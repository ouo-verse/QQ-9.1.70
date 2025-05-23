package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetRecomUserListRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends a implements IQCircleReportSessionOperation {
    private String D;

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<UIStateData<FeedCloudRead$StGetFeedListRsp>> f92846m = new MutableLiveData<>();
    public MutableLiveData<FeedCloudRead$StGetRecomUserListRsp> C = new MutableLiveData<>();

    public e() {
        this.f92839i = QCircleReporterAgent.obtain(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(String str, BaseRequest baseRequest, boolean z16, long j3, String str2, FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
        QLog.d("PYMK-QCirclePersonalPymkViewModel", 1, "[fetchPersonalRecommendUser] isSuccess: ", Boolean.valueOf(z16), " retCode: ", Long.valueOf(j3), " errMsg: ", str2, " attachInfo:  ", str);
        if (z16 && j3 == 0 && feedCloudRead$StGetRecomUserListRsp != null) {
            this.C.setValue(feedCloudRead$StGetRecomUserListRsp);
        } else {
            QLog.d("PYMK-QCirclePersonalPymkViewModel", 1, "[fetchPersonalRecommendUser] response error!");
        }
    }

    public void M1(String str, final String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.D = str;
        }
        QCircleGetRecomUserListRequest qCircleGetRecomUserListRequest = new QCircleGetRecomUserListRequest(str2, 2, this.D);
        QLog.d("PYMK-QCirclePersonalPymkViewModel", 1, "[fetchPersonalRecommendUser] userId: ", this.D, " attachInfo:  ", str2);
        sendRequest(qCircleGetRecomUserListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.viewmodels.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str3, Object obj) {
                e.this.O1(str2, baseRequest, z16, j3, str3, (FeedCloudRead$StGetRecomUserListRsp) obj);
            }
        });
    }

    public String N1() {
        return this.D;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PYMK-QCirclePersonalPymkViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }
}
