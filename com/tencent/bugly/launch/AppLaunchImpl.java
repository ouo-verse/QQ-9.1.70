package com.tencent.bugly.launch;

import android.content.Context;
import com.tencent.rmonitor.launch.AppLaunchMonitor;
import com.tencent.rmonitor.launch.AppLaunchMonitorInstaller;

/* compiled from: P */
/* loaded from: classes5.dex */
class AppLaunchImpl implements AppLaunch {
    @Override // com.tencent.bugly.launch.AppLaunch
    public void addTag(String str) {
        AppLaunchMonitor.getInstance().addTag(str);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void endSpanFromLaunch(String str) {
        AppLaunchMonitor.getInstance().endSpanFromLaunch(str);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void install(Context context) {
        AppLaunchMonitorInstaller.install(context);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void reportAppFullLaunch() {
        AppLaunchMonitor.getInstance().reportAppFullLaunch();
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void spanEnd(String str) {
        AppLaunchMonitor.getInstance().spanEnd(str);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void spanStart(String str, String str2) {
        AppLaunchMonitor.getInstance().spanStart(str, str2);
    }
}
