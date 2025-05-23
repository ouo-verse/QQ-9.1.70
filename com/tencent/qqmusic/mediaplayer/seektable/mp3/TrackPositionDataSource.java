package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

/* loaded from: classes23.dex */
class TrackPositionDataSource {
    private final IDataSource mDataSource;
    private long mPosition = 0;

    public TrackPositionDataSource(IDataSource iDataSource) {
        this.mDataSource = iDataSource;
    }

    public long getCurPosition() {
        return this.mPosition;
    }

    public long getSize() throws IOException {
        return this.mDataSource.getSize();
    }

    public int read(byte[] bArr, int i3) throws IOException {
        int readAt = this.mDataSource.readAt(this.mPosition, bArr, 0, i3);
        this.mPosition += readAt;
        return readAt;
    }

    public long seek(long j3) throws IOException {
        if (j3 < this.mDataSource.getSize()) {
            this.mPosition = j3;
            return j3;
        }
        return -1L;
    }
}
