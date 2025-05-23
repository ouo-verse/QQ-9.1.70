package com.tencent.tmdownloader.internal.downloadservice;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.p;
import com.tencent.tmassistantbase.util.r;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageInfo packageArchiveInfo = GlobalUtil.getInstance().getContext().getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.applicationInfo.packageName;
            }
            return null;
        } catch (Exception e16) {
            r.a("AppUtils", "getApkPackageName>>>", e16);
            return null;
        }
    }

    public static boolean b(String str) {
        Uri uri;
        try {
            if (TextUtils.isEmpty(str)) {
                r.c("AppUtils", "localAPKPath is empty, return false");
                return false;
            }
            if (!new File(str).exists()) {
                r.c("AppUtils", "file not exist, return false");
                return false;
            }
            if (TextUtils.isEmpty(a(str))) {
                r.c("AppUtils", "package invaild del file, return false");
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                return false;
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            int i3 = GlobalUtil.getInstance().getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 24 && i3 >= 24) {
                uri = (Uri) p.f("android.support.v4.content.FileProvider").a("getUriForFile", GlobalUtil.getInstance().getContext(), "com.tencent.mobileqq.fileprovider", new File(str)).a();
                intent.addFlags(1);
                intent.addFlags(2);
            } else {
                uri = null;
            }
            if (uri == null) {
                uri = Uri.fromFile(new File(str));
            }
            r.b("AppUtils", "uri:" + uri);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            GlobalUtil.getInstance().getContext().startActivity(intent);
            r.b("AppUtils", "sdk installApp success");
            return true;
        } catch (Exception e16) {
            r.a("AppUtils", "installApp>>>", e16);
            return false;
        }
    }

    public static boolean a(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(GlobalUtil.getInstance().getContext().getPackageManager(), str, 0).versionCode >= i3;
        } catch (Throwable unused) {
            return false;
        }
    }
}
