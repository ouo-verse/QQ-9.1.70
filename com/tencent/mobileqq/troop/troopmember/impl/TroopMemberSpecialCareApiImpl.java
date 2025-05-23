package com.tencent.mobileqq.troop.troopmember.impl;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.troop.troopmember.ITroopMemberSpecialCareApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmember/impl/TroopMemberSpecialCareApiImpl;", "Lcom/tencent/mobileqq/troop/troopmember/ITroopMemberSpecialCareApi;", "()V", "isSpecialCare", "", "memberUin", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopMemberSpecialCareApiImpl implements ITroopMemberSpecialCareApi {
    @Override // com.tencent.mobileqq.troop.troopmember.ITroopMemberSpecialCareApi
    public Boolean isSpecialCare(String memberUin) {
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
        SpecialCareInfo O = friendsManager != null ? friendsManager.O(memberUin) : null;
        if (O == null) {
            return null;
        }
        return Boolean.valueOf(O.globalSwitch == 1);
    }
}
