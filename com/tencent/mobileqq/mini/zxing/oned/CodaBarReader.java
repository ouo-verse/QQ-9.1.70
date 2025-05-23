package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CodaBarReader extends OneDReader {
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] STARTEND_ENCODING = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D'};
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private int[] counters = new int[80];
    private int counterLength = 0;

    private void counterAppend(int i3) {
        int[] iArr = this.counters;
        int i16 = this.counterLength;
        iArr[i16] = i3;
        int i17 = i16 + 1;
        this.counterLength = i17;
        if (i17 >= iArr.length) {
            int[] iArr2 = new int[i17 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i17);
            this.counters = iArr2;
        }
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader
    public Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.counters, 0);
        setCounters(bitArray);
        int findStartPattern = findStartPattern();
        this.decodeRowResult.setLength(0);
        int i16 = findStartPattern;
        do {
            int narrowWidePattern = toNarrowWidePattern(i16);
            if (narrowWidePattern != -1) {
                this.decodeRowResult.append((char) narrowWidePattern);
                i16 += 8;
                if (this.decodeRowResult.length() > 1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                    break;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } while (i16 < this.counterLength);
        int i17 = i16 - 1;
        int i18 = this.counters[i17];
        int i19 = 0;
        for (int i26 = -8; i26 < -1; i26++) {
            i19 += this.counters[i16 + i26];
        }
        if (i16 < this.counterLength && i18 < i19 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        validatePattern(findStartPattern);
        for (int i27 = 0; i27 < this.decodeRowResult.length(); i27++) {
            StringBuilder sb5 = this.decodeRowResult;
            sb5.setCharAt(i27, ALPHABET[sb5.charAt(i27)]);
        }
        char charAt = this.decodeRowResult.charAt(0);
        char[] cArr = STARTEND_ENCODING;
        if (arrayContains(cArr, charAt)) {
            StringBuilder sb6 = this.decodeRowResult;
            if (arrayContains(cArr, sb6.charAt(sb6.length() - 1))) {
                if (this.decodeRowResult.length() > 3) {
                    if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                        StringBuilder sb7 = this.decodeRowResult;
                        sb7.deleteCharAt(sb7.length() - 1);
                        this.decodeRowResult.deleteCharAt(0);
                    }
                    int i28 = 0;
                    for (int i29 = 0; i29 < findStartPattern; i29++) {
                        i28 += this.counters[i29];
                    }
                    float f16 = i28;
                    while (findStartPattern < i17) {
                        i28 += this.counters[findStartPattern];
                        findStartPattern++;
                    }
                    float f17 = i3;
                    return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(f16, f17), new ResultPoint(i28, f17)}, BarcodeFormat.CODABAR);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        int i3 = 0;
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset < size) {
            boolean z16 = true;
            while (nextUnset < size) {
                if (bitArray.get(nextUnset) != z16) {
                    i3++;
                } else {
                    counterAppend(i3);
                    z16 = !z16;
                    i3 = 1;
                }
                nextUnset++;
            }
            counterAppend(i3);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int findStartPattern() throws NotFoundException {
        for (int i3 = 1; i3 < this.counterLength; i3 += 2) {
            int narrowWidePattern = toNarrowWidePattern(i3);
            if (narrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[narrowWidePattern])) {
                int i16 = 0;
                for (int i17 = i3; i17 < i3 + 7; i17++) {
                    i16 += this.counters[i17];
                }
                if (i3 == 1 || this.counters[i3 - 1] >= i16 / 2) {
                    return i3;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int toNarrowWidePattern(int i3) {
        int i16 = i3 + 7;
        if (i16 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i17 = Integer.MAX_VALUE;
        int i18 = 0;
        int i19 = Integer.MAX_VALUE;
        int i26 = 0;
        for (int i27 = i3; i27 < i16; i27 += 2) {
            int i28 = iArr[i27];
            if (i28 < i19) {
                i19 = i28;
            }
            if (i28 > i26) {
                i26 = i28;
            }
        }
        int i29 = (i19 + i26) / 2;
        int i36 = 0;
        for (int i37 = i3 + 1; i37 < i16; i37 += 2) {
            int i38 = iArr[i37];
            if (i38 < i17) {
                i17 = i38;
            }
            if (i38 > i36) {
                i36 = i38;
            }
        }
        int i39 = (i17 + i36) / 2;
        int i46 = 128;
        int i47 = 0;
        for (int i48 = 0; i48 < 7; i48++) {
            i46 >>= 1;
            if (iArr[i3 + i48] > ((i48 & 1) == 0 ? i29 : i39)) {
                i47 |= i46;
            }
        }
        while (true) {
            int[] iArr2 = CHARACTER_ENCODINGS;
            if (i18 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i18] == i47) {
                return i18;
            }
            i18++;
        }
    }

    static boolean arrayContains(char[] cArr, char c16) {
        if (cArr != null) {
            for (char c17 : cArr) {
                if (c17 == c16) {
                    return true;
                }
            }
        }
        return false;
    }

    private void validatePattern(int i3) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.decodeRowResult.length() - 1;
        int i16 = 0;
        int i17 = i3;
        int i18 = 0;
        while (true) {
            int i19 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i18)];
            for (int i26 = 6; i26 >= 0; i26--) {
                int i27 = (i26 & 1) + ((i19 & 1) * 2);
                iArr[i27] = iArr[i27] + this.counters[i17 + i26];
                iArr2[i27] = iArr2[i27] + 1;
                i19 >>= 1;
            }
            if (i18 >= length) {
                break;
            }
            i17 += 8;
            i18++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i28 = 0; i28 < 2; i28++) {
            fArr2[i28] = 0.0f;
            int i29 = i28 + 2;
            int i36 = iArr[i29];
            int i37 = iArr2[i29];
            float f16 = ((iArr[i28] / iArr2[i28]) + (i36 / i37)) / 2.0f;
            fArr2[i29] = f16;
            fArr[i28] = f16;
            fArr[i29] = ((i36 * 2.0f) + 1.5f) / i37;
        }
        int i38 = i3;
        loop3: while (true) {
            int i39 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i16)];
            for (int i46 = 6; i46 >= 0; i46--) {
                int i47 = (i46 & 1) + ((i39 & 1) * 2);
                float f17 = this.counters[i38 + i46];
                if (f17 < fArr2[i47] || f17 > fArr[i47]) {
                    break loop3;
                }
                i39 >>= 1;
            }
            if (i16 >= length) {
                return;
            }
            i38 += 8;
            i16++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
