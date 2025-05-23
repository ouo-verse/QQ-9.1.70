package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes33.dex */
public final class UPCEANExtension2Support {
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb5) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i3 = iArr[1];
        int i16 = 0;
        for (int i17 = 0; i17 < 2 && i3 < size; i17++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i3, UPCEANReader.L_AND_G_PATTERNS);
            sb5.append((char) ((decodeDigit % 10) + 48));
            for (int i18 : iArr2) {
                i3 += i18;
            }
            if (decodeDigit >= 10) {
                i16 |= 1 << (1 - i17);
            }
            if (i17 != 1) {
                i3 = bitArray.getNextUnset(bitArray.getNextSet(i3));
            }
        }
        if (sb5.length() == 2) {
            if (Integer.parseInt(sb5.toString()) % 4 == i16) {
                return i3;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        if (str.length() != 2) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Result decodeRow(int i3, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb5 = this.decodeRowStringBuffer;
        sb5.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb5);
        String sb6 = sb5.toString();
        Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(sb6);
        float f16 = i3;
        Result result = new Result(sb6, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f16), new ResultPoint(decodeMiddle, f16)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }
}
