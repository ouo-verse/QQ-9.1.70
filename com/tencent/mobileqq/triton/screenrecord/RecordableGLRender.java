package com.tencent.mobileqq.triton.screenrecord;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.engine.ScreenRecordCallback;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.screenrecord.encoder.MediaAudioEncoder;
import com.tencent.mobileqq.triton.screenrecord.encoder.MediaMuxerController;
import com.tencent.mobileqq.triton.screenrecord.encoder.MediaVideoEncoder;
import com.tencent.mobileqq.triton.screenrecord.gles.EglCore;
import com.tencent.mobileqq.triton.screenrecord.gles.FullFrameRect;
import com.tencent.mobileqq.triton.screenrecord.gles.WindowSurface;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RecordableGLRender implements Runnable, RenderContext.RenderSurfaceInitializerListener {
    private static final String TAG = "RecordableGLRender";
    private final ScreenRecordCallback mCallback;
    private EglCore mEglCore;
    private WindowSurface mEncoderWindowSurface;
    private FullFrameRect mFullFramePainter;
    private boolean mInitFailed;
    private Surface mInputSurface;
    private MediaVideoEncoder mMediaVideoEncoder;
    private MediaMuxerController mMuxer;
    private File mOutputFile;
    private boolean mReady;
    private boolean mRecordAudio;
    private final RenderContext mRenderContext;
    private Handler mRenderHandler;
    private Thread mRenderThread;
    private WindowSurface mScreenWindowSurface;
    private SurfaceTexture mSurfaceTexture;
    private int mVideoHeight;
    private int mVideoWidth;
    private int mTextureId = -1;
    private final float[] mTmpMatrix = new float[16];
    private SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.1
        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            RecordableGLRender.this.mRenderHandler.sendEmptyMessage(2);
        }
    };
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class RenderHandler extends Handler {
        public static final int MSG_FRAME_AVAILABLE = 2;
        public static final int MSG_START_RENDERING = 0;
        public static final int MSG_STOP_RENDERING = 1;
        private WeakReference<RecordableGLRender> mWeakRenderThread;

        public RenderHandler(RecordableGLRender recordableGLRender) {
            this.mWeakRenderThread = new WeakReference<>(recordableGLRender);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RecordableGLRender recordableGLRender = this.mWeakRenderThread.get();
            if (recordableGLRender == null) {
                Logger.w(RecordableGLRender.TAG, "RenderHandler.handleMessage: weak ref is null");
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                recordableGLRender.doStartRendering((Surface) message.obj);
            } else if (i3 == 1) {
                recordableGLRender.doStopRecording();
            } else if (i3 == 2) {
                recordableGLRender.drawFrame();
            }
        }
    }

    public RecordableGLRender(ScreenRecordCallback screenRecordCallback, RenderContext renderContext) {
        this.mCallback = screenRecordCallback;
        this.mRenderContext = renderContext;
    }

    private EglCore createEglCore() {
        return new EglCore(null, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartRendering(Surface surface) {
        Logger.i(TAG, "doStartRendering, outputSurface=" + surface);
        if (this.mScreenWindowSurface != null) {
            return;
        }
        RenderContext renderContext = this.mRenderContext;
        if (renderContext == null) {
            signalOnFailed(new Exception("RenderContext is null."));
            return;
        }
        if (!renderContext.isSurfaceReady()) {
            Logger.e(TAG, "doStartRendering wait for surface error.");
            signalOnFailed(new Exception("RenderContext surface not ready"));
            return;
        }
        Logger.i(TAG, "doStartRendering, begin create surface.");
        try {
            WindowSurface windowSurface = new WindowSurface(this.mEglCore, surface, false);
            this.mScreenWindowSurface = windowSurface;
            nSetSurfaceBuffersGeometry(surface, windowSurface.getWidth(), this.mScreenWindowSurface.getHeight());
            this.mScreenWindowSurface.makeCurrent();
            GLES20.glViewport(0, 0, this.mScreenWindowSurface.getWidth(), this.mScreenWindowSurface.getHeight());
            this.mMuxer.start();
            signalOnStarted();
        } catch (Exception e16) {
            Logger.e(TAG, "doStartRendering failed", e16);
            this.mRenderHandler.getLooper().quit();
            signalOnFailed(e16);
        } catch (UnsatisfiedLinkError e17) {
            Logger.e(TAG, "doStartRendering failed", e17);
            this.mRenderHandler.getLooper().quit();
            signalOnFailed(new IllegalStateException(e17.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStopRecording() {
        Logger.i(TAG, "doStopRecording, mScreenWindowSurface=" + this.mScreenWindowSurface);
        WindowSurface windowSurface = this.mScreenWindowSurface;
        if (windowSurface == null) {
            return;
        }
        try {
            windowSurface.release();
            this.mScreenWindowSurface = null;
            this.mEncoderWindowSurface.makeCurrent();
            this.mMuxer.stop();
            signalOnStopped();
        } catch (Exception e16) {
            Logger.e(TAG, "doStopRecording failed", e16);
            this.mRenderHandler.getLooper().quit();
            signalOnFailed(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawFrame() {
        if (this.mEglCore == null) {
            Logger.i(TAG, "Skipping drawFrame after shutdown");
            return;
        }
        try {
            this.mSurfaceTexture.updateTexImage();
            if (this.mScreenWindowSurface == null) {
                return;
            }
            this.mSurfaceTexture.getTransformMatrix(this.mTmpMatrix);
            this.mFullFramePainter.drawFrame(this.mTextureId, this.mTmpMatrix);
            if (this.mScreenWindowSurface.swapBuffers() && this.mMuxer != null) {
                this.mEncoderWindowSurface.makeCurrent();
                GLES20.glViewport(0, 0, this.mEncoderWindowSurface.getWidth(), this.mEncoderWindowSurface.getHeight());
                try {
                    try {
                        this.mFullFramePainter.drawFrame(this.mTextureId, this.mTmpMatrix);
                        this.mEncoderWindowSurface.setPresentationTime(this.mSurfaceTexture.getTimestamp() - this.mMuxer.getStoppingNanos());
                        this.mEncoderWindowSurface.swapBuffers();
                        this.mMediaVideoEncoder.frameAvailableSoon();
                    } catch (Exception e16) {
                        Logger.e(TAG, "Draw mEncoderWindowSurface failed!", e16);
                    }
                } finally {
                    this.mScreenWindowSurface.makeCurrent();
                    GLES20.glViewport(0, 0, this.mScreenWindowSurface.getWidth(), this.mScreenWindowSurface.getHeight());
                }
            }
        } catch (Exception e17) {
            Logger.e(TAG, "Draw mScreenWindowSurface failed!", e17);
        }
    }

    private void forcePrepared() {
        if (this.mRenderThread != null) {
        } else {
            throw new IllegalStateException("prepare() hasn't been called!");
        }
    }

    private native void nSetSurfaceBuffersGeometry(Surface surface, int i3, int i16);

    private void releaseResources() {
        int[] iArr = new int[1];
        WindowSurface windowSurface = this.mScreenWindowSurface;
        if (windowSurface != null) {
            windowSurface.release();
            this.mScreenWindowSurface = null;
        }
        WindowSurface windowSurface2 = this.mEncoderWindowSurface;
        if (windowSurface2 != null) {
            windowSurface2.release();
            this.mEncoderWindowSurface = null;
        }
        FullFrameRect fullFrameRect = this.mFullFramePainter;
        if (fullFrameRect != null) {
            fullFrameRect.release(true);
            this.mFullFramePainter = null;
        }
        int i3 = this.mTextureId;
        if (i3 > 0) {
            iArr[0] = i3;
            GLES20.glDeleteTextures(1, iArr, 0);
            this.mTextureId = -1;
        }
        Surface surface = this.mInputSurface;
        if (surface != null) {
            surface.release();
            this.mInputSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        EglCore eglCore = this.mEglCore;
        if (eglCore != null) {
            eglCore.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalOnCompleted(final File file) {
        if (this.mCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.7
                @Override // java.lang.Runnable
                public void run() {
                    RecordableGLRender.this.mCallback.onCompleted(file);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalOnFailed(final Exception exc) {
        if (this.mCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.6
                @Override // java.lang.Runnable
                public void run() {
                    RecordableGLRender.this.mCallback.onFailed(exc);
                }
            });
        }
    }

    private void signalOnInputSurfaceReady(final Surface surface) {
        if (this.mCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.4
                @Override // java.lang.Runnable
                public void run() {
                    RecordableGLRender.this.mCallback.onInputSurfaceReady(surface);
                }
            });
        }
    }

    private void signalOnReady() {
        if (this.mCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.8
                @Override // java.lang.Runnable
                public void run() {
                    RecordableGLRender.this.mCallback.onReady();
                }
            });
        }
    }

    private void signalOnRelease() {
        if (this.mCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.9
                @Override // java.lang.Runnable
                public void run() {
                    RecordableGLRender.this.mCallback.onRelease();
                }
            });
        }
    }

    private void signalOnStarted() {
        if (this.mCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.3
                @Override // java.lang.Runnable
                public void run() {
                    RecordableGLRender.this.mCallback.onStarted();
                }
            });
        }
    }

    private void signalOnStopped() {
        if (this.mCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.5
                @Override // java.lang.Runnable
                public void run() {
                    RecordableGLRender.this.mCallback.onStopped();
                }
            });
        }
    }

    private void startEncoder() throws IOException {
        this.mMuxer = new MediaMuxerController(this.mOutputFile);
        Logger.i(TAG, "starting encoder, mMuxer=" + this.mMuxer);
        this.mMuxer.setCallback(new MediaMuxerController.Callback() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGLRender.2
            @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaMuxerController.Callback
            public void onError(Exception exc) {
                Logger.e(RecordableGLRender.TAG, "MediaMuxerController reports an error", exc);
                RecordableGLRender.this.signalOnFailed(exc);
            }

            @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaMuxerController.Callback
            public void onReleased(File file) {
                RecordableGLRender.this.signalOnCompleted(file);
            }

            @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaMuxerController.Callback
            public void onReady() {
            }
        });
        this.mMediaVideoEncoder = new MediaVideoEncoder(this.mMuxer, this.mVideoWidth, this.mVideoHeight);
        if (this.mRecordAudio) {
            new MediaAudioEncoder(this.mMuxer);
        }
        this.mMuxer.prepare();
        WindowSurface windowSurface = new WindowSurface(this.mEglCore, this.mMediaVideoEncoder.getInputSurface(), false);
        this.mEncoderWindowSurface = windowSurface;
        windowSurface.makeCurrent();
        FullFrameRect fullFrameRect = new FullFrameRect();
        this.mFullFramePainter = fullFrameRect;
        this.mTextureId = fullFrameRect.createTextureObject();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureId);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this.mOnFrameAvailableListener);
        this.mInputSurface = new Surface(this.mSurfaceTexture);
    }

    private void stopEncoder() {
        if (this.mMuxer != null) {
            Logger.i(TAG, "stopping encoder, mMuxer=" + this.mMuxer);
            try {
                try {
                    this.mMuxer.stop();
                    this.mMuxer.release(false);
                } catch (IllegalStateException e16) {
                    Logger.e(TAG, "stopEncoder fail, e=", e16);
                }
            } finally {
                this.mMuxer = null;
                this.mMediaVideoEncoder = null;
            }
        }
    }

    public Surface getInputSurface() {
        forcePrepared();
        if (this.mInitFailed) {
            Logger.e(TAG, "getInputSurface mInitFailed");
            return null;
        }
        Logger.d(TAG, "getInputSurface: " + this.mInputSurface);
        return this.mInputSurface;
    }

    public boolean isReady() {
        if (this.mReady && !this.mInitFailed) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.triton.render.RenderContext.RenderSurfaceInitializerListener
    public void onInitializer() {
        signalOnReady();
    }

    public void onRenderSurfaceChanged() {
        forcePrepared();
        if (this.mInitFailed) {
            Logger.e(TAG, "onRenderSurfaceChanged mInitFailed");
        } else {
            if (this.mRenderContext == null) {
                return;
            }
            Logger.d(TAG, "onRenderSurfaceChanged");
            this.mRenderContext.addSurfaceInitializerListener(this);
        }
    }

    public boolean prepare(boolean z16, int i3, int i16, File file) {
        if (this.mRenderThread == null) {
            this.mRecordAudio = z16;
            this.mVideoWidth = i3;
            this.mVideoHeight = i16;
            this.mOutputFile = file;
            BaseThread baseThread = new BaseThread(this);
            this.mRenderThread = baseThread;
            baseThread.start();
            return !this.mInitFailed;
        }
        throw new IllegalStateException("prepare() must be called only once!");
    }

    public void release(boolean z16) {
        forcePrepared();
        if (this.mInitFailed) {
            Logger.e(TAG, "release mInitFailed");
        } else {
            this.mRenderHandler.getLooper().quit();
            this.mReady = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.mRenderHandler = new RenderHandler(this);
        try {
            this.mEglCore = createEglCore();
            e = null;
        } catch (Exception e16) {
            e = e16;
            Logger.e(TAG, "prepare openGL environment failed!", e);
        }
        if (e == null) {
            try {
                startEncoder();
            } catch (Exception e17) {
                e = e17;
                Logger.e(TAG, "startEncoder failed!", e);
            }
        }
        if (e != null) {
            this.mInitFailed = true;
            signalOnFailed(e);
        }
        if (this.mInitFailed) {
            return;
        }
        this.mReady = true;
        signalOnInputSurfaceReady(this.mInputSurface);
        Logger.i(TAG, "looper enter");
        Looper.loop();
        Logger.i(TAG, "looper quit");
        stopEncoder();
        Logger.i(TAG, "stopEncoder completed");
        releaseResources();
        Logger.i(TAG, "releaseResources completed");
        signalOnRelease();
    }

    public void startRendering(@NonNull Surface surface) {
        forcePrepared();
        if (this.mInitFailed) {
            Logger.e(TAG, "startRendering mInitFailed");
        } else {
            Message.obtain(this.mRenderHandler, 0, surface).sendToTarget();
        }
    }

    public void stopRendering() {
        forcePrepared();
        if (this.mInitFailed) {
            Logger.e(TAG, "stopRendering mInitFailed");
        } else {
            this.mRenderHandler.sendEmptyMessage(1);
        }
    }
}
