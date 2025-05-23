package com.tencent.tav.player;

import android.graphics.SurfaceTexture;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* loaded from: classes26.dex */
public interface IPlayer {

    /* loaded from: classes26.dex */
    public interface PlayerListener {
        void onPositionChanged(CMTime cMTime);

        void onStatusChanged(PlayerStatus playerStatus);
    }

    /* loaded from: classes26.dex */
    public enum PlayerStatus {
        IDLE,
        READY,
        PLAYING,
        STOPPED,
        PAUSED,
        FINISHED,
        ERROR,
        REPLAY
    }

    /* loaded from: classes26.dex */
    public interface TextureViewListener {
        void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);
    }

    PlayerStatus currentStatus();

    CMTime duration();

    CMTimeRange getPlayRange();

    boolean isPlaying();

    void pause();

    void play();

    CMTime position();

    void release();

    void release(Runnable runnable);

    void seekToTime(CMTime cMTime, Callback callback);

    void setLoop(boolean z16);

    void setOnCompositionUpdateListener(OnCompositionUpdateListener onCompositionUpdateListener);

    void setPlayRange(CMTimeRange cMTimeRange);

    void setPlayerListener(PlayerListener playerListener);

    void setVolume(float f16);

    void stop();

    void update(PlayerItem playerItem, CMTime cMTime);

    void updateAudioClipsProperties();

    void updateAudioVolumeProperties();

    int videoHeight();

    int videoWidth();

    void waitForRelease(long j3);
}
