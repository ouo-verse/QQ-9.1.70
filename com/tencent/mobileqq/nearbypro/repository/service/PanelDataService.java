package com.tencent.mobileqq.nearbypro.repository.service;

import com.tencent.mobileqq.nearbypro.base.NearbyNetError;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.base.l;
import com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp4.h;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J@\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/repository/service/PanelDataService;", "", "", "tinyId", "", "motionId", "", "motionAssetMD5", "coverUrl", "Lrp4/h;", "recordDressKey", "Lcom/tencent/mobileqq/nearbypro/base/l;", "", "listener", "b", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PanelDataService {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(l lVar, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, gq4.c cVar) {
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        if (lVar != null) {
            lVar.a(new NearbyNetError(rspStatus.c(), rspStatus.getCode(), null, null, 12, null), Unit.INSTANCE);
        }
    }

    public final void b(final long tinyId, final int motionId, @NotNull final String motionAssetMD5, @NotNull final String coverUrl, @NotNull final h recordDressKey, @Nullable final l<Unit> listener) {
        Intrinsics.checkNotNullParameter(motionAssetMD5, "motionAssetMD5");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(recordDressKey, "recordDressKey");
        j.e().b(new NearbyProBasePBRequest<gq4.b, gq4.c>(tinyId, motionId, motionAssetMD5, coverUrl, recordDressKey) { // from class: com.tencent.mobileqq.nearbypro.repository.service.PanelDataService$setCoverResource$1

            @NotNull
            private final gq4.b pbReq;

            @NotNull
            private final Function0<gq4.c> pbRspConstructor = new Function0<gq4.c>() { // from class: com.tencent.mobileqq.nearbypro.repository.service.PanelDataService$setCoverResource$1$pbRspConstructor$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final gq4.c invoke() {
                    return new gq4.c();
                }
            };

            @NotNull
            private final String cmd = "trpc.lplan.status_panel_svr.StatusPanelSvr.SsoSetCoverResource";

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                gq4.b bVar = new gq4.b();
                gq4.a aVar = new gq4.a();
                aVar.f403081a = tinyId;
                aVar.f403082b = motionId;
                rp4.b bVar2 = new rp4.b();
                bVar2.f431864c = motionAssetMD5;
                bVar2.f431862a = coverUrl;
                bVar2.f431863b = recordDressKey;
                aVar.f403083c = bVar2;
                Unit unit = Unit.INSTANCE;
                bVar.f403084a = new gq4.a[]{aVar};
                this.pbReq = bVar;
            }

            @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
            @NotNull
            public String getCmd() {
                return this.cmd;
            }

            @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
            @NotNull
            public Function0<gq4.c> getPbRspConstructor() {
                return this.pbRspConstructor;
            }

            @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
            @NotNull
            public gq4.b getPbReq() {
                return this.pbReq;
            }
        }, new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.repository.service.c
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                PanelDataService.c(l.this, (NearbyProBaseRequest) obj, rspStatus, (gq4.c) obj2);
            }
        });
    }
}
