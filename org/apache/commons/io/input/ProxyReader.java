package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* loaded from: classes29.dex */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader reader) {
        super(reader);
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterReader) this).in.close();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void mark(int i3) throws IOException {
        try {
            ((FilterReader) this).in.mark(i3);
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return ((FilterReader) this).in.markSupported();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int i3 = 1;
        try {
            beforeRead(1);
            int read = ((FilterReader) this).in.read();
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

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws IOException {
        try {
            return ((FilterReader) this).in.ready();
        } catch (IOException e16) {
            handleIOException(e16);
            return false;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void reset() throws IOException {
        try {
            ((FilterReader) this).in.reset();
        } catch (IOException e16) {
            handleIOException(e16);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j3) throws IOException {
        try {
            return ((FilterReader) this).in.skip(j3);
        } catch (IOException e16) {
            handleIOException(e16);
            return 0L;
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        int length;
        if (cArr != null) {
            try {
                length = cArr.length;
            } catch (IOException e16) {
                handleIOException(e16);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = ((FilterReader) this).in.read(cArr);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i3, int i16) throws IOException {
        try {
            beforeRead(i16);
            int read = ((FilterReader) this).in.read(cArr, i3, i16);
            afterRead(read);
            return read;
        } catch (IOException e16) {
            handleIOException(e16);
            return -1;
        }
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        int length;
        if (charBuffer != null) {
            try {
                length = charBuffer.length();
            } catch (IOException e16) {
                handleIOException(e16);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = ((FilterReader) this).in.read(charBuffer);
        afterRead(read);
        return read;
    }

    protected void afterRead(int i3) throws IOException {
    }

    protected void beforeRead(int i3) throws IOException {
    }

    protected void handleIOException(IOException iOException) throws IOException {
        throw iOException;
    }
}
