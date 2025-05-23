package org.light.device;

/* loaded from: classes29.dex */
class CPUYearList {
    private static final long KHZ = 1000;
    private static final int START_CORE_YEAR = 2012;
    private static final int START_YEAR = 2013;
    private static final long[] SCPU_Freq = {1520000, 1620000, 1780000, 2000000, 2200000, 2600000};
    private static final int[] SCORES_NUM = {2, 3, 7};

    CPUYearList() {
    }

    public static int getCPUOclock(long j3) {
        int length = SCPU_Freq.length;
        do {
            length--;
            if (length < 0) {
                return 2013;
            }
        } while (SCPU_Freq[length] >= j3);
        return length + 2013;
    }

    public static int getCoreNumYear(int i3) {
        int length = SCORES_NUM.length;
        do {
            length--;
            if (length < 0) {
                return 2012;
            }
        } while (SCORES_NUM[length] >= i3);
        return length + 2012;
    }
}
