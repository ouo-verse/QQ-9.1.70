package com.tencent.ark.mmkv;

import com.tencent.ark.ArkEnvironmentManager;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MMKVUtils {
    public static void addAppConfigKey2Set(IMMKV immkv, String str) {
        Set<String> set = immkv.getSet(MMKVConstans.APP_CONFIG_KEY_SET, null);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(str);
        immkv.putSet(MMKVConstans.APP_CONFIG_KEY_SET, set);
    }

    public static String fixAppBizConfigKey(String str) {
        if (ArkEnvironmentManager.getInstance().isTestEnv()) {
            return MMKVConstans.APP_BIZ_CONFIG_KEY_PREFIX_DEBUG;
        }
        return MMKVConstans.APP_BIZ_CONFIG_KEY_PREFIX + str;
    }

    public static String fixAppCacheConfigKey(String str) {
        if (ArkEnvironmentManager.getInstance().isTestEnv()) {
            return MMKVConstans.APP_CONFIG_CACHE_KEY_PREFIX_DEBUG;
        }
        return MMKVConstans.APP_CONFIG_CACHE_KEY_PREFIX + str;
    }

    public static String fixAppConfigKey(String str) {
        return getAppConfigPrefix() + str;
    }

    public static String fixAppDescKey(String str) {
        return MMKVConstans.APP_DESC_KEY_PREFIX + str;
    }

    public static String fixLastUseTimeKey(String str) {
        return MMKVConstans.LAST_USE_TIME_KEY_PREFIX + str;
    }

    public static String fixUpdatePeriodKey(String str) {
        return MMKVConstans.UPDATE_PERIOD_KEY_PREFIX + str;
    }

    public static String fixUpdateRecordKey(String str) {
        return MMKVConstans.UPDATE_RECORD_KEY_PREFIX + str;
    }

    public static String fixUpdateTimeKey(String str) {
        return MMKVConstans.UPDATE_TIME_KEY_PREFIX + str;
    }

    public static Set<String> getAppConfigKeySet(IMMKV immkv) {
        return immkv.getSet(MMKVConstans.APP_CONFIG_KEY_SET, null);
    }

    public static String getAppConfigPrefix() {
        if (ArkEnvironmentManager.getInstance().isTestEnv()) {
            return MMKVConstans.APP_CONFIG_KEY_PREFIX_DEBUG;
        }
        return MMKVConstans.APP_CONFIG_KEY_PREFIX;
    }
}
