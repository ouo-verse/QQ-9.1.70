package com.tencent.ams.mosaic.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                if (intent.resolveActivity(packageManager) == null) {
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                f.c("AppUtils", "resolveActivity error.", th5);
            }
        }
        return false;
    }

    private static String b(Context context) {
        String g16 = com.tencent.ams.mosaic.f.k().g();
        if (TextUtils.isEmpty(g16)) {
            return context.getPackageName() + ".fileprovider";
        }
        return g16;
    }

    public static boolean c(Context context, String str) {
        Uri uri;
        if (context != null && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.addFlags(268435456);
                    intent.addFlags(64);
                    intent.addFlags(1);
                    String b16 = b(context);
                    f.b h16 = com.tencent.ams.mosaic.f.k().h();
                    if (h16 != null) {
                        uri = h16.a(context, file, intent);
                    } else {
                        uri = null;
                    }
                    if (uri == null) {
                        uri = FileProvider.getUriForFile(context, b16, file);
                    }
                    if (uri == null) {
                        uri = Uri.fromFile(file);
                    }
                    intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    context.startActivity(intent);
                    return true;
                } catch (Throwable th5) {
                    f.c("AppUtils", "install error.", th5);
                }
            }
        }
        return false;
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                if (InstalledAppListMonitor.getPackageInfo(packageManager, str, 0) == null) {
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                f.c("AppUtils", "getPackageInfo error.", th5);
            }
        }
        return false;
    }

    public static boolean e(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (g(context, str, str2)) {
            f.e("AppUtils", "openAppByScheme success scheme:" + str + ", package:" + str2);
            return true;
        }
        return f(context, str2);
    }

    private static boolean f(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    f.e("AppUtils", "openAppByPackageName success packageName:" + str);
                    return true;
                }
                f.h("AppUtils", "openAppByPackageName failed, not found intent for package:" + str);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean g(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
                intent.addFlags(268435456);
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }
}
