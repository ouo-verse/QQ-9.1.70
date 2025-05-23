package org.light.device;

/* compiled from: P */
/* loaded from: classes29.dex */
class RamYearList {
    private static final long GB = 1000000000;
    private static final long MB = 1000000;
    private static final long[] SRamSize = {500000000, 1500000000, 2500000000L, 3500000000L, 3500000000L, 5500000000L, 7500000000L};
    private static final int START_YEAR = 2012;

    RamYearList() {
    }

    public static int getRamYear(long j3) {
        int length = SRamSize.length;
        do {
            length--;
            if (length < 0) {
                return 2012;
            }
        } while (SRamSize[length] >= j3);
        return length + 2012;
    }
}
