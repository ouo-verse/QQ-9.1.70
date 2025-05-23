package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgBoxNecessaryMsgInfo {
    public String highlightDigest;
    public long msgSeq;
    public long msgTime;

    public MsgBoxNecessaryMsgInfo() {
        this.highlightDigest = "";
    }

    public String getHighlightDigest() {
        return this.highlightDigest;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String toString() {
        return "MsgBoxNecessaryMsgInfo{msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",highlightDigest=" + this.highlightDigest + ",}";
    }

    public MsgBoxNecessaryMsgInfo(long j3, long j16, String str) {
        this.msgSeq = j3;
        this.msgTime = j16;
        this.highlightDigest = str;
    }
}
