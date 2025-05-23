package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InitLoginConfig {
    public long appid;
    public String bid;
    public String commonPath = "";
    public String clientVer = "";
    public String guid = "";
    public String platVer = "";
    public String hostName = "";
    public LoginPlatformType platform = LoginPlatformType.values()[0];
    public String deviceType = "";
    public String qua = "";
    public String appName = "";

    public String getAppName() {
        return this.appName;
    }

    public long getAppid() {
        return this.appid;
    }

    public String getBid() {
        return this.bid;
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public String getCommonPath() {
        return this.commonPath;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String getPlatVer() {
        return this.platVer;
    }

    public LoginPlatformType getPlatform() {
        return this.platform;
    }

    public String getQua() {
        return this.qua;
    }

    public String toString() {
        return "InitLoginConfig{commonPath=" + this.commonPath + ",clientVer=" + this.clientVer + ",guid=" + this.guid + ",platVer=" + this.platVer + ",hostName=" + this.hostName + ",platform=" + this.platform + ",deviceType=" + this.deviceType + ",qua=" + this.qua + ",bid=" + this.bid + ",appid=" + this.appid + ",appName=" + this.appName + ",}";
    }
}
