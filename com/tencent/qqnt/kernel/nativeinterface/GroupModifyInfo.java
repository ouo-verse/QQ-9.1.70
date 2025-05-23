package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupModifyInfo {
    public int activeMemberNum;
    public int addOption;
    public long allianceId;
    public int allowMemberInvite;
    public int appPrivilegeFlag;
    public int appPrivilegeMask;
    public int certificationType;
    public int classExt;
    public int flag;
    public int groupExtAdminNum;
    public int groupFace;
    public int groupFlagExt3;
    public int groupFlagExt3Mask;
    public int groupFlagExt4;
    public int groupFlagExt4Mask;
    public int groupFlagPro1;
    public int groupFlagPro1Mask;
    public int groupGrade;
    public int groupOpenAppid;
    public int groupSecLevel;
    public int groupSecLevelInfo;
    public int groupTypeFlag;
    public int hlGuildAppid;
    public int hlGuildOrgId;
    public int hlGuildSubType;
    public int msgLimitFrequency;
    public int noCodeFingerOpenFlag;
    public int noFingerOpenFlag;
    public long rootId;
    public int shutUpTime;
    public long subscriptionUin;
    public String groupName = "";
    public String classText = "";
    public String fingerMemo = "";
    public String richFingerMemo = "";
    public ArrayList<String> tagRecord = new ArrayList<>();
    public GroupGeoInfo groupGeoInfo = new GroupGeoInfo();
    public String groupMemo = "";
    public String groupAioSkinUrl = "";
    public String groupBoardSkinUrl = "";
    public String groupCoverSkinUrl = "";
    public String certificationText = "";
    public GroupNewGuidelinesInfo groupNewGuideLines = new GroupNewGuidelinesInfo();
    public GroupExtInfoOnly groupExtOnly = new GroupExtInfoOnly();
    public String subscriptionUid = "";
    public String groupQuestion = "";
    public String groupAnswer = "";
    public GroupSchoolInfo groupSchoolInfo = new GroupSchoolInfo();
    public GroupCardPrefix groupCardPrefix = new GroupCardPrefix();
    public ArrayList<Integer> selectedGameId = new ArrayList<>();

    public int getActiveMemberNum() {
        return this.activeMemberNum;
    }

    public int getAddOption() {
        return this.addOption;
    }

    public long getAllianceId() {
        return this.allianceId;
    }

    public int getAllowMemberInvite() {
        return this.allowMemberInvite;
    }

    public int getAppPrivilegeFlag() {
        return this.appPrivilegeFlag;
    }

    public int getAppPrivilegeMask() {
        return this.appPrivilegeMask;
    }

    public String getCertificationText() {
        return this.certificationText;
    }

    public int getCertificationType() {
        return this.certificationType;
    }

    public int getClassExt() {
        return this.classExt;
    }

    public String getClassText() {
        return this.classText;
    }

    public String getFingerMemo() {
        return this.fingerMemo;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getGroupAioSkinUrl() {
        return this.groupAioSkinUrl;
    }

    public String getGroupAnswer() {
        return this.groupAnswer;
    }

    public String getGroupBoardSkinUrl() {
        return this.groupBoardSkinUrl;
    }

    public GroupCardPrefix getGroupCardPrefix() {
        return this.groupCardPrefix;
    }

    public String getGroupCoverSkinUrl() {
        return this.groupCoverSkinUrl;
    }

    public int getGroupExtAdminNum() {
        return this.groupExtAdminNum;
    }

    public GroupExtInfoOnly getGroupExtOnly() {
        return this.groupExtOnly;
    }

    public int getGroupFace() {
        return this.groupFace;
    }

    public int getGroupFlagExt3() {
        return this.groupFlagExt3;
    }

    public int getGroupFlagExt3Mask() {
        return this.groupFlagExt3Mask;
    }

    public int getGroupFlagExt4() {
        return this.groupFlagExt4;
    }

    public int getGroupFlagExt4Mask() {
        return this.groupFlagExt4Mask;
    }

    public int getGroupFlagPro1() {
        return this.groupFlagPro1;
    }

    public int getGroupFlagPro1Mask() {
        return this.groupFlagPro1Mask;
    }

    public GroupGeoInfo getGroupGeoInfo() {
        return this.groupGeoInfo;
    }

    public int getGroupGrade() {
        return this.groupGrade;
    }

    public String getGroupMemo() {
        return this.groupMemo;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public GroupNewGuidelinesInfo getGroupNewGuideLines() {
        return this.groupNewGuideLines;
    }

    public int getGroupOpenAppid() {
        return this.groupOpenAppid;
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

    public int getHlGuildAppid() {
        return this.hlGuildAppid;
    }

    public int getHlGuildOrgId() {
        return this.hlGuildOrgId;
    }

    public int getHlGuildSubType() {
        return this.hlGuildSubType;
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

    public String getRichFingerMemo() {
        return this.richFingerMemo;
    }

    public long getRootId() {
        return this.rootId;
    }

    public ArrayList<Integer> getSelectedGameId() {
        return this.selectedGameId;
    }

    public int getShutUpTime() {
        return this.shutUpTime;
    }

    public String getSubscriptionUid() {
        return this.subscriptionUid;
    }

    public long getSubscriptionUin() {
        return this.subscriptionUin;
    }

    public ArrayList<String> getTagRecord() {
        return this.tagRecord;
    }

    public String toString() {
        return "GroupModifyInfo{groupName=" + this.groupName + ",classExt=" + this.classExt + ",classText=" + this.classText + ",fingerMemo=" + this.fingerMemo + ",richFingerMemo=" + this.richFingerMemo + ",tagRecord=" + this.tagRecord + ",groupGeoInfo=" + this.groupGeoInfo + ",groupExtAdminNum=" + this.groupExtAdminNum + ",flag=" + this.flag + ",groupMemo=" + this.groupMemo + ",groupAioSkinUrl=" + this.groupAioSkinUrl + ",groupBoardSkinUrl=" + this.groupBoardSkinUrl + ",groupCoverSkinUrl=" + this.groupCoverSkinUrl + ",groupGrade=" + this.groupGrade + ",activeMemberNum=" + this.activeMemberNum + ",certificationType=" + this.certificationType + ",certificationText=" + this.certificationText + ",groupNewGuideLines=" + this.groupNewGuideLines + ",groupFace=" + this.groupFace + ",addOption=" + this.addOption + ",shutUpTime=" + this.shutUpTime + ",groupTypeFlag=" + this.groupTypeFlag + ",appPrivilegeFlag=" + this.appPrivilegeFlag + ",appPrivilegeMask=" + this.appPrivilegeMask + ",groupExtOnly=" + this.groupExtOnly + ",groupSecLevel=" + this.groupSecLevel + ",groupSecLevelInfo=" + this.groupSecLevelInfo + ",subscriptionUin=" + this.subscriptionUin + ",subscriptionUid=" + this.subscriptionUid + ",allowMemberInvite=" + this.allowMemberInvite + ",groupQuestion=" + this.groupQuestion + ",groupAnswer=" + this.groupAnswer + ",groupFlagExt3=" + this.groupFlagExt3 + ",groupFlagExt3Mask=" + this.groupFlagExt3Mask + ",groupOpenAppid=" + this.groupOpenAppid + ",noFingerOpenFlag=" + this.noFingerOpenFlag + ",noCodeFingerOpenFlag=" + this.noCodeFingerOpenFlag + ",rootId=" + this.rootId + ",msgLimitFrequency=" + this.msgLimitFrequency + ",hlGuildAppid=" + this.hlGuildAppid + ",hlGuildSubType=" + this.hlGuildSubType + ",hlGuildOrgId=" + this.hlGuildOrgId + ",groupFlagExt4=" + this.groupFlagExt4 + ",groupFlagExt4Mask=" + this.groupFlagExt4Mask + ",groupSchoolInfo=" + this.groupSchoolInfo + ",groupCardPrefix=" + this.groupCardPrefix + ",allianceId=" + this.allianceId + ",groupFlagPro1=" + this.groupFlagPro1 + ",groupFlagPro1Mask=" + this.groupFlagPro1Mask + ",selectedGameId=" + this.selectedGameId + ",}";
    }
}
