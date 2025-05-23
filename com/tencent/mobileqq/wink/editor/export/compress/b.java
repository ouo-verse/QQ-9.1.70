package com.tencent.mobileqq.wink.editor.export.compress;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {
    private static int a(MediaExtractor mediaExtractor) {
        int sampleTrackIndex = mediaExtractor.getSampleTrackIndex();
        if (sampleTrackIndex >= 0) {
            return mediaExtractor.getTrackFormat(sampleTrackIndex).getInteger("sample-rate");
        }
        throw new IllegalArgumentException("Extractor must be pointing to a valid track.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer b(MediaCodec mediaCodec, MediaCodec mediaCodec2, MediaExtractor mediaExtractor, MediaExtractor mediaExtractor2, int i3, float f16, float f17) {
        long j3;
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        ByteBuffer allocate2 = ByteBuffer.allocate(i3);
        long j16 = -1;
        if (mediaCodec != null) {
            e(mediaCodec, mediaExtractor, allocate, f16);
            j3 = mediaExtractor.getSampleTime();
        } else {
            j3 = -1;
        }
        if (mediaCodec2 != null) {
            e(mediaCodec2, mediaExtractor2, allocate2, f17);
            j16 = mediaExtractor2.getSampleTime();
        }
        w53.b.a("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", " mainSampleTime = " + j3 + " newSampleTime = " + j16 + " reduce = " + (j16 - j3));
        int a16 = a(mediaExtractor);
        int a17 = a(mediaExtractor2);
        int min = Math.min(a16, a17);
        if (a16 != min && allocate.limit() != 0) {
            allocate = f(allocate, a16, min);
        }
        if (a17 != min && allocate2.limit() != 0) {
            allocate2 = f(allocate2, a17, min);
        }
        ByteBuffer allocate3 = ByteBuffer.allocate(Math.max(allocate.limit(), allocate2.limit()) * 2);
        c(allocate, allocate2, allocate3);
        return allocate3;
    }

    private static void c(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        byteBuffer.position(0);
        byteBuffer2.position(0);
        byteBuffer3.position(0);
        while (byteBuffer.remaining() >= 2 && byteBuffer2.remaining() >= 2) {
            byteBuffer3.putShort((short) Math.max(Math.min(byteBuffer.getShort() + byteBuffer2.getShort(), 32767), -32768));
        }
        while (byteBuffer.remaining() >= 2) {
            byteBuffer3.putShort(byteBuffer.getShort());
        }
        while (byteBuffer2.remaining() >= 2) {
            byteBuffer3.putShort(byteBuffer2.getShort());
        }
        byteBuffer3.limit(byteBuffer3.position());
        byteBuffer3.position(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(MediaCodec mediaCodec, ByteBuffer byteBuffer, long j3, MediaMuxer mediaMuxer, int i3) throws IOException {
        int i16;
        ByteBuffer inputBuffer;
        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer >= 0 && (inputBuffer = mediaCodec.getInputBuffer(dequeueInputBuffer)) != null) {
            inputBuffer.clear();
            if (byteBuffer.limit() <= inputBuffer.capacity()) {
                inputBuffer.put(byteBuffer);
                if (j3 >= 0) {
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.limit(), j3, 0);
                    w53.b.a("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", String.format("Queued input buffer. Size: %d, Time: %d", Integer.valueOf(byteBuffer.limit()), Long.valueOf(j3)));
                } else {
                    throw new IllegalArgumentException("Invalid presentation time: " + j3);
                }
            } else {
                throw new IllegalArgumentException("Input buffer size exceeds codec buffer capacity.");
            }
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
        while (dequeueOutputBuffer >= 0) {
            ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(dequeueOutputBuffer);
            if (outputBuffer != null && (i16 = bufferInfo.size) > 0) {
                w53.b.a("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", String.format("Writing encoded audio data. Size: %d, Time: %d, Offset: %d, Flags: %d", Integer.valueOf(i16), Long.valueOf(bufferInfo.presentationTimeUs), Integer.valueOf(bufferInfo.offset), Integer.valueOf(bufferInfo.flags)));
                mediaMuxer.writeSampleData(i3, outputBuffer, bufferInfo);
            } else {
                w53.b.g("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", "No audio data available for writing or size is zero");
            }
            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
            dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
        }
    }

    private static void e(MediaCodec mediaCodec, MediaExtractor mediaExtractor, ByteBuffer byteBuffer, float f16) {
        ByteBuffer inputBuffer;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        byteBuffer.clear();
        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer >= 0 && (inputBuffer = mediaCodec.getInputBuffer(dequeueInputBuffer)) != null) {
            int readSampleData = mediaExtractor.readSampleData(inputBuffer, 0);
            if (readSampleData > 0) {
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
            } else {
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            }
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
            if (dequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(dequeueOutputBuffer);
                if (outputBuffer != null && bufferInfo.size > 0) {
                    outputBuffer.position(bufferInfo.offset);
                    outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    i16 += bufferInfo.size;
                    byteBuffer.put(outputBuffer);
                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        w53.b.g("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", "processAudioDecoderBuffer end stream");
                        break;
                    }
                }
                i3 = 0;
            } else if (dequeueOutputBuffer == -1) {
                i3++;
                if (i3 > 10) {
                    w53.b.g("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", "Failed to dequeue input buffer after 10 attempts");
                    break;
                }
            } else if (dequeueOutputBuffer != -3 && dequeueOutputBuffer == -2) {
                w53.b.c("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", "processAudioDecoderBuffer INFO_OUTPUT_FORMAT_CHANGED" + mediaCodec.getOutputFormat());
            }
        }
        byteBuffer.limit(i16);
        byteBuffer.position(0);
    }

    private static ByteBuffer f(ByteBuffer byteBuffer, int i3, int i16) {
        int remaining = byteBuffer.remaining() / 2;
        byteBuffer.asShortBuffer().get(new short[remaining]);
        int i17 = (int) ((remaining * i16) / i3);
        short[] sArr = new short[i17];
        w53.b.c("WinkPublish-Export-WinkMediaCodecUtils WinkMixMusicUtils", "inputSampleCount = " + remaining + "outputSampleCount = " + i17);
        for (int i18 = 0; i18 < i17; i18++) {
            float f16 = (i18 * remaining) / i17;
            float floor = f16 - ((int) Math.floor(f16));
            sArr[i18] = (short) (((1.0f - floor) * r1[r3]) + (floor * r1[Math.min(r3 + 1, remaining - 1)]));
        }
        ByteBuffer allocate = ByteBuffer.allocate(i17 * 2);
        allocate.asShortBuffer().put(sArr);
        return allocate;
    }
}
