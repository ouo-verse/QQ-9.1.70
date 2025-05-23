package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class hx extends hy {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f389396a;

    /* renamed from: b, reason: collision with root package name */
    private int f389397b;

    /* renamed from: c, reason: collision with root package name */
    private int f389398c;

    @Override // com.xiaomi.push.hy
    public int a(byte[] bArr, int i3, int i16) {
        int f16 = f();
        if (i16 > f16) {
            i16 = f16;
        }
        if (i16 > 0) {
            System.arraycopy(this.f389396a, this.f389397b, bArr, i3, i16);
            b(i16);
        }
        return i16;
    }

    @Override // com.xiaomi.push.hy
    public void b(int i3) {
        this.f389397b += i3;
    }

    @Override // com.xiaomi.push.hy
    public void c(byte[] bArr, int i3, int i16) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.hy
    public byte[] d() {
        return this.f389396a;
    }

    @Override // com.xiaomi.push.hy
    public int e() {
        return this.f389397b;
    }

    @Override // com.xiaomi.push.hy
    public int f() {
        return this.f389398c - this.f389397b;
    }

    public void h(byte[] bArr) {
        i(bArr, 0, bArr.length);
    }

    public void i(byte[] bArr, int i3, int i16) {
        this.f389396a = bArr;
        this.f389397b = i3;
        this.f389398c = i3 + i16;
    }
}
