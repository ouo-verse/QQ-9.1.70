package com.tencent.bugly.common.utils;

import android.os.Debug;
import com.tencent.bugly.common.config.configs.CommonConfig;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GcInfoStatHelper {
    private static final int BYTES_PER_KILOBYTE = 1024;
    private static final int GC_INFO_COUNT_LIMIT = 100;
    private static final int MAX_GC_INFO_COUNT = 10;
    private static final String TAG = "GcInfoStatHelper";
    private WeakReference<GcNotify> gcNotifyWeakReference;
    private GcInfo lastGcInfo;
    private final LinkedBlockingDeque<GcInfo> linkedBlockingDeque;
    private final AtomicBoolean sStartedStat;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class GcInfo {
        public static final String BLOCK_GC_COUNT_RATE_HISTOGRAM = "block_histogram";
        public static final String GC_COUNT_RATE_HISTOGRAM = "histogram";
        public static final String HAS_ALLOC_SIZE = "alloc_size";
        public static final String HAS_FREE_SIZE = "free_size";
        public static final String TIME_STAMP = "gc_time_stamp";
        public static final String TOTAL_BLOCK_GC_COUNT = "block_gc_count";
        public static final String TOTAL_BLOCK_GC_TIME = "block_gc_time";
        public static final String TOTAL_GC_COUNT = "count";
        public static final String TOTAL_GC_TIME = "time";
        public static final String TOTAL_HEAP_SIZE = "heap_size";
        public long totalGcCount = -1;
        public long totalGcTimeInMs = -1;
        public long totalBlockGcCount = -1;
        public long totalBlockGcTimeInMs = -1;
        public long hasAllocSizeInByte = -1;
        public long hasFreeSizeInByte = -1;
        public String gcCountRateHistogram = "";
        public String blockGcCountRateHistogram = "";
        public long timeStamp = -1;
        public long totalHeapSize = -1;
        public long isBlockGc = 2;
        public long gcTime = -1;

        public GcInfo() {
        }

        private boolean isValid() {
            long j3 = this.totalGcCount;
            if (j3 >= 0 && j3 >= this.totalBlockGcCount) {
                long j16 = this.totalGcTimeInMs;
                if (j16 >= 0 && j16 >= this.totalBlockGcTimeInMs) {
                    return true;
                }
            }
            return false;
        }

        public JSONObject toJSONObject() {
            if (!isValid()) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.totalGcCount);
                jSONObject.put("time", this.totalGcTimeInMs);
                jSONObject.put(TOTAL_BLOCK_GC_COUNT, this.totalBlockGcCount);
                jSONObject.put(TOTAL_BLOCK_GC_TIME, this.totalBlockGcTimeInMs);
                jSONObject.put(HAS_ALLOC_SIZE, this.hasAllocSizeInByte / 1024);
                jSONObject.put(TOTAL_HEAP_SIZE, this.totalHeapSize / 1024);
                jSONObject.put(HAS_FREE_SIZE, this.hasFreeSizeInByte / 1024);
                jSONObject.put(GC_COUNT_RATE_HISTOGRAM, this.gcCountRateHistogram);
                jSONObject.put(BLOCK_GC_COUNT_RATE_HISTOGRAM, this.blockGcCountRateHistogram);
                jSONObject.put(TIME_STAMP, this.timeStamp);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class GcNotify {
        GcNotify() {
        }

        protected void finalize() throws Throwable {
            super.finalize();
            GcInfoStatHelper.getInstance().notifyGC();
            GcInfoStatHelper.this.gcNotifyWeakReference = new WeakReference(new GcNotify());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class SInstanceHolder {
        static final GcInfoStatHelper INSTANCE = new GcInfoStatHelper();

        SInstanceHolder() {
        }
    }

    private JSONObject buildGcItem(GcInfo gcInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_block", gcInfo.isBlockGc);
            jSONObject.put("time", gcInfo.gcTime);
            jSONObject.put("size", (gcInfo.hasAllocSizeInByte - gcInfo.hasFreeSizeInByte) / 1024);
            jSONObject.put("max_size", gcInfo.totalHeapSize / 1024);
            jSONObject.put("time_stamp", gcInfo.timeStamp);
            return jSONObject;
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
            return new JSONObject();
        }
    }

    public static GcInfoStatHelper getInstance() {
        return SInstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GcInfo updateGcInfoWithStats() {
        char c16;
        try {
            Map<String, String> runtimeStats = Debug.getRuntimeStats();
            GcInfo gcInfo = new GcInfo();
            gcInfo.timeStamp = System.currentTimeMillis();
            gcInfo.totalHeapSize = Runtime.getRuntime().totalMemory();
            for (Map.Entry<String, String> entry : runtimeStats.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Logger logger = Logger.f365497g;
                logger.i(TAG, key + ProgressTracer.SEPARATOR + value);
                switch (key.hashCode()) {
                    case -1376014683:
                        if (key.equals("art.gc.gc-count")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -453042801:
                        if (key.equals("art.gc.blocking-gc-count")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case -127282065:
                        if (key.equals("art.gc.bytes-freed")) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case 384293087:
                        if (key.equals("art.gc.gc-count-rate-histogram")) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case 678622797:
                        if (key.equals("art.gc.blocking-gc-time")) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 1203038839:
                        if (key.equals("art.gc.gc-time")) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 1982822581:
                        if (key.equals("art.gc.blocking-gc-count-rate-histogram")) {
                            c16 = 7;
                            break;
                        }
                        break;
                    case 2086314558:
                        if (key.equals("art.gc.bytes-allocated")) {
                            c16 = 4;
                            break;
                        }
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                        gcInfo.totalGcCount = Long.parseLong(value);
                        break;
                    case 1:
                        gcInfo.totalGcTimeInMs = Long.parseLong(value);
                        break;
                    case 2:
                        gcInfo.totalBlockGcCount = Long.parseLong(value);
                        break;
                    case 3:
                        gcInfo.totalBlockGcTimeInMs = Long.parseLong(value);
                        break;
                    case 4:
                        gcInfo.hasAllocSizeInByte = Long.parseLong(value);
                        break;
                    case 5:
                        gcInfo.hasFreeSizeInByte = Long.parseLong(value);
                        break;
                    case 6:
                        gcInfo.gcCountRateHistogram = value;
                        break;
                    case 7:
                        gcInfo.blockGcCountRateHistogram = value;
                        break;
                    default:
                        logger.i(TAG, key + " is not parsed, and it's value is " + value);
                        break;
                }
            }
            return gcInfo;
        } catch (Throwable unused) {
            return null;
        }
    }

    public GcInfo getLastGcInfo() {
        return this.lastGcInfo;
    }

    protected void notifyGC() {
        ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.bugly.common.utils.GcInfoStatHelper.1
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                long j16;
                long j17;
                try {
                    GcInfo updateGcInfoWithStats = GcInfoStatHelper.this.updateGcInfoWithStats();
                    if (updateGcInfoWithStats == null) {
                        return;
                    }
                    if (GcInfoStatHelper.this.lastGcInfo != null) {
                        if (updateGcInfoWithStats.totalBlockGcCount > GcInfoStatHelper.this.lastGcInfo.totalBlockGcCount) {
                            j3 = 1;
                        } else {
                            j3 = 0;
                        }
                        updateGcInfoWithStats.isBlockGc = j3;
                        if (j3 == 1) {
                            j16 = updateGcInfoWithStats.totalBlockGcTimeInMs;
                            j17 = GcInfoStatHelper.this.lastGcInfo.totalBlockGcTimeInMs;
                        } else {
                            j16 = updateGcInfoWithStats.totalGcTimeInMs;
                            j17 = GcInfoStatHelper.this.lastGcInfo.totalGcTimeInMs;
                        }
                        updateGcInfoWithStats.gcTime = j16 - j17;
                    }
                    GcInfoStatHelper.this.lastGcInfo = updateGcInfoWithStats;
                    synchronized (GcInfoStatHelper.this.linkedBlockingDeque) {
                        if (!GcInfoStatHelper.this.linkedBlockingDeque.offer(updateGcInfoWithStats)) {
                            GcInfoStatHelper.this.linkedBlockingDeque.poll();
                            GcInfoStatHelper.this.linkedBlockingDeque.offer(updateGcInfoWithStats);
                        }
                    }
                } catch (Throwable th5) {
                    Logger.f365497g.c(GcInfoStatHelper.TAG, th5);
                }
            }
        }, 0L);
    }

    public void startGCStat(String str) {
        try {
            Logger logger = Logger.f365497g;
            logger.i(TAG, "try to start gc stat for " + str);
            if (this.sStartedStat.get()) {
                logger.i(TAG, "sStartedStat is true");
                return;
            }
            if (!AndroidVersion.isOverM()) {
                logger.i(TAG, "don't support gc stat below Android M");
                return;
            }
            k d16 = ConfigFetcher.g().d("common");
            if (!(d16 instanceof CommonConfig)) {
                logger.i(TAG, "it is not CommonConfig");
                return;
            }
            if (!((CommonConfig) d16).isEnableGcInfo() && !DebugConfig.INSTANCE.inDebugMode()) {
                logger.i(TAG, "startGCStat fail for config");
                return;
            }
            logger.i(TAG, "start gc stat success");
            this.sStartedStat.compareAndSet(false, true);
            this.gcNotifyWeakReference = new WeakReference<>(new GcNotify());
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }

    public JSONObject toJSON(long j3, long j16) {
        JSONObject jSONObject;
        if (j3 <= j16 && !this.linkedBlockingDeque.isEmpty()) {
            synchronized (this.linkedBlockingDeque) {
                try {
                    Iterator<GcInfo> descendingIterator = this.linkedBlockingDeque.descendingIterator();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    int i3 = 0;
                    while (descendingIterator.hasNext() && i3 < 10) {
                        GcInfo next = descendingIterator.next();
                        long j17 = next.timeStamp;
                        if (j17 >= j3 && j17 <= j16) {
                            if (i3 == 0) {
                                jSONObject2 = next.toJSONObject();
                            }
                            jSONArray.mo162put(buildGcItem(next));
                            i3++;
                        }
                    }
                    jSONObject = new JSONObject();
                    if (i3 > 0) {
                        jSONObject.put("statistic", jSONObject2);
                        jSONObject.put("detail", jSONArray);
                    }
                } catch (Throwable unused) {
                    return new JSONObject();
                }
            }
            return jSONObject;
        }
        return new JSONObject();
    }

    GcInfoStatHelper() {
        this.gcNotifyWeakReference = null;
        this.sStartedStat = new AtomicBoolean(false);
        this.linkedBlockingDeque = new LinkedBlockingDeque<>(100);
        this.lastGcInfo = null;
    }
}
