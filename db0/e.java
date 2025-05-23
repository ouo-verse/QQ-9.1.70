package db0;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseSenderChain f393497a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QCircleBaseRequest f393498b;

        a(BaseSenderChain baseSenderChain, QCircleBaseRequest qCircleBaseRequest) {
            this.f393497a = baseSenderChain;
            this.f393498b = qCircleBaseRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            QLog.d(e.this.a(), 1, "requestCmd: " + baseRequest.get$cmd() + "traceId:" + baseRequest.getTraceId() + "isSuccess:" + z16 + " retCode:" + j3 + " errMsg:" + str);
            this.f393497a.handleRsp(z16, j3, str, this.f393498b, obj);
        }
    }

    public String a() {
        return "QCircleSenderReqInterceptor";
    }

    @Override // com.tencent.richframework.sender.interceptor.ReqInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void interceptAddReq(QCircleBaseRequest qCircleBaseRequest, BaseSenderChain baseSenderChain) {
        if (qCircleBaseRequest != null && baseSenderChain != null) {
            VSNetworkHelper.getInstance().sendRequest(QCircleApplication.APP, qCircleBaseRequest, new a(baseSenderChain, qCircleBaseRequest));
        }
    }
}
