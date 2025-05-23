package com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend;

import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.requests.QFSGetFeedBottomFeedReq;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomBannerRecReqUtils {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z16, List<e30.b> list);
    }

    private static void c(e30.b bVar, List<e30.b> list) {
        Iterator<e30.b> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().e().f398449id.get().equals(bVar.e().f398449id.get())) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(e30.b bVar, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final a aVar) {
        List<e30.b> D = r.D(bVar);
        if (D != null && D.size() > 1) {
            QLog.d("QFSBottomBannerRecReqUtils", 1, "has already bind recData , don not need rebind");
            return;
        }
        final ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        c(bVar, b16);
        b16.add(0, bVar);
        if (b16.size() > 0) {
            r.S0(bVar, b16);
            r.R0(bVar);
            QLog.d("QFSBottomBannerRecReqUtils", 1, "handleSuccess size:" + b16.size());
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomBannerRecReqUtils.2
            @Override // java.lang.Runnable
            public void run() {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a(true, b16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(QFSGetFeedBottomFeedReq qFSGetFeedBottomFeedReq, final e30.b bVar, final a aVar, BaseRequest baseRequest, boolean z16, long j3, String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QLog.d("QFSBottomBannerRecReqUtils", 1, "requestData onReceive: dispatch Success:" + z16 + " | TraceId:" + qFSGetFeedBottomFeedReq.getTraceId() + " | SeqId:" + qFSGetFeedBottomFeedReq.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + VSNetworkHelper.isProtocolCache(str));
        if (z16 && j3 == 0) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomBannerRecReqUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSBottomBannerRecReqUtils.d(e30.b.this, feedCloudRead$StGetFeedListRsp, aVar);
                }
            });
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        if (aVar != null) {
            aVar.a(false, arrayList);
        }
    }

    public static void f(final e30.b bVar, final a aVar) {
        if (bVar == null) {
            return;
        }
        QFSGetFeedBottomFeedReq.a aVar2 = new QFSGetFeedBottomFeedReq.a(bVar.e().poster.f398463id.get());
        aVar2.j(1);
        aVar2.h(0);
        aVar2.k(64);
        aVar2.g(bVar.e());
        final QFSGetFeedBottomFeedReq b16 = aVar2.b();
        BaseRequest.isCacheExist(b16);
        VSNetworkHelper.getInstance().sendRequest(b16, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSBottomBannerRecReqUtils.e(QFSGetFeedBottomFeedReq.this, bVar, aVar, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }
}
