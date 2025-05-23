package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedMemberListRsp {
    public boolean isFinished;
    public boolean isSmallGuild;
    public long nextIndex;
    public long nextRoleIdIndex;
    public int totalMemberNum;
    public ArrayList<GProRoleMemberList> roleList = new ArrayList<>();
    public ArrayList<GProUser> robotMembers = new ArrayList<>();

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public boolean getIsSmallGuild() {
        return this.isSmallGuild;
    }

    public long getNextIndex() {
        return this.nextIndex;
    }

    public long getNextRoleIdIndex() {
        return this.nextRoleIdIndex;
    }

    public ArrayList<GProUser> getRobotMembers() {
        return this.robotMembers;
    }

    public ArrayList<GProRoleMemberList> getRoleList() {
        return this.roleList;
    }

    public int getTotalMemberNum() {
        return this.totalMemberNum;
    }

    public String toString() {
        return "GProFeedMemberListRsp{isFinished=" + this.isFinished + ",nextIndex=" + this.nextIndex + ",nextRoleIdIndex=" + this.nextRoleIdIndex + ",isSmallGuild=" + this.isSmallGuild + ",totalMemberNum=" + this.totalMemberNum + ",roleList=" + this.roleList + ",robotMembers=" + this.robotMembers + ",}";
    }
}
