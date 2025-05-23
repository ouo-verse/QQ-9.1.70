package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase$StTagChallengePageReq;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetFeedListTagChallengeRequest extends QCircleBaseRequest {
    public static final int LIST_NUM = 10;
    public FeedCloudRead$StGetFeedListReq mRequest;
    public QCircleTagChallengeInfo mTagChallengeInfo;

    public QCircleGetFeedListTagChallengeRequest(QCircleLayerBean qCircleLayerBean, String str) {
        this(qCircleLayerBean, str, 10);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListTagChallenge";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public QCircleGetFeedListTagChallengeRequest(QCircleLayerBean qCircleLayerBean, String str, int i3) {
        this.mRequest = new FeedCloudRead$StGetFeedListReq();
        if (qCircleLayerBean == null || qCircleLayerBean.getTagChallengeInfo() == null) {
            return;
        }
        FeedCloudMeta$StFeed simpleFeed = QCirclePluginUtil.getSimpleFeed(qCircleLayerBean.getFeed());
        if (str == null) {
            this.mRequest.feed.set(simpleFeed);
            this.mRequest.feed.busiTranparent.set(qCircleLayerBean.getFeed().busiTranparent.get());
        } else {
            this.mRequest.feedAttchInfo.set(str);
        }
        this.mRequest.source.set(54);
        this.mRequest.listNum.set(i3);
        QQCircleFeedBase$StFeedListBusiReqData feedListBusiReq = qCircleLayerBean.getFeedListBusiReq();
        QQCircleFeedBase$StTagChallengePageReq qQCircleFeedBase$StTagChallengePageReq = new QQCircleFeedBase$StTagChallengePageReq();
        QCircleTagChallengeInfo tagChallengeInfo = qCircleLayerBean.getTagChallengeInfo();
        this.mTagChallengeInfo = tagChallengeInfo;
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagId.set(tagChallengeInfo.mTagId);
        qQCircleFeedBase$StTagChallengePageReq.reqTagInfo.set(feedCloudMeta$StTagInfo);
        feedListBusiReq.tagChallengePageReq.set(qQCircleFeedBase$StTagChallengePageReq);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(feedListBusiReq.toByteArray()));
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudRead$StGetFeedListRsp decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }
}
