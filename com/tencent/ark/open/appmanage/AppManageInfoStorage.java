package com.tencent.ark.open.appmanage;

import android.text.TextUtils;
import android.util.Base64;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.Logger;
import com.tencent.ark.mmkv.IMMKV;
import com.tencent.ark.mmkv.MMKVManager;
import com.tencent.ark.mmkv.MMKVUtils;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AppManageInfoStorage {
    private static final String PREF_APP_DESC = "ArkAppDescCache";
    public static final String PREF_UPDATE_TIME_RECORD = "ArkLocalAppUpdateTime";
    private static final String TAG = "ArkApp.ArkAppMgr";

    public static long getAppLastUseTime(String str, String str2) {
        long j3;
        if (TextUtils.isEmpty(str)) {
            return System.currentTimeMillis();
        }
        String appConfigCacheKey = ArkAppConfigMgr.getAppConfigCacheKey(str, str2);
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV != null) {
            j3 = arkMMKV.getLong(MMKVUtils.fixLastUseTimeKey(appConfigCacheKey), 0L);
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            updateAppLastUseTime(str, str2);
            j3 = System.currentTimeMillis();
        }
        if (ArkAppMgr.DEBUG && j3 <= 0) {
            throw new AssertionError("Assertion failed");
        }
        return j3;
    }

    public static boolean isAppNotRecentUse(String str, String str2) {
        if (System.currentTimeMillis() - getAppLastUseTime(str, str2) >= 2592000000L) {
            return true;
        }
        return false;
    }

    public static String loadAppDesc(String str) {
        IMMKV arkMMKV;
        if (TextUtils.isEmpty(str) || (arkMMKV = MMKVManager.getInstance().getArkMMKV()) == null) {
            return null;
        }
        return arkMMKV.getString(MMKVUtils.fixAppDescKey(str), null);
    }

    public static byte[] loadAppSignature(String str) {
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            return null;
        }
        try {
            return Base64.decode(arkMMKV.getString(MMKVUtils.fixUpdateTimeKey(str + "_sign"), WidgetCacheConstellationData.BAD), 0);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void saveAppDesc(String str, String str2) {
        IMMKV arkMMKV;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (arkMMKV = MMKVManager.getInstance().getArkMMKV()) == null) {
            return;
        }
        arkMMKV.putString(MMKVUtils.fixAppDescKey(str), str2);
    }

    public static void saveAppSignature(String str, byte[] bArr) {
        IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
        if (arkMMKV == null) {
            Logger.logE("ArkApp.ArkAppMgr", "saveAppSignature sp is null");
            return;
        }
        arkMMKV.putString(MMKVUtils.fixUpdateTimeKey(str + "_sign"), Base64.encodeToString(bArr, 0));
    }

    public static void updateAppLastUseTime(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.appmanage.AppManageInfoStorage.1
            @Override // java.lang.Runnable
            public void run() {
                String appConfigCacheKey = ArkAppConfigMgr.getAppConfigCacheKey(str, str2);
                IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
                if (arkMMKV == null) {
                    Logger.logE("ArkApp.ArkAppMgr", "updateAppLastUseTime sp is null");
                } else {
                    arkMMKV.putLong(MMKVUtils.fixLastUseTimeKey(appConfigCacheKey), System.currentTimeMillis());
                }
            }
        });
    }
}
