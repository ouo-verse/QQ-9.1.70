package kz;

import UserGrowth.stDramaFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends b {
    @Override // jz.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(g gVar, jz.c<stDramaFeed> cVar) {
        int g16 = gVar.g();
        ArrayList<stDramaFeed> b16 = b(gVar, g16, g16 + 4, cVar);
        if (b16 != null) {
            cVar.d0(b16, false, false, l.b(gVar.c(), false, true, false));
        }
        return true;
    }
}
