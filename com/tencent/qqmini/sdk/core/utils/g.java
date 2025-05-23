package com.tencent.qqmini.sdk.core.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes23.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f348081a = false;

    private static void a(File file, boolean z16) {
        if (z16) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void b(Context context) {
        if (AppLoaderFactory.g().isMainProcess()) {
            QMLog.d("WebViewUtils", "setWebViewMultiProcess isMainProcess!");
            return;
        }
        if (f348081a) {
            QMLog.d("WebViewUtils", "sHasWebViewSetDataDirSuffix is true!");
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            f348081a = true;
            QMLog.d("WebViewUtils", "SDK_INT is not need set setDataDirectorySuffix!");
            return;
        }
        String processName = AppLoaderFactory.g().getProcessName();
        try {
            WebView.setDataDirectorySuffix(processName);
            f348081a = true;
            QMLog.d("WebViewUtils", "setWebViewMultiProcess: processName=" + processName);
        } catch (Throwable th5) {
            QMLog.e("WebViewUtils", "setWebViewMultiProcess exception!", th5);
        }
        if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isUseWebViewTryLockOrRecreateFile() && Build.VERSION.SDK_INT == 32 && context != null) {
            c(context, "_" + processName);
            QMLog.d("WebViewUtils", "setWebViewMultiProcess use tryLockOrRecreateFile!");
        }
    }

    @TargetApi(28)
    private static void c(Context context, String str) {
        File dataDir;
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        dataDir = context.getDataDir();
        sb5.append(dataDir.getAbsolutePath());
        sb5.append("/app_webview");
        sb5.append(str);
        sb5.append("/webview_data.lock");
        File file = new File(sb5.toString());
        if (file.exists()) {
            try {
                FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else {
                    a(file, file.delete());
                }
            } catch (Exception e16) {
                QMLog.e("WebViewUtils", "tryLockOrRecreateFile error!", e16);
                if (file.exists()) {
                    z16 = file.delete();
                } else {
                    z16 = false;
                }
                a(file, z16);
            }
        }
    }
}
