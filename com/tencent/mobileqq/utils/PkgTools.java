package com.tencent.mobileqq.utils;

/* loaded from: classes20.dex */
public class PkgTools {
    public static void DWord2Byte(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 24);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 3] = (byte) j3;
    }

    public static void copyData(byte[] bArr, int i3, byte[] bArr2, int i16) {
        copyData(bArr, i3, bArr2, 0, i16);
    }

    public static void copyData(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        System.arraycopy(bArr2, i16, bArr, i3, i17);
    }
}
