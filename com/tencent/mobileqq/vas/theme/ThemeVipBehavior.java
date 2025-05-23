package com.tencent.mobileqq.vas.theme;

import QC.UniBusinessItem;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.em;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.business.XAResBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeVipBehavior {
    public static final String TAG = "ThemeVipBehavior";
    public static final int VIP_RES_ID = 12;
    private static String sCurrentVipTheme = "";

    static /* bridge */ /* synthetic */ boolean c() {
        return vipThemeResExits();
    }

    public static boolean couldShowVipSplash() {
        return em.b().a().getBoolean(QQTheme.THEME_VIP_SPLASH, false);
    }

    public static boolean couldShowVipSplashSkip() {
        return false;
    }

    private static void downloadVipThemeRes() {
        try {
            int vipResId = getVipResId();
            XAResBusiness xAResBusiness = (XAResBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(XAResBusiness.class);
            if (xAResBusiness.isFileExists(vipResId)) {
                QLog.d(TAG, 2, "downloadVipThemeRes exist!");
            } else {
                xAResBusiness.startDownload(xAResBusiness.getScid(vipResId));
                QLog.d(TAG, 2, "downloadVipThemeRes startDownload");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
    }

    public static boolean enableVipSplash() {
        if (couldShowVipSplash() && getVipSplashSwitch()) {
            return true;
        }
        return false;
    }

    private static String getChangedThemeId(Intent intent, boolean z16) {
        String stringExtra = intent.getStringExtra("options");
        String str = "";
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                str = new JSONObject(stringExtra).optString("themeId", "");
                if (z16) {
                    intent.removeExtra("options");
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16.getCause(), new Object[0]);
            }
        }
        return str;
    }

    private static int getVipResId() {
        int i3 = 12;
        try {
            i3 = new JSONObject(VasToggle.FEATURE_THEME_VIP_SPLASH.getStringData("")).optInt(IPreloadServiceProxy.KEY_RESID, 12);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
        QLog.d(TAG, 2, "getVipResId res_id=" + i3);
        return i3;
    }

    public static boolean getVipSplashSwitch() {
        return em.b().a().getBoolean(QQTheme.THEME_VIP_SPLASH_SWITCH, true);
    }

    public static String getVipThemeResPath() {
        int vipResId = getVipResId();
        XAResBusiness xAResBusiness = new XAResBusiness();
        return xAResBusiness.getSavePath(xAResBusiness.getScid(vipResId));
    }

    public static void handleChangeTheme(final Activity activity) {
        final String changedThemeId = getChangedThemeId(activity.getIntent(), true);
        if (!TextUtils.isEmpty(changedThemeId) && !changedThemeId.equals(QQTheme.getCurrentThemeId()) && !changedThemeId.equals(sCurrentVipTheme)) {
            QLog.e(TAG, 1, "handleChangeTheme sCurrentVipTheme=" + sCurrentVipTheme + ", needChangeThemeId=" + changedThemeId);
            sCurrentVipTheme = changedThemeId;
            if (QQTheme.isNowSimpleUI()) {
                QQToast.makeText(activity, "\u7b80\u6d01\u6a21\u5f0f\u4e0d\u652f\u6301\u7279\u6b8a\u4e3b\u9898\u54e6", 0).show();
            } else {
                setItem(3, Integer.parseInt(changedThemeId), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.theme.ThemeVipBehavior.1
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public void onUpdate(int i3, boolean z16, Object obj) {
                        boolean z17;
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder("setVasTheme onUpdate");
                            sb5.append(" type=");
                            sb5.append(i3);
                            sb5.append(",success=");
                            sb5.append(z16);
                            sb5.append(",data=");
                            if (obj == null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            sb5.append(z17);
                            if (obj instanceof UniSetRsp) {
                                sb5.append(",ret=");
                                sb5.append(((UniSetRsp) obj).ret);
                            }
                            QLog.e(ThemeVipBehavior.TAG, 1, sb5.toString());
                        }
                        if (z16 && (!(obj instanceof UniSetRsp) || ((UniSetRsp) obj).ret == 0)) {
                            final IThemeSwitchManager themeSwitchManager = VasUtil.getService().getThemeSwitchManager();
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.ThemeVipBehavior.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    ThemeVipBehavior.switchTheme(changedThemeId, themeSwitchManager, activity);
                                }
                            }, 16, null, false);
                        } else {
                            QQToast.makeText(activity, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                        }
                    }
                });
            }
        }
    }

    public static boolean handleDuplicationJump(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null || TextUtils.isEmpty(getChangedThemeId(intent, false)) || !VasToggle.BUG_109805691.isEnable(true)) {
            return true;
        }
        QLog.e(TAG, 1, "handleDuplicationJump skip Duplication");
        return false;
    }

    private static boolean isNowScreenBig() {
        boolean z16;
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        if (i3 > 1500) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d(TAG, 1, "current screen is big, not show vip splash. WidthPixels=" + i3);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setCurrentUserVip$0(boolean z16) {
        boolean z17;
        try {
            SharedPreferences preference = new ThemeMMKVPreference().getPreference();
            QLog.d(TAG, 2, "setCurrentUserVip=" + z16);
            if (z16 && VasToggle.FEATURE_THEME_VIP_SPLASH.isEnable(true) && vipThemeResExits() && !isNowScreenBig()) {
                z17 = true;
            } else {
                z17 = false;
            }
            preference.edit().putBoolean(QQTheme.THEME_VIP_SPLASH, z17).apply();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
    }

    public static void setCurrentUserVip(final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.b
            @Override // java.lang.Runnable
            public final void run() {
                ThemeVipBehavior.lambda$setCurrentUserVip$0(z16);
            }
        }, 16, null, false);
    }

    private static void setItem(int i3, int i16, BusinessObserver businessObserver) {
        IJce build = VasUtil.getService().getJceRequset().build("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniSet", "stReq", "rsp");
        UniSetReq uniSetReq = new UniSetReq();
        uniSetReq.stLogin = IJce.Util.getLoginInfo();
        UniBusinessItem uniBusinessItem = new UniBusinessItem();
        uniSetReq.stUniBusinessItem = uniBusinessItem;
        uniBusinessItem.appid = i3;
        uniBusinessItem.itemid = i16;
        build.request("uniSet", uniSetReq, new UniSetRsp(), businessObserver, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void switchTheme(String str, final IThemeSwitchManager iThemeSwitchManager, Activity activity) {
        iThemeSwitchManager.openSwitchDialog(activity);
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.ThemeVipBehavior.2
            @Override // java.lang.Runnable
            public void run() {
                IThemeSwitchManager.this.doScreenShot(ThemeVipBehavior.c());
            }
        });
        ThemeSwitcher.startSwitch(str, ThemeReporter.FROM_VIP, new IThemeSwitchCallback() { // from class: com.tencent.mobileqq.vas.theme.ThemeVipBehavior.3
            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean beforeSwitch(@Nullable ThemeLocator themeLocator) {
                return false;
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean postSwitch(int i3) {
                IThemeSwitchManager.this.onPostThemeChanged();
                return false;
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public void beginSwitch() {
            }

            @Override // com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public void onProgress(long j3, long j16) {
            }
        });
    }

    public static void updateNextShowVipSplash() {
        SharedPreferences preference = new ThemeMMKVPreference().getPreference();
        int i3 = 3;
        try {
            JSONArray optJSONArray = new JSONObject(VasToggle.FEATURE_THEME_VIP_SPLASH.getStringData("")).optJSONArray("gap");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i16 = preference.getInt(QQTheme.THEME_VIP_SPLASH_SKIP, 1);
                if (i16 > optJSONArray.length()) {
                    i3 = ((Integer) optJSONArray.get(optJSONArray.length() - 1)).intValue();
                } else {
                    i3 = ((Integer) optJSONArray.get(i16 - 1)).intValue();
                    preference.edit().putInt(QQTheme.THEME_VIP_SPLASH_SKIP, i16 + 1).apply();
                }
                QLog.d(TAG, 1, "updateNextShowVipSplash array=" + optJSONArray);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
        preference.edit().putLong(QQTheme.THEME_VIP_SPLASH_SHOW_TIME, System.currentTimeMillis() + (i3 * 86400000)).apply();
        QLog.d(TAG, 1, "updateNextShowVipSplash gap=" + i3);
    }

    public static boolean updateShouldShowVasSplash() {
        boolean z16;
        boolean z17;
        try {
            setCurrentUserVip(VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateShouldShowVasSplash,error", e16);
        }
        if (enableVipSplash() && VasToggle.FEATURE_THEME_VIP_SPLASH.isEnable(false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QQTheme.isNowThemeIsSuperTheme() && VasNormalToggle.THEME_SPLASH_ENABLE.isEnable(false)) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d(TAG, 1, "updateShouldShowVasSplash,needShowVip=" + z16 + ", needShowSuperTheme=" + z17);
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    public static void updateSvipSplashSwitch(boolean z16) {
        try {
            QLog.d(TAG, 1, "updateSVipSplashSwitch=" + z16);
            new ThemeMMKVPreference().getPreference().edit().putBoolean(QQTheme.THEME_VIP_SPLASH_SWITCH, z16).apply();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
    }

    private static boolean vipThemeResExits() {
        boolean z16;
        try {
            z16 = ((XAResBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(XAResBusiness.class)).isFileExists(getVipResId());
            if (!z16) {
                try {
                    downloadVipThemeRes();
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, e.getCause(), new Object[0]);
                    QLog.d(TAG, 2, "vipThemeResExits =" + z16);
                    return z16;
                }
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        QLog.d(TAG, 2, "vipThemeResExits =" + z16);
        return z16;
    }
}
