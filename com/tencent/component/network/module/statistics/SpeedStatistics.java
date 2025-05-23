package com.tencent.component.network.module.statistics;

import com.tencent.component.network.module.statistics.common.SortedFixedLinkedList;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SpeedStatistics {
    private static final int UPDATE_AVERAGE_SPEED_INTERVAL = 2;
    private static final Comparator<StatisticsUnit> sUnitComparator = new Comparator<StatisticsUnit>() { // from class: com.tencent.component.network.module.statistics.SpeedStatistics.1
        @Override // java.util.Comparator
        public int compare(StatisticsUnit statisticsUnit, StatisticsUnit statisticsUnit2) {
            long j3 = statisticsUnit.startTime;
            long j16 = statisticsUnit2.startTime;
            if (j3 > j16) {
                return -1;
            }
            return j3 < j16 ? 1 : 0;
        }
    };
    private float mAverageSpeed;
    private int mAverageSpeedCount;
    private final SortedFixedLinkedList<StatisticsUnit> mStatisticList;
    private int mStatisticsCount;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class InstanceHolder {
        static final SpeedStatistics INSTANCE = new SpeedStatistics();

        InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class StatisticsUnit {
        long bytesSize;
        long endTime;
        long startTime;

        StatisticsUnit() {
        }
    }

    private static long gapBetween(long j3, long j16, long j17, long j18) {
        if (j17 > j16) {
            return j17 - j16;
        }
        if (j3 > j18) {
            return j3 - j18;
        }
        return 0L;
    }

    public static SpeedStatistics getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static long max(long j3, long j16) {
        if (j3 <= j16) {
            return j16;
        }
        return j3;
    }

    private static int min(int i3, int i16) {
        return i3 < i16 ? i3 : i16;
    }

    private boolean shouldUpdateAverageSpeed() {
        int i3 = this.mAverageSpeedCount;
        this.mAverageSpeedCount = i3 + 1;
        if (i3 < 2) {
            return false;
        }
        this.mAverageSpeedCount = 0;
        return true;
    }

    private void updateAverageSpeed(int i3) {
        float f16;
        int size = this.mStatisticList.size();
        if (i3 > 0) {
            size = min(size, i3);
        }
        if (size <= 0) {
            return;
        }
        int i16 = size - 1;
        StatisticsUnit statisticsUnit = this.mStatisticList.get(i16);
        long j3 = statisticsUnit.startTime;
        long j16 = statisticsUnit.endTime;
        long j17 = 0;
        long j18 = 0;
        while (i16 >= 0) {
            StatisticsUnit statisticsUnit2 = this.mStatisticList.get(i16);
            long j19 = j17 + statisticsUnit2.bytesSize;
            long j26 = statisticsUnit2.startTime;
            long j27 = statisticsUnit2.endTime;
            j18 += gapBetween(j3, j16, j26, j27);
            j3 = min(j3, j26);
            j16 = max(j16, j27);
            i16--;
            j17 = j19;
        }
        long j28 = (j16 - j3) - j18;
        if (j28 <= 0) {
            return;
        }
        double d16 = j17 / 1024.0d;
        double d17 = j28 / 1000.0d;
        if (d16 > 0.0d && d17 > 0.0d) {
            f16 = (float) (d16 / d17);
        } else {
            f16 = 0.0f;
        }
        this.mAverageSpeed = f16;
    }

    public float getAverageSpeed() {
        return this.mAverageSpeed;
    }

    public int getStatisticsCount() {
        return this.mStatisticsCount;
    }

    public void report(long j3, long j16, long j17) {
        if (j3 < 51200) {
            return;
        }
        StatisticsUnit statisticsUnit = new StatisticsUnit();
        statisticsUnit.bytesSize = j3;
        statisticsUnit.startTime = min(j16, j17);
        statisticsUnit.endTime = max(j16, j17);
        synchronized (this.mStatisticList) {
            this.mStatisticList.add(statisticsUnit);
            this.mStatisticsCount++;
            if (shouldUpdateAverageSpeed()) {
                updateAverageSpeed(5);
            }
        }
    }

    SpeedStatistics() {
        this.mAverageSpeedCount = 0;
        this.mStatisticList = new SortedFixedLinkedList<>(100, sUnitComparator, false);
    }

    private static long min(long j3, long j16) {
        return j3 < j16 ? j3 : j16;
    }
}
