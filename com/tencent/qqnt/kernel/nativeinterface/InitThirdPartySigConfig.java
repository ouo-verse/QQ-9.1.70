package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class InitThirdPartySigConfig {
    public String bid;
    public String commonPath = "";
    public String openidPath = "";

    public String getBid() {
        return this.bid;
    }

    public String getCommonPath() {
        return this.commonPath;
    }

    public String getOpenidPath() {
        return this.openidPath;
    }

    public String toString() {
        return "InitThirdPartySigConfig{commonPath=" + this.commonPath + ",openidPath=" + this.openidPath + ",bid=" + this.bid + ",}";
    }
}
