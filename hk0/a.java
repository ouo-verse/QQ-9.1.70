package hk0;

import ik0.c;
import ik0.d;
import java.util.Map;
import lk0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a {
    public static c a(fk0.c cVar, b bVar, d dVar, Map<String, ik0.b> map, Map<String, c> map2) {
        c a16;
        c a17;
        if (bVar == null || (a16 = ik0.a.a(cVar, bVar, dVar, map.get(bVar.h0()))) == null) {
            return null;
        }
        if (map2 != null) {
            map2.put(bVar.f0(), a16);
        }
        if (a16 instanceof d) {
            d dVar2 = (d) a16;
            int W = bVar.W();
            for (int i3 = 0; i3 < W; i3++) {
                b a06 = bVar.a0(i3);
                if (a06 != null && (a17 = a(cVar, a06, dVar2, map, map2)) != null) {
                    dVar2.Q(a17);
                }
            }
        }
        return a16;
    }
}
