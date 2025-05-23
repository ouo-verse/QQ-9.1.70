package com.tencent.thumbplayer.core.renderer;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thumbplayer.core.renderer.ITPAudioSink;
import com.tencent.thumbplayer.core.renderer.TPAudioTrackPositionTracker;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ExecutorService;

/* loaded from: classes26.dex */
public final class TPAudioSink implements ITPAudioSink {
    public static final int AUDIO_SESSION_ID_UNSET = 0;
    private static final int AUDIO_TRACK_RETRY_DURATION_MS = 100;
    private static final int AUDIO_TRACK_SMALLER_BUFFER_RETRY_SIZE = 1000000;
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    private static final int ERROR_NATIVE_DEAD_OBJECT = -32;
    private static final long LATENCY_LOG_INTERVER_MS = 3000;
    public static final int OUTPUT_MODE_PASSTHROUGH = 1;
    public static final int OUTPUT_MODE_PCM = 0;
    private static final String TAG = "TPAudioSink";

    @GuardedBy("releaseExecutorLock")
    private static int pendingReleaseCount;

    @Nullable
    @GuardedBy("releaseExecutorLock")
    private static ExecutorService releaseExecutor;
    private static final Object releaseExecutorLock = new Object();
    private AudioAttributes audioAttributes;
    private int audioSessionId;

    @Nullable
    private AudioTrack audioTrack;
    private final TPAudioTrackBufferSizeProvider audioTrackBufferSizeProvider = new TPAudioTrackBufferSizeProvider();
    private final TPAudioTrackPositionTracker audioTrackPositionTracker;
    private long audioTrackPositionUs;

    @Nullable
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private Configuration configuration;
    private boolean externalAudioSessionIdProvided;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private final PendingExceptionHolder<ITPAudioSink.InitializationException> initializationExceptionPendingExceptionHolder;

    @Nullable
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private long lastFeedElapsedRealtimeMs;
    private long lastTunnelingAvSyncPresentationTimeUs;
    private boolean latencyInvalid;

    @Nullable
    private ITPAudioSink.Listener listener;
    private long mediaPresentationTimeUs;

    @Nullable
    private ByteBuffer outputBuffer;

    @Nullable
    private Configuration pendingConfiguration;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;

    @Nullable
    private AudioDeviceInfoApi23 preferredDevice;
    private final TPConditionVariable releasingConditionVariable;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsInit;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private boolean tunneling;
    private float volume;
    private final PendingExceptionHolder<ITPAudioSink.WriteException> writeExceptionPendingExceptionHolder;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(23)
    /* loaded from: classes26.dex */
    public static final class Api23 {
        Api23() {
        }

