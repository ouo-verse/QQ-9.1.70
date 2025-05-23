package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.framework.BaseVideoView;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class VideoPlayerView extends BaseVideoView {
    private static final HashMap<View, Integer> J1 = new HashMap<>();
    private static float K1 = 1.0f;
    private static final SparseBooleanArray L1 = new SparseBooleanArray();
    private static boolean M1;
    protected ImageView A0;
    private boolean A1;
    protected ImageView B0;
    private boolean B1;
    protected ImageView C0;
    private View C1;
    protected ProgressBar D0;
    private int D1;
    protected View E0;
    private boolean E1;
    private final int F0;
    private SystemBarCompact F1;
    private final int G0;
    private int G1;
    protected URLImageView H0;
    private ExtraTypeInfo H1;
    private boolean I0;
    private SeekBar I1;
    private int[] J0;
    private int[] K0;
    private ArrayList<View> L0;
    private boolean M0;
    private boolean N0;
    private String O0;
    private boolean P0;
    private int Q0;
    private boolean R0;
    private boolean S0;
    private View T0;
    private CertifiedAccountMeta$StFeed U0;
    private TextView V0;
    private View W0;
    private SquareImageView X0;
    private FollowTextView Y0;
    private SubscribeVideoDetailFragment Z0;

    /* renamed from: a1, reason: collision with root package name */
    private View f96305a1;

    /* renamed from: b1, reason: collision with root package name */
    private TextView f96306b1;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f96307c1;

    /* renamed from: d1, reason: collision with root package name */
    private VideoNextFeedsView f96308d1;

    /* renamed from: e1, reason: collision with root package name */
    private View f96309e1;

    /* renamed from: f1, reason: collision with root package name */
    private View f96310f1;

    /* renamed from: g1, reason: collision with root package name */
    private long f96311g1;

    /* renamed from: h1, reason: collision with root package name */
    private View f96312h1;

    /* renamed from: i1, reason: collision with root package name */
    private HashMap<String, Boolean> f96313i1;

    /* renamed from: j1, reason: collision with root package name */
    private boolean f96314j1;

    /* renamed from: k1, reason: collision with root package name */
    private boolean f96315k1;

    /* renamed from: l1, reason: collision with root package name */
    private long f96316l1;

    /* renamed from: m1, reason: collision with root package name */
    private IVideoOuterStatusListener f96317m1;

    /* renamed from: n1, reason: collision with root package name */
    private boolean f96318n1;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f96319o1;

    /* renamed from: p1, reason: collision with root package name */
    private long f96320p1;

    /* renamed from: q1, reason: collision with root package name */
    private long f96321q1;

    /* renamed from: r1, reason: collision with root package name */
    private long f96322r1;

    /* renamed from: s1, reason: collision with root package name */
    private boolean f96323s1;

    /* renamed from: t1, reason: collision with root package name */
    private String f96324t1;

    /* renamed from: u1, reason: collision with root package name */
    private View f96325u1;

    /* renamed from: v0, reason: collision with root package name */
    private View f96326v0;

    /* renamed from: v1, reason: collision with root package name */
    private SquareImageView f96327v1;

    /* renamed from: w0, reason: collision with root package name */
    protected TextView f96328w0;

    /* renamed from: w1, reason: collision with root package name */
    private TextView f96329w1;

    /* renamed from: x0, reason: collision with root package name */
    protected TextView f96330x0;

    /* renamed from: x1, reason: collision with root package name */
    private FollowTextView f96331x1;

    /* renamed from: y0, reason: collision with root package name */
    protected ImageView f96332y0;

    /* renamed from: y1, reason: collision with root package name */
    private LinearLayout f96333y1;

    /* renamed from: z0, reason: collision with root package name */
    private View f96334z0;

    /* renamed from: z1, reason: collision with root package name */
    private LinearLayout f96335z1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements gh2.c {
        a() {
        }

        @Override // gh2.c
        public void a() {
            if (VideoPlayerView.this.H() != null && VideoPlayerView.this.f96317m1 != null) {
                VideoPlayerView.this.f96319o1 = false;
                VideoPlayerView.this.f96317m1.onOrientationChange(VideoPlayerView.this.A1);
                VideoPlayerView.this.f96317m1.onVideoSize(VideoPlayerView.this.E().getRenderViewWidth(), VideoPlayerView.this.E().getRenderViewHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements gh2.d {
        b() {
        }

        @Override // gh2.d
        public boolean onCloseClick() {
            return false;
        }

        @Override // gh2.d
        public boolean onEnterClick(int i3, int i16) {
            VideoPlayerView.this.f96319o1 = true;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f96344d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f96345e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f96346f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f96347h;

        c(int i3, View view, boolean z16, int i16) {
            this.f96344d = i3;
            this.f96345e = view;
            this.f96346f = z16;
            this.f96347h = i16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f96346f) {
                VideoPlayerView.this.n1(this.f96345e, this.f96344d, this.f96347h, false);
            } else if (this.f96344d == 0 && VideoPlayerView.L1 != null && !VideoPlayerView.L1.get(this.f96345e.getId())) {
                this.f96345e.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f96344d == 1 && VideoPlayerView.L1 != null && !VideoPlayerView.L1.get(this.f96345e.getId())) {
                this.f96345e.setVisibility(0);
            }
            if (this.f96344d == 0 && VideoPlayerView.L1 != null && !VideoPlayerView.L1.get(this.f96345e.getId())) {
                HashMap hashMap = VideoPlayerView.J1;
                View view = this.f96345e;
                hashMap.put(view, Integer.valueOf(view.getVisibility()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VideoPlayerView.this.J1();
            VideoPlayerView.this.U();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (VideoPlayerView.this.f96308d1 != null) {
                VideoPlayerView.this.f96308d1.i();
                VideoPlayerView.this.q1();
                VideoPlayerView.this.F1(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements FollowTextView.e {
        f() {
        }

        @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView.e
        public void a(boolean z16, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            VSReporter.n(VideoPlayerView.this.U0.poster.f24929id.get(), "auth_video", "finish_follow", 0, 0, "", "", VideoPlayerView.this.U0.f24925id.get(), VideoPlayerView.this.U0.title.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPlayerView.this.V1();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (VideoPlayerView.this.f96305a1 != null) {
                VideoPlayerView.this.f96305a1.setVisibility(8);
            }
            VideoPlayerView.this.S0 = false;
            VideoPlayerView.M1 = true;
            VideoPlayerView.this.d0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i implements FollowTextView.e {
        i() {
        }

        @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView.e
        public void a(boolean z16, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            if (VideoPlayerView.this.U0 != null) {
                VSReporter.n(VideoPlayerView.this.U0.poster.f24929id.get(), "auth_video", "half_follow", 0, 0, "", "", VideoPlayerView.this.U0.f24925id.get(), VideoPlayerView.this.U0.title.get());
                VideoPlayerView.this.U0.poster.followState.set(1);
                VideoPlayerView.this.f96313i1.put(VideoPlayerView.this.U0.poster.f24929id.get(), Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VideoPlayerView.this.G1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (VideoPlayerView.this.I0) {
                VideoPlayerView.this.p1();
            } else {
                VideoPlayerView.this.U1();
                if (VideoPlayerView.this.U0 != null) {
                    VSReporter.p(VideoPlayerView.this.U0.poster.f24929id.get(), "auth_video", ReportConst.ACTION.FULLSCREEN, 0, 0, "", "", VideoPlayerView.this.U0.poster.nick.get(), VideoPlayerView.this.U0.title.get());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (hf0.a.b("mLLSkipBackWrapper", 500L)) {
                VideoPlayerView.this.S1();
                VideoPlayerView videoPlayerView = VideoPlayerView.this;
                videoPlayerView.n1(videoPlayerView.f96309e1, 0, 1, true);
                if (VideoPlayerView.this.H() != null) {
                    VideoPlayerView videoPlayerView2 = VideoPlayerView.this;
                    videoPlayerView2.c0(videoPlayerView2.H().getCurrentPositionMs() - 10000);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (hf0.a.b("mLLSkipForwardWrapper", 500L)) {
                VideoPlayerView.this.S1();
                VideoPlayerView videoPlayerView = VideoPlayerView.this;
                videoPlayerView.n1(videoPlayerView.f96310f1, 0, 1, true);
                if (VideoPlayerView.this.H() != null) {
                    VideoPlayerView videoPlayerView2 = VideoPlayerView.this;
                    videoPlayerView2.c0(videoPlayerView2.H().getCurrentPositionMs() + 10000);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class n implements IVideoInnerStatusListener {
        n() {
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoClose(int i3) {
            VideoPlayerView.this.f96318n1 = false;
            if (VideoPlayerView.this.f96308d1 != null) {
                VideoPlayerView.this.f96308d1.i();
                VideoPlayerView.this.f96308d1 = null;
            }
            VideoPlayerView.this.Z0 = null;
            VideoPlayerView.this.T();
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoSeek(int i3) {
            QLog.d("VideoPlayerView", 4, "notifyVideoSeek seek " + i3);
            VideoPlayerView videoPlayerView = VideoPlayerView.this;
            videoPlayerView.c0((((long) i3) * videoPlayerView.H().getDurationMs()) / 100);
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStart() {
            if (VideoPlayerView.this.H().getCurrentPositionMs() < VideoPlayerView.this.H().getDurationMs()) {
                VideoPlayerView.this.d0();
                return;
            }
            if (VideoPlayerView.this.f96323s1) {
                QLog.d("VideoPlayerView", 4, "has more , wait for auto play next");
                return;
            }
            VideoPlayerView.this.H().setLoopback(true);
            VideoPlayerView.this.U();
            if (VideoPlayerView.this.f96317m1 != null) {
                VideoPlayerView.this.f96317m1.onVideoStart((int) VideoPlayerView.this.H().getDurationMs());
            }
            QLog.d("VideoPlayerView", 4, "no more, player repeat");
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStop() {
            VideoPlayerView.this.R();
        }
    }

    public VideoPlayerView(@NonNull Context context) {
        this(context, null);
    }

    private void D1() {
        boolean z16;
        boolean z17;
        HashMap<String, Boolean> hashMap;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.U0;
        if (certifiedAccountMeta$StFeed != null) {
            int i3 = 0;
            if (certifiedAccountMeta$StFeed.poster.followState.get() == 0 && (hashMap = this.f96313i1) != null && hashMap.get(this.U0.poster.f24929id.get()) == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            FollowTextView followTextView = this.Y0;
            if (followTextView != null) {
                followTextView.setOnlyFollowMode(true);
                this.Y0.setFeedData(this.U0);
                this.Y0.setExtraTypeInfo(g());
            }
            if (!z16 && !this.B1 && z1()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (this.W0 != null) {
                if (z17) {
                    this.B1 = true;
                    CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed2 = this.U0;
                    if (certifiedAccountMeta$StFeed2 != null) {
                        VSReporter.p(certifiedAccountMeta$StFeed2.poster.f24929id.get(), "auth_video", "half_exp", 0, 0, "", "", this.U0.poster.nick.get(), this.U0.title.get());
                    }
                }
                View view = this.W0;
                if (!z17) {
                    i3 = 8;
                }
                view.setVisibility(i3);
                j().sendEmptyMessageDelayed(3, 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1(boolean z16) {
        CertifiedAccountMeta$StFeed h16;
        String str;
        if (this.Z0 != null && (h16 = this.f96308d1.h()) != null) {
            this.Z0.Jh(h16);
            String str2 = h16.poster.f24929id.get();
            if (z16) {
                str = "next_play";
            } else {
                str = "next_clk";
            }
            VSReporter.p(str2, "auth_video", str, 0, 0, new String[0]);
        }
        URLImageView uRLImageView = this.H0;
        if (uRLImageView != null) {
            uRLImageView.setBackgroundResource(0);
            this.H0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        if (H() != null && this.A0 != null) {
            if (H().isPlaying()) {
                R();
            } else {
                d0();
            }
        }
    }

    private void I1() {
        int i3;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.U0;
        if (certifiedAccountMeta$StFeed != null && certifiedAccountMeta$StFeed.poster != null && H() != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f96320p1;
            StringBuilder sb5 = new StringBuilder();
            if (currentTimeMillis >= H().getDurationMs()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append("");
            String sb6 = sb5.toString();
            VSReporter.n(this.U0.poster.f24929id.get(), "auth_video", "play", 0, 0, H().getDurationMs() + "", currentTimeMillis + "", sb6, this.U0.f24925id.get());
        }
        if (G() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("time_cost", Long.valueOf(C()));
            hashMap.put("count", Integer.valueOf(G()));
            hashMap.put("url", this.f96324t1);
            VSReporter.q("subscribe_account_video_play_extra_buffer", VSReporter.i(hashMap));
        }
        VSReporter.q("subscribe_account_video_download", VSReporter.j(VSReporter.f(Long.valueOf(this.f96110i0).longValue(), 0L, this.f96324t1, 0L)));
        if (H() != null) {
            double currentPositionMs = H().getCurrentPositionMs();
            double durationMs = H().getDurationMs();
            if (currentPositionMs > 0.0d && durationMs > 0.0d && currentPositionMs <= durationMs) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rate", String.format("%.2f", Double.valueOf((currentPositionMs / durationMs) * 100.0d)));
                hashMap2.put("url", this.f96324t1);
                hashMap2.put("attach_info", String.valueOf(durationMs));
                VSReporter.q("subscribe_account_video_play_complete_rate", VSReporter.i(hashMap2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1() {
        Q1(1);
        this.B1 = false;
        View view = this.f96326v0;
        if (view != null && !this.f96315k1) {
            view.setVisibility(0);
        }
        View view2 = this.f96312h1;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (this.f96334z0 != null) {
            ImageView imageView = this.A0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.cc5);
            }
            this.f96334z0.setVisibility(0);
            W1(true);
        }
        View view3 = this.W0;
        if (view3 != null && view3.getVisibility() == 0) {
            this.W0.setVisibility(8);
        }
        q1();
        j().removeMessages(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1() {
        int i3;
        if (this.V0 != null && (getContext() instanceof Activity)) {
            if (((Activity) getContext()).getRequestedOrientation() == 0) {
                i3 = 25;
            } else {
                i3 = 12;
            }
            this.V0.setMaxEms(i3);
        }
    }

    private void L1() {
        this.f96324t1 = null;
        j().removeCallbacksAndMessages(null);
    }

    private void M1(int[] iArr) {
        getLayoutParams().width = iArr[0];
        getLayoutParams().height = iArr[1];
        setLayoutParams(getLayoutParams());
    }

    private boolean O(String str) {
        try {
            for (String str2 : ((String) VSConfigManager.c().e("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|")) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private void O1(boolean z16) {
        this.I0 = z16;
        SubscribeVideoDetailFragment subscribeVideoDetailFragment = this.Z0;
        if (subscribeVideoDetailFragment != null && subscribeVideoDetailFragment.getBaseActivity() != null) {
            View decorView = this.Z0.getBaseActivity().getWindow().getDecorView();
            if (this.I0) {
                SystemBarCompact systemBarCompact = this.F1;
                if (systemBarCompact != null) {
                    systemBarCompact.setStatusBarVisible(2, 0);
                }
                this.Z0.getBaseActivity().getWindow().setFlags(1024, 1024);
                LiuHaiUtils.resetFullScreen(this.Z0.getBaseActivity());
                ((IVideoFeedsHelper) QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(this.Z0.getBaseActivity());
            } else {
                SystemBarCompact systemBarCompact2 = this.F1;
                if (systemBarCompact2 != null) {
                    systemBarCompact2.setStatusBarVisible(0, 10);
                }
                this.Z0.getBaseActivity().getWindow().clearFlags(1024);
                LiuHaiUtils.closeFullScreen(this.Z0.getBaseActivity());
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-3));
            }
        }
        VideoNextFeedsView videoNextFeedsView = this.f96308d1;
        if (videoNextFeedsView != null) {
            videoNextFeedsView.setUIState(z16, this.A1);
        }
        h1(this.I0);
    }

    private void P1(int i3) {
        ArrayList<View> arrayList = this.L0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<View> it = this.L0.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next != null) {
                    next.setVisibility(i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(int i3) {
        this.D1 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1() {
        LinearLayout linearLayout;
        VideoNextFeedsView videoNextFeedsView;
        int i3;
        View view = this.f96326v0;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f96325u1;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.W0;
        if (view3 != null && view3.getVisibility() == 0) {
            this.W0.setVisibility(8);
        }
        VideoNextFeedsView videoNextFeedsView2 = this.f96308d1;
        if (videoNextFeedsView2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoNextFeedsView2.getLayoutParams();
            if (z1()) {
                layoutParams.addRule(12);
                layoutParams.addRule(13, 0);
            } else {
                layoutParams.addRule(13);
                layoutParams.addRule(12, 0);
            }
            this.f96308d1.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout2 = this.f96335z1;
        if (linearLayout2 != null) {
            if (z1()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            linearLayout2.setVisibility(i3);
        }
        if (z1() && this.U0 != null) {
            TextView textView = this.f96329w1;
            if (textView != null) {
                textView.setVisibility(0);
                this.f96329w1.setText(this.U0.poster.nick.get());
            }
            if (this.f96327v1 != null) {
                com.tencent.biz.subscribe.a.e(this.U0.poster.icon.get(), this.f96327v1);
            }
            FollowTextView followTextView = this.f96331x1;
            if (followTextView != null) {
                followTextView.setOnlyFollowMode(true);
                this.f96331x1.setFeedData(this.U0);
                this.f96331x1.setExtraTypeInfo(g());
                this.f96331x1.setFollowStateChangeListener(new f());
            }
            if (this.f96333y1 != null && (linearLayout = this.f96335z1) != null && this.f96331x1 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                if ((getContext() instanceof Activity) && ((Activity) getContext()).getRequestedOrientation() == 0 && (videoNextFeedsView = this.f96308d1) != null) {
                    layoutParams2.addRule(2, videoNextFeedsView.getId());
                    this.f96333y1.setOrientation(0);
                    ((LinearLayout.LayoutParams) this.f96331x1.getLayoutParams()).rightMargin = ImmersiveUtils.dpToPx(12.0f);
                } else {
                    this.f96333y1.setOrientation(1);
                    ((LinearLayout.LayoutParams) this.f96331x1.getLayoutParams()).rightMargin = 0;
                    layoutParams2.addRule(2, 0);
                }
                this.f96331x1.requestLayout();
            }
            View view4 = this.C1;
            if (view4 != null) {
                view4.setVisibility(8);
                return;
            }
            return;
        }
        View view5 = this.C1;
        if (view5 != null) {
            view5.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1() {
        if (!this.R0) {
            Iterator<View> it = J1.keySet().iterator();
            while (it.hasNext()) {
                m1(it.next(), 0, 1);
            }
            this.R0 = true;
            View view = this.f96334z0;
            if (view != null && view.getVisibility() == 8) {
                this.f96334z0.setVisibility(0);
            }
        }
    }

    private void T1() {
        if (this.U0 != null) {
            TextView textView = this.V0;
            if (textView != null) {
                textView.setVisibility(0);
            }
            K1();
        }
        ImageView imageView = this.f96332y0;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f160409cc2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
        l1();
        int i3 = this.K0[0];
        if (getLayoutParams().width != -1) {
            i3 = getLayoutParams().width;
        }
        this.J0 = new int[]{i3, getLayoutParams().height};
        if (this.A1) {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).setRequestedOrientation(0);
            }
            int[] iArr = this.K0;
            M1(new int[]{iArr[1], iArr[0]});
        } else {
            int[] iArr2 = this.K0;
            M1(new int[]{iArr2[0], iArr2[1]});
        }
        P1(8);
        O1(true);
        T1();
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1() {
        if (this.R0) {
            r1();
        } else {
            S1();
        }
        this.P0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(boolean z16) {
        int i3;
        ProgressBar progressBar = this.D0;
        int i16 = 0;
        if (progressBar != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            progressBar.setVisibility(i3);
        }
        ImageView imageView = this.A0;
        if (imageView != null) {
            if (z16) {
                i16 = 8;
            }
            imageView.setVisibility(i16);
        }
    }

    private void h1(boolean z16) {
        if (!LiuHaiUtils.isLiuHaiUseValid()) {
            return;
        }
        if (z16 && !this.A1) {
            SubscribeVideoDetailFragment subscribeVideoDetailFragment = this.Z0;
            if (subscribeVideoDetailFragment != null) {
                subscribeVideoDetailFragment.Ih(true, this.G1);
            }
            View view = this.f96326v0;
            if (view != null) {
                view.setPadding(0, this.G1, 0, 0);
                return;
            }
            return;
        }
        SubscribeVideoDetailFragment subscribeVideoDetailFragment2 = this.Z0;
        if (subscribeVideoDetailFragment2 != null) {
            subscribeVideoDetailFragment2.Ih(false, this.G1);
        }
        View view2 = this.f96326v0;
        if (view2 != null) {
            view2.setPadding(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        boolean z16;
        if (E() != null) {
            if (E().getRenderViewWidth() > E().getRenderViewHeight()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.A1 = z16;
        }
    }

    private void m1(View view, int i3, int i16) {
        n1(view, i3, i16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(View view, int i3, int i16, boolean z16) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, i3, i16);
        ofFloat.setDuration(0L);
        ofFloat.addListener(new c(i16, view, z16, i3));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).setRequestedOrientation(1);
            TextView textView = this.V0;
            if (textView != null) {
                textView.setMaxEms(12);
            }
        }
        M1(this.J0);
        P1(0);
        O1(false);
        s1();
        if (this.D1 == 10) {
            R1();
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        View view = this.f96325u1;
        if (view != null && view.getVisibility() == 0) {
            this.f96325u1.setVisibility(8);
        }
        VideoNextFeedsView videoNextFeedsView = this.f96308d1;
        if (videoNextFeedsView != null && videoNextFeedsView.getVisibility() == 0) {
            this.f96308d1.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        if (this.R0 && !this.S0) {
            Iterator<View> it = J1.keySet().iterator();
            while (it.hasNext()) {
                m1(it.next(), 1, 0);
            }
            this.R0 = false;
        }
    }

    private void s1() {
        TextView textView = this.V0;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f96332y0;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f160410cc3);
        }
        View view = this.W0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void t1() {
        View findViewById = findViewById(R.id.lhz);
        this.f96325u1 = findViewById;
        this.f96308d1 = (VideoNextFeedsView) findViewById.findViewById(R.id.kzp);
        this.C1 = this.f96325u1.findViewById(R.id.f166114lr0);
        this.f96335z1 = (LinearLayout) this.f96325u1.findViewById(R.id.lhy);
        this.f96327v1 = (SquareImageView) this.f96325u1.findViewById(R.id.lno);
        this.f96333y1 = (LinearLayout) this.f96325u1.findViewById(R.id.lqg);
        this.f96329w1 = (TextView) this.f96325u1.findViewById(R.id.mcq);
        this.f96331x1 = (FollowTextView) this.f96325u1.findViewById(R.id.f165306lj4);
        this.E0 = this.f96325u1.findViewById(R.id.mdq);
        d dVar = new d();
        this.E0.setOnClickListener(dVar);
        this.C1.setOnClickListener(dVar);
        this.f96308d1.setOnClickListener(new e());
        this.f96308d1.setOnCounterListener(new VideoNextFeedsView.a() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15
            @Override // com.tencent.biz.subscribe.widget.VideoNextFeedsView.a
            public void a(boolean z16) {
                VideoPlayerView.this.f96323s1 = z16;
                if (VideoPlayerView.this.E1) {
                    VideoPlayerView.this.j().post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15.1
                        @Override // java.lang.Runnable
                        public void run() {
                            VideoPlayerView.this.J1();
                            VideoPlayerView.this.U();
                        }
                    });
                    return;
                }
                if (VideoPlayerView.this.f96323s1) {
                    VideoPlayerView.this.j().post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoPlayerView.this.f96308d1 != null) {
                                VideoPlayerView.this.F1(true);
                            }
                        }
                    });
                    return;
                }
                if (VideoPlayerView.this.f96318n1) {
                    if (VideoPlayerView.this.H() != null) {
                        VideoPlayerView.this.H().setLoopback(true);
                    }
                    VideoPlayerView.this.U();
                    if (VideoPlayerView.this.f96317m1 != null) {
                        VideoPlayerView.this.f96317m1.onVideoStart((int) VideoPlayerView.this.H().getDurationMs());
                    }
                }
            }
        });
    }

    private void u1() {
        View findViewById = findViewById(R.id.m6w);
        this.f96326v0 = findViewById;
        this.f96328w0 = (TextView) findViewById.findViewById(R.id.kc_);
        this.V0 = (TextView) this.f96326v0.findViewById(R.id.kbs);
        this.f96330x0 = (TextView) this.f96326v0.findViewById(R.id.kc9);
        this.f96332y0 = (ImageView) this.f96326v0.findViewById(R.id.dvm);
        this.f96312h1 = this.f96326v0.findViewById(R.id.ecx);
        this.T0 = this.f96326v0.findViewById(R.id.eej);
        this.f96334z0 = this.f96326v0.findViewById(R.id.f166124lr4);
        this.A0 = (ImageView) this.f96326v0.findViewById(R.id.dyu);
        this.B0 = (ImageView) this.f96326v0.findViewById(R.id.lot);
        this.C0 = (ImageView) this.f96326v0.findViewById(R.id.lor);
        this.D0 = (ProgressBar) this.f96326v0.findViewById(R.id.loq);
        this.I1 = (SeekBar) this.f96326v0.findViewById(R.id.ilm);
    }

    private void w1() {
        HashMap<View, Integer> hashMap = J1;
        hashMap.put(this.f96326v0, 0);
        hashMap.put(this.C0, 0);
        hashMap.put(this.A0, 0);
        hashMap.put(this.B0, 0);
        hashMap.put(this.I1, 0);
        hashMap.put(this.f96332y0, 0);
        SparseBooleanArray sparseBooleanArray = L1;
        sparseBooleanArray.put(this.f96326v0.getId(), true);
        sparseBooleanArray.put(this.f96309e1.getId(), true);
        sparseBooleanArray.put(this.f96310f1.getId(), true);
    }

    private void x1() {
        this.f96326v0.setOnTouchListener(new g());
        this.f96306b1.setOnClickListener(new h());
        this.Y0.setFollowStateChangeListener(new i());
        this.A0.setOnClickListener(new j());
        this.f96332y0.setOnClickListener(new k());
        this.f96309e1.setOnClickListener(new l());
        this.f96310f1.setOnClickListener(new m());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void y1() {
        u1();
        t1();
        this.f96309e1 = findViewById(R.id.eed);
        this.f96310f1 = findViewById(R.id.eee);
        URLImageView uRLImageView = (URLImageView) findViewById(R.id.dys);
        this.H0 = uRLImageView;
        setVideoCover(uRLImageView);
        this.W0 = findViewById(R.id.cc5);
        this.Y0 = (FollowTextView) findViewById(R.id.mcp);
        this.X0 = (SquareImageView) findViewById(R.id.dwu);
        this.f96305a1 = findViewById(R.id.l3r);
        this.f96306b1 = (TextView) findViewById(R.id.k8s);
        w1();
        if (E() != null) {
            E().setXYaxis(2);
        }
        NetworkManager.registNetStatusListener(this);
    }

    public boolean A1() {
        return this.A1;
    }

    public boolean B1() {
        return this.f96318n1;
    }

    public boolean C1() {
        if (H() != null && H().isPlaying()) {
            return true;
        }
        return false;
    }

    public boolean E1() {
        if (this.I0) {
            p1();
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public SeekBar F() {
        return this.I1;
    }

    public void H1(boolean z16) {
        VideoNextFeedsView videoNextFeedsView = this.f96308d1;
        if (videoNextFeedsView != null) {
            videoNextFeedsView.k(z16);
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    protected boolean N() {
        return true;
    }

    public void N1() {
        super.d0();
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public void R() {
        if (H() != null) {
            Q1(7);
            super.R();
            this.I = true;
            this.f96321q1 = System.currentTimeMillis();
            ImageView imageView = this.A0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.cc5);
            }
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public void T() {
        super.T();
        I1();
        ArrayList<View> arrayList = this.L0;
        if (arrayList != null) {
            arrayList.clear();
        }
        SparseBooleanArray sparseBooleanArray = L1;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        HashMap<View, Integer> hashMap = J1;
        if (hashMap != null) {
            hashMap.clear();
        }
        j().removeCallbacksAndMessages(null);
    }

    public void X1(boolean z16) {
        int i3;
        ImageView imageView = this.B0;
        if (imageView != null) {
            if (z16) {
                i3 = R.drawable.hlx;
            } else {
                i3 = R.drawable.hlw;
            }
            imageView.setImageResource(i3);
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public void d0() {
        if (H() != null) {
            Q1(5);
            if (this.I && this.f96321q1 > 0) {
                this.f96320p1 -= System.currentTimeMillis() - this.f96321q1;
                this.f96321q1 = 0L;
            }
            this.I = false;
            super.d0();
            IVideoOuterStatusListener iVideoOuterStatusListener = this.f96317m1;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onVideoStart((int) H().getDurationMs());
            }
            ImageView imageView = this.A0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.f160411cc4);
            }
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public void e0() {
        I1();
        Q1(8);
        super.e0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public void f0() {
        super.f0();
        if (this.P0 || this.S0) {
            this.Q0 = 0;
            this.P0 = false;
        }
        int i3 = this.Q0;
        if (i3 > 120) {
            j().sendEmptyMessage(2);
        } else {
            this.Q0 = i3 + 1;
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public ExtraTypeInfo g() {
        return this.H1;
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(FollowUpdateEvent.class);
        arrayList.add(CommentListShowStateEvent.class);
        arrayList.add(SharePanelShowStateEvent.class);
        return arrayList;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        View view;
        int i16 = message.what;
        if (i16 != -1001) {
            if (i16 != 2) {
                if (i16 == 3 && (view = this.W0) != null) {
                    view.setVisibility(8);
                }
            } else {
                r1();
            }
        } else {
            if (this.M0) {
                i3 = message.arg2 - message.arg1;
            } else {
                i3 = message.arg1;
            }
            int i17 = i3 / 1000;
            int i18 = i17 / 60;
            int i19 = i17 % 60;
            if (H() != null && H().getCurrentPositionMs() > H().getDurationMs() / 2 && !this.B1) {
                D1();
            }
            if (!this.f96318n1) {
                TextView textView = this.f96330x0;
                if (textView != null) {
                    textView.setText(String.format("%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i19)));
                }
                if (this.f96107f0 != null && ((Boolean) message.obj).booleanValue()) {
                    this.f96107f0.a(String.format("%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i19)), message.arg2, message.arg1);
                }
            } else if (this.f96317m1 != null && ((Boolean) message.obj).booleanValue()) {
                this.f96317m1.onVideoProgressUpdate(message.arg1);
            }
        }
        return false;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.c7j;
    }

    public void i1(View view) {
        J1.put(view, Integer.valueOf(view.getVisibility()));
    }

    public void j1(View view) {
        this.L0.add(view);
    }

    public void k1(int[] iArr) {
        int i3;
        this.J0 = iArr;
        TextView textView = this.V0;
        if (textView != null) {
            if (iArr[0] > iArr[1]) {
                i3 = 25;
            } else {
                i3 = 12;
            }
            textView.setMaxEms(i3);
        }
    }

    public boolean o1() {
        if (H() != null && E() != null) {
            if (z1()) {
                p1();
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.8
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    FloatingScreenParams.FloatingBuilder floatingBuilder = new FloatingScreenParams.FloatingBuilder();
                    if (VideoPlayerView.this.E() != null && VideoPlayerView.this.E().getRenderViewWidth() <= VideoPlayerView.this.E().getRenderViewHeight()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(BaseApplication.getContext(), (View) VideoPlayerView.this.E(), floatingBuilder.setIsHorizontal(z16).setCanMove(true).setCanZoom(false).build(), 28) == 1) {
                        ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(VideoPlayerView.this.getContext());
                        return;
                    }
                    VideoPlayerView.this.v1();
                    VideoPlayerView.this.f96318n1 = true;
                    if (VideoPlayerView.this.f96308d1 != null && VideoPlayerView.this.f96308d1.getVisibility() == 0) {
                        VideoPlayerView.this.f96308d1.i();
                        VideoPlayerView.this.f96308d1.m();
                    }
                    if (VideoPlayerView.this.H().getCurrentPositionMs() >= VideoPlayerView.this.H().getDurationMs()) {
                        VideoPlayerView.this.U();
                        if (VideoPlayerView.this.f96317m1 != null) {
                            VideoPlayerView.this.f96317m1.onVideoStart((int) VideoPlayerView.this.H().getDurationMs());
                        }
                    }
                    if (VideoPlayerView.this.E() != null && VideoPlayerView.this.f96317m1 != null) {
                        VideoPlayerView.this.f96317m1.onVideoSize(VideoPlayerView.this.E().getRenderViewWidth(), VideoPlayerView.this.E().getRenderViewHeight());
                        VideoPlayerView.this.d0();
                    }
                    if (VideoPlayerView.this.Z0 != null) {
                        VideoPlayerView.this.Z0.getBaseActivity().finish();
                    }
                }
            }, 500L);
            return true;
        }
        QLog.d("VideoPlayerView", 4, "enterFloat to early, player is not init");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f96314j1 = false;
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        j().post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.18
            @Override // java.lang.Runnable
            public void run() {
                URLImageView uRLImageView;
                VideoPlayerView.this.Q1(10);
                if (VideoPlayerView.this.H() != null) {
                    VideoPlayerView.this.R1();
                    VideoPlayerView.this.S1();
                    VideoPlayerView.this.S0 = true;
                }
                if (VideoPlayerView.this.E1) {
                    VideoPlayerView.this.J1();
                    VideoPlayerView.this.U();
                } else if (VideoPlayerView.this.f96308d1 != null) {
                    if (VideoPlayerView.this.B1()) {
                        VideoPlayerView.this.f96308d1.m();
                    } else if (VideoPlayerView.this.f96308d1.n() && (uRLImageView = VideoPlayerView.this.H0) != null) {
                        uRLImageView.setBackgroundResource(R.color.f156808bw);
                        VideoPlayerView.this.H0.setImageDrawable(null);
                        VideoPlayerView.this.H0.setVisibility(0);
                        if (VideoPlayerView.this.U0 != null) {
                            VSReporter.p(VideoPlayerView.this.U0.poster.f24929id.get(), "auth_video", "finish_exp", 0, 0, "", "", VideoPlayerView.this.U0.poster.nick.get(), VideoPlayerView.this.U0.title.get());
                        }
                    }
                }
                if (VideoPlayerView.this.f96334z0 != null) {
                    VideoPlayerView.this.f96334z0.setVisibility(8);
                }
                if (VideoPlayerView.this.f96317m1 != null) {
                    VideoPlayerView.this.f96317m1.onVideoComplete(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.biz.subscribe.baseUI.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f96314j1 = true;
        VideoNextFeedsView videoNextFeedsView = this.f96308d1;
        if (videoNextFeedsView != null) {
            videoNextFeedsView.i();
        }
        j().removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, final int i3, int i16, int i17, String str) {
        super.onError(iSuperPlayer, i3, i16, i17, str);
        j().post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19
            @Override // java.lang.Runnable
            public void run() {
                VideoPlayerView.this.Q1(9);
                VideoPlayerView.this.W1(false);
                VSReporter.q("subscribe_account_video_play", VSReporter.j(VSReporter.f(i3, 0L, VideoPlayerView.this.f96324t1, 0L)));
                if (!VideoPlayerView.this.f96315k1) {
                    QQToast.makeText(VideoPlayerView.this.getContext(), 1, HardCodeUtil.qqStr(R.string.v68), 0).show();
                }
            }
        });
        return false;
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, final int i3, long j3, long j16, Object obj) {
        super.onInfo(iSuperPlayer, i3, j3, j16, obj);
        j().post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.20
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 == 112) {
                    VideoPlayerView.this.Q1(4);
                    VideoPlayerView.this.S0 = true;
                    VideoPlayerView.this.W1(true);
                    VideoPlayerView.this.S1();
                    return;
                }
                if (i16 == 113) {
                    VideoPlayerView.this.Q1(5);
                    VideoPlayerView.this.S0 = false;
                    VideoPlayerView.this.W1(false);
                    VideoPlayerView.this.r1();
                }
            }
        });
        return false;
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.component.network.NetworkManager.NetStatusListener
    public void onNetworkChanged(String str, String str2) {
        if (!"wifi".equals(str2)) {
            j().post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPlayerView.this.f96305a1 != null && VideoPlayerView.this.f96305a1.getVisibility() == 8 && !VideoPlayerView.M1) {
                        VideoPlayerView.this.R();
                        VideoPlayerView.this.S1();
                        VideoPlayerView.this.f96305a1.setVisibility(0);
                        VideoPlayerView.this.S0 = true;
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof FollowUpdateEvent) {
            FollowUpdateEvent followUpdateEvent = (FollowUpdateEvent) simpleBaseEvent;
            if (followUpdateEvent.followStatus == 0) {
                HashMap<String, Boolean> hashMap = this.f96313i1;
                if (hashMap != null) {
                    hashMap.remove(followUpdateEvent.useId);
                }
            } else {
                HashMap<String, Boolean> hashMap2 = this.f96313i1;
                if (hashMap2 != null) {
                    hashMap2.put(followUpdateEvent.useId, Boolean.TRUE);
                }
            }
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.U0;
            if (certifiedAccountMeta$StFeed != null) {
                certifiedAccountMeta$StFeed.poster.followState.set(followUpdateEvent.followStatus);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof CommentListShowStateEvent) {
            this.E1 = ((CommentListShowStateEvent) simpleBaseEvent).shown;
        } else if (simpleBaseEvent instanceof SharePanelShowStateEvent) {
            this.E1 = ((SharePanelShowStateEvent) simpleBaseEvent).shown;
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        this.S0 = true;
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        super.onStopTrackingTouch(seekBar);
        this.S0 = false;
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView, com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(final ISuperPlayer iSuperPlayer) {
        super.onVideoPrepared(iSuperPlayer);
        j().post(new Runnable() { // from class: com.tencent.biz.subscribe.videoplayer.VideoPlayerView.17
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int dpToPx;
                VSReporter.q("subscribe_account_video_play", VSReporter.j(VSReporter.f(0L, 0L, VideoPlayerView.this.f96324t1, 0L)));
                VSReporter.q("subscribe_account_video_play_first_buffer", VSReporter.j(VSReporter.f(0L, System.currentTimeMillis() - VideoPlayerView.this.f96316l1, VideoPlayerView.this.f96324t1, 0L)));
                VideoPlayerView.this.Q1(10);
                VideoPlayerView.this.S0 = false;
                VideoPlayerView.this.l1();
                VideoPlayerView.this.K1();
                if (VideoPlayerView.this.W0 != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VideoPlayerView.this.W0.getLayoutParams();
                    if (VideoPlayerView.this.A1) {
                        i3 = 21;
                    } else {
                        i3 = 85;
                    }
                    layoutParams.gravity = i3;
                    int dpToPx2 = ImmersiveUtils.dpToPx(25.0f);
                    if (VideoPlayerView.this.A1) {
                        dpToPx = 0;
                    } else {
                        dpToPx = ImmersiveUtils.dpToPx(82.0f);
                    }
                    layoutParams.setMargins(0, 0, dpToPx2, dpToPx);
                    VideoPlayerView.this.W0.setLayoutParams(layoutParams);
                }
                if (VideoPlayerView.this.f96317m1 != null && VideoPlayerView.this.B1() && VideoPlayerView.this.E() != null) {
                    if (!VideoPlayerView.this.f96319o1) {
                        VideoPlayerView.this.f96317m1.onOrientationChange(VideoPlayerView.this.A1);
                    }
                    VideoPlayerView.this.f96317m1.onVideoSize(VideoPlayerView.this.E().getRenderViewWidth(), VideoPlayerView.this.E().getRenderViewHeight());
                }
                if (VideoPlayerView.this.f96334z0 != null) {
                    VideoPlayerView.this.f96334z0.setVisibility(0);
                    VideoPlayerView.this.W1(false);
                }
                if (VideoPlayerView.this.f96312h1 != null) {
                    VideoPlayerView.this.f96312h1.setVisibility(0);
                }
                long durationMs = iSuperPlayer.getDurationMs() / 1000;
                TextView textView = VideoPlayerView.this.f96328w0;
                if (textView != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("/");
                    int i16 = (int) durationMs;
                    sb5.append(String.format("%02d:%02d", Integer.valueOf(i16 / 60), Integer.valueOf(i16 % 60)));
                    textView.setText(sb5.toString());
                }
                if ((VideoPlayerView.this.N0 && NetworkUtils.isWifiConnected(VideoPlayerView.this.getContext())) || VideoPlayerView.M1) {
                    if (!((BaseVideoView) VideoPlayerView.this).I) {
                        VideoPlayerView.this.d0();
                        VideoPlayerView.this.f96322r1 = System.currentTimeMillis();
                    }
                } else if (VideoPlayerView.this.f96307c1) {
                    VideoPlayerView.this.f96305a1.setVisibility(0);
                } else if (VideoPlayerView.this.f96334z0 != null) {
                    VideoPlayerView.this.f96334z0.setVisibility(0);
                }
                if (((BaseVideoView) VideoPlayerView.this).f96107f0 != null) {
                    ((BaseVideoView) VideoPlayerView.this).f96107f0.b(iSuperPlayer);
                }
                VideoPlayerView.this.r1();
            }
        });
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        SubscribeVideoDetailFragment subscribeVideoDetailFragment;
        super.onWindowFocusChanged(z16);
        if (z1() && (subscribeVideoDetailFragment = this.Z0) != null && subscribeVideoDetailFragment.getBaseActivity() != null) {
            ((IVideoFeedsHelper) QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(this.Z0.getBaseActivity());
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        y1();
        x1();
    }

    public void setCleanMode(boolean z16) {
        int i3;
        this.f96315k1 = z16;
        View view = this.f96326v0;
        if (view != null) {
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
    }

    public void setContinueFeeds(List<CertifiedAccountMeta$StFeed> list) {
        VideoNextFeedsView videoNextFeedsView;
        if (list != null && (videoNextFeedsView = this.f96308d1) != null) {
            videoNextFeedsView.setData(list);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void setExtraTypeInfo(ExtraTypeInfo extraTypeInfo) {
        this.H1 = extraTypeInfo;
    }

    public void setHostFragment(SubscribeVideoDetailFragment subscribeVideoDetailFragment) {
        this.Z0 = subscribeVideoDetailFragment;
        if (subscribeVideoDetailFragment.getBaseActivity() != null) {
            this.F1 = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) this.Z0.getBaseActivity());
            this.G1 = LiuHaiUtils.getNotchInScreenHeight(this.Z0.getBaseActivity());
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public void setLoopBack(boolean z16) {
        if (H() != null) {
            H().setLoopback(z16);
        }
    }

    public void setNeedWifiTips(boolean z16) {
        this.f96307c1 = z16;
    }

    public void setNextVideoClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.C0;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    public void setOutPutMute(boolean z16) {
        if (H() != null) {
            H().setOutputMute(z16);
        }
    }

    public void setPreviewVideoClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.B0;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setRevertProgress(boolean z16) {
        this.M0 = z16;
    }

    public void setVideoFeeds(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed == null) {
            return;
        }
        this.U0 = certifiedAccountMeta$StFeed;
        setVideoPath(certifiedAccountMeta$StFeed.video.fileId.get(), certifiedAccountMeta$StFeed.video.playUrl.get());
        if (this.X0 != null) {
            com.tencent.biz.subscribe.a.e(certifiedAccountMeta$StFeed.poster.icon.get(), this.X0);
        }
        TextView textView = this.V0;
        if (textView != null) {
            textView.setText(this.U0.title.get());
        }
    }

    public void setVideoPath(String str, String str2) {
        L1();
        J1();
        VSReporter.a();
        if (!StringUtil.isEmpty(str2) && O(str2)) {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                parse.getQueryParameter("playerformat");
                if (StringUtil.isEmpty(str)) {
                    str = parse.getQueryParameter("vid");
                }
            }
            str2 = null;
        }
        if (str2 != null) {
            this.f96324t1 = str2;
        } else {
            this.f96324t1 = str;
        }
        S1();
        this.S0 = true;
        super.setVideoPath(str, str2, 0);
        this.f96316l1 = System.currentTimeMillis();
        VSReporter.q("subscribe_account_video_start_play", VSReporter.j(VSReporter.f(0L, 0L, this.f96324t1, 0L)));
        VSReporter.q("subscribe_account_video_start_download", VSReporter.j(VSReporter.f(0L, 0L, this.f96324t1, 0L)));
        this.f96320p1 = System.currentTimeMillis();
    }

    public void setVideoViewCover(String str) {
        if (this.H0 != null) {
            this.O0 = str;
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.d_0);
                obtain.mFailedDrawable = getResources().getDrawable(R.drawable.d_0);
                URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                if (drawable != null) {
                    this.H0.setImageDrawable(drawable);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void setWifiAutoPlay(boolean z16) {
        this.N0 = z16;
    }

    public void v1() {
        this.f96317m1 = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new n());
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFullScreenViewClickListener(new a());
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(((IFloatingWrapperManager) QRoute.api(IFloatingWrapperManager.class)).getFloatingVideoWrapperName(), new b());
    }

    public boolean z1() {
        return this.I0;
    }

    public VideoPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F0 = 2;
        this.G0 = 3;
        this.I0 = false;
        this.J0 = null;
        this.K0 = LiuHaiUtils.getRealDisplay(getContext());
        this.L0 = new ArrayList<>();
        this.M0 = false;
        this.O0 = "";
        this.R0 = true;
        this.S0 = true;
        this.f96311g1 = 0L;
        this.f96313i1 = new HashMap<>();
        this.f96318n1 = false;
        this.f96319o1 = false;
        this.f96323s1 = false;
        this.D1 = 1;
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    protected void Y() {
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    protected void W(long j3, long j16) {
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    protected void X(long j3, long j16) {
    }

    @Override // com.tencent.biz.subscribe.framework.BaseVideoView
    protected void V(int i3, int i16, long j3, long j16) {
    }
}
