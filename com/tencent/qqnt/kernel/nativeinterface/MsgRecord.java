package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgRecord {
    public AnonymousExtInfo anonymousExtInfo;
    public int atType;
    public ArrayList<MsgElement> auxiliaryElements;
    public int avatarFlag;
    public String avatarMeta;
    public String avatarPendant;
    public int categoryManage;
    public String channelId;
    public String channelName;
    public int chatType;
    public GuildClientIdentity clientIdentityInfo;
    public long clientSeq;
    public long cntSeq;
    public long commentCnt;
    public int directMsgFlag;
    public ArrayList<DirectMsgMember> directMsgMembers;
    public boolean editable;
    public ArrayList<MsgElement> elements;
    public ArrayList<MsgEmojiLikes> emojiLikesList;
    public byte[] extInfoForUI;
    public String feedId;
    public Integer fileGroupSize;
    public FoldingInfo foldingInfo;
    public FreqLimitInfo freqLimitInfo;
    public long fromAppid;
    public FromRoleInfo fromChannelRoleInfo;
    public FromRoleInfo fromGuildRoleInfo;
    public long fromUid;
    public byte[] generalFlags;
    public long guildCode;
    public String guildId;
    public String guildName;
    public boolean isImportMsg;
    public boolean isOnlineMsg;
    public boolean isSupportRoamMsg;
    public FromRoleInfo levelRoleInfo;
    public HashMap<Integer, MsgAttributeInfo> msgAttrs;
    public byte[] msgEventInfo;
    public long msgId;
    public byte[] msgMeta;
    public long msgRandom;
    public long msgSeq;
    public long msgTime;
    public int msgType;
    public MultiTransInfo multiTransInfo;
    public int nameType;
    public String peerName;
    public String peerUid;
    public long peerUin;
    public GuildMedal personalMedal;
    public long recallTime;
    public ArrayList<MsgRecord> records;
    public long roleId;
    public int roleType;
    public String sendMemberName;
    public String sendNickName;
    public String sendRemarkName;
    public int sendStatus;
    public int sendType;
    public String senderUid;
    public long senderUin;
    public int sourceType;
    public int subMsgType;
    public long timeStamp;
    public long totalSeq;

    public MsgRecord() {
        this.senderUid = "";
        this.peerUid = "";
        this.channelId = "";
        this.guildId = "";
        this.msgMeta = new byte[0];
        this.sendRemarkName = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.guildName = "";
        this.channelName = "";
        this.elements = new ArrayList<>();
        this.auxiliaryElements = new ArrayList<>();
        this.records = new ArrayList<>();
        this.emojiLikesList = new ArrayList<>();
        this.directMsgMembers = new ArrayList<>();
        this.peerName = "";
        this.avatarMeta = "";
        this.avatarPendant = "";
        this.feedId = "";
        this.fromChannelRoleInfo = new FromRoleInfo();
        this.fromGuildRoleInfo = new FromRoleInfo();
        this.levelRoleInfo = new FromRoleInfo();
        this.generalFlags = new byte[0];
        this.msgAttrs = new HashMap<>();
    }

    public AnonymousExtInfo getAnonymousExtInfo() {
        return this.anonymousExtInfo;
    }

    public int getAtType() {
        return this.atType;
    }

    public ArrayList<MsgElement> getAuxiliaryElements() {
        return this.auxiliaryElements;
    }

    public int getAvatarFlag() {
        return this.avatarFlag;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public int getCategoryManage() {
        return this.categoryManage;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChatType() {
        return this.chatType;
    }

    public GuildClientIdentity getClientIdentityInfo() {
        return this.clientIdentityInfo;
    }

    public long getClientSeq() {
        return this.clientSeq;
    }

    public long getCntSeq() {
        return this.cntSeq;
    }

    public long getCommentCnt() {
        return this.commentCnt;
    }

    public int getDirectMsgFlag() {
        return this.directMsgFlag;
    }

    public ArrayList<DirectMsgMember> getDirectMsgMembers() {
        return this.directMsgMembers;
    }

    public boolean getEditable() {
        return this.editable;
    }

    public ArrayList<MsgElement> getElements() {
        return this.elements;
    }

    public ArrayList<MsgEmojiLikes> getEmojiLikesList() {
        return this.emojiLikesList;
    }

    public byte[] getExtInfoForUI() {
        return this.extInfoForUI;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public Integer getFileGroupSize() {
        return this.fileGroupSize;
    }

    public FoldingInfo getFoldingInfo() {
        return this.foldingInfo;
    }

    public FreqLimitInfo getFreqLimitInfo() {
        return this.freqLimitInfo;
    }

    public long getFromAppid() {
        return this.fromAppid;
    }

    public FromRoleInfo getFromChannelRoleInfo() {
        return this.fromChannelRoleInfo;
    }

    public FromRoleInfo getFromGuildRoleInfo() {
        return this.fromGuildRoleInfo;
    }

    public long getFromUid() {
        return this.fromUid;
    }

    public byte[] getGeneralFlags() {
        return this.generalFlags;
    }

    public long getGuildCode() {
        return this.guildCode;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public boolean getIsImportMsg() {
        return this.isImportMsg;
    }

    public boolean getIsOnlineMsg() {
        return this.isOnlineMsg;
    }

    public boolean getIsSupportRoamMsg() {
        return this.isSupportRoamMsg;
    }

    public FromRoleInfo getLevelRoleInfo() {
        return this.levelRoleInfo;
    }

    public HashMap<Integer, MsgAttributeInfo> getMsgAttrs() {
        return this.msgAttrs;
    }

    public byte[] getMsgEventInfo() {
        return this.msgEventInfo;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public byte[] getMsgMeta() {
        return this.msgMeta;
    }

    public long getMsgRandom() {
        return this.msgRandom;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public MultiTransInfo getMultiTransInfo() {
        return this.multiTransInfo;
    }

    public int getNameType() {
        return this.nameType;
    }

    public String getPeerName() {
        return this.peerName;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public long getPeerUin() {
        return this.peerUin;
    }

    public GuildMedal getPersonalMedal() {
        return this.personalMedal;
    }

    public long getRecallTime() {
        return this.recallTime;
    }

    public ArrayList<MsgRecord> getRecords() {
        return this.records;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public int getRoleType() {
        return this.roleType;
    }

    public String getSendMemberName() {
        return this.sendMemberName;
    }

    public String getSendNickName() {
        return this.sendNickName;
    }

    public String getSendRemarkName() {
        return this.sendRemarkName;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public int getSubMsgType() {
        return this.subMsgType;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public long getTotalSeq() {
        return this.totalSeq;
    }

    public String toString() {
        return "MsgRecord{msgId=" + this.msgId + ",msgRandom=" + this.msgRandom + ",msgSeq=" + this.msgSeq + ",cntSeq=" + this.cntSeq + ",chatType=" + this.chatType + ",msgType=" + this.msgType + ",subMsgType=" + this.subMsgType + ",sendType=" + this.sendType + ",senderUid=" + this.senderUid + ",peerUid=" + this.peerUid + ",channelId=" + this.channelId + ",guildId=" + this.guildId + ",guildCode=" + this.guildCode + ",fromUid=" + this.fromUid + ",fromAppid=" + this.fromAppid + ",msgTime=" + this.msgTime + ",msgMeta=" + this.msgMeta + ",sendStatus=" + this.sendStatus + ",sendRemarkName=" + this.sendRemarkName + ",sendMemberName=" + this.sendMemberName + ",sendNickName=" + this.sendNickName + ",guildName=" + this.guildName + ",channelName=" + this.channelName + ",elements=" + this.elements + ",auxiliaryElements=" + this.auxiliaryElements + ",records=" + this.records + ",emojiLikesList=" + this.emojiLikesList + ",commentCnt=" + this.commentCnt + ",directMsgFlag=" + this.directMsgFlag + ",directMsgMembers=" + this.directMsgMembers + ",peerName=" + this.peerName + ",freqLimitInfo=" + this.freqLimitInfo + ",editable=" + this.editable + ",avatarMeta=" + this.avatarMeta + ",avatarPendant=" + this.avatarPendant + ",feedId=" + this.feedId + ",roleId=" + this.roleId + ",timeStamp=" + this.timeStamp + ",clientIdentityInfo=" + this.clientIdentityInfo + ",isImportMsg=" + this.isImportMsg + ",atType=" + this.atType + ",roleType=" + this.roleType + ",fromChannelRoleInfo=" + this.fromChannelRoleInfo + ",fromGuildRoleInfo=" + this.fromGuildRoleInfo + ",levelRoleInfo=" + this.levelRoleInfo + ",recallTime=" + this.recallTime + ",isOnlineMsg=" + this.isOnlineMsg + ",generalFlags=" + this.generalFlags + ",clientSeq=" + this.clientSeq + ",fileGroupSize=" + this.fileGroupSize + ",foldingInfo=" + this.foldingInfo + ",multiTransInfo=" + this.multiTransInfo + ",senderUin=" + this.senderUin + ",peerUin=" + this.peerUin + ",msgAttrs=" + this.msgAttrs + ",anonymousExtInfo=" + this.anonymousExtInfo + ",nameType=" + this.nameType + ",avatarFlag=" + this.avatarFlag + ",extInfoForUI=" + this.extInfoForUI + ",personalMedal=" + this.personalMedal + ",categoryManage=" + this.categoryManage + ",msgEventInfo=" + this.msgEventInfo + ",sourceType=" + this.sourceType + ",totalSeq=" + this.totalSeq + ",isSupportRoamMsg=" + this.isSupportRoamMsg + ",}";
    }

    public MsgRecord(long j3, long j16, long j17, long j18, int i3, int i16, int i17, int i18, String str, String str2, String str3, String str4, long j19, long j26, long j27, long j28, byte[] bArr, int i19, String str5, String str6, String str7, String str8, String str9, ArrayList<MsgElement> arrayList, ArrayList<MsgRecord> arrayList2, ArrayList<MsgEmojiLikes> arrayList3, long j29, int i26, ArrayList<DirectMsgMember> arrayList4, String str10, FreqLimitInfo freqLimitInfo, boolean z16, String str11, String str12, String str13, long j36, long j37, GuildClientIdentity guildClientIdentity, boolean z17, int i27, int i28, FromRoleInfo fromRoleInfo, FromRoleInfo fromRoleInfo2, FromRoleInfo fromRoleInfo3, long j38, boolean z18, byte[] bArr2, long j39, Integer num, FoldingInfo foldingInfo, MultiTransInfo multiTransInfo, long j46, long j47, HashMap<Integer, MsgAttributeInfo> hashMap, AnonymousExtInfo anonymousExtInfo, int i29, int i36, byte[] bArr3, GuildMedal guildMedal, int i37, byte[] bArr4) {
        this.senderUid = "";
        this.peerUid = "";
        this.channelId = "";
        this.guildId = "";
        this.msgMeta = new byte[0];
        this.sendRemarkName = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.guildName = "";
        this.channelName = "";
        this.elements = new ArrayList<>();
        this.auxiliaryElements = new ArrayList<>();
        this.records = new ArrayList<>();
        this.emojiLikesList = new ArrayList<>();
        this.directMsgMembers = new ArrayList<>();
        this.peerName = "";
        this.avatarMeta = "";
        this.avatarPendant = "";
        this.feedId = "";
        this.fromChannelRoleInfo = new FromRoleInfo();
        this.fromGuildRoleInfo = new FromRoleInfo();
        this.levelRoleInfo = new FromRoleInfo();
        this.generalFlags = new byte[0];
        new HashMap();
        this.msgId = j3;
        this.msgRandom = j16;
        this.msgSeq = j17;
        this.cntSeq = j18;
        this.chatType = i3;
        this.msgType = i16;
        this.subMsgType = i17;
        this.sendType = i18;
        this.senderUid = str;
        this.peerUid = str2;
        this.channelId = str3;
        this.guildId = str4;
        this.guildCode = j19;
        this.fromUid = j26;
        this.fromAppid = j27;
        this.msgTime = j28;
        this.msgMeta = bArr;
        this.sendStatus = i19;
        this.sendRemarkName = str5;
        this.sendMemberName = str6;
        this.sendNickName = str7;
        this.guildName = str8;
        this.channelName = str9;
        this.elements = arrayList;
        this.records = arrayList2;
        this.emojiLikesList = arrayList3;
        this.commentCnt = j29;
        this.directMsgFlag = i26;
        this.directMsgMembers = arrayList4;
        this.peerName = str10;
        this.freqLimitInfo = freqLimitInfo;
        this.editable = z16;
        this.avatarMeta = str11;
        this.avatarPendant = str12;
        this.feedId = str13;
        this.roleId = j36;
        this.timeStamp = j37;
        this.clientIdentityInfo = guildClientIdentity;
        this.isImportMsg = z17;
        this.atType = i27;
        this.roleType = i28;
        this.fromChannelRoleInfo = fromRoleInfo;
        this.fromGuildRoleInfo = fromRoleInfo2;
        this.levelRoleInfo = fromRoleInfo3;
        this.recallTime = j38;
        this.isOnlineMsg = z18;
        this.generalFlags = bArr2;
        this.clientSeq = j39;
        this.fileGroupSize = num;
        this.foldingInfo = foldingInfo;
        this.multiTransInfo = multiTransInfo;
        this.senderUin = j46;
        this.peerUin = j47;
        this.msgAttrs = hashMap;
        this.anonymousExtInfo = anonymousExtInfo;
        this.nameType = i29;
        this.avatarFlag = i36;
        this.extInfoForUI = bArr3;
        this.personalMedal = guildMedal;
        this.categoryManage = i37;
        this.msgEventInfo = bArr4;
    }
}
