package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    protected long f266335a;

    /* renamed from: b, reason: collision with root package name */
    protected long f266336b;

    /* renamed from: c, reason: collision with root package name */
    protected String f266337c = "";

    /* renamed from: d, reason: collision with root package name */
    protected byte[] f266338d = new byte[0];

    /* renamed from: e, reason: collision with root package name */
    protected ct f266339e = new ct();

    /* renamed from: f, reason: collision with root package name */
    protected cs f266340f = new cs();

    public cs a() {
        return this.f266340f;
    }

    public byte[] b() {
        return this.f266338d;
    }

    public long c() {
        return this.f266336b;
    }

    public String d() {
        return this.f266337c;
    }

    public ct e() {
        return this.f266339e;
    }

    public long f() {
        return this.f266335a;
    }

    public void g(cs csVar) {
        this.f266340f = csVar;
    }

    public void h(byte[] bArr) {
        this.f266338d = bArr;
    }

    public void i(long j3) {
        this.f266336b = j3;
    }

    public void j(String str) {
        this.f266337c = str;
    }

    public void k(ct ctVar) {
        this.f266339e = ctVar;
    }

    public void l(long j3) {
        this.f266335a = j3;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProGuildSearchNewSearchReq{mTinyid=");
        sb5.append(this.f266335a);
        sb5.append("mGuildId=");
        sb5.append(this.f266336b);
        sb5.append("mQuery=");
        sb5.append(this.f266337c);
        sb5.append("mCookie.length=");
        byte[] bArr = this.f266338d;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mSearchType=");
        sb5.append(this.f266339e);
        sb5.append("mCond=");
        sb5.append(this.f266340f);
        sb5.append("}");
        return sb5.toString();
    }
}
