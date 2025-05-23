package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes23.dex */
class StreamDecodeDataComponent extends BaseDecodeDataComponent {
    private static final int MAX_AUDIO_TRACK_BUFFER_TIME = 1;
    private static final int MIN_AUDIO_TRACK_BUFFER_TIMES = 1;
    private static final String TAG = "StreamDecodeDataComponent";
    private static final int USE_AUDIO_TRACK_TIME_THRESHOLD = 5000;
    private long mCurrentFrameCount;
    private boolean mNeedFlush;
    private final Stack<Integer> mSeekRecord;
    private int mTrackBufferSizeInByte;

    public StreamDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i3, @NonNull IAudioListener iAudioListener, @NonNull IAudioListener iAudioListener2) {
        super(corePlayer, playerStateRunner, audioInformation, playerCallback, handleDecodeDataCallback, handler, i3, iAudioListener, iAudioListener2);
        this.mSeekRecord = new Stack<>();
        this.mCurrentFrameCount = 0L;
        this.mNeedFlush = false;
    }

    private void addSeekRecord(int i3) {
        synchronized (this.mSeekRecord) {
            Logger.i(TAG, "add seek: " + i3);
            this.mSeekRecord.push(Integer.valueOf(i3));
        }
    }

    private boolean createAudioTrack() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        StringBuilder sb5;
        int state;
        Logger.d(TAG, axiliary("createAudioTrack"));
        if (!this.mStateRunner.isEqual(3)) {
            Logger.e(TAG, "mState is not preparing");
            callExceptionCallback(91, 54);
            return false;
        }
        if (this.mInformation.getSampleRate() <= 0) {
            Logger.e(TAG, "mInformation.getSampleRate() failed");
            callExceptionCallback(91, 64);
            return false;
        }
        int channels = this.mInformation.getChannels();
        if (channels == 1) {
            i3 = 4;
        } else {
            int i26 = 12;
            if (channels != 2) {
                if (channels == 6) {
                    i26 = 252;
                } else if (channels == 8) {
                    i26 = 1020;
                }
            }
            i3 = i26;
        }
        Logger.d(TAG, axiliary(this.mInformation.toString()));
        this.mTargetPlaySample = this.mInformation.getSampleRate();
        while (this.mTargetPlaySample > getMaxSupportSampleRate()) {
            this.mTargetPlaySample /= 2;
        }
        int bitDepth = this.mInformation.getBitDepth();
        if (bitDepth == 0) {
            i16 = 2;
        } else {
            i16 = bitDepth;
        }
        if (isSupportHighBitDepth() && this.mInformation.getBitDepth() >= 3) {
            this.mTargetBitDepth = i16;
            this.isUseFloatForHighDepth = true;
            if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                Logger.i(TAG, axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mInformation.getBitDepth() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            } else {
                Logger.i(TAG, axiliary("will use float pcm for Hi-Res, bitDept: " + this.mInformation.getBitDepth() + ", sample rate: " + this.mTargetPlaySample));
            }
        } else if (!isSupportHighBitDepth() && this.mInformation.getBitDepth() >= 3) {
            this.mTargetBitDepth = 2;
            if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                Logger.i(TAG, axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + this.mInformation.getBitDepth() + ", target bitDept: " + this.mTargetBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            } else {
                Logger.i(TAG, axiliary("will use byte pcm with bitDept converted, origin bitDept: " + this.mInformation.getBitDepth() + ", target bitDept: " + this.mTargetBitDepth));
            }
        } else {
            this.mTargetBitDepth = i16;
            Logger.i(TAG, axiliary("will use byte pcm resampled, bitDept: " + this.mInformation.getBitDepth() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
        }
        if (i16 == 1) {
            i17 = 3;
        } else if (i16 != 2 && this.isUseFloatForHighDepth) {
            i17 = 4;
        } else {
            i17 = 2;
        }
        int minPcmBufferSize = (int) this.mHandleDecodeDataCallback.getMinPcmBufferSize();
        int i27 = i16;
        int minBufferSize = getMinBufferSize(this.mTargetPlaySample, i3, i17, channels, i16);
        Logger.i(TAG, axiliary("[createAudioTrack] playback_bufsize:" + minBufferSize + " decoderBufsizeInByte:" + minPcmBufferSize));
        int i28 = this.mLeastCommonMultiple;
        if (i28 > 1) {
            minBufferSize = getLcm(i28, minBufferSize);
        }
        if (minBufferSize > minPcmBufferSize) {
            i18 = minBufferSize;
        } else {
            i18 = minPcmBufferSize;
        }
        this.mBuffSize = i18;
        Logger.i(TAG, axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mTargetPlaySample: %d, playChannel: %d, pcmEncoding: %d", Integer.valueOf(minBufferSize), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mTargetPlaySample), Integer.valueOf(channels), Integer.valueOf(i17))));
        int max = Math.max((int) (Math.floor((((this.mTargetPlaySample * 1) * channels) * 2) / minBufferSize) + 1.0d), 1);
        Logger.d(TAG, axiliary("times: " + max + ", MIN_AUDIO_TRACK_BUFFER_TIMES: 1"));
        int i29 = max;
        while (i29 >= 1) {
            int i36 = minBufferSize * i29;
            try {
                this.mTrackBufferSizeInByte = i36;
                setAudioTrack(BaseDecodeDataComponent.instantiateAudioTrackCompat(this.mAudioStreamType, (int) this.mTargetPlaySample, i3, i17, i36, 1));
                sb5 = new StringBuilder();
                sb5.append("[createAudioTrack] new AudioTrack, sampleRate: ");
                sb5.append(this.mTargetPlaySample);
                sb5.append(", channels: ");
                sb5.append(i3);
                sb5.append(", bitDepth: ");
                i19 = i27;
            } catch (Throwable th5) {
                th = th5;
                i19 = i27;
            }
            try {
                sb5.append(i19);
                sb5.append(", buffer: ");
                sb5.append(this.mTrackBufferSizeInByte);
                Logger.i(TAG, axiliary(sb5.toString()));
                state = this.mAudioTrack.getState();
            } catch (Throwable th6) {
                th = th6;
                Logger.e(TAG, th);
                i29 -= 2;
                i27 = i19;
            }
            if (state == 1) {
                Logger.i(TAG, axiliary("new AudioTrack succeed"));
                break;
            }
            Logger.e(TAG, axiliary("audioTrack create fail!!! state = " + state));
            this.mAudioTrack.release();
            i29 -= 2;
            i27 = i19;
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null && audioTrack.getState() == 1) {
            Logger.d(TAG, axiliary("create audioTrack success times = " + i29));
            this.mStateRunner.setAudioTrack(this.mAudioTrack);
            return true;
        }
        this.mCreateAudioTrackFail = true;
        Logger.e(TAG, axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
        setAudioTrack(null);
        callExceptionCallback(92, 66);
        return false;
    }

    private long getCalcBitMinSize(AudioInformation audioInformation) {
        if (audioInformation != null) {
            return (((float) ((audioInformation.getSampleRate() * audioInformation.getChannels()) * audioInformation.getBitDepth())) * 5.0f) / 1000.0f;
        }
        return 0L;
    }

    private int getGcd(int i3, int i16) {
        while (true) {
            int i17 = i16;
            int i18 = i3;
            i3 = i17;
            if (i3 > 0) {
                i16 = i18 % i3;
            } else {
                return i18;
            }
        }
    }

    private int getLcm(int i3, int i16) {
        return (i3 * i16) / getGcd(i3, i16);
    }

    @NonNull
    private BufferInfo initTempBufferInfoIfNeeded(BufferInfo bufferInfo, int i3) {
        if (bufferInfo == null) {
            BufferInfo bufferInfo2 = new BufferInfo();
            bufferInfo2.setByteBufferCapacity(i3);
            return bufferInfo2;
        }
        return bufferInfo;
    }

    @NonNull
    private FloatBufferInfo initTempFloatBufferInfoIfNeeded(FloatBufferInfo floatBufferInfo, int i3) {
        if (floatBufferInfo == null) {
            FloatBufferInfo floatBufferInfo2 = new FloatBufferInfo();
            floatBufferInfo2.setFloatBufferCapacity(i3);
            return floatBufferInfo2;
        }
        return floatBufferInfo;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void flush() {
        this.mNeedFlush = true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public int getAudioStreamType() {
        return 3;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public long getCurPosition() {
        long j3;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null && audioTrack.getState() != 0) {
            AudioInformation audioInformation = this.mInformation;
            if (audioInformation == null) {
                return this.mCurPosition;
            }
            long actualTime = this.mAudioEffectListener.getActualTime(BaseDecodeDataComponent.getAudioTrackPosition(this.mCurrentFrameCount, audioTrack));
            long channels = audioInformation.getChannels() * this.mTargetBitDepth * audioInformation.getPlaySample();
            if (channels > 0) {
                j3 = (this.mTrackBufferSizeInByte / channels) * 1000;
            } else {
                j3 = 0;
            }
            long curPositionByDecoder = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0L, j3);
            if (curPositionByDecoder < 0) {
                this.mCurPosition = actualTime;
            } else if (actualTime > 0 && Math.abs(actualTime - curPositionByDecoder) < 5000) {
                this.mCurPosition = actualTime;
            } else {
                this.mCurPosition = curPositionByDecoder;
            }
            return this.mCurPosition;
        }
        return this.mCurPosition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x07b2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x077c  */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33, types: [int] */
    /* JADX WARN: Type inference failed for: r3v84 */
    /* JADX WARN: Type inference failed for: r3v85 */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDecodeData() throws Throwable {
        int i3;
        boolean z16;
        int i16;
        int i17;
        boolean z17;
        long j3;
        int i18;
        int i19;
        int i26;
        boolean z18;
        char c16;
        boolean z19;
        int i27;
        boolean z26;
        char c17;
        int i28;
        int i29;
        boolean z27;
        long calculatePcmPlayTime;
        boolean z28;
        int i36;
        boolean z29;
        int i37;
        long j16;
        int i38;
        ?? r36;
        int i39;
        int underrunCount;
        int i46;
        BufferInfo bufferInfo;
        FloatBufferInfo floatBufferInfo;
        int i47;
        int i48;
        boolean z36;
        if (this.mInformation != null && !this.mCorePlayer.mIsExit) {
            try {
            } catch (SoNotFindException e16) {
                Logger.e(TAG, e16);
            }
            if (0 >= this.mInformation.getSampleRate()) {
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
            if (!createAudioTrack()) {
                Logger.e(TAG, "failed to createAudioTrack");
                this.mStateRunner.transfer(9);
                return;
            }
            initAudioListeners(this.mTargetBitDepth, this.mInformation, getCurPosition());
            this.mStateRunner.transfer(2);
            boolean z37 = false;
            postRunnable(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent.1
                @Override // java.lang.Runnable
                public void run() {
                    if (StreamDecodeDataComponent.this.getPlayerState() == 8) {
                        Logger.w(StreamDecodeDataComponent.TAG, "[run] state changed to END during postRunnable!");
                    } else {
                        StreamDecodeDataComponent streamDecodeDataComponent = StreamDecodeDataComponent.this;
                        streamDecodeDataComponent.mCallback.playerPrepared(streamDecodeDataComponent.mCorePlayer);
                    }
                }
            }, 0);
            if (!isPlaying() && !this.mCorePlayer.mIsExit) {
                Logger.i(TAG, axiliary("prepared. waiting..."));
                this.mSignalControl.doWait(20L, 100, new WaitNotify.WaitListener() { // from class: com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent.2
                    @Override // com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener
                    public boolean keepWaiting() {
                        if (!StreamDecodeDataComponent.this.isPlaying() && !StreamDecodeDataComponent.this.mCorePlayer.mIsExit) {
                            return true;
                        }
                        return false;
                    }
                });
                Logger.i(TAG, axiliary("woke after preparing"));
            }
            PlayerConfigManager.getInstance().setCommonPlayerRef(this.mCorePlayer);
            this.mDecodeBufferInfo.setByteBufferCapacity(this.mBuffSize);
            Float f16 = null;
            BufferInfo bufferInfo2 = null;
            FloatBufferInfo floatBufferInfo2 = null;
            long j17 = 0;
            boolean z38 = true;
            boolean z39 = true;
            int i49 = 0;
            int i56 = 0;
            int i57 = 0;
            boolean z46 = false;
            int i58 = 0;
            int i59 = 0;
            boolean z47 = false;
            int i65 = 0;
            while (!this.mCorePlayer.mIsExit) {
                if (this.mSpeedToSet != null && this.mAudioTrack != null) {
                    Logger.i(TAG, axiliary("setSpeed:" + this.mSpeedToSet));
                    PlaybackParams playbackParams = this.mAudioTrack.getPlaybackParams();
                    playbackParams.setSpeed(this.mSpeedToSet.floatValue());
                    this.mSpeedToSet = f16;
                    this.mAudioTrack.setPlaybackParams(playbackParams);
                }
                synchronized (this.mSeekRecord) {
                    if (!this.mSeekRecord.empty()) {
                        i3 = this.mSeekRecord.pop().intValue();
                        this.mSeekRecord.clear();
                        Logger.i(TAG, "execute seek: " + i3 + ", abandon the others");
                    } else {
                        i3 = -1;
                    }
                }
                if (i3 < 0 && this.mNeedFlush) {
                    i3 = BaseDecodeDataComponent.getAudioTrackPosition(this.mCurrentFrameCount, this.mAudioTrack);
                    Logger.i(TAG, axiliary("[run] flashback to " + i3));
                    this.mNeedFlush = z37;
                }
                if (i3 >= 0) {
                    int seekTo = this.mHandleDecodeDataCallback.seekTo(i3);
                    if (seekTo < 0) {
                        Logger.e(TAG, axiliary("seekTo failed: " + seekTo));
                        this.mStateRunner.transfer(9);
                        callExceptionCallback(95, 74);
                        return;
                    }
                    if (this.mAudioTrack != null) {
                        z16 = z46;
                        this.mCurrentFrameCount = Math.round((i3 / 1000.0d) * r9.getSampleRate());
                        if (this.mAudioTrack.getPlayState() == 3) {
                            this.mAudioTrack.pause();
                            this.mAudioTrack.flush();
                            this.mAudioTrack.play();
                        } else {
                            this.mAudioTrack.flush();
                        }
                        i49 = 0;
                    } else {
                        z16 = z46;
                    }
                    long j18 = i3;
                    this.mCurPosition = j18;
                    notifySeekCompleteForAudioListeners(j18);
                    this.mCallback.playerSeekCompletion(this.mCorePlayer, i3);
                } else {
                    z16 = z46;
                }
                int i66 = i49;
                if (isPaused()) {
                    if (this.mAudioTrack.getPlayState() != 2) {
                        this.mAudioTrack.pause();
                    }
                    postRunnable(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent.3
                        @Override // java.lang.Runnable
                        public void run() {
                            StreamDecodeDataComponent streamDecodeDataComponent = StreamDecodeDataComponent.this;
                            streamDecodeDataComponent.mCallback.playerPaused(streamDecodeDataComponent.mCorePlayer);
                        }
                    }, 20);
                    Logger.i(TAG, axiliary("paused. waiting..."));
                    doWaitForPaused();
                    Logger.i(TAG, axiliary("woke after pausing"));
                    i49 = i66;
                    z46 = z16;
                    f16 = null;
                    z37 = false;
                } else if (!isIdle() && !isError() && !isStopped()) {
                    if (isCompleted()) {
                        int channels = (i66 / this.mInformation.getChannels()) - i56;
                        if (channels > 0) {
                            i16 = channels;
                        } else {
                            i16 = 0;
                        }
                        int channels2 = (this.mTrackBufferSizeInByte / this.mTargetBitDepth) / this.mInformation.getChannels();
                        if (i16 >= channels2) {
                            i16 = channels2;
                        }
                        int sampleRate = (int) ((i16 * 1000) / this.mInformation.getSampleRate());
                        Logger.i(TAG, axiliary("writeShortCount: " + i66 + ", playFramePosition: " + i56 + ", leftTimeInMs: " + sampleRate + ", minAudioTrackWaitTimeMs: " + AudioPlayerConfigure.minAudioTrackWaitTimeMs));
                        if (sampleRate > 0) {
                            synchronized (this) {
                                wait(Math.max(r1, sampleRate));
                            }
                            return;
                        }
                        return;
                    }
                    if (isPlaying() && this.mAudioTrack.getPlayState() != 3) {
                        this.mAudioTrack.play();
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (z38) {
                        if (z16) {
                            try {
                                Logger.i(TAG, axiliary("writeFail = true,  mBuffSize = " + this.mBuffSize));
                                Logger.i(TAG, axiliary("there is no need to read more pcm data, just use writeFailByteArray"));
                                i47 = 0;
                            } catch (SoNotFindException e17) {
                                Logger.e(TAG, e17);
                                this.mStateRunner.transfer(9);
                                callExceptionCallback(92, 62);
                                return;
                            }
                        } else {
                            i47 = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.byteBuffer);
                            this.mDecodeBufferInfo.bufferSize = i47;
                            j17 += i47;
                        }
                        this.mHasDecode = true;
                        if (i57 == 0) {
                            long calcBitMinSize = getCalcBitMinSize(this.mInformation);
                            Logger.i(TAG, axiliary("minSize: " + calcBitMinSize + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
                            if (calcBitMinSize > 0) {
                                int i67 = 10;
                                while (true) {
                                    BufferInfo bufferInfo3 = this.mDecodeBufferInfo;
                                    i48 = i47;
                                    i17 = i56;
                                    if (bufferInfo3.bufferSize >= calcBitMinSize || i67 < 0) {
                                        break;
                                    }
                                    bufferInfo3.setTempByteBufferCapacity(this.mBuffSize);
                                    i47 = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.tempByteBuffer);
                                    if (i47 > 0) {
                                        BufferInfo bufferInfo4 = this.mDecodeBufferInfo;
                                        bufferInfo4.appendByte(bufferInfo4.tempByteBuffer, 0, i47);
                                        this.mDecodeBufferInfo.bufferSize += i47;
                                        z36 = z38;
                                        j17 += i47;
                                    } else {
                                        z36 = z38;
                                    }
                                    i67--;
                                    Logger.d(TAG, axiliary("decode tmpSize: " + i47 + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
                                    z38 = z36;
                                    i56 = i17;
                                }
                                z17 = z38;
                                i47 = i48;
                            } else {
                                i17 = i56;
                                z17 = z38;
                            }
                            if (this.mInformation.getBitDepth() == 0) {
                                int calcBitDept = AudioRecognition.calcBitDept(j17, this.mHandleDecodeDataCallback.getCurPositionByDecoder(), this.mInformation.getChannels(), this.mInformation.getSampleRate());
                                this.mTargetBitDepth = calcBitDept;
                                this.mInformation.setBitDept(calcBitDept);
                                Logger.w(TAG, axiliary("create audiotrack with wrong bitDepth, there may cause some problem!! " + this.mTargetBitDepth));
                            }
                            i18 = this.mTargetBitDepth;
                            Logger.d(TAG, axiliary("mPlayBitDept: " + i18));
                            j3 = j17;
                            i19 = i47;
                        } else {
                            i17 = i56;
                            z17 = z38;
                            j3 = j17;
                            i19 = i47;
                            i18 = i57;
                        }
                    } else {
                        i17 = i56;
                        z17 = z38;
                        j3 = j17;
                        i18 = i57;
                        i19 = i59;
                    }
                    if (this.mNeedChangePlayThreadPriority) {
                        this.mNeedChangePlayThreadPriority = false;
                        PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
                    }
                    if (this.mDecodeBufferInfo.bufferSize > 0) {
                        if (!this.mHasDecodeSuccess) {
                            this.mCallback.playerStarted(this.mCorePlayer);
                            this.mHasDecodeSuccess = true;
                        }
                        if (!z16) {
                            if (this.mTargetBitDepth != this.mInformation.getBitDepth() && !this.isUseFloatForHighDepth) {
                                bufferInfo = initTempBufferInfoIfNeeded(bufferInfo2, this.mBuffSize);
                                handleHighBitDepth(this.mDecodeBufferInfo, bufferInfo);
                                bufferInfo.fillInto(this.mDecodeBufferInfo);
                            } else {
                                bufferInfo = bufferInfo2;
                            }
                            if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                                bufferInfo = initTempBufferInfoIfNeeded(bufferInfo, this.mBuffSize);
                                handleHighSample(this.mDecodeBufferInfo, bufferInfo);
                                bufferInfo.fillInto(this.mDecodeBufferInfo);
                            }
                            if (this.isUseFloatForHighDepth) {
                                convertBytePcmToFloatPcm(this.mDecodeBufferInfo, this.mFloatBufferInfo);
                                if (this.mAudioEffectListener.isEnabled()) {
                                    FloatBufferInfo initTempFloatBufferInfoIfNeeded = initTempFloatBufferInfoIfNeeded(floatBufferInfo2, this.mFloatBufferInfo.bufferSize);
                                    i27 = i19;
                                    this.mAudioEffectListener.onPcm(this.mFloatBufferInfo, initTempFloatBufferInfoIfNeeded, this.mCorePlayer.getCurPositionByDecoder());
                                    this.mFloatBufferInfo.fillFloat(initTempFloatBufferInfoIfNeeded.floatBuffer, initTempFloatBufferInfoIfNeeded.bufferSize);
                                    bufferInfo2 = bufferInfo;
                                    floatBufferInfo2 = initTempFloatBufferInfoIfNeeded;
                                } else {
                                    i27 = i19;
                                    floatBufferInfo = floatBufferInfo2;
                                }
                            } else {
                                i27 = i19;
                                floatBufferInfo = floatBufferInfo2;
                                if (this.mAudioEffectListener.isEnabled()) {
                                    bufferInfo = initTempBufferInfoIfNeeded(bufferInfo, this.mBuffSize);
                                    this.mAudioEffectListener.onPcm(this.mDecodeBufferInfo, bufferInfo, this.mCorePlayer.getCurPositionByDecoder());
                                    bufferInfo.fillInto(this.mDecodeBufferInfo);
                                }
                            }
                            bufferInfo2 = bufferInfo;
                            floatBufferInfo2 = floatBufferInfo;
                        } else {
                            i27 = i19;
                        }
                        if (this.mAudioTrack != null && isPlaying()) {
                            if (!z16 && this.mTerminalAudioEffectListener.isEnabled()) {
                                if (this.isUseFloatForHighDepth) {
                                    IAudioListener iAudioListener = this.mTerminalAudioEffectListener;
                                    FloatBufferInfo floatBufferInfo3 = this.mFloatBufferInfo;
                                    iAudioListener.onPcm(floatBufferInfo3, floatBufferInfo3, this.mCorePlayer.getCurPositionByDecoder());
                                } else {
                                    IAudioListener iAudioListener2 = this.mTerminalAudioEffectListener;
                                    BufferInfo bufferInfo5 = this.mDecodeBufferInfo;
                                    iAudioListener2.onPcm(bufferInfo5, bufferInfo5, this.mCorePlayer.getCurPositionByDecoder());
                                }
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (!z26) {
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (this.needSetVolume) {
                                    this.mAudioTrack.setStereoVolume(this.leftVolume, this.rightVolume);
                                    this.needSetVolume = false;
                                }
                                if (this.isUseFloatForHighDepth) {
                                    calculatePcmPlayTime = calculatePcmPlayTime(this.mFloatBufferInfo.floatBuffer, this.mInformation.getChannels(), this.mTargetPlaySample);
                                    AudioTrack audioTrack = this.mAudioTrack;
                                    FloatBufferInfo floatBufferInfo4 = this.mFloatBufferInfo;
                                    int write = audioTrack.write(floatBufferInfo4.floatBuffer, 0, floatBufferInfo4.bufferSize, 0);
                                    if (write < 0) {
                                        if (this.mAudioTrack.getPlayState() == 3) {
                                            Logger.e(TAG, axiliary("mAudioTrack write float failed: " + write + ", expect: " + this.mFloatBufferInfo.bufferSize));
                                            this.mStateRunner.transfer(9);
                                            callExceptionCallback(92, 102);
                                            return;
                                        }
                                        Logger.i(TAG, axiliary("write data to audiotrack failed, but it's OK"));
                                        i28 = i18;
                                        j16 = calculatePcmPlayTime;
                                        i49 = i66;
                                        i38 = i58;
                                        i29 = i27;
                                        z29 = z16;
                                        z38 = false;
                                        z28 = false;
                                        c17 = 2;
                                        z27 = true;
                                        if (Build.VERSION.SDK_INT >= 24) {
                                            underrunCount = this.mAudioTrack.getUnderrunCount();
                                            i39 = i65;
                                            if (underrunCount > 0 && underrunCount > i39) {
                                                PlayStuckMonitor.INSTANCE.onPlayStuck(currentTimeMillis2, j16, z47, underrunCount - i39);
                                                i39 = underrunCount;
                                                z47 = z27;
                                            } else {
                                                z47 = z28;
                                            }
                                        } else {
                                            i39 = i65;
                                            if (j16 > 0 && currentTimeMillis2 > j16 && !z39) {
                                                PlayStuckMonitor.INSTANCE.onPlayStuck(currentTimeMillis2, j16, z47, 0);
                                                z47 = z27;
                                            } else {
                                                z47 = z28;
                                            }
                                        }
                                        i58 = i38;
                                        i65 = i39;
                                        z39 = z28;
                                        i59 = i29;
                                        f16 = null;
                                        i57 = i28;
                                        boolean z48 = z29;
                                        i56 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                        j17 = j3;
                                        z46 = z48;
                                        z37 = z39;
                                    } else {
                                        if (write != this.mFloatBufferInfo.bufferSize) {
                                            Logger.w(TAG, axiliary("mAudioTrack write float not equal: " + write + ", expect: " + this.mFloatBufferInfo.bufferSize));
                                            if (write == 0) {
                                                i46 = i58 + 1;
                                                if (i46 >= 5) {
                                                    Logger.w(TAG, axiliary("continuous write zero"));
                                                    this.mStateRunner.transfer(9);
                                                    callExceptionCallback(92, 105);
                                                    return;
                                                }
                                                z29 = true;
                                                if (write <= 0) {
                                                    c17 = 2;
                                                    i28 = i18;
                                                    i37 = i46;
                                                    i29 = i27;
                                                    z28 = false;
                                                    z27 = true;
                                                    r36 = this.mFloatBufferInfo.bufferSize * 2;
                                                    j16 = calculatePcmPlayTime;
                                                    i49 = i66 + r36;
                                                    i38 = i37;
                                                    z38 = z27;
                                                    if (Build.VERSION.SDK_INT >= 24) {
                                                    }
                                                    i58 = i38;
                                                    i65 = i39;
                                                    z39 = z28;
                                                    i59 = i29;
                                                    f16 = null;
                                                    i57 = i28;
                                                    boolean z482 = z29;
                                                    i56 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                                    j17 = j3;
                                                    z46 = z482;
                                                    z37 = z39;
                                                } else {
                                                    c17 = 2;
                                                    i28 = i18;
                                                    i36 = i46;
                                                    i29 = i27;
                                                    z28 = false;
                                                    z27 = true;
                                                    i37 = i36;
                                                    r36 = z28;
                                                    j16 = calculatePcmPlayTime;
                                                    i49 = i66 + r36;
                                                    i38 = i37;
                                                    z38 = z27;
                                                    if (Build.VERSION.SDK_INT >= 24) {
                                                    }
                                                    i58 = i38;
                                                    i65 = i39;
                                                    z39 = z28;
                                                    i59 = i29;
                                                    f16 = null;
                                                    i57 = i28;
                                                    boolean z4822 = z29;
                                                    i56 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                                    j17 = j3;
                                                    z46 = z4822;
                                                    z37 = z39;
                                                }
                                            } else {
                                                this.mAudioTrack.flush();
                                                PlayStuckMonitor.INSTANCE.onAudioTrackFlush(write, this.mFloatBufferInfo.bufferSize);
                                            }
                                        }
                                        z29 = false;
                                        i46 = 0;
                                        if (write <= 0) {
                                        }
                                    }
                                } else {
                                    c17 = 2;
                                    i28 = i18;
                                    i29 = i27;
                                    z27 = true;
                                    calculatePcmPlayTime = calculatePcmPlayTime(this.mDecodeBufferInfo.byteBuffer, this.mInformation.getChannels(), this.mTargetBitDepth, this.mTargetPlaySample);
                                    AudioTrack audioTrack2 = this.mAudioTrack;
                                    BufferInfo bufferInfo6 = this.mDecodeBufferInfo;
                                    z28 = false;
                                    int write2 = audioTrack2.write(bufferInfo6.byteBuffer, 0, bufferInfo6.bufferSize);
                                    if (write2 < 0) {
                                        if (this.mAudioTrack.getPlayState() == 3) {
                                            Logger.e(TAG, axiliary("mAudioTrack write bytes failed: " + write2 + ", expect: " + this.mDecodeBufferInfo.bufferSize));
                                            this.mStateRunner.transfer(9);
                                            callExceptionCallback(92, 102);
                                            return;
                                        }
                                        Logger.i(TAG, axiliary("write data to audiotrack failed, but it's OK"));
                                        j16 = calculatePcmPlayTime;
                                        z38 = false;
                                        i49 = i66;
                                        i38 = i58;
                                        z29 = z16;
                                        if (Build.VERSION.SDK_INT >= 24) {
                                        }
                                        i58 = i38;
                                        i65 = i39;
                                        z39 = z28;
                                        i59 = i29;
                                        f16 = null;
                                        i57 = i28;
                                        boolean z48222 = z29;
                                        i56 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                        j17 = j3;
                                        z46 = z48222;
                                        z37 = z39;
                                    } else {
                                        if (write2 != this.mDecodeBufferInfo.bufferSize) {
                                            Logger.w(TAG, axiliary("mAudioTrack write bytes not equal: " + write2 + ", expect: " + this.mDecodeBufferInfo.bufferSize));
                                            if (write2 == 0) {
                                                i36 = i58 + 1;
                                                if (i36 >= 5) {
                                                    Logger.w(TAG, axiliary("float, continuous write zero"));
                                                    this.mStateRunner.transfer(9);
                                                    callExceptionCallback(92, 105);
                                                    return;
                                                }
                                                z29 = true;
                                                if (write2 > 0) {
                                                    i37 = i36;
                                                    r36 = this.mDecodeBufferInfo.bufferSize;
                                                    j16 = calculatePcmPlayTime;
                                                    i49 = i66 + r36;
                                                    i38 = i37;
                                                    z38 = z27;
                                                    if (Build.VERSION.SDK_INT >= 24) {
                                                    }
                                                    i58 = i38;
                                                    i65 = i39;
                                                    z39 = z28;
                                                    i59 = i29;
                                                    f16 = null;
                                                    i57 = i28;
                                                    boolean z482222 = z29;
                                                    i56 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                                    j17 = j3;
                                                    z46 = z482222;
                                                    z37 = z39;
                                                }
                                                i37 = i36;
                                                r36 = z28;
                                                j16 = calculatePcmPlayTime;
                                                i49 = i66 + r36;
                                                i38 = i37;
                                                z38 = z27;
                                                if (Build.VERSION.SDK_INT >= 24) {
                                                }
                                                i58 = i38;
                                                i65 = i39;
                                                z39 = z28;
                                                i59 = i29;
                                                f16 = null;
                                                i57 = i28;
                                                boolean z4822222 = z29;
                                                i56 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                                j17 = j3;
                                                z46 = z4822222;
                                                z37 = z39;
                                            } else {
                                                this.mAudioTrack.flush();
                                                PlayStuckMonitor.INSTANCE.onAudioTrackFlush(write2, this.mDecodeBufferInfo.bufferSize);
                                            }
                                        }
                                        i36 = 0;
                                        z29 = false;
                                        if (write2 > 0) {
                                        }
                                        i37 = i36;
                                        r36 = z28;
                                        j16 = calculatePcmPlayTime;
                                        i49 = i66 + r36;
                                        i38 = i37;
                                        z38 = z27;
                                        if (Build.VERSION.SDK_INT >= 24) {
                                        }
                                        i58 = i38;
                                        i65 = i39;
                                        z39 = z28;
                                        i59 = i29;
                                        f16 = null;
                                        i57 = i28;
                                        boolean z48222222 = z29;
                                        i56 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
                                        j17 = j3;
                                        z46 = z48222222;
                                        z37 = z39;
                                    }
                                }
                            }
                        }
                        i26 = i18;
                        z18 = false;
                        c16 = 2;
                        z19 = true;
                        i59 = i27;
                        i65 = i65;
                    } else {
                        i26 = i18;
                        int i68 = i19;
                        z18 = false;
                        c16 = 2;
                        z19 = true;
                        this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(i68, 92);
                        i59 = i68;
                        i65 = i65;
                    }
                    i49 = i66;
                    z38 = z17;
                    j17 = j3;
                    z46 = z16;
                    i56 = i17;
                    f16 = null;
                    z37 = z18;
                    i57 = i26;
                } else {
                    return;
                }
            }
            return;
        }
        if (!this.mCorePlayer.mIsExit) {
            Logger.e(TAG, axiliary("\u4e0d\u7559\u75d5\u8ff9\u7684\u9000\u51fa \u65f6\u673a\uff1a\u83b7\u53d6Information\u65f6 step = 3"));
            this.mStateRunner.transfer(9);
            callExceptionCallback(91, 63);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void pause(boolean z16) {
        AudioTrack audioTrack;
        super.pause(z16);
        if (z16 && (audioTrack = this.mAudioTrack) != null) {
            try {
                if (audioTrack.getState() == 1 && audioTrack.getPlayState() != 2) {
                    audioTrack.pause();
                }
            } catch (IllegalStateException unused) {
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void release() {
        super.release();
        this.mCurrentFrameCount = 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void seek(int i3) {
        addSeekRecord(i3);
        refreshTimeAndNotify(i3);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void setAudioStreamType(int i3) {
        if (i3 == this.mAudioStreamType) {
            return;
        }
        try {
            this.mAudioStreamType = i3;
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack != null) {
                AudioTrack instantiateAudioTrackCompat = BaseDecodeDataComponent.instantiateAudioTrackCompat(i3, audioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
                Logger.i(TAG, axiliary("[setAudioStreamType] new AudioTrack, sampleRate: " + this.mAudioTrack.getSampleRate() + ", channels: " + this.mAudioTrack.getChannelConfiguration() + ", bitDepth: " + this.mAudioTrack.getAudioFormat() + ", buffer: " + this.mTrackBufferSizeInByte));
                int playState = this.mAudioTrack.getPlayState();
                if (playState == 3) {
                    pause(false);
                }
                this.mAudioTrack.release();
                setAudioTrack(instantiateAudioTrackCompat);
                this.mStateRunner.setAudioTrack(this.mAudioTrack);
                if (playState == 3) {
                    play();
                }
            }
        } catch (IllegalArgumentException | IllegalStateException e16) {
            Logger.e(TAG, "failed in setting audio stream type to :" + i3, e16);
        }
    }
}
