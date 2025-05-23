package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NotificationCommonInfo {
    public long msgListUnreadCnt;

    public NotificationCommonInfo() {
    }

    public long getMsgListUnreadCnt() {
        return this.msgListUnreadCnt;
    }

    public String toString() {
        return "NotificationCommonInfo{msgListUnreadCnt=" + this.msgListUnreadCnt + ",}";
    }

    public NotificationCommonInfo(long j3) {
        this.msgListUnreadCnt = j3;
    }
}
