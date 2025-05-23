package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudFavoritessvr$UpdateFavoritesReq;
import feedcloud.FeedCloudFavoritessvr$UpdateFavoritesRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSUpdateCollectBoxRequest extends QCircleBaseRequest {
    private final FeedCloudFavoritessvr$UpdateFavoritesReq mRequest;

    public QFSUpdateCollectBoxRequest(long j3, String str) {
        FeedCloudFavoritessvr$UpdateFavoritesReq feedCloudFavoritessvr$UpdateFavoritesReq = new FeedCloudFavoritessvr$UpdateFavoritesReq();
        this.mRequest = feedCloudFavoritessvr$UpdateFavoritesReq;
        FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = new FeedCloudFavoritessvr$FavoritesInfo();
        feedCloudFavoritessvr$FavoritesInfo.f398434id.set(j3);
        feedCloudFavoritessvr$FavoritesInfo.title.set(str);
        feedCloudFavoritessvr$UpdateFavoritesReq.info.set(feedCloudFavoritessvr$FavoritesInfo);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.UpdateFavorites";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudFavoritessvr$UpdateFavoritesRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudFavoritessvr$UpdateFavoritesRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudFavoritessvr$UpdateFavoritesRsp>() { // from class: feedcloud.FeedCloudFavoritessvr$UpdateFavoritesRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudFavoritessvr$UpdateFavoritesRsp.class);
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
