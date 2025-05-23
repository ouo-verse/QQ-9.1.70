package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.comment.h;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudRead$GetAICommentsReq;
import feedcloud.FeedCloudRead$GetAICommentsRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSGetAiCommentsRequest extends QCircleBaseRequest {
    FeedCloudRead$GetAICommentsReq req;

    public QFSGetAiCommentsRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, String str) {
        int i3;
        FeedCloudRead$GetAICommentsReq feedCloudRead$GetAICommentsReq = new FeedCloudRead$GetAICommentsReq();
        this.req = feedCloudRead$GetAICommentsReq;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        feedCloudRead$GetAICommentsReq.feed = feedCloudMeta$StFeed;
        feedCloudRead$GetAICommentsReq.trans_info.set(h.G().z());
        PBInt32Field pBInt32Field = this.req.gen_type;
        if (feedCloudMeta$StComment == null && feedCloudMeta$StReply == null) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pBInt32Field.set(i3);
        if (feedCloudMeta$StComment != null) {
            this.req.target_cmt.set(feedCloudMeta$StComment);
        }
        if (feedCloudMeta$StReply != null) {
            this.req.target_reply.set(feedCloudMeta$StReply);
        }
        this.req.user_write_text.set(TextUtils.isEmpty(str) ? "" : str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetAIComments";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$GetAICommentsRsp feedCloudRead$GetAICommentsRsp = new FeedCloudRead$GetAICommentsRsp();
        try {
            feedCloudRead$GetAICommentsRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$GetAICommentsRsp;
    }
}
