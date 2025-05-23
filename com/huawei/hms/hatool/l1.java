package com.huawei.hms.hatool;

/* compiled from: P */
/* loaded from: classes2.dex */
public class l1 {

    /* renamed from: a, reason: collision with root package name */
    private s0 f37170a;

    /* renamed from: b, reason: collision with root package name */
    private s0 f37171b;

    /* renamed from: c, reason: collision with root package name */
    private s0 f37172c;

    /* renamed from: d, reason: collision with root package name */
    private s0 f37173d;

    public l1(String str) {
    }

    public s0 a() {
        return this.f37172c;
    }

    public s0 b() {
        return this.f37170a;
    }

    public s0 c() {
        return this.f37171b;
    }

    public s0 d() {
        return this.f37173d;
    }

    public s0 a(String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        v.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void b(s0 s0Var) {
        this.f37171b = s0Var;
    }

    public void a(s0 s0Var) {
        this.f37170a = s0Var;
    }
}
