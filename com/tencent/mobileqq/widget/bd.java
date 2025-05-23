package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: P */
/* loaded from: classes20.dex */
class bd extends Animation {

    /* renamed from: d, reason: collision with root package name */
    private Camera f316709d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f316710e;

    /* renamed from: f, reason: collision with root package name */
    private int f316711f;

    /* renamed from: h, reason: collision with root package name */
    private int f316712h;

    /* renamed from: i, reason: collision with root package name */
    private View f316713i;

    public bd(View view) {
        this.f316713i = view;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        super.applyTransformation(f16, transformation);
        this.f316709d.save();
        this.f316709d.rotateX(f16 * 90.0f);
        this.f316709d.getMatrix(this.f316710e);
        this.f316709d.restore();
        this.f316710e.preTranslate((-this.f316711f) / 2, (-this.f316712h) / 2);
        this.f316710e.postTranslate(this.f316711f / 2, this.f316712h / 2);
        transformation.getMatrix().postConcat(this.f316710e);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        super.initialize(i3, i16, i17, i18);
        this.f316709d = new Camera();
        this.f316710e = new Matrix();
        this.f316711f = i3;
        this.f316712h = i16;
    }
}
