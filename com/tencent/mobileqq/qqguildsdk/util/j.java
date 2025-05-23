package com.tencent.mobileqq.qqguildsdk.util;

import android.text.TextUtils;
import com.tencent.BuildConfig;
import com.tencent.mobileqq.util.SSODebugUtil;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j {
    public static String a(String str) {
        if (str != null && str.length() > 11264) {
            return str.substring(0, 10240);
        }
        return str;
    }

    public static String b(Exception exc) {
        if (exc == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(exc.getMessage());
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            if (stackTraceElement != null && stackTraceElement.getClassName() != null && (stackTraceElement.getClassName().startsWith(BuildConfig.LIBRARY_PACKAGE_NAME) || stackTraceElement.getClassName().startsWith("mqq.app"))) {
                sb5.append("\n");
                sb5.append(stackTraceElement.toString());
            }
        }
        return sb5.toString();
    }

    public static boolean c(String str, long j3) {
        if (!i(str) && j3 != 0) {
            return true;
        }
        h.v("GProUtil", "isCategoryLegal", "guildId \uff1a" + str + "\uff0c categoryId \uff1a" + j3);
        return false;
    }

    public static boolean d(String str, long j3, String str2) {
        if (!TextUtils.isEmpty(str2) && c(str, j3)) {
            return true;
        }
        return false;
    }

    public static boolean e(String str, String str2) {
        if (!i(str) && !TextUtils.isEmpty(str2) && !str2.equals("")) {
            return true;
        }
        h.v("GProUtil", "isCategoryLegal", "guildId \uff1a" + str + "\uff0c categoryName \uff1a" + str2);
        return false;
    }

    public static boolean f(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        int i3;
        if (i(str)) {
            h.v("GProUtil", "isCategoryLegalForSort", "guildId \uff1a" + str);
            return false;
        }
        if (bVar != null && bVar.e() != null) {
            i3 = bVar.e().size() + 0;
        } else {
            i3 = 0;
        }
        if (list != null) {
            Iterator<com.tencent.mobileqq.qqguildsdk.data.b> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().h()) {
                    it.remove();
                }
            }
            i3 += list.size();
        }
        if (i3 < 0) {
            return false;
        }
        return true;
    }

    public static boolean g(String str, List<Long> list) {
        if (!i(str) && list != null && list.size() != 0) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                if (longValue == 0) {
                    h.v("GProUtil", "isCategoryLegal", "guildId \uff1a" + str + "\uff0c categoryId \uff1a" + longValue);
                    it.remove();
                }
            }
            if (list.size() <= 0) {
                return false;
            }
            return true;
        }
        h.v("GProUtil", "isCategoryLegal", "guildId \uff1a" + str);
        return false;
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0")) {
            return true;
        }
        return false;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return !TextUtils.isDigitsOnly(str);
    }

    public static boolean j(List<String> list) {
        if (list == null) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (i(it.next())) {
                it.remove();
            }
        }
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
            return true;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong != 0 && parseLong < 100000000000000000L) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    public static boolean l() {
        return new File(SSODebugUtil.SSO_CONF_DIR, SSODebugUtil.SSO_CONF_FILENAME).exists();
    }
}
