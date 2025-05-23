package com.google.android.exoplayer2;

/* loaded from: classes2.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline, int i3, long j3) {
        this.timeline = timeline;
        this.windowIndex = i3;
        this.positionMs = j3;
    }
}
