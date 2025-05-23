package org.apache.httpcore.impl.io;

import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class EmptyInputStream extends InputStream {
    public static final EmptyInputStream INSTANCE = new EmptyInputStream();

    EmptyInputStream() {
    }

    @Override // java.io.InputStream
    public int available() {
        return 0;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        return 0L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) {
        return -1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public void reset() {
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
    }
}
