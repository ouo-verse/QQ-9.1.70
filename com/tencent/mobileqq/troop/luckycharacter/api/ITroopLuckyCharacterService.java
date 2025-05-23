package com.tencent.mobileqq.troop.luckycharacter.api;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopLuckyCharacterService extends IRuntimeService {
    String getLuckyCharacterPicUrl(TroopInfo troopInfo);

    boolean isShowInTroopGuild();

    boolean isSupportLuckyCharacter(TroopInfo troopInfo);

    boolean isTroopLuckyCharacterSwitchChanged(int i3, int i16);
}
