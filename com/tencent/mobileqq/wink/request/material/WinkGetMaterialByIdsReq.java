package com.tencent.mobileqq.wink.request.material;

import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QShadowMaterialDistribution$GetMaterialInfoByIdsReq;
import qshadow.QShadowMaterialDistribution$GetMaterialInfoByIdsRsp;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/request/material/WinkGetMaterialByIdsReq;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "serviceId", "", "materialIds", "", "(Ljava/lang/String;Ljava/util/List;)V", "req", "Lqshadow/QShadowMaterialDistribution$GetMaterialInfoByIdsReq;", "getReq", "()Lqshadow/QShadowMaterialDistribution$GetMaterialInfoByIdsReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkGetMaterialByIdsReq extends QCircleBaseRequest {

    @NotNull
    private final QShadowMaterialDistribution$GetMaterialInfoByIdsReq req;

    public WinkGetMaterialByIdsReq(@NotNull String serviceId, @NotNull List<String> materialIds) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(materialIds, "materialIds");
        QShadowMaterialDistribution$GetMaterialInfoByIdsReq qShadowMaterialDistribution$GetMaterialInfoByIdsReq = new QShadowMaterialDistribution$GetMaterialInfoByIdsReq();
        this.req = qShadowMaterialDistribution$GetMaterialInfoByIdsReq;
        qShadowMaterialDistribution$GetMaterialInfoByIdsReq.groupID.set(a.f326269a.a());
        qShadowMaterialDistribution$GetMaterialInfoByIdsReq.serviceID.set(serviceId);
        qShadowMaterialDistribution$GetMaterialInfoByIdsReq.sdkVersion.set(e.f445096a.d());
        qShadowMaterialDistribution$GetMaterialInfoByIdsReq.materialIDs.set(materialIds);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.QShadowMaterialDistribution$GetMaterialInfoByIdsRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QShadowMaterialDistribution$GetMaterialInfoByIdsRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_materialinfo_by_ids";
    }

    @NotNull
    public final QShadowMaterialDistribution$GetMaterialInfoByIdsReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
