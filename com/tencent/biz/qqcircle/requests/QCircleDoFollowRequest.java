package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.aj;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoFollowReq;
import feedcloud.FeedCloudWrite$StDoFollowRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoFollowRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StDoFollowReq mRequest;

    public QCircleDoFollowRequest(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
        this(feedCloudMeta$StUser, i3, null, false, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoFollow";
    }

    public FeedCloudWrite$StDoFollowReq getReq() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public QCircleDoFollowRequest(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, QCircleInitBean qCircleInitBean) {
        this(feedCloudMeta$StUser, i3, feedCloudCommon$StCommonExt, false, qCircleInitBean);
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

    public QCircleDoFollowRequest(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, boolean z16, QCircleInitBean qCircleInitBean) {
        FeedCloudWrite$StDoFollowReq feedCloudWrite$StDoFollowReq = new FeedCloudWrite$StDoFollowReq();
        this.mRequest = feedCloudWrite$StDoFollowReq;
        feedCloudWrite$StDoFollowReq.user.set(feedCloudMeta$StUser);
        this.mRequest.followType.set(i3);
        FeedCloudCommon$StCommonExt c16 = aj.c(qCircleInitBean);
        if (feedCloudCommon$StCommonExt != null) {
            this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
            this.mRequest.extInfo.mapInfo.addAll(c16.mapInfo.get());
        } else {
            this.mRequest.extInfo.set(c16);
        }
        this.mRequest.followMethod.set(z16 ? 1 : 0);
    }
}
