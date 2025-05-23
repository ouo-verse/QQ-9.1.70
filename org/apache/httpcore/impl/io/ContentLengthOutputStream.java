package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContentLengthOutputStream extends OutputStream {
    private boolean closed;
    private final long contentLength;
    private final SessionOutputBuffer out;
    private long total;

    public ContentLengthOutputStream(SessionOutputBuffer sessionOutputBuffer, long j3) {
        this.out = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.contentLength = Args.notNegative(j3, "Content length");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.out.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        if (!this.closed) {
            long j3 = this.total;
            long j16 = this.contentLength;
            if (j3 < j16) {
                long j17 = j16 - j3;
                if (i16 > j17) {
                    i16 = (int) j17;
                }
                this.out.write(bArr, i3, i16);
                this.total += i16;
                return;
            }
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.total < this.contentLength) {
            this.out.write(i3);
            this.total++;
        }
    }
}
