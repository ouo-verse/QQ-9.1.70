package com.tencent.mobileqq.qzoneplayer.ui;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.PlayerCallBack;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.model.VideoInfo;
import com.tencent.oskplayer.player.ISegmentMediaPlayer;
import com.tencent.oskplayer.player.SegmentMediaPlayer;
import com.tencent.oskplayer.player.StateMediaPlayer;
import com.tencent.oskplayer.player.StateSegmentMediaPlayer;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.ThreadUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: P */
/* loaded from: classes35.dex */
public class QZoneVideoView extends FrameLayout implements IMediaPlayer.OnPreparedListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnVideoSizeChangedListener, IMediaPlayer.OnSeekCompleteListener, VideoProxy.HttpErrorListener {
    private View C;
    private ImageView D;
    private ProgressBar E;
    private ImageView F;
    private VideoInfo G;
    private boolean H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    private int M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private String f279545a0;

    /* renamed from: b0, reason: collision with root package name */
    private HttpRetryLogic f279546b0;

    /* renamed from: c0, reason: collision with root package name */
    private VideoControllerView.OnControllerEventListener f279547c0;

    /* renamed from: d, reason: collision with root package name */
    private Activity f279548d;

    /* renamed from: d0, reason: collision with root package name */
    private GestureDetector f279549d0;

    /* renamed from: e, reason: collision with root package name */
    private View f279550e;

    /* renamed from: e0, reason: collision with root package name */
    private VideoControllerView.MediaPlayerControl f279551e0;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceView f279552f;

    /* renamed from: f0, reason: collision with root package name */
    private Handler f279553f0;

    /* renamed from: h, reason: collision with root package name */
    private StateSegmentMediaPlayer f279554h;

