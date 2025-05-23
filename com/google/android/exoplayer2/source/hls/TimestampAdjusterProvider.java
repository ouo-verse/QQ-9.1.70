package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* loaded from: classes2.dex */
public final class TimestampAdjusterProvider {
    private final SparseArray<TimestampAdjuster> timestampAdjusters = new SparseArray<>();

    public TimestampAdjuster getAdjuster(int i3) {
        TimestampAdjuster timestampAdjuster = this.timestampAdjusters.get(i3);
        if (timestampAdjuster == null) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(Long.MAX_VALUE);
            this.timestampAdjusters.put(i3, timestampAdjuster2);
            return timestampAdjuster2;
        }
        return timestampAdjuster;
    }

    public void reset() {
        this.timestampAdjusters.clear();
    }
}
