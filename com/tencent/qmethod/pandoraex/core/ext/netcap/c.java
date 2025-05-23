package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends OutputStream {

    /* renamed from: e, reason: collision with root package name */
    private final OutputStream f344080e;

    /* renamed from: f, reason: collision with root package name */
    private long f344081f = 0;

    /* renamed from: h, reason: collision with root package name */
    private j f344082h = null;

    /* renamed from: d, reason: collision with root package name */
    private final ByteArrayOutputStream f344079d = new ByteArrayOutputStream();

    public c(OutputStream outputStream) {
        this.f344080e = outputStream;
    }

    private void d() {
        j jVar = this.f344082h;
        if (jVar != null) {
            jVar.b(this.f344081f, this.f344079d.toByteArray());
        }
    }

    private void e() {
        j jVar = this.f344082h;
        if (jVar != null) {
            jVar.d(this.f344081f);
        }
    }

    public ByteArrayOutputStream a() {
        return this.f344079d;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f344080e.close();
            d();
        } catch (IOException e16) {
            e();
            throw e16;
        }
    }

    public void f(j jVar) {
        this.f344082h = jVar;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.f344080e.flush();
            this.f344079d.flush();
        } catch (IOException e16) {
            throw e16;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        try {
            this.f344080e.write(i3);
            this.f344079d.write(i3);
            this.f344081f++;
        } catch (IOException e16) {
            throw e16;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.f344080e.write(bArr);
            this.f344079d.write(bArr);
            this.f344081f += bArr.length;
        } catch (IOException e16) {
            throw e16;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        try {
            this.f344080e.write(bArr, i3, i16);
            this.f344079d.write(bArr, i3, i16);
            this.f344081f += i16;
        } catch (IOException e16) {
            throw e16;
        }
    }
}
