package com.tencent.mobileqq.shortvideo.util;

import android.opengl.Matrix;
import java.util.Arrays;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GlMatricUtil {
    private float[] mMatrixCamera = new float[16];
    private float[] mMatrixProjection = new float[16];
    private float[] mMatrixCurrent = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private Stack<float[]> mStack = new Stack<>();

    public void clearStack() {
        this.mStack.clear();
    }

    public void frustum(float f16, float f17, float f18, float f19, float f26, float f27) {
        Matrix.frustumM(this.mMatrixProjection, 0, f16, f17, f18, f19, f26, f27);
    }

    public float[] getFinalMatrix() {
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, 0, this.mMatrixCamera, 0, this.mMatrixCurrent, 0);
        Matrix.multiplyMM(fArr, 0, this.mMatrixProjection, 0, fArr, 0);
        return fArr;
    }

    public void ortho(float f16, float f17, float f18, float f19, float f26, float f27) {
        Matrix.orthoM(this.mMatrixProjection, 0, f16, f17, f18, f19, f26, f27);
    }

    public void popMatrix() {
        this.mMatrixCurrent = this.mStack.pop();
    }

    public void pushMatrix() {
        this.mStack.push(Arrays.copyOf(this.mMatrixCurrent, 16));
    }

    public void rotate(float f16, float f17, float f18, float f19) {
        Matrix.rotateM(this.mMatrixCurrent, 0, f16, f17, f18, f19);
    }

    public void scale(float f16, float f17, float f18) {
        Matrix.scaleM(this.mMatrixCurrent, 0, f16, f17, f18);
    }

    public void setCamera(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36) {
        Matrix.setLookAtM(this.mMatrixCamera, 0, f16, f17, f18, f19, f26, f27, f28, f29, f36);
    }

    public void translate(float f16, float f17, float f18) {
        Matrix.translateM(this.mMatrixCurrent, 0, f16, f17, f18);
    }
}
