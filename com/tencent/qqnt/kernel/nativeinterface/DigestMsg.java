package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestMsg {
    public int addDigestTime;
    public long addDigestUin;
    public long groupCode;
    public int latestMsgSeq;
    public ArrayList<DigestMsgElem> msgContent = new ArrayList<>();
    public int msgRandom;
    public int msgSeq;
    public int opType;
    public long picSize;
    public int senderTime;
    public long senderUin;
    public int startTime;
    public long textSize;
    public long videoSize;

    public int getAddDigestTime() {
        return this.addDigestTime;
    }

    public long getAddDigestUin() {
        return this.addDigestUin;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getLatestMsgSeq() {
        return this.latestMsgSeq;
    }

    public ArrayList<DigestMsgElem> getMsgContent() {
        return this.msgContent;
    }

    public int getMsgRandom() {
        return this.msgRandom;
    }

    public int getMsgSeq() {
        return this.msgSeq;
    }

    public int getOpType() {
        return this.opType;
    }

    public long getPicSize() {
        return this.picSize;
    }

    public int getSenderTime() {
        return this.senderTime;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public long getTextSize() {
        return this.textSize;
    }

    public long getVideoSize() {
        return this.videoSize;
    }

    public String toString() {
        return "DigestMsg{groupCode=" + this.groupCode + ",msgSeq=" + this.msgSeq + ",msgRandom=" + this.msgRandom + ",msgContent=" + this.msgContent + ",textSize=" + this.textSize + ",picSize=" + this.picSize + ",videoSize=" + this.videoSize + ",senderUin=" + this.senderUin + ",senderTime=" + this.senderTime + ",addDigestUin=" + this.addDigestUin + ",addDigestTime=" + this.addDigestTime + ",startTime=" + this.startTime + ",latestMsgSeq=" + this.latestMsgSeq + ",opType=" + this.opType + ",}";
    }
}
