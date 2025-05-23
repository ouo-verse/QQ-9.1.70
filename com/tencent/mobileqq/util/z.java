package com.tencent.mobileqq.util;

/* compiled from: P */
/* loaded from: classes20.dex */
public class z {
    public static int a(byte b16) {
        return b16 & 255;
    }

    public static byte[] b(int i3) {
        byte[] bArr = new byte[4];
        for (int i16 = 0; i16 < 4; i16++) {
            bArr[i16] = Integer.valueOf(i3 >>> 24).byteValue();
            i3 <<= 8;
        }
        return bArr;
    }

    public static byte[] c(short s16) {
        return new byte[]{(byte) (s16 >>> 8), (byte) s16};
    }

    public static byte[] d(int i3) {
        return new byte[]{(byte) ((i3 & (-16777216)) >> 24), (byte) ((16711680 & i3) >> 16), (byte) ((65280 & i3) >> 8), (byte) (i3 & 255)};
    }

    public static int e(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            i3 = (i3 << 8) | a(bArr[i16]);
        }
        return i3;
    }

    public static int f(byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = i3; i17 < i3 + 4; i17++) {
            i16 = (i16 << 8) | a(bArr[i17]);
        }
        return i16;
    }

    public static short g(byte[] bArr) {
        short s16 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            s16 = (short) (((short) (s16 << 8)) | a(bArr[i3]));
        }
        return s16;
    }
}
