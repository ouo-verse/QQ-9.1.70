package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.aj;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoCommentReq;
import feedcloud.FeedCloudWrite$StDoCommentRsp;
import va0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoCommentRequest extends QCircleBaseRequest {
    public static final int OPER_TYPE_ADD = 1;
    public static final int OPER_TYPE_DELETE = 0;
    public static final int OPER_TYPE_OWNER_DELETE = 2;
    private FeedCloudMeta$StFeed mStFeed;
    FeedCloudWrite$StDoCommentReq req;

    public QCircleDoCommentRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3, boolean z16, QCircleInitBean qCircleInitBean) {
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        FeedCloudWrite$StDoCommentReq feedCloudWrite$StDoCommentReq = new FeedCloudWrite$StDoCommentReq();
        this.req = feedCloudWrite$StDoCommentReq;
        feedCloudWrite$StDoCommentReq.feed.setHasFlag(true);
        this.req.feed.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
        this.req.feed.poster.setHasFlag(true);
        this.req.feed.poster.f398463id.set(feedCloudMeta$StFeed.poster.f398463id.get());
        this.req.feed.createTime.set(feedCloudMeta$StFeed.createTime.get());
        this.req.feed.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
        this.req.comment.set(feedCloudMeta$StComment);
        this.req.comment.vecReply.clear();
        this.req.comment.postUser.clear();
        this.req.comment.postUser.setHasFlag(true);
        this.req.comment.postUser.f398463id.set(feedCloudMeta$StComment.postUser.f398463id.get());
        this.req.commentType.set(i3);
        this.req.from.set(0);
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("ext_source");
        if (z16) {
            feedCloudCommon$Entry.value.set("2");
        } else {
            feedCloudCommon$Entry.value.set("1");
        }
        FeedCloudCommon$StCommonExt c16 = aj.c(qCircleInitBean);
        c16.mapInfo.add(feedCloudCommon$Entry);
        this.req.extInfo.set(c16);
        this.mStFeed = feedCloudMeta$StFeed;
        addRequestInterceptor(new b());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoComment";
    }

    public FeedCloudWrite$StDoCommentReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudWrite$StDoCommentRsp feedCloudWrite$StDoCommentRsp = new FeedCloudWrite$StDoCommentRsp();
        try {
            feedCloudWrite$StDoCommentRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StDoCommentRsp;
    }
}
