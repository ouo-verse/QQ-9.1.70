package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$LoadMoreFeedInfo;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import qqcircle.QQCircleFeedBase$StFavoritesFeedsPageReq;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetCollectBoxFeedListRequest extends QCircleBaseRequest {
    public static final int LIST_NUM = 12;
    public FeedCloudRead$StGetFeedListReq mRequest;

    public QFSGetCollectBoxFeedListRequest(long j3, boolean z16, boolean z17, String str, int i3) {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        this.mRequest = feedCloudRead$StGetFeedListReq;
        if (i3 == 0) {
            feedCloudRead$StGetFeedListReq.feedAttchInfo.set(str);
            FeedCloudRead$LoadMoreFeedInfo feedCloudRead$LoadMoreFeedInfo = new FeedCloudRead$LoadMoreFeedInfo();
            feedCloudRead$LoadMoreFeedInfo.load_more_type.set(0);
            this.mRequest.load_more_info.set(feedCloudRead$LoadMoreFeedInfo);
        } else if (i3 == 1) {
            FeedCloudRead$LoadMoreFeedInfo feedCloudRead$LoadMoreFeedInfo2 = new FeedCloudRead$LoadMoreFeedInfo();
            feedCloudRead$LoadMoreFeedInfo2.load_more_type.set(1);
            feedCloudRead$LoadMoreFeedInfo2.page_up_attach_info.set(str);
            this.mRequest.load_more_info.set(feedCloudRead$LoadMoreFeedInfo2);
        }
        this.mRequest.source.set(88);
        this.mRequest.listNum.set(12);
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        QQCircleFeedBase$StFavoritesFeedsPageReq qQCircleFeedBase$StFavoritesFeedsPageReq = new QQCircleFeedBase$StFavoritesFeedsPageReq();
        qQCircleFeedBase$StFavoritesFeedsPageReq.f429305id.set(j3);
        qQCircleFeedBase$StFavoritesFeedsPageReq.isAddFeedsPage.set(z16);
        qQCircleFeedBase$StFavoritesFeedsPageReq.isDraft.set(z17);
        qQCircleFeedBase$StFeedListBusiReqData.favoritesFeedsPage.set(qQCircleFeedBase$StFavoritesFeedsPageReq);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFavoritesFeedsPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getType() {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = this.mRequest;
        if (feedCloudRead$StGetFeedListReq != null) {
            return String.valueOf(feedCloudRead$StGetFeedListReq.source.get());
        }
        return super.getType();
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
