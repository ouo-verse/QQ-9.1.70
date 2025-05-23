package org.apache.commons.fileupload.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class LimitedInputStream extends FilterInputStream implements Closeable {
    private boolean closed;
    private long count;
    private final long sizeMax;

    public LimitedInputStream(InputStream inputStream, long j3) {
        super(inputStream);
        this.sizeMax = j3;
    }

    private void checkLimit() throws IOException {
        long j3 = this.count;
        long j16 = this.sizeMax;
        if (j3 > j16) {
            raiseError(j16, j3);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, org.apache.commons.fileupload.util.Closeable
    public void close() throws IOException {
        this.closed = true;
        super.close();
    }

    @Override // org.apache.commons.fileupload.util.Closeable
    public boolean isClosed() throws IOException {
        return this.closed;
    }

    protected abstract void raiseError(long j3, long j16) throws IOException;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.count++;
            checkLimit();
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int read = super.read(bArr, i3, i16);
        if (read > 0) {
            this.count += read;
            checkLimit();
        }
        return read;
    }
}
