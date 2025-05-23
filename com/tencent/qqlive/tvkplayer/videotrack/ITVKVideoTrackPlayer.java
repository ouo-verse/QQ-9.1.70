package com.tencent.qqlive.tvkplayer.videotrack;

import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes23.dex */
public interface ITVKVideoTrackPlayer {
    public static final int COMPLETE = 7;
    public static final int ERROR = 9;
    public static final int IDLE = 1;
    public static final int INDEX = 0;
    public static final int PAUSED = 6;
    public static final int PREPARED = 4;
    public static final int PREPARING = 3;
    public static final int SELECTED = 2;
    public static final int STARTED = 5;
    public static final int STOPPED = 8;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface STATE {
    }

    /* loaded from: classes23.dex */
    public interface VideoTrackPlayerListener {
        void onCompletion(ITVKVideoTrackPlayer iTVKVideoTrackPlayer);

        void onEndBuffering(ITVKVideoTrackPlayer iTVKVideoTrackPlayer);

        boolean onError(ITVKVideoTrackPlayer iTVKVideoTrackPlayer, TVKError tVKError);

        void onNetVideoInfo(ITVKVideoTrackPlayer iTVKVideoTrackPlayer, TVKNetVideoInfo tVKNetVideoInfo);

        void onSeekComplete(ITVKVideoTrackPlayer iTVKVideoTrackPlayer);

        void onStartBuffering(ITVKVideoTrackPlayer iTVKVideoTrackPlayer);

        void onVideoPrepared(ITVKVideoTrackPlayer iTVKVideoTrackPlayer);
    }

    void activeConnection();

    void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener);

    void deSelect();

    TVKVideoTrackInfo getVideoTrackInfo();

    boolean isSelected();

    void openMediaPlayer(long j3, long j16);

    void pause();

    void pauseDownload();

    void release();

    void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener);

    void resumeDownload();

    void saveReport();

    void seekTo(int i3);

    void seekToAccuratePos(int i3);

    void select();

    void setPlaySpeedRatio(float f16);

    void setVideoTrackPlayerListener(VideoTrackPlayerListener videoTrackPlayerListener);

    void start();

    int state();

    void stop();

    void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException;

    void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException;

    void updateMasterPlayer(ITVKTPPlayer iTVKTPPlayer);

    void updateReportParam(TVKProperties tVKProperties);
}
