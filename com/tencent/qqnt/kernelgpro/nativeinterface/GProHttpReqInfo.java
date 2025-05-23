package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProHttpReqInfo {
    public int env;
    public String pskey = "";
    public String appid = "";
    public String routeId = "";

    public String getAppid() {
        return this.appid;
    }

    public int getEnv() {
        return this.env;
    }

    public String getPskey() {
        return this.pskey;
    }

    public String getRouteId() {
        return this.routeId;
    }

    public String toString() {
        return "GProHttpReqInfo{pskey=" + this.pskey + ",appid=" + this.appid + ",env=" + this.env + ",routeId=" + this.routeId + ",}";
    }
}
