package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int decodeCode(BitArray bitArray, int[] iArr, int i3) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i3, iArr);
        float f16 = 0.25f;
        int i16 = -1;
        int i17 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i17 >= iArr2.length) {
                break;
            }
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i17], 0.7f);
            if (patternMatchVariance < f16) {
                i16 = i17;
                f16 = patternMatchVariance;
            }
            i17++;
        }
        if (i16 >= 0) {
            return i16;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        boolean z16 = false;
        int i3 = 0;
        int i16 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z16) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 5) {
                    int i17 = -1;
                    float f16 = 0.25f;
                    for (int i18 = 103; i18 <= 105; i18++) {
                        float patternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i18], 0.7f);
                        if (patternMatchVariance < f16) {
                            i17 = i18;
                            f16 = patternMatchVariance;
                        }
                    }
                    if (i17 >= 0 && bitArray.isRange(Math.max(0, i16 - ((nextSet - i16) / 2)), i16, false)) {
                        return new int[]{i16, nextSet, i17};
                    }
                    i16 += iArr[0] + iArr[1];
                    int i19 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i19);
                    iArr[i19] = 0;
                    iArr[i3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z16 = !z16;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0088. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x00c3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:78:0x0110. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013e A[PHI: r17
  0x013e: PHI (r17v9 boolean) = (r17v5 boolean), (r17v13 boolean) binds: [B:78:0x0110, B:50:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125 A[FALL_THROUGH, PHI: r17
  0x0125: PHI (r17v8 boolean) = 
  (r17v5 boolean)
  (r17v5 boolean)
  (r17v5 boolean)
  (r17v5 boolean)
  (r17v13 boolean)
  (r17v13 boolean)
  (r17v13 boolean)
  (r17v13 boolean)
 binds: [B:78:0x0110, B:79:0x0114, B:83:0x0120, B:82:0x011c, B:50:0x00c3, B:51:0x00c8, B:55:0x00d4, B:54:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.tencent.mobileqq.mini.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decodeRow(int i3, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        char c16;
        char c17;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        boolean z26 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] findStartPattern = findStartPattern(bitArray);
        int i16 = findStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i16));
        switch (i16) {
            case 103:
                c16 = 'e';
                break;
            case 104:
                c16 = 'd';
                break;
            case 105:
                c16 = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb5 = new StringBuilder(20);
        int i17 = 6;
        int[] iArr = new int[6];
        boolean z27 = false;
        boolean z28 = false;
        boolean z29 = false;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        boolean z36 = true;
        char c18 = c16;
        int i27 = findStartPattern[0];
        int i28 = findStartPattern[1];
        char c19 = c18;
        while (!z28) {
            int decodeCode = decodeCode(bitArray, iArr, i28);
            arrayList.add(Byte.valueOf((byte) decodeCode));
            if (decodeCode != 106) {
                z36 = true;
            }
            if (decodeCode != 106) {
                i19++;
                i16 += i19 * decodeCode;
            }
            int i29 = i28;
            for (int i36 = 0; i36 < i17; i36++) {
                i29 += iArr[i36];
            }
            switch (decodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c19) {
                        case 'c':
                            c17 = 'd';
                            if (decodeCode >= 100) {
                                if (decodeCode != 106) {
                                    z36 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 100:
                                            c19 = 'd';
                                            break;
                                        case 101:
                                            z16 = false;
                                            c19 = 'e';
                                            break;
                                        case 102:
                                            if (z26) {
                                                if (sb5.length() == 0) {
                                                    sb5.append("]C1");
                                                    break;
                                                } else {
                                                    sb5.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z16 = false;
                                    z28 = true;
                                    break;
                                }
                            } else {
                                if (decodeCode < 10) {
                                    sb5.append('0');
                                }
                                sb5.append(decodeCode);
                            }
                            z16 = false;
                            break;
                        case 'd':
                            if (decodeCode < 96) {
                                if (z27 == z19) {
                                    sb5.append((char) (decodeCode + 32));
                                } else {
                                    sb5.append((char) (decodeCode + 32 + 128));
                                }
                                z16 = false;
                                z27 = false;
                                c17 = 'd';
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z36 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 98:
                                            z17 = z19;
                                            z18 = true;
                                            c19 = 'e';
                                            break;
                                        case 99:
                                            z17 = z19;
                                            z18 = false;
                                            c19 = 'c';
                                            break;
                                        case 100:
                                            if (z19 || !z27) {
                                                if (z19 && z27) {
                                                    z18 = false;
                                                    z17 = false;
                                                }
                                                z17 = z19;
                                                z18 = false;
                                                z27 = true;
                                                break;
                                            } else {
                                                z18 = false;
                                                z17 = true;
                                            }
                                            z27 = false;
                                            break;
                                        case 101:
                                            z17 = z19;
                                            z18 = false;
                                            c19 = 'e';
                                            break;
                                        case 102:
                                            if (z26) {
                                                if (sb5.length() == 0) {
                                                    sb5.append("]C1");
                                                } else {
                                                    sb5.append((char) 29);
                                                }
                                            }
                                        default:
                                            z17 = z19;
                                            z18 = false;
                                            break;
                                    }
                                    c17 = 'd';
                                    boolean z37 = z17;
                                    z16 = z18;
                                    z19 = z37;
                                    break;
                                }
                                z17 = z19;
                                z18 = false;
                                z28 = true;
                                c17 = 'd';
                                boolean z372 = z17;
                                z16 = z18;
                                z19 = z372;
                            }
                        case 'e':
                            if (decodeCode < 64) {
                                if (z27 == z19) {
                                    sb5.append((char) (decodeCode + 32));
                                } else {
                                    sb5.append((char) (decodeCode + 32 + 128));
                                }
                            } else if (decodeCode >= 96) {
                                if (decodeCode != 106) {
                                    z36 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 98:
                                            z17 = z19;
                                            z18 = true;
                                            c19 = 'd';
                                            break;
                                        case 100:
                                            z17 = z19;
                                            z18 = false;
                                            c19 = 'd';
                                            break;
                                        case 101:
                                            if (z19 || !z27) {
                                                if (z19 && z27) {
                                                    z18 = false;
                                                    z17 = false;
                                                }
                                                z17 = z19;
                                                z18 = false;
                                                z27 = true;
                                                break;
                                            } else {
                                                z18 = false;
                                                z17 = true;
                                            }
                                            z27 = false;
                                            break;
                                        case 102:
                                            if (z26) {
                                                if (sb5.length() == 0) {
                                                    sb5.append("]C1");
                                                } else {
                                                    sb5.append((char) 29);
                                                }
                                            }
                                    }
                                    c17 = 'd';
                                    boolean z3722 = z17;
                                    z16 = z18;
                                    z19 = z3722;
                                    break;
                                }
                                z17 = z19;
                                z18 = false;
                                z28 = true;
                                c17 = 'd';
                                boolean z37222 = z17;
                                z16 = z18;
                                z19 = z37222;
                            } else if (z27 == z19) {
                                sb5.append((char) (decodeCode - 64));
                            } else {
                                sb5.append((char) (decodeCode + 64));
                            }
                            z16 = false;
                            z27 = false;
                            c17 = 'd';
                            break;
                        default:
                            c17 = 'd';
                            z16 = false;
                            break;
                    }
                    if (z29) {
                        c19 = c19 == 'e' ? c17 : 'e';
                    }
                    z29 = z16;
                    i17 = 6;
                    i27 = i28;
                    i28 = i29;
                    i26 = i18;
                    i18 = decodeCode;
            }
        }
        int i37 = i28 - i27;
        int nextUnset = bitArray.getNextUnset(i28);
        if (bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i27) / 2) + nextUnset), false)) {
            int i38 = i26;
            if ((i16 - (i19 * i38)) % 103 == i38) {
                int length = sb5.length();
                if (length != 0) {
                    if (length > 0 && z36) {
                        if (c19 == 'c') {
                            sb5.delete(length - 2, length);
                        } else {
                            sb5.delete(length - 1, length);
                        }
                    }
                    float f16 = (findStartPattern[1] + findStartPattern[0]) / 2.0f;
                    float f17 = i27 + (i37 / 2.0f);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i39 = 0; i39 < size; i39++) {
                        bArr[i39] = ((Byte) arrayList.get(i39)).byteValue();
                    }
                    float f18 = i3;
                    return new Result(sb5.toString(), bArr, new ResultPoint[]{new ResultPoint(f16, f18), new ResultPoint(f17, f18)}, BarcodeFormat.CODE_128);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw ChecksumException.getChecksumInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
