package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSendNoticeReq {
    public long appId;
    public long channelId;
    public long guildId;
    public long roomId;
    public String authMeta = "";
    public GProAVChannelNoticeMemberInfo notifyMemberInfo = new GProAVChannelNoticeMemberInfo();

    public long getAppId() {
        return this.appId;
    }

    public String getAuthMeta() {
        return this.authMeta;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProAVChannelNoticeMemberInfo getNotifyMemberInfo() {
        return this.notifyMemberInfo;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProSendNoticeReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",authMeta=" + this.authMeta + ",appId=" + this.appId + ",roomId=" + this.roomId + ",notifyMemberInfo=" + this.notifyMemberInfo + ",}";
    }
}
