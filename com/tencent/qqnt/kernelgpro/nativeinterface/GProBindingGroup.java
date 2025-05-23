package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBindingGroup {
    public long groupCode;
    public int groupFlag;
    public long groupMemberSize;
    public int isConfGroup;
    public boolean isGroupMember;
    public int privilege;
    public String groupName = "";
    public String signature = "";
    public String onlineMemberSize = "";
    public String groupUrl = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupFlag() {
        return this.groupFlag;
    }

    public long getGroupMemberSize() {
        return this.groupMemberSize;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupUrl() {
        return this.groupUrl;
    }

    public int getIsConfGroup() {
        return this.isConfGroup;
    }

    public boolean getIsGroupMember() {
        return this.isGroupMember;
    }

    public String getOnlineMemberSize() {
        return this.onlineMemberSize;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    public String getSignature() {
        return this.signature;
    }

    public String toString() {
        return "GProBindingGroup{groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",privilege=" + this.privilege + ",groupMemberSize=" + this.groupMemberSize + ",signature=" + this.signature + ",groupFlag=" + this.groupFlag + ",isConfGroup=" + this.isConfGroup + ",onlineMemberSize=" + this.onlineMemberSize + ",groupUrl=" + this.groupUrl + ",isGroupMember=" + this.isGroupMember + ",}";
    }
}
