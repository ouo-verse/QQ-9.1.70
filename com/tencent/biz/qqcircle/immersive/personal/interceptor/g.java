package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.request.QFSDoUrgeRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor;
import com.tencent.richframework.sender.chain.BaseSenderChain;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends QCircleFakeInterceptor {
    public g() {
        super(true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void d(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain, Object obj2) {
        w wVar;
        if (qCircleBaseRequest instanceof QFSDoUrgeRequest) {
            QFSDoUrgeRequest qFSDoUrgeRequest = (QFSDoUrgeRequest) qCircleBaseRequest;
            MutableLiveData globalData = w20.a.j().getGlobalData(w.class, qFSDoUrgeRequest.getUin());
            if (globalData != null) {
                wVar = (w) globalData.getValue();
            } else {
                wVar = null;
            }
            if (wVar == null) {
                wVar = new w(qFSDoUrgeRequest.getUin());
            }
            wVar.Z(1);
            w20.a.j().initOrUpdateGlobalState((w20.a) wVar, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.richframework.sender.iml.QCircleFakeInterceptor
    public void e(QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain) {
        w wVar;
        if (qCircleBaseRequest instanceof QFSDoUrgeRequest) {
            QFSDoUrgeRequest qFSDoUrgeRequest = (QFSDoUrgeRequest) qCircleBaseRequest;
            MutableLiveData globalData = w20.a.j().getGlobalData(w.class, qFSDoUrgeRequest.getUin());
            if (globalData != null) {
                wVar = (w) globalData.getValue();
            } else {
                wVar = null;
            }
            if (wVar == null) {
                wVar = new w(qFSDoUrgeRequest.getUin());
            }
            wVar.Z(2);
            w20.a.j().initOrUpdateGlobalState((w20.a) wVar, true);
        }
    }
}
