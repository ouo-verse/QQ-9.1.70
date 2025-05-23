package com.tencent.biz.qqcircle.immersive.personal.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudFavoritessvr$CreateFavoritesReq;
import feedcloud.FeedCloudFavoritessvr$CreateFavoritesRsp;
import feedcloud.FeedCloudFavoritessvr$FavoritesFeedDetail;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNewCollectBoxRequest extends QCircleBaseRequest {
    private final FeedCloudFavoritessvr$CreateFavoritesReq mRequest;

    public QFSNewCollectBoxRequest(@NonNull String str, @Nullable List<FeedCloudMeta$StFeed> list) {
        FeedCloudFavoritessvr$CreateFavoritesReq feedCloudFavoritessvr$CreateFavoritesReq = new FeedCloudFavoritessvr$CreateFavoritesReq();
        this.mRequest = feedCloudFavoritessvr$CreateFavoritesReq;
        FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = new FeedCloudFavoritessvr$FavoritesInfo();
        feedCloudFavoritessvr$FavoritesInfo.title.set(str);
        feedCloudFavoritessvr$CreateFavoritesReq.info.set(feedCloudFavoritessvr$FavoritesInfo);
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
            FeedCloudFavoritessvr$FavoritesFeedDetail feedCloudFavoritessvr$FavoritesFeedDetail = new FeedCloudFavoritessvr$FavoritesFeedDetail();
            feedCloudFavoritessvr$FavoritesFeedDetail.f398433id.set(feedCloudMeta$StFeed.f398449id.get());
            feedCloudFavoritessvr$FavoritesFeedDetail.poster_id.set(feedCloudMeta$StFeed.poster.f398463id.get());
            feedCloudFavoritessvr$FavoritesFeedDetail.create_time.set(feedCloudMeta$StFeed.createTime.get());
            arrayList.add(feedCloudFavoritessvr$FavoritesFeedDetail);
        }
        this.mRequest.feed_signs.set(arrayList);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.CreateFavorites";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudFavoritessvr$CreateFavoritesRsp decode(byte[] bArr) {
        FeedCloudFavoritessvr$CreateFavoritesRsp feedCloudFavoritessvr$CreateFavoritesRsp = new FeedCloudFavoritessvr$CreateFavoritesRsp();
        try {
            feedCloudFavoritessvr$CreateFavoritesRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudFavoritessvr$CreateFavoritesRsp;
    }

    public QFSNewCollectBoxRequest(long j3, @NonNull String str) {
        FeedCloudFavoritessvr$CreateFavoritesReq feedCloudFavoritessvr$CreateFavoritesReq = new FeedCloudFavoritessvr$CreateFavoritesReq();
        this.mRequest = feedCloudFavoritessvr$CreateFavoritesReq;
        feedCloudFavoritessvr$CreateFavoritesReq.isDraft.set(true);
        FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo = new FeedCloudFavoritessvr$FavoritesInfo();
        feedCloudFavoritessvr$FavoritesInfo.f398434id.set(j3);
        feedCloudFavoritessvr$FavoritesInfo.title.set(str);
        feedCloudFavoritessvr$CreateFavoritesReq.info.set(feedCloudFavoritessvr$FavoritesInfo);
    }
}
