package com.tencent.mobileqq.nearbypro.api.impl;

import ca2.b;
import com.tencent.ecommerce.biz.hr.module.e;
import com.tencent.mobileqq.nearbypro.api.INearbyDataService;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/NearbyDataServiceImpl;", "Lcom/tencent/mobileqq/nearbypro/api/INearbyDataService;", "Lca2/b;", "selfInfo", "", "setMatchFriendBaseInfo", "getMatchFriendBaseInfo", "", QAdLoginDefine$LoginStatus.IS_LOGIN, "setQQKLLogin", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyDataServiceImpl implements INearbyDataService {

    @NotNull
    private static final String QQ_KL_LOGIN_KEY = "is_in_qq_kl";

    @NotNull
    private static final String TAG = "NearbyDataServiceImpl";

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyDataService
    @NotNull
    public b getMatchFriendBaseInfo() {
        return b.INSTANCE.a(c.a.g(j.d(), "nearby_pro_match_friend_self_user", "", null, false, 12, null));
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyDataService
    public void setMatchFriendBaseInfo(@NotNull b selfInfo) {
        Intrinsics.checkNotNullParameter(selfInfo, "selfInfo");
        try {
            c.a.m(j.d(), "nearby_pro_match_friend_self_user", selfInfo.d(), null, false, 12, null);
        } catch (Throwable th5) {
            j.c().d(TAG, th5.toString());
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.api.INearbyDataService
    public void setQQKLLogin(boolean isLogin) {
        String str;
        if (isLogin) {
            str = "1";
        } else {
            str = "0";
        }
        e.f102613b.b(QQ_KL_LOGIN_KEY, str);
    }
}
