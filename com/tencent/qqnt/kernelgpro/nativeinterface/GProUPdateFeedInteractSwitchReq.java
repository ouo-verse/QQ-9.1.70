package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUPdateFeedInteractSwitchReq {
    public long channelId;
    public String feedId = "";
    public long guildId;
    public int operateType;

    public long getChannelId() {
        return this.channelId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public String toString() {
        return "GProUPdateFeedInteractSwitchReq{feedId=" + this.feedId + ",operateType=" + this.operateType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }
}
