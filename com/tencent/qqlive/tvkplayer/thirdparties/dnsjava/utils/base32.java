package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class base32 {
    private final String alphabet;
    private final boolean lowercase;
    private final boolean padding;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Alphabet {
        public static final String BASE32 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=";
        public static final String BASE32HEX = "0123456789ABCDEFGHIJKLMNOPQRSTUV=";

        Alphabet() {
        }
    }

    public base32(String str, boolean z16, boolean z17) {
        this.alphabet = str;
        this.padding = z16;
        this.lowercase = z17;
    }

    private static int blockLenToPadding(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 4;
            }
            if (i3 == 3) {
                return 3;
            }
            if (i3 == 4) {
                return 1;
            }
            if (i3 != 5) {
                return -1;
            }
            return 0;
        }
        return 6;
    }

    private static int paddingToBlockLen(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return 4;
            }
            if (i3 == 3) {
                return 3;
            }
            if (i3 != 4) {
                if (i3 == 6) {
                    return 1;
                }
                return -1;
            }
            return 2;
        }
        return 5;
    }

    public byte[] fromString(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b16 : str.getBytes()) {
            char c16 = (char) b16;
            if (!Character.isWhitespace(c16)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c16));
            }
        }
        if (this.padding) {
            if (byteArrayOutputStream.size() % 8 != 0) {
                return null;
            }
        } else {
            while (byteArrayOutputStream.size() % 8 != 0) {
                byteArrayOutputStream.write(61);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i3 = 0; i3 < byteArray.length / 8; i3++) {
            short[] sArr = new short[8];
            int[] iArr = new int[5];
            int i16 = 8;
            for (int i17 = 0; i17 < 8; i17++) {
                byte b17 = byteArray[(i3 * 8) + i17];
                if (((char) b17) == '=') {
                    break;
                }
                short indexOf = (short) this.alphabet.indexOf(b17);
                sArr[i17] = indexOf;
                if (indexOf < 0) {
                    return null;
                }
                i16--;
            }
            int paddingToBlockLen = paddingToBlockLen(i16);
            if (paddingToBlockLen < 0) {
                return null;
            }
            int i18 = sArr[0] << 3;
            short s16 = sArr[1];
            iArr[0] = i18 | (s16 >> 2);
            int i19 = ((s16 & 3) << 6) | (sArr[2] << 1);
            short s17 = sArr[3];
            iArr[1] = i19 | (s17 >> 4);
            int i26 = (s17 & 15) << 4;
            short s18 = sArr[4];
            iArr[2] = i26 | ((s18 >> 1) & 15);
            int i27 = (s18 << 7) | (sArr[5] << 2);
            short s19 = sArr[6];
            iArr[3] = i27 | (s19 >> 3);
            iArr[4] = sArr[7] | ((s19 & 7) << 5);
            for (int i28 = 0; i28 < paddingToBlockLen; i28++) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i28] & 255));
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString(byte[] bArr) {
        int i3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i16 = 0; i16 < (bArr.length + 4) / 5; i16++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i17 = 5;
            for (int i18 = 0; i18 < 5; i18++) {
                int i19 = (i16 * 5) + i18;
                if (i19 < bArr.length) {
                    sArr[i18] = (short) (bArr[i19] & 255);
                } else {
                    sArr[i18] = 0;
                    i17--;
                }
            }
            int blockLenToPadding = blockLenToPadding(i17);
            short s16 = sArr[0];
            iArr[0] = (byte) ((s16 >> 3) & 31);
            short s17 = sArr[1];
            iArr[1] = (byte) (((s16 & 7) << 2) | ((s17 >> 6) & 3));
            iArr[2] = (byte) ((s17 >> 1) & 31);
            short s18 = sArr[2];
            iArr[3] = (byte) (((s17 & 1) << 4) | ((s18 >> 4) & 15));
            int i26 = (s18 & 15) << 1;
            short s19 = sArr[3];
            iArr[4] = (byte) (i26 | (1 & (s19 >> 7)));
            iArr[5] = (byte) ((s19 >> 2) & 31);
            short s26 = sArr[4];
            iArr[6] = (byte) (((s26 >> 5) & 7) | ((s19 & 3) << 3));
            iArr[7] = (byte) (s26 & 31);
            int i27 = 0;
            while (true) {
                i3 = 8 - blockLenToPadding;
                if (i27 >= i3) {
                    break;
                }
                char charAt = this.alphabet.charAt(iArr[i27]);
                if (this.lowercase) {
                    charAt = Character.toLowerCase(charAt);
                }
                byteArrayOutputStream.write(charAt);
                i27++;
            }
            if (this.padding) {
                while (i3 < 8) {
                    byteArrayOutputStream.write(61);
                    i3++;
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
