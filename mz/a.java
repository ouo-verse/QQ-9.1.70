package mz;

import UserGrowth.stGetAllFeedsByDramaIDRsp;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSAllEpisodeIdsRequest;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements jz.b<f, String> {
    @Override // jz.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(f fVar, jz.c<String> cVar) {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSAllEpisodeIdsRequest(fVar.f417831c)).b(new C10810a(cVar));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: mz.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10810a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetAllFeedsByDramaIDRsp, stGetAllFeedsByDramaIDRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jz.c f417816a;

        C10810a(jz.c cVar) {
            this.f417816a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j jVar) {
            super.b(jVar);
            this.f417816a.i(jVar.a(), jVar.b(), false, false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stGetAllFeedsByDramaIDRsp stgetallfeedsbydramaidrsp) {
            super.d(stgetallfeedsbydramaidrsp);
            this.f417816a.d0(stgetallfeedsbydramaidrsp.feedIDs, false, false, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j jVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stGetAllFeedsByDramaIDRsp c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetAllFeedsByDramaIDRsp> gVar, stGetAllFeedsByDramaIDRsp stgetallfeedsbydramaidrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return stgetallfeedsbydramaidrsp;
        }
    }
}
