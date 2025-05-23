package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAppInfo {
    public long appId;
    public int appQyyFlag;
    public String iconUrl = "";
    public String appName = "";
    public String appDescription = "";
    public ArrayList<String> preViewList = new ArrayList<>();

    public String getAppDescription() {
        return this.appDescription;
    }

    public long getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAppQyyFlag() {
        return this.appQyyFlag;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public ArrayList<String> getPreViewList() {
        return this.preViewList;
    }

    public String toString() {
        return "GProAppInfo{appId=" + this.appId + ",iconUrl=" + this.iconUrl + ",appName=" + this.appName + ",appDescription=" + this.appDescription + ",preViewList=" + this.preViewList + ",appQyyFlag=" + this.appQyyFlag + ",}";
    }
}
