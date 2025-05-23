package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes29.dex */
public class ProxyOutputStream extends FilterOutputStream {
    public ProxyOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterOutputStream) this).out.close();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) throws IOException {
        try {
            beforeWrite(1);
            ((FilterOutputStream) this).out.write(i3);
            afterWrite(1);
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        int length;
        if (bArr != null) {
            try {
                length = bArr.length;
            } catch (IOException e16) {
                handleIOException(e16);
                return;
            }
        } else {
            length = 0;
        }
        beforeWrite(length);
        ((FilterOutputStream) this).out.write(bArr);
        afterWrite(length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        try {
            beforeWrite(i16);
            ((FilterOutputStream) this).out.write(bArr, i3, i16);
            afterWrite(i16);
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    protected void afterWrite(int i3) throws IOException {
    }

    protected void beforeWrite(int i3) throws IOException {
    }

    protected void handleIOException(IOException iOException) throws IOException {
        throw iOException;
    }
}
