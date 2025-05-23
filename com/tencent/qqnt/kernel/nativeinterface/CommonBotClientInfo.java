package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CommonBotClientInfo {
    public int buildNum;
    public int platform;
    public String version;

    public CommonBotClientInfo() {
        this.version = "";
    }

    public int getBuildNum() {
        return this.buildNum;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "CommonBotClientInfo{platform=" + this.platform + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",buildNum=" + this.buildNum + ",}";
    }

    public CommonBotClientInfo(int i3, String str, int i16) {
        this.platform = i3;
        this.version = str;
        this.buildNum = i16;
    }
}
