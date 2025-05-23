package com.tencent.mapsdk.internal;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class cv implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final int f148076a = 29;

    /* renamed from: b, reason: collision with root package name */
    public static final int f148077b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f148078c = 8;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f148080e = true;

    /* renamed from: g, reason: collision with root package name */
    private int f148082g;

    /* renamed from: h, reason: collision with root package name */
    private String f148083h;

    /* renamed from: f, reason: collision with root package name */
    private static cv[] f148081f = new cv[28];

    /* renamed from: d, reason: collision with root package name */
    public static final cv f148079d = new cv("REQ_CONFIG");

    cv(String str) {
        new String();
        this.f148083h = str;
        this.f148082g = 29;
        f148081f[26] = this;
    }

    private static cv a(int i3) {
        int i16 = 0;
        while (true) {
            cv[] cvVarArr = f148081f;
            if (i16 < cvVarArr.length) {
                cv cvVar = cvVarArr[i16];
                if (cvVar.f148082g == i3) {
                    return cvVar;
                }
                i16++;
            } else {
                if (f148080e) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    public final String toString() {
        return this.f148083h;
    }

    private static cv a(String str) {
        int i3 = 0;
        while (true) {
            cv[] cvVarArr = f148081f;
            if (i3 < cvVarArr.length) {
                if (cvVarArr[i3].toString().equals(str)) {
                    return f148081f[i3];
                }
                i3++;
            } else {
                if (f148080e) {
                    return null;
                }
                throw new AssertionError();
            }
        }
    }

    private int a() {
        return this.f148082g;
    }
}
