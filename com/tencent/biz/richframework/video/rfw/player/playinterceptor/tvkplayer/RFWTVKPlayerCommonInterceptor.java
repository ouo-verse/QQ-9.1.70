package com.tencent.biz.richframework.video.rfw.player.playinterceptor.tvkplayer;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class RFWTVKPlayerCommonInterceptor extends RFWPlayerBaseInterceptor {
    private volatile TVKNetVideoInfo mTVKNetVideoInfo;
    private final Map<Integer, Object> mTvkInfoMap;

    public RFWTVKPlayerCommonInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
        this.mTVKNetVideoInfo = null;
        this.mTvkInfoMap = new HashMap();
    }

    private void setIsActive(int i3) {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRealPlayer() != null) {
            this.mPlayer.getRealPlayer().onRealTimeInfoChange(1, Integer.valueOf(i3));
            RFWLog.d(getTag(), RFWLog.USR, "set player activity:" + i3);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.afterOpenMedia(superPlayerOption, iSuperPlayer);
        if (this.mPlayerOptions.isPreloadPlayer()) {
            setIsActive(1);
        }
    }

    public TVKNetVideoInfo getTVKNetVideoInfo() {
        return this.mTVKNetVideoInfo;
    }

    public Map<Integer, Object> getTvkInfoMap() {
        return this.mTvkInfoMap;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onInfo(int i3, long j3, long j16, Object obj) {
        super.onInfo(i3, j3, j16, obj);
        this.mTvkInfoMap.put(Integer.valueOf(i3), obj);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        super.onNetVideoInfo(tVKNetVideoInfo);
        this.mTVKNetVideoInfo = tVKNetVideoInfo;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        setIsActive(0);
    }
}
