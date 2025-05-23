package com.tencent.bugly.common.reporter.builder;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.constants.SPKey;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public class UniqueIDHelper {
    private String lastUniqueID = null;

    public String getGuid() {
        String uuid = UUID.randomUUID().toString();
        if (!TextUtils.isEmpty(uuid)) {
            return uuid.replaceAll("-", "");
        }
        return uuid;
    }

    public String getLastUniqueIDFromCrashSp(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(Constants.SP_DEVICE_ID, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return sharedPreferences.getString("androidid", "");
        }
        return null;
    }

    public String getLastUniqueIDFromSp(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(SPKey.KEY_LAST_SAVE_UNIQUE_ID, "");
        }
        return null;
    }

    public String getUniqueID(String str, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(this.lastUniqueID)) {
            return this.lastUniqueID;
        }
        String lastUniqueIDFromCrashSp = getLastUniqueIDFromCrashSp(sharedPreferences2);
        if (!TextUtils.isEmpty(lastUniqueIDFromCrashSp)) {
            return lastUniqueIDFromCrashSp;
        }
        String lastUniqueIDFromSp = getLastUniqueIDFromSp(sharedPreferences);
        if (!TextUtils.isEmpty(lastUniqueIDFromSp)) {
            return lastUniqueIDFromSp;
        }
        return getGuid();
    }

    public void updateLastUniqueID(String str, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(this.lastUniqueID, str)) {
            this.lastUniqueID = str;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(SPKey.KEY_LAST_SAVE_UNIQUE_ID, this.lastUniqueID).apply();
            }
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putString(Constants.SP_DEVICE_ID, this.lastUniqueID).apply();
            }
        }
    }
}
