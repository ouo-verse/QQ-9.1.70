package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes23.dex */
public class PerformanceTracer {
    private IDataSource dataSource;
    private long totalPcmInByte;
    private final Map<String, SpeedCheck> speedMap = new LinkedHashMap();
    private long lastTimeStampNanoSecond = 0;
    private long playStartTimestampNanoSec = 0;
    private long totalTimeCostInNanoSec = 0;

    /* loaded from: classes23.dex */
    public static class BufferSizeCheck {
        private final String name;
        private int sizeMismatchCount = 0;
        private int lastSize = 0;
        private int maxMismatch = 0;

        public BufferSizeCheck(String str) {
            this.name = str;
        }

        public int getMaxMismatch() {
            return this.maxMismatch;
        }

        public String getName() {
            return this.name;
        }

        public int getSizeMismatchCount() {
            return this.sizeMismatchCount;
        }

        public void onEnd(int i3) {
            int i16 = this.lastSize;
            if (i3 != i16) {
                int i17 = i16 - i3;
                if (Math.abs(i17) > this.maxMismatch) {
                    this.maxMismatch = i17;
                }
                this.sizeMismatchCount++;
            }
        }

        public void onStart(int i3) {
            this.lastSize = i3;
        }
    }

    /* loaded from: classes23.dex */
    public static class OverallInfo {
        final IDataSource dataSource;
        final long timeCostInMs;
        final long totalPcmToBePlayed;

        public OverallInfo(IDataSource iDataSource, long j3, long j16) {
            this.dataSource = iDataSource;
            this.timeCostInMs = j3;
            this.totalPcmToBePlayed = j16;
        }
    }

    /* loaded from: classes23.dex */
    public static class SpeedCheck {

        /* renamed from: f, reason: collision with root package name */
        private static final double f348405f = 1000000.0d;
        private double avg;
        private double max;
        private double min;
        private final String name;
        private long totalBufferLength;
        private long totalTimeNanoSecond;

        /* JADX INFO: Access modifiers changed from: private */
        public void compute() {
            this.avg = (this.totalBufferLength * 1000000.0d) / this.totalTimeNanoSecond;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(int i3, long j3) {
            this.totalBufferLength += i3;
            this.totalTimeNanoSecond += j3;
            double d16 = (i3 * 1000000.0d) / j3;
            double d17 = this.max;
            if (d16 <= d17 && d17 != 0.0d) {
                double d18 = this.min;
                if (d16 < d18 || d18 == 0.0d) {
                    this.min = d16;
                    return;
                }
                return;
            }
            this.max = d16;
        }

        public double getAvg() {
            return this.avg;
        }

        public double getMax() {
            return this.max;
        }

        public double getMin() {
            return this.min;
        }

        public String getName() {
            return this.name;
        }

        public long getTotalBufferLength() {
            return this.totalBufferLength;
        }

        public long getTotalTimeMs() {
            return Math.round(this.totalTimeNanoSecond / 1000000.0d);
        }

        public void reset() {
            this.avg = 0.0d;
            this.max = 0.0d;
            this.min = 0.0d;
            this.totalTimeNanoSecond = 0L;
            this.totalBufferLength = 0L;
        }

        public String toString() {
            compute();
            return String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength));
        }

        SpeedCheck(String str) {
            this.name = str;
        }
    }

    /* loaded from: classes23.dex */
    public interface Visitor {
        void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo);
    }

    private SpeedCheck getSpeedCheck(String str) {
        SpeedCheck speedCheck = this.speedMap.get(str);
        if (speedCheck != null) {
            return speedCheck;
        }
        SpeedCheck speedCheck2 = new SpeedCheck(str);
        this.speedMap.put(str, speedCheck2);
        return speedCheck2;
    }

    public void accept(Visitor visitor) {
        ArrayList arrayList = new ArrayList(this.speedMap.values());
        Iterator<SpeedCheck> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().compute();
        }
        visitor.visitSpeedCheck(arrayList, new OverallInfo(this.dataSource, Math.round(this.totalTimeCostInNanoSec / 1000000.0d), this.totalPcmInByte));
    }

    public void end(String str, int i3) {
        getSpeedCheck(str).update(i3, System.nanoTime() - this.lastTimeStampNanoSecond);
    }

    public void init(IDataSource iDataSource) {
        this.dataSource = iDataSource;
        this.lastTimeStampNanoSecond = 0L;
        Iterator<SpeedCheck> it = this.speedMap.values().iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    public void playStart() {
        this.totalPcmInByte = 0L;
    }

    public void roundEnd(int i3) {
        this.totalPcmInByte += i3;
        this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
    }

    public void roundStart() {
        this.playStartTimestampNanoSec = System.nanoTime();
    }

    public void start(String str) {
        getSpeedCheck(str);
        this.lastTimeStampNanoSecond = System.nanoTime();
    }

    public void playEnd() {
    }
}
