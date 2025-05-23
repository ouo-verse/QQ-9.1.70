package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

/* loaded from: classes23.dex */
public class AppBrandCmdProxy {
    private static volatile AppBrandCmdProxy instance;
    private static byte[] lock = new byte[0];
    private AppBrandProxy mAppBrandProxy;

    AppBrandCmdProxy() {
    }

    public static AppBrandCmdProxy g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AppBrandCmdProxy();
                }
            }
        }
        return instance;
    }

    public synchronized void sendCmd(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        AppBrandProxy appBrandProxy = this.mAppBrandProxy;
        if (appBrandProxy != null) {
            appBrandProxy.sendCmd(str, bundle, miniCmdCallback);
        }
    }

    public synchronized void setAppBrandProxy(AppBrandProxy appBrandProxy) {
        if (this.mAppBrandProxy != null) {
            return;
        }
        this.mAppBrandProxy = appBrandProxy;
    }
}
