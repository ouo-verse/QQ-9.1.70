package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSchedulePollingInfo {
    public long channelId;
    public long guildId;
    public ArrayList<GProScheduleStatusInfo> schedulerStatus = new ArrayList<>();

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProScheduleStatusInfo> getSchedulerStatus() {
        return this.schedulerStatus;
    }

    public String toString() {
        return "GProSchedulePollingInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",schedulerStatus=" + this.schedulerStatus + ",}";
    }
}
