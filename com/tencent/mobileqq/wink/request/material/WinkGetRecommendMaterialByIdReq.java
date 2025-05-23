package com.tencent.mobileqq.wink.request.material;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QShadowMaterialDistribution$GetRecommendCatMatTreeReq;
import qshadow.QShadowMaterialDistribution$GetRecommendCatMatTreeRsp;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/request/material/WinkGetRecommendMaterialByIdReq;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "serviceId", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "categoryId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategoryId", "()Ljava/lang/String;", "getMaterialId", "req", "Lqshadow/QShadowMaterialDistribution$GetRecommendCatMatTreeReq;", "getReq", "()Lqshadow/QShadowMaterialDistribution$GetRecommendCatMatTreeReq;", "getServiceId", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkGetRecommendMaterialByIdReq extends QCircleBaseRequest {

    @NotNull
    private final String categoryId;

    @NotNull
    private final String materialId;

    @NotNull
    private final QShadowMaterialDistribution$GetRecommendCatMatTreeReq req;

    @NotNull
    private final String serviceId;

    public WinkGetRecommendMaterialByIdReq(@NotNull String serviceId, @NotNull String materialId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.serviceId = serviceId;
        this.materialId = materialId;
        this.categoryId = categoryId;
        QShadowMaterialDistribution$GetRecommendCatMatTreeReq qShadowMaterialDistribution$GetRecommendCatMatTreeReq = new QShadowMaterialDistribution$GetRecommendCatMatTreeReq();
        this.req = qShadowMaterialDistribution$GetRecommendCatMatTreeReq;
        qShadowMaterialDistribution$GetRecommendCatMatTreeReq.groupID.set(a.f326269a.a());
        qShadowMaterialDistribution$GetRecommendCatMatTreeReq.serviceID.set(serviceId);
        qShadowMaterialDistribution$GetRecommendCatMatTreeReq.materialID.set(materialId);
        qShadowMaterialDistribution$GetRecommendCatMatTreeReq.cateID.set(categoryId);
        qShadowMaterialDistribution$GetRecommendCatMatTreeReq.etag.set("");
        qShadowMaterialDistribution$GetRecommendCatMatTreeReq.sdkVersion.set(e.f445096a.d());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.QShadowMaterialDistribution$GetRecommendCatMatTreeRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QShadowMaterialDistribution$GetRecommendCatMatTreeRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_recommend_material";
    }

    @NotNull
    public final String getMaterialId() {
        return this.materialId;
    }

    @NotNull
    public final QShadowMaterialDistribution$GetRecommendCatMatTreeReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    @NotNull
    public final String getServiceId() {
        return this.serviceId;
    }
}
