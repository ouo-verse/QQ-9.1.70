package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ClientInfo {
    public int platform;
    public String version = "";

    public int getPlatform() {
        return this.platform;
    }

    public String getVersion() {
        return this.version;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "ClientInfo{platform=" + this.platform + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",}";
    }
}
