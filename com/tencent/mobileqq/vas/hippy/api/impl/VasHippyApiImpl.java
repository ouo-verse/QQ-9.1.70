package com.tencent.mobileqq.vas.hippy.api.impl;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.vas.hippy.api.IVasHippyApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import m13.a;
import m13.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasHippyApiImpl implements IVasHippyApi {
    @Override // com.tencent.mobileqq.vas.hippy.api.IVasHippyApi
    public HippyAPIProvider createHippyAPIProvider() {
        return new a();
    }

    @Override // com.tencent.mobileqq.vas.hippy.api.IVasHippyApi
    public HippyCustomViewCreator createHippyCustomViewCreator() {
        return new b();
    }

    @Override // com.tencent.mobileqq.vas.hippy.api.IVasHippyApi
    public boolean isVasModuleNeedToBeAdd(String str) {
        if (!HippyQQConstants.ModuleName.QQ_VIP.equals(str) && !HippyQQConstants.ModuleName.QQ_PERSONALITY.equals(str) && !HippyQQConstants.ModuleName.QQ_BIG_CLUB.equals(str) && !HippyQQConstants.ModuleName.QQ_VIP_PAY.equals(str) && !HippyQQConstants.ModuleName.QQ_MINI_GAME_PUBLICACCOUNT.equals(str) && !HippyQQConstants.ModuleName.QQ_YELLOW_VIP.equals(str) && !HippyQQConstants.ModuleName.QQ_SPORT.equals(str) && !HippyQQConstants.ModuleName.QQ_MINI_GAME_CENTER.equals(str) && !HippyQQConstants.ModuleName.QQ_NEWS_PUBLICACCOUNT.equals(str) && !HippyQQConstants.ModuleName.QQ_VAS_GUIDE_MODULE.equals(str) && !HippyQQConstants.ModuleName.QQ_WEATHER.equals(str) && !HippyQQConstants.ModuleName.QQ_VIP_SSR.equals(str) && !VasUtil.getTempApi().isContainsModule(str)) {
            return false;
        }
        return true;
    }
}
