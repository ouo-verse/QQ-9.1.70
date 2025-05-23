package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ITFReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.5f;
    private static final int N = 1;
    private static final int W = 3;

    /* renamed from: w, reason: collision with root package name */
    private static final int f246771w = 2;
    private int narrowLineWidth = -1;
    private static final int[] DEFAULT_ALLOWED_LENGTHS = {6, 8, 10, 12, 14};
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[][] END_PATTERN_REVERSED = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    private static final int[][] PATTERNS = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    private static int decodeDigit(int[] iArr) throws NotFoundException {
        int length = PATTERNS.length;
        float f16 = MAX_AVG_VARIANCE;
        int i3 = -1;
        for (int i16 = 0; i16 < length; i16++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, PATTERNS[i16], 0.5f);
            if (patternMatchVariance < f16) {
                i3 = i16;
                f16 = patternMatchVariance;
            } else if (patternMatchVariance == f16) {
                i3 = -1;
            }
        }
        if (i3 >= 0) {
            return i3 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] decodeEnd(BitArray bitArray) throws NotFoundException {
        int[] findGuardPattern;
        bitArray.reverse();
        try {
            int skipWhiteSpace = skipWhiteSpace(bitArray);
            try {
                findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace, END_PATTERN_REVERSED[0]);
            } catch (NotFoundException unused) {
                findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace, END_PATTERN_REVERSED[1]);
            }
            validateQuietZone(bitArray, findGuardPattern[0]);
            int i3 = findGuardPattern[0];
            findGuardPattern[0] = bitArray.getSize() - findGuardPattern[1];
            findGuardPattern[1] = bitArray.getSize() - i3;
            return findGuardPattern;
        } finally {
            bitArray.reverse();
        }
    }

    private int[] decodeStart(BitArray bitArray) throws NotFoundException {
        int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        int i3 = findGuardPattern[1];
        int i16 = findGuardPattern[0];
        this.narrowLineWidth = (i3 - i16) / 4;
        validateQuietZone(bitArray, i16);
        return findGuardPattern;
    }

    private static int[] findGuardPattern(BitArray bitArray, int i3, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i16 = i3;
        boolean z16 = false;
        int i17 = 0;
        while (i3 < size) {
            if (bitArray.get(i3) != z16) {
                iArr2[i17] = iArr2[i17] + 1;
            } else {
                if (i17 != length - 1) {
                    i17++;
                } else {
                    if (OneDReader.patternMatchVariance(iArr2, iArr, 0.5f) < MAX_AVG_VARIANCE) {
                        return new int[]{i16, i3};
                    }
                    i16 += iArr2[0] + iArr2[1];
                    int i18 = i17 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i17] = 0;
                    i17--;
                }
                iArr2[i17] = 1;
                z16 = !z16;
            }
            i3++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void validateQuietZone(BitArray bitArray, int i3) throws NotFoundException {
        int i16 = this.narrowLineWidth * 10;
        if (i16 >= i3) {
            i16 = i3;
        }
        for (int i17 = i3 - 1; i16 > 0 && i17 >= 0 && !bitArray.get(i17); i17--) {
            i16--;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader
    public Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z16;
        int[] decodeStart = decodeStart(bitArray);
        int[] decodeEnd = decodeEnd(bitArray);
        StringBuilder sb5 = new StringBuilder(20);
        decodeMiddle(bitArray, decodeStart[1], decodeEnd[0], sb5);
        String sb6 = sb5.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = sb6.length();
        int length2 = iArr.length;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= length2) {
                z16 = false;
                break;
            }
            int i18 = iArr[i16];
            if (length == i18) {
                z16 = true;
                break;
            }
            if (i18 > i17) {
                i17 = i18;
            }
            i16++;
        }
        if (!z16 && length > i17) {
            z16 = true;
        }
        if (z16) {
            float f16 = i3;
            return new Result(sb6, null, new ResultPoint[]{new ResultPoint(decodeStart[1], f16), new ResultPoint(decodeEnd[0], f16)}, BarcodeFormat.ITF);
        }
        throw FormatException.getFormatInstance();
    }

    private static void decodeMiddle(BitArray bitArray, int i3, int i16, StringBuilder sb5) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i3 < i16) {
            OneDReader.recordPattern(bitArray, i3, iArr);
            for (int i17 = 0; i17 < 5; i17++) {
                int i18 = i17 * 2;
                iArr2[i17] = iArr[i18];
                iArr3[i17] = iArr[i18 + 1];
            }
            sb5.append((char) (decodeDigit(iArr2) + 48));
            sb5.append((char) (decodeDigit(iArr3) + 48));
            for (int i19 = 0; i19 < 10; i19++) {
                i3 += iArr[i19];
            }
        }
    }
}
