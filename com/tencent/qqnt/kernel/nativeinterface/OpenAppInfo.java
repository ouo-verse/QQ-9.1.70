package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OpenAppInfo {
    public OpenAppType appType;
    public String comeFrom;
    public long openAppid;

    public OpenAppInfo() {
        this.appType = OpenAppType.values()[0];
        this.comeFrom = "";
    }

    public OpenAppType getAppType() {
        return this.appType;
    }

    public String getComeFrom() {
        return this.comeFrom;
    }

    public long getOpenAppid() {
        return this.openAppid;
    }

    public String toString() {
        return "OpenAppInfo{openAppid=" + this.openAppid + ",appType=" + this.appType + ",comeFrom=" + this.comeFrom + ",}";
    }

    public OpenAppInfo(long j3, OpenAppType openAppType, String str) {
        OpenAppType openAppType2 = OpenAppType.values()[0];
        this.openAppid = j3;
        this.appType = openAppType;
        this.comeFrom = str;
    }
}
