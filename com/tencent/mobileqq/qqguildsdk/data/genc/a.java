package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<String> f266073a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<String> f266074b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f266075c;

    public ArrayList<String> a() {
        return this.f266073a;
    }

    public boolean b() {
        return this.f266075c;
    }

    public ArrayList<String> c() {
        return this.f266074b;
    }

    public void d(boolean z16) {
        this.f266075c = z16;
    }

    public String toString() {
        return "GWGProAISearchBatchDeleteSessionReq{mDeleteSessionIds=" + this.f266073a + "mReserveSessionIds=" + this.f266074b + "mIsAllSelect=" + this.f266075c + "}";
    }
}
