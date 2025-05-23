package org.tencwebrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.Callable;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private final EglBase eglBase;
    private int frameRotation;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;

    @Nullable
    private VideoSink listener;
    private final int oesTextureId;

    @Nullable
    private VideoSink pendingListener;
    final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private int textureHeight;
    private int textureWidth;

    @Nullable
    private final TimestampAligner timestampAligner;
    private final YuvConverter yuvConverter;

    public static SurfaceTextureHelper create(final String str, final EglBase.Context context, final boolean z16, final YuvConverter yuvConverter) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str);
        baseHandlerThread.start();
        final Handler handler = new Handler(baseHandlerThread.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<SurfaceTextureHelper>() { // from class: org.tencwebrtc.SurfaceTextureHelper.1
            @Override // java.util.concurrent.Callable
            @Nullable
            public SurfaceTextureHelper call() {
                try {
                    return new SurfaceTextureHelper(EglBase.Context.this, handler, z16, yuvConverter);
                } catch (RuntimeException e16) {
                    Logging.e(SurfaceTextureHelper.TAG, str + " create failure", e16);
                    return null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispose$5() {
        this.isQuitting = true;
        if (!this.isTextureInUse) {
            release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(SurfaceTexture surfaceTexture) {
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$returnTextureFrame$4() {
        this.isTextureInUse = false;
        if (this.isQuitting) {
            release();
        } else {
            tryDeliverTextureFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFrameRotation$3(int i3) {
        this.frameRotation = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTextureSize$2(int i3, int i16) {
        this.textureWidth = i3;
        this.textureHeight = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopListening$1() {
        this.listener = null;
        this.pendingListener = null;
    }

    private void release() {
        if (this.handler.getLooper().getThread() == Thread.currentThread()) {
            if (!this.isTextureInUse && this.isQuitting) {
                this.yuvConverter.release();
                GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
                this.surfaceTexture.release();
                this.eglBase.release();
                this.handler.getLooper().quit();
                TimestampAligner timestampAligner = this.timestampAligner;
                if (timestampAligner != null) {
                    timestampAligner.dispose();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unexpected release.");
        }
        throw new IllegalStateException("Wrong thread.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnTextureFrame() {
        this.handler.post(new Runnable() { // from class: org.tencwebrtc.t
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.lambda$returnTextureFrame$4();
            }
        });
    }

    @TargetApi(21)
    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, handler);
    }

    private void tryDeliverTextureFrame() {
        int i3;
        if (this.handler.getLooper().getThread() == Thread.currentThread()) {
            if (!this.isQuitting && this.hasPendingTexture && !this.isTextureInUse && this.listener != null) {
                this.isTextureInUse = true;
                this.hasPendingTexture = false;
                updateTexImage();
                float[] fArr = new float[16];
                this.surfaceTexture.getTransformMatrix(fArr);
                long timestamp = this.surfaceTexture.getTimestamp();
                TimestampAligner timestampAligner = this.timestampAligner;
                if (timestampAligner != null) {
                    timestamp = timestampAligner.translateTimestamp(timestamp);
                }
                int i16 = this.textureWidth;
                if (i16 != 0 && (i3 = this.textureHeight) != 0) {
                    VideoFrame videoFrame = new VideoFrame(new TextureBufferImpl(i16, i3, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, new Runnable() { // from class: org.tencwebrtc.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            SurfaceTextureHelper.this.returnTextureFrame();
                        }
                    }), this.frameRotation, timestamp);
                    this.listener.onFrame(videoFrame);
                    videoFrame.release();
                    return;
                }
                Logging.e(TAG, "Texture size has not been set.");
                return;
            }
            return;
        }
        throw new IllegalStateException("Wrong thread.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTexImage() {
        synchronized (EglBase.lock) {
            try {
                this.surfaceTexture.updateTexImage();
            } catch (RuntimeException e16) {
                Logging.e(TAG, "updateTexImage: " + e16);
            }
        }
    }

    public void dispose() {
        Logging.d(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: org.tencwebrtc.x
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.lambda$dispose$5();
            }
        });
    }

    public Handler getHandler() {
        return this.handler;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public void setFrameRotation(final int i3) {
        this.handler.post(new Runnable() { // from class: org.tencwebrtc.w
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.lambda$setFrameRotation$3(i3);
            }
        });
    }

    public void setTextureSize(final int i3, final int i16) {
        if (i3 > 0) {
            if (i16 > 0) {
                this.surfaceTexture.setDefaultBufferSize(i3, i16);
                this.handler.post(new Runnable() { // from class: org.tencwebrtc.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceTextureHelper.this.lambda$setTextureSize$2(i3, i16);
                    }
                });
                return;
            } else {
                throw new IllegalArgumentException("Texture height must be positive, but was " + i16);
            }
        }
        throw new IllegalArgumentException("Texture width must be positive, but was " + i3);
    }

    public void startListening(VideoSink videoSink) {
        if (this.listener == null && this.pendingListener == null) {
            this.pendingListener = videoSink;
            this.handler.post(this.setListenerRunnable);
            return;
        }
        throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
    }

    public void stopListening() {
        Logging.d(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: org.tencwebrtc.u
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceTextureHelper.this.lambda$stopListening$1();
            }
        });
    }

    @Deprecated
    public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer textureBuffer) {
        return textureBuffer.toI420();
    }

    SurfaceTextureHelper(EglBase.Context context, Handler handler, boolean z16, YuvConverter yuvConverter) {
        this.setListenerRunnable = new Runnable() { // from class: org.tencwebrtc.SurfaceTextureHelper.2
            @Override // java.lang.Runnable
            public void run() {
                Logging.d(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
                SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
                surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
                SurfaceTextureHelper.this.pendingListener = null;
                if (SurfaceTextureHelper.this.hasPendingTexture) {
                    SurfaceTextureHelper.this.updateTexImage();
                    SurfaceTextureHelper.this.hasPendingTexture = false;
                }
            }
        };
        if (handler.getLooper().getThread() == Thread.currentThread()) {
            this.handler = handler;
            this.timestampAligner = z16 ? new TimestampAligner() : null;
            this.yuvConverter = yuvConverter;
            EglBase c16 = g.c(context, EglBase.CONFIG_PIXEL_BUFFER);
            this.eglBase = c16;
            try {
                c16.createDummyPbufferSurface();
                c16.makeCurrent();
                int generateTexture = GlUtil.generateTexture(36197);
                this.oesTextureId = generateTexture;
                SurfaceTexture surfaceTexture = new SurfaceTexture(generateTexture);
                this.surfaceTexture = surfaceTexture;
                setOnFrameAvailableListener(surfaceTexture, new SurfaceTexture.OnFrameAvailableListener() { // from class: org.tencwebrtc.z
                    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                    public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                        SurfaceTextureHelper.this.lambda$new$0(surfaceTexture2);
                    }
                }, handler);
                return;
            } catch (RuntimeException e16) {
                this.eglBase.release();
                handler.getLooper().quit();
                throw e16;
            }
        }
        throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context) {
        return create(str, context, false, new YuvConverter());
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context, boolean z16) {
        return create(str, context, z16, new YuvConverter());
    }
}
