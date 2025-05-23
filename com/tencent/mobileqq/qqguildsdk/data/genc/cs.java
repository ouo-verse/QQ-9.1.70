package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cs {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<Long> f266341a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Long> f266342b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<cq> f266343c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    protected int f266344d;

    public ArrayList<Long> a() {
        return this.f266341a;
    }

    public ArrayList<Long> b() {
        return this.f266342b;
    }

    public int c() {
        return this.f266344d;
    }

    public ArrayList<cq> d() {
        return this.f266343c;
    }

    public void e(ArrayList<Long> arrayList) {
        this.f266341a = arrayList;
    }

    public void f(ArrayList<Long> arrayList) {
        this.f266342b = arrayList;
    }

    public void g(int i3) {
        this.f266344d = i3;
    }

    public void h(ArrayList<cq> arrayList) {
        this.f266343c = arrayList;
    }

    public String toString() {
        return "GWGProGuildSearchSearchCond{mChannelIds=" + this.f266341a + "mFromTinyids=" + this.f266342b + "mTimeRanges=" + this.f266343c + "mRankType=" + this.f266344d + "}";
    }
}
