package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: P */
/* loaded from: classes20.dex */
class c extends Animation {

    /* renamed from: d, reason: collision with root package name */
    private Camera f316811d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f316812e;

    /* renamed from: f, reason: collision with root package name */
    private int f316813f;

    /* renamed from: h, reason: collision with root package name */
    private int f316814h;

    /* renamed from: i, reason: collision with root package name */
    private View f316815i;

    public c(View view) {
        this.f316815i = view;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        super.applyTransformation(f16, transformation);
        float f17 = 90.0f - (f16 * 90.0f);
        this.f316811d.save();
        this.f316811d.rotateX(f17);
        this.f316811d.getMatrix(this.f316812e);
        this.f316811d.restore();
        View view = this.f316815i;
        if (view != null) {
            view.setAlpha(1.0f - (f17 / 90.0f));
            this.f316815i.invalidate();
        }
        this.f316812e.preTranslate((-this.f316813f) / 2, 0.0f);
        this.f316812e.postTranslate(this.f316813f / 2, 0.0f);
        transformation.getMatrix().postConcat(this.f316812e);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        super.initialize(i3, i16, i17, i18);
        this.f316811d = new Camera();
        this.f316812e = new Matrix();
        this.f316813f = i3;
        this.f316814h = i16;
    }
}
