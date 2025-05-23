package com.tencent.thumbplayer.core.renderer;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* loaded from: classes26.dex */
public interface ITPAudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;

    /* loaded from: classes26.dex */
    public static class Format {
        public static final int NO_VALUE = -1;
        public String sampleMimeType;
        public int channelCount = -1;
        public int sampleRate = -1;
        public int pcmEncoding = -1;
        public int bitrate = -1;
    }

    /* loaded from: classes26.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final Format format;
        public final boolean isRecoverable;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InitializationException(int i3, int i16, int i17, int i18, Format format, boolean z16, @Nullable Exception exc) {
            super(r0.toString(), exc);
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("AudioTrack init failed ");
            sb5.append(i3);
            sb5.append(" ");
            sb5.append("Config(");
            sb5.append(i16);
            sb5.append(", ");
            sb5.append(i17);
            sb5.append(", ");
            sb5.append(i18);
            sb5.append(")");
            sb5.append(" ");
            sb5.append(format);
            if (z16) {
                str = " (recoverable)";
            } else {
                str = "";
            }
            sb5.append(str);
            this.audioTrackState = i3;
            this.isRecoverable = z16;
            this.format = format;
        }
    }

    /* loaded from: classes26.dex */
    public interface Listener {
        void onAudioSinkError(Exception exc);

        void onPositionAdvancing(long j3);

        void onPositionDiscontinuity();

        void onUnderrun(int i3, long j3, long j16);
    }

    /* loaded from: classes26.dex */
    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public UnexpectedDiscontinuityException(long j3, long j16) {
            super("Unexpected audio track timestamp discontinuity: expected " + j16 + ", got " + j3);
            this.actualPresentationTimeUs = j3;
            this.expectedPresentationTimeUs = j16;
        }
    }

    /* loaded from: classes26.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;
        public final Format format;
        public final boolean isRecoverable;

        public WriteException(int i3, Format format, boolean z16) {
            super("AudioTrack write failed: " + i3);
            this.isRecoverable = z16;
            this.errorCode = i3;
            this.format = format;
        }
    }

    void configure(Format format, int i3) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21();

    void flush();

    @Nullable
    AudioAttributes getAudioAttributes();

    int getAudioSessionId();

    long getCurrentPositionUs(boolean z16);

    long getLatencyUs(boolean z16);

    boolean handleBuffer(ByteBuffer byteBuffer, long j3, int i3) throws InitializationException, WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void release();

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int i3);

    void setListener(Listener listener);

    void setOutputStreamOffsetUs(long j3);

    @RequiresApi(23)
    void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo);

    void setVolume(float f16);

    /* loaded from: classes26.dex */
    public static final class ConfigurationException extends Exception {
        public final Format format;

        public ConfigurationException(Throwable th5, Format format) {
            super(th5);
            this.format = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.format = format;
        }
    }
}
