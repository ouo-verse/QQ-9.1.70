package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ContentLengthInputStream extends InputStream {
    private final int length;
    private final InputStream stream;

    public ContentLengthInputStream(InputStream inputStream, int i3) {
        this.stream = inputStream;
        this.length = i3;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
        this.stream.mark(i3);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.stream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.stream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        return this.stream.skip(j3);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.stream.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        return this.stream.read(bArr, i3, i16);
    }
}
