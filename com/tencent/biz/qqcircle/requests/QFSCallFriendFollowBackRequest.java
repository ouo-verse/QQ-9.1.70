package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudWrite$StBatchCallFollowReq;
import feedcloud.FeedCloudWrite$StBatchCallFollowRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSCallFriendFollowBackRequest extends QCircleBaseRequest {
    private final FeedCloudWrite$StBatchCallFollowReq mRequest;

    public QFSCallFriendFollowBackRequest(String str) {
        FeedCloudWrite$StBatchCallFollowReq feedCloudWrite$StBatchCallFollowReq = new FeedCloudWrite$StBatchCallFollowReq();
        this.mRequest = feedCloudWrite$StBatchCallFollowReq;
        if (!TextUtils.isEmpty(str)) {
            feedCloudWrite$StBatchCallFollowReq.uids.add(str);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.BatchCallFollow";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudWrite$StBatchCallFollowRsp feedCloudWrite$StBatchCallFollowRsp = new FeedCloudWrite$StBatchCallFollowRsp();
        try {
            feedCloudWrite$StBatchCallFollowRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StBatchCallFollowRsp;
    }
}
