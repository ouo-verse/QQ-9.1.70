package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import com.tencent.mobileqq.msf.core.d;

/* loaded from: classes33.dex */
public final class UPCEReader extends UPCEANReader {
    private static final int[] MIDDLE_END_PATTERN = {1, 1, 1, 1, 1, 1};
    static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] decodeMiddleCounters = new int[4];

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    public boolean checkChecksum(String str) throws FormatException {
        return super.checkChecksum(convertUPCEtoUPCA(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb5) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i3 = iArr[1];
        int i16 = 0;
        for (int i17 = 0; i17 < 6 && i3 < size; i17++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i3, UPCEANReader.L_AND_G_PATTERNS);
            sb5.append((char) ((decodeDigit % 10) + 48));
            for (int i18 : iArr2) {
                i3 += i18;
            }
            if (decodeDigit >= 10) {
                i16 |= 1 << (5 - i17);
            }
        }
        determineNumSysAndCheckDigit(sb5, i16);
        return i3;
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_E;
    }

    public static String convertUPCEtoUPCA(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb5 = new StringBuilder(12);
        sb5.append(str.charAt(0));
        char c16 = cArr[5];
        switch (c16) {
            case '0':
            case '1':
            case '2':
                sb5.append(cArr, 0, 2);
                sb5.append(c16);
                sb5.append("0000");
                sb5.append(cArr, 2, 3);
                break;
            case '3':
                sb5.append(cArr, 0, 3);
                sb5.append(d.f247921x);
                sb5.append(cArr, 3, 2);
                break;
            case '4':
                sb5.append(cArr, 0, 4);
                sb5.append(d.f247921x);
                sb5.append(cArr[4]);
                break;
            default:
                sb5.append(cArr, 0, 5);
                sb5.append("0000");
                sb5.append(c16);
                break;
        }
        if (str.length() >= 8) {
            sb5.append(str.charAt(7));
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    protected int[] decodeEnd(BitArray bitArray, int i3) throws NotFoundException {
        return UPCEANReader.findGuardPattern(bitArray, i3, true, MIDDLE_END_PATTERN);
    }

    private static void determineNumSysAndCheckDigit(StringBuilder sb5, int i3) throws NotFoundException {
        for (int i16 = 0; i16 <= 1; i16++) {
            for (int i17 = 0; i17 < 10; i17++) {
                if (i3 == NUMSYS_AND_CHECK_DIGIT_PATTERNS[i16][i17]) {
                    sb5.insert(0, (char) (i16 + 48));
                    sb5.append((char) (i17 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
