package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class dx {

    /* renamed from: a, reason: collision with root package name */
    protected long f266455a;

    /* renamed from: b, reason: collision with root package name */
    protected String f266456b = "";

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<ea> f266457c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    protected long f266458d;

    /* renamed from: e, reason: collision with root package name */
    protected int f266459e;

    public int a() {
        return this.f266459e;
    }

    public long b() {
        return this.f266455a;
    }

    public String c() {
        return this.f266456b;
    }

    public ArrayList<ea> d() {
        return this.f266457c;
    }

    public long e() {
        return this.f266458d;
    }

    public void f(int i3) {
        this.f266459e = i3;
    }

    public void g(long j3) {
        this.f266455a = j3;
    }

    public void h(String str) {
        this.f266456b = str;
    }

    public void i(ArrayList<ea> arrayList) {
        this.f266457c = arrayList;
    }

    public String toString() {
        return "GWGProSaveCustomApplicationReq{mGuildId=" + this.f266455a + "mIconSelectorColor=" + this.f266456b + "mItems=" + this.f266457c + "mVersion=" + this.f266458d + "mAction=" + this.f266459e + "}";
    }
}
