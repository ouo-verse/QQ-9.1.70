package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBriefAppInfo {
    public String appId = "";
    public String appName = "";
    public String appAvatarUrl = "";

    public String getAppAvatarUrl() {
        return this.appAvatarUrl;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String toString() {
        return "GProBriefAppInfo{appId=" + this.appId + ",appName=" + this.appName + ",appAvatarUrl=" + this.appAvatarUrl + ",}";
    }
}
