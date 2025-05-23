package com.tencent.rmonitor.base.config.data;

import android.text.TextUtils;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f365317a = new HashMap<>();

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            HashMap<String, String> hashMap = f365317a;
            if (hashMap.isEmpty()) {
                b();
            }
            String str2 = hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return str2 + "-" + str;
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    private static void b() {
        HashMap<String, String> hashMap = f365317a;
        hashMap.put(BuglyMonitorName.FLUENCY_METRIC, "looper");
        hashMap.put(BuglyMonitorName.FLUENCY_METRIC, "looper");
        hashMap.put(BuglyMonitorName.LOOPER_STACK, "looper");
        hashMap.put("work_thread_lag", "looper");
        hashMap.put(BuglyMonitorName.MEMORY_JAVA_CEILING, "memory");
        hashMap.put(BuglyMonitorName.MEMORY_JAVA_LEAK, "memory");
        hashMap.put(BuglyMonitorName.MEMORY_BIG_BITMAP, "memory");
        hashMap.put(BuglyMonitorName.FD_ANALYZE, "memory");
        hashMap.put(BuglyMonitorName.NATIVE_MEMORY_ANALYZE, "memory");
        hashMap.put(BuglyMonitorName.MEMORY_METRIC, "metric");
        hashMap.put("io", "io");
        hashMap.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, TVKNetVideoInfo.AUDIO_TRACK_DOLBY);
        hashMap.put("device", "device");
        hashMap.put("battery", "battery");
        hashMap.put(BuglyMonitorName.LAUNCH, "launch");
        hashMap.put(BuglyMonitorName.TRAFFIC, "resource");
        hashMap.put(BuglyMonitorName.TRAFFIC_DETAIL, "resource");
        hashMap.put(BuglyMonitorName.NET_QUALITY, "resource");
        hashMap.put(BuglyMonitorName.BATTERY_METRIC, "resource");
        hashMap.put(BuglyMonitorName.BATTERY_ELEMENT, "resource");
        hashMap.put(BuglyMonitorName.BATTERY_ELEMENT_METRIC, "resource");
        hashMap.put(BuglyMonitorName.PAGE_LAUNCH, "launch");
    }
}
