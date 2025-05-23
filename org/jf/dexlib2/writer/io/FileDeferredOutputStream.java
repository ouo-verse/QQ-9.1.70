package org.jf.dexlib2.writer.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import q1.b;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileDeferredOutputStream extends DeferredOutputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    @Nonnull
    private final File backingFile;

    @Nonnull
    private final NakedBufferedOutputStream output;
    private int writtenBytes;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class NakedBufferedOutputStream extends BufferedOutputStream {
        public NakedBufferedOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public byte[] getBuffer() {
            return ((BufferedOutputStream) this).buf;
        }

        public int getCount() {
            return ((BufferedOutputStream) this).count;
        }

        public void resetBuffer() {
            ((BufferedOutputStream) this).count = 0;
        }

        public NakedBufferedOutputStream(OutputStream outputStream, int i3) {
            super(outputStream, i3);
        }
    }

    public FileDeferredOutputStream(@Nonnull File file) throws FileNotFoundException {
        this(file, 4096);
    }

    @Nonnull
    public static DeferredOutputStreamFactory getFactory(@Nullable File file) {
        return getFactory(file, 4096);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.output.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.output.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        this.output.write(i3);
        this.writtenBytes++;
    }

    @Override // org.jf.dexlib2.writer.io.DeferredOutputStream
    public void writeTo(@Nonnull OutputStream outputStream) throws IOException {
        byte[] buffer = this.output.getBuffer();
        int count = this.output.getCount();
        this.output.resetBuffer();
        this.output.close();
        if (count != this.writtenBytes) {
            b.b(new FileInputStream(this.backingFile), outputStream);
            this.backingFile.delete();
        }
        outputStream.write(buffer, 0, count);
    }

    public FileDeferredOutputStream(@Nonnull File file, int i3) throws FileNotFoundException {
        this.backingFile = file;
        this.output = new NakedBufferedOutputStream(new FileOutputStream(file), i3);
    }

    @Nonnull
    public static DeferredOutputStreamFactory getFactory(@Nullable final File file, final int i3) {
        return new DeferredOutputStreamFactory() { // from class: org.jf.dexlib2.writer.io.FileDeferredOutputStream.1
            @Override // org.jf.dexlib2.writer.io.DeferredOutputStreamFactory
            public DeferredOutputStream makeDeferredOutputStream() throws IOException {
                return new FileDeferredOutputStream(File.createTempFile("dexlibtmp", null, file), i3);
            }
        };
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.output.write(bArr);
        this.writtenBytes += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        this.output.write(bArr, i3, i16);
        this.writtenBytes += i16;
    }
}
