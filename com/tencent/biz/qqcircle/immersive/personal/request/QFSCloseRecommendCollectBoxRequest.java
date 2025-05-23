package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudFavoritessvr$CloseDraftFavoritesReq;
import feedcloud.FeedCloudFavoritessvr$CloseDraftFavoritesRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCloseRecommendCollectBoxRequest extends QCircleBaseRequest {
    private final FeedCloudFavoritessvr$CloseDraftFavoritesReq mRequest = new MessageMicro<FeedCloudFavoritessvr$CloseDraftFavoritesReq>() { // from class: feedcloud.FeedCloudFavoritessvr$CloseDraftFavoritesReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudFavoritessvr$CloseDraftFavoritesReq.class);
    };

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.CloseDraftFavorites";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudFavoritessvr$CloseDraftFavoritesRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudFavoritessvr$CloseDraftFavoritesRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudFavoritessvr$CloseDraftFavoritesRsp>() { // from class: feedcloud.FeedCloudFavoritessvr$CloseDraftFavoritesRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudFavoritessvr$CloseDraftFavoritesRsp.class);
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
