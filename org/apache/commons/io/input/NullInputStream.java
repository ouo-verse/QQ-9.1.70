package org.apache.commons.io.input;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NullInputStream extends InputStream {
    private boolean eof;
    private long mark;
    private final boolean markSupported;
    private long position;
    private long readlimit;
    private final long size;
    private final boolean throwEofException;

    public NullInputStream(long j3) {
        this(j3, true, false);
    }

    private int doEndOfFile() throws EOFException {
        this.eof = true;
        if (!this.throwEofException) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public int available() {
        long j3 = this.size - this.position;
        if (j3 <= 0) {
            return 0;
        }
        if (j3 > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) j3;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.eof = false;
        this.position = 0L;
        this.mark = -1L;
    }

    public long getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        if (this.markSupported) {
            this.mark = this.position;
            this.readlimit = i3;
        } else {
            throw new UnsupportedOperationException("Mark not supported");
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.markSupported;
    }

    protected int processByte() {
        return 0;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.eof) {
            long j3 = this.position;
            if (j3 == this.size) {
                return doEndOfFile();
            }
            this.position = j3 + 1;
            return processByte();
        }
        throw new IOException("Read after end of file");
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.markSupported) {
            long j3 = this.mark;
            if (j3 >= 0) {
                if (this.position <= this.readlimit + j3) {
                    this.position = j3;
                    this.eof = false;
                } else {
                    throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
                }
            } else {
                throw new IOException("No position has been marked");
            }
        } else {
            throw new UnsupportedOperationException("Mark not supported");
        }
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        if (!this.eof) {
            long j16 = this.position;
            long j17 = this.size;
            if (j16 == j17) {
                return doEndOfFile();
            }
            long j18 = j16 + j3;
            this.position = j18;
            if (j18 > j17) {
                long j19 = j3 - (j18 - j17);
                this.position = j17;
                return j19;
            }
            return j3;
        }
        throw new IOException("Skip after end of file");
    }

    public NullInputStream(long j3, boolean z16, boolean z17) {
        this.mark = -1L;
        this.size = j3;
        this.markSupported = z16;
        this.throwEofException = z17;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (!this.eof) {
            long j3 = this.position;
            long j16 = this.size;
            if (j3 == j16) {
                return doEndOfFile();
            }
            long j17 = j3 + i16;
            this.position = j17;
            if (j17 > j16) {
                i16 -= (int) (j17 - j16);
                this.position = j16;
            }
            processBytes(bArr, i3, i16);
            return i16;
        }
        throw new IOException("Read after end of file");
    }

    protected void processBytes(byte[] bArr, int i3, int i16) {
    }
}
