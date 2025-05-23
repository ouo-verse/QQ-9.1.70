package com.tencent.gamematrix.gmcg.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes6.dex */
public class CGSharedPrefUtil {
    public static void clear(Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.clear();
        edit.apply();
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (obj instanceof Boolean) {
            return Boolean.valueOf(defaultSharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof String) {
            return defaultSharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Float) {
            return Float.valueOf(defaultSharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(defaultSharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof Integer) {
            return Long.valueOf(defaultSharedPreferences.getLong(str, ((Integer) obj).intValue()));
        }
        return defaultSharedPreferences.getString(str, obj.toString());
    }

    public static void put(Context context, String str, Object obj) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else {
            edit.putString(str, obj.toString());
        }
        edit.apply();
    }

    public static void remove(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.remove(str2);
        edit.apply();
    }

    public static void remove(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove(str);
        edit.apply();
    }

    public static Object get(Context context, String str, String str2, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        if (obj instanceof Integer) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Integer) obj).intValue()));
        }
        return sharedPreferences.getString(str2, obj.toString());
    }

    public static void put(Context context, String str, String str2, Object obj) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (obj instanceof Boolean) {
            edit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            edit.putString(str2, (String) obj);
        } else if (obj instanceof Float) {
            edit.putFloat(str2, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str2, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str2, ((Integer) obj).intValue());
        } else {
            edit.putString(str2, obj.toString());
        }
        edit.apply();
    }
}
