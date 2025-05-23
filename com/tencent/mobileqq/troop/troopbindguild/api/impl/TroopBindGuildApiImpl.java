package com.tencent.mobileqq.troop.troopbindguild.api.impl;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopbindguild/api/impl/TroopBindGuildApiImpl;", "Lcom/tencent/mobileqq/troop/troopbindguild/api/ITroopBindGuildApi;", "", "troopUin", "Lcom/tencent/mobileqq/troop/troopbindguild/api/ITroopBindGuildApi$a;", "getBindGuildInfoFromExtInfo", "", "getAIOShowBindGuildSwitch", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGuildApiImpl implements ITroopBindGuildApi {

    @NotNull
    public static final String UNITED_CONFIG_ID_AIO_SHOW_BIND_GUILD = "102456";

    @Override // com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi
    public boolean getAIOShowBindGuildSwitch() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(UNITED_CONFIG_ID_AIO_SHOW_BIND_GUILD, false);
    }

    @Override // com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi
    @Nullable
    public ITroopBindGuildApi.TroopBindGuildInfo getBindGuildInfoFromExtInfo(@NotNull String troopUin) {
        TroopInfo findTroopInfo;
        boolean z16;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin)) == null) {
            return null;
        }
        GroupExt groupExt = findTroopInfo.groupExt;
        if (groupExt.groupBindGuildSwitch != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new ITroopBindGuildApi.TroopBindGuildInfo(z16, groupExt.groupAioBindGuildId);
    }
}
