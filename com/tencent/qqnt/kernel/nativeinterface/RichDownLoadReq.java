package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RichDownLoadReq {
    public int chatType;
    public int downloadType;
    public MsgElement elem;
    public String guildId;
    public long msgId;
    public long msgRandom;
    public long msgSeq;
    public long msgTime;
    public String peerUid;
    public String senderUid;
    public int thumbSize;
    public int triggerType;
    public Integer useHttps;

    public RichDownLoadReq() {
        this.senderUid = "";
        this.peerUid = "";
        this.guildId = "";
        this.elem = new MsgElement();
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public MsgElement getElem() {
        return this.elem;
    }

    public String getGuildId() {
        return this.guildId;
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

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public Integer getUseHttps() {
        return this.useHttps;
    }

    public RichDownLoadReq(int i3, int i16, long j3, long j16, long j17, long j18, int i17, String str, String str2, String str3, MsgElement msgElement, Integer num) {
        this.senderUid = "";
        this.peerUid = "";
        this.guildId = "";
        new MsgElement();
        this.downloadType = i3;
        this.thumbSize = i16;
        this.msgId = j3;
        this.msgRandom = j16;
        this.msgSeq = j17;
        this.msgTime = j18;
        this.chatType = i17;
        this.senderUid = str;
        this.peerUid = str2;
        this.guildId = str3;
        this.elem = msgElement;
        this.useHttps = num;
    }
}
