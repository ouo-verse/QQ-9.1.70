package com.tencent.biz.qqcircle.immersive.redpacket.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudDatacard$GetRedPocketCoverReq;
import feedcloud.FeedCloudDatacard$GetRedPocketCoverRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSGetRedPacketRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "Lfeedcloud/FeedCloudDatacard$GetRedPocketCoverReq;", "req", "Lfeedcloud/FeedCloudDatacard$GetRedPocketCoverReq;", "<init>", "(Lfeedcloud/FeedCloudDatacard$GetRedPocketCoverReq;)V", "Companion", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSGetRedPacketRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudDatacard$GetRedPocketCoverReq req;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSGetRedPacketRequest$a;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest$a;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSGetRedPacketRequest;", "e", "", "c", "Ljava/lang/String;", "coverId", "Lfeedcloud/FeedCloudDatacard$GetRedPocketCoverReq;", "d", "Lfeedcloud/FeedCloudDatacard$GetRedPocketCoverReq;", "getReq", "()Lfeedcloud/FeedCloudDatacard$GetRedPocketCoverReq;", "req", "<init>", "(Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QCircleBaseRequest.a<QFSGetRedPacketRequest> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String coverId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudDatacard$GetRedPocketCoverReq req;

        public a(@NotNull String coverId) {
            Intrinsics.checkNotNullParameter(coverId, "coverId");
            this.coverId = coverId;
            FeedCloudDatacard$GetRedPocketCoverReq feedCloudDatacard$GetRedPocketCoverReq = new FeedCloudDatacard$GetRedPocketCoverReq();
            feedCloudDatacard$GetRedPocketCoverReq.cover_id.set(coverId);
            this.req = feedCloudDatacard$GetRedPocketCoverReq;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        @NotNull
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetRedPacketRequest b() {
            return new QFSGetRedPacketRequest(this.req);
        }
    }

    public QFSGetRedPacketRequest(@NotNull FeedCloudDatacard$GetRedPocketCoverReq req) {
        Intrinsics.checkNotNullParameter(req, "req");
        this.req = req;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudDatacard$GetRedPocketCoverRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new FeedCloudDatacard$GetRedPocketCoverRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSGetRedPacketRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.datacard.RedPocket.GetRedPocketCover";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
