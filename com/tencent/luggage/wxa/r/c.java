package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.q.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends d {

    /* renamed from: b, reason: collision with root package name */
    public long f139041b;

    public c(l lVar) {
        super(lVar);
        this.f139041b = -9223372036854775807L;
    }

    public static Date c(com.tencent.luggage.wxa.n0.l lVar) {
        Date date = new Date((long) d(lVar).doubleValue());
        lVar.f(2);
        return date;
    }

    public static Double d(com.tencent.luggage.wxa.n0.l lVar) {
        return Double.valueOf(Double.longBitsToDouble(lVar.m()));
    }

    public static HashMap e(com.tencent.luggage.wxa.n0.l lVar) {
        int u16 = lVar.u();
        HashMap hashMap = new HashMap(u16);
        for (int i3 = 0; i3 < u16; i3++) {
            hashMap.put(h(lVar), a(lVar, i(lVar)));
        }
        return hashMap;
    }

    public static HashMap f(com.tencent.luggage.wxa.n0.l lVar) {
        HashMap hashMap = new HashMap();
        while (true) {
            String h16 = h(lVar);
            int i3 = i(lVar);
            if (i3 == 9) {
                return hashMap;
            }
            hashMap.put(h16, a(lVar, i3));
        }
    }

    public static ArrayList g(com.tencent.luggage.wxa.n0.l lVar) {
        int u16 = lVar.u();
        ArrayList arrayList = new ArrayList(u16);
        for (int i3 = 0; i3 < u16; i3++) {
            arrayList.add(a(lVar, i(lVar)));
        }
        return arrayList;
    }

    public static String h(com.tencent.luggage.wxa.n0.l lVar) {
        int w3 = lVar.w();
        int c16 = lVar.c();
        lVar.f(w3);
        return new String(lVar.f135088a, c16, w3);
    }

    public static int i(com.tencent.luggage.wxa.n0.l lVar) {
        return lVar.q();
    }

    @Override // com.tencent.luggage.wxa.r.d
    public boolean a(com.tencent.luggage.wxa.n0.l lVar) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.r.d
    public void b(com.tencent.luggage.wxa.n0.l lVar, long j3) {
        if (i(lVar) == 2) {
            if ("onMetaData".equals(h(lVar)) && i(lVar) == 8) {
                HashMap e16 = e(lVar);
                if (e16.containsKey("duration")) {
                    double doubleValue = ((Double) e16.get("duration")).doubleValue();
                    if (doubleValue > 0.0d) {
                        this.f139041b = (long) (doubleValue * 1000000.0d);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new o();
    }

    public long a() {
        return this.f139041b;
    }

    public static Object a(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        if (i3 == 8) {
            return e(lVar);
        }
        if (i3 == 10) {
            return g(lVar);
        }
        if (i3 == 11) {
            return c(lVar);
        }
        if (i3 == 0) {
            return d(lVar);
        }
        if (i3 == 1) {
            return b(lVar);
        }
        if (i3 == 2) {
            return h(lVar);
        }
        if (i3 != 3) {
            return null;
        }
        return f(lVar);
    }

    public static Boolean b(com.tencent.luggage.wxa.n0.l lVar) {
        return Boolean.valueOf(lVar.q() == 1);
    }
}
