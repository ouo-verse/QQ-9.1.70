package org.tencwebrtc;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.gamematrix.gmvideofilter.VideoFilter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.RendererCommon;
import org.tencwebrtc.VideoDecoder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EglRenderer implements VideoSink {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final String TAG = "EglRenderer";
    private static boolean debugLogEnabled;
    private static boolean isFirstFrameDecoded;
    public static VideoDecoder.DecodeCallback mDecodeCb;
    private static int mDegree;
    private static PerfCallBack mPerfCb;
    private final int DECODE_LENGTH;
    private final int SEI_EXTENDED_LENGTH;
    private final int SEI_LENGTH;
    private final int UUID_LENGTH;
    private final GlTextureFrameBuffer bitmapTextureFramebuffer;
    private final Matrix drawMatrix;

    @Nullable
    private RendererCommon.GlDrawer drawer;

    @Nullable
    private EglBase eglBase;
    private final EglSurfaceCreation eglSurfaceCreationRunnable;
    private final Object fpsReductionLock;
    private final VideoFrameDrawer frameDrawer;
    private final ArrayList<FrameListenerAndParams> frameListeners;
    private final Object frameLock;
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    private final Object handlerLock;
    private float layoutAspectRatio;
    private final Object layoutLock;
    private final Runnable logStatisticsRunnable;
    private int mEncodeNumber;
    private int mRotate;
    private long minRenderPeriodNs;
    private boolean mirrorHorizontally;
    private boolean mirrorVertically;
    protected final String name;
    private long nextFrameTimeNs;

    @Nullable
    private VideoFrame pendingFrame;
    private long renderSwapBufferTimeNs;

    @Nullable
    private Handler renderThreadHandler;
    private long renderTimeMs;
    private long renderTimeNs;
    private final Object statisticsLock;
    private long statisticsStartTimeNs;
    private boolean usePresentationTimeStamp;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class EglSurfaceCreation implements Runnable {
        private Object surface;

        EglSurfaceCreation() {
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                if (this.surface != null && EglRenderer.this.eglBase != null && !EglRenderer.this.eglBase.hasSurface()) {
                    Object obj = this.surface;
                    if (obj instanceof Surface) {
                        EglRenderer.this.eglBase.createSurface((Surface) this.surface);
                    } else if (obj instanceof SurfaceTexture) {
                        EglRenderer.this.eglBase.createSurface((SurfaceTexture) this.surface);
                    } else {
                        throw new IllegalStateException("Invalid surface: " + this.surface);
                    }
                    EglRenderer.this.eglBase.makeCurrent();
                    GLES20.glPixelStorei(3317, 1);
                }
            } catch (Exception e16) {
                Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread(EglSurfaceCreation)", e16);
            }
        }

        public synchronized void setSurface(Object obj) {
            this.surface = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface FrameListener {
        void onFrame(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener frameListener, float f16, RendererCommon.GlDrawer glDrawer, boolean z16) {
            this.listener = frameListener;
            this.scale = f16;
            this.drawer = glDrawer;
            this.applyFpsReduction = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class HandlerWithExceptionCallback extends Handler {
        private final Runnable exceptionCallback;

        public HandlerWithExceptionCallback(Looper looper, Runnable runnable) {
            super(looper);
            this.exceptionCallback = runnable;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e16) {
                Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e16);
                this.exceptionCallback.run();
                throw e16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface PerfCallBack {
        void onPerfCb(byte[] bArr, int i3);
    }

    public EglRenderer(String str) {
        this(str, new VideoFrameDrawer());
        mDegree = 0;
        isFirstFrameDecoded = false;
    }

    private String averageTimeAsString(long j3, int i3) {
        if (i3 <= 0) {
            return "NA";
        }
        return TimeUnit.NANOSECONDS.toMicros(j3 / i3) + " us";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearSurfaceOnRenderThread, reason: merged with bridge method [inline-methods] */
    public void lambda$clearImage$6(float f16, float f17, float f18, float f19) {
        EglBase eglBase = this.eglBase;
        if (eglBase != null && eglBase.hasSurface()) {
            logD("clearSurface");
            GLES20.glClearColor(f16, f17, f18, f19);
            GLES20.glClear(16384);
            this.eglBase.swapBuffers();
        }
    }

    private void createEglSurfaceInternal(Object obj) {
        this.eglSurfaceCreationRunnable.setSurface(obj);
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    public static void enableLogToDebugOutput(boolean z16) {
        debugLogEnabled = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFrameListener$3(RendererCommon.GlDrawer glDrawer, FrameListener frameListener, float f16, boolean z16) {
        if (glDrawer == null) {
            glDrawer = this.drawer;
        }
        this.frameListeners.add(new FrameListenerAndParams(frameListener, f16, glDrawer, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(EglBase.Context context, int[] iArr) {
        if (context == null) {
            logD("EglBase10.create context");
            this.eglBase = g.f(iArr);
        } else {
            logD("EglBase.create shared context");
            this.eglBase = g.c(context, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1(CountDownLatch countDownLatch) {
        GLES20.glUseProgram(0);
        RendererCommon.GlDrawer glDrawer = this.drawer;
        if (glDrawer != null) {
            glDrawer.release();
            this.drawer = null;
        }
        this.frameDrawer.release();
        this.bitmapTextureFramebuffer.release();
        if (this.eglBase != null) {
            logD("eglBase detach and release.");
            this.eglBase.detachCurrent();
            this.eglBase.release();
            this.eglBase = null;
        }
        this.frameListeners.clear();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(Looper looper) {
        logD("Quitting render thread.");
        looper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseEglSurface$5(Runnable runnable) {
        EglBase eglBase = this.eglBase;
        if (eglBase != null) {
            eglBase.detachCurrent();
            this.eglBase.releaseSurface();
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeFrameListener$4(CountDownLatch countDownLatch, FrameListener frameListener) {
        countDownLatch.countDown();
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            if (it.next().listener == frameListener) {
                it.remove();
            }
        }
    }

    private void logD(String str) {
        if (debugLogEnabled) {
            Logging.v(TAG, this.name + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logStatistics() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        long nanoTime = System.nanoTime();
        synchronized (this.statisticsLock) {
            long j3 = nanoTime - this.statisticsStartTimeNs;
            if (j3 <= 0) {
                return;
            }
            logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(j3) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + decimalFormat.format(((float) (this.framesRendered * TimeUnit.SECONDS.toNanos(1L))) / ((float) j3)) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
            resetStatistics(nanoTime);
        }
    }

    private void logW(String str) {
        Logging.w(TAG, this.name + str);
    }

    private void notifyCallbacks(VideoFrame videoFrame, boolean z16) {
        float f16;
        float f17;
        if (this.frameListeners.isEmpty()) {
            return;
        }
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        Matrix matrix = this.drawMatrix;
        if (this.mirrorHorizontally) {
            f16 = -1.0f;
        } else {
            f16 = 1.0f;
        }
        if (this.mirrorVertically) {
            f17 = -1.0f;
        } else {
            f17 = 1.0f;
        }
        matrix.preScale(f16, f17);
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            FrameListenerAndParams next = it.next();
            if (z16 || !next.applyFpsReduction) {
                it.remove();
                int rotatedWidth = (int) (next.scale * videoFrame.getRotatedWidth());
                int rotatedHeight = (int) (next.scale * videoFrame.getRotatedHeight());
                if (rotatedWidth != 0 && rotatedHeight != 0) {
                    this.bitmapTextureFramebuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                    GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.bitmapTextureFramebuffer.getTextureId(), 0);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                    this.frameDrawer.drawFrame(videoFrame, next.drawer, this.drawMatrix, 0, 0, rotatedWidth, rotatedHeight);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
                    GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
                    GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                    Bitmap createBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocateDirect);
                    next.listener.onFrame(createBitmap);
                } else {
                    next.listener.onFrame(null);
                }
            }
        }
        FTrace.endTrace();
    }

    private void postToRenderThread(Runnable runnable) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFrameOnRenderThread() {
        boolean z16;
        float f16;
        float f17;
        float f18;
        EglRenderer eglRenderer;
        VideoFrame videoFrame;
        boolean z17;
        int i3;
        int i16;
        long j3;
        int i17;
        short s16;
        short s17;
        short s18;
        int i18;
        short s19;
        short s26;
        short s27;
        short s28;
        short s29;
        short s36;
        short s37;
        short s38;
        short s39;
        short s46;
        short s47;
        try {
            synchronized (this.frameLock) {
                VideoFrame videoFrame2 = this.pendingFrame;
                if (videoFrame2 == null) {
                    return;
                }
                this.pendingFrame = null;
                EglBase eglBase = this.eglBase;
                if (eglBase != null && eglBase.hasSurface()) {
                    synchronized (this.fpsReductionLock) {
                        long j16 = this.minRenderPeriodNs;
                        if (j16 != Long.MAX_VALUE) {
                            if (j16 > 0) {
                                long nanoTime = System.nanoTime();
                                long j17 = this.nextFrameTimeNs;
                                if (nanoTime < j17) {
                                    logD("Skipping frame rendering - fps reduction is active.");
                                } else {
                                    long j18 = j17 + this.minRenderPeriodNs;
                                    this.nextFrameTimeNs = j18;
                                    this.nextFrameTimeNs = Math.max(j18, nanoTime);
                                }
                            }
                            z16 = true;
                        }
                        z16 = false;
                    }
                    long nanoTime2 = System.nanoTime();
                    FTrace.startTrace("EglRenderer.renderFrameOnRenderThread pts=%d", Long.valueOf(videoFrame2.getTimestampNs() / 1000));
                    float rotatedWidth = videoFrame2.getRotatedWidth() / videoFrame2.getRotatedHeight();
                    synchronized (this.layoutLock) {
                        f16 = this.layoutAspectRatio;
                        if (f16 == 0.0f) {
                            f16 = rotatedWidth;
                        }
                    }
                    if (rotatedWidth > f16) {
                        f18 = f16 / rotatedWidth;
                        f17 = 1.0f;
                    } else {
                        f17 = rotatedWidth / f16;
                        f18 = 1.0f;
                    }
                    byte[] latencyTimestamp = videoFrame2.getLatencyTimestamp();
                    if (latencyTimestamp != null) {
                        this.mRotate = latencyTimestamp[18];
                    }
                    this.drawMatrix.reset();
                    this.drawMatrix.preTranslate(0.5f, 0.5f);
                    this.drawMatrix.preScale(this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
                    this.drawMatrix.preScale(f18, f17);
                    this.drawMatrix.preTranslate(-0.5f, -0.5f);
                    if (debugLogEnabled) {
                        Logging.v(TAG, " mRotate=" + this.mRotate + " mDegree=" + mDegree);
                    }
                    int i19 = mDegree;
                    if (i19 != 0 && i19 != 360 && videoFrame2.getBuffer().getWidth() < videoFrame2.getBuffer().getHeight()) {
                        this.drawMatrix.postRotate(360 - mDegree, 0.5f, 0.5f);
                    }
                    if (z16) {
                        try {
                            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                            GLES20.glClear(16384);
                            boolean z18 = z16;
                            this.frameDrawer.drawFrame(videoFrame2, this.drawer, this.drawMatrix, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight());
                            long nanoTime3 = System.nanoTime();
                            if (debugLogEnabled) {
                                Logging.v(TAG, "timestamp=" + (videoFrame2.getTimestampNs() / 1000000));
                            }
                            if (this.usePresentationTimeStamp) {
                                this.eglBase.swapBuffers(videoFrame2.getTimestampNs());
                            } else {
                                this.eglBase.swapBuffers();
                            }
                            long nanoTime4 = System.nanoTime();
                            synchronized (this.statisticsLock) {
                                this.framesRendered++;
                                long j19 = nanoTime4 - nanoTime2;
                                this.renderTimeNs += j19;
                                long j26 = j19 / 1000000;
                                this.renderTimeMs = j26;
                                this.renderSwapBufferTimeNs += nanoTime4 - nanoTime3;
                                if (VideoFilter.isFsrEnabled_) {
                                    VideoFilter.updateRenderTime(j26);
                                }
                            }
                            if (latencyTimestamp == null || latencyTimestamp.length < 48) {
                                eglRenderer = this;
                                videoFrame = videoFrame2;
                            } else {
                                if (debugLogEnabled) {
                                    Logging.v(TAG, "sei length = " + latencyTimestamp.length);
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                if (debugLogEnabled) {
                                    StringBuilder sb5 = new StringBuilder();
                                    for (int i26 = 0; i26 < latencyTimestamp.length; i26++) {
                                        String hexString = Integer.toHexString(latencyTimestamp[i26] & 255);
                                        if (hexString.length() == 1) {
                                            hexString = "0" + hexString;
                                        }
                                        if (i26 % 8 == 0) {
                                            sb5.append(" ");
                                        }
                                        sb5.append(hexString);
                                    }
                                    Logging.v(TAG, sb5.toString());
                                }
                                ByteBuffer wrap = ByteBuffer.wrap(latencyTimestamp);
                                wrap.order(ByteOrder.LITTLE_ENDIAN);
                                int i27 = wrap.getInt();
                                int i28 = wrap.getInt();
                                long j27 = wrap.getLong();
                                short s48 = wrap.getShort();
                                byte b16 = wrap.get();
                                byte b17 = wrap.get();
                                int i29 = wrap.getInt();
                                this.mEncodeNumber = i28;
                                byte b18 = b16;
                                long j28 = wrap.getLong();
                                if (j28 > 0) {
                                    long j29 = nanoTime4 / 1000000;
                                    j3 = j27;
                                    s16 = (short) (j29 - j28);
                                    i17 = i29;
                                    StringBuilder sb6 = new StringBuilder();
                                    i16 = i28;
                                    sb6.append(" latencyMs=");
                                    sb6.append((int) s16);
                                    sb6.append(" startMs=");
                                    sb6.append(j28);
                                    sb6.append(" currMs=");
                                    sb6.append(j29);
                                    sb6.append(" timestamp=");
                                    i3 = i27;
                                    sb6.append(videoFrame2.getTimestampNs() / 1000000);
                                    Logging.w(TAG, sb6.toString());
                                    if (debugLogEnabled) {
                                        Logging.v(TAG, " latencyMs=" + ((int) s16) + " startMs=" + j28 + " currMs=" + j29 + " timestamp=" + (videoFrame2.getTimestampNs() / 1000000));
                                    }
                                } else {
                                    i3 = i27;
                                    i16 = i28;
                                    j3 = j27;
                                    i17 = i29;
                                    s16 = -1;
                                }
                                short s49 = b17;
                                if (latencyTimestamp.length >= 64) {
                                    s18 = wrap.getShort();
                                    s17 = wrap.getShort();
                                    i18 = wrap.getInt();
                                    s19 = wrap.getShort();
                                    s26 = wrap.getShort();
                                    s27 = wrap.getShort();
                                    s28 = wrap.getShort();
                                } else {
                                    s17 = s49;
                                    s18 = 0;
                                    i18 = 0;
                                    s19 = 0;
                                    s26 = 0;
                                    s27 = 0;
                                    s28 = 0;
                                }
                                int i36 = wrap.getInt();
                                short s56 = wrap.getShort();
                                short s57 = s28;
                                short s58 = wrap.getShort();
                                short s59 = s26;
                                short s65 = s27;
                                long j36 = wrap.getLong();
                                short s66 = (short) (currentTimeMillis - j36);
                                short s67 = (short) this.renderTimeMs;
                                if (debugLogEnabled) {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("");
                                    sb7.append("render number            : ");
                                    int i37 = i3;
                                    sb7.append(i37);
                                    i3 = i37;
                                    sb7.append("\n");
                                    String sb8 = sb7.toString();
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append(sb8);
                                    sb9.append("encode number            : ");
                                    int i38 = i16;
                                    sb9.append(i38);
                                    i16 = i38;
                                    sb9.append("\n");
                                    String sb10 = sb9.toString();
                                    StringBuilder sb11 = new StringBuilder();
                                    sb11.append(sb10);
                                    sb11.append("encode start             : ");
                                    s29 = s18;
                                    short s68 = s17;
                                    long j37 = j3;
                                    sb11.append(j37);
                                    j3 = j37;
                                    sb11.append("\n");
                                    String sb12 = sb11.toString();
                                    StringBuilder sb13 = new StringBuilder();
                                    sb13.append(sb12);
                                    sb13.append("encode ms                : ");
                                    s37 = s48;
                                    sb13.append((int) s37);
                                    sb13.append("\n");
                                    String sb14 = sb13.toString();
                                    StringBuilder sb15 = new StringBuilder();
                                    sb15.append(sb14);
                                    sb15.append("rotate                   : ");
                                    sb15.append((int) b18);
                                    b18 = b18;
                                    sb15.append("\n");
                                    String str = sb15.toString() + "recv to render start     : " + ((int) b17) + "\n";
                                    StringBuilder sb16 = new StringBuilder();
                                    sb16.append(str);
                                    sb16.append("rgb2yuv                  : ");
                                    int i39 = i17;
                                    sb16.append(i39);
                                    i17 = i39;
                                    sb16.append("\n");
                                    String str2 = (((((((sb16.toString() + "frame size               : " + i36 + "\n") + "receive to decode        : " + ((int) s56) + "\n") + "decode time              : " + ((int) s58) + "\n") + "decode start             : " + j36 + "\n") + "decode to render latency : " + ((int) s66) + "\n") + "render time              : " + ((int) s67) + "\n") + "round trip latency       : " + ((int) s16) + "\n") + "reserve1                 : 0\n";
                                    s39 = s16;
                                    if (latencyTimestamp.length >= 64) {
                                        StringBuilder sb17 = new StringBuilder();
                                        sb17.append(str2 + "scene id                 : " + ((int) s29) + "\n");
                                        sb17.append("recv ts to render start  : ");
                                        s47 = s68;
                                        sb17.append((int) s47);
                                        sb17.append("\n");
                                        String str3 = (sb17.toString() + "session id               : " + i18 + "\n") + "reserve2                 : " + ((int) s19) + "\n";
                                        StringBuilder sb18 = new StringBuilder();
                                        sb18.append(str3);
                                        sb18.append("reserve3                 : ");
                                        sb18.append((int) s59);
                                        s59 = s59;
                                        sb18.append("\n");
                                        String sb19 = sb18.toString();
                                        StringBuilder sb20 = new StringBuilder();
                                        sb20.append(sb19);
                                        sb20.append("reserve4                 : ");
                                        sb20.append((int) s65);
                                        s65 = s65;
                                        sb20.append("\n");
                                        str2 = sb20.toString() + "srTime                   : " + ((int) s57) + "\n";
                                        s38 = s57;
                                    } else {
                                        s38 = s57;
                                        s47 = s68;
                                    }
                                    s46 = s19;
                                    StringBuilder sb21 = new StringBuilder();
                                    s36 = s47;
                                    sb21.append(" latency=");
                                    sb21.append(str2);
                                    Logging.v(TAG, sb21.toString());
                                } else {
                                    s29 = s18;
                                    s36 = s17;
                                    s37 = s48;
                                    s38 = s57;
                                    s39 = s16;
                                    s46 = s19;
                                }
                                int length = latencyTimestamp.length;
                                byte[] bArr = new byte[length];
                                ByteBuffer wrap2 = ByteBuffer.wrap(bArr);
                                wrap2.order(ByteOrder.BIG_ENDIAN);
                                wrap2.putInt(i3);
                                wrap2.putInt(i16);
                                wrap2.putLong(j3);
                                wrap2.putShort(s37);
                                wrap2.put(b18);
                                wrap2.put(b17);
                                wrap2.putInt(i17);
                                wrap2.putInt(i36);
                                wrap2.putShort(s56);
                                wrap2.putShort(s58);
                                wrap2.putLong(j36);
                                wrap2.putShort(s66);
                                wrap2.putShort(s67);
                                wrap2.putShort(s39);
                                wrap2.putShort((short) 0);
                                if (latencyTimestamp.length >= 64 && i18 != 0) {
                                    wrap2.putShort(s29);
                                    wrap2.putShort(s36);
                                    wrap2.putInt(i18);
                                    wrap2.putShort(s46);
                                    wrap2.putShort(s59);
                                    wrap2.putShort(s65);
                                    wrap2.putShort(s38);
                                }
                                try {
                                    PerfCallBack perfCallBack = mPerfCb;
                                    if (perfCallBack != null) {
                                        perfCallBack.onPerfCb(bArr, length);
                                    }
                                    if (!isFirstFrameDecoded) {
                                        isFirstFrameDecoded = true;
                                        VideoDecoder.DecodeCallback decodeCallback = mDecodeCb;
                                        if (decodeCallback != null) {
                                            decodeCallback.onFirstFrameDecoded();
                                            if (debugLogEnabled) {
                                                Logging.v(TAG, "onFirstFrameDecoded");
                                            }
                                        }
                                    }
                                } catch (Exception e16) {
                                    Logging.e(TAG, "onPerfCb failed, cause: " + e16);
                                }
                                eglRenderer = this;
                                videoFrame = videoFrame2;
                            }
                            z17 = z18;
                        } catch (Exception e17) {
                            e = e17;
                            Logging.e(TAG, "failed to renderFrameOnRenderThread, cause: " + e);
                            return;
                        }
                    } else {
                        eglRenderer = this;
                        z17 = z16;
                        videoFrame = videoFrame2;
                    }
                    eglRenderer.notifyCallbacks(videoFrame, z17);
                    videoFrame.release();
                    FTrace.endTrace();
                    return;
                }
                logD("Dropping frame - No surface");
                videoFrame2.release();
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    private void resetStatistics(long j3) {
        synchronized (this.statisticsLock) {
            this.statisticsStartTimeNs = j3;
            this.framesReceived = 0;
            this.framesDropped = 0;
            this.framesRendered = 0;
            this.renderTimeNs = 0L;
            this.renderSwapBufferTimeNs = 0L;
        }
    }

    public static void setCallback(VideoDecoder.DecodeCallback decodeCallback) {
        mDecodeCb = decodeCallback;
        isFirstFrameDecoded = false;
    }

    public static void setDegree(int i3) {
        mDegree = i3;
    }

    public static void setPerfCb(PerfCallBack perfCallBack) {
        mPerfCb = perfCallBack;
    }

    public void addFrameListener(FrameListener frameListener, float f16) {
        addFrameListener(frameListener, f16, null, false);
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void createEglSurface(Surface surface) {
        createEglSurfaceInternal(surface);
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public int getEncodeNumber() {
        return this.mEncodeNumber;
    }

    public void init(@Nullable final EglBase.Context context, final int[] iArr, RendererCommon.GlDrawer glDrawer, boolean z16) {
        isFirstFrameDecoded = false;
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                logD("Initializing EglRenderer");
                this.drawer = glDrawer;
                this.usePresentationTimeStamp = z16;
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.name + TAG);
                baseHandlerThread.start();
                HandlerWithExceptionCallback handlerWithExceptionCallback = new HandlerWithExceptionCallback(baseHandlerThread.getLooper(), new Runnable() { // from class: org.tencwebrtc.EglRenderer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (EglRenderer.this.handlerLock) {
                            EglRenderer.this.renderThreadHandler = null;
                        }
                    }
                });
                this.renderThreadHandler = handlerWithExceptionCallback;
                ThreadUtils.invokeAtFrontUninterruptibly(handlerWithExceptionCallback, new Runnable() { // from class: org.tencwebrtc.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.lambda$init$0(context, iArr);
                    }
                });
                this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
                resetStatistics(System.nanoTime());
                this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
            } else {
                throw new IllegalStateException(this.name + "Already initialized");
            }
        }
    }

    @Override // org.tencwebrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        boolean z16;
        synchronized (this.statisticsLock) {
            this.framesReceived++;
        }
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                logD("Dropping frame - Not initialized or already released.");
                return;
            }
            synchronized (this.frameLock) {
                if (this.pendingFrame != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    logD(" Dropping frame");
                    this.pendingFrame.release();
                }
                FTrace.startTrace("EglRenderer.OnFrame framesReceived=%d pts=%d dropOldFrame=%b", Integer.valueOf(this.framesReceived), Long.valueOf(videoFrame.getTimestampNs() / 1000), Boolean.valueOf(z16));
                this.pendingFrame = videoFrame;
                videoFrame.retain();
                this.renderThreadHandler.post(new Runnable() { // from class: org.tencwebrtc.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.renderFrameOnRenderThread();
                    }
                });
                FTrace.endTrace();
            }
            if (z16) {
                synchronized (this.statisticsLock) {
                    this.framesDropped++;
                }
            }
        }
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    public void printStackTrace() {
        Thread thread;
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                thread = null;
            } else {
                thread = handler.getLooper().getThread();
            }
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace.length > 0) {
                    logW("EglRenderer stack trace:");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        logW(stackTraceElement.toString());
                    }
                }
            }
        }
    }

    public void release() {
        logD("Releasing.");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                logD("Already released");
                return;
            }
            handler.removeCallbacks(this.logStatisticsRunnable);
            this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: org.tencwebrtc.k
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.lambda$release$1(countDownLatch);
                }
            });
            final Looper looper = this.renderThreadHandler.getLooper();
            this.renderThreadHandler.post(new Runnable() { // from class: org.tencwebrtc.l
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.lambda$release$2(looper);
                }
            });
            this.renderThreadHandler = null;
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            synchronized (this.frameLock) {
                VideoFrame videoFrame = this.pendingFrame;
                if (videoFrame != null) {
                    videoFrame.release();
                    this.pendingFrame = null;
                }
            }
            logD("Releasing done.");
        }
    }

    public void releaseEglSurface(final Runnable runnable) {
        this.eglSurfaceCreationRunnable.setSurface(null);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                handler.removeCallbacks(this.eglSurfaceCreationRunnable);
                this.renderThreadHandler.postAtFrontOfQueue(new Runnable() { // from class: org.tencwebrtc.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.lambda$releaseEglSurface$5(runnable);
                    }
                });
            } else {
                runnable.run();
            }
        }
    }

    public void removeFrameListener(final FrameListener frameListener) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                return;
            }
            if (Thread.currentThread() != this.renderThreadHandler.getLooper().getThread()) {
                postToRenderThread(new Runnable() { // from class: org.tencwebrtc.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.lambda$removeFrameListener$4(countDownLatch, frameListener);
                    }
                });
                ThreadUtils.awaitUninterruptibly(countDownLatch);
                return;
            }
            throw new RuntimeException("removeFrameListener must not be called on the render thread.");
        }
    }

    public void setFpsReduction(float f16) {
        logD("setFpsReduction: " + f16);
        synchronized (this.fpsReductionLock) {
            long j3 = this.minRenderPeriodNs;
            if (f16 <= 0.0f) {
                this.minRenderPeriodNs = Long.MAX_VALUE;
            } else {
                this.minRenderPeriodNs = ((float) TimeUnit.SECONDS.toNanos(1L)) / f16;
            }
            if (this.minRenderPeriodNs != j3) {
                this.nextFrameTimeNs = System.nanoTime();
            }
        }
    }

    public void setLayoutAspectRatio(float f16) {
        logD("setLayoutAspectRatio: " + f16);
        synchronized (this.layoutLock) {
            this.layoutAspectRatio = f16;
        }
    }

    public void setMirror(boolean z16) {
        logD("setMirrorHorizontally: " + z16);
        synchronized (this.layoutLock) {
            this.mirrorHorizontally = z16;
        }
    }

    public void setMirrorVertically(boolean z16) {
        logD("setMirrorVertically: " + z16);
        synchronized (this.layoutLock) {
            this.mirrorVertically = z16;
        }
    }

    public void addFrameListener(FrameListener frameListener, float f16, RendererCommon.GlDrawer glDrawer) {
        addFrameListener(frameListener, f16, glDrawer, false);
    }

    public void clearImage(final float f16, final float f17, final float f18, final float f19) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                return;
            }
            handler.postAtFrontOfQueue(new Runnable() { // from class: org.tencwebrtc.n
                @Override // java.lang.Runnable
                public final void run() {
                    EglRenderer.this.lambda$clearImage$6(f16, f17, f18, f19);
                }
            });
        }
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture);
    }

    public void addFrameListener(final FrameListener frameListener, final float f16, @Nullable final RendererCommon.GlDrawer glDrawer, final boolean z16) {
        postToRenderThread(new Runnable() { // from class: org.tencwebrtc.i
            @Override // java.lang.Runnable
            public final void run() {
                EglRenderer.this.lambda$addFrameListener$3(glDrawer, frameListener, f16, z16);
            }
        });
    }

    public EglRenderer(String str, VideoFrameDrawer videoFrameDrawer) {
        this.SEI_LENGTH = 48;
        this.SEI_EXTENDED_LENGTH = 64;
        this.UUID_LENGTH = 16;
        this.DECODE_LENGTH = 16;
        this.handlerLock = new Object();
        this.frameListeners = new ArrayList<>();
        this.fpsReductionLock = new Object();
        this.drawMatrix = new Matrix();
        this.frameLock = new Object();
        this.layoutLock = new Object();
        this.statisticsLock = new Object();
        this.bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
        this.logStatisticsRunnable = new Runnable() { // from class: org.tencwebrtc.EglRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                EglRenderer.this.logStatistics();
                synchronized (EglRenderer.this.handlerLock) {
                    if (EglRenderer.this.renderThreadHandler != null) {
                        EglRenderer.this.renderThreadHandler.removeCallbacks(EglRenderer.this.logStatisticsRunnable);
                        EglRenderer.this.renderThreadHandler.postDelayed(EglRenderer.this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
                    }
                }
            }
        };
        this.eglSurfaceCreationRunnable = new EglSurfaceCreation();
        this.name = str;
        this.frameDrawer = videoFrameDrawer;
        mDegree = 0;
        this.mRotate = 0;
        isFirstFrameDecoded = false;
    }

    public void init(@Nullable EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        init(context, iArr, glDrawer, false);
    }
}
