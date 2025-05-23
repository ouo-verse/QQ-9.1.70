package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.common.BitArray;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class EAN8Reader extends UPCEANReader {
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
        for (int i16 = 0; i16 < 4 && i3 < size; i16++) {
            sb5.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i3, UPCEANReader.L_PATTERNS) + 48));
            for (int i17 : iArr2) {
                i3 += i17;
            }
        }
        int i18 = UPCEANReader.findGuardPattern(bitArray, i3, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i19 = 0; i19 < 4 && i18 < size; i19++) {
            sb5.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i18, UPCEANReader.L_PATTERNS) + 48));
            for (int i26 : iArr2) {
                i18 += i26;
            }
        }
        return i18;
    }

    @Override // com.tencent.mobileqq.mini.zxing.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
