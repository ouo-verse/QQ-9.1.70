package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSquareGroupInfoItem {
    public long groupCode;
    public int groupFlag;
    public int groupFlagExt;
    public int memberMaxNum;
    public int memberNum;
    public int uinPrivilege;
    public String groupName = "";
    public String memo = "";
    public ArrayList<GroupSquareLabel> labels = new ArrayList<>();
    public String joinGroupAuth = "";
    public String recomTrace = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupFlag() {
        return this.groupFlag;
    }

    public int getGroupFlagExt() {
        return this.groupFlagExt;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getJoinGroupAuth() {
        return this.joinGroupAuth;
    }

    public ArrayList<GroupSquareLabel> getLabels() {
        return this.labels;
    }

    public int getMemberMaxNum() {
        return this.memberMaxNum;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getRecomTrace() {
        return this.recomTrace;
    }

    public int getUinPrivilege() {
        return this.uinPrivilege;
    }

    public String toString() {
        return "GroupSquareGroupInfoItem{groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",memo=" + this.memo + ",labels=" + this.labels + ",memberNum=" + this.memberNum + ",memberMaxNum=" + this.memberMaxNum + ",groupFlagExt=" + this.groupFlagExt + ",groupFlag=" + this.groupFlag + ",joinGroupAuth=" + this.joinGroupAuth + ",uinPrivilege=" + this.uinPrivilege + ",recomTrace=" + this.recomTrace + ",}";
    }
}
