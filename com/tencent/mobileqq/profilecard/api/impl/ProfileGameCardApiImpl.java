package com.tencent.mobileqq.profilecard.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.profilecard.api.IProfileGameCardApi;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameCardComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameInfoSettingHelper;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.profilesetting.u;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;

/* loaded from: classes35.dex */
public class ProfileGameCardApiImpl implements IProfileGameCardApi {
    @Override // com.tencent.mobileqq.profilecard.api.IProfileGameCardApi
    public void getAuthFromServer() {
        if (((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.PROFILE_GAMEINFO_CARD_SETTING_SWITCH, true)) {
            ElegantProfileGameInfoSettingHelper.getAuthFromServer();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGameCardApi
    public Class getGameCardComponentClazz() {
        return ElegantProfileGameCardComponent.class;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGameCardApi
    public void onInterestSwitchEditActivityCreate(Activity activity) {
        ElegantProfileGameInfoSettingHelper.onInterestSwitchEditActivityCreate((InterestSwitchEditActivity) activity);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGameCardApi
    public void onInterestSwitchEditActivityDestroy() {
        ElegantProfileGameInfoSettingHelper.onInterestSwitchEditActivityDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileGameCardApi
    public void showGameInfoActionSheet(boolean z16, Object obj) {
        ElegantProfileGameInfoSettingHelper.showGameInfoActionSheet(z16, (u) obj);
    }
}
