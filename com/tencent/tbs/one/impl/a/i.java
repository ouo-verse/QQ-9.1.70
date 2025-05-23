package com.tencent.tbs.one.impl.a;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class i extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private OutputStream[] f374580a;

    public i(OutputStream[] outputStreamArr) {
        this.f374580a = outputStreamArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        for (OutputStream outputStream : this.f374580a) {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        for (OutputStream outputStream : this.f374580a) {
            outputStream.flush();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i3) throws IOException {
        for (OutputStream outputStream : this.f374580a) {
            outputStream.write(i3);
        }
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr) throws IOException {
        for (OutputStream outputStream : this.f374580a) {
            outputStream.write(bArr);
        }
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        for (OutputStream outputStream : this.f374580a) {
            outputStream.write(bArr, i3, i16);
        }
    }
}
