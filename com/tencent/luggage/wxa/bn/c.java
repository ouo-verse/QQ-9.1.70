package com.tencent.luggage.wxa.bn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public byte f123080a = 1;

    /* renamed from: b, reason: collision with root package name */
    public String f123081b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f123082c = null;

    public void a(byte b16) {
        this.f123080a = b16;
    }

    public String b() {
        return this.f123082c;
    }

    public byte c() {
        return this.f123080a;
    }

    public String toString() {
        return "SoterMpReqModel{reqAuthenMode=" + ((int) this.f123080a) + ", challenge='" + this.f123081b + "', content='" + this.f123082c + "'}";
    }

    public String a() {
        return this.f123081b;
    }

    public void b(String str) {
        this.f123082c = str;
    }

    public void a(String str) {
        this.f123081b = str;
    }
}
