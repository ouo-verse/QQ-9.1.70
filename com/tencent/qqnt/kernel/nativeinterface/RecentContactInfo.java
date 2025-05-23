package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentContactInfo implements IKernelModel {
    public ArrayList<MsgAbstractElement> abstractContent;
    public Integer anonymousFlag;
    public int atType;
    public String avatarPath;
    public String avatarUrl;
    public long c2cClientMsgSeq;
    public int chatType;
    public long contactId;
    public ArrayList<MsgAbstractElement> draft;
    public byte draftFlag;
    public long draftTime;
    public ArrayList<RecentContactExtAttr> extAttrs;
    public byte[] extBuffer;
    public GuildContactInfo guildContactInfo;
    public int hiddenFlag;

    /* renamed from: id, reason: collision with root package name */
    public String f359204id;
    public boolean isBeat;
    public boolean isBlock;
    public boolean isMsgDisturb;
    public boolean isOnlineMsg;
    public int keepHiddenFlag;
    public ArrayList<SpecificEventTypeInfoInMsgBox> listOfSpecificEventTypeInfosInMsgBox;
    public HashMap<LiteBusinessType, String> liteBusiness;
    public String memberName;
    public long msgId;
    public long msgRandom;
    public long msgSeq;
    public long msgTime;
    public long msgUid;
    public ArrayList<RecentContactInfo> nestedChangedList;
    public ArrayList<Long> nestedSortedContactList;
    public int notifiedType;
    public String peerName;
    public String peerUid;
    public long peerUin;
    public String remark;
    public String sendMemberName;
    public String sendNickName;
    public String sendRemarkName;
    public int sendStatus;
    public String senderUid;
    public long senderUin;
    public int sessionType;
    public long shieldFlag;
    public long sortField;
    public byte specialCareFlag;
    public byte topFlag;
    public long topFlagTime;
    public int unreadChatCnt;
    public long unreadCnt;
    public long unreadFlag;
    public VASRecentContactMsgElement vasMsgInfo;
    public VASPersonalElement vasPersonalInfo;

    public RecentContactInfo() {
        this.f359204id = "";
        this.senderUid = "";
        this.peerUid = "";
        this.sendRemarkName = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.peerName = "";
        this.remark = "";
        this.avatarUrl = "";
        this.avatarPath = "";
        this.abstractContent = new ArrayList<>();
        this.draft = new ArrayList<>();
        this.nestedSortedContactList = new ArrayList<>();
        this.nestedChangedList = new ArrayList<>();
        this.vasPersonalInfo = new VASPersonalElement();
        this.vasMsgInfo = new VASRecentContactMsgElement();
        this.extAttrs = new ArrayList<>();
        this.liteBusiness = new HashMap<>();
    }

    public ArrayList<MsgAbstractElement> getAbstractContent() {
        return this.abstractContent;
    }

    public Integer getAnonymousFlag() {
        return this.anonymousFlag;
    }

    public int getAtType() {
        return this.atType;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public long getC2cClientMsgSeq() {
        return this.c2cClientMsgSeq;
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getContactId() {
        return this.contactId;
    }

    public ArrayList<MsgAbstractElement> getDraft() {
        return this.draft;
    }

    public byte getDraftFlag() {
        return this.draftFlag;
    }

    public long getDraftTime() {
        return this.draftTime;
    }

    public ArrayList<RecentContactExtAttr> getExtAttrs() {
        return this.extAttrs;
    }

    public byte[] getExtBuffer() {
        return this.extBuffer;
    }

    public GuildContactInfo getGuildContactInfo() {
        return this.guildContactInfo;
    }

    public int getHiddenFlag() {
        return this.hiddenFlag;
    }

    public String getId() {
        return this.f359204id;
    }

    public boolean getIsBeat() {
        return this.isBeat;
    }

    public boolean getIsBlock() {
        return this.isBlock;
    }

    public boolean getIsMsgDisturb() {
        return this.isMsgDisturb;
    }

    public boolean getIsOnlineMsg() {
        return this.isOnlineMsg;
    }

    public int getKeepHiddenFlag() {
        return this.keepHiddenFlag;
    }

    public ArrayList<SpecificEventTypeInfoInMsgBox> getListOfSpecificEventTypeInfosInMsgBox() {
        return this.listOfSpecificEventTypeInfosInMsgBox;
    }

    public HashMap<LiteBusinessType, String> getLiteBusiness() {
        return this.liteBusiness;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public long getMsgId() {
        return this.msgId;
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

    public long getMsgUid() {
        return this.msgUid;
    }

    public ArrayList<RecentContactInfo> getNestedChangedList() {
        return this.nestedChangedList;
    }

    public ArrayList<Long> getNestedSortedContactList() {
        return this.nestedSortedContactList;
    }

    public int getNotifiedType() {
        return this.notifiedType;
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

    public String getRemark() {
        return this.remark;
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

    public String getSenderUid() {
        return this.senderUid;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public int getSessionType() {
        return this.sessionType;
    }

    public long getShieldFlag() {
        return this.shieldFlag;
    }

    public long getSortField() {
        return this.sortField;
    }

    public byte getSpecialCareFlag() {
        return this.specialCareFlag;
    }

    public byte getTopFlag() {
        return this.topFlag;
    }

    public long getTopFlagTime() {
        return this.topFlagTime;
    }

    public int getUnreadChatCnt() {
        return this.unreadChatCnt;
    }

    public long getUnreadCnt() {
        return this.unreadCnt;
    }

    public long getUnreadFlag() {
        return this.unreadFlag;
    }

    public VASRecentContactMsgElement getVasMsgInfo() {
        return this.vasMsgInfo;
    }

    public VASPersonalElement getVasPersonalInfo() {
        return this.vasPersonalInfo;
    }

    public void setAbstractContent(ArrayList<MsgAbstractElement> arrayList) {
        this.abstractContent = arrayList;
    }

    public void setAnonymousFlag(Integer num) {
        this.anonymousFlag = num;
    }

    public void setAtType(int i3) {
        this.atType = i3;
    }

    public void setAvatarPath(String str) {
        this.avatarPath = str;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setC2cClientMsgSeq(long j3) {
        this.c2cClientMsgSeq = j3;
    }

    public void setChatType(int i3) {
        this.chatType = i3;
    }

    public void setContactId(long j3) {
        this.contactId = j3;
    }

    public void setDraft(ArrayList<MsgAbstractElement> arrayList) {
        this.draft = arrayList;
    }

    public void setDraftFlag(byte b16) {
        this.draftFlag = b16;
    }

    public void setDraftTime(long j3) {
        this.draftTime = j3;
    }

    public void setExtAttrs(ArrayList<RecentContactExtAttr> arrayList) {
        this.extAttrs = arrayList;
    }

    public void setExtBuffer(byte[] bArr) {
        this.extBuffer = bArr;
    }

    public void setGuildContactInfo(GuildContactInfo guildContactInfo) {
        this.guildContactInfo = guildContactInfo;
    }

    public void setHiddenFlag(int i3) {
        this.hiddenFlag = i3;
    }

    public void setId(String str) {
        this.f359204id = str;
    }

    public void setIsBeat(boolean z16) {
        this.isBeat = z16;
    }

    public void setIsBlock(boolean z16) {
        this.isBlock = z16;
    }

    public void setIsMsgDisturb(boolean z16) {
        this.isMsgDisturb = z16;
    }

    public void setIsOnlineMsg(boolean z16) {
        this.isOnlineMsg = z16;
    }

    public void setKeepHiddenFlag(int i3) {
        this.keepHiddenFlag = i3;
    }

    public void setListOfSpecificEventTypeInfosInMsgBox(ArrayList<SpecificEventTypeInfoInMsgBox> arrayList) {
        this.listOfSpecificEventTypeInfosInMsgBox = arrayList;
    }

    public void setLiteBusiness(HashMap<LiteBusinessType, String> hashMap) {
        this.liteBusiness = hashMap;
    }

    public void setMemberName(String str) {
        this.memberName = str;
    }

    public void setMsgId(long j3) {
        this.msgId = j3;
    }

    public void setMsgRandom(long j3) {
        this.msgRandom = j3;
    }

    public void setMsgSeq(long j3) {
        this.msgSeq = j3;
    }

    public void setMsgTime(long j3) {
        this.msgTime = j3;
    }

    public void setMsgUid(long j3) {
        this.msgUid = j3;
    }

    public void setNestedChangedList(ArrayList<RecentContactInfo> arrayList) {
        this.nestedChangedList = arrayList;
    }

    public void setNestedSortedContactList(ArrayList<Long> arrayList) {
        this.nestedSortedContactList = arrayList;
    }

    public void setNotifiedType(int i3) {
        this.notifiedType = i3;
    }

    public void setPeerName(String str) {
        this.peerName = str;
    }

    public void setPeerUid(String str) {
        this.peerUid = str;
    }

    public void setPeerUin(long j3) {
        this.peerUin = j3;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSendMemberName(String str) {
        this.sendMemberName = str;
    }

    public void setSendNickName(String str) {
        this.sendNickName = str;
    }

    public void setSendRemarkName(String str) {
        this.sendRemarkName = str;
    }

    public void setSendStatus(int i3) {
        this.sendStatus = i3;
    }

    public void setSenderUid(String str) {
        this.senderUid = str;
    }

    public void setSenderUin(long j3) {
        this.senderUin = j3;
    }

    public void setSessionType(int i3) {
        this.sessionType = i3;
    }

    public void setShieldFlag(long j3) {
        this.shieldFlag = j3;
    }

    public void setSortField(long j3) {
        this.sortField = j3;
    }

    public void setSpecialCareFlag(byte b16) {
        this.specialCareFlag = b16;
    }

    public void setTopFlag(byte b16) {
        this.topFlag = b16;
    }

    public void setTopFlagTime(long j3) {
        this.topFlagTime = j3;
    }

    public void setUnreadChatCnt(int i3) {
        this.unreadChatCnt = i3;
    }

    public void setUnreadCnt(long j3) {
        this.unreadCnt = j3;
    }

    public void setUnreadFlag(long j3) {
        this.unreadFlag = j3;
    }

    public void setVasMsgInfo(VASRecentContactMsgElement vASRecentContactMsgElement) {
        this.vasMsgInfo = vASRecentContactMsgElement;
    }

    public void setVasPersonalInfo(VASPersonalElement vASPersonalElement) {
        this.vasPersonalInfo = vASPersonalElement;
    }

    public String toString() {
        return "RecentContactInfo{id=" + this.f359204id + ",contactId=" + this.contactId + ",sortField=" + this.sortField + ",chatType=" + this.chatType + ",senderUid=" + this.senderUid + ",senderUin=" + this.senderUin + ",peerUid=" + this.peerUid + ",peerUin=" + this.peerUin + ",msgSeq=" + this.msgSeq + ",c2cClientMsgSeq=" + this.c2cClientMsgSeq + ",msgUid=" + this.msgUid + ",msgRandom=" + this.msgRandom + ",msgTime=" + this.msgTime + ",sendRemarkName=" + this.sendRemarkName + ",sendMemberName=" + this.sendMemberName + ",sendNickName=" + this.sendNickName + ",peerName=" + this.peerName + ",remark=" + this.remark + ",memberName=" + this.memberName + ",avatarUrl=" + this.avatarUrl + ",avatarPath=" + this.avatarPath + ",abstractContent=" + this.abstractContent + ",sendStatus=" + this.sendStatus + ",topFlag=" + ((int) this.topFlag) + ",topFlagTime=" + this.topFlagTime + ",draftFlag=" + ((int) this.draftFlag) + ",draftTime=" + this.draftTime + ",specialCareFlag=" + ((int) this.specialCareFlag) + ",sessionType=" + this.sessionType + ",shieldFlag=" + this.shieldFlag + ",atType=" + this.atType + ",draft=" + this.draft + ",hiddenFlag=" + this.hiddenFlag + ",keepHiddenFlag=" + this.keepHiddenFlag + ",isMsgDisturb=" + this.isMsgDisturb + ",nestedSortedContactList=" + this.nestedSortedContactList + ",nestedChangedList=" + this.nestedChangedList + ",unreadCnt=" + this.unreadCnt + ",unreadChatCnt=" + this.unreadChatCnt + ",unreadFlag=" + this.unreadFlag + ",isBeat=" + this.isBeat + ",isOnlineMsg=" + this.isOnlineMsg + ",msgId=" + this.msgId + ",notifiedType=" + this.notifiedType + ",isBlock=" + this.isBlock + ",listOfSpecificEventTypeInfosInMsgBox=" + this.listOfSpecificEventTypeInfosInMsgBox + ",guildContactInfo=" + this.guildContactInfo + ",vasPersonalInfo=" + this.vasPersonalInfo + ",vasMsgInfo=" + this.vasMsgInfo + ",anonymousFlag=" + this.anonymousFlag + ",extBuffer=" + this.extBuffer + ",extAttrs=" + this.extAttrs + ",liteBusiness=" + this.liteBusiness + ",}";
    }

    public RecentContactInfo(String str, long j3, long j16, int i3, String str2, long j17, String str3, long j18, long j19, long j26, long j27, long j28, long j29, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ArrayList<MsgAbstractElement> arrayList, int i16, byte b16, long j36, byte b17, long j37, byte b18, int i17, long j38, int i18, ArrayList<MsgAbstractElement> arrayList2, int i19, int i26, boolean z16, ArrayList<Long> arrayList3, ArrayList<RecentContactInfo> arrayList4, long j39, int i27, long j46, boolean z17, boolean z18, long j47, int i28, boolean z19, ArrayList<SpecificEventTypeInfoInMsgBox> arrayList5, GuildContactInfo guildContactInfo, VASPersonalElement vASPersonalElement, VASRecentContactMsgElement vASRecentContactMsgElement, Integer num, byte[] bArr, ArrayList<RecentContactExtAttr> arrayList6, HashMap<LiteBusinessType, String> hashMap) {
        this.f359204id = "";
        this.senderUid = "";
        this.peerUid = "";
        this.sendRemarkName = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.peerName = "";
        this.remark = "";
        this.avatarUrl = "";
        this.avatarPath = "";
        this.abstractContent = new ArrayList<>();
        this.draft = new ArrayList<>();
        this.nestedSortedContactList = new ArrayList<>();
        this.nestedChangedList = new ArrayList<>();
        this.vasPersonalInfo = new VASPersonalElement();
        this.vasMsgInfo = new VASRecentContactMsgElement();
        this.extAttrs = new ArrayList<>();
        new HashMap();
        this.f359204id = str;
        this.contactId = j3;
        this.sortField = j16;
        this.chatType = i3;
        this.senderUid = str2;
        this.senderUin = j17;
        this.peerUid = str3;
        this.peerUin = j18;
        this.msgSeq = j19;
        this.c2cClientMsgSeq = j26;
        this.msgUid = j27;
        this.msgRandom = j28;
        this.msgTime = j29;
        this.sendRemarkName = str4;
        this.sendMemberName = str5;
        this.sendNickName = str6;
        this.peerName = str7;
        this.remark = str8;
        this.memberName = str9;
        this.avatarUrl = str10;
        this.avatarPath = str11;
        this.abstractContent = arrayList;
        this.sendStatus = i16;
        this.topFlag = b16;
        this.topFlagTime = j36;
        this.draftFlag = b17;
        this.draftTime = j37;
        this.specialCareFlag = b18;
        this.sessionType = i17;
        this.shieldFlag = j38;
        this.atType = i18;
        this.draft = arrayList2;
        this.hiddenFlag = i19;
        this.keepHiddenFlag = i26;
        this.isMsgDisturb = z16;
        this.nestedSortedContactList = arrayList3;
        this.nestedChangedList = arrayList4;
        this.unreadCnt = j39;
        this.unreadChatCnt = i27;
        this.unreadFlag = j46;
        this.isBeat = z17;
        this.isOnlineMsg = z18;
        this.msgId = j47;
        this.notifiedType = i28;
        this.isBlock = z19;
        this.listOfSpecificEventTypeInfosInMsgBox = arrayList5;
        this.guildContactInfo = guildContactInfo;
        this.vasPersonalInfo = vASPersonalElement;
        this.vasMsgInfo = vASRecentContactMsgElement;
        this.anonymousFlag = num;
        this.extBuffer = bArr;
        this.extAttrs = arrayList6;
        this.liteBusiness = hashMap;
    }
}
