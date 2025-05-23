package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
final class Tx3gSubtitle implements Subtitle {
    public static final Tx3gSubtitle EMPTY = new Tx3gSubtitle();
    private final List<Cue> cues;

    public Tx3gSubtitle(Cue cue) {
        this.cues = Collections.singletonList(cue);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j3) {
        if (j3 >= 0) {
            return this.cues;
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i3) {
        boolean z16;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j3) {
        if (j3 < 0) {
            return 0;
        }
        return -1;
    }

    Tx3gSubtitle() {
        this.cues = Collections.emptyList();
    }
}
