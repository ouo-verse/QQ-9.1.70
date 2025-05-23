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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar;
import com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes35.dex */
public class FeedAutoVideoFullLivePlayBack extends BaseVideo {
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
    private TipFloatContainer M;
    private View N;
    protected VideoControllerView.OnControllerEventListener P;
    protected boolean Q;
    private TextView R;
    protected boolean S;
    private VideoExtendedAnimationView T;
    private boolean U;
    private View.OnClickListener V;
    private MediaControllerListener W;

    /* renamed from: a0, reason: collision with root package name */
    protected ImageView f279742a0;

    /* renamed from: b0, reason: collision with root package name */
    protected ImageView f279743b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f279744c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f279745d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f279746d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f279747e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f279748e0;

    /* renamed from: f, reason: collision with root package name */
    protected FeedAutoVideoControllerView f279749f;

    /* renamed from: f0, reason: collision with root package name */
    private LinearLayout f279750f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f279751g0;

    /* renamed from: h, reason: collision with root package name */
    private float f279752h;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f279753h0;

    /* renamed from: i, reason: collision with root package name */
    private float f279754i;

    /* renamed from: i0, reason: collision with root package name */
    private LinearLayout f279755i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f279756j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f279757k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f279758l0;

    /* renamed from: m, reason: collision with root package name */
    private float f279759m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f279760m0;

    /* renamed from: n0, reason: collision with root package name */
    private CountDownTimer f279761n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f279762o0;

    /* renamed from: p0, reason: collision with root package name */
    protected MediaPlayerControl f279763p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f279764q0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f279765r0;

    /* renamed from: s0, reason: collision with root package name */
    protected boolean f279766s0;

    /* renamed from: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack$9, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ FeedAutoVideoFullLivePlayBack this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.T != null) {
                this.this$0.T.setVisibility(4);
                this.this$0.T.h();
            }
        }
    }

    /* loaded from: classes35.dex */
    public class MediaPlayerControl implements VideoControllerView.MediaPlayerControl {
        private boolean isRawPaused;
        private StringBuilder mFormatBuilder = new StringBuilder();
        private Formatter mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        private int mLastCurrentPosition;
        private int mLastDuration;

