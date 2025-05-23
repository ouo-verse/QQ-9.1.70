package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetTopicFeedsReq {
    public int count;
    public int getType;
    public long guildId;
    public long topicId;
    public byte[] attachInfo = new byte[0];
    public String topFeedId = "";

    public byte[] getAttachInfo() {
        return this.attachInfo;
    }

    public int getCount() {
        return this.count;
    }

    public int getGetType() {
        return this.getType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getTopFeedId() {
        return this.topFeedId;
    }

    public long getTopicId() {
        return this.topicId;
    }

    public String toString() {
        return "GProGetTopicFeedsReq{topicId=" + this.topicId + ",count=" + this.count + ",getType=" + this.getType + ",attachInfo=" + this.attachInfo + ",topFeedId=" + this.topFeedId + ",guildId=" + this.guildId + ",}";
    }
}
