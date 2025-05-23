package c.t.m.sapp.c;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static volatile SharedPreferences f30186a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f30187b;

    public static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (p.class) {
            if (f30186a == null) {
                f30186a = f30187b.getSharedPreferences("TLocationSDK", 0);
            }
            sharedPreferences = f30186a;
        }
        return sharedPreferences;
    }

    public static void b(String str, String str2, Object obj) {
        b(a(str), str2, obj);
    }

    public static void b(SharedPreferences sharedPreferences, String str, Object obj) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        edit.apply();
    }

    public static SharedPreferences a(String str) {
        if ("TLocationSDK".equals(str)) {
            return a();
        }
        return f30187b.getSharedPreferences(str, "com.tencent.mobileqq".equals(f30187b.getPackageName()) ? 4 : 0);
    }

    public static Object a(String str, String str2, Object obj) {
        return a(a(str), str2, obj);
    }

    public static Object a(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }
}
