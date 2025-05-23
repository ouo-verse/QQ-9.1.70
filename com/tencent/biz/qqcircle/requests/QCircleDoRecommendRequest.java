package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.aj;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudWrite$StDoPushReq;
import feedcloud.FeedCloudWrite$StDoPushRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoRecommendRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StDoPushReq mReq;
    private FeedCloudMeta$StFeed mStFeed;
    private int mUndoPushCount = 0;

    public QCircleDoRecommendRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, FeedCloudMeta$StPushList feedCloudMeta$StPushList, int i16, QCircleInitBean qCircleInitBean) {
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        FeedCloudWrite$StDoPushReq feedCloudWrite$StDoPushReq = new FeedCloudWrite$StDoPushReq();
        this.mReq = feedCloudWrite$StDoPushReq;
        feedCloudWrite$StDoPushReq.feed.set(QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed));
        this.mReq.comboCount.set(i3);
        if (feedCloudMeta$StPushList != null) {
            this.mReq.push.set(feedCloudMeta$StPushList);
        }
        this.mReq.pushType.set(i16);
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("doPushTimestamp");
        feedCloudCommon$Entry.value.set(String.valueOf(System.currentTimeMillis()));
        FeedCloudCommon$StCommonExt c16 = aj.c(qCircleInitBean);
        c16.mapInfo.add(feedCloudCommon$Entry);
        this.mReq.extInfo.set(c16);
        this.mStFeed = feedCloudMeta$StFeed;
        this.mReq.push_version.set(1);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoPush";
    }

    public FeedCloudWrite$StDoPushReq getReq() {
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

    public int getUndoPushCount() {
        return this.mUndoPushCount;
    }

    public void setPushVersion(int i3) {
        this.mReq.push_version.set(i3);
    }

    public void setReq(FeedCloudWrite$StDoPushReq feedCloudWrite$StDoPushReq) {
        this.mReq = feedCloudWrite$StDoPushReq;
    }

    public void setUndoPushCount(int i3) {
        this.mUndoPushCount = i3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudWrite$StDoPushRsp feedCloudWrite$StDoPushRsp = new FeedCloudWrite$StDoPushRsp();
        try {
            feedCloudWrite$StDoPushRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StDoPushRsp;
    }
}
