package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends InputStream {

    /* renamed from: d, reason: collision with root package name */
    private final InputStream f344076d;

    /* renamed from: e, reason: collision with root package name */
    private long f344077e = 0;

    /* renamed from: f, reason: collision with root package name */
    private j f344078f = null;

    public b(InputStream inputStream) {
        this.f344076d = inputStream;
    }

    private void a() {
        j jVar = this.f344078f;
        if (jVar != null) {
            jVar.a(this.f344077e);
        }
    }

    private void d() {
        j jVar = this.f344078f;
        if (jVar != null) {
            jVar.c(this.f344077e);
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f344076d.available();
        } catch (IOException e16) {
            throw e16;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f344076d.close();
            a();
        } catch (IOException e16) {
            d();
            throw e16;
        }
    }

    public void e(j jVar) {
        this.f344078f = jVar;
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
        if (!markSupported()) {
            return;
        }
        this.f344076d.mark(i3);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f344076d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int read = this.f344076d.read();
            if (read >= 0) {
                this.f344077e += read;
            } else {
                a();
            }
            return read;
        } catch (IOException e16) {
            d();
            throw e16;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (!markSupported()) {
            return;
        }
        try {
            this.f344076d.reset();
        } catch (IOException e16) {
            throw e16;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        try {
            long skip = this.f344076d.skip(j3);
            this.f344077e += skip;
            return skip;
        } catch (IOException e16) {
            d();
            throw e16;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int read = this.f344076d.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.f344077e += read;
            } else {
                a();
            }
            return read;
        } catch (IOException e16) {
            d();
            throw e16;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        try {
            int read = this.f344076d.read(bArr, i3, i16);
            if (read >= 0) {
                this.f344077e += read;
            } else {
                a();
            }
            return read;
        } catch (IOException e16) {
            d();
            throw e16;
        }
    }
}
