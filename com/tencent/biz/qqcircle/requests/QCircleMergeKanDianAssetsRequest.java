package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudWrite$StMergeQQKandianAssetsReq;
import feedcloud.FeedCloudWrite$StMergeQQKandianAssetsRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleMergeKanDianAssetsRequest extends QCircleBaseRequest {
    private final FeedCloudWrite$StMergeQQKandianAssetsReq mRequest;

    public QCircleMergeKanDianAssetsRequest(int i3, int i16) {
        FeedCloudWrite$StMergeQQKandianAssetsReq feedCloudWrite$StMergeQQKandianAssetsReq = new FeedCloudWrite$StMergeQQKandianAssetsReq();
        this.mRequest = feedCloudWrite$StMergeQQKandianAssetsReq;
        feedCloudWrite$StMergeQQKandianAssetsReq.profileAuthorize.set(i3);
        feedCloudWrite$StMergeQQKandianAssetsReq.feedsAuthorize.set(i16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.MergeQQKandianAssets";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudWrite$StMergeQQKandianAssetsRsp, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudWrite$StMergeQQKandianAssetsRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudWrite$StMergeQQKandianAssetsRsp>() { // from class: feedcloud.FeedCloudWrite$StMergeQQKandianAssetsRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, FeedCloudWrite$StMergeQQKandianAssetsRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
