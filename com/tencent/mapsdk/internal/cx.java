package com.tencent.mapsdk.internal;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class cx implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final int f148096a = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f148098c = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f148100e = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f148102g = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final int f148104i = 4;

    /* renamed from: k, reason: collision with root package name */
    public static final int f148106k = 5;

    /* renamed from: m, reason: collision with root package name */
    public static final int f148108m = 6;

    /* renamed from: o, reason: collision with root package name */
    public static final int f148110o = 7;

    /* renamed from: q, reason: collision with root package name */
    static final /* synthetic */ boolean f148112q = true;

    /* renamed from: s, reason: collision with root package name */
    private int f148114s;

    /* renamed from: t, reason: collision with root package name */
    private String f148115t;

    /* renamed from: r, reason: collision with root package name */
    private static cx[] f148113r = new cx[8];

    /* renamed from: b, reason: collision with root package name */
    public static final cx f148097b = new cx(0, 0, "RST_SUCC");

    /* renamed from: d, reason: collision with root package name */
    public static final cx f148099d = new cx(1, 1, "RST_DECODE_FAIL");

    /* renamed from: f, reason: collision with root package name */
    public static final cx f148101f = new cx(2, 2, "RST_SYS_ERR");

    /* renamed from: h, reason: collision with root package name */
    public static final cx f148103h = new cx(3, 3, "RST_INVALID_USER");

    /* renamed from: j, reason: collision with root package name */
    public static final cx f148105j = new cx(4, 4, "RST_USE_INVALID_KEY");

    /* renamed from: l, reason: collision with root package name */
    public static final cx f148107l = new cx(5, 5, "RST_INVALID_UIN");

    /* renamed from: n, reason: collision with root package name */
    public static final cx f148109n = new cx(6, 6, "RST_INVALID_CMD");

    /* renamed from: p, reason: collision with root package name */
    public static final cx f148111p = new cx(7, 7, "RST_PACKAGE_ERR");

    cx(int i3, int i16, String str) {
        new String();
        this.f148115t = str;
        this.f148114s = i16;
        f148113r[i3] = this;
    }

    private static cx a(int i3) {
        int i16 = 0;
        while (true) {
            cx[] cxVarArr = f148113r;
            if (i16 < cxVarArr.length) {
                cx cxVar = cxVarArr[i16];
                if (cxVar.f148114s == i3) {
                    return cxVar;
                }
                i16++;
            } else {
                if (f148112q) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public final String toString() {
        return this.f148115t;
    }

    private static cx a(String str) {
        int i3 = 0;
        while (true) {
            cx[] cxVarArr = f148113r;
            if (i3 < cxVarArr.length) {
                if (cxVarArr[i3].toString().equals(str)) {
                    return f148113r[i3];
                }
                i3++;
            } else {
                if (f148112q) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    private int a() {
        return this.f148114s;
    }
}
