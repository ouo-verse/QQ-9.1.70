package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgAbstract implements Serializable {
    public long abstractTime;
    public ArrayList<MsgAbstractElement> elements;
    public long msgSeq;
    public int msgType;
    public Contact peer;
    public String sendMemberName;
    public String sendNickName;
    public int sendStatus;
    public String senderUid;
    long serialVersionUID;

    public MsgAbstract() {
        this.serialVersionUID = 1L;
        this.peer = new Contact();
        this.senderUid = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.elements = new ArrayList<>();
    }

    public long getAbstractTime() {
        return this.abstractTime;
    }

    public ArrayList<MsgAbstractElement> getElements() {
        return this.elements;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public Contact getPeer() {
        return this.peer;
    }

    public String getSendMemberName() {
        return this.sendMemberName;
    }

    public String getSendNickName() {
        return this.sendNickName;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public String toString() {
        return "MsgAbstract{peer=" + this.peer + ",senderUid=" + this.senderUid + ",sendMemberName=" + this.sendMemberName + ",sendNickName=" + this.sendNickName + ",sendStatus=" + this.sendStatus + ",elements=" + this.elements + ",abstractTime=" + this.abstractTime + ",msgType=" + this.msgType + ",msgSeq=" + this.msgSeq + ",}";
    }

    public MsgAbstract(Contact contact, String str, String str2, String str3, int i3, ArrayList<MsgAbstractElement> arrayList, long j3, int i16, long j16) {
        this.serialVersionUID = 1L;
        this.peer = new Contact();
        this.senderUid = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        new ArrayList();
        this.peer = contact;
        this.senderUid = str;
        this.sendMemberName = str2;
        this.sendNickName = str3;
        this.sendStatus = i3;
        this.elements = arrayList;
        this.abstractTime = j3;
        this.msgType = i16;
        this.msgSeq = j16;
    }
}
