package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreateGroupInfo {
    public int appId;
    public int checkLimitFlag;
    public int confUin;
    public long createFlag;
    public int groupClass;
    public int groupClassExt;
    public int groupCode;
    public int groupFace;
    public int groupFaceFlag;
    public int groupOpenAppid;
    public int groupOption;
    public int groupSize;
    public int groupTypeFlag;
    public int securityFlag;
    public int sourceId;
    public String ownerUid = "";
    public byte[] stringGroupName = new byte[0];
    public byte[] stringGroupMemo = new byte[0];
    public byte[] stringGroupFingerMemo = new byte[0];
    public byte[] stringGroupRichFingerMemo = new byte[0];
    public byte[] stringQuestion = new byte[0];
    public byte[] stringAnswer = new byte[0];
    public byte[] stringSign = new byte[0];
    public CreateGroupClientInfo clientInfo = new CreateGroupClientInfo();
    public CreateGroupGeoInfo groupGeoInfo = new CreateGroupGeoInfo();
    public TypeValues typeValueInfo = new TypeValues();
    public CreateGroupChannelInfo msgChannelInfo = new CreateGroupChannelInfo();

    public int getAppId() {
        return this.appId;
    }

    public int getCheckLimitFlag() {
        return this.checkLimitFlag;
    }

    public CreateGroupClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public int getConfUin() {
        return this.confUin;
    }

    public long getCreateFlag() {
        return this.createFlag;
    }

    public int getGroupClass() {
        return this.groupClass;
    }

    public int getGroupClassExt() {
        return this.groupClassExt;
    }

    public int getGroupCode() {
        return this.groupCode;
    }

    public int getGroupFace() {
        return this.groupFace;
    }

    public int getGroupFaceFlag() {
        return this.groupFaceFlag;
    }

    public CreateGroupGeoInfo getGroupGeoInfo() {
        return this.groupGeoInfo;
    }

    public int getGroupOpenAppid() {
        return this.groupOpenAppid;
    }

    public int getGroupOption() {
        return this.groupOption;
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public int getGroupTypeFlag() {
        return this.groupTypeFlag;
    }

    public CreateGroupChannelInfo getMsgChannelInfo() {
        return this.msgChannelInfo;
    }

    public String getOwnerUid() {
        return this.ownerUid;
    }

    public int getSecurityFlag() {
        return this.securityFlag;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public byte[] getStringAnswer() {
        return this.stringAnswer;
    }

    public byte[] getStringGroupFingerMemo() {
        return this.stringGroupFingerMemo;
    }

    public byte[] getStringGroupMemo() {
        return this.stringGroupMemo;
    }

    public byte[] getStringGroupName() {
        return this.stringGroupName;
    }

    public byte[] getStringGroupRichFingerMemo() {
        return this.stringGroupRichFingerMemo;
    }

    public byte[] getStringQuestion() {
        return this.stringQuestion;
    }

    public byte[] getStringSign() {
        return this.stringSign;
    }

    public TypeValues getTypeValueInfo() {
        return this.typeValueInfo;
    }

    public String toString() {
        return "CreateGroupInfo{groupCode=" + this.groupCode + ",ownerUid=" + this.ownerUid + ",groupOption=" + this.groupOption + ",groupClass=" + this.groupClass + ",groupClassExt=" + this.groupClassExt + ",groupFace=" + this.groupFace + ",appId=" + this.appId + ",groupSize=" + this.groupSize + ",createFlag=" + this.createFlag + ",stringGroupName=" + this.stringGroupName + ",confUin=" + this.confUin + ",checkLimitFlag=" + this.checkLimitFlag + ",stringGroupMemo=" + this.stringGroupMemo + ",stringGroupFingerMemo=" + this.stringGroupFingerMemo + ",stringGroupRichFingerMemo=" + this.stringGroupRichFingerMemo + ",stringQuestion=" + this.stringQuestion + ",stringAnswer=" + this.stringAnswer + ",stringSign=" + this.stringSign + ",clientInfo=" + this.clientInfo + ",groupGeoInfo=" + this.groupGeoInfo + ",groupTypeFlag=" + this.groupTypeFlag + ",groupFaceFlag=" + this.groupFaceFlag + ",typeValueInfo=" + this.typeValueInfo + ",groupOpenAppid=" + this.groupOpenAppid + ",sourceId=" + this.sourceId + ",msgChannelInfo=" + this.msgChannelInfo + ",securityFlag=" + this.securityFlag + ",}";
    }
}
