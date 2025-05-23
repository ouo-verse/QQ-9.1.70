package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c0 {
    public static boolean a(Context context) {
        return System.currentTimeMillis() - d.a(context, "Privacy_MY", "flashKeyTime", -1L) > 43200000;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (context.checkSelfPermission(str) == 0) {
            return false;
        }
        v.f("hmsSdk", "not have read phone permission!");
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean a(Context context, String str, int i3) {
        String str2 = d.c(context, str) + ".xml";
        long length = new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
        if (length <= i3) {
            return false;
        }
        v.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i3)));
        return true;
    }

    public static boolean a(String str, long j3, long j16) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j3 - Long.parseLong(str) > j16;
        } catch (NumberFormatException unused) {
            v.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
