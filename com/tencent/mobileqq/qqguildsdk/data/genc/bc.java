package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    protected long f266185a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Long> f266186b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<Integer> f266187c = new ArrayList<>();

    public ArrayList<Long> a() {
        return this.f266186b;
    }

    public ArrayList<Integer> b() {
        return this.f266187c;
    }

    public long c() {
        return this.f266185a;
    }

    public void d(ArrayList<Long> arrayList) {
        this.f266186b = arrayList;
    }

    public void e(long j3) {
        this.f266185a = j3;
    }

    public String toString() {
        return "GWGProGetCategoryChannelInfoListByFilterReq{mGuildId=" + this.f266185a + "mCategoryIdList=" + this.f266186b + "mCategoryTypeList=" + this.f266187c + "}";
    }
}
