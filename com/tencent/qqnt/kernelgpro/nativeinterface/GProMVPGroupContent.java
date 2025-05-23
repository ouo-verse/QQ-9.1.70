package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPGroupContent implements Serializable {
    public long groupCode;
    public int groupMemberNum;
    long serialVersionUID = 1;
    public String groupName = "";
    public String groupAvatar = "";
    public String groupJoinAuth = "";

    public String getGroupAvatar() {
        return this.groupAvatar;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupJoinAuth() {
        return this.groupJoinAuth;
    }

    public int getGroupMemberNum() {
        return this.groupMemberNum;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String toString() {
        return "GProMVPGroupContent{groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",groupMemberNum=" + this.groupMemberNum + ",groupAvatar=" + this.groupAvatar + ",groupJoinAuth=" + this.groupJoinAuth + ",}";
    }
}
