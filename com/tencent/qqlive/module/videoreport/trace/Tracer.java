package com.tencent.qqlive.module.videoreport.trace;

import android.support.v4.util.ArrayMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Tracer {
    private static Map<String, TraceData> sDataMap = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TraceData {
        int count;
        long lastBeginNano;
        long totalNano;

        TraceData() {
            this.count = 0;
            this.totalNano = 0L;
            this.lastBeginNano = -1L;
        }
    }

    public static void begin(String str) {
        fetchData(str).lastBeginNano = System.nanoTime();
    }

    public static void clear() {
        sDataMap.clear();
    }

    public static long end(String str) {
        long nanoTime = System.nanoTime();
        TraceData fetchData = fetchData(str);
        long j3 = fetchData.lastBeginNano;
        if (j3 == -1) {
            return -1L;
        }
        fetchData.count++;
        long j16 = nanoTime - j3;
        fetchData.totalNano += j16;
        fetchData.lastBeginNano = -1L;
        return j16;
    }

    private static TraceData fetchData(String str) {
        TraceData traceData = sDataMap.get(str);
        if (traceData == null) {
            TraceData traceData2 = new TraceData();
            sDataMap.put(str, traceData2);
            return traceData2;
        }
        return traceData;
    }
}
