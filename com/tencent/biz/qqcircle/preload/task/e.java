package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudRead$StGetMainPageRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private String f91619a;

    /* renamed from: b, reason: collision with root package name */
    private QCircleInitBean f91620b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetMainPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91621a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f91621a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetMainPageRsp feedCloudRead$StGetMainPageRsp) {
            QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f91621a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetMainPageRsp);
            }
        }
    }

    public e(String str, QCircleInitBean qCircleInitBean) {
        this.f91619a = str;
        this.f91620b = qCircleInitBean;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        QCircleGetMainPageRequest qCircleGetMainPageRequest = new QCircleGetMainPageRequest(this.f91619a, null, this.f91620b);
        qCircleGetMainPageRequest.mRequest.extInfo.setHasFlag(true);
        qCircleGetMainPageRequest.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
        a aVar = new a(onPreLoadListener);
        qCircleGetMainPageRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetMainPageRequest, aVar);
        QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->sendQCircleRequest: CmdName:" + qCircleGetMainPageRequest.get$cmd() + "| TraceId:" + qCircleGetMainPageRequest.getTraceId() + " | SeqId:" + qCircleGetMainPageRequest.getCurrentSeq());
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
