package com.tencent.luggage.wxa.n0;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p extends BufferedOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public boolean f135095a;

    public p(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        a.b(this.f135095a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f135095a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f135095a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th6) {
            if (th == null) {
                th = th6;
            }
        }
        if (th != null) {
            v.a(th);
        }
    }

    public p(OutputStream outputStream, int i3) {
        super(outputStream, i3);
    }
}
