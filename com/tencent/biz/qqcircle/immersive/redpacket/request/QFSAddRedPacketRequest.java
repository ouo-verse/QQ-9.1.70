package com.tencent.biz.qqcircle.immersive.redpacket.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudDatacard$AddRedPocketCoverReq;
import feedcloud.FeedCloudDatacard$AddRedPocketCoverRsp;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import feedcloud.FeedCloudMeta$StImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSAddRedPacketRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "Lfeedcloud/FeedCloudDatacard$AddRedPocketCoverReq;", "req", "Lfeedcloud/FeedCloudDatacard$AddRedPocketCoverReq;", "<init>", "(Lfeedcloud/FeedCloudDatacard$AddRedPocketCoverReq;)V", "Companion", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAddRedPacketRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudDatacard$AddRedPocketCoverReq req;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSAddRedPacketRequest$a;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest$a;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSAddRedPacketRequest;", "e", "", "c", "Ljava/lang/String;", "feedOwner", "d", "feedId", "", "J", "feedTime", "Lfeedcloud/FeedCloudMeta$StImage;", "f", "Lfeedcloud/FeedCloudMeta$StImage;", "coverImage", "g", "firstFrame", "Lfeedcloud/FeedCloudDatacard$AddRedPocketCoverReq;", h.F, "Lfeedcloud/FeedCloudDatacard$AddRedPocketCoverReq;", "getReq", "()Lfeedcloud/FeedCloudDatacard$AddRedPocketCoverReq;", "req", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLfeedcloud/FeedCloudMeta$StImage;Lfeedcloud/FeedCloudMeta$StImage;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QCircleBaseRequest.a<QFSAddRedPacketRequest> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String feedOwner;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String feedId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long feedTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudMeta$StImage coverImage;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudMeta$StImage firstFrame;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudDatacard$AddRedPocketCoverReq req;

        public a(@NotNull String feedOwner, @NotNull String feedId, long j3, @NotNull FeedCloudMeta$StImage coverImage, @NotNull FeedCloudMeta$StImage firstFrame) {
            Intrinsics.checkNotNullParameter(feedOwner, "feedOwner");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(coverImage, "coverImage");
            Intrinsics.checkNotNullParameter(firstFrame, "firstFrame");
            this.feedOwner = feedOwner;
            this.feedId = feedId;
            this.feedTime = j3;
            this.coverImage = coverImage;
            this.firstFrame = firstFrame;
            FeedCloudDatacard$AddRedPocketCoverReq feedCloudDatacard$AddRedPocketCoverReq = new FeedCloudDatacard$AddRedPocketCoverReq();
            FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo = new FeedCloudDatacard$RedPocketCoverInfo();
            feedCloudDatacard$RedPocketCoverInfo.feed_owner.set(feedOwner);
            feedCloudDatacard$RedPocketCoverInfo.feed_id.set(feedId);
            feedCloudDatacard$RedPocketCoverInfo.feed_time.set(j3);
            feedCloudDatacard$RedPocketCoverInfo.cover_image.set(coverImage);
            feedCloudDatacard$RedPocketCoverInfo.first_frame.set(firstFrame);
            feedCloudDatacard$AddRedPocketCoverReq.cover_info.set(feedCloudDatacard$RedPocketCoverInfo);
            this.req = feedCloudDatacard$AddRedPocketCoverReq;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        @NotNull
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSAddRedPacketRequest b() {
            return new QFSAddRedPacketRequest(this.req);
        }
    }

    public QFSAddRedPacketRequest(@NotNull FeedCloudDatacard$AddRedPocketCoverReq req) {
        Intrinsics.checkNotNullParameter(req, "req");
        this.req = req;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudDatacard$AddRedPocketCoverRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new FeedCloudDatacard$AddRedPocketCoverRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSAddRedPacketRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.datacard.RedPocket.AddRedPocketCover";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
