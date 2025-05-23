package kz;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends b {
    @Override // jz.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(g gVar, jz.c<stDramaFeed> cVar) {
        Map<Integer, stDramaFeed> e16 = gVar.e();
        int g16 = gVar.g();
        stDramaFeed stdramafeed = e16.get(Integer.valueOf(g16));
        if (stdramafeed == null) {
            gVar.k(0);
            c(gVar, cVar);
            return false;
        }
        x.i("WSDramaFeedsSingleFetcher-nel-log", "[WSAbsDramaFeedsFetcher.java][fetchFeedsFromCache]");
        ArrayList arrayList = new ArrayList();
        arrayList.add(stdramafeed);
        cVar.d0(arrayList, false, false, null);
        e(gVar, cVar, e16, g16);
        return true;
    }

    private void e(g gVar, jz.c<stDramaFeed> cVar, Map<Integer, stDramaFeed> map, int i3) {
        if (map.get(Integer.valueOf(i3 + 1)) == null) {
            gVar.m(true);
            gVar.k(0);
            c(gVar, cVar);
        }
    }
}
