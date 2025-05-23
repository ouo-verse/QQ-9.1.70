package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

/* compiled from: P */
/* loaded from: classes2.dex */
final class DefaultMediaClock implements MediaClock {
    private final PlaybackParameterListener listener;

    @Nullable
    private MediaClock rendererClock;

    @Nullable
    private Renderer rendererClockSource;
    private final StandaloneMediaClock standaloneMediaClock;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface PlaybackParameterListener {
        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(PlaybackParameterListener playbackParameterListener, Clock clock) {
        this.listener = playbackParameterListener;
        this.standaloneMediaClock = new StandaloneMediaClock(clock);
    }

    private void ensureSynced() {
        this.standaloneMediaClock.resetPosition(this.rendererClock.getPositionUs());
        PlaybackParameters playbackParameters = this.rendererClock.getPlaybackParameters();
        if (!playbackParameters.equals(this.standaloneMediaClock.getPlaybackParameters())) {
            this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
            this.listener.onPlaybackParametersChanged(playbackParameters);
        }
    }

    private boolean isUsingRendererClock() {
        Renderer renderer = this.rendererClockSource;
        if (renderer != null && !renderer.isEnded() && (this.rendererClockSource.isReady() || !this.rendererClockSource.hasReadStreamToEnd())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            return mediaClock.getPlaybackParameters();
        }
        return this.standaloneMediaClock.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (isUsingRendererClock()) {
            return this.rendererClock.getPositionUs();
        }
        return this.standaloneMediaClock.getPositionUs();
    }

    public void onRendererDisabled(Renderer renderer) {
        if (renderer == this.rendererClockSource) {
            this.rendererClock = null;
            this.rendererClockSource = null;
        }
    }

    public void onRendererEnabled(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock mediaClock2 = renderer.getMediaClock();
        if (mediaClock2 != null && mediaClock2 != (mediaClock = this.rendererClock)) {
            if (mediaClock == null) {
                this.rendererClock = mediaClock2;
                this.rendererClockSource = renderer;
                mediaClock2.setPlaybackParameters(this.standaloneMediaClock.getPlaybackParameters());
                ensureSynced();
                return;
            }
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public void resetPosition(long j3) {
        this.standaloneMediaClock.resetPosition(j3);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            playbackParameters = mediaClock.setPlaybackParameters(playbackParameters);
        }
        this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
        this.listener.onPlaybackParametersChanged(playbackParameters);
        return playbackParameters;
    }

    public void start() {
        this.standaloneMediaClock.start();
    }

    public void stop() {
        this.standaloneMediaClock.stop();
    }

    public long syncAndGetPositionUs() {
        if (isUsingRendererClock()) {
            ensureSynced();
            return this.rendererClock.getPositionUs();
        }
        return this.standaloneMediaClock.getPositionUs();
    }
}
