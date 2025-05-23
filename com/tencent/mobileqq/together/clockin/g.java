package com.tencent.mobileqq.together.clockin;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends Animation {
    private Camera C;
    private float D;

    /* renamed from: d, reason: collision with root package name */
    private float f293375d;

    /* renamed from: e, reason: collision with root package name */
    private float f293376e;

    /* renamed from: f, reason: collision with root package name */
    private float f293377f;

    /* renamed from: h, reason: collision with root package name */
    private float f293378h;

    /* renamed from: i, reason: collision with root package name */
    private float f293379i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f293380m;

    public g(float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
        this.f293375d = f17;
        this.f293376e = f18;
        this.f293377f = f19;
        this.f293378h = f26;
        this.f293379i = f27;
        this.f293380m = z16;
        this.D = f16;
    }

    public void a(float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
        this.f293375d = f17;
        this.f293376e = f18;
        this.f293377f = f19;
        this.f293378h = f26;
        this.f293379i = f27;
        this.f293380m = z16;
        this.D = f16;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        float f17 = this.f293375d;
        float f18 = f17 + ((this.f293376e - f17) * f16);
        float f19 = this.f293377f;
        float f26 = this.f293378h;
        Camera camera2 = this.C;
        Matrix matrix = transformation.getMatrix();
        camera2.save();
        if (this.f293380m) {
            camera2.translate(0.0f, 0.0f, this.f293379i * f16);
        } else {
            camera2.translate(0.0f, 0.0f, this.f293379i * (1.0f - f16));
        }
        camera2.rotateY(f18);
        camera2.getMatrix(matrix);
        camera2.restore();
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f27 = fArr[6];
        float f28 = this.D;
        fArr[6] = f27 / f28;
        fArr[7] = fArr[7] / f28;
        matrix.setValues(fArr);
        matrix.preTranslate(-f19, -f26);
        matrix.postTranslate(f19, f26);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i3, int i16, int i17, int i18) {
        super.initialize(i3, i16, i17, i18);
        this.C = new Camera();
    }

    public g() {
        this.f293375d = 0.0f;
        this.f293376e = 0.0f;
        this.f293377f = 0.0f;
        this.f293378h = 0.0f;
        this.f293379i = 0.0f;
        this.D = 0.0f;
        this.f293380m = false;
    }
}
