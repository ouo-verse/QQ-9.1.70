package com.tencent.gamematrix.gmcg.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EncodedImage;
import org.tencwebrtc.FTrace;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.VideoCodecStatus;
import org.tencwebrtc.VideoDecoder;
import org.tencwebrtc.VideoFrame;
import org.tencwebrtc.VideoSink;
import org.tencwebrtc.ad;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DefaultVideoDecoder implements VideoDecoder, VideoSink {
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final String TAG = "DefaultVideoDecoder";
    private static boolean decodeReleased = false;

    @Nullable
    private static Surface displaySurface = null;
    public static boolean enableTunnel = false;
    private static int encodeNumber = 0;
    private static long frameHeight = 0;
    private static long frameWidth = 0;
    private static long framesDecoded = 0;
    private static boolean lowLatency = true;
    public static VideoDecoder.DecodeCallback mCb;
    private static boolean skipRender;
    private static long totalDecodeTime;

    @Nullable
    private VideoDecoder.Callback callback;

    @Nullable
    private MediaCodec codec;
    private final String codecName;
    private final CodecMimeType codecType;
    private int colorFormat;
    private ThreadUtils.ThreadChecker decoderThreadChecker;
    private final Object dimensionLock = new Object();
    private final BlockingDeque<FrameInfo> frameInfos;
    private boolean hasDecodedFirstFrame;
    private int height;
    private boolean isFirstFrameDecoded;
    private boolean keyFrameRequired;
    private String notusesystemtimeProp;

    @Nullable
    private File notusesystemtimestampFile;

    @Nullable
    private Thread outputThread;
    private ThreadUtils.ThreadChecker outputThreadChecker;
    private int prev_orientation;
    private int previousHeight;
    private int previousWidth;
    private volatile boolean running;

    @Nullable
    private volatile Exception shutdownException;
    private int sliceHeight;
    private int stride;

    @Nullable
    private Surface surface;
    private boolean useSystemTimestamp;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
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
    public DefaultVideoDecoder(String str, CodecMimeType codecMimeType, int i3) {
        if (isSupportedColorFormat(i3)) {
            CGLog.i("ctor name: " + str + " type: " + codecMimeType + " color format: " + i3 + " context: ");
            this.codecName = str;
            this.codecType = codecMimeType;
            this.colorFormat = i3;
            this.frameInfos = new LinkedBlockingDeque();
            this.previousHeight = 0;
            this.previousWidth = 0;
            this.useSystemTimestamp = true;
            return;
        }
        throw new IllegalArgumentException("Unsupported color format: " + i3);
    }

    @TargetApi(18)
    private int configureLowLatency(MediaFormat mediaFormat, MediaCodec mediaCodec) {
        int i3;
        String name = mediaCodec.getName();
        CGLog.i("codecName: " + name);
        if ("OMX.qcom.video.decoder.avc".equalsIgnoreCase(name) || "c2.qti.avc.decoder".equalsIgnoreCase(name) || "OMX.qcom.video.decoder.hevc".equalsIgnoreCase(name) || "c2.qti.hevc.decoder".equalsIgnoreCase(name)) {
            mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
            mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
            CGLog.i("codecName: " + name + " low latency enabled");
        }
        int i16 = 2;
        if (!"OMX.hisi.video.decoder.avc".equalsIgnoreCase(name) && !"OMX.hisi.video.decoder.hevc".equalsIgnoreCase(name)) {
            i3 = 0;
        } else {
            mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
            mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
            mediaFormat.setInteger("fast-output-mode", 1);
            CGLog.i("codecName: " + name + " low latency fast output enabled, flags=2");
            i3 = 2;
        }
        if ("OMX.MS.AVC.Decoder".equalsIgnoreCase(name) || "OMX.MS.HEVC.Decoder".equalsIgnoreCase(name)) {
            mediaFormat.setInteger("vendor.START.low-latency.enable", 1);
            CGLog.i("codecName: " + name + "vendor low latency enabled, flags=2");
            i3 = 2;
        }
        if ("OMX.GK.AVC.Decoder".equalsIgnoreCase(name) || "OMX.GK.HEVC.Decoder".equalsIgnoreCase(name)) {
            mediaFormat.setInteger("goke.lowlatency.enable", 1);
            CGLog.i("codecName: " + name + " low latency enabled");
        }
        if (name.startsWith("OMX.amlogic")) {
            mediaFormat.setInteger("vendor.START.low-latency.enable", 1);
            CGLog.i("codecName: " + name + " due low latency enabled");
        }
        if (!name.startsWith("OMX.MKT") && !name.startsWith("OMX.NVT")) {
            i16 = i3;
        } else {
            mediaFormat.setInteger("vendor.START.low-latency.enable", 1);
            CGLog.i("codecName: " + name + "vendor low latency enabled, flags=2");
        }
        mediaFormat.setInteger("vendor.low-latency.enable", 1);
        String property = System.getProperty("cloudgame.tunnel");
        if (!new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cloudgame.tunnel").exists() && (property == null || !property.equals("1"))) {
            enableTunnel = false;
        } else {
            enableTunnel = true;
        }
        if (enableTunnel) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            Log.i(TAG, "codecName: " + name + " enable tunnelled playback");
        } else {
            Log.i(TAG, "codecName: " + name + " not enable tunnelled playback");
        }
        return i16;
    }

    @TargetApi(18)
    private void configureMaxResolution(MediaFormat mediaFormat) {
        if ("OMX.amlogic.hevc.decoder.awesome".equalsIgnoreCase(this.codecName)) {
            mediaFormat.setInteger("max-width", 3840);
            mediaFormat.setInteger("max-height", 2160);
            CGLog.i("OMX.amlogic.hevc.decoder.awesome, max widthxheight=3840x2160");
        }
    }

    private Thread createOutputThread() {
        return new BaseThread("DefaultVideoDecoder.outputThread") { // from class: com.tencent.gamematrix.gmcg.webrtc.DefaultVideoDecoder.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                DefaultVideoDecoder.this.outputThreadChecker = new ThreadUtils.ThreadChecker();
                while (DefaultVideoDecoder.this.running) {
                    try {
                        DefaultVideoDecoder.this.deliverDecodedFrameToDisplay();
                    } catch (Exception e16) {
                        CGLog.i("Failed to deliver decoded frame " + e16);
                    }
                }
                DefaultVideoDecoder.this.releaseCodecOnOutputThread();
            }
        };
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
        this.notusesystemtimestampFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/cloudgame.notusesystemtimeforbuffer");
        this.notusesystemtimeProp = System.getProperty("cloudgame.notusesystemtimeforbuffer");
        File file = this.notusesystemtimestampFile;
        if ((file != null && file.exists()) || ((str = this.notusesystemtimeProp) != null && str.equals("1"))) {
            this.useSystemTimestamp = false;
            Log.i(TAG, "force not use system timestamp as PTS");
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
            CGLog.e("initDecodeInternal: skipRender, but displaySurface is released");
            return VideoCodecStatus.ERR_PARAMETER;
        }
        this.decoderThreadChecker.checkIsOnValidThread();
        CGLog.i("DefaultVideoDecoder initDecodeInternal name:  type: " + this.codecType + " width: " + i3 + " height: " + i16);
        if (this.outputThread != null) {
            CGLog.e("initDecodeInternal called while the codec is already running");
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.width = i3;
        this.height = i16;
        this.stride = i3;
        this.sliceHeight = i16;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        try {
            this.codec = MediaCodec.createByCodecName(this.codecName);
            try {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), i3, i16);
                if (skipRender) {
                    configureMaxResolution(createVideoFormat);
                    Surface surface2 = displaySurface;
                    if (surface2 != null && surface2.isValid()) {
                        this.codec.configure(createVideoFormat, displaySurface, (MediaCrypto) null, configureLowLatency(createVideoFormat, this.codec));
                    } else {
                        CGLog.e("codec.configure on null displaySurface");
                    }
                } else {
                    this.codec.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
                }
                this.codec.start();
                this.running = true;
                Thread createOutputThread = createOutputThread();
                this.outputThread = createOutputThread;
                createOutputThread.start();
                CGLog.i("initDecodeInternal done");
                return VideoCodecStatus.OK;
            } catch (Exception e16) {
                CGLog.e("initDecode failed:" + e16);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (IOException | IllegalArgumentException unused) {
            CGLog.e("Cannot create media decoder " + this.codecName);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        } catch (Exception e17) {
            CGLog.e("createByCodecName uncaught exception " + this.codecName + e17);
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
        CGLog.i("Decoder format changed: " + mediaFormat.toString());
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
            synchronized (this.dimensionLock) {
                if (mediaFormat.containsKey("stride")) {
                    this.stride = mediaFormat.getInteger("stride");
                }
                if (mediaFormat.containsKey("slice-height")) {
                    this.sliceHeight = mediaFormat.getInteger("slice-height");
                }
                CGLog.i("Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
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
        CGLog.i("Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e16) {
            CGLog.e("Media decoder stop failed" + e16);
        }
        try {
            this.codec.release();
        } catch (Exception e17) {
            CGLog.e("Media decoder release failed" + e17);
            this.shutdownException = e17;
        }
        CGLog.i("Release on output thread done");
    }

    private VideoCodecStatus releaseInternal() {
        if (!this.running) {
            CGLog.i("release: Decoder is not running.");
            return VideoCodecStatus.OK;
        }
        try {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                CGLog.e("Media decoder release timeout" + new RuntimeException());
                return VideoCodecStatus.TIMEOUT;
            }
            if (this.shutdownException != null) {
                CGLog.e("Media decoder release error" + new RuntimeException(this.shutdownException));
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

    public static void setLowLatency(boolean z16) {
        lowLatency = z16;
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

    @Override // org.tencwebrtc.VideoDecoder
    public /* synthetic */ long createNativeVideoDecoder() {
        return ad.a(this);
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        int i3;
        int i16;
        ByteBuffer byteBuffer;
        byte[] bArr;
        long micros;
        byte b16;
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.decoderThreadChecker = threadChecker;
        threadChecker.checkIsOnValidThread();
        boolean z16 = false;
        if (this.codec != null && this.callback != null) {
            ByteBuffer byteBuffer2 = encodedImage.buffer;
            if (byteBuffer2 == null) {
                CGLog.e("decode() - no input data");
                return VideoCodecStatus.ERR_PARAMETER;
            }
            int remaining = byteBuffer2.remaining();
            if (remaining == 0) {
                CGLog.e("decode() - input buffer empty");
                return VideoCodecStatus.ERR_PARAMETER;
            }
            synchronized (this.dimensionLock) {
                i3 = this.width;
                i16 = this.height;
            }
            if (i3 > 0 && i16 > 0 && (i3 != this.previousWidth || i16 != this.previousHeight)) {
                VideoDecoder.DecodeCallback decodeCallback = mCb;
                if (decodeCallback != null) {
                    frameWidth = i3;
                    frameHeight = i16;
                    decodeCallback.onFrameResolutionChanged(i3, i16, encodedImage.rotation);
                }
                CGLog.i("onFrameResolutionChanged previous: " + this.previousWidth + HippyTKDListViewAdapter.X + this.previousHeight + ", current: " + i3 + HippyTKDListViewAdapter.X + i16);
                this.previousWidth = i3;
                this.previousHeight = i16;
            }
            int i17 = ((remaining - 48) - 3) - 3;
            long currentTimeMillis = System.currentTimeMillis();
            int i18 = 0;
            while (true) {
                int i19 = 32;
                if (i18 < i17) {
                    int i26 = i18 + 2;
                    if (encodedImage.buffer.get(i26) <= 1) {
                        if (encodedImage.buffer.get(i26) == 1) {
                            int i27 = i18 + 1;
                            if (encodedImage.buffer.get(i27) == 0 && encodedImage.buffer.get(i18) == 0) {
                                CodecMimeType codecMimeType = this.codecType;
                                if (codecMimeType == CodecMimeType.H264) {
                                    b16 = (byte) (encodedImage.buffer.get(i18 + 3) & 31);
                                } else if (codecMimeType == CodecMimeType.H265) {
                                    b16 = (byte) ((encodedImage.buffer.get(i18 + 3) & Byte.MAX_VALUE) >> 1);
                                    i18 = i27;
                                } else {
                                    b16 = 0;
                                }
                                if ((b16 == 6 || b16 == 39) && encodedImage.buffer.get(i18 + 4) == 5 && encodedImage.buffer.get(i18 + 5) == 48) {
                                    int i28 = i18 + 6 + 16;
                                    byte[] bArr2 = new byte[48];
                                    byteBuffer = ByteBuffer.wrap(bArr2);
                                    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                                    int i29 = 0;
                                    while (i29 + 2 < i19) {
                                        int i36 = i28 + 2;
                                        if (encodedImage.buffer.get(i36) > 3) {
                                            int i37 = i29 + 1;
                                            int i38 = i28 + 1;
                                            bArr2[i29] = encodedImage.buffer.get(i28);
                                            i29 = i37 + 1;
                                            bArr2[i37] = encodedImage.buffer.get(i38);
                                            i28 = i38 + 1;
                                        } else if (encodedImage.buffer.get(i28) == 0 && encodedImage.buffer.get(i28 + 1) == 0 && encodedImage.buffer.get(i36) == 3) {
                                            int i39 = i29 + 1;
                                            bArr2[i29] = 0;
                                            i29 = i39 + 1;
                                            bArr2[i39] = 0;
                                            i28 += 3;
                                            i19 = 32;
                                        }
                                        bArr2[i29] = encodedImage.buffer.get(i28);
                                        i29++;
                                        i28++;
                                        i19 = 32;
                                    }
                                    for (int i46 = i19; i29 < i46; i46 = 32) {
                                        bArr2[i29] = encodedImage.buffer.get(i28);
                                        i29++;
                                        i28++;
                                    }
                                    bArr = bArr2;
                                }
                            }
                        }
                        i18++;
                    }
                    i18 += 3;
                } else {
                    byteBuffer = null;
                    bArr = null;
                    break;
                }
            }
            int i47 = encodedImage.encodedWidth;
            int i48 = encodedImage.encodedHeight;
            if (i47 * i48 > 0 && (i47 != i3 || i48 != i16)) {
                CGLog.i("width=" + i3 + ",height=" + i16 + ",encodedWidth=" + encodedImage.encodedWidth + ",encodedHeight=" + encodedImage.encodedHeight);
                VideoCodecStatus reinitDecode = reinitDecode(encodedImage.encodedWidth, encodedImage.encodedHeight);
                if (reinitDecode != VideoCodecStatus.OK) {
                    return reinitDecode;
                }
            }
            if (this.keyFrameRequired) {
                if (encodedImage.frameType != EncodedImage.FrameType.VideoFrameKey) {
                    CGLog.e("decode() - key frame required first");
                    return VideoCodecStatus.NO_OUTPUT;
                }
                if (!encodedImage.completeFrame) {
                    CGLog.e("decode() - complete frame required first");
                    return VideoCodecStatus.NO_OUTPUT;
                }
            }
            try {
                int dequeueInputBuffer = this.codec.dequeueInputBuffer(500000L);
                if (dequeueInputBuffer < 0) {
                    CGLog.e("decode() - no HW buffers available; decoder falling behind");
                    return VideoCodecStatus.ERROR;
                }
                try {
                    ByteBuffer byteBuffer3 = this.codec.getInputBuffers()[dequeueInputBuffer];
                    if (byteBuffer3.capacity() < remaining) {
                        CGLog.e("decode() - HW buffer too small");
                        return VideoCodecStatus.ERROR;
                    }
                    byteBuffer3.put(encodedImage.buffer);
                    if (this.useSystemTimestamp) {
                        micros = System.nanoTime() / 1000;
                    } else {
                        micros = TimeUnit.NANOSECONDS.toMicros(encodedImage.captureTimeNs);
                    }
                    long j3 = micros;
                    FrameInfo frameInfo = new FrameInfo(SystemClock.elapsedRealtime(), j3, encodedImage.rotation, bArr);
                    CGLog.i("decode capture_time_ms_=" + encodedImage.captureTimeMs + " decodeStartTimeMs=" + frameInfo.decodeStartTimeMs);
                    this.frameInfos.offer(frameInfo);
                    if (byteBuffer != null) {
                        byteBuffer.putInt(32, remaining);
                        byteBuffer.putShort(36, (short) encodedImage.recvToDecodeMs);
                        byteBuffer.putLong(40, currentTimeMillis);
                    }
                    try {
                        this.codec.queueInputBuffer(dequeueInputBuffer, 0, remaining, j3, 0);
                        if (this.keyFrameRequired) {
                            this.keyFrameRequired = false;
                        }
                        return VideoCodecStatus.OK;
                    } catch (IllegalStateException e16) {
                        CGLog.e("queueInputBuffer failed" + e16);
                        this.frameInfos.pollLast();
                        return VideoCodecStatus.ERROR;
                    }
                } catch (IllegalStateException e17) {
                    CGLog.e("getInputBuffers failed" + e17);
                    return VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException e18) {
                CGLog.e("dequeueInputBuffer failed" + e18);
                return VideoCodecStatus.ERROR;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("decode uninitalized, codec: ");
        if (this.codec != null) {
            z16 = true;
        }
        sb5.append(z16);
        sb5.append(", callback: ");
        sb5.append(this.callback);
        CGLog.i(sb5.toString());
        return VideoCodecStatus.UNINITIALIZED;
    }

    protected void deliverDecodedFrameToDisplay() {
        int i3;
        boolean z16;
        byte[] bArr;
        int i16;
        byte b16;
        long j3;
        short s16;
        Surface surface = displaySurface;
        if (surface != null && surface.isValid()) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, JsonGrayBusiId.UI_RESERVE_100000_110000);
            if (dequeueOutputBuffer == -2) {
                reformat(this.codec.getOutputFormat());
                return;
            }
            if (dequeueOutputBuffer < 0) {
                CGLog.i("dequeueOutputBuffer returned " + dequeueOutputBuffer);
                return;
            }
            FrameInfo poll = this.frameInfos.poll();
            if (poll != null) {
                CGLog.i("poll,frameInfo.decodeStartTimeMs=" + poll.decodeStartTimeMs + ",frameInfo.captureTimeUs=" + poll.captureTimeUs);
            }
            while (poll != null && bufferInfo.presentationTimeUs > poll.captureTimeUs) {
                poll = this.frameInfos.poll();
                CGLog.i("info.presentationTimeUs(" + bufferInfo.presentationTimeUs + ") > frameInfo.captureTimeUs(" + poll.captureTimeUs + ")");
            }
            if (poll != null) {
                framesDecoded++;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Integer valueOf = Integer.valueOf((int) (elapsedRealtime - poll.decodeStartTimeMs));
                totalDecodeTime += valueOf.intValue();
                byte[] bArr2 = poll.sei;
                FTrace.startTrace("start_ms=%d decode_ms=%d ", Long.valueOf(poll.decodeStartTimeMs), valueOf);
                if (bArr2 == null || bArr2.length < 48) {
                    i3 = dequeueOutputBuffer;
                } else {
                    byte b17 = bArr2[18];
                    if (b17 != this.prev_orientation) {
                        VideoDecoder.DecodeCallback decodeCallback = mCb;
                        if (decodeCallback != null) {
                            decodeCallback.onOrientationChanged(b17);
                        }
                        CGLog.i("Current orientation " + ((int) b17));
                        this.prev_orientation = b17;
                    }
                    ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    wrap.putShort(38, (short) valueOf.intValue());
                    CGLog.i("sei length = " + bArr2.length);
                    long currentTimeMillis = System.currentTimeMillis();
                    wrap.position(0);
                    int i17 = wrap.getInt();
                    encodeNumber = wrap.getInt();
                    long j16 = wrap.getLong();
                    short s17 = wrap.getShort();
                    byte b18 = wrap.get();
                    i3 = dequeueOutputBuffer;
                    byte b19 = wrap.get();
                    int i18 = wrap.getInt();
                    long j17 = wrap.getLong();
                    long nanoTime = System.nanoTime();
                    if (j17 != -1) {
                        j3 = j16;
                        long j18 = nanoTime / 1000000;
                        i16 = i17;
                        b16 = b18;
                        s16 = (short) (j18 - j17);
                        StringBuilder sb5 = new StringBuilder();
                        bArr = bArr2;
                        sb5.append(" latencyMs=");
                        sb5.append((int) s16);
                        sb5.append(" startMs=");
                        sb5.append(j17);
                        sb5.append(" currMs=");
                        sb5.append(j18);
                        CGLog.i(sb5.toString());
                    } else {
                        bArr = bArr2;
                        i16 = i17;
                        b16 = b18;
                        j3 = j16;
                        s16 = -1;
                    }
                    int i19 = wrap.getInt();
                    short s18 = wrap.getShort();
                    short s19 = wrap.getShort();
                    CGLog.i("decodeTimeMs(" + valueOf + ") = elapsedTime(" + elapsedRealtime + ") - frameInfo.decodeStartTimeMs(" + poll.decodeStartTimeMs + "); decodeTime=" + ((int) s19));
                    long j19 = wrap.getLong();
                    short s26 = (short) (currentTimeMillis - j19);
                    CGLog.i("decodeToRenderLatency(" + ((int) s26) + ") = curTimeMs(" + currentTimeMillis + ") - decodeStartTimestamp(" + j19 + ")");
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("");
                    sb6.append("render number            : ");
                    int i26 = i16;
                    sb6.append(i26);
                    sb6.append("\n");
                    String str = sb6.toString() + "encode number            : " + encodeNumber + "\n";
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str);
                    sb7.append("encode start             : ");
                    long j26 = j3;
                    sb7.append(j26);
                    sb7.append("\n");
                    String str2 = sb7.toString() + "encode ms                : " + ((int) s17) + "\n";
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str2);
                    sb8.append("rotate                   : ");
                    byte b26 = b16;
                    sb8.append((int) b26);
                    sb8.append("\n");
                    CGLog.i(" latency=" + (((((((((sb8.toString() + "offset to render start   : " + ((int) b19) + "\n") + "rgb2yuv                  : " + i18 + "\n") + "frame size               : " + i19 + "\n") + "receive to decode        : " + ((int) s18) + "\n") + "decode time              : " + ((int) s19) + "\n") + "decode start             : " + j19 + "\n") + "decode to render latency : " + ((int) s26) + "\n") + "render time              : 0\n") + "round trip latency       : " + ((int) s16) + "\n"));
                    int length = bArr.length;
                    byte[] bArr3 = new byte[length];
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr3);
                    wrap2.order(ByteOrder.BIG_ENDIAN);
                    wrap2.putInt(i26);
                    wrap2.putInt(encodeNumber);
                    wrap2.putLong(j26);
                    wrap2.putShort(s17);
                    wrap2.put(b26);
                    wrap2.put(b19);
                    wrap2.putInt(i18);
                    wrap2.putInt(i19);
                    wrap2.putShort(s18);
                    wrap2.putShort(s19);
                    wrap2.putLong(j19);
                    wrap2.putShort(s26);
                    wrap2.putShort((short) 0);
                    wrap2.putShort(s16);
                    VideoDecoder.DecodeCallback decodeCallback2 = mCb;
                    if (decodeCallback2 != null) {
                        decodeCallback2.onPerfCb(bArr3, length + 8);
                    }
                }
            } else {
                i3 = dequeueOutputBuffer;
                CGLog.i("deliverDecodedFrameToDisplay: failed to get sei");
            }
            if (this.useSystemTimestamp) {
                this.codec.releaseOutputBuffer(i3, System.nanoTime());
                CGLog.i("Release output with System.nanoTime");
                z16 = true;
            } else {
                z16 = true;
                this.codec.releaseOutputBuffer(i3, true);
                CGLog.i("Release output with render");
            }
            if (this.isFirstFrameDecoded) {
                return;
            }
            this.isFirstFrameDecoded = z16;
            VideoDecoder.DecodeCallback decodeCallback3 = mCb;
            if (decodeCallback3 != null) {
                decodeCallback3.onFirstFrameDecoded();
                CGLog.i("onFirstFrameDecoded");
                return;
            }
            return;
        }
        CGLog.e("displaySurface is null, not deliver decoded frame ");
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
        if (skipRender && ((surface = displaySurface) == null || !surface.isValid())) {
            CGLog.e("initDecode: skipRender, but displaySurface is released");
            return VideoCodecStatus.ERR_PARAMETER;
        }
        framesDecoded = 0L;
        totalDecodeTime = 0L;
        this.isFirstFrameDecoded = false;
        this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
        this.callback = callback;
        return initDecodeInternal(settings.width, settings.height);
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus release() {
        CGLog.i("release");
        VideoCodecStatus releaseInternal = releaseInternal();
        if (this.surface != null) {
            releaseSurface();
            this.surface = null;
        }
        this.callback = null;
        this.frameInfos.clear();
        return releaseInternal;
    }

    protected void releaseSurface() {
        this.surface.release();
    }

    @Override // org.tencwebrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
    }
}
