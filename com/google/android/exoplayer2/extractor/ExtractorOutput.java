package com.google.android.exoplayer2.extractor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ExtractorOutput {
    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i3, int i16);
}