        public static void setPreferredDeviceOnAudioTrack(AudioTrack audioTrack, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo audioDeviceInfo;
            if (audioDeviceInfoApi23 == null) {
                audioDeviceInfo = null;
            } else {
                audioDeviceInfo = audioDeviceInfoApi23.audioDeviceInfo;
            }
            audioTrack.setPreferredDevice(audioDeviceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(23)
    /* loaded from: classes26.dex */
    public static final class AudioDeviceInfoApi23 {
        public final AudioDeviceInfo audioDeviceInfo;

        public AudioDeviceInfoApi23(AudioDeviceInfo audioDeviceInfo) {
            this.audioDeviceInfo = audioDeviceInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static final class Configuration {
        public final int bufferSize;
        public final ITPAudioSink.Format inputFormat;
        public final int inputPcmFrameSize;
        public final int outputChannelConfig;
        public final int outputEncoding;
        public final int outputMode;
        public final int outputPcmFrameSize;
        public final int outputSampleRate;

        public Configuration(ITPAudioSink.Format format, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
            this.inputFormat = format;
            this.inputPcmFrameSize = i3;
            this.outputMode = i16;
            this.outputPcmFrameSize = i17;
            this.outputSampleRate = i18;
            this.outputChannelConfig = i19;
            this.outputEncoding = i26;
            this.bufferSize = i27;
        }

        private AudioTrack createAudioTrack(boolean z16, AudioAttributes audioAttributes, int i3) {
            String str;
            if (("Create audio track, tunneling:" + z16 + " attributes:" + audioAttributes) == null) {
                str = "null";
            } else {
                str = audioAttributes + " sessionId:" + i3 + " inputPcmFrameSize:" + this.inputPcmFrameSize + " outputMode:" + this.outputMode + " outputPcmFrameSize:" + this.outputPcmFrameSize + " sampleRate:" + this.outputSampleRate + " channelConfig:" + this.outputChannelConfig + " encoding:" + this.outputEncoding + " bufferSize:" + this.bufferSize;
            }
            TPNativeLog.printLog(2, TPAudioSink.TAG, str);
            if (Build.VERSION.SDK_INT >= 29) {
                return createAudioTrackV29(z16, audioAttributes, i3);
            }
            return createAudioTrackV21(z16, audioAttributes, i3);
        }

        @RequiresApi(21)
        private AudioTrack createAudioTrackV21(boolean z16, AudioAttributes audioAttributes, int i3) {
            TPNativeLog.printLog(2, TPAudioSink.TAG, "createAudioTrackV21");
            return new ReportAudioTrack(getAudioTrackAttributesV21(audioAttributes, z16), TPAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding), this.bufferSize, 1, i3);
        }

        @RequiresApi(29)
        private AudioTrack createAudioTrackV29(boolean z16, AudioAttributes audioAttributes, int i3) {
            TPNativeLog.printLog(2, TPAudioSink.TAG, "createAudioTrackV29");
            return new ReportAudioTrack.Builder().setAudioAttributes(getAudioTrackAttributesV21(audioAttributes, z16)).setAudioFormat(TPAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding)).setTransferMode(1).setBufferSizeInBytes(this.bufferSize).setSessionId(i3).build();
        }

        private AudioTrack createAudioTrackV9(int i3) {
            TPNativeLog.printLog(2, TPAudioSink.TAG, "createAudioTrackV9");
            if (i3 == 0) {
                return new ReportAudioTrack(3, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
            }
            return new ReportAudioTrack(3, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, i3);
        }

        @RequiresApi(21)
        private static AudioAttributes getAudioTrackAttributesV21(AudioAttributes audioAttributes, boolean z16) {
            if (z16) {
                return getAudioTrackTunnelingAttributesV21();
            }
            if (audioAttributes == null) {
                return new AudioAttributes.Builder().setUsage(1).build();
            }
            return audioAttributes;
        }

        @RequiresApi(21)
        private static AudioAttributes getAudioTrackTunnelingAttributesV21() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack buildAudioTrack(boolean z16, AudioAttributes audioAttributes, int i3) throws ITPAudioSink.InitializationException {
            try {
                AudioTrack createAudioTrack = createAudioTrack(z16, audioAttributes, i3);
                int state = createAudioTrack.getState();
                if (state == 1) {
                    return createAudioTrack;
                }
                TPNativeLog.printLog(0, TPAudioSink.TAG, "Audio track created in error state:" + state);
                try {
                    createAudioTrack.release();
                } catch (Exception unused) {
                }
                throw new ITPAudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, false, null);
            } catch (IllegalArgumentException | UnsupportedOperationException e16) {
                throw new ITPAudioSink.InitializationException(0, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, false, e16);
            }
        }

        public boolean canReuseAudioTrack(Configuration configuration) {
            if (configuration.outputMode == this.outputMode && configuration.outputEncoding == this.outputEncoding && configuration.outputSampleRate == this.outputSampleRate && configuration.outputChannelConfig == this.outputChannelConfig && configuration.outputPcmFrameSize == this.outputPcmFrameSize) {
                return true;
            }
            return false;
        }

        public Configuration copyWithBufferSize(int i3) {
            return new Configuration(this.inputFormat, this.inputPcmFrameSize, this.outputMode, this.outputPcmFrameSize, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, i3);
        }

        public long framesToDurationUs(long j3) {
            return TPAudioSinkUtils.sampleCountToDurationUs(j3, this.outputSampleRate);
        }

        public long inputFramesToDurationUs(long j3) {
            return TPAudioSinkUtils.sampleCountToDurationUs(j3, this.inputFormat.sampleRate);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface OutputMode {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static final class PendingExceptionHolder<T extends Exception> {

        @Nullable
        private T pendingException;
        private long throwDeadlineMs;
        private final long throwDelayMs;

        public PendingExceptionHolder(long j3) {
            this.throwDelayMs = j3;
        }

        public void clear() {
            this.pendingException = null;
        }

        public void throwExceptionIfDeadlineIsReached(T t16) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.pendingException == null) {
                this.pendingException = t16;
                this.throwDeadlineMs = this.throwDelayMs + elapsedRealtime;
            }
            if (elapsedRealtime >= this.throwDeadlineMs) {
                T t17 = this.pendingException;
                if (t17 != t16) {
                    t17.addSuppressed(t16);
                }
                T t18 = this.pendingException;
                clear();
                throw t18;
            }
        }
    }

    /* loaded from: classes26.dex */
    private final class PositionTrackerListener implements TPAudioTrackPositionTracker.Listener {
        PositionTrackerListener() {
        }

        @Override // com.tencent.thumbplayer.core.renderer.TPAudioTrackPositionTracker.Listener
        public void OnLatencyHugeDiffUs(long j3) {
            TPNativeLog.printLog(0, TPAudioSink.TAG, "OnHugeLatencyDiff, diffUs " + j3);
            TPAudioSink.this.latencyInvalid = true;
        }

        @Override // com.tencent.thumbplayer.core.renderer.TPAudioTrackPositionTracker.Listener
        public void onInvalidLatency(long j3) {
            TPNativeLog.printLog(0, TPAudioSink.TAG, "onInvalidLatency, latencyUs:" + j3);
            TPAudioSink.this.latencyInvalid = true;
        }

        @Override // com.tencent.thumbplayer.core.renderer.TPAudioTrackPositionTracker.Listener
        public void onPositionAdvancing(long j3) {
            TPNativeLog.printLog(1, TPAudioSink.TAG, "onPositionAdvancing, playoutStartSystemTimeMs:" + j3);
            if (TPAudioSink.this.listener != null) {
                TPAudioSink.this.listener.onPositionAdvancing(j3);
            }
        }

        @Override // com.tencent.thumbplayer.core.renderer.TPAudioTrackPositionTracker.Listener
        public void onPositionFramesMismatch(long j3, long j16, long j17, long j18) {
            TPNativeLog.printLog(1, TPAudioSink.TAG, "Spurious audio timestamp (frame position mismatch): " + j3 + ", " + j16 + ", " + j17 + ", " + j18 + ", " + TPAudioSink.this.getSubmittedFrames() + ", " + TPAudioSink.this.getWrittenFrames());
        }

        @Override // com.tencent.thumbplayer.core.renderer.TPAudioTrackPositionTracker.Listener
        public void onSystemTimeUsMismatch(long j3, long j16, long j17, long j18) {
            TPNativeLog.printLog(1, TPAudioSink.TAG, "Spurious audio timestamp (frame position mismatch): " + j3 + ", " + j16 + ", " + j17 + ", " + j18 + ", " + TPAudioSink.this.getSubmittedFrames() + ", " + TPAudioSink.this.getWrittenFrames());
        }

        @Override // com.tencent.thumbplayer.core.renderer.TPAudioTrackPositionTracker.Listener
        public void onUnderrun(int i3, long j3) {
            TPNativeLog.printLog(1, TPAudioSink.TAG, "onUnderrun, bufferSize:" + i3 + " bufferSizeMs:" + j3);
            if (TPAudioSink.this.listener != null) {
                TPAudioSink.this.listener.onUnderrun(i3, j3, SystemClock.elapsedRealtime() - TPAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    public TPAudioSink() {
        TPConditionVariable tPConditionVariable = new TPConditionVariable();
        this.releasingConditionVariable = tPConditionVariable;
        tPConditionVariable.open();
        this.audioTrackPositionTracker = new TPAudioTrackPositionTracker(new PositionTrackerListener());
        this.volume = 1.0f;
        this.audioSessionId = 0;
        this.initializationExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100L);
        this.writeExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100L);
        this.mediaPresentationTimeUs = -9223372036854775807L;
        this.audioTrackPositionUs = -9223372036854775807L;
        this.latencyInvalid = false;
    }

    private AudioTrack buildAudioTrack(Configuration configuration) throws ITPAudioSink.InitializationException {
        try {
            return configuration.buildAudioTrack(this.tunneling, this.audioAttributes, this.audioSessionId);
        } catch (ITPAudioSink.InitializationException e16) {
            ITPAudioSink.Listener listener = this.listener;
            if (listener != null) {
                listener.onAudioSinkError(e16);
            }
            throw e16;
        }
    }

    private AudioTrack buildAudioTrackWithRetry() throws ITPAudioSink.InitializationException {
        try {
            return buildAudioTrack((Configuration) TPAudioSinkUtils.checkNotNull(this.configuration));
        } catch (ITPAudioSink.InitializationException e16) {
            if (this.configuration.bufferSize > 1000000) {
                TPNativeLog.printLog(2, TAG, "Try to build audio track with smarller size:1000000");
                Configuration copyWithBufferSize = this.configuration.copyWithBufferSize(1000000);
                try {
                    AudioTrack buildAudioTrack = buildAudioTrack(copyWithBufferSize);
                    this.configuration = copyWithBufferSize;
                    return buildAudioTrack;
                } catch (ITPAudioSink.InitializationException e17) {
                    e16.addSuppressed(e17);
                    throw e16;
                }
            }
            throw e16;
        }
    }

    public static ByteBuffer createByteBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
    }

    private boolean drainToEndOfStream() throws ITPAudioSink.WriteException {
        ByteBuffer byteBuffer = this.outputBuffer;
        if (byteBuffer == null) {
            return true;
        }
        writeBuffer(byteBuffer, Long.MIN_VALUE);
        if (this.outputBuffer == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    public static AudioFormat getAudioFormat(int i3, int i16, int i17) {
        return new AudioFormat.Builder().setSampleRate(i3).setChannelMask(i16).setEncoding(i17).build();
    }

    private static int getAudioTrackMinBufferSize(int i3, int i16, int i17) {
        boolean z16;
        int minBufferSize = AudioTrack.getMinBufferSize(i3, i16, i17);
        if (minBufferSize != -2) {
            z16 = true;
        } else {
            z16 = false;
        }
        TPAudioSinkUtils.checkState(z16);
        return minBufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getSubmittedFrames() {
        if (this.configuration.outputMode == 0) {
            return this.submittedPcmBytes / r0.inputPcmFrameSize;
        }
        return this.submittedEncodedFrames;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getWrittenFrames() {
        if (this.configuration.outputMode == 0) {
            return this.writtenPcmBytes / r0.outputPcmFrameSize;
        }
        return this.writtenEncodedFrames;
    }

    private boolean initializeAudioTrack() throws ITPAudioSink.InitializationException {
        boolean z16;
        if (!this.releasingConditionVariable.isOpen()) {
            return false;
        }
        AudioTrack buildAudioTrackWithRetry = buildAudioTrackWithRetry();
        this.audioTrack = buildAudioTrackWithRetry;
        this.audioSessionId = buildAudioTrackWithRetry.getAudioSessionId();
        TPAudioTrackPositionTracker tPAudioTrackPositionTracker = this.audioTrackPositionTracker;
        AudioTrack audioTrack = this.audioTrack;
        Configuration configuration = this.configuration;
        if (configuration.outputMode == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        tPAudioTrackPositionTracker.setAudioTrack(audioTrack, z16, configuration.outputEncoding, configuration.outputPcmFrameSize, configuration.bufferSize);
        setVolumeInternal();
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.preferredDevice;
        if (audioDeviceInfoApi23 != null) {
            Api23.setPreferredDeviceOnAudioTrack(this.audioTrack, audioDeviceInfoApi23);
        }
        this.startMediaTimeUsNeedsInit = true;
        TPNativeLog.printLog(2, TAG, "init audio track successful, actual sessionId:" + this.audioSessionId);
        return true;
    }

    private static boolean isAudioTrackDeadObject(int i3) {
        if ((Build.VERSION.SDK_INT >= 24 && i3 == -6) || i3 == -32) {
            return true;
        }
        return false;
    }

    private boolean isAudioTrackInitialized() {
        if (this.audioTrack != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$releaseAudioTrackAsync$0(AudioTrack audioTrack, TPConditionVariable tPConditionVariable) {
        try {
            audioTrack.flush();
            audioTrack.release();
            tPConditionVariable.open();
            synchronized (releaseExecutorLock) {
                int i3 = pendingReleaseCount - 1;
                pendingReleaseCount = i3;
                if (i3 == 0) {
                    releaseExecutor.shutdown();
                    releaseExecutor = null;
                }
                TPNativeLog.printLog(2, TAG, "pending release end, cnt:" + pendingReleaseCount);
            }
        } catch (Throwable th5) {
            tPConditionVariable.open();
            synchronized (releaseExecutorLock) {
                int i16 = pendingReleaseCount - 1;
                pendingReleaseCount = i16;
                if (i16 == 0) {
                    releaseExecutor.shutdown();
                    releaseExecutor = null;
                }
                TPNativeLog.printLog(2, TAG, "pending release end, cnt:" + pendingReleaseCount);
                throw th5;
            }
        }
    }

    private void playPendingData() {
        if (!this.stoppedAudioTrack) {
            this.stoppedAudioTrack = true;
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
        }
    }

    private void recordMediaPosition(long j3) {
        this.mediaPresentationTimeUs = j3;
        this.audioTrackPositionUs = this.configuration.framesToDurationUs(getWrittenFrames());
    }

    private static void releaseAudioTrackAsync(final AudioTrack audioTrack, final TPConditionVariable tPConditionVariable) {
        tPConditionVariable.close();
        synchronized (releaseExecutorLock) {
            if (releaseExecutor == null) {
                releaseExecutor = TPAudioSinkUtils.newSingleThreadExecutor("ExoPlayer:AudioTrackReleaseThread");
            }
            pendingReleaseCount++;
            TPNativeLog.printLog(2, TAG, "pending release start, cnt:" + pendingReleaseCount);
            releaseExecutor.execute(new Runnable() { // from class: com.tencent.thumbplayer.core.renderer.c
                @Override // java.lang.Runnable
                public final void run() {
                    TPAudioSink.lambda$releaseAudioTrackAsync$0(audioTrack, tPConditionVariable);
                }
            });
        }
    }

    private void resetSinkStateForFlush() {
        this.submittedPcmBytes = 0L;
        this.submittedEncodedFrames = 0L;
        this.writtenPcmBytes = 0L;
        this.writtenEncodedFrames = 0L;
        this.framesPerEncodedSample = 0;
        this.startMediaTimeUs = 0L;
        this.inputBuffer = null;
        this.inputBufferAccessUnitCount = 0;
        this.outputBuffer = null;
        this.stoppedAudioTrack = false;
        this.handledEndOfStream = false;
        this.avSyncHeader = null;
        this.bytesUntilNextAvSync = 0;
        this.mediaPresentationTimeUs = -9223372036854775807L;
        this.audioTrackPositionUs = -9223372036854775807L;
    }

    private void setVolumeInternal() {
        if (!isAudioTrackInitialized()) {
            return;
        }
        TPNativeLog.printLog(2, TAG, "set volumn:" + this.volume);
        setVolumeInternalV21(this.audioTrack, this.volume);
    }

    @RequiresApi(21)
    private static void setVolumeInternalV21(AudioTrack audioTrack, float f16) {
        audioTrack.setVolume(f16);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack, float f16) {
        audioTrack.setStereoVolume(f16, f16);
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j3) throws ITPAudioSink.WriteException {
        int writeNonBlockingV21;
        boolean z16;
        boolean z17;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.outputBuffer;
        boolean z18 = true;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z17 = true;
            } else {
                z17 = false;
            }
            TPAudioSinkUtils.checkState(z17);
        } else {
            this.outputBuffer = byteBuffer;
        }
        int remaining = byteBuffer.remaining();
        if (this.tunneling) {
            if (j3 != -9223372036854775807L) {
                z16 = true;
            } else {
                z16 = false;
            }
            TPAudioSinkUtils.checkState(z16);
            if (j3 == Long.MIN_VALUE) {
                j3 = this.lastTunnelingAvSyncPresentationTimeUs;
            } else {
                this.lastTunnelingAvSyncPresentationTimeUs = j3;
            }
            writeNonBlockingV21 = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining, j3);
        } else {
            writeNonBlockingV21 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining);
        }
        this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
        if (writeNonBlockingV21 < 0) {
            if (!isAudioTrackDeadObject(writeNonBlockingV21) || this.writtenEncodedFrames <= 0) {
                z18 = false;
            }
            ITPAudioSink.WriteException writeException = new ITPAudioSink.WriteException(writeNonBlockingV21, this.configuration.inputFormat, z18);
            ITPAudioSink.Listener listener = this.listener;
            if (listener != null) {
                listener.onAudioSinkError(writeException);
            }
            if (!writeException.isRecoverable) {
                this.writeExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(writeException);
                return;
            }
            throw writeException;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        int i3 = this.configuration.outputMode;
        if (i3 == 0) {
            this.writtenPcmBytes += writeNonBlockingV21;
        }
        if (writeNonBlockingV21 == remaining) {
            if (i3 != 0) {
                if (byteBuffer != this.inputBuffer) {
                    z18 = false;
                }
                TPAudioSinkUtils.checkState(z18);
                this.writtenEncodedFrames += this.framesPerEncodedSample * this.inputBufferAccessUnitCount;
            }
            this.outputBuffer = null;
        }
    }

    @RequiresApi(21)
    private static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3) {
        return audioTrack.write(byteBuffer, i3, 1);
    }

    @RequiresApi(21)
    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3, long j3) {
        if (Build.VERSION.SDK_INT >= 26) {
            return audioTrack.write(byteBuffer, i3, 1, j3 * 1000);
        }
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

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void configure(ITPAudioSink.Format format, int i3) throws ITPAudioSink.ConfigurationException {
        int i16;
        int i17;
        int i18;
        int intValue;
        int i19;
        int i26;
        int i27;
        int i28;
        int bufferSizeInBytes;
        TPNativeLog.printLog(2, TAG, "Configure, channels:" + format.channelCount + " sampleRate:" + format.sampleRate + " pcmEncoding:" + format.pcmEncoding + " sampleMimeType:" + format.sampleMimeType + " bitrate:" + format.bitrate);
        if ("audio/raw".equals(format.sampleMimeType)) {
            TPAudioSinkUtils.checkState(TPAudioSinkUtils.isEncodingLinearPcm(format.pcmEncoding));
            int pcmFrameSize = TPAudioSinkUtils.getPcmFrameSize(format.pcmEncoding, format.channelCount);
            int i29 = format.pcmEncoding;
            int i36 = format.sampleRate;
            int audioTrackChannelConfig = TPAudioSinkUtils.getAudioTrackChannelConfig(format.channelCount);
            i19 = i29;
            i16 = i36;
            i18 = TPAudioSinkUtils.getPcmFrameSize(i29, format.channelCount);
            i17 = 0;
            i26 = pcmFrameSize;
            intValue = audioTrackChannelConfig;
        } else {
            int i37 = format.sampleRate;
            Pair<Integer, Integer> encodingAndChannelConfigForPassthrough = TPAudioSinkUtils.getEncodingAndChannelConfigForPassthrough(format);
            if (encodingAndChannelConfigForPassthrough != null) {
                int intValue2 = ((Integer) encodingAndChannelConfigForPassthrough.first).intValue();
                i16 = i37;
                i17 = 1;
                i18 = -1;
                intValue = ((Integer) encodingAndChannelConfigForPassthrough.second).intValue();
                i19 = intValue2;
                i26 = -1;
            } else {
                throw new ITPAudioSink.ConfigurationException("Unable to configure passthrough for: " + format, format);
            }
        }
        if (i19 != 0) {
            if (intValue != 0) {
                if (i3 != 0) {
                    bufferSizeInBytes = i3;
                    i28 = i19;
                } else {
                    TPAudioTrackBufferSizeProvider tPAudioTrackBufferSizeProvider = this.audioTrackBufferSizeProvider;
                    int audioTrackMinBufferSize = getAudioTrackMinBufferSize(i16, intValue, i19);
                    if (i18 != -1) {
                        i27 = i18;
                    } else {
                        i27 = 1;
                    }
                    i28 = i19;
                    bufferSizeInBytes = tPAudioTrackBufferSizeProvider.getBufferSizeInBytes(audioTrackMinBufferSize, i19, i17, i27, i16, format.bitrate);
                }
                Configuration configuration = new Configuration(format, i26, i17, i18, i16, intValue, i28, bufferSizeInBytes);
                if (isAudioTrackInitialized()) {
                    this.pendingConfiguration = configuration;
                    return;
                } else {
                    this.configuration = configuration;
                    return;
                }
            }
            throw new ITPAudioSink.ConfigurationException("Invalid output channel config (mode=" + i17 + ") for: " + format, format);
        }
        throw new ITPAudioSink.ConfigurationException("Invalid output encoding (mode=" + i17 + ") for: " + format, format);
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            flush();
        }
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void enableTunnelingV21() {
        TPAudioSinkUtils.checkState(true);
        TPAudioSinkUtils.checkState(this.externalAudioSessionIdProvided);
        if (!this.tunneling) {
            this.tunneling = true;
            flush();
        }
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void flush() {
        if (isAudioTrackInitialized()) {
            TPNativeLog.printLog(2, TAG, "Flush");
            resetSinkStateForFlush();
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            Configuration configuration = this.pendingConfiguration;
            if (configuration != null) {
                this.configuration = configuration;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            releaseAudioTrackAsync(this.audioTrack, this.releasingConditionVariable);
            this.audioTrack = null;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public int getAudioSessionId() {
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            return this.audioSessionId;
        }
        return audioTrack.getAudioSessionId();
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public long getCurrentPositionUs(boolean z16) {
        if (isAudioTrackInitialized() && !this.startMediaTimeUsNeedsInit) {
            long min = Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z16), this.configuration.framesToDurationUs(getWrittenFrames()));
            long j3 = this.audioTrackPositionUs;
            if (j3 != -9223372036854775807L) {
                long j16 = this.mediaPresentationTimeUs;
                if (j16 != -9223372036854775807L) {
                    return j16 + (min - j3);
                }
            }
            return min;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public long getLatencyUs(boolean z16) {
        if (isAudioTrackInitialized() && !this.startMediaTimeUsNeedsInit) {
            return this.audioTrackPositionTracker.getLatencyUs(z16, this.configuration.framesToDurationUs(getWrittenFrames()));
        }
        return Long.MIN_VALUE;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j3, int i3) throws ITPAudioSink.InitializationException, ITPAudioSink.WriteException {
        boolean z16;
        boolean z17;
        ByteBuffer byteBuffer2 = this.inputBuffer;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            z16 = false;
        } else {
            z16 = true;
        }
        TPAudioSinkUtils.checkState(z16);
        TPAudioSinkUtils.checkState(!this.latencyInvalid);
        if (this.pendingConfiguration != null) {
            if (!drainToEndOfStream()) {
                return false;
            }
            if (!this.pendingConfiguration.canReuseAudioTrack(this.configuration)) {
                playPendingData();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            } else {
                this.configuration = this.pendingConfiguration;
                this.pendingConfiguration = null;
            }
            recordMediaPosition(j3);
        }
        if (!isAudioTrackInitialized()) {
            try {
                if (!initializeAudioTrack()) {
                    return false;
                }
            } catch (ITPAudioSink.InitializationException e16) {
                if (!e16.isRecoverable) {
                    this.initializationExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(e16);
                    return false;
                }
                throw e16;
            }
        }
        this.initializationExceptionPendingExceptionHolder.clear();
        if (this.startMediaTimeUsNeedsInit) {
            this.startMediaTimeUs = Math.max(0L, j3);
            this.startMediaTimeUsNeedsSync = false;
            this.startMediaTimeUsNeedsInit = false;
            recordMediaPosition(j3);
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                z17 = true;
            } else {
                z17 = false;
            }
            TPAudioSinkUtils.checkState(z17);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            Configuration configuration = this.configuration;
            if (configuration.outputMode != 0 && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample = TPAudioSinkUtils.getFramesPerEncodedSample(configuration.outputEncoding, byteBuffer);
                this.framesPerEncodedSample = framesPerEncodedSample;
                if (framesPerEncodedSample == 0) {
                    return true;
                }
            }
            long inputFramesToDurationUs = this.startMediaTimeUs + this.configuration.inputFramesToDurationUs(getSubmittedFrames());
            if (!this.startMediaTimeUsNeedsSync && Math.abs(inputFramesToDurationUs - j3) > 200000) {
                ITPAudioSink.Listener listener = this.listener;
                if (listener != null) {
                    listener.onAudioSinkError(new ITPAudioSink.UnexpectedDiscontinuityException(j3, inputFramesToDurationUs));
                }
                this.startMediaTimeUsNeedsSync = true;
            }
            if (this.startMediaTimeUsNeedsSync) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                long j16 = j3 - inputFramesToDurationUs;
                this.startMediaTimeUs += j16;
                this.startMediaTimeUsNeedsSync = false;
                recordMediaPosition(j3);
                ITPAudioSink.Listener listener2 = this.listener;
                if (listener2 != null && j16 != 0) {
                    listener2.onPositionDiscontinuity();
                }
            }
            if (this.configuration.outputMode == 0) {
                this.submittedPcmBytes += byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += this.framesPerEncodedSample * i3;
            }
            this.inputBuffer = byteBuffer;
            this.inputBufferAccessUnitCount = i3;
        }
        ByteBuffer byteBuffer3 = this.inputBuffer;
        if (byteBuffer3 == null) {
            byteBuffer3 = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
        }
        writeBuffer(byteBuffer3, j3);
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            return true;
        }
        if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return false;
        }
        TPNativeLog.printLog(1, TAG, "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public boolean hasPendingData() {
        if (isAudioTrackInitialized() && this.audioTrackPositionTracker.hasPendingData(getWrittenFrames())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public boolean isEnded() {
        if (isAudioTrackInitialized() && (!this.handledEndOfStream || hasPendingData())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void pause() {
        this.playing = false;
        if (isAudioTrackInitialized() && this.audioTrackPositionTracker.pause()) {
            TPNativeLog.printLog(2, TAG, "Pause");
            this.audioTrack.pause();
        }
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void play() {
        this.playing = true;
        if (isAudioTrackInitialized()) {
            TPNativeLog.printLog(2, TAG, "Play");
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void playToEndOfStream() throws ITPAudioSink.WriteException {
        if (!this.handledEndOfStream && isAudioTrackInitialized() && drainToEndOfStream()) {
            playPendingData();
            this.handledEndOfStream = true;
        }
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public /* synthetic */ void release() {
        a.a(this);
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void reset() {
        TPNativeLog.printLog(2, TAG, "Reset");
        flush();
        this.playing = false;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        if (this.audioAttributes.equals(audioAttributes)) {
            return;
        }
        this.audioAttributes = audioAttributes;
        if (this.tunneling) {
            return;
        }
        flush();
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void setAudioSessionId(int i3) {
        boolean z16;
        if (this.audioSessionId != i3) {
            this.audioSessionId = i3;
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.externalAudioSessionIdProvided = z16;
            flush();
        }
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void setListener(ITPAudioSink.Listener listener) {
        this.listener = listener;
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public /* synthetic */ void setOutputStreamOffsetUs(long j3) {
        a.b(this, j3);
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    @RequiresApi(23)
    public void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23;
        if (audioDeviceInfo == null) {
            audioDeviceInfoApi23 = null;
        } else {
            audioDeviceInfoApi23 = new AudioDeviceInfoApi23(audioDeviceInfo);
        }
        this.preferredDevice = audioDeviceInfoApi23;
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            Api23.setPreferredDeviceOnAudioTrack(audioTrack, audioDeviceInfoApi23);
        }
    }

    @Override // com.tencent.thumbplayer.core.renderer.ITPAudioSink
    public void setVolume(float f16) {
        if (this.volume != f16) {
            this.volume = f16;
            setVolumeInternal();
        }
    }
}
