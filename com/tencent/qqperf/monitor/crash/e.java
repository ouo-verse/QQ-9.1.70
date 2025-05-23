package com.tencent.qqperf.monitor.crash;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {
    public static SharedPreferences a(@NotNull Context context, String str, int i3) {
        QLog.d("CrashMMKVMigrateHelper", 2, "getMMKVMigratedSharePreferencesSync oldSP is " + str + "|" + i3);
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, str, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QLog.d("CrashMMKVMigrateHelper", 1, "mmkv migrate oldSP is " + str + "|" + i3);
            QMMKV.migrateToSpAdapter(context, str, i3, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }
}
