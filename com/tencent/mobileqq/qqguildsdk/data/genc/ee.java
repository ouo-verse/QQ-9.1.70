package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ee {

    /* renamed from: a, reason: collision with root package name */
    protected long f266495a;

    /* renamed from: c, reason: collision with root package name */
    protected int f266497c;

    /* renamed from: d, reason: collision with root package name */
    protected long f266498d;

    /* renamed from: g, reason: collision with root package name */
    protected int f266501g;

    /* renamed from: h, reason: collision with root package name */
    protected int f266502h;

    /* renamed from: i, reason: collision with root package name */
    protected int f266503i;

    /* renamed from: b, reason: collision with root package name */
    protected String f266496b = "";

    /* renamed from: e, reason: collision with root package name */
    protected String f266499e = "";

    /* renamed from: f, reason: collision with root package name */
    protected byte[] f266500f = new byte[0];

    public byte[] a() {
        return this.f266500f;
    }

    public long b() {
        return this.f266495a;
    }

    public String c() {
        return this.f266496b;
    }

    public int d() {
        return this.f266497c;
    }

    public long e() {
        return this.f266498d;
    }

    public int f() {
        return this.f266501g;
    }

    public int g() {
        return this.f266503i;
    }

    public String h() {
        return this.f266499e;
    }

    public int i() {
        return this.f266502h;
    }

    public void j(long j3) {
        this.f266495a = j3;
    }

    public void k(String str) {
        this.f266496b = str;
    }

    public void l(int i3) {
        this.f266497c = i3;
    }

    public void m(int i3) {
        this.f266501g = i3;
    }

    public void n(int i3) {
        this.f266503i = i3;
    }

    public void o(int i3) {
        this.f266502h = i3;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProSearchBlackUserReq{mGuildId=");
        sb5.append(this.f266495a);
        sb5.append("mKeyword=");
        sb5.append(this.f266496b);
        sb5.append("mNum=");
        sb5.append(this.f266497c);
        sb5.append("mPos=");
        sb5.append(this.f266498d);
        sb5.append("mTraceId=");
        sb5.append(this.f266499e);
        sb5.append("mBuf.length=");
        byte[] bArr = this.f266500f;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mScene=");
        sb5.append(this.f266501g);
        sb5.append("mUserType=");
        sb5.append(this.f266502h);
        sb5.append("mServiceType=");
        sb5.append(this.f266503i);
        sb5.append("}");
        return sb5.toString();
    }
}
