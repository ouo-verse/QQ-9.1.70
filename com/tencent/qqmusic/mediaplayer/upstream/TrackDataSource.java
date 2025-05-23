package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TrackDataSource implements IDataSource, PlayerListenerCallback {
    private static final String TAG = "TrackDataSource";
    private IDataSource mDataSource;
    private long mEndBytePosition;
    private long mStartBytePosition;
    private long mStartTimePosition;
    private TrackInfo mTrackInfo;
    private TrackStateCallback mTrackStateCallback;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface TrackStateCallback {
        void onTrackPrepared(TrackInfo trackInfo);
    }

    public TrackDataSource(TrackInfo trackInfo) throws DataSourceException, IOException {
        String uri = trackInfo.getUri();
        if (!TextUtils.isEmpty(trackInfo.getUri())) {
            if (new File(uri).exists()) {
                this.mDataSource = new FileDataSource(trackInfo.getUri());
                this.mTrackInfo = trackInfo;
                return;
            }
            throw new DataSourceException(-1, "track info's media file not exists!", null);
        }
        throw new DataSourceException(-1, "track info has no media file path!", null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDataSource.close();
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        return this.mDataSource.getAudioType();
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        return this.mDataSource.getSize();
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        SeekTable seekTable;
        try {
            this.mDataSource.open();
            long size = this.mDataSource.getSize();
            try {
                seekTable = baseMediaPlayer.createSeekTable();
            } catch (IllegalStateException e16) {
                Logger.e(TAG, "createSeekTable ex occurred!!", e16);
                seekTable = null;
            }
            if (seekTable == null) {
                Logger.e(TAG, "createSeekTable is null, return");
                return;
            }
            Pair<Long, Long> range = this.mTrackInfo.getRange();
            Logger.i(TAG, "start time: " + range.first + ", end time: " + range.second);
            if (((Long) range.first).longValue() > ((Long) range.second).longValue()) {
                Logger.e(TAG, "start range larger, return");
                return;
            }
            this.mStartTimePosition = ((Long) range.first).longValue();
            long seek = seekTable.seek(((Long) range.first).longValue());
            long seek2 = seekTable.seek(((Long) range.second).longValue());
            if (size > 0 && seek > size) {
                Logger.e(TAG, "startBytePosition larger than size!");
                return;
            }
            if (size <= 0 || seek2 <= size) {
                size = seek2;
            }
            this.mStartBytePosition = seek;
            this.mEndBytePosition = size;
            Logger.i(TAG, "start byte: " + this.mStartBytePosition + ", end byte: " + this.mEndBytePosition);
            TrackStateCallback trackStateCallback = this.mTrackStateCallback;
            if (trackStateCallback != null) {
                trackStateCallback.onTrackPrepared(this.mTrackInfo);
            }
        } catch (IOException e17) {
            Logger.e(TAG, "dataSource open failed!", e17);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStarted(BaseMediaPlayer baseMediaPlayer) {
        baseMediaPlayer.seekTo(0);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        this.mDataSource.open();
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        long j16 = this.mEndBytePosition;
        if (j16 > 0 && j3 > j16) {
            return -1;
        }
        return this.mDataSource.readAt(j3, bArr, i3, i16);
    }

    public void setEndBytePosition(long j3) {
        this.mEndBytePosition = j3;
    }

    public void setTrackStateCallback(TrackStateCallback trackStateCallback) {
        this.mTrackStateCallback = trackStateCallback;
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i3) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i3) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i3) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onError(BaseMediaPlayer baseMediaPlayer, int i3, int i16, int i17) {
    }
}
