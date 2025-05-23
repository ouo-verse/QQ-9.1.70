package com.tencent.comic.utils;

import android.os.Build;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {
    public static void a(AppRuntime appRuntime, int i3, int i16, long j3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i16 + "|");
        sb5.append(i3 + "|");
        sb5.append(j3 + "|");
        sb5.append(Build.BRAND + "|");
        sb5.append(DeviceInfoMonitor.getModel() + "|");
        sb5.append(Build.VERSION.RELEASE);
        BaseQQAppInterface baseQQAppInterface = appRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) appRuntime : null;
        if (QLog.isColorLevel()) {
            QLog.d("PreloadSuccessRateReporter", 2, "[preloadSuccessRate]: " + sb5.toString());
        }
        DcReportUtil.c(baseQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|preloadSuccessRate", sb5.toString(), true);
    }
}
