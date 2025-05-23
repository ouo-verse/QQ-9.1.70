package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupAllInfo {
    public int appealDeadline;
    public int certType;
    public int classExt;
    public int cmdUinFlagEx2;
    public int cmdUinJoinTime;
    public GroupMsgMask cmdUinMsgMask;
    public int cmdUinMsgSeq;
    public MemberRole cmdUinPrivilege;
    public int cmdUinUinFlag;
    public String fingerMemo;
    public String groupAnswer;
    public long groupCode;
    public int groupFlag;
    public int groupFlagExt;
    public int groupFlagExt3;
    public int groupFlagExt4;
    public String groupMemo;
    public String groupName;
    public int groupOption;
    public String groupQuestion;
    public int groupSecLevel;
    public int groupSecLevelInfo;
    public int groupTypeFlag;
    public int isAllowModifyConfGroupName;
    public int isConfGroup;
    public int isModifyConfGroupFace;
    public int isModifyConfGroupName;
    public boolean isTop;
    public String joinGroupAuth;
    public int maxMemberNum;
    public int memberNum;
    public String ownerUid;
    public int privilegeFlag;
    public String remarkName;
    public String richFingerMemo;
    public int shutUpAllTimestamp;
    public int shutUpMeTimestamp;

    public GroupAllInfo() {
        this.ownerUid = "";
        this.groupName = "";
        this.fingerMemo = "";
        this.groupQuestion = "";
        this.groupMemo = "";
        this.cmdUinMsgMask = GroupMsgMask.values()[0];
        this.cmdUinPrivilege = MemberRole.values()[0];
        this.remarkName = "";
        this.richFingerMemo = "";
        this.groupAnswer = "";
        this.joinGroupAuth = "";
    }

    public int getAppealDeadline() {
        return this.appealDeadline;
    }

    public int getCertType() {
        return this.certType;
    }

    public int getClassExt() {
        return this.classExt;
    }

    public int getCmdUinFlagEx2() {
        return this.cmdUinFlagEx2;
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

    public int getCmdUinUinFlag() {
        return this.cmdUinUinFlag;
    }

    public String getFingerMemo() {
        return this.fingerMemo;
    }

    public String getGroupAnswer() {
        return this.groupAnswer;
    }

    public long getGroupCode() {
        return this.groupCode;
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

    public String getGroupMemo() {
        return this.groupMemo;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getGroupOption() {
        return this.groupOption;
    }

    public String getGroupQuestion() {
        return this.groupQuestion;
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

    public int getIsAllowModifyConfGroupName() {
        return this.isAllowModifyConfGroupName;
    }

    public int getIsConfGroup() {
        return this.isConfGroup;
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

    public String getJoinGroupAuth() {
        return this.joinGroupAuth;
    }

    public int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getOwnerUid() {
        return this.ownerUid;
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

    public int getShutUpAllTimestamp() {
        return this.shutUpAllTimestamp;
    }

    public int getShutUpMeTimestamp() {
        return this.shutUpMeTimestamp;
    }

    public String toString() {
        return "GroupAllInfo{groupCode=" + this.groupCode + ",ownerUid=" + this.ownerUid + ",groupFlag=" + this.groupFlag + ",groupFlagExt=" + this.groupFlagExt + ",maxMemberNum=" + this.maxMemberNum + ",memberNum=" + this.memberNum + ",groupOption=" + this.groupOption + ",classExt=" + this.classExt + ",groupName=" + this.groupName + ",fingerMemo=" + this.fingerMemo + ",groupQuestion=" + this.groupQuestion + ",certType=" + this.certType + ",shutUpAllTimestamp=" + this.shutUpAllTimestamp + ",shutUpMeTimestamp=" + this.shutUpMeTimestamp + ",groupTypeFlag=" + this.groupTypeFlag + ",privilegeFlag=" + this.privilegeFlag + ",groupSecLevel=" + this.groupSecLevel + ",groupFlagExt3=" + this.groupFlagExt3 + ",isConfGroup=" + this.isConfGroup + ",isModifyConfGroupFace=" + this.isModifyConfGroupFace + ",isModifyConfGroupName=" + this.isModifyConfGroupName + ",groupFlagExt4=" + this.groupFlagExt4 + ",groupMemo=" + this.groupMemo + ",cmdUinMsgSeq=" + this.cmdUinMsgSeq + ",cmdUinJoinTime=" + this.cmdUinJoinTime + ",cmdUinUinFlag=" + this.cmdUinUinFlag + ",cmdUinMsgMask=" + this.cmdUinMsgMask + ",groupSecLevelInfo=" + this.groupSecLevelInfo + ",cmdUinPrivilege=" + this.cmdUinPrivilege + ",cmdUinFlagEx2=" + this.cmdUinFlagEx2 + ",appealDeadline=" + this.appealDeadline + ",remarkName=" + this.remarkName + ",isTop=" + this.isTop + ",richFingerMemo=" + this.richFingerMemo + ",groupAnswer=" + this.groupAnswer + ",joinGroupAuth=" + this.joinGroupAuth + ",isAllowModifyConfGroupName=" + this.isAllowModifyConfGroupName + ",}";
    }

    public GroupAllInfo(long j3, String str, int i3, int i16, int i17, int i18, int i19, int i26, String str2, String str3, String str4, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, String str5, int i56, int i57, int i58, GroupMsgMask groupMsgMask, int i59, MemberRole memberRole, int i65, int i66, String str6, boolean z16, String str7, String str8, String str9, int i67) {
        this.ownerUid = "";
        this.groupName = "";
        this.fingerMemo = "";
        this.groupQuestion = "";
        this.groupMemo = "";
        this.cmdUinMsgMask = GroupMsgMask.values()[0];
        MemberRole memberRole2 = MemberRole.values()[0];
        this.groupCode = j3;
        this.ownerUid = str;
        this.groupFlag = i3;
        this.groupFlagExt = i16;
        this.maxMemberNum = i17;
        this.memberNum = i18;
        this.groupOption = i19;
        this.classExt = i26;
        this.groupName = str2;
        this.fingerMemo = str3;
        this.groupQuestion = str4;
        this.certType = i27;
        this.shutUpAllTimestamp = i28;
        this.shutUpMeTimestamp = i29;
        this.groupTypeFlag = i36;
        this.privilegeFlag = i37;
        this.groupSecLevel = i38;
        this.groupFlagExt3 = i39;
        this.isConfGroup = i46;
        this.isModifyConfGroupFace = i47;
        this.isModifyConfGroupName = i48;
        this.groupFlagExt4 = i49;
        this.groupMemo = str5;
        this.cmdUinMsgSeq = i56;
        this.cmdUinJoinTime = i57;
        this.cmdUinUinFlag = i58;
        this.cmdUinMsgMask = groupMsgMask;
        this.groupSecLevelInfo = i59;
        this.cmdUinPrivilege = memberRole;
        this.cmdUinFlagEx2 = i65;
        this.appealDeadline = i66;
        this.remarkName = str6;
        this.isTop = z16;
        this.richFingerMemo = str7;
        this.groupAnswer = str8;
        this.joinGroupAuth = str9;
        this.isAllowModifyConfGroupName = i67;
    }
}
