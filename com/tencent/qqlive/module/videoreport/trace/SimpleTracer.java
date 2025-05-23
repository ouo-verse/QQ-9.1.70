package com.tencent.qqlive.module.videoreport.trace;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SimpleTracer {
    private static volatile Map<String, Long> BEGIN_MAP = null;
    private static final String TAG = "SimpleTracer";

    public static void begin(String str) {
        if (!VideoReportInner.getInstance().isDebugMode()) {
            return;
        }
        getBeginMap().put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static long end(String str) {
        Long remove;
        if (!VideoReportInner.getInstance().isDebugMode() || (remove = getBeginMap().remove(str)) == null) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis() - remove.longValue();
        if (VideoReport.isDebugMode()) {
            Log.i(TAG, str + " cost " + currentTimeMillis + " ms.");
        }
        return currentTimeMillis;
    }

    private static Map<String, Long> getBeginMap() {
        if (BEGIN_MAP != null) {
            return BEGIN_MAP;
        }
        synchronized (SimpleTracer.class) {
            if (BEGIN_MAP == null) {
                BEGIN_MAP = new ConcurrentHashMap();
            }
        }
        return BEGIN_MAP;
    }
}
