package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.luggage.wxa.c8.c;
import java.util.ArrayList;
import java.util.List;
import jf0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final ViewAnimator f97049a;

    /* renamed from: b, reason: collision with root package name */
    private final View[] f97050b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f97052d;

    /* renamed from: c, reason: collision with root package name */
    private final List<Animator> f97051c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f97053e = false;

    /* renamed from: f, reason: collision with root package name */
    private Interpolator f97054f = null;

    public a(ViewAnimator viewAnimator, View... viewArr) {
        this.f97049a = viewAnimator;
        this.f97050b = viewArr;
    }

    public a a(float... fArr) {
        return j(c.f123400v, fArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Animator> b() {
        return this.f97051c;
    }

    public a c(long j3) {
        this.f97049a.l(j3);
        return this;
    }

    public Interpolator d() {
        return this.f97054f;
    }

    protected float[] e(float... fArr) {
        if (!this.f97053e) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr2[i3] = l(fArr[i3]);
        }
        return fArr2;
    }

    public View f() {
        return this.f97050b[0];
    }

    public boolean g() {
        return this.f97052d;
    }

    public a h(jf0.c cVar) {
        this.f97049a.m(cVar);
        return this;
    }

    public a i(d dVar) {
        this.f97049a.n(dVar);
        return this;
    }

    public a j(String str, float... fArr) {
        for (View view : this.f97050b) {
            this.f97051c.add(ObjectAnimator.ofFloat(view, str, e(fArr)));
        }
        return this;
    }

    public ViewAnimator k() {
        this.f97049a.o();
        return this.f97049a;
    }

    protected float l(float f16) {
        return f16 * this.f97050b[0].getContext().getResources().getDisplayMetrics().density;
    }

    public a m(float... fArr) {
        return j("translationY", fArr);
    }
}
