package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class JsonGrayMsgInfo {
    public long cliSeq;
    public long msgId;
    public long msgRandom;
    public long msgSeq;
    public long msgTime;

    public JsonGrayMsgInfo() {
    }

    public long getCliSeq() {
        return this.cliSeq;
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

    public String toString() {
        return "JsonGrayMsgInfo{msgId=" + this.msgId + ",msgSeq=" + this.msgSeq + ",cliSeq=" + this.cliSeq + ",msgTime=" + this.msgTime + ",msgRandom=" + this.msgRandom + ",}";
    }

    public JsonGrayMsgInfo(long j3, long j16, long j17, long j18, long j19) {
        this.msgId = j3;
        this.msgSeq = j16;
        this.cliSeq = j17;
        this.msgTime = j18;
        this.msgRandom = j19;
    }
}
