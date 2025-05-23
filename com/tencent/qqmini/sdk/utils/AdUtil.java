package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.util.List;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class AdUtil {
    public static final String AD_GDT_COOKIE_PRE = "gdt_cookie";
    public static final int BANNER_AD_TYPE = 0;
    public static final int MINI_APP_AD_BOX_AD_TYPE = 7;
    public static final int MINI_APP_AD_IN_FEEDS_AD_TYPE = 6;
    public static final int MINI_APP_BANNER_AD_TYPE = 2;
    public static final int MINI_APP_CARD_AD_TYPE = 5;
    public static final int MINI_APP_FLIP_PAGE_AD_TYPE = 4;
    public static final int MINI_APP_SPLASH_SCREEN_AD_TYPE = 14;
    public static final int MINI_APP_VIDEO_AD_TYPE = 3;
    public static final int MINI_GAME_AD_BOX_AD_TYPE = 8;
    public static final int MINI_GAME_BUILDING_BLOCK_AD_TYPE = 13;
    public static final int MINI_GAME_NEW_BANNER_AD_TYPE = 9;
    public static final int MINI_GAME_SPLASH_SCREEN_AD_TYPE = 15;
    public static final int REWARDED_AD_LOAD_INTERNAL_EXP_KEY = 106492;
    public static final String TAG = "AdUtil";
    public static final int VIDEO_AD_TYPE = 1;

    private static String getGdtCookieSpKey(int i3) {
        return "gdt_cookie_" + LoginManager.getInstance().getAccount() + "_" + i3;
    }

    public static long getLoadIntervalFromExpParam(List<AdProxy.ExpParam> list) {
        long j3 = Long.MAX_VALUE;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                try {
                    if (list.get(i3).key == 106492) {
                        j3 = Long.parseLong(list.get(i3).value);
                    }
                } catch (Throwable th5) {
                    QMLog.e(TAG, "getLoadIntervalFromExpParam fail:", th5);
                }
            }
        }
        QMLog.i(AdProxy.AbsRewardVideoAdView.REALTIME_TAG, "getLoadIntervalFromExpParam loadInterval:" + j3);
        return j3;
    }

    public static String getSpAdGdtCookie(int i3) {
        return StorageUtil.getPreference().getString(getGdtCookieSpKey(i3), "");
    }

    public static void putSpAdGdtCookie(int i3, String str) {
        StorageUtil.getPreference().edit().putString(getGdtCookieSpKey(i3), str).apply();
    }
}
