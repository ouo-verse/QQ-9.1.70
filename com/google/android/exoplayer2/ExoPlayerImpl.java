package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ExoPlayerImpl implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean hasPendingPrepare;
    private boolean hasPendingSeek;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArraySet<Player.EventListener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private int pendingOperationAcks;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private PlaybackParameters playbackParameters;
    private final Renderer[] renderers;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl, Clock clock) {
        boolean z16;
        Looper mainLooper;
        Log.i(TAG, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "]");
        if (rendererArr.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.renderers = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.listeners = new CopyOnWriteArraySet<>();
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(TrackGroupArray.EMPTY, new boolean[rendererArr.length], new TrackSelectionArray(new TrackSelection[rendererArr.length]), null, new RendererConfiguration[rendererArr.length]);
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.playbackParameters = PlaybackParameters.DEFAULT;
        if (Looper.myLooper() != null) {
            mainLooper = Looper.myLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(mainLooper) { // from class: com.google.android.exoplayer2.ExoPlayerImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ExoPlayerImpl.this.handleEvent(message);
            }
        };
        this.eventHandler = handler;
        this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, 0L, trackSelectorResult);
        ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(rendererArr, trackSelector, trackSelectorResult, loadControl, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, handler, this, clock);
        this.internalPlayer = exoPlayerImplInternal;
        this.internalPlayerHandler = new Handler(exoPlayerImplInternal.getPlaybackLooper());
    }

    private PlaybackInfo getResetPlaybackInfo(boolean z16, boolean z17, int i3) {
        Timeline timeline;
        Object obj;
        TrackSelectorResult trackSelectorResult;
        if (z16) {
            this.maskingWindowIndex = 0;
            this.maskingPeriodIndex = 0;
            this.maskingWindowPositionMs = 0L;
        } else {
            this.maskingWindowIndex = getCurrentWindowIndex();
            this.maskingPeriodIndex = getCurrentPeriodIndex();
            this.maskingWindowPositionMs = getCurrentPosition();
        }
        if (z17) {
            timeline = Timeline.EMPTY;
        } else {
            timeline = this.playbackInfo.timeline;
        }
        Timeline timeline2 = timeline;
        if (z17) {
            obj = null;
        } else {
            obj = this.playbackInfo.manifest;
        }
        Object obj2 = obj;
        PlaybackInfo playbackInfo = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
        long j3 = playbackInfo.startPositionUs;
        long j16 = playbackInfo.contentPositionUs;
        if (z17) {
            trackSelectorResult = this.emptyTrackSelectorResult;
        } else {
            trackSelectorResult = playbackInfo.trackSelectorResult;
        }
        return new PlaybackInfo(timeline2, obj2, mediaPeriodId, j3, j16, i3, false, trackSelectorResult);
    }

    private void handlePlaybackInfo(PlaybackInfo playbackInfo, int i3, boolean z16, int i16) {
        int i17;
        int i18 = this.pendingOperationAcks - i3;
        this.pendingOperationAcks = i18;
        if (i18 == 0) {
            if (playbackInfo.startPositionUs == -9223372036854775807L) {
                playbackInfo = playbackInfo.fromNewPosition(playbackInfo.periodId, 0L, playbackInfo.contentPositionUs);
            }
            PlaybackInfo playbackInfo2 = playbackInfo;
            if ((!this.playbackInfo.timeline.isEmpty() || this.hasPendingPrepare) && playbackInfo2.timeline.isEmpty()) {
                this.maskingPeriodIndex = 0;
                this.maskingWindowIndex = 0;
                this.maskingWindowPositionMs = 0L;
            }
            if (this.hasPendingPrepare) {
                i17 = 0;
            } else {
                i17 = 2;
            }
            boolean z17 = this.hasPendingSeek;
            this.hasPendingPrepare = false;
            this.hasPendingSeek = false;
            updatePlaybackInfo(playbackInfo2, z16, i16, i17, z17);
        }
    }

    private long playbackInfoPositionUsToWindowPositionMs(long j3) {
        long usToMs = C.usToMs(j3);
        if (!this.playbackInfo.periodId.isAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period);
            return usToMs + this.period.getPositionInWindowMs();
        }
        return usToMs;
    }

    private boolean shouldMaskPosition() {
        if (!this.playbackInfo.timeline.isEmpty() && this.pendingOperationAcks <= 0) {
            return false;
        }
        return true;
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo, boolean z16, int i3, int i16, boolean z17) {
        boolean z18;
        boolean z19;
        boolean z26;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        boolean z27 = false;
        if (playbackInfo2.timeline == playbackInfo.timeline && playbackInfo2.manifest == playbackInfo.manifest) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (playbackInfo2.playbackState != playbackInfo.playbackState) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (playbackInfo2.isLoading != playbackInfo.isLoading) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (playbackInfo2.trackSelectorResult != playbackInfo.trackSelectorResult) {
            z27 = true;
        }
        this.playbackInfo = playbackInfo;
        if (z18 || i16 == 0) {
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                Player.EventListener next = it.next();
                PlaybackInfo playbackInfo3 = this.playbackInfo;
                next.onTimelineChanged(playbackInfo3.timeline, playbackInfo3.manifest, i16);
            }
        }
        if (z16) {
            Iterator<Player.EventListener> it5 = this.listeners.iterator();
            while (it5.hasNext()) {
                it5.next().onPositionDiscontinuity(i3);
            }
        }
        if (z27) {
            this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
            Iterator<Player.EventListener> it6 = this.listeners.iterator();
            while (it6.hasNext()) {
                Player.EventListener next2 = it6.next();
                TrackSelectorResult trackSelectorResult = this.playbackInfo.trackSelectorResult;
                next2.onTracksChanged(trackSelectorResult.groups, trackSelectorResult.selections);
            }
        }
        if (z26) {
            Iterator<Player.EventListener> it7 = this.listeners.iterator();
            while (it7.hasNext()) {
                it7.next().onLoadingChanged(this.playbackInfo.isLoading);
            }
        }
        if (z19) {
            Iterator<Player.EventListener> it8 = this.listeners.iterator();
            while (it8.hasNext()) {
                it8.next().onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
            }
        }
        if (z17) {
            Iterator<Player.EventListener> it9 = this.listeners.iterator();
            while (it9.hasNext()) {
                it9.next().onSeekProcessed();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        ArrayList<PlayerMessage> arrayList = new ArrayList();
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            arrayList.add(createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send());
        }
        boolean z16 = false;
        for (PlayerMessage playerMessage : arrayList) {
            boolean z17 = true;
            while (z17) {
                try {
                    playerMessage.blockUntilDelivered();
                    z17 = false;
                } catch (InterruptedException unused) {
                    z16 = true;
                }
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.bufferedPositionUs);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        if (isPlayingAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period);
            return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.contentPositionUs);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public Object getCurrentManifest() {
        return this.playbackInfo.manifest;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        if (shouldMaskPosition()) {
            return this.maskingPeriodIndex;
        }
        return this.playbackInfo.periodId.periodIndex;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.positionUs);
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackSelectorResult.groups;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period).windowIndex;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -9223372036854775807L;
        }
        if (isPlayingAd()) {
            MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
            timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
            return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
        }
        return timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getNextWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getNextWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPreviousWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getPreviousWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        return this.renderers.length;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i3) {
        return this.renderers[i3].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.repeatMode;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.TextComponent getTextComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.VideoComponent getVideoComponent() {
        return null;
    }

    void handleEvent(Message message) {
        int i3 = message.what;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                    Iterator<Player.EventListener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onPlayerError(exoPlaybackException);
                    }
                    return;
                }
                throw new IllegalStateException();
            }
            PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
            if (!this.playbackParameters.equals(playbackParameters)) {
                this.playbackParameters = playbackParameters;
                Iterator<Player.EventListener> it5 = this.listeners.iterator();
                while (it5.hasNext()) {
                    it5.next().onPlaybackParametersChanged(playbackParameters);
                }
                return;
            }
            return;
        }
        PlaybackInfo playbackInfo = (PlaybackInfo) message.obj;
        int i16 = message.arg1;
        int i17 = message.arg2;
        if (i17 == -1) {
            z16 = false;
        }
        handlePlaybackInfo(playbackInfo, i16, z16, i17);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowDynamic() {
        Timeline timeline = this.playbackInfo.timeline;
        if (!timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowSeekable() {
        Timeline timeline = this.playbackInfo.timeline;
        if (!timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        if (!shouldMaskPosition() && this.playbackInfo.periodId.isAd()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        Log.i(TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j3) {
        seekTo(getCurrentWindowIndex(), j3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z16) {
        if (this.playWhenReady != z16) {
            this.playWhenReady = z16;
            this.internalPlayer.setPlayWhenReady(z16);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlayerStateChanged(z16, this.playbackInfo.playbackState);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        this.internalPlayer.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i3) {
        if (this.repeatMode != i3) {
            this.repeatMode = i3;
            this.internalPlayer.setRepeatMode(i3);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        this.internalPlayer.setSeekParameters(seekParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z16) {
        if (this.shuffleModeEnabled != z16) {
            this.shuffleModeEnabled = z16;
            this.internalPlayer.setShuffleModeEnabled(z16);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z16);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        stop(false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource, boolean z16, boolean z17) {
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z16, z17, 2);
        this.hasPendingPrepare = true;
        this.pendingOperationAcks++;
        this.internalPlayer.prepare(mediaSource, z16, z17);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i3, long j3) {
        Timeline timeline = this.playbackInfo.timeline;
        if (i3 >= 0 && (timeline.isEmpty() || i3 < timeline.getWindowCount())) {
            this.hasPendingSeek = true;
            this.pendingOperationAcks++;
            if (isPlayingAd()) {
                Log.w(TAG, "seekTo ignored because an ad is playing");
                this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
                return;
            }
            this.maskingWindowIndex = i3;
            if (timeline.isEmpty()) {
                this.maskingWindowPositionMs = j3 == -9223372036854775807L ? 0L : j3;
                this.maskingPeriodIndex = 0;
            } else {
                long defaultPositionUs = j3 == -9223372036854775807L ? timeline.getWindow(i3, this.window).getDefaultPositionUs() : C.msToUs(j3);
                Pair<Integer, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i3, defaultPositionUs);
                this.maskingWindowPositionMs = C.usToMs(defaultPositionUs);
                this.maskingPeriodIndex = ((Integer) periodPosition.first).intValue();
            }
            this.internalPlayer.seekTo(timeline, i3, C.msToUs(j3));
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPositionDiscontinuity(1);
            }
            return;
        }
        throw new IllegalSeekPositionException(timeline, i3, j3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition(int i3) {
        seekTo(i3, -9223372036854775807L);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z16) {
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z16, z16, 1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop(z16);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false);
    }
}
