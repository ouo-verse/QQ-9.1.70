package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
class o extends OutputStream {

    /* renamed from: d, reason: collision with root package name */
    boolean f344109d;

    /* renamed from: e, reason: collision with root package name */
    ByteArrayOutputStream f344110e = new ByteArrayOutputStream();

    /* renamed from: f, reason: collision with root package name */
    OutputStream f344111f;

    public o(OutputStream outputStream, boolean z16) {
        this.f344109d = true;
        this.f344111f = outputStream;
        this.f344109d = z16;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f344110e.close();
        this.f344111f.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f344110e.flush();
        this.f344111f.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        if (this.f344109d && !k.d(this.f344110e.size())) {
            this.f344110e.write(i3);
        }
        this.f344111f.write(i3);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        if (this.f344109d && !k.d(this.f344110e.size())) {
            this.f344110e.write(bArr, i3, i16);
        }
        this.f344111f.write(bArr, i3, i16);
    }
}
