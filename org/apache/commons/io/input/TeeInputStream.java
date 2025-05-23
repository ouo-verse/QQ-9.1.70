package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TeeInputStream extends ProxyInputStream {
    private final OutputStream branch;
    private final boolean closeBranch;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, false);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.closeBranch) {
                this.branch.close();
            }
        }
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.branch.write(read);
        }
        return read;
    }

    public TeeInputStream(InputStream inputStream, OutputStream outputStream, boolean z16) {
        super(inputStream);
        this.branch = outputStream;
        this.closeBranch = z16;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int read = super.read(bArr, i3, i16);
        if (read != -1) {
            this.branch.write(bArr, i3, read);
        }
        return read;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = super.read(bArr);
        if (read != -1) {
            this.branch.write(bArr, 0, read);
        }
        return read;
    }
}
