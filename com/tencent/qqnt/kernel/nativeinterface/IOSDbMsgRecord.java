package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class IOSDbMsgRecord {
    public int actionType;
    public String actionUrl;
    public String adid;
    public int age;
    public int appShareID;
    public int bubbleid;
    public int captureCount;
    public int chatType;
    public int conseqMsg;
    public String content;
    public int distance;
    public int errorCode;
    public byte[] exData;
    public String extended;
    public int fileMsgType;
    public int flag;
    public int fromSecretStatus;
    public int gender;
    public long groupCode;
    public int memberLevel;
    public int moreflag;
    public long msgId;
    public int msgLen;
    public long msgRandom;
    public int msgRelatedFlag;
    public long msgSeq;
    public int msgSourceType;
    public int msgType;
    public String nickName;
    public int onlineFileId;
    public long peerUin;
    public String picUrl;
    public int placeholderMsg;
    public int read;
    public int relatedFailedMsgID;
    public int reservedInt1;
    public int reservedInt2;
    public int richFlag;
    public int richSource;
    public int roamMsg;
    public int roamRandom;
    public int roamTime;
    public String secretContent;
    public int secretEncryptKey;
    public int secretFileDurationTime;
    public int secretFileExpireTime;
    public int secretFileLeftTime;
    public int secretFileReadTimes;
    public String secretFromUin;
    public int secretPreHeadLength;
    public int secretReadtime;
    public int secretTimelimit;
    public String secretToUin;
    public int sendState;
    public int state;
    public String strShareExtra;
    public int time;
    public String tlvTag;
    public String tlvValue;
    public int toSecretStatus;
    public int type;
    public long uin;
    public String uniqueIdentifier;
    public int visiable;
    public int wSourceID;
    public int wSourceSubID;
    public int xiaowoFlag;
    public int xiaowoLabel;

    public IOSDbMsgRecord() {
        this.content = "";
        this.actionUrl = "";
        this.adid = "";
        this.strShareExtra = "";
        this.secretContent = "";
        this.secretFromUin = "";
        this.secretToUin = "";
        this.tlvTag = "";
        this.tlvValue = "";
        this.picUrl = "";
        this.exData = new byte[0];
        this.nickName = "";
        this.uniqueIdentifier = "";
        this.extended = "";
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public String getAdid() {
        return this.adid;
    }

    public int getAge() {
        return this.age;
    }

    public int getAppShareID() {
        return this.appShareID;
    }

    public int getBubbleid() {
        return this.bubbleid;
    }

    public int getCaptureCount() {
        return this.captureCount;
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getConseqMsg() {
        return this.conseqMsg;
    }

    public String getContent() {
        return this.content;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public byte[] getExData() {
        return this.exData;
    }

    public String getExtended() {
        return this.extended;
    }

    public int getFileMsgType() {
        return this.fileMsgType;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getFromSecretStatus() {
        return this.fromSecretStatus;
    }

    public int getGender() {
        return this.gender;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getMemberLevel() {
        return this.memberLevel;
    }

    public int getMoreflag() {
        return this.moreflag;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public int getMsgLen() {
        return this.msgLen;
    }

    public long getMsgRandom() {
        return this.msgRandom;
    }

    public int getMsgRelatedFlag() {
        return this.msgRelatedFlag;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public int getMsgSourceType() {
        return this.msgSourceType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getOnlineFileId() {
        return this.onlineFileId;
    }

    public long getPeerUin() {
        return this.peerUin;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getPlaceholderMsg() {
        return this.placeholderMsg;
    }

    public int getRead() {
        return this.read;
    }

    public int getRelatedFailedMsgID() {
        return this.relatedFailedMsgID;
    }

    public int getReservedInt1() {
        return this.reservedInt1;
    }

    public int getReservedInt2() {
        return this.reservedInt2;
    }

    public int getRichFlag() {
        return this.richFlag;
    }

    public int getRichSource() {
        return this.richSource;
    }

    public int getRoamMsg() {
        return this.roamMsg;
    }

    public int getRoamRandom() {
        return this.roamRandom;
    }

    public int getRoamTime() {
        return this.roamTime;
    }

    public String getSecretContent() {
        return this.secretContent;
    }

    public int getSecretEncryptKey() {
        return this.secretEncryptKey;
    }

    public int getSecretFileDurationTime() {
        return this.secretFileDurationTime;
    }

    public int getSecretFileExpireTime() {
        return this.secretFileExpireTime;
    }

    public int getSecretFileLeftTime() {
        return this.secretFileLeftTime;
    }

    public int getSecretFileReadTimes() {
        return this.secretFileReadTimes;
    }

    public String getSecretFromUin() {
        return this.secretFromUin;
    }

    public int getSecretPreHeadLength() {
        return this.secretPreHeadLength;
    }

    public int getSecretReadtime() {
        return this.secretReadtime;
    }

    public int getSecretTimelimit() {
        return this.secretTimelimit;
    }

    public String getSecretToUin() {
        return this.secretToUin;
    }

    public int getSendState() {
        return this.sendState;
    }

    public int getState() {
        return this.state;
    }

    public String getStrShareExtra() {
        return this.strShareExtra;
    }

    public int getTime() {
        return this.time;
    }

    public String getTlvTag() {
        return this.tlvTag;
    }

    public String getTlvValue() {
        return this.tlvValue;
    }

    public int getToSecretStatus() {
        return this.toSecretStatus;
    }

    public int getType() {
        return this.type;
    }

    public long getUin() {
        return this.uin;
    }

    public String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    public int getVisiable() {
        return this.visiable;
    }

    public int getWSourceID() {
        return this.wSourceID;
    }

    public int getWSourceSubID() {
        return this.wSourceSubID;
    }

    public int getXiaowoFlag() {
        return this.xiaowoFlag;
    }

    public int getXiaowoLabel() {
        return this.xiaowoLabel;
    }

    public String toString() {
        return "IOSDbMsgRecord{chatType=" + this.chatType + ",msgId=" + this.msgId + ",uin=" + this.uin + ",time=" + this.time + ",type=" + this.type + ",flag=" + this.flag + ",read=" + this.read + ",content=" + this.content + ",visiable=" + this.visiable + ",richFlag=" + this.richFlag + ",moreflag=" + this.moreflag + ",actionUrl=" + this.actionUrl + ",adid=" + this.adid + ",appShareID=" + this.appShareID + ",roamMsg=" + this.roamMsg + ",conseqMsg=" + this.conseqMsg + ",roamRandom=" + this.roamRandom + ",roamTime=" + this.roamTime + ",fileMsgType=" + this.fileMsgType + ",onlineFileId=" + this.onlineFileId + ",placeholderMsg=" + this.placeholderMsg + ",relatedFailedMsgID=" + this.relatedFailedMsgID + ",msgRelatedFlag=" + this.msgRelatedFlag + ",sendState=" + this.sendState + ",wSourceID=" + this.wSourceID + ",wSourceSubID=" + this.wSourceSubID + ",strShareExtra=" + this.strShareExtra + ",richSource=" + this.richSource + ",secretReadtime=" + this.secretReadtime + ",secretTimelimit=" + this.secretTimelimit + ",secretEncryptKey=" + this.secretEncryptKey + ",secretPreHeadLength=" + this.secretPreHeadLength + ",secretContent=" + this.secretContent + ",captureCount=" + this.captureCount + ",toSecretStatus=" + this.toSecretStatus + ",fromSecretStatus=" + this.fromSecretStatus + ",secretFromUin=" + this.secretFromUin + ",secretToUin=" + this.secretToUin + ",msgRandom=" + this.msgRandom + ",msgSeq=" + this.msgSeq + ",bubbleid=" + this.bubbleid + ",tlvTag=" + this.tlvTag + ",tlvValue=" + this.tlvValue + ",peerUin=" + this.peerUin + ",picUrl=" + this.picUrl + ",secretFileDurationTime=" + this.secretFileDurationTime + ",secretFileLeftTime=" + this.secretFileLeftTime + ",secretFileExpireTime=" + this.secretFileExpireTime + ",secretFileReadTimes=" + this.secretFileReadTimes + ",errorCode=" + this.errorCode + ",exData=" + this.exData + ",msgType=" + this.msgType + ",nickName=" + this.nickName + ",msgSourceType=" + this.msgSourceType + ",state=" + this.state + ",msgLen=" + this.msgLen + ",actionType=" + this.actionType + ",groupCode=" + this.groupCode + ",uniqueIdentifier=" + this.uniqueIdentifier + ",reservedInt1=" + this.reservedInt1 + ",reservedInt2=" + this.reservedInt2 + ",extended=" + this.extended + ",memberLevel=" + this.memberLevel + ",gender=" + this.gender + ",age=" + this.age + ",distance=" + this.distance + ",xiaowoFlag=" + this.xiaowoFlag + ",xiaowoLabel=" + this.xiaowoLabel + ",}";
    }

    public IOSDbMsgRecord(int i3, long j3, long j16, int i16, int i17, int i18, int i19, String str, int i26, int i27, int i28, String str2, String str3, int i29, int i36, int i37, int i38, int i39, int i46, int i47, int i48, int i49, int i56, int i57, int i58, int i59, String str4, int i65, int i66, int i67, int i68, int i69, String str5, int i75, int i76, int i77, String str6, String str7, long j17, long j18, int i78, String str8, String str9, long j19, String str10, int i79, int i85, int i86, int i87, int i88, byte[] bArr, int i89, String str11, int i95, int i96, int i97, int i98, long j26, String str12, int i99, int i100, String str13, int i101, int i102, int i103, int i104, int i105, int i106) {
        this.chatType = i3;
        this.msgId = j3;
        this.uin = j16;
        this.time = i16;
        this.type = i17;
        this.flag = i18;
        this.read = i19;
        this.content = str;
        this.visiable = i26;
        this.richFlag = i27;
        this.moreflag = i28;
        this.actionUrl = str2;
        this.adid = str3;
        this.appShareID = i29;
        this.roamMsg = i36;
        this.conseqMsg = i37;
        this.roamRandom = i38;
        this.roamTime = i39;
        this.fileMsgType = i46;
        this.onlineFileId = i47;
        this.placeholderMsg = i48;
        this.relatedFailedMsgID = i49;
        this.msgRelatedFlag = i56;
        this.sendState = i57;
        this.wSourceID = i58;
        this.wSourceSubID = i59;
        this.strShareExtra = str4;
        this.richSource = i65;
        this.secretReadtime = i66;
        this.secretTimelimit = i67;
        this.secretEncryptKey = i68;
        this.secretPreHeadLength = i69;
        this.secretContent = str5;
        this.captureCount = i75;
        this.toSecretStatus = i76;
        this.fromSecretStatus = i77;
        this.secretFromUin = str6;
        this.secretToUin = str7;
        this.msgRandom = j17;
        this.msgSeq = j18;
        this.bubbleid = i78;
        this.tlvTag = str8;
        this.tlvValue = str9;
        this.peerUin = j19;
        this.picUrl = str10;
        this.secretFileDurationTime = i79;
        this.secretFileLeftTime = i85;
        this.secretFileExpireTime = i86;
        this.secretFileReadTimes = i87;
        this.errorCode = i88;
        this.exData = bArr;
        this.msgType = i89;
        this.nickName = str11;
        this.msgSourceType = i95;
        this.state = i96;
        this.msgLen = i97;
        this.actionType = i98;
        this.groupCode = j26;
        this.uniqueIdentifier = str12;
        this.reservedInt1 = i99;
        this.reservedInt2 = i100;
        this.extended = str13;
        this.memberLevel = i101;
        this.gender = i102;
        this.age = i103;
        this.distance = i104;
        this.xiaowoFlag = i105;
        this.xiaowoLabel = i106;
    }
}
