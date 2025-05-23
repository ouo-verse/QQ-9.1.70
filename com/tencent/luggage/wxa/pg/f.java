package com.tencent.luggage.wxa.pg;

import com.tencent.luggage.wxa.cp.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements Comparable {

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f137552i = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v1\\.dat)$");

    /* renamed from: a, reason: collision with root package name */
    public final String f137553a;

    /* renamed from: b, reason: collision with root package name */
    public final long f137554b;

    /* renamed from: c, reason: collision with root package name */
    public final long f137555c;

    /* renamed from: d, reason: collision with root package name */
    public final long f137556d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.rg.b f137557e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f137558f;

    /* renamed from: g, reason: collision with root package name */
    public final v f137559g;

    /* renamed from: h, reason: collision with root package name */
    public final long f137560h;

    public f(String str, long j3, long j16, long j17, com.tencent.luggage.wxa.rg.b bVar, boolean z16, long j18, v vVar) {
        this.f137553a = str;
        this.f137554b = j3;
        this.f137555c = j16;
        this.f137556d = j17;
        this.f137557e = bVar;
        this.f137558f = z16;
        this.f137559g = vVar;
        this.f137560h = j18;
    }

    public static v a(v vVar, String str, long j3, long j16, com.tencent.luggage.wxa.rg.b bVar, long j17) {
        return new v(vVar, str + "." + j3 + "." + j16 + "." + bVar.a() + "." + j17 + ".v1.dat");
    }

    public static f b(String str, long j3) {
        return new f(str, j3, -1L, -1L, com.tencent.luggage.wxa.rg.b.f139662c, false, -1L, null);
    }

    public static f a(String str, long j3) {
        return new f(str, j3, -1L, -1L, com.tencent.luggage.wxa.rg.b.f139662c, false, -1L, null);
    }

    public static f a(String str, long j3, long j16) {
        return new f(str, j3, j16, -1L, com.tencent.luggage.wxa.rg.b.f139662c, false, -1L, null);
    }

    public static f a(v vVar) {
        Matcher matcher = f137552i.matcher(vVar.i());
        if (matcher.matches()) {
            return a(matcher.group(1), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)), com.tencent.luggage.wxa.rg.b.a(matcher.group(4)), Long.parseLong(matcher.group(5)), vVar);
        }
        return null;
    }

    public static f a(String str, long j3, long j16, com.tencent.luggage.wxa.rg.b bVar, long j17, v vVar) {
        return new f(str, j3, vVar.s(), j16, bVar, true, j17, vVar);
    }

    public boolean a() {
        return this.f137555c == -1;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        if (!this.f137553a.equals(fVar.f137553a)) {
            return this.f137553a.compareTo(fVar.f137553a);
        }
        long j3 = this.f137554b - fVar.f137554b;
        if (j3 == 0) {
            return 0;
        }
        return j3 < 0 ? -1 : 1;
    }
}
