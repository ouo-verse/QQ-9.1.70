package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    protected long f266167a;

    /* renamed from: b, reason: collision with root package name */
    protected String f266168b = "";

    /* renamed from: c, reason: collision with root package name */
    protected String f266169c = "";

    public String a() {
        return this.f266169c;
    }

    public long b() {
        return this.f266167a;
    }

    public String c() {
        return this.f266168b;
    }

    public void d(String str) {
        this.f266169c = str;
    }

    public void e(long j3) {
        this.f266167a = j3;
    }

    public void f(String str) {
        this.f266168b = str;
    }

    public String toString() {
        return "GWGProFetchJoinGuildOptionReq{mGuildId=" + this.f266167a + "mInviteCode=" + this.f266168b + "mContentId=" + this.f266169c + "}";
    }
}
