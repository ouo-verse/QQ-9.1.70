package com.tencent.smtt.sdk.core.dynamicinstall;

import android.content.Context;
import com.tencent.smtt.sdk.ProgressListener;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DynamicInstallManager {

    /* renamed from: a, reason: collision with root package name */
    e f369300a;

    public DynamicInstallManager(Context context) {
        this.f369300a = new e(context, null, "x5WebView");
    }

    public final void cancelInstall() {
        this.f369300a.b();
    }

    public final void clearCache() {
        this.f369300a.c();
    }

    public final boolean needUpdateLicense() {
        return this.f369300a.d();
    }

    public final void registerListener(ProgressListener progressListener) {
        this.f369300a.a(progressListener);
    }

    public final void startInstall() {
        new BaseThread() { // from class: com.tencent.smtt.sdk.core.dynamicinstall.DynamicInstallManager.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                DynamicInstallManager.this.f369300a.a();
            }
        }.start();
    }

    public DynamicInstallManager(Context context, File file) {
        this.f369300a = new e(context, file, "x5webView");
    }
}
