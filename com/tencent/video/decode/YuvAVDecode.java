package com.tencent.video.decode;

import android.graphics.Bitmap;
import android.media.AudioTrack;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YuvAVDecode extends AbstractAVDecode {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "YuvAVDecode";
    private byte[] audioBuffer;
    AVDecodeOption mAVOption;
    private ByteBuffer mConvertBuffer;
    int mCurrentDropped;
    int mDropSectionSize;
    int mNeedDropCount;
    boolean mNeedDropFrame;
    float mRealFps;
    int mSingleAudioByteNum;
    VideoSourceHelper mSourceHelper;
    int mTotalNeedDrop;
    float mVideoFps;

    YuvAVDecode(AVDecodeOption aVDecodeOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVDecodeOption);
            return;
        }
        this.mVideoFps = -1.0f;
        this.mRealFps = -1.0f;
        this.audioBuffer = null;
        this.mConvertBuffer = null;
        this.mTotalNeedDrop = 0;
        this.mCurrentDropped = 0;
        VideoSourceHelper videoSourceHelper = new VideoSourceHelper(aVDecodeOption.mVfPath, aVDecodeOption.mAfPath);
        this.mSourceHelper = videoSourceHelper;
        this.mAVOption = aVDecodeOption;
        videoSourceHelper.initHelperParam();
        int[] sourceVideoParam = this.mSourceHelper.getSourceVideoParam();
        float f16 = (aVDecodeOption.mVideoFrames * 1000.0f) / aVDecodeOption.mTotalTime;
        this.mVideoFps = f16;
        AVVideoParam aVVideoParam = this.videoParam;
        aVVideoParam.errcode = 0;
        aVVideoParam.stream_kind = AbstractAVDecode.STREAM_VIDEO;
        aVVideoParam.width = sourceVideoParam[0];
        aVVideoParam.height = sourceVideoParam[1];
        aVVideoParam.frame_index = 0;
        aVVideoParam.rotation = 0;
        float f17 = aVDecodeOption.wantedFps;
        if (f17 >= f16 / 2.0f && f17 < f16 && Math.abs(f16 - f17) > 2.0f) {
            this.mNeedDropFrame = true;
            float f18 = f16 / (f16 - aVDecodeOption.wantedFps);
            this.mDropSectionSize = (int) f18;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "YuvAVDecode,fps = " + f16 + ",wantedFps = " + aVDecodeOption.wantedFps + ",mDropSectionSize = " + this.mDropSectionSize + " dropSize=" + f18);
            }
            int i3 = (int) (f16 / this.mDropSectionSize);
            this.mNeedDropCount = i3;
            aVDecodeOption.wantedFps = f16 - i3;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "YuvAVDecode,fps = " + f16 + ",wantedFps = " + aVDecodeOption.wantedFps + ",mDropSectionSize = " + this.mDropSectionSize + " , mNeedDropCount=" + this.mNeedDropCount);
            }
            this.mTotalNeedDrop = (int) (this.mNeedDropCount * (aVDecodeOption.mTotalTime / 1000.0f));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "YuvAVDecode,mTotalNeedDrop = " + this.mTotalNeedDrop);
            }
            float f19 = aVDecodeOption.wantedFps;
            this.mRealFps = f19;
            AVVideoParam aVVideoParam2 = this.videoParam;
            aVVideoParam2.fps_num = (int) (f19 * 1000.0f);
            aVVideoParam2.fps_den = 1000;
        } else {
            this.mNeedDropFrame = false;
            this.mTotalNeedDrop = 0;
            float f26 = this.mVideoFps;
            this.mRealFps = f26;
            aVDecodeOption.wantedFps = f26;
            AVVideoParam aVVideoParam3 = this.videoParam;
            aVVideoParam3.fps_num = (int) (f26 * 1000.0f);
            aVVideoParam3.fps_den = 1000;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "YuvAVDecode,do not drop frame,fps = " + f16 + ",wantedFps = " + aVDecodeOption.wantedFps + ",mRealFps = " + this.mRealFps);
            }
        }
        this.videoParam.duration = getVideoDuration(this.mRealFps);
        AVAudioParam aVAudioParam = this.audioParam;
        aVAudioParam.errcode = 0;
        aVAudioParam.stream_kind = AbstractAVDecode.STREAM_AUDIO;
        aVAudioParam.duration = -1;
        VideoSourceHelper videoSourceHelper2 = this.mSourceHelper;
        aVAudioParam.sample_rate = videoSourceHelper2.mSampleRate;
        aVAudioParam.numsample = 0;
        int i16 = videoSourceHelper2.mPCMFormat;
        if (i16 == 3) {
            this.mSingleAudioByteNum = 1;
        } else if (i16 == 2) {
            this.mSingleAudioByteNum = 2;
        }
        int i17 = videoSourceHelper2.mChannel;
        aVAudioParam.channels = i17;
        if (i17 == 2) {
            aVAudioParam.channels = 1;
        } else if (i17 == 3) {
            aVAudioParam.channels = 2;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "YuvAVDecode,mSourceHelper.mChannel " + this.mSourceHelper.mChannel);
            }
            this.audioParam.channels = 2;
        }
        this.audioParam.frameIndex = 0;
        initMediaBuffer();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        sb5.append(" videoParam.duration: " + this.videoParam.duration);
        sb5.append(" videoParam.width: " + this.videoParam.width);
        sb5.append(" videoParam.height: " + this.videoParam.height);
        sb5.append(" videoParam.fps_num: " + this.videoParam.fps_num);
        sb5.append(" videoParam.fps_den: " + this.videoParam.fps_den);
        sb5.append(" audioParam.sample_rate: " + this.audioParam.sample_rate);
        sb5.append(" audioParam.channels: " + this.audioParam.channels);
        sb5.append("] ");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "YuvAVDecode, " + sb5.toString());
        }
    }

    private int getAudioDuration(int i3) {
        AVAudioParam aVAudioParam = this.audioParam;
        return (i3 * 1000) / ((aVAudioParam.sample_rate * aVAudioParam.channels) * this.mSingleAudioByteNum);
    }

    private int getNextFrameDrop(Bitmap bitmap) {
        int nextVideoFrameBitmap = this.mSourceHelper.getNextVideoFrameBitmap(bitmap);
        if (nextVideoFrameBitmap == -1) {
            return nextVideoFrameBitmap;
        }
        AVVideoParam aVVideoParam = this.videoParam;
        int i3 = aVVideoParam.frame_index + 1;
        aVVideoParam.frame_index = i3;
        if (this.mNeedDropFrame && i3 % this.mDropSectionSize == 0 && this.mCurrentDropped < this.mTotalNeedDrop) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getNextFrameDrop,drop a frame,videoParam.frame_index  = " + this.videoParam.frame_index);
            }
            this.mCurrentDropped++;
            nextVideoFrameBitmap = this.mSourceHelper.getNextVideoFrameBitmap(bitmap);
            if (nextVideoFrameBitmap == 0) {
                this.videoParam.frame_index++;
            }
        }
        return nextVideoFrameBitmap;
    }

    private int getVideoDuration(float f16) {
        return (int) (1000.0f / f16);
    }

    private boolean initMediaBuffer() {
        int[] bufferSize = this.mSourceHelper.getBufferSize();
        if (bufferSize != null && bufferSize.length >= 2) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "initMediaBuffer videosize=" + bufferSize[0] + ", audiosize=" + bufferSize[1]);
            }
            try {
                if (this.audioBuffer == null) {
                    int calcuAudioBufferSize = calcuAudioBufferSize();
                    this.audioBuffer = new byte[calcuAudioBufferSize];
                    this.mConvertBuffer = ByteBuffer.allocateDirect(calcuAudioBufferSize).order(ByteOrder.nativeOrder());
                }
                return true;
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static YuvAVDecode newInstance(AVDecodeOption aVDecodeOption) {
        try {
            AbstractAVDecode.checkSoLoaded();
            return new YuvAVDecode(aVDecodeOption);
        } catch (AVideoException e16) {
            e16.printStackTrace();
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "YuvAVDecode,newInstance ep = " + e16);
            return null;
        } catch (UnsatisfiedLinkError e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "YuvAVDecode,newInstance err = " + e17);
            return null;
        }
    }

    private void resetVideoSource() {
        int resetDataSource = this.mSourceHelper.resetDataSource();
        if (resetDataSource != -1) {
            this.videoParam.frame_index = 0;
            this.audioParam.frameIndex = 0;
            this.mCurrentDropped = 0;
            return;
        }
        throw new AVideoException(resetDataSource, -1, "reset error");
    }

    int calcuAudioBufferSize() {
        int i3;
        AVAudioParam aVAudioParam = this.audioParam;
        if (aVAudioParam.channels <= 1) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        int i16 = aVAudioParam.sample_rate;
        if (i16 <= 0) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "calcuAudioBufferSize(), sampleRateInHz=" + i16 + ", <= 0, return...");
                return 2000;
            }
            return 2000;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i16, i3, 2);
        if (minBufferSize < 1024) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "calcuAudioBufferSize(), minBufSize=" + minBufferSize + " < 1024, so mutiply 2");
            }
            minBufferSize *= 2;
            if (minBufferSize < 1024) {
                minBufferSize = 1024;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "calcuAudioBufferSize() primePlaySize: " + minBufferSize);
        }
        return minBufferSize;
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mSourceHelper.closeHelper();
        }
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public void resetVideoPlayer(AVDecodeOption aVDecodeOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVDecodeOption);
        } else {
            this.mSourceHelper.resetDataSource();
        }
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public byte[] seekToNextAudioByteFrame() throws AVideoException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "seekToNextAudioByteFrame ");
        }
        int nextAudioFrame = this.mSourceHelper.getNextAudioFrame(this.audioBuffer);
        if (nextAudioFrame > 0) {
            AVAudioParam aVAudioParam = this.audioParam;
            aVAudioParam.numsample = nextAudioFrame / this.mSingleAudioByteNum;
            aVAudioParam.frameIndex++;
        }
        return this.audioBuffer;
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public float[] seekToNextAudioFloatFrame() throws AVideoException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (float[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public short[] seekToNextAudioShortFrame() throws AVideoException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (short[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int nextAudioFrame = this.mSourceHelper.getNextAudioFrame(this.audioBuffer);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "seekToNextAudioShortFrame,byteNum = " + nextAudioFrame);
        }
        if (nextAudioFrame > 0) {
            AVAudioParam aVAudioParam = this.audioParam;
            aVAudioParam.numsample = nextAudioFrame / this.mSingleAudioByteNum;
            aVAudioParam.frameIndex++;
            aVAudioParam.duration = getAudioDuration(nextAudioFrame);
            this.mConvertBuffer.position(0);
            this.mConvertBuffer.put(this.audioBuffer, 0, nextAudioFrame);
            this.mConvertBuffer.position(0);
            short[] sArr = new short[nextAudioFrame / 2];
            this.mConvertBuffer.asShortBuffer().get(sArr);
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "seekToNextAudioShortFrame,byteNum = " + nextAudioFrame + ",duration = " + this.audioParam.duration + ", nativeCost = " + (elapsedRealtime2 - elapsedRealtime) + ",convertCost = " + (elapsedRealtime3 - elapsedRealtime2));
            }
            return sArr;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "seekToNextAudioShortFrame throw exception");
        }
        throw new AVideoException(AVDecodeError.AUDIO_DATA_DECODE_FINISH, -1, " seekToNextAudioShortFrame error");
    }

    @Override // com.tencent.video.decode.AbstractAVDecode
    public void seekToNextFrame(Bitmap bitmap) throws AVideoException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int nextFrameDrop = getNextFrameDrop(bitmap);
        if (nextFrameDrop == -1) {
            AVVideoParam aVVideoParam = this.videoParam;
            aVVideoParam.frame_count = aVVideoParam.frame_index;
            if (this.mAVOption.cycle) {
                resetVideoSource();
                int nextFrameDrop2 = getNextFrameDrop(bitmap);
                if (nextFrameDrop2 == -1) {
                    throw new AVideoException(nextFrameDrop2, -1, "recycle getNextFrameDrop error");
                }
            } else {
                throw new AVideoException(-110, nextFrameDrop, " getNextFrameDrop error");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "seekToNextFrame,cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }
}
