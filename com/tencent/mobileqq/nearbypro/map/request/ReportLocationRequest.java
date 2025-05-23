package com.tencent.mobileqq.nearbypro.map.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.a;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import np4.c;
import op4.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qp4.e;
import xp4.j;
import xp4.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/request/ReportLocationRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lxp4/j;", "req", "Lxp4/j;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "latLng", "Lop4/h;", "poiInfo", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;Lop4/h;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ReportLocationRequest extends NearbyProBaseRequest {

    @NotNull
    private j req;

    public ReportLocationRequest(@NotNull LatLng latLng, @NotNull h poiInfo) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        Intrinsics.checkNotNullParameter(poiInfo, "poiInfo");
        j jVar = new j();
        e eVar = new e();
        eVar.f429215a = (float) latLng.latitude;
        eVar.f429216b = (float) latLng.longitude;
        jVar.f448340b = eVar;
        c cVar = new c();
        a.c(cVar);
        jVar.f448339a = cVar;
        jVar.f448341c = poiInfo;
        this.req = jVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        T t16 = (T) new k();
        try {
            T t17 = (T) k.c(convertInputStreamtoByteArray);
            Intrinsics.checkNotNullExpressionValue(t17, "parseFrom(convertInputStreamtoByteArray)");
            return t17;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return t16;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.lplan.map_svr.Map.SsoReportLocation";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = MessageNano.toByteArray(this.req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        return byteArray;
    }
}
