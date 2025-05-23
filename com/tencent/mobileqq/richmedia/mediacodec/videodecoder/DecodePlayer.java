package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.mobileqq.sveffects.libsveffects.BuildConfig;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes18.dex */
public class DecodePlayer implements HWDecodeListener {
    public static final int STATE_CANCELED = 2;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_STOPING = 6;
    private static final String TAG = "DecodePlayer";
    private HWVideoDecoder hwVideoDecoder;
    private HWDecodeListener mHWDecodeListener;
    private SimpleAudioPlayer mSimpleAudioPlayer;
    private AtomicInteger mCurrentState = new AtomicInteger(0);
    private final DecodeConfig mVideoDecodeConfig = new DecodeConfig();
    public long videoDuration = 0;
    private long mCurrentDecodeTimestampNs = -1;
    private int mAudioOffsetMs = 0;
    private final AudioDecodeConfig mAudioDecodeConfig = new AudioDecodeConfig();

    /* loaded from: classes18.dex */
    public static class AudioDecodeConfig {
        public String audioFilePath;
        public boolean repeat = true;
        public int speedType = 0;
        public boolean mMuteAudio = false;
        public long startTimeMs = 0;
        public long endTimeMs = 0;
        public long videoDurationMs = 0;

        public void copyFrom(AudioDecodeConfig audioDecodeConfig) {
            audioDecodeConfig.getClass();
            this.audioFilePath = audioDecodeConfig.audioFilePath;
            this.repeat = audioDecodeConfig.repeat;
            this.speedType = audioDecodeConfig.speedType;
            this.mMuteAudio = audioDecodeConfig.mMuteAudio;
            this.startTimeMs = audioDecodeConfig.startTimeMs;
            this.endTimeMs = audioDecodeConfig.endTimeMs;
            this.videoDurationMs = audioDecodeConfig.videoDurationMs;
        }

        public String toString() {
            return "AudioDecodeConfig=[audioFilePath:" + this.audioFilePath + " repeat:" + this.repeat + " speedType:" + this.speedType + " mMuteAudio:" + this.mMuteAudio + " startTimeMs:" + this.startTimeMs + " endTimeMs:" + this.endTimeMs + " videoDuration:" + this.videoDurationMs + "]";
        }
    }

    public DecodePlayer() {
        this.hwVideoDecoder = null;
        this.hwVideoDecoder = new HWVideoDecoder();
    }

    public int getCurrentState() {
        return this.mCurrentState.get();
    }

    public HWVideoDecoder getDecoder() {
        return this.hwVideoDecoder;
    }

    public int getSpeedType() {
        return this.mVideoDecodeConfig.speedType;
    }

