package com.tencent.mobileqq.minigame.api.impl;

import com.tencent.mobileqq.minigame.api.IMiniGameVipWithoutAdManager;
import com.tencent.mobileqq.minigame.utils.VipWithoutAdHelper;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameVipWithoutAdManagerImpl implements IMiniGameVipWithoutAdManager {
    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVipWithoutAdManager
    public boolean getVipWithoutAdMemberState() {
        return VipWithoutAdHelper.getVipWithoutAdMemberState();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVipWithoutAdManager
    public String getVipWithoutAdToastText() {
        return VipWithoutAdHelper.getVipWithoutAdToastText();
    }
}
