package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class WrapperEngineGlobalConfig implements IKernelModel {
    public int appType;
    public String appVersion;
    public InitGlobalPathConfig globalPathConfig;
    public String osVersion;
    public int platformType;
    public String qua;
    public ThumbConfig thumbConfig;
    public boolean useXlog;

    public WrapperEngineGlobalConfig() {
        this.appVersion = "";
        this.osVersion = "";
        this.globalPathConfig = new InitGlobalPathConfig();
        this.qua = "";
    }

    public int getAppType() {
        return this.appType;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public InitGlobalPathConfig getGlobalPathConfig() {
        return this.globalPathConfig;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public int getPlatformType() {
        return this.platformType;
    }

    public String getQua() {
        return this.qua;
    }

    public ThumbConfig getThumbConfig() {
        return this.thumbConfig;
    }

    public boolean getUseXlog() {
        return this.useXlog;
    }

    public void setAppType(int i3) {
        this.appType = i3;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setGlobalPathConfig(InitGlobalPathConfig initGlobalPathConfig) {
        this.globalPathConfig = initGlobalPathConfig;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setPlatformType(int i3) {
        this.platformType = i3;
    }

    public void setQua(String str) {
        this.qua = str;
    }

    public void setThumbConfig(ThumbConfig thumbConfig) {
        this.thumbConfig = thumbConfig;
    }

    public void setUseXlog(boolean z16) {
        this.useXlog = z16;
    }

    public String toString() {
        return "WrapperEngineGlobalConfig{platformType=" + this.platformType + ",appType=" + this.appType + ",appVersion=" + this.appVersion + ",osVersion=" + this.osVersion + ",globalPathConfig=" + this.globalPathConfig + ",thumbConfig=" + this.thumbConfig + ",useXlog=" + this.useXlog + ",qua=" + this.qua + ",}";
    }

    public WrapperEngineGlobalConfig(int i3, int i16, String str, String str2, InitGlobalPathConfig initGlobalPathConfig, ThumbConfig thumbConfig, boolean z16, String str3) {
        this.appVersion = "";
        this.osVersion = "";
        new InitGlobalPathConfig();
        this.platformType = i3;
        this.appType = i16;
        this.appVersion = str;
        this.osVersion = str2;
        this.globalPathConfig = initGlobalPathConfig;
        this.thumbConfig = thumbConfig;
        this.useXlog = z16;
        this.qua = str3;
    }
}
