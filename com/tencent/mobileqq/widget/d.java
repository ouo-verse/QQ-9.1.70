package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: P */
/* loaded from: classes20.dex */
class d extends Animation {

    /* renamed from: d, reason: collision with root package name */
    private Camera f316857d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f316858e;

    /* renamed from: f, reason: collision with root package name */
    private int f316859f;

    /* renamed from: h, reason: collision with root package name */
    private int f316860h;

    /* renamed from: i, reason: collision with root package name */
    private View f316861i;

    public d(View view) {
        this.f316861i = view;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        super.applyTransformation(f16, transformation);
        float f17 = f16 * 90.0f;
        this.f316857d.save();
        this.f316857d.rotateX(f17);
        this.f316857d.getMatrix(this.f316858e);
        this.f316857d.restore();
        View view = this.f316861i;
        if (view != null) {
            view.setAlpha(1.0f - (f17 / 90.0f));
            this.f316861i.invalidate();
        }
        this.f316858e.preTranslate(-this.f316859f, -this.f316860h);
        this.f316858e.postTranslate(this.f316859f, this.f316860h);
        transformation.getMatrix().postConcat(this.f316858e);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        super.initialize(i3, i16, i17, i18);
        this.f316857d = new Camera();
        this.f316858e = new Matrix();
        this.f316859f = i3;
        this.f316860h = i16;
    }
}
