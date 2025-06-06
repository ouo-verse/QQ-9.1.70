package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InlineKeyboardClickInfo {
    public long botAppid;
    public String buttonId;
    public String callbackData;
    public int chatType;
    public int dmFlag;
    public String guildId;
    public long msgSeq;
    public String peerId;

    public InlineKeyboardClickInfo() {
        this.guildId = "";
        this.peerId = "";
        this.buttonId = "";
        this.callbackData = "";
    }

    public long getBotAppid() {
        return this.botAppid;
    }

    public String getButtonId() {
        return this.buttonId;
    }

    public String getCallbackData() {
        return this.callbackData;
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getDmFlag() {
        return this.dmFlag;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getPeerId() {
        return this.peerId;
    }

    public String toString() {
        return "InlineKeyboardClickInfo{guildId=" + this.guildId + ",peerId=" + this.peerId + ",botAppid=" + this.botAppid + ",msgSeq=" + this.msgSeq + ",buttonId=" + this.buttonId + ",callbackData=" + this.callbackData + ",dmFlag=" + this.dmFlag + ",chatType=" + this.chatType + ",}";
    }

    public InlineKeyboardClickInfo(String str, String str2, long j3, long j16, String str3, String str4, int i3, int i16) {
        this.guildId = str;
        this.peerId = str2;
        this.botAppid = j3;
        this.msgSeq = j16;
        this.buttonId = str3;
        this.callbackData = str4;
        this.dmFlag = i3;
        this.chatType = i16;
    }
}
