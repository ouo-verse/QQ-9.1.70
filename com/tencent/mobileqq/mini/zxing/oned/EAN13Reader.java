package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.common.BitArray;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class EAN13Reader extends UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

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
        determineFirstDigit(sb5, i16);
        int i19 = UPCEANReader.findGuardPattern(bitArray, i3, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i26 = 0; i26 < 6 && i19 < size; i26++) {
            sb5.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i19, UPCEANReader.L_PATTERNS) + 48));
            for (int i27 : iArr2) {
                i19 += i27;
            }
        }
        return i19;
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }

    private static void determineFirstDigit(StringBuilder sb5, int i3) throws NotFoundException {
        for (int i16 = 0; i16 < 10; i16++) {
            if (i3 == FIRST_DIGIT_ENCODINGS[i16]) {
                sb5.insert(0, (char) (i16 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
