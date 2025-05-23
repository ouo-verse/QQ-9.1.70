package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProConfigItem {
    public int configID;
    public int configStatus;
    public String desc = "";
    public String jumpUrl = "";

    public int getConfigID() {
        return this.configID;
    }

    public int getConfigStatus() {
        return this.configStatus;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String toString() {
        return "GProConfigItem{configID=" + this.configID + ",configStatus=" + this.configStatus + ",desc=" + this.desc + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
