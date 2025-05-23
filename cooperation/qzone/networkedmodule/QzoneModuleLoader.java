package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneModuleLoader {
    public static final String TAG = "QzoneModuleLoader";
    private static boolean sIsLibLoaded = false;

    public static boolean loadModuleDex(String str, Context context, ClassLoader classLoader, String str2, QzoneModuleRecord qzoneModuleRecord) {
        return loadModuleDex(str, context, classLoader, str2, qzoneModuleRecord, false);
    }

    public static boolean loadModuleDex2MainClassLoader(String str, Context context, String str2, QzoneModuleRecord qzoneModuleRecord) {
        long nanoTime = System.nanoTime();
        boolean loadModuleDex = loadModuleDex(str, context, QzoneModuleConst.class.getClassLoader(), str2, qzoneModuleRecord, true);
        if (loadModuleDex) {
            long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
            QLog.i("QzoneModuleLoader", 1, "----------resolve class successful, cost:" + nanoTime2);
            QzoneModuleReport.reportResolveClassRes(qzoneModuleRecord, "1", nanoTime2);
        } else {
            QLog.e("QzoneModuleLoader", 1, "loadModule failed: " + str);
            QzoneModuleReport.reportResolveClassRes(qzoneModuleRecord, "0", (System.nanoTime() - nanoTime) / 1000000);
        }
        return loadModuleDex;
    }

    public static boolean loadModuleDex(String str, Context context, ClassLoader classLoader, String str2, QzoneModuleRecord qzoneModuleRecord, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneModuleLoader", 2, "classloader is: " + classLoader + " , classloader class is: " + classLoader.getClass());
        }
        QLog.d("QzoneModuleLoader", 4, "load module: " + str);
        boolean z17 = false;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        long nanoTime = System.nanoTime();
        try {
            z17 = QzoneModuleInjector.inject(context, classLoader, str, str2, z16);
        } catch (Throwable th5) {
            QLog.e("QzoneModuleLoader", 1, "inject failed, catch an exception:", th5);
        }
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
        QLog.d("QzoneModuleLoader", 1, "loaded module success ? " + z17 + " --module:  " + str + " , classloader: " + classLoader + ", cost:" + nanoTime2);
        if (qzoneModuleRecord != null) {
            QzoneModuleReport.reportLoadRes(qzoneModuleRecord, z17, nanoTime2);
        }
        return z17;
    }
}
