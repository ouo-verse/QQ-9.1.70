package org.jf.dexlib2.writer.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import javax.annotation.Nonnull;
import org.jf.util.RandomAccessFileInputStream;
import org.jf.util.RandomAccessFileOutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FileDataStore implements DexDataStore {
    private final RandomAccessFile raf;

    public FileDataStore(@Nonnull File file) throws FileNotFoundException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.raf = randomAccessFile;
        randomAccessFile.setLength(0L);
    }

    @Override // org.jf.dexlib2.writer.io.DexDataStore
    public void close() throws IOException {
        this.raf.close();
    }

    @Override // org.jf.dexlib2.writer.io.DexDataStore
    @Nonnull
    public OutputStream outputAt(int i3) {
        return new RandomAccessFileOutputStream(this.raf, i3);
    }

    @Override // org.jf.dexlib2.writer.io.DexDataStore
    @Nonnull
    public InputStream readAt(int i3) {
        return new RandomAccessFileInputStream(this.raf, i3);
    }
}
