package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z16) {
        return this.timeline.getFirstWindowIndex(z16);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z16) {
        return this.timeline.getLastWindowIndex(z16);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i3, int i16, boolean z16) {
        return this.timeline.getNextWindowIndex(i3, i16, z16);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i3, Timeline.Period period, boolean z16) {
        return this.timeline.getPeriod(i3, period, z16);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i3, int i16, boolean z16) {
        return this.timeline.getPreviousWindowIndex(i3, i16, z16);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i3, Timeline.Window window, boolean z16, long j3) {
        return this.timeline.getWindow(i3, window, z16, j3);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }
}
