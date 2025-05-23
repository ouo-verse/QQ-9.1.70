package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h implements ReqInterceptor<QCircleBaseRequest, BaseSenderChain>, OnTaskListener<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final String f88718a;

    /* renamed from: b, reason: collision with root package name */
    private QCircleBaseRequest f88719b;

    /* renamed from: c, reason: collision with root package name */
    private BaseSenderChain f88720c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f88721d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends BasePreLoadTask<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleBaseRequest f88722a;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.personal.interceptor.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0898a implements VSDispatchObserver.OnVSRspCallBack<Object> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ OnPreLoadListener f88724a;

            C0898a(OnPreLoadListener onPreLoadListener) {
                this.f88724a = onPreLoadListener;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QLog.d(h.this.b(), 1, "requestCmd: " + baseRequest.get$cmd() + "traceId:" + baseRequest.getTraceId() + "isSuccess:" + z16 + " retCode:" + j3 + " errMsg:" + str);
                this.f88724a.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
            }
        }

        a(QCircleBaseRequest qCircleBaseRequest) {
            this.f88722a = qCircleBaseRequest;
        }

        @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
        public void onRemove() {
            QLog.d(h.this.b(), 1, "onRemove key = " + h.this.f88718a);
        }

        @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
        public void startLoadData(OnPreLoadListener<Object> onPreLoadListener) {
            VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), this.f88722a, new C0898a(onPreLoadListener));
        }
    }

    public h(String str, boolean z16) {
        this.f88718a = str;
        this.f88721d = z16;
    }

    public String b() {
        return "QFSPreloadReqInterceptor";
    }

    @Override // com.tencent.richframework.sender.interceptor.ReqInterceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void interceptAddReq(QCircleBaseRequest qCircleBaseRequest, BaseSenderChain baseSenderChain) {
        if (TextUtils.isEmpty(this.f88718a)) {
            baseSenderChain.addRequest(qCircleBaseRequest);
            return;
        }
        this.f88719b = qCircleBaseRequest;
        this.f88720c = baseSenderChain;
        if (this.f88721d) {
            PreLoader.preLoad(this.f88718a, new a(qCircleBaseRequest));
            if (com.tencent.biz.qqcircle.f.j()) {
                PreLoader.addListener(this.f88718a, this);
                return;
            }
            return;
        }
        if (PreLoader.exists(this.f88718a)) {
            PreLoader.addListener(this.f88718a, this);
        } else {
            baseSenderChain.addRequest(qCircleBaseRequest);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
    public void onComplete(Object... objArr) {
        if (this.f88720c != null && this.f88719b != null) {
            try {
                this.f88720c.handleRsp(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], this.f88719b, objArr[3]);
            } catch (Exception e16) {
                QLog.e(b(), 1, e16.getMessage());
            }
        }
    }
}
