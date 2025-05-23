package com.tencent.mobileqq.mini.zxing.common;

import com.tencent.mobileqq.mini.zxing.Binarizer;
import com.tencent.mobileqq.mini.zxing.LuminanceSource;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int cap(int i3, int i16, int i17) {
        if (i3 < i16) {
            return i16;
        }
        if (i3 > i17) {
            return i17;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.mini.zxing.common.GlobalHistogramBinarizer, com.tencent.mobileqq.mini.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.tencent.mobileqq.mini.zxing.common.GlobalHistogramBinarizer, com.tencent.mobileqq.mini.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width >= 40 && height >= 40) {
            byte[] matrix = luminanceSource.getMatrix();
            int i3 = width >> 3;
            if ((width & 7) != 0) {
                i3++;
            }
            int i16 = i3;
            int i17 = height >> 3;
            if ((height & 7) != 0) {
                i17++;
            }
            int i18 = i17;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix, i16, i18, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i16, i18, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        } else {
            this.matrix = super.getBlackMatrix();
        }
        return this.matrix;
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i3, int i16, int i17, int i18) {
        char c16;
        int i19 = 8;
        int i26 = i18 - 8;
        int i27 = i17 - 8;
        char c17 = 2;
        boolean z16 = true;
        int i28 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i16, i3);
        int i29 = 0;
        while (i29 < i16) {
            int i36 = i29 << 3;
            if (i36 > i26) {
                i36 = i26;
            }
            int i37 = i28;
            while (i37 < i3) {
                int i38 = i37 << 3;
                if (i38 > i27) {
                    i38 = i27;
                }
                int i39 = (i36 * i17) + i38;
                int i46 = i28;
                int i47 = i46;
                int i48 = i47;
                int i49 = 255;
                while (i46 < i19) {
                    int i56 = i48;
                    int i57 = 0;
                    while (i57 < i19) {
                        int i58 = bArr[i39 + i57] & 255;
                        i47 += i58;
                        if (i58 < i49) {
                            i49 = i58;
                        }
                        if (i58 > i56) {
                            i56 = i58;
                        }
                        i57++;
                        i19 = 8;
                    }
                    if (i56 - i49 <= 24) {
                        i46++;
                        i39 += i17;
                        i48 = i56;
                        z16 = true;
                        i19 = 8;
                    }
                    while (true) {
                        i46++;
                        i39 += i17;
                        if (i46 < 8) {
                            int i59 = 0;
                            for (int i65 = 8; i59 < i65; i65 = 8) {
                                i47 += bArr[i39 + i59] & 255;
                                i59++;
                            }
                        }
                    }
                    i46++;
                    i39 += i17;
                    i48 = i56;
                    z16 = true;
                    i19 = 8;
                }
                boolean z17 = z16;
                int i66 = i47 >> 6;
                if (i48 - i49 <= 24) {
                    i66 = i49 / 2;
                    if (i29 > 0 && i37 > 0) {
                        int[] iArr2 = iArr[i29 - 1];
                        int i67 = i37 - 1;
                        c16 = 2;
                        int i68 = ((iArr2[i37] + (iArr[i29][i67] * 2)) + iArr2[i67]) / 4;
                        if (i49 < i68) {
                            i66 = i68;
                        }
                        iArr[i29][i37] = i66;
                        i37++;
                        z16 = z17;
                        c17 = c16;
                        i19 = 8;
                        i28 = 0;
                    }
                }
                c16 = 2;
                iArr[i29][i37] = i66;
                i37++;
                z16 = z17;
                c17 = c16;
                i19 = 8;
                i28 = 0;
            }
            i29++;
            i19 = 8;
            i28 = 0;
        }
        return iArr;
    }

    private static void thresholdBlock(byte[] bArr, int i3, int i16, int i17, int i18, BitMatrix bitMatrix) {
        int i19 = (i16 * i18) + i3;
        int i26 = 0;
        while (i26 < 8) {
            for (int i27 = 0; i27 < 8; i27++) {
                if ((bArr[i19 + i27] & 255) <= i17) {
                    bitMatrix.set(i3 + i27, i16 + i26);
                }
            }
            i26++;
            i19 += i18;
        }
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i3, int i16, int i17, int i18, int[][] iArr, BitMatrix bitMatrix) {
        int i19 = i18 - 8;
        int i26 = i17 - 8;
        for (int i27 = 0; i27 < i16; i27++) {
            int i28 = i27 << 3;
            int i29 = i28 > i19 ? i19 : i28;
            int cap = cap(i27, 2, i16 - 3);
            for (int i36 = 0; i36 < i3; i36++) {
                int i37 = i36 << 3;
                int i38 = i37 > i26 ? i26 : i37;
                int cap2 = cap(i36, 2, i3 - 3);
                int i39 = 0;
                for (int i46 = -2; i46 <= 2; i46++) {
                    int[] iArr2 = iArr[cap + i46];
                    i39 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i38, i29, i39 / 25, i17, bitMatrix);
            }
        }
    }
}
