package org.apache.httpcore.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.httpcore.io.SessionOutputBuffer;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IdentityOutputStream extends OutputStream {
    private boolean closed = false;
    private final SessionOutputBuffer out;

    public IdentityOutputStream(SessionOutputBuffer sessionOutputBuffer) {
        this.out = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
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
            this.out.write(bArr, i3, i16);
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
        if (!this.closed) {
            this.out.write(i3);
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
