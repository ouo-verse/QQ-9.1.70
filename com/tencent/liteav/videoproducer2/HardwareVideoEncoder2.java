package com.tencent.liteav.videoproducer2;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.h;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.b;
import com.tencent.liteav.videoproducer.encoder.e;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class HardwareVideoEncoder2 {
    private EGLCore mEGLCore;
    private Surface mInputSurface;
    private long mNativeHandler;
    private final VideoEncodeParams mParams;
    private h mPixelFrameRenderer;
    private HWEncoderServerConfig mServerConfig;
    private b mSurfaceInputVideoEncoder;
    private String mTAG;
    private String mTraceId;
    private final Size mSurfaceSize = new Size(0, 0);
    private final AtomicBoolean mNeedRestart = new AtomicBoolean(false);
    private final Bundle mSessionStates = new Bundle();
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    private long mPreFrameTimeStamp = 0;
    private final e.a mVideoEncoderListener = new e.a() { // from class: com.tencent.liteav.videoproducer2.HardwareVideoEncoder2.1
        @Override // com.tencent.liteav.videoproducer.encoder.e.a
        public final void a() {
            HardwareVideoEncoder2.this.mNeedRestart.set(true);
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
        public final void onBitrateModeUpdated(VideoEncoderDef.BitrateMode bitrateMode) {
            HardwareVideoEncoder2 hardwareVideoEncoder2 = HardwareVideoEncoder2.this;
            hardwareVideoEncoder2.nativeOnBitrateModeUpdated(hardwareVideoEncoder2.mNativeHandler, bitrateMode.mValue);
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
        public final void onEncodedFail(e.a aVar) {
            e.a aVar2 = e.a.ERR_CODE_NONE;
            HardwareVideoEncoder2.this.notifyEncodeFail();
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
        public final synchronized void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z16) {
            boolean z17;
            int intValue;
            if (HardwareVideoEncoder2.this.mNativeHandler != 0 && !z16) {
                HardwareVideoEncoder2 hardwareVideoEncoder2 = HardwareVideoEncoder2.this;
                long j3 = hardwareVideoEncoder2.mNativeHandler;
                ByteBuffer byteBuffer = encodedVideoFrame.data;
                int i3 = encodedVideoFrame.nalType.mValue;
                int i16 = encodedVideoFrame.profileType.mValue;
                int i17 = encodedVideoFrame.codecType.mValue;
                int i18 = encodedVideoFrame.rotation;
                long j16 = encodedVideoFrame.dts;
                long j17 = encodedVideoFrame.pts;
                long j18 = encodedVideoFrame.gopIndex;
                long j19 = encodedVideoFrame.gopFrameIndex;
                long j26 = encodedVideoFrame.frameIndex;
                long j27 = encodedVideoFrame.refFrameIndex;
                int i19 = encodedVideoFrame.width;
                int i26 = encodedVideoFrame.height;
                Integer num = encodedVideoFrame.svcInfo;
                if (num != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                hardwareVideoEncoder2.nativeOnEncodedNAL(j3, encodedVideoFrame, byteBuffer, i3, i16, i17, i18, j16, j17, j18, j19, j26, j27, i19, i26, z17, intValue);
                return;
            }
            LiteavLog.d(HardwareVideoEncoder2.this.mTAG, "onEncodedNAL mNativeHandler=%d,isEos=%b", Long.valueOf(HardwareVideoEncoder2.this.mNativeHandler), Boolean.valueOf(z16));
        }
    };

    public HardwareVideoEncoder2(long j3, String str, VideoEncodeParams videoEncodeParams) {
        this.mTraceId = str;
        this.mTAG = str + "HardwareVideoEncoder2_" + hashCode();
        this.mNativeHandler = j3;
        this.mParams = videoEncodeParams;
    }

    public static PixelFrame createPixelFrameByTexture(int i3, int i16, int i17, int i18, long j3, int i19, boolean z16, boolean z17, int i26, Object obj) {
        int i27 = GLConstants.a.TEXTURE_2D.mValue;
        GLConstants.PixelFormatType.RGBA.getValue();
        PixelFrame pixelFrame = new PixelFrame(i3, i16, 0, i17, i18);
        pixelFrame.setMirrorHorizontal(z16);
        pixelFrame.setMirrorVertical(z17);
        pixelFrame.setTextureId(i26);
        pixelFrame.setGLContext(obj);
        pixelFrame.setRotation(k.a(i19));
        pixelFrame.setTimestamp(j3);
        return pixelFrame;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: d -> 0x00bb, TryCatch #0 {d -> 0x00bb, blocks: (B:6:0x0005, B:8:0x0017, B:11:0x0020, B:14:0x0028, B:15:0x0037, B:17:0x0044, B:18:0x004a, B:20:0x0058, B:21:0x0061, B:23:0x007d, B:24:0x00a0, B:28:0x002c, B:31:0x0034), top: B:5:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[Catch: d -> 0x00bb, TryCatch #0 {d -> 0x00bb, blocks: (B:6:0x0005, B:8:0x0017, B:11:0x0020, B:14:0x0028, B:15:0x0037, B:17:0x0044, B:18:0x004a, B:20:0x0058, B:21:0x0061, B:23:0x007d, B:24:0x00a0, B:28:0x002c, B:31:0x0034), top: B:5:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d A[Catch: d -> 0x00bb, TryCatch #0 {d -> 0x00bb, blocks: (B:6:0x0005, B:8:0x0017, B:11:0x0020, B:14:0x0028, B:15:0x0037, B:17:0x0044, B:18:0x004a, B:20:0x0058, B:21:0x0061, B:23:0x007d, B:24:0x00a0, B:28:0x002c, B:31:0x0034), top: B:5:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawFrameToInputSurface(PixelFrame pixelFrame) {
        h hVar;
        b bVar;
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore == null) {
            return;
        }
        try {
            eGLCore.makeCurrent();
            PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
            boolean z16 = true;
            if (pixelFrame2.getRotation() != k.ROTATION_90 && pixelFrame2.getRotation() != k.ROTATION_270) {
                if (pixelFrame2.isMirrorVertical()) {
                    z16 = false;
                }
                pixelFrame2.setMirrorVertical(z16);
                Size size = this.mSurfaceSize;
                OpenGlUtils.glViewport(0, 0, size.width, size.height);
                hVar = this.mPixelFrameRenderer;
                if (hVar != null) {
                    hVar.a(pixelFrame2, GLConstants.GLScaleType.CENTER_CROP, (d) null);
                }
                bVar = this.mSurfaceInputVideoEncoder;
                long timestamp = pixelFrame2.getTimestamp();
                if (bVar.f119701i.isEmpty()) {
                    bVar.f119702j.set(SystemClock.elapsedRealtime());
                }
                bVar.f119701i.addLast(Long.valueOf(timestamp));
                bVar.f119695c.sendEmptyMessageDelayed(10, 10L);
                if (pixelFrame2.getTimestamp() < this.mPreFrameTimeStamp) {
                    LiteavLog.e(this.mTAG, "timestamp is not increase. pre: " + this.mPreFrameTimeStamp + ", cur: " + pixelFrame2.getTimestamp());
                }
                this.mPreFrameTimeStamp = pixelFrame2.getTimestamp();
                this.mEGLCore.setPresentationTime(TimeUnit.MILLISECONDS.toNanos(pixelFrame2.getTimestamp()));
                this.mEGLCore.swapBuffers();
            }
            if (pixelFrame2.isMirrorHorizontal()) {
                z16 = false;
            }
            pixelFrame2.setMirrorHorizontal(z16);
            Size size2 = this.mSurfaceSize;
            OpenGlUtils.glViewport(0, 0, size2.width, size2.height);
            hVar = this.mPixelFrameRenderer;
            if (hVar != null) {
            }
            bVar = this.mSurfaceInputVideoEncoder;
            long timestamp2 = pixelFrame2.getTimestamp();
            if (bVar.f119701i.isEmpty()) {
            }
            bVar.f119701i.addLast(Long.valueOf(timestamp2));
            bVar.f119695c.sendEmptyMessageDelayed(10, 10L);
            if (pixelFrame2.getTimestamp() < this.mPreFrameTimeStamp) {
            }
            this.mPreFrameTimeStamp = pixelFrame2.getTimestamp();
            this.mEGLCore.setPresentationTime(TimeUnit.MILLISECONDS.toNanos(pixelFrame2.getTimestamp()));
            this.mEGLCore.swapBuffers();
        } catch (com.tencent.liteav.videobase.egl.d e16) {
            LiteavLog.e(this.mThrottlers.a("EncodeFrameError"), this.mTAG, "makeCurrent failed. error = ".concat(String.valueOf("VideoEncode: swapBuffer error, EGLCode:" + e16.mErrorCode + " message:" + e16.getMessage())), e16);
            notifyEncodeFail();
        }
    }

    public static Object getCurrentContext() {
        return OpenGlUtils.getCurrentContext();
    }

    private ServerVideoProducerConfig getServerVideoProducerConfig(HWEncoderServerConfig hWEncoderServerConfig) {
        ServerVideoProducerConfig serverVideoProducerConfig = new ServerVideoProducerConfig();
        serverVideoProducerConfig.setHardwareEncodeType(hWEncoderServerConfig.getHardwareEncodeType());
        serverVideoProducerConfig.setHardwareEncoderHighProfileEnable(hWEncoderServerConfig.getHardwareEncoderHighProfileEnable());
        serverVideoProducerConfig.setHardwareEncoderHighProfileSupport(hWEncoderServerConfig.getHardwareEncoderHighProfileSupport());
        Boolean isHardwareEncoderBitrateModeCBRSupported = hWEncoderServerConfig.isHardwareEncoderBitrateModeCBRSupported();
        if (isHardwareEncoderBitrateModeCBRSupported != null) {
            serverVideoProducerConfig.setHardwareEncoderBitrateModeCBRSupported(isHardwareEncoderBitrateModeCBRSupported.booleanValue());
        }
        return serverVideoProducerConfig;
    }

    private boolean initOpenGLComponents(Object obj, Surface surface) {
        if (surface == null) {
            LiteavLog.w(this.mThrottlers.a("NoSurface"), this.mTAG, "init opengl: surface is null.", new Object[0]);
            return false;
        }
        LiteavLog.d(this.mThrottlers.a("initGL"), this.mTAG, "initOpenGLComponents", new Object[0]);
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            Size size = this.mSurfaceSize;
            eGLCore.initialize(obj, surface, size.width, size.height);
            Size size2 = this.mSurfaceSize;
            this.mPixelFrameRenderer = new h(size2.width, size2.height);
            return true;
        } catch (com.tencent.liteav.videobase.egl.d e16) {
            LiteavLog.e(this.mThrottlers.a("initGLError"), this.mTAG, "create EGLCore failed. error = ".concat(String.valueOf("VideoEncode: create EGLCore failed, EGLCode:" + e16.mErrorCode + " message:" + e16.getMessage())), e16);
            notifyStartEncodedFail();
            this.mEGLCore = null;
            return false;
        }
    }

    public static boolean isInUIThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnBitrateModeUpdated(long j3, int i3);

    private native void nativeOnEncodedFail(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnEncodedNAL(long j3, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i3, int i16, int i17, int i18, long j16, long j17, long j18, long j19, long j26, long j27, int i19, int i26, boolean z16, int i27);

    private native void nativeOnStartEncodedFail(long j3);

    private boolean restart() {
        LiteavLog.d(this.mTAG, "reStart");
        stop();
        return start();
    }

    private boolean start() {
        if (this.mSurfaceInputVideoEncoder != null) {
            if (this.mInputSurface == null) {
                return false;
            }
            return true;
        }
        LiteavLog.i(this.mTAG, "Start hw video encoder. %s", this.mParams);
        b bVar = new b(this.mSessionStates, new com.tencent.liteav.videobase.videobase.d(), this.mTraceId);
        this.mSurfaceInputVideoEncoder = bVar;
        bVar.f119695c = new CustomHandler(Looper.myLooper()) { // from class: com.tencent.liteav.videoproducer.encoder.b.1
            public AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 10) {
                    b.this.c();
                }
            }
        };
        this.mSurfaceInputVideoEncoder.a(getServerVideoProducerConfig(this.mServerConfig));
        b bVar2 = this.mSurfaceInputVideoEncoder;
        VideoEncodeParams videoEncodeParams = this.mParams;
        e.a aVar = this.mVideoEncoderListener;
        LiteavLog.d(bVar2.f119693a, "start");
        bVar2.f119697e = aVar;
        Surface a16 = bVar2.a(videoEncodeParams);
        LiteavLog.i(bVar2.f119693a, "startCodecInternal success");
        Size size = new Size(720, 1280);
        VideoEncodeParams videoEncodeParams2 = bVar2.f119698f;
        if (videoEncodeParams2 != null) {
            size.set(videoEncodeParams2.width, videoEncodeParams2.height);
        }
        Pair pair = new Pair(a16, size);
        this.mInputSurface = (Surface) pair.first;
        this.mSurfaceSize.set((Size) pair.second);
        if (this.mInputSurface != null) {
            return true;
        }
        notifyStartEncodedFail();
        return false;
    }

    private void stop() {
        uninitOpenGLComponents();
        Surface surface = this.mInputSurface;
        if (surface != null) {
            surface.release();
            this.mInputSurface = null;
        }
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            LiteavLog.i(bVar.f119693a, "stop");
            bVar.b();
            bVar.a();
            this.mSurfaceInputVideoEncoder.a();
            this.mSurfaceInputVideoEncoder = null;
        }
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        if (this.mNeedRestart.getAndSet(false) && !restart()) {
            return;
        }
        if (this.mSurfaceInputVideoEncoder == null && !start()) {
            return;
        }
        pixelFrame.getGLContext();
        if (this.mEGLCore == null && !initOpenGLComponents(pixelFrame.getGLContext(), this.mInputSurface)) {
            return;
        }
        this.mSurfaceInputVideoEncoder.c();
        drawFrameToInputSurface(pixelFrame);
    }

    public synchronized void notifyEncodeFail() {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnEncodedFail(j3);
        }
    }

    public synchronized void notifyStartEncodedFail() {
        long j3 = this.mNativeHandler;
        if (j3 != 0) {
            nativeOnStartEncodedFail(j3);
        }
    }

    public synchronized void release() {
        LiteavLog.d(this.mTAG, "release");
        this.mNativeHandler = 0L;
        stop();
    }

    public void requestKeyFrame() {
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void setBitrate(int i3) {
        MediaCodec mediaCodec;
        LiteavLog.i(this.mTAG, "SetBitrate ".concat(String.valueOf(i3)));
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar == null) {
            this.mParams.bitrate = i3;
            return;
        }
        VideoEncodeParams videoEncodeParams = bVar.f119698f;
        if (videoEncodeParams == null) {
            LiteavLog.w(bVar.f119693a, "encoder not started yet. set bitrate to " + i3 + " kbps will not take effect.");
            return;
        }
        if (videoEncodeParams.bitrate != i3) {
            LiteavLog.i(bVar.f119693a, "set bitrate to " + i3 + " kbps");
            boolean z16 = false;
            if (i3 < bVar.f119698f.bitrate) {
                if (bVar.f119694b.getBoolean("need_restart_when_down_bitrate", false)) {
                    z16 = true;
                } else {
                    bVar.a(i3);
                }
            }
            bVar.f119698f.bitrate = i3;
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 19 && (mediaCodec = bVar.f119696d) != null) {
                if (z16) {
                    bVar.f119695c.removeCallbacks(bVar.f119703k);
                    long elapsedRealtime = SystemClock.elapsedRealtime() - bVar.f119699g;
                    if (elapsedRealtime >= TimeUnit.SECONDS.toMillis(2L)) {
                        bVar.f119703k.run();
                        return;
                    } else {
                        bVar.f119695c.postDelayed(bVar.f119703k, 2000 - elapsedRealtime);
                        return;
                    }
                }
                bVar.a(mediaCodec, i3);
            }
        }
    }

    public void setHWEncoderServerConfig(HWEncoderServerConfig hWEncoderServerConfig) {
        this.mServerConfig = hWEncoderServerConfig;
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            bVar.a(getServerVideoProducerConfig(hWEncoderServerConfig));
        }
    }

    public void signalEndOfStream() {
        final b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            LiteavLog.i(bVar.f119693a, "signalEndOfStream");
            MediaCodec mediaCodec = bVar.f119696d;
            if (mediaCodec != null) {
                try {
                    mediaCodec.signalEndOfInputStream();
                } catch (Throwable th5) {
                    LiteavLog.e(bVar.f119693a, "signalEndOfStream failed.", th5);
                }
            }
            if (bVar.f119700h == null) {
                r rVar = new r(Looper.myLooper(), new r.a(bVar) { // from class: com.tencent.liteav.videoproducer.encoder.d

                    /* renamed from: a, reason: collision with root package name */
                    private final b f119721a;

                    {
                        this.f119721a = bVar;
                    }

                    @Override // com.tencent.liteav.base.util.r.a
                    public final void onTimeout() {
                        this.f119721a.c();
                    }
                });
                bVar.f119700h = rVar;
                rVar.a(30);
            }
        }
    }

    public void uninitOpenGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        LiteavLog.d(this.mThrottlers.a("uninitGL"), this.mTAG, "uninitOpenGLComponents", new Object[0]);
        try {
            this.mEGLCore.makeCurrent();
            h hVar = this.mPixelFrameRenderer;
            if (hVar != null) {
                hVar.a();
                this.mPixelFrameRenderer = null;
            }
        } catch (com.tencent.liteav.videobase.egl.d e16) {
            LiteavLog.e(this.mThrottlers.a("unintGLError"), this.mTAG, "makeCurrent failed.", e16);
        }
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
    }
}
