package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ag {

    /* renamed from: a, reason: collision with root package name */
    protected long f266125a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266126b;

    /* renamed from: c, reason: collision with root package name */
    protected int f266127c;

    /* renamed from: d, reason: collision with root package name */
    protected ec f266128d = new ec();

    /* renamed from: e, reason: collision with root package name */
    protected int f266129e;

    public int a() {
        return this.f266127c;
    }

    public long b() {
        return this.f266126b;
    }

    public int c() {
        return this.f266129e;
    }

    public long d() {
        return this.f266125a;
    }

    public ec e() {
        return this.f266128d;
    }

    public void f(int i3) {
        this.f266127c = i3;
    }

    public void g(long j3) {
        this.f266126b = j3;
    }

    public void h(int i3) {
        this.f266129e = i3;
    }

    public void i(long j3) {
        this.f266125a = j3;
    }

    public void j(ec ecVar) {
        this.f266128d = ecVar;
    }

    public String toString() {
        return "GWGProEditScheduleReq{mGuildId=" + this.f266125a + "mChannelId=" + this.f266126b + "mChanelType=" + this.f266127c + "mScheduleInfo=" + this.f266128d + "mEditType=" + this.f266129e + "}";
    }
}
