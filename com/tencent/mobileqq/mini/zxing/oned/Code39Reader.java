package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import com.tencent.view.FilterEnum;
import java.util.Arrays;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Code39Reader extends OneDReader {
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    static final int ASTERISK_ENCODING = 148;
    static final int[] CHARACTER_ENCODINGS = {52, FilterEnum.MIC_PTU_ZIRAN, 97, g.CTRL_INDEX, 49, 304, 112, 37, 292, 100, 265, 73, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 25, FilterEnum.MIC_PTU_TRANS_XINXIAN, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, TroopInfo.PAY_PRIVILEGE_ALL, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    public Code39Reader() {
        this(false);
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i3;
        char c16;
        int length = charSequence.length();
        StringBuilder sb5 = new StringBuilder(length);
        int i16 = 0;
        while (i16 < length) {
            char charAt = charSequence.charAt(i16);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb5.append(charAt);
            } else {
                i16++;
                char charAt2 = charSequence.charAt(i16);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i3 = charAt2 - ' ';
                                } else {
                                    if (charAt2 != 'Z') {
                                        throw FormatException.getFormatInstance();
                                    }
                                    c16 = ':';
                                    sb5.append(c16);
                                }
                            }
                            c16 = 0;
                            sb5.append(c16);
                        } else {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i3 = charAt2 + TokenParser.SP;
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i3 = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i3 = charAt2 - 11;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i3 = charAt2 + 16;
                    } else if (charAt2 < 'P' || charAt2 > 'T') {
                        if (charAt2 != 'U') {
                            if (charAt2 == 'V') {
                                c16 = '@';
                            } else if (charAt2 == 'W') {
                                c16 = '`';
                            } else {
                                if (charAt2 != 'X' && charAt2 != 'Y' && charAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c16 = '\u007f';
                            }
                            sb5.append(c16);
                        }
                        c16 = 0;
                        sb5.append(c16);
                    } else {
                        i3 = charAt2 + '+';
                    }
                } else {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i3 = charAt2 - '@';
                }
                c16 = (char) i3;
                sb5.append(c16);
            }
            i16++;
        }
        return sb5.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        boolean z16 = false;
        int i3 = 0;
        int i16 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z16) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (toNarrowWidePattern(iArr) == 148 && bitArray.isRange(Math.max(0, i16 - ((nextSet - i16) / 2)), i16, false)) {
                        return new int[]{i16, nextSet};
                    }
                    i16 += iArr[0] + iArr[1];
                    int i17 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i17);
                    iArr[i17] = 0;
                    iArr[i3] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z16 = !z16;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i16 = Integer.MAX_VALUE;
            for (int i17 : iArr) {
                if (i17 < i16 && i17 > i3) {
                    i16 = i17;
                }
            }
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            for (int i27 = 0; i27 < length; i27++) {
                int i28 = iArr[i27];
                if (i28 > i16) {
                    i19 |= 1 << ((length - 1) - i27);
                    i18++;
                    i26 += i28;
                }
            }
            if (i18 == 3) {
                for (int i29 = 0; i29 < length && i18 > 0; i29++) {
                    int i36 = iArr[i29];
                    if (i36 > i16) {
                        i18--;
                        if (i36 * 2 >= i26) {
                            return -1;
                        }
                    }
                }
                return i19;
            }
            if (i18 <= 3) {
                return -1;
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader
    public Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        String sb5;
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb6 = this.decodeRowResult;
        sb6.setLength(0);
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray, iArr)[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern >= 0) {
                char patternToChar = patternToChar(narrowWidePattern);
                sb6.append(patternToChar);
                int i16 = nextSet;
                for (int i17 : iArr) {
                    i16 += i17;
                }
                int nextSet2 = bitArray.getNextSet(i16);
                if (patternToChar == '*') {
                    sb6.setLength(sb6.length() - 1);
                    int i18 = 0;
                    for (int i19 : iArr) {
                        i18 += i19;
                    }
                    int i26 = (nextSet2 - nextSet) - i18;
                    if (nextSet2 != size && i26 * 2 < i18) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (this.usingCheckDigit) {
                        int length = sb6.length() - 1;
                        int i27 = 0;
                        for (int i28 = 0; i28 < length; i28++) {
                            i27 += ALPHABET_STRING.indexOf(this.decodeRowResult.charAt(i28));
                        }
                        if (sb6.charAt(length) == ALPHABET_STRING.charAt(i27 % 43)) {
                            sb6.setLength(length);
                        } else {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                    if (sb6.length() != 0) {
                        if (this.extendedMode) {
                            sb5 = decodeExtended(sb6);
                        } else {
                            sb5 = sb6.toString();
                        }
                        float f16 = i3;
                        return new Result(sb5, null, new ResultPoint[]{new ResultPoint((r2[1] + r2[0]) / 2.0f, f16), new ResultPoint(nextSet + (i18 / 2.0f), f16)}, BarcodeFormat.CODE_39);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public Code39Reader(boolean z16) {
        this(z16, false);
    }

    private static char patternToChar(int i3) throws NotFoundException {
        int i16 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i16 >= iArr.length) {
                if (i3 == 148) {
                    return '*';
                }
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i16] == i3) {
                return ALPHABET_STRING.charAt(i16);
            }
            i16++;
        }
    }

    public Code39Reader(boolean z16, boolean z17) {
        this.usingCheckDigit = z16;
        this.extendedMode = z17;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }
}
