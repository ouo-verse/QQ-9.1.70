package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleNotifyInfo {
    public int atType;
    public long channelId;
    public long guildId;
    public boolean needNotify;
    public GProScheduleInfo scheduleInfo = new GProScheduleInfo();

    public int getAtType() {
        return this.atType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getNeedNotify() {
        return this.needNotify;
    }

    public GProScheduleInfo getScheduleInfo() {
        return this.scheduleInfo;
    }

    public String toString() {
        return "GProScheduleNotifyInfo{scheduleInfo=" + this.scheduleInfo + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",needNotify=" + this.needNotify + ",atType=" + this.atType + ",}";
    }
}
