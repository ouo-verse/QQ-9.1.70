package com.tencent.luggage.wxa.kj;

import android.util.LongSparseArray;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final LongSparseArray f132213a = new LongSparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final LongSparseArray f132214b = new LongSparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final LongSparseArray f132215c = new LongSparseArray();

    public void a(long j3, k1 k1Var, k1 k1Var2) {
        this.f132213a.put(j3, k1Var);
        this.f132214b.put(j3, k1Var2);
        a(j3, "routePageOpenType", k1Var, false);
    }

    public void b(long j3) {
        this.f132215c.remove(j3);
        this.f132213a.remove(j3);
        this.f132214b.remove(j3);
    }

    public void c(long j3) {
        a(j3, "routeStartTime", Long.valueOf(com.tencent.luggage.wxa.tn.w0.c()), false);
    }

    public void d(long j3) {
        a(j3, "routeInitReadyTime", Long.valueOf(com.tencent.luggage.wxa.tn.w0.c()), false);
    }

    public k1 a(long j3, k1 k1Var, boolean z16) {
        k1 k1Var2;
        Objects.requireNonNull(k1Var);
        if (this.f132214b.get(j3, null) != k1Var || (k1Var2 = (k1) this.f132213a.get(j3, null)) == null) {
            return k1Var;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageContainer.AppRouteMetricsContext", "restore target(%s) -> source(%s), routeId:%d, isAppRouteDone:%b", k1Var, k1Var2, Long.valueOf(j3), Boolean.valueOf(z16));
        return k1Var2;
    }

    public void a(long j3, String str, Object obj, boolean z16) {
        Map map = (Map) this.f132215c.get(j3);
        if (map == null) {
            if (!z16) {
                return;
            }
            map = new HashMap();
            this.f132215c.put(j3, map);
        }
        if ("routeInitReadyTime".equals(str) && map.containsKey(str)) {
            return;
        }
        map.put(str, obj);
    }

    public Map a(long j3) {
        return (Map) this.f132215c.get(j3);
    }

    public long a(k1 k1Var) {
        long hash = Objects.hash(Integer.valueOf(k1Var.ordinal()), Long.valueOf(com.tencent.luggage.wxa.tn.w0.a()));
        a(hash, "routeStartTime", Long.valueOf(com.tencent.luggage.wxa.tn.w0.c()), true);
        a(hash, "routePageOpenType", k1Var, false);
        return hash;
    }

    public void a(long j3, Boolean bool) {
        a(j3, "overrideEntryPagePath", bool, false);
    }

    public void a() {
        this.f132213a.clear();
        this.f132214b.clear();
        this.f132215c.clear();
    }
}
