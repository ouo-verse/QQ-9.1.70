package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QQConnectAttr {
    public long appID;
    public int appType;

    public QQConnectAttr() {
    }

    public long getAppID() {
        return this.appID;
    }

    public int getAppType() {
        return this.appType;
    }

    public String toString() {
        return "QQConnectAttr{appID=" + this.appID + ",appType=" + this.appType + ",}";
    }

    public QQConnectAttr(long j3, int i3) {
        this.appID = j3;
        this.appType = i3;
    }
}
