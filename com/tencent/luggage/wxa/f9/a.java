package com.tencent.luggage.wxa.f9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static short a(byte b16, byte b17, boolean z16) {
        int i3;
        if (z16) {
            i3 = ((short) (((short) ((b16 & 255) | 0)) << 8)) | (b17 & 255);
        } else {
            i3 = (b16 & 255) | ((short) (((short) ((b17 & 255) | 0)) << 8));
        }
        return (short) i3;
    }

    public static byte[] a(short s16, boolean z16) {
        byte[] bArr = new byte[2];
        if (z16) {
            bArr[1] = (byte) (s16 & 255);
            bArr[0] = (byte) (((short) (s16 >> 8)) & 255);
        } else {
            bArr[0] = (byte) (s16 & 255);
            bArr[1] = (byte) (((short) (s16 >> 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(byte b16, byte b17, byte b18, byte b19, boolean z16) {
        return a((short) ((a(b16, b17, z16) / 2) + (a(b18, b19, z16) / 2)), z16);
    }

    public static short[] a(byte[] bArr, int i3) {
        int i16 = i3 / 2;
        short[] sArr = new short[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = i17 * 2;
            sArr[i17] = (short) (((bArr[i18 + 1] & 255) << 8) | (bArr[i18] & 255));
        }
        return sArr;
    }

    public static byte[] a(short[] sArr) {
        byte[] bArr = new byte[sArr.length << 1];
        for (int i3 = 0; i3 < sArr.length; i3++) {
            int i16 = i3 * 2;
            short s16 = sArr[i3];
            bArr[i16] = (byte) (s16 & 255);
            bArr[i16 + 1] = (byte) ((s16 & 65280) >> 8);
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, double d16) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = (byte) (bArr[i3] * d16);
        }
        return bArr;
    }
}
