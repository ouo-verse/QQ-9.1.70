package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultAudioSink implements AudioSink {
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final int ERROR_BAD_VALUE = -2;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_BUFFER_DURATION_US = 750000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final long MIN_BUFFER_DURATION_US = 250000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int MIN_TIMESTAMP_SAMPLE_INTERVAL_US = 500000;
    private static final int MODE_STATIC = 0;
    private static final int MODE_STREAM = 1;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final String TAG = "AudioTrack";

    @SuppressLint({"InlinedApi"})
    private static final int WRITE_NON_BLOCKING = 1;
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private AudioAttributes audioAttributes;

    @Nullable
    private final AudioCapabilities audioCapabilities;
    private AudioProcessor[] audioProcessors;
    private int audioSessionId;
    private boolean audioTimestampSet;
    private AudioTrack audioTrack;
    private final AudioTrackUtil audioTrackUtil;
    private ByteBuffer avSyncHeader;
    private int bufferSize;
    private long bufferSizeUs;
    private int bytesUntilNextAvSync;
    private boolean canApplyPlaybackParameters;
    private int channelConfig;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private int drainingAudioProcessorIndex;
    private PlaybackParameters drainingPlaybackParameters;
    private final boolean enableConvertHighResIntPcmToFloat;
    private int framesPerEncodedSample;
    private Method getLatencyMethod;
    private boolean handledEndOfStream;
    private boolean hasData;
    private ByteBuffer inputBuffer;
    private int inputSampleRate;
    private boolean isInputPcm;
    private AudioTrack keepSessionIdAudioTrack;
    private long lastFeedElapsedRealtimeMs;
    private long lastPlayheadSampleTimeUs;
    private long lastTimestampSampleTimeUs;
    private long latencyUs;

    @Nullable
    private AudioSink.Listener listener;
    private int nextPlayheadOffsetIndex;
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private int outputEncoding;
    private int outputPcmFrameSize;
    private int pcmFrameSize;
    private PlaybackParameters playbackParameters;
    private final ArrayDeque<PlaybackParametersCheckpoint> playbackParametersCheckpoints;
    private long playbackParametersOffsetUs;
    private long playbackParametersPositionUs;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private boolean processingEnabled;
    private final ConditionVariable releasingConditionVariable;
    private long resumeSystemTimeUs;
    private int sampleRate;
    private boolean shouldConvertHighResIntPcmToFloat;
    private long smoothedPlayheadOffsetUs;
    private final SonicAudioProcessor sonicAudioProcessor;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class AudioTrackUtil {
        private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
        protected AudioTrack audioTrack;
        private long endPlaybackHeadPosition;
        private long forceResetWorkaroundTimeMs;
        private long lastRawPlaybackHeadPosition;
        private boolean needsPassthroughWorkaround;
        private long passthroughWorkaroundPauseOffset;
        private long rawPlaybackHeadWrapCount;
        private int sampleRate;
        private long stopPlaybackHeadPosition;
        private long stopTimestampUs;

        AudioTrackUtil() {
        }

        public long getPlaybackHeadPosition() {
            if (this.stopTimestampUs != -9223372036854775807L) {
                return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * this.sampleRate) / 1000000));
            }
            int playState = this.audioTrack.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = this.audioTrack.getPlaybackHeadPosition() & 4294967295L;
            if (this.needsPassthroughWorkaround) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
                }
                playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
            }
            if (Util.SDK_INT <= 28) {
                if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                    if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                        this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                    }
                    return this.lastRawPlaybackHeadPosition;
                }
                this.forceResetWorkaroundTimeMs = -9223372036854775807L;
            }
            if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
                this.rawPlaybackHeadWrapCount++;
            }
            this.lastRawPlaybackHeadPosition = playbackHeadPosition;
            return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
        }

        public long getPositionUs() {
            return (getPlaybackHeadPosition() * 1000000) / this.sampleRate;
        }

        public long getTimestampFramePosition() {
            throw new UnsupportedOperationException();
        }

        public long getTimestampNanoTime() {
            throw new UnsupportedOperationException();
        }

        public void handleEndOfStream(long j3) {
            this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
            this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
            this.endPlaybackHeadPosition = j3;
            this.audioTrack.stop();
        }

        public boolean needsReset(long j3) {
            if (this.forceResetWorkaroundTimeMs != -9223372036854775807L && j3 > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS) {
                return true;
            }
            return false;
        }

        public void pause() {
            if (this.stopTimestampUs != -9223372036854775807L) {
                return;
            }
            this.audioTrack.pause();
        }

        public void reconfigure(AudioTrack audioTrack, boolean z16) {
            this.audioTrack = audioTrack;
            this.needsPassthroughWorkaround = z16;
            this.stopTimestampUs = -9223372036854775807L;
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
            this.lastRawPlaybackHeadPosition = 0L;
            this.rawPlaybackHeadWrapCount = 0L;
            this.passthroughWorkaroundPauseOffset = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public boolean updateTimestamp() {
            return false;
        }
    }

    /* compiled from: P */
    @TargetApi(19)
    /* loaded from: classes2.dex */
    private static class AudioTrackUtilV19 extends AudioTrackUtil {
        private final AudioTimestamp audioTimestamp;
        private long lastRawTimestampFramePosition;
        private long lastTimestampFramePosition;
        private long rawTimestampFramePositionWrapCount;

        public AudioTrackUtilV19() {
            super();
            this.audioTimestamp = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public long getTimestampFramePosition() {
            return this.lastTimestampFramePosition;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public long getTimestampNanoTime() {
            return this.audioTimestamp.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public void reconfigure(AudioTrack audioTrack, boolean z16) {
            super.reconfigure(audioTrack, z16);
            this.rawTimestampFramePositionWrapCount = 0L;
            this.lastRawTimestampFramePosition = 0L;
            this.lastTimestampFramePosition = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioTrackUtil
        public boolean updateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long j3 = this.audioTimestamp.framePosition;
                if (this.lastRawTimestampFramePosition > j3) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastRawTimestampFramePosition = j3;
                this.lastTimestampFramePosition = j3 + (this.rawTimestampFramePositionWrapCount << 32);
            }
            return timestamp;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class PlaybackParametersCheckpoint {
        private final long mediaTimeUs;
        private final PlaybackParameters playbackParameters;
        private final long positionUs;

        PlaybackParametersCheckpoint(PlaybackParameters playbackParameters, long j3, long j16) {
            this.playbackParameters = playbackParameters;
            this.mediaTimeUs = j3;
            this.positionUs = j16;
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities, audioProcessorArr, false);
    }

    private long applySpeedup(long j3) {
        long j16;
        long mediaDurationForPlayoutDuration;
        while (!this.playbackParametersCheckpoints.isEmpty() && j3 >= this.playbackParametersCheckpoints.getFirst().positionUs) {
            PlaybackParametersCheckpoint remove = this.playbackParametersCheckpoints.remove();
            this.playbackParameters = remove.playbackParameters;
            this.playbackParametersPositionUs = remove.positionUs;
            this.playbackParametersOffsetUs = remove.mediaTimeUs - this.startMediaTimeUs;
        }
        if (this.playbackParameters.speed == 1.0f) {
            return (j3 + this.playbackParametersOffsetUs) - this.playbackParametersPositionUs;
        }
        if (this.playbackParametersCheckpoints.isEmpty()) {
            j16 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = this.sonicAudioProcessor.scaleDurationForSpeedup(j3 - this.playbackParametersPositionUs);
        } else {
            j16 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(j3 - this.playbackParametersPositionUs, this.playbackParameters.speed);
        }
        return j16 + mediaDurationForPlayoutDuration;
    }

    @TargetApi(21)
    private AudioTrack createAudioTrackV21() {
        android.media.AudioAttributes audioAttributesV21;
        if (this.tunneling) {
            audioAttributesV21 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            audioAttributesV21 = this.audioAttributes.getAudioAttributesV21();
        }
        android.media.AudioAttributes audioAttributes = audioAttributesV21;
        AudioFormat build = new AudioFormat.Builder().setChannelMask(this.channelConfig).setEncoding(this.outputEncoding).setSampleRate(this.sampleRate).build();
        int i3 = this.audioSessionId;
        if (i3 == 0) {
            i3 = 0;
        }
        return new ReportAudioTrack(audioAttributes, build, this.bufferSize, 1, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0032 -> B:7:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean drainAudioProcessorsToEndOfStream() throws AudioSink.WriteException {
        boolean z16;
        int i3;
        AudioProcessor[] audioProcessorArr;
        int length;
        if (this.drainingAudioProcessorIndex == -1) {
            if (this.processingEnabled) {
                length = 0;
            } else {
                length = this.audioProcessors.length;
            }
            this.drainingAudioProcessorIndex = length;
            z16 = true;
            i3 = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.audioProcessors;
            if (i3 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i3];
                if (z16) {
                    audioProcessor.queueEndOfStream();
                }
                processBuffers(-9223372036854775807L);
                if (!audioProcessor.isEnded()) {
                    return false;
                }
                this.drainingAudioProcessorIndex++;
                z16 = true;
                i3 = this.drainingAudioProcessorIndex;
                audioProcessorArr = this.audioProcessors;
                if (i3 < audioProcessorArr.length) {
                    ByteBuffer byteBuffer = this.outputBuffer;
                    if (byteBuffer != null) {
                        writeBuffer(byteBuffer, -9223372036854775807L);
                        if (this.outputBuffer != null) {
                            return false;
                        }
                    }
                    this.drainingAudioProcessorIndex = -1;
                    return true;
                }
            }
        } else {
            z16 = false;
            i3 = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.audioProcessors;
            if (i3 < audioProcessorArr.length) {
            }
        }
    }

    private long durationUsToFrames(long j3) {
        return (j3 * this.sampleRate) / 1000000;
    }

    private long framesToDurationUs(long j3) {
        return (j3 * 1000000) / this.sampleRate;
    }

    private AudioProcessor[] getAvailableAudioProcessors() {
        if (this.shouldConvertHighResIntPcmToFloat) {
            return this.toFloatPcmAvailableAudioProcessors;
        }
        return this.toIntPcmAvailableAudioProcessors;
    }

    private static int getFramesPerEncodedSample(int i3, ByteBuffer byteBuffer) {
        if (i3 != 7 && i3 != 8) {
            if (i3 == 5) {
                return Ac3Util.getAc3SyncframeAudioSampleCount();
            }
            if (i3 == 6) {
                return Ac3Util.parseEAc3SyncframeAudioSampleCount(byteBuffer);
            }
            if (i3 == 14) {
                return Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer) * 8;
            }
            throw new IllegalStateException("Unexpected audio encoding: " + i3);
        }
        return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
    }

    private long getSubmittedFrames() {
        if (this.isInputPcm) {
            return this.submittedPcmBytes / this.pcmFrameSize;
        }
        return this.submittedEncodedFrames;
    }

    private long getWrittenFrames() {
        if (this.isInputPcm) {
            return this.writtenPcmBytes / this.outputPcmFrameSize;
        }
        return this.writtenEncodedFrames;
    }

    private boolean hasCurrentPositionUs() {
        if (isInitialized() && this.startMediaTimeState != 0) {
            return true;
        }
        return false;
    }

    private void initialize() throws AudioSink.InitializationException {
        this.releasingConditionVariable.block();
        this.audioTrack = initializeAudioTrack();
        setPlaybackParameters(this.playbackParameters);
        resetAudioProcessors();
        int audioSessionId = this.audioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            AudioTrack audioTrack = this.keepSessionIdAudioTrack;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(audioSessionId);
            }
        }
        if (this.audioSessionId != audioSessionId) {
            this.audioSessionId = audioSessionId;
            AudioSink.Listener listener = this.listener;
            if (listener != null) {
                listener.onAudioSessionId(audioSessionId);
            }
        }
        this.audioTrackUtil.reconfigure(this.audioTrack, needsPassthroughWorkarounds());
        setVolumeInternal();
        this.hasData = false;
    }

    private AudioTrack initializeAudioTrack() throws AudioSink.InitializationException {
        AudioTrack reportAudioTrack;
        if (Util.SDK_INT >= 21) {
            reportAudioTrack = createAudioTrackV21();
        } else {
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
            int i3 = this.audioSessionId;
            if (i3 == 0) {
                reportAudioTrack = new ReportAudioTrack(streamTypeForAudioUsage, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1);
            } else {
                reportAudioTrack = new ReportAudioTrack(streamTypeForAudioUsage, this.sampleRate, this.channelConfig, this.outputEncoding, this.bufferSize, 1, i3);
            }
        }
        int state = reportAudioTrack.getState();
        if (state == 1) {
            return reportAudioTrack;
        }
        try {
            reportAudioTrack.release();
        } catch (Exception unused) {
        }
        throw new AudioSink.InitializationException(state, this.sampleRate, this.channelConfig, this.bufferSize);
    }

    private AudioTrack initializeKeepSessionIdAudioTrack(int i3) {
        return new ReportAudioTrack(3, 4000, 4, 2, 2, 0, i3);
    }

    private long inputFramesToDurationUs(long j3) {
        return (j3 * 1000000) / this.inputSampleRate;
    }

    private static boolean isEncodingPcm(int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824 && i3 != 4) {
            return false;
        }
        return true;
    }

    private boolean isInitialized() {
        if (this.audioTrack != null) {
            return true;
        }
        return false;
    }

    private void maybeSampleSyncParams() {
        long positionUs = this.audioTrackUtil.getPositionUs();
        if (positionUs == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
            long[] jArr = this.playheadOffsets;
            int i3 = this.nextPlayheadOffsetIndex;
            jArr[i3] = positionUs - nanoTime;
            this.nextPlayheadOffsetIndex = (i3 + 1) % 10;
            int i16 = this.playheadOffsetCount;
            if (i16 < 10) {
                this.playheadOffsetCount = i16 + 1;
            }
            this.lastPlayheadSampleTimeUs = nanoTime;
            this.smoothedPlayheadOffsetUs = 0L;
            int i17 = 0;
            while (true) {
                int i18 = this.playheadOffsetCount;
                if (i17 >= i18) {
                    break;
                }
                this.smoothedPlayheadOffsetUs += this.playheadOffsets[i17] / i18;
                i17++;
            }
        }
        if (!needsPassthroughWorkarounds() && nanoTime - this.lastTimestampSampleTimeUs >= 500000) {
            boolean updateTimestamp = this.audioTrackUtil.updateTimestamp();
            this.audioTimestampSet = updateTimestamp;
            if (updateTimestamp) {
                long timestampNanoTime = this.audioTrackUtil.getTimestampNanoTime() / 1000;
                long timestampFramePosition = this.audioTrackUtil.getTimestampFramePosition();
                if (timestampNanoTime < this.resumeSystemTimeUs) {
                    this.audioTimestampSet = false;
                } else if (Math.abs(timestampNanoTime - nanoTime) > 5000000) {
                    String str = "Spurious audio timestamp (system clock mismatch): " + timestampFramePosition + ", " + timestampNanoTime + ", " + nanoTime + ", " + positionUs + ", " + getSubmittedFrames() + ", " + getWrittenFrames();
                    if (!failOnSpuriousAudioTimestamp) {
                        Log.w(TAG, str);
                        this.audioTimestampSet = false;
                    } else {
                        throw new InvalidAudioTrackTimestampException(str);
                    }
                } else if (Math.abs(framesToDurationUs(timestampFramePosition) - positionUs) > 5000000) {
                    String str2 = "Spurious audio timestamp (frame position mismatch): " + timestampFramePosition + ", " + timestampNanoTime + ", " + nanoTime + ", " + positionUs + ", " + getSubmittedFrames() + ", " + getWrittenFrames();
                    if (!failOnSpuriousAudioTimestamp) {
                        Log.w(TAG, str2);
                        this.audioTimestampSet = false;
                    } else {
                        throw new InvalidAudioTrackTimestampException(str2);
                    }
                }
            }
            if (this.getLatencyMethod != null && this.isInputPcm) {
                try {
                    long intValue = (((Integer) r1.invoke(this.audioTrack, null)).intValue() * 1000) - this.bufferSizeUs;
                    this.latencyUs = intValue;
                    long max = Math.max(intValue, 0L);
                    this.latencyUs = max;
                    if (max > 5000000) {
                        Log.w(TAG, "Ignoring impossibly large audio latency: " + this.latencyUs);
                        this.latencyUs = 0L;
                    }
                } catch (Exception unused) {
                    this.getLatencyMethod = null;
                }
            }
            this.lastTimestampSampleTimeUs = nanoTime;
        }
    }

    private boolean needsPassthroughWorkarounds() {
        int i3;
        if (Util.SDK_INT < 23 && ((i3 = this.outputEncoding) == 5 || i3 == 6)) {
            return true;
        }
        return false;
    }

    private boolean overrideHasPendingData() {
        if (needsPassthroughWorkarounds() && this.audioTrack.getPlayState() == 2 && this.audioTrack.getPlaybackHeadPosition() == 0) {
            return true;
        }
        return false;
    }

    private void processBuffers(long j3) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.audioProcessors.length;
        int i3 = length;
        while (i3 >= 0) {
            if (i3 > 0) {
                byteBuffer = this.outputBuffers[i3 - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i3 == length) {
                writeBuffer(byteBuffer, j3);
            } else {
                AudioProcessor audioProcessor = this.audioProcessors[i3];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i3] = output;
                if (output.hasRemaining()) {
                    i3++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i3--;
            }
        }
    }

    private void releaseKeepSessionIdAudioTrack() {
        final AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack == null) {
            return;
        }
        this.keepSessionIdAudioTrack = null;
        new BaseThread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                audioTrack.release();
            }
        }.start();
    }

    private void resetAudioProcessors() {
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : getAvailableAudioProcessors()) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.audioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        for (int i3 = 0; i3 < size; i3++) {
            AudioProcessor audioProcessor2 = this.audioProcessors[i3];
            audioProcessor2.flush();
            this.outputBuffers[i3] = audioProcessor2.getOutput();
        }
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
        this.audioTimestampSet = false;
        this.lastTimestampSampleTimeUs = 0L;
    }

    private void setVolumeInternal() {
        if (isInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    @TargetApi(21)
    private static void setVolumeInternalV21(AudioTrack audioTrack, float f16) {
        audioTrack.setVolume(f16);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack, float f16) {
        audioTrack.setStereoVolume(f16, f16);
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j3) throws AudioSink.WriteException {
        boolean z16;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.outputBuffer;
        boolean z17 = true;
        int i3 = 0;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkArgument(z16);
        } else {
            this.outputBuffer = byteBuffer;
            if (Util.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.preV21OutputBuffer;
                if (bArr == null || bArr.length < remaining) {
                    this.preV21OutputBuffer = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                byteBuffer.position(position);
                this.preV21OutputBufferOffset = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (Util.SDK_INT < 21) {
            int playbackHeadPosition = this.bufferSize - ((int) (this.writtenPcmBytes - (this.audioTrackUtil.getPlaybackHeadPosition() * this.outputPcmFrameSize)));
            if (playbackHeadPosition > 0) {
                int write = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, playbackHeadPosition));
                AudioSink.Listener listener = this.listener;
                if (listener != null && listener.isNeedAudioData() && write > 0) {
                    byte[] bArr2 = new byte[write];
                    int position2 = byteBuffer.position();
                    byteBuffer.get(bArr2, 0, write);
                    byteBuffer.position(position2);
                    this.listener.onRenderAudioData(bArr2);
                }
                if (write > 0) {
                    this.preV21OutputBufferOffset += write;
                    byteBuffer.position(byteBuffer.position() + write);
                }
                i3 = write;
            }
        } else if (this.tunneling) {
            if (j3 == -9223372036854775807L) {
                z17 = false;
            }
            Assertions.checkState(z17);
            i3 = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j3);
        } else {
            AudioSink.Listener listener2 = this.listener;
            if (listener2 != null && listener2.isNeedAudioData()) {
                int position3 = byteBuffer.position();
                int writeNonBlockingV21 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
                if (writeNonBlockingV21 > 0) {
                    int position4 = byteBuffer.position();
                    byteBuffer.position(position3);
                    byte[] bArr3 = new byte[writeNonBlockingV21];
                    byteBuffer.get(bArr3, 0, writeNonBlockingV21);
                    byteBuffer.position(position4);
                    this.listener.onRenderAudioData(bArr3);
                }
                i3 = writeNonBlockingV21;
            } else {
                i3 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
            }
        }
        this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
        if (i3 >= 0) {
            boolean z18 = this.isInputPcm;
            if (z18) {
                this.writtenPcmBytes += i3;
            }
            if (i3 == remaining2) {
                if (!z18) {
                    this.writtenEncodedFrames += this.framesPerEncodedSample;
                }
                this.outputBuffer = null;
                return;
            }
            return;
        }
        throw new AudioSink.WriteException(i3);
    }

    @TargetApi(21)
    private static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3) {
        return audioTrack.write(byteBuffer, i3, 1);
    }

    @TargetApi(21)
    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3, long j3) {
        if (this.avSyncHeader == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.avSyncHeader = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i3);
            this.avSyncHeader.putLong(8, j3 * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i3;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack, byteBuffer, i3);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0135  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configure(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, int i26) throws AudioSink.ConfigurationException {
        boolean z16;
        int i27;
        boolean z17;
        boolean z18;
        int i28;
        boolean z19;
        int i29;
        int i36;
        long j3;
        this.inputSampleRate = i17;
        this.isInputPcm = isEncodingPcm(i3);
        boolean z26 = true;
        if (this.enableConvertHighResIntPcmToFloat && isEncodingSupported(1073741824) && Util.isEncodingHighResolutionIntegerPcm(i3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.shouldConvertHighResIntPcmToFloat = z16;
        if (this.isInputPcm) {
            this.pcmFrameSize = Util.getPcmFrameSize(i3, i16);
        }
        int i37 = 4;
        if (this.isInputPcm) {
            i27 = i3;
            if (i27 != 4) {
                z17 = true;
                if (!z17 && !this.shouldConvertHighResIntPcmToFloat) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                this.canApplyPlaybackParameters = z18;
                if (!z17) {
                    this.trimmingAudioProcessor.setTrimSampleCount(i19, i26);
                    this.channelMappingAudioProcessor.setChannelMap(iArr);
                    i28 = i17;
                    z19 = false;
                    i29 = i16;
                    for (AudioProcessor audioProcessor : getAvailableAudioProcessors()) {
                        try {
                            z19 |= audioProcessor.configure(i28, i29, i27);
                            if (audioProcessor.isActive()) {
                                i29 = audioProcessor.getOutputChannelCount();
                                i28 = audioProcessor.getOutputSampleRateHz();
                                i27 = audioProcessor.getOutputEncoding();
                            }
                        } catch (AudioProcessor.UnhandledFormatException e16) {
                            throw new AudioSink.ConfigurationException(e16);
                        }
                    }
                } else {
                    i28 = i17;
                    z19 = false;
                    i29 = i16;
                }
                int i38 = 252;
                int i39 = 12;
                switch (i29) {
                    case 1:
                        break;
                    case 2:
                        i37 = 12;
                        break;
                    case 3:
                        i37 = 28;
                        break;
                    case 4:
                        i37 = 204;
                        break;
                    case 5:
                        i37 = 220;
                        break;
                    case 6:
                        i37 = 252;
                        break;
                    case 7:
                        i37 = 1276;
                        break;
                    case 8:
                        i37 = C.CHANNEL_OUT_7POINT1_SURROUND;
                        break;
                    default:
                        throw new AudioSink.ConfigurationException("Unsupported channel count: " + i29);
                }
                i36 = Util.SDK_INT;
                if (i36 <= 23 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER)) {
                    if (i29 != 3 && i29 != 5) {
                        if (i29 == 7) {
                            i38 = C.CHANNEL_OUT_7POINT1_SURROUND;
                        }
                    }
                    if (i36 <= 25 || !"fugu".equals(Util.DEVICE) || this.isInputPcm || i29 != 1) {
                        i39 = i38;
                    }
                    if (z19 && isInitialized() && this.outputEncoding == i27 && this.sampleRate == i28 && this.channelConfig == i39) {
                        return;
                    }
                    reset();
                    this.processingEnabled = z17;
                    this.sampleRate = i28;
                    this.channelConfig = i39;
                    this.outputEncoding = i27;
                    if (this.isInputPcm) {
                        this.outputPcmFrameSize = Util.getPcmFrameSize(i27, i29);
                    }
                    if (i18 == 0) {
                        this.bufferSize = i18;
                    } else if (this.isInputPcm) {
                        int minBufferSize = AudioTrack.getMinBufferSize(i28, i39, this.outputEncoding);
                        if (minBufferSize == -2) {
                            z26 = false;
                        }
                        Assertions.checkState(z26);
                        this.bufferSize = Util.constrainValue(minBufferSize * 4, ((int) durationUsToFrames(250000L)) * this.outputPcmFrameSize, (int) Math.max(minBufferSize, durationUsToFrames(MAX_BUFFER_DURATION_US) * this.outputPcmFrameSize));
                    } else {
                        int i46 = this.outputEncoding;
                        if (i46 != 5 && i46 != 6) {
                            if (i46 == 7) {
                                this.bufferSize = 49152;
                            } else {
                                this.bufferSize = 294912;
                            }
                        } else {
                            this.bufferSize = 20480;
                        }
                    }
                    if (!this.isInputPcm) {
                        j3 = framesToDurationUs(this.bufferSize / this.outputPcmFrameSize);
                    } else {
                        j3 = -9223372036854775807L;
                    }
                    this.bufferSizeUs = j3;
                }
                i38 = i37;
                if (i36 <= 25) {
                }
                i39 = i38;
                if (z19) {
                }
                reset();
                this.processingEnabled = z17;
                this.sampleRate = i28;
                this.channelConfig = i39;
                this.outputEncoding = i27;
                if (this.isInputPcm) {
                }
                if (i18 == 0) {
                }
                if (!this.isInputPcm) {
                }
                this.bufferSizeUs = j3;
            }
        } else {
            i27 = i3;
        }
        z17 = false;
        if (!z17) {
        }
        z18 = false;
        this.canApplyPlaybackParameters = z18;
        if (!z17) {
        }
        int i382 = 252;
        int i392 = 12;
        switch (i29) {
        }
        i36 = Util.SDK_INT;
        if (i36 <= 23) {
            if (i29 != 3) {
                if (i29 == 7) {
                }
            }
            if (i36 <= 25) {
            }
            i392 = i382;
            if (z19) {
            }
            reset();
            this.processingEnabled = z17;
            this.sampleRate = i28;
            this.channelConfig = i392;
            this.outputEncoding = i27;
            if (this.isInputPcm) {
            }
            if (i18 == 0) {
            }
            if (!this.isInputPcm) {
            }
            this.bufferSizeUs = j3;
        }
        i382 = i37;
        if (i36 <= 25) {
        }
        i392 = i382;
        if (z19) {
        }
        reset();
        this.processingEnabled = z17;
        this.sampleRate = i28;
        this.channelConfig = i392;
        this.outputEncoding = i27;
        if (this.isInputPcm) {
        }
        if (i18 == 0) {
        }
        if (!this.isInputPcm) {
        }
        this.bufferSizeUs = j3;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i3) {
        boolean z16;
        if (Util.SDK_INT >= 21) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        if (!this.tunneling || this.audioSessionId != i3) {
            this.tunneling = true;
            this.audioSessionId = i3;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z16) {
        long j3;
        if (!hasCurrentPositionUs()) {
            return Long.MIN_VALUE;
        }
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.audioTimestampSet) {
            j3 = framesToDurationUs(this.audioTrackUtil.getTimestampFramePosition() + durationUsToFrames(nanoTime - (this.audioTrackUtil.getTimestampNanoTime() / 1000)));
        } else {
            if (this.playheadOffsetCount == 0) {
                j3 = this.audioTrackUtil.getPositionUs();
            } else {
                j3 = nanoTime + this.smoothedPlayheadOffsetUs;
            }
            if (!z16) {
                j3 -= this.latencyUs;
            }
        }
        return this.startMediaTimeUs + applySpeedup(Math.min(j3, framesToDurationUs(getWrittenFrames())));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j3) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z16;
        String str;
        String str2;
        int i3;
        ByteBuffer byteBuffer2 = this.inputBuffer;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            z16 = false;
        } else {
            z16 = true;
        }
        Assertions.checkArgument(z16);
        if (!isInitialized()) {
            initialize();
            if (this.playing) {
                play();
            }
        }
        if (needsPassthroughWorkarounds()) {
            if (this.audioTrack.getPlayState() == 2) {
                this.hasData = false;
                return false;
            }
            if (this.audioTrack.getPlayState() == 1 && this.audioTrackUtil.getPlaybackHeadPosition() != 0) {
                return false;
            }
        }
        boolean z17 = this.hasData;
        boolean hasPendingData = hasPendingData();
        this.hasData = hasPendingData;
        if (z17 && !hasPendingData && this.audioTrack.getPlayState() != 1 && this.listener != null) {
            this.listener.onUnderrun(this.bufferSize, C.usToMs(this.bufferSizeUs), SystemClock.elapsedRealtime() - this.lastFeedElapsedRealtimeMs);
        }
        if (this.inputBuffer == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.isInputPcm && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample = getFramesPerEncodedSample(this.outputEncoding, byteBuffer);
                this.framesPerEncodedSample = framesPerEncodedSample;
                if (framesPerEncodedSample == 0) {
                    return true;
                }
            }
            if (this.drainingPlaybackParameters != null) {
                if (!drainAudioProcessorsToEndOfStream()) {
                    return false;
                }
                ArrayDeque<PlaybackParametersCheckpoint> arrayDeque = this.playbackParametersCheckpoints;
                PlaybackParameters playbackParameters = this.drainingPlaybackParameters;
                long max = Math.max(0L, j3);
                str2 = TAG;
                arrayDeque.add(new PlaybackParametersCheckpoint(playbackParameters, max, framesToDurationUs(getWrittenFrames())));
                this.drainingPlaybackParameters = null;
                resetAudioProcessors();
            } else {
                str2 = TAG;
            }
            if (this.startMediaTimeState == 0) {
                this.startMediaTimeUs = Math.max(0L, j3);
                this.startMediaTimeState = 1;
                str = str2;
            } else {
                long inputFramesToDurationUs = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames());
                if (this.startMediaTimeState == 1 && Math.abs(inputFramesToDurationUs - j3) > 200000) {
                    str = str2;
                    Log.e(str, "Discontinuity detected [expected " + inputFramesToDurationUs + ", got " + j3 + "]");
                    i3 = 2;
                    this.startMediaTimeState = 2;
                } else {
                    str = str2;
                    i3 = 2;
                }
                if (this.startMediaTimeState == i3) {
                    this.startMediaTimeUs += j3 - inputFramesToDurationUs;
                    this.startMediaTimeState = 1;
                    AudioSink.Listener listener = this.listener;
                    if (listener != null) {
                        listener.onPositionDiscontinuity();
                    }
                }
            }
            if (this.isInputPcm) {
                this.submittedPcmBytes += byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += this.framesPerEncodedSample;
            }
            this.inputBuffer = byteBuffer;
        } else {
            str = TAG;
        }
        if (this.processingEnabled) {
            processBuffers(j3);
        } else {
            writeBuffer(this.inputBuffer, j3);
        }
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            return true;
        }
        if (this.audioTrackUtil.needsReset(getWrittenFrames())) {
            Log.w(str, "Resetting stalled audio track");
            reset();
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        if (this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        if (isInitialized() && (getWrittenFrames() > this.audioTrackUtil.getPlaybackHeadPosition() || overrideHasPendingData())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEncodingSupported(int i3) {
        if (isEncodingPcm(i3)) {
            if (i3 != 4 || Util.SDK_INT >= 21) {
                return true;
            }
            return false;
        }
        AudioCapabilities audioCapabilities = this.audioCapabilities;
        if (audioCapabilities != null && audioCapabilities.supportsEncoding(i3)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        if (isInitialized() && (!this.handledEndOfStream || hasPendingData())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.playing = false;
        if (isInitialized()) {
            resetSyncParams();
            this.audioTrackUtil.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.playing = true;
        if (isInitialized()) {
            this.resumeSystemTimeUs = System.nanoTime() / 1000;
            this.audioTrack.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isInitialized() && drainAudioProcessorsToEndOfStream()) {
            this.audioTrackUtil.handleEndOfStream(getWrittenFrames());
            this.bytesUntilNextAvSync = 0;
            this.handledEndOfStream = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        releaseKeepSessionIdAudioTrack();
        for (AudioProcessor audioProcessor : this.toIntPcmAvailableAudioProcessors) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.toFloatPcmAvailableAudioProcessors) {
            audioProcessor2.reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.writtenPcmBytes = 0L;
            this.writtenEncodedFrames = 0L;
            this.framesPerEncodedSample = 0;
            PlaybackParameters playbackParameters = this.drainingPlaybackParameters;
            if (playbackParameters != null) {
                this.playbackParameters = playbackParameters;
                this.drainingPlaybackParameters = null;
            } else if (!this.playbackParametersCheckpoints.isEmpty()) {
                this.playbackParameters = this.playbackParametersCheckpoints.getLast().playbackParameters;
            }
            this.playbackParametersCheckpoints.clear();
            this.playbackParametersOffsetUs = 0L;
            this.playbackParametersPositionUs = 0L;
            this.inputBuffer = null;
            this.outputBuffer = null;
            int i3 = 0;
            while (true) {
                AudioProcessor[] audioProcessorArr = this.audioProcessors;
                if (i3 >= audioProcessorArr.length) {
                    break;
                }
                AudioProcessor audioProcessor = audioProcessorArr[i3];
                audioProcessor.flush();
                this.outputBuffers[i3] = audioProcessor.getOutput();
                i3++;
            }
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            this.startMediaTimeState = 0;
            this.latencyUs = 0L;
            resetSyncParams();
            if (this.audioTrack.getPlayState() == 3) {
                this.audioTrack.pause();
            }
            final AudioTrack audioTrack = this.audioTrack;
            this.audioTrack = null;
            this.audioTrackUtil.reconfigure(null, false);
            this.releasingConditionVariable.close();
            new BaseThread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        if (this.audioAttributes.equals(audioAttributes)) {
            return;
        }
        this.audioAttributes = audioAttributes;
        if (this.tunneling) {
            return;
        }
        reset();
        this.audioSessionId = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i3) {
        if (this.audioSessionId != i3) {
            this.audioSessionId = i3;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.listener = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (isInitialized() && !this.canApplyPlaybackParameters) {
            PlaybackParameters playbackParameters2 = PlaybackParameters.DEFAULT;
            this.playbackParameters = playbackParameters2;
            return playbackParameters2;
        }
        PlaybackParameters playbackParameters3 = new PlaybackParameters(this.sonicAudioProcessor.setSpeed(playbackParameters.speed), this.sonicAudioProcessor.setPitch(playbackParameters.pitch));
        PlaybackParameters playbackParameters4 = this.drainingPlaybackParameters;
        if (playbackParameters4 == null) {
            if (!this.playbackParametersCheckpoints.isEmpty()) {
                playbackParameters4 = this.playbackParametersCheckpoints.getLast().playbackParameters;
            } else {
                playbackParameters4 = this.playbackParameters;
            }
        }
        if (!playbackParameters3.equals(playbackParameters4)) {
            if (isInitialized()) {
                this.drainingPlaybackParameters = playbackParameters3;
            } else {
                this.playbackParameters = playbackParameters3;
            }
        }
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f16) {
        if (this.volume != f16) {
            this.volume = f16;
            setVolumeInternal();
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr, boolean z16) {
        this.audioCapabilities = audioCapabilities;
        this.enableConvertHighResIntPcmToFloat = z16;
        this.releasingConditionVariable = new ConditionVariable(true);
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (Util.SDK_INT >= 19) {
            this.audioTrackUtil = new AudioTrackUtilV19();
        } else {
            this.audioTrackUtil = new AudioTrackUtil();
        }
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor;
        SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
        this.sonicAudioProcessor = sonicAudioProcessor;
        AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 4];
        this.toIntPcmAvailableAudioProcessors = audioProcessorArr2;
        audioProcessorArr2[0] = new ResamplingAudioProcessor();
        audioProcessorArr2[1] = channelMappingAudioProcessor;
        audioProcessorArr2[2] = trimmingAudioProcessor;
        System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 3, audioProcessorArr.length);
        audioProcessorArr2[audioProcessorArr.length + 3] = sonicAudioProcessor;
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.playheadOffsets = new long[10];
        this.volume = 1.0f;
        this.startMediaTimeState = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.drainingAudioProcessorIndex = -1;
        this.audioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.playbackParametersCheckpoints = new ArrayDeque<>();
    }
}
