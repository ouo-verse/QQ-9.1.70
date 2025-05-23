package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.VersionedPackage;

/* loaded from: classes25.dex */
public class PackageManagerInvokeRedirect {
    public static ActivityInfo getActivityInfo(ClassLoader classLoader, ComponentName componentName, int i3) throws PackageManager.NameNotFoundException {
        return getPluginPackageManager(classLoader).getActivityInfo(componentName, i3);
    }

    public static ApplicationInfo getApplicationInfo(ClassLoader classLoader, String str, int i3) throws PackageManager.NameNotFoundException {
        return getPluginPackageManager(classLoader).getApplicationInfo(str, i3);
    }

    public static PackageInfo getPackageInfo(ClassLoader classLoader, String str, int i3) throws PackageManager.NameNotFoundException {
        return getPluginPackageManager(classLoader).getPackageInfo(str, i3);
    }

    private static PluginPackageManager getPluginPackageManager(ClassLoader classLoader) {
        return PluginPartInfoManager.getPluginInfo(classLoader).packageManager;
    }

    public static ProviderInfo resolveContentProvider(ClassLoader classLoader, String str, int i3) {
        return getPluginPackageManager(classLoader).resolveContentProvider(str, i3);
    }

    @TargetApi(26)
    public static PackageInfo getPackageInfo(ClassLoader classLoader, VersionedPackage versionedPackage, int i3) throws PackageManager.NameNotFoundException {
        String packageName;
        PluginPackageManager pluginPackageManager = getPluginPackageManager(classLoader);
        packageName = versionedPackage.getPackageName();
        return pluginPackageManager.getPackageInfo(packageName, i3);
    }
}
