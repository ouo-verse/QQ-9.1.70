package com.tencent.rmonitor;

import com.tencent.bugly.library.BuglyMonitorName;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f365250a;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f365250a = hashMap;
        hashMap.put(BuglyMonitorName.FLUENCY_METRIC, 101);
        hashMap.put(BuglyMonitorName.LOOPER_STACK, 102);
        hashMap.put("work_thread_lag", 158);
    }

    public static String a(int i3) {
        for (Map.Entry<String, Integer> entry : f365250a.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == i3) {
                return entry.getKey();
            }
        }
        return null;
    }
}
