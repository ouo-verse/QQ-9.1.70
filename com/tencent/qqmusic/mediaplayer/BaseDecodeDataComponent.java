package com.tencent.qqmusic.mediaplayer;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;

/* compiled from: P */
/* loaded from: classes23.dex */
abstract class BaseDecodeDataComponent {
    static final int CALL_PREPARED_DELAY_TIME = 20;
    private static final String TAG = "BaseDecodeDataComponent";
    static final int WRITE_ZERO_THRESHOLD = 5;
    private static volatile int sSessionId = -1;
    volatile float leftVolume;
    final IAudioListener mAudioEffectListener;
    AudioTrack mAudioTrack;
    int mBuffSize;
    final PlayerCallback mCallback;
    final CorePlayer mCorePlayer;
    private final Handler mEventHandler;

    @NonNull
    final HandleDecodeDataCallback mHandleDecodeDataCallback;
    final AudioInformation mInformation;
    private final int mPlayerID;
    final PlayerStateRunner mStateRunner;
    long mTargetPlaySample;
    final IAudioListener mTerminalAudioEffectListener;
    volatile float rightVolume;
    long mCurPosition = 0;
    boolean mHasDecodeSuccess = false;
    boolean mHasDecode = false;
    boolean mHasInit = false;
    boolean mCreateAudioTrackFail = false;
    volatile boolean needSetVolume = false;
    int mTargetBitDepth = 2;
    final BufferInfo mDecodeBufferInfo = new BufferInfo();
    final FloatBufferInfo mFloatBufferInfo = new FloatBufferInfo();
    int mAudioStreamType = getAudioStreamType();

    @NonNull
    final WaitNotify mSignalControl = new WaitNotify();

    @Nullable
    PerformanceTracer performanceTracer = null;
    volatile boolean mNeedChangePlayThreadPriority = false;
    boolean isUseFloatForHighDepth = false;
    int mLeastCommonMultiple = 1;

    @Nullable
    Float mSpeedToSet = null;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface HandleDecodeDataCallback {
        long getCurPositionByDecoder();

        long getMinPcmBufferSize();

        void onAudioTrackChanged(AudioTrack audioTrack);

        void onPullDecodeDataEndOrFailed(int i3, int i16);

        int pullDecodeData(int i3, byte[] bArr);

        int seekTo(int i3);
    }

