package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class SinglePeriodTimeline extends Timeline {
    private static final Object ID = new Object();
    private final boolean isDynamic;
    private final boolean isSeekable;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    public SinglePeriodTimeline(long j3, boolean z16, boolean z17) {
        this(j3, j3, 0L, 0L, z16, z17);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        if (ID.equals(obj)) {
            return 0;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i3, Timeline.Period period, boolean z16) {
        Object obj;
        Assertions.checkIndex(i3, 0, 1);
        if (z16) {
            obj = ID;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        return period.set(obj2, obj2, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r1 > r4) goto L12;
     */
    @Override // com.google.android.exoplayer2.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Timeline.Window getWindow(int i3, Timeline.Window window, boolean z16, long j3) {
        Object obj;
        long j16;
        Assertions.checkIndex(i3, 0, 1);
        if (z16) {
            obj = ID;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        long j17 = this.windowDefaultStartPositionUs;
        boolean z17 = this.isDynamic;
        if (z17 && j3 != 0) {
            long j18 = this.windowDurationUs;
            if (j18 != -9223372036854775807L) {
                j17 += j3;
            }
            j16 = -9223372036854775807L;
            return window.set(obj2, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, z17, j16, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
        }
        j16 = j17;
        return window.set(obj2, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, z17, j16, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j3, long j16, long j17, long j18, boolean z16, boolean z17) {
        this(-9223372036854775807L, -9223372036854775807L, j3, j16, j17, j18, z16, z17);
    }

    public SinglePeriodTimeline(long j3, long j16, long j17, long j18, long j19, long j26, boolean z16, boolean z17) {
        this.presentationStartTimeMs = j3;
        this.windowStartTimeMs = j16;
        this.periodDurationUs = j17;
        this.windowDurationUs = j18;
        this.windowPositionInPeriodUs = j19;
        this.windowDefaultStartPositionUs = j26;
        this.isSeekable = z16;
        this.isDynamic = z17;
    }
}
