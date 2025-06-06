package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ChatInfo {
    public int chatType;
    public String peerUid;

    public ChatInfo() {
        this.peerUid = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "ChatInfo{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",}";
    }

    public ChatInfo(int i3, String str) {
        this.chatType = i3;
        this.peerUid = str;
    }
}
