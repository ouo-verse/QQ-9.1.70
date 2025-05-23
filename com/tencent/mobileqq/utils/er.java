package com.tencent.mobileqq.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class er {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f307748a = {"KEY_DELAY_LOAD_PROXY", "KEY_ENABLE_MEMORY_LEAK", "KEY_DISABLE_NAVIGATION_BAR", "KEY_DISABLE_SAVE_PLUGIN_INFO"};

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f307749b = new ConcurrentHashMap<>(4);

    private static boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
        if (!TextUtils.isEmpty(str)) {
            if (from.decodeBool(com.tencent.mobileqq.config.aq.f202314b + str, false)) {
                return false;
            }
        }
        if (System.currentTimeMillis() - from.decodeLong("_last_crash_time_", 0L) > 1800000) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context, String str, boolean z16) {
        return c(context, str, false, z16);
    }

    public static boolean c(Context context, String str, boolean z16, boolean z17) {
        boolean z18;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[6];
            objArr[0] = "call getSwitch, Context=";
            if (context != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            objArr[1] = Boolean.valueOf(z18);
            objArr[2] = " ,key=";
            objArr[3] = str;
            objArr[4] = " judgeSafeMode=";
            objArr[5] = Boolean.valueOf(z16);
            QLog.d("TripleGraySwitchUtil", 2, objArr);
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (f307749b.containsKey(str)) {
            return f307749b.get(str).booleanValue();
        }
        if (z16 && !a(context, str)) {
            return false;
        }
        boolean decodeBool = QMMKV.from(context, "common_mmkv_configurations").decodeBool(str, z17);
        f307749b.put(str, Boolean.valueOf(decodeBool));
        if (QLog.isColorLevel()) {
            QLog.d("TripleGraySwitchUtil", 2, "key=", str, " value=", Boolean.valueOf(decodeBool), " valueWhenNotExists=", Boolean.valueOf(z17));
        }
        return decodeBool;
    }
}
