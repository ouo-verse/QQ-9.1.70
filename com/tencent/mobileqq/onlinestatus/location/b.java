package com.tencent.mobileqq.onlinestatus.location;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public double f255916a;

    /* renamed from: b, reason: collision with root package name */
    public double f255917b;

    /* renamed from: c, reason: collision with root package name */
    public double f255918c;

    /* renamed from: d, reason: collision with root package name */
    public String f255919d;

    /* renamed from: e, reason: collision with root package name */
    public String f255920e;

    /* renamed from: f, reason: collision with root package name */
    public long f255921f;

    /* renamed from: g, reason: collision with root package name */
    public String f255922g;

    /* renamed from: h, reason: collision with root package name */
    public int f255923h;

    public b(double d16, double d17, String str, String str2) {
        this.f255916a = d16;
        this.f255917b = d17;
        this.f255919d = str;
        this.f255922g = str2;
        if (b(d16, d17, str2)) {
            this.f255923h = 0;
        } else {
            this.f255923h = 1;
        }
    }

    public static boolean a(b bVar, double d16, double d17, String str) {
        if (bVar == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        if (!str.equals(bVar.f255922g)) {
            return true;
        }
        if (Math.abs(d16) < 1.0E-4d || Math.abs(d17) < 1.0E-4d) {
            return false;
        }
        if (Math.abs(bVar.f255916a - d16) > 0.001d || Math.abs(bVar.f255917b - d17) > 0.001d) {
            return true;
        }
        return false;
    }

    public static boolean b(double d16, double d17, String str) {
        if (Math.abs(d16) > 1.0E-4d && Math.abs(d17) > 1.0E-4d && !TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("mLatitude:");
        sb5.append(this.f255916a);
        sb5.append(" mLongitude:");
        sb5.append(this.f255917b);
        sb5.append(" mDirection:");
        sb5.append(this.f255918c);
        sb5.append(" mPoiName:");
        sb5.append(this.f255919d);
        sb5.append(" mPoiAddr:");
        sb5.append(this.f255920e);
        sb5.append(" adCode:");
        sb5.append(this.f255922g);
        sb5.append(" mUpdateTime:");
        sb5.append(this.f255921f);
        sb5.append(" mValidFlag:");
        sb5.append(this.f255923h);
        return sb5.toString();
    }
}
