package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private QCirclePolymerizationBean f91623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91624a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f91624a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            QLog.d("QCirclePolymerizationPreLoaderTask", 1, "QCirclePolymerizationPreLoaderTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f91624a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetFeedListRsp);
            }
        }
    }

    public f(QCirclePolymerizationBean qCirclePolymerizationBean) {
        this.f91623a = qCirclePolymerizationBean;
    }

    private void a(OnPreLoadListener onPreLoadListener) {
        b(new QCircleGetFeedListRequest(this.f91623a, (String) null, (String) null), onPreLoadListener);
    }

    private void b(QCircleGetFeedListRequest qCircleGetFeedListRequest, OnPreLoadListener onPreLoadListener) {
        a aVar = new a(onPreLoadListener);
        qCircleGetFeedListRequest.setEnableCache(true);
        qCircleGetFeedListRequest.mRequest.extInfo.setHasFlag(true);
        qCircleGetFeedListRequest.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
        VSNetworkHelper.getInstance().sendRequest(qCircleGetFeedListRequest, aVar);
        QLog.d("QCirclePolymerizationPreLoaderTask", 1, "QCirclePolymerizationPreLoaderTask->sendQCircleRequest: CmdName:" + qCircleGetFeedListRequest.get$cmd() + "| TraceId:" + qCircleGetFeedListRequest.getTraceId() + " | SeqId:" + qCircleGetFeedListRequest.getCurrentSeq() + " | extInfo:" + qCircleGetFeedListRequest.mRequest.extInfo.mapInfo.get(0).key.get() + MsgSummary.STR_COLON + qCircleGetFeedListRequest.mRequest.extInfo.mapInfo.get(0).value.get());
    }

    private void c(OnPreLoadListener onPreLoadListener) {
        if (this.f91623a.getSelectedTabType() == -1) {
            this.f91623a.setTagTabType(0);
        }
        b(new QCircleGetFeedListRequest(this.f91623a, (String) null, (String) null), onPreLoadListener);
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        QCirclePolymerizationBean qCirclePolymerizationBean = this.f91623a;
        if (qCirclePolymerizationBean == null) {
            return;
        }
        if (qCirclePolymerizationBean.getPolymerizationType() == 7) {
            c(onPreLoadListener);
        } else {
            a(onPreLoadListener);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