    /* renamed from: i, reason: collision with root package name */
    private VideoControllerView f279555i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f279556m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class GetCurrentPositionRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f279559d;
        final /* synthetic */ QZoneVideoView this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f279559d = this.this$0.f279554h.getCurrentPosition();
            } catch (NullPointerException unused) {
                this.f279559d = 0L;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface f {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface g {
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface h {
    }

    private void d(SurfaceHolder surfaceHolder) {
        this.E.setVisibility(0);
        this.H = false;
        this.I = false;
        this.W = false;
        VideoControllerView videoControllerView = this.f279555i;
        if (videoControllerView != null) {
            videoControllerView.setEnabled(false);
            this.f279555i.postSetProgress();
        }
        this.K = true;
        StateSegmentMediaPlayer stateSegmentMediaPlayer = new StateSegmentMediaPlayer(new SegmentMediaPlayer(), false);
        this.f279554h = stateSegmentMediaPlayer;
        stateSegmentMediaPlayer.setAudioStreamType(3);
        String currentStreamUrl = this.G.getCurrentStreamUrl();
        SegmentVideoInfo.StreamInfo streamInfo = new SegmentVideoInfo.StreamInfo();
        streamInfo.streamType = 0;
        streamInfo.addSegmentInfo(currentStreamUrl, 0);
        if (TextUtils.isEmpty(currentStreamUrl)) {
            return;
        }
        try {
            this.f279554h.setDataSource(streamInfo);
            this.f279545a0 = this.f279554h.getCurrentProxySegmentUrl();
            this.f279554h.setOnPreparedListener(this);
            this.f279554h.setOnVideoSizeChangedListener(this);
            this.f279554h.setOnBufferingUpdateListener(this);
            this.f279554h.setOnErrorListener(this);
            this.f279554h.setOnCompletionListener(this);
            this.f279554h.setOnInfoListener(this);
            this.f279554h.setOnSeekCompleteListener(this);
            VideoManager.getInstance().addHttpErrorListener(this.G.getCurrentStreamUrl(), this);
            VideoManager.getInstance().addHttpRetryLogic(this.G.getCurrentStreamUrl(), this.f279546b0);
            while (!this.V) {
                try {
                    LockMethodProxy.sleep(10L);
                } catch (InterruptedException unused) {
                }
            }
            try {
                this.f279554h.setDisplay(surfaceHolder);
                this.f279554h.prepareAsync();
                Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
                if (callbacks != null) {
                    for (PlayerCallBack playerCallBack : callbacks) {
                        playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_PREPARE, "video prepare async", this.G);
                    }
                }
                this.f279553f0.sendEmptyMessageDelayed(1, 30000L);
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
        } catch (IOException e17) {
            PlayerUtils.log(6, "QZoneVideoView", PlayerUtils.getPrintableStackTrace(e17));
        }
    }

    public void c() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public void e() {
        PlayerUtils.log(4, "QZoneVideoView", "stopPlayback");
        if (this.f279554h != null) {
            ThreadUtils.submitTaskCatchAll(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.ui.QZoneVideoView.3

                /* renamed from: d, reason: collision with root package name */
                final ISegmentMediaPlayer f279557d;

                {
                    this.f279557d = QZoneVideoView.this.f279554h;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ISegmentMediaPlayer iSegmentMediaPlayer = this.f279557d;
                    if (iSegmentMediaPlayer != null) {
                        iSegmentMediaPlayer.stop();
                        this.f279557d.reset();
                        this.f279557d.release();
                    }
                }
            }, 100, false, "release mediaplayer");
            this.f279554h = null;
            Handler handler = this.f279553f0;
            if (handler != null) {
                handler.removeMessages(1);
            }
            Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
            if (callbacks != null) {
                for (PlayerCallBack playerCallBack : callbacks) {
                    playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_STOP, "video stopped", this.G);
                }
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i3) {
        this.J = i3;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i3, int i16) {
        String str;
        String str2 = "!";
        if (i3 == 1) {
            str = "MEDIA_ERROR_UNKNOWN";
        } else if (i3 != 100) {
            str = "!";
        } else {
            str = "MEDIA_ERROR_SERVER_DIED";
        }
        if (i16 == -1010) {
            str2 = "MEDIA_ERROR_UNSUPPORTED";
        } else if (i16 == -1007) {
            str2 = "MEDIA_ERROR_MALFORMED";
        } else if (i16 == -1004) {
            str2 = "MEDIA_ERROR_IO";
        } else if (i16 == -110) {
            str2 = "MEDIA_ERROR_TIMED_OUT";
        }
        if (i16 == -1007) {
            e();
        }
        String format = String.format("what:%d,%s extra:%d,%s", Integer.valueOf(i3), str, Integer.valueOf(i16), str2);
        PlayerUtils.log(4, "QZoneVideoView", "onErrorListener " + format);
        Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
        if (callbacks != null) {
            for (PlayerCallBack playerCallBack : callbacks) {
                playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_ERROR, format, this.G);
            }
        }
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i16) {
        PlayerUtils.log(4, "QZoneVideoView", "onInfo: what=" + i3 + " extra=" + i16);
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int defaultSize = View.getDefaultSize(this.L, i3);
        int defaultSize2 = View.getDefaultSize(this.M, i16);
        int i18 = this.L;
        if (i18 > 0 && (i17 = this.M) > 0) {
            if (i18 * defaultSize2 > defaultSize * i17) {
                defaultSize2 = (i17 * defaultSize) / i18;
            } else if (i18 * defaultSize2 < defaultSize * i17) {
                defaultSize = (i18 * defaultSize2) / i17;
            }
            ViewGroup.LayoutParams layoutParams = this.f279550e.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            this.f279550e.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f279556m.getLayoutParams();
            layoutParams2.height = defaultSize2;
            layoutParams2.width = defaultSize;
            this.f279556m.setLayoutParams(layoutParams2);
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        super.onMeasure(i3, i16);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        PlayerUtils.log(3, "QZoneVideoView", "onPrepared is called");
        this.E.setVisibility(8);
        this.f279553f0.removeMessages(1);
        this.I = true;
        this.K = false;
        this.f279555i.setMediaPlayer(this.f279551e0);
        this.f279555i.setAnchorView((RelativeLayout) this.f279550e);
        this.f279555i.setEnabled(true);
        this.f279554h.setVolume(1.0f, 1.0f);
        try {
            if (this.f279554h.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_START)) {
                this.f279554h.start();
            }
        } catch (IMediaPlayer.InternalOperationException e16) {
            PlayerUtils.log(6, "QZoneVideoView", e16.toString());
        }
        PlayerUtils.log(3, "QZoneVideoView", "player.start()");
        if (this.H) {
            this.f279554h.seekTo(this.G.getCurrentPosition());
        }
        if (!this.P) {
            try {
                this.f279554h.pause();
            } catch (IMediaPlayer.InternalOperationException e17) {
                PlayerUtils.log(6, "QZoneVideoView", e17.toString());
            }
        }
        this.f279555i.postSetProgress();
        this.f279555i.updatePausePlay();
        this.f279555i.updateFullScreen();
        this.f279555i.updateLandscapeIndicator();
        this.f279555i.hide();
        c();
        Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
        if (callbacks != null) {
            for (PlayerCallBack playerCallBack : callbacks) {
                playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_START, "video start", this.G);
            }
        }
        if (this.P) {
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.ui.QZoneVideoView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneVideoView.this.f279551e0 != null) {
                        QZoneVideoView.this.f279551e0.start();
                    }
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f279549d0.onTouchEvent(motionEvent);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i16) {
        StateSegmentMediaPlayer stateSegmentMediaPlayer;
        PlayerUtils.log(3, "QZoneVideoView", "onVideoSizeChanged called");
        this.L = i3;
        this.M = i16;
        if (i3 != 0 && i16 != 0) {
            this.H = true;
            if (!this.I || (stateSegmentMediaPlayer = this.f279554h) == null) {
                return;
            }
            stateSegmentMediaPlayer.seekTo(this.G.getCurrentPosition());
            return;
        }
        PlayerUtils.log(3, "QZoneVideoView", "invalid video width(" + i3 + ") or height(" + i16 + ")");
    }

    public void setEnableBackButton(Activity activity, boolean z16) {
        this.f279548d = activity;
        this.S = z16;
        ImageView imageView = this.D;
        if (imageView != null) {
            imageView.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setEnableGesture(boolean z16) {
        this.Q = z16;
    }

    public void setEnableToggleFullscreen(boolean z16) {
        this.T = z16;
    }

    public void setEnableToggleLandscape(boolean z16) {
        this.U = z16;
    }

    public void setEnableTopBar(boolean z16) {
        this.R = z16;
    }

    public void setIsAutoStart(boolean z16) {
        this.P = z16;
    }

    public void setIsLandscape(boolean z16) {
        this.N = z16;
        VideoControllerView videoControllerView = this.f279555i;
        if (videoControllerView != null) {
            videoControllerView.updateLandscapeIndicator();
        }
    }

    public void setOnControllerEventListener(VideoControllerView.OnControllerEventListener onControllerEventListener) {
        this.f279547c0 = onControllerEventListener;
    }

    public void setVideoInfo(VideoInfo videoInfo, boolean z16) {
        if (this.G != null) {
            e();
        }
        this.G = videoInfo;
        this.P = z16;
        try {
            VideoInfo.validate(videoInfo);
            this.f279555i.setCurrentStreamName(this.G.getDefaultStreamName());
            this.f279555i.setSeekBarrier(this.G.getDurationAllow());
            PlayerUtils.log(3, "QZoneVideoView", "setVideoInfo: isSurfaceCreated=" + this.V);
            if (this.V) {
                d(this.f279552f.getHolder());
            }
        } catch (IllegalArgumentException e16) {
            PlayerUtils.log(6, "QZoneVideoView", "Illegal video info : " + e16.getMessage());
            Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
            if (callbacks != null) {
                for (PlayerCallBack playerCallBack : callbacks) {
                    playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_ERROR, e16.getMessage(), this.G);
                }
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        PlayerUtils.log(4, "QZoneVideoView", "play complete");
        this.W = true;
        Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
        if (callbacks != null) {
            for (PlayerCallBack playerCallBack : callbacks) {
                playerCallBack.onMediaEvent(playerCallBack, PlayerCallBack.EVENT_PLAY_COMPLETE, "play complete", this.G);
            }
        }
    }

    @Override // com.tencent.oskplayer.proxy.VideoProxy.HttpErrorListener
    public void onHttpError(String str, String str2, int i3, Map<String, Object> map, Map<String, List<String>> map2, int i16, long j3, long j16) {
        Set<PlayerCallBack> callbacks = PlayerConfig.g().getCallbacks();
        String str3 = map != null ? (String) map.get("error_msg") : null;
        if (!TextUtils.isEmpty(str3)) {
            PlayerUtils.log(6, "QZoneVideoView", "\u89c6\u9891\u64ad\u653e\u5931\u8d25," + str3);
        } else {
            PlayerUtils.log(6, "QZoneVideoView", "\u6570\u636e\u4e0b\u8f7d\u51fa\u9519\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u6216\u5237\u65b0\u91cd\u8bd5(" + i3 + ")");
        }
        if (callbacks != null) {
            for (PlayerCallBack playerCallBack : callbacks) {
                playerCallBack.onHttpDownloadError(playerCallBack, str, str2, i3, str3, map2, i16, j3, j16);
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
    }

    public void setOnBufferingUpdateListener(a aVar) {
    }

    public void setOnCompletionListener(b bVar) {
    }

    public void setOnErrorListener(c cVar) {
    }

    public void setOnInfoListener(d dVar) {
    }

    public void setOnPreparedListener(e eVar) {
    }

    public void setOnSeekCompleteListener(f fVar) {
    }

    public void setOnSetDataSourceListener(g gVar) {
    }

    public void setOnVideoSizeChangedListener(h hVar) {
    }
}
