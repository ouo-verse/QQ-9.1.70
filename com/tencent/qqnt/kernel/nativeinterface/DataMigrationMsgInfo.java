package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DataMigrationMsgInfo {
    public int chatType;
    public String chatUin;
    public byte[] extensionData;
    public String extraData;
    public long msgRandom;
    public long msgSeq;
    public long msgTime;
    public int msgType;

    public DataMigrationMsgInfo() {
        this.chatUin = "";
        this.extensionData = new byte[0];
        this.extraData = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getChatUin() {
        return this.chatUin;
    }

    public byte[] getExtensionData() {
        return this.extensionData;
    }

    public String getExtraData() {
        return this.extraData;
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

    public String toString() {
        return "DataMigrationMsgInfo{chatType=" + this.chatType + ",chatUin=" + this.chatUin + ",msgType=" + this.msgType + ",msgTime=" + this.msgTime + ",msgSeq=" + this.msgSeq + ",msgRandom=" + this.msgRandom + ",extensionData=" + this.extensionData + ",extraData=" + this.extraData + ",}";
    }

    public DataMigrationMsgInfo(int i3, String str, int i16, long j3, long j16, long j17, byte[] bArr, String str2) {
        this.chatType = i3;
        this.chatUin = str;
        this.msgType = i16;
        this.msgTime = j3;
        this.msgSeq = j16;
        this.msgRandom = j17;
        this.extensionData = bArr;
        this.extraData = str2;
    }
}
