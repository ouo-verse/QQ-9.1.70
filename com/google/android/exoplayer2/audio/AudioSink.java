package com.google.android.exoplayer2.audio;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th5) {
            super(th5);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i3, int i16, int i17, int i18) {
            super("AudioTrack init failed: " + i3 + ", Config(" + i16 + ", " + i17 + ", " + i18 + ")");
            this.audioTrackState = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Listener {
        boolean isNeedAudioData();

        void onAudioSessionId(int i3);

        void onPositionDiscontinuity();

        void onRenderAudioData(byte[] bArr);

        void onUnderrun(int i3, long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i3) {
            super("AudioTrack write failed: " + i3);
            this.errorCode = i3;
        }
    }

    void configure(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, int i26) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int i3);

    long getCurrentPositionUs(boolean z16);

    PlaybackParameters getPlaybackParameters();

    boolean handleBuffer(ByteBuffer byteBuffer, long j3) throws InitializationException, WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEncodingSupported(int i3);

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void release();

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int i3);

    void setListener(Listener listener);

    PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters);

    void setVolume(float f16);
}
