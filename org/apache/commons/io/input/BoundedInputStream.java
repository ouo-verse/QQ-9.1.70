package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BoundedInputStream extends InputStream {

    /* renamed from: in, reason: collision with root package name */
    private final InputStream f423532in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream inputStream, long j3) {
        this.pos = 0L;
        this.mark = -1L;
        this.propagateClose = true;
        this.max = j3;
        this.f423532in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long j3 = this.max;
        if (j3 >= 0 && this.pos >= j3) {
            return 0;
        }
        return this.f423532in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.propagateClose) {
            this.f423532in.close();
        }
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        this.f423532in.mark(i3);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f423532in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j3 = this.max;
        if (j3 >= 0 && this.pos >= j3) {
            return -1;
        }
        int read = this.f423532in.read();
        this.pos++;
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f423532in.reset();
        this.pos = this.mark;
    }

    public void setPropagateClose(boolean z16) {
        this.propagateClose = z16;
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        long j16 = this.max;
        if (j16 >= 0) {
            j3 = Math.min(j3, j16 - this.pos);
        }
        long skip = this.f423532in.skip(j3);
        this.pos += skip;
        return skip;
    }

    public String toString() {
        return this.f423532in.toString();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        long j3 = this.max;
        if (j3 >= 0 && this.pos >= j3) {
            return -1;
        }
        int read = this.f423532in.read(bArr, i3, (int) (j3 >= 0 ? Math.min(i16, j3 - this.pos) : i16));
        if (read == -1) {
            return -1;
        }
        this.pos += read;
        return read;
    }

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1L);
    }
}
