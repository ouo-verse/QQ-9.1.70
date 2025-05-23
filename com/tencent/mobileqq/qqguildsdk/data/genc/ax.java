package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    protected long f266177a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266178b;

    /* renamed from: c, reason: collision with root package name */
    protected String f266179c = "";

    /* renamed from: d, reason: collision with root package name */
    protected int f266180d;

    public String a() {
        return this.f266179c;
    }

    public long b() {
        return this.f266177a;
    }

    public int c() {
        return this.f266180d;
    }

    public long d() {
        return this.f266178b;
    }

    public void e(String str) {
        this.f266179c = str;
    }

    public void f(long j3) {
        this.f266177a = j3;
    }

    public void g(int i3) {
        this.f266180d = i3;
    }

    public void h(long j3) {
        this.f266178b = j3;
    }

    public String toString() {
        return "GWGProFetchUserJoinedGuildListReq{mGuildId=" + this.f266177a + "mTinyId=" + this.f266178b + "mCookie=" + this.f266179c + "mPageSize=" + this.f266180d + "}";
    }
}
