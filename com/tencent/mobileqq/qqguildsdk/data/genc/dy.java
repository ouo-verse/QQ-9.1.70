package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class dy {

    /* renamed from: a, reason: collision with root package name */
    protected long f266460a;

    /* renamed from: b, reason: collision with root package name */
    protected String f266461b = "";

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<ea> f266462c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    protected long f266463d;

    public long a() {
        return this.f266460a;
    }

    public String b() {
        return this.f266461b;
    }

    public ArrayList<ea> c() {
        return this.f266462c;
    }

    public long d() {
        return this.f266463d;
    }

    public void e(long j3) {
        this.f266460a = j3;
    }

    public void f(String str) {
        this.f266461b = str;
    }

    public void g(ArrayList<ea> arrayList) {
        this.f266462c = arrayList;
    }

    public void h(long j3) {
        this.f266463d = j3;
    }

    public String toString() {
        return "GWGProSaveGuildNavigationReq{mGuildId=" + this.f266460a + "mIconSelectorColor=" + this.f266461b + "mItems=" + this.f266462c + "mVersion=" + this.f266463d + "}";
    }
}
