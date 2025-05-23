package com.tencent.ttpic.voicechanger.common.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@TargetApi(18)
/* loaded from: classes27.dex */
public class PcmEncoder {
    private static final int CODEC_TIMEOUT = 5000;
    private static final String COMPRESSED_AUDIO_FILE_MIME_TYPE = "audio/mp4a-latm";
    private static final String TAG = "PcmEncoder";
    private int audioTrackId;
    private int bitrate;
    private MediaCodec.BufferInfo bufferInfo;
    private int channelCount;
    private ByteBuffer[] codecInputBuffers;
    private ByteBuffer[] codecOutputBuffers;
    private MediaCodec mediaCodec;
    private MediaFormat mediaFormat;
    private MediaMuxer mediaMuxer;
    private String outputPath;
    private double presentationTimeUs;
    private int sampleRate;
    private int totalBytesRead;

    public PcmEncoder(int i3, int i16, int i17) {
        this.bitrate = i3;
        this.sampleRate = i16;
        this.channelCount = i17;
    }

    private void handleEndOfStream() {
        this.mediaCodec.queueInputBuffer(this.mediaCodec.dequeueInputBuffer(5000L), 0, 0, (long) this.presentationTimeUs, 4);
        writeOutputs();
    }

    private boolean isKitkat() {
        if (DeviceInstance.getSDKVersion() >= 19) {
            return true;
        }
        return false;
    }

    private boolean isLollipop() {
        if (DeviceInstance.getSDKVersion() >= 21) {
            return true;
        }
        return false;
    }

    private void writeOutputs() {
        ByteBuffer outputBuffer;
        int i3 = 0;
        while (i3 != -1) {
            i3 = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 5000L);
            if (i3 >= 0) {
                if (!isLollipop()) {
                    outputBuffer = this.codecOutputBuffers[i3];
                } else {
                    outputBuffer = this.mediaCodec.getOutputBuffer(i3);
                }
                if (isKitkat()) {
                    outputBuffer.position(this.bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
                    outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                }
                MediaCodec.BufferInfo bufferInfo2 = this.bufferInfo;
                if ((bufferInfo2.flags & 2) != 0 && bufferInfo2.size != 0) {
                    this.mediaCodec.releaseOutputBuffer(i3, false);
                } else {
                    this.mediaMuxer.writeSampleData(this.audioTrackId, this.codecOutputBuffers[i3], bufferInfo2);
                    this.mediaCodec.releaseOutputBuffer(i3, false);
                }
            } else if (i3 == -2) {
                MediaFormat outputFormat = this.mediaCodec.getOutputFormat();
                this.mediaFormat = outputFormat;
                this.audioTrackId = this.mediaMuxer.addTrack(outputFormat);
                this.mediaMuxer.start();
            }
        }
    }

    public void encode(InputStream inputStream, int i3) throws IOException {
        ByteBuffer inputBuffer;
        LogUtils.d(TAG, "Starting encoding of InputStream");
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = new byte[i3 * 2];
        boolean z16 = true;
        boolean z17 = false;
        while (!z17) {
            int i16 = 0;
            int i17 = 0;
            while (i16 != -1 && z16 && i17 <= i3 * 50) {
                i16 = this.mediaCodec.dequeueInputBuffer(5000L);
                if (i16 >= 0) {
                    if (!isLollipop()) {
                        inputBuffer = this.codecInputBuffers[i16];
                    } else {
                        inputBuffer = this.mediaCodec.getInputBuffer(i16);
                    }
                    inputBuffer.clear();
                    int read = inputStream.read(bArr, 0, inputBuffer.limit());
                    if (read == -1) {
                        this.mediaCodec.queueInputBuffer(i16, 0, 0, (long) this.presentationTimeUs, 0);
                        z17 = true;
                        z16 = false;
                    } else {
                        this.totalBytesRead += read;
                        i17 += read;
                        inputBuffer.put(bArr, 0, read);
                        this.mediaCodec.queueInputBuffer(i16, 0, read, (long) this.presentationTimeUs, 0);
                        this.presentationTimeUs = ((this.totalBytesRead / 2) * 1000000) / i3;
                    }
                }
            }
            writeOutputs();
        }
        inputStream.close();
        String str = TAG;
        LogUtils.d(str, "Finished encoding of InputStream");
        LogUtils.d(str, "pcm 2 m4a: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public void prepare() {
        if (this.outputPath != null) {
            try {
                MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.sampleRate, this.channelCount);
                this.mediaFormat = createAudioFormat;
                createAudioFormat.setInteger("aac-profile", 2);
                this.mediaFormat.setInteger("bitrate", this.bitrate);
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
        this.mediaCodec.stop();
        this.mediaCodec.release();
        this.mediaMuxer.stop();
        this.mediaMuxer.release();
    }
}
