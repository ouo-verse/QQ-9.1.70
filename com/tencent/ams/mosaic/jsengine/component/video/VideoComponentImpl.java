package com.tencent.ams.mosaic.jsengine.component.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.container.Container;
import com.tencent.ams.mosaic.jsengine.component.video.a;
import com.tencent.ams.mosaic.jsengine.component.view.NetworkImageView;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoComponentImpl extends BasicComponent implements VideoComponent, SurfaceHolder.Callback, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnInfoListener, a.InterfaceC0694a {
    static IPatchRedirector $redirector_;
    private FrameLayout C;
    private VideoContainerView D;
    private VideoSurfaceView E;
    private NetworkImageView F;
    private com.tencent.ams.mosaic.jsengine.component.video.a G;
    private b H;
    private int I;
    private int J;
    private boolean K;
    private String L;
    private int M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private String S;
    private boolean T;
    private int U;
    private boolean V;

    /* renamed from: d, reason: collision with root package name */
    private int f71364d;

    /* renamed from: e, reason: collision with root package name */
    private Context f71365e;

    /* renamed from: f, reason: collision with root package name */
    private MediaPlayer f71366f;

    /* renamed from: h, reason: collision with root package name */
    private JSFunction f71367h;

    /* renamed from: i, reason: collision with root package name */
    private JSFunction f71368i;

    /* renamed from: m, reason: collision with root package name */
    private JSFunction f71369m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayEventType {
        public static final int IDLE = 0;
        public static final int PLAY_COMPLETE = 2;
        public static final int PLAY_ERROR = 3;
        public static final int PLAY_PAUSE = 4;
        public static final int PLAY_START = 1;
        public static final int PREPARED = 6;
        public static final int PREPARING = 5;
        public static final int RENDER_START = 8;
        public static final int STOPPED = 7;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayerState {
        public static final int STATE_COMPLETED = 5;
        public static final int STATE_ERROR = -1;
        public static final int STATE_IDLE = 0;
        public static final int STATE_PAUSED = 4;
        public static final int STATE_PLAYING = 3;
        public static final int STATE_PREPARED = 2;
        public static final int STATE_PREPARING = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements f.InterfaceC0685f.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoComponentImpl.this);
            }
        }

        @Override // com.tencent.ams.mosaic.f.InterfaceC0685f.a
        public void onLoadFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "load video finish: " + str);
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                VideoComponentImpl.this.a0(3);
            } else {
                VideoComponentImpl.this.Y(str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.InterfaceC0685f.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "load video start");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<VideoComponentImpl> f71371a;

        b(VideoComponentImpl videoComponentImpl) {
            super(Looper.getMainLooper());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) videoComponentImpl);
            } else {
                this.f71371a = new WeakReference<>(videoComponentImpl);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.tencent.ams.mosaic.jsengine.component.video.a controllerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            VideoComponentImpl videoComponentImpl = this.f71371a.get();
            if (videoComponentImpl == null || (controllerView = videoComponentImpl.getControllerView()) == null) {
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        super.handleMessage(message);
                        return;
                    } else {
                        controllerView.setTotalTime(videoComponentImpl.getDuration());
                        return;
                    }
                }
                int currentPosition = videoComponentImpl.getCurrentPosition();
                videoComponentImpl.setSavedPosition(currentPosition);
                controllerView.setCurrentTime(currentPosition);
                sendEmptyMessageDelayed(2, 50L);
                return;
            }
            videoComponentImpl.setControllerVisible(false);
        }
    }

    public VideoComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f71364d = 0;
        this.S = "fitXY";
        this.U = 0;
        I(context);
    }

    private com.tencent.ams.mosaic.jsengine.component.video.a D() {
        Class<? extends com.tencent.ams.mosaic.jsengine.component.video.a> r16 = com.tencent.ams.mosaic.f.k().r();
        if (r16 != null) {
            try {
                com.tencent.ams.mosaic.jsengine.component.video.a newInstance = r16.getConstructor(new Class[0]).newInstance(new Object[0]);
                com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "createControllerViewFromOutSide success");
                return newInstance;
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.i("VideoComponentImpl", "createControllerViewFromOutSide failed", th5);
                return null;
            }
        }
        return null;
    }

    private VideoContainerView E(Context context) {
        VideoContainerView videoContainerView = new VideoContainerView(context);
        videoContainerView.setBackgroundColor(-16777216);
        videoContainerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.mosaic.jsengine.component.video.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoComponentImpl.K(view);
            }
        });
        return videoContainerView;
    }

    private Configuration F() {
        Resources resources;
        Context context = this.f71365e;
        if (context != null && (resources = context.getResources()) != null) {
            return resources.getConfiguration();
        }
        return null;
    }

    private ImageView.ScaleType G() {
        if (TextUtils.isEmpty(this.S)) {
            return ImageView.ScaleType.FIT_XY;
        }
        String str = this.S;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    c16 = 1;
                    break;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    c16 = 2;
                    break;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    c16 = 3;
                    break;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return ImageView.ScaleType.CENTER;
            case 1:
                return ImageView.ScaleType.FIT_END;
            case 2:
                return ImageView.ScaleType.FIT_START;
            case 3:
                return ImageView.ScaleType.CENTER_INSIDE;
            case 4:
                return ImageView.ScaleType.FIT_XY;
            case 5:
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return ImageView.ScaleType.FIT_CENTER;
        }
    }

    private com.tencent.ams.mosaic.jsengine.component.video.a H() {
        com.tencent.ams.mosaic.jsengine.component.video.a D = D();
        if (D == null) {
            D = new VideoControllerView(this.C.getContext());
        }
        D.setControllerViewListener(this);
        D.setMute(this.R);
        return D;
    }

    private void I(Context context) {
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "initVideoView");
        try {
            this.f71365e = context;
            this.C = new FrameLayout(context);
            this.E = new VideoSurfaceView(context);
            this.D = E(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.D.addView(this.E, layoutParams);
            this.C.addView(this.D, new FrameLayout.LayoutParams(-1, -1));
            SurfaceHolder holder = this.E.getHolder();
            holder.addCallback(this);
            holder.setKeepScreenOn(true);
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.f71366f = reportMediaPlayer;
            reportMediaPlayer.setAudioStreamType(3);
            this.f71366f.setOnCompletionListener(this);
            this.f71366f.setOnErrorListener(this);
            this.f71366f.setOnVideoSizeChangedListener(this);
            this.f71366f.setOnPreparedListener(this);
            this.f71366f.setOnInfoListener(this);
            NetworkImageView networkImageView = new NetworkImageView(this.f71365e);
            networkImageView.setScaleType(G());
            this.C.addView(networkImageView, new FrameLayout.LayoutParams(-1, -1));
            this.F = networkImageView;
        } catch (Exception e16) {
            com.tencent.ams.mosaic.utils.f.h("VideoComponentImpl", "initVideoView --> failed! exception = " + e16.getMessage());
        }
    }

    private boolean J() {
        int i3;
        if (this.f71366f != null && (i3 = this.f71364d) != -1 && i3 != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(int i3, int i16) {
        this.G.onVideoSizeChanged(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        com.tencent.ams.mosaic.jsengine.component.video.a aVar = this.G;
        if (aVar != null) {
            aVar.setPaused(true);
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        com.tencent.ams.mosaic.jsengine.component.video.a aVar = this.G;
        if (aVar != null) {
            aVar.setPaused(true);
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        com.tencent.ams.mosaic.jsengine.component.video.a aVar = this.G;
        if (aVar != null) {
            aVar.setPaused(false);
            f0();
        }
        NetworkImageView networkImageView = this.F;
        if (networkImageView != null) {
            networkImageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(boolean z16, int i3, MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        if (z16 && (mediaPlayer2 = this.f71366f) != null) {
            mediaPlayer2.start();
            b0(i3);
            this.f71364d = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(final int i3, final boolean z16) {
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "seekTo position: " + i3);
        try {
            this.f71366f.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.ams.mosaic.jsengine.component.video.e
                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public final void onSeekComplete(MediaPlayer mediaPlayer) {
                    VideoComponentImpl.this.P(z16, i3, mediaPlayer);
                }
            });
            if (Build.VERSION.SDK_INT >= 26) {
                this.f71366f.seekTo(i3, 3);
            } else {
                this.f71366f.seekTo(i3);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(boolean z16) {
        if (z16) {
            if (this.G == null) {
                this.G = H();
                this.H = new b(this);
                this.C.addView(this.G.getView(), this.C.getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
            }
            this.G.setVisibility(0);
            return;
        }
        com.tencent.ams.mosaic.jsengine.component.video.a aVar = this.G;
        if (aVar != null) {
            aVar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(boolean z16) {
        boolean z17;
        if (z16 == this.T) {
            com.tencent.ams.mosaic.utils.f.h("VideoComponentImpl", "setFullScreen cancel: fullScreen status not change");
            return;
        }
        this.T = z16;
        Container rootView = getJSEngine().d().getRootView();
        if (rootView != null && (rootView.getView() instanceof ViewGroup)) {
            if (z16) {
                Context context = this.f71365e;
                VideoContainerView videoContainerView = this.D;
                com.tencent.ams.mosaic.jsengine.component.video.a aVar = this.G;
                ViewGroup viewGroup = (ViewGroup) rootView.getView();
                FrameLayout frameLayout = this.C;
                if (this.U == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                s.b(context, videoContainerView, aVar, viewGroup, frameLayout, z17);
                getJSEngine().g().b(new com.tencent.ams.mosaic.g("onVideoSwitchToFullscreen"));
                getJSEngine().u(this.f71368i, new Object[0], null);
                return;
            }
            s.d(this.f71365e, this.D, this.G, (ViewGroup) rootView.getView(), this.C);
            getJSEngine().g().b(new com.tencent.ams.mosaic.g("onVideoSwitchToSmallScreen"));
            getJSEngine().u(this.f71369m, new Object[0], null);
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("VideoComponentImpl", "setFullScreen failed: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(JSFunction jSFunction) {
        if (this.mViewClickListener == null) {
            this.mViewClickListener = new ComponentBase.a(this);
        }
        this.mViewClickListener.b(jSFunction);
        VideoSurfaceView videoSurfaceView = this.E;
        if (videoSurfaceView != null) {
            videoSurfaceView.setOnClickListener(this.mViewClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(JSFunction jSFunction) {
        if (this.mViewClickListener == null) {
            this.mViewClickListener = new ComponentBase.a(this);
        }
        this.mViewClickListener.c(jSFunction);
        VideoSurfaceView videoSurfaceView = this.E;
        if (videoSurfaceView != null) {
            videoSurfaceView.setOnTouchListener(this.mViewClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(String str) {
        if (this.S != str) {
            this.S = str;
            NetworkImageView networkImageView = this.F;
            if (networkImageView != null) {
                networkImageView.setScaleType(G());
            }
            this.E.setScaleType(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = this.f71366f;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
    }

    private void X() {
        com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "openVideo");
        if (this.L != null) {
            getVideoLoader().loadVideo(this.L, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str) {
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "openVideo: " + str);
        try {
            this.f71366f.reset();
            this.f71366f.setDataSource(this.f71365e, Uri.parse(str));
            if ("fitXY".equals(this.S)) {
                this.f71366f.setVideoScalingMode(1);
            } else {
                this.f71366f.setVideoScalingMode(2);
            }
            this.f71366f.setLooping(false);
            this.f71366f.prepareAsync();
            this.f71364d = 1;
        } catch (Exception e16) {
            com.tencent.ams.mosaic.utils.f.c("VideoComponentImpl", "play failed", e16);
            a0(4);
        }
    }

    private void Z() {
        com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "publishComplete");
        if (this.f71367h != null) {
            callbackJsPlayEvent(2, 0);
        }
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoComponentImpl.this.M();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i3) {
        com.tencent.ams.mosaic.utils.f.h("VideoComponentImpl", "publishError: " + i3);
        if (this.f71367h != null) {
            callbackJsPlayEvent(3, i3);
        }
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.k
            @Override // java.lang.Runnable
            public final void run() {
                VideoComponentImpl.this.N();
            }
        });
    }

    private void b0(int i3) {
        com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "publishStart: " + i3);
        if (this.f71367h != null) {
            callbackJsPlayEvent(1, 0);
        }
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.g
            @Override // java.lang.Runnable
            public final void run() {
                VideoComponentImpl.this.O();
            }
        });
    }

    private void c0(Configuration configuration) {
        MediaPlayer mediaPlayer;
        VideoSurfaceView videoSurfaceView = this.E;
        if (videoSurfaceView != null && (mediaPlayer = this.f71366f) != null) {
            videoSurfaceView.setVideoSize(mediaPlayer.getVideoWidth(), this.f71366f.getVideoHeight());
        }
    }

    private void callbackJsPlayEvent(int i3, int i16) {
        if (this.f71367h != null) {
            getJSEngine().u(this.f71367h, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}, null);
        }
    }

    private void d0() {
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "releaseVideoResource");
        MediaPlayer mediaPlayer = this.f71366f;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f71366f.release();
                this.f71366f.setOnPreparedListener(null);
                this.f71366f.setOnCompletionListener(null);
                this.f71366f.setOnErrorListener(null);
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.c("VideoComponentImpl", "releaseVideoResource, media player stop error.", th5);
            }
            this.f71366f = null;
        }
        b bVar = this.H;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
    }

    private void e0(int i3) {
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "start position: " + i3);
        try {
            if (i3 > 0) {
                this.f71366f.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.ams.mosaic.jsengine.component.video.f
                    @Override // android.media.MediaPlayer.OnSeekCompleteListener
                    public final void onSeekComplete(MediaPlayer mediaPlayer) {
                        VideoComponentImpl.this.W(mediaPlayer);
                    }
                });
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f71366f.seekTo(i3, 3);
                } else {
                    this.f71366f.seekTo(i3);
                }
            } else {
                this.f71366f.start();
            }
            b0(i3);
            this.f71364d = 3;
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("VideoComponentImpl", "start failed", th5);
        }
    }

    private void f0() {
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "startUpdateControllerProgress");
        b bVar = this.H;
        if (bVar != null) {
            bVar.sendEmptyMessage(3);
            this.H.sendEmptyMessage(2);
        }
    }

    private void g0() {
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "stopUpdateControllerProgress");
        b bVar = this.H;
        if (bVar != null) {
            bVar.removeMessages(2);
        }
    }

    public com.tencent.ams.mosaic.jsengine.component.video.a getControllerView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (com.tencent.ams.mosaic.jsengine.component.video.a) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.G;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        if (J()) {
            return this.f71366f.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        if (J()) {
            return this.f71366f.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.C;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public boolean isFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.T;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (J()) {
            return this.f71366f.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a.InterfaceC0694a
    public void onBackClick(@NonNull com.tencent.ams.mosaic.jsengine.component.video.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) aVar);
        } else {
            com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onBackClick");
            setFullScreen(false);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) mediaPlayer);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onCompletion");
        if (this.f71364d == 5) {
            return;
        }
        this.f71364d = 5;
        this.M = 0;
        Z();
        if (this.Q) {
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        com.tencent.ams.mosaic.utils.f.h("VideoComponentImpl", String.format(Locale.getDefault(), "onError: what-%d, extra-%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        if (this.f71364d == 5) {
            return true;
        }
        this.f71364d = -1;
        if (!MosaicUtils.u(this.f71365e)) {
            a0(1);
        } else if (i3 == 1) {
            a0(2);
        } else {
            a0(4);
        }
        return true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a.InterfaceC0694a
    public void onFullScreenClick(@NonNull com.tencent.ams.mosaic.jsengine.component.video.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) aVar);
        } else {
            setFullScreen(!this.T);
        }
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onInfo what:" + i3 + ", extra:" + i16);
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a.InterfaceC0694a
    public void onMuteClick(@NonNull com.tencent.ams.mosaic.jsengine.component.video.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) aVar);
        } else {
            setOutputMute(!this.R);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a.InterfaceC0694a
    public void onPlayClick(@NonNull com.tencent.ams.mosaic.jsengine.component.video.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) aVar);
            return;
        }
        int i3 = this.f71364d;
        if (i3 == 3) {
            pause();
            this.P = false;
        } else if (i3 == 4 || i3 == 5) {
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) mediaPlayer);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onPrepared");
        this.f71364d = 2;
        MediaPlayer mediaPlayer2 = this.f71366f;
        if (mediaPlayer2 != null && !mediaPlayer2.isPlaying()) {
            if (this.N || this.P) {
                com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onPrepared seekTo:" + this.M);
                e0(this.M);
                b0(this.M);
                this.f71364d = 3;
                this.M = 0;
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a.InterfaceC0694a
    public void onProgressSeeking(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, i3);
        } else {
            seekTo(i3, !this.V);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a.InterfaceC0694a
    public void onStartProgressSeek(@NonNull com.tencent.ams.mosaic.jsengine.component.video.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onStartProgressSeek");
        this.V = true;
        g0();
        if (isPlaying()) {
            pause();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.a.InterfaceC0694a
    public void onStopProgressSeek(@NonNull com.tencent.ams.mosaic.jsengine.component.video.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) aVar, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onStopProgressSeek position: " + i3);
        this.V = false;
        seekTo(i3);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i3, final int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "onVideoSizeChanged width: " + i3 + ", height: " + i16);
        c0(F());
        if (this.G != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.m
                @Override // java.lang.Runnable
                public final void run() {
                    VideoComponentImpl.this.L(i3, i16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "pause");
        if (J()) {
            this.f71366f.pause();
            this.f71364d = 4;
        }
        com.tencent.ams.mosaic.jsengine.component.video.a aVar = this.G;
        if (aVar != null) {
            aVar.setPaused(true);
            g0();
        }
        if (this.f71367h != null) {
            callbackJsPlayEvent(4, 0);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "seekTo: " + i3);
        seekTo(i3, true);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "setAutoPlay: " + z16);
        this.N = z16;
        if (z16) {
            start();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setControllerVisible(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.j
                @Override // java.lang.Runnable
                public final void run() {
                    VideoComponentImpl.this.R(z16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setFullScreen(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "setFullScreen: " + z16);
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.l
            @Override // java.lang.Runnable
            public final void run() {
                VideoComponentImpl.this.S(z16);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setFullScreenMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.U = i3;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        super.setJSEngine(aVar);
        NetworkImageView networkImageView = this.F;
        if (networkImageView != null) {
            networkImageView.setImageLoader(getImageLoader());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.Q = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setOnClickListener(final JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSFunction);
        } else {
            com.tencent.ams.mosaic.utils.f.e(tag(), "setOnClickListener");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.i
                @Override // java.lang.Runnable
                public final void run() {
                    VideoComponentImpl.this.T(jSFunction);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(final JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSFunction);
        } else {
            com.tencent.ams.mosaic.utils.f.e(tag(), "setOnTouchListener");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.d
                @Override // java.lang.Runnable
                public final void run() {
                    VideoComponentImpl.this.U(jSFunction);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setOutputMute(boolean z16) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "setOutputMute: " + z16);
        this.R = z16;
        MediaPlayer mediaPlayer = this.f71366f;
        if (mediaPlayer != null) {
            if (z16) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            mediaPlayer.setVolume(f16, f16);
            com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "setVolume: " + f16);
        }
        com.tencent.ams.mosaic.jsengine.component.video.a aVar = this.G;
        if (aVar != null) {
            aVar.setMute(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPlayListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSFunction);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "setPlayListener: " + jSFunction);
        this.f71367h = jSFunction;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPlayerEventListener(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) jSObject);
            return;
        }
        Map<String, Object> f16 = com.tencent.ams.mosaic.jsengine.e.f(getJSEngine().l(), jSObject);
        if (f16 == null) {
            com.tencent.ams.mosaic.utils.f.h("VideoComponentImpl", "addPlayerEventListener failed: invalid listenerDict");
        } else {
            this.f71368i = com.tencent.ams.mosaic.jsengine.e.c(f16.get("PlayerFullScreen"));
            this.f71369m = com.tencent.ams.mosaic.jsengine.e.c(f16.get("PlayerExitFullScreen"));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPoster(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        NetworkImageView networkImageView = this.F;
        if (networkImageView != null) {
            networkImageView.setSrc(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setPosterData(String str) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            return;
        }
        if (this.F != null) {
            float f17 = 0.0f;
            if (getWidth() > 0.0f) {
                f16 = getWidth();
            } else {
                f16 = 0.0f;
            }
            if (getHeight() > 0.0f) {
                f17 = getHeight();
            }
            this.F.setImageBitmap(MosaicUtils.d(str, f16, f17));
        }
    }

    public void setSavedPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            this.M = i3;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setScaleType(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "setScaleType: " + str);
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.b
            @Override // java.lang.Runnable
            public final void run() {
                VideoComponentImpl.this.V(str);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setVideoParams(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "setVideoParams: " + str);
        this.L = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void setVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "setVolume: " + i3);
        MediaPlayer mediaPlayer = this.f71366f;
        if (mediaPlayer != null) {
            float f16 = i3;
            mediaPlayer.setVolume(f16, f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "start");
        this.P = true;
        if (J()) {
            if (this.K) {
                e0(this.M);
                this.M = 0;
                return;
            }
            return;
        }
        if (!this.K) {
            this.f71364d = 0;
        } else {
            X();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.video.VideoComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "stop");
        this.P = false;
        d0();
        g0();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "surfaceChanged");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) surfaceHolder);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "surfaceCreated");
        if (this.E != null) {
            Configuration F = F();
            if (F != null && F.orientation == 1) {
                this.I = this.E.getWidth();
                this.J = this.E.getHeight();
            } else {
                this.I = this.E.getHeight();
                this.J = this.E.getWidth();
            }
        }
        MediaPlayer mediaPlayer = this.f71366f;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
        this.K = true;
        if (this.L != null && this.f71364d <= 2) {
            X();
            com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "surfaceCreated - openVideo mSavedPosition: " + this.M);
            return;
        }
        int i3 = this.f71364d;
        if (i3 != 3 && !this.P) {
            if (i3 == 4) {
                seekTo(this.M, false);
                return;
            }
            return;
        }
        e0(this.M);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) surfaceHolder);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "surfaceDestroyed");
        this.K = false;
        MediaPlayer mediaPlayer = this.f71366f;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying() || this.f71364d == 4) {
                this.f71366f.pause();
                this.f71364d = 4;
                com.tencent.ams.mosaic.utils.f.a("VideoComponentImpl", "surfaceDestroyed - mSavedPosition: " + this.M);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "VideoComponentImpl";
    }

    public void seekTo(final int i3, final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("VideoComponentImpl", "seekTo: " + i3 + ", startAfterSeek: " + z16);
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.video.h
            @Override // java.lang.Runnable
            public final void run() {
                VideoComponentImpl.this.Q(i3, z16);
            }
        });
    }
}
