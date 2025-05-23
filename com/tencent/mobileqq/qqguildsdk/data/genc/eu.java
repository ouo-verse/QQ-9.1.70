package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class eu {

    /* renamed from: b, reason: collision with root package name */
    protected int f266560b;

    /* renamed from: c, reason: collision with root package name */
    protected int f266561c;

    /* renamed from: d, reason: collision with root package name */
    protected int f266562d;

    /* renamed from: a, reason: collision with root package name */
    protected dh f266559a = new dh();

    /* renamed from: e, reason: collision with root package name */
    protected byte[] f266563e = new byte[0];

    /* renamed from: f, reason: collision with root package name */
    protected byte[] f266564f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    protected String f266565g = "";

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f266566h = new byte[0];

    public byte[] a() {
        return this.f266566h;
    }

    public byte[] b() {
        return this.f266564f;
    }

    public byte[] c() {
        return this.f266563e;
    }

    public int d() {
        return this.f266560b;
    }

    public int e() {
        return this.f266561c;
    }

    public String f() {
        return this.f266565g;
    }

    public dh g() {
        return this.f266559a;
    }

    public int h() {
        return this.f266562d;
    }

    public void i(byte[] bArr) {
        this.f266566h = bArr;
    }

    public void j(byte[] bArr) {
        this.f266564f = bArr;
    }

    public void k(byte[] bArr) {
        this.f266563e = bArr;
    }

    public void l(int i3) {
        this.f266560b = i3;
    }

    public void m(int i3) {
        this.f266561c = i3;
    }

    public void n(String str) {
        this.f266565g = str;
    }

    public void o(int i3) {
        this.f266562d = i3;
    }

    public String toString() {
        Object valueOf;
        Object valueOf2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProTabContentCommonReq{mSource=");
        sb5.append(this.f266559a);
        sb5.append("mDirection=");
        sb5.append(this.f266560b);
        sb5.append("mRefreshNum=");
        sb5.append(this.f266561c);
        sb5.append("mTabId=");
        sb5.append(this.f266562d);
        sb5.append("mCookies.length=");
        byte[] bArr = this.f266563e;
        Object obj = "null";
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mBackendCookies.length=");
        byte[] bArr2 = this.f266564f;
        if (bArr2 == null) {
            valueOf2 = "null";
        } else {
            valueOf2 = Integer.valueOf(bArr2.length);
        }
        sb5.append(valueOf2);
        sb5.append("mSessionId=");
        sb5.append(this.f266565g);
        sb5.append("mAdCookies.length=");
        byte[] bArr3 = this.f266566h;
        if (bArr3 != null) {
            obj = Integer.valueOf(bArr3.length);
        }
        sb5.append(obj);
        sb5.append("}");
        return sb5.toString();
    }
}
