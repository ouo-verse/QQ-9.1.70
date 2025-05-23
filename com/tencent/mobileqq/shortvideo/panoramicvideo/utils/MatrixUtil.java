package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

import android.opengl.Matrix;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MatrixUtil {
    public static final int ADJUSTING_MODE_CROP = 2;
    public static final int ADJUSTING_MODE_FIT_TO_SCREEN = 3;
    public static final int ADJUSTING_MODE_STRETCH = 1;
    public static float[] IDENTITY_MATRIX;

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void updateProjection(int i3, int i16, int i17, int i18, int i19, float[] fArr) {
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 == 3) {
                    updateProjectionFit(i3, i16, i17, i18, fArr);
                    return;
                }
                throw new RuntimeException("Adjusting Mode not found!");
            }
            updateProjectionCrop(i3, i16, i17, i18, fArr);
            return;
        }
        updateProjectionFill(fArr);
    }

    public static void updateProjectionCrop(int i3, int i16, int i17, int i18, float[] fArr) {
        float f16 = i17 / i18;
        float f17 = i3 / i16;
        if (f17 < f16) {
            Matrix.orthoM(fArr, 0, -1.0f, 1.0f, (-f17) / f16, f17 / f16, -1.0f, 1.0f);
        } else {
            Matrix.orthoM(fArr, 0, (-f16) / f17, f16 / f17, -1.0f, 1.0f, -1.0f, 1.0f);
        }
    }

    public static void updateProjectionFill(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }

    public static void updateProjectionFit(int i3, int i16, int i17, int i18, float[] fArr) {
        float f16 = i17 / i18;
        float f17 = i3 / i16;
        if (f17 > f16) {
            Matrix.orthoM(fArr, 0, -1.0f, 1.0f, (-f17) / f16, f17 / f16, -1.0f, 1.0f);
        } else {
            Matrix.orthoM(fArr, 0, (-f16) / f17, f16 / f17, -1.0f, 1.0f, -1.0f, 1.0f);
        }
    }
}
