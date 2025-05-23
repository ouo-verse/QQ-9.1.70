package c.t.m.g;

import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes.dex */
public class k1 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile SharedPreferences f29816a;

    public static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (k1.class) {
            if (f29816a == null) {
                f29816a = o0.a().getSharedPreferences("LocationSDK", 0);
            }
            sharedPreferences = f29816a;
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
        if ("LocationSDK".equals(str)) {
            return a();
        }
        return o0.a().getSharedPreferences(str, "com.tencent.mobileqq".equals(o0.a().getPackageName()) ? 4 : 0);
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

    public static void b(SharedPreferences sharedPreferences, String str, String str2) {
        b(sharedPreferences, str, (Object) r0.b(str2));
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        String str3 = (String) a(sharedPreferences, str, (Object) "");
        if (h1.a(str3)) {
            return str2;
        }
        String a16 = r0.a(str3);
        if (h1.a(a16)) {
            b(sharedPreferences, str, (Object) "");
        }
        return h1.a(a16) ? str2 : a16;
    }
}
