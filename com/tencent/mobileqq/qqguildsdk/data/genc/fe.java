package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class fe {

    /* renamed from: a, reason: collision with root package name */
    protected long f266595a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266596b;

    /* renamed from: c, reason: collision with root package name */
    protected String f266597c = "";

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<Integer> f266598d = new ArrayList<>();

    public long a() {
        return this.f266596b;
    }

    public String b() {
        return this.f266597c;
    }

    public long c() {
        return this.f266595a;
    }

    public ArrayList<Integer> d() {
        return this.f266598d;
    }

    public void e(long j3) {
        this.f266596b = j3;
    }

    public void f(String str) {
        this.f266597c = str;
    }

    public void g(long j3) {
        this.f266595a = j3;
    }

    public void h(ArrayList<Integer> arrayList) {
        this.f266598d = arrayList;
    }

    public String toString() {
        return "GWGProUserFreeGiftReq{mGuildId=" + this.f266595a + "mChannelId=" + this.f266596b + "mCheckContext=" + this.f266597c + "mThemeTypes=" + this.f266598d + "}";
    }
}
