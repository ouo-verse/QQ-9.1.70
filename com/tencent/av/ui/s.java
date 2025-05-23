package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.av.utils.ba;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    int f76592a;

    /* renamed from: b, reason: collision with root package name */
    View f76593b;

    /* renamed from: c, reason: collision with root package name */
    View f76594c;

    /* renamed from: d, reason: collision with root package name */
    View f76595d;

    /* renamed from: e, reason: collision with root package name */
    View f76596e;

    /* renamed from: f, reason: collision with root package name */
    View f76597f;

    /* renamed from: g, reason: collision with root package name */
    View f76598g;

    /* renamed from: h, reason: collision with root package name */
    QavPanel f76599h;

    /* renamed from: i, reason: collision with root package name */
    Animation f76600i;

    /* renamed from: j, reason: collision with root package name */
    Animation f76601j;

    /* renamed from: k, reason: collision with root package name */
    Animation f76602k;

    /* renamed from: l, reason: collision with root package name */
    Animation f76603l;

    /* renamed from: m, reason: collision with root package name */
    Animation f76604m;

    /* renamed from: n, reason: collision with root package name */
    Animation f76605n;

    /* renamed from: o, reason: collision with root package name */
    Animation f76606o;

    /* renamed from: p, reason: collision with root package name */
    Animation f76607p;

    /* renamed from: q, reason: collision with root package name */
    Animation f76608q;

    /* renamed from: r, reason: collision with root package name */
    Animation f76609r;

    /* renamed from: s, reason: collision with root package name */
    Animation f76610s;

    /* renamed from: t, reason: collision with root package name */
    SoftReference<Context> f76611t;

    /* renamed from: v, reason: collision with root package name */
    Animation.AnimationListener f76613v;

    /* renamed from: w, reason: collision with root package name */
    Animation.AnimationListener f76614w;

    /* renamed from: x, reason: collision with root package name */
    Animation.AnimationListener f76615x;

    /* renamed from: u, reason: collision with root package name */
    e f76612u = null;

    /* renamed from: y, reason: collision with root package name */
    boolean f76616y = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b();
    }

    public s(Context context, int i3, QavPanel qavPanel, View view, View view2, View view3, View view4, View view5, View view6) {
        if (context != null) {
            this.f76611t = new SoftReference<>(context);
        }
        this.f76592a = i3;
        this.f76599h = qavPanel;
        this.f76593b = view;
        this.f76594c = view2;
        this.f76595d = view3;
        this.f76596e = view4;
        this.f76597f = view5;
        this.f76598g = view6;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
        this.f76600i = alphaAnimation;
        alphaAnimation.setDuration(500L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 0.0f);
        this.f76601j = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.f76602k = translateAnimation;
        long j3 = 620;
        translateAnimation.setDuration(j3);
        this.f76602k.setInterpolator(decelerateInterpolator);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.f76606o = translateAnimation2;
        translateAnimation2.setDuration(j3);
        this.f76606o.setInterpolator(accelerateInterpolator);
        float f16 = -((int) (ba.getScreenHeight(context) * 0.18f));
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, f16, 1, 0.0f);
        this.f76603l = translateAnimation3;
        translateAnimation3.setDuration(j3);
        this.f76603l.setInterpolator(decelerateInterpolator);
        TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 0, f16);
        this.f76607p = translateAnimation4;
        translateAnimation4.setDuration(j3);
        this.f76607p.setInterpolator(accelerateInterpolator);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
        this.f76604m = alphaAnimation3;
        alphaAnimation3.setDuration(j3);
        AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
        this.f76608q = alphaAnimation4;
        alphaAnimation4.setDuration(j3);
        TranslateAnimation translateAnimation5 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.f76605n = translateAnimation5;
        translateAnimation5.setDuration(j3);
        this.f76605n.setInterpolator(decelerateInterpolator);
        TranslateAnimation translateAnimation6 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.f76609r = translateAnimation6;
        translateAnimation6.setDuration(j3);
        this.f76609r.setInterpolator(accelerateInterpolator);
        AlphaAnimation alphaAnimation5 = new AlphaAnimation(0.0f, 0.0f);
        this.f76610s = alphaAnimation5;
        alphaAnimation5.setDuration(j3);
        this.f76613v = new a();
        this.f76614w = new b();
        this.f76615x = new c();
    }

    public void a() {
        this.f76611t = null;
        this.f76616y = true;
        Animation animation = this.f76602k;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f76603l;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f76604m;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.f76605n;
        if (animation4 != null) {
            animation4.cancel();
        }
        Animation animation5 = this.f76606o;
        if (animation5 != null) {
            animation5.cancel();
        }
        Animation animation6 = this.f76607p;
        if (animation6 != null) {
            animation6.cancel();
        }
        Animation animation7 = this.f76608q;
        if (animation7 != null) {
            animation7.cancel();
        }
        Animation animation8 = this.f76609r;
        if (animation8 != null) {
            animation8.cancel();
        }
        Animation animation9 = this.f76610s;
        if (animation9 != null) {
            animation9.cancel();
        }
        this.f76600i = null;
        this.f76601j = null;
        this.f76602k = null;
        this.f76603l = null;
        this.f76604m = null;
        this.f76605n = null;
        this.f76606o = null;
        this.f76607p = null;
        this.f76608q = null;
        this.f76609r = null;
        this.f76610s = null;
        this.f76612u = null;
        this.f76613v = null;
        this.f76614w = null;
        this.f76615x = null;
        this.f76599h = null;
        this.f76593b = null;
        this.f76594c = null;
        this.f76595d = null;
        this.f76596e = null;
        this.f76597f = null;
        this.f76598g = null;
    }

    public void b() {
        c(null);
    }

    public void c(d dVar) {
        Animation animation;
        if (com.tencent.av.r.h0() != null && !this.f76616y && com.tencent.av.n.e().f() != null && !com.tencent.av.n.e().f().F1 && this.f76599h != null && this.f76611t != null && (animation = this.f76605n) != null && this.f76600i != null) {
            animation.setAnimationListener(this.f76613v);
            this.f76600i.setAnimationListener(this.f76614w);
            this.f76599h.startAnimation(this.f76600i);
            View view = this.f76593b;
            if (view != null) {
                view.startAnimation(this.f76601j);
            }
            View view2 = this.f76594c;
            if (view2 != null) {
                view2.startAnimation(this.f76601j);
            }
            View view3 = this.f76595d;
            if (view3 != null) {
                view3.startAnimation(this.f76601j);
            }
            View view4 = this.f76596e;
            if (view4 != null) {
                view4.startAnimation(this.f76601j);
            }
            View view5 = this.f76597f;
            if (view5 != null) {
                view5.startAnimation(this.f76601j);
            }
            View view6 = this.f76598g;
            if (view6 != null) {
                view6.startAnimation(this.f76601j);
            }
        }
    }

    public void d(e eVar) {
        QavPanel qavPanel;
        Animation animation;
        this.f76612u = eVar;
        if (com.tencent.av.r.h0() != null && !this.f76616y && com.tencent.av.n.e().f() != null && !com.tencent.av.n.e().f().G1 && (qavPanel = this.f76599h) != null && this.f76611t != null && (animation = this.f76609r) != null) {
            if (qavPanel.getVisibility() != 0) {
                animation = this.f76610s;
            }
            animation.setAnimationListener(this.f76615x);
            this.f76599h.startAnimation(animation);
            View view = this.f76593b;
            if (view != null && view.getVisibility() == 0) {
                this.f76593b.startAnimation(this.f76606o);
            }
            View view2 = this.f76594c;
            if (view2 != null && view2.getVisibility() == 0) {
                this.f76594c.startAnimation(this.f76607p);
            }
            View view3 = this.f76595d;
            if (view3 != null && view3.getVisibility() == 0) {
                this.f76595d.startAnimation(this.f76607p);
            }
            View view4 = this.f76596e;
            if (view4 != null && view4.getVisibility() == 0) {
                this.f76596e.startAnimation(this.f76608q);
            }
            View view5 = this.f76597f;
            if (view5 != null && view5.getVisibility() == 0) {
                this.f76597f.startAnimation(this.f76608q);
            }
            View view6 = this.f76598g;
            if (view6 != null && view6.getVisibility() == 0) {
                this.f76598g.startAnimation(this.f76608q);
            }
            com.tencent.av.n.e().f().G1 = true;
            return;
        }
        if (com.tencent.av.r.h0() != null && !this.f76616y && com.tencent.av.n.e().f() != null) {
            com.tencent.av.n.e().f().F1 = false;
            com.tencent.av.n.e().f().G1 = false;
        }
        e eVar2 = this.f76612u;
        if (eVar2 != null) {
            eVar2.b();
            this.f76612u.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationEnd");
            }
            try {
                s.this.getClass();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationEnd Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("QavInOutAnimation", 2, "InAnimation onAnimationStart");
            }
            try {
                s.this.getClass();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavInOutAnimation", 2, "QavInAnimationListener onAnimationStart Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QavPanel qavPanel = s.this.f76599h;
            if (qavPanel != null) {
                qavPanel.clearAnimation();
                s sVar = s.this;
                sVar.f76599h.startAnimation(sVar.f76605n);
            }
            View view = s.this.f76593b;
            if (view != null) {
                view.clearAnimation();
                if (s.this.f76593b.getVisibility() == 0) {
                    s sVar2 = s.this;
                    sVar2.f76593b.startAnimation(sVar2.f76602k);
                }
            }
            View view2 = s.this.f76594c;
            if (view2 != null) {
                view2.clearAnimation();
                if (s.this.f76594c.getVisibility() == 0) {
                    s sVar3 = s.this;
                    sVar3.f76594c.startAnimation(sVar3.f76603l);
                }
            }
            View view3 = s.this.f76595d;
            if (view3 != null) {
                view3.clearAnimation();
                if (s.this.f76595d.getVisibility() == 0) {
                    s sVar4 = s.this;
                    sVar4.f76595d.startAnimation(sVar4.f76603l);
                }
            }
            View view4 = s.this.f76596e;
            if (view4 != null) {
                view4.clearAnimation();
                if (s.this.f76596e.getVisibility() == 0) {
                    s sVar5 = s.this;
                    sVar5.f76596e.startAnimation(sVar5.f76604m);
                }
            }
            View view5 = s.this.f76597f;
            if (view5 != null) {
                view5.clearAnimation();
                if (s.this.f76597f.getVisibility() == 0) {
                    s sVar6 = s.this;
                    sVar6.f76597f.startAnimation(sVar6.f76604m);
                }
            }
            View view6 = s.this.f76598g;
            if (view6 != null) {
                view6.clearAnimation();
                if (s.this.f76598g.getVisibility() == 0) {
                    s sVar7 = s.this;
                    sVar7.f76598g.startAnimation(sVar7.f76604m);
                }
            }
            if (com.tencent.av.r.h0() != null && !s.this.f76616y && com.tencent.av.n.e().f() != null) {
                com.tencent.av.n.e().f().F1 = true;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationEnd");
            }
            try {
                if (com.tencent.av.r.h0() != null && !s.this.f76616y && com.tencent.av.n.e().f() != null) {
                    com.tencent.av.n.e().f().F1 = false;
                    com.tencent.av.n.e().f().G1 = false;
                }
                QavPanel qavPanel = s.this.f76599h;
                if (qavPanel != null) {
                    qavPanel.setVisibility(4);
                }
                View view = s.this.f76593b;
                if (view != null) {
                    view.setVisibility(4);
                }
                View view2 = s.this.f76594c;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                View view3 = s.this.f76595d;
                if (view3 != null) {
                    view3.setVisibility(4);
                }
                View view4 = s.this.f76596e;
                if (view4 != null) {
                    view4.setVisibility(4);
                }
                View view5 = s.this.f76597f;
                if (view5 != null) {
                    view5.setVisibility(4);
                }
                View view6 = s.this.f76598g;
                if (view6 != null) {
                    view6.setVisibility(4);
                }
                e eVar = s.this.f76612u;
                if (eVar != null) {
                    eVar.a();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationEnd Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("QavInOutAnimation", 2, "OutAnimation onAnimationStart");
            }
            try {
                e eVar = s.this.f76612u;
                if (eVar != null) {
                    eVar.b();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavInOutAnimation", 2, "QavOutAnimationListener onAnimationStart Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
