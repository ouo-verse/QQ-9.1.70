package com.tencent.mapsdk.internal;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class cw implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final int f148084b = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f148086d = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f148088f = 2;

    /* renamed from: h, reason: collision with root package name */
    public static final int f148090h = 3;

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f148092j = true;

    /* renamed from: a, reason: collision with root package name */
    public int f148094a;

    /* renamed from: l, reason: collision with root package name */
    private String f148095l;

    /* renamed from: k, reason: collision with root package name */
    private static cw[] f148093k = new cw[4];

    /* renamed from: c, reason: collision with root package name */
    public static final cw f148085c = new cw(0, 0, "DT_NORMAL");

    /* renamed from: e, reason: collision with root package name */
    public static final cw f148087e = new cw(1, 1, "DT_ONLY_LINK");

    /* renamed from: g, reason: collision with root package name */
    public static final cw f148089g = new cw(2, 2, "DT_ONLY_STATUS");

    /* renamed from: i, reason: collision with root package name */
    public static final cw f148091i = new cw(3, 3, "DT_LINK_AND_STATUS");

    cw(int i3, int i16, String str) {
        new String();
        this.f148095l = str;
        this.f148094a = i16;
        f148093k[i3] = this;
    }

    private static cw a(int i3) {
        int i16 = 0;
        while (true) {
            cw[] cwVarArr = f148093k;
            if (i16 < cwVarArr.length) {
                cw cwVar = cwVarArr[i16];
                if (cwVar.f148094a == i3) {
                    return cwVar;
                }
                i16++;
            } else {
                if (f148092j) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public final String toString() {
        return this.f148095l;
    }

    private static cw a(String str) {
        int i3 = 0;
        while (true) {
            cw[] cwVarArr = f148093k;
            if (i3 < cwVarArr.length) {
                if (cwVarArr[i3].toString().equals(str)) {
                    return f148093k[i3];
                }
                i3++;
            } else {
                if (f148092j) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    private int a() {
        return this.f148094a;
    }
}
