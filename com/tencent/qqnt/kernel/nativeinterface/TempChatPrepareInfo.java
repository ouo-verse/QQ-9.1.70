package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class TempChatPrepareInfo {
    public int chatType;
    public String fromGroupCode;
    public TempChatGameSession gameSession;
    public String peerNickname;
    public String peerUid;
    public String selfPhone;
    public String selfUid;
    public byte[] sig;

    public TempChatPrepareInfo() {
        this.peerUid = "";
        this.peerNickname = "";
        this.fromGroupCode = "";
        this.sig = new byte[0];
        this.selfUid = "";
        this.selfPhone = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getFromGroupCode() {
        return this.fromGroupCode;
    }

    public TempChatGameSession getGameSession() {
        return this.gameSession;
    }

    public String getPeerNickname() {
        return this.peerNickname;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getSelfPhone() {
        return this.selfPhone;
    }

    public String getSelfUid() {
        return this.selfUid;
    }

    public byte[] getSig() {
        return this.sig;
    }

    public String toString() {
        return "TempChatPrepareInfo{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",peerNickname=" + this.peerNickname + ",fromGroupCode=" + this.fromGroupCode + ",sig=" + this.sig + ",selfUid=" + this.selfUid + ",selfPhone=" + this.selfPhone + ",gameSession=" + this.gameSession + ",}";
    }

    public TempChatPrepareInfo(int i3, String str, String str2, String str3, byte[] bArr, String str4, String str5, TempChatGameSession tempChatGameSession) {
        this.chatType = i3;
        this.peerUid = str;
        this.peerNickname = str2;
        this.fromGroupCode = str3;
        this.sig = bArr;
        this.selfUid = str4;
        this.selfPhone = str5;
        this.gameSession = tempChatGameSession;
    }
}
