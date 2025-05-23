package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeSwitchUtil {
    public static final String FROM_LOGIN_RESULT = "301";
    private static final String SWITCH_SIMPLE_DELAY_NAME = "switchSimpleDelay";
    public static final String TAG = "ThemeSwitchUtil";
    public static final String THEME_KEY_PREVIOUS_THEME_ID = "previousThemeId";
    public static final String THEME_KEY_PREVIOUS_THEME_VERSION = "previousThemeVersion";
    public static final String THEME_KEY_THEME_DOWNLOADNIGHT_USER = "nightmodedownload_uin";

    public static Bundle getPreviousThemeIdVersion(AppRuntime appRuntime) {
        Bundle bundle = new Bundle();
        String weekLoopTheme = ThemeUtil.getWeekLoopTheme(appRuntime);
        if (TextUtils.isEmpty(weekLoopTheme)) {
            SharedPreferences preferences = appRuntime.getPreferences();
            String string = preferences.getString(THEME_KEY_PREVIOUS_THEME_ID, "1000");
            String string2 = preferences.getString(THEME_KEY_PREVIOUS_THEME_VERSION, "0");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ThemeSwitchUtil getPreviousThemeIdVersion,themeID=" + string + MttLoader.QQBROWSER_PARAMS_VERSION + string2);
            }
            bundle.putString("themeID", string);
            bundle.putString("version", string2);
        } else {
            bundle.putString("themeID", weekLoopTheme);
            bundle.putString("version", ThemeUtil.getUserCurrentThemeVersion(appRuntime));
        }
        return bundle;
    }

    public static Bundle getUserDownload(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", ThemeUtil.getThemePreferences(context).getString(THEME_KEY_THEME_DOWNLOADNIGHT_USER, ""));
        return bundle;
    }

    public static Boolean setPreviousThemeIdVersion(AppRuntime appRuntime, String str, String str2) {
        String account = appRuntime.getAccount();
        if (account == null) {
            account = "noLogin";
        }
        SharedPreferences sharedPreferences = appRuntime.getApplication().getSharedPreferences(account, 4);
        String account2 = appRuntime.getAccount();
        String string = sharedPreferences.getString(THEME_KEY_PREVIOUS_THEME_ID, "1000");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(THEME_KEY_PREVIOUS_THEME_ID, str);
        edit.putString(THEME_KEY_PREVIOUS_THEME_VERSION, str2);
        QLog.d(TAG, 1, "ThemeSwitchUtil setPreviousThemeIdVersion,uin=" + account2 + ",oldPreviousThemeId=" + string + ",set new themeId=" + str);
        return Boolean.valueOf(edit.commit());
    }

    public static boolean setUserDownload(Context context, String str) {
        SharedPreferences themePreferences = ThemeUtil.getThemePreferences(context);
        String string = themePreferences.getString(THEME_KEY_THEME_DOWNLOADNIGHT_USER, "");
        SharedPreferences.Editor edit = themePreferences.edit();
        edit.putString(THEME_KEY_THEME_DOWNLOADNIGHT_USER, str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setUserDownload ,curruin=" + str + ",oldPreviousUser=" + string);
        }
        return edit.commit();
    }
}
