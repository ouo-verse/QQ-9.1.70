package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupRobotStoreDiscoveryReq {
    public long groupId;
    public int sceneId;

    public long getGroupId() {
        return this.groupId;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setGroupId(long j3) {
        this.groupId = j3;
    }

    public void setSceneId(int i3) {
        this.sceneId = i3;
    }

    public String toString() {
        return "GroupRobotStoreDiscoveryReq{groupId=" + this.groupId + ",sceneId=" + this.sceneId + ",}";
    }
}
