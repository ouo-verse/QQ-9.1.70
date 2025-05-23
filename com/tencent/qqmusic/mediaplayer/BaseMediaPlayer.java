package com.tencent.qqmusic.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.DataSourceException;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: classes23.dex */
public abstract class BaseMediaPlayer {
    public static final int DECODER_TYPE_ANDROID_MEDIA_PLAYER = 0;
    public static final int DECODER_TYPE_MEDIA_CODEC = 2;
    public static final int DECODER_TYPE_SOFT = 1;
    private static final String TAG = "BaseMediaPlayer";
    private long startTime = 0;
    private long duration = 0;
    private boolean isPaused = false;
    protected String mCacheDir = null;

    public abstract void TransferStateTo(int i3);

    public abstract void addAudioListener(@NonNull IAudioListener iAudioListener);

    public abstract SeekTable createSeekTable() throws IllegalStateException;

    public abstract void flush();

    public long getCurPlayTime() {
        if (this.startTime <= 0) {
            return 0L;
        }
        if (this.isPaused) {
            return this.duration;
        }
        return (this.duration + SystemClock.elapsedRealtime()) - this.startTime;
    }

    public abstract AudioInformation getCurrentAudioInformation();

    public abstract long getCurrentPosition() throws IllegalStateException;

    public abstract long getCurrentPositionFromFile() throws IllegalStateException;

    public abstract int getDecoderType();

    public abstract int getDuration() throws IllegalStateException;

    public abstract int getPlayerState();

    public abstract int getSessionId();

    public abstract boolean isPlaying() throws IllegalStateException;

    public void notifyPauseSong() {
        this.isPaused = true;
        if (this.startTime > 0) {
            this.duration += SystemClock.elapsedRealtime() - this.startTime;
        }
    }

    public void notifyStartPlaySong() {
        this.isPaused = false;
        this.startTime = SystemClock.elapsedRealtime();
    }

    public abstract void pause() throws IllegalStateException;

    public abstract void pauseRealTime() throws IllegalStateException;

    public abstract void prepare() throws IllegalStateException, IOException;

    public abstract void prepareAsync() throws IllegalStateException, IOException, UnSupportMethodException;

    public abstract void release();

    public abstract void removeAudioListener(@NonNull IAudioListener iAudioListener);

    public abstract void reset() throws IllegalStateException;

    public abstract void seekTo(int i3) throws IllegalStateException;

    public abstract void setAudioStreamType(int i3) throws IllegalStateException;

    public abstract void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, IllegalStateException, SecurityException;

    public abstract void setDataSource(Context context, UriLoader uriLoader) throws DataSourceException;

    public abstract void setDataSource(TrackInfo trackInfo) throws IllegalArgumentException, IllegalStateException, DataSourceException, IOException;

    public abstract void setDataSource(IMediaHTTPService iMediaHTTPService, Uri uri) throws IllegalArgumentException, IllegalStateException;

    public abstract void setDataSource(IDataSourceFactory iDataSourceFactory) throws IllegalArgumentException, IllegalStateException, DataSourceException;

    public abstract void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalStateException, IllegalArgumentException, IllegalStateException, UnSupportMethodException;

    public abstract void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    public void setOnlinePlayCacheDir(@NonNull String str) {
        if (new File(str).isDirectory()) {
            this.mCacheDir = str;
            return;
        }
        Logger.e(TAG, "setOnlinePlayCacheDir cacheDir is invalid! cacheDir = " + str);
    }

    public abstract void setPlayerListenerCallback(PlayerListenerCallback playerListenerCallback);

    public abstract void setVolume(float f16, float f17) throws IllegalStateException;

    public abstract void setWakeMode(Context context, int i3) throws IllegalStateException, UnSupportMethodException;

    public abstract void start() throws IllegalStateException;

    public abstract void stop() throws IllegalStateException;

    public void setLeastCommonMultiple(int i3) {
    }

    public void setPlayLocalPath(String str) {
    }
}
