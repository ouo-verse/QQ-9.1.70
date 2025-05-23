package hc0;

import com.tencent.biz.qqcircle.rerank.request.QFSRankEdgeGetDetailsReq;
import com.tencent.biz.qqcircle.rerank.request.QFSRankEdgeGetFeedsReq;
import com.tencent.biz.qqcircle.rerank.util.QFSRankEdgeReportHelper;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import ec0.a;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StBatchGetFeedDetailRsp;
import feedcloud.FeedCloudRead$StGetCloudSealFeedRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class m implements ec0.a {

    /* renamed from: a, reason: collision with root package name */
    private String f404720a;

    private List<FeedCloudMeta$StFeed> n(List<QFSEdgeItem> list) {
        ArrayList arrayList = new ArrayList();
        for (QFSEdgeItem qFSEdgeItem : list) {
            if (qFSEdgeItem != null && qFSEdgeItem.getFeedBlockData() != null && qFSEdgeItem.getFeedBlockData().g() != null) {
                arrayList.add(qFSEdgeItem.getFeedBlockData().g());
            }
        }
        return arrayList;
    }

    private void o(boolean z16, FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp, a.InterfaceC10228a interfaceC10228a, Map<String, String> map) {
        ArrayList<e30.b> b16;
        ArrayList arrayList = new ArrayList();
        if (feedCloudRead$StBatchGetFeedDetailRsp != null && (b16 = e30.d.b(feedCloudRead$StBatchGetFeedDetailRsp.feeds.get())) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (e30.b bVar : b16) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry.key.set("KEY_LOAD_TIME");
                feedCloudCommon$Entry.value.set(currentTimeMillis + "");
                bVar.g().extInfo.add(feedCloudCommon$Entry);
                QFSEdgeItem qFSEdgeItem = new QFSEdgeItem(bVar, 2);
                qFSEdgeItem.setTimeStamp(currentTimeMillis);
                arrayList.add(qFSEdgeItem);
            }
        }
        if (interfaceC10228a != null) {
            interfaceC10228a.a(z16, arrayList, map);
        }
        QLog.d("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "handleDetailListRsp   | edgeItemList.size = " + arrayList.size());
    }

    private void p(boolean z16, FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp, a.InterfaceC10228a interfaceC10228a, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (feedCloudRead$StGetCloudSealFeedRsp != null) {
            this.f404720a = feedCloudRead$StGetCloudSealFeedRsp.attachInfo.get();
            ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetCloudSealFeedRsp.sealFeeds.get());
            if (b16 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                for (e30.b bVar : b16) {
                    QFSEdgeItem qFSEdgeItem = new QFSEdgeItem(bVar, 2);
                    FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                    feedCloudCommon$Entry.key.set("KEY_LOAD_TIME");
                    feedCloudCommon$Entry.value.set(currentTimeMillis + "");
                    bVar.g().extInfo.add(feedCloudCommon$Entry);
                    qFSEdgeItem.setTimeStamp(currentTimeMillis);
                    arrayList.add(qFSEdgeItem);
                }
            }
        }
        if (interfaceC10228a != null) {
            interfaceC10228a.a(z16, arrayList, map);
        }
        QLog.d("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "handleRawListRsp   | edgeItemList.size = " + arrayList.size() + " | mRawAttachInfo = " + this.f404720a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(boolean z16, QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq, long j3, String str, FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp, a.InterfaceC10228a interfaceC10228a, Map map, long j16, BaseRequest baseRequest) {
        QLog.d("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "requestDetail onReceive: dispatch result:" + z16 + " | TraceId:" + qFSRankEdgeGetDetailsReq.getTraceId() + " | SeqId:" + qFSRankEdgeGetDetailsReq.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        o(z16, feedCloudRead$StBatchGetFeedDetailRsp, interfaceC10228a, map);
        QFSRankEdgeReportHelper.g(new QFSRankEdgeReportHelper.a().n("tedgeRSV2_edge_detail_query").p(System.currentTimeMillis() - j16).q(baseRequest.getTraceId()).o(j3).m(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(final QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq, final a.InterfaceC10228a interfaceC10228a, final Map map, final long j3, final BaseRequest baseRequest, final boolean z16, final long j16, final String str, final FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: hc0.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.q(z16, qFSRankEdgeGetDetailsReq, j16, str, feedCloudRead$StBatchGetFeedDetailRsp, interfaceC10228a, map, j3, baseRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(List list, final a.InterfaceC10228a interfaceC10228a) {
        final long currentTimeMillis = System.currentTimeMillis();
        final QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq = new QFSRankEdgeGetDetailsReq(n(list));
        final HashMap hashMap = new HashMap();
        hashMap.put("traceId", qFSRankEdgeGetDetailsReq.getTraceId());
        VSNetworkHelper.getInstance().sendRequest(qFSRankEdgeGetDetailsReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: hc0.j
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                m.this.r(qFSRankEdgeGetDetailsReq, interfaceC10228a, hashMap, currentTimeMillis, baseRequest, z16, j3, str, (FeedCloudRead$StBatchGetFeedDetailRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(boolean z16, QFSRankEdgeGetFeedsReq qFSRankEdgeGetFeedsReq, long j3, String str, FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp, a.InterfaceC10228a interfaceC10228a, Map map, long j16, BaseRequest baseRequest) {
        QLog.d("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "requestItemIndexList onReceive: dispatch result:" + z16 + " | TraceId:" + qFSRankEdgeGetFeedsReq.getTraceId() + " | SeqId:" + qFSRankEdgeGetFeedsReq.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        p(z16, feedCloudRead$StGetCloudSealFeedRsp, interfaceC10228a, map);
        QFSRankEdgeReportHelper.g(new QFSRankEdgeReportHelper.a().n("tedgeRSV2_edge_list_query").p(System.currentTimeMillis() - j16).q(baseRequest.getTraceId()).o(j3).m(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(final QFSRankEdgeGetFeedsReq qFSRankEdgeGetFeedsReq, final a.InterfaceC10228a interfaceC10228a, final Map map, final long j3, final BaseRequest baseRequest, final boolean z16, final long j16, final String str, final FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: hc0.k
            @Override // java.lang.Runnable
            public final void run() {
                m.this.t(z16, qFSRankEdgeGetFeedsReq, j16, str, feedCloudRead$StGetCloudSealFeedRsp, interfaceC10228a, map, j3, baseRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(String str, int i3, final a.InterfaceC10228a interfaceC10228a) {
        final long currentTimeMillis = System.currentTimeMillis();
        final QFSRankEdgeGetFeedsReq qFSRankEdgeGetFeedsReq = new QFSRankEdgeGetFeedsReq(str, i3, this.f404720a);
        final HashMap hashMap = new HashMap();
        hashMap.put("traceId", qFSRankEdgeGetFeedsReq.getTraceId());
        VSNetworkHelper.getInstance().sendRequest(qFSRankEdgeGetFeedsReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: hc0.i
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                m.this.u(qFSRankEdgeGetFeedsReq, interfaceC10228a, hashMap, currentTimeMillis, baseRequest, z16, j3, str2, (FeedCloudRead$StGetCloudSealFeedRsp) obj);
            }
        });
    }

    public static List<QFSEdgeItem> w(int i3) {
        ArrayList arrayList;
        long j3;
        ArrayList arrayList2 = new ArrayList();
        try {
            arrayList = (ArrayList) bj.a(RFWFileUtils.readFile(com.tencent.mobileqq.qcircle.api.constant.a.f261580e + "KEY_FEED_DATA_TYPE_" + i3));
        } catch (Exception e16) {
            QLog.e("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "getSaveItemList error: " + e16);
        }
        if (arrayList == null) {
            return arrayList2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            byte[] bArr = (byte[]) arrayList.get(i16);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.mergeFrom(bArr);
            e30.b bVar = new e30.b(feedCloudMeta$StFeed);
            bVar.p();
            QFSEdgeItem qFSEdgeItem = new QFSEdgeItem(bVar, 2);
            try {
                j3 = Long.parseLong(bh.d(feedCloudMeta$StFeed.extInfo.get(), "KEY_LOAD_TIME"));
            } catch (Exception e17) {
                QLog.d("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "getSaveItemList parseLong error: " + e17);
                j3 = currentTimeMillis;
            }
            qFSEdgeItem.setTimeStamp(j3);
            arrayList2.add(qFSEdgeItem);
        }
        QLog.d("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "getSaveItemList return size: " + arrayList2.size());
        return arrayList2;
    }

    public static void x(List<QFSEdgeItem> list, int i3) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    QLog.d("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "saveItemList size: " + list.size() + ",type:" + i3);
                    ArrayList arrayList = new ArrayList();
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        arrayList.add(list.get(i16).getFeedBlockData().g().toByteArray());
                    }
                    com.tencent.biz.qqcircle.utils.f.b(bj.j(arrayList), com.tencent.mobileqq.qcircle.api.constant.a.f261580e + "KEY_FEED_DATA_TYPE_" + i3);
                }
            } catch (Exception e16) {
                QLog.e("TEDGEQFS_QFSRerankDataPoolDelegate", 1, "saveItemList save error: " + e16);
            }
        }
    }

    @Override // ec0.a
    public void a(final int i3, final String str, final a.InterfaceC10228a interfaceC10228a) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: hc0.h
            @Override // java.lang.Runnable
            public final void run() {
                m.this.v(str, i3, interfaceC10228a);
            }
        });
    }

    @Override // ec0.a
    public List<QFSEdgeItem> b(int i3) {
        return w(i3);
    }

    @Override // ec0.a
    public long c() {
        return uq3.c.y4();
    }

    @Override // ec0.a
    public long d() {
        return uq3.c.x4();
    }

    @Override // ec0.a
    public void e(final List<QFSEdgeItem> list, final a.InterfaceC10228a interfaceC10228a) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: hc0.g
            @Override // java.lang.Runnable
            public final void run() {
                m.this.s(list, interfaceC10228a);
            }
        });
    }

    @Override // ec0.a
    public void f(List<QFSEdgeItem> list, int i3) {
        x(list, i3);
    }

    @Override // ec0.a
    public boolean g() {
        return uq3.c.n0();
    }
}
