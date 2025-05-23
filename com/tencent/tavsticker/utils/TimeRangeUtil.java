package com.tencent.tavsticker.utils;

import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimeRangeUtil {
    public static boolean isInTimeRange(CMTimeRange cMTimeRange, long j3) {
        if (isValidTimeRange(cMTimeRange) && j3 >= 0) {
            long j16 = j3 * 1000;
            if (j16 >= cMTimeRange.getStartUs() && j16 <= cMTimeRange.getEndUs()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isValidTimeRange(CMTimeRange cMTimeRange) {
        if (cMTimeRange == null) {
            return false;
        }
        return cMTimeRange.isLegal();
    }
}
