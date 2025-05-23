package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: P */
/* loaded from: classes20.dex */
class bc extends Animation {

    /* renamed from: d, reason: collision with root package name */
    private Camera f316704d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f316705e;

    /* renamed from: f, reason: collision with root package name */
    private int f316706f;

    /* renamed from: h, reason: collision with root package name */
    private int f316707h;

    /* renamed from: i, reason: collision with root package name */
    private View f316708i;

    public bc(View view) {
        this.f316708i = view;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        super.applyTransformation(f16, transformation);
        this.f316704d.save();
        this.f316704d.rotateX(90.0f - (f16 * 90.0f));
        this.f316704d.getMatrix(this.f316705e);
        this.f316704d.restore();
        this.f316705e.preTranslate((-this.f316706f) / 2, (-this.f316707h) / 2);
        this.f316705e.postTranslate(this.f316706f / 2, this.f316707h / 2);
        transformation.getMatrix().postConcat(this.f316705e);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        super.initialize(i3, i16, i17, i18);
        this.f316704d = new Camera();
        this.f316705e = new Matrix();
        this.f316706f = i3;
        this.f316707h = i16;
    }
}
