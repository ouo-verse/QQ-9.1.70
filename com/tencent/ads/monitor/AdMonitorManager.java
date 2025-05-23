package com.tencent.ads.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ads.monitor.AdMonitorEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdMonitorManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61654a = "AdMonitorManager";

    /* renamed from: b, reason: collision with root package name */
    private static Map f61655b = new ConcurrentHashMap();

    private static boolean a(String str, AdMonitor adMonitor) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        f61655b.put(str, adMonitor);
        return true;
    }

    public static AdMonitor getOrCreateMonitor(String str) {
        Log.i(f61654a, "getOrCreateMonitor:" + str);
        AdMonitor adMonitor = (AdMonitor) f61655b.get(str);
        if (adMonitor == null || adMonitor.isReported()) {
            adMonitor = new AdMonitor(str);
            if (!TextUtils.isEmpty(str)) {
                f61655b.put(str, adMonitor);
            }
        }
        return adMonitor;
    }

    public static void remove(AdMonitor adMonitor) {
        Log.i(f61654a, "remove:" + adMonitor.getRequestId());
        f61655b.remove(adMonitor.getRequestId());
    }

    public static void removeAll() {
        Log.i(f61654a, "removeAll");
        f61655b.clear();
    }

    public static void reportAllWhenExist() {
        Log.i(f61654a, "reportAllWhenExist");
        for (String str : f61655b.keySet()) {
            AdMonitor adMonitor = (AdMonitor) f61655b.get(str);
            if (adMonitor != null) {
                adMonitor.onAdPlaySkip(AdMonitorEvent.SkipCause.USER_RETURN);
                Log.i(f61654a, "reportAllWhenExist - monitor.onAdPlaySkip:" + str);
            } else {
                Log.w(f61654a, "reportAllWhenExist - monitor is null:" + str);
            }
        }
    }
}
