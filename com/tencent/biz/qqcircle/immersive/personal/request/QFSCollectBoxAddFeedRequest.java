package com.tencent.biz.qqcircle.immersive.personal.request;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudFavoritessvr$AddFavoritesFeedsReq;
import feedcloud.FeedCloudFavoritessvr$AddFavoritesFeedsRsp;
import feedcloud.FeedCloudFavoritessvr$FavoritesFeedDetail;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCollectBoxAddFeedRequest extends QCircleBaseRequest {
    private final FeedCloudFavoritessvr$AddFavoritesFeedsReq mRequest;

    public QFSCollectBoxAddFeedRequest(long j3, @NonNull List<FeedCloudMeta$StFeed> list) {
        FeedCloudFavoritessvr$AddFavoritesFeedsReq feedCloudFavoritessvr$AddFavoritesFeedsReq = new FeedCloudFavoritessvr$AddFavoritesFeedsReq();
        this.mRequest = feedCloudFavoritessvr$AddFavoritesFeedsReq;
        feedCloudFavoritessvr$AddFavoritesFeedsReq.f398431id.set(j3);
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
        return "FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.AddFavoritesFeeds";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudFavoritessvr$AddFavoritesFeedsRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudFavoritessvr$AddFavoritesFeedsRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudFavoritessvr$AddFavoritesFeedsRsp>() { // from class: feedcloud.FeedCloudFavoritessvr$AddFavoritesFeedsRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudFavoritessvr$AddFavoritesFeedsRsp.class);
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
