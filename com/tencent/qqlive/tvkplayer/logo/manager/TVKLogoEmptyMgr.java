package com.tencent.qqlive.tvkplayer.logo.manager;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoEmptyMgr implements ITVKLogoMgr {
    private static final String TAG = "TVKLogoEmptyMgr";
    private final ITVKLogger mLogger;

    public TVKLogoEmptyMgr(TVKContext tVKContext) {
        this.mLogger = new TVKLogger(tVKContext, TAG);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public boolean draw() {
        this.mLogger.info("not support draw", new Object[0]);
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public boolean isLogoEnabled() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void reset() {
        this.mLogger.info("not support reset", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void resetStartTime() {
        this.mLogger.info("not support resetStartTime", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setDynamicLogoOpen(boolean z16) {
        this.mLogger.info("not support setDynamicLogoOpen", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setStaticLogoOpen(boolean z16) {
        this.mLogger.info("not support setStaticLogoOpen", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setVideoSize(int i3, int i16) {
        this.mLogger.info("not support setVideoSize", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setXYAxis(int i3) {
        this.mLogger.info("not support setXYAxis", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void updateLogoInfo(@NonNull TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo) {
        this.mLogger.info("not support updateLogoInfo", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void updatePlayerPositionMs(long j3) {
        this.mLogger.info("not support updatePlayerPositionMs", new Object[0]);
    }
}
