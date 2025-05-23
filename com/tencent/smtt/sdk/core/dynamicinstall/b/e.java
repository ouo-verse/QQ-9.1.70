package com.tencent.smtt.sdk.core.dynamicinstall.b;

import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes23.dex */
public class e {
    public static byte[] a(byte[] bArr, int i3, int i16) {
        if (i3 < bArr.length) {
            byte[] bArr2 = new byte[Math.min(i16, bArr.length - i3)];
            System.arraycopy(bArr, i3, bArr2, 0, i16);
            return bArr2;
        }
        throw new IllegalStateException("Index of bound. Size: " + bArr.length + "; index: " + i3);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }
}
