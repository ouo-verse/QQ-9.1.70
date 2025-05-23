package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotAddFriendRequest {
    public String robotUid;
    public long robotUin;

    public RobotAddFriendRequest() {
        this.robotUid = "";
    }

    public String getRobotUid() {
        return this.robotUid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "RobotAddFriendRequest{robotUin=" + this.robotUin + ",robotUid=" + this.robotUid + ",}";
    }

    public RobotAddFriendRequest(long j3, String str) {
        this.robotUin = j3;
        this.robotUid = str;
    }
}
