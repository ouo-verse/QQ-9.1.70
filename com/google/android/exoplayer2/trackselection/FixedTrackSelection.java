package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class FixedTrackSelection extends BaseTrackSelection {
    private final Object data;
    private final int reason;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Factory implements TrackSelection.Factory {
        private final Object data;
        private final int reason;

        public Factory() {
            this.reason = 0;
            this.data = null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public FixedTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            Assertions.checkArgument(iArr.length == 1);
            return new FixedTrackSelection(trackGroup, iArr[0], this.reason, this.data);
        }

        public Factory(int i3, Object obj) {
            this.reason = i3;
            this.data = obj;
        }
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i3) {
        this(trackGroup, i3, 0, null);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        return this.data;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i3, int i16, Object obj) {
        super(trackGroup, i3);
        this.reason = i16;
        this.data = obj;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j3, long j16, long j17) {
    }
}
