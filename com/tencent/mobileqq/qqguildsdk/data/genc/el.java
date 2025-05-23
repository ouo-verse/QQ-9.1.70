package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class el {

    /* renamed from: a, reason: collision with root package name */
    protected long f266522a;

    /* renamed from: b, reason: collision with root package name */
    protected GWGProJoinGuildSetting f266523b = new GWGProJoinGuildSetting();

    public long a() {
        return this.f266522a;
    }

    public GWGProJoinGuildSetting b() {
        return this.f266523b;
    }

    public void c(long j3) {
        this.f266522a = j3;
    }

    public void d(GWGProJoinGuildSetting gWGProJoinGuildSetting) {
        this.f266523b = gWGProJoinGuildSetting;
    }

    public String toString() {
        return "GWGProSetJoinGuildOptionReq{mGuildId=" + this.f266522a + "mSettingInfo=" + this.f266523b + "}";
    }
}
