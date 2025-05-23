package com.tencent.liteav.videoconsumer2;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.avcore.jni.codec.NativeCodec;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.common.MediaCodecAbility;
import com.tencent.liteav.videobase.utils.b;
import com.tencent.liteav.videobase.utils.d;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoconsumer.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class HardwareVideoDecoder2 implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DRAIN_ERROR = -1;
    private static final int DRAIN_SUCCESS = 0;
    private static final int DRAIN_SUCCESS_MEET_END_OF_STREAM = 1;
    private static final int INVALID_COLOR_FORMAT = 0;
    private final b mDecoderMediaFormatBuilder;
    private Surface mExternalSurface;
    private boolean mIsRealTime;
    private boolean mIsStarted;
    private long mNativeVideoDecoderImplAndroid;
    private Surface mOutputSurface;
    private SurfaceTexture mSurfaceTexture;
    private final String mTAG;
    private boolean mUseByteBuffer;
    private boolean mUseSoftwareDecoder;
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    private MediaCodec mMediaCodec = null;
    private final MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private boolean mEnableLimitMaxDecFrameBufferingInH264Sps = true;
    private final com.tencent.liteav.videoconsumer.a.a mSPSModifier = new com.tencent.liteav.videoconsumer.a.a();

    HardwareVideoDecoder2(String str, boolean z16, boolean z17, int i3, int i16, boolean z18, boolean z19, long j3) {
        String str2;
        this.mUseSoftwareDecoder = false;
        this.mUseByteBuffer = false;
        this.mTAG = str + "HardwareVideoDecoder2";
        this.mIsRealTime = z16;
        this.mUseSoftwareDecoder = z18;
        this.mUseByteBuffer = z19;
        this.mNativeVideoDecoderImplAndroid = j3;
        b bVar = new b();
        if (z17) {
            str2 = "video/hevc";
        } else {
            str2 = "video/avc";
        }
        bVar.f119373c = str2;
        bVar.f119371a = i3;
        bVar.f119372b = i16;
        this.mDecoderMediaFormatBuilder = bVar;
    }

    private boolean configureDecoder(a aVar, boolean z16) {
        String str;
        Surface surface;
        b bVar = this.mDecoderMediaFormatBuilder;
        bVar.f119374d = z16;
        MediaFormat a16 = bVar.a();
        LiteavLog.i(this.mTAG, "mediaFormat:".concat(String.valueOf(a16)));
        try {
            String string = a16.getString("mime");
            MediaCodec createMediaCodecInternal = createMediaCodecInternal(this.mUseSoftwareDecoder, string);
            aVar.f119567a = createMediaCodecInternal;
            if (this.mUseByteBuffer) {
                int supportedByteBufferColorFormat = getSupportedByteBufferColorFormat(createMediaCodecInternal, string);
                if (supportedByteBufferColorFormat == 0) {
                    LiteavLog.e(this.mTAG, "No supported color format");
                    return false;
                }
                a16.setInteger("color-format", supportedByteBufferColorFormat);
            }
            if (this.mUseByteBuffer) {
                surface = null;
            } else {
                surface = this.mExternalSurface;
                if (surface == null) {
                    surface = this.mOutputSurface;
                }
            }
            aVar.f119567a.configure(a16, surface, (MediaCrypto) null, 0);
            aVar.f119567a.setVideoScalingMode(1);
            aVar.f119567a.start();
            LiteavLog.i(this.mTAG, "Start MediaCodec(%s) success.", aVar.f119567a.getName());
            return true;
        } catch (Throwable th5) {
            LiteavLog.e(this.mTAG, "Start MediaCodec failed.", th5);
            destroyMediaCodec(aVar.f119567a);
            aVar.f119567a = null;
            e.c cVar = e.c.WARNING_VIDEO_DECODE_START_FAILED;
            if (th5 instanceof IllegalArgumentException) {
                cVar = e.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT;
                str = "VideoDecode: illegal argument, Start decoder failed";
            } else if (th5 instanceof IllegalStateException) {
                cVar = e.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE;
                str = "VideoDecode: illegal state, Start decoder failed";
            } else {
                str = "VideoDecode: Start decoder failed";
            }
            aVar.f119568b = cVar;
            aVar.f119569c = str;
            aVar.f119570d = th5;
            return false;
        }
    }

    private void destroyMediaCodec(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                try {
                    LiteavLog.i(this.mTAG, "mediaCodec stop");
                    mediaCodec.stop();
                    LiteavLog.i(this.mTAG, "mediaCodec release");
                    mediaCodec.release();
                } catch (Throwable th5) {
                    LiteavLog.e(this.mTAG, "release MediaCodec failed.", th5);
                }
            } catch (Throwable th6) {
                try {
                    LiteavLog.e(this.mTAG, "Stop MediaCodec failed." + th6.getMessage());
                    LiteavLog.i(this.mTAG, "mediaCodec release");
                    mediaCodec.release();
                } catch (Throwable th7) {
                    try {
                        LiteavLog.i(this.mTAG, "mediaCodec release");
                        mediaCodec.release();
                    } catch (Throwable th8) {
                        LiteavLog.e(this.mTAG, "release MediaCodec failed.", th8);
                    }
                    throw th7;
                }
            }
        }
    }

    private int drainDecodedFrameInternal() {
        int dequeueOutputBuffer;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= 3 || (dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, TimeUnit.MILLISECONDS.toMicros(10L))) == -1) {
                return -1;
            }
            if (dequeueOutputBuffer == -3) {
                LiteavLog.i(this.mTAG, "on output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                outputFormatChange();
            } else {
                if (dequeueOutputBuffer >= 0) {
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        LiteavLog.i(this.mTAG, "meet end of stream.");
                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                        return 1;
                    }
                    if (this.mUseByteBuffer) {
                        i3 = handleOutputBuffer(dequeueOutputBuffer);
                    }
                    this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                    if (this.mExternalSurface != null) {
                        long millis = TimeUnit.MICROSECONDS.toMillis(this.mBufferInfo.presentationTimeUs);
                        long j3 = this.mNativeVideoDecoderImplAndroid;
                        if (j3 != 0) {
                            nativeOnDecodedFrameWithSurface(j3, millis);
                        }
                    }
                    return i3;
                }
                LiteavLog.d(this.mTAG, "dequeueOutputBuffer get invalid index: %d", Integer.valueOf(dequeueOutputBuffer));
            }
            i16++;
        }
    }

    private boolean feedDataToMediaCodec(EncodedVideoFrame encodedVideoFrame) {
        boolean z16;
        ByteBuffer byteBuffer;
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        }
        if (encodedVideoFrame != null && (encodedVideoFrame.isEosFrame || ((byteBuffer = encodedVideoFrame.data) != null && byteBuffer.remaining() != 0))) {
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            if (inputBuffers != null && inputBuffers.length != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                LiteavLog.e(this.mTAG, "get invalid input buffers.");
                return false;
            }
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                return false;
            }
            if (!encodedVideoFrame.isEosFrame) {
                limitMaxDecFrameBufferingInH264Sps(encodedVideoFrame);
                int remaining = encodedVideoFrame.data.remaining();
                inputBuffers[dequeueInputBuffer].put(encodedVideoFrame.data);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, remaining, TimeUnit.MILLISECONDS.toMicros(encodedVideoFrame.pts), 0);
            } else {
                LiteavLog.i(this.mTAG, "feedDataToMediaCodec BUFFER_FLAG_END_OF_STREAM");
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            }
            return true;
        }
        LiteavLog.w(this.mTAG, "receive empty buffer.");
        return true;
    }

    private byte[] getSpsData(byte[] bArr, int[] iArr) {
        int i3 = 0;
        while (true) {
            if (i3 + 4 >= bArr.length || (i3 = EncodedVideoFrame.getNextNALHeaderPos(i3, ByteBuffer.wrap(bArr))) < 0) {
                break;
            }
            if ((bArr[i3] & 31) == 7) {
                iArr[0] = i3;
                break;
            }
        }
        int i16 = iArr[0];
        if (i16 < 0) {
            return null;
        }
        int length = bArr.length - i16;
        while (true) {
            int i17 = i16 + 3;
            if (i17 >= bArr.length) {
                break;
            }
            byte b16 = bArr[i16];
            if ((b16 != 0 || bArr[i16 + 1] != 0 || bArr[i16 + 2] != 1) && (b16 != 0 || bArr[i16 + 1] != 0 || bArr[i16 + 2] != 0 || bArr[i17] != 1)) {
                i16++;
            }
        }
        length = i16 - iArr[0];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, iArr[0], bArr2, 0, length);
        return bArr2;
    }

    private int getSupportedByteBufferColorFormat(MediaCodec mediaCodec, String str) {
        boolean z16 = false;
        boolean z17 = false;
        for (int i3 : mediaCodec.getCodecInfo().getCapabilitiesForType(str).colorFormats) {
            if (i3 == 19) {
                z16 = true;
            } else if (i3 == 21) {
                z17 = true;
            }
        }
        if (z16) {
            return 19;
        }
        if (!z17) {
            return 0;
        }
        return 21;
    }

    private void handleDecoderError(e.c cVar, String str) {
        LiteavLog.e(this.mTAG, str);
        long j3 = this.mNativeVideoDecoderImplAndroid;
        if (j3 != 0) {
            nativeOnDecodedFrameFailed(j3, e.a(cVar));
        }
    }

    private int handleOutputBuffer(int i3) {
        int value;
        int i16;
        int i17;
        int i18;
        synchronized (this) {
            ByteBuffer outputBuffer = this.mMediaCodec.getOutputBuffer(i3);
            outputBuffer.position(this.mBufferInfo.offset);
            MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
            outputBuffer.rewind();
            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            int integer = outputFormat.getInteger("color-format");
            if (integer == 19) {
                value = GLConstants.PixelFormatType.I420.getValue();
            } else if (integer == 21) {
                value = GLConstants.PixelFormatType.NV12.getValue();
            } else {
                handleDecoderError(e.c.WARNING_VIDEO_DECODE_ERROR_NOT_SUPPORT_PIXEL_FORMAT_TYPE, "Unsupported color format:".concat(String.valueOf(integer)));
                return -1;
            }
            int i19 = value;
            int integer2 = outputFormat.getInteger("width");
            int integer3 = outputFormat.getInteger("height");
            if (outputFormat.containsKey(NativeCodec.RIGHT) && outputFormat.containsKey(NativeCodec.LEFT)) {
                i16 = Math.abs(outputFormat.getInteger(NativeCodec.RIGHT) - outputFormat.getInteger(NativeCodec.LEFT)) + 1;
            } else {
                i16 = integer2;
            }
            if (outputFormat.containsKey(NativeCodec.BOTTOM) && outputFormat.containsKey(NativeCodec.TOP)) {
                i17 = Math.abs(outputFormat.getInteger(NativeCodec.BOTTOM) - outputFormat.getInteger(NativeCodec.TOP)) + 1;
            } else {
                i17 = integer3;
            }
            if (outputFormat.containsKey(NativeCodec.STRIDE)) {
                integer2 = outputFormat.getInteger(NativeCodec.STRIDE);
            }
            int i26 = integer2;
            if (outputFormat.containsKey(NativeCodec.SLICEHEIGHT)) {
                i18 = outputFormat.getInteger(NativeCodec.SLICEHEIGHT);
            } else {
                i18 = integer3;
            }
            long millis = TimeUnit.MICROSECONDS.toMillis(this.mBufferInfo.presentationTimeUs);
            long j3 = this.mNativeVideoDecoderImplAndroid;
            if (j3 != 0) {
                nativeOnByteBuffer(j3, i19, outputBuffer, this.mBufferInfo.size, i16, i17, i26, i18, millis);
            }
            return 0;
        }
    }

    private boolean initializeSurface(int i3) {
        LiteavLog.i(this.mTAG, "initialize surface");
        synchronized (this) {
            try {
                this.mSurfaceTexture = new SurfaceTexture(i3);
                this.mOutputSurface = new Surface(this.mSurfaceTexture);
                this.mSurfaceTexture.setOnFrameAvailableListener(this);
            } catch (Surface.OutOfResourcesException e16) {
                LiteavLog.e(this.mThrottlers.a("surface"), this.mTAG, "create SurfaceTexture failed.", e16);
                handleDecoderError(e.c.WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE, "VideoDecode: insufficient resource, Start decoder failed:" + e16.getMessage());
                return false;
            }
        }
        LiteavLog.i(this.mThrottlers.a("initializeSurface"), this.mTAG, "initializeSurface", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$limitMaxDecFrameBufferingInH264Sps$0(HardwareVideoDecoder2 hardwareVideoDecoder2, int i3, int i16, int i17, int i18) {
        LiteavLog.e(hardwareVideoDecoder2.mTAG, "frame cropping flag exist, crop[l:" + i3 + ",r:" + i16 + ",t:" + i17 + ",b:" + i18 + "]");
        hardwareVideoDecoder2.mEnableLimitMaxDecFrameBufferingInH264Sps = false;
        long j3 = hardwareVideoDecoder2.mNativeVideoDecoderImplAndroid;
        if (j3 != 0) {
            hardwareVideoDecoder2.nativeOnFrameFlagCropExist(j3, i3, i16, i17, i18);
        }
        return false;
    }

    private void limitMaxDecFrameBufferingInH264Sps(EncodedVideoFrame encodedVideoFrame) {
        byte[] a16;
        byte[] bArr;
        ByteBuffer b16;
        byte[] bArr2;
        boolean z16;
        byte b17;
        if (!encodedVideoFrame.isIDRFrame() || encodedVideoFrame.codecType != CodecType.H264 || !this.mEnableLimitMaxDecFrameBufferingInH264Sps || !this.mIsRealTime || (a16 = d.a(encodedVideoFrame.data.remaining())) == null) {
            return;
        }
        encodedVideoFrame.data.get(a16);
        encodedVideoFrame.data.rewind();
        int[] iArr = {-1};
        byte[] spsData = getSpsData(a16, iArr);
        if (spsData != null && iArr[0] >= 0) {
            try {
                com.tencent.liteav.videoconsumer.a.a aVar = this.mSPSModifier;
                a.InterfaceC5952a interfaceC5952a = new a.InterfaceC5952a(this) { // from class: com.tencent.liteav.videoconsumer2.a

                    /* renamed from: a, reason: collision with root package name */
                    private final HardwareVideoDecoder2 f119571a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f119571a = this;
                    }

                    @Override // com.tencent.liteav.videoconsumer.a.a.InterfaceC5952a
                    public final boolean a(int i3, int i16, int i17, int i18) {
                        return HardwareVideoDecoder2.lambda$limitMaxDecFrameBufferingInH264Sps$0(this.f119571a, i3, i16, i17, i18);
                    }
                };
                byte[] bArr3 = new byte[spsData.length];
                int i3 = 0;
                int i16 = 0;
                while (i3 < spsData.length) {
                    if (i3 < spsData.length - 3 && (b17 = spsData[i3]) == 0) {
                        int i17 = i3 + 1;
                        if (spsData[i17] == 0 && spsData[i3 + 2] == 3) {
                            int i18 = i3 + 3;
                            if (spsData[i18] <= 3) {
                                int i19 = i16 + 1;
                                bArr3[i16] = b17;
                                i16 = i19 + 1;
                                bArr3[i19] = spsData[i17];
                                i3 = i18;
                            }
                        }
                    }
                    bArr3[i16] = spsData[i3];
                    i3++;
                    i16++;
                }
                if (i16 != spsData.length) {
                    bArr2 = new byte[i16];
                    System.arraycopy(bArr3, 0, bArr2, 0, i16);
                } else {
                    bArr2 = null;
                }
                if (bArr2 != null) {
                    z16 = true;
                } else {
                    bArr2 = spsData;
                    z16 = false;
                }
                byte[] a17 = aVar.a(new ByteArrayInputStream(bArr2), interfaceC5952a);
                if (a17 != null && z16) {
                    a17 = com.tencent.liteav.videoconsumer.a.a.a(a17);
                }
                bArr = a17;
            } catch (Throwable th5) {
                LiteavLog.e(this.mTAG, "modify dec buffer error ", th5);
                bArr = null;
            }
            if (bArr == null || (b16 = d.b((a16.length - spsData.length) + bArr.length)) == null) {
                return;
            }
            encodedVideoFrame.data = b16;
            int i26 = iArr[0];
            if (i26 > 0) {
                b16.put(a16, 0, i26);
            }
            encodedVideoFrame.data.put(bArr);
            ByteBuffer byteBuffer = encodedVideoFrame.data;
            int i27 = iArr[0];
            byteBuffer.put(a16, spsData.length + i27, (a16.length - i27) - spsData.length);
            encodedVideoFrame.data.rewind();
        }
    }

    private native void nativeOnByteBuffer(long j3, int i3, ByteBuffer byteBuffer, int i16, int i17, int i18, int i19, int i26, long j16);

    private native void nativeOnDecodedFrameFailed(long j3, int i3);

    private native void nativeOnDecodedFrameWithSurface(long j3, long j16);

    private native void nativeOnFrameAvailable(long j3, long j16);

    private native void nativeOnFrameFlagCropExist(long j3, int i3, int i16, int i17, int i18);

    private void outputFormatChange() {
        LiteavLog.i(this.mTAG, "decode output format changed: ".concat(String.valueOf(this.mMediaCodec.getOutputFormat())));
    }

    private boolean startInternal() {
        a aVar = new a((byte) 0);
        if (!configureDecoder(aVar, this.mIsRealTime) && !configureDecoder(aVar, false)) {
            handleDecoderError(aVar.f119568b, "decoder config fail, message:" + aVar.f119569c + " exception:" + aVar.f119570d.getMessage());
            return false;
        }
        this.mMediaCodec = aVar.f119567a;
        this.mIsStarted = true;
        LiteavLog.i(this.mTAG, "Start succeed");
        return true;
    }

    private void uninitializeSurface() {
        LiteavLog.i(this.mTAG, "uninitialize surface");
        synchronized (this) {
            Surface surface = this.mOutputSurface;
            if (surface != null) {
                surface.release();
                this.mOutputSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }
    }

    public MediaCodec createMediaCodecInternal(boolean z16, String str) throws IOException {
        if (!z16) {
            return MediaCodec.createDecoderByType(str);
        }
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
            if (!mediaCodecInfo.isEncoder()) {
                for (String str2 : supportedTypes) {
                    if (str2.contains(str) && MediaCodecAbility.isSoftOnlyDecoder(mediaCodecInfo)) {
                        LiteavLog.i(this.mTAG, "Use soft only decoder:%s", mediaCodecInfo.getName());
                        return MediaCodec.createByCodecName(mediaCodecInfo.getName());
                    }
                }
            }
        }
        return MediaCodec.createDecoderByType(str);
    }

    public boolean decodeFrame(EncodedVideoFrame encodedVideoFrame) {
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        }
        if (encodedVideoFrame == null) {
            return true;
        }
        try {
            if (!feedDataToMediaCodec(encodedVideoFrame)) {
                encodedVideoFrame.release();
                return false;
            }
        } catch (Throwable th5) {
            LiteavLog.e(this.mTAG, "decode failed.", th5);
            handleDecoderError(e.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, "VideoDecode: decode error, restart decoder message:" + th5.getMessage());
        }
        encodedVideoFrame.release();
        return true;
    }

    public int drainDecodedFrame() {
        try {
            return drainDecodedFrameInternal();
        } catch (Throwable th5) {
            LiteavLog.e(this.mTAG, "decode failed.", th5);
            handleDecoderError(e.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, "VideoDecode: decode error, restart decoder message:" + th5.getMessage());
            return -1;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
            if (surfaceTexture2 != null && surfaceTexture2 == surfaceTexture) {
                long millis = TimeUnit.NANOSECONDS.toMillis(surfaceTexture.getTimestamp());
                if (millis == 0) {
                    millis = TimeUnit.MICROSECONDS.toMillis(this.mBufferInfo.presentationTimeUs);
                }
                long j3 = this.mNativeVideoDecoderImplAndroid;
                if (j3 != 0) {
                    nativeOnFrameAvailable(j3, millis);
                }
            }
        }
    }

    public void resetNativeHandle() {
        this.mNativeVideoDecoderImplAndroid = 0L;
    }

    public void setEnableVui(boolean z16) {
        this.mEnableLimitMaxDecFrameBufferingInH264Sps = z16;
    }

    public boolean start(int i3) {
        if (this.mIsStarted) {
            return true;
        }
        LiteavLog.i(this.mTAG, "Start: texture_id = %d", Integer.valueOf(i3));
        if (this.mUseByteBuffer || initializeSurface(i3)) {
            return startInternal();
        }
        return false;
    }

    public void stop() {
        LiteavLog.i(this.mTAG, "stop");
        if (!this.mIsStarted) {
            return;
        }
        destroyMediaCodec(this.mMediaCodec);
        this.mMediaCodec = null;
        uninitializeSurface();
        this.mIsStarted = false;
        this.mExternalSurface = null;
    }

    public float[] updateTexImage() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return null;
        }
        try {
            float[] fArr = new float[16];
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(fArr);
            return fArr;
        } catch (Throwable th5) {
            LiteavLog.w(this.mThrottlers.a("updateImage"), this.mTAG, "updateTexImage exception: ".concat(String.valueOf(th5)), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public MediaCodec f119567a;

        /* renamed from: b, reason: collision with root package name */
        public e.c f119568b;

        /* renamed from: c, reason: collision with root package name */
        public String f119569c;

        /* renamed from: d, reason: collision with root package name */
        public Throwable f119570d;

        a() {
            this.f119567a = null;
            this.f119568b = null;
            this.f119569c = null;
            this.f119570d = null;
        }

        /* synthetic */ a(byte b16) {
            this();
        }
    }

    public boolean start(Surface surface) {
        if (this.mIsStarted) {
            return true;
        }
        LiteavLog.i(this.mTAG, "Start with surface ".concat(String.valueOf(surface)));
        if (surface == null) {
            return false;
        }
        this.mExternalSurface = surface;
        return startInternal();
    }
}
