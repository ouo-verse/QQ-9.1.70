package com.epicgames.ue4;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AudioDecoder {
    private byte[] mAacSpecificConfig;
    private int mBitsPerSample;
    private int mChannelCount;
    private int mSampleRate;
    private MediaCodec mAudioCodec = null;
    private boolean bIsInitialized = false;

    private boolean CreateCodec() {
        synchronized (this) {
            try {
                try {
                    this.mAudioCodec = MediaCodec.createDecoderByType("audio/mp4a-latm");
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.mSampleRate, this.mChannelCount);
                    createAudioFormat.setInteger("bitrate", this.mBitsPerSample);
                    createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{RegisterType.REFERENCE, RegisterType.REFERENCE}));
                    this.mAudioCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
                    this.mAudioCodec.start();
                    this.bIsInitialized = true;
                } catch (Exception e16) {
                    UE4.Log.warn("Android Audio Decoder: CreateCodec failed!");
                    e16.printStackTrace();
                    return false;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    public byte[] DecodeAudio(byte[] bArr) {
        byte[] bArr2;
        synchronized (this) {
            MediaCodec mediaCodec = this.mAudioCodec;
            if (mediaCodec != null) {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1L);
                if (dequeueInputBuffer >= 0) {
                    int length = bArr.length;
                    ByteBuffer inputBuffer = this.mAudioCodec.getInputBuffer(dequeueInputBuffer);
                    inputBuffer.clear();
                    inputBuffer.put(bArr);
                    inputBuffer.clear();
                    this.mAudioCodec.queueInputBuffer(dequeueInputBuffer, 0, length, 0L, 0);
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.mAudioCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer != -2) {
                        if (dequeueOutputBuffer != -1) {
                            ByteBuffer outputBuffer = this.mAudioCodec.getOutputBuffer(dequeueOutputBuffer);
                            bArr2 = new byte[bufferInfo.size];
                            outputBuffer.get(bArr2);
                            outputBuffer.clear();
                            this.mAudioCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                        } else {
                            UE4.Log.debug("Android Audio Decoder: dequeueOutputBuffer timed out!");
                        }
                    } else {
                        UE4.Log.debug("Android Audio Decoder: New format " + this.mAudioCodec.getOutputFormat());
                    }
                } else {
                    UE4.Log.debug("Android Audio Decoder: INFO_OUTPUT_BUFFERS_CHANGED");
                }
            }
            bArr2 = null;
        }
        return bArr2;
    }

    public void release() {
        resetCodec();
    }

    public void resetCodec() {
        synchronized (this) {
            MediaCodec mediaCodec = this.mAudioCodec;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    this.mAudioCodec.release();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public boolean updateConfig(int i3, int i16, int i17, byte[] bArr) {
        boolean CreateCodec;
        synchronized (this) {
            UE4.Log.warn("Android Audio Decoder: updateConfig channelCount:" + i16);
            this.bIsInitialized = false;
            this.mSampleRate = i3;
            this.mChannelCount = i16;
            this.mBitsPerSample = i17;
            this.mAacSpecificConfig = bArr;
            resetCodec();
            CreateCodec = CreateCodec();
        }
        return CreateCodec;
    }
}
