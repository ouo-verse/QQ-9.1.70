package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProBotClientInfo {
    public int buildNum;
    public int platform;
    public String version;

    public GProBotClientInfo() {
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

    public void setBuildNum(int i3) {
        this.buildNum = i3;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "GProBotClientInfo{platform=" + this.platform + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",buildNum=" + this.buildNum + ",}";
    }

    public GProBotClientInfo(int i3, String str, int i16) {
        this.platform = i3;
        this.version = str;
        this.buildNum = i16;
    }
}
