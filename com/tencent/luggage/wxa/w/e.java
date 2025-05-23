package com.tencent.luggage.wxa.w;

import android.util.SparseArray;
import com.tencent.luggage.wxa.w.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements v.c {

    /* renamed from: a, reason: collision with root package name */
    public final int f143774a;

    /* renamed from: b, reason: collision with root package name */
    public final List f143775b;

    public e(int i3) {
        this(i3, Collections.emptyList());
    }

    @Override // com.tencent.luggage.wxa.w.v.c
    public SparseArray a() {
        return new SparseArray();
    }

    public e(int i3, List list) {
        this.f143774a = i3;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(com.tencent.luggage.wxa.m.j.a(null, "application/cea-608", 0, null));
        }
        this.f143775b = list;
    }

    @Override // com.tencent.luggage.wxa.w.v.c
    public v a(int i3, v.b bVar) {
        if (i3 == 2) {
            return new o(new i());
        }
        if (i3 == 3 || i3 == 4) {
            return new o(new m(bVar.f143975b));
        }
        if (i3 == 15) {
            if (a(2)) {
                return null;
            }
            return new o(new d(false, bVar.f143975b));
        }
        if (i3 == 21) {
            return new o(new l());
        }
        if (i3 == 27) {
            if (a(4)) {
                return null;
            }
            return new o(new j(a(bVar), a(1), a(8)));
        }
        if (i3 == 36) {
            return new o(new k(a(bVar)));
        }
        if (i3 != 89) {
            if (i3 != 138) {
                if (i3 != 129) {
                    if (i3 != 130) {
                        if (i3 == 134) {
                            if (a(16)) {
                                return null;
                            }
                            return new r(new t());
                        }
                        if (i3 != 135) {
                            return null;
                        }
                    }
                }
                return new o(new b(bVar.f143975b));
            }
            return new o(new f(bVar.f143975b));
        }
        return new o(new g(bVar.f143976c));
    }

    public final s a(v.b bVar) {
        int i3;
        String str;
        if (a(32)) {
            return new s(this.f143775b);
        }
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(bVar.f143977d);
        List list = this.f143775b;
        while (lVar.a() > 0) {
            int q16 = lVar.q();
            int c16 = lVar.c() + lVar.q();
            if (q16 == 134) {
                list = new ArrayList();
                int q17 = lVar.q() & 31;
                for (int i16 = 0; i16 < q17; i16++) {
                    String b16 = lVar.b(3);
                    int q18 = lVar.q();
                    if ((q18 & 128) != 0) {
                        i3 = q18 & 63;
                        str = "application/cea-708";
                    } else {
                        i3 = 1;
                        str = "application/cea-608";
                    }
                    list.add(com.tencent.luggage.wxa.m.j.a((String) null, str, (String) null, -1, 0, b16, i3, (com.tencent.luggage.wxa.p.a) null));
                    lVar.f(2);
                }
            }
            lVar.e(c16);
        }
        return new s(list);
    }

    public final boolean a(int i3) {
        return (i3 & this.f143774a) != 0;
    }
}
