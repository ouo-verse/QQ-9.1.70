package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.luggage.wxa.kf.c;
import com.tencent.luggage.wxa.rf.d;
import com.tencent.luggage.wxa.rf.f;
import com.tencent.luggage.wxa.se.i;
import com.tencent.luggage.wxa.xd.m0;
import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.view.FilterEnum;
import java.util.Arrays;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Code93Reader extends OneDReader {
    static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private final StringBuilder decodeRowResult = new StringBuilder(20);
    private final int[] counters = new int[6];

    static {
        int[] iArr = {276, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, f.CTRL_INDEX, 308, FilterEnum.MIC_PTU_BAIXI, a.CTRL_INDEX, 332, 326, 300, 278, i.CTRL_INDEX, 434, 428, 422, 406, 410, 364, d.CTRL_INDEX, 310, 314, 302, c.d.CTRL_INDEX, m0.CTRL_INDEX, 458, 366, 374, 430, 294, 474, 470, 306, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    private static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0029. Please report as an issue. */
    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i3;
        char c16;
        int length = charSequence.length();
        StringBuilder sb5 = new StringBuilder(length);
        int i16 = 0;
        while (i16 < length) {
            char charAt = charSequence.charAt(i16);
            if (charAt < 'a' || charAt > 'd') {
                sb5.append(charAt);
            } else if (i16 < length - 1) {
                i16++;
                char charAt2 = charSequence.charAt(i16);
                switch (charAt) {
                    case 'a':
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i3 = charAt2 - '@';
                        c16 = (char) i3;
                        sb5.append(c16);
                        break;
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
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
                                    if (charAt2 < 'X' || charAt2 > 'Z') {
                                        throw FormatException.getFormatInstance();
                                    }
                                    c16 = '\u007f';
                                }
                                sb5.append(c16);
                                break;
                            }
                            c16 = 0;
                            sb5.append(c16);
                        } else {
                            i3 = charAt2 + '+';
                        }
                        c16 = (char) i3;
                        sb5.append(c16);
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i3 = charAt2 - ' ';
                            c16 = (char) i3;
                            sb5.append(c16);
                        } else {
                            if (charAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c16 = ':';
                            sb5.append(c16);
                            break;
                        }
                    case 'd':
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i3 = charAt2 + TokenParser.SP;
                        c16 = (char) i3;
                        sb5.append(c16);
                        break;
                        break;
                    default:
                        c16 = 0;
                        sb5.append(c16);
                        break;
                }
            } else {
                throw FormatException.getFormatInstance();
            }
            i16++;
        }
        return sb5.toString();
    }

    private int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
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
                    if (toPattern(iArr) == ASTERISK_ENCODING) {
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

    private static int toPattern(int[] iArr) {
        int i3 = 0;
        for (int i16 : iArr) {
            i3 += i16;
        }
        int length = iArr.length;
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            int round = Math.round((iArr[i18] * 9.0f) / i3);
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i18 & 1) == 0) {
                for (int i19 = 0; i19 < round; i19++) {
                    i17 = (i17 << 1) | 1;
                }
            } else {
                i17 <<= round;
            }
        }
        return i17;
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader
    public Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray)[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb5 = this.decodeRowResult;
        sb5.setLength(0);
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern >= 0) {
                char patternToChar = patternToChar(pattern);
                sb5.append(patternToChar);
                int i16 = nextSet;
                for (int i17 : iArr) {
                    i16 += i17;
                }
                int nextSet2 = bitArray.getNextSet(i16);
                if (patternToChar == '*') {
                    sb5.deleteCharAt(sb5.length() - 1);
                    int i18 = 0;
                    for (int i19 : iArr) {
                        i18 += i19;
                    }
                    if (nextSet2 != size && bitArray.get(nextSet2)) {
                        if (sb5.length() >= 2) {
                            checkChecksums(sb5);
                            sb5.setLength(sb5.length() - 2);
                            float f16 = i3;
                            return new Result(decodeExtended(sb5), null, new ResultPoint[]{new ResultPoint((r14[1] + r14[0]) / 2.0f, f16), new ResultPoint(nextSet + (i18 / 2.0f), f16)}, BarcodeFormat.CODE_93);
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static char patternToChar(int i3) throws NotFoundException {
        int i16 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i16 < iArr.length) {
                if (iArr[i16] == i3) {
                    return ALPHABET[i16];
                }
                i16++;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static void checkOneChecksum(CharSequence charSequence, int i3, int i16) throws ChecksumException {
        int i17 = 0;
        int i18 = 1;
        for (int i19 = i3 - 1; i19 >= 0; i19--) {
            i17 += ALPHABET_STRING.indexOf(charSequence.charAt(i19)) * i18;
            i18++;
            if (i18 > i16) {
                i18 = 1;
            }
        }
        if (charSequence.charAt(i3) != ALPHABET[i17 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
