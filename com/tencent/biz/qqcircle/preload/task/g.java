package com.tencent.biz.qqcircle.preload.task;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private QCircleInitBean f91626a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f91627b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91628a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f91628a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.d("QCircleTagPreLoaderTask", 1, "QCircleTagPreLoaderTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f91628a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetFeedListRsp);
            }
        }
    }

    public g(QCircleInitBean qCircleInitBean, boolean z16) {
        this.f91626a = qCircleInitBean;
        this.f91627b = z16;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        QCircleInitBean qCircleInitBean = this.f91626a;
        if (qCircleInitBean != null && qCircleInitBean.getTagInfo() != null) {
            if (!TextUtils.isEmpty(this.f91626a.getTagInfo().tagId.get()) || !TextUtils.isEmpty(this.f91626a.getTagInfo().tagName.get())) {
                QCircleGetFeedListRequest qCircleGetFeedListRequest = new QCircleGetFeedListRequest(this.f91626a.getTagInfo().tagId.get(), this.f91626a.getTagInfo().tagName.get(), this.f91627b, null, null);
                a aVar = new a(onPreLoadListener);
                if (this.f91627b) {
                    qCircleGetFeedListRequest.setEnableCache(false);
                } else {
                    qCircleGetFeedListRequest.setEnableCache(true);
                }
                VSNetworkHelper.getInstance().sendRequest(qCircleGetFeedListRequest, aVar);
                QLog.d("QCircleTagPreLoaderTask", 1, "QCircleTagPreLoaderTask->sendQCircleRequest: CmdName:" + qCircleGetFeedListRequest.get$cmd() + "| TraceId:" + qCircleGetFeedListRequest.getTraceId() + " | SeqId:" + qCircleGetFeedListRequest.getCurrentSeq());
            }
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
