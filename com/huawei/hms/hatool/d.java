package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: P */
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes2.dex */
public class d {
    public static long a(Context context, String str, String str2, long j3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            v.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j3;
        }
        SharedPreferences b16 = b(context, str);
        return b16 != null ? b16.getLong(str2, j3) : j3;
    }

    private static SharedPreferences b(Context context, String str) {
        return context.getSharedPreferences(c(context, str), 0);
    }

    public static String c(Context context, String str) {
        String packageName = context.getPackageName();
        String n3 = a1.n("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(n3)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + n3;
    }

    public static String a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            v.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences b16 = b(context, str);
        return b16 != null ? b16.getString(str2, str3) : str3;
    }

    public static void b(Context context, String str, String str2, long j3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            v.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b16 = b(context, str);
        if (b16 != null) {
            SharedPreferences.Editor edit = b16.edit();
            edit.putLong(str2, j3);
            edit.commit();
        }
    }

    public static Map<String, ?> a(Context context, String str) {
        return b(context, str).getAll();
    }

    public static void b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            v.e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b16 = b(context, str);
        if (b16 != null) {
            SharedPreferences.Editor edit = b16.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static void a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else {
            if (strArr != null) {
                SharedPreferences b16 = b(context, str);
                if (b16 != null) {
                    SharedPreferences.Editor edit = b16.edit();
                    if (strArr.length == 0) {
                        edit.clear();
                        edit.commit();
                        return;
                    }
                    for (String str3 : strArr) {
                        if (b16.contains(str3)) {
                            edit.remove(str3);
                            edit.commit();
                        }
                    }
                    return;
                }
                return;
            }
            str2 = "clearData(): No data need to be deleted,keys is null";
        }
        v.f("hmsSdk", str2);
    }
}
