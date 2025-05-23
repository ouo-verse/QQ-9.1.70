package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InputStreamDataSource implements IDataSource {
    private long currentPosition;
    private InputStream currentStream;
    private final InputStreamFactory factory;
    private long size;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface InputStreamFactory {
        InputStream create() throws IOException;
    }

    public InputStreamDataSource(InputStreamFactory inputStreamFactory) {
        this.factory = inputStreamFactory;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.currentStream;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        return FormatDetector.getAudioFormat((IDataSource) this, false);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        return this.size;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        InputStream inputStream = this.currentStream;
        if (inputStream != null) {
            inputStream.close();
        }
        this.currentStream = this.factory.create();
        this.size = r0.available();
        this.currentPosition = 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        long j16 = this.currentPosition;
        if (j3 < j16) {
            open();
            return readAt(j3, bArr, i3, i16);
        }
        if (j3 > j16) {
            long j17 = j3 - j16;
            while (true) {
                long skip = this.currentStream.skip(j17);
                j17 -= skip;
                if (j17 <= 0 && skip > 0) {
                    break;
                }
            }
            if (j17 >= 0) {
                this.currentPosition = j3;
            } else {
                throw new IOException("skipped too much bytes");
            }
        }
        int read = this.currentStream.read(bArr, i3, i16);
        if (read > 0) {
            this.currentPosition += read;
        }
        return read;
    }
}
