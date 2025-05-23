package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FetchEssenceMsgInfo {
    public int addDigestTime;
    public long addDigestUin;
    public boolean canBeRemoved;
    public long groupCode;
    public int msgRandom;
    public int msgSeq;
    public int senderTime;
    public long senderUin;
    public String senderNick = "";
    public String addDigestNick = "";
    public ArrayList<FetchEssenceMsgContent> msgContent = new ArrayList<>();

    public String getAddDigestNick() {
        return this.addDigestNick;
    }

    public int getAddDigestTime() {
        return this.addDigestTime;
    }

    public long getAddDigestUin() {
        return this.addDigestUin;
    }

    public boolean getCanBeRemoved() {
        return this.canBeRemoved;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<FetchEssenceMsgContent> getMsgContent() {
        return this.msgContent;
    }

    public int getMsgRandom() {
        return this.msgRandom;
    }

    public int getMsgSeq() {
        return this.msgSeq;
    }

    public String getSenderNick() {
        return this.senderNick;
    }

    public int getSenderTime() {
        return this.senderTime;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public String toString() {
        return "FetchEssenceMsgInfo{groupCode=" + this.groupCode + ",msgSeq=" + this.msgSeq + ",msgRandom=" + this.msgRandom + ",senderUin=" + this.senderUin + ",senderNick=" + this.senderNick + ",senderTime=" + this.senderTime + ",addDigestUin=" + this.addDigestUin + ",addDigestNick=" + this.addDigestNick + ",addDigestTime=" + this.addDigestTime + ",msgContent=" + this.msgContent + ",canBeRemoved=" + this.canBeRemoved + ",}";
    }
}
