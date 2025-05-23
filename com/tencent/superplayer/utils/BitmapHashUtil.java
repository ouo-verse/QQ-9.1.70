package com.tencent.superplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.io.IOException;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes26.dex */
public class BitmapHashUtil {
    private static final int BLUE_WIGHT = 15;
    private static final int GREEN_WIGHT = 75;
    private static final long H01 = 72340172838076673L;
    private static final long HASH = 0;
    private static final int IMAGE_WIDTH = 32;
    private static final long M1 = 6148914691236517205L;
    private static final long M2 = 3689348814741910323L;
    private static final long M4 = 1085102592571150095L;
    private static final long ONE = 1;
    private static final int RED_WIGHT = 38;

    private static double[][] coefficient(int i3) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i3);
        double d16 = i3;
        double sqrt = Math.sqrt(1.0d / d16);
        double sqrt2 = Math.sqrt(2.0d / d16);
        for (int i16 = 0; i16 < i3; i16++) {
            dArr[0][i16] = sqrt;
        }
        for (int i17 = 1; i17 < i3; i17++) {
            for (int i18 = 0; i18 < i3; i18++) {
                dArr[i17][i18] = Math.cos(((i17 * 3.141592653589793d) * (i18 + 0.5d)) / d16) * sqrt2;
            }
        }
        return dArr;
    }

    private static int computeGray(int i3) {
        return (((Color.red(i3) * 38) + (Color.green(i3) * 75)) + (Color.blue(i3) * 15)) >> 7;
    }

    private static long computeHash(double[] dArr) {
        double d16 = 0.0d;
        for (double d17 : dArr) {
            d16 += d17;
        }
        double length = d16 / dArr.length;
        long j3 = 1;
        long j16 = 0;
        for (double d18 : dArr) {
            if (d18 > length) {
                j16 |= j3;
            }
            j3 <<= 1;
        }
        return j16;
    }

    private static int[] createGrayImage(Bitmap bitmap, int i3) {
        int i16 = i3 * i3;
        int[] iArr = new int[i16];
        bitmap.getPixels(iArr, 0, i3, 0, 0, i3, i3);
        bitmap.recycle();
        for (int i17 = 0; i17 < i16; i17++) {
            int computeGray = computeGray(iArr[i17]);
            iArr[i17] = Color.rgb(computeGray, computeGray, computeGray);
        }
        return iArr;
    }

    private static double[][] dct(int[] iArr, int i3) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i3);
        for (int i16 = 0; i16 < i3; i16++) {
            for (int i17 = 0; i17 < i3; i17++) {
                dArr[i16][i17] = iArr[(i16 * i3) + i17];
            }
        }
        double[][] coefficient = coefficient(i3);
        return matrixMultiply(matrixMultiply(coefficient, dArr, i3), transposingMatrix(coefficient, i3), i3);
    }

    private static double[] dct8(int[] iArr, int i3) {
        double[][] dct = dct(iArr, i3);
        double[] dArr = new double[64];
        for (int i16 = 0; i16 < 8; i16++) {
            System.arraycopy(dct[i16], 0, dArr, i16 * 8, 8);
        }
        return dArr;
    }

    public static long dctImageHash(Bitmap bitmap, boolean z16) throws IOException {
        return computeHash(dct8(createGrayImage(BitmapUtil.scaleBitmap(bitmap, z16, 32), 32), 32));
    }

    public static int hammingDistance(long j3, long j16) {
        long j17 = j3 ^ j16;
        long j18 = j17 - ((j17 >> 1) & M1);
        long j19 = (j18 & M2) + ((j18 >> 2) & M2);
        return (int) (((M4 & (j19 + (j19 >> 4))) * H01) >> 56);
    }

    private static double[][] matrixMultiply(double[][] dArr, double[][] dArr2, int i3) {
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i3);
        for (int i16 = 0; i16 < i3; i16++) {
            for (int i17 = 0; i17 < i3; i17++) {
                double d16 = 0.0d;
                for (int i18 = 0; i18 < i3; i18++) {
                    d16 += dArr[i16][i18] * dArr2[i18][i17];
                }
                dArr3[i16][i17] = d16;
            }
        }
        return dArr3;
    }

    private static double[][] transposingMatrix(double[][] dArr, int i3) {
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, i3);
        for (int i16 = 0; i16 < i3; i16++) {
            for (int i17 = 0; i17 < i3; i17++) {
                dArr2[i16][i17] = dArr[i17][i16];
            }
        }
        return dArr2;
    }
}
