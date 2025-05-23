package org.tencwebrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Surface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EncodedImage;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.VideoDecoder;
import org.tencwebrtc.VideoFrame;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class AndroidVideoDecoder implements VideoDecoder, VideoSink {
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final String TAG = "AndroidVideoDecoder";
    private static boolean decodeReleased;

    @Nullable
    private static Surface displaySurface;
    private static int encodeNumber;
    private static long frameHeight;
    private static long frameWidth;
    private static long framesDecoded;
    public static VideoDecoder.DecodeCallback mCb;
    private static boolean skipRender;
    private static long totalDecodeTime;

    @Nullable
    private VideoDecoder.Callback callback;

    @Nullable
    private MediaCodecWrapper codec;
    private final String codecName;
    private final VideoCodecType codecType;
    private int colorFormat;
    private ThreadUtils.ThreadChecker decoderThreadChecker;
    VideoFrame.I420Buffer frameBuffer_;
    private final BlockingDeque<FrameInfo> frameInfos;
    private boolean hasDecodedFirstFrame;
    private int height;
    private boolean isFirstFrameDecoded;
    private boolean keyFrameRequired;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private String notusesystemtimeProp;

    @Nullable
    private File notusesystemtimestampFile;

    @Nullable
    private Thread outputThread;
    private ThreadUtils.ThreadChecker outputThreadChecker;
    private int prev_orientation;
    private int previousHeight;
    private int previousWidth;
    private int ref_frameBuffer_;
    private int ref_sr_frameBuffer_;

    @Nullable
    private DecodedTextureMetadata renderedTextureMetadata;
    private volatile boolean running;

    @Nullable
    private final EglBase.Context sharedContext;

    @Nullable
    private volatile Exception shutdownException;
    private int sliceHeight;
    VideoFrame.I420Buffer sr_frameBuffer_;
    private int stride;

    @Nullable
    private Surface surface;

    @Nullable
    private SurfaceTextureHelper surfaceTextureHelper;
    private boolean useSystemTimestamp;
    private int width;
    private final int SEI_LENGTH = 48;
    private final int SEI_EXTENDED_LENGTH = 64;
    private final int UUID_LENGTH = 16;
    private final int DECODE_LENGTH = 16;
    private int sei_length = 48;
    private int uuid_length = 16;
    private int decode_length = 16;
    private final boolean isCustomizeDecoder = false;
    private final Object dimensionLock = new Object();
    private final Object renderedTextureMetadataLock = new Object();
    private final boolean is_config_sr_mem_complex_ = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DecodedTextureMetadata {
        final Integer decodeTimeMs;
        final long presentationTimestampUs;
        final byte[] sei;

        DecodedTextureMetadata(long j3, Integer num, byte[] bArr) {
            this.presentationTimestampUs = j3;
            this.decodeTimeMs = num;
            this.sei = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class FrameInfo {
        final long captureTimeUs;
        final long decodeStartTimeMs;
        final int rotation;
        final byte[] sei;

        FrameInfo(long j3, long j16, int i3, byte[] bArr) {
            this.decodeStartTimeMs = j3;
            this.captureTimeUs = j16;
            this.rotation = i3;
            this.sei = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidVideoDecoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, int i3, @Nullable EglBase.Context context) {
        if (isSupportedColorFormat(i3)) {
            Logging.d(TAG, "ctor name: " + str + " type: " + videoCodecType + " color format: " + i3 + " context: " + context);
            this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
            this.codecName = str;
            this.codecType = videoCodecType;
            this.colorFormat = i3;
            this.sharedContext = context;
            this.frameInfos = new LinkedBlockingDeque();
            this.previousHeight = 0;
            this.previousWidth = 0;
            this.useSystemTimestamp = false;
            return;
        }
        throw new IllegalArgumentException("Unsupported color format: " + i3);
    }

    @TargetApi(18)
    private void configureMaxResolution(MediaFormat mediaFormat) {
        if ("OMX.amlogic.hevc.decoder.awesome".equalsIgnoreCase(this.codecName)) {
            mediaFormat.setInteger("max-width", 3840);
            mediaFormat.setInteger("max-height", 2160);
            Logging.d(TAG, "OMX.amlogic.hevc.decoder.awesome, max widthxheight=3840x2160");
        }
    }

    private VideoFrame.Buffer copyI420Buffer(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18) {
        int i19;
        if (i3 % 2 == 0) {
            int i26 = (i17 + 1) / 2;
            int i27 = i16 % 2;
            if (i27 == 0) {
                i19 = (i18 + 1) / 2;
            } else {
                i19 = i18 / 2;
            }
            int i28 = i19;
            int i29 = i3 / 2;
            int i36 = (i3 * i16) + 0;
            int i37 = i29 * i28;
            int i38 = i36 + ((i29 * i16) / 2);
            int i39 = i38 + i37;
            VideoFrame.I420Buffer allocateI420Buffer = allocateI420Buffer(i17, i18);
            byteBuffer.limit((i3 * i18) + 0);
            byteBuffer.position(0);
            copyPlane(byteBuffer.slice(), i3, allocateI420Buffer.getDataY(), allocateI420Buffer.getStrideY(), i17, i18);
            byteBuffer.limit(i36 + i37);
            byteBuffer.position(i36);
            copyPlane(byteBuffer.slice(), i29, allocateI420Buffer.getDataU(), allocateI420Buffer.getStrideU(), i26, i28);
            if (i27 == 1) {
                byteBuffer.position(i36 + ((i28 - 1) * i29));
                ByteBuffer dataU = allocateI420Buffer.getDataU();
                dataU.position(allocateI420Buffer.getStrideU() * i28);
                dataU.put(byteBuffer);
            }
            byteBuffer.limit(i39);
            byteBuffer.position(i38);
            copyPlane(byteBuffer.slice(), i29, allocateI420Buffer.getDataV(), allocateI420Buffer.getStrideV(), i26, i28);
            if (i27 == 1) {
                byteBuffer.position(i38 + (i29 * (i28 - 1)));
                ByteBuffer dataV = allocateI420Buffer.getDataV();
                dataV.position(allocateI420Buffer.getStrideV() * i28);
                dataV.put(byteBuffer);
            }
            return allocateI420Buffer;
        }
        throw new AssertionError("Stride is not divisible by two: " + i3);
    }

    private VideoFrame.Buffer copyI420Buffer_SR(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18) {
        int i19;
        boolean z16;
        boolean z17;
        boolean z18;
        int i26;
        int i27;
        int i28;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        if (i3 % 2 == 0) {
            int i29 = (i17 + 1) / 2;
            int i36 = i16 % 2;
            if (i36 == 0) {
                i19 = (i18 + 1) / 2;
            } else {
                i19 = i18 / 2;
            }
            int i37 = i19;
            int i38 = i3 / 2;
            int i39 = (i3 * i18) + 0;
            int i46 = (i3 * i16) + 0;
            int i47 = i38 * i37;
            int i48 = i46 + i47;
            int i49 = i46 + ((i38 * i16) / 2);
            int i56 = i49 + i47;
            if (VideoSR.getWidth() == i17 && VideoSR.getHeight() == i18) {
                z17 = true;
            } else {
                if (VideoSR.srServiceReinit("AVDecoder", i17, i18) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z16;
            }
            if (z17 && i3 == i17) {
                z18 = false;
            } else {
                z18 = true;
            }
            VideoFrame.I420Buffer allocateI420Buffer = allocateI420Buffer(i17, i18);
            byteBuffer.limit(i39);
            byteBuffer.position(0);
            ByteBuffer slice = byteBuffer.slice();
            if (z18) {
                i26 = i56;
                i27 = i49;
                i28 = i48;
                copyPlane(slice, i3, allocateI420Buffer.getDataY(), i17, i17, i18);
            } else {
                i26 = i56;
                i27 = i49;
                i28 = i48;
            }
            byteBuffer.limit(i28);
            byteBuffer.position(i46);
            ByteBuffer slice2 = byteBuffer.slice();
            if (z18) {
                copyPlane(slice2, i38, allocateI420Buffer.getDataU(), i29, i29, i37);
            }
            if (i36 == 1) {
                byteBuffer.position(i46 + ((i37 - 1) * i38));
                if (z18) {
                    ByteBuffer dataU = allocateI420Buffer.getDataU();
                    dataU.position(i29 * i37);
                    dataU.put(byteBuffer);
                }
            }
            byteBuffer.limit(i26);
            int i57 = i27;
            byteBuffer.position(i57);
            ByteBuffer slice3 = byteBuffer.slice();
            if (z18) {
                copyPlane(slice3, i38, allocateI420Buffer.getDataV(), i29, i29, i37);
            }
            if (i36 == 1) {
                byteBuffer.position(i57 + (i38 * (i37 - 1)));
                if (z18) {
                    ByteBuffer dataV = allocateI420Buffer.getDataV();
                    dataV.position(i29 * i37);
                    dataV.put(byteBuffer);
                }
            }
            if (!z17) {
                return allocateI420Buffer;
            }
            if (z18) {
                byteBuffer3 = allocateI420Buffer.getDataY();
                byteBuffer2 = allocateI420Buffer.getDataU();
                byteBuffer4 = allocateI420Buffer.getDataV();
            } else {
                byteBuffer2 = slice2;
                byteBuffer3 = slice;
                byteBuffer4 = slice3;
            }
            VideoFrame.I420Buffer allocateI420Buffer2 = allocateI420Buffer(i17, i18, VideoSR.getScale());
            int srServicePredictSlice = VideoSR.srServicePredictSlice(byteBuffer3, byteBuffer2, byteBuffer4, allocateI420Buffer2.getDataY(), allocateI420Buffer2.getDataU(), allocateI420Buffer2.getDataV(), i18, i17);
            if (srServicePredictSlice == 0) {
                allocateI420Buffer.release();
                return allocateI420Buffer2;
            }
            allocateI420Buffer2.release();
            Logging.e(TAG, "ServicePredictSlice errCode: " + srServicePredictSlice);
            return allocateI420Buffer;
        }
        throw new AssertionError("Stride is not divisible by two: " + i3);
    }

    private VideoFrame.Buffer copyI420Buffer_SR_OneBuffer(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18) {
        int i19;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i26;
        int i27;
        int i28;
        String str;
        int i29;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        String str2;
        if (i3 % 2 == 0) {
            int i36 = (i17 + 1) / 2;
            int i37 = i16 % 2;
            if (i37 == 0) {
                i19 = (i18 + 1) / 2;
            } else {
                i19 = i18 / 2;
            }
            int i38 = i19;
            int i39 = i3 / 2;
            int i46 = (i3 * i18) + 0;
            int i47 = (i3 * i16) + 0;
            int i48 = i39 * i38;
            int i49 = i47 + i48;
            int i56 = i47 + ((i39 * i16) / 2);
            int i57 = i56 + i48;
            if (VideoSR.getWidth() == i17 && VideoSR.getHeight() == i18) {
                z17 = true;
                z18 = false;
            } else {
                if (VideoSR.srServiceReinit("AVDecoder", i17, i18) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 = z16;
                z18 = true;
            }
            if (z17 && i3 == i17) {
                z19 = false;
            } else {
                z19 = true;
            }
            VideoFrame.I420Buffer i420Buffer = this.frameBuffer_;
            if (i420Buffer != null && this.ref_frameBuffer_ != 0) {
                if (z18) {
                    i420Buffer.release();
                    this.ref_frameBuffer_--;
                    Logging.d(TAG, "VideoSR copyI420Buffer_SR_OneBuffer reinit buffer.release ref_frameBuffer=" + this.ref_frameBuffer_);
                    if (this.ref_frameBuffer_ < 0) {
                        this.ref_frameBuffer_ = 0;
                    }
                    this.frameBuffer_ = allocateI420Buffer(i17, i18);
                    this.ref_frameBuffer_++;
                    Logging.d(TAG, "VideoSR copyI420Buffer_SR_OneBuffer reinit alloc ref_frameBuffer=" + this.ref_frameBuffer_);
                }
            } else {
                this.frameBuffer_ = allocateI420Buffer(i17, i18);
                this.ref_frameBuffer_++;
                Logging.d(TAG, "VideoSR copyI420Buffer_SR_OneBuffer alloc buffer ref_frameBuffer=" + this.ref_frameBuffer_);
            }
            byteBuffer.limit(i46);
            byteBuffer.position(0);
            ByteBuffer slice = byteBuffer.slice();
            if (z19) {
                ByteBuffer dataY = this.frameBuffer_.getDataY();
                i28 = i57;
                str = TAG;
                i29 = i49;
                i26 = i56;
                i27 = i47;
                copyPlane(slice, i3, dataY, i17, i17, i18);
            } else {
                i26 = i56;
                i27 = i47;
                i28 = i57;
                str = TAG;
                i29 = i49;
            }
            byteBuffer.limit(i29);
            byteBuffer.position(i27);
            ByteBuffer slice2 = byteBuffer.slice();
            if (z19) {
                copyPlane(slice2, i39, this.frameBuffer_.getDataU(), i36, i36, i38);
            }
            if (i37 == 1) {
                byteBuffer.position(i27 + ((i38 - 1) * i39));
                if (z19) {
                    ByteBuffer dataU = this.frameBuffer_.getDataU();
                    dataU.position(i36 * i38);
                    dataU.put(byteBuffer);
                }
            }
            byteBuffer.limit(i28);
            int i58 = i26;
            byteBuffer.position(i58);
            ByteBuffer slice3 = byteBuffer.slice();
            if (z19) {
                copyPlane(slice3, i39, this.frameBuffer_.getDataV(), i36, i36, i38);
            }
            if (i37 == 1) {
                byteBuffer.position(i58 + (i39 * (i38 - 1)));
                if (z19) {
                    ByteBuffer dataV = this.frameBuffer_.getDataV();
                    dataV.position(i36 * i38);
                    dataV.put(byteBuffer);
                }
            }
            if (!z17) {
                return this.frameBuffer_;
            }
            if (z19) {
                byteBuffer4 = this.frameBuffer_.getDataY();
                byteBuffer2 = this.frameBuffer_.getDataU();
                byteBuffer3 = this.frameBuffer_.getDataV();
            } else {
                byteBuffer2 = slice2;
                byteBuffer3 = slice3;
                byteBuffer4 = slice;
            }
            VideoFrame.I420Buffer i420Buffer2 = this.sr_frameBuffer_;
            if (i420Buffer2 != null && this.ref_sr_frameBuffer_ != 0) {
                if (z18) {
                    i420Buffer2.release();
                    this.ref_sr_frameBuffer_--;
                    str2 = str;
                    Logging.d(str2, "VideoSR copyI420Buffer_SR_OneBuffer reinit buffer.release ref_sr_frameBuffer_=" + this.ref_sr_frameBuffer_);
                    if (this.ref_sr_frameBuffer_ < 0) {
                        this.ref_sr_frameBuffer_ = 0;
                    }
                    this.sr_frameBuffer_ = allocateI420Buffer(i17, i18, VideoSR.getScale());
                    this.ref_sr_frameBuffer_++;
                    Logging.d(str2, "VideoSR copyI420Buffer_SR_OneBuffer reinit alloc ref_sr_frameBuffer_=" + this.ref_sr_frameBuffer_);
                } else {
                    str2 = str;
                }
            } else {
                str2 = str;
                this.sr_frameBuffer_ = allocateI420Buffer(i17, i18, VideoSR.getScale());
                this.ref_sr_frameBuffer_++;
                Logging.d(str2, "VideoSR copyI420Buffer_SR_OneBuffer alloc sr_buffer ref_sr_frameBuffer_=" + this.ref_sr_frameBuffer_);
            }
            String str3 = str2;
            int srServicePredictSlice = VideoSR.srServicePredictSlice(byteBuffer4, byteBuffer2, byteBuffer3, this.sr_frameBuffer_.getDataY(), this.sr_frameBuffer_.getDataU(), this.sr_frameBuffer_.getDataV(), i18, i17);
            if (srServicePredictSlice == 0) {
                return this.sr_frameBuffer_;
            }
            Logging.e(str3, "ServicePredictSlice errCode: " + srServicePredictSlice);
            return this.frameBuffer_;
        }
        throw new AssertionError("Stride is not divisible by two: " + i3);
    }

    private VideoFrame.Buffer copyNV12ToI420Buffer(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18) {
        return new NV12Buffer(i17, i18, i3, i16, byteBuffer, null).toI420();
    }

    private VideoFrame.Buffer copyNV12ToI420Buffer_SR(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18) {
        VideoFrame.I420Buffer i420 = new NV12Buffer(i17, i18, i3, i16, byteBuffer, null).toI420();
        boolean z16 = true;
        if ((VideoSR.getWidth() != i17 || VideoSR.getHeight() != i18) && VideoSR.srServiceReinit("AVDecoder", i17, i18) != 0) {
            z16 = false;
        }
        if (!z16) {
            return i420;
        }
        VideoFrame.I420Buffer allocateI420Buffer = allocateI420Buffer(i17, i18, VideoSR.getScale());
        int srServicePredictSlice = VideoSR.srServicePredictSlice(i420.getDataY(), i420.getDataU(), i420.getDataV(), allocateI420Buffer.getDataY(), allocateI420Buffer.getDataU(), allocateI420Buffer.getDataV(), i18, i17);
        if (srServicePredictSlice == 0) {
            i420.release();
            return allocateI420Buffer;
        }
        allocateI420Buffer.release();
        Logging.e(TAG, "NV12 ServicePredictSlice errCode: " + srServicePredictSlice);
        return i420;
    }

    private VideoFrame.Buffer copyNV12ToI420Buffer_SR_OneBuffer(ByteBuffer byteBuffer, int i3, int i16, int i17, int i18) {
        VideoFrame.I420Buffer i420 = new NV12Buffer(i17, i18, i3, i16, byteBuffer, null).toI420();
        boolean z16 = true;
        if ((VideoSR.getWidth() != i17 || VideoSR.getHeight() != i18) && VideoSR.srServiceReinit("AVDecoder", i17, i18) != 0) {
            z16 = false;
        }
        if (!z16) {
            return i420;
        }
        VideoFrame.I420Buffer allocateI420Buffer = allocateI420Buffer(i17, i18, VideoSR.getScale());
        int srServicePredictSlice = VideoSR.srServicePredictSlice(i420.getDataY(), i420.getDataU(), i420.getDataV(), allocateI420Buffer.getDataY(), allocateI420Buffer.getDataU(), allocateI420Buffer.getDataV(), i18, i17);
        if (srServicePredictSlice == 0) {
            i420.release();
            return allocateI420Buffer;
        }
        allocateI420Buffer.release();
        Logging.e(TAG, "NV12 ServicePredictSlice errCode: " + srServicePredictSlice);
        return i420;
    }

    private Thread createOutputThread() {
        return new BaseThread("AndroidVideoDecoder.outputThread") { // from class: org.tencwebrtc.AndroidVideoDecoder.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                AndroidVideoDecoder.this.outputThreadChecker = new ThreadUtils.ThreadChecker();
                while (AndroidVideoDecoder.this.running) {
                    try {
                        if (AndroidVideoDecoder.skipRender) {
                            AndroidVideoDecoder.this.deliverDecodedFrameToDisplay();
                        } else {
                            AndroidVideoDecoder.this.deliverDecodedFrame();
                        }
                    } catch (Exception e16) {
                        Logging.v(AndroidVideoDecoder.TAG, "Failed to deliver decoded frame " + e16);
                    }
                }
                AndroidVideoDecoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    private void deliverByteFrame(int i3, MediaCodec.BufferInfo bufferInfo, int i16, Integer num, byte[] bArr) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        VideoFrame.Buffer copyNV12ToI420Buffer;
        synchronized (this.dimensionLock) {
            i17 = this.width;
            i18 = this.height;
            i19 = this.stride;
            i26 = this.sliceHeight;
        }
        int i28 = bufferInfo.size;
        if (i28 < ((i17 * i18) * 3) / 2) {
            Logging.e(TAG, "Insufficient output buffer size: " + bufferInfo.size);
            return;
        }
        if (i28 < ((i19 * i18) * 3) / 2 && i26 == i18 && i19 > i17) {
            i27 = (i28 * 2) / (i18 * 3);
        } else {
            i27 = i19;
        }
        ByteBuffer byteBuffer = this.codec.getOutputBuffers()[i3];
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        ByteBuffer slice = byteBuffer.slice();
        if (VideoSR.isInited() && !VideoSR.isPause()) {
            if (this.colorFormat == 19) {
                copyNV12ToI420Buffer = copyI420Buffer_SR(slice, i27, i26, i17, i18);
            } else {
                copyNV12ToI420Buffer = copyNV12ToI420Buffer_SR(slice, i27, i26, i17, i18);
            }
        } else if (this.colorFormat == 19) {
            copyNV12ToI420Buffer = copyI420Buffer(slice, i27, i26, i17, i18);
        } else {
            copyNV12ToI420Buffer = copyNV12ToI420Buffer(slice, i27, i26, i17, i18);
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            wrap.putShort((bArr.length + 38) - 48, (short) num.intValue());
            if (bArr.length >= 64) {
                wrap.putShort(46, (short) VideoSR.predictTimeMs_);
            }
        }
        this.codec.releaseOutputBuffer(i3, false);
        VideoFrame videoFrame = new VideoFrame(copyNV12ToI420Buffer, i16, bufferInfo.presentationTimeUs * 1000);
        videoFrame.setLatencyTimestamp(bArr);
        this.callback.onDecodedFrame(videoFrame, num, null);
        videoFrame.release();
    }

    private void deliverTextureFrame(int i3, MediaCodec.BufferInfo bufferInfo, int i16, Integer num, byte[] bArr) {
        int i17;
        int i18;
        synchronized (this.dimensionLock) {
            i17 = this.width;
            i18 = this.height;
        }
        synchronized (this.renderedTextureMetadataLock) {
            if (this.renderedTextureMetadata != null) {
                this.codec.releaseOutputBuffer(i3, false);
                return;
            }
            this.surfaceTextureHelper.setTextureSize(i17, i18);
            this.surfaceTextureHelper.setFrameRotation(i16);
            this.renderedTextureMetadata = new DecodedTextureMetadata(bufferInfo.presentationTimeUs, num, bArr);
            this.codec.releaseOutputBuffer(i3, true);
        }
    }

    public static long getDecodeTimeMs() {
        return totalDecodeTime;
    }

    public static int getEncodeNumber() {
        return encodeNumber;
    }

    public static long getFrameHeight() {
        return frameHeight;
    }

    public static long getFrameWidth() {
        return frameWidth;
    }

    public static long getFramesDecoded() {
        return framesDecoded;
    }

    private VideoCodecStatus initDecodeInternal(int i3, int i16) {
        String str;
        Surface surface;
        String str2;
        try {
            this.notusesystemtimestampFile = new File(Environment.getDataDirectory().getAbsolutePath() + "/cloudgame.notusesystemtimeforbuffer");
            this.notusesystemtimeProp = System.getProperty("cloudgame.notusesystemtimeforbuffer");
            File file = this.notusesystemtimestampFile;
            if ((file != null && file.exists()) || ((str2 = this.notusesystemtimeProp) != null && str2.equals("1"))) {
                this.useSystemTimestamp = false;
                Log.i(TAG, "force not use system timestamp as PTS");
            }
        } catch (Exception e16) {
            this.useSystemTimestamp = false;
            e16.printStackTrace();
            Log.e(TAG, "initDecodeInternal exception: " + e16.getMessage());
        }
        if (!skipRender) {
            this.useSystemTimestamp = false;
            Log.i(TAG, "Not use system timestamp as PTS since not skiprender");
        }
        if (this.useSystemTimestamp) {
            Log.i(TAG, "Change captureTime to system nanoTime");
        } else {
            Log.i(TAG, "Not change captureTime to system nanoTime");
        }
        if (skipRender && ((surface = displaySurface) == null || !surface.isValid())) {
            Logging.e(TAG, "initDecodeInternal: skipRender, but displaySurface is released");
            VideoDecoder.DecodeCallback decodeCallback = mCb;
            if (decodeCallback != null) {
                decodeCallback.onDecodeErrCodeReported(false, VideoCodecStatus.SURFACE_NULL_OR_VALID.getNumber(), 0, "initDecodeInternal: skipRender, but displaySurface is released");
            }
            return VideoCodecStatus.ERR_PARAMETER;
        }
        this.decoderThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + i3 + " height: " + i16);
        if (this.outputThread != null) {
            Logging.e(TAG, "initDecodeInternal called while the codec is already running");
            VideoDecoder.DecodeCallback decodeCallback2 = mCb;
            if (decodeCallback2 != null) {
                decodeCallback2.onDecodeErrCodeReported(false, VideoCodecStatus.CODEC_IS_RUNNING.getNumber(), 0, "initDecodeInternal called while the codec is already running");
            }
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.width = i3;
        this.height = i16;
        this.stride = i3;
        this.sliceHeight = i16;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            try {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), i3, i16);
                if (this.sharedContext == null) {
                    createVideoFormat.setInteger("color-format", this.colorFormat);
                }
                if (skipRender) {
                    configureMaxResolution(createVideoFormat);
                    Surface surface2 = displaySurface;
                    if (surface2 != null && surface2.isValid()) {
                        this.codec.configure(createVideoFormat, displaySurface, null, 0);
                    } else {
                        Logging.e(TAG, "codec.configure on null displaySurface");
                    }
                } else {
                    this.codec.configure(createVideoFormat, this.surface, null, 0);
                }
                this.codec.start();
                this.running = true;
                Thread createOutputThread = createOutputThread();
                this.outputThread = createOutputThread;
                createOutputThread.start();
                Logging.d(TAG, "initDecodeInternal done");
                return VideoCodecStatus.OK;
            } catch (Exception e17) {
                Logging.e(TAG, "initDecode failed", e17);
                release();
                if (mCb != null) {
                    VideoCodecType videoCodecType = this.codecType;
                    if (videoCodecType != null) {
                        str = videoCodecType.mimeType();
                    } else {
                        str = "";
                    }
                    mCb.onDecodeErrCodeReported(false, VideoCodecStatus.INIT_DECODE_EXCEPTION.getNumber(), 0, "initDecodeInternal failed: " + e17 + ", codeType: " + str + ", width: " + i3 + ", height: " + i16);
                }
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (IOException | IllegalArgumentException unused) {
            Logging.e(TAG, "Cannot create media decoder " + this.codecName);
            VideoDecoder.DecodeCallback decodeCallback3 = mCb;
            if (decodeCallback3 != null) {
                decodeCallback3.onDecodeErrCodeReported(false, VideoCodecStatus.CREATE_DECODER_FAILED.getNumber(), 0, "Cannot create media decoder " + this.codecName);
            }
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        } catch (Exception e18) {
            Logging.e(TAG, "createByCodecName uncaught exception " + this.codecName + e18);
            VideoDecoder.DecodeCallback decodeCallback4 = mCb;
            if (decodeCallback4 != null) {
                decodeCallback4.onDecodeErrCodeReported(false, VideoCodecStatus.CREATE_DECODER_FAILED.getNumber(), 0, "createByCodecName uncaught exception " + this.codecName + e18);
            }
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private boolean isSupportedColorFormat(int i3) {
        for (int i16 : MediaCodecUtils.DECODER_COLOR_FORMATS) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private void reformat(MediaFormat mediaFormat) {
        int integer;
        int integer2;
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Decoder format changed: " + mediaFormat.toString());
        if (mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            integer = (mediaFormat.getInteger("crop-right") + 1) - mediaFormat.getInteger("crop-left");
            integer2 = (mediaFormat.getInteger("crop-bottom") + 1) - mediaFormat.getInteger("crop-top");
        } else {
            integer = mediaFormat.getInteger("width");
            integer2 = mediaFormat.getInteger("height");
        }
        synchronized (this.dimensionLock) {
            if (this.hasDecodedFirstFrame && (this.width != integer || this.height != integer2)) {
                stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2));
                return;
            }
            this.width = integer;
            this.height = integer2;
            if (this.surfaceTextureHelper == null && mediaFormat.containsKey("color-format")) {
                this.colorFormat = mediaFormat.getInteger("color-format");
                Logging.d(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
                if (!isSupportedColorFormat(this.colorFormat)) {
                    stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
                    return;
                }
            }
            synchronized (this.dimensionLock) {
                if (mediaFormat.containsKey("stride")) {
                    this.stride = mediaFormat.getInteger("stride");
                }
                if (mediaFormat.containsKey("slice-height")) {
                    this.sliceHeight = mediaFormat.getInteger("slice-height");
                }
                Logging.d(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                this.stride = Math.max(this.width, this.stride);
                this.sliceHeight = Math.max(this.height, this.sliceHeight);
            }
        }
    }

    private VideoCodecStatus reinitDecode(int i3, int i16) {
        this.decoderThreadChecker.checkIsOnValidThread();
        VideoCodecStatus releaseInternal = releaseInternal();
        if (releaseInternal != VideoCodecStatus.OK) {
            return releaseInternal;
        }
        return initDecodeInternal(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e16) {
            Logging.e(TAG, "Media decoder stop failed", e16);
        }
        try {
            this.codec.release();
        } catch (Exception e17) {
            Logging.e(TAG, "Media decoder release failed", e17);
            this.shutdownException = e17;
        }
        Logging.d(TAG, "Release on output thread done");
    }

    private VideoCodecStatus releaseInternal() {
        if (!this.running) {
            Logging.d(TAG, "release: Decoder is not running.");
            return VideoCodecStatus.OK;
        }
        try {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                Logging.e(TAG, "Media decoder release timeout", new RuntimeException());
                VideoDecoder.DecodeCallback decodeCallback = mCb;
                if (decodeCallback != null) {
                    decodeCallback.onDecodeErrCodeReported(false, VideoCodecStatus.TIMEOUT.getNumber(), 0, "Media decoder release timeout");
                }
                return VideoCodecStatus.TIMEOUT;
            }
            if (this.shutdownException != null) {
                Logging.e(TAG, "Media decoder release error", new RuntimeException(this.shutdownException));
                this.shutdownException = null;
                return VideoCodecStatus.ERROR;
            }
            this.codec = null;
            this.outputThread = null;
            return VideoCodecStatus.OK;
        } finally {
            this.codec = null;
            this.outputThread = null;
        }
    }

    public static void setCallback(VideoDecoder.DecodeCallback decodeCallback) {
        mCb = decodeCallback;
    }

    public static void setSkipRender(boolean z16) {
        skipRender = z16;
    }

    public static void setSurface(Surface surface) {
        displaySurface = surface;
    }

    private void stopOnOutputThread(Exception exc) {
        this.outputThreadChecker.checkIsOnValidThread();
        this.running = false;
        this.shutdownException = exc;
    }

    protected VideoFrame.I420Buffer allocateI420Buffer(int i3, int i16) {
        return JavaI420Buffer.allocate(i3, i16);
    }

    protected void copyPlane(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, int i17, int i18) {
        YuvHelper.copyPlane(byteBuffer, i3, byteBuffer2, i16, i17, i18);
    }

    @Override // org.tencwebrtc.VideoDecoder
    public /* synthetic */ long createNativeVideoDecoder() {
        return ad.a(this);
    }

    protected SurfaceTextureHelper createSurfaceTextureHelper() {
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        int i3;
        int i16;
        ByteBuffer byteBuffer;
        byte[] bArr;
        long micros;
        byte b16;
        int i17;
        Surface surface;
        byte b17 = 0;
        try {
            if (skipRender && ((surface = displaySurface) == null || !surface.isValid())) {
                Logging.e(TAG, "decode: skipRender, but displaySurface is released");
                VideoDecoder.DecodeCallback decodeCallback = mCb;
                if (decodeCallback != null) {
                    decodeCallback.onDecodeErrCodeReported(false, VideoCodecStatus.SURFACE_NULL_OR_VALID.getNumber(), 0, "decode: skipRender, but displaySurface is released");
                }
                return VideoCodecStatus.ERR_PARAMETER;
            }
            ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
            this.decoderThreadChecker = threadChecker;
            threadChecker.checkIsOnValidThread();
            byte b18 = 1;
            if (this.codec != null && this.callback != null) {
                ByteBuffer byteBuffer2 = encodedImage.buffer;
                if (byteBuffer2 == null) {
                    Logging.e(TAG, "decode() - no input data");
                    VideoDecoder.DecodeCallback decodeCallback2 = mCb;
                    if (decodeCallback2 != null) {
                        decodeCallback2.onDecodeErrCodeReported(false, VideoCodecStatus.NO_INPUT_DATA_OR_EMPTY.getNumber(), 0, "decode() - no input data");
                    }
                    return VideoCodecStatus.ERR_PARAMETER;
                }
                int remaining = byteBuffer2.remaining();
                if (remaining == 0) {
                    Logging.e(TAG, "decode() - input buffer empty");
                    VideoDecoder.DecodeCallback decodeCallback3 = mCb;
                    if (decodeCallback3 != null) {
                        decodeCallback3.onDecodeErrCodeReported(false, VideoCodecStatus.NO_INPUT_DATA_OR_EMPTY.getNumber(), 0, "decode() - input buffer empty");
                    }
                    return VideoCodecStatus.ERR_PARAMETER;
                }
                if (MediaCodecWrapperFactoryImpl.enableTunnel) {
                    Logging.d(TAG, "enableTunnel: previousWidth=" + this.previousWidth + ", previousHeight=" + this.previousHeight + ", frame.encodedWidth=" + encodedImage.encodedWidth + ", frame.encodedHeight=" + encodedImage.encodedHeight + ", width=" + this.width + ", height=" + this.height);
                    int i18 = encodedImage.encodedHeight;
                    if (i18 > 0 && (i17 = encodedImage.encodedWidth) > 0) {
                        this.width = i17;
                        this.height = i18;
                    }
                }
                synchronized (this.dimensionLock) {
                    i3 = this.width;
                    i16 = this.height;
                }
                if (i3 > 0 && i16 > 0 && (i3 != this.previousWidth || i16 != this.previousHeight)) {
                    VideoDecoder.DecodeCallback decodeCallback4 = mCb;
                    if (decodeCallback4 != null) {
                        frameWidth = i3;
                        frameHeight = i16;
                        decodeCallback4.onFrameResolutionChanged(i3, i16, encodedImage.rotation);
                    }
                    Logging.v(TAG, "onFrameResolutionChanged previous: " + this.previousWidth + HippyTKDListViewAdapter.X + this.previousHeight + ", current: " + i3 + HippyTKDListViewAdapter.X + i16);
                    this.previousWidth = i3;
                    this.previousHeight = i16;
                }
                int i19 = 64 - this.uuid_length;
                int i26 = ((remaining - this.sei_length) - 3) - 3;
                long currentTimeMillis = System.currentTimeMillis();
                int i27 = 0;
                while (true) {
                    if (i27 >= i26) {
                        byteBuffer = null;
                        bArr = null;
                        break;
                    }
                    int i28 = i27 + 2;
                    if (encodedImage.buffer.get(i28) > b18) {
                        i27 += 3;
                    } else {
                        if (encodedImage.buffer.get(i28) == b18) {
                            int i29 = i27 + 1;
                            if (encodedImage.buffer.get(i29) == 0 && encodedImage.buffer.get(i27) == 0) {
                                VideoCodecType videoCodecType = this.codecType;
                                if (videoCodecType == VideoCodecType.H264) {
                                    b16 = (byte) (encodedImage.buffer.get(i27 + 3) & 31);
                                } else if (videoCodecType == VideoCodecType.H265) {
                                    b16 = (byte) ((encodedImage.buffer.get(i27 + 3) & Byte.MAX_VALUE) >> b18);
                                    i27 = i29;
                                } else {
                                    b16 = b17;
                                }
                                if ((b16 == 6 || b16 == 39) && encodedImage.buffer.get(i27 + 4) == 5) {
                                    this.sei_length = encodedImage.buffer.get(i27 + 5);
                                    int i36 = this.uuid_length;
                                    int i37 = i27 + 6 + i36;
                                    byte[] bArr2 = new byte[(64 - i36) + this.decode_length];
                                    byteBuffer = ByteBuffer.wrap(bArr2);
                                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                                    int i38 = b17;
                                    while (i38 + 2 < this.sei_length - this.uuid_length) {
                                        int i39 = i37 + 2;
                                        if (encodedImage.buffer.get(i39) > 3) {
                                            int i46 = i38 + 1;
                                            int i47 = i37 + 1;
                                            bArr2[i38] = encodedImage.buffer.get(i37);
                                            i38 = i46 + 1;
                                            i37 = i47 + 1;
                                            bArr2[i46] = encodedImage.buffer.get(i47);
                                        } else if (encodedImage.buffer.get(i37) == 0 && encodedImage.buffer.get(i37 + 1) == 0 && encodedImage.buffer.get(i39) == 3) {
                                            int i48 = i38 + 1;
                                            bArr2[i38] = 0;
                                            i38 = i48 + 1;
                                            bArr2[i48] = 0;
                                            i37 += 3;
                                        }
                                        bArr2[i38] = encodedImage.buffer.get(i37);
                                        i38++;
                                        i37++;
                                    }
                                    while (i38 < this.sei_length - this.uuid_length) {
                                        bArr2[i38] = encodedImage.buffer.get(i37);
                                        i38++;
                                        i37++;
                                    }
                                    bArr = bArr2;
                                } else {
                                    i27 += 3;
                                    b17 = 0;
                                    b18 = 1;
                                }
                            }
                        }
                        i27++;
                        b17 = 0;
                        b18 = 1;
                    }
                }
                int i49 = encodedImage.encodedWidth;
                int i56 = encodedImage.encodedHeight;
                if (i49 * i56 > 0 && (i49 != i3 || i56 != i16)) {
                    Logging.d(TAG, "width=" + i3 + ",height=" + i16 + ",encodedWidth=" + encodedImage.encodedWidth + ",encodedHeight=" + encodedImage.encodedHeight);
                    VideoCodecStatus reinitDecode = reinitDecode(encodedImage.encodedWidth, encodedImage.encodedHeight);
                    if (reinitDecode != VideoCodecStatus.OK) {
                        return reinitDecode;
                    }
                }
                if (this.keyFrameRequired) {
                    if (encodedImage.frameType != EncodedImage.FrameType.VideoFrameKey) {
                        Logging.e(TAG, "decode() - key frame required first");
                        VideoDecoder.DecodeCallback decodeCallback5 = mCb;
                        if (decodeCallback5 != null) {
                            decodeCallback5.onDecodeErrCodeReported(false, VideoCodecStatus.NO_OUTPUT.getNumber(), 0, "decode() - key frame required first");
                        }
                        return VideoCodecStatus.NO_OUTPUT;
                    }
                    if (!encodedImage.completeFrame) {
                        Logging.e(TAG, "decode() - complete frame required first");
                        VideoDecoder.DecodeCallback decodeCallback6 = mCb;
                        if (decodeCallback6 != null) {
                            decodeCallback6.onDecodeErrCodeReported(false, VideoCodecStatus.NO_OUTPUT.getNumber(), 0, "decode() - complete frame required first");
                        }
                        return VideoCodecStatus.NO_OUTPUT;
                    }
                }
                FTrace.startTrace();
                try {
                    int dequeueInputBuffer = this.codec.dequeueInputBuffer(500000L);
                    if (dequeueInputBuffer < 0) {
                        Logging.e(TAG, "decode() - no HW buffers available; decoder falling behind");
                        VideoDecoder.DecodeCallback decodeCallback7 = mCb;
                        if (decodeCallback7 != null) {
                            decodeCallback7.onDecodeErrCodeReported(false, VideoCodecStatus.ERROR.getNumber(), 0, "decode() - no HW buffers available; decoder falling behind");
                        }
                        return VideoCodecStatus.ERROR;
                    }
                    try {
                        ByteBuffer byteBuffer3 = this.codec.getInputBuffers()[dequeueInputBuffer];
                        if (byteBuffer3.capacity() < remaining) {
                            Logging.e(TAG, "decode() - HW buffer too small");
                            VideoDecoder.DecodeCallback decodeCallback8 = mCb;
                            if (decodeCallback8 != null) {
                                decodeCallback8.onDecodeErrCodeReported(false, VideoCodecStatus.MEMORY.getNumber(), 0, "decode() - HW buffer too small");
                            }
                            return VideoCodecStatus.ERROR;
                        }
                        byteBuffer3.put(encodedImage.buffer);
                        if (this.useSystemTimestamp) {
                            micros = System.nanoTime() / 1000;
                        } else {
                            micros = TimeUnit.NANOSECONDS.toMicros(encodedImage.captureTimeNs);
                        }
                        FrameInfo frameInfo = new FrameInfo(SystemClock.elapsedRealtime(), micros, encodedImage.rotation, bArr);
                        Logging.d(TAG, "decode capture_time_ms_=" + encodedImage.captureTimeMs + " decodeStartTimeMs=" + frameInfo.decodeStartTimeMs);
                        FTrace.startTrace("start_ms=%d", Long.valueOf(frameInfo.decodeStartTimeMs));
                        this.frameInfos.offer(frameInfo);
                        if (byteBuffer != null) {
                            byteBuffer.putInt(i19, remaining);
                            int i57 = i19 + 4;
                            byteBuffer.putShort(i57, (short) encodedImage.recvToDecodeMs);
                            byteBuffer.putLong(i57 + 4, currentTimeMillis);
                        }
                        try {
                            this.codec.queueInputBuffer(dequeueInputBuffer, 0, remaining, micros, 0);
                            if (this.keyFrameRequired) {
                                this.keyFrameRequired = false;
                            }
                            FTrace.endTrace();
                            FTrace.endTrace();
                            return VideoCodecStatus.OK;
                        } catch (IllegalStateException e16) {
                            Logging.e(TAG, "queueInputBuffer failed", e16);
                            this.frameInfos.pollLast();
                            VideoDecoder.DecodeCallback decodeCallback9 = mCb;
                            if (decodeCallback9 != null) {
                                decodeCallback9.onDecodeErrCodeReported(false, VideoCodecStatus.ERROR.getNumber(), 0, "queueInputBuffer failed: " + e16.getMessage());
                            }
                            return VideoCodecStatus.ERROR;
                        }
                    } catch (IllegalStateException e17) {
                        Logging.e(TAG, "getInputBuffers failed", e17);
                        VideoDecoder.DecodeCallback decodeCallback10 = mCb;
                        if (decodeCallback10 != null) {
                            decodeCallback10.onDecodeErrCodeReported(false, VideoCodecStatus.MEMORY.getNumber(), 0, "getInputBuffers failed: " + e17.getMessage());
                        }
                        return VideoCodecStatus.ERROR;
                    }
                } catch (IllegalStateException e18) {
                    Logging.e(TAG, "dequeueInputBuffer failed", e18);
                    VideoDecoder.DecodeCallback decodeCallback11 = mCb;
                    if (decodeCallback11 != null) {
                        decodeCallback11.onDecodeErrCodeReported(false, VideoCodecStatus.ERROR.getNumber(), 0, "dequeueInputBuffer failed: " + e18.getMessage());
                    }
                    return VideoCodecStatus.ERROR;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("decode uninitalized, codec: ");
            sb5.append(this.codec != null);
            sb5.append(", callback: ");
            sb5.append(this.callback);
            Logging.d(TAG, sb5.toString());
            VideoDecoder.DecodeCallback decodeCallback12 = mCb;
            if (decodeCallback12 != null) {
                int number = VideoCodecStatus.UNINITIALIZED.getNumber();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("decode uninitalized, codec: ");
                sb6.append(this.codec != null);
                sb6.append(", callback: ");
                sb6.append(this.callback);
                decodeCallback12.onDecodeErrCodeReported(false, number, 0, sb6.toString());
            }
            return VideoCodecStatus.UNINITIALIZED;
        } catch (Throwable th5) {
            Logging.e(TAG, "AndroidVideoDecoder failed", th5);
            VideoDecoder.DecodeCallback decodeCallback13 = mCb;
            if (decodeCallback13 != null) {
                decodeCallback13.onDecodeErrCodeReported(false, VideoCodecStatus.ERROR.getNumber(), 0, "AndroidVideoDecoder failed: " + th5.getMessage());
            }
            return VideoCodecStatus.ERROR;
        }
    }

    protected void deliverDecodedFrame() {
        Integer num;
        int i3;
        byte[] bArr;
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            FTrace.startTrace();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, JsonGrayBusiId.UI_RESERVE_100000_110000);
            if (dequeueOutputBuffer == -2) {
                reformat(this.codec.getOutputFormat());
                FTrace.endTrace();
                return;
            }
            if (dequeueOutputBuffer < 0) {
                Logging.v(TAG, "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                FTrace.endTrace();
                return;
            }
            FrameInfo poll = this.frameInfos.poll();
            while (poll != null && bufferInfo.presentationTimeUs > poll.captureTimeUs) {
                poll = this.frameInfos.poll();
                Logging.d(TAG, "info.presentationTimeUs(" + bufferInfo.presentationTimeUs + ") > frameInfo.captureTimeUs(" + poll.captureTimeUs + ")");
            }
            if (poll != null) {
                num = Integer.valueOf((int) (SystemClock.elapsedRealtime() - poll.decodeStartTimeMs));
                i3 = poll.rotation;
                bArr = poll.sei;
                FTrace.startTrace("start_ms=%d decode_ms=%d pts=%d", Long.valueOf(poll.decodeStartTimeMs), num, Long.valueOf(bufferInfo.presentationTimeUs));
                Logging.d(TAG, "deliverDecodedFrame decodeStartTimeMs=" + poll.decodeStartTimeMs);
            } else {
                num = null;
                i3 = 0;
                bArr = null;
            }
            this.hasDecodedFirstFrame = true;
            if (!this.isFirstFrameDecoded) {
                this.isFirstFrameDecoded = true;
                VideoDecoder.DecodeCallback decodeCallback = mCb;
                if (decodeCallback != null) {
                    decodeCallback.onFirstFrameDecoded();
                    Logging.d(TAG, "onFirstFrameDecoded");
                }
            }
            if (this.surfaceTextureHelper != null) {
                deliverTextureFrame(dequeueOutputBuffer, bufferInfo, i3, num, bArr);
            } else {
                deliverByteFrame(dequeueOutputBuffer, bufferInfo, i3, num, bArr);
            }
            if (poll != null) {
                FTrace.endTrace();
            }
            FTrace.endTrace();
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "deliverDecodedFrame failed", e16);
        }
    }

    protected void deliverDecodedFrameToDisplay() {
        AndroidVideoDecoder androidVideoDecoder;
        int i3;
        String str;
        int i16;
        boolean z16;
        String str2;
        int i17;
        int i18;
        String str3;
        long j3;
        short s16;
        long j16;
        short s17;
        int i19;
        long j17;
        Surface surface = displaySurface;
        if (surface != null && surface.isValid()) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, JsonGrayBusiId.UI_RESERVE_100000_110000);
            if (dequeueOutputBuffer == -2) {
                reformat(this.codec.getOutputFormat());
                return;
            }
            if (dequeueOutputBuffer < 0) {
                Logging.v(TAG, "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                FTrace.endTrace();
                if (dequeueOutputBuffer == -1 && MediaCodecWrapperFactoryImpl.enableTunnel) {
                    try {
                        LockMethodProxy.sleep(100L);
                        return;
                    } catch (InterruptedException e16) {
                        Log.e(TAG, "deliverDecodedFrameToDisplay sleep exception " + e16);
                        return;
                    }
                }
                return;
            }
            FrameInfo poll = this.frameInfos.poll();
            if (poll != null) {
                Logging.d(TAG, "poll,frameInfo.decodeStartTimeMs=" + poll.decodeStartTimeMs + ",frameInfo.captureTimeUs=" + poll.captureTimeUs);
            }
            while (poll != null && bufferInfo.presentationTimeUs > poll.captureTimeUs) {
                poll = this.frameInfos.poll();
                Logging.d(TAG, "info.presentationTimeUs(" + bufferInfo.presentationTimeUs + ") > frameInfo.captureTimeUs(" + poll.captureTimeUs + ")");
            }
            if (poll != null) {
                framesDecoded++;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Integer valueOf = Integer.valueOf((int) (elapsedRealtime - poll.decodeStartTimeMs));
                totalDecodeTime += valueOf.intValue();
                byte[] bArr = poll.sei;
                FrameInfo frameInfo = poll;
                FTrace.startTrace("start_ms=%d decode_ms=%d pts=%d", Long.valueOf(poll.decodeStartTimeMs), valueOf, Long.valueOf(bufferInfo.presentationTimeUs));
                if (bArr == null || bArr.length < 48) {
                    androidVideoDecoder = this;
                    str2 = TAG;
                    i3 = dequeueOutputBuffer;
                } else {
                    byte b16 = bArr[18];
                    if (b16 != this.prev_orientation) {
                        VideoDecoder.DecodeCallback decodeCallback = mCb;
                        if (decodeCallback != null) {
                            decodeCallback.onOrientationChanged(b16);
                        }
                        Logging.v(TAG, "Current orientation " + ((int) b16));
                        this.prev_orientation = b16;
                    }
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    wrap.putShort((bArr.length + 38) - 48, (short) valueOf.intValue());
                    Logging.d(TAG, "sei length = " + bArr.length);
                    long currentTimeMillis = System.currentTimeMillis();
                    wrap.position(0);
                    int i26 = wrap.getInt();
                    encodeNumber = wrap.getInt();
                    long j18 = wrap.getLong();
                    short s18 = wrap.getShort();
                    i3 = dequeueOutputBuffer;
                    byte b17 = wrap.get();
                    byte b18 = wrap.get();
                    int i27 = wrap.getInt();
                    long j19 = wrap.getLong();
                    long nanoTime = System.nanoTime();
                    if (j19 != -1) {
                        i18 = i26;
                        str3 = ")";
                        long j26 = nanoTime / 1000000;
                        j3 = currentTimeMillis;
                        s16 = (short) (j26 - j19);
                        StringBuilder sb5 = new StringBuilder();
                        i17 = i27;
                        sb5.append(" latencyMs=");
                        sb5.append((int) s16);
                        sb5.append(" startMs=");
                        sb5.append(j19);
                        sb5.append(" currMs=");
                        sb5.append(j26);
                        Logging.d(TAG, sb5.toString());
                    } else {
                        i17 = i27;
                        i18 = i26;
                        str3 = ")";
                        j3 = currentTimeMillis;
                        s16 = -1;
                    }
                    short s19 = b18;
                    if (bArr.length >= 64) {
                        short s26 = wrap.getShort();
                        short s27 = wrap.getShort();
                        i19 = wrap.getInt();
                        j16 = wrap.getLong();
                        s17 = s26;
                        s19 = s27;
                    } else {
                        j16 = 0;
                        s17 = 0;
                        i19 = 0;
                    }
                    int i28 = wrap.getInt();
                    short s28 = wrap.getShort();
                    long j27 = j16;
                    short s29 = wrap.getShort();
                    StringBuilder sb6 = new StringBuilder();
                    int i29 = i19;
                    sb6.append("decodeTimeMs(");
                    sb6.append(valueOf);
                    sb6.append(") = elapsedTime(");
                    sb6.append(elapsedRealtime);
                    sb6.append(") - frameInfo.decodeStartTimeMs(");
                    sb6.append(frameInfo.decodeStartTimeMs);
                    sb6.append("); decodeTime=");
                    sb6.append((int) s29);
                    sb6.append(", presentationTimeUs=");
                    sb6.append(bufferInfo.presentationTimeUs);
                    Logging.d(TAG, sb6.toString());
                    long j28 = wrap.getLong();
                    short s36 = s17;
                    short s37 = (short) (j3 - j28);
                    Logging.d(TAG, "decodeToRenderLatency(" + ((int) s37) + ") = curTimeMs(" + j3 + ") - decodeStartTimestamp(" + j28 + str3);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("");
                    sb7.append("render number            : ");
                    int i36 = i18;
                    sb7.append(i36);
                    sb7.append("\n");
                    String str4 = sb7.toString() + "encode number            : " + encodeNumber + "\n";
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str4);
                    sb8.append("encode start             : ");
                    short s38 = s16;
                    sb8.append(j18);
                    sb8.append("\n");
                    String str5 = (((((((((((sb8.toString() + "encode ms                : " + ((int) s18) + "\n") + "rotate                   : " + ((int) b17) + "\n") + "recv to render start     : " + ((int) s19) + "\n") + "rgb2yuv                  : " + i17 + "\n") + "frame size               : " + i28 + "\n") + "receive to decode        : " + ((int) s28) + "\n") + "decode time              : " + ((int) s29) + "\n") + "decode start             : " + j28 + "\n") + "decode to render latency : " + ((int) s37) + "\n") + "render time              : 0\n") + "round trip latency       : " + ((int) s38) + "\n") + "reserve1                : 0\n";
                    if (bArr.length >= 64) {
                        String str6 = ((str5 + "scene id                 : " + ((int) s36) + "\n") + "recv ts to render start  : " + ((int) s19) + "\n") + "session id               : " + i29 + "\n";
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(str6);
                        sb9.append("reserved                 : ");
                        j17 = j27;
                        sb9.append(j17);
                        sb9.append("\n");
                        str5 = sb9.toString();
                    } else {
                        j17 = j27;
                    }
                    StringBuilder sb10 = new StringBuilder();
                    long j29 = j17;
                    sb10.append(" latency=");
                    sb10.append(str5);
                    Logging.d(TAG, sb10.toString());
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append(" sei_length=");
                    androidVideoDecoder = this;
                    sb11.append(androidVideoDecoder.sei_length);
                    sb11.append(" sei.length=");
                    sb11.append(bArr.length);
                    Logging.d(TAG, sb11.toString());
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
                    str2 = TAG;
                    wrap2.order(ByteOrder.BIG_ENDIAN);
                    wrap2.putInt(i36);
                    wrap2.putInt(encodeNumber);
                    wrap2.putLong(j18);
                    wrap2.putShort(s18);
                    wrap2.put(b17);
                    wrap2.put(b18);
                    wrap2.putInt(i17);
                    wrap2.putInt(i28);
                    wrap2.putShort(s28);
                    wrap2.putShort(s29);
                    wrap2.putLong(j28);
                    wrap2.putShort(s37);
                    wrap2.putShort((short) 0);
                    wrap2.putShort(s38);
                    wrap2.putShort((short) 0);
                    if (bArr.length >= 64 && androidVideoDecoder.sei_length >= 64) {
                        wrap2.putShort(s36);
                        wrap2.putShort(s19);
                        wrap2.putInt(i29);
                        wrap2.putLong(j29);
                    }
                    VideoDecoder.DecodeCallback decodeCallback2 = mCb;
                    if (decodeCallback2 != null) {
                        decodeCallback2.onPerfCb(bArr2, length);
                    }
                }
                str = str2;
            } else {
                androidVideoDecoder = this;
                i3 = dequeueOutputBuffer;
                str = TAG;
                Logging.d(str, "deliverDecodedFrameToDisplay: failed to get sei");
            }
            if (androidVideoDecoder.useSystemTimestamp) {
                i16 = i3;
                androidVideoDecoder.codec.releaseOutputBuffer(i16, System.nanoTime());
                Logging.d(str, "Release output with System.nanoTime");
                z16 = true;
            } else {
                i16 = i3;
                z16 = true;
                androidVideoDecoder.codec.releaseOutputBuffer(i16, true);
                Logging.d(str, "Release output with render");
            }
            if (!androidVideoDecoder.isFirstFrameDecoded) {
                androidVideoDecoder.isFirstFrameDecoded = z16;
                VideoDecoder.DecodeCallback decodeCallback3 = mCb;
                if (decodeCallback3 != null) {
                    decodeCallback3.onFirstFrameDecoded();
                    Logging.v(str, "onFirstFrameDecoded");
                }
            }
            Logging.v(str, "deliverDecodedFrameToDisplay: result=" + i16);
            return;
        }
        Logging.v(TAG, "displaySurface is null, not deliver decoded frame ");
    }

    @Override // org.tencwebrtc.VideoDecoder
    public String getImplementationName() {
        return this.codecName;
    }

    @Override // org.tencwebrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        Surface surface;
        try {
            if (skipRender && ((surface = displaySurface) == null || !surface.isValid())) {
                Logging.e(TAG, "initDecode: skipRender, but displaySurface is released");
                VideoDecoder.DecodeCallback decodeCallback = mCb;
                if (decodeCallback != null) {
                    decodeCallback.onDecodeErrCodeReported(false, VideoCodecStatus.SURFACE_NULL_OR_VALID.getNumber(), 0, "skipRender, but displaySurface is released");
                }
                return VideoCodecStatus.ERR_PARAMETER;
            }
            framesDecoded = 0L;
            totalDecodeTime = 0L;
            this.isFirstFrameDecoded = false;
            this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
            this.callback = callback;
            if (this.sharedContext != null) {
                try {
                    SurfaceTextureHelper createSurfaceTextureHelper = createSurfaceTextureHelper();
                    this.surfaceTextureHelper = createSurfaceTextureHelper;
                    if (createSurfaceTextureHelper == null) {
                        Logging.e(TAG, "surfaceTextureHelper=null returned by createSurfaceTextureHelper");
                        VideoDecoder.DecodeCallback decodeCallback2 = mCb;
                        if (decodeCallback2 != null) {
                            decodeCallback2.onDecodeErrCodeReported(false, VideoCodecStatus.SURFACE_TEXTURE_HELPER_NULL_EXCEPTION.getNumber(), 0, "createSurfaceTextureHelper failed!");
                        }
                        return VideoCodecStatus.ERR_PARAMETER;
                    }
                    this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
                    this.surfaceTextureHelper.startListening(this);
                } catch (Exception e16) {
                    Logging.e(TAG, "initDecode exception: " + e16);
                    VideoDecoder.DecodeCallback decodeCallback3 = mCb;
                    if (decodeCallback3 != null) {
                        decodeCallback3.onDecodeErrCodeReported(false, VideoCodecStatus.SURFACE_TEXTURE_HELPER_NULL_EXCEPTION.getNumber(), 0, "initDecode exception: " + e16.getMessage());
                    }
                    return VideoCodecStatus.ERR_PARAMETER;
                }
            }
            return initDecodeInternal(settings.width, settings.height);
        } catch (Exception e17) {
            Logging.e(TAG, "initDecode exception: " + e17);
            VideoDecoder.DecodeCallback decodeCallback4 = mCb;
            if (decodeCallback4 != null) {
                decodeCallback4.onDecodeErrCodeReported(false, VideoCodecStatus.INIT_DECODE_EXCEPTION.getNumber(), 0, "initDecode failed: " + e17.getMessage());
            }
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    @Override // org.tencwebrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        synchronized (this.renderedTextureMetadataLock) {
            DecodedTextureMetadata decodedTextureMetadata = this.renderedTextureMetadata;
            if (decodedTextureMetadata == null) {
                Logging.e(TAG, "Rendered texture metadata was null in onTextureFrameAvailable.");
                return;
            }
            long j3 = decodedTextureMetadata.presentationTimestampUs * 1000;
            Integer num = decodedTextureMetadata.decodeTimeMs;
            byte[] bArr = decodedTextureMetadata.sei;
            this.renderedTextureMetadata = null;
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                wrap.putShort((bArr.length + 38) - 48, (short) num.intValue());
            }
            Logging.d(TAG, "onFrame timestamp=" + j3 + " decodeTimeMs=" + num);
            FTrace.startTrace("AndroidVideoDecoder.OnFrame pts=%d decode_ms=%d", Long.valueOf(j3 / 1000), num);
            VideoFrame videoFrame2 = new VideoFrame(videoFrame.getBuffer(), videoFrame.getRotation(), j3);
            videoFrame2.setLatencyTimestamp(bArr);
            this.callback.onDecodedFrame(videoFrame2, num, null);
            FTrace.endTrace();
        }
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus release() {
        Logging.d(TAG, "release");
        VideoCodecStatus releaseInternal = releaseInternal();
        if (this.surface != null) {
            releaseSurface();
            this.surface = null;
            this.surfaceTextureHelper.stopListening();
            this.surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
        synchronized (this.renderedTextureMetadataLock) {
            this.renderedTextureMetadata = null;
        }
        this.callback = null;
        this.frameInfos.clear();
        return releaseInternal;
    }

    protected void releaseSurface() {
        this.surface.release();
    }

    void resetSrShareFrameBuffer() {
        VideoFrame.I420Buffer i420Buffer;
        VideoFrame.I420Buffer i420Buffer2;
        Logging.d(TAG, "VideoSR resetSrShareFrameBuffer ref_frameBuffer=" + this.ref_frameBuffer_ + " ref_sr_frameBuffer=" + this.ref_sr_frameBuffer_);
        if (this.ref_frameBuffer_ != 0 && (i420Buffer2 = this.frameBuffer_) != null) {
            i420Buffer2.release();
        }
        this.ref_frameBuffer_ = 0;
        if (this.ref_sr_frameBuffer_ != 0 && (i420Buffer = this.sr_frameBuffer_) != null) {
            i420Buffer.release();
        }
        this.ref_sr_frameBuffer_ = 0;
    }

    protected VideoFrame.I420Buffer allocateI420Buffer(int i3, int i16, int i17) {
        return JavaI420Buffer.allocate(i3, i16, i17);
    }
}
