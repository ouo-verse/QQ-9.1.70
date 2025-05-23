package com.tencent.tav.core.audio;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.MediaCodecManager;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioExportRunner implements Runnable {
    private static final int EDGE_DURATION_MS = 200;
    private static final int MAX_INPUT_SIZE = 8192;
    private static final String MIME = "audio/mp4a-latm";
    static final int PACKET_FPS = 44;
    private static final long WAIT_TRANSIENT_MS = 20;
    IAudioSource<? extends IDecoderTrack> mAudioAsset;
    private IDecoderTrack mAudioDecoder;
    private MediaCodec mAudioEncoder;
    private ExportCallback mCallback;
    private FileOutputStream mFos;
    private String mSavePath;
    CMTimeRange mSelectedTimeRange;
    private Thread mThread;
    private final String TAG = "AudioExportRunner@" + Integer.toHexString(hashCode());
    private String mMime = "audio/mp4a-latm";
    private int mRate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
    private int mSampleRate = 44100;
    private int mChannelCount = 1;
    private int mStatus = 0;
    private AtomicBoolean mStop = new AtomicBoolean(false);
    private boolean mCancel = false;
    private boolean enOfAudioInputStream = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioExportRunner(@NonNull IAudioSource<? extends IDecoderTrack> iAudioSource, @Nullable CMTimeRange cMTimeRange) {
        this.mAudioAsset = iAudioSource;
        if (cMTimeRange == null) {
            this.mSelectedTimeRange = new CMTimeRange(CMTime.CMTimeZero, iAudioSource.getDuration());
        } else {
            this.mSelectedTimeRange = cMTimeRange;
        }
    }

    private void confirmFinishAndNotify() {
        if (this.mStatus != 2 && !this.mCancel) {
            this.mStatus = 2;
            notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
        }
    }

    private int dequeueInputBuffer(MediaCodec mediaCodec) {
        try {
            return mediaCodec.dequeueInputBuffer(1000L);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "dequeueInputBuffer e = ", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                String str = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CodecException - isTransient = ");
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                sb5.append(codecException.isTransient());
                sb5.append(" , isRecoverable = ");
                sb5.append(codecException.isRecoverable());
                sb5.append(" , errorCode = ");
                sb5.append(codecException.getErrorCode());
                Logger.e(str, sb5.toString());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    return dequeueInputBuffer(mediaCodec);
                }
            }
            throw e16;
        }
    }

    private ByteBuffer getInputBuffer(int i3) {
        return this.mAudioEncoder.getInputBuffer(i3);
    }

    private ByteBuffer getOutputBuffer(int i3) {
        return this.mAudioEncoder.getOutputBuffer(i3);
    }

    private void initAudioDecoder() {
        try {
            IDecoderTrack sourceAudioDecoder = this.mAudioAsset.getSourceAudioDecoder(this.mSelectedTimeRange);
            this.mAudioDecoder = sourceAudioDecoder;
            sourceAudioDecoder.start();
            CMTime start = this.mSelectedTimeRange.getStart();
            IDecoderTrack iDecoderTrack = this.mAudioDecoder;
            CMTime cMTime = CMTime.CMTimeZero;
            if (start.bigThan(cMTime)) {
                cMTime = start.sub(CMTime.fromMs(200L));
            }
            iDecoderTrack.seekTo(cMTime, false, false);
        } catch (Throwable th5) {
            Logger.e(this.TAG, "initAudioDecoder: ", th5);
        }
    }

    private void initAudioEncoder() throws IOException {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.mSampleRate, this.mChannelCount);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("bitrate", this.mRate);
        createAudioFormat.setInteger("max-input-size", 8192);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.mMime);
        this.mAudioEncoder = createEncoderByType;
        createEncoderByType.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
    }

    private boolean isFinish(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo.presentationTimeUs >= this.mSelectedTimeRange.getEndUs()) {
            return true;
        }
        return false;
    }

    private boolean isValidBuffer(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo.size > 0 && bufferInfo.presentationTimeUs >= this.mSelectedTimeRange.getStartUs() && bufferInfo.presentationTimeUs <= this.mSelectedTimeRange.getEndUs() && (bufferInfo.flags & 2) == 0) {
            return true;
        }
        return false;
    }

    private void notifyProgressUpdate(long j3) {
        CMTimeRange cMTimeRange;
        if (this.mCallback != null && (cMTimeRange = this.mSelectedTimeRange) != null) {
            this.mCallback.onProgress(this.mStatus, (((float) (j3 - cMTimeRange.getStartUs())) * 1.0f) / ((float) this.mSelectedTimeRange.getDurationUs()));
        }
    }

    private void queueInputBuffer(MediaCodec mediaCodec, int i3, int i16, int i17, long j3, int i18) {
        try {
            mediaCodec.queueInputBuffer(i3, i16, i17, j3, i18);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "queueInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                String str = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CodecException - isTransient = ");
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                sb5.append(codecException.isTransient());
                sb5.append(" , isRecoverable = ");
                sb5.append(codecException.isRecoverable());
                sb5.append(" , errorCode = ");
                sb5.append(codecException.getErrorCode());
                Logger.e(str, sb5.toString());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    queueInputBuffer(mediaCodec, i3, i16, i17, j3, i18);
                }
            }
            throw e16;
        }
    }

    private void readNextSample() {
        CMSampleBuffer readSample = this.mAudioDecoder.readSample();
        CMTime time = readSample.getTime();
        if (time.value > 0 && time.getTimeUs() <= this.mSelectedTimeRange.getEndUs()) {
            ByteBuffer sampleByteBuffer = readSample.getSampleByteBuffer();
            int limit = sampleByteBuffer.limit() - sampleByteBuffer.position();
            byte[] bArr = new byte[limit];
            sampleByteBuffer.get(bArr);
            writeAudioSample(time, limit, bArr);
            return;
        }
        long stateCode = readSample.getState().getStateCode();
        if (stateCode >= -1 && !this.enOfAudioInputStream) {
            signalEndOfAudioStream();
            this.enOfAudioInputStream = true;
        }
        if (stateCode < -1) {
            this.mStatus = 255;
        }
    }

    private void signalEndOfAudioStream() {
        try {
            Logger.d(this.TAG, "signalEndOfAudioStream: ");
            int dequeueInputBuffer = dequeueInputBuffer(this.mAudioEncoder);
            if (dequeueInputBuffer >= 0) {
                queueInputBuffer(this.mAudioEncoder, dequeueInputBuffer, 0, 0, 0L, 4);
            }
        } catch (Throwable th5) {
            Logger.e(this.TAG, "signalEndOfAudioStream failed", th5);
        }
    }

    private synchronized void stop() {
        if (!this.mStop.get()) {
            this.mStop.set(true);
            try {
                this.mAudioDecoder.release();
                this.mAudioEncoder.stop();
                MediaCodecManager.releaseCodec(this.mAudioEncoder);
                this.mFos.flush();
                this.mFos.close();
            } catch (Exception e16) {
                Logger.e(this.TAG, "stop: ", e16);
            }
        }
        this.mCancel = false;
    }

    private void waitTime(long j3) {
        try {
            wait(j3);
        } catch (InterruptedException e16) {
            Logger.e(this.TAG, "waitTime: ", e16);
        }
    }

    private void write(byte[] bArr) throws Throwable {
        if (this.mFos == null) {
            this.mFos = new FileOutputStream(this.mSavePath);
        }
        this.mFos.write(bArr);
    }

    private void writeAudioSample(CMTime cMTime, int i3, byte[] bArr) {
        int i16 = 5;
        int i17 = 0;
        while (i3 - i17 > 0) {
            int dequeueInputBuffer = this.mAudioEncoder.dequeueInputBuffer(1000L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                int min = Math.min(inputBuffer.capacity(), i3);
                inputBuffer.put(bArr, i17, min);
                i17 += min;
                this.mAudioEncoder.queueInputBuffer(dequeueInputBuffer, 0, min, cMTime.getTimeUs(), 1);
            } else {
                i16--;
                if (i16 >= 0) {
                    waitTime(20L);
                } else {
                    throw new RuntimeException("dequeueInputBuffer fail");
                }
            }
        }
    }

    public synchronized void cancel() {
        this.mCancel = true;
    }

    public int getRate() {
        return this.mRate;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public CMTimeRange getSelectedTimeRange() {
        return this.mSelectedTimeRange;
    }

    public void prepare() throws IOException {
        initAudioDecoder();
        initAudioEncoder();
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger.d(this.TAG, "encoder start - " + this);
        while (this.mStatus <= 1 && !this.mCancel) {
            try {
                readNextSample();
                writeAudioSample();
            } catch (Throwable th5) {
                Logger.e(this.TAG, "run: writeAudioSample", th5);
                this.mStatus = 255;
                notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
            }
        }
        if (this.mCancel) {
            this.mStatus = 4;
            notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
        }
        Logger.d(this.TAG, "encoder finish - " + this + "  mStatus = " + this.mStatus);
        stop();
    }

    public void setAsset(IAudioSource<? extends IDecoderTrack> iAudioSource) {
        this.mAudioAsset = iAudioSource;
    }

    public void setCallback(ExportCallback exportCallback) {
        this.mCallback = exportCallback;
    }

    public void setMime(String str) {
        this.mMime = str;
    }

    public void setRate(int i3) {
        this.mRate = i3;
    }

    public void setSampleRate(int i3) {
        this.mSampleRate = i3;
    }

    public void setSavePath(String str) {
        this.mSavePath = str;
    }

    public void setSelectedTimeRange(CMTimeRange cMTimeRange) {
        this.mSelectedTimeRange = cMTimeRange;
    }

    public synchronized void start() {
        if (this.mThread == null) {
            this.mAudioEncoder.start();
            BaseThread baseThread = new BaseThread(this, this.TAG);
            this.mThread = baseThread;
            baseThread.start();
            this.mStop.set(false);
            this.mCancel = false;
            this.enOfAudioInputStream = false;
            this.mStatus = 1;
        }
    }

    private void writeAudioSample() throws Throwable {
        int dequeueOutputBuffer;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        do {
            dequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer >= 0 && isValidBuffer(bufferInfo) && this.mStatus != 2) {
                if ((bufferInfo.flags & 4) != 0) {
                    Logger.d(this.TAG, "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
                    this.mStatus = 2;
                }
                ByteBuffer outputBuffer = getOutputBuffer(dequeueOutputBuffer);
                outputBuffer.position(bufferInfo.offset);
                int i3 = bufferInfo.size;
                byte[] bArr = new byte[i3 + 7];
                outputBuffer.get(bArr, 7, i3);
                EncoderUtils.addADTStoPacket(bArr, this.mChannelCount);
                Logger.v(this.TAG, "dequeue finish - " + bufferInfo.presentationTimeUs + "--" + bufferInfo.flags + " -- " + bufferInfo.size + "  -  " + dequeueOutputBuffer + " endUs = " + this.mSelectedTimeRange.getEndUs());
                write(bArr);
                this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (this.mStatus != 2) {
                    notifyProgressUpdate(bufferInfo.presentationTimeUs);
                } else {
                    notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
                }
            } else if (isFinish(bufferInfo)) {
                confirmFinishAndNotify();
            } else if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -2) {
                if ((bufferInfo.flags & 4) != 0) {
                    Logger.d(this.TAG, "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM " + bufferInfo.size + "/" + bufferInfo.presentationTimeUs);
                    confirmFinishAndNotify();
                    this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                } else {
                    this.mAudioEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
        } while (dequeueOutputBuffer >= 0);
    }
}
