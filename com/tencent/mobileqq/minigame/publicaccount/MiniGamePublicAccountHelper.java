package com.tencent.mobileqq.minigame.publicaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minigame.config.MiniGameConfig;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountHelper {
    private static final String HIPPY_DOMAIN = "qzone.qq.com";
    private static final String HIPPY_URL = "https://h5.qzone.qq.com/miniapp/act/gamePublic";
    private static final String TAG = "MiniGamePublicAccountHelper";

    private static boolean isNeedJumpKuikly(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject optJSONObject2 = new JSONObject(str).optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("xmodal")) == null) {
                return false;
            }
            return optJSONObject.optBoolean("needJumpKuikly", false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isNeedJumpKuikly fail, arkMsg=" + str, e16);
            return false;
        }
    }

    public static void launchMiniGamePublicAccountFromAIO(Context context, String str) {
        openHippyMiniGamePAByScheme(context, "aio", isNeedJumpKuikly(str));
    }

    private static void openHippyMiniGamePA(Context context, String str) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_MINI_GAME_PUBLICACCOUNT;
        openHippyInfo.domain = "qzone.qq.com";
        openHippyInfo.url = "https://h5.qzone.qq.com/miniapp/act/gamePublic";
        openHippyInfo.errorUrl = "https://h5.qzone.qq.com/miniapp/act/gamePublic";
        openHippyInfo.processName = "main";
        openHippyInfo.isPreloadWhenClosed = false;
        openHippyInfo.isPredrawWhenClosed = false;
        openHippyInfo.isAnimated = true;
        openHippyInfo.isEnbaleRightFling = true;
        openHippyInfo.preloadType = TabPreloadItem.PreloadType.PRE_LOAD;
        openHippyInfo.fragmentClass = MiniGamePAHippyFragment.class;
        openHippyInfo.from = str;
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, openHippyInfo);
    }

    private static void openHippyMiniGamePAByScheme(Context context, String str, boolean z16) {
        String paHippyScheme;
        QLog.i(TAG, 1, "openHippyMiniGamePAByScheme: from=" + str + "; isNeedJumpKuikly=" + z16);
        MiniGameConfig miniGameConfig = (MiniGameConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameConfig.CONFIG_ID);
        if (miniGameConfig != null) {
            if (z16 && !TextUtils.isEmpty(miniGameConfig.getPaKuiklyScheme())) {
                paHippyScheme = miniGameConfig.getPaKuiklyScheme();
            } else {
                paHippyScheme = !TextUtils.isEmpty(miniGameConfig.getPaHippyScheme()) ? miniGameConfig.getPaHippyScheme() : null;
            }
            if (!TextUtils.isEmpty(paHippyScheme)) {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setData(Uri.parse(paHippyScheme));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return;
            }
        }
        QLog.e(TAG, 1, "openHippyMiniGamePAByScheme: config is null");
        openHippyMiniGamePA(context, str);
    }

    public static boolean shouldOpenWebFragment(String str) {
        return TextUtils.equals(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, str);
    }

    @Deprecated
    public static boolean shouldUseWebStrategy2() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_ARK_MSG_GRAY, 0) == 1;
    }

    public static boolean startMiniGamePA(Context context, OpenHippyInfo openHippyInfo) {
        if (AppSetting.t(context)) {
            if (context != null && openHippyInfo != null && openHippyInfo.checkData()) {
                openHippyInfo.openId = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).generateOpenId();
                QLog.i(TAG, 1, "openHippy bundleName:" + openHippyInfo.bundleName + " processName:" + openHippyInfo.getProcessName());
                Bundle bundle = openHippyInfo.toBundle();
                bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
                Class<? extends QPublicBaseFragment> miniGamePAHippyClass = ((IMiniGamePublicAccountApi) QRoute.api(IMiniGamePublicAccountApi.class)).getMiniGamePAHippyClass();
                if (miniGamePAHippyClass != null) {
                    openHippyInfo.fragmentClass = miniGamePAHippyClass;
                }
                Intent intent = new Intent();
                intent.putExtra("params", bundle);
                if (openHippyInfo.isTransparent) {
                    intent.putExtra("public_fragment_window_feature", 1);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isLaunchByMiniApp(context)) {
                    QLog.i(TAG, 1, "Launch by miniApp");
                    ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).launchMiniHippy(context, intent);
                    return true;
                }
                Class<? extends QPublicFragmentActivity> startActivityClass = openHippyInfo.getStartActivityClass();
                Class<? extends QPublicBaseFragment> startFragmentClass = openHippyInfo.getStartFragmentClass();
                if (startActivityClass != null && startFragmentClass != null) {
                    if (openHippyInfo.isAnimated) {
                        intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154445lb);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, R.anim.f154449lf);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, R.anim.f154435l2);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, R.anim.f154436l4);
                    } else {
                        intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, 0);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, 0);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, 0);
                        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0);
                    }
                    intent.setClass(context, startActivityClass);
                    com.tencent.mobileqq.pad.b bVar = new com.tencent.mobileqq.pad.b();
                    bVar.e(false).g(true).h(LaunchMode.standard);
                    i.e(context, intent.getExtras(), miniGamePAHippyClass, bVar.a());
                    return true;
                }
                QLog.e(TAG, 1, "openHippyPage cannot find activity class or fragment class");
                return false;
            }
            QLog.e(TAG, 1, "openHippyPage params error");
            return false;
        }
        return ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, openHippyInfo);
    }

    public static void launchMiniGamePublicAccount(Context context, String str) {
        openHippyMiniGamePAByScheme(context, str, false);
    }
}
