package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ip {
    public static int a(byte[] bArr) {
        if (bArr.length == 4) {
            return (bArr[3] & 255) | 0 | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        throw new IllegalArgumentException("the length of bytes must be 4");
    }

    public static byte[] b(int i3) {
        return new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3};
    }
}
