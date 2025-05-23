package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetGoodsDetailReq;
import feedcloud.FeedCloudRead$StGetGoodsDetailRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleShoppingInfoGetRequest extends QCircleBaseRequest {
    private final FeedCloudRead$StGetGoodsDetailReq mRequest;

    public QCircleShoppingInfoGetRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudRead$StGetGoodsDetailReq feedCloudRead$StGetGoodsDetailReq = new FeedCloudRead$StGetGoodsDetailReq();
        this.mRequest = feedCloudRead$StGetGoodsDetailReq;
        if (feedCloudMeta$StFeed != null) {
            feedCloudRead$StGetGoodsDetailReq.from.set(0);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed2.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
            feedCloudMeta$StFeed2.poster.set(feedCloudMeta$StFeed.poster.get());
            feedCloudMeta$StFeed2.createTime.set(feedCloudMeta$StFeed.createTime.get());
            feedCloudMeta$StFeed2.eShopGoods.set(feedCloudMeta$StFeed.eShopGoods.get());
            feedCloudMeta$StFeed2.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
            feedCloudRead$StGetGoodsDetailReq.entryFeed.set(feedCloudMeta$StFeed2);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetGoodsDetail";
    }

    public FeedCloudRead$StGetGoodsDetailReq getRequest() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetGoodsDetailRsp feedCloudRead$StGetGoodsDetailRsp = new FeedCloudRead$StGetGoodsDetailRsp();
        try {
            feedCloudRead$StGetGoodsDetailRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetGoodsDetailRsp;
    }
}
