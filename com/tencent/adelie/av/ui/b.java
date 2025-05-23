package com.tencent.adelie.av.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.av.utils.ba;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private View f61531a;

    /* renamed from: b, reason: collision with root package name */
    private View f61532b;

    /* renamed from: c, reason: collision with root package name */
    private View f61533c;

    /* renamed from: d, reason: collision with root package name */
    private View f61534d;

    /* renamed from: e, reason: collision with root package name */
    private View f61535e;

    /* renamed from: f, reason: collision with root package name */
    private View f61536f;

    /* renamed from: g, reason: collision with root package name */
    private AdelieAVPanel f61537g;

    /* renamed from: h, reason: collision with root package name */
    private Animation f61538h;

    /* renamed from: i, reason: collision with root package name */
    private Animation f61539i;

    /* renamed from: j, reason: collision with root package name */
    private Animation f61540j;

    /* renamed from: k, reason: collision with root package name */
    private Animation f61541k;

    /* renamed from: l, reason: collision with root package name */
    private Animation f61542l;

    /* renamed from: m, reason: collision with root package name */
    private Animation f61543m;

    /* renamed from: n, reason: collision with root package name */
    private Animation f61544n;

    /* renamed from: o, reason: collision with root package name */
    private Animation f61545o;

    /* renamed from: p, reason: collision with root package name */
    private Animation f61546p;

    /* renamed from: q, reason: collision with root package name */
    private Animation f61547q;

    /* renamed from: r, reason: collision with root package name */
    private Animation f61548r;

    /* renamed from: s, reason: collision with root package name */
    private d f61549s = null;

    /* renamed from: t, reason: collision with root package name */
    private e f61550t = null;

    /* renamed from: u, reason: collision with root package name */
    private Animation.AnimationListener f61551u;

    /* renamed from: v, reason: collision with root package name */
    private Animation.AnimationListener f61552v;

    /* renamed from: w, reason: collision with root package name */
    private Animation.AnimationListener f61553w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f61554x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f61555y;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface e {
        void a();

        void b();
    }

    public b(Context context, AdelieAVPanel adelieAVPanel, View view, View view2, View view3, View view4, View view5, View view6) {
        this.f61537g = adelieAVPanel;
        this.f61531a = view;
        this.f61532b = view2;
        this.f61533c = view3;
        this.f61534d = view4;
        this.f61535e = view5;
        this.f61536f = view6;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
        this.f61538h = alphaAnimation;
        long j3 = 200;
        alphaAnimation.setDuration(j3);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 0.0f);
        this.f61539i = alphaAnimation2;
        alphaAnimation2.setDuration(j3);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.f61540j = translateAnimation;
        long j16 = com.tencent.luggage.wxa.fe.a.CTRL_INDEX;
        translateAnimation.setDuration(j16);
        this.f61540j.setInterpolator(decelerateInterpolator);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.f61544n = translateAnimation2;
        translateAnimation2.setDuration(j16);
        this.f61544n.setInterpolator(accelerateInterpolator);
        float f16 = -((int) (ba.getScreenHeight(context) * 0.18f));
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, f16, 1, 0.0f);
        this.f61541k = translateAnimation3;
        translateAnimation3.setDuration(j16);
        this.f61541k.setInterpolator(decelerateInterpolator);
        TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 0, f16);
        this.f61545o = translateAnimation4;
        translateAnimation4.setDuration(j16);
        this.f61545o.setInterpolator(accelerateInterpolator);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
        this.f61542l = alphaAnimation3;
        alphaAnimation3.setDuration(j16);
        AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
        this.f61546p = alphaAnimation4;
        alphaAnimation4.setDuration(j16);
        TranslateAnimation translateAnimation5 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.f61543m = translateAnimation5;
        translateAnimation5.setDuration(j16);
        this.f61543m.setInterpolator(decelerateInterpolator);
        TranslateAnimation translateAnimation6 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.f61547q = translateAnimation6;
        translateAnimation6.setDuration(j16);
        this.f61547q.setInterpolator(accelerateInterpolator);
        AlphaAnimation alphaAnimation5 = new AlphaAnimation(0.0f, 0.0f);
        this.f61548r = alphaAnimation5;
        alphaAnimation5.setDuration(j16);
        this.f61551u = new a();
        this.f61552v = new AnimationAnimationListenerC0526b();
        this.f61553w = new c();
    }

    public void p() {
        Animation animation = this.f61540j;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f61541k;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f61542l;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.f61543m;
        if (animation4 != null) {
            animation4.setAnimationListener(null);
            this.f61543m.cancel();
        }
        Animation animation5 = this.f61544n;
        if (animation5 != null) {
            animation5.cancel();
        }
        Animation animation6 = this.f61545o;
        if (animation6 != null) {
            animation6.cancel();
        }
        Animation animation7 = this.f61546p;
        if (animation7 != null) {
            animation7.cancel();
        }
        Animation animation8 = this.f61547q;
        if (animation8 != null) {
            animation8.cancel();
            this.f61547q.setAnimationListener(null);
        }
        Animation animation9 = this.f61548r;
        if (animation9 != null) {
            animation9.cancel();
            this.f61548r.setAnimationListener(null);
        }
        Animation animation10 = this.f61538h;
        if (animation10 != null) {
            animation10.cancel();
            this.f61538h.setAnimationListener(null);
        }
        this.f61538h = null;
        this.f61539i = null;
        this.f61540j = null;
        this.f61541k = null;
        this.f61542l = null;
        this.f61543m = null;
        this.f61544n = null;
        this.f61545o = null;
        this.f61546p = null;
        this.f61547q = null;
        this.f61548r = null;
        this.f61549s = null;
        this.f61550t = null;
        this.f61551u = null;
        this.f61552v = null;
        this.f61553w = null;
        this.f61537g = null;
        this.f61531a = null;
        this.f61532b = null;
        this.f61533c = null;
        this.f61534d = null;
        this.f61535e = null;
        this.f61536f = null;
    }

    public void q(d dVar) {
        Animation animation;
        this.f61549s = dVar;
        if (this.f61554x || this.f61537g == null || (animation = this.f61543m) == null || this.f61538h == null) {
            if (dVar != null) {
                dVar.b();
                this.f61549s.a();
                return;
            }
            return;
        }
        animation.setAnimationListener(this.f61551u);
        this.f61538h.setAnimationListener(this.f61552v);
        this.f61537g.startAnimation(this.f61538h);
        View view = this.f61531a;
        if (view != null) {
            view.startAnimation(this.f61539i);
        }
        View view2 = this.f61532b;
        if (view2 != null) {
            view2.startAnimation(this.f61539i);
        }
        View view3 = this.f61533c;
        if (view3 != null) {
            view3.startAnimation(this.f61539i);
        }
        View view4 = this.f61534d;
        if (view4 != null) {
            view4.startAnimation(this.f61539i);
        }
        View view5 = this.f61535e;
        if (view5 != null) {
            view5.startAnimation(this.f61539i);
        }
        View view6 = this.f61536f;
        if (view6 != null) {
            view6.startAnimation(this.f61539i);
        }
    }

    public void r(e eVar) {
        AdelieAVPanel adelieAVPanel;
        Animation animation;
        this.f61550t = eVar;
        if (!this.f61555y && (adelieAVPanel = this.f61537g) != null && (animation = this.f61547q) != null) {
            if (adelieAVPanel.getVisibility() != 0) {
                animation = this.f61548r;
            }
            animation.setAnimationListener(this.f61553w);
            this.f61537g.startAnimation(animation);
            View view = this.f61531a;
            if (view != null && view.getVisibility() == 0) {
                this.f61531a.startAnimation(this.f61544n);
            }
            View view2 = this.f61532b;
            if (view2 != null && view2.getVisibility() == 0) {
                this.f61532b.startAnimation(this.f61545o);
            }
            View view3 = this.f61533c;
            if (view3 != null && view3.getVisibility() == 0) {
                this.f61533c.startAnimation(this.f61545o);
            }
            View view4 = this.f61534d;
            if (view4 != null && view4.getVisibility() == 0) {
                this.f61534d.startAnimation(this.f61546p);
            }
            View view5 = this.f61535e;
            if (view5 != null && view5.getVisibility() == 0) {
                this.f61535e.startAnimation(this.f61546p);
            }
            View view6 = this.f61536f;
            if (view6 != null && view6.getVisibility() == 0) {
                this.f61536f.startAnimation(this.f61546p);
            }
            this.f61555y = true;
            return;
        }
        this.f61554x = false;
        this.f61555y = false;
        if (eVar != null) {
            eVar.b();
            this.f61550t.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieAVInOutAnimation", 2, "InAnimation onAnimationEnd");
            }
            try {
                if (b.this.f61549s != null) {
                    b.this.f61549s.a();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AdelieAVInOutAnimation", 2, "QavInAnimationListener onAnimationEnd Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieAVInOutAnimation", 2, "InAnimation onAnimationStart");
            }
            try {
                if (b.this.f61549s != null) {
                    b.this.f61549s.b();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AdelieAVInOutAnimation", 2, "QavInAnimationListener onAnimationStart Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.adelie.av.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    class AnimationAnimationListenerC0526b implements Animation.AnimationListener {
        AnimationAnimationListenerC0526b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (b.this.f61537g != null) {
                b.this.f61537g.clearAnimation();
                b.this.f61537g.startAnimation(b.this.f61543m);
            }
            if (b.this.f61531a != null) {
                b.this.f61531a.clearAnimation();
                if (b.this.f61531a.getVisibility() == 0) {
                    b.this.f61531a.startAnimation(b.this.f61540j);
                }
            }
            if (b.this.f61532b != null) {
                b.this.f61532b.clearAnimation();
                if (b.this.f61532b.getVisibility() == 0) {
                    b.this.f61532b.startAnimation(b.this.f61541k);
                }
            }
            if (b.this.f61533c != null) {
                b.this.f61533c.clearAnimation();
                if (b.this.f61533c.getVisibility() == 0) {
                    b.this.f61533c.startAnimation(b.this.f61541k);
                }
            }
            if (b.this.f61534d != null) {
                b.this.f61534d.clearAnimation();
                if (b.this.f61534d.getVisibility() == 0) {
                    b.this.f61534d.startAnimation(b.this.f61542l);
                }
            }
            if (b.this.f61535e != null) {
                b.this.f61535e.clearAnimation();
                if (b.this.f61535e.getVisibility() == 0) {
                    b.this.f61535e.startAnimation(b.this.f61542l);
                }
            }
            if (b.this.f61536f != null) {
                b.this.f61536f.clearAnimation();
                if (b.this.f61536f.getVisibility() == 0) {
                    b.this.f61536f.startAnimation(b.this.f61542l);
                }
            }
            b.this.f61554x = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieAVInOutAnimation", 2, "OutAnimation onAnimationEnd");
            }
            try {
                b.this.f61554x = false;
                b.this.f61555y = false;
                if (b.this.f61537g != null) {
                    b.this.f61537g.setVisibility(4);
                }
                if (b.this.f61531a != null) {
                    b.this.f61531a.setVisibility(4);
                }
                if (b.this.f61532b != null) {
                    b.this.f61532b.setVisibility(4);
                }
                if (b.this.f61533c != null) {
                    b.this.f61533c.setVisibility(4);
                }
                if (b.this.f61534d != null) {
                    b.this.f61534d.setVisibility(4);
                }
                if (b.this.f61535e != null) {
                    b.this.f61535e.setVisibility(4);
                }
                if (b.this.f61536f != null) {
                    b.this.f61536f.setVisibility(4);
                }
                if (b.this.f61550t != null) {
                    b.this.f61550t.a();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AdelieAVInOutAnimation", 2, "QavOutAnimationListener onAnimationEnd Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieAVInOutAnimation", 2, "OutAnimation onAnimationStart");
            }
            try {
                if (b.this.f61550t != null) {
                    b.this.f61550t.b();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AdelieAVInOutAnimation", 2, "QavOutAnimationListener onAnimationStart Exception :" + e16);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
