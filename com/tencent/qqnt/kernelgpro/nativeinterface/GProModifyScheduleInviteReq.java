package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProModifyScheduleInviteReq {
    public int chanelType;
    public long channelId;
    public long guildId;
    public int inviteStatus;
    public long scheduleId;

    public int getChanelType() {
        return this.chanelType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public String toString() {
        return "GProModifyScheduleInviteReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",chanelType=" + this.chanelType + ",scheduleId=" + this.scheduleId + ",inviteStatus=" + this.inviteStatus + ",}";
    }
}
