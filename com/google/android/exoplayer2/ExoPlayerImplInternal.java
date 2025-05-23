package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.SimpleHandlerThread;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSource.Listener, DefaultMediaClock.PlaybackParameterListener, PlayerMessage.Sender {
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_DO_SOME_WORK = 2;
    public static final int MSG_ERROR = 2;
    private static final int MSG_PERIOD_PREPARED = 9;
    public static final int MSG_PLAYBACK_INFO_CHANGED = 0;
    public static final int MSG_PLAYBACK_PARAMETERS_CHANGED = 1;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_REFRESH_SOURCE_INFO = 8;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 12;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 13;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 10;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 11;
    private static final int PREPARING_SOURCE_INTERVAL_MS = 10;
    private static final int RENDERER_TIMESTAMP_OFFSET_US = 60000000;
    private static final int RENDERING_INTERVAL_MS = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final Clock clock;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private Renderer[] enabledRenderers;
    private final Handler eventHandler;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private MediaSource mediaSource;
    private int nextPendingMessageIndex;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private int pendingPrepareCount;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private final ExoPlayer player;
    private boolean rebuffering;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;
    private HashMap<Renderer, SimpleHandlerThread> mRenderHandlerThreadMap = null;
    private boolean parallelRender = true;
    private final MediaPeriodQueue queue = new MediaPeriodQueue();
    private SeekParameters seekParameters = SeekParameters.DEFAULT;
    private final PlaybackInfoUpdate playbackInfoUpdate = new PlaybackInfoUpdate();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class MediaSourceRefreshInfo {
        public final Object manifest;
        public final MediaSource source;
        public final Timeline timeline;

        public MediaSourceRefreshInfo(MediaSource mediaSource, Timeline timeline, Object obj) {
            this.source = mediaSource;
            this.timeline = timeline;
            this.manifest = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;

        @Nullable
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i3, long j3, Object obj) {
            this.resolvedPeriodIndex = i3;
            this.resolvedPeriodTimeUs = j3;
            this.resolvedPeriodUid = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i3 = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i3 != 0 ? i3 : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class PlaybackInfoUpdate {
        private int discontinuityReason;
        private PlaybackInfo lastPlaybackInfo;
        private int operationAcks;
        private boolean positionDiscontinuity;

        PlaybackInfoUpdate() {
        }

        public boolean hasPendingUpdate(PlaybackInfo playbackInfo) {
            if (playbackInfo == this.lastPlaybackInfo && this.operationAcks <= 0 && !this.positionDiscontinuity) {
                return false;
            }
            return true;
        }

        public void incrementPendingOperationAcks(int i3) {
            this.operationAcks += i3;
        }

        public void reset(PlaybackInfo playbackInfo) {
            this.lastPlaybackInfo = playbackInfo;
            this.operationAcks = 0;
            this.positionDiscontinuity = false;
        }

        public void setPositionDiscontinuity(int i3) {
            boolean z16 = true;
            if (this.positionDiscontinuity && this.discontinuityReason != 4) {
                if (i3 != 4) {
                    z16 = false;
                }
                Assertions.checkArgument(z16);
            } else {
                this.positionDiscontinuity = true;
                this.discontinuityReason = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class RendererRunnable implements Runnable {
        long elapsedTimeUs;
        ExoPlaybackException exceptionThrown;
        CountDownLatch latch;
        long positionUs;
        Renderer renderer;
        boolean rendererReadyOrEnded;
        boolean renderersEnded;

        public RendererRunnable(Renderer renderer, long j3, long j16, CountDownLatch countDownLatch) {
            this.renderer = renderer;
            this.latch = countDownLatch;
        }

        public ExoPlaybackException getExceptionThrown() {
            return this.exceptionThrown;
        }

        public Renderer getRenderer() {
            return this.renderer;
        }

        public boolean isEnded() {
            return this.renderersEnded;
        }

        public boolean rendererReadyOrEnded() {
            return this.rendererReadyOrEnded;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            try {
                try {
                    this.renderer.render(this.positionUs, this.elapsedTimeUs);
                    this.renderersEnded = this.renderer.isEnded();
                } catch (Exception e16) {
                    Renderer renderer = this.renderer;
                    if (renderer instanceof MediaCodecRenderer) {
                        this.exceptionThrown = ExoPlaybackException.createForRenderer(e16, ((MediaCodecRenderer) renderer).getRenderIndex());
                    } else {
                        this.exceptionThrown = ExoPlaybackException.createForUnexpected(e16);
                    }
                }
                if (!this.renderer.isReady() && !this.renderer.isEnded() && !ExoPlayerImplInternal.this.rendererWaitingForNextStream(this.renderer)) {
                    z16 = false;
                    this.rendererReadyOrEnded = z16;
                }
                z16 = true;
                this.rendererReadyOrEnded = z16;
            } finally {
                this.latch.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i3, long j3) {
            this.timeline = timeline;
            this.windowIndex = i3;
            this.windowPositionUs = j3;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, boolean z16, int i3, boolean z17, Handler handler, ExoPlayer exoPlayer, Clock clock) {
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.playWhenReady = z16;
        this.repeatMode = i3;
        this.shuffleModeEnabled = z17;
        this.eventHandler = handler;
        this.player = exoPlayer;
        this.clock = clock;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, -9223372036854775807L, trackSelectorResult);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i16 = 0; i16 < rendererArr.length; i16++) {
            rendererArr[i16].setIndex(i16);
            this.rendererCapabilities[i16] = rendererArr[i16].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.enabledRenderers = new Renderer[0];
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread = baseHandlerThread;
        baseHandlerThread.start();
        this.handler = clock.createHandler(baseHandlerThread.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void disableParallelRender() {
        if (this.parallelRender) {
            this.parallelRender = false;
            Iterator<SimpleHandlerThread> it = this.mRenderHandlerThreadMap.values().iterator();
            while (it.hasNext()) {
                it.next().quit();
            }
            this.mRenderHandlerThreadMap.clear();
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        this.mediaClock.onRendererDisabled(renderer);
        ensureStopped(renderer);
        renderer.disable();
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        long j3;
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        boolean z19;
        int i16;
        long uptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        if (!this.queue.hasPlayingPeriod()) {
            maybeThrowPeriodPrepareError();
            scheduleNextWork(uptimeMillis, 10L);
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
        if (this.parallelRender && this.playbackInfo.playbackState != 3) {
            CountDownLatch countDownLatch = new CountDownLatch(this.enabledRenderers.length);
            Renderer[] rendererArr = this.enabledRenderers;
            int length = rendererArr.length;
            RendererRunnable[] rendererRunnableArr = new RendererRunnable[length];
            int length2 = rendererArr.length;
            int i17 = 0;
            int i18 = 0;
            while (i17 < length2) {
                Renderer renderer = rendererArr[i17];
                CountDownLatch countDownLatch2 = countDownLatch;
                Renderer[] rendererArr2 = rendererArr;
                int i19 = length2;
                RendererRunnable[] rendererRunnableArr2 = rendererRunnableArr;
                long j16 = uptimeMillis;
                int i26 = length;
                long j17 = elapsedRealtime;
                RendererRunnable rendererRunnable = new RendererRunnable(renderer, this.rendererPositionUs, elapsedRealtime, countDownLatch2);
                int i27 = i18 + 1;
                rendererRunnableArr2[i18] = rendererRunnable;
                if (this.mRenderHandlerThreadMap == null) {
                    this.mRenderHandlerThreadMap = new HashMap<>();
                }
                SimpleHandlerThread simpleHandlerThread = this.mRenderHandlerThreadMap.get(renderer);
                if (simpleHandlerThread == null) {
                    simpleHandlerThread = new SimpleHandlerThread("TrackRender-" + renderer.getTrackType(), -16);
                    simpleHandlerThread.start();
                    this.mRenderHandlerThreadMap.put(renderer, simpleHandlerThread);
                }
                simpleHandlerThread.postJob(rendererRunnable);
                i17++;
                i18 = i27;
                length = i26;
                countDownLatch = countDownLatch2;
                rendererArr = rendererArr2;
                length2 = i19;
                rendererRunnableArr = rendererRunnableArr2;
                uptimeMillis = j16;
                elapsedRealtime = j17;
            }
            RendererRunnable[] rendererRunnableArr3 = rendererRunnableArr;
            j3 = uptimeMillis;
            int i28 = length;
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            z16 = true;
            z17 = true;
            for (int i29 = 0; i29 < i28; i29++) {
                RendererRunnable rendererRunnable2 = rendererRunnableArr3[i29];
                if (rendererRunnable2.getExceptionThrown() == null) {
                    if (z16 && rendererRunnable2.isEnded()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean rendererReadyOrEnded = rendererRunnable2.rendererReadyOrEnded();
                    if (!rendererReadyOrEnded) {
                        rendererRunnable2.getRenderer().maybeThrowStreamError();
                    }
                    if (z17 && rendererReadyOrEnded) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                } else {
                    throw rendererRunnable2.getExceptionThrown();
                }
            }
        } else {
            long j18 = elapsedRealtime;
            j3 = uptimeMillis;
            disableParallelRender();
            Renderer[] rendererArr3 = this.enabledRenderers;
            int length3 = rendererArr3.length;
            int i36 = 0;
            boolean z26 = true;
            boolean z27 = true;
            while (i36 < length3) {
                Renderer renderer2 = rendererArr3[i36];
                long j19 = j18;
                renderer2.render(this.rendererPositionUs, j19);
                if (z26 && renderer2.isEnded()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (!renderer2.isReady() && !renderer2.isEnded() && !rendererWaitingForNextStream(renderer2)) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    renderer2.maybeThrowStreamError();
                }
                if (z27 && z18) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                i36++;
                j18 = j19;
            }
            z16 = z26;
            z17 = z27;
        }
        if (!z17) {
            maybeThrowPeriodPrepareError();
        }
        long j26 = playingPeriod.info.durationUs;
        if (z16 && ((j26 == -9223372036854775807L || j26 <= this.playbackInfo.positionUs) && playingPeriod.info.isFinal)) {
            setState(4);
            stopRenderers();
            i3 = 3;
        } else {
            if (this.playbackInfo.playbackState == 2) {
                if (!this.parallelRender && !z17) {
                    z19 = false;
                } else {
                    z19 = true;
                }
                if (shouldTransitionToReadyState(z19)) {
                    i3 = 3;
                    setState(3);
                    if (this.playWhenReady) {
                        startRenderers();
                    }
                }
            }
            i3 = 3;
            if (this.playbackInfo.playbackState == 3 && (this.enabledRenderers.length != 0 ? !z17 : !isTimelineReady())) {
                this.rebuffering = this.playWhenReady;
                setState(2);
                stopRenderers();
            }
        }
        if (this.playbackInfo.playbackState == 2) {
            for (Renderer renderer3 : this.enabledRenderers) {
                renderer3.maybeThrowStreamError();
            }
        }
        if ((this.playWhenReady && this.playbackInfo.playbackState == i3) || (i16 = this.playbackInfo.playbackState) == 2) {
            scheduleNextWork(j3, 10L);
        } else {
            long j27 = j3;
            if (this.enabledRenderers.length != 0 && i16 != 4) {
                scheduleNextWork(j27, 1000L);
            } else {
                this.handler.removeMessages(2);
            }
        }
        TraceUtil.endSection();
    }

    private void enableRenderer(int i3, boolean z16, int i16) throws ExoPlaybackException {
        boolean z17;
        boolean z18;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        Renderer renderer = this.renderers[i3];
        this.enabledRenderers[i16] = renderer;
        if (renderer.getState() == 0) {
            TrackSelectorResult trackSelectorResult = playingPeriod.trackSelectorResult;
            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i3];
            Format[] formats = getFormats(trackSelectorResult.selections.get(i3));
            if (this.playWhenReady && this.playbackInfo.playbackState == 3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z16 && z17) {
                z18 = true;
            } else {
                z18 = false;
            }
            renderer.enable(rendererConfiguration, formats, playingPeriod.sampleStreams[i3], this.rendererPositionUs, z18, playingPeriod.getRendererOffset());
            this.mediaClock.onRendererEnabled(renderer);
            if (z17) {
                renderer.start();
            }
        }
    }

    private void enableRenderers(boolean[] zArr, int i3) throws ExoPlaybackException {
        this.enabledRenderers = new Renderer[i3];
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        int i16 = 0;
        for (int i17 = 0; i17 < this.renderers.length; i17++) {
            if (playingPeriod.trackSelectorResult.renderersEnabled[i17]) {
                enableRenderer(i17, zArr[i17], i16);
                i16++;
            }
        }
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private int getFirstPeriodIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return 0;
        }
        return timeline.getWindow(timeline.getFirstWindowIndex(this.shuffleModeEnabled), this.window).firstPeriodIndex;
    }

    @NonNull
    private static Format[] getFormats(TrackSelection trackSelection) {
        int i3;
        if (trackSelection != null) {
            i3 = trackSelection.length();
        } else {
            i3 = 0;
        }
        Format[] formatArr = new Format[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            formatArr[i16] = trackSelection.getFormat(i16);
        }
        return formatArr;
    }

    private Pair<Integer, Long> getPeriodPosition(Timeline timeline, int i3, long j3) {
        return timeline.getPeriodPosition(this.window, this.period, i3, j3);
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (!this.queue.isLoading(mediaPeriod)) {
            return;
        }
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        maybeContinueLoading();
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (!this.queue.isLoading(mediaPeriod)) {
            return;
        }
        updateLoadControlTrackSelection(this.queue.handleLoadingPeriodPrepared(this.mediaClock.getPlaybackParameters().speed));
        if (!this.queue.hasPlayingPeriod()) {
            resetRendererPosition(this.queue.advancePlayingPeriod().info.startPositionUs);
            updatePlayingPeriodRenderers(null);
        }
        maybeContinueLoading();
    }

    private void handleSourceInfoRefreshEndedPlayback() {
        setState(4);
        resetInternal(false, true, false);
    }

    private void handleSourceInfoRefreshed(MediaSourceRefreshInfo mediaSourceRefreshInfo) throws ExoPlaybackException {
        Object obj;
        long j3;
        long j16;
        if (mediaSourceRefreshInfo.source != this.mediaSource) {
            return;
        }
        Timeline timeline = this.playbackInfo.timeline;
        Timeline timeline2 = mediaSourceRefreshInfo.timeline;
        Object obj2 = mediaSourceRefreshInfo.manifest;
        this.queue.setTimeline(timeline2);
        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2, obj2);
        resolvePendingMessagePositions();
        int i3 = this.pendingPrepareCount;
        long j17 = 0;
        if (i3 > 0) {
            this.playbackInfoUpdate.incrementPendingOperationAcks(i3);
            this.pendingPrepareCount = 0;
            SeekPosition seekPosition = this.pendingInitialSeekPosition;
            if (seekPosition != null) {
                Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(seekPosition, true);
                this.pendingInitialSeekPosition = null;
                if (resolveSeekPosition == null) {
                    handleSourceInfoRefreshEndedPlayback();
                    return;
                }
                int intValue = ((Integer) resolveSeekPosition.first).intValue();
                long longValue = ((Long) resolveSeekPosition.second).longValue();
                MediaSource.MediaPeriodId resolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(intValue, longValue);
                PlaybackInfo playbackInfo = this.playbackInfo;
                if (resolveMediaPeriodIdForAds.isAd()) {
                    j16 = 0;
                } else {
                    j16 = longValue;
                }
                this.playbackInfo = playbackInfo.fromNewPosition(resolveMediaPeriodIdForAds, j16, longValue);
                return;
            }
            if (this.playbackInfo.startPositionUs == -9223372036854775807L) {
                if (timeline2.isEmpty()) {
                    handleSourceInfoRefreshEndedPlayback();
                    return;
                }
                Pair<Integer, Long> periodPosition = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
                int intValue2 = ((Integer) periodPosition.first).intValue();
                long longValue2 = ((Long) periodPosition.second).longValue();
                MediaSource.MediaPeriodId resolveMediaPeriodIdForAds2 = this.queue.resolveMediaPeriodIdForAds(intValue2, longValue2);
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                if (resolveMediaPeriodIdForAds2.isAd()) {
                    j3 = 0;
                } else {
                    j3 = longValue2;
                }
                this.playbackInfo = playbackInfo2.fromNewPosition(resolveMediaPeriodIdForAds2, j3, longValue2);
                return;
            }
            return;
        }
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        int i16 = playbackInfo3.periodId.periodIndex;
        long j18 = playbackInfo3.contentPositionUs;
        if (timeline.isEmpty()) {
            if (!timeline2.isEmpty()) {
                MediaSource.MediaPeriodId resolveMediaPeriodIdForAds3 = this.queue.resolveMediaPeriodIdForAds(i16, j18);
                PlaybackInfo playbackInfo4 = this.playbackInfo;
                if (!resolveMediaPeriodIdForAds3.isAd()) {
                    j17 = j18;
                }
                this.playbackInfo = playbackInfo4.fromNewPosition(resolveMediaPeriodIdForAds3, j17, j18);
                return;
            }
            return;
        }
        MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod();
        if (frontPeriod == null) {
            obj = timeline.getPeriod(i16, this.period, true).uid;
        } else {
            obj = frontPeriod.uid;
        }
        int indexOfPeriod = timeline2.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            int resolveSubsequentPeriod = resolveSubsequentPeriod(i16, timeline, timeline2);
            if (resolveSubsequentPeriod == -1) {
                handleSourceInfoRefreshEndedPlayback();
                return;
            }
            Pair<Integer, Long> periodPosition2 = getPeriodPosition(timeline2, timeline2.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, -9223372036854775807L);
            int intValue3 = ((Integer) periodPosition2.first).intValue();
            long longValue3 = ((Long) periodPosition2.second).longValue();
            MediaSource.MediaPeriodId resolveMediaPeriodIdForAds4 = this.queue.resolveMediaPeriodIdForAds(intValue3, longValue3);
            timeline2.getPeriod(intValue3, this.period, true);
            if (frontPeriod != null) {
                Object obj3 = this.period.uid;
                frontPeriod.info = frontPeriod.info.copyWithPeriodIndex(-1);
                while (true) {
                    frontPeriod = frontPeriod.next;
                    if (frontPeriod == null) {
                        break;
                    } else if (frontPeriod.uid.equals(obj3)) {
                        frontPeriod.info = this.queue.getUpdatedMediaPeriodInfo(frontPeriod.info, intValue3);
                    } else {
                        frontPeriod.info = frontPeriod.info.copyWithPeriodIndex(-1);
                    }
                }
            }
            if (!resolveMediaPeriodIdForAds4.isAd()) {
                j17 = longValue3;
            }
            this.playbackInfo = this.playbackInfo.fromNewPosition(resolveMediaPeriodIdForAds4, seekToPeriodPosition(resolveMediaPeriodIdForAds4, j17), longValue3);
            return;
        }
        if (indexOfPeriod != i16) {
            this.playbackInfo = this.playbackInfo.copyWithPeriodIndex(indexOfPeriod);
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        if (mediaPeriodId.isAd()) {
            MediaSource.MediaPeriodId resolveMediaPeriodIdForAds5 = this.queue.resolveMediaPeriodIdForAds(indexOfPeriod, j18);
            if (!resolveMediaPeriodIdForAds5.equals(mediaPeriodId)) {
                if (!resolveMediaPeriodIdForAds5.isAd()) {
                    j17 = j18;
                }
                this.playbackInfo = this.playbackInfo.fromNewPosition(resolveMediaPeriodIdForAds5, seekToPeriodPosition(resolveMediaPeriodIdForAds5, j17), j18);
                return;
            }
        }
        if (!this.queue.updateQueuedPeriods(mediaPeriodId, this.rendererPositionUs)) {
            seekToCurrentPosition(false);
        }
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j3 = playingPeriod.info.durationUs;
        if (j3 != -9223372036854775807L && this.playbackInfo.positionUs >= j3 && ((mediaPeriodHolder = playingPeriod.next) == null || (!mediaPeriodHolder.prepared && !mediaPeriodHolder.info.f32937id.isAd()))) {
            return false;
        }
        return true;
    }

    private void maybeContinueLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long nextLoadPositionUs = loadingPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            setIsLoading(false);
            return;
        }
        boolean shouldContinueLoading = this.loadControl.shouldContinueLoading(nextLoadPositionUs - loadingPeriod.toPeriodTime(this.rendererPositionUs), this.mediaClock.getPlaybackParameters().speed);
        setIsLoading(shouldContinueLoading);
        if (shouldContinueLoading) {
            loadingPeriod.continueLoading(this.rendererPositionUs);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        int i3;
        if (this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo)) {
            Handler handler = this.eventHandler;
            int i16 = this.playbackInfoUpdate.operationAcks;
            if (this.playbackInfoUpdate.positionDiscontinuity) {
                i3 = this.playbackInfoUpdate.discontinuityReason;
            } else {
                i3 = -1;
            }
            handler.obtainMessage(0, i16, i3, this.playbackInfo).sendToTarget();
            this.playbackInfoUpdate.reset(this.playbackInfo);
        }
    }

    private void maybeThrowPeriodPrepareError() throws IOException {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (loadingPeriod != null && !loadingPeriod.prepared) {
            if (readingPeriod == null || readingPeriod.next == loadingPeriod) {
                for (Renderer renderer : this.enabledRenderers) {
                    if (!renderer.hasReadStreamToEnd()) {
                        return;
                    }
                }
                loadingPeriod.mediaPeriod.maybeThrowPrepareError();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x006b, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0034, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void maybeTriggerPendingMessages(long j3, long j16) throws ExoPlaybackException {
        PendingMessageInfo pendingMessageInfo;
        PendingMessageInfo pendingMessageInfo2;
        if (!this.pendingMessages.isEmpty() && !this.playbackInfo.periodId.isAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            if (playbackInfo.startPositionUs == j3) {
                j3--;
            }
            int i3 = playbackInfo.periodId.periodIndex;
            int i16 = this.nextPendingMessageIndex;
            if (i16 > 0) {
                pendingMessageInfo = this.pendingMessages.get(i16 - 1);
                while (pendingMessageInfo != null) {
                    int i17 = pendingMessageInfo.resolvedPeriodIndex;
                    if (i17 <= i3 && (i17 != i3 || pendingMessageInfo.resolvedPeriodTimeUs <= j3)) {
                        break;
                    }
                    int i18 = this.nextPendingMessageIndex - 1;
                    this.nextPendingMessageIndex = i18;
                    if (i18 > 0) {
                        pendingMessageInfo = this.pendingMessages.get(i18 - 1);
                    }
                }
                if (this.nextPendingMessageIndex < this.pendingMessages.size()) {
                    pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
                    while (pendingMessageInfo2 != null && pendingMessageInfo2.resolvedPeriodUid != null) {
                        int i19 = pendingMessageInfo2.resolvedPeriodIndex;
                        if (i19 >= i3 && (i19 != i3 || pendingMessageInfo2.resolvedPeriodTimeUs > j3)) {
                            break;
                        }
                        int i26 = this.nextPendingMessageIndex + 1;
                        this.nextPendingMessageIndex = i26;
                        if (i26 < this.pendingMessages.size()) {
                            pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
                        }
                    }
                    while (pendingMessageInfo2 != null && pendingMessageInfo2.resolvedPeriodUid != null && pendingMessageInfo2.resolvedPeriodIndex == i3) {
                        long j17 = pendingMessageInfo2.resolvedPeriodTimeUs;
                        if (j17 > j3 && j17 <= j16) {
                            sendMessageToTarget(pendingMessageInfo2.message);
                            if (pendingMessageInfo2.message.getDeleteAfterDelivery()) {
                                this.pendingMessages.remove(this.nextPendingMessageIndex);
                            } else {
                                this.nextPendingMessageIndex++;
                            }
                            if (this.nextPendingMessageIndex < this.pendingMessages.size()) {
                                pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
                            } else {
                                pendingMessageInfo2 = null;
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                }
                pendingMessageInfo2 = null;
            }
            pendingMessageInfo = null;
        }
    }

    private void maybeUpdateLoadingPeriod() throws IOException {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod()) {
            MediaPeriodInfo nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if (nextMediaPeriodInfo == null) {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
                return;
            }
            this.queue.enqueueNextMediaPeriod(this.rendererCapabilities, AEEditorConstants.MAX_CLIP_TIME_US, this.trackSelector, this.loadControl.getAllocator(), this.mediaSource, this.playbackInfo.timeline.getPeriod(nextMediaPeriodInfo.f32937id.periodIndex, this.period, true).uid, nextMediaPeriodInfo).prepare(this, nextMediaPeriodInfo.startPositionUs);
            setIsLoading(true);
        }
    }

    private void prepareInternal(MediaSource mediaSource, boolean z16, boolean z17) {
        this.pendingPrepareCount++;
        resetInternal(true, z16, z17);
        this.loadControl.onPrepared();
        this.mediaSource = mediaSource;
        setState(2);
        mediaSource.prepareSource(this.player, true, this);
        this.handler.sendEmptyMessage(2);
    }

    private void releaseInternal() {
        resetInternal(true, true, true);
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rendererWaitingForNextStream(Renderer renderer) {
        MediaPeriodHolder mediaPeriodHolder = this.queue.getReadingPeriod().next;
        if (mediaPeriodHolder != null && mediaPeriodHolder.prepared && renderer.hasReadStreamToEnd()) {
            return true;
        }
        return false;
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        boolean z16;
        if (!this.queue.hasPlayingPeriod()) {
            return;
        }
        float f16 = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z17 = true;
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.next) {
            if (playingPeriod.selectTracks(f16)) {
                if (z17) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean removeAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long applyTrackSelection = playingPeriod2.applyTrackSelection(this.playbackInfo.positionUs, removeAfter, zArr);
                    updateLoadControlTrackSelection(playingPeriod2.trackSelectorResult);
                    PlaybackInfo playbackInfo = this.playbackInfo;
                    if (playbackInfo.playbackState != 4 && applyTrackSelection != playbackInfo.positionUs) {
                        PlaybackInfo playbackInfo2 = this.playbackInfo;
                        this.playbackInfo = playbackInfo2.fromNewPosition(playbackInfo2.periodId, applyTrackSelection, playbackInfo2.contentPositionUs);
                        this.playbackInfoUpdate.setPositionDiscontinuity(4);
                        resetRendererPosition(applyTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i3 = 0;
                    int i16 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i3 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i3];
                        if (renderer.getState() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        zArr2[i3] = z16;
                        SampleStream sampleStream = playingPeriod2.sampleStreams[i3];
                        if (sampleStream != null) {
                            i16++;
                        }
                        if (z16) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i3]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i3++;
                    }
                    this.playbackInfo = this.playbackInfo.copyWithTrackSelectorResult(playingPeriod2.trackSelectorResult);
                    enableRenderers(zArr2, i16);
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                        updateLoadControlTrackSelection(playingPeriod.trackSelectorResult);
                    }
                }
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (playingPeriod == readingPeriod) {
                z17 = false;
            }
        }
    }

    private void resetInternal(boolean z16, boolean z17, boolean z18) {
        Timeline timeline;
        Object obj;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j3;
        TrackSelectorResult trackSelectorResult;
        MediaSource mediaSource;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = AEEditorConstants.MAX_CLIP_TIME_US;
        for (Renderer renderer : this.enabledRenderers) {
            try {
                disableRenderer(renderer);
            } catch (ExoPlaybackException | RuntimeException e16) {
                Log.e(TAG, "Stop failed.", e16);
            }
        }
        this.enabledRenderers = new Renderer[0];
        this.queue.clear();
        setIsLoading(false);
        if (z17) {
            this.pendingInitialSeekPosition = null;
        }
        if (z18) {
            this.queue.setTimeline(Timeline.EMPTY);
            Iterator<PendingMessageInfo> it = this.pendingMessages.iterator();
            while (it.hasNext()) {
                it.next().message.markAsProcessed(false);
            }
            this.pendingMessages.clear();
            this.nextPendingMessageIndex = 0;
        }
        if (z18) {
            timeline = Timeline.EMPTY;
        } else {
            timeline = this.playbackInfo.timeline;
        }
        Timeline timeline2 = timeline;
        if (z18) {
            obj = null;
        } else {
            obj = this.playbackInfo.manifest;
        }
        if (z17) {
            mediaPeriodId = new MediaSource.MediaPeriodId(getFirstPeriodIndex());
        } else {
            mediaPeriodId = this.playbackInfo.periodId;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j16 = -9223372036854775807L;
        if (z17) {
            j3 = -9223372036854775807L;
        } else {
            j3 = this.playbackInfo.positionUs;
        }
        if (!z17) {
            j16 = this.playbackInfo.contentPositionUs;
        }
        long j17 = j16;
        PlaybackInfo playbackInfo = this.playbackInfo;
        int i3 = playbackInfo.playbackState;
        if (z18) {
            trackSelectorResult = this.emptyTrackSelectorResult;
        } else {
            trackSelectorResult = playbackInfo.trackSelectorResult;
        }
        this.playbackInfo = new PlaybackInfo(timeline2, obj, mediaPeriodId2, j3, j17, i3, false, trackSelectorResult);
        if (z16 && (mediaSource = this.mediaSource) != null) {
            mediaSource.releaseSource();
            this.mediaSource = null;
        }
    }

    private void resetRendererPosition(long j3) throws ExoPlaybackException {
        long rendererTime;
        if (!this.queue.hasPlayingPeriod()) {
            rendererTime = j3 + AEEditorConstants.MAX_CLIP_TIME_US;
        } else {
            rendererTime = this.queue.getPlayingPeriod().toRendererTime(j3);
        }
        this.rendererPositionUs = rendererTime;
        this.mediaClock.resetPosition(rendererTime);
        for (Renderer renderer : this.enabledRenderers) {
            renderer.resetPosition(this.rendererPositionUs);
        }
    }

    private boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo) {
        Object obj = pendingMessageInfo.resolvedPeriodUid;
        if (obj == null) {
            Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getWindowIndex(), C.msToUs(pendingMessageInfo.message.getPositionMs())), false);
            if (resolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(((Integer) resolveSeekPosition.first).intValue(), ((Long) resolveSeekPosition.second).longValue(), this.playbackInfo.timeline.getPeriod(((Integer) resolveSeekPosition.first).intValue(), this.period, true).uid);
        } else {
            int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(obj);
            if (indexOfPeriod == -1) {
                return false;
            }
            pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        }
        return true;
    }

    private void resolvePendingMessagePositions() {
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size))) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    private Pair<Integer, Long> resolveSeekPosition(SeekPosition seekPosition, boolean z16) {
        int resolveSubsequentPeriod;
        Timeline timeline = this.playbackInfo.timeline;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        if (timeline2.isEmpty()) {
            timeline2 = timeline;
        }
        try {
            Pair<Integer, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline == timeline2) {
                return periodPosition;
            }
            int indexOfPeriod = timeline.getIndexOfPeriod(timeline2.getPeriod(((Integer) periodPosition.first).intValue(), this.period, true).uid);
            if (indexOfPeriod != -1) {
                return Pair.create(Integer.valueOf(indexOfPeriod), periodPosition.second);
            }
            if (!z16 || (resolveSubsequentPeriod = resolveSubsequentPeriod(((Integer) periodPosition.first).intValue(), timeline2, timeline)) == -1) {
                return null;
            }
            return getPeriodPosition(timeline, timeline.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalSeekPositionException(timeline, seekPosition.windowIndex, seekPosition.windowPositionUs);
        }
    }

    private int resolveSubsequentPeriod(int i3, Timeline timeline, Timeline timeline2) {
        int periodCount = timeline.getPeriodCount();
        int i16 = i3;
        int i17 = -1;
        for (int i18 = 0; i18 < periodCount && i17 == -1; i18++) {
            i16 = timeline.getNextPeriodIndex(i16, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (i16 == -1) {
                break;
            }
            i17 = timeline2.getIndexOfPeriod(timeline.getPeriod(i16, this.period, true).uid);
        }
        return i17;
    }

    private void scheduleNextWork(long j3, long j16) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, j3 + j16);
    }

    private void seekToCurrentPosition(boolean z16) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.f32937id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = playbackInfo.fromNewPosition(mediaPeriodId, seekToPeriodPosition, playbackInfo.contentPositionUs);
            if (z16) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void seekToInternal(SeekPosition seekPosition) throws ExoPlaybackException {
        long longValue;
        boolean z16;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j3;
        long j16;
        long j17;
        boolean z17 = true;
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(seekPosition, true);
        if (resolveSeekPosition == null) {
            mediaPeriodId = new MediaSource.MediaPeriodId(getFirstPeriodIndex());
            z16 = true;
            longValue = -9223372036854775807L;
            j3 = -9223372036854775807L;
        } else {
            int intValue = ((Integer) resolveSeekPosition.first).intValue();
            long longValue2 = ((Long) resolveSeekPosition.second).longValue();
            MediaSource.MediaPeriodId resolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(intValue, longValue2);
            if (resolveMediaPeriodIdForAds.isAd()) {
                z16 = true;
                longValue = 0;
            } else {
                longValue = ((Long) resolveSeekPosition.second).longValue();
                if (seekPosition.windowPositionUs == -9223372036854775807L) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            mediaPeriodId = resolveMediaPeriodIdForAds;
            j3 = longValue2;
        }
        try {
            if (this.mediaSource != null && this.pendingPrepareCount <= 0) {
                if (longValue == -9223372036854775807L) {
                    setState(4);
                    resetInternal(false, true, false);
                    j16 = longValue;
                    this.playbackInfo = this.playbackInfo.fromNewPosition(mediaPeriodId, j16, j3);
                    if (z16) {
                        this.playbackInfoUpdate.setPositionDiscontinuity(2);
                        return;
                    }
                    return;
                }
                if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
                    MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                    if (playingPeriod != null && longValue != 0) {
                        j17 = playingPeriod.mediaPeriod.getAdjustedSeekPositionUs(longValue, this.seekParameters);
                    } else {
                        j17 = longValue;
                    }
                    if (C.usToMs(j17) == C.usToMs(this.playbackInfo.positionUs)) {
                        this.playbackInfo = this.playbackInfo.fromNewPosition(mediaPeriodId, this.playbackInfo.positionUs, j3);
                        if (z16) {
                            this.playbackInfoUpdate.setPositionDiscontinuity(2);
                            return;
                        }
                        return;
                    }
                } else {
                    j17 = longValue;
                }
                long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, j17);
                if (longValue == seekToPeriodPosition) {
                    z17 = false;
                }
                z16 |= z17;
                j16 = seekToPeriodPosition;
                this.playbackInfo = this.playbackInfo.fromNewPosition(mediaPeriodId, j16, j3);
                if (z16) {
                }
            }
            this.pendingInitialSeekPosition = seekPosition;
            j16 = longValue;
            this.playbackInfo = this.playbackInfo.fromNewPosition(mediaPeriodId, j16, j3);
            if (z16) {
            }
        } catch (Throwable th5) {
            this.playbackInfo = this.playbackInfo.fromNewPosition(mediaPeriodId, longValue, j3);
            if (z16) {
                this.playbackInfoUpdate.setPositionDiscontinuity(2);
            }
            throw th5;
        }
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j3) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j3, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod());
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.mediaSource != null && this.pendingPrepareCount <= 0) {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            if (resolvePendingMessagePosition(pendingMessageInfo)) {
                this.pendingMessages.add(pendingMessageInfo);
                Collections.sort(this.pendingMessages);
                return;
            } else {
                playerMessage.markAsProcessed(false);
                return;
            }
        }
        this.pendingMessages.add(new PendingMessageInfo(playerMessage));
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getHandler().getLooper() == this.handler.getLooper()) {
            deliverMessage(playerMessage);
            int i3 = this.playbackInfo.playbackState;
            if (i3 == 3 || i3 == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        playerMessage.getHandler().post(new Runnable() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ExoPlayerImplInternal.this.deliverMessage(playerMessage);
                } catch (ExoPlaybackException e16) {
                    Log.e(ExoPlayerImplInternal.TAG, "Unexpected error delivering message on external thread.", e16);
                    throw new RuntimeException(e16);
                }
            }
        });
    }

    private void setIsLoading(boolean z16) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.isLoading != z16) {
            this.playbackInfo = playbackInfo.copyWithIsLoading(z16);
        }
    }

    private void setPlayWhenReadyInternal(boolean z16) throws ExoPlaybackException {
        this.rebuffering = false;
        this.playWhenReady = z16;
        if (!z16) {
            stopRenderers();
            updatePlaybackPositions();
            return;
        }
        int i3 = this.playbackInfo.playbackState;
        if (i3 == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (i3 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setRepeatModeInternal(int i3) throws ExoPlaybackException {
        this.repeatMode = i3;
        if (!this.queue.updateRepeatMode(i3)) {
            seekToCurrentPosition(true);
        }
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setShuffleModeEnabledInternal(boolean z16) throws ExoPlaybackException {
        this.shuffleModeEnabled = z16;
        if (!this.queue.updateShuffleModeEnabled(z16)) {
            seekToCurrentPosition(true);
        }
    }

    private void setState(int i3) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != i3) {
            this.playbackInfo = playbackInfo.copyWithPlaybackState(i3);
        }
    }

    private boolean shouldKeepPeriodHolder(MediaSource.MediaPeriodId mediaPeriodId, long j3, MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodId.equals(mediaPeriodHolder.info.f32937id) && mediaPeriodHolder.prepared) {
            this.playbackInfo.timeline.getPeriod(mediaPeriodHolder.info.f32937id.periodIndex, this.period);
            int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j3);
            if (adGroupIndexAfterPositionUs == -1 || this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) == mediaPeriodHolder.info.endPositionUs) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean shouldTransitionToReadyState(boolean z16) {
        if (this.enabledRenderers.length == 0) {
            return isTimelineReady();
        }
        if (!z16) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long bufferedPositionUs = loadingPeriod.getBufferedPositionUs(!loadingPeriod.info.isFinal);
        if (bufferedPositionUs != Long.MIN_VALUE && !this.loadControl.shouldStartPlayback(bufferedPositionUs - loadingPeriod.toPeriodTime(this.rendererPositionUs), this.mediaClock.getPlaybackParameters().speed, this.rebuffering)) {
            return false;
        }
        return true;
    }

    private void startRenderers() throws ExoPlaybackException {
        this.rebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.enabledRenderers) {
            renderer.start();
        }
    }

    private void stopInternal(boolean z16, boolean z17) {
        resetInternal(true, z16, z16);
        this.playbackInfoUpdate.incrementPendingOperationAcks(this.pendingPrepareCount + (z17 ? 1 : 0));
        this.pendingPrepareCount = 0;
        this.loadControl.onStopped();
        setState(1);
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.enabledRenderers) {
            ensureStopped(renderer);
        }
    }

    private void updateLoadControlTrackSelection(TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackSelectorResult.groups, trackSelectorResult.selections);
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        boolean z16;
        boolean z17;
        int i3;
        MediaSource mediaSource = this.mediaSource;
        if (mediaSource == null) {
            return;
        }
        if (this.pendingPrepareCount > 0) {
            mediaSource.maybeThrowSourceInfoRefreshError();
            return;
        }
        maybeUpdateLoadingPeriod();
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        int i16 = 0;
        if (loadingPeriod != null && !loadingPeriod.isFullyBuffered()) {
            if (!this.playbackInfo.isLoading) {
                maybeContinueLoading();
            }
        } else {
            setIsLoading(false);
        }
        if (!this.queue.hasPlayingPeriod()) {
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z18 = false;
        while (this.playWhenReady && playingPeriod != readingPeriod && this.rendererPositionUs >= playingPeriod.next.rendererPositionOffsetUs) {
            if (z18) {
                maybeNotifyPlaybackInfoChanged();
            }
            if (playingPeriod.info.isLastInTimelinePeriod) {
                i3 = 0;
            } else {
                i3 = 3;
            }
            MediaPeriodHolder advancePlayingPeriod = this.queue.advancePlayingPeriod();
            updatePlayingPeriodRenderers(playingPeriod);
            PlaybackInfo playbackInfo = this.playbackInfo;
            MediaPeriodInfo mediaPeriodInfo = advancePlayingPeriod.info;
            this.playbackInfo = playbackInfo.fromNewPosition(mediaPeriodInfo.f32937id, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.contentPositionUs);
            this.playbackInfoUpdate.setPositionDiscontinuity(i3);
            updatePlaybackPositions();
            playingPeriod = advancePlayingPeriod;
            z18 = true;
        }
        if (readingPeriod.info.isFinal) {
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i16 < rendererArr.length) {
                    Renderer renderer = rendererArr[i16];
                    SampleStream sampleStream = readingPeriod.sampleStreams[i16];
                    if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                        renderer.setCurrentStreamFinal();
                    }
                    i16++;
                } else {
                    return;
                }
            }
        } else {
            MediaPeriodHolder mediaPeriodHolder = readingPeriod.next;
            if (mediaPeriodHolder != null && mediaPeriodHolder.prepared) {
                int i17 = 0;
                while (true) {
                    Renderer[] rendererArr2 = this.renderers;
                    if (i17 < rendererArr2.length) {
                        Renderer renderer2 = rendererArr2[i17];
                        SampleStream sampleStream2 = readingPeriod.sampleStreams[i17];
                        if (renderer2.getStream() == sampleStream2) {
                            if (sampleStream2 == null || renderer2.hasReadStreamToEnd()) {
                                i17++;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        TrackSelectorResult trackSelectorResult = readingPeriod.trackSelectorResult;
                        MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                        TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.trackSelectorResult;
                        if (advanceReadingPeriod.mediaPeriod.readDiscontinuity() != -9223372036854775807L) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        int i18 = 0;
                        while (true) {
                            Renderer[] rendererArr3 = this.renderers;
                            if (i18 < rendererArr3.length) {
                                Renderer renderer3 = rendererArr3[i18];
                                if (trackSelectorResult.renderersEnabled[i18]) {
                                    if (z16) {
                                        renderer3.setCurrentStreamFinal();
                                    } else if (!renderer3.isCurrentStreamFinal()) {
                                        TrackSelection trackSelection = trackSelectorResult2.selections.get(i18);
                                        boolean z19 = trackSelectorResult2.renderersEnabled[i18];
                                        if (this.rendererCapabilities[i18].getTrackType() == 5) {
                                            z17 = true;
                                        } else {
                                            z17 = false;
                                        }
                                        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i18];
                                        RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i18];
                                        if (z19 && rendererConfiguration2.equals(rendererConfiguration) && !z17) {
                                            renderer3.replaceStream(getFormats(trackSelection), advanceReadingPeriod.sampleStreams[i18], advanceReadingPeriod.getRendererOffset());
                                        } else {
                                            renderer3.setCurrentStreamFinal();
                                        }
                                    }
                                }
                                i18++;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        long bufferedPositionUs;
        if (!this.queue.hasPlayingPeriod()) {
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long readDiscontinuity = playingPeriod.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity != -9223372036854775807L) {
            resetRendererPosition(readDiscontinuity);
            if (readDiscontinuity != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = playbackInfo.fromNewPosition(playbackInfo.periodId, readDiscontinuity, playbackInfo.contentPositionUs);
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        } else {
            long syncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs();
            this.rendererPositionUs = syncAndGetPositionUs;
            long periodTime = playingPeriod.toPeriodTime(syncAndGetPositionUs);
            maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
            this.playbackInfo.positionUs = periodTime;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (this.enabledRenderers.length == 0) {
            bufferedPositionUs = playingPeriod.info.durationUs;
        } else {
            bufferedPositionUs = playingPeriod.getBufferedPositionUs(true);
        }
        playbackInfo2.bufferedPositionUs = bufferedPositionUs;
    }

    private void updatePlayingPeriodRenderers(@Nullable MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        boolean z16;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null && mediaPeriodHolder != playingPeriod) {
            boolean[] zArr = new boolean[this.renderers.length];
            int i3 = 0;
            int i16 = 0;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i3 < rendererArr.length) {
                    Renderer renderer = rendererArr[i3];
                    if (renderer.getState() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zArr[i3] = z16;
                    boolean z17 = playingPeriod.trackSelectorResult.renderersEnabled[i3];
                    if (z17) {
                        i16++;
                    }
                    if (z16 && (!z17 || (renderer.isCurrentStreamFinal() && renderer.getStream() == mediaPeriodHolder.sampleStreams[i3]))) {
                        disableRenderer(renderer);
                    }
                    i3++;
                } else {
                    this.playbackInfo = this.playbackInfo.copyWithTrackSelectorResult(playingPeriod.trackSelectorResult);
                    enableRenderers(zArr, i16);
                    return;
                }
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f16) {
        for (MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            TrackSelectorResult trackSelectorResult = frontPeriod.trackSelectorResult;
            if (trackSelectorResult != null) {
                for (TrackSelection trackSelection : trackSelectorResult.selections.getAll()) {
                    if (trackSelection != null) {
                        trackSelection.onPlaybackSpeed(f16);
                    }
                }
            }
        }
    }

    public Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        try {
            switch (message.what) {
                case 0:
                    MediaSource mediaSource = (MediaSource) message.obj;
                    if (message.arg1 != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (message.arg2 != 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    prepareInternal(mediaSource, z16, z17);
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    setPlayWhenReadyInternal(z18);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    if (message.arg1 != 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    stopInternal(z19, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handleSourceInfoRefreshed((MediaSourceRefreshInfo) message.obj);
                    break;
                case 9:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 10:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 11:
                    reselectTracksInternal();
                    break;
                case 12:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 13:
                    if (message.arg1 != 0) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    setShuffleModeEnabledInternal(z26);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (ExoPlaybackException e16) {
            Log.e(TAG, "Playback error.", e16);
            stopInternal(false, false);
            this.eventHandler.obtainMessage(2, e16).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (IOException e17) {
            Log.e(TAG, "Source error.", e17);
            stopInternal(false, false);
            this.eventHandler.obtainMessage(2, ExoPlaybackException.createForSource(e17)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (RuntimeException e18) {
            Log.e(TAG, "Internal runtime error.", e18);
            stopInternal(false, false);
            this.eventHandler.obtainMessage(2, ExoPlaybackException.createForUnexpected(e18)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackParameterListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.eventHandler.obtainMessage(1, playbackParameters).sendToTarget();
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
        this.handler.obtainMessage(8, new MediaSourceRefreshInfo(mediaSource, timeline, obj)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(11);
    }

    public void prepare(MediaSource mediaSource, boolean z16, boolean z17) {
        this.handler.obtainMessage(0, z16 ? 1 : 0, z17 ? 1 : 0, mediaSource).sendToTarget();
    }

    public synchronized void release() {
        if (this.released) {
            return;
        }
        this.handler.sendEmptyMessage(7);
        boolean z16 = false;
        while (!this.released) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    public void seekTo(Timeline timeline, int i3, long j3) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i3, j3)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (this.released) {
            Log.w(TAG, "Ignoring messages sent after release.");
            playerMessage.markAsProcessed(false);
        } else {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
        }
    }

    public void setPlayWhenReady(boolean z16) {
        this.handler.obtainMessage(1, z16 ? 1 : 0, 0).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setRepeatMode(int i3) {
        this.handler.obtainMessage(12, i3, 0).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z16) {
        this.handler.obtainMessage(13, z16 ? 1 : 0, 0).sendToTarget();
    }

    public void stop(boolean z16) {
        this.handler.obtainMessage(6, z16 ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(10, mediaPeriod).sendToTarget();
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j3, boolean z16) throws ExoPlaybackException {
        stopRenderers();
        this.rebuffering = false;
        setState(2);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (true) {
            if (mediaPeriodHolder == null) {
                break;
            }
            if (shouldKeepPeriodHolder(mediaPeriodId, j3, mediaPeriodHolder)) {
                this.queue.removeAfter(mediaPeriodHolder);
                break;
            }
            mediaPeriodHolder = this.queue.advancePlayingPeriod();
        }
        if (playingPeriod != mediaPeriodHolder || z16) {
            for (Renderer renderer : this.enabledRenderers) {
                disableRenderer(renderer);
            }
            this.enabledRenderers = new Renderer[0];
            playingPeriod = null;
        }
        if (mediaPeriodHolder != null) {
            updatePlayingPeriodRenderers(playingPeriod);
            if (mediaPeriodHolder.hasEnabledTracks) {
                long seekToUs = mediaPeriodHolder.mediaPeriod.seekToUs(j3);
                mediaPeriodHolder.mediaPeriod.discardBuffer(seekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                j3 = seekToUs;
            }
            resetRendererPosition(j3);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j3);
        }
        this.handler.sendEmptyMessage(2);
        return j3;
    }
}
