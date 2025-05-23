package com.tencent.biz.pubaccount.weishi.net.common;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private int f80946a;

    /* renamed from: b, reason: collision with root package name */
    private String f80947b;

    public j(int i3, String str) {
        this.f80946a = i3;
        this.f80947b = str;
    }

    public int a() {
        return this.f80946a;
    }

    public String b() {
        String str = this.f80947b;
        return str == null ? "" : str;
    }

    public String toString() {
        return "WSServiceErrorInfo{mErrorCode=" + this.f80946a + ", mErrorMsg='" + this.f80947b + "'}";
    }
}
