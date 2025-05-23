package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BrokenInputStream extends InputStream {
    private final IOException exception;

    public BrokenInputStream(IOException iOException) {
        this.exception = iOException;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        throw this.exception;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        throw this.exception;
    }

    public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }
}
