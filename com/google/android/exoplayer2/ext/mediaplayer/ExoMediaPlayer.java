package com.google.android.exoplayer2.ext.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.ext.audio.AudioFrameManager;
import com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface;
import com.google.android.exoplayer2.ext.mediaplayer.QLoadControl;
import com.google.android.exoplayer2.ext.mediaplayer.Repeater;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
/* loaded from: classes2.dex */
public class ExoMediaPlayer implements MediaPlayerInterface, AudioLevelSupport {
    private static final int BUFFER_REPEAT_DELAY = 1000;
    public static final String DEFAULT_LC_SAMPLE_CONFIG = "65536,15000,30000,2000,5000";
    private static final String HANDLER_THREAD_NAME = "SimpleExoMediaPlayer_HandlerThread";
    private static final String TAG = "ExoMediaPlayer";
    private Context mAppContext;
    protected DecoderInfo mAudioDecoderInfo;
    private MediaPlayerInterface.AudioEventListener mAudioEventListener;
    protected Format mAudioFormat;
    private AudioFrameManager mAudioFrameManager;
    private Repeater mBufferUpdateRepeater;
    private ExoPlayer.EventListener mExo2EventListener;
    private ExoPlayer mExoPlayer;
    private HandlerThread mHandlerThread;
    private boolean mIsLooping;
    private volatile boolean mIsRelease;
    private int mLastBufferedPercentage;
    private boolean mLoopingPlaySeek;
    private Handler mMainHandler;
    private MediaSource mMediaSource;
    private MediaSourceEventListener mMediaSourceEventListener;
    private MediaPlayerInterface.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private MediaPlayerInterface.OnCompletionListener mOnCompletionListener;
    private MediaPlayerInterface.OnErrorListener mOnErrorListener;
    private MediaPlayerInterface.OnInfoListener mOnInfoListener;
    private MediaPlayerInterface.OnLoopStartListener mOnLoopStartListener;
    private MediaPlayerInterface.OnPreparedListener mOnPreparedListener;
    private MediaPlayerInterface.OnSeekCompleteListener mOnSeekCompleteListener;
    private MediaPlayerInterface.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private boolean mOwnsSurface;
    private List<Renderer> mRenderers;
    private boolean mScreenOnWhilePlaying;
    private StateStore mStateStore;
    private boolean mStayAwake;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private final SurfaceListener mSurfaceListener;
    private TextureView mTextureView;
    protected DecoderInfo mVideoDecoderInfo;
    protected Format mVideoFormat;
    private int mVideoHeight;
    private int mVideoWidth;
    private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    private static ILogger sLogger = null;
    private final AtomicBoolean mStopped = new AtomicBoolean();
    private int mAudioSessionId = 0;
    private PowerManager.WakeLock mWakeLock = null;
    private boolean mFirstFrameDecoded = false;
    private boolean mFirstFrameDecodedEventSent = false;
    private boolean mCalculateAudioLevel = false;
    private double mLastAudioLevelDuration = -1.0d;
    private double mLastAudioLevelEnergy = -1.0d;
    private ArrayList<Long> mClipDurations = new ArrayList<>();

    /* loaded from: classes2.dex */
    private class BufferRepeatListener implements Repeater.RepeatListener {
        BufferRepeatListener() {
        }

