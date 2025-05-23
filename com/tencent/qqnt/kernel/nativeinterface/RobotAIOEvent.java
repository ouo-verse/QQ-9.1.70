package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotAIOEvent {
    public int changeId;
    public String uid = "";

    public int getChangeId() {
        return this.changeId;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "RobotAIOEvent{uid=" + this.uid + ",changeId=" + this.changeId + ",}";
    }
}
