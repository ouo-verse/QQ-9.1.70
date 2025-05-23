package com.tencent.mobileqq.nearbypro.feedscheck.basepart;

import com.tencent.mobileqq.nearbypro.base.NearbyNetError;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.base.l;
import com.tencent.mobileqq.nearbypro.feeds.request.GetPersonGeoRequest;
import com.tencent.mobileqq.nearbypro.feeds.request.GetUserStatusListRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004J\u001c\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0004J,\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/c;", "Lcom/tencent/mobileqq/mvvm/a;", "", "tinyId", "Lcom/tencent/mobileqq/nearbypro/base/l;", "Lup4/b;", "callback", "", DomainData.DOMAIN_NAME, "", "Lxp4/h;", "l", "", "doILike", "feedsId", "posterId", "Lop4/d;", "p", "<init>", "()V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends com.tencent.mobileqq.mvvm.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(l callback, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, xp4.e eVar) {
        xp4.h hVar;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        j.c().e("NBP.FeedsCheckPart.FeedsStatusListRepo", "fetchUserCurrentPos " + rspStatus);
        NearbyNetError nearbyNetError = new NearbyNetError(rspStatus.c(), rspStatus.getCode(), rspStatus.getMsg(), null, 8, null);
        if (eVar != null) {
            hVar = eVar.f448318b;
        } else {
            hVar = null;
        }
        callback.a(nearbyNetError, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(l callback, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, up4.b bVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        j.c().e("NBP.FeedsCheckPart.FeedsStatusListRepo", "fetchUserFeedsStatusList " + rspStatus);
        callback.a(new NearbyNetError(rspStatus.c(), rspStatus.getCode(), rspStatus.getMsg(), null, 8, null), bVar);
    }

    public final void l(long tinyId, @NotNull final l<xp4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.e().b(new GetPersonGeoRequest(tinyId), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.basepart.a
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                c.m(l.this, (NearbyProBaseRequest) obj, rspStatus, (xp4.e) obj2);
            }
        });
    }

    public final void n(@NotNull String tinyId, @NotNull final l<up4.b> callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.e().b(new GetUserStatusListRequest(tinyId, 1, 0, null, 12, null), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.basepart.b
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                c.o(l.this, (NearbyProBaseRequest) obj, rspStatus, (up4.b) obj2);
            }
        });
    }

    public final void p(int doILike, @NotNull String feedsId, @NotNull String posterId, @NotNull l<op4.d> callback) {
        Intrinsics.checkNotNullParameter(feedsId, "feedsId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }
}
