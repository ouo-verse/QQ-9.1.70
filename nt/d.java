package nt;

import com.tencent.ams.fusion.service.event.impl.b;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    public static void a(com.tencent.ams.fusion.service.event.impl.b bVar) {
        if (bVar == null) {
            return;
        }
        com.tencent.ams.fusion.a.f.a("FusionAd\uff0cpostReportEvent in " + bVar.f70286b);
        com.tencent.ams.fusion.service.b.b().k().a((com.tencent.ams.fusion.service.event.a) bVar);
    }

    public static void b(f fVar, int i3, long j3, long j16, int i16) {
        c(fVar, null, i3, j3, j16, i16);
    }

    public static void c(f fVar, SplashOrder splashOrder, int i3, long j3, long j16, int i16) {
        com.tencent.ams.fusion.service.event.impl.b bVar = new com.tencent.ams.fusion.service.event.impl.b();
        bVar.f70286b = i3;
        bVar.f70287c = j3;
        b.C0676b c0676b = bVar.f70290f;
        c0676b.f70294a = j16;
        c0676b.f70295b = i16;
        if (splashOrder != null) {
            bVar.f70288d.f70291a = splashOrder.f();
            bVar.f70288d.f70292b = splashOrder.y();
        }
        if (fVar != null) {
            bVar.f70289e.f70299a = fVar.b();
            bVar.f70289e.f70300b = fVar.a();
        }
        com.tencent.ams.fusion.service.b.b().k().a((com.tencent.ams.fusion.service.event.a) bVar);
    }
}
