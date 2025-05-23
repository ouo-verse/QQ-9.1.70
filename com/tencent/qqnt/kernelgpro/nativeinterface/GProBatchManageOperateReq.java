package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBatchManageOperateReq {
    public long channelId;
    public long guildId;
    public int operateType;
    public long orgChannelId;
    public boolean removePoster;
    public GProSelectParam include = new GProSelectParam();
    public GProSelectParam exclude = new GProSelectParam();

    public long getChannelId() {
        return this.channelId;
    }

    public GProSelectParam getExclude() {
        return this.exclude;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProSelectParam getInclude() {
        return this.include;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public long getOrgChannelId() {
        return this.orgChannelId;
    }

    public boolean getRemovePoster() {
        return this.removePoster;
    }

    public String toString() {
        return "GProBatchManageOperateReq{guildId=" + this.guildId + ",orgChannelId=" + this.orgChannelId + ",operateType=" + this.operateType + ",include=" + this.include + ",exclude=" + this.exclude + ",channelId=" + this.channelId + ",removePoster=" + this.removePoster + ",}";
    }
}
