package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$Result;
import feedcloud.FeedCloudCommon$StCommonExt;
import qqcircle.QQCircleFeedbackhit$StFeedbackCommonInfo;
import qqcircle.QQCircleFeedbackhit$StSetFeedbackHitReq;
import qqcircle.QQCircleFeedbackhit$StSetFeedbackHitRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleFeedbackHitRequest extends QCircleBaseRequest {
    private QQCircleFeedbackhit$StSetFeedbackHitReq mRequest;

    public QCircleFeedbackHitRequest(QQCircleFeedbackhit$StFeedbackCommonInfo qQCircleFeedbackhit$StFeedbackCommonInfo, int i3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QQCircleFeedbackhit$StSetFeedbackHitReq qQCircleFeedbackhit$StSetFeedbackHitReq = new QQCircleFeedbackhit$StSetFeedbackHitReq();
        this.mRequest = qQCircleFeedbackhit$StSetFeedbackHitReq;
        qQCircleFeedbackhit$StSetFeedbackHitReq.feedbackInfo.set(qQCircleFeedbackhit$StFeedbackCommonInfo);
        if (feedCloudCommon$StCommonExt != null) {
            this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
        }
        this.mRequest.type.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.feedbackHit.FeedbackHit.SetFeedbackHit";
    }

    public QQCircleFeedbackhit$StSetFeedbackHitReq getReq() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleFeedbackhit$StSetFeedbackHitRsp> messageMicro = new MessageMicro<QQCircleFeedbackhit$StSetFeedbackHitRsp>() { // from class: qqcircle.QQCircleFeedbackhit$StSetFeedbackHitRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "result"}, new Object[]{null, null}, QQCircleFeedbackhit$StSetFeedbackHitRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
            public FeedCloudCommon$Result result = new FeedCloudCommon$Result();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
