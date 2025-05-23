package org.tencwebrtc;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Metrics {
    private static final String TAG = "Metrics";
    public final Map<String, HistogramInfo> map = new HashMap();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class HistogramInfo {
        public final int bucketCount;
        public final int max;
        public final int min;
        public final Map<Integer, Integer> samples = new HashMap();

        @CalledByNative("HistogramInfo")
        public HistogramInfo(int i3, int i16, int i17) {
            this.min = i3;
            this.max = i16;
            this.bucketCount = i17;
        }

        @CalledByNative("HistogramInfo")
        public void addSample(int i3, int i16) {
            this.samples.put(Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @CalledByNative
    Metrics() {
    }

    @CalledByNative
    private void add(String str, HistogramInfo histogramInfo) {
        this.map.put(str, histogramInfo);
    }

    public static void enable() {
        nativeEnable();
    }

    public static Metrics getAndReset() {
        return nativeGetAndReset();
    }

    private static native void nativeEnable();

    private static native Metrics nativeGetAndReset();
}
