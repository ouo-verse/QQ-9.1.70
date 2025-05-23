package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppInfo implements Serializable {
    public long appId;
    long serialVersionUID = 1;
    public String version = "";
    public String appName = "";
    public String qua = "";

    public long getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getQua() {
        return this.qua;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "AppInfo{version=" + this.version + ",appId=" + this.appId + ",appName=" + this.appName + ",qua=" + this.qua + ",}";
    }
}
