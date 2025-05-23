package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotMetricsInfo {
    public long chatCount;
    public long friendCount;
    public long hot;
    public long joinedGroupCount;

    public long getChatCount() {
        return this.chatCount;
    }

    public long getFriendCount() {
        return this.friendCount;
    }

    public long getHot() {
        return this.hot;
    }

    public long getJoinedGroupCount() {
        return this.joinedGroupCount;
    }

    public String toString() {
        return "RobotMetricsInfo{hot=" + this.hot + ",friendCount=" + this.friendCount + ",joinedGroupCount=" + this.joinedGroupCount + ",chatCount=" + this.chatCount + ",}";
    }
}
