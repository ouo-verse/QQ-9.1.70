package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProFeedStat implements Serializable {
    public long pageView;
    public long preferCount;
    public int preferStatus;
    long serialVersionUID = 1;
    public long shareCount;
    public long totalCommentCount;

    public GProFeedStat() {
    }

    public long getPageView() {
        return this.pageView;
    }

    public long getPreferCount() {
        return this.preferCount;
    }

    public int getPreferStatus() {
        return this.preferStatus;
    }

    public long getShareCount() {
        return this.shareCount;
    }

    public long getTotalCommentCount() {
        return this.totalCommentCount;
    }

    public void setPageView(long j3) {
        this.pageView = j3;
    }

    public void setPreferCount(long j3) {
        this.preferCount = j3;
    }

    public void setPreferStatus(int i3) {
        this.preferStatus = i3;
    }

    public void setShareCount(long j3) {
        this.shareCount = j3;
    }

    public void setTotalCommentCount(long j3) {
        this.totalCommentCount = j3;
    }

    public String toString() {
        return "GProFeedStat{pageView=" + this.pageView + ",shareCount=" + this.shareCount + ",totalCommentCount=" + this.totalCommentCount + ",preferCount=" + this.preferCount + ",preferStatus=" + this.preferStatus + ",}";
    }

    public GProFeedStat(long j3, long j16, long j17, long j18, int i3) {
        this.pageView = j3;
        this.shareCount = j16;
        this.totalCommentCount = j17;
        this.preferCount = j18;
        this.preferStatus = i3;
    }
}
