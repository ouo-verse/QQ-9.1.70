package com.tencent.bugly.common.reporter.upload;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.GlobalConfig;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import q04.a;

/* loaded from: classes5.dex */
public final class EntranceResponseProcessor {
    private static final String CONFIG_LATEST_UPDATE_TIME = "config_latest_update_time";
    private static final String LIMIT_CODE = "limit_code";
    static final int LIMIT_CODE_BLOCK_ALL = 100011;
    private static final String LIMIT_CODE_EXPIRATION_TIME = "limit_expiration_time";
    static final int LIMIT_CODE_NO_LIMIT = 0;
    static final int LIMIT_CODE_ONLY_ALLOW_CRASH_ANDROID_ANR_OOM = 100040;
    static final int LIMIT_CODE_ONLY_ALLOW_CRASH_ANR_OOM = 100030;
    static final int LIMIT_CODE_ONLY_ALLOW_CRASH_ANR_OOM_ERROR = 100020;
    private static final String TAG = "RMonitor_report_entrance";
    static final long TRY_REFRESH_CONFIG_INTERVAL = 60000;
    private static EntranceResponseProcessor processor;
    private final ArrayList<String> coreQualityBaseTypes;
    private final ArrayList<String> qualityBaseTypes;
    private int limitCode = 0;
    private long limitCodeExpirationTimeInSec = 0;
    private long configLatestUpdateTimeInSec = 0;
    private boolean hasLoadedFromCache = false;
    private long lastCheckTime = 0;
    private long lastConfigUpdateTimeFromApply = 0;

    protected EntranceResponseProcessor() {
        ArrayList<String> arrayList = new ArrayList<>(3);
        this.coreQualityBaseTypes = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>(4);
        this.qualityBaseTypes = arrayList2;
        arrayList.add("crash");
        arrayList.add(QZoneAppCtrlUploadFileLogic.ANR_LOG_DIRECTORY);
        arrayList2.addAll(arrayList);
        arrayList2.add("error");
    }

    private boolean checkLimitCode(String str, String str2) {
        boolean contains;
        int i3 = this.limitCode;
        if (i3 == 0) {
            return false;
        }
        if (i3 == 100011) {
            return true;
        }
        if (i3 != LIMIT_CODE_ONLY_ALLOW_CRASH_ANDROID_ANR_OOM && i3 != LIMIT_CODE_ONLY_ALLOW_CRASH_ANR_OOM) {
            if (i3 != 100020) {
                return false;
            }
            contains = this.qualityBaseTypes.contains(str);
        } else {
            contains = this.coreQualityBaseTypes.contains(str);
        }
        return !contains;
    }

    private long getConfigUpdateTimeFromConfigApply() {
        SharedPreferences b16 = a.b();
        if (b16 != null) {
            this.lastConfigUpdateTimeFromApply = b16.getLong(SPKey.KEY_CONFIG_UPDATED_TIME, 0L);
            Logger.f365497g.d(TAG, "load from cache, config_update_time_from_apply_in_sec: " + this.lastConfigUpdateTimeFromApply);
        }
        return this.lastConfigUpdateTimeFromApply;
    }

    private static EntranceResponseProcessor getProcessor() {
        if (processor == null) {
            processor = new EntranceResponseProcessor();
        }
        return processor;
    }

    private void loadFromCache() {
        SharedPreferences b16 = a.b();
        if (b16 != null) {
            this.limitCode = b16.getInt(SPKey.KEY_LIMIT_CODE, 0);
            this.limitCodeExpirationTimeInSec = b16.getLong(SPKey.KEY_LIMIT_CODE_EXPIRATION_TIME, 0L);
            this.configLatestUpdateTimeInSec = b16.getLong(SPKey.KEY_CONFIG_LATEST_UPDATE_TIME, 0L);
            this.hasLoadedFromCache = true;
            Logger.f365497g.d(TAG, "load from cache, code: " + this.limitCode + ", code_expiration_time_in_sec: " + this.limitCodeExpirationTimeInSec + ", config_latest_update_time_in_sec: " + this.configLatestUpdateTimeInSec);
        }
    }

