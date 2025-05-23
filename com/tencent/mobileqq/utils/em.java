package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class em {

    /* renamed from: b, reason: collision with root package name */
    private static volatile em f307731b;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f307732a;

    em() {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "theme", "common_mmkv_configurations");
        this.f307732a = fromSpAdapter;
        if (!fromSpAdapter.getBoolean(ThemeConstants.MMKV_THEME_SP_MIGRATE, false)) {
            QLog.d("ThemePreferenceManager", 1, "migrate theme sp to mmkv");
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), "theme", "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean(ThemeConstants.MMKV_THEME_SP_MIGRATE, true).apply();
        }
    }

    public static em b() {
        if (f307731b == null) {
            synchronized (em.class) {
                if (f307731b == null) {
                    f307731b = new em();
                }
            }
        }
        return f307731b;
    }

    public SharedPreferences a() {
        return this.f307732a;
    }
}
