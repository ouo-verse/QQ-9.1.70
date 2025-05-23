package com.tencent.tavkit.utils;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVTimeUtil {
    public static float factorForTime(CMTime cMTime, CMTimeRange cMTimeRange) {
        if (cMTimeRange == null) {
            return 0.0f;
        }
        return cMTime.sub(cMTimeRange.getStart()).getTimeSeconds() / cMTimeRange.getDuration().getTimeSeconds();
    }

    @Nullable
    public static CMTimeRange getIntersection(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        CMTime start;
        CMTime end;
        if (cMTimeRange == null || cMTimeRange2 == null) {
            return null;
        }
        if (cMTimeRange.getStart().bigThan(cMTimeRange2.getStart())) {
            cMTimeRange2 = cMTimeRange;
            cMTimeRange = cMTimeRange2;
        }
        if (cMTimeRange.getEnd().smallThan(cMTimeRange2.getStart())) {
            return null;
        }
        if (cMTimeRange.getStart().bigThan(cMTimeRange2.getStart())) {
            start = cMTimeRange.getStart();
        } else {
            start = cMTimeRange2.getStart();
        }
        if (cMTimeRange.getEnd().smallThan(cMTimeRange2.getEnd())) {
            end = cMTimeRange.getEnd();
        } else {
            end = cMTimeRange2.getEnd();
        }
        return new CMTimeRange(start, end.sub(start));
    }
}
