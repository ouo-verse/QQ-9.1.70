package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSimpleInfo implements IKernelModel {
    public int appealDeadline;
    public int authGroupType;
    public int cmdUinFlag;
    public int cmdUinFlagEx2;
    public int cmdUinRingtoneId;
    public long createTime;
    public int discussToGroupMaxMsgSeq;
    public int discussToGroupTime;
    public long discussToGroupUin;
    public int groupClassExt;
    public long groupCode;
    public int groupCreditLevel;
    public int groupFlagExt;
    public int groupFlagExt3;
    public int groupFlagExt4;
    public int groupInfoChangeSeq;
    public int groupSecLevelInfo;
    public long groupShutupExpireTime;
    public int groupTypeFlag;
    public long groupUin;
    public boolean hasMemo;
    public boolean hasModifyConfGroupFace;
    public boolean hasModifyConfGroupName;
    public int hlGuildAppId;
    public int hlGuildSubType;
    public boolean isConf;
    public boolean isTop;
    public int joinTime;
    public int maxMember;
    public int memberCardChangeSeq;
    public int memberChangeSeq;
    public int memberCount;
    public int memberLevelNameSeq;
    public long personShutupExpireTime;
    public int privilegeFlag;
    public long subscriptionUin;
    public long toppedTimestamp;
    public MemberID groupOwnerId = new MemberID();
    public String groupName = "";
    public GroupStatus groupStatus = GroupStatus.values()[0];
    public byte[] groupMemo = new byte[0];
    public MemberRole memberRole = MemberRole.values()[0];
    public String remarkName = "";
    public GroupMsgMask cmdUinMsgMask = GroupMsgMask.values()[0];

    public int getAppealDeadline() {
        return this.appealDeadline;
    }

    public int getAuthGroupType() {
        return this.authGroupType;
    }

    public int getCmdUinFlag() {
        return this.cmdUinFlag;
    }

    public int getCmdUinFlagEx2() {
        return this.cmdUinFlagEx2;
    }

    public GroupMsgMask getCmdUinMsgMask() {
        return this.cmdUinMsgMask;
    }

    public int getCmdUinRingtoneId() {
        return this.cmdUinRingtoneId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getDiscussToGroupMaxMsgSeq() {
        return this.discussToGroupMaxMsgSeq;
    }

    public int getDiscussToGroupTime() {
        return this.discussToGroupTime;
    }

    public long getDiscussToGroupUin() {
        return this.discussToGroupUin;
    }

    public int getGroupClassExt() {
        return this.groupClassExt;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupCreditLevel() {
        return this.groupCreditLevel;
    }

    public int getGroupFlagExt() {
        return this.groupFlagExt;
    }

    public int getGroupFlagExt3() {
        return this.groupFlagExt3;
    }

    public int getGroupFlagExt4() {
        return this.groupFlagExt4;
    }

    public int getGroupInfoChangeSeq() {
        return this.groupInfoChangeSeq;
    }

    public byte[] getGroupMemo() {
        return this.groupMemo;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public MemberID getGroupOwnerId() {
        return this.groupOwnerId;
    }

    public int getGroupSecLevelInfo() {
        return this.groupSecLevelInfo;
    }

    public long getGroupShutupExpireTime() {
        return this.groupShutupExpireTime;
    }

    public GroupStatus getGroupStatus() {
        return this.groupStatus;
    }

    public int getGroupTypeFlag() {
        return this.groupTypeFlag;
    }

    public long getGroupUin() {
        return this.groupUin;
    }

    public boolean getHasMemo() {
        return this.hasMemo;
    }

    public boolean getHasModifyConfGroupFace() {
        return this.hasModifyConfGroupFace;
    }

    public boolean getHasModifyConfGroupName() {
        return this.hasModifyConfGroupName;
    }

    public int getHlGuildAppId() {
        return this.hlGuildAppId;
    }

    public int getHlGuildSubType() {
        return this.hlGuildSubType;
    }

    public boolean getIsConf() {
        return this.isConf;
    }

    public boolean getIsTop() {
        return this.isTop;
    }

    public int getJoinTime() {
        return this.joinTime;
    }

    public int getMaxMember() {
        return this.maxMember;
    }

    public int getMemberCardChangeSeq() {
        return this.memberCardChangeSeq;
    }

    public int getMemberChangeSeq() {
        return this.memberChangeSeq;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int getMemberLevelNameSeq() {
        return this.memberLevelNameSeq;
    }

    public MemberRole getMemberRole() {
        return this.memberRole;
    }

    public long getPersonShutupExpireTime() {
        return this.personShutupExpireTime;
    }

    public int getPrivilegeFlag() {
        return this.privilegeFlag;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public long getSubscriptionUin() {
        return this.subscriptionUin;
    }

    public long getToppedTimestamp() {
        return this.toppedTimestamp;
    }

    public void setAppealDeadline(int i3) {
        this.appealDeadline = i3;
    }

    public void setAuthGroupType(int i3) {
        this.authGroupType = i3;
    }

    public void setCmdUinFlag(int i3) {
        this.cmdUinFlag = i3;
    }

    public void setCmdUinFlagEx2(int i3) {
        this.cmdUinFlagEx2 = i3;
    }

    public void setCmdUinMsgMask(GroupMsgMask groupMsgMask) {
        this.cmdUinMsgMask = groupMsgMask;
    }

    public void setCmdUinRingtoneId(int i3) {
        this.cmdUinRingtoneId = i3;
    }

    public void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public void setDiscussToGroupMaxMsgSeq(int i3) {
        this.discussToGroupMaxMsgSeq = i3;
    }

    public void setDiscussToGroupTime(int i3) {
        this.discussToGroupTime = i3;
    }

    public void setDiscussToGroupUin(long j3) {
        this.discussToGroupUin = j3;
    }

    public void setGroupClassExt(int i3) {
        this.groupClassExt = i3;
    }

    public void setGroupCode(long j3) {
        this.groupCode = j3;
    }

    public void setGroupCreditLevel(int i3) {
        this.groupCreditLevel = i3;
    }

    public void setGroupFlagExt(int i3) {
        this.groupFlagExt = i3;
    }

    public void setGroupFlagExt3(int i3) {
        this.groupFlagExt3 = i3;
    }

    public void setGroupFlagExt4(int i3) {
        this.groupFlagExt4 = i3;
    }

    public void setGroupInfoChangeSeq(int i3) {
        this.groupInfoChangeSeq = i3;
    }

    public void setGroupMemo(byte[] bArr) {
        this.groupMemo = bArr;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupOwnerId(MemberID memberID) {
        this.groupOwnerId = memberID;
    }

    public void setGroupSecLevelInfo(int i3) {
        this.groupSecLevelInfo = i3;
    }

    public void setGroupShutupExpireTime(long j3) {
        this.groupShutupExpireTime = j3;
    }

    public void setGroupStatus(GroupStatus groupStatus) {
        this.groupStatus = groupStatus;
    }

    public void setGroupTypeFlag(int i3) {
        this.groupTypeFlag = i3;
    }

    public void setGroupUin(long j3) {
        this.groupUin = j3;
    }

    public void setHasMemo(boolean z16) {
        this.hasMemo = z16;
    }

    public void setHasModifyConfGroupFace(boolean z16) {
        this.hasModifyConfGroupFace = z16;
    }

    public void setHasModifyConfGroupName(boolean z16) {
        this.hasModifyConfGroupName = z16;
    }

    public void setHlGuildAppId(int i3) {
        this.hlGuildAppId = i3;
    }

    public void setHlGuildSubType(int i3) {
        this.hlGuildSubType = i3;
    }

    public void setIsConf(boolean z16) {
        this.isConf = z16;
    }

    public void setIsTop(boolean z16) {
        this.isTop = z16;
    }

    public void setJoinTime(int i3) {
        this.joinTime = i3;
    }

    public void setMaxMember(int i3) {
        this.maxMember = i3;
    }

    public void setMemberCardChangeSeq(int i3) {
        this.memberCardChangeSeq = i3;
    }

    public void setMemberChangeSeq(int i3) {
        this.memberChangeSeq = i3;
    }

    public void setMemberCount(int i3) {
        this.memberCount = i3;
    }

    public void setMemberLevelNameSeq(int i3) {
        this.memberLevelNameSeq = i3;
    }

    public void setMemberRole(MemberRole memberRole) {
        this.memberRole = memberRole;
    }

    public void setPersonShutupExpireTime(long j3) {
        this.personShutupExpireTime = j3;
    }

    public void setPrivilegeFlag(int i3) {
        this.privilegeFlag = i3;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setSubscriptionUin(long j3) {
        this.subscriptionUin = j3;
    }

    public void setToppedTimestamp(long j3) {
        this.toppedTimestamp = j3;
    }

    public String toString() {
        return "GroupSimpleInfo{groupCode=" + this.groupCode + ",groupUin=" + this.groupUin + ",groupOwnerId=" + this.groupOwnerId + ",createTime=" + this.createTime + ",maxMember=" + this.maxMember + ",memberCount=" + this.memberCount + ",groupName=" + this.groupName + ",groupStatus=" + this.groupStatus + ",isTop=" + this.isTop + ",toppedTimestamp=" + this.toppedTimestamp + ",groupShutupExpireTime=" + this.groupShutupExpireTime + ",discussToGroupUin=" + this.discussToGroupUin + ",discussToGroupMaxMsgSeq=" + this.discussToGroupMaxMsgSeq + ",discussToGroupTime=" + this.discussToGroupTime + ",groupFlagExt=" + this.groupFlagExt + ",groupClassExt=" + this.groupClassExt + ",authGroupType=" + this.authGroupType + ",groupTypeFlag=" + this.groupTypeFlag + ",privilegeFlag=" + this.privilegeFlag + ",groupCreditLevel=" + this.groupCreditLevel + ",groupFlagExt3=" + this.groupFlagExt3 + ",isConf=" + this.isConf + ",hasModifyConfGroupFace=" + this.hasModifyConfGroupFace + ",hasModifyConfGroupName=" + this.hasModifyConfGroupName + ",groupFlagExt4=" + this.groupFlagExt4 + ",groupMemo=" + this.groupMemo + ",hasMemo=" + this.hasMemo + ",groupSecLevelInfo=" + this.groupSecLevelInfo + ",appealDeadline=" + this.appealDeadline + ",subscriptionUin=" + this.subscriptionUin + ",hlGuildAppId=" + this.hlGuildAppId + ",hlGuildSubType=" + this.hlGuildSubType + ",memberChangeSeq=" + this.memberChangeSeq + ",groupInfoChangeSeq=" + this.groupInfoChangeSeq + ",memberCardChangeSeq=" + this.memberCardChangeSeq + ",memberLevelNameSeq=" + this.memberLevelNameSeq + ",joinTime=" + this.joinTime + ",memberRole=" + this.memberRole + ",remarkName=" + this.remarkName + ",personShutupExpireTime=" + this.personShutupExpireTime + ",cmdUinFlag=" + this.cmdUinFlag + ",cmdUinFlagEx2=" + this.cmdUinFlagEx2 + ",cmdUinRingtoneId=" + this.cmdUinRingtoneId + ",cmdUinMsgMask=" + this.cmdUinMsgMask + ",}";
    }
}
