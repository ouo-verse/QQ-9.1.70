package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$QueryUsersLiverStatusReq;
import feedcloud.FeedCloudRead$QueryUsersLiverStatusRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSQueryUsersLiverStatusRequest extends QCircleBaseRequest {
    private final FeedCloudRead$QueryUsersLiverStatusReq mRequest;

    public QFSQueryUsersLiverStatusRequest(List<String> list) {
        FeedCloudRead$QueryUsersLiverStatusReq feedCloudRead$QueryUsersLiverStatusReq = new FeedCloudRead$QueryUsersLiverStatusReq();
        this.mRequest = feedCloudRead$QueryUsersLiverStatusReq;
        feedCloudRead$QueryUsersLiverStatusReq.uids.clear();
        feedCloudRead$QueryUsersLiverStatusReq.uids.addAll(list);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.QueryUsersLiverStatus";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$QueryUsersLiverStatusRsp feedCloudRead$QueryUsersLiverStatusRsp = new FeedCloudRead$QueryUsersLiverStatusRsp();
        try {
            feedCloudRead$QueryUsersLiverStatusRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$QueryUsersLiverStatusRsp;
    }
}
