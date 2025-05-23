package com.tencent.mobileqq.vas.vipicon.api.impl;

import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconSwitch;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/impl/VipIconSwitchImpl;", "Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconSwitch;", "()V", "showInGroup", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VipIconSwitchImpl implements IVipIconSwitch {
    @Override // com.tencent.mobileqq.vas.vipicon.api.IVipIconSwitch
    public boolean showInGroup() {
        IBizTroopInfoService iBizTroopInfoService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iBizTroopInfoService = (IBizTroopInfoService) peekAppRuntime.getRuntimeService(IBizTroopInfoService.class, "")) != null) {
            return iBizTroopInfoService.isShowTroopBigClub();
        }
        return false;
    }
}
