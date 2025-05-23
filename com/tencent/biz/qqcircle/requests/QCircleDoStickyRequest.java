package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoTopReq;
import feedcloud.FeedCloudWrite$StDoTopRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoStickyRequest extends QCircleBaseRequest {
    public static final int OPER_TYPE_DO_CANCLE_TOP = 2;
    public static final int OPER_TYPE_DO_TOP = 1;
    private FeedCloudWrite$StDoTopReq mReq;

    public QCircleDoStickyRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        FeedCloudWrite$StDoTopReq feedCloudWrite$StDoTopReq = new FeedCloudWrite$StDoTopReq();
        this.mReq = feedCloudWrite$StDoTopReq;
        feedCloudWrite$StDoTopReq.feed.set(QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed));
        this.mReq.comment.set(QCirclePluginUtil.getSimpleComment(feedCloudMeta$StComment));
        this.mReq.topType.set(i3);
        if (feedCloudMeta$StComment != null) {
            this.mReq.comment.set(feedCloudMeta$StComment);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoTop";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudWrite$StDoTopRsp> messageMicro = new MessageMicro<FeedCloudWrite$StDoTopRsp>() { // from class: feedcloud.FeedCloudWrite$StDoTopRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, FeedCloudWrite$StDoTopRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
