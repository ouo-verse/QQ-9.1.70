package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RemoveRobotFromGroupReq {
    public long groupId;
    public long robotUin;

    public RemoveRobotFromGroupReq() {
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "RemoveRobotFromGroupReq{groupId=" + this.groupId + ",robotUin=" + this.robotUin + ",}";
    }

    public RemoveRobotFromGroupReq(long j3, long j16) {
        this.groupId = j3;
        this.robotUin = j16;
    }
}
