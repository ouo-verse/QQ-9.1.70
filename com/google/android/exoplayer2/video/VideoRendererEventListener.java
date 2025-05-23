package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface VideoRendererEventListener {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class EventDispatcher {

        @Nullable
        private final Handler handler;

        @Nullable
        private final VideoRendererEventListener listener;

        public EventDispatcher(@Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener) {
            Handler handler2;
            if (videoRendererEventListener != null) {
                handler2 = (Handler) Assertions.checkNotNull(handler);
            } else {
                handler2 = null;
            }
            this.handler = handler2;
            this.listener = videoRendererEventListener;
        }

        public void decoderInitialized(final String str, final long j3, final long j16) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onVideoDecoderInitialized(str, j3, j16);
                    }
                });
            }
        }

        public void disabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.7
                    @Override // java.lang.Runnable
                    public void run() {
                        decoderCounters.ensureUpdated();
                        EventDispatcher.this.listener.onVideoDisabled(decoderCounters);
                    }
                });
            }
        }

        public void droppedFrames(final int i3, final long j3) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.4
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onDroppedFrames(i3, j3);
                    }
                });
            }
        }

        public void enabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onVideoEnabled(decoderCounters);
                    }
                });
            }
        }

        public void inputFormatChanged(final Format format) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onVideoInputFormatChanged(format);
                    }
                });
            }
        }

        public void renderedFirstFrame(final Surface surface) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.6
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onRenderedFirstFrame(surface);
                    }
                });
            }
        }

        public void videoSizeChanged(final int i3, final int i16, final int i17, final float f16) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.5
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onVideoSizeChanged(i3, i16, i17, f16);
                    }
                });
            }
        }
    }

    void onDroppedFrames(int i3, long j3);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j3, long j16);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int i3, int i16, int i17, float f16);
}
