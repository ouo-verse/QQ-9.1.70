package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentContactData {
    public ArrayList<MsgAbstractElementData> abstractContent;
    public String avatarPath;
    public String avatarUrl;
    public int chatType;
    public ArrayList<RecentContactExtAttr> extAttrs;
    public byte[] extBuffer;
    public boolean forceInsert;
    public ArrayList<SpecificEventTypeInfoInMsgBox> listOfSpecificEventTypeInfosInMsgBox;
    public long msgTime;
    public String peerName;
    public String peerUid;
    public long peerUin;
    public int sendStatus;
    public long unreadCnt;

    public RecentContactData() {
        this.peerUid = "";
        this.peerName = "";
        this.avatarUrl = "";
        this.avatarPath = "";
        this.abstractContent = new ArrayList<>();
        this.extAttrs = new ArrayList<>();
    }

    public ArrayList<MsgAbstractElementData> getAbstractContent() {
        return this.abstractContent;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getChatType() {
        return this.chatType;
    }

    public ArrayList<RecentContactExtAttr> getExtAttrs() {
        return this.extAttrs;
    }

    public byte[] getExtBuffer() {
        return this.extBuffer;
    }

    public boolean getForceInsert() {
        return this.forceInsert;
    }

    public ArrayList<SpecificEventTypeInfoInMsgBox> getListOfSpecificEventTypeInfosInMsgBox() {
        return this.listOfSpecificEventTypeInfosInMsgBox;
    }

    public long getMsgTime() {
        return this.msgTime;
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

    public int getSendStatus() {
        return this.sendStatus;
    }

    public long getUnreadCnt() {
        return this.unreadCnt;
    }

    public String toString() {
        return "RecentContactData{peerUid=" + this.peerUid + ",peerUin=" + this.peerUin + ",peerName=" + this.peerName + ",chatType=" + this.chatType + ",unreadCnt=" + this.unreadCnt + ",avatarUrl=" + this.avatarUrl + ",avatarPath=" + this.avatarPath + ",sendStatus=" + this.sendStatus + ",abstractContent=" + this.abstractContent + ",msgTime=" + this.msgTime + ",listOfSpecificEventTypeInfosInMsgBox=" + this.listOfSpecificEventTypeInfosInMsgBox + ",extBuffer=" + this.extBuffer + ",extAttrs=" + this.extAttrs + ",forceInsert=" + this.forceInsert + ",}";
    }

    public RecentContactData(String str, long j3, String str2, int i3, long j16, String str3, String str4, int i16, ArrayList<MsgAbstractElementData> arrayList, long j17, ArrayList<SpecificEventTypeInfoInMsgBox> arrayList2, byte[] bArr, ArrayList<RecentContactExtAttr> arrayList3) {
        this.peerUid = "";
        this.peerName = "";
        this.avatarUrl = "";
        this.avatarPath = "";
        this.abstractContent = new ArrayList<>();
        new ArrayList();
        this.peerUid = str;
        this.peerUin = j3;
        this.peerName = str2;
        this.chatType = i3;
        this.unreadCnt = j16;
        this.avatarUrl = str3;
        this.avatarPath = str4;
        this.sendStatus = i16;
        this.abstractContent = arrayList;
        this.msgTime = j17;
        this.listOfSpecificEventTypeInfosInMsgBox = arrayList2;
        this.extBuffer = bArr;
        this.extAttrs = arrayList3;
    }
}
