package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private boolean readEndOfStream = true;
    private int state;
    private SampleStream stream;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private final int trackType;

    public BaseRenderer(int i3) {
        this.trackType = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean supportsFormatDrm(@Nullable DrmSessionManager<?> drmSessionManager, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (drmSessionManager == null) {
            return false;
        }
        return drmSessionManager.canAcquireSession(drmInitData);
    }

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

    /* JADX INFO: Access modifiers changed from: protected */
    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
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
        return this.trackType;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.readEndOfStream;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isSourceReady() {
        if (this.readEndOfStream) {
            return this.streamIsFinal;
        }
        return this.stream.isReady();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws IOException {
        this.stream.maybeThrowError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int readSource(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
        int readData = this.stream.readData(formatHolder, decoderInputBuffer, z16);
        if (readData == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.readEndOfStream = true;
                if (this.streamIsFinal) {
                    return -4;
                }
                return -3;
            }
            decoderInputBuffer.timeUs += this.streamOffsetUs;
        } else if (readData == -5) {
            Format format = formatHolder.format;
            long j3 = format.subsampleOffsetUs;
            if (j3 != Long.MAX_VALUE) {
                formatHolder.format = format.copyWithSubsampleOffsetUs(j3 + this.streamOffsetUs);
            }
        }
        return readData;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j3) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        this.readEndOfStream = false;
        this.streamOffsetUs = j3;
        onStreamChanged(formatArr, j3);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j3) throws ExoPlaybackException {
        this.streamIsFinal = false;
        this.readEndOfStream = false;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public int skipSource(long j3) {
        return this.stream.skipData(j3 - this.streamOffsetUs);
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
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    protected void onDisabled() {
    }

    protected void onStarted() throws ExoPlaybackException {
    }

    protected void onStopped() throws ExoPlaybackException {
    }

    protected void onEnabled(boolean z16) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i3, Object obj) throws ExoPlaybackException {
    }

    protected void onPositionReset(long j3, boolean z16) throws ExoPlaybackException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j3) throws ExoPlaybackException {
    }
}
