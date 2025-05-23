package com.tencent.mobileqq.wink.zplan;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.AIFacePtaData$ZPlanV2Reply;
import qshadow.AIFacePtaData$ZPlanV2Request;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/zplan/WinkAIFaceRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "byteArray", "", "portalGender", "", "seqId", "", "([BLjava/lang/String;I)V", "getByteArray", "()[B", "mReq", "Lqshadow/AIFacePtaData$ZPlanV2Request;", "decode", "T", "convertInputStreamtoByteArray", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkAIFaceRequest extends QCircleBaseRequest {

    @NotNull
    private final byte[] byteArray;

    @NotNull
    private AIFacePtaData$ZPlanV2Request mReq;

    @NotNull
    private final String portalGender;
    private final int seqId;

    public WinkAIFaceRequest(@NotNull byte[] byteArray, @NotNull String portalGender, int i3) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(portalGender, "portalGender");
        this.byteArray = byteArray;
        this.portalGender = portalGender;
        this.seqId = i3;
        AIFacePtaData$ZPlanV2Request aIFacePtaData$ZPlanV2Request = new AIFacePtaData$ZPlanV2Request();
        aIFacePtaData$ZPlanV2Request.input_image.set(ByteStringMicro.copyFrom(byteArray));
        aIFacePtaData$ZPlanV2Request.gender.set(portalGender);
        aIFacePtaData$ZPlanV2Request.model_ver.set("1.9.1");
        aIFacePtaData$ZPlanV2Request.sequence_index.set(i3);
        aIFacePtaData$ZPlanV2Request.render_engine.set(2);
        this.mReq = aIFacePtaData$ZPlanV2Request;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.AIFacePtaData$ZPlanV2Reply] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new AIFacePtaData$ZPlanV2Reply();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @NotNull
    public final byte[] getByteArray() {
        return this.byteArray;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_qq_pta_cgi";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }
}
