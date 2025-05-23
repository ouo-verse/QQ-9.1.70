package com.tencent.mapsdk.internal;

import android.opengl.Matrix;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lp {
    private static float[][] a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        Matrix.multiplyMM(fArr3, 0, fArr2, 0, fArr, 0);
        float[][] fArr4 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 6, 4);
        float[] fArr5 = fArr4[0];
        fArr5[0] = fArr3[3] - fArr3[0];
        fArr5[1] = fArr3[7] - fArr3[4];
        fArr5[2] = fArr3[11] - fArr3[8];
        fArr5[3] = fArr3[15] - fArr3[12];
        double sqrt = Math.sqrt((r6 * r6) + (r8 * r8) + (r12 * r12));
        float[] fArr6 = fArr4[0];
        fArr6[0] = (float) (fArr6[0] / sqrt);
        fArr6[1] = (float) (fArr6[1] / sqrt);
        fArr6[2] = (float) (fArr6[2] / sqrt);
        fArr6[3] = (float) (fArr6[3] / sqrt);
        float[] fArr7 = fArr4[1];
        fArr7[0] = fArr3[3] + fArr3[0];
        fArr7[1] = fArr3[7] + fArr3[4];
        fArr7[2] = fArr3[11] + fArr3[8];
        fArr7[3] = fArr3[15] + fArr3[12];
        double sqrt2 = Math.sqrt((r6 * r6) + (r8 * r8) + (r12 * r12));
        float[] fArr8 = fArr4[1];
        fArr8[0] = (float) (fArr8[0] / sqrt2);
        fArr8[1] = (float) (fArr8[1] / sqrt2);
        fArr8[2] = (float) (fArr8[2] / sqrt2);
        fArr8[3] = (float) (fArr8[3] / sqrt2);
        float[] fArr9 = fArr4[2];
        fArr9[0] = fArr3[3] + fArr3[1];
        fArr9[1] = fArr3[7] + fArr3[5];
        fArr9[2] = fArr3[11] + fArr3[9];
        fArr9[3] = fArr3[15] + fArr3[13];
        double sqrt3 = Math.sqrt((r6 * r6) + (r8 * r8) + (r13 * r13));
        float[] fArr10 = fArr4[2];
        fArr10[0] = (float) (fArr10[0] / sqrt3);
        fArr10[1] = (float) (fArr10[1] / sqrt3);
        fArr10[2] = (float) (fArr10[2] / sqrt3);
        fArr10[3] = (float) (fArr10[3] / sqrt3);
        float[] fArr11 = fArr4[3];
        fArr11[0] = fArr3[3] - fArr3[1];
        fArr11[1] = fArr3[7] - fArr3[5];
        fArr11[2] = fArr3[11] - fArr3[9];
        fArr11[3] = fArr3[15] - fArr3[13];
        double sqrt4 = Math.sqrt((r8 * r8) + (r11 * r11) + (r13 * r13));
        float[] fArr12 = fArr4[3];
        fArr12[0] = (float) (fArr12[0] / sqrt4);
        fArr12[1] = (float) (fArr12[1] / sqrt4);
        fArr12[2] = (float) (fArr12[2] / sqrt4);
        fArr12[3] = (float) (fArr12[3] / sqrt4);
        float[] fArr13 = fArr4[4];
        fArr13[0] = fArr3[3] - fArr3[2];
        fArr13[1] = fArr3[7] - fArr3[6];
        fArr13[2] = fArr3[11] - fArr3[10];
        fArr13[3] = fArr3[15] - fArr3[14];
        double sqrt5 = Math.sqrt((r6 * r6) + (r8 * r8) + (r13 * r13));
        float[] fArr14 = fArr4[4];
        fArr14[0] = (float) (fArr14[0] / sqrt5);
        fArr14[1] = (float) (fArr14[1] / sqrt5);
        fArr14[2] = (float) (fArr14[2] / sqrt5);
        fArr14[3] = (float) (fArr14[3] / sqrt5);
        float[] fArr15 = fArr4[5];
        fArr15[0] = fArr3[3] + fArr3[2];
        fArr15[1] = fArr3[7] + fArr3[6];
        fArr15[2] = fArr3[11] + fArr3[10];
        fArr15[3] = fArr3[15] + fArr3[14];
        double sqrt6 = Math.sqrt((r4 * r4) + (r7 * r7) + (r8 * r8));
        float[] fArr16 = fArr4[5];
        fArr16[0] = (float) (fArr16[0] / sqrt6);
        fArr16[1] = (float) (fArr16[1] / sqrt6);
        fArr16[2] = (float) (fArr16[2] / sqrt6);
        fArr16[3] = (float) (fArr16[3] / sqrt6);
        return fArr4;
    }

    private static boolean b(float[][] fArr, float[] fArr2) {
        int length = fArr2.length / 3;
        for (int i3 = 0; i3 < 6; i3++) {
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                float[] fArr3 = fArr[i3];
                int i18 = i17 + 1;
                int i19 = i18 + 1;
                float f16 = (fArr3[0] * fArr2[i17]) + (fArr3[1] * fArr2[i18]);
                int i26 = i19 + 1;
                if (f16 + (fArr3[2] * fArr2[i19]) + fArr3[3] > 0.0f) {
                    break;
                }
                i16++;
                i17 = i26;
            }
            if (i16 == length) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(float[][] fArr, float[] fArr2) {
        int length = fArr2.length / 3;
        for (int i3 = 0; i3 < 6; i3++) {
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                float[] fArr3 = fArr[i3];
                int i18 = i17 + 1;
                int i19 = i18 + 1;
                float f16 = (fArr3[0] * fArr2[i17]) + (fArr3[1] * fArr2[i18]);
                int i26 = i19 + 1;
                if (f16 + (fArr3[2] * fArr2[i19]) + fArr3[3] > 0.0f) {
                    break;
                }
                i16++;
                i17 = i26;
            }
            if (i16 == length) {
                return false;
            }
        }
        return true;
    }
}