        public MediaPlayerControl() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canPausePlay() {
            return FeedAutoVideoFullLivePlayBack.this.getState() == 3 || FeedAutoVideoFullLivePlayBack.this.getState() == 5 || FeedAutoVideoFullLivePlayBack.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canSeekBackward() {
            return FeedAutoVideoFullLivePlayBack.this.f279748e0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canSeekForward() {
            return FeedAutoVideoFullLivePlayBack.this.f279748e0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean enableToggleFullScreen() {
            return FeedAutoVideoFullLivePlayBack.this.J;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean enableToggleLandscape() {
            return FeedAutoVideoFullLivePlayBack.this.K;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getBufferPercentage() {
            return FeedAutoVideoFullLivePlayBack.this.f279762o0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getCurrentPosition() {
            Object h16 = FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().h();
            if (h16 == null) {
                return this.mLastCurrentPosition;
            }
            if (this.mLastDuration != 0) {
                Integer num = (Integer) h16;
                int intValue = num.intValue();
                int i3 = this.mLastDuration;
                if (intValue > i3) {
                    this.mLastCurrentPosition = Math.max(i3, num.intValue());
                    PlayerUtils.log(3, "FeedAutoVideoFull", "MangerHandler getCurrentPosition: positon=" + this.mLastCurrentPosition);
                    return this.mLastCurrentPosition;
                }
            }
            this.mLastCurrentPosition = ((Integer) h16).intValue();
            PlayerUtils.log(3, "FeedAutoVideoFull", "MangerHandler getCurrentPosition: positon=" + this.mLastCurrentPosition);
            return this.mLastCurrentPosition;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getDuration() {
            Object duration = FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().getDuration();
            if (duration == null) {
                return 0;
            }
            Integer num = (Integer) duration;
            this.mLastDuration = num.intValue();
            return num.intValue();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public String getVideoUriWithUuid() {
            return FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().i();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void hideTopBar() {
            FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack = FeedAutoVideoFullLivePlayBack.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFullLivePlayBack.P;
            if (onControllerEventListener != null) {
                onControllerEventListener.onControllerHide(feedAutoVideoFullLivePlayBack);
            }
            FeedAutoVideoFullLivePlayBack.this.t();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isFullScreen() {
            FeedAutoVideoFullLivePlayBack.this.getClass();
            return FeedAutoVideoFullLivePlayBack.this.H;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isLandscape() {
            FeedAutoVideoFullLivePlayBack.this.getClass();
            return false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isLoading() {
            return FeedAutoVideoFullLivePlayBack.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isPlayComplete() {
            return FeedAutoVideoFullLivePlayBack.this.getState() == 4 || FeedAutoVideoFullLivePlayBack.this.getState() == 1;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isPlaying() {
            return FeedAutoVideoFullLivePlayBack.this.getState() == 3 && !this.isRawPaused;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void pause() {
            FeedAutoVideoFullLivePlayBack.this.setState(5);
            this.isRawPaused = true;
            FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().pauseVideo();
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFullLivePlayBack.this.P;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestPauseVideo();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void seekTo(int i3) {
            boolean z16;
            if (FeedAutoVideoFullLivePlayBack.this.getState() != 5) {
                FeedAutoVideoFullLivePlayBack.this.setState(2);
                z16 = false;
            } else {
                z16 = true;
            }
            FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().seekVideoRealManual(i3);
            FeedAutoVideoFullLivePlayBack.this.f279749f.postSetProgress();
            if (FeedAutoVideoFullLivePlayBack.this.getState() == 3 && this.isRawPaused) {
                this.isRawPaused = false;
            }
            if (z16) {
                pause();
            }
            FeedAutoVideoFullLivePlayBack.this.f279749f.updatePausePlay();
            FeedAutoVideoFullLivePlayBack.this.f279749f.show();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void setRate(float f16) {
            FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().I(f16);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void toggleFullScreen() {
            FeedAutoVideoFullLivePlayBack.this.H = !r0.H;
            FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack = FeedAutoVideoFullLivePlayBack.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFullLivePlayBack.P;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestToggleFullscreen(feedAutoVideoFullLivePlayBack, feedAutoVideoFullLivePlayBack.H);
            }
            if (isFullScreen()) {
                FeedAutoVideoFullLivePlayBack.this.f279743b0.setVisibility(0);
            } else {
                FeedAutoVideoFullLivePlayBack.this.f279743b0.setVisibility(8);
            }
            FeedAutoVideoFullLivePlayBack.this.f279749f.updateLayout();
            ((AutoVideoCoverFull) FeedAutoVideoFullLivePlayBack.this.mVideoCover).a();
            FeedAutoVideoFullLivePlayBack.this.f279749f.updateFullScreen();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void toggleLandscape() {
            FeedAutoVideoFullLivePlayBack.this.G = !r0.G;
            FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack = FeedAutoVideoFullLivePlayBack.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFullLivePlayBack.P;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestToggleLandscape(feedAutoVideoFullLivePlayBack, feedAutoVideoFullLivePlayBack.G);
            }
            FeedAutoVideoFullLivePlayBack.this.f279749f.updateLandscapeIndicator();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void updatePlayPauseButton() {
            if (FeedAutoVideoFullLivePlayBack.this.W != null) {
                FeedAutoVideoFullLivePlayBack.this.W.onUpdatePlayPauseButton();
            }
            FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack = FeedAutoVideoFullLivePlayBack.this;
            if (feedAutoVideoFullLivePlayBack.f279742a0 == null) {
                return;
            }
            if (feedAutoVideoFullLivePlayBack.getState() != 2 && FeedAutoVideoFullLivePlayBack.this.getState() != 0 && FeedAutoVideoFullLivePlayBack.this.getState() != 1) {
                FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack2 = FeedAutoVideoFullLivePlayBack.this;
                feedAutoVideoFullLivePlayBack2.f279742a0.setVisibility(feedAutoVideoFullLivePlayBack2.S ? 0 : 8);
            } else {
                FeedAutoVideoFullLivePlayBack.this.f279742a0.setVisibility(8);
            }
            if (isPlaying()) {
                FeedAutoVideoFullLivePlayBack.this.f279742a0.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1093));
            } else {
                FeedAutoVideoFullLivePlayBack.this.f279742a0.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1094));
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void start() {
            this.isRawPaused = false;
            FeedAutoVideoFullLivePlayBack.this.setState(3);
            FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().startVideoReal();
            FeedAutoVideoFullLivePlayBack.this.mVideoCover.requestLayout();
            if (!FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().isCurSoundOpened()) {
                FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().enableAutoVideoSound();
            }
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFullLivePlayBack.this.P;
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
            this.mFormatBuilder.setLength(0);
            if (i18 > 0) {
                return this.mFormatter.format("%d:%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)).toString();
            }
            return this.mFormatter.format("%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i16)).toString();
        }
    }

    /* loaded from: classes35.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFullLivePlayBack.this.P;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequsetJumpAdvUrl();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PlayerUtils.log(4, "FeedAutoVideoFull", "mVideoClickListener onClick: state=" + FeedAutoVideoFullLivePlayBack.this.getState());
            if (FeedAutoVideoFullLivePlayBack.this.getVideoPlayInfo() == null) {
                PlayerUtils.log(6, "FeedAutoVideoFull", "mVideoClickListener onClick: getVideoPlayInfo() is null");
            } else if (FeedAutoVideoFullLivePlayBack.this.getState() != 3 && FeedAutoVideoFullLivePlayBack.this.getState() != 5 && !BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                if (FeedAutoVideoFullLivePlayBack.this.getState() == 1) {
                    if (FeedAutoVideoFullLivePlayBack.this.getVideoPlayInfo().f()) {
                        FeedAutoVideoFullLivePlayBack.this.Q = false;
                    }
                    FeedAutoVideoFullLivePlayBack.this.getBaseVideoManager().startVideo(FeedAutoVideoFullLivePlayBack.this);
                }
            } else {
                if (FeedAutoVideoFullLivePlayBack.this.getState() == 5) {
                    FeedAutoVideoFullLivePlayBack.this.Q = false;
                }
                FeedAutoVideoFullLivePlayBack.this.f279749f.show();
                FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack = FeedAutoVideoFullLivePlayBack.this;
                feedAutoVideoFullLivePlayBack.S = true;
                feedAutoVideoFullLivePlayBack.D();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes35.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoFullLivePlayBack.this.f279749f.doPauseResume();
            if (FeedAutoVideoFullLivePlayBack.this.f279763p0.isPlaying()) {
                FeedAutoVideoFullLivePlayBack.this.Q = false;
            } else {
                FeedAutoVideoFullLivePlayBack.this.Q = true;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes35.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FeedAutoVideoFullLivePlayBack.this.f279763p0.isFullScreen()) {
                FeedAutoVideoFullLivePlayBack.this.f279763p0.toggleFullScreen();
                FeedAutoVideoFullLivePlayBack.this.f279749f.show(VideoControllerView.sDefaultTimeout);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes35.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoFullLivePlayBack.this.G();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes35.dex */
    class i implements RotationSeekBar.OnRotationChangeListener {
        i() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar.OnRotationChangeListener
        public int getCurRotate() {
            OperationContainer operationContainer = FeedAutoVideoFullLivePlayBack.this.L;
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

    public FeedAutoVideoFullLivePlayBack(Context context) {
        super(context);
        this.f279745d = 3000;
        this.f279747e = 950;
        this.F = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.J = true;
        this.K = false;
        this.Q = false;
        this.V = new d();
        this.f279763p0 = new MediaPlayerControl();
        this.f279764q0 = 300;
        x();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(MotionEvent motionEvent) {
        this.f279759m = motionEvent.getX();
        this.C = motionEvent.getY();
        this.D = Math.abs(this.f279759m - this.f279752h);
        this.E = Math.abs(this.C - this.f279754i);
        float f16 = this.D;
        double sqrt = Math.sqrt((f16 * f16) + (r6 * r6));
        if (this.E <= this.F || sqrt < this.D * 2.0f) {
            return false;
        }
        if (this.C >= this.f279754i) {
            VideoControllerView.OnControllerEventListener onControllerEventListener = this.P;
            if (onControllerEventListener != null) {
                onControllerEventListener.onGestureMoveDown();
            }
        } else {
            VideoControllerView.OnControllerEventListener onControllerEventListener2 = this.P;
            if (onControllerEventListener2 != null) {
                onControllerEventListener2.onGestureMoveUp();
            }
        }
        return true;
    }

    private void B() {
        View view;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || (view = this.N) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        v();
        this.f279746d0 = true;
        getBaseVideoManager().switchVideoStream(this, 3);
        VideoControllerView.OnControllerEventListener onControllerEventListener = this.P;
        if (onControllerEventListener != null) {
            onControllerEventListener.onRequestOriginalVideo();
        }
    }

    private void initData() {
        e eVar = new e();
        this.mVideoClickListener = eVar;
        setOnClickListener(eVar);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.3

            /* renamed from: d, reason: collision with root package name */
            private long f279771d;

            /* renamed from: e, reason: collision with root package name */
            private int f279772e;

            /* renamed from: f, reason: collision with root package name */
            private Runnable f279773f = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.3.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideoFullLivePlayBack.this.performClick();
                }
            };

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FeedAutoVideoFullLivePlayBack.this.isUse360VideoRender()) {
                    return FeedAutoVideoFullLivePlayBack.this.onTouchExt(view, motionEvent);
                }
                long currentTimeMillis = System.currentTimeMillis();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 || FeedAutoVideoFullLivePlayBack.this.A(motionEvent)) {
                        return true;
                    }
                    if (currentTimeMillis - this.f279771d > 3000) {
                        FeedAutoVideoFullLivePlayBack.this.performLongClick();
                        return true;
                    }
                    if (this.f279772e != 1 && FeedAutoVideoFullLivePlayBack.this.y()) {
                        if (this.f279772e == 2) {
                            FeedAutoVideoFullLivePlayBack.this.f279763p0.toggleFullScreen();
                        }
                    } else {
                        FeedAutoVideoFullLivePlayBack.this.postDelayed(this.f279773f, 400L);
                    }
                } else {
                    FeedAutoVideoFullLivePlayBack.this.w();
                    FeedAutoVideoFullLivePlayBack.this.z(motionEvent);
                    FeedAutoVideoFullLivePlayBack.this.removeCallbacks(this.f279773f);
                    long j3 = this.f279771d;
                    if (j3 != 0 && currentTimeMillis - j3 > 300) {
                        this.f279772e = 0;
                    }
                    this.f279772e++;
                    this.f279771d = currentTimeMillis;
                }
                return true;
            }
        });
    }

    private void p() {
        View view;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || (view = this.N) == null) {
            return;
        }
        viewGroup.removeView(view);
        viewGroup.addView(this.N, 0, new ViewGroup.LayoutParams(-1, -1));
        this.N.bringToFront();
    }

    private void q() {
        ((ViewGroup) getParent()).setContentDescription("videoContainer");
        if (this.T.getLayoutParams() == null) {
            this.T.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.T);
        }
        VideoExtendedAnimationView videoExtendedAnimationView = this.T;
        BaseVideoCover baseVideoCover = this.mVideoCover;
        videoExtendedAnimationView.setContainerDimensionOverride(baseVideoCover.picWidth, baseVideoCover.picHeight, true);
        this.T.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        TextView textView;
        if (this.M == null || (textView = this.R) == null) {
            return;
        }
        textView.setVisibility(8);
        B();
    }

    private void v() {
        if (this.f279744c0 != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(this.f279764q0);
            alphaAnimation.setAnimationListener(new c());
            this.f279744c0.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(MotionEvent motionEvent) {
        this.f279752h = motionEvent.getX();
        this.f279754i = motionEvent.getY();
    }

    protected void C() {
        MediaPlayerControl mediaPlayerControl = this.f279763p0;
        if (mediaPlayerControl == null || !mediaPlayerControl.isFullScreen()) {
            return;
        }
        p();
        FeedAutoVideoControllerView feedAutoVideoControllerView = this.f279749f;
        if (feedAutoVideoControllerView != null) {
            feedAutoVideoControllerView.bringToFront();
        }
        TipFloatContainer tipFloatContainer = this.M;
        if (tipFloatContainer != null) {
            tipFloatContainer.bringToFront();
        }
        E();
    }

    public void D() {
        this.f279749f.updateLayout();
        TextView textView = this.f279744c0;
        if (textView != null) {
            if (this.f279746d0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
        if (this.f279763p0.isFullScreen()) {
            this.f279743b0.setVisibility(0);
            LinearLayout linearLayout = this.f279750f0;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            TextView textView2 = this.f279751g0;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.f279753h0;
            if (textView3 != null && ((CellTextView) ((ViewGroup) textView3.getParent()).getChildAt(0)).getVisibility() != 0) {
                this.f279753h0.setVisibility(0);
            }
            LinearLayout linearLayout2 = this.f279755i0;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            this.f279743b0.setVisibility(8);
            LinearLayout linearLayout3 = this.f279750f0;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            TextView textView4 = this.f279751g0;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.f279753h0;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.f279755i0;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(this.f279764q0);
        alphaAnimation.setAnimationListener(new b());
        this.L.startAnimation(alphaAnimation);
    }

    public void E() {
        F();
        if (this.f279761n0 == null) {
            CountDownTimer countDownTimer = new CountDownTimer(3000L, 950L) { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.10

                /* renamed from: a, reason: collision with root package name */
                private int f279767a = 3;

                static /* synthetic */ int a(AnonymousClass10 anonymousClass10) {
                    int i3 = anonymousClass10.f279767a;
                    anonymousClass10.f279767a = i3 - 1;
                    return i3;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedAutoVideoFullLivePlayBack.this.s();
                        }
                    });
                    VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFullLivePlayBack.this.P;
                    if (onControllerEventListener != null) {
                        onControllerEventListener.onGestureMoveUp();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    if (FeedAutoVideoFullLivePlayBack.this.M == null || FeedAutoVideoFullLivePlayBack.this.R == null) {
                        return;
                    }
                    PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedAutoVideoFullLivePlayBack.this.R.setVisibility(0);
                            FeedAutoVideoFullLivePlayBack.this.R.setText(AnonymousClass10.a(AnonymousClass10.this) + "\u79d2\u540e\u64ad\u653e\u4e0b\u4e00\u89c6\u9891");
                        }
                    });
                }
            };
            this.f279761n0 = countDownTimer;
            countDownTimer.start();
        }
    }

    public void F() {
        CountDownTimer countDownTimer = this.f279761n0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f279761n0 = null;
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        this.mVideoCover = new AutoVideoCoverFull(context, this);
        addView(this.mVideoCover, new ViewGroup.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initChildView() {
        super.initChildView();
        FeedAutoVideoControllerView feedAutoVideoControllerView = new FeedAutoVideoControllerView(getContext(), FeedVideoEnv.playerResources);
        this.f279749f = feedAutoVideoControllerView;
        feedAutoVideoControllerView.setVisibility(0);
        this.L = (OperationContainer) LayoutInflater.from(getContext()).inflate(FeedVideoEnv.feedResources.getLayoutId(9), (ViewGroup) null);
        int layoutId = FeedVideoEnv.playerResources.getLayoutId(5);
        if (layoutId != 0) {
            TipFloatContainer tipFloatContainer = (TipFloatContainer) LayoutInflater.from(getContext()).inflate(layoutId, (ViewGroup) null);
            this.M = tipFloatContainer;
            if (tipFloatContainer != null) {
                this.R = (TextView) tipFloatContainer.findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.NEXT_VIDEO_COUNT_DOWN_TIP));
            }
        }
        View view = new View(getContext());
        this.N = view;
        view.setBackgroundColor(Color.parseColor("#66000000"));
        this.N.setVisibility(0);
        ImageView imageView = (ImageView) this.L.findViewById(FeedVideoEnv.playerResources.getViewId(550));
        this.f279742a0 = imageView;
        imageView.setOnClickListener(new f());
        ImageView imageView2 = (ImageView) this.L.findViewById(FeedVideoEnv.feedResources.getViewId(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST));
        this.f279743b0 = imageView2;
        imageView2.setOnClickListener(new g());
        this.f279750f0 = (LinearLayout) this.L.findViewById(FeedVideoEnv.feedResources.getViewId(588));
        this.f279751g0 = (TextView) this.L.findViewById(FeedVideoEnv.feedResources.getViewId(com.tencent.luggage.wxa.c3.f.CTRL_INDEX));
        this.f279753h0 = (TextView) this.L.findViewById(FeedVideoEnv.feedResources.getViewId(c0.CTRL_INDEX));
        this.f279755i0 = (LinearLayout) this.L.findViewById(FeedVideoEnv.feedResources.getViewId(591));
        this.L.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.6

            /* renamed from: d, reason: collision with root package name */
            private long f279776d;

            /* renamed from: e, reason: collision with root package name */
            private int f279777e;

            /* renamed from: f, reason: collision with root package name */
            private Runnable f279778f = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.6.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideoFullLivePlayBack.this.f279749f.startFadeout(0);
                }
            };

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction() & 255;
                long currentTimeMillis = System.currentTimeMillis();
                if (action == 0) {
                    FeedAutoVideoFullLivePlayBack.this.z(motionEvent);
                    FeedAutoVideoFullLivePlayBack.this.removeCallbacks(this.f279778f);
                    if (currentTimeMillis - this.f279776d > 400) {
                        this.f279777e = 0;
                    }
                    this.f279777e++;
                    this.f279776d = currentTimeMillis;
                    FeedAutoVideoFullLivePlayBack.this.f279749f.cancelFadeout();
                    return true;
                }
                if (action == 1 || action == 3) {
                    if (FeedAutoVideoFullLivePlayBack.this.A(motionEvent)) {
                        return true;
                    }
                    if (currentTimeMillis - this.f279776d > 500) {
                        FeedAutoVideoFullLivePlayBack.this.f279749f.startFadeout();
                    }
                    if (this.f279777e != 1 && FeedAutoVideoFullLivePlayBack.this.y()) {
                        FeedAutoVideoFullLivePlayBack.this.f279763p0.toggleFullScreen();
                    } else {
                        FeedAutoVideoFullLivePlayBack.this.postDelayed(this.f279778f, 400L);
                    }
                }
                return false;
            }
        });
        int layoutId2 = FeedVideoEnv.playerResources.getLayoutId(6);
        if (layoutId2 != 0) {
            VideoExtendedAnimationView videoExtendedAnimationView = (VideoExtendedAnimationView) LayoutInflater.from(getContext()).inflate(layoutId2, (ViewGroup) null);
            this.T = videoExtendedAnimationView;
            if (videoExtendedAnimationView != null) {
                videoExtendedAnimationView.f();
                this.T.setItemOnTouchListener();
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
            this.f279749f.setVideoDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            if (this.f279758l0) {
                defaultSize = this.f279756j0;
                defaultSize2 = this.f279757k0;
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
        VideoExtendedAnimationView videoExtendedAnimationView = this.T;
        if (videoExtendedAnimationView != null) {
            videoExtendedAnimationView.setContainerDimensionOverride(this.mVideoCover.getMeasuredWidth(), this.mVideoCover.getMeasuredHeight(), true);
            this.T.measure(this.mVideoCover.getMeasuredWidth(), this.mVideoCover.getMeasuredHeight());
            this.T.setLayoutParams(this.mVideoCover.getLayoutParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        super.onReceivedMessage(message);
        int i3 = message.what;
        if (i3 == 1) {
            if (this.f279749f.isShowing()) {
                this.f279749f.updatePausePlay();
            }
            this.f279763p0.isRawPaused = false;
            getBaseVideoManager().enableAutoVideoSound();
            return;
        }
        if (i3 == 2) {
            v();
            return;
        }
        if (i3 == 17) {
            getBaseVideoManager().enableAutoVideoSound();
            this.f279748e0 = true;
            return;
        }
        if (i3 == 20) {
            getBaseVideoManager().enableAutoVideoSound();
            this.f279748e0 = true;
        } else {
            if (i3 != 23) {
                return;
            }
            VideoExtendedAnimationView videoExtendedAnimationView = this.T;
            if (videoExtendedAnimationView == null || videoExtendedAnimationView.getVisibility() != 0) {
                C();
            }
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public void onRecycled() {
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder;
        if (this.f279766s0 && (globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder.oldSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFull", "mWillSwitchToWindow true, onPause does nothing");
            return;
        }
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder2 = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder();
        if (globalChangeSurfaceHolder2 != null && globalChangeSurfaceHolder2.newSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFull", "onRecycled does nothing");
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
        this.f279762o0 = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoSizeChanged(int i3, int i16) {
        super.onVideoSizeChanged(i3, i16);
    }

    protected void r() {
        PlayerUtils.runOnUiThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.17
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack = FeedAutoVideoFullLivePlayBack.this;
                feedAutoVideoFullLivePlayBack.f279749f.setMediaPlayer(feedAutoVideoFullLivePlayBack.f279763p0);
                FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack2 = FeedAutoVideoFullLivePlayBack.this;
                VideoPlayInfo videoPlayInfo = feedAutoVideoFullLivePlayBack2.mVideoPlayInfo;
                if (videoPlayInfo != null && videoPlayInfo.isAdvMicro) {
                    feedAutoVideoFullLivePlayBack2.f279749f.updateLayout();
                    return;
                }
                feedAutoVideoFullLivePlayBack2.f279749f.show();
                FeedAutoVideoFullLivePlayBack feedAutoVideoFullLivePlayBack3 = FeedAutoVideoFullLivePlayBack.this;
                feedAutoVideoFullLivePlayBack3.S = false;
                feedAutoVideoFullLivePlayBack3.D();
            }
        }, 300L);
    }

    public void setActivityWillDestroy(boolean z16) {
        this.f279765r0 = z16;
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.f279756j0 = i3;
        this.f279757k0 = i16;
        this.f279758l0 = z16;
    }

    public void setMediaControllerListener(MediaControllerListener mediaControllerListener) {
        this.W = mediaControllerListener;
    }

    public void setOnControllerEventListener(VideoControllerView.OnControllerEventListener onControllerEventListener) {
        this.P = onControllerEventListener;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        super.setVideoPlayInfo(videoPlayInfo);
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.setContentDescription("videoContainer");
        if (!this.f279760m0) {
            viewGroup.addView(this.L);
            TipFloatContainer tipFloatContainer = this.M;
            if (tipFloatContainer != null) {
                viewGroup.addView(tipFloatContainer);
            }
            this.f279749f.setContentDescription("videoController");
            this.f279749f.setAnchorView(this.L);
            this.f279749f.setVideoView(this);
            this.f279749f.setMediaPlayer(this.f279763p0);
            this.f279749f.setEnabled(true);
            this.f279760m0 = true;
        }
        if (this.L != null) {
            this.f279749f.cancelFadeout();
            this.L.setVisibility(8);
        }
        LinearLayout linearLayout = this.f279750f0;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            View avatarImageView = FeedVideoEnv.externalFunc.getAvatarImageView(getContext(), videoPlayInfo.authorUin);
            this.f279750f0.addView(avatarImageView);
            ViewGroup.LayoutParams layoutParams = avatarImageView.getLayoutParams();
            int i3 = FeedVideoEnv.dp37;
            layoutParams.width = i3;
            layoutParams.height = i3;
            avatarImageView.setLayoutParams(layoutParams);
        }
        TextView textView = this.f279751g0;
        if (textView != null) {
            textView.setText(videoPlayInfo.authorNickname);
        }
        TextView textView2 = this.f279753h0;
        if (textView2 != null) {
            textView2.setText(videoPlayInfo.displayFeedTime);
        }
        if (videoPlayInfo.segmentVideoInfo.getDefaultUrl().startsWith("/")) {
            this.f279762o0 = 100;
        }
        this.f279744c0 = null;
        if (videoPlayInfo.segmentVideoInfo.getStreamInfo(3) != null && this.f279744c0 == null) {
            TextView textView3 = (TextView) this.L.findViewById(FeedVideoEnv.feedResources.getViewId(586));
            this.f279744c0 = textView3;
            textView3.setOnClickListener(new h());
            if (VideoManager.getInstance().isCached(videoPlayInfo.segmentVideoInfo.getStreamInfo(3))) {
                G();
            }
        }
        MediaPlayerControl mediaPlayerControl = this.f279763p0;
        if (mediaPlayerControl != null) {
            mediaPlayerControl.isRawPaused = false;
            this.f279763p0.mLastCurrentPosition = 0;
        }
        this.f279748e0 = false;
        FeedAutoVideoControllerView feedAutoVideoControllerView = this.f279749f;
        if (feedAutoVideoControllerView != null) {
            feedAutoVideoControllerView.setSeekbarRotationChangeListener(new i());
        }
        this.U = videoPlayInfo.needVideoExtendedAnimation;
        if (this.T != null) {
            q();
            this.T.setVisibility(8);
        }
        this.f279749f.markAtPosition(videoPlayInfo.lightSpotInfo);
    }

    public void setWillSwitchToWindow(boolean z16) {
        this.f279766s0 = z16;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void stop() {
        super.stop();
        setShowCoverImage(true);
    }

    public void t() {
        if (this.L.getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(this.f279764q0);
        alphaAnimation.setAnimationListener(new a());
        this.L.startAnimation(alphaAnimation);
    }

    public void u() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.15
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFullLivePlayBack.this.f279749f.cancelFadeout();
                FeedAutoVideoFullLivePlayBack.this.L.setVisibility(4);
            }
        });
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void update() {
        MediaPlayerControl mediaPlayerControl;
        super.update();
        if (this.isAutoPlay && this.I && (mediaPlayerControl = this.f279763p0) != null && mediaPlayerControl.isRawPaused) {
            this.f279763p0.pause();
        }
        this.I = false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void updateWithoutDelay(boolean z16) {
        super.updateWithoutDelay(z16);
        r();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void videoUIStop() {
        super.videoUIStop();
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.11
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFullLivePlayBack.this.f279749f.hide();
                FeedAutoVideoFullLivePlayBack.this.u();
            }
        });
    }

    public void w() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFullLivePlayBack.16
            @Override // java.lang.Runnable
            public void run() {
                if (FeedAutoVideoFullLivePlayBack.this.M != null) {
                    FeedAutoVideoFullLivePlayBack.this.R.setVisibility(8);
                    FeedAutoVideoFullLivePlayBack.this.F();
                }
            }
        });
    }

    protected boolean y() {
        return true;
    }

    private void x() {
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
        if (this.f279766s0 && (globalChangeSurfaceHolder2 = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder2.oldSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFull", "mWillSwitchToWindow true, onPause does nothing");
        } else if (this.f279765r0 && (globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder.newSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFull", "mIsActivityWillDestroy true, onPause does nothing");
        } else {
            super.onPause();
        }
    }

    public FeedAutoVideoFullLivePlayBack(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279745d = 3000;
        this.f279747e = 950;
        this.F = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.J = true;
        this.K = false;
        this.Q = false;
        this.V = new d();
        this.f279763p0 = new MediaPlayerControl();
        this.f279764q0 = 300;
        x();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FeedAutoVideoFullLivePlayBack.this.L.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PlayerUtils.log(4, "FeedAutoVideoFull", "SHOW");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            FeedAutoVideoFullLivePlayBack.this.L.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (FeedAutoVideoFullLivePlayBack.this.f279744c0 != null) {
                FeedAutoVideoFullLivePlayBack.this.f279744c0.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void setFeedAutoVideoFullFunc(com.tencent.mobileqq.qzoneplayer.video.a aVar) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void showValidTimeText() {
    }

    public FeedAutoVideoFullLivePlayBack(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f279745d = 3000;
        this.f279747e = 950;
        this.F = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.J = true;
        this.K = false;
        this.Q = false;
        this.V = new d();
        this.f279763p0 = new MediaPlayerControl();
        this.f279764q0 = 300;
        x();
        initData();
    }
}
