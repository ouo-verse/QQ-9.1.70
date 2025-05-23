package com.tencent.tgpa.vendorpd.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            f.a("can not find app: %s , get version name failed.", str);
            str2 = null;
        }
        if (str2 == null) {
            return "0";
        }
        return str2;
    }

    public static int b(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            f.a("can not find app: %s , get version code failed.", str);
            return 0;
        }
    }
}
