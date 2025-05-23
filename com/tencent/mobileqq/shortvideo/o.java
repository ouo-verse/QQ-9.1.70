package com.tencent.mobileqq.shortvideo;

import android.os.Build;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o {
    private static void a(String str, int i3, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("MANUFACTURER", Build.MANUFACTURER);
        hashMap.put("MODEL", DeviceInfoMonitor.getModel());
        hashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
        hashMap.put("type", "" + i3);
        hashMap.put("error", "" + i16);
        StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, str, true, 0L, 0L, hashMap, "");
    }

    public static void b(int i3, int i16) {
        a("sv_resource_download_base", i3, i16);
    }

    public static void c(int i3, int i16) {
        a("sv_resource_download_qzone", i3, i16);
    }

    public static void d(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("MANUFACTURER", Build.MANUFACTURER);
        hashMap.put("MODEL", DeviceInfoMonitor.getModel());
        hashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
        hashMap.put("waite", "" + i3);
        StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, "sv_waite_record_count", true, 0L, 0L, hashMap, "");
    }
}
