package com.tencent.qqlive.tvkplayer.logo.manager;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoImplFactory;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoMgr implements ITVKLogoMgr {
    private static final String TAG = "TVKLogoMgr";
    private final int mLogoViewType;
    private TVKContext mTVKContext;
    private int mVideoH;
    private int mVideoW;
    private final ViewGroup mViewGroup;
    private final ITVKLogger mLogger = new TVKLogger(null, TAG);
    private ITVKLogoImpl mLogoImpl = null;
    private int mXYAxisType = 0;
    private boolean mIsDynamicLogoOpen = true;
    private boolean mIsStaticLogoOpen = true;
    private TVKLogoCommonDefine.TVKOriginalLogoInfo mOriginalLogoInfo = null;

    public TVKLogoMgr(TVKContext tVKContext, ViewGroup viewGroup, int i3) {
        this.mTVKContext = tVKContext;
        this.mViewGroup = viewGroup;
        this.mLogoViewType = i3;
    }

    private void changeLogoImplByLogoType(int i3) {
        ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
        if (iTVKLogoImpl != null) {
            iTVKLogoImpl.release();
        }
        ITVKLogoImpl createLogoImpl = TVKLogoImplFactory.createLogoImpl(this.mTVKContext, this.mViewGroup, i3, this.mLogoViewType);
        this.mLogoImpl = createLogoImpl;
        createLogoImpl.setXYaxis(this.mXYAxisType);
        this.mLogoImpl.setVideoSize(this.mVideoW, this.mVideoH);
        this.mLogoImpl.updateLogoInfo(this.mOriginalLogoInfo);
    }

    private int getLogoTypeFromLogoInfo(TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo) {
        if (tVKOriginalLogoInfo == null) {
            return 0;
        }
        if (TextUtils.isEmpty(tVKOriginalLogoInfo.vodDynamicLogoActionUrl) && tVKOriginalLogoInfo.liveDynamicLogoInfo == null) {
            if (tVKOriginalLogoInfo.logoInfoList == null) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    private void resetAllParams() {
        this.mVideoW = 0;
        this.mVideoH = 0;
        this.mIsDynamicLogoOpen = true;
        this.mIsStaticLogoOpen = true;
        this.mXYAxisType = 0;
    }

    private void resetLogo() {
        ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
        if (iTVKLogoImpl != null) {
            iTVKLogoImpl.release();
            this.mLogoImpl = null;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public boolean draw() {
        ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
        if (iTVKLogoImpl != null) {
            return iTVKLogoImpl.draw();
        }
        this.mLogger.info("logoImpl is null, can't draw", new Object[0]);
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public boolean isLogoEnabled() {
        if (!this.mIsDynamicLogoOpen && !this.mIsStaticLogoOpen) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void reset() {
        resetLogo();
        resetAllParams();
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void resetStartTime() {
        ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
        if (iTVKLogoImpl != null) {
            iTVKLogoImpl.resetStartTime();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setDynamicLogoOpen(boolean z16) {
        this.mLogger.info("setDynamicLogoOpen " + z16, new Object[0]);
        if (this.mIsDynamicLogoOpen == z16) {
            return;
        }
        if (z16 && getLogoTypeFromLogoInfo(this.mOriginalLogoInfo) == 2) {
            changeLogoImplByLogoType(2);
        } else {
            ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
            if (iTVKLogoImpl != null && iTVKLogoImpl.getCurrentLogoType() == 2) {
                resetLogo();
            }
        }
        this.mIsDynamicLogoOpen = z16;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setStaticLogoOpen(boolean z16) {
        this.mLogger.info("setStaticLogoOpen " + z16, new Object[0]);
        if (this.mIsStaticLogoOpen == z16) {
            return;
        }
        if (z16 && getLogoTypeFromLogoInfo(this.mOriginalLogoInfo) == 1) {
            changeLogoImplByLogoType(1);
        } else {
            ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
            if (iTVKLogoImpl != null && iTVKLogoImpl.getCurrentLogoType() == 1) {
                resetLogo();
            }
        }
        this.mIsStaticLogoOpen = z16;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setVideoSize(int i3, int i16) {
        this.mVideoW = i3;
        this.mVideoH = i16;
        ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
        if (iTVKLogoImpl != null) {
            iTVKLogoImpl.setVideoSize(i3, i16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void setXYAxis(int i3) {
        this.mXYAxisType = i3;
        ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
        if (iTVKLogoImpl != null) {
            iTVKLogoImpl.setXYaxis(i3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void updateLogoInfo(@NonNull TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo) {
        if (tVKOriginalLogoInfo == null) {
            this.mLogger.info("originalLogoInfo is null", new Object[0]);
            return;
        }
        this.mOriginalLogoInfo = tVKOriginalLogoInfo;
        int logoTypeFromLogoInfo = getLogoTypeFromLogoInfo(tVKOriginalLogoInfo);
        this.mLogger.info("isDynamicLogoOpen=" + this.mIsDynamicLogoOpen + ", isStaticLogoOpen=" + this.mIsStaticLogoOpen, new Object[0]);
        if (logoTypeFromLogoInfo != 0 && ((logoTypeFromLogoInfo != 2 || this.mIsDynamicLogoOpen) && (logoTypeFromLogoInfo != 1 || this.mIsStaticLogoOpen))) {
            ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
            if (iTVKLogoImpl != null && iTVKLogoImpl.getCurrentLogoType() == logoTypeFromLogoInfo) {
                this.mLogoImpl.updateLogoInfo(tVKOriginalLogoInfo);
                return;
            }
            changeLogoImplByLogoType(logoTypeFromLogoInfo);
            this.mLogger.info("updateLogoInfo done, mLogoImpl: " + this.mLogoImpl, new Object[0]);
            return;
        }
        resetLogo();
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.manager.ITVKLogoMgr
    public void updatePlayerPositionMs(long j3) {
        ITVKLogoImpl iTVKLogoImpl = this.mLogoImpl;
        if (iTVKLogoImpl != null) {
            iTVKLogoImpl.updatePlayerPositionMs(j3);
        }
    }
}
