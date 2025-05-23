package com.tencent.qqlive.tvkplayer.tpplayer.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.manager.TPMgr;

/* loaded from: classes23.dex */
public class TVKPlayerStrategy {
    public static final String HARDWARE_ACCELERATE_CRASH = "hardware_accelerate_crash";
    public static final String HARDWARE_ACCELERATE_STATE = "hardware_accelerate_state";
    public static final String HA_CRASH_COUNT = "ha_crash_count";
    public static final String HA_TURN_OFF_COUNT = "ha_turn_off_count";
    public static final String HA_TURN_OFF_FOR_TIMEOUT = "ha_turn_off_for_timeout";
    public static final String SELFPLAYER_CRASH_COUNT = "qqlive_selfplayer_crash_count";
    public static final String SELFPLAYER_CRASH_STATE = "qqlive_selfplayer_crash_state";
    private static final String TAG = "TVKPlayer[TVKPlayerStrategy]";
    private static int isInBlackListForSelfPlayer = -1;
    private static boolean sHasTurnOffMediaCodecForInitTimeout = false;
    private static int sMediaCodecInitContinuousTimeoutCount;

    public static synchronized int getMaxMediaCodecInitTimeoutCount() {
        int i3;
        synchronized (TVKPlayerStrategy.class) {
            if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.ha_init_timeout_white_list)) {
                i3 = TVKMediaPlayerConfig.PlayerConfig.ha_max_init_timeout_count_for_special_device;
            } else {
                i3 = TVKMediaPlayerConfig.PlayerConfig.ha_max_init_timeout_count;
            }
        }
        return i3;
    }

    public static synchronized int getMediaCodecInitContinuousTimeoutCount() {
        int i3;
        synchronized (TVKPlayerStrategy.class) {
            i3 = sMediaCodecInitContinuousTimeoutCount;
        }
        return i3;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        try {
            return context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        } catch (Exception e16) {
            TVKLogUtil.i(TAG, "failed to get SharedPreferences, exception=" + e16);
            return null;
        }
    }

    public static String getThumbPlayerVersion() {
        String str;
        int lastIndexOf;
        try {
            str = TPMgr.getLibVersion("TPCore");
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            str = "";
        }
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) >= 0) {
            return str.substring(0, lastIndexOf + 1);
        }
        return str;
    }

    public static synchronized boolean hasHaTurnOffForTimeout() {
        synchronized (TVKPlayerStrategy.class) {
            boolean z16 = sHasTurnOffMediaCodecForInitTimeout;
            if (z16) {
                return z16;
            }
            SharedPreferences sharedPreferences = getSharedPreferences(TVKCommParams.getApplicationContext());
            if (sharedPreferences == null) {
                TVKLogUtil.e(TAG, "[hasHaTurnOffForTimeout] Failed to get SharedPreferences");
                return sHasTurnOffMediaCodecForInitTimeout;
            }
            try {
                sHasTurnOffMediaCodecForInitTimeout = sharedPreferences.getBoolean(HA_TURN_OFF_FOR_TIMEOUT, false);
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, e16);
            }
            return sHasTurnOffMediaCodecForInitTimeout;
        }
    }

    public static synchronized void increaseMediaCodecInitContinuousTimeoutCount() {
        synchronized (TVKPlayerStrategy.class) {
            sMediaCodecInitContinuousTimeoutCount++;
            if (!hasHaTurnOffForTimeout() && sMediaCodecInitContinuousTimeoutCount >= getMaxMediaCodecInitTimeoutCount()) {
                saveSpData(HA_TURN_OFF_FOR_TIMEOUT, true);
            }
            TVKLogUtil.i(TAG, "increaseMediaCodecInitContinuousTimeoutCount :" + sMediaCodecInitContinuousTimeoutCount);
        }
    }

    public static boolean isBlackListForSelfPlayer(Context context) {
        int i3 = isInBlackListForSelfPlayer;
        if (i3 != -1) {
            if (i3 == 0) {
                return false;
            }
            return true;
        }
        isInBlackListForSelfPlayer = 0;
        return false;
    }

    public static boolean isBlackListForSelfPlayerByCrash(Context context) {
        int i3 = isInBlackListForSelfPlayer;
        if (i3 != -1) {
            if (i3 != 0) {
                return true;
            }
            return false;
        }
        isInBlackListForSelfPlayer = 0;
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            TVKLogUtil.i(TAG, "[isBlackListForSelfPlayerByCrash] Failed to get SharedPreferences");
            return false;
        }
        try {
            boolean z16 = sharedPreferences.getBoolean(SELFPLAYER_CRASH_STATE, false);
            int i16 = sharedPreferences.getInt(SELFPLAYER_CRASH_STATE, 0);
            if (z16) {
                int i17 = i16 + 1;
                if (i17 > TVKMediaPlayerConfig.PlayerConfig.self_player_crash_count_to_switch) {
                    isInBlackListForSelfPlayer = 1;
                    TVKLogUtil.i(TAG, "isBlackListForSelfPlayerByCrash, crashCountInt: " + i17);
                    i17 = 0;
                } else {
                    isInBlackListForSelfPlayer = 0;
                }
                sharedPreferences.edit().putInt(SELFPLAYER_CRASH_COUNT, i17).apply();
            } else {
                isInBlackListForSelfPlayer = 0;
                sharedPreferences.edit().putInt(SELFPLAYER_CRASH_COUNT, 0).apply();
            }
            sharedPreferences.edit().putBoolean(SELFPLAYER_CRASH_STATE, false).apply();
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
        if (isInBlackListForSelfPlayer != 0) {
            return true;
        }
        return false;
    }

    public static boolean isEnabledHWDec(Context context) {
        int i3;
        boolean z16;
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            TVKLogUtil.i(TAG, "[isEnabledHWDec] Failed to get SharedPreferences");
            return true;
        }
        try {
            boolean z17 = false;
            if (!sharedPreferences.getBoolean(HARDWARE_ACCELERATE_STATE, true)) {
                TVKLogUtil.i(TAG, "[isEnabledHWDec] HA user setting: false");
                return false;
            }
            boolean z18 = sharedPreferences.getBoolean(HARDWARE_ACCELERATE_CRASH, false);
            int i16 = sharedPreferences.getInt(HA_TURN_OFF_COUNT, 0);
            int i17 = sharedPreferences.getInt(HA_CRASH_COUNT, 0);
            if (z18) {
                i3 = TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_interval;
                i17++;
                if (i17 > TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_count) {
                    sharedPreferences.edit().putBoolean(HARDWARE_ACCELERATE_STATE, false).apply();
                    z16 = false;
                    i3 = 0;
                    i17 = 0;
                } else if (i3 <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sharedPreferences.edit().putBoolean(HARDWARE_ACCELERATE_CRASH, false).apply();
            } else {
                i3 = i16 - 1;
                if (i3 < (-TVKMediaPlayerConfig.PlayerConfig.ha_crash_reset_interval)) {
                    i3 = 0;
                    i17 = 0;
                }
                if (i3 <= 0) {
                    z17 = true;
                }
                z16 = z17;
            }
            TVKLogUtil.i(TAG, "[isEnabledHWDec]isCrash:" + z18 + ", crashCount:" + i17 + ", turnOffCount:" + i3 + ", HA enabled:" + z16 + ", ha_crash_retry_interval:" + TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_interval + ", ha_crash_retry_count:" + TVKMediaPlayerConfig.PlayerConfig.ha_crash_retry_count + ", ha_crash_reset_interval:" + TVKMediaPlayerConfig.PlayerConfig.ha_crash_reset_interval);
            sharedPreferences.edit().putInt(HA_CRASH_COUNT, i17).apply();
            sharedPreferences.edit().putInt(HA_TURN_OFF_COUNT, i3).apply();
            return z16;
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            TVKLogUtil.i(TAG, "[isEnabledHWDec] failed to get user setting: true by default");
            return true;
        }
    }

    public static boolean isEnabledMediaCodec() {
        if (TVKMediaPlayerConfig.PlayerConfig.is_use_mediacodec && isEnabledHWDec(TVKCommParams.getApplicationContext())) {
            return true;
        }
        return false;
    }

    public static boolean isSelfPlayerAvailable(Context context) {
        if (!TPMgr.isSelfDevPlayerAvailable() || isBlackListForSelfPlayer(context) || isBlackListForSelfPlayerByCrash(context)) {
            return false;
        }
        return true;
    }

    public static synchronized void resetMediaCodecInitContinuousTimeoutCount() {
        synchronized (TVKPlayerStrategy.class) {
            boolean hasHaTurnOffForTimeout = hasHaTurnOffForTimeout();
            sHasTurnOffMediaCodecForInitTimeout = hasHaTurnOffForTimeout;
            if (hasHaTurnOffForTimeout) {
                saveSpData(HA_TURN_OFF_FOR_TIMEOUT, false);
            }
            sHasTurnOffMediaCodecForInitTimeout = false;
            sMediaCodecInitContinuousTimeoutCount = 0;
        }
    }

    private static void saveSpData(String str, boolean z16) {
        SharedPreferences sharedPreferences = getSharedPreferences(TVKCommParams.getApplicationContext());
        if (sharedPreferences == null) {
            TVKLogUtil.e(TAG, "[saveSpData] Failed to get SharedPreferences");
            return;
        }
        try {
            sharedPreferences.edit().putBoolean(str, z16).apply();
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }
}
