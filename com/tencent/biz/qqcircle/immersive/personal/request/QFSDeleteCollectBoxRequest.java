package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudFavoritessvr$DelFavoritesReq;
import feedcloud.FeedCloudFavoritessvr$DelFavoritesRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDeleteCollectBoxRequest extends QCircleBaseRequest {
    private final FeedCloudFavoritessvr$DelFavoritesReq mRequest;

    public QFSDeleteCollectBoxRequest(long j3) {
        FeedCloudFavoritessvr$DelFavoritesReq feedCloudFavoritessvr$DelFavoritesReq = new FeedCloudFavoritessvr$DelFavoritesReq();
        this.mRequest = feedCloudFavoritessvr$DelFavoritesReq;
        feedCloudFavoritessvr$DelFavoritesReq.f398432id.set(j3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.DelFavorites";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudFavoritessvr$DelFavoritesRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudFavoritessvr$DelFavoritesRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudFavoritessvr$DelFavoritesRsp>() { // from class: feedcloud.FeedCloudFavoritessvr$DelFavoritesRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudFavoritessvr$DelFavoritesRsp.class);
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
