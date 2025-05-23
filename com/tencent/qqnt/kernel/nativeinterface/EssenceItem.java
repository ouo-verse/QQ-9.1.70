package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EssenceItem {
    public long grayTipSeq;
    public long groupCode;
    public int msgRandom;
    public long msgSenderUin;
    public int msgSeq;
    public int opTime;
    public int opType;
    public long opUin;
    public String msgSenderNick = "";
    public String opNick = "";

    public long getGrayTipSeq() {
        return this.grayTipSeq;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getMsgRandom() {
        return this.msgRandom;
    }

    public String getMsgSenderNick() {
        return this.msgSenderNick;
    }

    public long getMsgSenderUin() {
        return this.msgSenderUin;
    }

    public int getMsgSeq() {
        return this.msgSeq;
    }

    public String getOpNick() {
        return this.opNick;
    }

    public int getOpTime() {
        return this.opTime;
    }

    public int getOpType() {
        return this.opType;
    }

    public long getOpUin() {
        return this.opUin;
    }

    public String toString() {
        return "EssenceItem{groupCode=" + this.groupCode + ",msgSeq=" + this.msgSeq + ",msgRandom=" + this.msgRandom + ",msgSenderUin=" + this.msgSenderUin + ",msgSenderNick=" + this.msgSenderNick + ",opType=" + this.opType + ",opUin=" + this.opUin + ",opNick=" + this.opNick + ",opTime=" + this.opTime + ",grayTipSeq=" + this.grayTipSeq + ",}";
    }
}
