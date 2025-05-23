package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPAReportExecuteRsp {

    /* renamed from: msg, reason: collision with root package name */
    public String f359307msg;
    public int ret;

    public GProPAReportExecuteRsp() {
        this.f359307msg = "";
    }

    public String getMsg() {
        return this.f359307msg;
    }

    public int getRet() {
        return this.ret;
    }

    public String toString() {
        return "GProPAReportExecuteRsp{ret=" + this.ret + ",msg=" + this.f359307msg + ",}";
    }

    public GProPAReportExecuteRsp(int i3, String str) {
        this.ret = i3;
        this.f359307msg = str;
    }
}
