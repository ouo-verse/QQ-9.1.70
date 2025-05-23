package kz;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class b implements jz.b<g, stDramaFeed> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<stDramaFeed> b(g gVar, int i3, int i16, jz.c<stDramaFeed> cVar) {
        ArrayList<stDramaFeed> arrayList = new ArrayList<>();
        Map<Integer, stDramaFeed> e16 = gVar.e();
        while (i3 <= i16) {
            stDramaFeed stdramafeed = e16.get(Integer.valueOf(i3));
            if (stdramafeed == null) {
                c(gVar, cVar);
                return null;
            }
            arrayList.add(stdramafeed);
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(g gVar, jz.c<stDramaFeed> cVar) {
        x.i("WSAbsDramaFeedsFetcherLog-nel-log", "[WSAbsDramaFeedsFetcher.java][fetchFeedsFromServer]");
        new e().a(gVar, cVar);
    }
}
