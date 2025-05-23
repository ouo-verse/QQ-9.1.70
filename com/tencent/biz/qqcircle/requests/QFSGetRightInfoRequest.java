package com.tencent.biz.qqcircle.requests;

import com.tencent.qphone.base.util.QLog;
import feedcloud.GetRightInfoReq;
import feedcloud.GetRightInfoRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSGetRightInfoRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "feed_Id", "Ljava/lang/String;", "getFeed_Id", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSGetRightInfoRequest extends QCircleBaseRequest {

    @NotNull
    private final String feed_Id;

    public QFSGetRightInfoRequest(@NotNull String feed_Id) {
        Intrinsics.checkNotNullParameter(feed_Id, "feed_Id");
        this.feed_Id = feed_Id;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            return (T) GetRightInfoRsp.ADAPTER.decode(bytes);
        } catch (Exception e16) {
            QLog.e("QFSGetRightInfoRequest", 1, "decode, error ", e16);
            return (T) new GetRightInfoRsp.a().build();
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.comment_right.CommentRight.GetRightInfo";
    }

    @NotNull
    public final String getFeed_Id() {
        return this.feed_Id;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return new GetRightInfoReq.a().b(this.feed_Id).build().encode();
    }
}
