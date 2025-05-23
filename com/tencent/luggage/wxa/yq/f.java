package com.tencent.luggage.wxa.yq;

import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.u0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public i0 f146066a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f146067b;

    /* renamed from: c, reason: collision with root package name */
    public String f146068c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f146069d;

    /* renamed from: e, reason: collision with root package name */
    public int f146070e;

    /* renamed from: f, reason: collision with root package name */
    public String f146071f;

    /* renamed from: g, reason: collision with root package name */
    public String f146072g;

    /* renamed from: h, reason: collision with root package name */
    public int f146073h;

    /* renamed from: i, reason: collision with root package name */
    public String f146074i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f146075j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f146076k;

    /* renamed from: l, reason: collision with root package name */
    public String f146077l;

    /* renamed from: m, reason: collision with root package name */
    public int f146078m;

    public f(String str, boolean z16, int i3, String str2, int i16, int i17) {
        this.f146067b = false;
        this.f146069d = z16;
        this.f146072g = str;
        this.f146073h = i3;
        this.f146077l = str2;
        this.f146070e = i16;
        this.f146078m = i17;
        if (!a()) {
            throw new RuntimeException("invalid update config");
        }
    }

    public boolean a() {
        String str;
        String str2;
        String str3;
        if ((this.f146067b && ((str3 = this.f146068c) == null || str3.isEmpty())) || (str = this.f146072g) == null || str.isEmpty() || this.f146073h == -1) {
            return false;
        }
        if (this.f146067b && this.f146069d && ((str2 = this.f146071f) == null || str2.isEmpty())) {
            return false;
        }
        return true;
    }

    public String b() {
        if (a()) {
            if (this.f146069d) {
                int i3 = this.f146078m;
                if (i3 != 1 && i3 != 2) {
                    throw new RuntimeException("invalid patchType in updateConfig");
                }
                return u0.a(this.f146073h, i3);
            }
            return u0.i(this.f146073h);
        }
        throw new RuntimeException("invalid update config");
    }

    public String c() {
        if (a()) {
            return "{UpdateConfig isMatchMd5:" + this.f146067b + ",downloadFileMd5:" + this.f146068c + ",isPatchUpdate:" + this.f146069d + ",downUrl:" + this.f146072g + ",apkVer:" + this.f146073h + ",useCDN:" + this.f146075j + ",downloadPath:" + b() + "}";
        }
        return "invalid update config";
    }

    public int d() {
        if (this.f146069d) {
            return 2;
        }
        return 1;
    }

    public f(String str, boolean z16, String str2, String str3, int i3, String str4, int i16, int i17) {
        this.f146067b = true;
        this.f146068c = str;
        this.f146069d = z16;
        this.f146071f = str2;
        this.f146072g = str3;
        this.f146073h = i3;
        this.f146077l = str4;
        this.f146070e = i16;
        this.f146078m = i17;
        if (!a()) {
            throw new RuntimeException("invalid update config");
        }
    }

    public f(String str, boolean z16, int i3, String str2, int i16) {
        this.f146078m = 1;
        this.f146067b = false;
        this.f146069d = z16;
        this.f146072g = str;
        this.f146073h = i3;
        this.f146077l = str2;
        this.f146070e = i16;
        if (!a()) {
            throw new RuntimeException("invalid update config");
        }
    }
}
