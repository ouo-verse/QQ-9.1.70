package com.tencent.mobileqq.qqsomonitor;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorIPCModuleApi;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(@NonNull Context context, File file) {
        if (file == null) {
            QLog.d("SoMonitor", 1, "[getSoFileFlag] soFile is null!");
            return 0;
        }
        a d16 = f.d(context, file);
        if (d16 == null) {
            QLog.d("SoMonitor", 1, "[getSoFileFlag] soFileInfo is null for " + file.getAbsolutePath());
            return 0;
        }
        return d16.f274729h;
    }

    public static String b(@NonNull Context context, File file) {
        if (file == null) {
            QLog.d("SoMonitor", 1, "[isSoFileMd5Legal] file");
            return null;
        }
        a d16 = f.d(context, file);
        if (d16 == null) {
            QLog.d("SoMonitor", 1, "[isSoFileMd5Legal] soFileMd5Info is null for " + file.getAbsolutePath());
            return null;
        }
        return d16.f274727f;
    }

    public static boolean c(@NonNull Context context, File file) {
        if (d(context, file) == 0) {
            return true;
        }
        return false;
    }

    public static int d(@NonNull Context context, File file) {
        if (file == null) {
            QLog.d("SoMonitor", 1, "[isSoFileLegal] soFile is null!");
            return -2;
        }
        if (!file.exists()) {
            QLog.d("SoMonitor", 1, "[isSoFileLegal] " + file.getAbsolutePath() + " not exist!");
            return -2;
        }
        String absolutePath = file.getAbsolutePath();
        if (g.f(absolutePath)) {
            QLog.d("SoMonitor", 1, "[isSoFileLegal] " + absolutePath + " contains '..'");
        }
        a d16 = f.d(context, file);
        if (d16 == null) {
            QLog.d("SoMonitor", 1, "[isSoFileLegal] soFileInfo is null for " + file.getName());
            return -1;
        }
        QLog.d("SoMonitor", 1, "[isSoFileLegal] " + d16);
        return d16.b(file);
    }

    public static boolean e(@NonNull Context context, File file) {
        if (file == null) {
            QLog.d("SoMonitor", 1, "[isSoFileRegistered] soFile is null!");
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        if (g.f(absolutePath)) {
            QLog.d("SoMonitor", 1, "[isSoFileRegistered] " + absolutePath + " contains '..'");
        }
        if (f.d(context, file) == null) {
            return false;
        }
        return true;
    }

    public static boolean f(@NonNull Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("SoMonitor", 1, "[isSoFileLegal] soFilePath is null or empty");
            return false;
        }
        return c(context, new File(str));
    }

    public static boolean g(@NonNull Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("SoMonitor", 1, "[isSoFileRegistered] soFilePath is null or empty");
            return false;
        }
        return e(context, new File(str));
    }

    public static void h(@NonNull Context context, File file) {
        if (file == null) {
            QLog.d("SoMonitor", 1, "[registerSoFileInfo] soFile is null!");
            return;
        }
        if (!file.exists()) {
            QLog.d("SoMonitor", 1, "[registerSoFileInfo] " + file.getAbsolutePath() + " not exist!");
            return;
        }
        String name = file.getName();
        String b16 = g.b(file);
        String d16 = g.d(b16);
        a aVar = new a(name, b16, file.length(), file.lastModified());
        aVar.f274723b = d16;
        QLog.d("SoMonitor", 1, "[registerSoFileInfo] " + aVar);
        String absolutePath = file.getAbsolutePath();
        if (g.f(absolutePath)) {
            QLog.d("SoMonitor", 1, "[registerSoFileInfo] " + absolutePath + " contains '..'");
            aVar.f274729h = aVar.f274729h | 1;
            aVar.f274728g = absolutePath;
        }
        if (g.e()) {
            f.j(context, aVar, true);
            return;
        }
        QLog.d("SoMonitor", 1, "[registerSoFileInfo] call by QIPC");
        Bundle bundle = new Bundle();
        bundle.putString(ISoMonitorIPCModuleApi.BUNDLE_KEY_SO_FILE_INFO, g.a(aVar));
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(ISoMonitorIPCModuleApi.NAME, ISoMonitorIPCModuleApi.ACTION_REGISTER_SO_FILE_INFO, bundle);
        if (callServer == null) {
            QLog.e("SoMonitor", 1, "registerSoFileInfo call by QIPC return null");
        } else if (!callServer.isSuccess()) {
            QLog.e("SoMonitor", 1, new RuntimeException("registerSoFileInfo call by QIPC failed"), new Object[0]);
        }
    }

    public static void i(@NonNull Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("SoMonitor", 1, "[registerSoFileInfo] soFilePath is null or empty");
        } else {
            h(context, new File(str));
        }
    }
}
