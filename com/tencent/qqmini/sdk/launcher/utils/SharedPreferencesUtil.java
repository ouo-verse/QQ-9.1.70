package com.tencent.qqmini.sdk.launcher.utils;

import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@MiniKeep
/* loaded from: classes23.dex */
public class SharedPreferencesUtil {
    public static final String PRE_MINI_APP = "pre_miniapp";
    public static final String TAG = "SharedPreferencesUtil";
    private static SharedPreferences sPreMiniAppSp;

    public static SharedPreferences getPreference() {
        if (sPreMiniAppSp == null) {
            if (AppLoaderFactory.g().getContext() != null) {
                sPreMiniAppSp = AppLoaderFactory.g().getContext().getSharedPreferences("pre_miniapp", 4);
            } else {
                QMLog.e(TAG, " getPreference AppLoaderFactory.g().getContext() is null ");
            }
        }
        return sPreMiniAppSp;
    }
}
