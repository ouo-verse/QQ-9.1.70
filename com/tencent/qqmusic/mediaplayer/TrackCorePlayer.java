package com.tencent.qqmusic.mediaplayer;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

/* loaded from: classes23.dex */
class TrackCorePlayer extends CorePlayer implements TrackDataSource.TrackStateCallback {
    private static final String TAG = "TrackCorePlayer";
    private long mStartPosition;

    public TrackCorePlayer(@NonNull IDataSource iDataSource, @NonNull PlayerCallback playerCallback, @NonNull Looper looper, @NonNull QMThreadExecutor qMThreadExecutor) {
        super(iDataSource, null, playerCallback, looper, new NativeDecoder(), qMThreadExecutor);
        this.mStartPosition = 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.CorePlayer
    public long getCurPosition() {
        return super.getCurPosition() - this.mStartPosition;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource.TrackStateCallback
    public void onTrackPrepared(TrackInfo trackInfo) {
        this.mStartPosition = ((Long) trackInfo.getRange().first).longValue();
        long longValue = ((Long) trackInfo.getRange().second).longValue();
        long longValue2 = ((Long) trackInfo.getRange().first).longValue();
        Logger.i(TAG, "onTrackPrepared, start byte: " + longValue2 + ", end byte: " + longValue);
        this.mInformation.setDuration(longValue - longValue2);
    }

    @Override // com.tencent.qqmusic.mediaplayer.CorePlayer
    public void seek(int i3) {
        int i16 = (int) (i3 + this.mStartPosition);
        Logger.i(TAG, "seek, position: " + i3 + " ,realseek: " + i16);
        super.seek(i16);
    }
}
