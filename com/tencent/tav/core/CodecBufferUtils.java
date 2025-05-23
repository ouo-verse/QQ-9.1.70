package com.tencent.tav.core;

import android.media.MediaCodec;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CodecBufferUtils {
    private static final String TAG = "BufferUtils";
    private static final long WAIT_TRANSIENT_MS = 20;

    public static int dequeueInputBuffer(MediaCodec mediaCodec) {
        try {
            return mediaCodec.dequeueInputBuffer(1000L);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "dequeueInputBuffer e = ", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                loggerCodecException(codecException);
                if (codecException.isTransient()) {
                    waitTime(20L);
                    return dequeueInputBuffer(mediaCodec);
                }
            }
            throw e16;
        }
    }

    public static int dequeueOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) {
        try {
            return mediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
        } catch (Exception e16) {
            Logger.e(TAG, "dequeueOutputBuffer e = ", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                loggerCodecException(codecException);
                if (codecException.isTransient()) {
                    waitTime(20L);
                    return dequeueOutputBuffer(mediaCodec, bufferInfo);
                }
            }
            throw e16;
        }
    }

    public static ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i3) {
        try {
            return DecoderUtils.getInputBuffer(mediaCodec, i3);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "getInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                loggerCodecException(codecException);
                if (codecException.isTransient()) {
                    waitTime(20L);
                    return getInputBuffer(mediaCodec, i3);
                }
            }
            throw e16;
        }
    }

    public static ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i3) {
        try {
            return DecoderUtils.getOutputBuffer(mediaCodec, i3);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "getOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                loggerCodecException(codecException);
                if (codecException.isTransient()) {
                    waitTime(20L);
                    return getOutputBuffer(mediaCodec, i3);
                }
            }
            throw e16;
        }
    }

    public static void loggerCodecException(MediaCodec.CodecException codecException) {
        Logger.e(TAG, "CodecException - isTransient = " + codecException.isTransient() + " , isRecoverable = " + codecException.isRecoverable() + " , errorCode = " + codecException.getErrorCode());
    }

    public static void queueInputBuffer(MediaCodec mediaCodec, int i3, int i16, int i17, long j3, int i18) {
        try {
            mediaCodec.queueInputBuffer(i3, i16, i17, j3, i18);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "queueInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                loggerCodecException(codecException);
                if (codecException.isTransient()) {
                    waitTime(20L);
                    queueInputBuffer(mediaCodec, i3, i16, i17, j3, i18);
                }
            }
            throw e16;
        }
    }

    public static void releaseOutputBuffer(MediaCodec mediaCodec, int i3, boolean z16) {
        try {
            mediaCodec.releaseOutputBuffer(i3, z16);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "releaseOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) e16;
                loggerCodecException(codecException);
                if (codecException.isTransient()) {
                    waitTime(20L);
                    releaseOutputBuffer(mediaCodec, i3, z16);
                }
            }
            throw e16;
        }
    }

    public static void waitTime(long j3) {
        try {
            CodecBufferUtils.class.wait(j3);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }
}
