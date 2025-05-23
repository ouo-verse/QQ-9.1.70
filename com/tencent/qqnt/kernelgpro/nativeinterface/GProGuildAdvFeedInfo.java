package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildAdvFeedInfo {
    public long feedCreateTime;
    public String feedId = "";
    public long uin;

    public long getFeedCreateTime() {
        return this.feedCreateTime;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProGuildAdvFeedInfo{uin=" + this.uin + ",feedId=" + this.feedId + ",feedCreateTime=" + this.feedCreateTime + ",}";
    }
}
