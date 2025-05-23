package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.utils;

import java.io.ByteArrayOutputStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class base16 {
    private static final String BASE_16_CHARS = "0123456789ABCDEF";

    base16() {
    }

    public static byte[] fromString(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if ((charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'F')) {
                byteArrayOutputStream.write(charAt);
            } else if (charAt >= 'a' && charAt <= 'f') {
                byteArrayOutputStream.write(charAt - ' ');
            } else if (!Character.isWhitespace(charAt)) {
                return null;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if ((byteArray.length & 1) != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        for (int i16 = 0; i16 < byteArray.length; i16 += 2) {
            byteArrayOutputStream.write((((byte) BASE_16_CHARS.indexOf(byteArray[i16])) << 4) + (((byte) BASE_16_CHARS.indexOf(byteArray[i16 + 1])) & RegisterType.DOUBLE_HI));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            short s16 = (short) (b16 & 255);
            sb5.append(BASE_16_CHARS.charAt((byte) (s16 >> 4)));
            sb5.append(BASE_16_CHARS.charAt((byte) (s16 & 15)));
        }
        return sb5.toString();
    }
}
