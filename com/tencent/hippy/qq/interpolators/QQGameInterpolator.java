package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQGameInterpolator extends HippyInterpolator {
    public String getModuleName() {
        return HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNTV2;
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean hasNewMessage() {
        if (((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getRedDotUnreadCount() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).isCanPreloadByTab(getModuleName());
    }
}
