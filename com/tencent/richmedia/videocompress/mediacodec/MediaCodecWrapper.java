package com.tencent.richmedia.videocompress.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MediaCodecWrapper {
    public static int DEC_CODEC = 0;
    public static int ENC_CODEC = 1;
    private static String TAG = "AndroidCodec";
    public static int TIMEOUT_US = 33000;
    protected static Method getInputBuffer21 = null;
    protected static Method getOutputBuffer21 = null;
    protected static Method getOutputFormat21 = null;
    public static boolean invokeAPILevel21 = true;
    protected ByteBuffer[] inputBuffers;
    protected int mCodecType = DEC_CODEC;
    protected MediaCodec mMediaCodec;
    protected MediaFormat mOutputFormat;
    protected ByteBuffer[] outputBuffers;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class BufferData {
        public ByteBuffer buffer;
        public MediaFormat format;
        public int index;
        public MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
        public boolean success = true;
    }

    public MediaCodecWrapper(String str) {
        if (!TextUtils.isEmpty(str)) {
            TAG = str + "_AndroidCodec";
        }
        invoke21Apis();
    }

    public static MediaCodecInfo getCodecInfo(String str) {
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (codecInfoAt.getName().equalsIgnoreCase(str)) {
                    return codecInfoAt;
                }
            }
            return null;
        } catch (Throwable th5) {
            ConvertLog.e(TAG, 1, "getCodecInfo error", th5);
            return null;
        }
    }

    public static void invoke21Apis() {
        try {
            if (getInputBuffer21 == null) {
                getInputBuffer21 = MediaCodec.class.getMethod("getInputBuffer", Integer.TYPE);
            }
            if (getOutputBuffer21 == null) {
                getOutputBuffer21 = MediaCodec.class.getMethod("getOutputBuffer", Integer.TYPE);
            }
            if (getOutputFormat21 == null) {
                getOutputFormat21 = MediaCodec.class.getMethod("getOutputFormat", Integer.TYPE);
            }
        } catch (Exception unused) {
            getInputBuffer21 = null;
            getOutputBuffer21 = null;
            getOutputFormat21 = null;
            invokeAPILevel21 = false;
        }
    }

    public synchronized BufferData dequeueOutputBuffer() {
        if (this.mMediaCodec == null) {
            return null;
        }
        BufferData bufferData = new BufferData();
        int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferData.info, TIMEOUT_US);
        if (dequeueOutputBuffer != -3) {
            if (dequeueOutputBuffer != -2) {
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer >= 0) {
                        if (ConvertLog.isDevLevel()) {
                            ConvertLog.d(TAG, 3, "dequeueOutputBuffer ok, index = " + dequeueOutputBuffer + ", BufferInfo[flags = " + bufferData.info.flags + ", offset=" + bufferData.info.offset + ", size= " + bufferData.info.size + ", TimeUs=" + bufferData.info.presentationTimeUs + "]");
                        }
                        bufferData.index = dequeueOutputBuffer;
                        try {
                            bufferData.buffer = (ByteBuffer) getOutputBuffer21.invoke(this.mMediaCodec, Integer.valueOf(dequeueOutputBuffer));
                            bufferData.format = (MediaFormat) getOutputFormat21.invoke(this.mMediaCodec, Integer.valueOf(dequeueOutputBuffer));
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            bufferData.success = false;
                        }
                    }
                } else {
                    if (ConvertLog.isColorLevel()) {
                        ConvertLog.e(TAG, 2, "dequeueOutputBuffer timed out!");
                    }
                    bufferData.index = -1;
                    return bufferData;
                }
            } else {
                bufferData.index = -2;
                MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                this.mOutputFormat = outputFormat;
                bufferData.format = outputFormat;
                if (this.mCodecType == DEC_CODEC) {
                    if (outputFormat.containsKey("color-format")) {
                        int integer = this.mOutputFormat.getInteger("color-format");
                        if (ConvertLog.isColorLevel()) {
                            ConvertLog.e(TAG, 2, "New color format " + integer + "[0x" + Integer.toHexString(integer) + "]");
                        }
                    }
                } else if (ConvertLog.isColorLevel()) {
                    ConvertLog.e(TAG, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
                }
            }
        } else {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.e(TAG, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
            }
            this.outputBuffers = this.mMediaCodec.getOutputBuffers();
            bufferData.index = -3;
        }
        return bufferData;
    }

    public MediaCodec getInnerMediaCodec() {
        return this.mMediaCodec;
    }

    public BufferData getInputBuffer() {
        if (this.mMediaCodec == null) {
            return null;
        }
        BufferData bufferData = new BufferData();
        int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(TIMEOUT_US);
        if (dequeueInputBuffer < 0) {
            return null;
        }
        synchronized (this) {
            bufferData.index = dequeueInputBuffer;
            try {
                bufferData.buffer = (ByteBuffer) getInputBuffer21.invoke(this.mMediaCodec, Integer.valueOf(dequeueInputBuffer));
            } catch (Exception e16) {
                e16.printStackTrace();
                bufferData.success = false;
            }
        }
        return bufferData;
    }

    public void init(MediaFormat mediaFormat, String str, Surface surface) {
        int i3;
        MediaCodecInfo codecInfo = getCodecInfo(str);
        if (codecInfo == null || !codecInfo.isEncoder()) {
            i3 = 0;
        } else {
            this.mCodecType = ENC_CODEC;
            i3 = 1;
        }
        try {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            this.mMediaCodec = createByCodecName;
            createByCodecName.configure(mediaFormat, surface, (MediaCrypto) null, i3);
        } catch (Exception e16) {
            ConvertLog.e(TAG, 1, "init codec error", e16);
        }
    }

    public synchronized void queueInputBuffer(int i3, int i16, long j3, int i17) {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.queueInputBuffer(i3, 0, i16, j3, i17);
        } catch (Exception e16) {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.e(TAG, 1, "queueInputBuffer exception, index[" + i3 + "], sampleSize[" + i16 + "], timestamp[" + j3 + "], flags[" + i17 + "]", e16);
            }
        }
    }

    public synchronized void release() {
        this.inputBuffers = null;
        this.outputBuffers = null;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mMediaCodec = null;
        }
    }

    public synchronized void releaseOutputBuffer(int i3) {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return;
        }
        mediaCodec.releaseOutputBuffer(i3, false);
    }

    public void start() {
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.start();
            }
        } catch (Exception e16) {
            ConvertLog.e(TAG, 1, "start codec error", e16);
        }
    }

    public void stop() {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.stop();
        }
    }

    public void init(MediaFormat mediaFormat, int i3) {
        this.mCodecType = i3;
        try {
            String string = mediaFormat.getString("mime");
            if (string != null) {
                if (i3 == DEC_CODEC) {
                    this.mMediaCodec = MediaCodec.createDecoderByType(string);
                } else {
                    this.mMediaCodec = MediaCodec.createEncoderByType(string);
                }
                this.mMediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, i3 == ENC_CODEC ? 1 : 0);
            }
        } catch (Exception e16) {
            ConvertLog.e(TAG, 1, "init codec error", e16);
        }
    }
}
