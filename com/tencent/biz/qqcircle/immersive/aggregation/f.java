package com.tencent.biz.qqcircle.immersive.aggregation;

import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetFeedListMusicRequest;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetFeedListUnifiedTagRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private QFSFlowAggregationInitBean f84767a;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f84768a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f84768a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.d("QFSMusicAggregationPreLoaderTask", 1, "QFSMusicAggregationPreLoaderTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f84768a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetFeedListRsp);
            }
        }
    }

    public f(QFSFlowAggregationInitBean qFSFlowAggregationInitBean) {
        this.f84767a = qFSFlowAggregationInitBean;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        BaseRequest qFSGetFeedListMusicRequest;
        QFSFlowAggregationInitBean qFSFlowAggregationInitBean = this.f84767a;
        if (qFSFlowAggregationInitBean == null) {
            return;
        }
        int aggregationType = qFSFlowAggregationInitBean.getAggregationType();
        if (aggregationType != 43) {
            if (aggregationType != 44) {
                return;
            } else {
                qFSGetFeedListMusicRequest = new QFSGetFeedListUnifiedTagRequest(this.f84767a, null, null);
            }
        } else {
            qFSGetFeedListMusicRequest = new QFSGetFeedListMusicRequest(this.f84767a, null, null);
        }
        a aVar = new a(onPreLoadListener);
        qFSGetFeedListMusicRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(qFSGetFeedListMusicRequest, aVar);
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
