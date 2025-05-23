package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class fc {

    /* renamed from: b, reason: collision with root package name */
    protected long f266586b;

    /* renamed from: a, reason: collision with root package name */
    protected k f266585a = new k();

    /* renamed from: c, reason: collision with root package name */
    protected l f266587c = new l();

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<an> f266588d = new ArrayList<>();

    public k a() {
        return this.f266585a;
    }

    public l b() {
        return this.f266587c;
    }

    public ArrayList<an> c() {
        return this.f266588d;
    }

    public long d() {
        return this.f266586b;
    }

    public void e(k kVar) {
        this.f266585a = kVar;
    }

    public void f(l lVar) {
        this.f266587c = lVar;
    }

    public void g(long j3) {
        this.f266586b = j3;
    }

    public String toString() {
        return "GWGProUserAVReqInfo{mCommonInfo=" + this.f266585a + "mTinyId=" + this.f266586b + "mDevOpt=" + this.f266587c + "mExtInfos=" + this.f266588d + "}";
    }
}
