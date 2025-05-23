package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$GetGuildListReq;
import feedcloud.FeedCloudRead$GetGuildListRsp;

/* loaded from: classes4.dex */
public class QFSPersonalGuildInfoRequest extends QCircleBaseRequest {
    public static final String TAG = "com.tencent.biz.qqcircle.immersive.personal.request.QFSPersonalGuildInfoRequest";
    private FeedCloudRead$GetGuildListReq mRequest = new FeedCloudRead$GetGuildListReq();

    public QFSPersonalGuildInfoRequest() {
        this.mRequest.extInfo.set(new FeedCloudCommon$StCommonExt());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetGuildList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$GetGuildListRsp feedCloudRead$GetGuildListRsp = new FeedCloudRead$GetGuildListRsp();
        try {
            feedCloudRead$GetGuildListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$GetGuildListRsp;
    }
}
