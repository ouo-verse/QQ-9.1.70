package com.tencent.mobileqq.wink.publish.fs.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudRead$StGetPublishPageRecomTagListReq;
import feedcloud.FeedCloudRead$StGetPublishPageRecomTagListRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FSGetAssociateTagRequest extends QCircleBaseRequest {
    public static final String TAG = "QCircleGetAssociateTagRequest";
    private FeedCloudRead$StGetPublishPageRecomTagListReq mReq;

    public FSGetAssociateTagRequest(String str, String str2) {
        FeedCloudRead$StGetPublishPageRecomTagListReq feedCloudRead$StGetPublishPageRecomTagListReq = new FeedCloudRead$StGetPublishPageRecomTagListReq();
        this.mReq = feedCloudRead$StGetPublishPageRecomTagListReq;
        if (str != null) {
            feedCloudRead$StGetPublishPageRecomTagListReq.attachInfo.set(str);
        }
        if (str2 != null) {
            this.mReq.word.set(str2);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetPublishPageRecomTagList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    public FeedCloudRead$StGetPublishPageRecomTagListReq getmReq() {
        return this.mReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetPublishPageRecomTagListRsp feedCloudRead$StGetPublishPageRecomTagListRsp = new FeedCloudRead$StGetPublishPageRecomTagListRsp();
        try {
            feedCloudRead$StGetPublishPageRecomTagListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetPublishPageRecomTagListRsp;
    }
}
