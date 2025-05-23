package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class p {
    public static <T> T a(Context context, String str, String str2, T t16) {
        String str3;
        if (Build.VERSION.SDK_INT >= 24) {
            str3 = PreferenceManager.getDefaultSharedPreferencesName(context);
        } else {
            str3 = context.getPackageName() + "_preferences";
        }
        return (T) c(context, str3, str, str2, t16);
    }

    public static Object b(Context context, String str, String str2, Object obj) {
        String str3;
        if (Build.VERSION.SDK_INT >= 24) {
            str3 = PreferenceManager.getDefaultSharedPreferencesName(context);
        } else {
            str3 = context.getPackageName() + "_preferences";
        }
        return c(context, str3, str, str2, obj);
    }

    public static Object c(Context context, String str, String str2, String str3, Object obj) {
        return d(context, str, str2, str3, obj, 0);
    }

    public static Object d(Context context, String str, String str2, String str3, Object obj, int i3) {
        Object valueOf;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i3);
        try {
            String str4 = str3 + str2;
            if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                if (obj.getClass() == String.class) {
                    valueOf = sharedPreferences.getString(str4, (String) obj);
                } else {
                    if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
                        if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                            if (obj.getClass() == Long.TYPE || obj.getClass() == Long.class) {
                                valueOf = Long.valueOf(sharedPreferences.getLong(str4, ((Long) obj).longValue()));
                            } else {
                                return obj;
                            }
                        }
                        valueOf = Float.valueOf(sharedPreferences.getFloat(str4, ((Float) obj).floatValue()));
                    }
                    valueOf = Boolean.valueOf(sharedPreferences.getBoolean(str4, ((Boolean) obj).booleanValue()));
                }
                return valueOf;
            }
            valueOf = Integer.valueOf(sharedPreferences.getInt(str4, ((Integer) obj).intValue()));
            return valueOf;
        } catch (Exception e16) {
            QLog.e("SharedPreUtil", 1, e16, new Object[0]);
            return obj;
        }
    }

    public static void e(Context context, String str, String str2, boolean z16, String str3, Object obj) {
        f(context, str, str2, z16, str3, obj, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0091 A[Catch: Exception -> 0x0099, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0008, B:5:0x001f, B:8:0x0028, B:10:0x0030, B:12:0x0091, B:15:0x0095, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x004f, B:27:0x0058, B:29:0x0060, B:31:0x0068, B:32:0x0072, B:33:0x007c, B:34:0x0086), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095 A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0008, B:5:0x001f, B:8:0x0028, B:10:0x0030, B:12:0x0091, B:15:0x0095, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x004f, B:27:0x0058, B:29:0x0060, B:31:0x0068, B:32:0x0072, B:33:0x007c, B:34:0x0086), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(Context context, String str, String str2, boolean z16, String str3, Object obj, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, i3).edit();
        try {
            String str4 = str3 + str2;
            if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                if (obj.getClass() == String.class) {
                    edit.putString(str4, (String) obj);
                } else {
                    if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
                        if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                            if (obj.getClass() == Long.TYPE || obj.getClass() == Long.class) {
                                edit.putLong(str4, ((Long) obj).longValue());
                            }
                        }
                        edit.putFloat(str4, ((Float) obj).floatValue());
                    }
                    edit.putBoolean(str4, ((Boolean) obj).booleanValue());
                }
                if (!z16) {
                    edit.apply();
                    return;
                } else {
                    edit.commit();
                    return;
                }
            }
            edit.putInt(str4, ((Integer) obj).intValue());
            if (!z16) {
            }
        } catch (Exception e16) {
            QLog.e("SharedPreUtil", 1, e16, new Object[0]);
        }
    }

    public static void g(Context context, String str, boolean z16, String str2, Object obj) {
        String str3;
        if (Build.VERSION.SDK_INT >= 24) {
            str3 = PreferenceManager.getDefaultSharedPreferencesName(context);
        } else {
            str3 = context.getPackageName() + "_preferences";
        }
        e(context, str3, str, z16, str2, obj);
    }
}
