package com.tencent.biz.pubaccount.weishi.recommend.data;

import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f81428a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f81429b;

        a(b bVar, long j3) {
            this.f81428a = bVar;
            this.f81429b = j3;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            f.this.c(lVar, this.f81428a, this.f81429b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l lVar, b bVar, long j3) {
        x.j("WSNoticeDataManagerLog", "[WSNoticeDataManager.java][handleOnTaskResponse] resultCode:" + lVar.f80992e + ", resultBean:" + lVar.f80999l + ", thread:" + Thread.currentThread().getName());
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (!lVar.d()) {
            com.tencent.biz.pubaccount.weishi.report.g.d().r(currentTimeMillis, lVar.f80994g, lVar.f80991d, lVar.f80990c);
            if (bVar != null) {
                bVar.x(lVar.f80991d, lVar.f80990c);
                return;
            }
            return;
        }
        if (!(lVar.f80999l instanceof stNotificationRsp)) {
            x.f("WSNoticeDataManagerLog", "[WSNoticeDataManager.java][handleOnTaskResponse] task.mResultBean instanceof stNotificationRsp: false! error:" + lVar.f80992e + ", errorMsg:" + lVar.f80990c);
            com.tencent.biz.pubaccount.weishi.report.g.d().r(currentTimeMillis, lVar.f80994g, -1, "\u6570\u636e\u65e0\u6cd5\u89e3\u6790\u6216\u4e3a\u7a7a");
            if (bVar != null) {
                bVar.x(lVar.f80992e, lVar.f80990c);
                return;
            }
            return;
        }
        com.tencent.biz.pubaccount.weishi.report.g.d().p(currentTimeMillis, lVar.f80994g, "feeds", true);
        stNotificationRsp stnotificationrsp = (stNotificationRsp) lVar.f80999l;
        x.j("WSNoticeDataManagerLog", "[WSNoticeDataManager.java][handleOnTaskResponse] type:" + stnotificationrsp.type + ", text:" + stnotificationrsp.text + ", h5Url:" + stnotificationrsp.h5Url + ", schema:" + stnotificationrsp.scheme_url);
        com.tencent.biz.pubaccount.weishi.net.d dVar = lVar.f81000m;
        if (dVar != null) {
            com.tencent.biz.pubaccount.weishi.report.c.b().d(stnotificationrsp.trace_id, dVar.f80962a);
        }
        if (stnotificationrsp.type > 0) {
            if (bVar != null) {
                bVar.i0(stnotificationrsp, dVar);
            }
        } else if (bVar != null) {
            bVar.x(lVar.f80992e, lVar.f80990c);
        }
    }

    public void b(String str, b bVar) {
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new i10.g(str), null, new a(bVar, System.currentTimeMillis()), 2001));
    }
}
