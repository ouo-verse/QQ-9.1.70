package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgsReq {
    public int byType;
    public long clientSeq;
    public int cnt;
    public int extraCnt;
    public boolean includeDeleteMsg;
    public boolean includeSelf;
    public long msgId;
    public long msgSeq;
    public long msgTime;
    public Contact peer;
    public boolean queryOrder;

    public MsgsReq() {
        this.peer = new Contact();
    }

    public int getByType() {
        return this.byType;
    }

    public long getClientSeq() {
        return this.clientSeq;
    }

    public int getCnt() {
        return this.cnt;
    }

    public int getExtraCnt() {
        return this.extraCnt;
    }

    public boolean getIncludeDeleteMsg() {
        return this.includeDeleteMsg;
    }

    public boolean getIncludeSelf() {
        return this.includeSelf;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public Contact getPeer() {
        return this.peer;
    }

    public boolean getQueryOrder() {
        return this.queryOrder;
    }

    public String toString() {
        return "MsgsReq{peer=" + this.peer + ",byType=" + this.byType + ",msgId=" + this.msgId + ",msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",clientSeq=" + this.clientSeq + ",cnt=" + this.cnt + ",queryOrder=" + this.queryOrder + ",includeSelf=" + this.includeSelf + ",includeDeleteMsg=" + this.includeDeleteMsg + ",extraCnt=" + this.extraCnt + ",}";
    }

    public MsgsReq(Contact contact, int i3, long j3, long j16, long j17, long j18, int i16, boolean z16, boolean z17, boolean z18, int i17) {
        new Contact();
        this.peer = contact;
        this.byType = i3;
        this.msgId = j3;
        this.msgSeq = j16;
        this.msgTime = j17;
        this.clientSeq = j18;
        this.cnt = i16;
        this.queryOrder = z16;
        this.includeSelf = z17;
        this.includeDeleteMsg = z18;
        this.extraCnt = i17;
    }
}
