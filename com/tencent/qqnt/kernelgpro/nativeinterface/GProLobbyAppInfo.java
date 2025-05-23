package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLobbyAppInfo implements Serializable {
    public int antiAddiction;
    public int antiAddictionMode;
    public String appId;
    public String appName;
    public long appUin;
    public int fullScreenMode;
    public String h5Url;
    public String iconUrl;
    public int maxMember;
    public int minMember;
    public int perLoadingMaterialType;
    public String perLoadingMaterialUrl;
    public long permissionRequired;
    public int screenMode;
    long serialVersionUID;
    public String topImageUrl;

    public GProLobbyAppInfo() {
        this.serialVersionUID = 1L;
        this.appId = "";
        this.appName = "";
        this.iconUrl = "";
        this.topImageUrl = "";
        this.h5Url = "";
        this.perLoadingMaterialUrl = "";
    }

    public int getAntiAddiction() {
        return this.antiAddiction;
    }

    public int getAntiAddictionMode() {
        return this.antiAddictionMode;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public long getAppUin() {
        return this.appUin;
    }

    public int getFullScreenMode() {
        return this.fullScreenMode;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getMaxMember() {
        return this.maxMember;
    }

    public int getMinMember() {
        return this.minMember;
    }

    public int getPerLoadingMaterialType() {
        return this.perLoadingMaterialType;
    }

    public String getPerLoadingMaterialUrl() {
        return this.perLoadingMaterialUrl;
    }

    public long getPermissionRequired() {
        return this.permissionRequired;
    }

    public int getScreenMode() {
        return this.screenMode;
    }

    public String getTopImageUrl() {
        return this.topImageUrl;
    }

    public String toString() {
        return "GProLobbyAppInfo{appId=" + this.appId + ",appName=" + this.appName + ",iconUrl=" + this.iconUrl + ",topImageUrl=" + this.topImageUrl + ",h5Url=" + this.h5Url + ",screenMode=" + this.screenMode + ",permissionRequired=" + this.permissionRequired + ",appUin=" + this.appUin + ",minMember=" + this.minMember + ",maxMember=" + this.maxMember + ",antiAddiction=" + this.antiAddiction + ",perLoadingMaterialUrl=" + this.perLoadingMaterialUrl + ",perLoadingMaterialType=" + this.perLoadingMaterialType + ",fullScreenMode=" + this.fullScreenMode + ",antiAddictionMode=" + this.antiAddictionMode + ",}";
    }

    public GProLobbyAppInfo(String str, String str2, String str3, String str4, String str5, int i3, long j3, long j16, int i16, int i17, int i18, String str6, int i19, int i26, int i27) {
        this.serialVersionUID = 1L;
        this.appId = str;
        this.appName = str2;
        this.iconUrl = str3;
        this.topImageUrl = str4;
        this.h5Url = str5;
        this.screenMode = i3;
        this.permissionRequired = j3;
        this.appUin = j16;
        this.minMember = i16;
        this.maxMember = i17;
        this.antiAddiction = i18;
        this.perLoadingMaterialUrl = str6;
        this.perLoadingMaterialType = i19;
        this.fullScreenMode = i26;
        this.antiAddictionMode = i27;
    }
}
