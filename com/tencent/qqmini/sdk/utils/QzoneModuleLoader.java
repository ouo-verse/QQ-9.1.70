package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QzoneModuleLoader {
    public static final String TAG = "QzoneModuleLoader";

    public static boolean loadModuleDex(String str, Context context, ClassLoader classLoader, String str2, boolean z16) {
        QMLog.d("QzoneModuleLoader", "classloader is: " + classLoader + " , classloader class is: " + classLoader.getClass());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("load module: ");
        sb5.append(str);
        QMLog.d("QzoneModuleLoader", sb5.toString());
        boolean z17 = false;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        long nanoTime = System.nanoTime();
        try {
            z17 = QzoneModuleInjector.inject(context, classLoader, str, str2, z16);
        } catch (Throwable th5) {
            QMLog.e("QzoneModuleLoader", "inject failed, catch an exception:", th5);
        }
        QMLog.d("QzoneModuleLoader", "loaded module success ? " + z17 + " --module:  " + str + " , classloader: " + classLoader + ", cost:" + ((System.nanoTime() - nanoTime) / 1000000));
        return z17;
    }
}
