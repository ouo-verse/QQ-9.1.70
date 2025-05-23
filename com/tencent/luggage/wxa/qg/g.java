package com.tencent.luggage.wxa.qg;

import android.net.Uri;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f138703a;

    /* renamed from: b, reason: collision with root package name */
    public final long f138704b;

    /* renamed from: c, reason: collision with root package name */
    public final long f138705c;

    /* renamed from: d, reason: collision with root package name */
    public final long f138706d;

    /* renamed from: e, reason: collision with root package name */
    public final String f138707e;

    /* renamed from: f, reason: collision with root package name */
    public final int f138708f;

    /* renamed from: g, reason: collision with root package name */
    public final String f138709g;

    /* renamed from: h, reason: collision with root package name */
    public final int f138710h;

    public g(Uri uri, long j3, long j16, long j17, String str, int i3, String str2) {
        this(uri, j3, j3, j17, str, i3, str2, -1);
    }

    public String toString() {
        return "DataSpec[uri=" + this.f138703a + ", absPos=" + this.f138704b + ", pos=" + this.f138705c + ", len=" + this.f138706d + ", key=" + this.f138707e + ", flags=" + this.f138708f + ", uuid=" + this.f138709g + "]";
    }

    public g(Uri uri, long j3, long j16, long j17, String str, int i3, String str2, int i16) {
        boolean z16 = true;
        try {
            com.tencent.luggage.wxa.tg.a.a(j3 >= 0);
            com.tencent.luggage.wxa.tg.a.a(j16 >= 0);
            if (j17 <= 0 && j17 != -1) {
                z16 = false;
            }
            com.tencent.luggage.wxa.tg.a.a(z16);
            this.f138703a = uri;
            this.f138704b = j3;
            this.f138705c = j16;
            this.f138706d = j17;
            this.f138707e = str;
            this.f138708f = i3;
            this.f138709g = str2;
            this.f138710h = i16;
        } catch (IllegalArgumentException e16) {
            throw new m(e16);
        }
    }
}
