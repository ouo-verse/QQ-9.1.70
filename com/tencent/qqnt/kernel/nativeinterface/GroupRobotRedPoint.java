package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GroupRobotRedPoint {
    public long endTs;
    public long robotUin;
    public int role;

    public GroupRobotRedPoint() {
    }

    public long getEndTs() {
        return this.endTs;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public int getRole() {
        return this.role;
    }

    public String toString() {
        return "GroupRobotRedPoint{robotUin=" + this.robotUin + ",endTs=" + this.endTs + ",role=" + this.role + ",}";
    }

    public GroupRobotRedPoint(long j3, long j16, int i3) {
        this.robotUin = j3;
        this.endTs = j16;
        this.role = i3;
    }
}
