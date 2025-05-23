package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bf {

    /* renamed from: c, reason: collision with root package name */
    protected int f266196c;

    /* renamed from: a, reason: collision with root package name */
    protected ds f266194a = new ds();

    /* renamed from: b, reason: collision with root package name */
    protected t f266195b = new t();

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<cy> f266197d = new ArrayList<>();

    public ds a() {
        return this.f266194a;
    }

    public ArrayList<cy> b() {
        return this.f266197d;
    }

    public int c() {
        return this.f266196c;
    }

    public t d() {
        return this.f266195b;
    }

    public void e(ArrayList<cy> arrayList) {
        this.f266197d = arrayList;
    }

    public void f(int i3) {
        this.f266196c = i3;
    }

    public void g(t tVar) {
        this.f266195b = tVar;
    }

    public String toString() {
        return "GWGProGetCategoryPageGuildsReq{mCategory=" + this.f266194a + "mSource=" + this.f266195b + "mRefreshNum=" + this.f266196c + "mItemList=" + this.f266197d + "}";
    }
}
