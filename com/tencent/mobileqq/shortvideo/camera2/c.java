package com.tencent.mobileqq.shortvideo.camera2;

import android.os.Build;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    public static synchronized void a() {
        int i3;
        synchronized (c.class) {
            try {
                i3 = Camera2Control.R();
            } catch (Throwable th5) {
                QLog.e("Camera2Support", 1, "reportCamera2DeviceSupport exception, ", th5);
                i3 = -4;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("camera2SupportLevel", String.valueOf(i3));
            hashMap.put("osVersion", Build.VERSION.SDK_INT + "");
            hashMap.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "Camera2Support", true, 0L, 0L, hashMap, "");
        }
    }

    public static void b(int i3, int i16, long j3) {
        String str;
        if (i3 == 2) {
            str = "actCapturePhotoCamera2";
        } else {
            str = "actCapturePhotoCamera";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_type", i3 + "");
        hashMap.put(HwStatisticMgr.KEY_CTIMECOST, j3 + "");
        hashMap.put("param_size", i16 + "");
        hashMap.put("param_version", Build.VERSION.SDK_INT + "");
        hashMap.put("param_deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, true, j3, 0L, hashMap, "");
    }
}