    public String getVideoFilePath() {
        return this.mVideoDecodeConfig.inputFilePath;
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeCancel() {
        this.mCurrentState.set(2);
        SdkContext.getInstance().getLogger().d(TAG, "onDecodeCancel");
        HWDecodeListener hWDecodeListener = this.mHWDecodeListener;
        if (hWDecodeListener != null) {
            hWDecodeListener.onDecodeCancel();
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeError(int i3, Throwable th5) {
        SdkContext.getInstance().getLogger().e(TAG, "onDecodeError errorCode = " + i3, th5);
        stopMusic();
        if (!BuildConfig.DEBUG) {
        } else {
            throw new RuntimeException(th5);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFinish() {
        this.mCurrentState.set(5);
        SdkContext.getInstance().getLogger().d(TAG, "onDecodeFinish");
        stopMusic();
        HWDecodeListener hWDecodeListener = this.mHWDecodeListener;
        if (hWDecodeListener != null) {
            hWDecodeListener.onDecodeFinish();
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFrame(long j3, long j16) throws InterruptedException {
        HWDecodeListener hWDecodeListener = this.mHWDecodeListener;
        if (hWDecodeListener != null) {
            hWDecodeListener.onDecodeFrame(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeRepeat() {
        SdkContext.getInstance().getLogger().d(TAG, "onDecodeRepeat");
        HWDecodeListener hWDecodeListener = this.mHWDecodeListener;
        if (hWDecodeListener != null) {
            hWDecodeListener.onDecodeRepeat();
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeSeekTo(long j3) {
        int i3 = (int) j3;
        this.mAudioOffsetMs = i3;
        this.mCurrentDecodeTimestampNs = System.nanoTime();
        if (FileUtil.fileExistsAndNotEmpty(this.mAudioDecodeConfig.audioFilePath) && this.mSimpleAudioPlayer != null && !VideoPrefsUtil.getMaterialMute()) {
            this.mSimpleAudioPlayer.setAudioStream(3);
            this.mSimpleAudioPlayer.seekPlay(this.mAudioDecodeConfig.audioFilePath, i3);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeStart() {
        this.mCurrentState.set(3);
        SdkContext.getInstance().getLogger().d(TAG, "onDecodeStart");
        HWDecodeListener hWDecodeListener = this.mHWDecodeListener;
        if (hWDecodeListener != null) {
            hWDecodeListener.onDecodeStart();
        }
    }

    public void resumeMusic() {
        SimpleAudioPlayer simpleAudioPlayer = this.mSimpleAudioPlayer;
        if (simpleAudioPlayer != null && !simpleAudioPlayer.isPlaying() && this.mCurrentState.get() == 3 && FileUtil.fileExistsAndNotEmpty(this.mAudioDecodeConfig.audioFilePath)) {
            this.mSimpleAudioPlayer.setAudioStream(3);
            this.mSimpleAudioPlayer.seekPlay(this.mAudioDecodeConfig.audioFilePath, ((int) ((System.nanoTime() - this.mCurrentDecodeTimestampNs) / 1000000)) + this.mAudioOffsetMs);
        }
    }

    public void setDecodeListener(HWDecodeListener hWDecodeListener) {
        this.mHWDecodeListener = hWDecodeListener;
    }

    public void setFilePath(String str, String str2) {
        this.mVideoDecodeConfig.inputFilePath = str;
        if (FileUtil.fileExistsAndNotEmpty(str2) && this.mSimpleAudioPlayer == null) {
            this.mSimpleAudioPlayer = new SimpleAudioPlayer();
        }
        this.mAudioDecodeConfig.audioFilePath = str2;
        if (SdkContext.getInstance().getLogger().isEnable()) {
            SdkContext.getInstance().getLogger().d(TAG, "setFilePath: videoFilePath = " + this.mVideoDecodeConfig.inputFilePath + " ; audioFilePath = " + str2);
        }
        long durationOfVideo = VideoUtil.getDurationOfVideo(this.mVideoDecodeConfig.inputFilePath);
        this.videoDuration = durationOfVideo;
        this.mAudioDecodeConfig.videoDurationMs = durationOfVideo;
    }

    public void setNOSleep(boolean z16) {
        this.mVideoDecodeConfig.noSleep = z16;
    }

    public void setRepeat(boolean z16) {
        this.mVideoDecodeConfig.repeat = z16;
        this.mAudioDecodeConfig.repeat = z16;
    }

    public void setSpeedType(int i3) {
        this.mVideoDecodeConfig.speedType = i3;
        this.mAudioDecodeConfig.speedType = i3;
        this.hwVideoDecoder.setSpeedType(i3);
    }

    public void setSyncDecode(boolean z16) {
        this.mVideoDecodeConfig.syncDecode = z16;
    }

    public void setVideoDecodeConfig(DecodeConfig decodeConfig) {
        this.mVideoDecodeConfig.copyFrom(decodeConfig);
    }

    public void startPlay(int i3, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        if (!TextUtils.isEmpty(this.mVideoDecodeConfig.inputFilePath)) {
            this.mCurrentState.set(1);
            this.hwVideoDecoder.startDecode(this.mVideoDecodeConfig, i3, onFrameAvailableListener, this);
            if (FileUtil.fileExistsAndNotEmpty(this.mAudioDecodeConfig.audioFilePath) && this.mSimpleAudioPlayer != null && !VideoPrefsUtil.getMaterialMute()) {
                this.mSimpleAudioPlayer.setAudioStream(3);
                this.mSimpleAudioPlayer.play(this.mAudioDecodeConfig.audioFilePath);
            }
            this.mAudioOffsetMs = 0;
            this.mCurrentDecodeTimestampNs = System.nanoTime();
            return;
        }
        throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }

    public void stopMusic() {
        SimpleAudioPlayer simpleAudioPlayer = this.mSimpleAudioPlayer;
        if (simpleAudioPlayer != null && simpleAudioPlayer.isPlaying()) {
            this.mSimpleAudioPlayer.stop();
        }
    }

    public void stopPlay() {
        this.mCurrentState.set(6);
        this.hwVideoDecoder.stopDecode();
        SimpleAudioPlayer simpleAudioPlayer = this.mSimpleAudioPlayer;
        if (simpleAudioPlayer != null && simpleAudioPlayer.isPlaying()) {
            this.mSimpleAudioPlayer.stop();
        }
    }
}
