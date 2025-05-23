package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c implements RspInterceptor<QCircleBaseRequest, BaseSenderChain> {
    public String a() {
        return "QFSGetFeedListBusiDataRspInterceptor";
    }

    @Override // com.tencent.richframework.sender.interceptor.RspInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void interceptReturnRsp(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, BaseSenderChain baseSenderChain) {
        if (z16 && j3 == 0 && (obj instanceof FeedCloudRead$StGetFeedListRsp)) {
            FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj;
            if (!feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
                QLog.d(a(), 1, "!rsp.busiRspData.has()");
            } else {
                QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
                try {
                    qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (qQCircleFeedBase$StFeedListBusiRspData.has()) {
                    baseSenderChain.callBackRsp(z16, j3, str, qCircleBaseRequest, qQCircleFeedBase$StFeedListBusiRspData);
                }
            }
        }
        baseSenderChain.handleRsp(z16, j3, str, qCircleBaseRequest, obj);
    }
}
