package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Reader;
import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class OneDReader implements Reader {
    /* JADX INFO: Access modifiers changed from: protected */
    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f16) {
        int length = iArr.length;
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            i3 += iArr[i17];
            i16 += iArr2[i17];
        }
        if (i3 < i16) {
            return Float.POSITIVE_INFINITY;
        }
        float f17 = i3;
        float f18 = f17 / i16;
        float f19 = f16 * f18;
        float f26 = 0.0f;
        for (int i18 = 0; i18 < length; i18++) {
            float f27 = iArr2[i18] * f18;
            float f28 = iArr[i18];
            float f29 = f28 > f27 ? f28 - f27 : f27 - f28;
            if (f29 > f19) {
                return Float.POSITIVE_INFINITY;
            }
            f26 += f29;
        }
        return f26 / f17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void recordPattern(BitArray bitArray, int i3, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i16 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i3 < size) {
            boolean z16 = !bitArray.get(i3);
            while (i3 < size) {
                if (bitArray.get(i3) != z16) {
                    iArr[i16] = iArr[i16] + 1;
                } else {
                    i16++;
                    if (i16 == length) {
                        break;
                    }
                    iArr[i16] = 1;
                    z16 = !z16;
                }
                i3++;
            }
            if (i16 != length) {
                if (i16 != length - 1 || i3 != size) {
                    throw NotFoundException.getNotFoundInstance();
                }
                return;
            }
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPatternInReverse(BitArray bitArray, int i3, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z16 = bitArray.get(i3);
        while (i3 > 0 && length >= 0) {
            i3--;
            if (bitArray.get(i3) != z16) {
                length--;
                z16 = !z16;
            }
        }
        if (length < 0) {
            recordPattern(bitArray, i3 + 1, iArr);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.tencent.mobileqq.mini.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    public abstract Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.tencent.mobileqq.mini.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e16) {
            if ((map != null && map.containsKey(DecodeHintType.TRY_HARDER)) && binaryBitmap.isRotateSupported()) {
                BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
                Result doDecode = doDecode(rotateCounterClockwise, map);
                Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
                int i3 = 270;
                if (resultMetadata != null) {
                    ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                    if (resultMetadata.containsKey(resultMetadataType)) {
                        i3 = (((Integer) resultMetadata.get(resultMetadataType)).intValue() + 270) % 360;
                    }
                }
                doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i3));
                ResultPoint[] resultPoints = doDecode.getResultPoints();
                if (resultPoints != null) {
                    int height = rotateCounterClockwise.getHeight();
                    for (int i16 = 0; i16 < resultPoints.length; i16++) {
                        resultPoints[i16] = new ResultPoint((height - resultPoints[i16].getY()) - 1.0f, resultPoints[i16].getX());
                    }
                }
                return doDecode;
            }
            throw e16;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007a A[Catch: ReaderException -> 0x00ca, TRY_LEAVE, TryCatch #4 {ReaderException -> 0x00ca, blocks: (B:34:0x0074, B:36:0x007a), top: B:33:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        OneDReader oneDReader;
        Map<DecodeHintType, ?> map2;
        int i3;
        int i16;
        Map<DecodeHintType, ?> map3 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i17 = 0;
        int i18 = 1;
        boolean z16 = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int max = Math.max(1, height >> (z16 ? 8 : 5));
        int i19 = z16 ? height : 15;
        int i26 = height / 2;
        int i27 = 0;
        while (i27 < i19) {
            int i28 = i27 + 1;
            int i29 = i28 / 2;
            if (((i27 & 1) == 0 ? i18 : i17) == 0) {
                i29 = -i29;
            }
            int i36 = (i29 * max) + i26;
            if (i36 < 0 || i36 >= height) {
                break;
            }
            try {
                bitArray = binaryBitmap.getBlackRow(i36, bitArray);
                int i37 = i17;
                while (i37 < 2) {
                    try {
                        if (i37 == i18) {
                            bitArray.reverse();
                            if (map3 != null) {
                                DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                                if (map3.containsKey(decodeHintType)) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.putAll(map3);
                                    hashMap.remove(decodeHintType);
                                    oneDReader = this;
                                    map3 = hashMap;
                                    Result decodeRow = oneDReader.decodeRow(i36, bitArray, map3);
                                    if (i37 != i18) {
                                        try {
                                            decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                            ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                            if (resultPoints != null) {
                                                map2 = map3;
                                                float f16 = width;
                                                try {
                                                    i3 = width;
                                                    try {
                                                        resultPoints[0] = new ResultPoint((f16 - resultPoints[i17].getX()) - 1.0f, resultPoints[i17].getY());
                                                        i16 = 1;
                                                    } catch (ReaderException unused) {
                                                        i16 = 1;
                                                        i37++;
                                                        i18 = i16;
                                                        map3 = map2;
                                                        width = i3;
                                                        i17 = 0;
                                                    }
                                                } catch (ReaderException unused2) {
                                                    i3 = width;
                                                    i16 = 1;
                                                    i37++;
                                                    i18 = i16;
                                                    map3 = map2;
                                                    width = i3;
                                                    i17 = 0;
                                                }
                                                try {
                                                    resultPoints[1] = new ResultPoint((f16 - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                                } catch (ReaderException unused3) {
                                                    continue;
                                                    i37++;
                                                    i18 = i16;
                                                    map3 = map2;
                                                    width = i3;
                                                    i17 = 0;
                                                }
                                            }
                                        } catch (ReaderException unused4) {
                                            map2 = map3;
                                        }
                                    }
                                    return decodeRow;
                                }
                            }
                        }
                        Result decodeRow2 = oneDReader.decodeRow(i36, bitArray, map3);
                        if (i37 != i18) {
                        }
                        return decodeRow2;
                    } catch (ReaderException unused5) {
                        map2 = map3;
                        i3 = width;
                        i16 = i18;
                    }
                    oneDReader = this;
                }
            } catch (NotFoundException unused6) {
            }
            i27 = i28;
            i18 = i18;
            width = width;
            i17 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.tencent.mobileqq.mini.zxing.Reader
    public void reset() {
    }
}
