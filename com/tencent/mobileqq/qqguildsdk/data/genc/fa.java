package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class fa {

    /* renamed from: a, reason: collision with root package name */
    protected long f266581a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266582b;

    /* renamed from: c, reason: collision with root package name */
    protected String f266583c = "";

    /* renamed from: d, reason: collision with root package name */
    protected int f266584d;

    public String a() {
        return this.f266583c;
    }

    public int b() {
        return this.f266584d;
    }

    public long c() {
        return this.f266582b;
    }

    public long d() {
        return this.f266581a;
    }

    public void e(String str) {
        this.f266583c = str;
    }

    public void f(int i3) {
        this.f266584d = i3;
    }

    public void g(long j3) {
        this.f266582b = j3;
    }

    public void h(long j3) {
        this.f266581a = j3;
    }

    public String toString() {
        return "GWGProUpdateChannelThemeReq{mUint64GuildId=" + this.f266581a + "mUint64ChannelId=" + this.f266582b + "mAuthMeta=" + this.f266583c + "mThemeType=" + this.f266584d + "}";
    }
}
