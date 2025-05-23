package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stDrama;
import UserGrowth.stGetDramaFeedsRsp;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSGetDramaFeedsRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f implements jz.b<mz.c, j> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f81989a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f81990b;

    /* renamed from: c, reason: collision with root package name */
    public String f81991c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public stDrama f81995a;

        /* renamed from: b, reason: collision with root package name */
        public List<j> f81996b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f81997c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f81998d;

        /* renamed from: e, reason: collision with root package name */
        public String f81999e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f82000f;

        public b(stDrama stdrama, List<j> list, boolean z16, boolean z17, String str, boolean z18) {
            this.f81995a = stdrama;
            this.f81996b = list;
            this.f81997c = z16;
            this.f81998d = z17;
            this.f81999e = str;
            this.f82000f = z18;
        }
    }

    private void e(b bVar) {
        this.f81991c = bVar.f81999e;
        if (bVar.f81998d) {
            this.f81990b = bVar.f82000f;
        } else {
            this.f81989a = bVar.f82000f;
        }
    }

    private int g(boolean z16, boolean z17) {
        if (z16) {
            return 1;
        }
        if (z17) {
            return 3;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.tencent.biz.pubaccount.weishi.net.common.j jVar, jz.c<j> cVar, mz.c cVar2) {
        cVar.i(jVar.a(), jVar.b(), cVar2.a(), cVar2.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b i(com.tencent.biz.pubaccount.weishi.net.common.g<stGetDramaFeedsRsp> gVar, stGetDramaFeedsRsp stgetdramafeedsrsp, mz.c cVar) {
        ArrayList<j> c16 = i.c(stgetdramafeedsrsp.drama, stgetdramafeedsrsp.dramaFeeds, cVar.e() && stgetdramafeedsrsp.isFinished);
        x.j("WSDramaEpisodeDataFetcher", "[WSDramaEpisodeDataFetcher.java][handleSuccessOnSubThread] itemDataList size:" + c16.size() + ", mIsFinished:" + stgetdramafeedsrsp.isFinished);
        return new b(stgetdramafeedsrsp.drama, c16, cVar.a(), cVar.e(), stgetdramafeedsrsp.attachInfo, stgetdramafeedsrsp.isFinished);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(b bVar, jz.c<j> cVar) {
        e(bVar);
        cVar.d0(bVar.f81996b, false, bVar.f81997c, Integer.valueOf(g(bVar.f81997c, bVar.f81998d)));
    }

    @Override // jz.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(mz.c cVar, jz.c<j> cVar2) {
        if (k(cVar.e())) {
            x.i("WSDramaEpisodeDataFetcher", "fetchData() is finished. isLoadMoreDown = " + cVar.e());
            return false;
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSGetDramaFeedsRequest(cVar, this.f81991c)).b(new a(cVar, cVar2));
        return true;
    }

    private boolean k(boolean z16) {
        if (z16) {
            return this.f81990b;
        }
        return this.f81989a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetDramaFeedsRsp, b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ mz.c f81992a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jz.c f81993b;

        a(mz.c cVar, jz.c cVar2) {
            this.f81992a = cVar;
            this.f81993b = cVar2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            f.this.h(jVar, this.f81993b, this.f81992a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetDramaFeedsRsp> gVar, stGetDramaFeedsRsp stgetdramafeedsrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return f.this.i(gVar, stgetdramafeedsrsp, this.f81992a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(b bVar) {
            f.this.j(bVar, this.f81993b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }
    }
}
