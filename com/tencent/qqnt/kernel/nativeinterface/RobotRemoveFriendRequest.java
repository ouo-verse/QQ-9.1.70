package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotRemoveFriendRequest {
    public String robotUid;
    public long robotUin;

    public RobotRemoveFriendRequest() {
        this.robotUid = "";
    }

    public String getRobotUid() {
        return this.robotUid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "RobotRemoveFriendRequest{robotUin=" + this.robotUin + ",robotUid=" + this.robotUid + ",}";
    }

    public RobotRemoveFriendRequest(long j3, String str) {
        this.robotUin = j3;
        this.robotUid = str;
    }
}
