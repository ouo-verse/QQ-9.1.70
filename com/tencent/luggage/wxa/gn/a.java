package com.tencent.luggage.wxa.gn;

import android.os.Build;
import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.tn.e;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f126797a;

    /* renamed from: b, reason: collision with root package name */
    public static String f126798b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f126799c;

    /* renamed from: d, reason: collision with root package name */
    public static String f126800d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f126801e;

    /* renamed from: f, reason: collision with root package name */
    public static int f126802f;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("android-");
        int i3 = Build.VERSION.SDK_INT;
        sb5.append(i3);
        f126797a = sb5.toString();
        f126798b = "android-" + i3;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("android-");
        String str = Build.MANUFACTURER;
        sb6.append(str);
        f126799c = sb6.toString();
        f126800d = "" + i3;
        f126801e = str + "-" + l.g();
        f126802f = e.f141563e;
    }

    public static String a() {
        return l.c();
    }

    public static String b() {
        return l.g();
    }
}
