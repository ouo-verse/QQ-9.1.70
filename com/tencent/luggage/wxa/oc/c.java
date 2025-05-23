package com.tencent.luggage.wxa.oc;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: b, reason: collision with root package name */
    public String f136325b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f136326c = "";

    /* renamed from: d, reason: collision with root package name */
    public long f136327d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f136328e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f136329f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f136330g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f136331h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f136332i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f136333j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f136334k = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f136335l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f136336m = "";

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 16636;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public boolean b() {
        return true;
    }

    public c c(long j3) {
        this.f136328e = j3;
        return this;
    }

    public c d(long j3) {
        this.f136330g = j3;
        return this;
    }

    public c e(String str) {
        this.f136325b = a("Username", str, true);
        return this;
    }

    public c f(long j3) {
        this.f136334k = j3;
        return this;
    }

    public c g(long j3) {
        this.f136333j = j3;
        return this;
    }

    public c h(long j3) {
        this.f136331h = j3;
        return this;
    }

    public c a(long j3) {
        this.f136327d = j3;
        return this;
    }

    public c b(String str) {
        this.f136326c = a("Appid", str, true);
        return this;
    }

    public c c(String str) {
        this.f136335l = a("PackageKey", str, true);
        return this;
    }

    public c d(String str) {
        this.f136336m = a("PrefetchId", str, true);
        return this;
    }

    public String f(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f136325b);
        stringBuffer.append(str);
        stringBuffer.append(this.f136326c);
        stringBuffer.append(str);
        stringBuffer.append(this.f136327d);
        stringBuffer.append(str);
        stringBuffer.append(this.f136328e);
        stringBuffer.append(str);
        stringBuffer.append(this.f136329f);
        stringBuffer.append(str);
        stringBuffer.append(this.f136330g);
        stringBuffer.append(str);
        stringBuffer.append(this.f136331h);
        stringBuffer.append(str);
        stringBuffer.append(this.f136332i);
        stringBuffer.append(str);
        stringBuffer.append(this.f136333j);
        stringBuffer.append(str);
        stringBuffer.append(this.f136334k);
        stringBuffer.append(str);
        stringBuffer.append(this.f136335l);
        stringBuffer.append(str);
        stringBuffer.append(this.f136336m);
        String stringBuffer2 = stringBuffer.toString();
        a(stringBuffer2);
        return stringBuffer2;
    }

    public c e(long j3) {
        this.f136329f = j3;
        return this;
    }

    public c b(long j3) {
        this.f136332i = j3;
        return this;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        return f(",");
    }
}
