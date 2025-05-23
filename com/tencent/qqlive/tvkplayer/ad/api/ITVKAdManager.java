package com.tencent.qqlive.tvkplayer.ad.api;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKAdManager extends ITVKPlugin {
    void closeAd(int i3);

    int getAdState();

    Object getAdStatus();

    int getAdType();

    long getCurrentPosition();

    long getRemainTime(int i3);

    boolean isPaused();

    boolean isPlaying();

    boolean onKeyEvent(KeyEvent keyEvent);

    void onRealTimeInfoChange(int i3, Object obj);

    boolean onTouchEvent(View view, MotionEvent motionEvent);

    boolean pauseAd();

    void release();

    void reset();

    void setAudioGainRatio(float f16);

    void setOutputMute(boolean z16);

    boolean skipAd();

    ITVKAdCommons.AdResult startAd();

    void updateDefinition(String str);

    void updatePlayerView(ITVKVideoViewBase iTVKVideoViewBase);

    void updateUserInfo(TVKUserInfo tVKUserInfo);
}
