package com.tencent.luggage.wxa.qm;

import com.tencent.luggage.wxa.p9.g;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.on.d {
    @Override // com.tencent.luggage.wxa.on.d
    public boolean a(com.tencent.luggage.wxa.p9.g gVar) {
        if (!((com.tencent.luggage.wxa.nb.c) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.nb.c.class)).V()) {
            return false;
        }
        if (!k.i()) {
            w.b("MicroMsg.Music.MusicActionListener", "don't anything, must init MusicPlayerManager first with MusicLogic before!");
            return false;
        }
        int i3 = gVar.f137457d.f137459a;
        if (i3 == 13) {
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.tm.b.a(e.class));
        } else if (i3 != 16) {
            switch (i3) {
                case -3:
                    gVar.f137458e.f137466b = k.f().b().i();
                    break;
                case -2:
                    gVar.f137458e.f137465a = k.f().a();
                    break;
                case -1:
                    k.f().d();
                    break;
                case 0:
                    k.f().e(gVar.f137457d.f137460b);
                    break;
                case 1:
                    k.f().b().j();
                    break;
                case 2:
                    k.f().b().a();
                    break;
                case 3:
                    k.f().f(gVar.f137457d.f137460b);
                    break;
                case 4:
                    k f16 = k.f();
                    g.a aVar = gVar.f137457d;
                    f16.a(aVar.f137461c, aVar.f137462d);
                    break;
                case 5:
                    k f17 = k.f();
                    g.a aVar2 = gVar.f137457d;
                    f17.a(aVar2.f137461c, aVar2.f137463e);
                    break;
                case 6:
                    k.f().d(gVar.f137457d.f137460b);
                    break;
                case 7:
                    gVar.f137458e.f137466b = k.f().b().b(gVar.f137457d.f137464f);
                    break;
                case 8:
                    gVar.f137458e.f137467c = k.f().b().b();
                    break;
                case 9:
                    gVar.f137458e.f137466b = k.f().b().c();
                    break;
                case 10:
                    gVar.f137458e.f137466b = k.f().b().h();
                    break;
                case 11:
                    k.f().b(600000);
                    break;
            }
        } else {
            k.f().b(gVar.f137457d.f137460b);
        }
        return false;
    }
}
