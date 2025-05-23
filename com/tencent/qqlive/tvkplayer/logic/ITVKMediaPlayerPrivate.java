package com.tencent.qqlive.tvkplayer.logic;

import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;

/* loaded from: classes23.dex */
public interface ITVKMediaPlayerPrivate {

    /* loaded from: classes23.dex */
    public interface ITVKStateKeeperListener extends ITVKMediaPlayer.OnVideoPreparedListener {
        void onAdPlayComplete(int i3, Object obj);

        void onAdPlayError(int i3, Object obj);

        void onAdRequestPauseVideo();

        void onAdRequestResumeVideo();
    }

    void addOptionalParam(TPOptionalParam<?> tPOptionalParam);

    void enablePlayerCallbackInterception(boolean z16);

    int getAdState();

    String getProperty(String str) throws IllegalStateException;

    ITVKTPPlayer getTVKTPPlayer();

    void removePendingPlayerCallback();

    void setStateKeeperListener(ITVKStateKeeperListener iTVKStateKeeperListener);
}
