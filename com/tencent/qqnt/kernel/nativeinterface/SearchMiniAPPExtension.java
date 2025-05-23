package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class SearchMiniAPPExtension {
    public String appid = "";
    public String miniappPath = "";
    public int miniappType;

    public String getAppid() {
        return this.appid;
    }

    public String getMiniappPath() {
        return this.miniappPath;
    }

    public int getMiniappType() {
        return this.miniappType;
    }

    public String toString() {
        return "SearchMiniAPPExtension{appid=" + this.appid + ",miniappType=" + this.miniappType + ",miniappPath=" + this.miniappPath + ",}";
    }
}
