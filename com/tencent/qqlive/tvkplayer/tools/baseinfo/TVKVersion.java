package com.tencent.qqlive.tvkplayer.tools.baseinfo;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.qqlive.tvkplayer.tools.auth.TVKAppKeyManager;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVersion {
    public static final boolean IS_INTERNATION = false;
    public static final boolean IS_TV = false;
    public static final String PLAYER_CORE_VERSION = "V10.20.000.1248";
    private static final String TAG = "TVKPlayer[TVKVersion]";
    private static boolean sIsGotChannelId = false;
    private static String sPlayerVersion;

    public static String getAdChId() {
        if (TextUtils.isEmpty(TVKAppKeyManager.getAdChid())) {
            return "";
        }
        return TVKAppKeyManager.getAdChid();
    }

    public static String getChannelId() {
        if (TextUtils.isEmpty(TVKAppKeyManager.getChannelId())) {
            sIsGotChannelId = false;
            TVKLogUtil.w(TAG, "channel id is empty, return \"000\" instead");
            return TVKUpdateInfo.APP_ID;
        }
        sIsGotChannelId = true;
        return TVKAppKeyManager.getChannelId();
    }

    public static String getPlatform() {
        if (TextUtils.isEmpty(TVKAppKeyManager.getPlatform())) {
            return "0";
        }
        return TVKAppKeyManager.getPlatform();
    }

    public static int getPlatformInteger() {
        try {
            return Integer.valueOf(getPlatform()).intValue();
        } catch (NumberFormatException e16) {
            TVKLogUtil.e(TAG, e16);
            return 0;
        }
    }

    public static String getPlayerVersion() {
        if (!TextUtils.isEmpty(sPlayerVersion) && sIsGotChannelId) {
            return sPlayerVersion;
        }
        String[] split = PLAYER_CORE_VERSION.split("\\.");
        if (4 == split.length) {
            sPlayerVersion = split[0] + "." + split[1] + "." + getChannelId() + "." + split[3];
        } else {
            sPlayerVersion = PLAYER_CORE_VERSION;
        }
        return sPlayerVersion;
    }

    public static String getSdtfrom() {
        if (TextUtils.isEmpty(TVKAppKeyManager.getSdtfrom())) {
            return "";
        }
        return TVKAppKeyManager.getSdtfrom();
    }

    public static boolean isQQLiveMainApp() {
        return "com.tencent.qqlive".equalsIgnoreCase(TVKVcSystemInfo.getPackageName());
    }

    public static int versionCompare(String str, String str2) throws Exception {
        int i3;
        int length;
        try {
            int i16 = 1;
            if (str.startsWith("V")) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            String[] split = str.substring(i3).split("\\.");
            if (!str2.startsWith("V")) {
                i16 = 0;
            }
            String[] split2 = str2.substring(i16).split("\\.");
            if (split.length > 0 && split2.length > 0) {
                if (split.length > split2.length) {
                    length = split2.length;
                } else {
                    length = split.length;
                }
                for (int i17 = 0; i17 < length; i17++) {
                    if (!split[i17].equals(split2[i17])) {
                        return Integer.parseInt(split[i17]) - Integer.parseInt(split2[i17]);
                    }
                }
                return 0;
            }
            throw new Exception("invalid version format.");
        } catch (Exception e16) {
            throw e16;
        }
    }
}
