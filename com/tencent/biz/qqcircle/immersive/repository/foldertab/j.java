package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleFeedDetailRspInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.requests.QFSFeedCloudRenderFeedDetailRequest;
import com.tencent.biz.qqcircle.rerank.request.QFSRankEdgeGetDetailsReq;
import com.tencent.biz.qqcircle.utils.ci;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StBatchGetFeedDetailRsp;
import feedcloud.FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final QFSTabFeedViewModel f89795a;

    public j(QFSTabFeedViewModel qFSTabFeedViewModel) {
        this.f89795a = qFSTabFeedViewModel;
    }

    private void e(boolean z16, List<FeedCloudMeta$StFeed> list, long j3, String str, List<FeedCloudMeta$StFeed> list2) {
        ArrayList<e30.b> arrayList;
        UIStateData<QCircleFeedDetailRspInfo> retCode;
        QCircleFeedDetailRspInfo qCircleFeedDetailRspInfo = null;
        if (z16 && j3 == 0 && list != null) {
            arrayList = e30.d.b(list);
            QLog.d("FeedLine_QFSSimpleFeedHelper", 1, "handleDetailListRsp   | itemList.size = " + arrayList.size() + " | originFeed.size = " + list2.size());
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() == list2.size()) {
            w20.a.j().initOrUpdateGlobalState((List) arrayList, true);
            qCircleFeedDetailRspInfo = new QCircleFeedDetailRspInfo(arrayList);
            retCode = UIStateData.obtainSuccess(false).setData(false, qCircleFeedDetailRspInfo).setRetCode(j3).setMsg(str);
        } else {
            retCode = UIStateData.obtainError(str).setRetCode(j3);
        }
        QLog.d("FeedLine_QFSSimpleFeedHelper", 1, "handleDetailListRsp detailFeedRspInfo :" + qCircleFeedDetailRspInfo);
        this.f89795a.c3(retCode);
    }

    public static boolean f(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            return g(bVar.g());
        }
        return false;
    }

    public static boolean g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return feedCloudMeta$StFeed.opMask2.get().contains(44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(List list, String str, BaseRequest baseRequest, boolean z16, long j3, String str2, FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (z16 && j3 == 0 && feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp != null && (feedCloudMeta$StFeed = feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp.feed_detail) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudMeta$StFeed);
            e(true, arrayList, j3, str2, list);
            RFWLog.d("FeedLine_QFSSimpleFeedHelper", RFWLog.USR, "[requestFeedDetailInfo] stFeed get succeed, traceId\uff1a" + baseRequest.getTraceId() + ",feedId:" + str);
            return;
        }
        e(false, new ArrayList(), j3, str2, list);
        RFWLog.e("FeedLine_QFSSimpleFeedHelper", RFWLog.USR, "[requestFeedDetailInfo] stFeed get error:" + j3 + ",errMsg:" + str2 + ",feedId:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(boolean z16, QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq, long j3, String str, FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp, List list) {
        QLog.d("FeedLine_QFSSimpleFeedHelper", 1, "requestDetail onReceive: dispatch result:" + z16 + " | TraceId:" + qFSRankEdgeGetDetailsReq.getTraceId() + " | SeqId:" + qFSRankEdgeGetDetailsReq.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        if (feedCloudRead$StBatchGetFeedDetailRsp != null) {
            e(z16, feedCloudRead$StBatchGetFeedDetailRsp.feeds.get(), j3, str, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(final QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq, final List list, BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.i
            @Override // java.lang.Runnable
            public final void run() {
                j.this.i(z16, qFSRankEdgeGetDetailsReq, j3, str, feedCloudRead$StBatchGetFeedDetailRsp, list);
            }
        });
    }

    private void l(@NonNull QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq) {
        byte[] s16;
        if (this.f89795a.r2() != null && (s16 = this.f89795a.r2().s()) != null && s16.length > 0) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set("common_reddot_insert_info");
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(s16));
            qFSRankEdgeGetDetailsReq.mRequest.extInfo.mapBytesInfo.add(feedCloudCommon$BytesEntry);
            if (!qFSRankEdgeGetDetailsReq.mRequest.extInfo.has()) {
                qFSRankEdgeGetDetailsReq.mRequest.extInfo.setHasFlag(true);
            }
            QLog.d("FeedLine_QFSSimpleFeedHelper", 1, "wrapRedPointInfo");
        }
    }

    public List<FeedCloudMeta$StFeed> d(List<e30.b> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            FeedCloudMeta$StFeed g16 = list.get(i3).g();
            if (g(g16)) {
                arrayList.add(g16);
            }
        }
        return arrayList;
    }

    public void k(List<e30.b> list) {
        if (list != null && !list.isEmpty()) {
            final List<FeedCloudMeta$StFeed> d16 = d(list);
            if (d16.isEmpty()) {
                return;
            }
            this.f89795a.c3(UIStateData.obtainLoading());
            QLog.d("FeedLine_QFSSimpleFeedHelper", 1, "loadPreloadFeedDetailInfo  origin feed size:" + d16.size());
            if (((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = d16.get(0);
                final String str = feedCloudMeta$StFeed.f398449id.get();
                QFSFeedCloudRenderFeedDetailRequest qFSFeedCloudRenderFeedDetailRequest = new QFSFeedCloudRenderFeedDetailRequest(str, "", 3, true);
                qFSFeedCloudRenderFeedDetailRequest.setAllPushTransInfo(ci.c(feedCloudMeta$StFeed));
                VSNetworkHelper.getInstance().sendRequest(qFSFeedCloudRenderFeedDetailRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.g
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                        j.this.h(d16, str, baseRequest, z16, j3, str2, (FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp) obj);
                    }
                });
                return;
            }
            final QFSRankEdgeGetDetailsReq qFSRankEdgeGetDetailsReq = new QFSRankEdgeGetDetailsReq(d16);
            l(qFSRankEdgeGetDetailsReq);
            VSNetworkHelper.getInstance().sendRequest(qFSRankEdgeGetDetailsReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.h
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                    j.this.j(qFSRankEdgeGetDetailsReq, d16, baseRequest, z16, j3, str2, (FeedCloudRead$StBatchGetFeedDetailRsp) obj);
                }
            });
        }
    }
}
