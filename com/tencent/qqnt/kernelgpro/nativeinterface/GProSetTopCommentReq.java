package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSetTopCommentReq {
    public long channelId;
    public long guildId;
    public int setType;
    public String feedId = "";
    public String commentId = "";
    public ArrayList<GProSetTopCommentReqExtInfoEntry> extInfoList = new ArrayList<>();

    public long getChannelId() {
        return this.channelId;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public ArrayList<GProSetTopCommentReqExtInfoEntry> getExtInfoList() {
        return this.extInfoList;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getSetType() {
        return this.setType;
    }

    public String toString() {
        return "GProSetTopCommentReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",feedId=" + this.feedId + ",commentId=" + this.commentId + ",setType=" + this.setType + ",extInfoList=" + this.extInfoList + ",}";
    }
}