    public static void onEntranceResponse(String str, String str2, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null) {
            if (!jSONObject.has(LIMIT_CODE) && !jSONObject.has(LIMIT_CODE_EXPIRATION_TIME) && !jSONObject.has("config_latest_update_time")) {
                if (Logger.verbos) {
                    Logger.f365497g.v(TAG, "update by [" + str + "." + str2 + "] fail for " + jSONObject);
                    return;
                }
                return;
            }
            try {
                getProcessor().process(jSONObject);
                return;
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, "update by [" + str + "." + str2 + "] fail for " + th5.getMessage());
                return;
            }
        }
        if (Logger.verbos) {
            Logger.f365497g.v(TAG, "update by [" + str + "." + str2 + "] fail for " + jSONObject);
        }
    }

    private void saveToCache() {
        SharedPreferences.Editor a16 = a.a();
        if (a16 != null) {
            a16.putInt(SPKey.KEY_LIMIT_CODE, this.limitCode);
            a16.putLong(SPKey.KEY_LIMIT_CODE_EXPIRATION_TIME, this.limitCodeExpirationTimeInSec);
            a16.putLong(SPKey.KEY_CONFIG_LATEST_UPDATE_TIME, this.configLatestUpdateTimeInSec);
            a16.apply();
            Logger.f365497g.d(TAG, "save to cache, code: " + this.limitCode + ", code_expiration_time_in_sec: " + this.limitCodeExpirationTimeInSec + ", config_latest_update_time_in_sec: " + this.configLatestUpdateTimeInSec);
        }
    }

    public static boolean whetherBlockReport(String str, String str2) {
        boolean z16;
        if (GlobalConfig.isInStandaloneMode()) {
            Logger.f365497g.w(TAG, String.format("block report %s.%s for app in standalone mode.", str, str2));
            return true;
        }
        try {
            z16 = getProcessor().whetherBlock(str, str2);
        } catch (Throwable th5) {
            th = th5;
            z16 = false;
        }
        try {
            if (z16) {
                Logger.f365497g.i(TAG, "check block report of [" + str + "." + str2 + "], block: " + z16);
            } else if (Logger.verbos) {
                Logger.f365497g.v(TAG, "check block report of [" + str + "." + str2 + "], block: " + z16);
            }
        } catch (Throwable th6) {
            th = th6;
            Logger.f365497g.e(TAG, "check block report of [" + str + "." + str2 + "] fail for " + th.getMessage());
            return z16;
        }
        return z16;
    }

    private boolean whetherRefreshConfig() {
        long j3 = this.configLatestUpdateTimeInSec;
        if (j3 == 0 || j3 == this.lastConfigUpdateTimeFromApply) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j16 = this.lastCheckTime;
        if (j16 != 0 && Math.abs(elapsedRealtime - j16) < 60000) {
            return false;
        }
        this.lastCheckTime = elapsedRealtime;
        if (this.configLatestUpdateTimeInSec <= getConfigUpdateTimeFromConfigApply()) {
            return false;
        }
        return true;
    }

    public void process(@NotNull JSONObject jSONObject) {
        if (!this.hasLoadedFromCache) {
            loadFromCache();
        }
        int optInt = jSONObject.optInt(LIMIT_CODE);
        long optLong = jSONObject.optLong(LIMIT_CODE_EXPIRATION_TIME);
        long optLong2 = jSONObject.optLong("config_latest_update_time");
        if (this.limitCode != optInt || this.limitCodeExpirationTimeInSec != optLong || this.configLatestUpdateTimeInSec != optLong2) {
            Logger.f365497g.d(TAG, "update, response: " + jSONObject);
            this.limitCode = optInt;
            this.limitCodeExpirationTimeInSec = optLong;
            this.configLatestUpdateTimeInSec = optLong2;
            saveToCache();
        }
        if (whetherRefreshConfig()) {
            ConfigFetcher.g().c();
        }
    }

    public boolean whetherBlock(String str, String str2) {
        if ("union_dau".equals(str2) && "metric".equals(str)) {
            return false;
        }
        if (!this.hasLoadedFromCache) {
            loadFromCache();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j3 = this.limitCodeExpirationTimeInSec;
        if (j3 != 0 && currentTimeMillis > j3) {
            return false;
        }
        return checkLimitCode(str, str2);
    }
}
