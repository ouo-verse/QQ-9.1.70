package kz;

import UserGrowth.stGetFollowedDramasRsp;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSGetFollowDramaRequest;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes38.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private String f413480a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f413481b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f413484a;

        /* renamed from: b, reason: collision with root package name */
        public String f413485b;

        /* renamed from: c, reason: collision with root package name */
        public mz.g f413486c;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.tencent.biz.pubaccount.weishi.net.common.j jVar, kz.a<mz.g> aVar) {
        x.i("WSGetFollowDramaFetcher", "request failed. errCode = " + jVar.a() + ", errMsg = " + jVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b f(com.tencent.biz.pubaccount.weishi.net.common.g<stGetFollowedDramasRsp> gVar, stGetFollowedDramasRsp stgetfolloweddramasrsp) {
        WeiShiCacheManager.O().s(stgetfolloweddramasrsp);
        b bVar = new b();
        bVar.f413485b = stgetfolloweddramasrsp.attachInfo;
        bVar.f413484a = stgetfolloweddramasrsp.isFinished;
        mz.g gVar2 = new mz.g();
        gVar2.c(stgetfolloweddramasrsp.title);
        gVar2.b(vz.a.b(stgetfolloweddramasrsp.dramas));
        bVar.f413486c = gVar2;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(b bVar, kz.a<mz.g> aVar) {
        x.i("WSGetFollowDramaFetcher", "request success.");
        aVar.onSuccess(bVar.f413486c);
        this.f413480a = bVar.f413485b;
        this.f413481b = bVar.f413484a;
    }

    public boolean d(kz.a<mz.g> aVar) {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSGetFollowDramaRequest(this.f413480a)).b(new a(aVar));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetFollowedDramasRsp, b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kz.a f413482a;

        a(kz.a aVar) {
            this.f413482a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            m.this.e(jVar, this.f413482a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetFollowedDramasRsp> gVar, stGetFollowedDramasRsp stgetfolloweddramasrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return m.this.f(gVar, stgetfolloweddramasrsp);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(b bVar) {
            m.this.g(bVar, this.f413482a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }
    }
}
