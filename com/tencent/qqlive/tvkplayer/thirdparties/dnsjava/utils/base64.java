package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class base64 {
    private static final String Base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    private static final String Base64Url = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    base64() {
    }

    public static String formatString(byte[] bArr, int i3, String str, boolean z16) {
        String base64Var = toString(bArr);
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < base64Var.length()) {
            sb5.append(str);
            int i17 = i16 + i3;
            if (i17 >= base64Var.length()) {
                sb5.append(base64Var.substring(i16));
                if (z16) {
                    sb5.append(" )");
                }
            } else {
                sb5.append((CharSequence) base64Var, i16, i17);
                sb5.append("\n");
            }
            i16 = i17;
        }
        return sb5.toString();
    }

    public static byte[] fromString(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        for (byte b16 : str.getBytes()) {
            if (!Character.isWhitespace((char) b16)) {
                byteArrayOutputStream.write(b16);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length % 4 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i16 = 0;
        while (i16 < (byteArray.length + 3) / 4) {
            short[] sArr = new short[4];
            short[] sArr2 = new short[3];
            for (int i17 = i3; i17 < 4; i17++) {
                sArr[i17] = (short) Base64.indexOf(byteArray[(i16 * 4) + i17]);
            }
            int i18 = sArr[i3] << 2;
            short s16 = sArr[1];
            sArr2[i3] = (short) (i18 + (s16 >> 4));
            short s17 = sArr[2];
            if (s17 == 64) {
                sArr2[2] = -1;
                sArr2[1] = -1;
                if ((sArr[1] & 15) != 0) {
                    return null;
                }
            } else {
                short s18 = sArr[3];
                if (s18 == 64) {
                    sArr2[1] = (short) (((s16 << 4) + (s17 >> 2)) & 255);
                    sArr2[2] = -1;
                    if ((sArr[2] & 3) != 0) {
                        return null;
                    }
                } else {
                    sArr2[1] = (short) (((s16 << 4) + (s17 >> 2)) & 255);
                    sArr2[2] = (short) (((s17 << 6) + s18) & 255);
                }
            }
            for (int i19 = 0; i19 < 3; i19++) {
                try {
                    short s19 = sArr2[i19];
                    if (s19 >= 0) {
                        dataOutputStream.writeByte(s19);
                    }
                } catch (IOException unused) {
                }
            }
            i16++;
            i3 = 0;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(byte[] bArr) {
        return toString(bArr, false);
    }

    public static String toString(byte[] bArr, boolean z16) {
        String str = z16 ? Base64Url : Base64;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; i3 < (bArr.length + 2) / 3; i3++) {
            short[] sArr = new short[3];
            short[] sArr2 = new short[4];
            for (int i16 = 0; i16 < 3; i16++) {
                int i17 = (i3 * 3) + i16;
                if (i17 < bArr.length) {
                    sArr[i16] = (short) (bArr[i17] & 255);
                } else {
                    sArr[i16] = -1;
                }
            }
            sArr2[0] = (short) (sArr[0] >> 2);
            short s16 = sArr[1];
            if (s16 == -1) {
                sArr2[1] = (short) ((sArr[0] & 3) << 4);
            } else {
                sArr2[1] = (short) (((sArr[0] & 3) << 4) + (s16 >> 4));
            }
            short s17 = sArr[1];
            if (s17 == -1) {
                sArr2[3] = 64;
                sArr2[2] = 64;
            } else {
                short s18 = sArr[2];
                if (s18 == -1) {
                    sArr2[2] = (short) ((s17 & 15) << 2);
                    sArr2[3] = 64;
                } else {
                    sArr2[2] = (short) (((s17 & 15) << 2) + (s18 >> 6));
                    sArr2[3] = (short) (sArr[2] & 63);
                }
            }
            for (int i18 = 0; i18 < 4; i18++) {
                short s19 = sArr2[i18];
                if (s19 != 64 || !z16) {
                    byteArrayOutputStream.write(str.charAt(s19));
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
