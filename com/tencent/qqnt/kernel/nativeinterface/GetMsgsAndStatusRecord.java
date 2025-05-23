package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetMsgsAndStatusRecord {
    public long appid;
    public int cnt;
    public boolean isIncludeSelf;
    public long msgId;
    public long msgTime;
    public Contact peer;
    public boolean queryOrder;

    public GetMsgsAndStatusRecord() {
        this.peer = new Contact();
    }

    public long getAppid() {
        return this.appid;
    }

    public int getCnt() {
        return this.cnt;
    }

    public boolean getIsIncludeSelf() {
        return this.isIncludeSelf;
    }

    public long getMsgId() {
        return this.msgId;
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
        return "GetMsgsAndStatusRecord{peer=" + this.peer + ",msgId=" + this.msgId + ",msgTime=" + this.msgTime + ",cnt=" + this.cnt + ",queryOrder=" + this.queryOrder + ",isIncludeSelf=" + this.isIncludeSelf + ",appid=" + this.appid + ",}";
    }

    public GetMsgsAndStatusRecord(Contact contact, long j3, long j16, int i3, boolean z16, boolean z17, long j17) {
        new Contact();
        this.peer = contact;
        this.msgId = j3;
        this.msgTime = j16;
        this.cnt = i3;
        this.queryOrder = z16;
        this.isIncludeSelf = z17;
        this.appid = j17;
    }
}
