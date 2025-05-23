package com.google.android.exoplayer2.text;

import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Subtitle {
    List<Cue> getCues(long j3);

    long getEventTime(int i3);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j3);
}
