package com.tencent.biz.qqcircle.richframework.sender.iml;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QCircleFakeInterceptor implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain>, RspInterceptor<QCircleBaseRequest, BaseSenderChain> {

    /* renamed from: a, reason: collision with root package name */
    private Object f91992a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f91993b;

    public QCircleFakeInterceptor(boolean z16, Object obj) {
        this.f91993b = z16;
        this.f91992a = obj;
    }

    @Override // com.tencent.richframework.sender.interceptor.ReqInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void interceptAddReq(final QCircleBaseRequest qCircleBaseRequest, final BaseSenderChain baseSenderChain) {
        if (this.f91993b) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    QCircleFakeInterceptor qCircleFakeInterceptor = QCircleFakeInterceptor.this;
                    qCircleFakeInterceptor.e(qCircleBaseRequest, qCircleFakeInterceptor.f91992a, baseSenderChain);
                }
            });
            baseSenderChain.callBackRsp(true, 0L, "", qCircleBaseRequest, this.f91992a);
        }
        baseSenderChain.addRequest(qCircleBaseRequest);
    }

    @Override // com.tencent.richframework.sender.interceptor.RspInterceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void interceptReturnRsp(boolean z16, long j3, String str, final QCircleBaseRequest qCircleBaseRequest, final Object obj, final BaseSenderChain baseSenderChain) {
        QLog.d("QCircleFakeInterceptor", 1, "interceptReturnRsp retCode:" + j3 + " | errorMsg:" + str + " | isSuccess: " + z16 + " | mEnableFake: " + this.f91993b);
        baseSenderChain.handleRsp(z16, j3, str, qCircleBaseRequest, obj);
        if (this.f91993b && j3 != 0) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor.2
                @Override // java.lang.Runnable
                public void run() {
                    QCircleFakeInterceptor qCircleFakeInterceptor = QCircleFakeInterceptor.this;
                    qCircleFakeInterceptor.d(qCircleBaseRequest, obj, baseSenderChain, qCircleFakeInterceptor.f91992a);
                }
            });
            baseSenderChain.callBackRsp(false, j3, "", qCircleBaseRequest, this.f91992a);
        }
    }

    public abstract void d(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain, Object obj2);

    public abstract void e(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain);
}
