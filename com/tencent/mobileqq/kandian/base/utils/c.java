package com.tencent.mobileqq.kandian.base.utils;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T d(String str, T t16, boolean z16) {
        SharedPreferences b16 = b(b.c(), z16, true);
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RIJSPUtils", 2, "getReadInJoySpValue: sp is null");
            }
            return t16;
        }
        if (t16 instanceof String) {
            return (T) b16.getString(str, (String) t16);
        }
        if (t16 instanceof Integer) {
            return (T) Integer.valueOf(b16.getInt(str, ((Integer) t16).intValue()));
        }
        if (t16 instanceof Long) {
            return (T) Long.valueOf(b16.getLong(str, ((Long) t16).longValue()));
        }
        if (t16 instanceof Boolean) {
            return (T) Boolean.valueOf(b16.getBoolean(str, ((Boolean) t16).booleanValue()));
        }
        return t16 instanceof Float ? (T) Float.valueOf(b16.getFloat(str, ((Float) t16).floatValue())) : t16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(String str, T t16, boolean z16) {
        Object obj;
        QLog.d("RIJSPUtils", 2, "updateReadInJoySpValue: key - " + str + " value - " + t16);
        SharedPreferences b16 = b(b.c(), z16, true);
        if (b16 == null) {
            QLog.d("RIJSPUtils", 2, "updateReadInJoySpValue: sp is null");
            return;
        }
        SharedPreferences.Editor edit = b16.edit();
        if (t16 instanceof String) {
            edit.putString(str, (String) t16);
        } else if (t16 instanceof Integer) {
            edit.putInt(str, ((Integer) t16).intValue());
        } else if (t16 instanceof Long) {
            edit.putLong(str, ((Long) t16).longValue());
        } else if (t16 instanceof Float) {
            edit.putFloat(str, ((Float) t16).floatValue());
        } else if (t16 instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) t16).booleanValue());
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateReadInJoySpValue: unsupported type ");
            if (t16 != 0) {
                obj = t16.getClass();
            } else {
                obj = "null";
            }
            sb5.append(obj);
            QLog.d("RIJSPUtils", 2, sb5.toString());
        }
        a(edit, true);
    }

    public static <T> T c(String str, T t16) {
        return (T) d(str, t16, true);
    }

    public static <T> void e(String str, T t16) {
        f(str, t16, true);
    }

    public static void a(SharedPreferences.Editor editor, boolean z16) {
        if (z16) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static SharedPreferences b(AppRuntime appRuntime, boolean z16, boolean z17) {
        if (appRuntime == null) {
            return null;
        }
        String str = "readinjoy_sp";
        if (z16) {
            str = "readinjoy_sp_" + appRuntime.getAccount();
        }
        return BaseApplicationImpl.getApplication().getSharedPreferences(str, z17 ? 4 : 0);
    }
}
