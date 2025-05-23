package com.tencent.luggage.wxa.qb;

import android.text.TextUtils;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {
    public ByteBuffer C;

    /* renamed from: y, reason: collision with root package name */
    public f f138588y;

    /* renamed from: a, reason: collision with root package name */
    public String f138564a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f138565b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f138566c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f138567d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f138568e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f138569f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f138570g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f138571h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f138572i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f138573j = 0;

    /* renamed from: k, reason: collision with root package name */
    public String f138574k = "";

    /* renamed from: l, reason: collision with root package name */
    public double f138575l = 1.0d;

    /* renamed from: m, reason: collision with root package name */
    public double f138576m = 1.0d;

    /* renamed from: n, reason: collision with root package name */
    public String f138577n = "";

    /* renamed from: o, reason: collision with root package name */
    public long f138578o = 0;

    /* renamed from: p, reason: collision with root package name */
    public long f138579p = 0;

    /* renamed from: q, reason: collision with root package name */
    public long f138580q = 0;

    /* renamed from: r, reason: collision with root package name */
    public long f138581r = 0;

    /* renamed from: s, reason: collision with root package name */
    public long f138582s = 0;

    /* renamed from: t, reason: collision with root package name */
    public long f138583t = 0;

    /* renamed from: u, reason: collision with root package name */
    public long f138584u = 0;

    /* renamed from: v, reason: collision with root package name */
    public String f138585v = null;

    /* renamed from: w, reason: collision with root package name */
    public String f138586w = null;

    /* renamed from: x, reason: collision with root package name */
    public long f138587x = 0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f138589z = true;
    public boolean A = false;
    public boolean B = false;

    public boolean a(b bVar) {
        String str;
        String str2;
        if (bVar == null || (str = this.f138564a) == null || !str.equalsIgnoreCase(bVar.f138564a) || (str2 = this.f138565b) == null || !str2.equalsIgnoreCase(bVar.f138565b)) {
            return false;
        }
        return true;
    }

    public void b(b bVar) {
        this.f138564a = bVar.f138564a;
        this.f138565b = bVar.f138565b;
        if (!TextUtils.isEmpty(bVar.f138566c)) {
            this.f138566c = bVar.f138566c;
        }
        this.f138567d = bVar.f138567d;
        this.f138568e = bVar.f138568e;
        this.f138570g = bVar.f138570g;
        this.f138571h = bVar.f138571h;
        this.f138572i = bVar.f138572i;
        this.f138574k = bVar.f138574k;
        this.f138575l = bVar.f138575l;
        this.f138577n = bVar.f138577n;
        f fVar = bVar.f138588y;
        if (fVar != null) {
            this.f138588y = fVar;
        }
        this.f138587x = bVar.f138587x;
        this.f138576m = bVar.f138576m;
    }
}
