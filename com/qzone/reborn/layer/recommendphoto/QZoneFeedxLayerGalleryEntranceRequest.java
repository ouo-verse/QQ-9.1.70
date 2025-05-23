package com.qzone.reborn.layer.recommendphoto;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxLayerGalleryEntranceRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetFeedListReq mRequest;

    public QZoneFeedxLayerGalleryEntranceRequest() {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        this.mRequest = feedCloudRead$StGetFeedListReq;
        feedCloudRead$StGetFeedListReq.source.set(87);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader_feeds.ComReaderFeeds.GetQzoneEmptyPageGalleryFeeds";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }
}
