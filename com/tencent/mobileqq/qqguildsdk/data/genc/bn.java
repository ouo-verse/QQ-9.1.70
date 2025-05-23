package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    protected long f266211a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f266212b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f266213c;

    public boolean a() {
        return this.f266213c;
    }

    public long b() {
        return this.f266211a;
    }

    public boolean c() {
        return this.f266212b;
    }

    public void d(boolean z16) {
        this.f266213c = z16;
    }

    public void e(long j3) {
        this.f266211a = j3;
    }

    public void f(boolean z16) {
        this.f266212b = z16;
    }

    public String toString() {
        return "GWGProGetGuildHomeCategoriesReq{mGuildId=" + this.f266211a + "mNeedChannel=" + this.f266212b + "mFilterClosedCategories=" + this.f266213c + "}";
    }
}
