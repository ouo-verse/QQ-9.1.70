package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ej {

    /* renamed from: a, reason: collision with root package name */
    protected long f266516a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Long> f266517b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<Long> f266518c = new ArrayList<>();

    public ArrayList<Long> a() {
        return this.f266518c;
    }

    public ArrayList<Long> b() {
        return this.f266517b;
    }

    public long c() {
        return this.f266516a;
    }

    public void d(ArrayList<Long> arrayList) {
        this.f266518c = arrayList;
    }

    public void e(ArrayList<Long> arrayList) {
        this.f266517b = arrayList;
    }

    public void f(long j3) {
        this.f266516a = j3;
    }

    public String toString() {
        return "GWGProSetCategoryOrderReq{mGuildId=" + this.f266516a + "mEnableList=" + this.f266517b + "mDisableList=" + this.f266518c + "}";
    }
}
