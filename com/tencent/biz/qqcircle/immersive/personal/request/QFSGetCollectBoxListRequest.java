package com.tencent.biz.qqcircle.immersive.personal.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudFavoritessvr$GetFavoritesListReq;
import feedcloud.FeedCloudFavoritessvr$GetFavoritesListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetCollectBoxListRequest extends QCircleBaseRequest {
    private final FeedCloudFavoritessvr$GetFavoritesListReq mRequest;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSGetCollectBoxListRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudFavoritessvr$GetFavoritesListReq f88998c;

        public a(String str) {
            FeedCloudFavoritessvr$GetFavoritesListReq feedCloudFavoritessvr$GetFavoritesListReq = new FeedCloudFavoritessvr$GetFavoritesListReq();
            this.f88998c = feedCloudFavoritessvr$GetFavoritesListReq;
            feedCloudFavoritessvr$GetFavoritesListReq.uin.set(c(str));
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetCollectBoxListRequest b() {
            return new QFSGetCollectBoxListRequest(this.f88998c);
        }

        public a f(String str) {
            this.f88998c.attach_info.set(c(str));
            return this;
        }
    }

    QFSGetCollectBoxListRequest(FeedCloudFavoritessvr$GetFavoritesListReq feedCloudFavoritessvr$GetFavoritesListReq) {
        this.mRequest = feedCloudFavoritessvr$GetFavoritesListReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.collectionsvr.CommFavorites.GetFavoritesList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    public void setAttachInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mRequest.attach_info.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudFavoritessvr$GetFavoritesListRsp decode(byte[] bArr) {
        FeedCloudFavoritessvr$GetFavoritesListRsp feedCloudFavoritessvr$GetFavoritesListRsp = new FeedCloudFavoritessvr$GetFavoritesListRsp();
        try {
            feedCloudFavoritessvr$GetFavoritesListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudFavoritessvr$GetFavoritesListRsp;
    }
}
