package com.tencent.luggage.wxa.l0;

import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final g f132776a;

    /* renamed from: b, reason: collision with root package name */
    public final j f132777b;

    /* renamed from: f, reason: collision with root package name */
    public long f132781f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f132779d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f132780e = false;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f132778c = new byte[1];

    public i(g gVar, j jVar) {
        this.f132776a = gVar;
        this.f132777b = jVar;
    }

    public long a() {
        return this.f132781f;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f132780e) {
            this.f132776a.close();
            this.f132780e = true;
        }
    }

    public final void d() {
        if (!this.f132779d) {
            this.f132776a.a(this.f132777b);
            this.f132779d = true;
        }
    }

    public void open() {
        d();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f132778c) == -1) {
            return -1;
        }
        return this.f132778c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) {
        com.tencent.luggage.wxa.n0.a.b(!this.f132780e);
        d();
        int read = this.f132776a.read(bArr, i3, i16);
        if (read == -1) {
            return -1;
        }
        this.f132781f += read;
        return read;
    }
}
