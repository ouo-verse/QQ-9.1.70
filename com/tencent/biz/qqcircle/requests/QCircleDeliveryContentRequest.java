package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StDeliveryContentReq;
import feedcloud.FeedCloudMeta$StDeliveryContentResp;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDeliveryContentRequest extends QCircleBaseRequest {
    private FeedCloudMeta$StDeliveryContentReq mRequest;

    public QCircleDeliveryContentRequest(int i3, int i16, long j3) {
        FeedCloudMeta$StDeliveryContentReq feedCloudMeta$StDeliveryContentReq = new FeedCloudMeta$StDeliveryContentReq();
        this.mRequest = feedCloudMeta$StDeliveryContentReq;
        feedCloudMeta$StDeliveryContentReq.taskID.set(i3);
        this.mRequest.SingleFeedExposure.set(i16);
        this.mRequest.ContentID.set(Arrays.asList(Long.valueOf(j3)));
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.mRequest.StartTime.set(currentTimeMillis);
        this.mRequest.EndTime.set(86400 + currentTimeMillis);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.yuhengservice.yuheng_task_svr.YuhengTaskSvr.DeliveryContent";
    }

    public FeedCloudMeta$StDeliveryContentReq getReq() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudMeta$StDeliveryContentResp> messageMicro = new MessageMicro<FeedCloudMeta$StDeliveryContentResp>() { // from class: feedcloud.FeedCloudMeta$StDeliveryContentResp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudMeta$StDeliveryContentResp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
