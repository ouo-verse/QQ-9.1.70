package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface AudioRendererEventListener {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class EventDispatcher {

        @Nullable
        private final Handler handler;

        @Nullable
        private final AudioRendererEventListener listener;

        public EventDispatcher(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
            Handler handler2;
            if (audioRendererEventListener != null) {
                handler2 = (Handler) Assertions.checkNotNull(handler);
            } else {
                handler2 = null;
            }
            this.handler = handler2;
            this.listener = audioRendererEventListener;
        }

        public void audioSessionId(final int i3) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.6
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onAudioSessionId(i3);
                    }
                });
            }
        }

        public void audioTrackUnderrun(final int i3, final long j3, final long j16) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.4
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onAudioSinkUnderrun(i3, j3, j16);
                    }
                });
            }
        }

        public void decoderInitialized(final String str, final long j3, final long j16) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onAudioDecoderInitialized(str, j3, j16);
                    }
                });
            }
        }

        public void disabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.5
                    @Override // java.lang.Runnable
                    public void run() {
                        decoderCounters.ensureUpdated();
                        EventDispatcher.this.listener.onAudioDisabled(decoderCounters);
                    }
                });
            }
        }

        public void enabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onAudioEnabled(decoderCounters);
                    }
                });
            }
        }

        public void inputFormatChanged(final Format format) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onAudioInputFormatChanged(format);
                    }
                });
            }
        }

        public boolean isNeedAudioData() {
            AudioRendererEventListener audioRendererEventListener = this.listener;
            if (audioRendererEventListener != null) {
                return audioRendererEventListener.isNeedAudioData();
            }
            return false;
        }

        public void onRenderAudioData(final byte[] bArr) {
            if (this.listener != null) {
                this.handler.post(new Runnable() { // from class: com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher.7
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onRenderAudioData(bArr);
                    }
                });
            }
        }
    }

    boolean isNeedAudioData();

    void onAudioDecoderInitialized(String str, long j3, long j16);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(Format format);

    void onAudioSessionId(int i3);

    void onAudioSinkUnderrun(int i3, long j3, long j16);

    void onRenderAudioData(byte[] bArr);
}
