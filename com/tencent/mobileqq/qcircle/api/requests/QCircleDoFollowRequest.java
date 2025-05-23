package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoFollowReq;
import feedcloud.FeedCloudWrite$StDoFollowRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleDoFollowRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StDoFollowReq mRequest;

    public QCircleDoFollowRequest(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        this(feedCloudMeta$StUser, i3, feedCloudCommon$StCommonExt, false);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoFollow";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    public QCircleDoFollowRequest(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, boolean z16) {
        FeedCloudWrite$StDoFollowReq feedCloudWrite$StDoFollowReq = new FeedCloudWrite$StDoFollowReq();
        this.mRequest = feedCloudWrite$StDoFollowReq;
        feedCloudWrite$StDoFollowReq.user.set(feedCloudMeta$StUser);
        this.mRequest.followType.set(i3);
        if (feedCloudCommon$StCommonExt != null) {
            this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
        }
        this.mRequest.followMethod.set(z16 ? 1 : 0);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudWrite$StDoFollowRsp feedCloudWrite$StDoFollowRsp = new FeedCloudWrite$StDoFollowRsp();
        try {
            feedCloudWrite$StDoFollowRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StDoFollowRsp;
    }
}
