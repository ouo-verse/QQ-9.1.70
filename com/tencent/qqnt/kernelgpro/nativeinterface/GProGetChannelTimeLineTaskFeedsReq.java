package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetChannelTimeLineTaskFeedsReq {
    public String attachInfo = "";
    public long channelId;
    public int count;
    public long guildId;
    public int sortOption;

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getCount() {
        return this.count;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getSortOption() {
        return this.sortOption;
    }

    public String toString() {
        return "GProGetChannelTimeLineTaskFeedsReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",count=" + this.count + ",sortOption=" + this.sortOption + ",attachInfo=" + this.attachInfo + ",}";
    }
}
