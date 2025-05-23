package com.tencent.biz.qqcircle.immersive.gallery.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QFSGetFeedDetailRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import e30.b;
import e30.d;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGalleryDetailViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IQCircleReportSessionOperation {

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<b>>> f86481m = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void N1(boolean z16, long j3, String str, FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        if (z16 && feedCloudRead$StGetFeedDetailRsp != null && j3 == 0) {
            if (feedCloudRead$StGetFeedDetailRsp.extInfo.has()) {
                updateSession(feedCloudRead$StGetFeedDetailRsp.extInfo.get());
            }
            P1(feedCloudRead$StGetFeedDetailRsp);
            return;
        }
        this.f86481m.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(QFSGetFeedDetailRequest qFSGetFeedDetailRequest, BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        QLog.d("QFSGalleryDetailViewModel", 1, "requestSingleFeed onReceive: dispatch Success:" + z16 + " | cmd:" + qFSGetFeedDetailRequest.getCmd() + " | TraceId:" + qFSGetFeedDetailRequest.getTraceId() + " | SeqId:" + qFSGetFeedDetailRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isLoadMore: true");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryDetailViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                QFSGalleryDetailViewModel.this.N1(z16, j3, str, feedCloudRead$StGetFeedDetailRsp);
            }
        });
    }

    private void P1(FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        this.f86481m.postValue(UIStateData.obtainSuccess(false).setData(false, d.b(Collections.singletonList(feedCloudRead$StGetFeedDetailRsp.feed.get()))).setFinish(true));
    }

    public void Q1(QCircleInitBean qCircleInitBean) {
        this.f86481m.setValue(UIStateData.obtainLoading());
        final QFSGetFeedDetailRequest qFSGetFeedDetailRequest = new QFSGetFeedDetailRequest(qCircleInitBean.getFeed().f398449id.get(), false, 0, qCircleInitBean.getFeed(), qCircleInitBean);
        qFSGetFeedDetailRequest.mRequest.extInfo.set(getSession(true));
        sendRequest(qFSGetFeedDetailRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.gallery.viewmodel.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSGalleryDetailViewModel.this.O1(qFSGetFeedDetailRequest, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedDetailRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return null;
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    public MutableLiveData<UIStateData<List<b>>> j() {
        return this.f86481m;
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }
}
