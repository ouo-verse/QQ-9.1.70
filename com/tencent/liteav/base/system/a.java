package com.tencent.liteav.base.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes7.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.liteav.base.util.p<PackageInfo> f118984a = new com.tencent.liteav.base.util.p<>(b.a());

    public static String a() {
        PackageInfo a16 = f118984a.a();
        if (a16 == null) {
            return "";
        }
        return a16.packageName;
    }

    public static String b() {
        PackageInfo a16;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || (a16 = f118984a.a()) == null) {
            return "";
        }
        return applicationContext.getPackageManager().getApplicationLabel(a16.applicationInfo).toString();
    }

    public static String c() {
        PackageInfo a16 = f118984a.a();
        if (a16 == null) {
            return "";
        }
        return a16.versionName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PackageInfo d() throws Exception {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return InstalledAppListMonitor.getPackageInfo(applicationContext.getPackageManager(), applicationContext.getPackageName(), 0);
    }
}
