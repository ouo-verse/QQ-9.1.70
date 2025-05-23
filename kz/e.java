package kz;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stGetDramaFeedsRsp;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSGetDramaFeedsRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e implements jz.b<g, stDramaFeed> {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f413456a;

        /* renamed from: b, reason: collision with root package name */
        boolean f413457b;

        /* renamed from: c, reason: collision with root package name */
        boolean f413458c;

        /* renamed from: d, reason: collision with root package name */
        boolean f413459d;

        /* renamed from: e, reason: collision with root package name */
        int f413460e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public stDrama f413461a;

        /* renamed from: b, reason: collision with root package name */
        public List<stDramaFeed> f413462b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f413463c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f413464d;

        /* renamed from: e, reason: collision with root package name */
        public String f413465e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f413466f;

        public c(stDrama stdrama, List<stDramaFeed> list, boolean z16, boolean z17, String str, boolean z18) {
            this.f413461a = stdrama;
            this.f413462b = list;
            this.f413463c = z16;
            this.f413464d = z17;
            this.f413465e = str;
            this.f413466f = z18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.tencent.biz.pubaccount.weishi.net.common.j jVar, jz.c<stDramaFeed> cVar, g gVar) {
        cVar.i(jVar.a(), jVar.b(), gVar.a(), gVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c g(com.tencent.biz.pubaccount.weishi.net.common.g<stGetDramaFeedsRsp> gVar, stGetDramaFeedsRsp stgetdramafeedsrsp, g gVar2) {
        x.i("WSDramaEpisodeDataFetcher-nel-log", "[WSDramaEpisodeDataFetcher.java][handleSuccessOnSubThread] dramaFeedsSize:" + stgetdramafeedsrsp.dramaFeeds.size());
        x.i("WSDramaEpisodeDataFetcher-nel-log", "[WSDramaEpisodeDataFetcher.java][handleSuccessOnSubThread] dramaId:" + stgetdramafeedsrsp.drama.dramaInfo.f25116id);
        return new c(stgetdramafeedsrsp.drama, stgetdramafeedsrsp.dramaFeeds, gVar2.a(), gVar2.d() == 0, stgetdramafeedsrsp.attachInfo, stgetdramafeedsrsp.isFinished);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(c cVar, jz.c<stDramaFeed> cVar2) {
        cVar2.d0(cVar.f413462b, false, cVar.f413463c, l.b(cVar.f413465e, cVar.f413463c, cVar.f413464d, cVar.f413466f));
    }

    @Override // jz.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(g gVar, jz.c<stDramaFeed> cVar) {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSGetDramaFeedsRequest(new mz.c(gVar.a(), gVar.b(), gVar.f(), gVar.h(), gVar.d() == 0), gVar.c())).b(new a(gVar, cVar));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetDramaFeedsRsp, c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f413453a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jz.c f413454b;

        a(g gVar, jz.c cVar) {
            this.f413453a = gVar;
            this.f413454b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            e.this.f(jVar, this.f413454b, this.f413453a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public c c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetDramaFeedsRsp> gVar, stGetDramaFeedsRsp stgetdramafeedsrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return e.this.g(gVar, stgetdramafeedsrsp, this.f413453a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(c cVar) {
            e.this.h(cVar, this.f413454b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }
    }
}
