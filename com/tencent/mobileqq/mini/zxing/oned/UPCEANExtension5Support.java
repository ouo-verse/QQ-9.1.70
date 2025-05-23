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
public final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
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
        for (int i17 = 0; i17 < 5 && i3 < size; i17++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i3, UPCEANReader.L_AND_G_PATTERNS);
            sb5.append((char) ((decodeDigit % 10) + 48));
            for (int i18 : iArr2) {
                i3 += i18;
            }
            if (decodeDigit >= 10) {
                i16 |= 1 << (4 - i17);
            }
            if (i17 != 4) {
                i3 = bitArray.getNextUnset(bitArray.getNextSet(i3));
            }
        }
        if (sb5.length() == 5) {
            if (extensionChecksum(sb5.toString()) == determineCheckDigit(i16)) {
                return i3;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        for (int i16 = length - 2; i16 >= 0; i16 -= 2) {
            i3 += charSequence.charAt(i16) - '0';
        }
        int i17 = i3 * 3;
        for (int i18 = length - 1; i18 >= 0; i18 -= 2) {
            i17 += charSequence.charAt(i18) - '0';
        }
        return (i17 * 3) % 10;
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        String parseExtension5String;
        if (str.length() != 5 || (parseExtension5String = parseExtension5String(str)) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ResultMetadataType.SUGGESTED_PRICE, parseExtension5String);
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

    private static String parseExtension5String(String str) {
        String str2;
        String valueOf;
        char charAt = str.charAt(0);
        if (charAt == '0') {
            str2 = "\u00a3";
        } else if (charAt != '5') {
            str2 = "";
            if (charAt == '9') {
                if ("90000".equals(str)) {
                    return null;
                }
                if ("99991".equals(str)) {
                    return "0.00";
                }
                if ("99990".equals(str)) {
                    return "Used";
                }
            }
        } else {
            str2 = "$";
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf2 = String.valueOf(parseInt / 100);
        int i3 = parseInt % 100;
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = String.valueOf(i3);
        }
        return str2 + valueOf2 + '.' + valueOf;
    }

    private static int determineCheckDigit(int i3) throws NotFoundException {
        for (int i16 = 0; i16 < 10; i16++) {
            if (i3 == CHECK_DIGIT_ENCODINGS[i16]) {
                return i16;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
