package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoCoverOpenTrafficText;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.wrapper.BaseVideoCoverUIWrapper;
import com.tencent.mobileqq.qzoneplayer.cover.wrapper.ICoverWrapper;
import com.tencent.mobileqq.qzoneplayer.ui.RotationSeekBar;
import com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeedAutoVideoFull extends BaseVideo {
    private int A0;
    protected h B0;
    private float C;
    private int C0;
    private float D;
    protected boolean D0;
    private float E;
    protected boolean E0;
    private float F;
    int G;
    private boolean H;
    private boolean I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    private int M;
    private int N;
    protected OperationContainer P;
    private TipFloatContainer Q;
    protected RelativeLayout R;
    private View S;
    protected VideoControllerView.OnControllerEventListener T;
    protected boolean U;
    private TextView V;
    protected boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private VideoExtendedAnimationView f279632a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f279633b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f279634c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f279635d;

    /* renamed from: d0, reason: collision with root package name */
    private MediaControllerListener f279636d0;

    /* renamed from: e, reason: collision with root package name */
    protected FeedAutoVideoControllerView f279637e;

    /* renamed from: e0, reason: collision with root package name */
    protected ImageView f279638e0;

    /* renamed from: f, reason: collision with root package name */
    protected View f279639f;

    /* renamed from: f0, reason: collision with root package name */
    protected ImageView f279640f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ImageView f279641g0;

    /* renamed from: h, reason: collision with root package name */
    protected RotationSeekBar f279642h;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f279643h0;

    /* renamed from: i, reason: collision with root package name */
    private float f279644i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f279645i0;

    /* renamed from: j0, reason: collision with root package name */
    protected LinearLayout f279646j0;

    /* renamed from: k0, reason: collision with root package name */
    protected TextView f279647k0;

    /* renamed from: l0, reason: collision with root package name */
    protected TextView f279648l0;

    /* renamed from: m, reason: collision with root package name */
    private float f279649m;

    /* renamed from: m0, reason: collision with root package name */
    private LinearLayout f279650m0;

    /* renamed from: n0, reason: collision with root package name */
    protected CellTextView f279651n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f279652o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f279653p0;

    /* renamed from: q0, reason: collision with root package name */
    protected LinearLayout f279654q0;

    /* renamed from: r0, reason: collision with root package name */
    protected int f279655r0;

    /* renamed from: s0, reason: collision with root package name */
    protected int f279656s0;

    /* renamed from: t0, reason: collision with root package name */
    protected boolean f279657t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f279658u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f279659v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f279660w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f279661x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f279662y0;

    /* renamed from: z0, reason: collision with root package name */
    private CountDownTimer f279663z0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull$9, reason: invalid class name */
    /* loaded from: classes35.dex */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ FeedAutoVideoFull this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f279632a0 != null) {
                this.this$0.f279632a0.setVisibility(4);
                this.this$0.f279632a0.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ec, code lost:
        
            if (r0.mWarnType != com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover.CoverWarnType.DEFAULT) goto L66;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            h hVar;
            VideoPlayInfo videoPlayInfo;
            boolean z16;
            FeedVideoElement feedVideoElement;
            EventCollector.getInstance().onViewClickedBefore(view);
            PlayerUtils.log(4, "FeedAutoVideoFull", "mVideoClickListener onClick: state=" + FeedAutoVideoFull.this.getState());
            if (FeedAutoVideoFull.this.getVideoPlayInfo() == null) {
                PlayerUtils.log(6, "FeedAutoVideoFull", "mVideoClickListener onClick: getVideoPlayInfo() is null");
            } else if (FeedAutoVideoFull.this.getState() != 3 && FeedAutoVideoFull.this.getState() != 5 && !BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                if (FeedAutoVideoFull.this.getState() == 1) {
                    if (FeedAutoVideoFull.this.getVideoPlayInfo().f()) {
                        FeedAutoVideoFull.this.U = false;
                    }
                    FeedAutoVideoFull.this.getBaseVideoManager().startVideo(FeedAutoVideoFull.this);
                } else if (FeedAutoVideoFull.this.getState() == 8 && FeedAutoVideoFull.this.B0.isFullScreen()) {
                    FeedAutoVideoFull.this.I();
                }
            } else {
                FeedAutoVideoFull feedAutoVideoFull = FeedAutoVideoFull.this;
                VideoPlayInfo videoPlayInfo2 = feedAutoVideoFull.mVideoPlayInfo;
                if (videoPlayInfo2 != null && (((z16 = videoPlayInfo2.isAdvMicro) || videoPlayInfo2.isAdFeeds || videoPlayInfo2.isLiveVideo) && !videoPlayInfo2.isFromFeedVideoAdv)) {
                    com.tencent.mobileqq.qzoneplayer.video.g gVar = feedAutoVideoFull.onFeedVideoElementClickListener;
                    if (gVar != null) {
                        if (z16) {
                            feedVideoElement = FeedVideoElement.ADV_MICRO;
                        } else {
                            feedVideoElement = FeedVideoElement.AUTO_VIDEO;
                        }
                        gVar.onClick(view, feedVideoElement, feedAutoVideoFull.feedPosition, videoPlayInfo2);
                        FeedAutoVideoFull.this.f279637e.updateLayout();
                        FeedAutoVideoFull feedAutoVideoFull2 = FeedAutoVideoFull.this;
                        VideoPlayInfo videoPlayInfo3 = feedAutoVideoFull2.mVideoPlayInfo;
                        if (videoPlayInfo3.isGdtAd || videoPlayInfo3.needAdvReport) {
                            feedAutoVideoFull2.W = true;
                            feedAutoVideoFull2.I();
                            FeedAutoVideoFull.this.f279637e.show();
                        }
                    }
                    FeedAutoVideoFull.this.f279637e.show();
                    hVar = FeedAutoVideoFull.this.B0;
                    if (hVar == null) {
                    }
                    videoPlayInfo = FeedAutoVideoFull.this.mVideoPlayInfo;
                    if (videoPlayInfo == null) {
                    }
                    FeedAutoVideoFull.this.setVideoInfoVisible(0);
                    FeedAutoVideoFull feedAutoVideoFull3 = FeedAutoVideoFull.this;
                    feedAutoVideoFull3.W = true;
                    feedAutoVideoFull3.I();
                } else {
                    if (feedAutoVideoFull.getState() == 5) {
                        FeedAutoVideoFull feedAutoVideoFull4 = FeedAutoVideoFull.this;
                        feedAutoVideoFull4.U = false;
                        BaseVideoCover baseVideoCover = feedAutoVideoFull4.mVideoCover;
                        if (baseVideoCover != null) {
                        }
                    }
                    FeedAutoVideoFull.this.f279637e.show();
                    hVar = FeedAutoVideoFull.this.B0;
                    if (hVar == null && (hVar.isFullScreen() || FeedAutoVideoFull.this.B0.isLandscape())) {
                        FeedAutoVideoFull.this.setVideoInfoVisible(8);
                    } else {
                        videoPlayInfo = FeedAutoVideoFull.this.mVideoPlayInfo;
                        if (videoPlayInfo == null && videoPlayInfo.e()) {
                            FeedAutoVideoFull.this.setVideoInfoVisible(8);
                        } else {
                            FeedAutoVideoFull.this.setVideoInfoVisible(0);
                        }
                    }
                    FeedAutoVideoFull feedAutoVideoFull32 = FeedAutoVideoFull.this;
                    feedAutoVideoFull32.W = true;
                    feedAutoVideoFull32.I();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedAutoVideoFull.this.f279637e.doPauseResume();
            if (FeedAutoVideoFull.this.B0.isPlaying()) {
                FeedAutoVideoFull.this.U = false;
            } else {
                FeedAutoVideoFull.this.U = true;
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
            if (FeedAutoVideoFull.this.B0.isFullScreen()) {
                FeedAutoVideoFull.this.B0.toggleFullScreen();
                FeedAutoVideoFull.this.f279637e.show();
                FeedAutoVideoFull.this.setVideoInfoVisible(0);
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
            FeedAutoVideoFull.this.L();
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
            OperationContainer operationContainer = FeedAutoVideoFull.this.P;
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
        private boolean f279688a;

        /* renamed from: b, reason: collision with root package name */
        private StringBuilder f279689b = new StringBuilder();

        /* renamed from: c, reason: collision with root package name */
        private Formatter f279690c = new Formatter(this.f279689b, Locale.getDefault());

        /* renamed from: d, reason: collision with root package name */
        private int f279691d;

        /* renamed from: e, reason: collision with root package name */
        private int f279692e;

        public h() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canPausePlay() {
            return FeedAutoVideoFull.this.getState() == 3 || FeedAutoVideoFull.this.getState() == 5 || FeedAutoVideoFull.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canSeekBackward() {
            return FeedAutoVideoFull.this.f279645i0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean canSeekForward() {
            return FeedAutoVideoFull.this.f279645i0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean enableToggleFullScreen() {
            return FeedAutoVideoFull.this.K;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean enableToggleLandscape() {
            return FeedAutoVideoFull.this.L;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getBufferPercentage() {
            return FeedAutoVideoFull.this.A0;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getCurrentPosition() {
            Object h16 = FeedAutoVideoFull.this.getBaseVideoManager().h();
            if (h16 == null) {
                return this.f279691d;
            }
            int i3 = this.f279692e;
            if (i3 != 0) {
                this.f279691d = Math.max(i3, ((Integer) h16).intValue());
            } else {
                this.f279691d = ((Integer) h16).intValue();
            }
            return this.f279691d;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public int getDuration() {
            Object duration = FeedAutoVideoFull.this.getBaseVideoManager().getDuration();
            if (duration == null) {
                return 0;
            }
            return ((Integer) duration).intValue();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public String getVideoUriWithUuid() {
            return FeedAutoVideoFull.this.getBaseVideoManager().i();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void hideTopBar() {
            FeedAutoVideoFull feedAutoVideoFull = FeedAutoVideoFull.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFull.T;
            if (onControllerEventListener != null) {
                onControllerEventListener.onControllerHide(feedAutoVideoFull);
            }
            FeedAutoVideoFull.this.t();
            FeedAutoVideoFull.this.setVideoInfoVisible(8);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isFullScreen() {
            FeedAutoVideoFull.this.getClass();
            return FeedAutoVideoFull.this.I;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isLandscape() {
            FeedAutoVideoFull.this.getClass();
            return false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isLoading() {
            return FeedAutoVideoFull.this.getState() == 2;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isPlayComplete() {
            return FeedAutoVideoFull.this.getState() == 4 || FeedAutoVideoFull.this.getState() == 1;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public boolean isPlaying() {
            return FeedAutoVideoFull.this.getState() == 3 && !this.f279688a;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void pause() {
            FeedAutoVideoFull.this.setState(5);
            this.f279688a = true;
            FeedAutoVideoFull.this.getBaseVideoManager().pauseVideo();
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFull.this.T;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestPauseVideo();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void seekTo(int i3) {
            boolean z16;
            if (FeedAutoVideoFull.this.getState() != 5) {
                FeedAutoVideoFull.this.setState(2);
                z16 = false;
            } else {
                z16 = true;
            }
            FeedAutoVideoFull.this.getBaseVideoManager().seekVideoRealManual(i3);
            FeedAutoVideoFull.this.f279637e.postSetProgress();
            if (FeedAutoVideoFull.this.getState() == 3 && this.f279688a) {
                this.f279688a = false;
            }
            if (z16) {
                pause();
            }
            FeedAutoVideoFull.this.f279637e.updatePausePlay();
            FeedAutoVideoFull.this.f279637e.show();
            h hVar = FeedAutoVideoFull.this.B0;
            if (hVar == null || hVar.isFullScreen() || FeedAutoVideoFull.this.B0.isLandscape()) {
                return;
            }
            FeedAutoVideoFull.this.setVideoInfoVisible(0);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void setRate(float f16) {
            FeedAutoVideoFull.this.getBaseVideoManager().I(f16);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void toggleFullScreen() {
            BaseVideoPresenter baseVideoPresenter;
            FeedAutoVideoFull feedAutoVideoFull = FeedAutoVideoFull.this;
            if (feedAutoVideoFull.K) {
                feedAutoVideoFull.I = !feedAutoVideoFull.I;
                FeedAutoVideoFull feedAutoVideoFull2 = FeedAutoVideoFull.this;
                VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFull2.T;
                if (onControllerEventListener != null) {
                    onControllerEventListener.onRequestToggleFullscreen(feedAutoVideoFull2, feedAutoVideoFull2.I);
                }
                if (FeedAutoVideoFull.this.isBaseVideoCoverWrapperNotNull() && (baseVideoPresenter = FeedAutoVideoFull.this.mVideoCoverPresenter) != null) {
                    baseVideoPresenter.setFullScreenMode(isFullScreen());
                }
                if (isFullScreen()) {
                    FeedAutoVideoFull.this.M(0);
                } else {
                    FeedAutoVideoFull.this.M(8);
                }
                FeedAutoVideoFull.this.f279637e.updateLayout();
                if (FeedAutoVideoFull.this.isBaseVideoCoverWrapperNotNull()) {
                    ViewGroup.LayoutParams layoutParams = FeedAutoVideoFull.this.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams2 = FeedAutoVideoFull.this.mVideoCoverWrapper.getCover().getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    }
                    if (layoutParams != null) {
                        layoutParams2.width = layoutParams.width;
                        layoutParams2.height = layoutParams.height;
                    }
                    FeedAutoVideoFull.this.mVideoCoverWrapper.getCover().setLayoutParams(layoutParams2);
                } else if (FeedAutoVideoFull.this.isVideoCoverNotNull()) {
                    ((AutoVideoCoverFull) FeedAutoVideoFull.this.mVideoCover).a();
                }
                FeedAutoVideoFull.this.f279637e.updateFullScreen();
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void toggleLandscape() {
            FeedAutoVideoFull.this.H = !r0.H;
            FeedAutoVideoFull feedAutoVideoFull = FeedAutoVideoFull.this;
            VideoControllerView.OnControllerEventListener onControllerEventListener = feedAutoVideoFull.T;
            if (onControllerEventListener != null) {
                onControllerEventListener.onRequestToggleLandscape(feedAutoVideoFull, feedAutoVideoFull.H);
            }
            FeedAutoVideoFull.this.f279637e.updateLandscapeIndicator();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void updatePlayPauseButton() {
            if (FeedAutoVideoFull.this.f279636d0 != null) {
                FeedAutoVideoFull.this.f279636d0.onUpdatePlayPauseButton();
            }
            FeedAutoVideoFull feedAutoVideoFull = FeedAutoVideoFull.this;
            if (feedAutoVideoFull.f279638e0 == null) {
                return;
            }
            if (feedAutoVideoFull.getState() != 2 && FeedAutoVideoFull.this.getState() != 0 && FeedAutoVideoFull.this.getState() != 1) {
                FeedAutoVideoFull feedAutoVideoFull2 = FeedAutoVideoFull.this;
                feedAutoVideoFull2.f279638e0.setVisibility(feedAutoVideoFull2.W ? 0 : 8);
            } else {
                FeedAutoVideoFull.this.f279638e0.setVisibility(8);
            }
            if (isPlaying()) {
                FeedAutoVideoFull.this.f279638e0.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1093));
            } else {
                FeedAutoVideoFull.this.f279638e0.setImageResource(FeedVideoEnv.playerResources.getDrawableId(1094));
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.MediaPlayerControl
        public void start() {
            this.f279688a = false;
            FeedAutoVideoFull.this.setState(3);
            FeedAutoVideoFull.this.getBaseVideoManager().startVideoReal();
            if (FeedAutoVideoFull.this.isBaseVideoCoverWrapperNotNull()) {
                FeedAutoVideoFull.this.mVideoCoverWrapper.getCover().requestLayout();
            } else if (FeedAutoVideoFull.this.isVideoCoverNotNull()) {
                FeedAutoVideoFull.this.mVideoCover.requestLayout();
            }
            if (!FeedAutoVideoFull.this.getBaseVideoManager().isCurSoundOpened()) {
                FeedAutoVideoFull.this.getBaseVideoManager().enableAutoVideoSound();
            }
            VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFull.this.T;
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
            this.f279689b.setLength(0);
            if (i18 > 0) {
                return this.f279690c.format("%d:%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)).toString();
            }
            return this.f279690c.format("%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i16)).toString();
        }
    }

    public FeedAutoVideoFull(Context context) {
        super(context);
        this.f279635d = 950;
        this.G = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.K = true;
        this.L = false;
        this.U = false;
        this.f279659v0 = false;
        this.f279660w0 = false;
        this.f279661x0 = false;
        this.f279662y0 = false;
        this.B0 = new h();
        this.C0 = 300;
        y();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        return getVideoPlayInfo() != null && (getVideoPlayInfo().videoFeedsType == 1 || getVideoPlayInfo().videoFeedsType == 2);
    }

    private void G() {
        View view = this.S;
        if (view != null) {
            removeView(view);
        }
    }

    private void N() {
        ImageButton imageButton = this.f279637e.mVideoOrigin;
        if (imageButton != null) {
            if (this.f279643h0) {
                imageButton.setVisibility(8);
            } else {
                imageButton.setVisibility(0);
            }
        }
    }

    private void n() {
        View view = this.S;
        if (view != null) {
            removeView(view);
            addView(this.S, 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void o() {
        ((ViewGroup) getParent()).setContentDescription("videoContainer");
        if (this.f279632a0.getLayoutParams() == null) {
            this.f279632a0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.f279632a0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        TextView textView;
        if (this.Q == null || (textView = this.V) == null) {
            return;
        }
        textView.setVisibility(8);
        G();
    }

    private void v() {
        ImageButton imageButton = this.f279637e.mVideoOrigin;
        if (imageButton != null) {
            imageButton.setVisibility(8);
            this.f279637e.invalidate();
        }
    }

    protected boolean B() {
        return true;
    }

    public void C() {
        VideoPlayInfo videoPlayInfo = getVideoPlayInfo();
        if (videoPlayInfo == null) {
            return;
        }
        if (videoPlayInfo.f()) {
            this.U = false;
        }
        getBaseVideoManager().startVideo(this);
    }

    protected void D(MotionEvent motionEvent) {
        this.f279644i = motionEvent.getX();
        this.f279649m = motionEvent.getY();
    }

    protected boolean E(MotionEvent motionEvent) {
        this.C = motionEvent.getX();
        this.D = motionEvent.getY();
        this.E = Math.abs(this.C - this.f279644i);
        this.F = Math.abs(this.D - this.f279649m);
        float f16 = this.E;
        double sqrt = Math.sqrt((f16 * f16) + (r10 * r10));
        float f17 = this.F;
        int i3 = this.G;
        if (f17 <= i3 || sqrt < this.E * 2.0f) {
            if (this.E > i3 && sqrt >= f17 * 2.0f) {
                if (this.C >= this.f279644i) {
                    VideoControllerView.OnControllerEventListener onControllerEventListener = this.T;
                    if (onControllerEventListener != null) {
                        onControllerEventListener.onGestureMoveRight();
                    }
                    return true;
                }
            }
            return false;
        }
        if (this.D >= this.f279649m) {
            VideoControllerView.OnControllerEventListener onControllerEventListener2 = this.T;
            if (onControllerEventListener2 != null) {
                onControllerEventListener2.onGestureMoveDown();
            }
        } else {
            VideoControllerView.OnControllerEventListener onControllerEventListener3 = this.T;
            if (onControllerEventListener3 != null) {
                onControllerEventListener3.onGestureMoveUp();
            }
        }
        return true;
    }

    public void F() {
        VideoPlayInfo videoPlayInfo = getVideoPlayInfo();
        if (getVideoPlayInfo() == null || TextUtils.isEmpty(videoPlayInfo.openFreeTrafficJumpUrl)) {
            return;
        }
        FeedVideoEnv.externalFunc.openBrowser(videoPlayInfo.openFreeTrafficJumpUrl, -1, new Bundle(), "");
    }

    protected void H() {
        h hVar = this.B0;
        if (hVar == null || !hVar.isFullScreen()) {
            return;
        }
        n();
        FeedAutoVideoControllerView feedAutoVideoControllerView = this.f279637e;
        if (feedAutoVideoControllerView != null) {
            feedAutoVideoControllerView.bringToFront();
        }
        TipFloatContainer tipFloatContainer = this.Q;
        if (tipFloatContainer != null) {
            tipFloatContainer.bringToFront();
        }
        J();
    }

    public void I() {
        this.f279637e.updateLayout();
        N();
        x();
        if (this.B0.isFullScreen()) {
            this.f279640f0.setVisibility(0);
            LinearLayout linearLayout = this.f279646j0;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            TextView textView = this.f279647k0;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f279648l0;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            LinearLayout linearLayout2 = this.f279650m0;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            this.f279640f0.setVisibility(8);
            LinearLayout linearLayout3 = this.f279646j0;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            TextView textView3 = this.f279647k0;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.f279648l0;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.f279650m0;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(this.C0);
        alphaAnimation.setAnimationListener(new b());
        this.P.startAnimation(alphaAnimation);
    }

    public void J() {
        K();
        if (this.f279663z0 != null || this.mVideoPlayInfo == null) {
            return;
        }
        CountDownTimer countDownTimer = new CountDownTimer(this.mVideoPlayInfo.scrollNextItemDelayTime, 950L) { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.11

            /* renamed from: a, reason: collision with root package name */
            private long f279664a;

            {
                this.f279664a = FeedAutoVideoFull.this.mVideoPlayInfo.scrollNextItemDelayTime / 1000;
            }

            static /* synthetic */ long a(AnonymousClass11 anonymousClass11) {
                long j3 = anonymousClass11.f279664a;
                anonymousClass11.f279664a = j3 - 1;
                return j3;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.11.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedAutoVideoFull.this.s();
                    }
                });
                VideoControllerView.OnControllerEventListener onControllerEventListener = FeedAutoVideoFull.this.T;
                if (onControllerEventListener != null) {
                    onControllerEventListener.onGestureMoveUp();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (FeedAutoVideoFull.this.Q == null || FeedAutoVideoFull.this.V == null) {
                    return;
                }
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedAutoVideoFull.this.V.setVisibility(0);
                        FeedAutoVideoFull.this.V.setText(AnonymousClass11.a(AnonymousClass11.this) + "\u79d2\u540e\u64ad\u653e\u4e0b\u4e00\u89c6\u9891");
                    }
                });
            }
        };
        this.f279663z0 = countDownTimer;
        countDownTimer.start();
    }

    public void K() {
        CountDownTimer countDownTimer = this.f279663z0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f279663z0 = null;
        }
    }

    protected void L() {
        v();
        this.f279643h0 = true;
        getBaseVideoManager().switchVideoStream(this, 3);
        VideoControllerView.OnControllerEventListener onControllerEventListener = this.T;
        if (onControllerEventListener != null) {
            onControllerEventListener.onRequestOriginalVideo();
        }
    }

    protected void M(int i3) {
        this.f279640f0.setVisibility(i3);
    }

    public void O(int i3) {
        TextView textView = this.f279652o0;
        if (textView != null) {
            textView.setVisibility(i3 > 0 ? 0 : 4);
            this.f279652o0.setText("\u64ad\u653e" + p(i3, false));
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        if (FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "UseNewVideoCoverSetting", 1) != 0) {
            this.mVideoCoverWrapper = new com.tencent.mobileqq.qzoneplayer.cover.wrapper.a(context, this, this.mPlayStateSubject);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mVideoCoverPresenter = ((BaseVideoCoverUIWrapper) this.mVideoCoverWrapper).getPresenter();
            addView(this.mVideoCoverWrapper.getParentView(), layoutParams);
            return;
        }
        this.mVideoCover = new AutoVideoCoverFull(context, this);
        addView(this.mVideoCover, new ViewGroup.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void initChildView() {
        super.initChildView();
        FeedAutoVideoControllerView feedAutoVideoControllerView = new FeedAutoVideoControllerView(getContext(), FeedVideoEnv.playerResources);
        this.f279637e = feedAutoVideoControllerView;
        feedAutoVideoControllerView.setVisibility(0);
        this.f279639f = LayoutInflater.from(getContext()).inflate(FeedVideoEnv.feedResources.getLayoutId(12), (ViewGroup) null);
        this.P = (OperationContainer) LayoutInflater.from(getContext()).inflate(FeedVideoEnv.feedResources.getLayoutId(9), (ViewGroup) null);
        if (FeedVideoEnv.feedResources.getLayoutId(14) != 0) {
            this.f279654q0 = (LinearLayout) LayoutInflater.from(getContext()).inflate(FeedVideoEnv.feedResources.getLayoutId(14), (ViewGroup) null);
        }
        this.R = (RelativeLayout) LayoutInflater.from(getContext()).inflate(FeedVideoEnv.feedResources.getLayoutId(13), (ViewGroup) null);
        int layoutId = FeedVideoEnv.playerResources.getLayoutId(5);
        if (layoutId != 0) {
            TipFloatContainer tipFloatContainer = (TipFloatContainer) LayoutInflater.from(getContext()).inflate(layoutId, (ViewGroup) null);
            this.Q = tipFloatContainer;
            if (tipFloatContainer != null) {
                this.V = (TextView) tipFloatContainer.findViewById(FeedVideoEnv.playerResources.getViewId(PlayerResources.ViewId.NEXT_VIDEO_COUNT_DOWN_TIP));
            }
        }
        View view = new View(getContext());
        this.S = view;
        view.setBackgroundColor(Color.parseColor("#66000000"));
        this.S.setVisibility(0);
        ImageView imageView = (ImageView) this.P.findViewById(FeedVideoEnv.playerResources.getViewId(550));
        this.f279638e0 = imageView;
        imageView.setOnClickListener(new d());
        ImageView imageView2 = (ImageView) this.P.findViewById(FeedVideoEnv.feedResources.getViewId(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST));
        this.f279640f0 = imageView2;
        imageView2.setOnClickListener(new e());
        this.f279646j0 = (LinearLayout) this.P.findViewById(FeedVideoEnv.feedResources.getViewId(588));
        this.f279647k0 = (TextView) this.P.findViewById(FeedVideoEnv.feedResources.getViewId(com.tencent.luggage.wxa.c3.f.CTRL_INDEX));
        this.f279648l0 = (TextView) this.P.findViewById(FeedVideoEnv.feedResources.getViewId(c0.CTRL_INDEX));
        this.f279650m0 = (LinearLayout) this.P.findViewById(FeedVideoEnv.feedResources.getViewId(591));
        this.f279651n0 = (CellTextView) this.R.findViewById(FeedVideoEnv.feedResources.getViewId(596));
        this.f279652o0 = (TextView) this.R.findViewById(FeedVideoEnv.feedResources.getViewId(597));
        this.f279653p0 = (TextView) this.R.findViewById(FeedVideoEnv.feedResources.getViewId(598));
        this.P.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.6

            /* renamed from: d, reason: collision with root package name */
            private long f279676d;

            /* renamed from: e, reason: collision with root package name */
            private int f279677e;

            /* renamed from: f, reason: collision with root package name */
            private Runnable f279678f = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.6.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideoFull.this.f279637e.startFadeout(0);
                }
            };

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
            
                if (r8 != 3) goto L27;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction() & 255;
                long currentTimeMillis = System.currentTimeMillis();
                if (action != 0) {
                    if (action == 1) {
                        if (FeedAutoVideoFull.this.getState() == 5) {
                            FeedAutoVideoFull.this.f279637e.doPauseResume();
                            if (FeedAutoVideoFull.this.B0.isPlaying()) {
                                FeedAutoVideoFull.this.U = false;
                            } else {
                                FeedAutoVideoFull.this.U = true;
                            }
                        }
                    }
                    if (FeedAutoVideoFull.this.E(motionEvent)) {
                        return true;
                    }
                    if (currentTimeMillis - this.f279676d > 500) {
                        FeedAutoVideoFull.this.f279637e.startFadeout();
                    }
                    if (this.f279677e != 1 && FeedAutoVideoFull.this.B()) {
                        FeedAutoVideoFull.this.B0.toggleFullScreen();
                    } else {
                        FeedAutoVideoFull.this.postDelayed(this.f279678f, 400L);
                    }
                    return false;
                }
                FeedAutoVideoFull.this.D(motionEvent);
                FeedAutoVideoFull.this.removeCallbacks(this.f279678f);
                if (currentTimeMillis - this.f279676d > 400) {
                    this.f279677e = 0;
                }
                this.f279677e++;
                this.f279676d = currentTimeMillis;
                FeedAutoVideoFull.this.f279637e.cancelFadeout();
                return true;
            }
        });
        int layoutId2 = FeedVideoEnv.playerResources.getLayoutId(6);
        if (layoutId2 != 0) {
            VideoExtendedAnimationView videoExtendedAnimationView = (VideoExtendedAnimationView) LayoutInflater.from(getContext()).inflate(layoutId2, (ViewGroup) null);
            this.f279632a0 = videoExtendedAnimationView;
            if (videoExtendedAnimationView != null) {
                videoExtendedAnimationView.f();
                this.f279632a0.setItemOnTouchListener();
            }
        }
    }

    protected void initData() {
        c cVar = new c();
        this.mVideoClickListener = cVar;
        setOnClickListener(cVar);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.2

            /* renamed from: d, reason: collision with root package name */
            private long f279669d;

            /* renamed from: e, reason: collision with root package name */
            private int f279670e;

            /* renamed from: f, reason: collision with root package name */
            private Runnable f279671f = new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.2.1
                @Override // java.lang.Runnable
                public void run() {
                    FeedAutoVideoFull.this.performClick();
                }
            };

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (FeedAutoVideoFull.this.isUse360VideoRender()) {
                    return FeedAutoVideoFull.this.onTouchExt(view, motionEvent);
                }
                long currentTimeMillis = System.currentTimeMillis();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1 || FeedAutoVideoFull.this.E(motionEvent)) {
                        return true;
                    }
                    if (currentTimeMillis - this.f279669d > 3000) {
                        FeedAutoVideoFull.this.performLongClick();
                        return true;
                    }
                    if (this.f279670e != 1 && FeedAutoVideoFull.this.B()) {
                        if (this.f279670e != 2 || FeedAutoVideoFull.this.A()) {
                            return true;
                        }
                        FeedAutoVideoFull.this.B0.toggleFullScreen();
                    } else {
                        FeedAutoVideoFull.this.postDelayed(this.f279671f, 400L);
                    }
                } else {
                    FeedAutoVideoFull.this.w();
                    FeedAutoVideoFull.this.D(motionEvent);
                    FeedAutoVideoFull.this.removeCallbacks(this.f279671f);
                    long j3 = this.f279669d;
                    if (j3 != 0 && currentTimeMillis - j3 > 300) {
                        this.f279670e = 0;
                    }
                    this.f279670e++;
                    this.f279669d = currentTimeMillis;
                }
                return true;
            }
        });
        this.mVideoPlayInfoListener = new BaseVideoManager.VideoPlayInfoListener() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.3
            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
                PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedAutoVideoFull.this.playLiveEndAnim();
                    }
                });
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
            }

            @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
            public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
            }
        };
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
        int i17 = this.M;
        if (i17 == 0) {
            if (isBaseVideoCoverWrapperNotNull()) {
                i17 = this.mVideoCoverWrapper.getPicWidth();
            } else {
                i17 = this.mVideoCover.getPicWidth();
            }
        }
        int i18 = this.N;
        if (i18 == 0) {
            if (isBaseVideoCoverWrapperNotNull()) {
                i18 = this.mVideoCoverWrapper.getPicHeight();
            } else {
                i18 = this.mVideoCover.getPicHeight();
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            super.onMeasure(i3, i16);
            this.f279637e.setVideoDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            if (this.f279657t0) {
                defaultSize = this.f279655r0;
                defaultSize2 = this.f279656s0;
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
                this.mVideoView.measure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824);
            if (isBaseVideoCoverWrapperNotNull()) {
                ViewGroup.LayoutParams layoutParams2 = this.mVideoCoverWrapper.getParentView().getLayoutParams();
                layoutParams2.height = -1;
                layoutParams2.width = -1;
                this.mVideoCoverWrapper.getCover().setLayoutParams(layoutParams2);
                this.mVideoCoverWrapper.getParentView().measure(makeMeasureSpec, makeMeasureSpec2);
            } else if (isVideoCoverNotNull()) {
                ViewGroup.LayoutParams layoutParams3 = this.mVideoCover.getLayoutParams();
                layoutParams3.height = -1;
                layoutParams3.width = -1;
                this.mVideoCover.setLayoutParams(layoutParams3);
                this.mVideoCover.measure(makeMeasureSpec, makeMeasureSpec2);
            }
            setMeasuredDimension(defaultSize, defaultSize2);
        }
        if (this.f279632a0 != null) {
            if (isBaseVideoCoverWrapperNotNull()) {
                this.f279632a0.setContainerDimensionOverride(this.mVideoCoverWrapper.getParentView().getMeasuredWidth(), this.mVideoCoverWrapper.getCover().getMeasuredHeight(), true);
                this.f279632a0.measure(this.mVideoCoverWrapper.getParentView().getMeasuredWidth(), this.mVideoCoverWrapper.getCover().getMeasuredHeight());
                this.f279632a0.setLayoutParams(this.mVideoCoverWrapper.getParentView().getLayoutParams());
            } else if (isVideoCoverNotNull()) {
                this.f279632a0.setContainerDimensionOverride(this.mVideoCover.getMeasuredWidth(), this.mVideoCover.getMeasuredHeight(), true);
                this.f279632a0.measure(this.mVideoCover.getMeasuredWidth(), this.mVideoCover.getMeasuredHeight());
                this.f279632a0.setLayoutParams(this.mVideoCover.getLayoutParams());
            }
        }
        if (isBaseVideoCoverWrapperNotNull()) {
            measureLiveEndAnim(this.mVideoCoverWrapper.getParentView().getMeasuredWidth(), this.mVideoCoverWrapper.getParentView().getMeasuredHeight());
        } else if (isVideoCoverNotNull()) {
            measureLiveEndAnim(this.mVideoCover.getMeasuredWidth(), this.mVideoCover.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onReceivedMessage(Message message) {
        super.onReceivedMessage(message);
        int i3 = message.what;
        if (i3 == 1) {
            if (this.f279637e.isShowing()) {
                this.f279637e.updatePausePlay();
            }
            N();
            this.B0.f279688a = false;
            getBaseVideoManager().enableAutoVideoSound();
            x();
            return;
        }
        if (i3 == 2) {
            v();
            x();
            return;
        }
        if (i3 == 17) {
            getBaseVideoManager().enableAutoVideoSound();
            this.f279645i0 = true;
            x();
        } else if (i3 == 20) {
            getBaseVideoManager().enableAutoVideoSound();
            this.f279645i0 = true;
        } else {
            if (i3 != 23) {
                return;
            }
            VideoExtendedAnimationView videoExtendedAnimationView = this.f279632a0;
            if (videoExtendedAnimationView == null || videoExtendedAnimationView.getVisibility() != 0) {
                H();
                v();
                x();
            }
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo, com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public void onRecycled() {
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder;
        if (this.E0 && (globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder.oldSurface == this) {
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
        if (videoPlayInfo == null || !FeedVideoEnv.externalFunc.isFreeTraffic() || FeedVideoEnv.isWifiConnected()) {
            return;
        }
        if (videoPlayInfo.isLiveVideo) {
            FeedVideoEnv.externalFunc.reportToLp00064(LpReportInfoConfig.ACTION_TYPE_DAWANG, 1, 3);
        } else {
            FeedVideoEnv.externalFunc.reportToLp00064(LpReportInfoConfig.ACTION_TYPE_DAWANG, 1, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoBufferingUpdate(int i3) {
        this.A0 = i3;
    }

    protected void q() {
        PlayerUtils.runOnUiThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.17
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFull feedAutoVideoFull = FeedAutoVideoFull.this;
                feedAutoVideoFull.f279637e.setMediaPlayer(feedAutoVideoFull.B0);
                FeedAutoVideoFull feedAutoVideoFull2 = FeedAutoVideoFull.this;
                VideoPlayInfo videoPlayInfo = feedAutoVideoFull2.mVideoPlayInfo;
                if (videoPlayInfo != null && (videoPlayInfo.isAdvMicro || videoPlayInfo.isLiveVideo)) {
                    feedAutoVideoFull2.f279637e.updateLayout();
                    return;
                }
                if (videoPlayInfo != null && videoPlayInfo.e()) {
                    FeedAutoVideoFull.this.setVideoInfoVisible(8);
                } else {
                    h hVar = FeedAutoVideoFull.this.B0;
                    if (hVar != null && !hVar.isFullScreen() && !FeedAutoVideoFull.this.B0.isLandscape()) {
                        FeedAutoVideoFull.this.setVideoInfoVisible(0);
                    }
                }
                FeedAutoVideoFull.this.f279637e.show();
                FeedAutoVideoFull feedAutoVideoFull3 = FeedAutoVideoFull.this;
                feedAutoVideoFull3.W = false;
                feedAutoVideoFull3.I();
            }
        }, 300L);
    }

    public void r() {
        FeedAutoVideoControllerView feedAutoVideoControllerView = this.f279637e;
        if (feedAutoVideoControllerView != null) {
            feedAutoVideoControllerView.doPauseResume();
        }
        h hVar = this.B0;
        if (hVar != null && hVar.isPlaying()) {
            this.U = false;
        } else {
            this.U = true;
        }
    }

    public void setActivityWillDestroy(boolean z16) {
        this.D0 = z16;
    }

    public void setContainerDimensionOverride(int i3, int i16, boolean z16) {
        this.f279655r0 = i3;
        this.f279656s0 = i16;
        this.f279657t0 = z16;
    }

    public void setMediaControllerListener(MediaControllerListener mediaControllerListener) {
        this.f279636d0 = mediaControllerListener;
    }

    public void setOnControllerEventListener(VideoControllerView.OnControllerEventListener onControllerEventListener) {
        this.T = onControllerEventListener;
    }

    public void setOnDanmakuSwitchClickListener(View.OnClickListener onClickListener) {
        ImageButton imageButton;
        FeedAutoVideoControllerView feedAutoVideoControllerView = this.f279637e;
        if (feedAutoVideoControllerView == null || (imageButton = feedAutoVideoControllerView.mVideoDanmakuSwitch) == null) {
            return;
        }
        imageButton.setOnClickListener(onClickListener);
    }

    public void setScrollToNextDelayTime(long j3) {
        VideoPlayInfo videoPlayInfo = this.mVideoPlayInfo;
        if (videoPlayInfo != null) {
            videoPlayInfo.l(j3);
        }
    }

    public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        FeedAutoVideoControllerView feedAutoVideoControllerView = this.f279637e;
        if (feedAutoVideoControllerView != null) {
            feedAutoVideoControllerView.setSeekBarChangeListener(onSeekBarChangeListener);
        }
    }

    public void setVideoInfoVisible(final int i3) {
        LinearLayout linearLayout;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            RelativeLayout relativeLayout = this.R;
            if (relativeLayout != null) {
                if (relativeLayout.getVisibility() != i3) {
                    this.R.setVisibility(i3);
                }
                if (i3 == 8) {
                    LinearLayout linearLayout2 = this.f279654q0;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                } else if (i3 == 0 && (linearLayout = this.f279654q0) != null) {
                    linearLayout.setVisibility(8);
                }
                if (this.R.getVisibility() == 0) {
                    this.R.bringToFront();
                    return;
                }
                return;
            }
            return;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.18
            @Override // java.lang.Runnable
            public void run() {
                LinearLayout linearLayout3;
                RelativeLayout relativeLayout2 = FeedAutoVideoFull.this.R;
                if (relativeLayout2 != null) {
                    int visibility = relativeLayout2.getVisibility();
                    int i16 = i3;
                    if (visibility != i16) {
                        FeedAutoVideoFull.this.R.setVisibility(i16);
                    }
                    int i17 = i3;
                    if (i17 == 8) {
                        LinearLayout linearLayout4 = FeedAutoVideoFull.this.f279654q0;
                        if (linearLayout4 != null) {
                            linearLayout4.setVisibility(0);
                        }
                    } else if (i17 == 0 && (linearLayout3 = FeedAutoVideoFull.this.f279654q0) != null) {
                        linearLayout3.setVisibility(8);
                    }
                    if (FeedAutoVideoFull.this.R.getVisibility() == 0) {
                        FeedAutoVideoFull.this.R.bringToFront();
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        LinearLayout linearLayout;
        CellTextView cellTextView;
        LinearLayout linearLayout2;
        super.setVideoPlayInfo(videoPlayInfo);
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.setContentDescription("videoContainer");
        boolean z16 = false;
        this.f279643h0 = false;
        this.M = 0;
        this.N = 0;
        this.f279657t0 = false;
        if (!this.f279659v0 && FeedVideoEnv.externalFunc.getRunningEnv() == FeedVideoEnv.RunningEnv.DULI) {
            RotationSeekBar rotationSeekBar = (RotationSeekBar) this.f279639f.findViewById(FeedVideoEnv.feedResources.getViewId(com.tencent.luggage.wxa.v6.d.CTRL_INDEX));
            this.f279642h = rotationSeekBar;
            rotationSeekBar.setThumb(null);
            this.f279642h.setMax(1000);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12, -1);
            this.f279639f.setLayoutParams(layoutParams);
            this.f279639f.setVisibility(4);
            viewGroup.addView(this.f279639f);
            this.f279659v0 = true;
        }
        if (!this.f279661x0 && (linearLayout2 = this.f279654q0) != null) {
            viewGroup.addView(linearLayout2);
            this.f279661x0 = true;
        }
        LinearLayout linearLayout3 = this.f279654q0;
        if (linearLayout3 != null && (cellTextView = (CellTextView) linearLayout3.findViewById(FeedVideoEnv.feedResources.getViewId(600))) != null) {
            BaseVideo.setViewVisibility(cellTextView, videoPlayInfo.isOriginalContent ? 0 : 8);
        }
        if (!this.f279658u0) {
            viewGroup.addView(this.P);
            TipFloatContainer tipFloatContainer = this.Q;
            if (tipFloatContainer != null) {
                viewGroup.addView(tipFloatContainer);
            }
            this.f279637e.setContentDescription("videoController");
            this.f279637e.setAnchorView(this.P);
            this.f279637e.setVideoView(this);
            this.f279637e.setMediaPlayer(this.B0);
            this.f279637e.setVideoBottomSeekBar(this.f279639f, this.f279642h);
            this.f279637e.setEnabled(true);
            this.f279658u0 = true;
        }
        if (isBaseVideoCoverWrapperNotNull()) {
            if (!this.f279660w0) {
                viewGroup.addView(this.R, new RelativeLayout.LayoutParams(-1, this.mVideoCoverWrapper.getPicHeight()));
                ((com.tencent.mobileqq.qzoneplayer.cover.wrapper.a) this.mVideoCoverWrapper).a(this.R);
                this.f279660w0 = true;
            } else {
                RelativeLayout relativeLayout = this.R;
                if (relativeLayout != null) {
                    ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = -1;
                        layoutParams2.height = this.mVideoCoverWrapper.getPicHeight();
                        this.R.setLayoutParams(layoutParams2);
                        ((com.tencent.mobileqq.qzoneplayer.cover.wrapper.a) this.mVideoCoverWrapper).a(this.R);
                    }
                    this.f279653p0.requestLayout();
                }
            }
        } else if (isVideoCoverNotNull()) {
            if (!this.f279660w0 && this.mVideoCover != null) {
                viewGroup.addView(this.R, new RelativeLayout.LayoutParams(-1, this.mVideoCover.picHeight));
                this.mVideoCover.mCoverRelatView = this.R;
                this.f279660w0 = true;
            }
            RelativeLayout relativeLayout2 = this.R;
            if (relativeLayout2 != null && this.mVideoCover != null) {
                ViewGroup.LayoutParams layoutParams3 = relativeLayout2.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = -1;
                    layoutParams3.height = this.mVideoCover.picHeight;
                    this.R.setLayoutParams(layoutParams3);
                    this.mVideoCover.mCoverRelatView = this.R;
                }
                this.f279653p0.requestLayout();
            }
        }
        if (this.P != null) {
            this.f279637e.cancelFadeout();
            this.P.setVisibility(8);
        }
        LinearLayout linearLayout4 = this.f279646j0;
        if (linearLayout4 != null) {
            linearLayout4.removeAllViews();
            View avatarImageView = FeedVideoEnv.externalFunc.getAvatarImageView(getContext(), videoPlayInfo.authorUin);
            this.f279646j0.addView(avatarImageView);
            ViewGroup.LayoutParams layoutParams4 = avatarImageView.getLayoutParams();
            int i3 = FeedVideoEnv.dp37;
            layoutParams4.width = i3;
            layoutParams4.height = i3;
            avatarImageView.setLayoutParams(layoutParams4);
        }
        TextView textView = this.f279647k0;
        if (textView != null) {
            textView.setText(videoPlayInfo.authorNickname);
        }
        TextView textView2 = this.f279648l0;
        if (textView2 != null) {
            textView2.setText(videoPlayInfo.displayFeedTime);
        }
        if (videoPlayInfo.segmentVideoInfo.getDefaultUrl().startsWith("/")) {
            this.A0 = 100;
        }
        ImageButton imageButton = this.f279637e.mVideoOrigin;
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        if (this.R != null && !videoPlayInfo.e()) {
            h hVar = this.B0;
            if (hVar != null && (hVar.isFullScreen() || this.B0.isLandscape())) {
                this.R.setVisibility(8);
            } else if (this.R.getVisibility() != 0) {
                this.R.setVisibility(0);
            }
            CellTextView cellTextView2 = this.f279651n0;
            if (cellTextView2 != null) {
                if (cellTextView2.getVisibility() != 0) {
                    this.f279651n0.setVisibility(0);
                }
                int i16 = videoPlayInfo.videoDescLineNum;
                if (i16 > 0) {
                    this.f279651n0.setMaxLine(i16);
                }
                this.f279651n0.setRichText(videoPlayInfo.videoDesc);
            }
            if (this.f279653p0 != null && getState() == 1) {
                if (this.f279653p0.getVisibility() != 0) {
                    this.f279653p0.setVisibility(0);
                }
                this.f279653p0.setText(videoPlayInfo.showVideoTime);
            } else {
                TextView textView3 = this.f279653p0;
                if (textView3 != null) {
                    textView3.setVisibility(4);
                }
            }
            O(videoPlayInfo.playCount);
        } else {
            RelativeLayout relativeLayout3 = this.R;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
        }
        if (this.R.getVisibility() == 0) {
            LinearLayout linearLayout5 = this.f279654q0;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
        } else if (this.R.getVisibility() == 8 && (linearLayout = this.f279654q0) != null) {
            linearLayout.setVisibility(0);
        }
        this.f279637e.mVideoOrigin = null;
        if (videoPlayInfo.segmentVideoInfo.getStreamInfo(3) != null) {
            FeedAutoVideoControllerView feedAutoVideoControllerView = this.f279637e;
            if (feedAutoVideoControllerView.mVideoOrigin == null) {
                feedAutoVideoControllerView.mVideoOrigin = (ImageButton) feedAutoVideoControllerView.findViewById(FeedVideoEnv.playerResources.getViewId(579));
                this.f279637e.mVideoOrigin.setOnClickListener(new f());
                if (VideoManager.getInstance().isCached(videoPlayInfo.segmentVideoInfo.getStreamInfo(3))) {
                    v();
                    this.f279643h0 = true;
                } else {
                    this.f279637e.mVideoOrigin.setVisibility(0);
                }
            }
        } else {
            v();
            this.f279643h0 = true;
        }
        h hVar2 = this.B0;
        if (hVar2 != null) {
            hVar2.f279688a = false;
            this.B0.f279691d = 0;
        }
        this.f279645i0 = false;
        FeedAutoVideoControllerView feedAutoVideoControllerView2 = this.f279637e;
        if (feedAutoVideoControllerView2 != null) {
            feedAutoVideoControllerView2.setSeekbarRotationChangeListener(new g());
        }
        this.f279633b0 = videoPlayInfo.needVideoExtendedAnimation;
        if (this.f279632a0 != null) {
            o();
            this.f279632a0.setVisibility(8);
        }
        ImageView imageView = (ImageView) this.P.findViewById(FeedVideoEnv.feedResources.getViewId(594));
        this.f279641g0 = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f279641g0.setVisibility(0);
        FeedAutoVideoControllerView feedAutoVideoControllerView3 = this.f279637e;
        if (feedAutoVideoControllerView3.mVideoDanmakuSwitch == null) {
            feedAutoVideoControllerView3.mVideoDanmakuSwitch = (ImageButton) feedAutoVideoControllerView3.findViewById(FeedVideoEnv.playerResources.getViewId(580));
        }
        if (!FeedVideoEnv.externalFunc.isFreeTraffic() && !FeedVideoEnv.isWifiConnected()) {
            VideoPlayInfo videoPlayInfo2 = this.mVideoPlayInfo;
            if (videoPlayInfo2.showOpenFreeTraffic && !videoPlayInfo2.isAdFeeds) {
                z16 = true;
            }
        }
        this.f279634c0 = z16;
        VideoCoverOpenTrafficText parseOpenTrafficText = BaseVideoCoverUtils.parseOpenTrafficText(this.mVideoPlayInfo.openFreeTrafficText);
        ICoverWrapper iCoverWrapper = this.mVideoCoverWrapper;
        if (iCoverWrapper != null) {
            iCoverWrapper.setShowOpenFreeTraffic(this.f279634c0);
            if (parseOpenTrafficText == null || !parseOpenTrafficText.isValid() || TextUtils.isEmpty(this.mVideoPlayInfo.openFreeTrafficJumpUrl)) {
                return;
            }
            this.mVideoCoverWrapper.setOpenFreeTrafficText(parseOpenTrafficText.mNormalText, parseOpenTrafficText.mUnderLineText);
            FeedVideoEnv.externalFunc.reportClick("8", ThemeReporter.FROM_PUSH, "3");
        }
    }

    public void setWillSwitchToWindow(boolean z16) {
        this.E0 = z16;
    }

    public void setmEnableToggleFullScreen(boolean z16) {
        this.K = z16;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void stop() {
        super.stop();
        setShowCoverImage(true);
    }

    public void t() {
        if (this.P.getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(this.C0);
        alphaAnimation.setAnimationListener(new a());
        this.P.startAnimation(alphaAnimation);
    }

    public void u() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.15
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFull.this.f279637e.cancelFadeout();
                FeedAutoVideoFull.this.P.setVisibility(4);
            }
        });
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void update() {
        h hVar;
        super.update();
        if (this.isAutoPlay && this.J && (hVar = this.B0) != null && hVar.f279688a) {
            this.B0.pause();
        }
        this.J = false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void updateWithoutDelay(boolean z16) {
        super.updateWithoutDelay(z16);
        q();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void videoUIStop() {
        super.videoUIStop();
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.12
            @Override // java.lang.Runnable
            public void run() {
                FeedAutoVideoFull.this.f279637e.hide();
                FeedAutoVideoFull.this.u();
            }
        });
    }

    public void w() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.16
            @Override // java.lang.Runnable
            public void run() {
                if (FeedAutoVideoFull.this.Q != null) {
                    FeedAutoVideoFull.this.V.setVisibility(8);
                    FeedAutoVideoFull.this.K();
                }
            }
        });
    }

    protected void x() {
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull.10
            @Override // java.lang.Runnable
            public void run() {
                if (FeedAutoVideoFull.this.f279653p0 == null || FeedAutoVideoFull.this.f279653p0.getVisibility() != 0) {
                    return;
                }
                FeedAutoVideoFull.this.f279653p0.setVisibility(4);
            }
        });
    }

    public boolean z() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onPause() {
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder;
        BaseVideoManagerUtils.ChangeSurfaceHolder globalChangeSurfaceHolder2;
        this.J = true;
        if (this.E0 && (globalChangeSurfaceHolder2 = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder2.oldSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFull", "mWillSwitchToWindow true, onPause does nothing");
        } else if (this.D0 && (globalChangeSurfaceHolder = BaseVideoManagerUtils.getGlobalChangeSurfaceHolder()) != null && globalChangeSurfaceHolder.newSurface == this) {
            PlayerUtils.log(4, "FeedAutoVideoFull", "mIsActivityWillDestroy true, onPause does nothing");
        } else {
            super.onPause();
        }
    }

    protected void y() {
        this.hasTimeview = false;
        this.hasPlayCountView = false;
        this.hasSoundTipLayout = false;
        this.hasSoundLinesLayout = false;
        this.mTimeview = null;
        this.mSoundLinesLayout = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void onVideoSizeChanged(int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            this.M = i3;
            this.N = i16;
        }
        super.onVideoSizeChanged(i3, i16);
    }

    public FeedAutoVideoFull(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279635d = 950;
        this.G = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.K = true;
        this.L = false;
        this.U = false;
        this.f279659v0 = false;
        this.f279660w0 = false;
        this.f279661x0 = false;
        this.f279662y0 = false;
        this.B0 = new h();
        this.C0 = 300;
        y();
        initData();
    }

    public String p(long j3, boolean z16) {
        if (j3 >= SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            long j16 = ((j3 / 10000000) + 5) / 10;
            if (j16 >= 10000) {
                return "9999\u4ebf";
            }
            return j16 + "\u4ebf";
        }
        if (j3 >= 10000) {
            long j17 = ((j3 / 1000) + 5) / 10;
            if (j17 >= 10000) {
                return "9999\u4e07";
            }
            return j17 + "\u4e07";
        }
        return String.valueOf(j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FeedAutoVideoFull.this.P.setVisibility(4);
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
            PlayerUtils.log(4, "FeedAutoVideoFull", "SHOW");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            FeedAutoVideoFull.this.P.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public void setFeedAutoVideoFullFunc(com.tencent.mobileqq.qzoneplayer.video.a aVar) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void showValidTimeText() {
    }

    public FeedAutoVideoFull(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f279635d = 950;
        this.G = ViewConfiguration.get(FeedVideoEnv.getApplicationContext()).getScaledTouchSlop();
        this.K = true;
        this.L = false;
        this.U = false;
        this.f279659v0 = false;
        this.f279660w0 = false;
        this.f279661x0 = false;
        this.f279662y0 = false;
        this.B0 = new h();
        this.C0 = 300;
        y();
        initData();
    }
}
