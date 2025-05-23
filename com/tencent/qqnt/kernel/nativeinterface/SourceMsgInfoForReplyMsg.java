package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SourceMsgInfoForReplyMsg {
    public int chatType;
    public long clientSeq;
    public long msgRandom;
    public long msgSeq;
    public long msgTime;
    public String peerUid = "";
    public String senderUid = "";

    public int getChatType() {
        return this.chatType;
    }

    public long getClientSeq() {
        return this.clientSeq;
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

    public String toString() {
        return "SourceMsgInfoForReplyMsg{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",senderUid=" + this.senderUid + ",msgTime=" + this.msgTime + ",msgRandom=" + this.msgRandom + ",msgSeq=" + this.msgSeq + ",clientSeq=" + this.clientSeq + ",}";
    }
}