    public BaseDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, @NonNull HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i3, @NonNull IAudioListener iAudioListener, @NonNull IAudioListener iAudioListener2) {
        this.mCorePlayer = corePlayer;
        this.mStateRunner = playerStateRunner;
        this.mInformation = audioInformation;
        this.mCallback = playerCallback;
        this.mHandleDecodeDataCallback = handleDecodeDataCallback;
        this.mEventHandler = handler;
        this.mPlayerID = i3;
        this.mAudioEffectListener = iAudioListener;
        this.mTerminalAudioEffectListener = iAudioListener2;
    }

    private void destroyAudioListeners() {
        this.mAudioEffectListener.onPlayerStopped();
        this.mTerminalAudioEffectListener.onPlayerStopped();
    }

    public static int getAudioTrackPosition(long j3, AudioTrack audioTrack) {
        long round;
        if (audioTrack != null) {
            try {
                round = Math.round(((j3 + audioTrack.getPlaybackHeadPosition()) / audioTrack.getSampleRate()) * 1000.0d);
            } catch (Exception e16) {
                Logger.e(TAG, "getAudioTrackPosition", e16);
            }
            return (int) round;
        }
        round = 0;
        return (int) round;
    }

    @NonNull
    public static AudioTrack instantiateAudioTrackCompat(int i3, int i16, int i17, int i18, int i19, int i26) {
        AudioTrack create;
        if (sSessionId == -1) {
            sSessionId = 0;
        }
        IAudioTrackCreator audioTrackCreator = AudioPlayerConfigure.getAudioTrackCreator();
        if (audioTrackCreator != null && (create = audioTrackCreator.create(i3, i16, i17, i18, i19, i26, sSessionId)) != null) {
            return create;
        }
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i3);
        AudioFormat.Builder builder2 = new AudioFormat.Builder();
        builder2.setSampleRate(i16);
        builder2.setEncoding(i18);
        builder2.setChannelMask(i17);
        return new AudioTrack.Builder().setAudioAttributes(builder.build()).setAudioFormat(builder2.build()).setBufferSizeInBytes(i19).setTransferMode(i26).setSessionId(sSessionId).build();
    }

    public String axiliary(String str) {
        return "ID: " + this.mPlayerID + ". " + str;
    }

    public long calculatePcmPlayTime(byte[] bArr, int i3, int i16, long j3) {
        if (i3 == 0 || i16 == 0 || j3 == 0) {
            return 0L;
        }
        return (((bArr.length * 1000.0f) / i3) / i16) / ((float) j3);
    }

    public void callExceptionCallback(int i3, int i16) {
        callExceptionCallback(i3, i16, 0);
    }

    public void changePlayThreadPriorityImmediately() {
        Logger.d(TAG, axiliary("changePlayThreadPriorityImmediately"));
        this.mNeedChangePlayThreadPriority = true;
    }

    public void convertBytePcmToFloatPcm(BufferInfo bufferInfo, FloatBufferInfo floatBufferInfo) {
        try {
            PcmConvertionUtil.convertByteBufferToFloatBuffer(bufferInfo, floatBufferInfo, this.mInformation.getBitDepth());
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
        }
    }

    public void doWaitForPaused() {
        this.mSignalControl.doWait(2000L, 5, new WaitNotify.WaitListener() { // from class: com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.1
            @Override // com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener
            public boolean keepWaiting() {
                return BaseDecodeDataComponent.this.isPaused();
            }
        });
    }

    public abstract int getAudioStreamType();

    public abstract long getCurPosition();

    public int getMaxSupportSampleRate() {
        Logger.i(TAG, axiliary("can't reflect max sample rate, use default sample rate"));
        return 192000;
    }

    public int getMinBufferSize(long j3, int i3, int i16, int i17, int i18) {
        int minBufferSize = AudioTrack.getMinBufferSize((int) j3, i3, i16);
        if (minBufferSize < 0) {
            Logger.i(TAG, axiliary("minBufferSize = " + minBufferSize + " mTargetPlaySample = " + j3 + "  channelConfiguration = " + i3 + "   pcmEncoding = " + i16));
            return i17 * 3536 * i18;
        }
        return minBufferSize;
    }

    public int getPlayerState() {
        return this.mStateRunner.get().intValue();
    }

    public int getSessionId() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getAudioSessionId();
        }
        return 0;
    }

    public float getSpeed() {
        Float f16 = this.mSpeedToSet;
        if (f16 != null) {
            return f16.floatValue();
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getPlaybackParams().getSpeed();
        }
        return 1.0f;
    }

    public abstract void handleDecodeData() throws Throwable;

    public void handleHighBitDepth(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        if (this.isUseFloatForHighDepth) {
            bufferInfo.fillInto(bufferInfo2);
            return;
        }
        try {
            PcmConvertionUtil.convertBitDepthTo16(bufferInfo, bufferInfo2, this.mInformation.getBitDepth());
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
        }
    }

    public void handleHighSample(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        try {
            PcmConvertionUtil.reSample(bufferInfo, bufferInfo2, this.mInformation.getSampleRate(), this.mTargetPlaySample, this.mTargetBitDepth);
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
        }
    }

    public synchronized boolean hasDecodeData() {
        return this.mHasDecode;
    }

    public synchronized boolean hasDecodeDataSuccess() {
        return this.mHasDecodeSuccess;
    }

    public void initAudioListeners(int i3, AudioInformation audioInformation, long j3) {
        this.mAudioEffectListener.onPlayerReady(i3, audioInformation, j3);
        this.mTerminalAudioEffectListener.onPlayerReady(i3, audioInformation, j3);
    }

    public synchronized boolean isCompleted() {
        return this.mStateRunner.isEqual(7);
    }

    public synchronized boolean isError() {
        return this.mStateRunner.isEqual(9);
    }

    public synchronized boolean isIdle() {
        return this.mStateRunner.isEqual(0);
    }

    public boolean isInit() {
        return this.mHasInit;
    }

    public synchronized boolean isPaused() {
        return this.mStateRunner.isEqual(5);
    }

    public synchronized boolean isPlaying() {
        return this.mStateRunner.isEqual(4);
    }

    public synchronized boolean isStopped() {
        return this.mStateRunner.isEqual(6);
    }

    public boolean isSupportHighBitDepth() {
        return true;
    }

    public void notifySeekCompleteForAudioListeners(long j3) {
        this.mAudioEffectListener.onPlayerSeekComplete(j3);
        this.mTerminalAudioEffectListener.onPlayerSeekComplete(j3);
    }

    public void pause(boolean z16) {
        Logger.i(TAG, axiliary("pause"));
        this.mStateRunner.transfer(5, 4, 2);
    }

    public void play() {
        Logger.i(TAG, axiliary("play"));
        this.mStateRunner.transfer(4, 5, 2, 6, 4);
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: play, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    public void postRunnable(Runnable runnable, int i3) {
        this.mEventHandler.postDelayed(runnable, i3);
    }

    public void refreshTimeAndNotify(int i3) {
        if (this.mSignalControl.isWaiting() && isPlaying()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: seek, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    public void release() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.stop();
            } catch (Throwable th5) {
                Logger.e(TAG, th5);
            }
            try {
                this.mAudioTrack.flush();
            } catch (Throwable th6) {
                Logger.e(TAG, th6);
            }
            try {
                this.mAudioTrack.release();
            } catch (Throwable th7) {
                Logger.e(TAG, th7);
            }
            try {
                destroyAudioListeners();
            } catch (Throwable th8) {
                Logger.i(TAG, "[run] failed to destroyAudioListeners!", th8);
            }
            setAudioTrack(null);
            Logger.d(TAG, axiliary("finally release audioTrack"));
        }
        if (!this.mCorePlayer.mIsExit) {
            if (this.mStateRunner.isEqual(7)) {
                this.mCallback.playerEnded(this.mCorePlayer);
            } else {
                this.mCallback.playerStopped(this.mCorePlayer);
            }
        }
    }

    public void releaseNotify() {
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: release, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    public void setAudioStreamType(int i3) {
        if (i3 == this.mAudioStreamType) {
            return;
        }
        this.mAudioStreamType = i3;
    }

    public void setAudioTrack(AudioTrack audioTrack) {
        this.mAudioTrack = audioTrack;
        this.mHandleDecodeDataCallback.onAudioTrackChanged(audioTrack);
    }

    public void setLeastCommonMultiple(int i3) {
        if (i3 < 1) {
            Logger.e(TAG, "wrong least common multiple: " + i3);
            return;
        }
        this.mLeastCommonMultiple = i3;
    }

    public void setPerformanceTracer(PerformanceTracer performanceTracer) {
        this.performanceTracer = performanceTracer;
    }

    public void setSpeed(float f16) {
        this.mSpeedToSet = Float.valueOf(f16);
    }

    public void setVolume(float f16, float f17) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.setStereoVolume(f16, f17);
            } catch (IllegalStateException e16) {
                Logger.e(TAG, "setVolume", e16);
            }
        }
    }

    public void setVolumeForHuawei(float f16, float f17) {
        this.leftVolume = f16;
        this.rightVolume = f17;
        this.needSetVolume = true;
    }

    public void stop() {
        Logger.i(TAG, axiliary("stop"));
        if (this.mStateRunner.transfer(6, 4, 5, 2) && this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: stop, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    private void callExceptionCallback(int i3, int i16, int i17) {
        this.mCallback.playerException(this.mCorePlayer, i3, i16, i17);
    }

    public long calculatePcmPlayTime(float[] fArr, int i3, long j3) {
        if (i3 == 0 || j3 == 0) {
            return 0L;
        }
        return ((fArr.length * 1000.0f) / i3) / ((float) j3);
    }

    public void flush() {
    }

    public void seek(int i3) {
    }
}
