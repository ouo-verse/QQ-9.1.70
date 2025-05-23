package com.tencent.tbs.one.impl.a;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class l extends InputStream {

    /* renamed from: b, reason: collision with root package name */
    public a f374588b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f374589c;

    /* renamed from: d, reason: collision with root package name */
    private long f374590d;

    /* renamed from: a, reason: collision with root package name */
    public long f374587a = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f374591e = 0;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void a(int i3);

        boolean a();
    }

    public l(InputStream inputStream, long j3) {
        this.f374589c = inputStream;
        this.f374590d = j3;
    }

    private void a() throws IOException {
        a aVar = this.f374588b;
        if (aVar != null && !aVar.a()) {
            throw new IOException("Aborted");
        }
    }

    private void b() {
        a aVar;
        long j3 = this.f374590d;
        if (j3 > 0 && (aVar = this.f374588b) != null) {
            int i3 = (int) ((this.f374587a / j3) * 100.0d);
            if (i3 - this.f374591e >= 2) {
                this.f374591e = i3;
                aVar.a(i3);
            }
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.f374589c.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f374589c.close();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i3) {
        this.f374589c.mark(i3);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f374589c.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        a();
        int read = this.f374589c.read();
        if (read != -1) {
            this.f374587a++;
            b();
        }
        return read;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.f374589c.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j3) throws IOException {
        return this.f374589c.skip(j3);
    }

    @Override // java.io.InputStream
    public final int read(@NonNull byte[] bArr) throws IOException {
        a();
        int read = this.f374589c.read(bArr);
        if (read != -1) {
            this.f374587a += read;
            b();
        }
        return read;
    }

    @Override // java.io.InputStream
    public final int read(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        a();
        int read = this.f374589c.read(bArr, i3, i16);
        if (read != -1) {
            this.f374587a += read;
            b();
        }
        return read;
    }
}
