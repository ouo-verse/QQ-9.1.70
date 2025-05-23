package com.tencent.luggage.wxa.m;

import com.tencent.luggage.wxa.n0.v;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f133805a;

    /* renamed from: b, reason: collision with root package name */
    public static final UUID f133806b;

    /* renamed from: c, reason: collision with root package name */
    public static final UUID f133807c;

    /* renamed from: d, reason: collision with root package name */
    public static final UUID f133808d;

    /* renamed from: e, reason: collision with root package name */
    public static final UUID f133809e;

    static {
        int i3;
        if (v.f135103a < 23) {
            i3 = 1020;
        } else {
            i3 = 6396;
        }
        f133805a = i3;
        f133806b = new UUID(0L, 0L);
        f133807c = new UUID(1186680826959645954L, -5988876978535335093L);
        f133808d = new UUID(-1301668207276963122L, -6645017420763422227L);
        f133809e = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j3) {
        if (j3 != -9223372036854775807L && j3 != Long.MIN_VALUE) {
            return j3 * 1000;
        }
        return j3;
    }

    public static long b(long j3) {
        if (j3 != -9223372036854775807L && j3 != Long.MIN_VALUE) {
            return j3 / 1000;
        }
        return j3;
    }
}
