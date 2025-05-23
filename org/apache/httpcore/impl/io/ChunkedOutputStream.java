package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.httpcore.io.SessionOutputBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ChunkedOutputStream extends OutputStream {
    private final byte[] cache;
    private int cachePosition;
    private boolean closed;
    private final SessionOutputBuffer out;
    private boolean wroteLastChunk;

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer, int i3) throws IOException {
        this(i3, sessionOutputBuffer);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            finish();
            this.out.flush();
        }
    }

    public void finish() throws IOException {
        if (!this.wroteLastChunk) {
            flushCache();
            writeClosingChunk();
            this.wroteLastChunk = true;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushCache();
        this.out.flush();
    }

    protected void flushCache() throws IOException {
        int i3 = this.cachePosition;
        if (i3 > 0) {
            this.out.writeLine(Integer.toHexString(i3));
            this.out.write(this.cache, 0, this.cachePosition);
            this.out.writeLine("");
            this.cachePosition = 0;
        }
    }

    protected void flushCacheWithAppend(byte[] bArr, int i3, int i16) throws IOException {
        this.out.writeLine(Integer.toHexString(this.cachePosition + i16));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.write(bArr, i3, i16);
        this.out.writeLine("");
        this.cachePosition = 0;
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        if (!this.closed) {
            byte[] bArr = this.cache;
            int i16 = this.cachePosition;
            bArr[i16] = (byte) i3;
            int i17 = i16 + 1;
            this.cachePosition = i17;
            if (i17 == bArr.length) {
                flushCache();
                return;
            }
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    protected void writeClosingChunk() throws IOException {
        this.out.writeLine("0");
        this.out.writeLine("");
    }

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer) throws IOException {
        this(2048, sessionOutputBuffer);
    }

    public ChunkedOutputStream(int i3, SessionOutputBuffer sessionOutputBuffer) {
        this.cachePosition = 0;
        this.wroteLastChunk = false;
        this.closed = false;
        this.cache = new byte[i3];
        this.out = sessionOutputBuffer;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        if (!this.closed) {
            byte[] bArr2 = this.cache;
            int length = bArr2.length;
            int i17 = this.cachePosition;
            if (i16 >= length - i17) {
                flushCacheWithAppend(bArr, i3, i16);
                return;
            } else {
                System.arraycopy(bArr, i3, bArr2, i17, i16);
                this.cachePosition += i16;
                return;
            }
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
