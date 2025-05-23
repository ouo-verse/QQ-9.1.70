package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
class StaticDecodeDataComponent extends BaseDecodeDataComponent {
    private static final String TAG = "StaticDecodeDataComponent";
    private int mAllBufferSize;
    private List<BufferInfo> mAllPcmBufferList;
    private boolean mHasTerminal;
    private boolean mIsfirstStarted;

    public StaticDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i3, @NonNull IAudioListener iAudioListener, @NonNull IAudioListener iAudioListener2) {
        super(corePlayer, playerStateRunner, audioInformation, playerCallback, handleDecodeDataCallback, handler, i3, iAudioListener, iAudioListener2);
        this.mHasTerminal = false;
        this.mBuffSize = 8192;
    }

    private boolean createAudioTrack() {
        int i3;
        int i16;
        Logger.d(TAG, axiliary("createAudioTrack"));
        if (this.mInformation == null) {
            Logger.e(TAG, axiliary("\u4e0d\u7559\u75d5\u8ff9\u7684\u9000\u51fa \u65f6\u673a\uff1a\u83b7\u53d6Information\u65f6 step = 3"));
            this.mStateRunner.transfer(9);
            callExceptionCallback(91, 63);
            return false;
        }
        if (!this.mStateRunner.isEqual(3)) {
            Logger.e(TAG, axiliary("mState is not preparing"));
            callExceptionCallback(91, 54);
            return false;
        }
        if (this.mInformation.getSampleRate() <= 0) {
            Logger.e(TAG, axiliary("mInformation.getSampleRate() failed"));
            callExceptionCallback(91, 64);
            return false;
        }
        int channels = this.mInformation.getChannels();
        if (channels == 1) {
            i3 = 4;
        } else {
            int i17 = 12;
            if (channels != 2) {
                if (channels == 6) {
                    i17 = 252;
                } else if (channels == 8) {
                    i17 = 1020;
                }
            }
            i3 = i17;
        }
        this.mTargetPlaySample = this.mInformation.getSampleRate();
        int bitDepth = this.mInformation.getBitDepth();
        while (this.mTargetPlaySample > getMaxSupportSampleRate()) {
            this.mTargetPlaySample /= 2;
        }
        if (isSupportHighBitDepth() && bitDepth >= 3) {
            this.mTargetBitDepth = bitDepth;
            this.isUseFloatForHighDepth = true;
            if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                Logger.i(TAG, axiliary("will use float resampled pcm for Hi-Res, bitDept: " + bitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            } else {
                Logger.i(TAG, axiliary("will use float pcm for Hi-Res, bitDept: " + bitDepth + ", sample rate: " + this.mTargetPlaySample));
            }
        } else if (!isSupportHighBitDepth() && bitDepth >= 3) {
            this.mTargetBitDepth = 2;
            if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                Logger.i(TAG, axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + bitDepth + ", target bitDept: " + this.mTargetBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            } else {
                Logger.i(TAG, axiliary("will use byte pcm with bitDept converted, origin bitDept: " + bitDepth + ", target bitDept: " + this.mTargetBitDepth));
            }
        } else {
            this.mTargetBitDepth = bitDepth;
            Logger.i(TAG, axiliary("will use byte pcm resampled, bitDept: " + bitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
        }
        if (bitDepth == 1) {
            i16 = 3;
        } else if (bitDepth != 2 && this.isUseFloatForHighDepth) {
            i16 = 4;
        } else {
            i16 = 2;
        }
        Logger.d(TAG, axiliary(String.format("mTargetPlaySample: %d, playChannel: %d", Long.valueOf(this.mTargetPlaySample), Integer.valueOf(channels))));
        try {
            setAudioTrack(BaseDecodeDataComponent.instantiateAudioTrackCompat(this.mAudioStreamType, (int) this.mTargetPlaySample, i3, i16, this.mAllBufferSize, 0));
            if (this.mSpeedToSet != null) {
                Logger.i(TAG, axiliary("setSpeed:" + this.mSpeedToSet));
                PlaybackParams playbackParams = this.mAudioTrack.getPlaybackParams();
                playbackParams.setSpeed(this.mSpeedToSet.floatValue());
                this.mSpeedToSet = null;
                this.mAudioTrack.setPlaybackParams(playbackParams);
            }
            if (this.mAudioTrack.getState() == 2) {
                Logger.d(TAG, axiliary("new AudioTrack succeed"));
            }
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null && audioTrack.getState() == 2) {
            Logger.d(TAG, axiliary("create audioTrack success"));
            return true;
        }
        this.mCreateAudioTrackFail = true;
        Logger.e(TAG, axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
        setAudioTrack(null);
        this.mStateRunner.transfer(9);
        callExceptionCallback(91, 66);
        return false;
    }

    private boolean decodeAllData() {
        this.mAllPcmBufferList = new ArrayList();
        while (true) {
            if (this.mCorePlayer.mIsExit) {
                break;
            }
            BufferInfo bufferInfo = new BufferInfo();
            bufferInfo.setByteBufferCapacity(this.mBuffSize);
            try {
                int pullDecodeData = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, bufferInfo.byteBuffer);
                this.mHasDecode = true;
                if (pullDecodeData > 0) {
                    bufferInfo.bufferSize = pullDecodeData;
                    this.mAllPcmBufferList.add(bufferInfo);
                    if (!this.mHasDecodeSuccess) {
                        this.mHasDecodeSuccess = true;
                    }
                } else if (pullDecodeData == 0) {
                    bufferInfo.bufferSize = this.mBuffSize;
                    this.mAllPcmBufferList.add(bufferInfo);
                    Logger.i(TAG, "static decode end");
                } else {
                    this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(pullDecodeData, 91);
                    return false;
                }
            } catch (SoNotFindException e16) {
                Logger.e(TAG, e16);
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, 62);
                return false;
            } catch (Throwable th5) {
                Logger.e(TAG, th5);
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, 67);
                return false;
            }
        }
        if (!this.mAllPcmBufferList.isEmpty()) {
            Iterator<BufferInfo> it = this.mAllPcmBufferList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 += it.next().bufferSize;
            }
            Logger.i(TAG, "static totalBufferSize = " + i3);
            this.mDecodeBufferInfo.setByteBufferCapacity(i3);
            int i16 = 0;
            for (BufferInfo bufferInfo2 : this.mAllPcmBufferList) {
                System.arraycopy(bufferInfo2.byteBuffer, 0, this.mDecodeBufferInfo.byteBuffer, i16, bufferInfo2.bufferSize);
                int i17 = bufferInfo2.bufferSize;
                i16 += i17;
                this.mDecodeBufferInfo.bufferSize += i17;
                this.mAllBufferSize += bufferInfo2.bufferSize;
            }
        }
        return true;
    }

    private void playAudioTrack() {
        this.mAudioTrack.reloadStaticData();
        while (!this.mCorePlayer.mIsExit) {
            if (isPaused()) {
                if (this.mAudioTrack.getPlayState() != 2) {
                    this.mAudioTrack.pause();
                }
                postRunnable(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.3
                    @Override // java.lang.Runnable
                    public void run() {
                        StaticDecodeDataComponent staticDecodeDataComponent = StaticDecodeDataComponent.this;
                        staticDecodeDataComponent.mCallback.playerPaused(staticDecodeDataComponent.mCorePlayer);
                    }
                }, 20);
                doWaitForPaused();
            } else if (!isIdle()) {
                if (isError()) {
                    Logger.e(TAG, "static play error");
                    return;
                }
                if (isStopped()) {
                    if (this.mAudioTrack.getPlayState() != 1) {
                        this.mAudioTrack.stop();
                    }
                    postRunnable(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.4
                        @Override // java.lang.Runnable
                        public void run() {
                            StaticDecodeDataComponent staticDecodeDataComponent = StaticDecodeDataComponent.this;
                            staticDecodeDataComponent.mCallback.playerStopped(staticDecodeDataComponent.mCorePlayer);
                        }
                    }, 20);
                    return;
                } else {
                    if (isCompleted()) {
                        this.mCorePlayer.mIsExit = true;
                        return;
                    }
                    if (isPlaying()) {
                        if (this.mAudioTrack.getPlayState() == 2) {
                            this.mAudioTrack.play();
                        } else if (this.mAudioTrack.getPlayState() == 1) {
                            if (!this.mIsfirstStarted) {
                                this.mIsfirstStarted = true;
                                this.mAudioTrack.play();
                                this.mCallback.playerStarted(this.mCorePlayer);
                            }
                        } else if (AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack) * this.mInformation.getChannels() * this.mTargetBitDepth >= this.mAllBufferSize) {
                            this.mStateRunner.transfer(7);
                            Logger.i(TAG, "static play completed");
                            postRunnable(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    StaticDecodeDataComponent staticDecodeDataComponent = StaticDecodeDataComponent.this;
                                    staticDecodeDataComponent.mCallback.playerEnded(staticDecodeDataComponent.mCorePlayer);
                                }
                            }, 20);
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private boolean writeAudioTrack() {
        BufferInfo bufferInfo = new BufferInfo();
        if (this.mDecodeBufferInfo.byteBuffer != null && this.mAudioTrack != null) {
            if (this.mTargetBitDepth != this.mInformation.getBitDepth()) {
                handleHighBitDepth(this.mDecodeBufferInfo, bufferInfo);
                this.mDecodeBufferInfo.fillInto(bufferInfo);
            }
            if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                handleHighSample(this.mDecodeBufferInfo, bufferInfo);
                this.mDecodeBufferInfo.fillInto(bufferInfo);
            }
            if (this.isUseFloatForHighDepth) {
                convertBytePcmToFloatPcm(this.mDecodeBufferInfo, this.mFloatBufferInfo);
                IAudioListener iAudioListener = this.mAudioEffectListener;
                FloatBufferInfo floatBufferInfo = this.mFloatBufferInfo;
                iAudioListener.onPcm(floatBufferInfo, floatBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
            } else {
                this.mAudioEffectListener.onPcm(this.mDecodeBufferInfo, bufferInfo, this.mCorePlayer.getCurPositionByDecoder());
                this.mDecodeBufferInfo.fillInto(bufferInfo);
            }
            this.mHasTerminal = false;
            if (this.mTerminalAudioEffectListener.isEnabled()) {
                if (this.isUseFloatForHighDepth) {
                    IAudioListener iAudioListener2 = this.mTerminalAudioEffectListener;
                    FloatBufferInfo floatBufferInfo2 = this.mFloatBufferInfo;
                    iAudioListener2.onPcm(floatBufferInfo2, floatBufferInfo2, this.mCorePlayer.getCurPositionByDecoder());
                } else {
                    IAudioListener iAudioListener3 = this.mTerminalAudioEffectListener;
                    BufferInfo bufferInfo2 = this.mDecodeBufferInfo;
                    iAudioListener3.onPcm(bufferInfo2, bufferInfo2, this.mCorePlayer.getCurPositionByDecoder());
                }
                this.mHasTerminal = true;
            }
            if (!this.mHasTerminal) {
                if (this.isUseFloatForHighDepth) {
                    AudioTrack audioTrack = this.mAudioTrack;
                    FloatBufferInfo floatBufferInfo3 = this.mFloatBufferInfo;
                    int write = audioTrack.write(floatBufferInfo3.floatBuffer, 0, floatBufferInfo3.bufferSize, 0);
                    if (write < 0) {
                        Logger.e(TAG, axiliary("mAudioTrack write float failed: " + write + ", expect: " + this.mFloatBufferInfo.bufferSize));
                        this.mStateRunner.transfer(9);
                        callExceptionCallback(91, 102);
                        return false;
                    }
                    if (write != this.mFloatBufferInfo.bufferSize) {
                        Logger.w(TAG, axiliary("mAudioTrack write float not equal: " + write + ", expect: " + this.mFloatBufferInfo.bufferSize));
                    }
                    int i3 = this.mFloatBufferInfo.bufferSize;
                } else {
                    AudioTrack audioTrack2 = this.mAudioTrack;
                    BufferInfo bufferInfo3 = this.mDecodeBufferInfo;
                    int write2 = audioTrack2.write(bufferInfo3.byteBuffer, 0, bufferInfo3.bufferSize);
                    if (write2 < 0) {
                        Logger.e(TAG, axiliary("mAudioTrack write bytes failed: " + write2 + ", expect: " + this.mDecodeBufferInfo.bufferSize));
                        this.mStateRunner.transfer(9);
                        callExceptionCallback(91, 102);
                        return false;
                    }
                    if (write2 != this.mDecodeBufferInfo.bufferSize) {
                        Logger.w(TAG, axiliary("mAudioTrack write bytes not equal: " + write2 + ", expect: " + this.mDecodeBufferInfo.bufferSize));
                    }
                    int i16 = this.mDecodeBufferInfo.bufferSize;
                }
                return true;
            }
            Logger.i(TAG, "mTerminalAudioEffectList has blocked");
        }
        return false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public int getAudioStreamType() {
        return 3;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public long getCurPosition() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null && audioTrack.getState() != 0) {
            long audioTrackPosition = BaseDecodeDataComponent.getAudioTrackPosition(0L, audioTrack);
            this.mCurPosition = audioTrackPosition;
            return audioTrackPosition;
        }
        return this.mCurPosition;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void handleDecodeData() {
        AudioInformation audioInformation = this.mInformation;
        if (audioInformation != null) {
            try {
            } catch (SoNotFindException e16) {
                Logger.e(TAG, e16);
            }
            if (0 >= audioInformation.getSampleRate()) {
                Logger.e(TAG, "failed to getSampleRate");
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, 63);
                return;
            }
            if (this.mInformation.getChannels() <= 0) {
                Logger.e(TAG, "failed to getChannels");
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, 63);
                return;
            }
            this.mHasInit = true;
            if (!decodeAllData()) {
                Logger.e(TAG, "failed to decodeAllData");
                this.mStateRunner.transfer(9);
                return;
            }
            if (!createAudioTrack()) {
                Logger.e(TAG, "failed to createAudioTrack");
                this.mStateRunner.transfer(9);
                return;
            }
            initAudioListeners(this.mTargetBitDepth, this.mInformation, getCurPosition());
            if (!writeAudioTrack() && !this.mHasTerminal) {
                Logger.e(TAG, "failed to writeAudioTrack");
                this.mStateRunner.transfer(9);
                return;
            }
            if (this.mHasTerminal) {
                this.mStateRunner.transfer(7);
                return;
            }
            if (!this.mStateRunner.transfer(2, 3)) {
                Logger.e(TAG, "failed to transfer to PREPARED because cur State is NOT PREPARING!!");
                return;
            }
            this.mIsfirstStarted = false;
            postRunnable(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.1
                @Override // java.lang.Runnable
                public void run() {
                    if (StaticDecodeDataComponent.this.getPlayerState() == 8) {
                        Logger.w(StaticDecodeDataComponent.TAG, "[run] state changed to END during postRunnable!");
                    } else {
                        StaticDecodeDataComponent staticDecodeDataComponent = StaticDecodeDataComponent.this;
                        staticDecodeDataComponent.mCallback.playerPrepared(staticDecodeDataComponent.mCorePlayer);
                    }
                }
            }, 0);
            Logger.i(TAG, axiliary("prepared. waiting..."));
            this.mSignalControl.doWait(20L, 100, new WaitNotify.WaitListener() { // from class: com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.2
                @Override // com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener
                public boolean keepWaiting() {
                    if (StaticDecodeDataComponent.this.getPlayerState() == 2) {
                        return true;
                    }
                    return false;
                }
            });
            Logger.i(TAG, axiliary("woke after preparing"));
            playAudioTrack();
            return;
        }
        Logger.e(TAG, axiliary("\u4e0d\u7559\u75d5\u8ff9\u7684\u9000\u51fa \u65f6\u673a\uff1a\u83b7\u53d6Information\u65f6 step = 3"));
        this.mStateRunner.transfer(9);
        callExceptionCallback(91, 63);
    }
}
