package com.tencent.mobileqq.wink.request.material;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.mobileqq.wink.context.WinkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq;
import qshadow.QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp;
import qshadow.QShadowMetaMaterialRecommendation$MediaInfo;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\u001f\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/request/material/WinkRecommendationMaterialReq;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedias", "Lqshadow/QShadowMetaMaterialRecommendation$MediaInfo;", "a", "", "getCmdName", "", "getRequestByteData", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "busiId", "I", "getBusiId", "()I", "Lqshadow/QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq;", "req", "Lqshadow/QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq;", "getReq", "()Lqshadow/QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq;", "frameBytes", "mediaType", "<init>", "(ILjava/util/List;Ljava/util/List;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkRecommendationMaterialReq extends QCircleBaseRequest {
    private final int busiId;

    @NotNull
    private final QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq req;

    public WinkRecommendationMaterialReq(int i3, @Nullable List<? extends LocalMediaInfo> list, @NotNull List<byte[]> frameBytes, int i16) {
        Intrinsics.checkNotNullParameter(frameBytes, "frameBytes");
        this.busiId = i3;
        QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq = new QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq();
        this.req = qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq;
        qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq.BusiID.set(i3);
        if (i3 == 65538) {
            qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq.MediaInfos.set(a(list));
            qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq.XsjSessionID.set(WinkContext.INSTANCE.d().getDtParams().c());
        }
        qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq.MediaType.set(i16);
        qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq.SdkVersion.set(e.f445096a.d());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = frameBytes.iterator();
        while (it.hasNext()) {
            ByteStringMicro copyFrom = ByteStringMicro.copyFrom((byte[]) it.next());
            Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(frameByteArray)");
            arrayList.add(copyFrom);
        }
        qShadowMetaMaterialRecommendation$GetMaterialRecommendationReq.Images.set(arrayList);
    }

    private final List<QShadowMetaMaterialRecommendation$MediaInfo> a(List<? extends LocalMediaInfo> selectedMedias) {
        ArrayList arrayList = new ArrayList();
        if (selectedMedias != null) {
            for (LocalMediaInfo localMediaInfo : selectedMedias) {
                QShadowMetaMaterialRecommendation$MediaInfo qShadowMetaMaterialRecommendation$MediaInfo = new QShadowMetaMaterialRecommendation$MediaInfo();
                PBInt32Field pBInt32Field = qShadowMetaMaterialRecommendation$MediaInfo.media_type;
                int i3 = 1;
                if (localMediaInfo.mMediaType != 1) {
                    i3 = 0;
                }
                pBInt32Field.set(i3);
                qShadowMetaMaterialRecommendation$MediaInfo.width.set(localMediaInfo.mediaWidth);
                qShadowMetaMaterialRecommendation$MediaInfo.height.set(localMediaInfo.mediaHeight);
                arrayList.add(qShadowMetaMaterialRecommendation$MediaInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qshadow.QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    public final int getBusiId() {
        return this.busiId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_media_material_recommendation";
    }

    @NotNull
    public final QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
