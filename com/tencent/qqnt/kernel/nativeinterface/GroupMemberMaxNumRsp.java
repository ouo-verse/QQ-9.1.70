package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMemberMaxNumRsp {
    public int activeMemberNum;
    public int groupAdminMaxNum;
    public long groupCode;
    public int groupMemberMaxNum;
    public int groupMemberNum;

    public int getActiveMemberNum() {
        return this.activeMemberNum;
    }

    public int getGroupAdminMaxNum() {
        return this.groupAdminMaxNum;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupMemberMaxNum() {
        return this.groupMemberMaxNum;
    }

    public int getGroupMemberNum() {
        return this.groupMemberNum;
    }

    public String toString() {
        return "GroupMemberMaxNumRsp{groupCode=" + this.groupCode + ",groupMemberMaxNum=" + this.groupMemberMaxNum + ",groupMemberNum=" + this.groupMemberNum + ",activeMemberNum=" + this.activeMemberNum + ",groupAdminMaxNum=" + this.groupAdminMaxNum + ",}";
    }
}
