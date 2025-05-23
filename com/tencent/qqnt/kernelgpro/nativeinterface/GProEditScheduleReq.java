package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProEditScheduleReq {
    public int chanelType;
    public long channelId;
    public int editType;
    public long guildId;
    public GProScheduleInfo scheduleInfo = new GProScheduleInfo();

    public int getChanelType() {
        return this.chanelType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getEditType() {
        return this.editType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProScheduleInfo getScheduleInfo() {
        return this.scheduleInfo;
    }

    public String toString() {
        return "GProEditScheduleReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",chanelType=" + this.chanelType + ",scheduleInfo=" + this.scheduleInfo + ",editType=" + this.editType + ",}";
    }
}
