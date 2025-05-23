package com.tencent.biz.richframework.part.block.base;

import com.tencent.biz.richframework.config.RFWCommonConfig;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LoadInfo {
    private int curLoadMoreAction;
    private String mSAttachInfo;
    private volatile boolean isFinish = true;
    private volatile boolean canPageUp = false;
    private volatile int mCurrentState = 4;
    private String mRefreshAttachInfo = null;
    private String mAdAttachInfo = null;
    private String mSPageUpAttachInfo = null;

    public boolean canPageUp() {
        return this.canPageUp;
    }

    public int getCurLoadMoreAction() {
        return this.curLoadMoreAction;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public String getSPageUpAttachInfo() {
        return this.mSPageUpAttachInfo;
    }

    public String getStringAttachInfo() {
        return this.mSAttachInfo;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    public boolean isInitState() {
        if (this.mCurrentState == 1) {
            return true;
        }
        return false;
    }

    public boolean isLoadMoreState() {
        if (this.mCurrentState == 3) {
            return true;
        }
        return false;
    }

    public boolean isLoading() {
        if (this.mCurrentState != 4) {
            return true;
        }
        return false;
    }

    public boolean isRefreshState() {
        if (this.mCurrentState == 2) {
            return true;
        }
        return false;
    }

    public void setAdAttachInfo(String str) {
        if (str != null) {
            RFWCommonConfig.setCurrentAdInfo(str);
        }
        this.mAdAttachInfo = str;
    }

    public void setCanPageUp(boolean z16) {
        this.canPageUp = z16;
    }

    public void setCurLoadMoreAction(int i3) {
        this.curLoadMoreAction = i3;
    }

    public void setCurrentState(int i3) {
        this.mCurrentState = i3;
    }

    public void setFinish(boolean z16) {
        this.isFinish = z16;
    }

    public void setPageUpAttachInfo(String str) {
        this.mSPageUpAttachInfo = str;
    }

    public void setRefreshAttachInfo(String str) {
        this.mRefreshAttachInfo = str;
    }

    public void setStringAttachInfo(String str) {
        this.mSAttachInfo = str;
    }

    public String toString() {
        return "LoadInfo{isFinish=" + this.isFinish + ", mCurrentState=" + this.mCurrentState + ", mSAttachInfo='" + this.mSAttachInfo + "', mRefreshAttachInfo='" + this.mRefreshAttachInfo + "'}";
    }
}
