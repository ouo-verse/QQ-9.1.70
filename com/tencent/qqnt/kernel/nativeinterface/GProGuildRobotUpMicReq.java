package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildRobotUpMicReq {
    public long channelId;
    public long guildId;
    public boolean needJoinPush;
    public long robotTinyid;
    public long robotUin;
    public ArrayList<Long> targetUsers;

    public GProGuildRobotUpMicReq() {
        this.targetUsers = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getNeedJoinPush() {
        return this.needJoinPush;
    }

    public long getRobotTinyid() {
        return this.robotTinyid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public ArrayList<Long> getTargetUsers() {
        return this.targetUsers;
    }

    public String toString() {
        return "GProGuildRobotUpMicReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",robotUin=" + this.robotUin + ",needJoinPush=" + this.needJoinPush + ",targetUsers=" + this.targetUsers + ",robotTinyid=" + this.robotTinyid + ",}";
    }

    public GProGuildRobotUpMicReq(long j3, long j16, long j17, boolean z16, ArrayList<Long> arrayList, long j18) {
        new ArrayList();
        this.guildId = j3;
        this.channelId = j16;
        this.robotUin = j17;
        this.needJoinPush = z16;
        this.targetUsers = arrayList;
        this.robotTinyid = j18;
    }
}
