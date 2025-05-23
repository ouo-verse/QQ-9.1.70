package com.tencent.luggage.wxa.oc;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: b, reason: collision with root package name */
    public String f136337b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f136338c = "";

    /* renamed from: d, reason: collision with root package name */
    public long f136339d;

    /* renamed from: e, reason: collision with root package name */
    public long f136340e;

    /* renamed from: f, reason: collision with root package name */
    public long f136341f;

    /* renamed from: g, reason: collision with root package name */
    public long f136342g;

    /* renamed from: h, reason: collision with root package name */
    public long f136343h;

    /* renamed from: i, reason: collision with root package name */
    public int f136344i;

    /* renamed from: j, reason: collision with root package name */
    public long f136345j;

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 18866;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public boolean b() {
        return true;
    }

    public d c(String str) {
        this.f136337b = a("UserName", str, true);
        return this;
    }

    public d d(long j3) {
        this.f136345j = j3;
        return this;
    }

    public d e(long j3) {
        this.f136341f = j3;
        return this;
    }

    public d f(long j3) {
        this.f136342g = j3;
        super.b("StartTimeStampMs", j3);
        return this;
    }

    public d a(long j3) {
        this.f136339d = j3;
        return this;
    }

    public d b(String str) {
        this.f136338c = a("AppId", str, true);
        return this;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        return d(",");
    }

    public d a(int i3) {
        this.f136344i = i3;
        return this;
    }

    public d c(long j3) {
        this.f136343h = j3;
        super.b("EndTimeStampMs", j3);
        return this;
    }

    public String d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f136337b);
        stringBuffer.append(str);
        stringBuffer.append(this.f136338c);
        stringBuffer.append(str);
        stringBuffer.append(this.f136339d);
        stringBuffer.append(str);
        stringBuffer.append(this.f136340e);
        stringBuffer.append(str);
        stringBuffer.append(this.f136341f);
        stringBuffer.append(str);
        stringBuffer.append(this.f136342g);
        stringBuffer.append(str);
        stringBuffer.append(this.f136343h);
        stringBuffer.append(str);
        stringBuffer.append(this.f136344i);
        stringBuffer.append(str);
        stringBuffer.append(this.f136345j);
        String stringBuffer2 = stringBuffer.toString();
        a(stringBuffer2);
        return stringBuffer2;
    }

    public d b(long j3) {
        this.f136340e = j3;
        super.a("CostTimeMs", j3);
        return this;
    }
}
