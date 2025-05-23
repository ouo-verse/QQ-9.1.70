package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    protected long f266650b;

    /* renamed from: a, reason: collision with root package name */
    protected k f266649a = new k();

    /* renamed from: c, reason: collision with root package name */
    protected fd f266651c = new fd();

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<an> f266652d = new ArrayList<>();

    public k a() {
        return this.f266649a;
    }

    public ArrayList<an> b() {
        return this.f266652d;
    }

    public long c() {
        return this.f266650b;
    }

    public fd d() {
        return this.f266651c;
    }

    public void e(ArrayList<an> arrayList) {
        this.f266652d = arrayList;
    }

    public void f(long j3) {
        this.f266650b = j3;
    }

    public String toString() {
        return "GWGProAVReportReqInfo{mCommonInfo=" + this.f266649a + "mTinyId=" + this.f266650b + "mUserDevState=" + this.f266651c + "mExtInfos=" + this.f266652d + "}";
    }
}
