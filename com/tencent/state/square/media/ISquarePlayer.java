package com.tencent.state.square.media;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\tH&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\tH&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/media/ISquarePlayer;", "", "getState", "Lcom/tencent/state/square/media/PlayerState;", "getVideoSource", "Lcom/tencent/state/square/media/MediaSource;", "isDestroying", "", "pause", "", "release", "reset", "resume", "setListener", "listener", "Lcom/tencent/state/square/media/ISquarePlayer$Listener;", "setLoopPlay", "isLoopPlay", "setPlayConfig", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/media/PlayConfig;", "start", "source", "stop", "Listener", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquarePlayer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/media/ISquarePlayer$Listener;", "", "onVideoDestroy", "", "onVideoError", "code", "", "message", "", "onVideoFirstFrame", "onVideoLoop", "onVideoLoopStart", "onVideoPause", "onVideoResume", "onVideoStart", "onVideoStop", "from", "Lcom/tencent/state/square/media/StopFrom;", "square_media_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface Listener {
        void onVideoDestroy();

        void onVideoError(int code, String message);

        void onVideoFirstFrame();

        void onVideoLoop();

        void onVideoLoopStart();

        void onVideoPause();

        void onVideoResume();

        void onVideoStart();

        void onVideoStop(StopFrom from);
    }

    PlayerState getState();

    MediaSource getVideoSource();

    boolean isDestroying();

    void pause();

    void release();

    void reset();

    void resume();

    void setListener(Listener listener);

    void setLoopPlay(boolean isLoopPlay);

    void setPlayConfig(PlayConfig config);

    void start();

    void start(MediaSource source);

    void stop();
}
