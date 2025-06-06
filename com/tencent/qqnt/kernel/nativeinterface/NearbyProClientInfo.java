package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class NearbyProClientInfo {
    public String device;
    public int platform;
    public String qqVer;

    public NearbyProClientInfo() {
        this.qqVer = "";
        this.device = "";
    }

    public String getDevice() {
        return this.device;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getQqVer() {
        return this.qqVer;
    }

    public String toString() {
        return "NearbyProClientInfo{qqVer=" + this.qqVer + ",device=" + this.device + ",platform=" + this.platform + ",}";
    }

    public NearbyProClientInfo(String str, String str2, int i3) {
        this.qqVer = str;
        this.device = str2;
        this.platform = i3;
    }
}
