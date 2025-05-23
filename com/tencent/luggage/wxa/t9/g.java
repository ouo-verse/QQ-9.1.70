package com.tencent.luggage.wxa.t9;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static String f141052a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f141053b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f141054c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f141055d;

    /* renamed from: e, reason: collision with root package name */
    public static String f141056e;

    /* renamed from: f, reason: collision with root package name */
    public static String f141057f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f141058g;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("android-");
        int i3 = Build.VERSION.SDK_INT;
        sb5.append(i3);
        f141052a = sb5.toString();
        f141053b = Build.BRAND;
        f141054c = l.g() + Build.CPU_ABI;
        StringBuilder sb6 = new StringBuilder();
        String str = Build.MANUFACTURER;
        sb6.append(str);
        sb6.append("-");
        sb6.append(l.g());
        f141055d = sb6.toString();
        f141056e = "android-" + i3;
        f141057f = "" + i3;
        f141058g = "android-" + str;
    }
}
