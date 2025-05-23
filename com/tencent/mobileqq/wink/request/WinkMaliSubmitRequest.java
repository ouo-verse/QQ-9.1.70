package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.xaction.log.b;
import feedcloud.FeedCloudAigcsvr$Image;
import feedcloud.FeedCloudAigcsvr$SubmitReq;
import feedcloud.FeedCloudAigcsvr$SubmitRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B'\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/request/WinkMaliSubmitRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "modelName", "Ljava/lang/String;", "imgUrl", "", "genWidth", "I", "genHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMaliSubmitRequest extends QCircleBaseRequest {
    private final int genHeight;
    private final int genWidth;

    @NotNull
    private final String imgUrl;

    @NotNull
    private final String modelName;

    public WinkMaliSubmitRequest(@NotNull String modelName, @NotNull String imgUrl, int i3, int i16) {
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        this.modelName = modelName;
        this.imgUrl = imgUrl;
        this.genWidth = i3;
        this.genHeight = i16;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudAigcsvr$SubmitRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new FeedCloudAigcsvr$SubmitRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            b.c("WinkMaliSubmitRequest", 1, "[decode] ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.aigcsvr.Aigcsvr.Submit";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        FeedCloudAigcsvr$Image feedCloudAigcsvr$Image = new FeedCloudAigcsvr$Image();
        feedCloudAigcsvr$Image.url.set(this.imgUrl);
        feedCloudAigcsvr$Image.width.set(this.genWidth);
        feedCloudAigcsvr$Image.height.set(this.genHeight);
        FeedCloudAigcsvr$SubmitReq feedCloudAigcsvr$SubmitReq = new FeedCloudAigcsvr$SubmitReq();
        feedCloudAigcsvr$SubmitReq.model.set(this.modelName);
        feedCloudAigcsvr$SubmitReq.image.set(feedCloudAigcsvr$Image);
        byte[] byteArray = feedCloudAigcsvr$SubmitReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
