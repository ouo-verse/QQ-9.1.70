package com.tencent.ttpic.baseutils.fps;

import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BenchUtil {
    private static final int COUNT = 10;
    private static final String PREFIX = "[time]";
    private static final String TAG = "BenchUtil";
    private static Map<String, Long> startTimeMap = new HashMap();
    private static Map<String, CopyOnWriteArrayList<Long>> totalTimeMap = new HashMap();
    private static Map<String, Float> lastTimeMap = new HashMap();
    private static LoggerAgent sLogger = new LoggerAgent();
    public static boolean ENABLE_DEBUG = true;
    public static boolean ENABLE_LOG = false;
    public static boolean ENABLE_PERFORMANCE_RECORD = false;
    public static String SHOWPREVIEW_BENCH_TAG = "[showPreview]";
    public static boolean ENABLE_MEMINFO = false;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LoggerAgent {
        public void d(String str, String str2) {
            if (BenchUtil.ENABLE_LOG) {
                LogUtils.d(str, str2);
            }
        }
    }

    public static long benchEnd(String str) {
        Map<String, Long> map;
        Long l3;
        if (!ENABLE_LOG || TextUtils.isEmpty(str) || (map = startTimeMap) == null || (l3 = map.get(str)) == null) {
            return 0L;
        }
        if (ENABLE_PERFORMANCE_RECORD && str.startsWith(SHOWPREVIEW_BENCH_TAG)) {
            GLES20.glFinish();
        }
        CopyOnWriteArrayList<Long> copyOnWriteArrayList = totalTimeMap.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            totalTimeMap.put(str, copyOnWriteArrayList);
        }
        long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
        copyOnWriteArrayList.add(Long.valueOf(currentTimeMillis));
        int size = copyOnWriteArrayList.size();
        if (size >= 10) {
            float totalTime = ((float) getTotalTime(copyOnWriteArrayList)) / size;
            Log.d(TAG, PREFIX + str + MsgSummary.STR_COLON + totalTime + " ms");
            lastTimeMap.put(str, Float.valueOf(totalTime));
            copyOnWriteArrayList.clear();
        }
        return currentTimeMillis;
    }

    public static long benchEndFPS(String str) {
        Map<String, Long> map;
        Long l3;
        if (!ENABLE_DEBUG || TextUtils.isEmpty(str) || (map = startTimeMap) == null || (l3 = map.get(str)) == null) {
            return 0L;
        }
        CopyOnWriteArrayList<Long> copyOnWriteArrayList = totalTimeMap.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            totalTimeMap.put(str, copyOnWriteArrayList);
        }
        long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
        copyOnWriteArrayList.add(Long.valueOf(currentTimeMillis));
        long totalTimeFPS = getTotalTimeFPS(copyOnWriteArrayList);
        int size = copyOnWriteArrayList.size();
        if (size >= 10) {
            float f16 = (float) (totalTimeFPS / size);
            LogUtils.d(TAG, PREFIX + str + MsgSummary.STR_COLON + f16 + "ms");
            lastTimeMap.put(str, Float.valueOf(f16));
            copyOnWriteArrayList.clear();
        }
        return currentTimeMillis;
    }

    public static long benchEndTotal(String str) {
        if (!ENABLE_LOG || TextUtils.isEmpty(str) || startTimeMap.get(str) == null) {
            return 0L;
        }
        CopyOnWriteArrayList<Long> copyOnWriteArrayList = totalTimeMap.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            totalTimeMap.put(str, copyOnWriteArrayList);
        }
        long currentTimeMillis = System.currentTimeMillis() - startTimeMap.get(str).longValue();
        copyOnWriteArrayList.add(Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    public static void benchStart(String str) {
        if (!ENABLE_LOG || TextUtils.isEmpty(str)) {
            return;
        }
        if (ENABLE_PERFORMANCE_RECORD && str.startsWith(SHOWPREVIEW_BENCH_TAG)) {
            GLES20.glFinish();
        }
        startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void benchStartFPS(String str) {
        if (!ENABLE_DEBUG || TextUtils.isEmpty(str)) {
            return;
        }
        startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void calcFps() {
        benchEndFPS("bench_fps");
        benchStartFPS("bench_fps");
    }

    public static float elapsed(String str) {
        if (!lastTimeMap.containsKey(str)) {
            return 0.0f;
        }
        return lastTimeMap.get(str).floatValue();
    }

    public static void flush() {
        for (Map.Entry<String, CopyOnWriteArrayList<Long>> entry : totalTimeMap.entrySet()) {
            sLogger.d(TAG, PREFIX + entry.getKey() + MsgSummary.STR_COLON + getTotalTime(entry.getValue()) + "ms");
        }
        totalTimeMap.clear();
    }

    public static String getBenchFps() {
        float elapsed = elapsed("bench_fps");
        if (elapsed == 0.0f) {
            return "";
        }
        return "" + Math.round(1000.0f / elapsed);
    }

    public static String getLastBenchAverage() {
        if (!ENABLE_LOG) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        float elapsed = elapsed("bench_fps");
        if (elapsed != 0.0f) {
            sb5.append("fps : " + Math.round(1000.0f / elapsed) + "\n");
        }
        sb5.append("frame elapsed : " + elapsed + "\n");
        sb5.append("yuv2rgba : " + elapsed("mPreviewFilter") + "\n");
        sb5.append("beauty-filter : " + elapsed("mBeautyFilter") + "\n");
        sb5.append("filter : " + elapsed("mFilter") + "\n");
        sb5.append("arFilter : " + elapsed("arFilter") + "\n");
        sb5.append("gpu2cpu : " + elapsed("gpu2cpu") + "\n");
        sb5.append("doTrack : " + elapsed("doTrack") + "\n");
        sb5.append("faceDetect : " + elapsed("faceDetect") + "\n");
        sb5.append("beautyTransform : " + elapsed("mBeautyTransformList") + "\n");
        sb5.append("sticker : " + elapsed("updateAndRender") + "\n");
        sb5.append("flip : " + elapsed("mFlipFilter") + "\n");
        sb5.append("viewFilter : " + elapsed("mViewFilter") + "\n");
        sb5.append("onDrawFrame : " + elapsed("onDrawFrame") + "\n");
        return sb5.toString();
    }

    private static synchronized long getTotalTime(CopyOnWriteArrayList<Long> copyOnWriteArrayList) {
        synchronized (BenchUtil.class) {
            long j3 = 0;
            if (!ENABLE_LOG) {
                return 0L;
            }
            if (CollectionUtils.isEmpty(copyOnWriteArrayList)) {
                return 0L;
            }
            Iterator<Long> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                j3 += it.next().longValue();
            }
            return j3;
        }
    }

    private static long getTotalTimeFPS(List<Long> list) {
        long j3 = 0;
        if (!ENABLE_DEBUG || CollectionUtils.isEmpty(list)) {
            return 0L;
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            j3 += it.next().longValue();
        }
        return j3;
    }

    public static void init() {
        startTimeMap.clear();
        totalTimeMap.clear();
        lastTimeMap.clear();
    }

    public static void setEnableDebugLog(boolean z16, boolean z17) {
        ENABLE_DEBUG = z16;
        ENABLE_LOG = z17;
    }

    public static void setLoggerAgent(LoggerAgent loggerAgent) {
        sLogger = loggerAgent;
    }

    public static void benchEnd(String str, int i3) {
        if (!ENABLE_LOG || TextUtils.isEmpty(str) || startTimeMap.get(str) == null) {
            return;
        }
        CopyOnWriteArrayList<Long> copyOnWriteArrayList = totalTimeMap.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            totalTimeMap.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis() - startTimeMap.get(str).longValue()));
        if (copyOnWriteArrayList.size() >= 10) {
            sLogger.d(TAG, PREFIX + str + MsgSummary.STR_COLON + (getTotalTime(copyOnWriteArrayList) / (copyOnWriteArrayList.size() / i3)) + "ms");
            copyOnWriteArrayList.clear();
        }
    }
}
