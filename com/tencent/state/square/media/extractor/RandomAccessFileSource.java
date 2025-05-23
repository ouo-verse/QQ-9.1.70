package com.tencent.state.square.media.extractor;

import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J*\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/media/extractor/RandomAccessFileSource;", "Lcom/tencent/state/square/media/extractor/IRandomAccessSource;", "Ljava/io/File;", "()V", "backendFile", "raf", "Ljava/io/RandomAccessFile;", "tempFile", "close", "", "copyFrom", "input", "Ljava/io/InputStream;", "getTempFile", "initialize", "data", "isInitialized", "", "length", "", k.f247491e, "", "position", "buffer", "", "offset", "size", k.f247492f, "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RandomAccessFileSource implements IRandomAccessSource<File> {
    private static final String TAG = "Square_RandomAccessFileSource";
    private File backendFile;
    private RandomAccessFile raf;
    private File tempFile;

    private final File getTempFile() {
        File file = this.tempFile;
        if (file == null) {
            file = new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), "smds/" + System.currentTimeMillis() + ".tmp");
        }
        this.tempFile = file;
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        return file;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        File file = this.tempFile;
        if (file != null) {
            file.delete();
        }
        this.tempFile = null;
    }

    @Override // com.tencent.state.square.media.extractor.IRandomAccessSource
    public void copyFrom(InputStream input) {
        Intrinsics.checkNotNullParameter(input, "input");
        File file = this.backendFile;
        if (file != null) {
            ByteStreamsKt.copyTo$default(input, new FileOutputStream(file), 0, 2, null);
        }
    }

    @Override // com.tencent.state.square.media.extractor.IRandomAccessSource
    public boolean isInitialized() {
        return this.raf != null;
    }

    @Override // com.tencent.state.square.media.extractor.IRandomAccessSource
    public long length() {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            return randomAccessFile.length();
        }
        return -1L;
    }

    @Override // com.tencent.state.square.media.extractor.IRandomAccessSource
    public int read(long position, byte[] buffer, int offset, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.seek(position);
        }
        RandomAccessFile randomAccessFile2 = this.raf;
        if (randomAccessFile2 != null) {
            return randomAccessFile2.read(buffer, offset, size);
        }
        return -1;
    }

    @Override // com.tencent.state.square.media.extractor.IRandomAccessSource
    public void initialize(File data) {
        if (data == null) {
            data = getTempFile();
        }
        this.backendFile = data;
        this.raf = new RandomAccessFile(this.backendFile, "rw");
    }

    @Override // com.tencent.state.square.media.extractor.IRandomAccessSource
    public void write(long position, byte[] buffer, int offset, int size) {
        if (buffer != null) {
            try {
                RandomAccessFile randomAccessFile = this.raf;
                if (randomAccessFile != null) {
                    randomAccessFile.seek(position);
                }
                RandomAccessFile randomAccessFile2 = this.raf;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.write(buffer, offset, size);
                }
            } catch (IOException e16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "write error: " + e16.getMessage(), null, 4, null);
            }
        }
    }
}
