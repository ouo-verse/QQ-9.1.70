package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QrOpenAppInfo {
    public QrOpenAppType appType = QrOpenAppType.values()[0];
    public String comeFrom = "";
    public long openAppid;

    public QrOpenAppType getAppType() {
        return this.appType;
    }

    public String getComeFrom() {
        return this.comeFrom;
    }

    public long getOpenAppid() {
        return this.openAppid;
    }

    public String toString() {
        return "QrOpenAppInfo{openAppid=" + this.openAppid + ",appType=" + this.appType + ",comeFrom=" + this.comeFrom + ",}";
    }
}
