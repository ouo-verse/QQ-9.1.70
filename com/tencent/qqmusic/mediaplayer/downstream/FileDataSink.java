package com.tencent.qqmusic.mediaplayer.downstream;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileDataSink implements IDataSink {
    private static final String TAG = "FileDataSink";
    private final String filePath;
    private RandomAccessFile randomAccessFile = null;
    private long currentPosition = 0;
    private boolean opened = false;

    public FileDataSink(String str) {
        this.filePath = str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.opened) {
            return;
        }
        this.randomAccessFile.close();
        this.currentPosition = 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.downstream.IDataSink
    public void open() throws IOException {
        if (this.opened) {
            return;
        }
        this.randomAccessFile = new RandomAccessFile(this.filePath, "rw");
        this.currentPosition = 0L;
        this.opened = true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.downstream.IDataSink
    public int write(long j3, byte[] bArr, int i3, int i16) throws IOException {
        if (this.randomAccessFile != null) {
            if (this.currentPosition != j3) {
                Logger.d("FileDataSink", "[write] seek to: " + j3);
                this.randomAccessFile.seek(j3);
                this.currentPosition = j3;
            }
            this.randomAccessFile.write(bArr, i3, i16);
            this.currentPosition += i16;
            return i16;
        }
        return 0;
    }
}
