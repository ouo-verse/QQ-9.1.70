package com.tencent.biz.qqcircle.requests;

import feedcloud.BatchGetFeedFeatureReq;
import feedcloud.BatchGetFeedFeatureRsp;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedEntity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleBatchGetFeedFeatureRequest extends QCircleBaseRequest {
    private List<FeedEntity> mFeedEntity = new ArrayList();

    public QCircleBatchGetFeedFeatureRequest(List<FeedCloudMeta$StFeed> list) {
        String str;
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
            if (feedCloudMeta$StFeed != null) {
                FeedEntity.a aVar = new FeedEntity.a();
                FeedEntity.a d16 = aVar.d(feedCloudMeta$StFeed.f398449id.get());
                FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
                if (feedCloudMeta$StUser != null) {
                    str = feedCloudMeta$StUser.f398463id.get();
                } else {
                    str = null;
                }
                d16.a(str).c(feedCloudMeta$StFeed.createTime.get());
                this.mFeedEntity.add(aVar.build());
            }
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.client_debug.ClientDebug.BatchGetFeedFeature";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return new BatchGetFeedFeatureReq.a().b(this.mFeedEntity).build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public BatchGetFeedFeatureRsp decode(byte[] bArr) {
        try {
            return BatchGetFeedFeatureRsp.ADAPTER.decode(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return new BatchGetFeedFeatureRsp.a().build();
        }
    }
}
