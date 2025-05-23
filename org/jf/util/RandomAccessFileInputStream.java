package org.jf.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RandomAccessFileInputStream extends InputStream {
    private int filePosition;

    @Nonnull
    private final RandomAccessFile raf;

    public RandomAccessFileInputStream(@Nonnull RandomAccessFile randomAccessFile, int i3) {
        this.filePosition = i3;
        this.raf = randomAccessFile;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return ((int) this.raf.length()) - this.filePosition;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition++;
        return this.raf.read();
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        int min = Math.min((int) j3, available());
        this.filePosition += min;
        return min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        this.raf.seek(this.filePosition);
        int read = this.raf.read(bArr);
        this.filePosition += read;
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        this.raf.seek(this.filePosition);
        int read = this.raf.read(bArr, i3, i16);
        this.filePosition += read;
        return read;
    }
}
