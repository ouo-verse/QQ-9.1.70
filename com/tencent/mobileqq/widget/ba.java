package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ba extends Animation {
    private final boolean C;
    private Camera D;

    /* renamed from: d, reason: collision with root package name */
    private final float f316696d;

    /* renamed from: e, reason: collision with root package name */
    private final float f316697e;

    /* renamed from: f, reason: collision with root package name */
    private float f316698f;

    /* renamed from: h, reason: collision with root package name */
    private float f316699h;

    /* renamed from: i, reason: collision with root package name */
    private int f316700i;

    /* renamed from: m, reason: collision with root package name */
    private final float f316701m;

    public ba(float f16, float f17, float f18, float f19, float f26, boolean z16) {
        this(f16, f17, 0, f18, f19, f26, z16);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        float f17 = this.f316696d;
        float f18 = f17 + ((this.f316697e - f17) * f16);
        float f19 = this.f316698f;
        float f26 = this.f316699h;
        Camera camera2 = this.D;
        Matrix matrix = transformation.getMatrix();
        camera2.save();
        if (this.C) {
            camera2.translate(0.0f, 0.0f, this.f316701m * f16);
        } else {
            camera2.translate(0.0f, 0.0f, this.f316701m * (1.0f - f16));
        }
        camera2.rotateY(f18);
        camera2.getMatrix(matrix);
        camera2.restore();
        matrix.preTranslate(-f19, -f26);
        matrix.postTranslate(f19, f26);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        super.initialize(i3, i16, i17, i18);
        this.D = new Camera();
        if (this.f316700i == 1) {
            this.f316698f = i3 * this.f316698f;
            this.f316699h = i16 * this.f316699h;
        }
    }

    public ba(float f16, float f17, int i3, float f18, float f19, float f26, boolean z16) {
        this.f316696d = f16;
        this.f316697e = f17;
        this.f316698f = f18;
        this.f316699h = f19;
        this.f316701m = f26;
        this.C = z16;
        this.f316700i = i3;
    }
}
