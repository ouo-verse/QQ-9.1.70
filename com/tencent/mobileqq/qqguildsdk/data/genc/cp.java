package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cp {

    /* renamed from: a, reason: collision with root package name */
    protected long f266331a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<String> f266332b = new ArrayList<>();

    public long a() {
        return this.f266331a;
    }

    public ArrayList<String> b() {
        return this.f266332b;
    }

    public void c(long j3) {
        this.f266331a = j3;
    }

    public void d(ArrayList<String> arrayList) {
        this.f266332b = arrayList;
    }

    public String toString() {
        return "GWGProGuildSearchGetFeedCalendarReq{mGuildId=" + this.f266331a + "mMonths=" + this.f266332b + "}";
    }
}
