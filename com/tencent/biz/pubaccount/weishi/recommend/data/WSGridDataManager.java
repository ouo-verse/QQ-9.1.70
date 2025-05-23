package com.tencent.biz.pubaccount.weishi.recommend.data;

import UserGrowth.stExposureFeedInfo;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSRecommendRequest;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.gdt.access;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSGridDataManager {

    /* renamed from: d, reason: collision with root package name */
    private boolean f81398d;

    /* renamed from: b, reason: collision with root package name */
    private String f81396b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f81397c = "";

    /* renamed from: a, reason: collision with root package name */
    private final d f81395a = new d();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<stSimpleMetaFeed> f81412a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f81413b;

        b() {
        }

        public ArrayList<stSimpleMetaFeed> b() {
            ArrayList<stSimpleMetaFeed> arrayList = this.f81412a;
            return arrayList == null ? new ArrayList<>() : arrayList;
        }

        public boolean c() {
            return this.f81413b;
        }

        public void d(ArrayList<stSimpleMetaFeed> arrayList) {
            this.f81412a = arrayList;
        }

        public void e(boolean z16) {
            this.f81413b = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<stSimpleMetaFeed> g(List<stSimpleMetaFeed> list) {
        ArrayList arrayList = new ArrayList();
        for (stSimpleMetaFeed stsimplemetafeed : list) {
            if (stsimplemetafeed.gdt_ad_type == 2) {
                access.AdGetRsp e16 = com.tencent.biz.pubaccount.weishi.util.d.f81760a.e(stsimplemetafeed.waterAdItem);
                if (e16.qq_ad_get_rsp.pos_ads_info.isEmpty() || e16.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.isEmpty()) {
                    arrayList.add(stsimplemetafeed);
                }
            }
        }
        list.removeAll(arrayList);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.biz.pubaccount.weishi.net.common.b<stSimpleGetFeedListRsp, b> i(com.tencent.biz.pubaccount.weishi.recommend.data.a aVar, boolean z16, boolean z17, boolean z18, String str, long j3) {
        return new a(z17, z16, str, aVar, z18, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b j(stSimpleGetFeedListRsp stsimplegetfeedlistrsp, com.tencent.biz.pubaccount.weishi.net.d dVar, boolean z16, boolean z17, String str) {
        x.j("WSGridDataManagerLog", "[WSGridDataManager.java][handleFeedResponse] successOnSubThread!");
        b bVar = new b();
        ArrayList<stSimpleMetaFeed> arrayList = stsimplegetfeedlistrsp.feeds;
        if (arrayList != null && arrayList.size() > 0) {
            this.f81396b = stsimplegetfeedlistrsp.attach_info;
            this.f81397c = stsimplegetfeedlistrsp.session;
            if (dVar != null) {
                com.tencent.biz.pubaccount.weishi.report.c.b().d(stsimplegetfeedlistrsp.trace_id, dVar.f80962a);
                x.j("WSGridDataManagerLog", "[WSGridDataManager.java][handleFeedResponseForSuccess] onLoadDataSuccess traceId = " + stsimplegetfeedlistrsp.trace_id);
            }
            if (z16) {
                iz.a.g().s(1, stsimplegetfeedlistrsp.config);
            }
            ArrayList<stSimpleMetaFeed> arrayList2 = stsimplegetfeedlistrsp.feeds;
            this.f81395a.a(z16, z17, arrayList2, str);
            bb.P(arrayList2);
            bVar.d(arrayList2);
            bVar.e(stsimplegetfeedlistrsp.is_finished);
            return bVar;
        }
        x.f("WSGridDataManagerLog", "[WSGridDataManager.java][handleFeedResponse] feeds.size(): 0");
        return bVar;
    }

    public void h(e eVar, final com.tencent.biz.pubaccount.weishi.recommend.data.a aVar) {
        final boolean j3 = eVar.j();
        final boolean h16 = eVar.h();
        final boolean i3 = eVar.i();
        final long e16 = eVar.e();
        final String f16 = eVar.f();
        final String d16 = eVar.d();
        final String c16 = eVar.c();
        final ArrayList<String> a16 = eVar.a();
        final ArrayList<stExposureFeedInfo> b16 = eVar.b();
        final Map<String, Integer> g16 = eVar.g();
        x.i("WSGridDataManagerLog", "[WSGridDataManager.java][fetchGridData] isFirstFromService:" + h16 + ", contentFeedIds:" + a16 + ", videoFeedTypeMap:" + g16 + ", exposeFeedList.size:" + b16.size());
        l(j3, h16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.recommend.data.WSGridDataManager.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSRecommendRequest(WSGridDataManager.this.f81396b, j3 ? (byte) 1 : (byte) 0, h16 ? (byte) 1 : (byte) 0, a16, 1, "", d16, WSGridDataManager.this.f81397c, c16, f16, b16, g16, com.tencent.biz.pubaccount.weishi.util.d.f81760a.b(String.valueOf(1)))).b(WSGridDataManager.this.i(aVar, j3, h16, i3, f16, e16));
            }
        }, 128, null, false);
    }

    public boolean k() {
        return this.f81398d;
    }

    private void l(boolean z16, boolean z17) {
        if (z17 || z16) {
            this.f81396b = "";
            this.f81397c = "";
            this.f81398d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stSimpleGetFeedListRsp, b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f81405a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f81406b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f81407c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.pubaccount.weishi.recommend.data.a f81408d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f81409e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f81410f;

        a(boolean z16, boolean z17, String str, com.tencent.biz.pubaccount.weishi.recommend.data.a aVar, boolean z18, long j3) {
            this.f81405a = z16;
            this.f81406b = z17;
            this.f81407c = str;
            this.f81408d = aVar;
            this.f81409e = z18;
            this.f81410f = j3;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j jVar) {
            super.b(jVar);
            com.tencent.biz.pubaccount.weishi.recommend.data.a aVar = this.f81408d;
            if (aVar != null) {
                aVar.e0(jVar.a(), jVar.b(), this.f81405a, this.f81406b);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b c(com.tencent.biz.pubaccount.weishi.net.common.g<stSimpleGetFeedListRsp> gVar, stSimpleGetFeedListRsp stsimplegetfeedlistrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return WSGridDataManager.this.j(stsimplegetfeedlistrsp, dVar, this.f81405a, this.f81406b, this.f81407c);
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(b bVar) {
            super.d(bVar);
            WSGridDataManager.this.f81398d = bVar.c();
            if (bVar.b() != null && bVar.b().size() > 0) {
                com.tencent.biz.pubaccount.weishi.recommend.data.a aVar = this.f81408d;
                if (aVar != null) {
                    aVar.R(WSGridDataManager.this.g(bVar.f81412a), this.f81405a, this.f81406b, this.f81409e, this.f81410f);
                    return;
                }
                return;
            }
            b(new j(0, HardCodeUtil.qqStr(R.string.vn7)));
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j jVar) {
        }
    }
}
