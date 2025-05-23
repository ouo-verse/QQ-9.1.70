package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    protected long f266119a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266120b;

    /* renamed from: d, reason: collision with root package name */
    protected int f266122d;

    /* renamed from: e, reason: collision with root package name */
    protected int f266123e;

    /* renamed from: c, reason: collision with root package name */
    protected ec f266121c = new ec();

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<Long> f266124f = new ArrayList<>();

    public int a() {
        return this.f266123e;
    }

    public ArrayList<Long> b() {
        return this.f266124f;
    }

    public int c() {
        return this.f266122d;
    }

    public long d() {
        return this.f266120b;
    }

    public long e() {
        return this.f266119a;
    }

    public ec f() {
        return this.f266121c;
    }

    public void g(int i3) {
        this.f266123e = i3;
    }

    public void h(int i3) {
        this.f266122d = i3;
    }

    public void i(long j3) {
        this.f266120b = j3;
    }

    public void j(long j3) {
        this.f266119a = j3;
    }

    public void k(ec ecVar) {
        this.f266121c = ecVar;
    }

    public String toString() {
        return "GWGProCreateScheduleReq{mGuildId=" + this.f266119a + "mChannelId=" + this.f266120b + "mScheduleInfo=" + this.f266121c + "mChanelType=" + this.f266122d + "mAtMemberType=" + this.f266123e + "mAtRoleIds=" + this.f266124f + "}";
    }
}
