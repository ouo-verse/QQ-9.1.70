package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetGuildAndChannelReq {
    public int businessType;
    public long channelId;
    public long guildId;
    public GProCmd0x1258FieldFilter fieldFilter = new GProCmd0x1258FieldFilter();
    public String inviteCode = "";
    public GProGetUserList getUserList = new GProGetUserList();
    public String guildNum = "";

    public int getBusinessType() {
        return this.businessType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProCmd0x1258FieldFilter getFieldFilter() {
        return this.fieldFilter;
    }

    public GProGetUserList getGetUserList() {
        return this.getUserList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildNum() {
        return this.guildNum;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String toString() {
        return "GProGetGuildAndChannelReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",fieldFilter=" + this.fieldFilter + ",businessType=" + this.businessType + ",inviteCode=" + this.inviteCode + ",getUserList=" + this.getUserList + ",guildNum=" + this.guildNum + ",}";
    }
}
