package com.tencent.smtt.utils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ByteUtils {
    public static void Word2Byte(byte[] bArr, int i3, short s16) {
        bArr[i3] = (byte) (s16 >> 8);
        bArr[i3 + 1] = (byte) s16;
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if ((bArr[i3] & 255) < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Long.toString(bArr[i3] & 255, 16));
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static byte[] subByte(byte[] bArr, int i3, int i16) {
        int length = bArr.length;
        if (i3 >= 0 && i3 + i16 <= length) {
            if (i16 < 0) {
                i16 = bArr.length - i3;
            }
            byte[] bArr2 = new byte[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                bArr2[i17] = bArr[i17 + i3];
            }
            return bArr2;
        }
        return null;
    }
}