        @Override // com.google.android.exoplayer2.ext.mediaplayer.Repeater.RepeatListener
        public void onUpdate() {
            synchronized (ExoMediaPlayer.this) {
                if (ExoMediaPlayer.this.mIsRelease) {
                    return;
                }
                if (ExoMediaPlayer.this.mExoPlayer != null) {
                    int playbackState = ExoMediaPlayer.this.mExoPlayer.getPlaybackState();
                    if (playbackState != 1) {
                        if (playbackState == 2 || playbackState == 3) {
                            int bufferedPercentage = ExoMediaPlayer.this.getBufferedPercentage();
                            if (bufferedPercentage != ExoMediaPlayer.this.mLastBufferedPercentage) {
                                ExoMediaPlayer.this.notifyOnBufferingUpdate(bufferedPercentage);
                                ExoMediaPlayer.this.mLastBufferedPercentage = bufferedPercentage;
                            }
                        } else if (playbackState != 4) {
                        }
                    }
                    ExoMediaPlayer.this.setBufferRepeaterStarted(false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private class Exo2EventListener implements ExoPlayer.EventListener {
        Exo2EventListener() {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onLoadingChanged(boolean z16) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onLoadingChanged " + z16);
            if (z16) {
                ExoMediaPlayer.this.setBufferRepeaterStarted(true);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onPlaybackParametersChanged [" + playbackParameters.speed + "," + playbackParameters.pitch + "]");
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            int i3;
            if (ExoMediaPlayer.this.mExoPlayer != null) {
                ExoMediaPlayer.this.setBufferRepeaterStarted(false);
            }
            ExoMediaPlayer.getLogger().e(ExoMediaPlayer.TAG, "ExoPlaybackException " + exoPlaybackException + "\n" + ExoMediaPlayerUtils.getPrintableStackTrace(exoPlaybackException));
            if (exoPlaybackException != null) {
                Throwable th5 = null;
                int i16 = 0;
                while (exoPlaybackException instanceof ExoPlaybackException) {
                    th5 = exoPlaybackException.getCause();
                    ExoPlaybackException exoPlaybackException2 = exoPlaybackException;
                    i16 = exoPlaybackException2.type + 100;
                    if (i16 == 1) {
                        i16 += exoPlaybackException2.rendererIndex;
                    }
                    exoPlaybackException = th5;
                }
                if (th5 != null) {
                    if (th5 instanceof HttpDataSource.HttpDataSourceException) {
                        i3 = i16 - 4000;
                        if (th5.toString().contains("Unable to connect")) {
                            boolean isNetworkAvailable = ExoMediaPlayerUtils.isNetworkAvailable(ExoMediaPlayer.this.mAppContext);
                            ExoMediaPlayer.getLogger().e(ExoMediaPlayer.TAG, "ExoPlaybackException hasNetwork=" + isNetworkAvailable + " caused by:\n" + th5.toString());
                            if (!isNetworkAvailable) {
                                ExoMediaPlayer.this.notifyOnError(i3, -2);
                                return;
                            } else {
                                ExoMediaPlayer.this.notifyOnError(i3, -3);
                                return;
                            }
                        }
                        if (th5 instanceof HttpDataSource.InvalidResponseCodeException) {
                            String th6 = th5.toString();
                            if (th6.contains("403")) {
                                ExoMediaPlayer.this.notifyOnError(i3, -10);
                                return;
                            }
                            if (th6.contains("404")) {
                                ExoMediaPlayer.this.notifyOnError(i3, -11);
                                return;
                            }
                            if (th6.contains("500")) {
                                ExoMediaPlayer.this.notifyOnError(i3, -12);
                                return;
                            } else if (th6.contains("502")) {
                                ExoMediaPlayer.this.notifyOnError(i3, -13);
                                return;
                            } else {
                                ExoMediaPlayer.this.notifyOnError(i3, -30);
                                return;
                            }
                        }
                        ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, ExoMediaPlayerUtils.getLogcatContent(0, null, 30));
                        ExoMediaPlayer.this.notifyOnError(i3, -1);
                    }
                    if (th5 instanceof UnrecognizedInputFormatException) {
                        ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, ExoMediaPlayerUtils.getLogcatContent());
                        ExoMediaPlayer.this.notifyOnError(i16 - 4001, -1);
                        return;
                    } else if (th5 instanceof IllegalStateException) {
                        ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, ExoMediaPlayerUtils.getLogcatContent());
                        ExoMediaPlayer.this.notifyOnError(i16 - 4002, -1);
                        return;
                    } else if (th5 instanceof MediaCodecRenderer.DecoderInitializationException) {
                        ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, ExoMediaPlayerUtils.getLogcatContent());
                        ExoMediaPlayer.this.notifyOnError(i16 - 4003, -1);
                        return;
                    } else if (th5 instanceof Loader.UnexpectedLoaderException) {
                        ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, ExoMediaPlayerUtils.getLogcatContent());
                        ExoMediaPlayer.this.notifyOnError(i16 - 4004, -1);
                        return;
                    }
                }
            }
            i3 = -4999;
            ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, ExoMediaPlayerUtils.getLogcatContent(0, null, 30));
            ExoMediaPlayer.this.notifyOnError(i3, -1);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z16, int i3) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onPlayerStateChanged playWhenReady=" + z16 + ",playbackState=" + i3);
            ExoMediaPlayer.this.reportPlayerState();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i3) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onPositionDiscontinuity reason=" + i3);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i3) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onRepeatModeChanged " + i3);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onSeekProcessed() {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onSeekProcessed");
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z16) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onShuffleModeEnabledChanged shuffleModeEnabled=" + z16);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj, int i3) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onTimelineChanged reason=" + i3);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onTracksChanged");
            if (ExoMediaPlayer.this.mClipDurations.size() > 0) {
                ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "update duration idx=" + ExoMediaPlayer.this.mExoPlayer.getCurrentWindowIndex() + ",duration=" + ExoMediaPlayer.this.mExoPlayer.getDuration());
                ExoMediaPlayer.this.mClipDurations.set(ExoMediaPlayer.this.mExoPlayer.getCurrentWindowIndex(), Long.valueOf(ExoMediaPlayer.this.mExoPlayer.getDuration()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class StateStore {
        private static final int FLAG_PLAY_WHEN_READY = -268435456;
        private static final int STATE_SEEKING = 100;
        private int[] prevStates;

        StateStore() {
            this.prevStates = new int[]{1, 1, 1, 1};
        }

        int getMostRecentState() {
            return this.prevStates[3];
        }

        int getState(boolean z16, int i3) {
            int i16;
            if (z16) {
                i16 = -268435456;
            } else {
                i16 = 0;
            }
            return i16 | i3;
        }

        boolean isLastReportedPlayWhenReady() {
            if ((this.prevStates[3] & (-268435456)) != 0) {
                return true;
            }
            return false;
        }

        boolean matchesHistory(int[] iArr, boolean z16) {
            int i3;
            boolean z17;
            if (z16) {
                i3 = 268435455;
            } else {
                i3 = -1;
            }
            int length = this.prevStates.length - iArr.length;
            int i16 = length;
            boolean z18 = true;
            while (true) {
                int[] iArr2 = this.prevStates;
                if (i16 < iArr2.length) {
                    if ((iArr2[i16] & i3) == (iArr[i16 - length] & i3)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 &= z17;
                    i16++;
                } else {
                    return z18;
                }
            }
        }

        void reset() {
            this.prevStates = new int[]{1, 1, 1, 1};
        }

        void setMostRecentState(boolean z16, int i3) {
            int state = getState(z16, i3);
            ExoMediaPlayer.getLogger().v(ExoMediaPlayer.TAG, "request setMostRecentState [" + z16 + "," + i3 + "], lastState=" + this.prevStates[3] + ",newState=" + state);
            int[] iArr = this.prevStates;
            int i16 = iArr[3];
            if (i16 == state) {
                return;
            }
            iArr[0] = iArr[1];
            iArr[1] = iArr[2];
            iArr[2] = i16;
            iArr[3] = state;
            ExoMediaPlayer.getLogger().v(ExoMediaPlayer.TAG, "MostRecentState [" + this.prevStates[0] + "," + this.prevStates[1] + "," + this.prevStates[2] + "," + this.prevStates[3] + "]");
        }
    }

    public ExoMediaPlayer(Context context) {
        this.mAppContext = context;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(HANDLER_THREAD_NAME);
        this.mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mMainHandler = new Handler(this.mHandlerThread.getLooper());
        this.mStateStore = new StateStore();
        this.mExo2EventListener = new Exo2EventListener();
        BufferRepeatListener bufferRepeatListener = new BufferRepeatListener();
        this.mMediaSourceEventListener = new ExoMediaSourceEventListener();
        this.mSurfaceListener = new SurfaceListener();
        Repeater repeater = new Repeater(this.mMainHandler);
        this.mBufferUpdateRepeater = repeater;
        repeater.setRepeaterDelay(1000);
        this.mBufferUpdateRepeater.setRepeatListener(bufferRepeatListener);
        RendererEventListener rendererEventListener = new RendererEventListener();
        this.mRenderers = new DefaultRendererProvider(this.mAppContext, this.mMainHandler, rendererEventListener, rendererEventListener, rendererEventListener, rendererEventListener).generate();
        this.mMainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ExoMediaPlayer.this) {
                    ExoMediaPlayer.this.initPlayer();
                    ExoMediaPlayer.this.notifyAll();
                }
            }
        });
        synchronized (this) {
            while (this.mExoPlayer == null) {
                try {
                    LockMethodProxy.wait(this);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private DataSource.Factory buildDataSourceFactory(boolean z16, String str) {
        return buildDataSourceFactory(z16 ? BANDWIDTH_METER : null, str);
    }

    private HttpDataSource.Factory buildHttpDataSourceFactory(DefaultBandwidthMeter defaultBandwidthMeter, String str) {
        return new DefaultHttpDataSourceFactory(str, defaultBandwidthMeter);
    }

    private MediaSource buildMediaSource(Context context, Uri uri, String str) {
        int inferContentType;
        if (TextUtils.isEmpty(str)) {
            inferContentType = Util.inferContentType(uri);
        } else {
            inferContentType = Util.inferContentType("." + str);
        }
        String userAgent = Util.getUserAgent(context, TAG);
        if (inferContentType != 2) {
            if (inferContentType == 3) {
                ExtractorMediaSource.Factory factory = new ExtractorMediaSource.Factory(buildDataSourceFactory(BANDWIDTH_METER, userAgent));
                factory.setContinueLoadingCheckIntervalBytes(2097152);
                factory.setMinLoadableRetryCount(10);
                return factory.createMediaSource(uri, this.mMainHandler, this.mMediaSourceEventListener);
            }
            throw new IllegalStateException("Unsupported type: " + inferContentType);
        }
        return new HlsMediaSource.Factory(buildDataSourceFactory(BANDWIDTH_METER, userAgent)).createMediaSource(uri, this.mMainHandler, this.mMediaSourceEventListener);
    }

    private void clearVideoSurface(Surface surface) {
        if (surface != null && surface == this.mSurface) {
            setSurface(null);
        }
    }

    private void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null && surfaceHolder == this.mSurfaceHolder) {
            setDisplay(null);
        }
    }

    private void clearVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        if (surfaceView == null) {
            holder = null;
        } else {
            holder = surfaceView.getHolder();
        }
        clearVideoSurfaceHolder(holder);
    }

    private void clearVideoTextureView(TextureView textureView) {
        if (textureView != null && textureView == this.mTextureView) {
            setVideoTextureView(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBufferedPercentage() {
        ExoPlayer exoPlayer = this.mExoPlayer;
        if (exoPlayer == null) {
            return 0;
        }
        return exoPlayer.getBufferedPercentage();
    }

    public static ILogger getLogger() {
        if (sLogger == null) {
            synchronized (ExoMediaPlayer.class) {
                if (sLogger == null) {
                    sLogger = new DefaultLogger();
                }
            }
        }
        return sLogger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPlayer() {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter()));
        QLoadControl qLoadControl = new QLoadControl();
        List<Renderer> list = this.mRenderers;
        ExoPlayer newInstance = ExoPlayerFactory.newInstance((Renderer[]) list.toArray(new Renderer[list.size()]), defaultTrackSelector, qLoadControl);
        this.mExoPlayer = newInstance;
        newInstance.addListener(this.mExo2EventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnBufferingUpdate(int i3) {
        getLogger().v(TAG, "notifyOnBufferingUpdate " + i3);
        synchronized (this) {
            if (this.mIsRelease) {
                return;
            }
            MediaPlayerInterface.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener.onBufferingUpdate(this, i3);
            }
        }
    }

    private void notifyOnCompletion() {
        getLogger().v(TAG, "notifyOnCompletion");
        synchronized (this) {
            if (this.mIsRelease) {
                return;
            }
            MediaPlayerInterface.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyOnError(int i3, int i16) {
        getLogger().d(TAG, "notifyOnError [" + i3 + "," + i16 + "]");
        MediaPlayerInterface.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null && onErrorListener.onError(this, i3, i16)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyOnInfo(int i3, int i16) {
        getLogger().d(TAG, "notifyOnInfo [" + i3 + "," + i16 + "]");
        MediaPlayerInterface.OnInfoListener onInfoListener = this.mOnInfoListener;
        if (onInfoListener != null && onInfoListener.onInfo(this, i3, i16)) {
            return true;
        }
        return false;
    }

    private void notifyOnPrepared() {
        getLogger().v(TAG, "notifyOnPrepared");
        synchronized (this) {
            if (this.mIsRelease) {
                return;
            }
            MediaPlayerInterface.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(this);
            }
        }
    }

    private void notifyOnSeekComplete() {
        getLogger().v(TAG, "notifyOnSeekComplete");
        synchronized (this) {
            if (this.mIsRelease) {
                return;
            }
            MediaPlayerInterface.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnVideoSizeChanged(int i3, int i16, int i17, int i18) {
        getLogger().v(TAG, "notifyOnVideoSizeChanged [" + i3 + "," + i16 + "]");
        synchronized (this) {
            if (this.mIsRelease) {
                return;
            }
            MediaPlayerInterface.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(this, i3, i16);
            }
        }
    }

    private void removeSurfaceCallbacks() {
        TextureView textureView = this.mTextureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.mSurfaceListener) {
                getLogger().w(TAG, "SurfaceTextureListener already unset or replaced");
            } else {
                this.mTextureView.setSurfaceTextureListener(null);
            }
            this.mTextureView = null;
        }
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.mSurfaceListener);
            this.mSurfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reportPlayerState() {
        if (this.mExoPlayer != null && !this.mIsRelease) {
            boolean playWhenReady = this.mExoPlayer.getPlayWhenReady();
            int playbackState = this.mExoPlayer.getPlaybackState();
            int state = this.mStateStore.getState(playWhenReady, playbackState);
            if (state != this.mStateStore.getMostRecentState()) {
                getLogger().d(TAG, "setMostRecentState [" + playWhenReady + "," + playbackState + "]");
                this.mStateStore.setMostRecentState(playWhenReady, playbackState);
                if (state == 3) {
                    setBufferRepeaterStarted(true);
                } else if (state == 1 || state == 4) {
                    setBufferRepeaterStarted(false);
                }
                if (state == this.mStateStore.getState(true, 4)) {
                    if (isLooping()) {
                        getLogger().i(TAG, "looping play start");
                        this.mLoopingPlaySeek = true;
                        seekTo(0L);
                        MediaPlayerInterface.OnLoopStartListener onLoopStartListener = this.mOnLoopStartListener;
                        if (onLoopStartListener != null) {
                            onLoopStartListener.onLoopStart(this);
                        }
                    } else {
                        notifyOnCompletion();
                    }
                    return;
                }
                StateStore stateStore = this.mStateStore;
                if (stateStore.matchesHistory(new int[]{stateStore.getState(false, 1), this.mStateStore.getState(false, 2), this.mStateStore.getState(false, 3)}, false)) {
                    notifyOnPrepared();
                    return;
                }
                if (this.mStateStore.matchesHistory(new int[]{100, 3, 2, 3}, true) | this.mStateStore.matchesHistory(new int[]{100, 2, 3}, true) | this.mStateStore.matchesHistory(new int[]{2, 100, 3}, true)) {
                    if (!this.mLoopingPlaySeek) {
                        notifyOnSeekComplete();
                    } else {
                        this.mLoopingPlaySeek = false;
                    }
                    return;
                }
                StateStore stateStore2 = this.mStateStore;
                if (stateStore2.matchesHistory(new int[]{stateStore2.getState(true, 3), this.mStateStore.getState(true, 2)}, false)) {
                    notifyOnInfo(701, getBufferedPercentage());
                    return;
                }
                StateStore stateStore3 = this.mStateStore;
                if (stateStore3.matchesHistory(new int[]{stateStore3.getState(true, 2), this.mStateStore.getState(true, 3)}, false)) {
                    notifyOnInfo(702, getBufferedPercentage());
                }
            }
        }
    }

    private void sendMessage(int i3, int i16, Object obj) {
        sendMessage(i3, i16, obj, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBufferRepeaterStarted(boolean z16) {
        getLogger().d(TAG, "setBufferRepeaterStarted " + z16);
        if (z16 && this.mOnBufferingUpdateListener != null) {
            this.mBufferUpdateRepeater.start();
        } else {
            this.mBufferUpdateRepeater.stop();
        }
    }

    public static void setLogger(ILogger iLogger) {
        synchronized (ExoMediaPlayer.class) {
            sLogger = iLogger;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(Surface surface, boolean z16) {
        if (this.mExoPlayer == null) {
            getLogger().w(TAG, "call setVideoSurfaceInternal after release");
            return;
        }
        Surface surface2 = this.mSurface;
        if (surface2 != null && surface2 != surface && surface != null) {
            if (this.mOwnsSurface) {
                surface2.release();
            }
            sendMessage(2, 1, surface, true);
            final long currentPosition = this.mExoPlayer.getCurrentPosition();
            if (Util.SDK_INT < 23) {
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ExoMediaPlayer.this.mExoPlayer != null) {
                            ExoMediaPlayer.this.mExoPlayer.seekTo(currentPosition);
                        }
                    }
                }, 200L);
            }
        } else {
            sendMessage(2, 1, surface, false);
        }
        this.mSurface = surface;
        this.mOwnsSurface = z16;
        updateSurfaceScreenOn();
    }

    private void setVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        if (surfaceView == null) {
            holder = null;
        } else {
            holder = surfaceView.getHolder();
        }
        setDisplay(holder);
    }

    private void setVideoTextureView(TextureView textureView) {
        removeSurfaceCallbacks();
        this.mTextureView = textureView;
        Surface surface = null;
        if (textureView == null) {
            setVideoSurfaceInternal(null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            getLogger().w(TAG, "Replacing existing SurfaceTextureListener");
        }
        SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
        if (surfaceTexture != null) {
            surface = new Surface(surfaceTexture);
        }
        setVideoSurfaceInternal(surface, true);
        textureView.setSurfaceTextureListener(this.mSurfaceListener);
    }

    private void stayAwake(boolean z16) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z16 && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z16 && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z16;
        updateSurfaceScreenOn();
    }

    public static void updateLoadControlConfig(QLoadControl.Config config) {
        getLogger().d(TAG, "updateLoadControlConfig " + config);
        QLoadControl.updateConfig(config);
    }

    private void updateSurfaceScreenOn() {
        boolean z16;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            if (this.mScreenOnWhilePlaying && this.mStayAwake) {
                z16 = true;
            } else {
                z16 = false;
            }
            surfaceHolder.setKeepScreenOn(z16);
        }
    }

    public static void warmDecoder() {
        MediaCodecUtil.warmDecoderInfoCache("video/hevc", false);
        MediaCodecUtil.warmDecoderInfoCache("video/avc", false);
        MediaCodecUtil.warmDecoderInfoCache("audio/mp4a-latm", false);
    }

    public DecoderInfo getAudioDecoderInfo() {
        return this.mAudioDecoderInfo;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public double getAudioDuration() {
        AudioFrameManager audioFrameManager = this.mAudioFrameManager;
        if (audioFrameManager != null) {
            return audioFrameManager.getDuration();
        }
        return 0.0d;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public double getAudioEnergy() {
        AudioFrameManager audioFrameManager = this.mAudioFrameManager;
        if (audioFrameManager != null) {
            return audioFrameManager.getAudioEnergy();
        }
        return 0.0d;
    }

    public Format getAudioFormat() {
        return this.mAudioFormat;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public double getAudioLevel() {
        AudioFrameManager audioFrameManager = this.mAudioFrameManager;
        double d16 = 0.0d;
        if (audioFrameManager != null) {
            double duration = audioFrameManager.getDuration() - this.mLastAudioLevelDuration;
            if (duration > 0.0d) {
                d16 = Math.sqrt((this.mAudioFrameManager.getAudioEnergy() - this.mLastAudioLevelEnergy) / duration);
            }
            this.mLastAudioLevelDuration = this.mAudioFrameManager.getDuration();
            this.mLastAudioLevelEnergy = this.mAudioFrameManager.getAudioEnergy();
        }
        return d16;
    }

    public int getAudioSessionId() {
        return this.mAudioSessionId;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public long getCurrentPosition() {
        long j3 = 0;
        if (this.mExoPlayer == null) {
            return 0L;
        }
        if (this.mClipDurations.size() > 0) {
            int currentWindowIndex = this.mExoPlayer.getCurrentWindowIndex();
            while (currentWindowIndex > 0) {
                currentWindowIndex--;
                j3 += this.mClipDurations.get(currentWindowIndex).longValue();
            }
            return j3 + this.mExoPlayer.getCurrentPosition();
        }
        return this.mExoPlayer.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public long getDuration() {
        long j3 = 0;
        if (this.mExoPlayer == null) {
            return 0L;
        }
        if (this.mClipDurations.size() > 0) {
            Iterator<Long> it = this.mClipDurations.iterator();
            while (it.hasNext()) {
                j3 += it.next().longValue();
            }
            return j3;
        }
        return this.mExoPlayer.getDuration();
    }

    public DecoderInfo getVideoDecoderInfo() {
        return this.mVideoDecoderInfo;
    }

    public Format getVideoFormat() {
        return this.mVideoFormat;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public boolean isLooping() {
        return this.mIsLooping;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0014, code lost:
    
        if (r0 != 4) goto L17;
     */
    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.mExoPlayer;
        if (exoPlayer == null) {
            return false;
        }
        int playbackState = exoPlayer.getPlaybackState();
        if (playbackState != 1) {
            if (playbackState != 2) {
                if (playbackState != 3) {
                }
            }
            if (!this.mIsLooping) {
                return false;
            }
            return true;
        }
        return this.mExoPlayer.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void pause() throws IllegalStateException {
        ExoPlayer exoPlayer = this.mExoPlayer;
        if (exoPlayer == null) {
            return;
        }
        exoPlayer.setPlayWhenReady(false);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void prepareAsync() throws IllegalStateException {
        getLogger().v(TAG, "prepareAsync");
        Surface surface = this.mSurface;
        if (surface != null) {
            setSurface(surface);
        }
        if (this.mIsLooping) {
            getLogger().v(TAG, "looping play video");
        }
        this.mExoPlayer.setPlayWhenReady(false);
        this.mExoPlayer.prepare(this.mMediaSource);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public synchronized void release() {
        this.mIsRelease = true;
        if (this.mExoPlayer != null) {
            setBufferRepeaterStarted(false);
            ExoPlayer exoPlayer = this.mExoPlayer;
            if (exoPlayer != null) {
                exoPlayer.release();
                this.mExoPlayer.removeListener(this.mExo2EventListener);
                this.mExoPlayer = null;
            }
            this.mSurface = null;
            this.mVideoWidth = 0;
            this.mVideoHeight = 0;
            this.mSurfaceHolder = null;
            this.mClipDurations.clear();
            this.mLastBufferedPercentage = 0;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
        }
        stayAwake(false);
        updateSurfaceScreenOn();
        removeSurfaceCallbacks();
        Surface surface = this.mSurface;
        if (surface != null) {
            if (this.mOwnsSurface) {
                surface.release();
            }
            this.mSurface = null;
        }
        this.mOnPreparedListener = null;
        this.mOnCompletionListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void reset() {
        if (this.mExoPlayer != null) {
            setBufferRepeaterStarted(false);
            ExoPlayer exoPlayer = this.mExoPlayer;
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(false);
                this.mExoPlayer.stop(true);
            }
            this.mIsLooping = false;
            this.mFirstFrameDecoded = false;
            this.mFirstFrameDecodedEventSent = false;
            this.mStateStore.reset();
            this.mClipDurations.clear();
            this.mLastBufferedPercentage = 0;
        }
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void seekTo(long j3) throws IllegalStateException {
        if (this.mExoPlayer == null) {
            return;
        }
        if (this.mClipDurations.size() > 0) {
            long j16 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= this.mClipDurations.size()) {
                    break;
                }
                j16 += this.mClipDurations.get(i3).longValue();
                if (j16 > j3) {
                    this.mExoPlayer.seekTo(i3, (j3 - j16) + this.mClipDurations.get(i3).longValue());
                    break;
                }
                i3++;
            }
        } else {
            this.mExoPlayer.seekTo(j3);
        }
        StateStore stateStore = this.mStateStore;
        stateStore.setMostRecentState(stateStore.isLastReportedPlayWhenReady(), 100);
    }

    public void setAudioEventListener(MediaPlayerInterface.AudioEventListener audioEventListener) {
        this.mAudioEventListener = audioEventListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.AudioLevelSupport
    public void setCalculateAudioLevel(boolean z16) {
        this.mCalculateAudioLevel = z16;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mMediaSource = buildMediaSource(this.mAppContext, uri, null);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setDisplay(SurfaceHolder surfaceHolder) {
        removeSurfaceCallbacks();
        this.mSurfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            setVideoSurfaceInternal(null, false);
        } else {
            setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
            surfaceHolder.addCallback(this.mSurfaceListener);
        }
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setLooping(boolean z16) {
        this.mIsLooping = z16;
        getLogger().i(TAG, "setLooping " + this.mIsLooping);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setNextMediaPlayer(MediaPlayerInterface mediaPlayerInterface) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("setNextMediaPlayer is not supported by " + ExoMediaPlayer.class.getSimpleName());
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnBufferingUpdateListener(MediaPlayerInterface.OnBufferingUpdateListener onBufferingUpdateListener) {
        boolean z16;
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setBufferRepeaterStarted(z16);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnCompletionListener(MediaPlayerInterface.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnErrorListener(MediaPlayerInterface.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnInfoListener(MediaPlayerInterface.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnLoopStartListener(MediaPlayerInterface.OnLoopStartListener onLoopStartListener) {
        this.mOnLoopStartListener = onLoopStartListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnPreparedListener(MediaPlayerInterface.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnSeekCompleteListener(MediaPlayerInterface.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setOnVideoSizeChangedListener(MediaPlayerInterface.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setRate(float f16) {
        this.mExoPlayer.setPlaybackParameters(new PlaybackParameters(f16, f16));
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setScreenOnWhilePlaying(boolean z16) {
        if (this.mScreenOnWhilePlaying != z16) {
            if (z16 && this.mSurfaceHolder == null) {
                getLogger().w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z16;
            updateSurfaceScreenOn();
        }
        updateSurfaceScreenOn();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        ExoPlayer exoPlayer = this.mExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setSeekParameters(seekParameters);
        }
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            getLogger().w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(surface, false);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setVolume(float f16, float f17) {
        sendMessage(1, 2, Float.valueOf(f16));
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setWakeMode(Context context, int i3) {
        boolean z16;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.mWakeLock.release();
                z16 = true;
            } else {
                z16 = false;
            }
            this.mWakeLock = null;
        } else {
            z16 = false;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.WAKE_LOCK", context.getPackageName()) == 0) {
                PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i3 | 536870912, ExoMediaPlayer.class.getName());
                this.mWakeLock = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            } else {
                getLogger().w(TAG, "Unable to acquire WAKE_LOCK due to missing manifest permission");
            }
        } catch (Exception e16) {
            getLogger().w(TAG, "Unable to acquire WAKE_LOCK ", e16);
        }
        stayAwake(z16);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void start() throws IllegalStateException {
        ExoPlayer exoPlayer = this.mExoPlayer;
        if (exoPlayer == null) {
            return;
        }
        exoPlayer.setPlayWhenReady(true);
        if (!this.mFirstFrameDecodedEventSent && this.mFirstFrameDecoded) {
            notifyOnInfo(3, 0);
            this.mFirstFrameDecodedEventSent = true;
        }
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void stop() throws IllegalStateException {
        if (this.mExoPlayer != null && !this.mStopped.getAndSet(true)) {
            this.mExoPlayer.setPlayWhenReady(false);
            this.mExoPlayer.stop();
        }
    }

    private DataSource.Factory buildDataSourceFactory(DefaultBandwidthMeter defaultBandwidthMeter, String str) {
        return new DefaultDataSourceFactory(this.mAppContext, defaultBandwidthMeter, buildHttpDataSourceFactory(defaultBandwidthMeter, str));
    }

    private void sendMessage(int i3, int i16, Object obj, boolean z16) {
        if (this.mRenderers.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Renderer renderer : this.mRenderers) {
            if (renderer.getTrackType() == i3) {
                arrayList.add(new ExoPlayer.ExoPlayerMessage(renderer, i16, obj));
            }
        }
        if (z16) {
            this.mExoPlayer.blockingSendMessages((ExoPlayer.ExoPlayerMessage[]) arrayList.toArray(new ExoPlayer.ExoPlayerMessage[arrayList.size()]));
        } else {
            this.mExoPlayer.sendMessages((ExoPlayer.ExoPlayerMessage[]) arrayList.toArray(new ExoPlayer.ExoPlayerMessage[arrayList.size()]));
        }
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setDataSource(Context context, List<String> list) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(buildMediaSource(this.mAppContext, Uri.parse(str), null));
            }
        }
        this.mMediaSource = new ConcatenatingMediaSource((MediaSource[]) arrayList.toArray(new MediaSource[arrayList.size()]));
    }

    public static void updateLoadControlConfig(String str) {
        getLogger().d(TAG, "updateLoadControlConfig " + str);
        QLoadControl.updateConfig(str);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(this.mAppContext, Uri.parse(str));
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
    public void setDataSource(List<VideoMeta> list) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mMediaSource = new DynamicConcatenatingMediaSource();
        for (VideoMeta videoMeta : list) {
            long j3 = videoMeta.startPosition * 1000;
            long j16 = videoMeta.endPosition;
            if (j16 == -1) {
                j16 = videoMeta.duration;
            }
            long j17 = j16 * 1000;
            if (j17 > j3) {
                this.mClipDurations.add(Long.valueOf((j17 - j3) / 1000));
                ((DynamicConcatenatingMediaSource) this.mMediaSource).addMediaSource(new ClippingMediaSource(buildMediaSource(this.mAppContext, Uri.parse(videoMeta.uri), null), j3, j17));
            } else {
                throw new IllegalArgumentException("wrong range [" + j3 + "," + j17 + "]");
            }
        }
    }

    public void setDataSource(VideoMeta... videoMetaArr) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(Arrays.asList(videoMetaArr));
    }

    /* loaded from: classes2.dex */
    private class RendererEventListener implements VideoRendererEventListener, AudioRendererEventListener, MetadataRenderer.Output, TextRenderer.Output {
        RendererEventListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public boolean isNeedAudioData() {
            if (ExoMediaPlayer.this.mAudioEventListener == null && !ExoMediaPlayer.this.mCalculateAudioLevel) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j3, long j16) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onAudioDecoderInitialized decoderName=" + str + ",initializedTimestampMs" + j3 + ",initializationDurationMs" + j16);
            ExoMediaPlayer.this.mAudioDecoderInfo = new DecoderInfo(1, str, j16);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onAudioEnabled");
            ExoMediaPlayer.this.mAudioSessionId = 0;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onAudioInputFormatChanged");
            ExoMediaPlayer.this.mAudioFormat = format;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i3) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onAudioSessionId " + i3);
            ExoMediaPlayer.this.mAudioSessionId = i3;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkUnderrun(int i3, long j3, long j16) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onAudioSinkUnderrun bufferSize=" + i3 + ",bufferSizeMs" + j3 + ",elapsedSinceLastFeedMs" + j16);
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onCues");
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i3, long j3) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onDroppedFrames");
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onMetadata");
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onRenderAudioData(byte[] bArr) {
            ExoMediaPlayer.getLogger().v(ExoMediaPlayer.TAG, "onRenderAudioData " + bArr.length);
            if (ExoMediaPlayer.this.mCalculateAudioLevel && ExoMediaPlayer.this.mAudioFrameManager == null) {
                ExoMediaPlayer.this.mAudioFrameManager = new AudioFrameManager();
            }
            if (ExoMediaPlayer.this.mAudioFrameManager != null) {
                ExoMediaPlayer.this.mAudioFrameManager.feedAudioData(bArr, ExoMediaPlayer.this.mAudioFormat);
            }
            if (ExoMediaPlayer.this.mAudioEventListener != null) {
                ExoMediaPlayer.this.mAudioEventListener.onRenderAudioData(bArr, ExoMediaPlayer.this.mAudioFormat);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onRenderedFirstFrame");
            if (ExoMediaPlayer.this.mExoPlayer != null && ExoMediaPlayer.this.mSurface == surface && ExoMediaPlayer.this.mExoPlayer.getPlayWhenReady() && !ExoMediaPlayer.this.mFirstFrameDecodedEventSent) {
                ExoMediaPlayer.this.notifyOnInfo(3, 0);
                ExoMediaPlayer.this.mFirstFrameDecodedEventSent = true;
            }
            ExoMediaPlayer.this.mFirstFrameDecoded = true;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j3, long j16) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onAudioDecoderInitialized decoderName=" + str + ",initializedTimestampMs=" + j3 + ",initializationDurationMs=" + j16);
            ExoMediaPlayer.this.mVideoDecoderInfo = new DecoderInfo(0, str, j16);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onVideoDisabled");
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onVideoEnabled");
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            ExoMediaPlayer.getLogger().d(ExoMediaPlayer.TAG, "onVideoInputFormatChanged");
            ExoMediaPlayer.this.mVideoFormat = format;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i3, int i16, int i17, float f16) {
            ExoMediaPlayer.this.mVideoWidth = i3;
            ExoMediaPlayer.this.mVideoHeight = i16;
            ExoMediaPlayer.this.notifyOnVideoSizeChanged(i3, i16, 1, 1);
            if (i17 > 0) {
                ExoMediaPlayer.this.notifyOnInfo(10001, i17);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class SurfaceListener implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        SurfaceListener() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            ExoMediaPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoMediaPlayer.this.setVideoSurfaceInternal(null, true);
            return true;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ExoMediaPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ExoMediaPlayer.this.setVideoSurfaceInternal(null, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        }
    }

    /* loaded from: classes2.dex */
    private class ExoMediaSourceEventListener implements MediaSourceEventListener {
        ExoMediaSourceEventListener() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19, IOException iOException, boolean z16) {
            ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, "loadError " + dataSpec + "," + i3 + "," + i16 + "," + j17 + "\n" + ExoMediaPlayerUtils.getPrintableStackTrace(iOException));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17) {
            ExoMediaPlayer.getLogger().i(ExoMediaPlayer.TAG, "loadStart " + dataSpec + "," + i3 + "," + i16 + "," + j17);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int i3, long j3, long j16) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int i3, Format format, int i16, Object obj, long j3) {
        }
    }
}
