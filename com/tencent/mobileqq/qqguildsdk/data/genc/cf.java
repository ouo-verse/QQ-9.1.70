package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    protected long f266248a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Long> f266249b = new ArrayList<>();

    public ArrayList<Long> a() {
        return this.f266249b;
    }

    public long b() {
        return this.f266248a;
    }

    public void c(ArrayList<Long> arrayList) {
        this.f266249b = arrayList;
    }

    public void d(long j3) {
        this.f266248a = j3;
    }

    public String toString() {
        return "GWGProGuildBrowseInfo{mGuildId=" + this.f266248a + "mChannelIds=" + this.f266249b + "}";
    }
}
