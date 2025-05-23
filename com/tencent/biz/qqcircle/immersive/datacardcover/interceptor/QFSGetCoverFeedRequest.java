package com.tencent.biz.qqcircle.immersive.datacardcover.interceptor;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import feedcloud.FeedCloudRead$StGetMainPageReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0014B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001d\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSGetCoverFeedRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "attachInfo", "", "setAttachInfo", "Lfeedcloud/FeedCloudRead$StGetMainPageReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudRead$StGetMainPageReq;", "<init>", "(Lfeedcloud/FeedCloudRead$StGetMainPageReq;)V", "Companion", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSGetCoverFeedRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudRead$StGetMainPageReq request;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSGetCoverFeedRequest$a", "Lcom/tencent/biz/richframework/network/request/RequestInterceptor;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "request1", "", "interceptRequest", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements RequestInterceptor {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public void interceptRequest(@NotNull BaseRequest request1) {
            Intrinsics.checkNotNullParameter(request1, "request1");
            com.tencent.biz.richframework.network.request.a.a(this, request1);
            cq.f92752a.a(QFSGetCoverFeedRequest.this.request.extInfo);
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSGetCoverFeedRequest$b;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest$a;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSGetCoverFeedRequest;", "", "from", "f", "e", "Lfeedcloud/FeedCloudRead$StGetMainPageReq;", "c", "Lfeedcloud/FeedCloudRead$StGetMainPageReq;", Const.BUNDLE_KEY_REQUEST, "", "uin", "<init>", "(Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCircleBaseRequest.a<QFSGetCoverFeedRequest> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudRead$StGetMainPageReq request;

        public b(@NotNull String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq = new FeedCloudRead$StGetMainPageReq();
            feedCloudRead$StGetMainPageReq.userId.set(uin);
            this.request = feedCloudRead$StGetMainPageReq;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        @NotNull
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetCoverFeedRequest b() {
            return new QFSGetCoverFeedRequest(this.request);
        }

        @NotNull
        public final b f(int from) {
            this.request.from.set(from);
            return this;
        }
    }

    public QFSGetCoverFeedRequest(@NotNull FeedCloudRead$StGetMainPageReq request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        addRequestInterceptor(new a());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudRead$StGetMainPageCommDataRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ?? r06 = (T) new FeedCloudRead$StGetMainPageCommDataRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSGetCoverFeedRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageCommData";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }

    public final void setAttachInfo(@NotNull String attachInfo) {
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.request.feedAttchInfo.set(attachInfo);
    }
}
