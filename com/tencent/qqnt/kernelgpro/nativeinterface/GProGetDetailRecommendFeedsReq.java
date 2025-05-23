package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetDetailRecommendFeedsReq {
    public int count;
    public long guildId;
    public String feedId = "";
    public byte[] attachInfo = new byte[0];

    public byte[] getAttachInfo() {
        return this.attachInfo;
    }

    public int getCount() {
        return this.count;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetDetailRecommendFeedsReq{feedId=" + this.feedId + ",count=" + this.count + ",attachInfo=" + this.attachInfo + ",guildId=" + this.guildId + ",}";
    }
}
