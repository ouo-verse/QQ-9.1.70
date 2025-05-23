package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j3) {
        Cue cue;
        int binarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j3, true, false);
        if (binarySearchFloor != -1 && (cue = this.cues[binarySearchFloor]) != null) {
            return Collections.singletonList(cue);
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i3) {
        boolean z16;
        boolean z17 = true;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        if (i3 >= this.cueTimesUs.length) {
            z17 = false;
        }
        Assertions.checkArgument(z17);
        return this.cueTimesUs[i3];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j3) {
        int binarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j3, false, false);
        if (binarySearchCeil >= this.cueTimesUs.length) {
            return -1;
        }
        return binarySearchCeil;
    }
}
