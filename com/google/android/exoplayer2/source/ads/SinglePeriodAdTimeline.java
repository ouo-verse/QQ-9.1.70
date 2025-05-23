package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        boolean z16;
        if (timeline.getPeriodCount() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        Assertions.checkState(timeline.getWindowCount() == 1);
        this.adPlaybackState = adPlaybackState;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i3, Timeline.Period period, boolean z16) {
        this.timeline.getPeriod(i3, period, z16);
        period.set(period.f32938id, period.uid, period.windowIndex, period.durationUs, period.getPositionInWindowUs(), this.adPlaybackState);
        return period;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int i3, Timeline.Window window, boolean z16, long j3) {
        Timeline.Window window2 = super.getWindow(i3, window, z16, j3);
        if (window2.durationUs == -9223372036854775807L) {
            window2.durationUs = this.adPlaybackState.contentDurationUs;
        }
        return window2;
    }
}
