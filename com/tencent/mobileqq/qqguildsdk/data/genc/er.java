package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class er {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<Long> f266552a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected String f266553b = "";

    /* renamed from: c, reason: collision with root package name */
    protected String f266554c = "";

    /* renamed from: d, reason: collision with root package name */
    protected int f266555d;

    public String a() {
        return this.f266553b;
    }

    public String b() {
        return this.f266554c;
    }

    public int c() {
        return this.f266555d;
    }

    public ArrayList<Long> d() {
        return this.f266552a;
    }

    public void e(ArrayList<Long> arrayList) {
        this.f266552a = arrayList;
    }

    public String toString() {
        return "GWGProSuperAdminBanUserReq{mTinyIds=" + this.f266552a + "mReason=" + this.f266553b + "mSource=" + this.f266554c + "mSourceId=" + this.f266555d + "}";
    }
}
