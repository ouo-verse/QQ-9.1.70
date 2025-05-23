package com.tencent.mobileqq.nearbypro.profile.basepart;

import com.tencent.mobileqq.nearbypro.base.NearbyNetError;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.base.l;
import com.tencent.mobileqq.nearbypro.profile.request.UserProfileInfoRequest;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import jb2.UserProfileData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/basepart/d;", "Lcom/tencent/mobileqq/mvvm/a;", "", "tinyId", "Lcom/tencent/mobileqq/nearbypro/base/l;", "Ljb2/a;", "callback", "", "k", "<init>", "()V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends com.tencent.mobileqq.mvvm.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(l callback, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, hq4.b bVar) {
        sp4.c[] cVarArr;
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        j.c().e("NBP.PersonalPart.ProfileRepository", "fetchUserInfo " + rspStatus);
        UserProfileData userProfileData = new UserProfileData(0L, "", "", null, 8, null);
        if (rspStatus.c()) {
            sp4.c[] cVarArr2 = null;
            if (bVar != null) {
                cVarArr = bVar.f405956b;
            } else {
                cVarArr = null;
            }
            boolean z17 = true;
            if (cVarArr != null) {
                if (cVarArr.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (!z17) {
                if (bVar != null) {
                    cVarArr2 = bVar.f405956b;
                }
                Intrinsics.checkNotNull(cVarArr2);
                sp4.c rspUserInfo = cVarArr2[0];
                long j3 = rspUserInfo.f434140a;
                String str = rspUserInfo.f434143d;
                Intrinsics.checkNotNullExpressionValue(str, "rspUserInfo.nick");
                String str2 = rspUserInfo.f434145f;
                Intrinsics.checkNotNullExpressionValue(str2, "rspUserInfo.avatar");
                Intrinsics.checkNotNullExpressionValue(rspUserInfo, "rspUserInfo");
                userProfileData = new UserProfileData(j3, str, str2, com.tencent.mobileqq.nearbypro.utils.b.a(rspUserInfo));
            }
        }
        callback.a(new NearbyNetError(rspStatus.c(), rspStatus.getCode(), null, null, 12, null), userProfileData);
    }

    public final void k(long tinyId, @NotNull final l<UserProfileData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        j.e().b(new UserProfileInfoRequest(tinyId), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.profile.basepart.c
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                d.l(l.this, (NearbyProBaseRequest) obj, rspStatus, (hq4.b) obj2);
            }
        });
    }
}
