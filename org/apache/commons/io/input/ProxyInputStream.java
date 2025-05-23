package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes29.dex */
public abstract class ProxyInputStream extends FilterInputStream {
    public ProxyInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e16) {
            handleIOException(e16);
            return 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        ((FilterInputStream) this).in.mark(i3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i3 = 1;
        try {
            beforeRead(1);
            int read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                i3 = -1;
            }
            afterRead(i3);
            return read;
        } catch (IOException e16) {
            handleIOException(e16);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        try {
            return ((FilterInputStream) this).in.skip(j3);
        } catch (IOException e16) {
            handleIOException(e16);
            return 0L;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int length;
        if (bArr != null) {
            try {
                length = bArr.length;
            } catch (IOException e16) {
                handleIOException(e16);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = ((FilterInputStream) this).in.read(bArr);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        try {
            beforeRead(i16);
            int read = ((FilterInputStream) this).in.read(bArr, i3, i16);
            afterRead(read);
            return read;
        } catch (IOException e16) {
            handleIOException(e16);
            return -1;
        }
    }

    protected void afterRead(int i3) throws IOException {
    }

    protected void beforeRead(int i3) throws IOException {
    }

    protected void handleIOException(IOException iOException) throws IOException {
        throw iOException;
    }
}
