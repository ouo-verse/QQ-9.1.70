package com.tencent.mobileqq.qfix;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import dalvik.system.PathClassLoader;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class QFixApplication extends Application {
    public ApplicationDelegate applicationLike;
    public String mApplicationDelegateName;

    public QFixApplication(String str) {
        this.mApplicationDelegateName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        ClassLoader classLoader = super.getClassLoader();
        if (Build.VERSION.SDK_INT >= 24 && isAndroidNPatchEnable()) {
            try {
                classLoader = AndroidNClassLoader.inject((PathClassLoader) super.getClassLoader(), this);
            } catch (Exception e16) {
                e16.printStackTrace();
                classLoader = super.getClassLoader();
            }
        }
        try {
            this.applicationLike = (ApplicationDelegate) classLoader.loadClass(this.mApplicationDelegateName).newInstance();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        this.applicationLike.proxyAttachBaseContext(context, this);
    }

    public boolean isAndroidNPatchEnable() {
        return false;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ApplicationDelegate applicationDelegate = this.applicationLike;
        if (applicationDelegate != null) {
            applicationDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.applicationLike.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ApplicationDelegate applicationDelegate = this.applicationLike;
        if (applicationDelegate != null) {
            applicationDelegate.onLowMemory();
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        ApplicationDelegate applicationDelegate = this.applicationLike;
        if (applicationDelegate != null) {
            applicationDelegate.onTerminate();
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    @TargetApi(14)
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        ApplicationDelegate applicationDelegate = this.applicationLike;
        if (applicationDelegate != null) {
            applicationDelegate.onTrimMemory(i3);
        }
    }
}
