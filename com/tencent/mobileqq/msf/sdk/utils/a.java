package com.tencent.mobileqq.msf.sdk.utils;

import android.app.ActivityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long a() {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            try {
                activityManager.getMemoryInfo(memoryInfo);
            } catch (Exception e16) {
                QLog.w(DeviceInfoUtils.TAG, 1, e16.getMessage(), e16.getCause());
            }
            return memoryInfo.availMem;
        }
        return -1L;
    }

    public static void b() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime != null) {
            QLog.d("AppMemoryInfo", 1, "appMaxMem:" + ((runtime.maxMemory() / 1024) / 1024) + "M|appTotalMem:" + ((runtime.totalMemory() / 1024) / 1024) + "M|appFreeMem:" + ((runtime.freeMemory() / 1014) / 1014) + "M");
        }
    }

    public static void c() {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            QLog.d("SysMemoryInfo", 1, "sysTotalMem:" + ((memoryInfo.totalMem / 1024) / 1024) + "M|sysAvailMem:" + ((memoryInfo.availMem / 1024) / 1024) + "M|sysThreshold:" + ((memoryInfo.threshold / 1014) / 1014) + "M|isLowMem:" + memoryInfo.lowMemory);
        }
    }
}
