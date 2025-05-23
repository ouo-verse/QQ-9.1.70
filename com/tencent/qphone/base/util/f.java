package com.tencent.qphone.base.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    f() {
    }

    public static void a(byte[] bArr, int i3, byte[] bArr2, int i16) {
        a(bArr, i3, bArr2, 0, i16);
    }

    public static void a(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        System.arraycopy(bArr2, i16, bArr, i3, i17);
    }

    public static void a(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 24);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 3] = (byte) j3;
    }
}
