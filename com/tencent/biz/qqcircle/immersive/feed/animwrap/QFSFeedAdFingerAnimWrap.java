package com.tencent.biz.qqcircle.immersive.feed.animwrap;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.events.QFSAdBannerChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSAdFingerStateChangeEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.widget.ak;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedAdFingerAnimWrap {

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f85820a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f85821b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f85822c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f85823d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f85824e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f85825f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f85826g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f85827h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f85828i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f85829j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f85830k;

    /* renamed from: l, reason: collision with root package name */
    private APNGDrawable f85831l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f85832m = null;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f85833n = null;

    /* renamed from: o, reason: collision with root package name */
    private Animation f85834o = null;

    /* renamed from: p, reason: collision with root package name */
    private Animation f85835p = null;

    /* renamed from: q, reason: collision with root package name */
    private final HashSet<ValueAnimator> f85836q = new HashSet<>();

    /* renamed from: r, reason: collision with root package name */
    private long f85837r = 2000;

    /* renamed from: s, reason: collision with root package name */
    private long f85838s = 2000;

    /* renamed from: t, reason: collision with root package name */
    private long f85839t = 2000;

    /* renamed from: u, reason: collision with root package name */
    private int f85840u = 0;

    /* renamed from: v, reason: collision with root package name */
    private Runnable f85841v = null;

    /* renamed from: w, reason: collision with root package name */
    private Runnable f85842w = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdFingerAnimWrap.1
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedAdFingerAnimWrap.this.f85826g != null && !QFSFeedAdFingerAnimWrap.this.C) {
                QFSFeedAdFingerAnimWrap.this.f85826g.startAnimation(QFSFeedAdFingerAnimWrap.this.f85834o);
            }
        }
    };

    /* renamed from: x, reason: collision with root package name */
    private Runnable f85843x = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdFingerAnimWrap.2
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedAdFingerAnimWrap.this.f85827h != null && QFSFeedAdFingerAnimWrap.this.A) {
                QFSFeedAdFingerAnimWrap.this.f85827h.setVisibility(0);
                QFSFeedAdFingerAnimWrap.this.f85827h.startAnimation(QFSFeedAdFingerAnimWrap.this.f85835p);
            }
        }
    };

    /* renamed from: y, reason: collision with root package name */
    private boolean f85844y = false;

    /* renamed from: z, reason: collision with root package name */
    private boolean f85845z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;

    public QFSFeedAdFingerAnimWrap(View view) {
        if (view == null) {
            return;
        }
        this.f85820a = (RelativeLayout) view.findViewById(R.id.f41641hm);
        this.f85821b = (RelativeLayout) view.findViewById(R.id.f41671hp);
        this.f85822c = (RelativeLayout) view.findViewById(R.id.f41761hy);
        this.f85823d = (RelativeLayout) view.findViewById(R.id.f41691hr);
        this.f85824e = (ImageView) view.findViewById(R.id.f41661ho);
        this.f85825f = (ImageView) view.findViewById(R.id.f41701hs);
        this.f85826g = (ImageView) view.findViewById(R.id.f41681hq);
        this.f85827h = (ImageView) view.findViewById(R.id.f41731hv);
        this.f85829j = (TextView) view.findViewById(R.id.f41721hu);
        this.f85830k = (TextView) view.findViewById(R.id.f41751hx);
        this.f85828i = (ImageView) view.findViewById(R.id.f41741hw);
        E();
        M();
    }

    private void E() {
        I();
        G();
        H();
        F();
    }

    private void F() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -0.3f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.f85835p = translateAnimation;
        translateAnimation.setDuration(660L);
        this.f85835p.setAnimationListener(new c());
    }

    private void G() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, this.f85826g.getX(), 0, cx.a(6.0f) + this.f85826g.getX(), 0, this.f85826g.getY(), 0, this.f85826g.getY());
        this.f85834o = translateAnimation;
        translateAnimation.setDuration(180L);
        this.f85834o.setInterpolator(new LinearInterpolator());
        this.f85834o.setFillBefore(true);
        this.f85834o.setRepeatCount(2);
        this.f85834o.setRepeatMode(2);
        this.f85834o.setAnimationListener(new b());
    }

    private void H() {
        ValueAnimator ofInt = ValueAnimator.ofInt(cx.a(32.0f), cx.a(260.0f));
        this.f85833n = ofInt;
        ofInt.setInterpolator(new DecelerateInterpolator());
        this.f85833n.setDuration(160L);
        this.f85823d.getLocationOnScreen(new int[2]);
        final int a16 = cx.a(r0[0]);
        this.f85833n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedAdFingerAnimWrap.this.J(a16, valueAnimator);
            }
        });
        this.f85833n.addListener(new a());
    }

    private void I() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, cx.a(11.0f));
        this.f85832m = ofInt;
        ofInt.setInterpolator(new DecelerateInterpolator());
        this.f85832m.setDuration(400L);
        this.f85832m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedAdFingerAnimWrap.this.K(valueAnimator);
            }
        });
        this.f85832m.addListener(new ak() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdFingerAnimWrap.3
            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSAdFingerStateChangeEvent("state2"));
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdFingerAnimWrap.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSFeedAdFingerAnimWrap.this.f85831l.resumeApng();
                    }
                }, 500L);
                QFSFeedAdFingerAnimWrap.this.f85841v = null;
            }

            @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                QFSFeedAdFingerAnimWrap.this.A = false;
                if (!QFSFeedAdFingerAnimWrap.this.f85844y) {
                    return;
                }
                QFSFeedAdFingerAnimWrap.this.f85824e.setImageDrawable(QFSFeedAdFingerAnimWrap.this.f85831l);
                QFSFeedAdFingerAnimWrap.this.f85831l.resetApng();
                QFSFeedAdFingerAnimWrap.this.f85831l.pauseApng();
                Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdFingerAnimWrap.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSFeedAdFingerAnimWrap.this.f85833n.start();
                    }
                };
                QFSFeedAdFingerAnimWrap.this.f85836q.add(QFSFeedAdFingerAnimWrap.this.f85833n);
                QFSFeedAdFingerAnimWrap.this.f85841v = runnable;
                RFWThreadManager.getUIHandler().postDelayed(runnable, QFSFeedAdFingerAnimWrap.this.f85838s);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(int i3, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f85822c.getLayoutParams();
        layoutParams.width = intValue;
        this.f85822c.setLayoutParams(layoutParams);
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f16 = i3 * animatedFraction;
        this.f85825f.setAlpha(1.0f - animatedFraction);
        this.f85823d.setAlpha(animatedFraction);
        if (cx.a(16.0f) < f16) {
            this.f85825f.setX(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f85820a.getLayoutParams();
        layoutParams.bottomMargin = intValue;
        this.f85820a.setLayoutParams(layoutParams);
        float animatedFraction = valueAnimator.getAnimatedFraction();
        if (animatedFraction < 0.7f) {
            return;
        }
        ImageView imageView = this.f85824e;
        if (imageView != null && imageView.getVisibility() == 8) {
            this.f85824e.setVisibility(0);
        }
        this.f85821b.setVisibility(0);
        this.f85821b.setAlpha((animatedFraction - 0.7f) / 0.3f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f85832m.start();
    }

    private void M() {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setUseCache(true);
        this.f85831l = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("QFSFeedAdFingerAnimWrap", "https://business-ad.cdn-go.cn/cdn-website/latest/public/ad/qfs_ad_finger.png", apngOptions);
    }

    private void R() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f85821b.getLayoutParams();
        layoutParams.leftMargin = cx.a(12.0f);
        this.f85821b.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f85820a.getLayoutParams();
        layoutParams2.bottomMargin = 0;
        layoutParams2.leftMargin = cx.a(12.0f);
        this.f85820a.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f85822c.getLayoutParams();
        layoutParams3.width = cx.a(32.0f);
        this.f85822c.setLayoutParams(layoutParams3);
    }

    private void S() {
        this.f85828i.setVisibility(0);
        this.f85830k.setVisibility(0);
        this.f85829j.setVisibility(0);
        this.f85821b.setVisibility(8);
        this.f85827h.setVisibility(8);
        this.f85823d.setAlpha(0.0f);
    }

    private void Z() {
        if (!this.f85844y) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.d
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedAdFingerAnimWrap.this.L();
            }
        };
        this.f85836q.clear();
        this.f85836q.add(this.f85832m);
        this.f85841v = runnable;
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85841v);
        RFWThreadManager.getUIHandler().postDelayed(runnable, this.f85837r);
    }

    public void N() {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdFingerAnimWrap", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
        this.B = false;
        this.A = false;
        this.C = false;
        this.f85844y = true;
        this.f85840u = 0;
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85843x);
        this.f85827h.clearAnimation();
        R();
        S();
        this.f85821b.setBackground(QCircleApplication.APP.getResources().getDrawable(R.drawable.l9q));
        Z();
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n("finger", "1");
        SimpleEventBus.getInstance().dispatchEvent(new QFSAdBannerChangeEvent("state2"));
    }

    public void O() {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdFingerAnimWrap", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
        this.f85844y = false;
        this.f85821b.setVisibility(8);
        this.f85822c.setVisibility(8);
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85841v);
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85842w);
        this.f85835p.cancel();
        this.f85832m.cancel();
        this.f85833n.cancel();
        this.f85841v = null;
    }

    public void P() {
        Iterator<ValueAnimator> it = this.f85836q.iterator();
        while (it.hasNext()) {
            ValueAnimator next = it.next();
            if (next.isRunning()) {
                next.pause();
                return;
            }
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85841v);
    }

    public void Q() {
        Iterator<ValueAnimator> it = this.f85836q.iterator();
        while (it.hasNext()) {
            ValueAnimator next = it.next();
            if (next.isPaused()) {
                next.resume();
                return;
            }
        }
        RFWThreadManager.getUIHandler().postDelayed(this.f85841v, 0L);
    }

    public void T(boolean z16) {
        this.f85845z = z16;
    }

    public void U(long j3) {
        this.f85837r = j3 * 1000;
    }

    public void V(long j3) {
        this.f85839t = j3 * 1000;
    }

    public void W(long j3) {
        this.f85838s = j3 * 1000;
    }

    public void X(boolean z16) {
        this.A = z16;
    }

    public void Y() {
        if (this.f85845z && this.A) {
            RFWThreadManager.getUIHandler().postDelayed(this.f85843x, 0L);
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
            SimpleEventBus.getInstance().dispatchEvent(new QFSAdFingerStateChangeEvent("state2"));
            RFWThreadManager.getUIHandler().postDelayed(QFSFeedAdFingerAnimWrap.this.f85842w, 660L);
            QFSFeedAdFingerAnimWrap.this.A = true;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSFeedAdFingerAnimWrap.this.f85824e.setVisibility(8);
            QFSFeedAdFingerAnimWrap.this.f85828i.setVisibility(8);
            QFSFeedAdFingerAnimWrap.this.f85830k.setVisibility(8);
            QFSFeedAdFingerAnimWrap.this.f85829j.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) QFSFeedAdFingerAnimWrap.this.f85822c.getLayoutParams();
            layoutParams.width = cx.a(32.0f);
            QFSFeedAdFingerAnimWrap.this.f85822c.setLayoutParams(layoutParams);
            QFSFeedAdFingerAnimWrap.this.f85822c.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedAdFingerAnimWrap.this.f85840u++;
            if (QFSFeedAdFingerAnimWrap.this.f85840u > 1) {
                if (QFSFeedAdFingerAnimWrap.this.f85844y && !QFSFeedAdFingerAnimWrap.this.f85845z) {
                    RFWThreadManager.getUIHandler().postDelayed(QFSFeedAdFingerAnimWrap.this.f85843x, QFSFeedAdFingerAnimWrap.this.f85839t);
                    return;
                }
                return;
            }
            RFWThreadManager.getUIHandler().postDelayed(QFSFeedAdFingerAnimWrap.this.f85842w, 880L);
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
    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedAdFingerAnimWrap.this.f85827h.setVisibility(8);
            QFSFeedAdFingerAnimWrap.this.B = !r4.B;
            if (QFSFeedAdFingerAnimWrap.this.B) {
                RFWThreadManager.getUIHandler().postDelayed(QFSFeedAdFingerAnimWrap.this.f85843x, 750L);
            } else {
                RFWThreadManager.getUIHandler().postDelayed(QFSFeedAdFingerAnimWrap.this.f85843x, 5000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            QFSFeedAdFingerAnimWrap.this.f85826g.clearAnimation();
            QFSFeedAdFingerAnimWrap.this.C = true;
            RFWThreadManager.getUIHandler().removeCallbacks(QFSFeedAdFingerAnimWrap.this.f85842w);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
