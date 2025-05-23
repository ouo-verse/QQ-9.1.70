package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public class k extends ByteArrayOutputStream {

    /* renamed from: d, reason: collision with root package name */
    private final c f31430d;

    public k(c cVar, int i3) {
        this.f31430d = cVar;
        ((ByteArrayOutputStream) this).buf = cVar.a(Math.max(i3, 256));
    }

    private void a(int i3) {
        int i16 = ((ByteArrayOutputStream) this).count;
        if (i16 + i3 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a16 = this.f31430d.a((i16 + i3) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a16, 0, ((ByteArrayOutputStream) this).count);
        this.f31430d.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a16;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f31430d.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f31430d.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i16) {
        a(i16);
        super.write(bArr, i3, i16);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i3) {
        a(1);
        super.write(i3);
    }
}
