package com.tencent.luggage.wxa.aa;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f121024a = w0.b(Build.MANUFACTURER, "").toLowerCase();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f121025b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f121026c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f121027d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f121028e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f121029f;

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f121030g;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f121031h;

    /* renamed from: i, reason: collision with root package name */
    public static Boolean f121032i;

    public static boolean a() {
        Boolean bool;
        if (f121030g == null) {
            if (f121024a.contains("eebbk")) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121030g = bool;
        }
        return f121030g.booleanValue();
    }

    public static boolean b() {
        Boolean bool;
        if (f121029f == null) {
            if (f121024a.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_LENOVO)) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121029f = bool;
        }
        return f121029f.booleanValue();
    }

    public static boolean c() {
        Boolean bool;
        if (f121031h == null) {
            if (f121024a.contains("oneplus")) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121031h = bool;
        }
        return f121031h.booleanValue();
    }

    public static boolean d() {
        Boolean bool;
        if (f121026c == null) {
            if (f121024a.contains("oppo")) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121026c = bool;
        }
        return f121026c.booleanValue();
    }

    public static boolean e() {
        Boolean bool;
        if (f121027d == null) {
            if (f121024a.contains("realme")) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121027d = bool;
        }
        return f121027d.booleanValue();
    }

    public static boolean f() {
        Boolean bool;
        if (f121025b == null) {
            if (f121024a.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121025b = bool;
        }
        return f121025b.booleanValue();
    }

    public static boolean g() {
        Boolean bool;
        if (f121032i == null) {
            if (f121024a.contains("tecno")) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121032i = bool;
        }
        return f121032i.booleanValue();
    }

    public static boolean h() {
        Boolean bool;
        if (f121028e == null) {
            if (f121024a.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            f121028e = bool;
        }
        return f121028e.booleanValue();
    }
}
