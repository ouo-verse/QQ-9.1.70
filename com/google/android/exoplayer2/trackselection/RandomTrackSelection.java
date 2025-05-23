package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class RandomTrackSelection extends BaseTrackSelection {
    private final Random random;
    private int selectedIndex;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Factory implements TrackSelection.Factory {
        private final Random random;

        public Factory() {
            this.random = new Random();
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public RandomTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            return new RandomTrackSelection(trackGroup, iArr, this.random);
        }

        public Factory(int i3) {
            this.random = new Random(i3);
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int... iArr) {
        super(trackGroup, iArr);
        Random random = new Random();
        this.random = random;
        this.selectedIndex = random.nextInt(this.length);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return 3;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j3, long j16, long j17) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = 0;
        for (int i16 = 0; i16 < this.length; i16++) {
            if (!isBlacklisted(i16, elapsedRealtime)) {
                i3++;
            }
        }
        this.selectedIndex = this.random.nextInt(i3);
        if (i3 != this.length) {
            int i17 = 0;
            for (int i18 = 0; i18 < this.length; i18++) {
                if (!isBlacklisted(i18, elapsedRealtime)) {
                    int i19 = i17 + 1;
                    if (this.selectedIndex == i17) {
                        this.selectedIndex = i18;
                        return;
                    }
                    i17 = i19;
                }
            }
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, long j3) {
        this(trackGroup, iArr, new Random(j3));
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, Random random) {
        super(trackGroup, iArr);
        this.random = random;
        this.selectedIndex = random.nextInt(this.length);
    }
}
