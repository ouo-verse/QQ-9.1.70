package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    protected long f266165a;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<Long> f266166b = new ArrayList<>();

    public ArrayList<Long> a() {
        return this.f266166b;
    }

    public long b() {
        return this.f266165a;
    }

    public void c(long j3) {
        this.f266165a = j3;
    }

    public String toString() {
        return "GWGProFetchGuildActiveLiveChannelNumReq{mGuildId=" + this.f266165a + "mChannelId=" + this.f266166b + "}";
    }
}
