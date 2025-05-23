package com.tencent.qqlive.tvkplayer.ad.api;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.event.ITVKEventObserver;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAdManagerEmpty implements ITVKAdManager, ITVKEventObserver {
    private static final String TAG = "TVKAdManagerEmpty";
    private final ITVKLogger mLogger;
    private final TVKContext mTVKContext;

    public TVKAdManagerEmpty(@NonNull TVKContext tVKContext) {
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, TAG);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void closeAd(int i3) {
        this.mLogger.info("close ad", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public int getAdState() {
        return 1;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public Object getAdStatus() {
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public int getAdType() {
        return -1;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public long getCurrentPosition() {
        return 0L;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public long getRemainTime(int i3) {
        return 0L;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public boolean isPaused() {
        this.mLogger.info("isPaused", new Object[0]);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public boolean isPlaying() {
        this.mLogger.info("isPlaying", new Object[0]);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public boolean onKeyEvent(KeyEvent keyEvent) {
        this.mLogger.info("on key event", new Object[0]);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin
    public void onLoad() {
        this.mTVKContext.getEventSender().registerObserver(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public boolean onTouchEvent(View view, MotionEvent motionEvent) {
        this.mLogger.info("on touch event", new Object[0]);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin
    public void onUnload() {
        this.mTVKContext.getEventSender().unregisterObserver(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public boolean pauseAd() {
        this.mLogger.info("pause ad", new Object[0]);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void release() {
        this.mLogger.info("release", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void reset() {
        this.mLogger.info("reset", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void setAudioGainRatio(float f16) {
        this.mLogger.info("set audio gain ratio", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void setOutputMute(boolean z16) {
        this.mLogger.info("set out put mute", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public boolean skipAd() {
        this.mLogger.info("skipAd", new Object[0]);
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public ITVKAdCommons.AdResult startAd() {
        this.mLogger.info("start ad", new Object[0]);
        return new ITVKAdCommons.AdResult();
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void updateDefinition(String str) {
        this.mLogger.info("update definition", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void updatePlayerView(ITVKVideoViewBase iTVKVideoViewBase) {
        this.mLogger.info("update player view", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void updateUserInfo(TVKUserInfo tVKUserInfo) {
        this.mLogger.info("update user info", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager
    public void onRealTimeInfoChange(int i3, Object obj) {
    }

    @Override // com.tencent.qqlive.tvkplayer.event.ITVKEventObserver
    public void onEvent(int i3, int i16, int i17, String str, Object obj) {
    }
}
