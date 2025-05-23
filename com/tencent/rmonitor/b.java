package com.tencent.rmonitor;

import android.text.TextUtils;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f365255a;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f365255a = hashMap;
        hashMap.put(BuglyMonitorName.LOOPER_STACK, 4);
        hashMap.put(BuglyMonitorName.FLUENCY_METRIC, 8);
        hashMap.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, 2);
        hashMap.put("io", 1);
        hashMap.put("battery", 65536);
        hashMap.put("device", 4194304);
        hashMap.put(BuglyMonitorName.MEMORY_JAVA_CEILING, 128);
        hashMap.put(BuglyMonitorName.MEMORY_METRIC, 256);
        hashMap.put(BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS, 2048);
        hashMap.put(BuglyMonitorName.MEMORY_BIG_BITMAP, 131072);
        hashMap.put(BuglyMonitorName.MEMORY_JAVA_LEAK, 64);
        hashMap.put(BuglyMonitorName.FD_ANALYZE, 1048576);
        hashMap.put(BuglyMonitorName.NATIVE_MEMORY_ANALYZE, 2097152);
        hashMap.put(BuglyMonitorName.LAUNCH, 0);
        hashMap.put("work_thread_lag", 32);
        hashMap.put(BuglyMonitorName.TRAFFIC, 8388608);
        hashMap.put(BuglyMonitorName.TRAFFIC_DETAIL, 16777216);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str) && (num = f365255a.get(str)) != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(int i3) {
        for (Map.Entry<String, Integer> entry : f365255a.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == i3) {
                return entry.getKey();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> c(int i3) {
        if (i3 == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : f365255a.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && (value.intValue() & i3) != 0) {
                arrayList.add(key);
            }
        }
        return arrayList;
    }
}
