package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudRead$GetPublishPageCommonInfoReq;
import feedcloud.FeedCloudRead$GetPublishPageCommonInfoRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkShoppingReq extends QCircleBaseRequest {
    public static final String CMD = "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetPublishPageCommonInfo";
    private final FeedCloudRead$GetPublishPageCommonInfoReq mRequest = new MessageMicro<FeedCloudRead$GetPublishPageCommonInfoReq>() { // from class: feedcloud.FeedCloudRead$GetPublishPageCommonInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, FeedCloudRead$GetPublishPageCommonInfoReq.class);
        public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    };

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return CMD;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$GetPublishPageCommonInfoRsp feedCloudRead$GetPublishPageCommonInfoRsp = new FeedCloudRead$GetPublishPageCommonInfoRsp();
        try {
            feedCloudRead$GetPublishPageCommonInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$GetPublishPageCommonInfoRsp;
    }
}
