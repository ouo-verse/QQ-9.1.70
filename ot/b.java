package ot;

import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.event.impl.b;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static void a(c cVar, SplashOrder splashOrder, int i3, long j3, long j16, int i16) {
        com.tencent.ams.fusion.service.event.impl.b bVar = new com.tencent.ams.fusion.service.event.impl.b();
        bVar.f70286b = i3;
        bVar.f70287c = j3;
        b.C0676b c0676b = bVar.f70290f;
        c0676b.f70294a = j16;
        c0676b.f70295b = i16;
        if (splashOrder != null) {
            bVar.f70288d.f70291a = splashOrder.f();
            bVar.f70288d.f70292b = splashOrder.y();
            bVar.f70288d.f70293c = splashOrder.au();
        }
        if (cVar != null) {
            bVar.f70289e.f70299a = cVar.i();
            bVar.f70289e.f70300b = cVar.a();
            bVar.f70290f.f70298e = cVar.l();
        }
        com.tencent.ams.fusion.service.b.b().k().a((com.tencent.ams.fusion.service.event.a) bVar);
    }

    public static void b(c cVar, d dVar, int i3, long j3, long j16) {
        c(cVar, dVar, i3, j3, j16, Integer.MIN_VALUE);
    }

    public static void c(c cVar, d dVar, int i3, long j3, long j16, int i16) {
        List<SplashOrder> list;
        if (dVar != null) {
            list = dVar.a();
        } else {
            list = null;
        }
        if (j.b(list)) {
            a(cVar, null, i3, j3, j16, i16);
            return;
        }
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            a(cVar, (SplashOrder) it.next(), i3, j3, j16, i16);
        }
    }
}
