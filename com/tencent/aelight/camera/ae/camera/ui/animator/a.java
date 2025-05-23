package com.tencent.aelight.camera.ae.camera.ui.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import bq.d;
import bq.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ViewAnimator f62461a;

    /* renamed from: b, reason: collision with root package name */
    private final View[] f62462b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f62464d;

    /* renamed from: c, reason: collision with root package name */
    private final List<Animator> f62463c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f62465e = false;

    /* renamed from: f, reason: collision with root package name */
    private Interpolator f62466f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.animator.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0537a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f62467d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f62468e;

        C0537a(e eVar, View view) {
            this.f62467d = eVar;
            this.f62468e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f62467d.a(this.f62468e, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements e {
        b() {
        }

        @Override // bq.e
        public void a(View view, float f16) {
            view.getLayoutParams().height = (int) f16;
            view.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements e {
        c() {
        }

        @Override // bq.e
        public void a(View view, float f16) {
            view.getLayoutParams().width = (int) f16;
            view.requestLayout();
        }
    }

    public a(ViewAnimator viewAnimator, View... viewArr) {
        this.f62461a = viewAnimator;
        this.f62462b = viewArr;
    }

    public ViewAnimator a() {
        return this.f62461a.m(new AccelerateInterpolator());
    }

    protected a b(Animator animator) {
        this.f62463c.add(animator);
        return this;
    }

    public a c(float... fArr) {
        return q(com.tencent.luggage.wxa.c8.c.f123400v, fArr);
    }

    public a d(View... viewArr) {
        return this.f62461a.i(viewArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Animator> e() {
        return this.f62463c;
    }

    public a f(e eVar, float... fArr) {
        for (View view : this.f62462b) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(j(fArr));
            if (eVar != null) {
                ofFloat.addUpdateListener(new C0537a(eVar, view));
            }
            b(ofFloat);
        }
        return this;
    }

    public ViewAnimator g(float f16) {
        return this.f62461a.m(new DecelerateInterpolator(f16));
    }

    public a h(long j3) {
        this.f62461a.l(j3);
        return this;
    }

    public Interpolator i() {
        return this.f62466f;
    }

    protected float[] j(float... fArr) {
        if (!this.f62465e) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr2[i3] = u(fArr[i3]);
        }
        return fArr2;
    }

    public View k() {
        return this.f62462b[0];
    }

    public a l(float... fArr) {
        return f(new b(), fArr);
    }

    public a m(Interpolator interpolator) {
        this.f62461a.m(interpolator);
        return this;
    }

    public boolean n() {
        return this.f62464d;
    }

    public a o(bq.c cVar) {
        this.f62461a.n(cVar);
        return this;
    }

    public a p(d dVar) {
        this.f62461a.o(dVar);
        return this;
    }

    public a q(String str, float... fArr) {
        for (View view : this.f62462b) {
            this.f62463c.add(ObjectAnimator.ofFloat(view, str, j(fArr)));
        }
        return this;
    }

    public a r(int i3) {
        this.f62461a.p(i3);
        return this;
    }

    public a s(int i3) {
        this.f62461a.q(i3);
        return this;
    }

    public ViewAnimator t() {
        this.f62461a.r();
        return this.f62461a;
    }

    protected float u(float f16) {
        return f16 * this.f62462b[0].getContext().getResources().getDisplayMetrics().density;
    }

    public a v(float... fArr) {
        return q("translationX", fArr);
    }

    public a w(float... fArr) {
        return q("translationY", fArr);
    }

    public a x(float... fArr) {
        return f(new c(), fArr);
    }
}
