package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.api.IAnonymousService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class AnonymousRedPointUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_PROFILE_RED_POINT_GUIDE_PREFIX = "anonymous_profile_red_point_guide_";
    private static final String KEY_SETTING_ME_RED_POINT_GUIDE_PREFIX = "anonymous_setting_me_red_point_guide_";
    private static final String RED_POINT_VALID_VERSION = "8.4.8";
    private static final String TAG = "AnonymousRedPointUtils";

    public AnonymousRedPointUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean checkRedPointValidVersion() {
        boolean equals = RED_POINT_VALID_VERSION.equals(AppSetting.f99551k);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("checkRedPointValidVersion valid=%s", Boolean.valueOf(equals)));
        }
        return equals;
    }

    public static void checkToCleanSettingMeRedPointGuide(AppInterface appInterface) {
        boolean showSettingMeRedPointGuide = showSettingMeRedPointGuide(appInterface);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("checkToCleanSettingMeRedPointGuide showRedPoint=%s", Boolean.valueOf(showSettingMeRedPointGuide)));
        }
        if (showSettingMeRedPointGuide && appInterface != null) {
            BaseApplication app = appInterface.getApp();
            String currentAccountUin = appInterface.getCurrentAccountUin();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(app).edit();
            edit.putBoolean(KEY_SETTING_ME_RED_POINT_GUIDE_PREFIX + currentAccountUin, false);
            edit.commit();
        }
    }

    public static void cleanProfileRedPointGuide(AppInterface appInterface) {
        if (appInterface != null) {
            BaseApplication app = appInterface.getApp();
            String currentAccountUin = appInterface.getCurrentAccountUin();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(app).edit();
            edit.putBoolean(KEY_PROFILE_RED_POINT_GUIDE_PREFIX + currentAccountUin, false);
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("cleanProfileRedPointGuide uin=%s", currentAccountUin));
            }
        }
    }

    public static boolean showProfileRedPointGuide(AppInterface appInterface) {
        String str;
        boolean z16;
        if (appInterface != null && checkRedPointValidVersion()) {
            BaseApplication app = appInterface.getApp();
            str = appInterface.getCurrentAccountUin();
            z16 = PreferenceManager.getDefaultSharedPreferences(app).getBoolean(KEY_PROFILE_RED_POINT_GUIDE_PREFIX + str, true);
        } else {
            str = null;
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("showProfileRedPointGuide uin=%s show=%s", str, Boolean.valueOf(z16)));
        }
        return z16;
    }

    public static boolean showSettingMeRedPointGuide(AppInterface appInterface) {
        String str;
        boolean z16;
        boolean z17;
        if (appInterface != null && checkRedPointValidVersion()) {
            BaseApplication app = appInterface.getApp();
            str = appInterface.getCurrentAccountUin();
            IAnonymousService iAnonymousService = (IAnonymousService) appInterface.getRuntimeService(IAnonymousService.class, "");
            if (iAnonymousService != null) {
                z16 = iAnonymousService.getSettingMeRedPointEnable();
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = PreferenceManager.getDefaultSharedPreferences(app).getBoolean(KEY_SETTING_ME_RED_POINT_GUIDE_PREFIX + str, true);
            } else {
                z17 = false;
            }
        } else {
            str = null;
            z16 = false;
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("showSettingMeRedPointGuide uin=%s enable=%s show=%s", str, Boolean.valueOf(z16), Boolean.valueOf(z17)));
        }
        return z17;
    }
}
