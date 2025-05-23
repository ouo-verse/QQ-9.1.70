package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotPermissionReq {
    public long guildId;
    public long robotUin;

    public GProGuildRobotPermissionReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "GProGuildRobotPermissionReq{guildId=" + this.guildId + ",robotUin=" + this.robotUin + ",}";
    }

    public GProGuildRobotPermissionReq(long j3, long j16) {
        this.guildId = j3;
        this.robotUin = j16;
    }
}
