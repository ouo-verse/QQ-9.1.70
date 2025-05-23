package org.jf.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RandomAccessFileOutputStream extends OutputStream {
    private int filePosition;

    @Nonnull
    private final RandomAccessFile raf;

    public RandomAccessFileOutputStream(@Nonnull RandomAccessFile randomAccessFile, int i3) {
        this.filePosition = i3;
        this.raf = randomAccessFile;
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition++;
        this.raf.write(i3);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition += bArr.length;
        this.raf.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        this.raf.seek(this.filePosition);
        this.filePosition += i16;
        this.raf.write(bArr, i3, i16);
    }
}
