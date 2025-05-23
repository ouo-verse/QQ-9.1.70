package com.tencent.biz.qqcircle.immersive.feed.animwrap;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.widget.bubble.GdtBubbleDanmakuLayout;
import com.tencent.biz.qqcircle.immersive.events.QFSAdBannerChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSAdDownloadButton;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedAdCardAnimEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.af;
import com.tencent.biz.qqcircle.immersive.feed.ad.eq;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.widget.ak;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedAdCardAnimWrap {
    private boolean E;
    private af.c H;

    /* renamed from: a, reason: collision with root package name */
    View f85786a;

    /* renamed from: b, reason: collision with root package name */
    RelativeLayout f85787b;

    /* renamed from: c, reason: collision with root package name */
    RelativeLayout f85788c;

    /* renamed from: d, reason: collision with root package name */
    ViewGroup f85789d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f85790e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f85791f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f85793h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f85794i;

    /* renamed from: j, reason: collision with root package name */
    LinearLayout f85795j;

    /* renamed from: k, reason: collision with root package name */
    GdtShakeIconView f85796k;

    /* renamed from: l, reason: collision with root package name */
    GdtShakeIconView f85797l;

    /* renamed from: m, reason: collision with root package name */
    GdtShakeIconView f85798m;

    /* renamed from: n, reason: collision with root package name */
    GdtShakeIconView f85799n;

    /* renamed from: o, reason: collision with root package name */
    GdtShakeIconView f85800o;

    /* renamed from: p, reason: collision with root package name */
    QCircleAsyncTextView f85801p;

    /* renamed from: q, reason: collision with root package name */
    FeedCloudMeta$StFeed f85802q;

    /* renamed from: r, reason: collision with root package name */
    private GdtAd f85803r;

    /* renamed from: s, reason: collision with root package name */
    GdtBubbleDanmakuLayout f85804s;

    /* renamed from: t, reason: collision with root package name */
    private long f85805t;

    /* renamed from: g, reason: collision with root package name */
    private boolean f85792g = false;

    /* renamed from: u, reason: collision with root package name */
    private final long f85806u = 300;

    /* renamed from: v, reason: collision with root package name */
    private long f85807v = 1000;

    /* renamed from: w, reason: collision with root package name */
    private long f85808w = 1000;

    /* renamed from: x, reason: collision with root package name */
    private long f85809x = 2000;

    /* renamed from: y, reason: collision with root package name */
    ValueAnimator f85810y = null;

    /* renamed from: z, reason: collision with root package name */
    ValueAnimator f85811z = null;
    ValueAnimator A = null;
    ValueAnimator B = null;
    private boolean C = false;
    private boolean D = false;
    private final HashSet<ValueAnimator> F = new HashSet<>();
    private Runnable G = null;
    Runnable I = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap.1
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedAdCardAnimWrap.this.C) {
                if (QLog.isColorLevel()) {
                    QLog.d("QFSFeedAdCardAnimWarp", 1, "buttonAnimRunnable run");
                }
                QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = QFSFeedAdCardAnimWrap.this;
                qFSFeedAdCardAnimWrap.f85810y.setDuration(qFSFeedAdCardAnimWrap.f85805t);
                QFSFeedAdCardAnimWrap.this.f85810y.start();
                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("threecard", "2");
            }
        }
    };
    Runnable J = new AnonymousClass2();
    Runnable K = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap.3

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap$3$a */
        /* loaded from: classes4.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f85813d;

            a(int i3) {
                this.f85813d = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                QFSFeedAdCardAnimWrap.this.f85786a.setTranslationX(-intValue);
                QFSFeedAdCardAnimWrap.this.f85787b.setTranslationX(intValue - this.f85813d);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int p16 = af.p();
            if (QFSFeedAdCardAnimWrap.this.f85786a.getTranslationX() != 0.0f) {
                QLog.e("QFSFeedAdCardAnimWarp", 1, "[hideAdBigBannerRunnable] big banner translationX: " + QFSFeedAdCardAnimWrap.this.f85786a.getTranslationX());
            }
            if (QLog.isColorLevel()) {
                QLog.d("QFSFeedAdCardAnimWarp", 1, "hideAdBigBannerRunnable run. translationX: " + p16);
            }
            if (QFSFeedAdCardAnimWrap.this.C) {
                QFSFeedAdCardAnimWrap.this.A = ValueAnimator.ofInt(0, p16);
                QFSFeedAdCardAnimWrap.this.A.setInterpolator(new DecelerateInterpolator());
                QFSFeedAdCardAnimWrap.this.A.setDuration(300L);
                QFSFeedAdCardAnimWrap.this.A.addUpdateListener(new a(p16));
                QFSFeedAdCardAnimWrap.this.A.addListener(new b());
                QFSFeedAdCardAnimWrap.this.F.add(QFSFeedAdCardAnimWrap.this.A);
                QFSFeedAdCardAnimWrap.this.w();
                QFSFeedAdCardAnimWrap.this.A.start();
                QFSFeedAdCardAnimWrap.this.R();
                QFSFeedAdCardAnimWrap.this.Q();
                QFSFeedAdCardAnimWrap.this.P();
                QFSFeedAdCardAnimWrap.this.M();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap$3$b */
        /* loaded from: classes4.dex */
        class b extends ak {
            b() {
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QFSFeedAdCardAnimWrap.this.U();
                QFSAdBannerChangeEvent qFSAdBannerChangeEvent = new QFSAdBannerChangeEvent(QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_BUTTON);
                qFSAdBannerChangeEvent.mShow = false;
                SimpleEventBus.getInstance().dispatchEvent(qFSAdBannerChangeEvent);
                View view = QFSFeedAdCardAnimWrap.this.f85786a;
                if (view != null) {
                    view.setVisibility(8);
                }
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RelativeLayout relativeLayout = QFSFeedAdCardAnimWrap.this.f85787b;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }
    };
    Runnable L = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap.4

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap$4$a */
        /* loaded from: classes4.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (animatedFraction < 0.5f) {
                    return;
                }
                QFSFeedAdCardAnimWrap.this.f85788c.setVisibility(0);
                QFSFeedAdCardAnimWrap.this.f85788c.setAlpha(animatedFraction);
                QFSFeedAdCardAnimWrap.this.f85788c.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d("QFSFeedAdCardAnimWarp", 1, "showAdSimpleBannerRunnable run");
            }
            if (QFSFeedAdCardAnimWrap.this.f85794i) {
                return;
            }
            if (QFSFeedAdCardAnimWrap.this.C && !af.K(QFSFeedAdCardAnimWrap.this.f85802q) && QFSFeedAdCardAnimWrap.this.f85793h) {
                if (af.J(QFSFeedAdCardAnimWrap.this.f85802q)) {
                    QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = QFSFeedAdCardAnimWrap.this;
                    qFSFeedAdCardAnimWrap.H(true, qFSFeedAdCardAnimWrap.f85809x + QFSFeedAdCardAnimWrap.this.f85807v);
                    return;
                }
                return;
            }
            if (QFSFeedAdCardAnimWrap.this.C) {
                QFSFeedAdCardAnimWrap.this.B = ValueAnimator.ofInt(cx.a(4.0f), 0);
                QFSFeedAdCardAnimWrap.this.B.setInterpolator(new AccelerateDecelerateInterpolator());
                QFSFeedAdCardAnimWrap.this.B.setDuration(300L);
                QFSFeedAdCardAnimWrap.this.B.addUpdateListener(new a());
                QFSFeedAdCardAnimWrap.this.B.addListener(new b());
                QFSFeedAdCardAnimWrap.this.F.add(QFSFeedAdCardAnimWrap.this.B);
                QFSFeedAdCardAnimWrap.this.w();
                QFSFeedAdCardAnimWrap.this.B.start();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap$4$b */
        /* loaded from: classes4.dex */
        class b extends ak {
            b() {
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QFSFeedAdCardAnimWrap.this.G = null;
                if (QFSFeedAdCardAnimWrap.this.C) {
                    QFSFeedAdCardAnimWrap.this.U();
                    QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = QFSFeedAdCardAnimWrap.this;
                    qFSFeedAdCardAnimWrap.t(qFSFeedAdCardAnimWrap.f85807v, 1000L, QFSFeedAdCardAnimWrap.this.D);
                }
                SimpleEventBus.getInstance().dispatchEvent(new QFSFeedAdCardAnimEvent(QFSFeedAdCardAnimWrap.this.f85803r, "2", 2));
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSFeedAdCardAnimEvent(QFSFeedAdCardAnimWrap.this.f85803r, "2", 1));
                QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = QFSFeedAdCardAnimWrap.this;
                if (qFSFeedAdCardAnimWrap.f85795j != null) {
                    qFSFeedAdCardAnimWrap.f85796k.stop();
                    QFSFeedAdCardAnimWrap.this.f85795j.setVisibility(8);
                }
                if (QFSFeedAdCardAnimWrap.this.H != null) {
                    QFSFeedAdCardAnimWrap.this.H.a();
                }
                QFSFeedAdCardAnimWrap.this.M();
                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("threecard", "1");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (view != null) {
                QFSFeedAdCardAnimWrap.this.V();
                view.removeOnLayoutChangeListener(this);
            } else {
                QLog.e("QFSFeedAdCardAnimWarp", 1, "LayoutMeasureListener view is null");
            }
        }
    }

    public QFSFeedAdCardAnimWrap(View view, View view2, ImageView imageView, FeedCloudMeta$StFeed feedCloudMeta$StFeed, GdtAd gdtAd) {
        boolean z16 = false;
        this.f85791f = false;
        this.f85793h = false;
        this.f85794i = false;
        this.E = false;
        if (view == null) {
            return;
        }
        this.f85787b = (RelativeLayout) view.findViewById(R.id.f38711_p);
        this.f85788c = (RelativeLayout) view.findViewById(R.id.f38701_o);
        this.f85795j = (LinearLayout) view.findViewById(R.id.f33280w1);
        this.f85796k = (GdtShakeIconView) view.findViewById(R.id.f38681_m);
        this.f85800o = (GdtShakeIconView) view.findViewById(R.id.f379618o);
        if (af.k(gdtAd)) {
            QFSAdDownloadButton qFSAdDownloadButton = (QFSAdDownloadButton) view.findViewById(R.id.f38751_t);
            this.f85789d = (ViewGroup) qFSAdDownloadButton.findViewById(R.id.f33240vx);
            this.f85797l = qFSAdDownloadButton.getShakeIcon();
            this.f85798m = ((QFSAdDownloadButton) view.findViewById(R.id.f376517u)).getShakeIcon();
            this.f85799n = ((QFSAdDownloadButton) view.findViewById(R.id.f380418w)).getShakeIcon();
        } else {
            this.f85789d = (ViewGroup) view.findViewById(R.id.f38721_q);
            this.f85797l = (GdtShakeIconView) view.findViewById(R.id.f38731_r);
            this.f85798m = (GdtShakeIconView) view.findViewById(R.id.f374917e);
            this.f85799n = (GdtShakeIconView) view.findViewById(R.id.f375117g);
        }
        this.f85804s = (GdtBubbleDanmakuLayout) view.findViewById(R.id.f165345vm4);
        this.f85786a = view2;
        if (view2 != null) {
            view2.addOnLayoutChangeListener(new b());
        }
        this.f85801p = (QCircleAsyncTextView) view.findViewById(R.id.v9j);
        this.f85790e = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QFSFeedAdCardAnimWrap.this.z(view3);
            }
        });
        this.f85802q = feedCloudMeta$StFeed;
        this.f85803r = gdtAd;
        this.f85791f = af.Z(gdtAd) && af.z(this.f85803r) == 1;
        eq eqVar = eq.f85700a;
        GdtAd gdtAd2 = this.f85803r;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f85802q;
        this.f85793h = eqVar.a(gdtAd2, feedCloudMeta$StFeed2 != null ? feedCloudMeta$StFeed2.status.get() : Integer.MIN_VALUE);
        this.f85794i = eqVar.h(this.f85803r);
        GdtAd gdtAd3 = this.f85803r;
        if (gdtAd3 != null && !RFSafeListUtils.isEmpty(gdtAd3.getDanmakuContents())) {
            z16 = true;
        }
        this.E = z16;
        x();
    }

    private void L(GdtShakeIconView gdtShakeIconView) {
        if (gdtShakeIconView == null) {
            return;
        }
        gdtShakeIconView.stop();
        gdtShakeIconView.setVisibility(0);
        gdtShakeIconView.setImageResource();
        gdtShakeIconView.startAnimation(Integer.MAX_VALUE, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
    }

    private void O(GdtShakeIconView gdtShakeIconView) {
        if (gdtShakeIconView == null) {
            return;
        }
        gdtShakeIconView.setVisibility(8);
        gdtShakeIconView.stop();
        gdtShakeIconView.resetImageResource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.f85804s != null) {
            V();
            this.f85804s.start();
            this.f85804s.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        View view;
        if (this.f85787b != null && this.f85804s != null) {
            if (this.E) {
                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n(QCircleDaTongConstant.ElementParamValue.BARRAGE, "1");
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f85787b.getLayoutParams();
            float y16 = this.f85787b.getY();
            if ((layoutParams.leftMargin < 0 || this.f85787b.getVisibility() == 8) && (view = this.f85786a) != null) {
                y16 = view.getY();
            }
            QLog.d("QFSFeedAdCardAnimWarp", 1, "updateAndShowDanmakuLayout visibleY:" + y16 + "qfsAdSimpleBannerLayout y:" + this.f85787b.getY());
            GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.f85804s;
            gdtBubbleDanmakuLayout.setY(y16 - ((float) gdtBubbleDanmakuLayout.getHeight()));
        }
    }

    private void s(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j3, long j16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdCardAnimWarp", 1, "doButtonAnim delayMillis=" + j3 + ",=canShowAdBigBanner" + z16);
        }
        this.f85805t = j16;
        this.G = this.I;
        RFWThreadManager.getUIHandler().removeCallbacks(this.I);
        RFWThreadManager.getUIHandler().postDelayed(this.I, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADCARD_THREE_STAGE, QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_BUTTON);
        VideoReport.setElementParams(this.f85789d, buildElementParams);
        VideoReport.clearElementExposure(this.f85789d, false);
        VideoReport.reportEvent("dt_imp", null, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.f85804s;
        if (gdtBubbleDanmakuLayout != null) {
            gdtBubbleDanmakuLayout.setVisibility(4);
        }
    }

    private void x() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f85810y = ofFloat;
        ofFloat.setDuration(this.f85805t);
        this.f85810y.setInterpolator(new AccelerateDecelerateInterpolator());
        final String w3 = af.w(this.f85802q, "startColor");
        final String w16 = af.w(this.f85802q, "endColor");
        this.f85810y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedAdCardAnimWrap.this.y(w3, w16, valueAnimator);
            }
        });
        this.f85810y.addListener(new a());
        this.F.add(this.f85810y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str, String str2, ValueAnimator valueAnimator) {
        GradientDrawable gradientDrawable;
        ViewGroup viewGroup = this.f85789d;
        if (viewGroup == null || (gradientDrawable = (GradientDrawable) viewGroup.getBackground()) == null) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        gradientDrawable.setColors(new int[]{v(floatValue, str).intValue(), v(floatValue, str2).intValue()});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        H(false, 0L);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void A() {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdCardAnimWarp", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
        this.C = true;
        ((GradientDrawable) this.f85789d.getBackground()).setColors(new int[]{v(0.0f, af.w(this.f85802q, "startColor")).intValue(), v(0.0f, af.w(this.f85802q, "endColor")).intValue()});
        af.k0(false);
        this.f85788c.setAlpha(0.0f);
        this.f85787b.setTranslationX(0.0f);
        this.f85786a.setTranslationX(-af.p());
        this.f85786a.setVisibility(8);
        this.f85787b.setVisibility(0);
        G(this.D, this.f85808w, this.f85807v, this.f85809x);
        SimpleEventBus.getInstance().dispatchEvent(new QFSAdBannerChangeEvent("state2"));
    }

    public void B() {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdCardAnimWarp", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
        this.C = false;
        GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.f85804s;
        if (gdtBubbleDanmakuLayout != null) {
            gdtBubbleDanmakuLayout.setVisibility(8);
            this.f85804s.stopAnimator();
        }
        af.r0(this.f85786a, 8);
        af.r0(this.f85788c, 8);
        RFWThreadManager.getUIHandler().removeCallbacks(this.I);
        RFWThreadManager.getUIHandler().removeCallbacks(this.J);
        RFWThreadManager.getUIHandler().removeCallbacks(this.K);
        RFWThreadManager.getUIHandler().removeCallbacks(this.L);
        s(this.f85810y);
        s(this.f85811z);
        s(this.A);
        s(this.B);
        this.G = null;
        S();
        R();
        Q();
        P();
    }

    public void C() {
        Iterator<ValueAnimator> it = this.F.iterator();
        while (it.hasNext()) {
            ValueAnimator next = it.next();
            if (next.isRunning()) {
                next.pause();
                return;
            }
        }
        GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.f85804s;
        if (gdtBubbleDanmakuLayout != null) {
            gdtBubbleDanmakuLayout.pauseAnimator();
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.G);
    }

    public void D() {
        Iterator<ValueAnimator> it = this.F.iterator();
        while (it.hasNext()) {
            ValueAnimator next = it.next();
            if (next.isPaused()) {
                next.resume();
                return;
            }
        }
        GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.f85804s;
        if (gdtBubbleDanmakuLayout != null) {
            gdtBubbleDanmakuLayout.resumeAnimator();
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.G);
        RFWThreadManager.getUIHandler().postDelayed(this.G, 0L);
    }

    public void E(boolean z16) {
        this.f85792g = z16;
    }

    public void F(af.c cVar) {
        this.H = cVar;
    }

    public void G(boolean z16, long j3, long j16, long j17) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdCardAnimWarp", 1, "startAdBannerAnim canShowAdBigBanner=" + z16 + ",delayMillis=" + j3);
        }
        if (!this.C) {
            return;
        }
        this.D = z16;
        this.f85807v = j16;
        this.f85809x = j17;
        this.f85808w = j3;
        this.G = this.L;
        RFWThreadManager.getUIHandler().removeCallbacks(this.L);
        RFWThreadManager.getUIHandler().postDelayed(this.L, j3);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap.6
            @Override // java.lang.Runnable
            public void run() {
                SimpleEventBus.getInstance().dispatchEvent(new QFSFeedAdCardAnimEvent(QFSFeedAdCardAnimWrap.this.f85803r, "1", 0));
            }
        });
    }

    public void H(boolean z16, long j3) {
        Runnable runnable;
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdCardAnimWarp", 1, "startAdBigBannerAnim isOpen=" + z16 + ",delayMillis=" + j3);
        }
        if (!this.C) {
            return;
        }
        if (z16) {
            runnable = this.J;
        } else {
            runnable = this.K;
        }
        if (z16) {
            this.G = this.J;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        RFWThreadManager.getUIHandler().postDelayed(runnable, j3);
    }

    public void I() {
        if (this.f85792g && this.f85791f) {
            L(this.f85799n);
        }
    }

    public void J() {
        if (!this.f85792g && this.f85791f) {
            L(this.f85798m);
        }
    }

    public void K() {
        GdtShakeIconView gdtShakeIconView = this.f85800o;
        if (gdtShakeIconView != null && this.f85791f) {
            L(gdtShakeIconView);
        }
    }

    public void M() {
        if (!this.f85791f) {
            return;
        }
        L(this.f85797l);
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("shake", "2");
    }

    public void N() {
        L(this.f85796k);
    }

    public void P() {
        O(this.f85799n);
    }

    public void Q() {
        GdtShakeIconView gdtShakeIconView = this.f85798m;
        if (gdtShakeIconView == null) {
            return;
        }
        O(gdtShakeIconView);
    }

    public void R() {
        GdtShakeIconView gdtShakeIconView = this.f85798m;
        if (gdtShakeIconView == null) {
            return;
        }
        O(gdtShakeIconView);
    }

    public void S() {
        O(this.f85797l);
    }

    public void T() {
        O(this.f85796k);
    }

    public Integer v(float f16, String str) {
        float f17;
        float[] fArr = new float[3];
        if (f16 < 0.1f) {
            f17 = 25.5f;
        } else {
            f17 = 255.0f * f16;
        }
        Color.colorToHSV(Color.parseColor(str), fArr);
        fArr[1] = fArr[1] * f16;
        fArr[2] = 1.0f;
        return Integer.valueOf(Color.HSVToColor((int) f17, fArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            QFSFeedAdCardAnimWrap.this.f85787b.setTranslationX(-intValue);
            QFSFeedAdCardAnimWrap.this.f85786a.setTranslationX(intValue - i3);
        }

        @Override // java.lang.Runnable
        public void run() {
            final int p16 = af.p();
            if (QFSFeedAdCardAnimWrap.this.f85787b.getTranslationX() != 0.0f) {
                QLog.e("QFSFeedAdCardAnimWarp", 1, "[showAdBigBannerRunnable] big banner translationX: " + QFSFeedAdCardAnimWrap.this.f85787b.getTranslationX());
            }
            if (QLog.isColorLevel()) {
                QLog.d("QFSFeedAdCardAnimWarp", 1, "showAdBigBannerRunnable run. translationX: " + p16);
            }
            if (QFSFeedAdCardAnimWrap.this.C) {
                QFSFeedAdCardAnimWrap.this.f85811z = ValueAnimator.ofInt(0, p16);
                QFSFeedAdCardAnimWrap.this.f85811z.setInterpolator(new DecelerateInterpolator());
                QFSFeedAdCardAnimWrap.this.f85811z.setDuration(300L);
                QFSFeedAdCardAnimWrap.this.f85811z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        QFSFeedAdCardAnimWrap.AnonymousClass2.this.b(p16, valueAnimator);
                    }
                });
                QFSFeedAdCardAnimWrap.this.f85811z.addListener(new a());
                QFSFeedAdCardAnimWrap.this.F.add(QFSFeedAdCardAnimWrap.this.f85811z);
                QFSFeedAdCardAnimWrap.this.f85786a.setVisibility(0);
                QFSFeedAdCardAnimWrap.this.w();
                QFSFeedAdCardAnimWrap.this.f85811z.start();
                QFSFeedAdCardAnimWrap.this.S();
                QFSFeedAdCardAnimWrap.this.J();
                QFSFeedAdCardAnimWrap.this.I();
                QFSFeedAdCardAnimWrap.this.K();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap$2$a */
        /* loaded from: classes4.dex */
        class a extends ak {
            a() {
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QFSFeedAdCardAnimWrap.this.G = null;
                QFSAdBannerChangeEvent qFSAdBannerChangeEvent = new QFSAdBannerChangeEvent(QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_4);
                qFSAdBannerChangeEvent.mShow = true;
                SimpleEventBus.getInstance().dispatchEvent(qFSAdBannerChangeEvent);
                RelativeLayout relativeLayout = QFSFeedAdCardAnimWrap.this.f85787b;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                QFSFeedAdCardAnimWrap.this.U();
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View view = QFSFeedAdCardAnimWrap.this.f85786a;
                if (view != null) {
                    view.setVisibility(0);
                }
                com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
                dVar.n("threecard", "3");
                if (QFSFeedAdCardAnimWrap.this.f85790e.getId() == R.id.f375517k) {
                    dVar.n("gameindustry", "1");
                    dVar.n("textlabel", "1");
                } else if (QFSFeedAdCardAnimWrap.this.f85790e.getId() == R.id.f38541_9) {
                    dVar.n(QAdVrReport.ElementID.AD_POSTER, "1");
                }
                if (QFSFeedAdCardAnimWrap.this.H != null) {
                    QFSFeedAdCardAnimWrap.this.H.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ak {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedAdCardAnimWrap.this.G = null;
            if (QFSFeedAdCardAnimWrap.this.D) {
                QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = QFSFeedAdCardAnimWrap.this;
                qFSFeedAdCardAnimWrap.H(true, qFSFeedAdCardAnimWrap.f85809x);
            }
            QFSFeedAdCardAnimWrap.this.u();
            SimpleEventBus.getInstance().dispatchEvent(new QFSAdBannerChangeEvent(QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_BUTTON));
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            af.k0(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
