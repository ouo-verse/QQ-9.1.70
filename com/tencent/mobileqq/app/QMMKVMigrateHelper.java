package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QMMKVMigrateHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String MIGRATE_FLAG = "_migrate_flag_";
    private static final String TAG = "QMMKVMigrateHelper";

    public QMMKVMigrateHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SharedPreferences getMMKVMigratedSharePreferencesSync(@NotNull Context context, @NotNull String str, int i3) {
        QLog.d(TAG, 2, "getMMKVMigratedSharePreferencesSync oldSP is " + str + "|" + i3);
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, str, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QLog.d(TAG, 1, "mmkv migrate oldSP is " + str + "|" + i3);
            QMMKV.migrateToSpAdapter(context, str, i3, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }
}
