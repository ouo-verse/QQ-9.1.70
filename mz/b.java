package mz;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import UserGrowth.stGetSimpleRecommendDramaRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSDramaRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements jz.b<e, d> {

    /* compiled from: P */
    /* renamed from: mz.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10811b {

        /* renamed from: a, reason: collision with root package name */
        public List<d> f417822a;

        public C10811b(List<d> list) {
            this.f417822a = list;
        }
    }

    private stDramaFeed g(Map<String, stDramaFeed> map, Map<String, ArrayList<String>> map2, stDrama stdrama) {
        int i3 = stdrama.dramaInfo.curWatchedFeedNum;
        ArrayList<String> f16 = f(map2, stdrama);
        if (f16 == null || i3 >= f16.size()) {
            return null;
        }
        return map.get(f16.get(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C10811b i(com.tencent.biz.pubaccount.weishi.net.common.g<stGetSimpleRecommendDramaRsp> gVar, stGetSimpleRecommendDramaRsp stgetsimplerecommenddramarsp) {
        ArrayList<stDrama> arrayList = stgetsimplerecommenddramarsp.dramas;
        Map<String, stDramaFeed> map = stgetsimplerecommenddramarsp.feedInfoMap;
        Map<String, ArrayList<String>> map2 = stgetsimplerecommenddramarsp.dramaFeedsMap;
        ArrayList arrayList2 = new ArrayList();
        Iterator<stDrama> it = arrayList.iterator();
        while (it.hasNext()) {
            stDrama next = it.next();
            if (!k(next)) {
                stDramaInfo stdramainfo = next.dramaInfo;
                stdramainfo.curWatchedFeedNum = Math.min(stdramainfo.curPublishedFeedNum, stdramainfo.curWatchedFeedNum);
                d dVar = new d(next);
                dVar.l(f(map2, next));
                dVar.m(g(map, map2, next));
                arrayList2.add(dVar);
            }
        }
        if (arrayList2.size() > 0) {
            ((d) arrayList2.get(0)).setChecked(true);
        }
        return new C10811b(arrayList2);
    }

    @Override // jz.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(e eVar, jz.c<d> cVar) {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSDramaRequest(eVar.c())).b(new a(cVar, eVar.a(), eVar.b()));
        return true;
    }

    private ArrayList<String> f(Map<String, ArrayList<String>> map, stDrama stdrama) {
        if (map != null) {
            return map.get(stdrama.dramaInfo.f25116id);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z16, boolean z17, j jVar, jz.c<d> cVar) {
        if (cVar != null) {
            cVar.i(jVar.a(), jVar.b(), z16, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(C10811b c10811b, jz.c<d> cVar) {
        if (cVar != null) {
            cVar.d0(c10811b.f417822a, false, false, null);
        }
    }

    private boolean k(stDrama stdrama) {
        stDramaInfo stdramainfo;
        return stdrama == null || (stdramainfo = stdrama.dramaInfo) == null || TextUtils.isEmpty(stdramainfo.f25116id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetSimpleRecommendDramaRsp, C10811b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jz.c f417818a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f417819b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f417820c;

        a(jz.c cVar, boolean z16, boolean z17) {
            this.f417818a = cVar;
            this.f417819b = z16;
            this.f417820c = z17;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j jVar) {
            super.b(jVar);
            b.this.h(this.f417819b, this.f417820c, jVar, this.f417818a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C10811b c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetSimpleRecommendDramaRsp> gVar, stGetSimpleRecommendDramaRsp stgetsimplerecommenddramarsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return b.this.i(gVar, stgetsimplerecommenddramarsp);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C10811b c10811b) {
            super.d(c10811b);
            b.this.j(c10811b, this.f417818a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j jVar) {
        }
    }
}
