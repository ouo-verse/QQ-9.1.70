package com.tencent.thumbplayer.core.renderer;

import android.media.AudioTrack;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.lang.reflect.Method;

/* loaded from: classes26.dex */
final class TPAudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long LATENCY_INVALID_THRESHOLD_US = 500000;
    private static final long LATENCY_LOG_INTERVER_MS = 3000;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final long MODE_SWITCH_SMOOTHING_DURATION_US = 1000000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private static final long RAW_PLAYBACK_HEAD_POSITION_UPDATE_INTERVAL_MS = 5;
    private static final String TAG = "TPAudioTrackPositionTracker";

    @Nullable
    private TPAudioTimestampPoller audioTimestampPoller;

    @Nullable
    private AudioTrack audioTrack;
    private float audioTrackPlaybackSpeed;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;

    @Nullable
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencyLogSysTimeMs;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastPositionUs;
    private long lastRawPlaybackHeadPositionSampleTimeMs;
    private boolean lastSampleUsedGetTimestampMode;
    private long lastSystemTimeUs;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private boolean notifiedPositionIncreasing;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long previousModePositionUs;
    private long previousModeSystemTimeUs;
    private long rawLatencyUsFromAudioTrack;
    private long rawPlaybackHeadPosition;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    /* loaded from: classes26.dex */
    public interface Listener {
        void OnLatencyHugeDiffUs(long j3);

        void onInvalidLatency(long j3);

        void onPositionAdvancing(long j3);

        void onPositionFramesMismatch(long j3, long j16, long j17, long j18);

        void onSystemTimeUsMismatch(long j3, long j16, long j17, long j18);

        void onUnderrun(int i3, long j3);
    }

    public TPAudioTrackPositionTracker(Listener listener) {
        this.listener = (Listener) TPAudioSinkUtils.checkNotNull(listener);
        try {
            this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.playheadOffsets = new long[10];
    }

    private boolean forceHasPendingData() {
        if (this.needsPassthroughWorkarounds && ((AudioTrack) TPAudioSinkUtils.checkNotNull(this.audioTrack)).getPlayState() == 2 && getPlaybackHeadPosition() == 0) {
            return true;
        }
        return false;
    }

    private long getPlaybackHeadPosition() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.stopTimestampUs;
        if (j3 != -9223372036854775807L) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + TPAudioSinkUtils.durationUsToSampleCount(TPAudioSinkUtils.getMediaDurationForPlayoutDuration((elapsedRealtime * 1000) - j3, this.audioTrackPlaybackSpeed), this.outputSampleRate));
        }
        if (elapsedRealtime - this.lastRawPlaybackHeadPositionSampleTimeMs >= 5) {
            updateRawPlaybackHeadPosition(elapsedRealtime);
            this.lastRawPlaybackHeadPositionSampleTimeMs = elapsedRealtime;
        }
        return this.rawPlaybackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }

    private long getPlaybackHeadPositionUs() {
        return TPAudioSinkUtils.sampleCountToDurationUs(getPlaybackHeadPosition(), this.outputSampleRate);
    }

    private void maybePollAndCheckTimestamp(long j3) {
        TPAudioTimestampPoller tPAudioTimestampPoller = (TPAudioTimestampPoller) TPAudioSinkUtils.checkNotNull(this.audioTimestampPoller);
        if (!tPAudioTimestampPoller.maybePollTimestamp(j3)) {
            return;
        }
        long timestampSystemTimeUs = tPAudioTimestampPoller.getTimestampSystemTimeUs();
        long timestampPositionFrames = tPAudioTimestampPoller.getTimestampPositionFrames();
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (Math.abs(timestampSystemTimeUs - j3) > 5000000) {
            this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j3, playbackHeadPositionUs);
            tPAudioTimestampPoller.rejectTimestamp();
        } else if (Math.abs(TPAudioSinkUtils.sampleCountToDurationUs(timestampPositionFrames, this.outputSampleRate) - playbackHeadPositionUs) > 5000000) {
            this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j3, playbackHeadPositionUs);
            tPAudioTimestampPoller.rejectTimestamp();
        } else {
            tPAudioTimestampPoller.acceptTimestamp();
        }
    }

    private void maybeSampleSyncParams() {
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
            long playbackHeadPositionUs = getPlaybackHeadPositionUs();
            if (playbackHeadPositionUs == 0) {
                return;
            }
            this.playheadOffsets[this.nextPlayheadOffsetIndex] = TPAudioSinkUtils.getPlayoutDurationForMediaDuration(playbackHeadPositionUs, this.audioTrackPlaybackSpeed) - nanoTime;
            this.nextPlayheadOffsetIndex = (this.nextPlayheadOffsetIndex + 1) % 10;
            int i3 = this.playheadOffsetCount;
            if (i3 < 10) {
                this.playheadOffsetCount = i3 + 1;
            }
            this.lastPlayheadSampleTimeUs = nanoTime;
            this.smoothedPlayheadOffsetUs = 0L;
            int i16 = 0;
            while (true) {
                int i17 = this.playheadOffsetCount;
                if (i16 >= i17) {
                    break;
                }
                this.smoothedPlayheadOffsetUs += this.playheadOffsets[i16] / i17;
                i16++;
            }
        }
        if (this.needsPassthroughWorkarounds) {
            return;
        }
        maybePollAndCheckTimestamp(nanoTime);
        maybeUpdateLatency(nanoTime);
    }

    private void maybeUpdateLatency(long j3) {
        Method method;
        if (this.isOutputPcm && (method = this.getLatencyMethod) != null && j3 - this.lastLatencySampleTimeUs >= LATENCY_INVALID_THRESHOLD_US) {
            try {
                this.rawLatencyUsFromAudioTrack = ((Integer) method.invoke(TPAudioSinkUtils.checkNotNull(this.audioTrack), new Object[0])).intValue() * 1000;
                long j16 = this.latencyUs - this.bufferSizeUs;
                this.latencyUs = j16;
                long max = Math.max(j16, 0L);
                this.latencyUs = max;
                if (max > 5000000) {
                    this.listener.onInvalidLatency(max);
                    this.latencyUs = 0L;
                }
            } catch (Exception unused) {
                this.getLatencyMethod = null;
            }
            this.lastLatencySampleTimeUs = j3;
        }
    }

    private static boolean needsPassthroughWorkarounds(int i3) {
        return false;
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
        this.lastSystemTimeUs = 0L;
        this.previousModeSystemTimeUs = 0L;
        this.notifiedPositionIncreasing = false;
    }

    private void updateRawPlaybackHeadPosition(long j3) {
        int playState = ((AudioTrack) TPAudioSinkUtils.checkNotNull(this.audioTrack)).getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = r0.getPlaybackHeadPosition() & 4294967295L;
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.rawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (Build.VERSION.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.rawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = j3;
                    return;
                }
                return;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.rawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.rawPlaybackHeadPosition = playbackHeadPosition;
    }

    public String getAudioTrackRawLatencyInfo() {
        return "AudioTrackRawInfo: getTimestampPositionFrames:" + this.audioTimestampPoller.getTimestampPositionFrames() + " getTimestampSystemTimeUs:" + this.audioTimestampPoller.getTimestampSystemTimeUs() + " bufferSizeUs:" + this.bufferSizeUs + " getLatencyUs:" + this.rawLatencyUsFromAudioTrack;
    }

    public int getAvailableBufferSize(long j3) {
        return this.bufferSize - ((int) (j3 - (getPlaybackHeadPosition() * this.outputPcmFrameSize)));
    }

    public long getCurrentPositionUs(boolean z16) {
        long mediaDurationForPlayoutDuration;
        if (((AudioTrack) TPAudioSinkUtils.checkNotNull(this.audioTrack)).getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        TPAudioTimestampPoller tPAudioTimestampPoller = (TPAudioTimestampPoller) TPAudioSinkUtils.checkNotNull(this.audioTimestampPoller);
        boolean hasAdvancingTimestamp = tPAudioTimestampPoller.hasAdvancingTimestamp();
        if (hasAdvancingTimestamp) {
            mediaDurationForPlayoutDuration = TPAudioSinkUtils.sampleCountToDurationUs(tPAudioTimestampPoller.getTimestampPositionFrames(), this.outputSampleRate) + TPAudioSinkUtils.getMediaDurationForPlayoutDuration(nanoTime - tPAudioTimestampPoller.getTimestampSystemTimeUs(), this.audioTrackPlaybackSpeed);
        } else {
            if (this.playheadOffsetCount == 0) {
                mediaDurationForPlayoutDuration = getPlaybackHeadPositionUs();
            } else {
                mediaDurationForPlayoutDuration = TPAudioSinkUtils.getMediaDurationForPlayoutDuration(this.smoothedPlayheadOffsetUs + nanoTime, this.audioTrackPlaybackSpeed);
            }
            if (!z16) {
                mediaDurationForPlayoutDuration = Math.max(0L, mediaDurationForPlayoutDuration - this.latencyUs);
            }
        }
        if (this.lastSampleUsedGetTimestampMode != hasAdvancingTimestamp) {
            this.previousModeSystemTimeUs = this.lastSystemTimeUs;
            this.previousModePositionUs = this.lastPositionUs;
        }
        long j3 = nanoTime - this.previousModeSystemTimeUs;
        if (j3 < 1000000) {
            long mediaDurationForPlayoutDuration2 = this.previousModePositionUs + TPAudioSinkUtils.getMediaDurationForPlayoutDuration(j3, this.audioTrackPlaybackSpeed);
            long j16 = (j3 * 1000) / 1000000;
            mediaDurationForPlayoutDuration = ((mediaDurationForPlayoutDuration * j16) + ((1000 - j16) * mediaDurationForPlayoutDuration2)) / 1000;
        }
        if (!this.notifiedPositionIncreasing) {
            long j17 = this.lastPositionUs;
            if (mediaDurationForPlayoutDuration > j17) {
                this.notifiedPositionIncreasing = true;
                this.listener.onPositionAdvancing(System.currentTimeMillis() - TPAudioSinkUtils.usToMs(TPAudioSinkUtils.getPlayoutDurationForMediaDuration(TPAudioSinkUtils.usToMs(mediaDurationForPlayoutDuration - j17), this.audioTrackPlaybackSpeed)));
            }
        }
        this.lastSystemTimeUs = nanoTime;
        this.lastPositionUs = mediaDurationForPlayoutDuration;
        this.lastSampleUsedGetTimestampMode = hasAdvancingTimestamp;
        return mediaDurationForPlayoutDuration;
    }

    public long getLatencyUs(boolean z16, long j3) {
        long currentPositionUs = getCurrentPositionUs(z16);
        long max = Math.max(0L, j3 - currentPositionUs);
        if (this.lastSampleUsedGetTimestampMode) {
            long j16 = this.rawLatencyUsFromAudioTrack;
            if (j16 != 0) {
                long abs = Math.abs(max - j16);
                if (abs > LATENCY_INVALID_THRESHOLD_US) {
                    this.listener.OnLatencyHugeDiffUs(abs);
                }
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.lastLatencyLogSysTimeMs > 3000) {
            TPNativeLog.printLog(2, TAG, getAudioTrackRawLatencyInfo());
            TPNativeLog.printLog(2, TAG, "positionUs:" + currentPositionUs + " writtenDurationUs:" + j3 + " latencyUs:" + max);
            this.lastLatencyLogSysTimeMs = elapsedRealtime;
        }
        return max;
    }

    public void handleEndOfStream(long j3) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j3;
    }

    public boolean hasPendingData(long j3) {
        if (j3 <= TPAudioSinkUtils.durationUsToSampleCount(getCurrentPositionUs(false), this.outputSampleRate) && !forceHasPendingData()) {
            return false;
        }
        return true;
    }

    public boolean isPlaying() {
        if (((AudioTrack) TPAudioSinkUtils.checkNotNull(this.audioTrack)).getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public boolean isStalled(long j3) {
        if (this.forceResetWorkaroundTimeMs != -9223372036854775807L && j3 > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS) {
            return true;
        }
        return false;
    }

    public boolean mayHandleBuffer(long j3) {
        int playState = ((AudioTrack) TPAudioSinkUtils.checkNotNull(this.audioTrack)).getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            }
            if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z16 = this.hasData;
        boolean hasPendingData = hasPendingData(j3);
        this.hasData = hasPendingData;
        if (z16 && !hasPendingData && playState != 1) {
            this.listener.onUnderrun(this.bufferSize, TPAudioSinkUtils.usToMs(this.bufferSizeUs));
        }
        return true;
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs == -9223372036854775807L) {
            ((TPAudioTimestampPoller) TPAudioSinkUtils.checkNotNull(this.audioTimestampPoller)).reset();
            return true;
        }
        return false;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    public void setAudioTrack(AudioTrack audioTrack, boolean z16, int i3, int i16, int i17) {
        boolean z17;
        long j3;
        this.audioTrack = audioTrack;
        this.outputPcmFrameSize = i16;
        this.bufferSize = i17;
        this.audioTimestampPoller = new TPAudioTimestampPoller(audioTrack);
        this.outputSampleRate = audioTrack.getSampleRate();
        if (z16 && needsPassthroughWorkarounds(i3)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.needsPassthroughWorkarounds = z17;
        boolean isEncodingLinearPcm = TPAudioSinkUtils.isEncodingLinearPcm(i3);
        this.isOutputPcm = isEncodingLinearPcm;
        if (isEncodingLinearPcm) {
            j3 = TPAudioSinkUtils.sampleCountToDurationUs(i17 / i16, this.outputSampleRate);
        } else {
            j3 = -9223372036854775807L;
        }
        this.bufferSizeUs = j3;
        this.rawPlaybackHeadPosition = 0L;
        this.rawPlaybackHeadWrapCount = 0L;
        this.passthroughWorkaroundPauseOffset = 0L;
        this.hasData = false;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.lastLatencySampleTimeUs = 0L;
        this.latencyUs = 0L;
        this.audioTrackPlaybackSpeed = 1.0f;
    }

    public void start() {
        ((TPAudioTimestampPoller) TPAudioSinkUtils.checkNotNull(this.audioTimestampPoller)).reset();
    }
}
