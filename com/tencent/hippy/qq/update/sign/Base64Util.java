package com.tencent.hippy.qq.update.sign;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.text.EmotcationConstants;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Base64Util {
    private static final char last2byte = (char) Integer.parseInt("00000011", 2);
    private static final char last4byte = (char) Integer.parseInt("00001111", 2);
    private static final char last6byte = (char) Integer.parseInt("00111111", 2);
    private static final char lead6byte = (char) Integer.parseInt("11111100", 2);
    private static final char lead4byte = (char) Integer.parseInt("11110000", 2);
    private static final char lead2byte = (char) Integer.parseInt("11000000", 2);
    private static final char[] encodeTable = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String encode(byte[] bArr) {
        int i3;
        int i16;
        StringBuilder sb5 = new StringBuilder(((int) (bArr.length * 1.34d)) + 3);
        int i17 = 0;
        char c16 = 0;
        for (int i18 = 0; i18 < bArr.length; i18++) {
            i17 %= 8;
            while (i17 < 8) {
                if (i17 != 0) {
                    if (i17 != 2) {
                        if (i17 != 4) {
                            if (i17 == 6) {
                                c16 = (char) (((char) (bArr[i18] & last2byte)) << 4);
                                int i19 = i18 + 1;
                                if (i19 < bArr.length) {
                                    i16 = (bArr[i19] & lead4byte) >>> 4;
                                    i3 = c16 | i16;
                                }
                            }
                            sb5.append(encodeTable[c16]);
                            i17 += 6;
                        } else {
                            c16 = (char) (((char) (bArr[i18] & last4byte)) << 2);
                            int i26 = i18 + 1;
                            if (i26 < bArr.length) {
                                i16 = (bArr[i26] & lead2byte) >>> 6;
                                i3 = c16 | i16;
                            } else {
                                sb5.append(encodeTable[c16]);
                                i17 += 6;
                            }
                        }
                    } else {
                        i3 = bArr[i18] & last6byte;
                    }
                } else {
                    i3 = ((char) (bArr[i18] & lead6byte)) >>> 2;
                }
                c16 = (char) i3;
                sb5.append(encodeTable[c16]);
                i17 += 6;
            }
        }
        if (sb5.length() % 4 != 0) {
            for (int length = 4 - (sb5.length() % 4); length > 0; length--) {
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            }
        }
        return sb5.toString();
    }
}
