package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetNextPageRepliesReq {
    public int pageSize;
    public String feedId = "";
    public String commentId = "";
    public String attachInfo = "";
    public GProStChannelSign channelSign = new GProStChannelSign();

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String toString() {
        return "GProGetNextPageRepliesReq{feedId=" + this.feedId + ",commentId=" + this.commentId + ",pageSize=" + this.pageSize + ",attachInfo=" + this.attachInfo + ",channelSign=" + this.channelSign + ",}";
    }
}
