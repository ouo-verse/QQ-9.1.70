package com.tencent.qqlive.tvkplayer.videotrack;

import android.view.ViewGroup;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;

/* loaded from: classes23.dex */
public interface ITVKVideoTrackPlayerMgr {

    /* loaded from: classes23.dex */
    public interface VideoTrackMgrOnListener {
        boolean onCanBePlay();

        void onRequestPause();

        void onRequestResume();

        void onTrackOpen();
    }

    void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener);

    void addReportEventListener(ITVKReportEventListener iTVKReportEventListener);

    void addTrack(int i3, String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalArgumentException;

    void deselectTrack(TVKTrackInfo tVKTrackInfo);

    int getSelectedTrack(int i3);

    TVKTrackInfo[] getTrackInfo();

    boolean isVideoTrackEmpty();

    void onClickPause();

    void onClickPause(ViewGroup viewGroup);

    void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException;

    void pause();

    void pauseDownload();

    void refreshPlayer();

    void refreshPlayerWithReopen();

    void release();

    void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener);

    void removeReportEventListener(ITVKReportEventListener iTVKReportEventListener);

    void resumeDownload();

    void saveReport();

    void seekTo(int i3);

    void seekToAccuratePos(int i3);

    void selectTrack(TVKTrackInfo tVKTrackInfo);

    void setPlaySpeedRatio(float f16);

    void setVideoTrackPlayerMgrListener(VideoTrackMgrOnListener videoTrackMgrOnListener);

    void start();

    void stop();

    void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException;

    void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException;

    void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException;

    void updateMasterPlayer(ITVKTPPlayer iTVKTPPlayer);

    void updatePlayerPositionMs(long j3);

    void updatePlayerType(int i3);

    void updateReportParam(TVKProperties tVKProperties);

    void updateUserInfo(TVKUserInfo tVKUserInfo);
}
