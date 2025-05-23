package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFeedParam {
    public long createTime;
    public String userId = "";
    public String feedId = "";

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "GProFeedParam{userId=" + this.userId + ",feedId=" + this.feedId + ",createTime=" + this.createTime + ",}";
    }
}
