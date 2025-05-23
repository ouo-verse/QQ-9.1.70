package com.tencent.ttpic.voicechanger.common.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
/* loaded from: classes27.dex */
public class RealTimePcmPacker {
    private static final int CODEC_TIMEOUT = 5000;
    private static final String COMPRESSED_AUDIO_FILE_MIME_TYPE = "audio/mp4a-latm";
    private static final String TAG = "RealTimePcmPacker";
    private int audioTrackId;
    private int bitrate;
    private MediaCodec.BufferInfo bufferInfo;
    private int channelCount;
    private ByteBuffer[] codecInputBuffers;
    private ByteBuffer[] codecOutputBuffers;
    private int frameByteLength;
    private boolean isMediaMuxerStart = false;
    private MediaCodec mediaCodec;
    private MediaFormat mediaFormat;
    private MediaMuxer mediaMuxer;
    private String outputPath;
    private double presentationTimeUs;
    private int sampleRate;
    private int totalBytesRead;

    public RealTimePcmPacker(int i3, int i16, int i17) {
        this.bitrate = i3;
        this.sampleRate = i16;
        this.channelCount = i17;
        this.frameByteLength = (int) (i16 * 0.02d * 2.0d);
    }

    private void handleEndOfStream() {
        int dequeueInputBuffer;
        MediaCodec mediaCodec = this.mediaCodec;
        if (mediaCodec == null || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(5000L)) <= 0) {
            return;
        }
        this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, (long) this.presentationTimeUs, 4);
        writeOutputs();
    }

    private void tryStartMediaMuxer() {
        MediaCodec mediaCodec;
        if (!this.isMediaMuxerStart && (mediaCodec = this.mediaCodec) != null && this.mediaMuxer != null) {
            MediaFormat outputFormat = mediaCodec.getOutputFormat();
            this.mediaFormat = outputFormat;
            this.audioTrackId = this.mediaMuxer.addTrack(outputFormat);
            this.mediaMuxer.start();
            this.isMediaMuxerStart = true;
        }
    }

    private void writeOutputs() {
        ByteBuffer outputBuffer;
        MediaCodec mediaCodec = this.mediaCodec;
        if (mediaCodec == null) {
            return;
        }
        try {
            this.codecOutputBuffers = mediaCodec.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 0L);
                String str = TAG;
                LogUtils.d(str, "dequeue & queue - dequeueOutput(" + dequeueOutputBuffer + ")");
                if (dequeueOutputBuffer == -1) {
                    LogUtils.e(str, "\u83b7\u5f97\u7f16\u7801\u5668\u8f93\u51fa\u7f13\u5b58\u533a\u8d85\u65f6");
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    if (!ApiHelper.hasLollipop()) {
                        this.codecOutputBuffers = this.mediaCodec.getOutputBuffers();
                        return;
                    }
                    return;
                }
                if (dequeueOutputBuffer == -2) {
                    tryStartMediaMuxer();
                    LogUtils.i(str, "\u7f16\u7801\u5668\u8f93\u51fa\u7f13\u5b58\u533a\u683c\u5f0f\u6539\u53d8\uff0c\u6dfb\u52a0\u89c6\u9891\u8f68\u9053\u5230\u6df7\u5408\u5668");
                    return;
                }
                if (dequeueOutputBuffer >= 0) {
                    if (!ApiHelper.hasLollipop()) {
                        outputBuffer = this.codecOutputBuffers[dequeueOutputBuffer];
                    } else {
                        outputBuffer = this.mediaCodec.getOutputBuffer(dequeueOutputBuffer);
                    }
                    if (this.bufferInfo.size != 0) {
                        if (!this.isMediaMuxerStart) {
                            LogUtils.e(str, "muxer hasn't started");
                            this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            if (ApiHelper.hasKitkat()) {
                                outputBuffer.position(this.bufferInfo.offset);
                                MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
                                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            }
                            this.mediaMuxer.writeSampleData(this.audioTrackId, this.codecOutputBuffers[dequeueOutputBuffer], this.bufferInfo);
                            this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            LogUtils.d(str, "dequeue & queue - releaseOutput(" + dequeueOutputBuffer + ")");
                        }
                    }
                    if ((this.bufferInfo.flags & 2) == 0) {
                        LogUtils.d(str, "writeOutputs:() - while - index = " + dequeueOutputBuffer);
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e16) {
            String str2 = TAG;
            LogUtils.e(str2, e16);
            Log.e(str2, "\u5408\u6210\u65f6\u53d1\u751f\u5f02\u5e38\uff1a" + e16.getMessage());
        }
    }

    public void encodeBytes(byte[] bArr) {
        ByteBuffer inputBuffer;
        String str = TAG;
        LogUtils.d(str, "Starting encoding 1 batch: length = " + bArr.length + "; timestamp = " + this.presentationTimeUs);
        MediaCodec mediaCodec = this.mediaCodec;
        if (mediaCodec != null && this.mediaMuxer != null) {
            this.codecInputBuffers = mediaCodec.getInputBuffers();
            int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(0L);
            LogUtils.d(str, "dequeue & queue - dequeueInput(" + dequeueInputBuffer + ")");
            if (dequeueInputBuffer >= 0) {
                if (!ApiHelper.hasLollipop()) {
                    inputBuffer = this.codecInputBuffers[dequeueInputBuffer];
                } else {
                    inputBuffer = this.mediaCodec.getInputBuffer(dequeueInputBuffer);
                }
                inputBuffer.clear();
                inputBuffer.put(bArr);
                this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, (long) this.presentationTimeUs, 0);
                writeOutputs();
                LogUtils.d(str, "dequeue & queue - queueInput(" + dequeueInputBuffer + ")");
            }
            this.totalBytesRead = this.totalBytesRead + bArr.length;
            this.presentationTimeUs = ((r1 / 2) * 1000000) / this.sampleRate;
            LogUtils.d(str, "Finished encoding 1 frame");
        }
    }

    public void prepare() {
        if (this.outputPath != null) {
            try {
                MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.sampleRate, this.channelCount);
                this.mediaFormat = createAudioFormat;
                createAudioFormat.setInteger("aac-profile", 2);
                this.mediaFormat.setInteger("bitrate", this.bitrate);
                this.mediaFormat.setInteger("max-input-size", 1048576);
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
                this.mediaCodec = createEncoderByType;
                createEncoderByType.configure(this.mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mediaCodec.start();
                this.codecInputBuffers = this.mediaCodec.getInputBuffers();
                this.codecOutputBuffers = this.mediaCodec.getOutputBuffers();
                this.bufferInfo = new MediaCodec.BufferInfo();
                this.mediaMuxer = new MediaMuxer(this.outputPath, 0);
                this.totalBytesRead = 0;
                this.presentationTimeUs = 0.0d;
                return;
            } catch (IOException e16) {
                LogUtils.e(TAG, "Exception while initializing PCMEncoder", e16, new Object[0]);
                return;
            }
        }
        throw new IllegalStateException("The output path must be set first!");
    }

    public void setOutputPath(String str) {
        this.outputPath = str;
    }

    public void stop() {
        LogUtils.d(TAG, "Stopping PCMEncoder");
        handleEndOfStream();
        try {
            MediaCodec mediaCodec = this.mediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mediaCodec.release();
            }
            MediaMuxer mediaMuxer = this.mediaMuxer;
            if (mediaMuxer != null) {
                mediaMuxer.stop();
                this.mediaMuxer.release();
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, "Stop audio mediaCodec & mediaMuxer ERROR: " + e16.getMessage());
        }
    }
}
