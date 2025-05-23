package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroupInfoItem {
    public long groupCode;
    public boolean hasModifyConfGroupFace;
    public boolean hasModifyConfGroupName;
    public boolean isConf;
    public int memberCount;
    public boolean noCodeFingerOpenFlag;
    public ArrayList<SearchHitInfo> groupCodeHits = new ArrayList<>();
    public String groupName = "";
    public ArrayList<SearchHitInfo> groupNameHits = new ArrayList<>();
    public String remarkName = "";
    public ArrayList<SearchHitInfo> remarkNameHits = new ArrayList<>();
    public GroupStatus groupStatus = GroupStatus.values()[0];
    public MemberRole memberRole = MemberRole.values()[0];

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<SearchHitInfo> getGroupCodeHits() {
        return this.groupCodeHits;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ArrayList<SearchHitInfo> getGroupNameHits() {
        return this.groupNameHits;
    }

    public GroupStatus getGroupStatus() {
        return this.groupStatus;
    }

    public boolean getHasModifyConfGroupFace() {
        return this.hasModifyConfGroupFace;
    }

    public boolean getHasModifyConfGroupName() {
        return this.hasModifyConfGroupName;
    }

    public boolean getIsConf() {
        return this.isConf;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public MemberRole getMemberRole() {
        return this.memberRole;
    }

    public boolean getNoCodeFingerOpenFlag() {
        return this.noCodeFingerOpenFlag;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public ArrayList<SearchHitInfo> getRemarkNameHits() {
        return this.remarkNameHits;
    }

    public String toString() {
        return "SearchGroupInfoItem{groupCode=" + this.groupCode + ",groupCodeHits=" + this.groupCodeHits + ",memberCount=" + this.memberCount + ",isConf=" + this.isConf + ",hasModifyConfGroupFace=" + this.hasModifyConfGroupFace + ",hasModifyConfGroupName=" + this.hasModifyConfGroupName + ",noCodeFingerOpenFlag=" + this.noCodeFingerOpenFlag + ",groupName=" + this.groupName + ",groupNameHits=" + this.groupNameHits + ",remarkName=" + this.remarkName + ",remarkNameHits=" + this.remarkNameHits + ",groupStatus=" + this.groupStatus + ",memberRole=" + this.memberRole + ",}";
    }
}
