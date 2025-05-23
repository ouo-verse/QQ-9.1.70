package com.tencent.mobileqq.nearbypro.map.request;

import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest;
import com.tencent.mobileqq.nearbypro.request.a;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import hq4.i;
import hq4.j;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import np4.c;
import org.jetbrains.annotations.NotNull;
import qp4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/request/LogoutRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "Lhq4/i;", "Lhq4/j;", "Lkotlin/Function0;", "pbRspConstructor", "Lkotlin/jvm/functions/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "", "cmd", "Ljava/lang/String;", "getCmd", "()Ljava/lang/String;", "pbReq", "Lhq4/i;", "getPbReq", "()Lhq4/i;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LogoutRequest extends NearbyProBasePBRequest<i, j> {

    @NotNull
    private final i pbReq;

    @NotNull
    private final Function0<j> pbRspConstructor = new Function0<j>() { // from class: com.tencent.mobileqq.nearbypro.map.request.LogoutRequest$pbRspConstructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final j invoke() {
            return new j();
        }
    };

    @NotNull
    private final String cmd = "trpc.lplan.user_manager_svr.User.SsoLogout";

    public LogoutRequest() {
        SelfUserInfo selfUserInfo;
        i iVar = new i();
        c cVar = new c();
        a.c(cVar);
        iVar.f405977a = cVar;
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            LatLng latLng = selfUserInfo.getLatLng();
            if (latLng != null) {
                e eVar = new e();
                eVar.f429215a = (float) latLng.latitude;
                eVar.f429216b = (float) latLng.longitude;
                iVar.f405978b = eVar;
            }
            iVar.f405979c = selfUserInfo.getLocationAddress();
        }
        this.pbReq = iVar;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public String getCmd() {
        return this.cmd;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public Function0<j> getPbRspConstructor() {
        return this.pbRspConstructor;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public i getPbReq() {
        return this.pbReq;
    }
}
