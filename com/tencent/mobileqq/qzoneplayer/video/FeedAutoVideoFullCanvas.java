package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar;
import com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoCanvasControllerView;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeedAutoVideoFullCanvas extends BaseVideo {
    private float C;
    private float D;
    private float E;
    int F;
    private boolean G;
    private boolean H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected OperationContainer L;
    private RelativeLayout M;
    private ImageButton N;
    private TipFloatContainer P;
    private View Q;
    protected VideoControllerView.OnControllerEventListener R;
    protected boolean S;
    private TextView T;
    protected boolean U;
    private VideoExtendedAnimationView V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private View.OnClickListener f279694a0;

    /* renamed from: b0, reason: collision with root package name */
    private MediaControllerListener f279695b0;

    /* renamed from: c0, reason: collision with root package name */
    protected RelativeLayout f279696c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f279697d;

    /* renamed from: d0, reason: collision with root package name */
    protected TextView f279698d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f279699e;

    /* renamed from: e0, reason: collision with root package name */
    private long f279700e0;

    /* renamed from: f, reason: collision with root package name */
    protected FeedAutoVideoCanvasControllerView f279701f;

    /* renamed from: f0, reason: collision with root package name */
    private String f279702f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ImageView f279703g0;

    /* renamed from: h, reason: collision with root package name */
    private float f279704h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f279705h0;

    /* renamed from: i, reason: collision with root package name */
    private float f279706i;

    /* renamed from: i0, reason: collision with root package name */
    public String f279707i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f279708j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f279709k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f279710l0;

    /* renamed from: m, reason: collision with root package name */
    private float f279711m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f279712m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f279713n0;

    /* renamed from: o0, reason: collision with root package name */
    private CountDownTimer f279714o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f279715p0;

    /* renamed from: q0, reason: collision with root package name */
    protected h f279716q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f279717r0;

    /* renamed from: s0, reason: collision with root package name */
    protected boolean f279718s0;

    /* renamed from: t0, reason: collision with root package name */
    protected boolean f279719t0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas$8, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ FeedAutoVideoFullCanvas this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.V != null) {
                this.this$0.V.setVisibility(4);
                this.this$0.V.h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFullCanvas.this.R;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequsetJumpAdvUrl();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PlayerUtils.log(4, "FeedAutoVideoFullCanvas", "mVideoClickListener onClick: state=" + FeedAutoVideoFullCanvas.this.getState());
            if (FeedAutoVideoFullCanvas.this.getVideoPlayInfo() == null) {
                PlayerUtils.log(6, "FeedAutoVideoFullCanvas", "mVideoClickListener onClick: getVideoPlayInfo() is null");
            } else if (FeedAutoVideoFullCanvas.this.getState() != 3 && FeedAutoVideoFullCanvas.this.getState() != 5 && !BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                if (FeedAutoVideoFullCanvas.this.getState() == 1) {
                    if (FeedAutoVideoFullCanvas.this.getVideoPlayInfo().f()) {
                        FeedAutoVideoFullCanvas.this.S = false;
                    }
                    FeedAutoVideoFullCanvas.this.getBaseVideoManager().startVideo(FeedAutoVideoFullCanvas.this);
                }
            } else {
                if (FeedAutoVideoFullCanvas.this.getState() == 5) {
                    FeedAutoVideoFullCanvas.this.S = false;
                }
                FeedAutoVideoFullCanvas.this.f279701f.show();
                FeedAutoVideoFullCanvas feedAutoVideoFullCanvas = FeedAutoVideoFullCanvas.this;
                feedAutoVideoFullCanvas.U = true;
                feedAutoVideoFullCanvas.x();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FeedAutoVideoFullCanvas.this.getBaseVideoManager() != null && FeedAutoVideoFullCanvas.this.getBaseVideoManager().isCurSoundOpened()) {
                FeedAutoVideoFullCanvas.this.getBaseVideoManager().f();
                FeedAutoVideoFullCanvas.this.N.setImageResource(FeedVideoEnv.feedResources.getDrawableId(1103));
            } else {
                if (FeedAutoVideoFullCanvas.this.getBaseVideoManager() != null) {
                    FeedAutoVideoFullCanvas.this.getBaseVideoManager().enableAutoVideoSound();
                }
                FeedAutoVideoFullCanvas.this.N.setImageResource(FeedVideoEnv.feedResources.getDrawableId(1106));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoFullCanvas.this.w();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class g implements RotationSeekBar.OnRotationChangeListener {
        g() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar.OnRotationChangeListener
        public int getCurRotate() {
            OperationContainer operationContainer = FeedAutoVideoFullCanvas.this.L;
            if (operationContainer == null) {
                return 0;
            }
            int rotation = (int) operationContainer.getRotation();
            if (rotation < 0) {
                rotation = 180 - rotation;
            }
            return rotation > 360 ? rotation - 360 : rotation;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class h implements VideoControllerView.MediaPlayerControl {

        /* renamed from: a, reason: collision with root package name */
        private boolean f279737a;

        /* renamed from: b, reason: collision with root package name */
        private StringBuilder f279738b = new StringBuilder();

        /* renamed from: c, reason: collision with root package name */
        private Formatter f279739c = new Formatter(this.f279738b, Locale.getDefault());

        /* renamed from: d, reason: collision with root package name */
        private int f279740d;

        public h() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canPausePlay() {
            return FeedAutoVideoFullCanvas.this.getState() == 3 || FeedAutoVideoFullCanvas.this.getState() == 5 || FeedAutoVideoFullCanvas.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canSeekBackward() {
            return FeedAutoVideoFullCanvas.this.f279705h0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canSeekForward() {
            return FeedAutoVideoFullCanvas.this.f279705h0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean enableToggleFullScreen() {
            return FeedAutoVideoFullCanvas.this.J;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean enableToggleLandscape() {
            return FeedAutoVideoFullCanvas.this.K;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getBufferPercentage() {
            return FeedAutoVideoFullCanvas.this.f279715p0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getCurrentPosition() {
            Object h16 = FeedAutoVideoFullCanvas.this.getBaseVideoManager().h();
            if (h16 == null) {
                return this.f279740d;
            }
            this.f279740d = ((Integer) h16).intValue();
            PlayerUtils.log(3, "FeedAutoVideoFullCanvas", "MangerHandler getCurrentPosition: positon=" + this.f279740d);
            return this.f279740d;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getDuration() {
            Object duration = FeedAutoVideoFullCanvas.this.getBaseVideoManager().getDuration();
            if (duration == null) {
                return 0;
            }
            return ((Integer) duration).intValue();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public String getVideoUriWithUuid() {
            return FeedAutoVideoFullCanvas.this.getBaseVideoManager().i();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void hideTopBar() {
            FeedAutoVideoFullCanvas feedAutoVideoFullCanvas = FeedAutoVideoFullCanvas.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFullCanvas.R;
            if (onControllerEventListener != null) {
                onControllerEventListener.onControllerHide(feedAutoVideoFullCanvas);
            }
            FeedAutoVideoFullCanvas.this.p();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isFullScreen() {
            FeedAutoVideoFullCanvas.this.getClass();
            return FeedAutoVideoFullCanvas.this.H;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isLandscape() {
            FeedAutoVideoFullCanvas.this.getClass();
            return false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isLoading() {
            return FeedAutoVideoFullCanvas.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isPlayComplete() {
            return FeedAutoVideoFullCanvas.this.getState() == 4 || FeedAutoVideoFullCanvas.this.getState() == 1;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isPlaying() {
            return FeedAutoVideoFullCanvas.this.getState() == 3 && !this.f279737a;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void pause() {
            FeedAutoVideoFullCanvas.this.setState(5);
            this.f279737a = true;
            FeedAutoVideoFullCanvas.this.getBaseVideoManager().pauseVideo();
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFullCanvas.this.R;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestPauseVideo();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void seekTo(int i3) {
            boolean z16;
            if (FeedAutoVideoFullCanvas.this.getState() != 5) {
                FeedAutoVideoFullCanvas.this.setState(2);
                z16 = false;
            } else {
                z16 = true;
            }
            FeedAutoVideoFullCanvas.this.getBaseVideoManager().seekVideoRealManual(i3);
            FeedAutoVideoFullCanvas.this.f279701f.postSetProgress();
            if (FeedAutoVideoFullCanvas.this.getState() == 3 && this.f279737a) {
                this.f279737a = false;
            }
            if (z16) {
                pause();
            }
            FeedAutoVideoFullCanvas.this.f279701f.updatePausePlay();
            FeedAutoVideoFullCanvas.this.f279701f.show();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void setRate(float f16) {
            FeedAutoVideoFullCanvas.this.getBaseVideoManager().I(f16);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void toggleFullScreen() {
            FeedAutoVideoFullCanvas.this.H = !r0.H;
            FeedAutoVideoFullCanvas feedAutoVideoFullCanvas = FeedAutoVideoFullCanvas.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFullCanvas.R;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestToggleFullscreen(feedAutoVideoFullCanvas, feedAutoVideoFullCanvas.H);
            }
            FeedAutoVideoFullCanvas.this.f279701f.updateLayout();
            ((AutoVideoCoverFullCanvas) FeedAutoVideoFullCanvas.this.mVideoCover).a();
            FeedAutoVideoFullCanvas.this.f279701f.updateFullScreen();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void toggleLandscape() {
            FeedAutoVideoFullCanvas.this.G = !r0.G;
            FeedAutoVideoFullCanvas feedAutoVideoFullCanvas = FeedAutoVideoFullCanvas.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFullCanvas.R;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestToggleLandscape(feedAutoVideoFullCanvas, feedAutoVideoFullCanvas.G);
            }
            FeedAutoVideoFullCanvas.this.f279701f.updateLandscapeIndicator();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void updatePlayPauseButton() {
            if (FeedAutoVideoFullCanvas.this.f279695b0 != null) {
                FeedAutoVideoFullCanvas.this.f279695b0.onUpdatePlayPauseButton();
            }
            FeedAutoVideoFullCanvas feedAutoVideoFullCanvas = FeedAutoVideoFullCanvas.this;
            if (feedAutoVideoFullCanvas.f279696c0 == null) {
                return;
            }
            if (feedAutoVideoFullCanvas.getState() != 2 && FeedAutoVideoFullCanvas.this.getState() != 0 && FeedAutoVideoFullCanvas.this.getState() != 1) {
                FeedAutoVideoFullCanvas feedAutoVideoFullCanvas2 = FeedAutoVideoFullCanvas.this;
                feedAutoVideoFullCanvas2.f279696c0.setVisibility(feedAutoVideoFullCanvas2.U ? 0 : 8);
            } else {
                FeedAutoVideoFullCanvas.this.f279696c0.setVisibility(8);
            }
            if (isPlaying()) {
                FeedAutoVideoFullCanvas.this.f279696c0.setVisibility(8);
            } else {
                FeedAutoVideoFullCanvas.this.f279696c0.setVisibility(8);
                FeedAutoVideoFullCanvas.this.f279703g0.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1107));
            }
            if (FeedAutoVideoFullCanvas.this.N != null) {
                if (FeedAutoVideoFullCanvas.this.getBaseVideoManager() != null && FeedAutoVideoFullCanvas.this.getBaseVideoManager().isCurSoundOpened()) {
                    FeedAutoVideoFullCanvas.this.N.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1106));
                } else {
                    FeedAutoVideoFullCanvas.this.N.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1103));
                }
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void start() {
            this.f279737a = false;
            FeedAutoVideoFullCanvas.this.setState(3);
            FeedAutoVideoFullCanvas.this.getBaseVideoManager().startVideoReal();
            FeedAutoVideoFullCanvas.this.mVideoCover.requestLayout();
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFullCanvas.this.R;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestPlayVideo();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public String time2str(int i3) {
            int round = (int) Math.round((i3 * 1.0d) / 1000.0d);
            int i16 = round % 60;
            int i17 = (round / 60) % 60;
            int i18 = round / 3600;
            this.f279738b.setLength(0);
            if (i18 > 0) {
                return this.f279739c.format("%d:%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)).toString();
            }
            return this.f279739c.format("%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i16)).toString();
        }
    }

    public FeedAutoVideoFullCanvas(Context context) {
        super(context);
        this.f279697d = 3000;
        this.f279699e = 950;
        this.F = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.J = true;
        this.K = false;
        this.S = false;
        this.f279694a0 = new c();
        this.f279700e0 = 0L;
        this.f279702f0 = null;
        this.f279707i0 = null;
        this.f279716q0 = new h();
        this.f279717r0 = 300;
        s();
        initData();
    }

    private void initData() {
        d dVar = new d();
        this.mVideoClickListener = dVar;
        setOnClickListener(dVar);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas.3

            /* renamed from: d, reason: collision with root package name */
            private long f279720d;

            /* renamed from: e, reason: collision with root package name */
            private int f279721e;

            /* renamed from: f, reason: collision with root package name */
            private Runnable f279722f = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas.3.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideoFullCanvas.this.performClick();
                }
            };

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FeedAutoVideoFullCanvas.this.isUse360VideoRender()) {
                    return FeedAutoVideoFullCanvas.this.onTouchExt(view, motionEvent);
                }
                long currentTimeMillis = System.currentTimeMillis();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 || FeedAutoVideoFullCanvas.this.v(motionEvent)) {
                        return true;
                    }
                    if (currentTimeMillis - this.f279720d > 3000) {
                        FeedAutoVideoFullCanvas.this.performLongClick();
                        return true;
                    }
                    if (this.f279721e != 1 && FeedAutoVideoFullCanvas.this.t()) {
                        if (this.f279721e == 2) {
                            FeedAutoVideoFullCanvas.this.f279716q0.toggleFullScreen();
                        }
                    } else {
                        FeedAutoVideoFullCanvas.this.postDelayed(this.f279722f, 400L);
                    }
                } else {
                    FeedAutoVideoFullCanvas.this.r();
                    FeedAutoVideoFullCanvas.this.u(motionEvent);
                    FeedAutoVideoFullCanvas.this.removeCallbacks(this.f279722f);
                    long j3 = this.f279720d;
                    if (j3 != 0 && currentTimeMillis - j3 > 300) {
                        this.f279721e = 0;
                    }
                    this.f279721e++;
                    this.f279720d = currentTimeMillis;
                }
                return true;
            }
        });
    }

    private void n() {
        ((ViewGroup) getParent()).setContentDescription("videoContainer");
        if (this.V.getLayoutParams() == null) {
            this.V.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.V);
        }
        VideoExtendedAnimationView videoExtendedAnimationView = this.V;
        BaseVideoCover baseVideoCover = this.mVideoCover;
        videoExtendedAnimationView.setContainerDimensionOverride(baseVideoCover.picWidth, baseVideoCover.picHeight, true);
        this.V.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(MotionEvent motionEvent) {
        this.f279704h = motionEvent.getX();
        this.f279706i = motionEvent.getY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(MotionEvent motionEvent) {
        this.f279711m = motionEvent.getX();
        this.C = motionEvent.getY();
        this.D = Math.abs(this.f279711m - this.f279704h);
        this.E = Math.abs(this.C - this.f279706i);
        float f16 = this.D;
        double sqrt = Math.sqrt((f16 * f16) + (r6 * r6));
        if (this.E <= this.F || sqrt < this.D * 2.0f) {
            return false;
        }
        if (this.C >= this.f279706i) {
            VideoControllerView.OnControllerEventListener onControllerEventListener = this.R;
            if (onControllerEventListener != null) {
                onControllerEventListener.onGestureMoveDown();
            }
        } else {
            VideoControllerView.OnControllerEventListener onControllerEventListener2 = this.R;
            if (onControllerEventListener2 != null) {
                onControllerEventListener2.onGestureMoveUp();
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        this.mVideoCover = new AutoVideoCoverFullCanvas(context, this);
        addView(this.mVideoCover, new ViewGroup.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initChildView() {
        super.initChildView();
        FeedAutoVideoCanvasControllerView feedAutoVideoCanvasControllerView = new FeedAutoVideoCanvasControllerView(getContext(), FeedVideoEnv.playerResources);
        this.f279701f = feedAutoVideoCanvasControllerView;
        feedAutoVideoCanvasControllerView.setVisibility(0);
        this.L = (OperationContainer) LayoutInflater.from(getContext()).inflate(FeedVideoEnv.feedResources.getLayoutId(10), (ViewGroup) null);
        this.M = (RelativeLayout) LayoutInflater.from(getContext()).inflate(FeedVideoEnv.feedResources.getLayoutId(11), (ViewGroup) null);
        int layoutId = FeedVideoEnv.playerResources.getLayoutId(5);
        if (layoutId != 0) {
            TipFloatContainer tipFloatContainer = (TipFloatContainer) LayoutInflater.from(getContext()).inflate(layoutId, (ViewGroup) null);
            this.P = tipFloatContainer;
            if (tipFloatContainer != null) {
                this.T = (TextView) tipFloatContainer.findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.NEXT_VIDEO_COUNT_DOWN_TIP));
            }
        }
        View view = new View(getContext());
        this.Q = view;
        view.setBackgroundColor(Color.parseColor("#66000000"));
        this.Q.setVisibility(0);
        ImageButton imageButton = (ImageButton) this.M.findViewById(FeedVideoEnv.feedResources.getViewId(29));
        this.N = imageButton;
        imageButton.setImageResource(FeedVideoEnv.feedResources.getDrawableId(1103));
        this.N.setOnClickListener(new e());
        this.f279703g0 = (ImageView) this.L.findViewById(FeedVideoEnv.playerResources.getViewId(550));
        this.f279698d0 = (TextView) this.L.findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT));
        this.f279696c0 = (RelativeLayout) this.L.findViewById(FeedVideoEnv.playerResources.getViewId(577));
        this.f279703g0.setOnClickListener(new f());
        this.L.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas.6

            /* renamed from: d, reason: collision with root package name */
            private long f279725d;

            /* renamed from: e, reason: collision with root package name */
            private int f279726e;

            /* renamed from: f, reason: collision with root package name */
            private Runnable f279727f = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas.6.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideoFullCanvas.this.f279701f.startFadeout(0);
                }
            };

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction() & 255;
                long currentTimeMillis = System.currentTimeMillis();
                if (action == 0) {
                    FeedAutoVideoFullCanvas.this.u(motionEvent);
                    FeedAutoVideoFullCanvas.this.removeCallbacks(this.f279727f);
                    if (currentTimeMillis - this.f279725d > 400) {
                        this.f279726e = 0;
                    }
                    this.f279726e++;
                    this.f279725d = currentTimeMillis;
                    FeedAutoVideoFullCanvas.this.f279701f.cancelFadeout();
                    return true;
                }
                if (action == 1 || action == 3) {
                    if (FeedAutoVideoFullCanvas.this.v(motionEvent)) {
                        return true;
                    }
                    if (currentTimeMillis - this.f279725d > 500) {
                        FeedAutoVideoFullCanvas.this.f279701f.startFadeout();
                    }
                    if (this.f279726e != 1 && FeedAutoVideoFullCanvas.this.t()) {
                        FeedAutoVideoFullCanvas.this.f279716q0.toggleFullScreen();
                    } else {
                        FeedAutoVideoFullCanvas.this.postDelayed(this.f279727f, 400L);
                    }
                }
                return false;
            }
        });
        int layoutId2 = FeedVideoEnv.playerResources.getLayoutId(6);
        if (layoutId2 != 0) {
            VideoExtendedAnimationView videoExtendedAnimationView = (VideoExtendedAnimationView) LayoutInflater.from(getContext()).inflate(layoutId2, (ViewGroup) null);
            this.V = videoExtendedAnimationView;
            if (videoExtendedAnimationView != null) {
                videoExtendedAnimationView.f();
                this.V.setItemOnTouchListener();
            }
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void onClickVideoEventProcess(View view) {
        View.OnClickListener onClickListener = this.mVideoClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int defaultSize;
        int defaultSize2;
        BaseVideoCover baseVideoCover = this.mVideoCover;
        int i17 = baseVideoCover.picWidth;
        int i18 = baseVideoCover.picHeight;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            super.onMeasure(i3, i16);
            this.f279701f.setVideoDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            if (this.f279710l0) {
                defaultSize = this.f279708j0;
                defaultSize2 = this.f279709k0;
            } else {
                defaultSize = View.getDefaultSize(0, i3);
                defaultSize2 = View.getDefaultSize(0, i16);
            }
            if (i17 > 0 && i18 > 0) {
                int i19 = i17 * defaultSize2;
                int i26 = defaultSize * i18;
                if (i19 > i26) {
                    defaultSize2 = i26 / i17;
                } else if (i19 < i26) {
                    defaultSize = i19 / i18;
                }
            }
            View view = this.mVideoView;
            if (view != null && view.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVideoView.getLayoutParams();
                this.mVideoView.measure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2 - (marginLayoutParams.topMargin * 2), 1073741824));
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824);
            ViewGroup.LayoutParams layoutParams2 = this.mVideoCover.getLayoutParams();
            layoutParams2.height = -1;
            layoutParams2.width = -1;
            this.mVideoCover.setLayoutParams(layoutParams2);
            this.mVideoCover.measure(makeMeasureSpec, makeMeasureSpec2);
            setMeasuredDimension(defaultSize, defaultSize2);
        }
        VideoExtendedAnimationView videoExtendedAnimationView = this.V;
        if (videoExtendedAnimationView != null) {
            videoExtendedAnimationView.setContainerDimensionOverride(this.mVideoCover.getMeasuredWidth(), this.mVideoCover.getMeasuredHeight(), true);
            this.V.measure(this.mVideoCover.getMeasuredWidth(), this.mVideoCover.getMeasuredHeight());
            this.V.setLayoutParams(this.mVideoCover.getLayoutParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        VideoExtendedAnimationView videoExtendedAnimationView;
        super.onReceivedMessage(message);
        int i3 = message.what;
        if (i3 == 1) {
            this.f279716q0.f279737a = false;
            this.mVideoCover.setShowPlayIcon(false);
            getBaseVideoManager().enableAutoVideoSound();
            ImageButton imageButton = this.N;
            if (imageButton != null) {
                imageButton.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1106));
                return;
            }
            return;
        }
        if (i3 == 17) {
            this.f279705h0 = true;
            return;
        }
        if (i3 != 20) {
            if (i3 == 23 && (videoExtendedAnimationView = this.V) != null) {
                videoExtendedAnimationView.getVisibility();
                return;
            }
            return;
        }
        getBaseVideoManager().enableAutoVideoSound();
        ImageButton imageButton2 = this.N;
        if (imageButton2 != null) {
            imageButton2.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1106));
        }
        this.f279705h0 = true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public void onRecycled() {
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder;
        if (this.f279719t0 && (globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder.oldSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFullCanvas", "mWillSwitchToWindow true, onPause does nothing");
            return;
        }
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder2 = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder();
        if (globalChangeSurfaceHolder2 != null && globalChangeSurfaceHolder2.newSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFullCanvas", "onRecycled does nothing");
        } else {
            super.onRecycled();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onSetVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        getBaseVideoManager().schedulePreload(this.mVideoPlayInfo.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoBufferingUpdate(int i3) {
        this.f279715p0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoSizeChanged(int i3, int i16) {
        super.onVideoSizeChanged(i3, i16);
    }

    public void p() {
        if (this.L.getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(this.f279717r0);
        alphaAnimation.setAnimationListener(new a());
        this.L.startAnimation(alphaAnimation);
    }

    public void q() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas.13
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFullCanvas.this.f279701f.cancelFadeout();
                FeedAutoVideoFullCanvas.this.L.setVisibility(4);
            }
        });
    }

    public void r() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas.14
            @Override // java.lang.Runnable
            public void run() {
                if (FeedAutoVideoFullCanvas.this.P != null) {
                    FeedAutoVideoFullCanvas.this.T.setVisibility(8);
                    FeedAutoVideoFullCanvas.this.y();
                }
            }
        });
    }

    public void setActivityWillDestroy(boolean z16) {
        this.f279718s0 = z16;
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.f279708j0 = i3;
        this.f279709k0 = i16;
        this.f279710l0 = z16;
    }

    public void setMediaControllerListener(MediaControllerListener mediaControllerListener) {
        this.f279695b0 = mediaControllerListener;
    }

    public void setOnControllerEventListener(VideoControllerView.OnControllerEventListener onControllerEventListener) {
        this.R = onControllerEventListener;
    }

    public void setOnControllerVisibilityListener(FeedAutoVideoCanvasControllerView.d dVar) {
        FeedAutoVideoCanvasControllerView feedAutoVideoCanvasControllerView = this.f279701f;
        if (feedAutoVideoCanvasControllerView != null) {
            feedAutoVideoCanvasControllerView.setControllerVisibilityListener(dVar);
        }
    }

    public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        FeedAutoVideoCanvasControllerView feedAutoVideoCanvasControllerView = this.f279701f;
        if (feedAutoVideoCanvasControllerView != null) {
            feedAutoVideoCanvasControllerView.setSeekBarChangeListener(onSeekBarChangeListener);
        }
    }

    public void setShowCover(boolean z16) {
        BaseVideoCover baseVideoCover = this.mVideoCover;
        if (baseVideoCover != null) {
            if (z16) {
                baseVideoCover.setShowPlayIcon(true);
            } else {
                baseVideoCover.setShowPlayIcon(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        super.setVideoPlayInfo(videoPlayInfo);
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.setContentDescription("videoContainer");
        if (!this.f279712m0) {
            viewGroup.addView(this.L);
            TipFloatContainer tipFloatContainer = this.P;
            if (tipFloatContainer != null) {
                viewGroup.addView(tipFloatContainer);
            }
            this.f279701f.setContentDescription("videoController");
            this.f279701f.setAnchorView(this.L);
            this.f279701f.setVideoView(this);
            this.f279701f.setMediaPlayer(this.f279716q0);
            this.f279701f.setEnabled(true);
            this.f279712m0 = true;
        }
        if (!this.f279713n0 && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            viewGroup.addView(this.M, layoutParams);
            this.f279713n0 = true;
        }
        if (this.L != null) {
            this.f279701f.cancelFadeout();
            this.L.setVisibility(8);
        }
        if (videoPlayInfo.segmentVideoInfo.getDefaultUrl().startsWith("/")) {
            this.f279715p0 = 100;
        }
        h hVar = this.f279716q0;
        if (hVar != null) {
            hVar.f279737a = false;
            this.f279716q0.f279740d = 0;
        }
        this.f279705h0 = false;
        FeedAutoVideoCanvasControllerView feedAutoVideoCanvasControllerView = this.f279701f;
        if (feedAutoVideoCanvasControllerView != null) {
            feedAutoVideoCanvasControllerView.setSeekbarRotationChangeListener(new g());
        }
        this.W = videoPlayInfo.needVideoExtendedAnimation;
        if (this.V != null) {
            n();
            this.V.setVisibility(8);
        }
    }

    public void setVideoTotalTraffic(long j3) {
        this.f279700e0 = j3;
        String format = String.format("%.2fM", Float.valueOf(((float) j3) / 1024.0f));
        this.f279702f0 = format;
        TextView textView = this.f279698d0;
        if (textView != null) {
            textView.setText(format);
        }
        BaseVideoCover baseVideoCover = this.mVideoCover;
        if (baseVideoCover instanceof AutoVideoCoverFullCanvas) {
            ((AutoVideoCoverFullCanvas) baseVideoCover).setVideoTotalTraffic(j3);
        }
    }

    public void setWillSwitchToWindow(boolean z16) {
        this.f279719t0 = z16;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void stop() {
        super.stop();
        setShowCover(true);
    }

    protected boolean t() {
        return true;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void update() {
        h hVar;
        super.update();
        if (this.isAutoPlay && this.I && (hVar = this.f279716q0) != null && hVar.f279737a) {
            this.f279716q0.pause();
        }
        this.I = false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void updateWithoutDelay(boolean z16) {
        super.updateWithoutDelay(z16);
        o();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void videoUIStop() {
        super.videoUIStop();
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullCanvas.10
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFullCanvas.this.f279701f.hide();
                FeedAutoVideoFullCanvas.this.q();
            }
        });
    }

    public void w() {
        this.f279701f.doPauseResume();
        if (this.f279716q0.isPlaying()) {
            this.S = false;
        } else {
            this.S = true;
        }
    }

    public void x() {
        this.f279701f.updateLayout();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(this.f279717r0);
        alphaAnimation.setAnimationListener(new b());
        this.L.startAnimation(alphaAnimation);
    }

    public void y() {
        CountDownTimer countDownTimer = this.f279714o0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f279714o0 = null;
        }
    }

    private void s() {
        this.hasTimeview = false;
        this.hasPlayCountView = false;
        this.hasSoundTipLayout = false;
        this.hasSoundLinesLayout = false;
        this.mTimeview = null;
        this.mSoundLinesLayout = null;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onPause() {
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder;
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder2;
        this.I = true;
        if (this.f279719t0 && (globalChangeSurfaceHolder2 = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder2.oldSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFullCanvas", "mWillSwitchToWindow true, onPause does nothing");
        } else if (this.f279718s0 && (globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder.newSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFullCanvas", "mIsActivityWillDestroy true, onPause does nothing");
        } else {
            super.onPause();
        }
    }

    public FeedAutoVideoFullCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279697d = 3000;
        this.f279699e = 950;
        this.F = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.J = true;
        this.K = false;
        this.S = false;
        this.f279694a0 = new c();
        this.f279700e0 = 0L;
        this.f279702f0 = null;
        this.f279707i0 = null;
        this.f279716q0 = new h();
        this.f279717r0 = 300;
        s();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FeedAutoVideoFullCanvas.this.L.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PlayerUtils.log(4, "FeedAutoVideoFullCanvas", "SHOW");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            FeedAutoVideoFullCanvas.this.L.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    protected void o() {
    }

    public void setFeedAutoVideoFullFunc(com.tencent.mobileqq.qzoneplayer.video.a aVar) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void showValidTimeText() {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void startIndicatePause() {
    }

    public FeedAutoVideoFullCanvas(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f279697d = 3000;
        this.f279699e = 950;
        this.F = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.J = true;
        this.K = false;
        this.S = false;
        this.f279694a0 = new c();
        this.f279700e0 = 0L;
        this.f279702f0 = null;
        this.f279707i0 = null;
        this.f279716q0 = new h();
        this.f279717r0 = 300;
        s();
        initData();
    }
}
