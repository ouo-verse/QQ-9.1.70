package com.tencent.mobileqq.qqguildsdk.data.genc;

/* compiled from: P */
/* loaded from: classes17.dex */
public class dw {

    /* renamed from: a, reason: collision with root package name */
    protected long f266451a;

    /* renamed from: b, reason: collision with root package name */
    protected String f266452b = "";

    /* renamed from: c, reason: collision with root package name */
    protected String f266453c = "";

    /* renamed from: d, reason: collision with root package name */
    protected byte[] f266454d = new byte[0];

    public byte[] a() {
        return this.f266454d;
    }

    public String b() {
        return this.f266452b;
    }

    public long c() {
        return this.f266451a;
    }

    public String d() {
        return this.f266453c;
    }

    public void e(String str) {
        this.f266452b = str;
    }

    public void f(long j3) {
        this.f266451a = j3;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProRiskMemberListReq{mGuildId=");
        sb5.append(this.f266451a);
        sb5.append("mCookie=");
        sb5.append(this.f266452b);
        sb5.append("mTraceId=");
        sb5.append(this.f266453c);
        sb5.append("mBuf.length=");
        byte[] bArr = this.f266454d;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("}");
        return sb5.toString();
    }
}
