package com.tencent.mobileqq.weiyun.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.WeiYunMiniAppProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).getString(k(str, str2), null);
    }

    public static boolean b(Context context, String str, String str2, boolean z16) {
        String string = context.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).getString(k(str, str2), null);
        if (string != null) {
            return Boolean.valueOf(string).booleanValue();
        }
        return z16;
    }

    public static int c(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.MINI_APP_WEIYUN_ENTRY, 0);
    }

    public static String d(Context context, String str) {
        return WeiYunMiniAppProcessor.c().f202410d;
    }

    public static int e(Context context, String str) {
        return WeiYunMiniAppProcessor.c().f202411e;
    }

    public static int f(Context context, String str) {
        return WeiYunMiniAppProcessor.c().f202412f;
    }

    public static String g(Iterator<String> it) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                if (i3 == 0) {
                    stringBuffer.append(next);
                } else {
                    stringBuffer.append(":");
                    stringBuffer.append(next);
                }
                i3++;
            }
        }
        return stringBuffer.toString();
    }

    public static void h(Context context, String str, String str2) {
        context.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).edit().remove(k(str, str2)).commit();
    }

    public static void i(Context context, String str, String str2, String str3) {
        context.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", 0).edit().putString(k(str, str2), str3).commit();
    }

    public static List<String> j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(":");
        if (split != null && split.length > 0) {
            ArrayList arrayList = new ArrayList(split.length);
            Collections.addAll(arrayList, split);
            return arrayList;
        }
        return new ArrayList();
    }

    private static String k(String str, String str2) {
        return str + str2;
    }
}
