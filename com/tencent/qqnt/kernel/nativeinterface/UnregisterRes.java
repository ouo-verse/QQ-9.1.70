package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UnregisterRes {

    /* renamed from: msg, reason: collision with root package name */
    public String f359235msg;
    public int result;

    public UnregisterRes() {
        this.f359235msg = "";
    }

    public String getMsg() {
        return this.f359235msg;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "UnregisterRes{result=" + this.result + ",msg=" + this.f359235msg + ",}";
    }

    public UnregisterRes(int i3, String str) {
        this.result = i3;
        this.f359235msg = str;
    }
}
