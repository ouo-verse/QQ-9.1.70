package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoCollectReq;
import feedcloud.FeedCloudWrite$StDoCollectRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDoCollectRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StDoCollectReq mRequest;

    public QFSDoCollectRequest(FeedCloudWrite$StDoCollectReq feedCloudWrite$StDoCollectReq) {
        this.mRequest = feedCloudWrite$StDoCollectReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoCollect";
    }

    public String getKey() {
        if (this.mRequest.collectType.get() != 0 || this.mRequest.feedAlbum == null) {
            return "";
        }
        return this.mRequest.feedAlbum.f398441id.get() + "";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudWrite$StDoCollectRsp decode(byte[] bArr) {
        FeedCloudWrite$StDoCollectRsp feedCloudWrite$StDoCollectRsp = new FeedCloudWrite$StDoCollectRsp();
        try {
            feedCloudWrite$StDoCollectRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StDoCollectRsp;
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSDoCollectRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudWrite$StDoCollectReq f88997c;

        public a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            FeedCloudWrite$StDoCollectReq feedCloudWrite$StDoCollectReq = new FeedCloudWrite$StDoCollectReq();
            this.f88997c = feedCloudWrite$StDoCollectReq;
            feedCloudWrite$StDoCollectReq.feed.set(feedCloudMeta$StFeed);
            feedCloudWrite$StDoCollectReq.collectType.set(1);
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSDoCollectRequest b() {
            return new QFSDoCollectRequest(this.f88997c);
        }

        public a f(int i3) {
            this.f88997c.collectAction.set(i3);
            return this;
        }

        public a(FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum) {
            FeedCloudWrite$StDoCollectReq feedCloudWrite$StDoCollectReq = new FeedCloudWrite$StDoCollectReq();
            this.f88997c = feedCloudWrite$StDoCollectReq;
            feedCloudWrite$StDoCollectReq.feedAlbum.set(feedCloudMeta$FeedAlbum);
            feedCloudWrite$StDoCollectReq.collectType.set(0);
        }
    }
}
