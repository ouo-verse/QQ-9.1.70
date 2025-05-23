package com.tencent.beacon.base.net;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public String f77777a;

    /* renamed from: b, reason: collision with root package name */
    public String f77778b;

    /* renamed from: c, reason: collision with root package name */
    public int f77779c;

    /* renamed from: d, reason: collision with root package name */
    public String f77780d;

    /* renamed from: e, reason: collision with root package name */
    public Throwable f77781e;

    public d(String str, String str2, int i3, String str3) {
        this.f77777a = str;
        this.f77778b = str2;
        this.f77779c = i3;
        this.f77780d = str3;
    }

    public String toString() {
        return "NetFailure{requestType='" + this.f77777a + "', attaCode='" + this.f77778b + "', responseCode=" + this.f77779c + ", msg='" + this.f77780d + "', exception=" + this.f77781e + '}';
    }

    public d(String str, String str2, int i3, String str3, Throwable th5) {
        this.f77777a = str;
        this.f77778b = str2;
        this.f77779c = i3;
        this.f77780d = str3;
        this.f77781e = th5;
    }
}
