package com.huawei.hms.push.ups.entity;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CodeResult {

    /* renamed from: a, reason: collision with root package name */
    public int f37484a;

    /* renamed from: b, reason: collision with root package name */
    public String f37485b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f37485b;
    }

    public int getReturnCode() {
        return this.f37484a;
    }

    public void setReason(String str) {
        this.f37485b = str;
    }

    public void setReturnCode(int i3) {
        this.f37484a = i3;
    }

    public CodeResult(int i3) {
        this.f37484a = i3;
    }

    public CodeResult(int i3, String str) {
        this.f37484a = i3;
        this.f37485b = str;
    }
}
