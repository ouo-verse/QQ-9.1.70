package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class SharedPreUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SharedPreUtils";

    /* loaded from: classes15.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f247309a = "common_sp_for_msf";
    }

    public SharedPreUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T> T genericGet(Context context, String str, String str2, T t16) {
        String str3;
        if (Build.VERSION.SDK_INT >= 24) {
            str3 = PreferenceManager.getDefaultSharedPreferencesName(context);
        } else {
            str3 = context.getPackageName() + "_preferences";
        }
        return (T) get(context, str3, str, str2, t16);
    }

    public static Object get(Context context, String str, String str2, Object obj) {
        String str3;
        if (Build.VERSION.SDK_INT >= 24) {
            str3 = PreferenceManager.getDefaultSharedPreferencesName(context);
        } else {
            str3 = context.getPackageName() + "_preferences";
        }
        return get(context, str3, str, str2, obj);
    }

    public static void set(Context context, String str, boolean z16, String str2, Object obj) {
        String str3;
        if (Build.VERSION.SDK_INT >= 24) {
            str3 = PreferenceManager.getDefaultSharedPreferencesName(context);
        } else {
            str3 = context.getPackageName() + "_preferences";
        }
        set(context, str3, str, z16, str2, obj);
    }

    public static Object get(Context context, String str, String str2, String str3, Object obj) {
        return get(context, str, str2, str3, obj, 0);
    }

    public static void set(Context context, String str, String str2, boolean z16, String str3, Object obj) {
        set(context, str, str2, z16, str3, obj, 0);
    }

    public static Object get(Context context, String str, String str2, String str3, Object obj, int i3) {
        String str4;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i3);
        try {
            str4 = str3 + str2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
            if (obj.getClass() == String.class) {
                obj = sharedPreferences.getString(str4, (String) obj);
            } else {
                if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
                    if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                        if (obj.getClass() == Long.TYPE || obj.getClass() == Long.class) {
                            obj = Long.valueOf(sharedPreferences.getLong(str4, ((Long) obj).longValue()));
                        }
                    }
                    obj = Float.valueOf(sharedPreferences.getFloat(str4, ((Float) obj).floatValue()));
                }
                obj = Boolean.valueOf(sharedPreferences.getBoolean(str4, ((Boolean) obj).booleanValue()));
            }
            return obj;
        }
        obj = Integer.valueOf(sharedPreferences.getInt(str4, ((Integer) obj).intValue()));
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0091 A[Catch: Exception -> 0x0099, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0008, B:5:0x001f, B:8:0x0028, B:10:0x0030, B:12:0x0091, B:15:0x0095, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x004f, B:27:0x0058, B:29:0x0060, B:31:0x0068, B:32:0x0072, B:33:0x007c, B:34:0x0086), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095 A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0008, B:5:0x001f, B:8:0x0028, B:10:0x0030, B:12:0x0091, B:15:0x0095, B:17:0x0036, B:19:0x003e, B:22:0x0047, B:24:0x004f, B:27:0x0058, B:29:0x0060, B:31:0x0068, B:32:0x0072, B:33:0x007c, B:34:0x0086), top: B:2:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void set(Context context, String str, String str2, boolean z16, String str3, Object obj, int i3) {
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
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}
