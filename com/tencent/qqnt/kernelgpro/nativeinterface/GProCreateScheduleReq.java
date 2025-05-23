package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCreateScheduleReq {
    public int atMemberType;
    public int chanelType;
    public long channelId;
    public long guildId;
    public GProScheduleInfo scheduleInfo = new GProScheduleInfo();
    public ArrayList<Long> atRoleIds = new ArrayList<>();

    public int getAtMemberType() {
        return this.atMemberType;
    }

    public ArrayList<Long> getAtRoleIds() {
        return this.atRoleIds;
    }

    public int getChanelType() {
        return this.chanelType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProScheduleInfo getScheduleInfo() {
        return this.scheduleInfo;
    }

    public String toString() {
        return "GProCreateScheduleReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",scheduleInfo=" + this.scheduleInfo + ",chanelType=" + this.chanelType + ",atMemberType=" + this.atMemberType + ",atRoleIds=" + this.atRoleIds + ",}";
    }
}
