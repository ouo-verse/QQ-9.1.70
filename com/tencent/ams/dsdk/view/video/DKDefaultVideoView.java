package com.tencent.ams.dsdk.view.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.dsdk.view.video.VideoLoader;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKDefaultVideoView extends VideoView implements DKVideoPlayer {
    static IPatchRedirector $redirector_ = null;
    private static final String EXTRA_PREV_VOLUME_STREAM_VALUE = "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
    private static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    private static final String TAG = "DKDefaultVideoView";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private boolean isLoop;
    private boolean isMute;
    private AudioAttributes mAudioAttributes;
    private AudioFocusRequest mAudioFocusRequest;
    private AudioManager mAudioManager;
    private boolean mAutoPlay;
    private boolean mHasAudioFocused;
    private boolean mIsMusicActiveInBackground;
    private boolean mLastPlayCompleted;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private DKVideoPlayer.OnVideoPlayListener mOnVideoPlayListener;
    private VideoLoader mVideoLoader;
    private float mVolume;
    private VolumeChangedReceiver mVolumeChangedReceiver;
    MediaPlayer mediaPlayer;
    private DKVideoPlayer.ObjectFit objectFit;
    private volatile Thread timeUpdaterThread;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnVolumeChangedListener {
        void onVolumeChanged(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class VolumeChangedReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;
        private OnVolumeChangedListener mOnVolumeChangedListener;

        public VolumeChangedReceiver(OnVolumeChangedListener onVolumeChangedListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onVolumeChangedListener);
            } else {
                this.mOnVolumeChangedListener = onVolumeChangedListener;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && DKDefaultVideoView.VOLUME_CHANGED_ACTION.equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(DKDefaultVideoView.EXTRA_VOLUME_STREAM_VALUE, 0);
                int intExtra2 = intent.getIntExtra(DKDefaultVideoView.EXTRA_PREV_VOLUME_STREAM_VALUE, 0);
                DLog.d(DKDefaultVideoView.TAG, "onVolume changed, volume: " + intExtra + ", old: " + intExtra2);
                OnVolumeChangedListener onVolumeChangedListener = this.mOnVolumeChangedListener;
                if (onVolumeChangedListener != null && intExtra != intExtra2) {
                    onVolumeChangedListener.onVolumeChanged(intExtra);
                }
            }
        }
    }

    public DKDefaultVideoView(Context context, VideoLoader videoLoader) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) videoLoader);
            return;
        }
        this.objectFit = DKVideoPlayer.ObjectFit.FILL;
        this.mVolumeChangedReceiver = null;
        this.mAudioManager = null;
        this.mOnVideoPlayListener = null;
        this.mLastPlayCompleted = false;
        this.mAutoPlay = true;
        this.mHasAudioFocused = false;
        this.mVideoLoader = videoLoader;
        initAudioManager();
        if (Build.VERSION.SDK_INT >= 26) {
            setAudioFocusRequest(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus() {
        int i3;
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                i3 = audioManager.abandonAudioFocusRequest(this.mAudioFocusRequest);
            } else {
                i3 = audioManager.abandonAudioFocus(this.mOnAudioFocusChangeListener);
            }
        } else {
            i3 = 0;
        }
        DLog.i(TAG, "abandonAudioFocus, result: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void callOnPlay(DKVideoPlayer.OnVideoPlayListener onVideoPlayListener) {
        DLog.d(TAG, "callOnPlay, isMute: " + this.isMute);
        if (onVideoPlayListener != null) {
            if (!this.isLoop || !this.mLastPlayCompleted) {
                onVideoPlayListener.onPlay();
                DLog.d(TAG, "onPlay: callOnPlay");
            }
            this.mLastPlayCompleted = false;
            if (this.timeUpdaterThread == null || !this.timeUpdaterThread.isAlive()) {
                this.timeUpdaterThread = new BaseThread(new Runnable(onVideoPlayListener) { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ DKVideoPlayer.OnVideoPlayListener val$onVideoPlayListener;

                    {
                        this.val$onVideoPlayListener = onVideoPlayListener;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this, (Object) onVideoPlayListener);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        while (DKDefaultVideoView.this.isPlaying()) {
                            try {
                                this.val$onVideoPlayListener.onTimeUpdate(DKDefaultVideoView.this.getCurrentPosition(), DKDefaultVideoView.this.getDuration());
                                try {
                                    LockMethodProxy.sleep(500L);
                                } catch (InterruptedException e16) {
                                    DLog.e(DKDefaultVideoView.TAG, "sleep error.", e16);
                                }
                            } catch (Throwable th5) {
                                DLog.e(DKDefaultVideoView.TAG, "timeUpdaterThread error.", th5);
                                return;
                            }
                        }
                    }
                });
                this.timeUpdaterThread.start();
            }
        }
    }

    private void initAudioManager() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        Context context = getContext();
        if (context != null) {
            try {
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
                this.mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.8
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this);
                        }
                    }

                    @Override // android.media.AudioManager.OnAudioFocusChangeListener
                    public void onAudioFocusChange(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, i3);
                            return;
                        }
                        DLog.i(DKDefaultVideoView.TAG, "onAudioFocusChange, focusChange: " + i3);
                    }
                };
                if (Build.VERSION.SDK_INT >= 26) {
                    this.mAudioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
                    audioAttributes = new AudioFocusRequest.Builder(1).setAudioAttributes(this.mAudioAttributes);
                    willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(true);
                    acceptsDelayedFocusGain = willPauseWhenDucked.setAcceptsDelayedFocusGain(true);
                    onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.mOnAudioFocusChangeListener);
                    build = onAudioFocusChangeListener.build();
                    this.mAudioFocusRequest = build;
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "init audioManager error.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo(String str) {
        boolean z16;
        DLog.i(TAG, "openVideo, path: " + str);
        if (str == null) {
            str = "";
        }
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null && audioManager.isMusicActive()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsMusicActiveInBackground = z16;
        super.setVideoPath(str);
        if (!this.mAutoPlay) {
            super.pause();
        }
    }

    private void registerVolumeReceiver() {
        Context context = getContext();
        if (this.mVolumeChangedReceiver == null && context != null) {
            VolumeChangedReceiver volumeChangedReceiver = new VolumeChangedReceiver(new OnVolumeChangedListener() { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this);
                    }
                }

                @Override // com.tencent.ams.dsdk.view.video.DKDefaultVideoView.OnVolumeChangedListener
                public void onVolumeChanged(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                        return;
                    }
                    if (DKDefaultVideoView.this.mAudioManager != null && DKDefaultVideoView.this.mOnVideoPlayListener != null && !DKDefaultVideoView.this.mIsMusicActiveInBackground) {
                        try {
                            float streamMaxVolume = DKDefaultVideoView.this.mAudioManager.getStreamMaxVolume(3);
                            float f16 = 0.0f;
                            if (streamMaxVolume != 0.0f) {
                                f16 = i3 / streamMaxVolume;
                            }
                            DLog.d(DKDefaultVideoView.TAG, "onVolumeChanged, volume: " + i3 + ", max: " + streamMaxVolume + ", v: " + f16);
                            if (f16 != i3) {
                                DKDefaultVideoView.this.mOnVideoPlayListener.onVolumeChange(f16);
                                DKDefaultVideoView.this.setVolume(f16);
                            }
                        } catch (Throwable th5) {
                            DLog.e(DKDefaultVideoView.TAG, "notify volume changed error.", th5);
                        }
                    }
                }
            });
            this.mVolumeChangedReceiver = volumeChangedReceiver;
            context.registerReceiver(volumeChangedReceiver, new IntentFilter(VOLUME_CHANGED_ACTION));
        }
    }

    private void requestAudioFocus() {
        int requestAudioFocus;
        DLog.i(TAG, "requestAudioFocus");
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null && !this.mHasAudioFocused) {
            if (Build.VERSION.SDK_INT >= 26) {
                requestAudioFocus = audioManager.requestAudioFocus(this.mAudioFocusRequest);
            } else {
                requestAudioFocus = audioManager.requestAudioFocus(this.mOnAudioFocusChangeListener, 3, 1);
            }
            if (requestAudioFocus == 1) {
                this.mIsMusicActiveInBackground = false;
                this.mHasAudioFocused = true;
            }
            DLog.i(TAG, "requestAudioFocus, result: " + requestAudioFocus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleObjectFit() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                float videoWidth = mediaPlayer.getVideoWidth();
                float videoHeight = this.mediaPlayer.getVideoHeight();
                if (videoHeight == 0.0f) {
                    return;
                }
                float width = getWidth();
                float height = getHeight();
                if (height == 0.0f) {
                    return;
                }
                float f16 = videoWidth / videoHeight;
                float f17 = width / height;
                if (f17 == 0.0f) {
                    return;
                }
                float f18 = f16 / f17;
                DLog.i(TAG, "scaleObjectFit, videoWidth: " + videoWidth + ", videoHeight: " + videoHeight + ", videoRatio: " + f16 + ", viewWidth: " + width + ", viewHeight: " + height + ", viewRatio: " + f17 + ", scaleX: " + f18);
                if (f18 >= 1.0f) {
                    DKVideoPlayer.ObjectFit objectFit = this.objectFit;
                    if (objectFit == DKVideoPlayer.ObjectFit.CONTAIN) {
                        setScaleX(1.0f);
                        setScaleY(1.0f / f18);
                    } else if (objectFit == DKVideoPlayer.ObjectFit.COVER) {
                        setScaleX(f18);
                        setScaleY(1.0f);
                    } else {
                        setScaleX(1.0f);
                        setScaleY(1.0f);
                    }
                } else {
                    DKVideoPlayer.ObjectFit objectFit2 = this.objectFit;
                    if (objectFit2 == DKVideoPlayer.ObjectFit.CONTAIN) {
                        setScaleX(f18);
                        setScaleY(1.0f);
                    } else if (objectFit2 == DKVideoPlayer.ObjectFit.COVER) {
                        setScaleX(1.0f);
                        setScaleY(1.0f / f18);
                    } else {
                        setScaleX(1.0f);
                        setScaleY(1.0f);
                    }
                }
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "scaleObjectFit error.", th5);
        }
    }

    private void unregisterVolumeReceiver() {
        Context context = getContext();
        try {
            VolumeChangedReceiver volumeChangedReceiver = this.mVolumeChangedReceiver;
            if (volumeChangedReceiver != null && context != null) {
                context.unregisterReceiver(volumeChangedReceiver);
                this.mVolumeChangedReceiver = null;
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "unregisterReceiver error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolume(float f16) {
        DLog.i(TAG, "updateVolume, volume: " + f16);
        if (this.mAudioManager != null) {
            try {
                DLog.d(TAG, "updateVolume, volume: " + f16);
                if (f16 > 0.0f && !this.mHasAudioFocused) {
                    requestAudioFocus();
                }
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.setVolume(f16, f16);
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "set volume error. volume: " + f16, th5);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.onAttachedToWindow();
            registerVolumeReceiver();
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        unregisterVolumeReceiver();
        abandonAudioFocus();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            DLog.i(TAG, "onMeasure");
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i3), View.getDefaultSize(getSuggestedMinimumHeight(), i16));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        DLog.i(TAG, "onSizeChanged, w: " + i3 + ", h: " + i16 + ", oldw: " + i17 + ", oldH: " + i18);
        super.onSizeChanged(i3, i16, i17, i18);
        scaleObjectFit();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        try {
            super.onWindowVisibilityChanged(i3);
        } catch (Throwable th5) {
            DLog.e(TAG, "onWindowVisibilityChanged error.", th5);
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl, com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DLog.d(TAG, "pause");
        super.pause();
        DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onPause();
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl, com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = this.mOnVideoPlayListener;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onSeeking(i3);
        }
        super.seekTo(i3);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        DLog.d(TAG, "setAutoPlay, autoPlay: " + z16);
        this.mAutoPlay = z16;
        if (z16) {
            start();
        }
    }

    @Override // android.view.View
    public void setKeepScreenOn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else if (Build.VERSION.SDK_INT < 26) {
            DynamicUtils.runOnUiThread(new Runnable(z16) { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$keepScreenOn;

                {
                    this.val$keepScreenOn = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DKDefaultVideoView.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKDefaultVideoView.super.setKeepScreenOn(this.val$keepScreenOn);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            super.setKeepScreenOn(z16);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        DLog.d(TAG, "setLoop, loop: " + z16);
        this.isLoop = z16;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setMute(boolean z16) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        DLog.d(TAG, "setMute, isMute: " + z16);
        this.isMute = z16;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        updateVolume(f16);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setObjectFit(DKVideoPlayer.ObjectFit objectFit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) objectFit);
            return;
        }
        DLog.d(TAG, "setObjectFit, objectFit: " + objectFit);
        this.objectFit = objectFit;
        scaleObjectFit();
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        DLog.i(TAG, "setVid, vid: " + str);
        VideoLoader videoLoader = this.mVideoLoader;
        if (videoLoader != null) {
            videoLoader.loadVideoByVid(str, new VideoLoader.VideoLoadListener() { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this);
                    }
                }

                @Override // com.tencent.ams.dsdk.view.video.VideoLoader.VideoLoadListener
                public void onLoadFinish(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str2);
                        return;
                    }
                    DLog.i(DKDefaultVideoView.TAG, "vid onLoadFinish, videoPath: " + str2);
                    DKDefaultVideoView.this.openVideo(str2);
                }

                @Override // com.tencent.ams.dsdk.view.video.VideoLoader.VideoLoadListener
                public void onLoadStart() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DLog.i(DKDefaultVideoView.TAG, "vid load video start");
                    }
                }
            });
        } else {
            Log.w(TAG, "not support vid play");
            openVideo("");
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoParams(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) jSONObject);
        }
    }

    @Override // android.widget.VideoView, com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        DLog.i(TAG, "setVideoPath, videoPath: " + str);
        VideoLoader videoLoader = this.mVideoLoader;
        if (videoLoader == null) {
            openVideo(str);
        } else {
            DLog.i(TAG, "load video by video loader");
            videoLoader.loadVideoByUrl(str, new VideoLoader.VideoLoadListener() { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this);
                    }
                }

                @Override // com.tencent.ams.dsdk.view.video.VideoLoader.VideoLoadListener
                public void onLoadFinish(String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) str2);
                        return;
                    }
                    DLog.i(DKDefaultVideoView.TAG, "url onLoadFinish, videoPath: " + str2);
                    DKDefaultVideoView.this.openVideo(str2);
                }

                @Override // com.tencent.ams.dsdk.view.video.VideoLoader.VideoLoadListener
                public void onLoadStart() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DLog.i(DKDefaultVideoView.TAG, "url load video start");
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoPlayListener(DKVideoPlayer.OnVideoPlayListener onVideoPlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onVideoPlayListener);
            return;
        }
        this.mOnVideoPlayListener = onVideoPlayListener;
        setOnPreparedListener(new MediaPlayer.OnPreparedListener(onVideoPlayListener) { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DKVideoPlayer.OnVideoPlayListener val$onVideoPlayListener;

            {
                this.val$onVideoPlayListener = onVideoPlayListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this, (Object) onVideoPlayListener);
                }
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                float f16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                    return;
                }
                DLog.d(DKDefaultVideoView.TAG, "onPrepared, isMute: " + DKDefaultVideoView.this.isMute + ", isLoop: " + DKDefaultVideoView.this.isLoop);
                DKDefaultVideoView.this.mediaPlayer = mediaPlayer;
                if (mediaPlayer != null) {
                    try {
                        DLog.i(DKDefaultVideoView.TAG, "videoWidth: " + DKDefaultVideoView.this.mediaPlayer.getVideoWidth() + ", videoHeight: " + DKDefaultVideoView.this.mediaPlayer.getVideoHeight());
                        DKDefaultVideoView dKDefaultVideoView = DKDefaultVideoView.this;
                        if (dKDefaultVideoView.isMute) {
                            f16 = 0.0f;
                        } else {
                            f16 = 1.0f;
                        }
                        dKDefaultVideoView.updateVolume(f16);
                        DKDefaultVideoView.this.mediaPlayer.setLooping(false);
                        DKDefaultVideoView.this.scaleObjectFit();
                    } catch (Throwable th5) {
                        DLog.e(DKDefaultVideoView.TAG, "prepared handler error.", th5);
                    }
                }
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener2 = this.val$onVideoPlayListener;
                if (onVideoPlayListener2 != null) {
                    onVideoPlayListener2.onReady();
                }
                if (mediaPlayer != null) {
                    mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer2) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) mediaPlayer2);
                                return;
                            }
                            DLog.d(DKDefaultVideoView.TAG, "onSeekComplete.");
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            DKVideoPlayer.OnVideoPlayListener onVideoPlayListener3 = anonymousClass1.val$onVideoPlayListener;
                            if (onVideoPlayListener3 != null) {
                                onVideoPlayListener3.onSeeked(DKDefaultVideoView.this.getCurrentPosition());
                            }
                        }
                    });
                }
                if (mediaPlayer != null) {
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.1.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.media.MediaPlayer.OnInfoListener
                        public boolean onInfo(MediaPlayer mediaPlayer2, int i3, int i16) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                return ((Boolean) iPatchRedirector3.redirect((short) 2, this, mediaPlayer2, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                            }
                            DLog.d(DKDefaultVideoView.TAG, "onInfo, what: " + i3 + ", extra: " + i16);
                            if (i3 != 3) {
                                if (i3 == 701) {
                                    DLog.d(DKDefaultVideoView.TAG, "onInfo, media info buffering start.");
                                    if (DKDefaultVideoView.this.mOnVideoPlayListener != null) {
                                        DKDefaultVideoView.this.mOnVideoPlayListener.onWaiting();
                                    }
                                }
                            } else {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                DKDefaultVideoView.this.callOnPlay(anonymousClass1.val$onVideoPlayListener);
                            }
                            return true;
                        }
                    });
                }
            }
        });
        setOnCompletionListener(new MediaPlayer.OnCompletionListener(onVideoPlayListener) { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ DKVideoPlayer.OnVideoPlayListener val$onVideoPlayListener;

            {
                this.val$onVideoPlayListener = onVideoPlayListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this, (Object) onVideoPlayListener);
                }
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                    return;
                }
                DLog.d(DKDefaultVideoView.TAG, "onCompletion");
                DKDefaultVideoView.this.mLastPlayCompleted = true;
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener2 = this.val$onVideoPlayListener;
                if (onVideoPlayListener2 != null) {
                    onVideoPlayListener2.onEnded();
                }
                if (!DKDefaultVideoView.this.isLoop) {
                    DKDefaultVideoView.this.abandonAudioFocus();
                    return;
                }
                DKDefaultVideoView.this.start();
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener3 = this.val$onVideoPlayListener;
                if (onVideoPlayListener3 != null) {
                    onVideoPlayListener3.onPlay();
                    DLog.d(DKDefaultVideoView.TAG, "onPlay: onCompletion restart");
                }
            }
        });
        setOnErrorListener(new MediaPlayer.OnErrorListener(onVideoPlayListener) { // from class: com.tencent.ams.dsdk.view.video.DKDefaultVideoView.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ DKVideoPlayer.OnVideoPlayListener val$onVideoPlayListener;

            {
                this.val$onVideoPlayListener = onVideoPlayListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKDefaultVideoView.this, (Object) onVideoPlayListener);
                }
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
                }
                DLog.i(DKDefaultVideoView.TAG, "onError, what: " + i3 + ", extra: " + i16);
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener2 = this.val$onVideoPlayListener;
                if (onVideoPlayListener2 != null) {
                    onVideoPlayListener2.onError(i3, String.valueOf(i16));
                }
                DKDefaultVideoView.this.abandonAudioFocus();
                return true;
            }
        });
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mVolume = f16;
            updateVolume(f16);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.stopPlayback();
            DLog.d(TAG, "stop");
        }
    }
}
