package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.PlaybackParameters;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface MediaClock {
    PlaybackParameters getPlaybackParameters();

    long getPositionUs();

    PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters);
}
