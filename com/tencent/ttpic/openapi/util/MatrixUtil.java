package com.tencent.ttpic.openapi.util;

import android.opengl.Matrix;
import android.util.Log;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MatrixUtil {
    private static final String TAG = "MatrixUtil";
    private static float[] mProjectionMatrix = new float[16];
    private static float[] mViewMatrix = new float[16];
    private static float[] mMVPMatrix = new float[16];
    private static float[] mIdentityMatrix = new float[16];
    public static final float[] TRANSLATE_IDENTITY = {0.0f, 0.0f, 0.0f};
    public static final float[] SCALE_IDENTITY = {1.0f, 1.0f, 1.0f};
    public static final float[] ROTATE_IDENTITY = {0.0f, 0.0f, 0.0f};

    public static float[] compose(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[16];
        float[] fArr5 = new float[16];
        float[] fArr6 = new float[16];
        float[] fArr7 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        Matrix.translateM(fArr4, 0, fArr[0], fArr[1], fArr[2]);
        Matrix.scaleM(fArr4, 0, fArr2[0], fArr2[1], fArr2[2]);
        float[] fArr8 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr8[i3] = (float) ((fArr3[i3] * 180.0f) / 3.141592653589793d);
        }
        Matrix.rotateM(fArr7, 0, fArr4, 0, fArr8[2], 0.0f, 0.0f, 1.0f);
        Matrix.rotateM(fArr6, 0, fArr7, 0, fArr8[1], 0.0f, 1.0f, 0.0f);
        Matrix.rotateM(fArr5, 0, fArr6, 0, fArr8[0], 1.0f, 0.0f, 0.0f);
        return fArr5;
    }

    public static void decompose(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        if (fArr != null && fArr.length >= 16) {
            fArr2[0] = fArr[12];
            fArr2[1] = fArr[13];
            fArr2[2] = fArr[14];
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[4];
            float f26 = fArr[5];
            float f27 = fArr[6];
            float f28 = fArr[8];
            float f29 = fArr[9];
            float f36 = fArr[10];
            float f37 = (((f26 * f36) - (f27 * f29)) * f16) + (((f27 * f28) - (f19 * f36)) * f17) + (((f19 * f29) - (f26 * f28)) * f18);
            float length = length(f16, f17, f18);
            float length2 = length(f19, f26, f27);
            float length3 = length(f28, f29, f36);
            fArr3[0] = length;
            fArr3[1] = length2;
            fArr3[2] = length3;
            if (f37 < 0.0f) {
                for (int i3 = 0; i3 < fArr3.length; i3++) {
                    fArr3[i3] = -fArr3[i3];
                }
            }
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            if (Math.abs(f37) > 0.0f) {
                for (int i16 = 0; i16 < 4; i16++) {
                    int i17 = i16 + 0;
                    copyOf[i17] = copyOf[i17] / fArr3[0];
                    int i18 = i16 + 4;
                    copyOf[i18] = copyOf[i18] / fArr3[1];
                    int i19 = i16 + 8;
                    copyOf[i19] = copyOf[i19] / fArr3[2];
                }
            }
            fArr4[0] = (float) Math.atan2(f27, f36);
            fArr4[1] = (float) Math.atan2(-f18, Math.sqrt((f27 * f27) + (f36 * f36)));
            fArr4[2] = (float) Math.atan2(f17, f16);
        }
    }

    public static float[] genLookAtMatrix(int i3, int i16) {
        Matrix.setLookAtM(mViewMatrix, 0, 0.0f, 0.0f, Math.max(i3, i16), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        return mViewMatrix;
    }

    public static float[] genProjectionMatrix(int i3, int i16) {
        float max = Math.max(i3, i16);
        Matrix.frustumM(mProjectionMatrix, 0, (-i3) * 0.01f, i3 * 0.01f, (-i16) * 0.01f, i16 * 0.01f, max * 0.02f, max * 2.0f);
        return mProjectionMatrix;
    }

    public static float[] getDefaultMVPMatrix() {
        initProjectionMatrix(1.0f, 3.0f);
        initViewMatrix(2.0f);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        return mMVPMatrix;
    }

    public static float[] getIdentityMatrix() {
        Matrix.setIdentityM(mIdentityMatrix, 0);
        return mIdentityMatrix;
    }

    public static float[] getMVPMatrix(float[] fArr, int i3, int i16) {
        genProjectionMatrix(i3, i16);
        genLookAtMatrix(i3, i16);
        Matrix.multiplyMM(fArr, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        return fArr;
    }

    public static float[] getRotate(float[] fArr) {
        float[] fArr2 = {1.0f, 1.0f, 1.0f};
        if (fArr != null && fArr.length >= 16) {
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[4];
            float f26 = fArr[5];
            float f27 = fArr[6];
            float f28 = fArr[8];
            float f29 = fArr[9];
            float f36 = fArr[10];
            float f37 = (((f26 * f36) - (f27 * f29)) * f16) + (((f27 * f28) - (f19 * f36)) * f17) + (((f19 * f29) - (f26 * f28)) * f18);
            float length = length(f16, f17, f18);
            float length2 = length(f19, f26, f27);
            float length3 = length(f28, f29, f36);
            fArr2[0] = length;
            fArr2[1] = length2;
            fArr2[2] = length3;
            if (f37 < 0.0f) {
                for (int i3 = 0; i3 < 3; i3++) {
                    fArr2[i3] = -fArr2[i3];
                }
            }
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            if (Math.abs(f37) > 0.0f) {
                for (int i16 = 0; i16 < 4; i16++) {
                    int i17 = i16 + 0;
                    copyOf[i17] = copyOf[i17] / fArr2[0];
                    int i18 = i16 + 4;
                    copyOf[i18] = copyOf[i18] / fArr2[1];
                    int i19 = i16 + 8;
                    copyOf[i19] = copyOf[i19] / fArr2[2];
                }
            }
            return new float[]{(float) Math.atan2(f27, f36), (float) Math.atan2(-f18, Math.sqrt((f27 * f27) + (f36 * f36))), (float) Math.atan2(f17, f16)};
        }
        return fArr2;
    }

    public static float[] getScale(float[] fArr) {
        float[] fArr2 = {1.0f, 1.0f, 1.0f};
        if (fArr != null && fArr.length >= 16) {
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[4];
            float f26 = fArr[5];
            float f27 = fArr[6];
            float f28 = fArr[8];
            float f29 = fArr[9];
            float f36 = fArr[10];
            float f37 = (((f26 * f36) - (f27 * f29)) * f16) + (((f27 * f28) - (f19 * f36)) * f17) + (((f19 * f29) - (f26 * f28)) * f18);
            float length = length(f16, f17, f18);
            float length2 = length(f19, f26, f27);
            float length3 = length(f28, f29, f36);
            fArr2[0] = length;
            fArr2[1] = length2;
            fArr2[2] = length3;
            if (f37 < 0.0f) {
                for (int i3 = 0; i3 < 3; i3++) {
                    fArr2[i3] = -fArr2[i3];
                }
            }
        }
        return fArr2;
    }

    public static float[] initProjectionMatrix(float f16, float f17) {
        Matrix.frustumM(mProjectionMatrix, 0, -1.0f, 1.0f, -1.0f, 1.0f, f16, f17);
        return mProjectionMatrix;
    }

    private static float[] initViewMatrix(float f16) {
        Matrix.setLookAtM(mViewMatrix, 0, 0.0f, 0.0f, f16, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
        return mViewMatrix;
    }

    public static float[] inverse(float[] fArr) {
        if (fArr == null) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr2[i3] = -fArr[i3];
        }
        return fArr2;
    }

    private static float length(float... fArr) {
        float f16 = 0.0f;
        for (float f17 : fArr) {
            f16 += f17 * f17;
        }
        return (float) Math.sqrt(f16);
    }

    public static void printMat(String str, float[] fArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append('\n');
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i16 = 0; i16 < 4; i16++) {
                sb5.append(fArr[(i3 * 4) + i16] + ", ");
            }
            sb5.append('\n');
        }
        Log.d(TAG, sb5.toString());
    }

    public static float[] rotate(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = (float) ((fArr2[i3] * 180.0f) / 3.141592653589793d);
        }
        float[] fArr4 = new float[16];
        setRotateEulerM(fArr4, 0, fArr3[0], fArr3[1], fArr3[2]);
        float[] fArr5 = new float[16];
        Matrix.multiplyMM(fArr5, 0, fArr, 0, fArr4, 0);
        return fArr5;
    }

    public static void setRotateEulerM(float[] fArr, int i3, float f16, float f17, float f18) {
        double d16 = f16 * 0.017453292f;
        float cos = (float) Math.cos(d16);
        float sin = (float) Math.sin(d16);
        double d17 = f17 * 0.017453292f;
        float cos2 = (float) Math.cos(d17);
        float sin2 = (float) Math.sin(d17);
        double d18 = f18 * 0.017453292f;
        float cos3 = (float) Math.cos(d18);
        float sin3 = (float) Math.sin(d18);
        float f19 = cos * sin2;
        float f26 = sin * sin2;
        fArr[i3 + 0] = cos2 * cos3;
        fArr[i3 + 4] = (-cos2) * sin3;
        fArr[i3 + 8] = sin2;
        fArr[i3 + 12] = 0.0f;
        fArr[i3 + 1] = (f26 * cos3) + (cos * sin3);
        fArr[i3 + 5] = ((-f26) * sin3) + (cos * cos3);
        fArr[i3 + 9] = (-sin) * cos2;
        fArr[i3 + 13] = 0.0f;
        fArr[i3 + 2] = ((-f19) * cos3) + (sin * sin3);
        fArr[i3 + 6] = (f19 * sin3) + (sin * cos3);
        fArr[i3 + 10] = cos * cos2;
        fArr[i3 + 14] = 0.0f;
        fArr[i3 + 3] = 0.0f;
        fArr[i3 + 7] = 0.0f;
        fArr[i3 + 11] = 0.0f;
        fArr[i3 + 15] = 1.0f;
    }

    public static float[] getMVPMatrix(float f16, float f17, float f18) {
        initProjectionMatrix(f17, f18);
        initViewMatrix(f16);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        return mMVPMatrix;
    }
}
