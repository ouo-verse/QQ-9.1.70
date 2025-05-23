package com.tencent.biz.qqcircle.preload.task;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StGetBusiInfoReq;
import feedcloud.FeedCloudRead$StGetBusiInfoRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    FeedCloudMeta$StGPSV2 f91612a;

    /* renamed from: b, reason: collision with root package name */
    QCircleFolderBean f91613b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetBusiInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91614a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f91614a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetBusiInfoRsp feedCloudRead$StGetBusiInfoRsp) {
            QLog.d("QCircleFolderPreLoaderTask", 1, "QCircleFolderPreLoaderTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f91614a;
            if (onPreLoadListener != null && feedCloudRead$StGetBusiInfoRsp != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetBusiInfoRsp.toByteArray());
            }
            com.tencent.a.a("QCircleFolderPreLoaderTask", "preload tab");
        }
    }

    public c(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, QCircleFolderBean qCircleFolderBean) {
        this.f91612a = feedCloudMeta$StGPSV2;
        this.f91613b = qCircleFolderBean;
    }

    private void a(QCircleGetTabListRequest qCircleGetTabListRequest) {
        FeedCloudRead$StGetBusiInfoReq feedCloudRead$StGetBusiInfoReq;
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt;
        if (qCircleGetTabListRequest != null && (feedCloudRead$StGetBusiInfoReq = qCircleGetTabListRequest.mReq) != null && (feedCloudCommon$StCommonExt = feedCloudRead$StGetBusiInfoReq.extInfo) != null) {
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt2 = feedCloudCommon$StCommonExt.get();
            List<FeedCloudCommon$BytesEntry> list = qCircleGetTabListRequest.mReq.extInfo.mapBytesInfo.get();
            List<FeedCloudCommon$Entry> list2 = qCircleGetTabListRequest.mReq.extInfo.mapInfo.get();
            String inviteId = QCircleReportHelper.getInstance().getInviteId();
            if (!TextUtils.isEmpty(inviteId)) {
                byte[] bytes = inviteId.getBytes();
                if (bytes != null) {
                    FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
                    feedCloudCommon$BytesEntry.key.set(QCircleReportHelper.MAP_KEY_CIRCLE_INVITE_ID);
                    feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(bytes));
                    list.add(feedCloudCommon$BytesEntry);
                }
                feedCloudCommon$StCommonExt2.mapBytesInfo.set(list);
            }
            list2.add(QCircleReportFirstLogin.getFirstLoginEntry());
            feedCloudCommon$StCommonExt2.mapInfo.set(list2);
            qCircleGetTabListRequest.mReq.extInfo.set(feedCloudCommon$StCommonExt2);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        com.tencent.a.e("QCircleFolderPreLoaderTask");
        QCircleGetTabListRequest qCircleGetTabListRequest = new QCircleGetTabListRequest(this.f91612a, this.f91613b);
        a aVar = new a(onPreLoadListener);
        a(qCircleGetTabListRequest);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetTabListRequest, aVar);
        QLog.d("QCircleFolderPreLoaderTask", 1, "QCircleFolderPreLoaderTask->sendQCircleRequest: CmdName:" + qCircleGetTabListRequest.get$cmd() + "| TraceId:" + qCircleGetTabListRequest.getTraceId() + " | SeqId:" + qCircleGetTabListRequest.getCurrentSeq());
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
