package com.tencent.qphone.base.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Cryptor {
    b impl = new b();

    public byte[] decrypt(byte[] bArr, int i3, int i16, byte[] bArr2) {
        return this.impl.a(bArr, i3, i16, bArr2);
    }

    public void enableResultRandom(boolean z16) {
        this.impl.a(z16);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return this.impl.b(bArr, bArr2);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return this.impl.a(bArr, bArr2);
    }
}
