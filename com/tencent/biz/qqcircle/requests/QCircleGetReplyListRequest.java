package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetReplyListReq;
import feedcloud.FeedCloudRead$StGetReplyListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetReplyListRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetReplyListReq req;

    public QCircleGetReplyListRequest(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull FeedCloudMeta$StComment feedCloudMeta$StComment, @NonNull String str) {
        FeedCloudRead$StGetReplyListReq feedCloudRead$StGetReplyListReq = new FeedCloudRead$StGetReplyListReq();
        this.req = feedCloudRead$StGetReplyListReq;
        feedCloudRead$StGetReplyListReq.feedUserId.set(feedCloudMeta$StFeed.poster.f398463id.get());
        this.req.feedId.set(feedCloudMeta$StFeed.f398449id.get());
        this.req.commentID.set(feedCloudMeta$StComment.f398447id.get());
        this.req.attchInfo.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetReplyList";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) a.b("comment_reply").second;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getRefer() {
        FeedCloudRead$StGetReplyListReq feedCloudRead$StGetReplyListReq = this.req;
        if (feedCloudRead$StGetReplyListReq != null && !TextUtils.isEmpty(feedCloudRead$StGetReplyListReq.attchInfo.get())) {
            return "0";
        }
        return "1";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) a.b("comment_reply").first;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetReplyListRsp feedCloudRead$StGetReplyListRsp = new FeedCloudRead$StGetReplyListRsp();
        try {
            feedCloudRead$StGetReplyListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetReplyListRsp;
    }
}
