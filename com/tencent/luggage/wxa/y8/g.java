package com.tencent.luggage.wxa.y8;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class g {
    public static int a(byte[] bArr) {
        return a(bArr, 0);
    }

    public static int a(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 0) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
    }
}
