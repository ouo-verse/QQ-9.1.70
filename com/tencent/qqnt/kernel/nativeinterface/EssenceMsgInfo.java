package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EssenceMsgInfo {
    public int addDigestTime;
    public long groupCode;
    public int msgRandom;
    public int msgSeq;
    public int senderTime;
    public String senderAvatar = "";
    public String senderNick = "";
    public String addDigestAvatar = "";
    public String addDigestNick = "";
    public String jumpUrl = "";
    public ArrayList<EssenceMsgContent> msgContent = new ArrayList<>();

    public String getAddDigestAvatar() {
        return this.addDigestAvatar;
    }

    public String getAddDigestNick() {
        return this.addDigestNick;
    }

    public int getAddDigestTime() {
        return this.addDigestTime;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public ArrayList<EssenceMsgContent> getMsgContent() {
        return this.msgContent;
    }

    public int getMsgRandom() {
        return this.msgRandom;
    }

    public int getMsgSeq() {
        return this.msgSeq;
    }

    public String getSenderAvatar() {
        return this.senderAvatar;
    }

    public String getSenderNick() {
        return this.senderNick;
    }

    public int getSenderTime() {
        return this.senderTime;
    }

    public String toString() {
        return "EssenceMsgInfo{groupCode=" + this.groupCode + ",msgSeq=" + this.msgSeq + ",msgRandom=" + this.msgRandom + ",senderAvatar=" + this.senderAvatar + ",senderNick=" + this.senderNick + ",senderTime=" + this.senderTime + ",addDigestAvatar=" + this.addDigestAvatar + ",addDigestNick=" + this.addDigestNick + ",addDigestTime=" + this.addDigestTime + ",jumpUrl=" + this.jumpUrl + ",msgContent=" + this.msgContent + ",}";
    }
}
