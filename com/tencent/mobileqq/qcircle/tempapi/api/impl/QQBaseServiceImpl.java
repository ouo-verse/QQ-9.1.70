package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.debug.api.IQQDebugApi;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdFragment;
import com.tencent.mobileqq.qcircle.api.hybird.tvideo.TVideoAdWebFragment;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQBaseServiceImpl implements IQQBaseService {
    private static final String TAG = "QQBaseServiceImpl";
    private ConditionSearchManager mSearchManager;

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public void attachConditionSearchManager() {
        AppRuntime peekAppRuntime;
        if (this.mSearchManager != null || (peekAppRuntime = MobileQQ.getMobileQQ().peekAppRuntime()) == null) {
            return;
        }
        ConditionSearchManager conditionSearchManager = (ConditionSearchManager) peekAppRuntime.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
        this.mSearchManager = conditionSearchManager;
        conditionSearchManager.h(this);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public int checkSupportMediaCodecFeature() {
        return ShortVideoCodec.checkSupportMediaCodecFeature(MobileQQ.sMobileQQ.getApplicationContext());
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public String decodeRemoteCode(long j3) {
        return ProfileCodecUtils.decodeRemoteCode(j3);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public void detachConditionSearchManager() {
        ConditionSearchManager conditionSearchManager = this.mSearchManager;
        if (conditionSearchManager != null) {
            conditionSearchManager.o(this);
            this.mSearchManager = null;
        }
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public int encodeLocCode(String str) {
        return ProfileCodecUtils.encodeLocCode(str);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public IEmoticonMainPanelApp getEmotionImpl() {
        return ((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.waitAppRuntime(null));
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public Intent getQQBrowserDelegationActivityIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
        intent.putExtra("param_force_internal_browser", true);
        intent.putExtra("key_isReadModeEnabled", true);
        intent.putExtra("url", str);
        return intent;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public Intent getQQSplashIntent(Context context) {
        Intent intent = new Intent();
        intent.addFlags(402653184);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra("tab_index", a.f183046i);
        intent.setComponent(SplashActivity.getAliasComponent(context));
        intent.putExtra("key_tab_name", QCircleFrame.class.getName());
        return intent;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public Intent handleQCircleHybirdActivityIntent(Context context, String str, Intent intent, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "launchQCircleHybirdActivity url isEmpty");
            return intent;
        }
        String str2 = str + "&theme=" + (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isInNightMode() ? 1 : 0);
        if (context == null) {
            context = MobileQQ.sMobileQQ.getApplicationContext();
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("url", str2);
        com.tencent.mobileqq.qcircle.api.hybird.a.c(intent, str2);
        if (intent.getBooleanExtra("web_show_qcircle_style_title_bar", true)) {
            intent.putExtra("titleBarStyle", 4);
        }
        intent.putExtra(QQBrowserActivityConstants.KEY_TITLE_STYLE, com.tencent.mobileqq.qcircle.api.hybird.a.b().d(context, str2));
        if (com.tencent.mobileqq.qcircle.api.hybird.a.e(str2)) {
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            intent.setClass(context, QQTranslucentBrowserActivity.class);
        } else {
            intent.setClass(context, QQBrowserActivity.class);
        }
        intent.putExtra("fragment_class", QCircleHybirdFragment.class.getCanonicalName());
        if (i3 != -1) {
            intent.putExtra("fragment_class", QCircleHybirdFragment.class.getCanonicalName());
        } else {
            intent.addFlags(268435456);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public Intent handleTVideoAdHybirdActivityIntent(Context context, String str, Intent intent) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "TVideoAdHybirdActivity url isEmpty");
            return intent;
        }
        if (context == null) {
            context = MobileQQ.sMobileQQ.getApplicationContext();
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("url", str);
        intent.putExtra("titleBarStyle", 0);
        intent.setClass(context, QQBrowserActivity.class);
        intent.putExtra("fragment_class", TVideoAdWebFragment.class.getCanonicalName());
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public boolean isNoActivityInForegroundExceptJumpActivity() {
        if (MobileQQ.sProcessId != 1) {
            QLog.d(TAG, 1, "isNoActivityInForegroundExceptJumpActivity: not on main process");
            return false;
        }
        int activityCount = Foreground.getActivityCount();
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            QLog.d(TAG, 1, "isNoActivityInForegroundExceptJumpActivity: current == null");
            return true;
        }
        if (topActivity instanceof SplashActivity) {
            QLog.d(TAG, 1, "isNoActivityInForegroundExceptJumpActivity: current instanceof SplashActivity");
            return false;
        }
        if (activityCount == 0) {
            QLog.d(TAG, 1, "isNoActivityInForegroundExceptJumpActivity: count == 0");
            return true;
        }
        QLog.d(TAG, 1, "isNoActivityInForegroundExceptJumpActivity: only JumpActivity is here");
        if (activityCount != 1 || !(topActivity instanceof JumpActivity)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public void openLocationSelectActivity(Context context, Bundle bundle) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) LocationSelectActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        attachConditionSearchManager();
        int j3 = this.mSearchManager.j();
        if (j3 != 0) {
            QLog.d(TAG, 1, "startLocationSelectActivity | update result = " + this.mSearchManager.h0(j3, true));
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public void openSplashActivity(Context context, HashMap<String, String> hashMap) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra("tab_index", a.f183046i);
        intent.putExtra("key_tab_name", QCircleFrame.class.getName());
        intent.putExtra(QCircleSchemeAttr.Polymerize.TAB_TYPE, hashMap);
        QLog.d(TAG, 1, "openSplashActivity!", new Exception("openSplashActivity stack"));
        QRoute.createNavigator(BaseApplication.getContext(), RouterConstants.UI_ROUTER_SPLASH).withAll(intent.getExtras()).withFlags(67108864).requestWithReturn();
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public void setNewSsoAndRestartApp(String str) {
        ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).buildTestEnvironment(str, "-1");
        ConfigManager.saveCustomEnv("", "", "-1");
        if (com.tencent.mobileqq.alpha.a.d()) {
            ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).restartApp(BaseApplication.getContext());
            ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).remove(IAECameraPrefsUtil.KEY_ETAG_STORY, 4);
            ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).remove(IAECameraPrefsUtil.KEY_ETAG_STORY_MAKEUP, 4);
            ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).remove(IAECameraPrefsUtil.KEY_ETAG_FLASH_SHOW, 4);
            ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).remove(IAECameraPrefsUtil.KEY_ETAG_EMOJI, 4);
            ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).remove("ShadowBackendSvc.GetPlayShowCatMatTree", 4);
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), "Release\u7248\u672c\u4e0d\u751f\u6548\uff0c\u8bf7\u5b89\u88c5Debug\u7248\u672c\uff01", 1).show();
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public void setQCircleToBottomTab(HashMap<String, Boolean> hashMap) {
        BottomTabSettingFragment.mi(true);
        BottomTabSettingFragment.ni(hashMap);
    }

    @Override // com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService
    public Intent startUnlockActivityIntent(Context context) {
        GesturePWDUnlockActivity.sGesturePWDUnlockShowing = true;
        return new Intent(context, (Class<?>) GesturePWDUnlockActivity.class);
    }
}
