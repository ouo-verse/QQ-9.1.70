package com.tencent.mobileqq.nearbypro.feeds.request;

import com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest;
import com.tencent.mobileqq.nearbypro.request.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import np4.c;
import org.jetbrains.annotations.NotNull;
import xp4.d;
import xp4.e;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feeds/request/GetPersonGeoRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "Lxp4/d;", "Lxp4/e;", "", "tinyId", "J", "getTinyId", "()J", "getPbReq", "()Lxp4/d;", "pbReq", "Lkotlin/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "pbRspConstructor", "", "getCmd", "()Ljava/lang/String;", "cmd", "<init>", "(J)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GetPersonGeoRequest extends NearbyProBasePBRequest<d, e> {
    private final long tinyId;

    public GetPersonGeoRequest(long j3) {
        this.tinyId = j3;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGetPersonGeo";
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public Function0<e> getPbRspConstructor() {
        return new Function0<e>() { // from class: com.tencent.mobileqq.nearbypro.feeds.request.GetPersonGeoRequest$pbRspConstructor$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                return new e();
            }
        };
    }

    public final long getTinyId() {
        return this.tinyId;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public d getPbReq() {
        d dVar = new d();
        dVar.f448316b = this.tinyId;
        c cVar = new c();
        a.c(cVar);
        dVar.f448315a = cVar;
        return dVar;
    }
}
