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
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudWrite$StDoReplyReq;
import feedcloud.FeedCloudWrite$StDoReplyRsp;
import va0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoReplyRequest extends QCircleBaseRequest {
    public static final int OPER_TYPE_ADD = 1;
    public static final int OPER_TYPE_DELETE = 0;
    public static final int OPER_TYPE_OWNER_DELETE = 2;
    private FeedCloudMeta$StFeed mStFeed;
    FeedCloudWrite$StDoReplyReq req;

    public QCircleDoReplyRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i3, boolean z16, QCircleInitBean qCircleInitBean) {
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        FeedCloudWrite$StDoReplyReq feedCloudWrite$StDoReplyReq = new FeedCloudWrite$StDoReplyReq();
        this.req = feedCloudWrite$StDoReplyReq;
        feedCloudWrite$StDoReplyReq.feed.setHasFlag(true);
        this.req.feed.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
        this.req.feed.poster.f398463id.set(feedCloudMeta$StFeed.poster.f398463id.get());
        this.req.feed.poster.setHasFlag(true);
        this.req.feed.createTime.set(feedCloudMeta$StFeed.createTime.get());
        this.req.feed.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
        this.req.comment.f398447id.set(feedCloudMeta$StComment.f398447id.get());
        this.req.comment.postUser.f398463id.set(feedCloudMeta$StComment.postUser.f398463id.get());
        this.req.comment.postUser.setHasFlag(true);
        this.req.comment.setHasFlag(true);
        this.req.reply.set(feedCloudMeta$StReply);
        this.req.reply.postUser.clear();
        this.req.reply.postUser.f398463id.set(feedCloudMeta$StReply.postUser.f398463id.get());
        this.req.reply.postUser.setHasFlag(true);
        this.req.from.set(0);
        this.req.replyType.set(i3);
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
        addRequestInterceptor(new d());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReply";
    }

    public FeedCloudWrite$StDoReplyReq getReq() {
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
        FeedCloudWrite$StDoReplyRsp feedCloudWrite$StDoReplyRsp = new FeedCloudWrite$StDoReplyRsp();
        try {
            feedCloudWrite$StDoReplyRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StDoReplyRsp;
    }
}
