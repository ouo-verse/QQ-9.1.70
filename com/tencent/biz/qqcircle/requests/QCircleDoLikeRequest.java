package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.aj;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudWrite$StDoLikeReq;
import feedcloud.FeedCloudWrite$StDoLikeRsp;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData;
import va0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoLikeRequest extends QCircleBaseRequest {
    private boolean mIsPraise;
    private boolean mIsReward;
    private FeedCloudWrite$StDoLikeReq mReq;
    private FeedCloudMeta$StFeed mStFeed;

    public QCircleDoLikeRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, FeedCloudMeta$StLike feedCloudMeta$StLike, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, boolean z16, QCircleInitBean qCircleInitBean) {
        this.mIsReward = false;
        this.mIsPraise = false;
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        FeedCloudWrite$StDoLikeReq feedCloudWrite$StDoLikeReq = new FeedCloudWrite$StDoLikeReq();
        this.mReq = feedCloudWrite$StDoLikeReq;
        feedCloudWrite$StDoLikeReq.feed.set(QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed));
        this.mReq.likeType.set(i3);
        if (feedCloudMeta$StLike != null) {
            feedCloudMeta$StLike.vecUser.set(Arrays.asList(QCirclePluginGlobalInfo.m()));
            feedCloudMeta$StLike.postUser.set(QCirclePluginGlobalInfo.m());
            this.mReq.like.set(feedCloudMeta$StLike);
        }
        if (feedCloudMeta$StComment != null) {
            this.mReq.comment.set(feedCloudMeta$StComment);
        }
        if (feedCloudMeta$StReply != null) {
            this.mReq.reply.set(feedCloudMeta$StReply);
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("ext_source");
        if (z16) {
            feedCloudCommon$Entry.value.set("2");
        } else {
            feedCloudCommon$Entry.value.set("1");
        }
        FeedCloudCommon$StCommonExt c16 = aj.c(qCircleInitBean);
        c16.mapInfo.add(feedCloudCommon$Entry);
        this.mReq.extInfo.set(c16);
        this.mStFeed = feedCloudMeta$StFeed;
        addRequestInterceptor(new c());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        if (this.mIsReward) {
            return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReward";
        }
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoLike";
    }

    public FeedCloudWrite$StDoLikeReq getReq() {
        return this.mReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    public boolean isPraise() {
        return this.mIsPraise;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudWrite$StDoLikeRsp> messageMicro = new MessageMicro<FeedCloudWrite$StDoLikeRsp>() { // from class: feedcloud.FeedCloudWrite$StDoLikeRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "like", "busiRspData"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudWrite$StDoLikeRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
            public FeedCloudMeta$StLike like = new FeedCloudMeta$StLike();
            public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }

    public QCircleDoLikeRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, FeedCloudMeta$StLike feedCloudMeta$StLike, QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData, boolean z16, boolean z17, QCircleInitBean qCircleInitBean) {
        this.mIsReward = false;
        this.mIsPraise = false;
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        this.mIsReward = z17;
        FeedCloudWrite$StDoLikeReq feedCloudWrite$StDoLikeReq = new FeedCloudWrite$StDoLikeReq();
        this.mReq = feedCloudWrite$StDoLikeReq;
        feedCloudWrite$StDoLikeReq.feed.set(QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed));
        this.mReq.feed.cover.set(feedCloudMeta$StFeed.cover.get());
        this.mReq.feed.images.set(feedCloudMeta$StFeed.images.get());
        this.mReq.likeType.set(i3);
        if (feedCloudMeta$StLike != null) {
            feedCloudMeta$StLike.vecUser.set(Arrays.asList(QCirclePluginGlobalInfo.m()));
            feedCloudMeta$StLike.postUser.set(QCirclePluginGlobalInfo.m());
            this.mReq.like.set(feedCloudMeta$StLike);
        }
        if (qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData != null) {
            this.mReq.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData.toByteArray()));
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("ext_source");
        if (z16) {
            feedCloudCommon$Entry.value.set("2");
        } else {
            feedCloudCommon$Entry.value.set("1");
        }
        FeedCloudCommon$StCommonExt c16 = aj.c(qCircleInitBean);
        c16.mapInfo.add(feedCloudCommon$Entry);
        this.mReq.extInfo.set(c16);
        this.mStFeed = feedCloudMeta$StFeed;
        addRequestInterceptor(new c());
    }

    public QCircleDoLikeRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, FeedCloudMeta$StLike feedCloudMeta$StLike, QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData, boolean z16, boolean z17, boolean z18, QCircleInitBean qCircleInitBean) {
        this.mIsReward = false;
        this.mIsPraise = false;
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        this.mIsReward = z17;
        FeedCloudWrite$StDoLikeReq feedCloudWrite$StDoLikeReq = new FeedCloudWrite$StDoLikeReq();
        this.mReq = feedCloudWrite$StDoLikeReq;
        feedCloudWrite$StDoLikeReq.feed.set(QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed));
        this.mReq.feed.cover.set(feedCloudMeta$StFeed.cover.get());
        this.mReq.feed.images.set(feedCloudMeta$StFeed.images.get());
        this.mReq.likeType.set(i3);
        if (feedCloudMeta$StLike != null) {
            feedCloudMeta$StLike.vecUser.set(Arrays.asList(QCirclePluginGlobalInfo.m()));
            feedCloudMeta$StLike.postUser.set(QCirclePluginGlobalInfo.m());
            this.mReq.like.set(feedCloudMeta$StLike);
        }
        if (qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData != null) {
            this.mReq.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData.toByteArray()));
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("ext_source");
        if (z16) {
            feedCloudCommon$Entry.value.set("2");
        } else {
            feedCloudCommon$Entry.value.set("1");
        }
        FeedCloudCommon$StCommonExt c16 = aj.c(qCircleInitBean);
        c16.mapInfo.add(feedCloudCommon$Entry);
        this.mReq.extInfo.set(c16);
        this.mStFeed = feedCloudMeta$StFeed;
        this.mIsPraise = z18;
        addRequestInterceptor(new c());
    }
}
