package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAVChannelNotice {
    public long appId;
    public long channelId;
    public long guildId;
    public long noticeId;
    public long roomId;
    public long timeStamp;
    public byte[] voiceChannelInfo = new byte[0];
    public byte[] resultItem = new byte[0];
    public GProAVChannelNoticeMemberInfo notifyMemberInfo = new GProAVChannelNoticeMemberInfo();

    public long getAppId() {
        return this.appId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getNoticeId() {
        return this.noticeId;
    }

    public GProAVChannelNoticeMemberInfo getNotifyMemberInfo() {
        return this.notifyMemberInfo;
    }

    public byte[] getResultItem() {
        return this.resultItem;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public byte[] getVoiceChannelInfo() {
        return this.voiceChannelInfo;
    }

    public String toString() {
        return "GProAVChannelNotice{noticeId=" + this.noticeId + ",timeStamp=" + this.timeStamp + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",appId=" + this.appId + ",roomId=" + this.roomId + ",voiceChannelInfo=" + this.voiceChannelInfo + ",resultItem=" + this.resultItem + ",notifyMemberInfo=" + this.notifyMemberInfo + ",}";
    }
}
