package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private boolean streamIsFinal;

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        boolean z16 = true;
        if (this.state != 1) {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j3, boolean z16, long j16) throws ExoPlaybackException {
        boolean z17;
        if (this.state == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkState(z17);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z16);
        replaceStream(formatArr, sampleStream, j16);
        onPositionReset(j3, z16);
    }

    protected final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    protected final int getIndex() {
        return this.index;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final SampleStream getStream() {
        return this.stream;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return 5;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j3) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        onRendererOffsetChanged(j3);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j3) throws ExoPlaybackException {
        this.streamIsFinal = false;
        onPositionReset(j3, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setIndex(int i3) {
        this.index = i3;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws ExoPlaybackException {
        boolean z16 = true;
        if (this.state != 1) {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() throws ExoPlaybackException {
        boolean z16;
        if (this.state == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws IOException {
    }

    protected void onDisabled() {
    }

    protected void onStarted() throws ExoPlaybackException {
    }

    protected void onStopped() throws ExoPlaybackException {
    }

    protected void onEnabled(boolean z16) throws ExoPlaybackException {
    }

    protected void onRendererOffsetChanged(long j3) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i3, Object obj) throws ExoPlaybackException {
    }

    protected void onPositionReset(long j3, boolean z16) throws ExoPlaybackException {
    }
}
