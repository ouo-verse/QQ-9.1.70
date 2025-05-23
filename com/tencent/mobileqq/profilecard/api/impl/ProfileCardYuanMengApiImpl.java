package com.tencent.mobileqq.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileCardYuanMengApi;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopMemGameInfoComponent;
import com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileTroopYuanMengComponent;

/* loaded from: classes35.dex */
public class ProfileCardYuanMengApiImpl implements IProfileCardYuanMengApi {
    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardYuanMengApi
    public Class getWangZheProfileCardComponentClazz() {
        return ElegantProfileTroopMemGameInfoComponent.class;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardYuanMengApi
    public Class getYuanMengProfileCardComponentClazz() {
        return ElegantProfileTroopYuanMengComponent.class;
    }
}
