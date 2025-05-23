package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSubscribePollingScheduleReq {
    public long channelId;
    public long guildId;
    public long scheduleId;

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public String toString() {
        return "GProSubscribePollingScheduleReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",scheduleId=" + this.scheduleId + ",}";
    }
}
