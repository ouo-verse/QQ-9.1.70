package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCommResult {

    /* renamed from: msg, reason: collision with root package name */
    public String f359285msg = "";
    public int retCode;

    public String getMsg() {
        return this.f359285msg;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String toString() {
        return "GProCommResult{retCode=" + this.retCode + ",msg=" + this.f359285msg + ",}";
    }
}
