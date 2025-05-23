package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkAIGCRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "mReq", "Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "(Lqshadow/ShadowAIGCGenerate$GenerateRequest;)V", "getMReq", "()Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkAIGCRequest extends QCircleBaseRequest {

    @NotNull
    private final ShadowAIGCGenerate$GenerateRequest mReq;

    public QQWinkAIGCRequest(@NotNull ShadowAIGCGenerate$GenerateRequest mReq) {
        Intrinsics.checkNotNullParameter(mReq, "mReq");
        this.mReq = mReq;
        setTimeout(30000L);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.ShadowAIGCGenerate$GenerateReply] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new ShadowAIGCGenerate$GenerateReply();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.shadow_qq.trpc_gateway.LongTimeGateway.sso_aigcsdk_cgi_generate";
    }

    @NotNull
    public final ShadowAIGCGenerate$GenerateRequest getMReq() {
        return this.mReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }
}
