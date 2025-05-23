package com.tencent.mobileqq.config.business;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bo {

    /* renamed from: a, reason: collision with root package name */
    private int f202641a = 2;

    /* renamed from: b, reason: collision with root package name */
    private int f202642b = 1;

    /* renamed from: c, reason: collision with root package name */
    private String f202643c = "https://ti.qq.com/sportslive/index?_wwv=128&_wv=2";

    /* renamed from: d, reason: collision with root package name */
    private String f202644d = "{\"key\": \"value\"}";

    public String a() {
        return this.f202644d;
    }

    public int b() {
        return this.f202642b;
    }

    public String c() {
        return this.f202643c;
    }

    public int d() {
        return this.f202641a;
    }

    public void e(String str) {
        this.f202644d = str;
    }

    public void f(int i3) {
        this.f202642b = i3;
    }

    public void g(String str) {
        this.f202643c = str;
    }

    public void h(int i3) {
        this.f202641a = i3;
    }

    public String toString() {
        return "WatchTogetherBean{version=" + this.f202641a + ", jumpType=" + this.f202642b + ", jumpUrl='" + this.f202643c + "', jumpExtensionInfo='" + this.f202644d + "'}";
    }
}
