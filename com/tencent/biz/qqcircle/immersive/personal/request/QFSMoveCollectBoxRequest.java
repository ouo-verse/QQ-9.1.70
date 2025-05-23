package com.tencent.biz.qqcircle.immersive.personal.request;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudFavoritessvr$FavoritesFeedDetail;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudFavoritessvr$MoveFavoritesFeedsReq;
import feedcloud.FeedCloudFavoritessvr$MoveFavoritesFeedsRsp;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMoveCollectBoxRequest extends QCircleBaseRequest {
    private final FeedCloudFavoritessvr$MoveFavoritesFeedsReq mRequest;

    public QFSMoveCollectBoxRequest(long j3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, @NonNull List<FeedCloudMeta$StFeed> list) {
        FeedCloudFavoritessvr$MoveFavoritesFeedsReq feedCloudFavoritessvr$MoveFavoritesFeedsReq = new FeedCloudFavoritessvr$MoveFavoritesFeedsReq();
        this.mRequest = feedCloudFavoritessvr$MoveFavoritesFeedsReq;
        feedCloudFavoritessvr$MoveFavoritesFeedsReq.src_id.set(j3);
        feedCloudFavoritessvr$MoveFavoritesFeedsReq.new_favorites_info.set(feedCloudFavoritessvr$FavoritesInfo);
        feedCloudFavoritessvr$MoveFavoritesFeedsReq.need_new_favorites.set(true);
        a(list);
    }

    private void a(@NonNull List<FeedCloudMeta$StFeed> list) {
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
            FeedCloudFavoritessvr$FavoritesFeedDetail feedCloudFavoritessvr$FavoritesFeedDetail = new FeedCloudFavoritessvr$FavoritesFeedDetail();
            feedCloudFavoritessvr$FavoritesFeedDetail.f398433id.set(feedCloudMeta$StFeed.f398449id.get());
            feedCloudFavoritessvr$FavoritesFeedDetail.poster_id.set(feedCloudMeta$StFeed.poster.f398463id.get());
            feedCloudFavoritessvr$FavoritesFeedDetail.create_time.set(feedCloudMeta$StFeed.createTime.get());
            arrayList.add(feedCloudFavoritessvr$FavoritesFeedDetail);
        }
        this.mRequest.feedsigns.set(arrayList);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.MoveFavoritesFeeds";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudFavoritessvr$MoveFavoritesFeedsRsp decode(byte[] bArr) {
        FeedCloudFavoritessvr$MoveFavoritesFeedsRsp feedCloudFavoritessvr$MoveFavoritesFeedsRsp = new FeedCloudFavoritessvr$MoveFavoritesFeedsRsp();
        try {
            feedCloudFavoritessvr$MoveFavoritesFeedsRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudFavoritessvr$MoveFavoritesFeedsRsp;
    }

    public QFSMoveCollectBoxRequest(long j3, long j16, @NonNull List<FeedCloudMeta$StFeed> list) {
        FeedCloudFavoritessvr$MoveFavoritesFeedsReq feedCloudFavoritessvr$MoveFavoritesFeedsReq = new FeedCloudFavoritessvr$MoveFavoritesFeedsReq();
        this.mRequest = feedCloudFavoritessvr$MoveFavoritesFeedsReq;
        feedCloudFavoritessvr$MoveFavoritesFeedsReq.src_id.set(j3);
        feedCloudFavoritessvr$MoveFavoritesFeedsReq.dst_id.set(j16);
        a(list);
    }
}
