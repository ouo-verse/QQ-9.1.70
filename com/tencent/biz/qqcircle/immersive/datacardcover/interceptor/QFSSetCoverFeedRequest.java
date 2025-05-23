package com.tencent.biz.qqcircle.immersive.datacardcover.interceptor;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudDatacard$DataCardCoverClientInfo;
import feedcloud.FeedCloudDatacard$SetDataCardCoverReq;
import feedcloud.FeedCloudDatacard$SetDataCardCoverRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSSetCoverFeedRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "Lfeedcloud/FeedCloudDatacard$SetDataCardCoverReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudDatacard$SetDataCardCoverReq;", "getRequest", "()Lfeedcloud/FeedCloudDatacard$SetDataCardCoverReq;", "<init>", "(Lfeedcloud/FeedCloudDatacard$SetDataCardCoverReq;)V", "Companion", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSetCoverFeedRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudDatacard$SetDataCardCoverReq request;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSSetCoverFeedRequest$a;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest$a;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSSetCoverFeedRequest;", "", "yPercent", "f", "e", "Lfeedcloud/FeedCloudDatacard$SetDataCardCoverReq;", "c", "Lfeedcloud/FeedCloudDatacard$SetDataCardCoverReq;", Const.BUNDLE_KEY_REQUEST, "", "feedId", "<init>", "(Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QCircleBaseRequest.a<QFSSetCoverFeedRequest> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudDatacard$SetDataCardCoverReq request;

        public a(@NotNull String feedId) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            FeedCloudDatacard$SetDataCardCoverReq feedCloudDatacard$SetDataCardCoverReq = new FeedCloudDatacard$SetDataCardCoverReq();
            feedCloudDatacard$SetDataCardCoverReq.feed_id.set(feedId);
            this.request = feedCloudDatacard$SetDataCardCoverReq;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        @NotNull
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSSetCoverFeedRequest b() {
            return new QFSSetCoverFeedRequest(this.request);
        }

        @NotNull
        public final a f(float yPercent) {
            FeedCloudDatacard$DataCardCoverClientInfo feedCloudDatacard$DataCardCoverClientInfo = new FeedCloudDatacard$DataCardCoverClientInfo();
            feedCloudDatacard$DataCardCoverClientInfo.y_percent.set(yPercent);
            this.request.client_info.set(ByteStringMicro.copyFrom(feedCloudDatacard$DataCardCoverClientInfo.toByteArray()));
            return this;
        }
    }

    public QFSSetCoverFeedRequest(@NotNull FeedCloudDatacard$SetDataCardCoverReq request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudDatacard$SetDataCardCoverRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ?? r06 = (T) new MessageMicro<FeedCloudDatacard$SetDataCardCoverRsp>() { // from class: feedcloud.FeedCloudDatacard$SetDataCardCoverRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudDatacard$SetDataCardCoverRsp.class);
        };
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSSetCoverFeedRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.datacard.DataCard.SetDataCardCover";
    }

    @NotNull
    public final FeedCloudDatacard$SetDataCardCoverReq getRequest() {
        return this.request;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
