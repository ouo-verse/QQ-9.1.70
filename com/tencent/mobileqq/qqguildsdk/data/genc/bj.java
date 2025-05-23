package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bj {

    /* renamed from: c, reason: collision with root package name */
    protected int f266204c;

    /* renamed from: d, reason: collision with root package name */
    protected int f266205d;

    /* renamed from: a, reason: collision with root package name */
    protected dh f266202a = new dh();

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f266203b = new byte[0];

    /* renamed from: e, reason: collision with root package name */
    protected String f266206e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f266207f = "";

    /* renamed from: g, reason: collision with root package name */
    protected String f266208g = "";

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f266209h = new byte[0];

    public byte[] a() {
        return this.f266209h;
    }

    public String b() {
        return this.f266207f;
    }

    public byte[] c() {
        return this.f266203b;
    }

    public int d() {
        return this.f266204c;
    }

    public String e() {
        return this.f266208g;
    }

    public int f() {
        return this.f266205d;
    }

    public String g() {
        return this.f266206e;
    }

    public dh h() {
        return this.f266202a;
    }

    public void i(byte[] bArr) {
        this.f266209h = bArr;
    }

    public void j(String str) {
        this.f266207f = str;
    }

    public void k(byte[] bArr) {
        this.f266203b = bArr;
    }

    public void l(int i3) {
        this.f266204c = i3;
    }

    public void m(int i3) {
        this.f266205d = i3;
    }

    public void n(String str) {
        this.f266206e = str;
    }

    public void o(dh dhVar) {
        this.f266202a = dhVar;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProGetContentRecommendReq{mSource=");
        sb5.append(this.f266202a);
        sb5.append("mCookies.length=");
        byte[] bArr = this.f266203b;
        Object obj = "null";
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mDirection=");
        sb5.append(this.f266204c);
        sb5.append("mRefreshNum=");
        sb5.append(this.f266205d);
        sb5.append("mSessionId=");
        sb5.append(this.f266206e);
        sb5.append("mBusiInfo=");
        sb5.append(this.f266207f);
        sb5.append("mNavigationVersion=");
        sb5.append(this.f266208g);
        sb5.append("mAdCookies.length=");
        byte[] bArr2 = this.f266209h;
        if (bArr2 != null) {
            obj = Integer.valueOf(bArr2.length);
        }
        sb5.append(obj);
        sb5.append("}");
        return sb5.toString();
    }
}
