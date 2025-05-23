package com.tencent.biz.qqcircle.richframework.sender.iml;

import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.biz.qqcircle.richframework.outbox.e;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain>, RspInterceptor<QCircleBaseRequest, BaseSenderChain> {

    /* renamed from: a, reason: collision with root package name */
    private e f92004a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f92005b;

    public String a() {
        return "QCircleOutboxInterceptor";
    }

    @Override // com.tencent.richframework.sender.interceptor.ReqInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void interceptAddReq(QCircleBaseRequest qCircleBaseRequest, BaseSenderChain baseSenderChain) {
        QLog.d(a(), 1, "interceptAddReq reqCmd:" + qCircleBaseRequest.get$cmd());
        this.f92004a = new e(qCircleBaseRequest, baseSenderChain);
        if (!HostNetworkUtils.isNetworkAvailable()) {
            if (this.f92005b) {
                QCircleToast.h(R.string.ci8, 0);
            }
            QCircleOutboxTaskQueue.k().a(this.f92004a);
        } else {
            QCircleOutboxTaskQueue.k().b(this.f92004a);
        }
        baseSenderChain.addRequest(qCircleBaseRequest);
    }

    @Override // com.tencent.richframework.sender.interceptor.RspInterceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void interceptReturnRsp(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain) {
        QLog.d(a(), 1, "interceptReturnRsp result:" + z16 + ",retCode:" + j3 + ",errMsg:" + str);
        this.f92004a.setResultCode(j3);
        this.f92004a.setResultMsg(str);
        QCircleOutboxTaskQueue.k().d(this.f92004a, z16);
        baseSenderChain.handleRsp(z16, j3, str, qCircleBaseRequest, obj);
    }

    public void d(boolean z16) {
        this.f92005b = z16;
    }
}
