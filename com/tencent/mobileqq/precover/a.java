package com.tencent.mobileqq.precover;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cu;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context, String str) {
        if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("PRECOVER_SP_NAME", 0).getLong(str, -1L)) <= 86400000) {
            return false;
        }
        return true;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("http://hb.url.cn/")) {
            return str.substring(17);
        }
        if (str.startsWith("http://")) {
            return str.substring(7);
        }
        return str;
    }

    public static String c() {
        if (cu.e()) {
            return AppConstants.SDCARD_PATH + "pddata/prd/res_precover";
        }
        return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/res_precover";
    }

    public static String d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return e(str) + str2;
        }
        return null;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        return sb5.toString();
    }

    public static void f(Context context, String str) {
        context.getSharedPreferences("PRECOVER_SP_NAME", 0).edit().putLong(str, System.currentTimeMillis()).commit();
    }
}
