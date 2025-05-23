package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InitQRConfig {
    public String appName;
    public int appid;
    public String deviceName;
    public String guid;
    public String version;

    public InitQRConfig() {
        this.appName = "";
        this.version = "";
        this.deviceName = "";
        this.guid = "";
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAppid() {
        return this.appid;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "InitQRConfig{appid=" + this.appid + ",appName=" + this.appName + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",deviceName=" + this.deviceName + ",guid=" + this.guid + ",}";
    }

    public InitQRConfig(int i3, String str, String str2, String str3, String str4) {
        this.appid = i3;
        this.appName = str;
        this.version = str2;
        this.deviceName = str3;
        this.guid = str4;
    }
}
