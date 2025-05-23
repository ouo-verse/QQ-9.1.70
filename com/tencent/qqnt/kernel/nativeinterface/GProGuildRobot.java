package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobot {
    public long robotAppid;
    public long robotUin;
    public int status;

    public GProGuildRobot() {
    }

    public long getRobotAppid() {
        return this.robotAppid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProGuildRobot{robotUin=" + this.robotUin + ",robotAppid=" + this.robotAppid + ",status=" + this.status + ",}";
    }

    public GProGuildRobot(long j3, long j16, int i3) {
        this.robotUin = j3;
        this.robotAppid = j16;
        this.status = i3;
    }
}
