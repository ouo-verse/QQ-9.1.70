package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.requests.QCircleGetMyPendantBannerRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import qqcircle.QQCirclePendant$GetMyPendantBannerRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private final String f91616a;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QQCirclePendant$GetMyPendantBannerRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91617a;

        a(OnPreLoadListener onPreLoadListener) {
            this.f91617a = onPreLoadListener;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCirclePendant$GetMyPendantBannerRsp qQCirclePendant$GetMyPendantBannerRsp) {
            QLog.d("QCircleGetMyPendantBannerPreLoaderTask", 1, "QCircleGetMyPendantBannerPreLoaderTask->onReceive: dispatch Success:" + z16 + " |CmdName:" + baseRequest.get$cmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + baseRequest.isEnableCache());
            OnPreLoadListener onPreLoadListener = this.f91617a;
            if (onPreLoadListener != null) {
                onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, qQCirclePendant$GetMyPendantBannerRsp);
            }
        }
    }

    public d(String str) {
        this.f91616a = str;
    }

    public static String a(String str) {
        return QCircleCommonUtil.getCurrentAccount() + "_" + str;
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        QCircleGetMyPendantBannerRequest qCircleGetMyPendantBannerRequest = new QCircleGetMyPendantBannerRequest(this.f91616a);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetMyPendantBannerRequest, new a(onPreLoadListener));
        QLog.d("QCircleGetMyPendantBannerPreLoaderTask", 1, "QCircleGetMyPendantBannerPreLoaderTask->sendQCircleRequest: CmdName:" + qCircleGetMyPendantBannerRequest.get$cmd() + "  TraceId:" + qCircleGetMyPendantBannerRequest.getTraceId() + " | SeqId:" + qCircleGetMyPendantBannerRequest.getCurrentSeq());
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
