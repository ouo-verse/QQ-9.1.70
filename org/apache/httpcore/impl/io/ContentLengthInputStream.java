package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.httpcore.ConnectionClosedException;
import org.apache.httpcore.io.BufferInfo;
import org.apache.httpcore.io.SessionInputBuffer;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private final long contentLength;

    /* renamed from: in, reason: collision with root package name */
    private SessionInputBuffer f423547in;
    private long pos = 0;
    private boolean closed = false;

    public ContentLengthInputStream(SessionInputBuffer sessionInputBuffer, long j3) {
        this.f423547in = null;
        this.f423547in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.contentLength = Args.notNegative(j3, "Content length");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f423547in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return Math.min(((BufferInfo) sessionInputBuffer).length(), (int) (this.contentLength - this.pos));
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (this.pos < this.contentLength) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.closed = true;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.pos >= this.contentLength) {
            return -1;
        }
        int read = this.f423547in.read();
        if (read != -1) {
            this.pos++;
        } else if (this.pos < this.contentLength) {
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", Long.valueOf(this.contentLength), Long.valueOf(this.pos));
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        int read;
        if (j3 <= 0) {
            return 0L;
        }
        byte[] bArr = new byte[2048];
        long min = Math.min(j3, this.contentLength - this.pos);
        long j16 = 0;
        while (min > 0 && (read = read(bArr, 0, (int) Math.min(2048L, min))) != -1) {
            long j17 = read;
            j16 += j17;
            min -= j17;
        }
        return j16;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (!this.closed) {
            long j3 = this.pos;
            long j16 = this.contentLength;
            if (j3 >= j16) {
                return -1;
            }
            if (i16 + j3 > j16) {
                i16 = (int) (j16 - j3);
            }
            int read = this.f423547in.read(bArr, i3, i16);
            if (read == -1 && this.pos < this.contentLength) {
                throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %,d; received: %,d)", Long.valueOf(this.contentLength), Long.valueOf(this.pos));
            }
            if (read > 0) {
                this.pos += read;
            }
            return read;
        }
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
