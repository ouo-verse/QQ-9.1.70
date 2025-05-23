package com.tencent.qqmini.sdk.core;

import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AdFrequencyLimit {
    public static int ERROR_CODE_2001 = 2001;
    public static int ERROR_CODE_2002 = 2002;
    public static int ERROR_CODE_2003 = 2003;
    private static int GAME_START_LIMIT = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_AD_GAME_START_LIMIT, 30) * 1000;
    private static int LAST_SHOW_LIMIT = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_AD_LAST_SHOW_LIMIT, 60) * 1000;
    private static long sGameStartTime = -1;
    private static boolean sRewardVideoAdShowing = false;
    private static long sRewardVideoAdLastShowedTime = -1;
    private static boolean sInterstitialAdShowing = false;
    private static long sInterstitialAdLastShowedTime = -1;

    public static int canShowInterstitialAdNow() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sGameStartTime < GAME_START_LIMIT) {
            return ERROR_CODE_2001;
        }
        long j3 = currentTimeMillis - sRewardVideoAdLastShowedTime;
        int i3 = LAST_SHOW_LIMIT;
        if (j3 >= i3 && currentTimeMillis - sInterstitialAdLastShowedTime >= i3) {
            if (!sRewardVideoAdShowing && !sInterstitialAdShowing) {
                return 0;
            }
            return ERROR_CODE_2003;
        }
        return ERROR_CODE_2002;
    }

    public static void setInterstitialAdShowing(boolean z16) {
        sInterstitialAdShowing = z16;
        if (z16) {
            sInterstitialAdLastShowedTime = System.currentTimeMillis();
        }
    }

    public static void setOnStartTime(long j3) {
        sGameStartTime = j3;
    }

    public static void setRewardVideoAdShowing(boolean z16) {
        sRewardVideoAdShowing = z16;
        if (z16) {
            sRewardVideoAdLastShowedTime = System.currentTimeMillis();
        }
    }

    public void reset() {
        sRewardVideoAdShowing = false;
        sRewardVideoAdLastShowedTime = -1L;
        sInterstitialAdShowing = false;
        sInterstitialAdLastShowedTime = -1L;
    }
}
