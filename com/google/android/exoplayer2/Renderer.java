package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Renderer extends PlayerMessage.Target {
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;

    void disable();

    void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j3, boolean z16, long j16) throws ExoPlaybackException;

    RendererCapabilities getCapabilities();

    MediaClock getMediaClock();

    int getState();

    SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long j3, long j16) throws ExoPlaybackException;

    void replaceStream(Format[] formatArr, SampleStream sampleStream, long j3) throws ExoPlaybackException;

    void resetPosition(long j3) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setIndex(int i3);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
