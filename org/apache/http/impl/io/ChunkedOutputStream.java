package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class ChunkedOutputStream extends OutputStream {
    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer, int i3) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void finish() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void flushCache() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void flushCacheWithAppend(byte[] bArr, int i3, int i16) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void writeClosingChunk() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
