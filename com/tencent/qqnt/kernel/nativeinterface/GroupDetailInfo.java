package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupDetailInfo implements IKernelModel {
    public int activeMemberNum;
    public long allianceId;
    public int appealDeadline;
    public int autoAgreeJoinGroupUserNumForConfGroup;
    public int autoAgreeJoinGroupUserNumForNormalGroup;
    public int certType;
    public int classExt;
    public int cmdUinFlagEx2;
    public int cmdUinFlagExt3Grocery;
    public int cmdUinJoinMsgSeq;
    public int cmdUinJoinRealMsgSeq;
    public int cmdUinJoinTime;
    public int cmdUinMsgSeq;
    public int cmdUinRingtoneId;
    public int cmdUinUinFlag;
    public int confMaxMsgSeq;
    public int confToGroupTime;
    public long confUin;
    public int groupAdminMaxNum;
    public long groupCode;
    public int groupCreateTime;
    public int groupFace;
    public int groupFlag;
    public int groupFlagExt;
    public int groupFlagExt3;
    public int groupFlagExt4;
    public int groupFreezeReason;
    public int groupGrade;
    public int groupOption;
    public int groupSecLevel;
    public int groupSecLevelInfo;
    public int groupTypeFlag;
    public long groupUin;
    public int headPortraitSeq;
    public int hlGuildAppid;
    public int hlGuildOrgId;
    public int hlGuildSubType;
    public long inviteNoAuthNumLimit;
    public int isAllowConfGroupMemberAtAll;
    public int isAllowConfGroupMemberModifyGroupName;
    public int isAllowConfGroupMemberNick;
    public int isAllowHlGuildBinary;
    public int isAllowRecallMsg;
    public int isConfGroup;
    public int isGroupFreeze;
    public int isModifyConfGroupFace;
    public int isModifyConfGroupName;
    public boolean isTop;
    public int localExitGroupReason;
    public int maxMemberNum;
    public int memberNum;
    public int msgLimitFrequency;
    public int noCodeFingerOpenFlag;
    public int noFingerOpenFlag;
    public long ownerUin;
    public int privilegeFlag;
    public int shutUpAllTimestamp;
    public int shutUpMeTimestamp;
    public long subscriptionUin;
    public String ownerUid = "";
    public String groupName = "";
    public String fingerMemo = "";
    public String groupQuestion = "";
    public String richFingerMemo = "";
    public ArrayList<GroupTagRecord> tagRecord = new ArrayList<>();
    public String groupMemo = "";
    public GroupMsgMask cmdUinMsgMask = GroupMsgMask.values()[0];
    public MemberRole cmdUinPrivilege = MemberRole.values()[0];
    public String remarkName = "";
    public GroupGeoInfo groupGeoInfo = new GroupGeoInfo();
    public String certificationText = "";
    public String longGroupName = "";
    public GroupCardPrefix groupCardPrefix = new GroupCardPrefix();
    public GroupExt groupExt = new GroupExt();
    public GroupSchoolInfo groupSchoolInfo = new GroupSchoolInfo();
    public String subscriptionUid = "";
    public GroupExtInfoOnly groupExtOnly = new GroupExtInfoOnly();
    public String groupClassText = "";
    public GroupPortrait groupHeadPortrait = new GroupPortrait();
    public String groupAnswer = "";
    public GroupPermissions groupPermissions = new GroupPermissions();
    public GroupWxNotifyStatus wxNotifyStatus = GroupWxNotifyStatus.values()[0];
    public GroupGameList groupGameList = new GroupGameList();
    public ArrayList<Integer> selectedGameId = new ArrayList<>();

    public int getActiveMemberNum() {
        return this.activeMemberNum;
    }

    public long getAllianceId() {
        return this.allianceId;
    }

    public int getAppealDeadline() {
        return this.appealDeadline;
    }

    public int getAutoAgreeJoinGroupUserNumForConfGroup() {
        return this.autoAgreeJoinGroupUserNumForConfGroup;
    }

    public int getAutoAgreeJoinGroupUserNumForNormalGroup() {
        return this.autoAgreeJoinGroupUserNumForNormalGroup;
    }

    public int getCertType() {
        return this.certType;
    }

    public String getCertificationText() {
        return this.certificationText;
    }

    public int getClassExt() {
        return this.classExt;
    }

    public int getCmdUinFlagEx2() {
        return this.cmdUinFlagEx2;
    }

    public int getCmdUinFlagExt3Grocery() {
        return this.cmdUinFlagExt3Grocery;
    }

    public int getCmdUinJoinMsgSeq() {
        return this.cmdUinJoinMsgSeq;
    }

    public int getCmdUinJoinRealMsgSeq() {
        return this.cmdUinJoinRealMsgSeq;
    }

    public int getCmdUinJoinTime() {
        return this.cmdUinJoinTime;
    }

    public GroupMsgMask getCmdUinMsgMask() {
        return this.cmdUinMsgMask;
    }

    public int getCmdUinMsgSeq() {
        return this.cmdUinMsgSeq;
    }

    public MemberRole getCmdUinPrivilege() {
        return this.cmdUinPrivilege;
    }

    public int getCmdUinRingtoneId() {
        return this.cmdUinRingtoneId;
    }

    public int getCmdUinUinFlag() {
        return this.cmdUinUinFlag;
    }

    public int getConfMaxMsgSeq() {
        return this.confMaxMsgSeq;
    }

    public int getConfToGroupTime() {
        return this.confToGroupTime;
    }

    public long getConfUin() {
        return this.confUin;
    }

    public String getFingerMemo() {
        return this.fingerMemo;
    }

    public int getGroupAdminMaxNum() {
        return this.groupAdminMaxNum;
    }

    public String getGroupAnswer() {
        return this.groupAnswer;
    }

    public GroupCardPrefix getGroupCardPrefix() {
        return this.groupCardPrefix;
    }

    public String getGroupClassText() {
        return this.groupClassText;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getGroupCreateTime() {
        return this.groupCreateTime;
    }

    public GroupExt getGroupExt() {
        return this.groupExt;
    }

    public GroupExtInfoOnly getGroupExtOnly() {
        return this.groupExtOnly;
    }

    public int getGroupFace() {
        return this.groupFace;
    }

    public int getGroupFlag() {
        return this.groupFlag;
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

    public int getGroupFreezeReason() {
        return this.groupFreezeReason;
    }

    public GroupGameList getGroupGameList() {
        return this.groupGameList;
    }

    public GroupGeoInfo getGroupGeoInfo() {
        return this.groupGeoInfo;
    }

    public int getGroupGrade() {
        return this.groupGrade;
    }

    public GroupPortrait getGroupHeadPortrait() {
        return this.groupHeadPortrait;
    }

    public String getGroupMemo() {
        return this.groupMemo;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getGroupOption() {
        return this.groupOption;
    }

    public GroupPermissions getGroupPermissions() {
        return this.groupPermissions;
    }

    public String getGroupQuestion() {
        return this.groupQuestion;
    }

    public GroupSchoolInfo getGroupSchoolInfo() {
        return this.groupSchoolInfo;
    }

    public int getGroupSecLevel() {
        return this.groupSecLevel;
    }

    public int getGroupSecLevelInfo() {
        return this.groupSecLevelInfo;
    }

    public int getGroupTypeFlag() {
        return this.groupTypeFlag;
    }

    public long getGroupUin() {
        return this.groupUin;
    }

    public int getHeadPortraitSeq() {
        return this.headPortraitSeq;
    }

    public int getHlGuildAppid() {
        return this.hlGuildAppid;
    }

    public int getHlGuildOrgId() {
        return this.hlGuildOrgId;
    }

    public int getHlGuildSubType() {
        return this.hlGuildSubType;
    }

    public long getInviteNoAuthNumLimit() {
        return this.inviteNoAuthNumLimit;
    }

    public int getIsAllowConfGroupMemberAtAll() {
        return this.isAllowConfGroupMemberAtAll;
    }

    public int getIsAllowConfGroupMemberModifyGroupName() {
        return this.isAllowConfGroupMemberModifyGroupName;
    }

    public int getIsAllowConfGroupMemberNick() {
        return this.isAllowConfGroupMemberNick;
    }

    public int getIsAllowHlGuildBinary() {
        return this.isAllowHlGuildBinary;
    }

    public int getIsAllowRecallMsg() {
        return this.isAllowRecallMsg;
    }

    public int getIsConfGroup() {
        return this.isConfGroup;
    }

    public int getIsGroupFreeze() {
        return this.isGroupFreeze;
    }

    public int getIsModifyConfGroupFace() {
        return this.isModifyConfGroupFace;
    }

    public int getIsModifyConfGroupName() {
        return this.isModifyConfGroupName;
    }

    public boolean getIsTop() {
        return this.isTop;
    }

    public int getLocalExitGroupReason() {
        return this.localExitGroupReason;
    }

    public String getLongGroupName() {
        return this.longGroupName;
    }

    public int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public int getMsgLimitFrequency() {
        return this.msgLimitFrequency;
    }

    public int getNoCodeFingerOpenFlag() {
        return this.noCodeFingerOpenFlag;
    }

    public int getNoFingerOpenFlag() {
        return this.noFingerOpenFlag;
    }

    public String getOwnerUid() {
        return this.ownerUid;
    }

    public long getOwnerUin() {
        return this.ownerUin;
    }

    public int getPrivilegeFlag() {
        return this.privilegeFlag;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String getRichFingerMemo() {
        return this.richFingerMemo;
    }

    public ArrayList<Integer> getSelectedGameId() {
        return this.selectedGameId;
    }

    public int getShutUpAllTimestamp() {
        return this.shutUpAllTimestamp;
    }

    public int getShutUpMeTimestamp() {
        return this.shutUpMeTimestamp;
    }

    public String getSubscriptionUid() {
        return this.subscriptionUid;
    }

    public long getSubscriptionUin() {
        return this.subscriptionUin;
    }

    public ArrayList<GroupTagRecord> getTagRecord() {
        return this.tagRecord;
    }

    public GroupWxNotifyStatus getWxNotifyStatus() {
        return this.wxNotifyStatus;
    }

    public void setActiveMemberNum(int i3) {
        this.activeMemberNum = i3;
    }

    public void setAllianceId(long j3) {
        this.allianceId = j3;
    }

    public void setAppealDeadline(int i3) {
        this.appealDeadline = i3;
    }

    public void setAutoAgreeJoinGroupUserNumForConfGroup(int i3) {
        this.autoAgreeJoinGroupUserNumForConfGroup = i3;
    }

    public void setAutoAgreeJoinGroupUserNumForNormalGroup(int i3) {
        this.autoAgreeJoinGroupUserNumForNormalGroup = i3;
    }

    public void setCertType(int i3) {
        this.certType = i3;
    }

    public void setCertificationText(String str) {
        this.certificationText = str;
    }

    public void setClassExt(int i3) {
        this.classExt = i3;
    }

    public void setCmdUinFlagEx2(int i3) {
        this.cmdUinFlagEx2 = i3;
    }

    public void setCmdUinFlagExt3Grocery(int i3) {
        this.cmdUinFlagExt3Grocery = i3;
    }

    public void setCmdUinJoinMsgSeq(int i3) {
        this.cmdUinJoinMsgSeq = i3;
    }

    public void setCmdUinJoinRealMsgSeq(int i3) {
        this.cmdUinJoinRealMsgSeq = i3;
    }

    public void setCmdUinJoinTime(int i3) {
        this.cmdUinJoinTime = i3;
    }

    public void setCmdUinMsgMask(GroupMsgMask groupMsgMask) {
        this.cmdUinMsgMask = groupMsgMask;
    }

    public void setCmdUinMsgSeq(int i3) {
        this.cmdUinMsgSeq = i3;
    }

    public void setCmdUinPrivilege(MemberRole memberRole) {
        this.cmdUinPrivilege = memberRole;
    }

    public void setCmdUinRingtoneId(int i3) {
        this.cmdUinRingtoneId = i3;
    }

    public void setCmdUinUinFlag(int i3) {
        this.cmdUinUinFlag = i3;
    }

    public void setConfMaxMsgSeq(int i3) {
        this.confMaxMsgSeq = i3;
    }

    public void setConfToGroupTime(int i3) {
        this.confToGroupTime = i3;
    }

    public void setConfUin(long j3) {
        this.confUin = j3;
    }

    public void setFingerMemo(String str) {
        this.fingerMemo = str;
    }

    public void setGroupAdminMaxNum(int i3) {
        this.groupAdminMaxNum = i3;
    }

    public void setGroupAnswer(String str) {
        this.groupAnswer = str;
    }

    public void setGroupCardPrefix(GroupCardPrefix groupCardPrefix) {
        this.groupCardPrefix = groupCardPrefix;
    }

    public void setGroupClassText(String str) {
        this.groupClassText = str;
    }

    public void setGroupCode(long j3) {
        this.groupCode = j3;
    }

    public void setGroupCreateTime(int i3) {
        this.groupCreateTime = i3;
    }

    public void setGroupExt(GroupExt groupExt) {
        this.groupExt = groupExt;
    }

    public void setGroupExtOnly(GroupExtInfoOnly groupExtInfoOnly) {
        this.groupExtOnly = groupExtInfoOnly;
    }

    public void setGroupFace(int i3) {
        this.groupFace = i3;
    }

    public void setGroupFlag(int i3) {
        this.groupFlag = i3;
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

    public void setGroupFreezeReason(int i3) {
        this.groupFreezeReason = i3;
    }

    public void setGroupGameList(GroupGameList groupGameList) {
        this.groupGameList = groupGameList;
    }

    public void setGroupGeoInfo(GroupGeoInfo groupGeoInfo) {
        this.groupGeoInfo = groupGeoInfo;
    }

    public void setGroupGrade(int i3) {
        this.groupGrade = i3;
    }

    public void setGroupHeadPortrait(GroupPortrait groupPortrait) {
        this.groupHeadPortrait = groupPortrait;
    }

    public void setGroupMemo(String str) {
        this.groupMemo = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupOption(int i3) {
        this.groupOption = i3;
    }

    public void setGroupPermissions(GroupPermissions groupPermissions) {
        this.groupPermissions = groupPermissions;
    }

    public void setGroupQuestion(String str) {
        this.groupQuestion = str;
    }

    public void setGroupSchoolInfo(GroupSchoolInfo groupSchoolInfo) {
        this.groupSchoolInfo = groupSchoolInfo;
    }

    public void setGroupSecLevel(int i3) {
        this.groupSecLevel = i3;
    }

    public void setGroupSecLevelInfo(int i3) {
        this.groupSecLevelInfo = i3;
    }

    public void setGroupTypeFlag(int i3) {
        this.groupTypeFlag = i3;
    }

    public void setGroupUin(long j3) {
        this.groupUin = j3;
    }

    public void setHeadPortraitSeq(int i3) {
        this.headPortraitSeq = i3;
    }

    public void setHlGuildAppid(int i3) {
        this.hlGuildAppid = i3;
    }

    public void setHlGuildOrgId(int i3) {
        this.hlGuildOrgId = i3;
    }

    public void setHlGuildSubType(int i3) {
        this.hlGuildSubType = i3;
    }

    public void setInviteNoAuthNumLimit(long j3) {
        this.inviteNoAuthNumLimit = j3;
    }

    public void setIsAllowConfGroupMemberAtAll(int i3) {
        this.isAllowConfGroupMemberAtAll = i3;
    }

    public void setIsAllowConfGroupMemberModifyGroupName(int i3) {
        this.isAllowConfGroupMemberModifyGroupName = i3;
    }

    public void setIsAllowConfGroupMemberNick(int i3) {
        this.isAllowConfGroupMemberNick = i3;
    }

    public void setIsAllowHlGuildBinary(int i3) {
        this.isAllowHlGuildBinary = i3;
    }

    public void setIsAllowRecallMsg(int i3) {
        this.isAllowRecallMsg = i3;
    }

    public void setIsConfGroup(int i3) {
        this.isConfGroup = i3;
    }

    public void setIsGroupFreeze(int i3) {
        this.isGroupFreeze = i3;
    }

    public void setIsModifyConfGroupFace(int i3) {
        this.isModifyConfGroupFace = i3;
    }

    public void setIsModifyConfGroupName(int i3) {
        this.isModifyConfGroupName = i3;
    }

    public void setIsTop(boolean z16) {
        this.isTop = z16;
    }

    public void setLocalExitGroupReason(int i3) {
        this.localExitGroupReason = i3;
    }

    public void setLongGroupName(String str) {
        this.longGroupName = str;
    }

    public void setMaxMemberNum(int i3) {
        this.maxMemberNum = i3;
    }

    public void setMemberNum(int i3) {
        this.memberNum = i3;
    }

    public void setMsgLimitFrequency(int i3) {
        this.msgLimitFrequency = i3;
    }

    public void setNoCodeFingerOpenFlag(int i3) {
        this.noCodeFingerOpenFlag = i3;
    }

    public void setNoFingerOpenFlag(int i3) {
        this.noFingerOpenFlag = i3;
    }

    public void setOwnerUid(String str) {
        this.ownerUid = str;
    }

    public void setOwnerUin(long j3) {
        this.ownerUin = j3;
    }

    public void setPrivilegeFlag(int i3) {
        this.privilegeFlag = i3;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setRichFingerMemo(String str) {
        this.richFingerMemo = str;
    }

    public void setSelectedGameId(ArrayList<Integer> arrayList) {
        this.selectedGameId = arrayList;
    }

    public void setShutUpAllTimestamp(int i3) {
        this.shutUpAllTimestamp = i3;
    }

    public void setShutUpMeTimestamp(int i3) {
        this.shutUpMeTimestamp = i3;
    }

    public void setSubscriptionUid(String str) {
        this.subscriptionUid = str;
    }

    public void setSubscriptionUin(long j3) {
        this.subscriptionUin = j3;
    }

    public void setTagRecord(ArrayList<GroupTagRecord> arrayList) {
        this.tagRecord = arrayList;
    }

    public void setWxNotifyStatus(GroupWxNotifyStatus groupWxNotifyStatus) {
        this.wxNotifyStatus = groupWxNotifyStatus;
    }

    public String toString() {
        return "GroupDetailInfo{groupCode=" + this.groupCode + ",groupUin=" + this.groupUin + ",ownerUid=" + this.ownerUid + ",ownerUin=" + this.ownerUin + ",groupFlag=" + this.groupFlag + ",groupFlagExt=" + this.groupFlagExt + ",maxMemberNum=" + this.maxMemberNum + ",memberNum=" + this.memberNum + ",groupOption=" + this.groupOption + ",classExt=" + this.classExt + ",groupName=" + this.groupName + ",fingerMemo=" + this.fingerMemo + ",groupQuestion=" + this.groupQuestion + ",certType=" + this.certType + ",richFingerMemo=" + this.richFingerMemo + ",tagRecord=" + this.tagRecord + ",shutUpAllTimestamp=" + this.shutUpAllTimestamp + ",shutUpMeTimestamp=" + this.shutUpMeTimestamp + ",groupTypeFlag=" + this.groupTypeFlag + ",privilegeFlag=" + this.privilegeFlag + ",groupSecLevel=" + this.groupSecLevel + ",groupFlagExt3=" + this.groupFlagExt3 + ",isConfGroup=" + this.isConfGroup + ",isModifyConfGroupFace=" + this.isModifyConfGroupFace + ",isModifyConfGroupName=" + this.isModifyConfGroupName + ",groupFlagExt4=" + this.groupFlagExt4 + ",groupMemo=" + this.groupMemo + ",cmdUinMsgSeq=" + this.cmdUinMsgSeq + ",cmdUinJoinTime=" + this.cmdUinJoinTime + ",cmdUinUinFlag=" + this.cmdUinUinFlag + ",cmdUinMsgMask=" + this.cmdUinMsgMask + ",groupSecLevelInfo=" + this.groupSecLevelInfo + ",cmdUinPrivilege=" + this.cmdUinPrivilege + ",cmdUinFlagEx2=" + this.cmdUinFlagEx2 + ",appealDeadline=" + this.appealDeadline + ",remarkName=" + this.remarkName + ",isTop=" + this.isTop + ",groupFace=" + this.groupFace + ",groupGeoInfo=" + this.groupGeoInfo + ",certificationText=" + this.certificationText + ",cmdUinRingtoneId=" + this.cmdUinRingtoneId + ",longGroupName=" + this.longGroupName + ",autoAgreeJoinGroupUserNumForConfGroup=" + this.autoAgreeJoinGroupUserNumForConfGroup + ",autoAgreeJoinGroupUserNumForNormalGroup=" + this.autoAgreeJoinGroupUserNumForNormalGroup + ",cmdUinFlagExt3Grocery=" + this.cmdUinFlagExt3Grocery + ",groupCardPrefix=" + this.groupCardPrefix + ",groupExt=" + this.groupExt + ",msgLimitFrequency=" + this.msgLimitFrequency + ",hlGuildAppid=" + this.hlGuildAppid + ",hlGuildSubType=" + this.hlGuildSubType + ",isAllowRecallMsg=" + this.isAllowRecallMsg + ",confUin=" + this.confUin + ",confMaxMsgSeq=" + this.confMaxMsgSeq + ",confToGroupTime=" + this.confToGroupTime + ",groupSchoolInfo=" + this.groupSchoolInfo + ",activeMemberNum=" + this.activeMemberNum + ",groupGrade=" + this.groupGrade + ",groupCreateTime=" + this.groupCreateTime + ",subscriptionUin=" + this.subscriptionUin + ",subscriptionUid=" + this.subscriptionUid + ",noFingerOpenFlag=" + this.noFingerOpenFlag + ",noCodeFingerOpenFlag=" + this.noCodeFingerOpenFlag + ",isGroupFreeze=" + this.isGroupFreeze + ",allianceId=" + this.allianceId + ",groupExtOnly=" + this.groupExtOnly + ",isAllowConfGroupMemberModifyGroupName=" + this.isAllowConfGroupMemberModifyGroupName + ",isAllowConfGroupMemberNick=" + this.isAllowConfGroupMemberNick + ",isAllowConfGroupMemberAtAll=" + this.isAllowConfGroupMemberAtAll + ",groupClassText=" + this.groupClassText + ",groupFreezeReason=" + this.groupFreezeReason + ",headPortraitSeq=" + this.headPortraitSeq + ",groupHeadPortrait=" + this.groupHeadPortrait + ",cmdUinJoinMsgSeq=" + this.cmdUinJoinMsgSeq + ",cmdUinJoinRealMsgSeq=" + this.cmdUinJoinRealMsgSeq + ",groupAnswer=" + this.groupAnswer + ",groupAdminMaxNum=" + this.groupAdminMaxNum + ",inviteNoAuthNumLimit=" + this.inviteNoAuthNumLimit + ",hlGuildOrgId=" + this.hlGuildOrgId + ",isAllowHlGuildBinary=" + this.isAllowHlGuildBinary + ",localExitGroupReason=" + this.localExitGroupReason + ",groupPermissions=" + this.groupPermissions + ",wxNotifyStatus=" + this.wxNotifyStatus + ",groupGameList=" + this.groupGameList + ",selectedGameId=" + this.selectedGameId + ",}";
    }
}
