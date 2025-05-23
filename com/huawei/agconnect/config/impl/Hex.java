package com.huawei.agconnect.config.impl;

import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Hex {
    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();

    private static byte[] decodeHex(char[] cArr) {
        if ((cArr.length & 1) == 0) {
            byte[] bArr = new byte[cArr.length >> 1];
            int i3 = 0;
            int i16 = 0;
            while (i3 < cArr.length) {
                int digit = Character.digit(cArr[i3], 16);
                if (digit != -1) {
                    int i17 = i3 + 1;
                    int digit2 = Character.digit(cArr[i17], 16);
                    if (digit2 != -1) {
                        i3 = i17 + 1;
                        bArr[i16] = (byte) (((digit << 4) | digit2) & 255);
                        i16++;
                    } else {
                        throw new IllegalArgumentException("Illegal hexadecimal character at index " + i17);
                    }
                } else {
                    throw new IllegalArgumentException("Illegal hexadecimal character at index " + i3);
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static byte[] decodeHexString(String str) {
        return decodeHex(str.toCharArray());
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            char[] cArr = HEX_CODE;
            sb5.append(cArr[(b16 >> 4) & 15]);
            sb5.append(cArr[b16 & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
