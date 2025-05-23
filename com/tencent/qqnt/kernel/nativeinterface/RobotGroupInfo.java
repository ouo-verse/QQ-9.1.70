package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotGroupInfo {
    public long groupId;
    public int groupMemberNum;
    public int uinRole;
    public String groupName = "";
    public String groupFingerMemo = "";
    public ArrayList<RobotGroupLabel> robotGroupLabel = new ArrayList<>();
    public String authSig = "";

    public String getAuthSig() {
        return this.authSig;
    }

    public String getGroupFingerMemo() {
        return this.groupFingerMemo;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupMemberNum() {
        return this.groupMemberNum;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ArrayList<RobotGroupLabel> getRobotGroupLabel() {
        return this.robotGroupLabel;
    }

    public int getUinRole() {
        return this.uinRole;
    }

    public String toString() {
        return "RobotGroupInfo{groupId=" + this.groupId + ",groupMemberNum=" + this.groupMemberNum + ",groupName=" + this.groupName + ",groupFingerMemo=" + this.groupFingerMemo + ",uinRole=" + this.uinRole + ",robotGroupLabel=" + this.robotGroupLabel + ",authSig=" + this.authSig + ",}";
    }
}
