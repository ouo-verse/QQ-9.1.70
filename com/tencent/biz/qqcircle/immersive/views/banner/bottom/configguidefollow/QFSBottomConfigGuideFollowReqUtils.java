package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import com.tencent.biz.qqcircle.immersive.request.QFSGetFeedDetailSecondaryLoadByFollowAuthorRequest;
import com.tencent.biz.qqcircle.immersive.request.QFSGetFeedDetailSecondaryLoadRequest;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigRecycleAdapter;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudRead$StDrawerCard;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadRsp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomConfigGuideFollowReqUtils {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z16, List<d> list, int i3, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(e30.b bVar, FeedCloudRead$StFeedDeatilSecondaryLoadRsp feedCloudRead$StFeedDeatilSecondaryLoadRsp, QFSBottomConfigRecycleAdapter.ShowScene showScene, a aVar) {
        List<FeedCloudRead$StDrawerCard> list = feedCloudRead$StFeedDeatilSecondaryLoadRsp.feedDrawer.cards.get();
        String str = feedCloudRead$StFeedDeatilSecondaryLoadRsp.feedDrawer.drawerTitle.get();
        int i3 = feedCloudRead$StFeedDeatilSecondaryLoadRsp.feedDrawer.type.get();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FeedCloudRead$StDrawerCard feedCloudRead$StDrawerCard : list) {
            d dVar = new d();
            int i16 = feedCloudRead$StDrawerCard.type.get();
            if (i16 == 1) {
                dVar.k(feedCloudRead$StDrawerCard.userInfo.get());
                dVar.h(-101);
                arrayList2.add(feedCloudRead$StDrawerCard.userInfo.get());
            } else if (i16 == 2) {
                dVar.g(feedCloudRead$StDrawerCard.feedInfo.get());
                dVar.h(-103);
            }
            dVar.i(bVar);
            dVar.j(i3);
            arrayList.add(dVar);
        }
        if (i3 == 2 && arrayList.size() > 3) {
            d dVar2 = new d();
            dVar2.h(-102);
            dVar2.l(arrayList2);
            arrayList.add(dVar2);
        }
        QLog.d("QFSBottomConfigGuideFollowReqUtils", 1, "[handleSuccess] type:" + i3 + ", size:" + arrayList.size());
        g(bVar, arrayList);
        if (i.f90684a.a(showScene)) {
            j(bVar, showScene);
            i(bVar, i3);
            h(bVar, str);
        }
        r.Y0(bVar);
        e(aVar, true, arrayList, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(QFSGetFeedDetailSecondaryLoadRequest qFSGetFeedDetailSecondaryLoadRequest, final a aVar, final e30.b bVar, final QFSBottomConfigRecycleAdapter.ShowScene showScene, BaseRequest baseRequest, boolean z16, long j3, String str, final FeedCloudRead$StFeedDeatilSecondaryLoadRsp feedCloudRead$StFeedDeatilSecondaryLoadRsp) {
        QLog.d("QFSBottomConfigGuideFollowReqUtils", 1, "requestFeedBottomConfigGuideFollowData onReceive: dispatch Success:" + z16 + " | TraceId:" + qFSGetFeedDetailSecondaryLoadRequest.getTraceId() + " | SeqId:" + qFSGetFeedDetailSecondaryLoadRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + VSNetworkHelper.isProtocolCache(str));
        if (z16 && j3 == 0 && feedCloudRead$StFeedDeatilSecondaryLoadRsp != null) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigGuideFollowReqUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSBottomConfigGuideFollowReqUtils.c(e30.b.this, feedCloudRead$StFeedDeatilSecondaryLoadRsp, showScene, aVar);
                }
            });
        } else if (aVar != null) {
            aVar.a(false, null, 0, "");
        }
    }

    private static void e(final a aVar, final boolean z16, final List<d> list, final int i3, final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigGuideFollowReqUtils.2
            @Override // java.lang.Runnable
            public void run() {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a(z16, list, i3, str);
                }
            }
        });
    }

    public static void f(final e30.b bVar, final QFSBottomConfigRecycleAdapter.ShowScene showScene, final a aVar) {
        final QFSGetFeedDetailSecondaryLoadRequest qFSGetFeedDetailSecondaryLoadRequest;
        if (bVar == null) {
            QLog.e("QFSBottomConfigGuideFollowReqUtils", 1, "[sendReq] sourceFeed should not be null");
            return;
        }
        if (i.f90684a.a(showScene)) {
            qFSGetFeedDetailSecondaryLoadRequest = new QFSGetFeedDetailSecondaryLoadByFollowAuthorRequest(bVar.g());
        } else {
            qFSGetFeedDetailSecondaryLoadRequest = new QFSGetFeedDetailSecondaryLoadRequest(bVar.g());
        }
        VSNetworkHelper.getInstance().sendRequest(qFSGetFeedDetailSecondaryLoadRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.e
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSBottomConfigGuideFollowReqUtils.d(QFSGetFeedDetailSecondaryLoadRequest.this, aVar, bVar, showScene, baseRequest, z16, j3, str, (FeedCloudRead$StFeedDeatilSecondaryLoadRsp) obj);
            }
        });
    }

    public static void g(e30.b bVar, List<d> list) {
        if (bVar != null && list != null) {
            bVar.o("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW", list);
        }
    }

    public static void h(e30.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        bVar.o("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_DRAWER_TITLE", str);
    }

    public static void i(e30.b bVar, int i3) {
        if (bVar == null) {
            return;
        }
        bVar.o("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_DRAWER_TYPE", Integer.valueOf(i3));
    }

    public static void j(e30.b bVar, QFSBottomConfigRecycleAdapter.ShowScene showScene) {
        if (bVar != null && showScene != null) {
            bVar.o("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_SHOW_SCENE", showScene);
        }
    }
}
