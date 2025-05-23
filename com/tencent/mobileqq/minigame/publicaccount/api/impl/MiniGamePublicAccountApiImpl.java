package com.tencent.mobileqq.minigame.publicaccount.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAApiProvider;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountApiImpl implements IMiniGamePublicAccountApi {
    private static final String TAG = "MiniGamePublicAccountApiImpl";

    private boolean hasUnReadMsg() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        return waitAppRuntime != null && ((IConversationFacade) waitAppRuntime.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(IMiniGamePublicAccountApi.UIN_MINI_GAME_PA, 1008) > 0;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi
    public boolean canPreloadHippy() {
        boolean isFollowUin = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin((AppInterface) BaseApplicationImpl.getApplication().getRuntime(), IMiniGamePublicAccountApi.UIN_MINI_GAME_PA);
        boolean hasUnReadMsg = hasUnReadMsg();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "canPreloadHippy isFollowPA=" + isFollowUin + " hasUnReadMsg=" + hasUnReadMsg);
        }
        return isFollowUin && hasUnReadMsg;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi
    public HippyAPIProvider createHippyProvider() {
        return new MiniGamePAApiProvider();
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi
    public Class<? extends QPublicBaseFragment> getMiniGamePAHippyClass() {
        return MiniGamePAHippyFragment.class;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi
    public boolean hasNewMessage() {
        boolean hasUnReadMsg = hasUnReadMsg();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hasNewMessage hasNewMsg=" + hasUnReadMsg);
        }
        return hasUnReadMsg;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi
    public boolean isMiniGamePAModule(String str) {
        return TextUtils.equals(str, HippyQQConstants.ModuleName.QQ_MINI_GAME_PUBLICACCOUNT);
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi
    public boolean startMiniGamePA(Context context, HashMap<String, String> hashMap) {
        return MiniGamePublicAccountHelper.startMiniGamePA(context, new OpenHippyInfo(hashMap));
    }
}
