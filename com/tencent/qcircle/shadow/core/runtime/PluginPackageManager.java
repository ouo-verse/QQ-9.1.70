package com.tencent.qcircle.shadow.core.runtime;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;

/* loaded from: classes22.dex */
public interface PluginPackageManager {
    ActivityInfo getActivityInfo(ComponentName componentName, int i3);

    ApplicationInfo getApplicationInfo(String str, int i3);

    PackageInfo getPackageInfo(String str, int i3);

    ProviderInfo resolveContentProvider(String str, int i3);
}
