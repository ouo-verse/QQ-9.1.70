package com.tencent.tav.coremedia;

import android.graphics.Matrix;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Transform {
    public float degrees;
    public final float scaleX;
    public final float scaleY;
    public final float translateX;
    public final float translateY;

    public Transform(float f16, float f17, float f18, float f19, float f26) {
        this.scaleX = f16;
        this.scaleY = f17;
        this.translateX = f18;
        this.translateY = f19;
        this.degrees = f26;
    }

    public static Transform instanceFromScale(float f16, float f17) {
        return new Transform(f16, f17, 0.0f, 0.0f, 0.0f);
    }

    public static Transform instanceFromTranslate(float f16, float f17) {
        return new Transform(1.0f, 1.0f, f16, f17, 0.0f);
    }

    public Matrix toMatrix() {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.degrees);
        matrix.postScale(this.scaleX, this.scaleY);
        matrix.postTranslate(this.translateX, this.translateY);
        return matrix;
    }
}
