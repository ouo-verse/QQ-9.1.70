package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowWangZheReportTabData$HokTabInfoReq;
import qshadow.ShadowWangZheReportTabData$HokTabInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkGetWangZheTabDataReq;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "()V", "mReq", "Lqshadow/ShadowWangZheReportTabData$HokTabInfoReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkGetWangZheTabDataReq extends QCircleBaseRequest {

    @NotNull
    private final ShadowWangZheReportTabData$HokTabInfoReq mReq = new MessageMicro<ShadowWangZheReportTabData$HokTabInfoReq>() { // from class: qshadow.ShadowWangZheReportTabData$HokTabInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ShadowWangZheReportTabData$HokTabInfoReq.class);
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.ShadowWangZheReportTabData$HokTabInfoRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new ShadowWangZheReportTabData$HokTabInfoRsp();
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
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_hok_report_xsj_entry";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }
}
