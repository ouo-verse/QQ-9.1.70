package com.tencent.mobileqq.utils;

import android.os.Build;
import com.tencent.commonsdk.soload.SoLoadReport;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ed implements SoLoadReport {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f307695a = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    private static void a(String str, String str2, long j3, int i3, boolean z16) {
        String currentUin;
        HashMap hashMap = new HashMap();
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
        hashMap.put("processName", MobileQQ.processName);
        hashMap.put("time", f307695a.format(new Date(System.currentTimeMillis())));
        hashMap.put("libName", str2);
        hashMap.put("costTime", j3 + "");
        hashMap.put("reportLoadType", str);
        hashMap.put(QzoneIPCModule.RESULT_CODE, String.valueOf(i3));
        hashMap.put("tooManyLibsException", String.valueOf(z16));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "0";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        QLog.d("SoLoadReportImpl", 1, "doReportBeacon, param: " + hashMap);
        QQBeaconReport.report(currentUin, "so_load_from_so_load_core", hashMap);
    }

    private static void b(String str, String str2, long j3, int i3) {
        a(str, str2, j3, i3, false);
    }

    private static void c(String str) {
        a("too_many_lib_exception", str, 0L, 0, true);
    }

    @Override // com.tencent.commonsdk.soload.SoLoadReport
    public void report(int i3, String str, long j3) {
        boolean z16;
        String str2;
        if ((i3 & 2097152) == 2097152) {
            if ((i3 & 1048576) == 1048576) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = "no_crc_load_suc";
            } else {
                str2 = "no_crc_load_failed";
            }
            if (ds.d(1, 10000) == 1) {
                b(str2, str, j3, i3);
                return;
            }
            return;
        }
        if ((i3 & 8192) != 8192) {
            ds.d(1, 10000);
            b("default_config_load", str, j3, i3);
            return;
        }
        if ((i3 & 512) != 512) {
            ds.d(1, 10000);
            b("lib_load", str, j3, i3);
        } else if ((i3 & 32) != 32) {
            b("classloader_load", str, j3, i3);
        } else if ((i3 & 4) != 4) {
            b("apk_load", str, j3, i3);
        } else {
            b("all_failed", str, j3, i3);
        }
    }

    @Override // com.tencent.commonsdk.soload.SoLoadReport
    public void reportThrowable(Throwable th5, String str) {
        String message;
        if (th5 != null && str != null && (th5 instanceof UnsatisfiedLinkError) && (message = th5.getMessage()) != null && !message.contains("too many libraries")) {
            c(str);
        }
    }
}
