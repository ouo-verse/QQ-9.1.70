package com.tencent.biz.qqcircle.beans;

/* loaded from: classes4.dex */
public class QFSPersonalGuildInfoInitBean extends QCircleInitBean {
    private boolean mIsNeedShow;
    private long mSelectGuildId = 0;

    public long getSelectGuildId() {
        return this.mSelectGuildId;
    }

    public boolean isNeedShow() {
        return this.mIsNeedShow;
    }

    public void setIsNeedShow(boolean z16) {
        this.mIsNeedShow = z16;
    }

    public void setSelectGuildId(long j3) {
        this.mSelectGuildId = j3;
    }
}
