package com.tencent.mobileqq.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileKoiLikeApi;
import com.tencent.mobileqq.profilecard.utils.SpecialPersonalityLabelResourceUtil;

/* loaded from: classes35.dex */
public class ProfileKoiLikeApiImpl implements IProfileKoiLikeApi {
    @Override // com.tencent.mobileqq.profilecard.api.IProfileKoiLikeApi
    public int getSpecialPersonalLabelTextColor(long j3) {
        return SpecialPersonalityLabelResourceUtil.getInstance().getTextColorById(j3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileKoiLikeApi
    public boolean isSpecialPersonalLabel(long j3) {
        return SpecialPersonalityLabelResourceUtil.getInstance().isSpecialLabel(j3);
    }
}
