package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.StreamUtils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileDataSource implements IDataSource {
    private long currentPosition;
    private RandomAccessFile file;
    private FileInputStream fileInputStream;
    private final String filePath;
    private boolean opened = false;
    private BufferedInputStream readingStream;

    public FileDataSource(String str) {
        this.filePath = str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.opened) {
            return;
        }
        FileInputStream fileInputStream = this.fileInputStream;
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        BufferedInputStream bufferedInputStream = this.readingStream;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.opened = false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        return AudioRecognition.recognitionAudioFormatExactly(this.filePath);
    }

    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        return this.file.length();
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        if (this.opened) {
            return;
        }
        this.opened = true;
        this.file = new RandomAccessFile(this.filePath, "r");
        this.fileInputStream = new FileInputStream(this.file.getFD());
        this.readingStream = new BufferedInputStream(this.fileInputStream);
        this.currentPosition = 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        long skipForBufferStream;
        long j16 = this.currentPosition;
        if (j16 != j3) {
            if (j16 > j3) {
                this.file.seek(j3);
                this.readingStream = new BufferedInputStream(this.fileInputStream);
                skipForBufferStream = j3;
            } else {
                skipForBufferStream = j16 + StreamUtils.skipForBufferStream(this.readingStream, j3 - j16);
            }
            if (skipForBufferStream != j3) {
                return -1;
            }
            this.currentPosition = j3;
        }
        int read = this.readingStream.read(bArr, i3, i16);
        if (read >= 0) {
            this.currentPosition += read;
        }
        return read;
    }

    public String toString() {
        return "(fd)" + this.filePath;
    }
}
