package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TeeOutputStream extends ProxyOutputStream {
    protected OutputStream branch;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.branch = outputStream2;
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            this.branch.close();
        }
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        super.flush();
        this.branch.flush();
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        super.write(bArr);
        this.branch.write(bArr);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i16) throws IOException {
        super.write(bArr, i3, i16);
        this.branch.write(bArr, i3, i16);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i3) throws IOException {
        super.write(i3);
        this.branch.write(i3);
    }
}
