package com.google.android.exoplayer2.util;

import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AtomicFile {
    private static final String TAG = "AtomicFile";
    private final File backupName;
    private final File baseName;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class AtomicFileOutputStream extends OutputStream {
        private boolean closed = false;
        private final FileOutputStream fileOutputStream;

        public AtomicFileOutputStream(File file) throws FileNotFoundException {
            this.fileOutputStream = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            flush();
            try {
                this.fileOutputStream.getFD().sync();
            } catch (IOException e16) {
                Log.w(AtomicFile.TAG, "Failed to sync file descriptor:", e16);
            }
            this.fileOutputStream.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.fileOutputStream.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i3) throws IOException {
            this.fileOutputStream.write(i3);
        }

        @Override // java.io.OutputStream
        public void write(@NonNull byte[] bArr) throws IOException {
            this.fileOutputStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(@NonNull byte[] bArr, int i3, int i16) throws IOException {
            this.fileOutputStream.write(bArr, i3, i16);
        }
    }

    public AtomicFile(File file) {
        this.baseName = file;
        this.backupName = new File(file.getPath() + ".bak");
    }

    private void restoreBackup() {
        if (this.backupName.exists()) {
            this.baseName.delete();
            this.backupName.renameTo(this.baseName);
        }
    }

    public void delete() {
        this.baseName.delete();
        this.backupName.delete();
    }

    public void endWrite(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.backupName.delete();
    }

    public InputStream openRead() throws FileNotFoundException {
        restoreBackup();
        return new FileInputStream(this.baseName);
    }

    public OutputStream startWrite() throws IOException {
        if (this.baseName.exists()) {
            if (!this.backupName.exists()) {
                if (!this.baseName.renameTo(this.backupName)) {
                    Log.w(TAG, "Couldn't rename file " + this.baseName + " to backup file " + this.backupName);
                }
            } else {
                this.baseName.delete();
            }
        }
        try {
            return new AtomicFileOutputStream(this.baseName);
        } catch (FileNotFoundException e16) {
            if (this.baseName.getParentFile().mkdirs()) {
                try {
                    return new AtomicFileOutputStream(this.baseName);
                } catch (FileNotFoundException e17) {
                    throw new IOException("Couldn't create " + this.baseName, e17);
                }
            }
            throw new IOException("Couldn't create directory " + this.baseName, e16);
        }
    }
}
