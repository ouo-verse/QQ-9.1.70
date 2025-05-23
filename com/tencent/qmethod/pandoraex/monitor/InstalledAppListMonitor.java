package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.VersionedPackage;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class InstalledAppListMonitor {
    private static final String NEED_AGREE_PRIVACY = "needAgreePrivacy";
    private static final String SYSTEM_CALL_INSTALL_APP_LIST = "call system api:PackageManager.";
    private static final String TAG = "InstalledAppListMonitor";
    public static List<PackageInfo> lastPackageInfoList = new ArrayList();
    public static List<ApplicationInfo> lastApplicationInfoList = new ArrayList();
    private static Map<String, Intent> lastLaunchIntentForPackage = new HashMap();
    private static List<ActivityManager.RunningAppProcessInfo> lastRunningAppProcessInfoList = new ArrayList();

    @SuppressLint({"NewApi"})
    public static List<ApplicationInfo> getInstalledApplications(PackageManager packageManager, int i3) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("appinfo", "PM#G_IN_APPS", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastApplicationInfoList = packageManager.getInstalledApplications(i3);
            MonitorReporter.handleEventReport("PM#G_IN_APPS", "");
            return lastApplicationInfoList;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastApplicationInfoList;
        }
        return new ArrayList();
    }

    @SuppressLint({"NewApi"})
    public static List<PackageInfo> getInstalledPackages(PackageManager packageManager, int i3) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("appinfo", "PM#G_IN_PKGS", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            lastPackageInfoList = packageManager.getInstalledPackages(i3);
            MonitorReporter.handleEventReport("PM#G_IN_PKGS", "");
            return lastPackageInfoList;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastPackageInfoList;
        }
        return new ArrayList();
    }

    public static Intent getLaunchIntentForPackage(PackageManager packageManager, String str) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("appinfo", "PM#G_LAU_INT_FOR_PKG", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            lastLaunchIntentForPackage.put(str, launchIntentForPackage);
            return launchIntentForPackage;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            Intent intent = lastLaunchIntentForPackage.get(str);
            if (intent == null) {
                return new Intent();
            }
            return intent;
        }
        return new Intent();
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str, int i3) throws Throwable {
        if (isSelfPackageName(str)) {
            return packageManager.getPackageInfo(str, i3);
        }
        com.tencent.qmethod.pandoraex.core.ext.netcap.k.j(str);
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").f("appinfo").c("PM#G_PKG_INFO_N").d();
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("appinfo", "PM#G_PKG_INFO_N", d16, null))) {
            return packageManager.getPackageInfo(str, i3);
        }
        if (com.tencent.qmethod.pandoraex.api.e.o(d16)) {
            return (PackageInfo) com.tencent.qmethod.pandoraex.api.e.a(d16, packageManager, str, Integer.valueOf(i3));
        }
        throw new PackageManager.NameNotFoundException(str);
    }

    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(ActivityManager activityManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("appinfo", "AM#G_RN_A_PC", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            lastRunningAppProcessInfoList = runningAppProcesses;
            return runningAppProcesses;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            return lastRunningAppProcessInfoList;
        }
        return new ArrayList();
    }

    public static boolean isSelfPackageName(String str) {
        String f16;
        if (com.tencent.qmethod.pandoraex.api.q.b() == null || TextUtils.isEmpty(str) || (f16 = com.tencent.qmethod.pandoraex.api.q.f()) == null || !f16.equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean isSpecificPackage(Intent intent) {
        if (intent != null && (intent.getComponent() != null || !TextUtils.isEmpty(intent.getPackage()))) {
            return true;
        }
        return false;
    }

    public static List<ResolveInfo> queryIntentActivities(PackageManager packageManager, Intent intent, int i3) {
        if (isSpecificPackage(intent)) {
            return packageManager.queryIntentActivities(intent, i3);
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("appinfo", "PM#QUERY_INT_ACT", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return packageManager.queryIntentActivities(intent, i3);
        }
        return new ArrayList();
    }

    public static List<ResolveInfo> queryIntentServices(PackageManager packageManager, Intent intent, int i3) {
        if (isSpecificPackage(intent)) {
            return packageManager.queryIntentServices(intent, i3);
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("appinfo", "PM#QUERY_INT_SERV", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return packageManager.queryIntentServices(intent, i3);
        }
        return new ArrayList();
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, VersionedPackage versionedPackage, int i3) throws Throwable {
        String packageName;
        PackageInfo packageInfo;
        String packageName2;
        PackageInfo packageInfo2;
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 26 && versionedPackage != null) {
            packageName2 = versionedPackage.getPackageName();
            if (isSelfPackageName(packageName2)) {
                packageInfo2 = packageManager.getPackageInfo(versionedPackage, i3);
                return packageInfo2;
            }
            com.tencent.qmethod.pandoraex.core.ext.netcap.k.j(packageName2);
        }
        vr3.a d16 = new a.C11438a().b("ban").b("cache_only").f("appinfo").c("PM#G_PKG_INFO_VP").d();
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("appinfo", "PM#G_PKG_INFO_VP", d16, null)) && i16 >= 26) {
            packageInfo = packageManager.getPackageInfo(versionedPackage, i3);
            return packageInfo;
        }
        if (com.tencent.qmethod.pandoraex.api.e.o(d16)) {
            return (PackageInfo) com.tencent.qmethod.pandoraex.api.e.a(d16, versionedPackage, Integer.valueOf(i3));
        }
        if (versionedPackage != null && i16 >= 26) {
            packageName = versionedPackage.getPackageName();
            throw new PackageManager.NameNotFoundException(packageName);
        }
        throw new PackageManager.NameNotFoundException("");
    }
}
