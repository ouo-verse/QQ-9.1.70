package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface TrackSelection {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Factory {
        TrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr);
    }

    boolean blacklist(int i3, long j3);

    void disable();

    void enable();

    int evaluateQueueSize(long j3, List<? extends MediaChunk> list);

    Format getFormat(int i3);

    int getIndexInTrackGroup(int i3);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int i3);

    int indexOf(Format format);

    int length();

    void onPlaybackSpeed(float f16);

    void updateSelectedTrack(long j3, long j16, long j17);
}
