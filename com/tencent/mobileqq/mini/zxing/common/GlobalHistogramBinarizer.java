package com.tencent.mobileqq.mini.zxing.common;

import com.tencent.mobileqq.mini.zxing.Binarizer;
import com.tencent.mobileqq.mini.zxing.LuminanceSource;
import com.tencent.mobileqq.mini.zxing.NotFoundException;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets;
    private byte[] luminances;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    private static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            int i19 = iArr[i18];
            if (i19 > i3) {
                i17 = i18;
                i3 = i19;
            }
            if (i19 > i16) {
                i16 = i19;
            }
        }
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 0; i28 < length; i28++) {
            int i29 = i28 - i17;
            int i36 = iArr[i28] * i29 * i29;
            if (i36 > i27) {
                i26 = i28;
                i27 = i36;
            }
        }
        if (i17 <= i26) {
            int i37 = i17;
            i17 = i26;
            i26 = i37;
        }
        if (i17 - i26 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i38 = i17 - 1;
        int i39 = -1;
        int i46 = i38;
        while (i38 > i26) {
            int i47 = i38 - i26;
            int i48 = i47 * i47 * (i17 - i38) * (i16 - iArr[i38]);
            if (i48 > i39) {
                i46 = i38;
                i39 = i48;
            }
            i38--;
        }
        return i46 << 3;
    }

    private void initArrays(int i3) {
        if (this.luminances.length < i3) {
            this.luminances = new byte[i3];
        }
        for (int i16 = 0; i16 < 32; i16++) {
            this.buckets[i16] = 0;
        }
    }

    @Override // com.tencent.mobileqq.mini.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    @Override // com.tencent.mobileqq.mini.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i3 = 1; i3 < 5; i3++) {
            byte[] row = luminanceSource.getRow((height * i3) / 5, this.luminances);
            int i16 = (width * 4) / 5;
            for (int i17 = width / 5; i17 < i16; i17++) {
                int i18 = (row[i17] & 255) >> 3;
                iArr[i18] = iArr[i18] + 1;
            }
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i19 = 0; i19 < height; i19++) {
            int i26 = i19 * width;
            for (int i27 = 0; i27 < width; i27++) {
                if ((matrix[i26 + i27] & 255) < estimateBlackPoint) {
                    bitMatrix.set(i27, i19);
                }
            }
        }
        return bitMatrix;
    }

    @Override // com.tencent.mobileqq.mini.zxing.Binarizer
    public BitArray getBlackRow(int i3, BitArray bitArray) throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray != null && bitArray.getSize() >= width) {
            bitArray.clear();
        } else {
            bitArray = new BitArray(width);
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i3, this.luminances);
        int[] iArr = this.buckets;
        for (int i16 = 0; i16 < width; i16++) {
            int i17 = (row[i16] & 255) >> 3;
            iArr[i17] = iArr[i17] + 1;
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        if (width < 3) {
            for (int i18 = 0; i18 < width; i18++) {
                if ((row[i18] & 255) < estimateBlackPoint) {
                    bitArray.set(i18);
                }
            }
        } else {
            int i19 = 1;
            int i26 = row[0] & 255;
            int i27 = row[1] & 255;
            while (i19 < width - 1) {
                int i28 = i19 + 1;
                int i29 = row[i28] & 255;
                if ((((i27 * 4) - i26) - i29) / 2 < estimateBlackPoint) {
                    bitArray.set(i19);
                }
                i26 = i27;
                i19 = i28;
                i27 = i29;
            }
        }
        return bitArray;
    }
}
