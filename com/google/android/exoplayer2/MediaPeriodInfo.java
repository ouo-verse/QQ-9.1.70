package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;

/* loaded from: classes2.dex */
final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final long endPositionUs;

    /* renamed from: id, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f32937id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j3, long j16, long j17, long j18, boolean z16, boolean z17) {
        this.f32937id = mediaPeriodId;
        this.startPositionUs = j3;
        this.endPositionUs = j16;
        this.contentPositionUs = j17;
        this.durationUs = j18;
        this.isLastInTimelinePeriod = z16;
        this.isFinal = z17;
    }

    public MediaPeriodInfo copyWithPeriodIndex(int i3) {
        return new MediaPeriodInfo(this.f32937id.copyWithPeriodIndex(i3), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public MediaPeriodInfo copyWithStartPositionUs(long j3) {
        return new MediaPeriodInfo(this.f32937id, j3, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }
}
