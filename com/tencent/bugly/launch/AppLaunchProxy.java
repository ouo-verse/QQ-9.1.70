package com.tencent.bugly.launch;

import android.content.Context;

/* loaded from: classes5.dex */
public class AppLaunchProxy implements AppLaunch {
    private final AppLaunch impl = new AppLaunchImpl();

    /* loaded from: classes5.dex */
    private static class InstanceWrapper {
        private static final AppLaunchProxy INSTANCE = new AppLaunchProxy();

        InstanceWrapper() {
        }
    }

    public static AppLaunch getAppLaunch() {
        return InstanceWrapper.INSTANCE;
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void addTag(String str) {
        this.impl.addTag(str);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void endSpanFromLaunch(String str) {
        this.impl.endSpanFromLaunch(str);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void install(Context context) {
        this.impl.install(context);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void reportAppFullLaunch() {
        this.impl.reportAppFullLaunch();
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void spanEnd(String str) {
        this.impl.spanEnd(str);
    }

    @Override // com.tencent.bugly.launch.AppLaunch
    public void spanStart(String str, String str2) {
        this.impl.spanStart(str, str2);
    }
}
