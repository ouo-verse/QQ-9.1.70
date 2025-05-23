package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class en {

    /* renamed from: a, reason: collision with root package name */
    protected long f266526a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Long> f266527b = new ArrayList<>();

    public ArrayList<Long> a() {
        return this.f266527b;
    }

    public long b() {
        return this.f266526a;
    }

    public void c(ArrayList<Long> arrayList) {
        this.f266527b = arrayList;
    }

    public void d(long j3) {
        this.f266526a = j3;
    }

    public String toString() {
        return "GWGProSortAndWriteBindGroupsReq{mGuildId=" + this.f266526a + "mGroupCodeList=" + this.f266527b + "}";
    }
}
