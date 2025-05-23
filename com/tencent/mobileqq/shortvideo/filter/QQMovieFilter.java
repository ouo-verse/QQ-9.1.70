package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;

/* compiled from: P */
@TargetApi(11)
/* loaded from: classes18.dex */
public class QQMovieFilter extends QQBaseFilter {
    public static final int MOVIE_FILTER_MESSAGE_RESUME_MUSIC = 3;
    public static final int MOVIE_FILTER_MESSAGE_START = 2;
    public static final int MOVIE_FILTER_MESSAGE_STOP = 1;
    public static final int MOVIE_FILTER_MESSAGE_STOP_MUSIC = 4;
    private static final String TAG = "QQMovieFilter";
    private boolean isSurfaceCreated;
    private int lastSendMessage;
    private GPUBaseFilter mBaseFilter;
    private DecodePlayer mDecodePlayer;
    private GPUOESMovieFilter mOESMovieFilter;
    private RenderBuffer mRenderFBO;
    private Handler movieProcessHandler;
    private HandlerThread movieProcessThread;
    private MovieOnFrameAvailableListener onFrameAvailableListener;
    private boolean sizeChange;
    protected int surfaceHeight;
    private SurfaceTexture surfaceTexture;
    protected int surfaceWidth;
    private int textureId;
    private String videoFilePath;
    private float xOffset;
    private float yOffset;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class MovieOnFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener {
        private boolean enable = true;
        private WeakReference<QQMovieFilter> movieFilterWeakReference;

        public MovieOnFrameAvailableListener(QQMovieFilter qQMovieFilter) {
            this.movieFilterWeakReference = new WeakReference<>(qQMovieFilter);
        }

        public void disable() {
            this.enable = false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            QQMovieFilter qQMovieFilter;
            if (this.enable && (qQMovieFilter = this.movieFilterWeakReference.get()) != null) {
                qQMovieFilter.setSurfaceTexture(surfaceTexture);
            }
        }
    }

    public QQMovieFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(100, qQFilterRenderManager);
        this.textureId = -1;
        this.surfaceWidth = -1;
        this.surfaceHeight = -1;
        this.isSurfaceCreated = false;
        this.lastSendMessage = 1;
        this.sizeChange = false;
        this.videoFilePath = null;
        this.xOffset = 0.0f;
        this.yOffset = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPlay() {
        DecodePlayer decodePlayer = this.mDecodePlayer;
        if (decodePlayer != null) {
            decodePlayer.stopPlay();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        if (this.lastSendMessage == 2 && this.isSurfaceCreated) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        DecodePlayer decodePlayer;
        DecodePlayer decodePlayer2 = this.mDecodePlayer;
        if (decodePlayer2 != null && decodePlayer2.getCurrentState() == 3 && this.surfaceTexture != null) {
            if (!this.isSurfaceCreated) {
                onSurfaceCreateInternal();
            }
            if (this.surfaceWidth != getQQFilterRenderManager().getFilterWidth() && this.surfaceHeight != getQQFilterRenderManager().getFilterHeight()) {
                onSurfaceChangeInternal(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
                this.sizeChange = true;
            } else {
                this.sizeChange = false;
            }
        }
        if (this.isSurfaceCreated && (decodePlayer = this.mDecodePlayer) != null && decodePlayer.getCurrentState() == 3 && this.surfaceTexture != null) {
            RenderBuffer renderBuffer = this.mRenderFBO;
            if (renderBuffer == null || renderBuffer.getWidth() <= 0 || this.mRenderFBO.getWidth() <= 0 || this.sizeChange) {
                this.mRenderFBO = new RenderBuffer(true, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), 33984);
            }
            try {
                this.mRenderFBO.setTexId(this.mInputTextureID);
                this.mRenderFBO.bind();
                GPUBaseFilter.checkGlError("fbo bind");
                int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
                if (glCheckFramebufferStatus == 36053) {
                    this.surfaceTexture.updateTexImage();
                    float[] fArr = new float[16];
                    this.surfaceTexture.getTransformMatrix(fArr);
                    this.mOESMovieFilter.drawTexture(this.textureId, fArr);
                    GPUBaseFilter.checkGlError("oes draw");
                    this.mRenderFBO.unbind();
                    this.mRenderFBO.recoverInitialTexId();
                    this.mRenderFBO.bind();
                    int glCheckFramebufferStatus2 = GLES20.glCheckFramebufferStatus(36160);
                    if (glCheckFramebufferStatus2 == 36053) {
                        GPUBaseFilter.checkGlError("pre clear");
                        this.mBaseFilter.drawTexture(this.mInputTextureID, null, null);
                        this.mRenderFBO.unbind();
                        this.mOutputTextureID = this.mRenderFBO.getTexId();
                        return;
                    }
                    SLog.e(TAG, "fbo status2 incomplete, status: " + glCheckFramebufferStatus2);
                    throw new RuntimeException("fbo status incomplete");
                }
                SLog.e(TAG, "fbo status incomplete, status: " + glCheckFramebufferStatus);
                throw new RuntimeException("fbo status incomplete");
            } catch (Throwable th5) {
                this.mOutputTextureID = this.mInputTextureID;
                SdkContext.getInstance().getLogger().e(TAG, "onDrawFrame error.", th5);
                return;
            }
        }
        this.mOutputTextureID = this.mInputTextureID;
    }

    public void onMusicOriginalChange(boolean z16) {
        HandlerThread handlerThread;
        int i3;
        if (isFilterWork() && this.movieProcessHandler != null && (handlerThread = this.movieProcessThread) != null && handlerThread.isAlive()) {
            if (z16) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            Message obtain = Message.obtain(this.movieProcessHandler, i3);
            this.movieProcessHandler.sendMessage(obtain);
            SLog.i(TAG, "send movie filter msg, what = " + obtain.what);
        }
    }

    public void onSurfaceChangeInternal(int i3, int i16) {
        if (SdkContext.getInstance().getLogger().isEnable()) {
            SdkContext.getInstance().getLogger().d(TAG, "onSurfaceChanged : " + i3 + ";" + i16);
        }
        this.surfaceWidth = i3;
        this.surfaceHeight = i16;
        try {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0 && SdkContext.getInstance().getLogger().isEnable()) {
                SdkContext.getInstance().getLogger().e(TAG, "previousUnknownError: glError 0x" + Integer.toHexString(glGetError));
            }
            GPUOESMovieFilter gPUOESMovieFilter = this.mOESMovieFilter;
            if (gPUOESMovieFilter != null) {
                gPUOESMovieFilter.onOutputSizeChanged(i3, i16);
                String str = this.videoFilePath;
                if (str != null) {
                    this.mOESMovieFilter.adjustVideo(VideoUtil.getHeightWidthRatioOfVideo(str), this.xOffset, this.yOffset);
                }
            }
            GPUBaseFilter gPUBaseFilter = this.mBaseFilter;
            if (gPUBaseFilter != null) {
                gPUBaseFilter.onOutputSizeChanged(i3, i16);
            }
        } catch (Throwable th5) {
            this.mRenderFBO = null;
            this.textureId = -1;
            SdkContext.getInstance().getLogger().e(TAG, "onSurfaceChange error.", th5);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        super.onSurfaceCreate();
        this.textureId = GlUtil.createTexture(36197);
    }

    public void onSurfaceCreateInternal() {
        if (SdkContext.getInstance().getLogger().isEnable()) {
            SdkContext.getInstance().getLogger().d(TAG, "onSurfaceCreated");
        }
        try {
            if (!this.isSurfaceCreated) {
                int glGetError = GLES20.glGetError();
                if (glGetError != 0 && SdkContext.getInstance().getLogger().isEnable()) {
                    SdkContext.getInstance().getLogger().e(TAG, "previousUnknownError: glError 0x" + Integer.toHexString(glGetError));
                }
                if (this.mOESMovieFilter == null) {
                    GPUOESMovieFilter gPUOESMovieFilter = new GPUOESMovieFilter();
                    this.mOESMovieFilter = gPUOESMovieFilter;
                    gPUOESMovieFilter.init();
                    this.mOESMovieFilter.onOutputSizeChanged(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
                    String str = this.videoFilePath;
                    if (str != null) {
                        this.mOESMovieFilter.adjustVideo(VideoUtil.getHeightWidthRatioOfVideo(str), this.xOffset, this.yOffset);
                    }
                }
                if (this.mBaseFilter == null) {
                    GPUBaseFilter gPUBaseFilter = new GPUBaseFilter();
                    this.mBaseFilter = gPUBaseFilter;
                    gPUBaseFilter.init();
                }
                GPUBaseFilter.checkGlError("filter init");
                this.isSurfaceCreated = true;
            }
        } catch (Throwable th5) {
            this.mRenderFBO = null;
            this.textureId = -1;
            SdkContext.getInstance().getLogger().e(TAG, "onSurfaceCreate error.", th5);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        if (SdkContext.getInstance().getLogger().isEnable()) {
            SdkContext.getInstance().getLogger().d(TAG, "surfaceDestroyed");
        }
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        GPUOESMovieFilter gPUOESMovieFilter = this.mOESMovieFilter;
        if (gPUOESMovieFilter != null) {
            gPUOESMovieFilter.destroy();
        }
        GPUBaseFilter gPUBaseFilter = this.mBaseFilter;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
        }
        if (this.movieProcessHandler != null) {
            this.movieProcessHandler = null;
        }
        HandlerThread handlerThread = this.movieProcessThread;
        if (handlerThread != null) {
            if (handlerThread.isAlive()) {
                this.movieProcessThread.quit();
            }
            this.movieProcessThread = null;
        }
        stopPlay();
        this.isSurfaceCreated = false;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.mDecodePlayer.getCurrentState() == 3) {
            this.surfaceTexture = surfaceTexture;
        }
    }

    public void startPlay(String str, String str2, boolean z16, float f16, float f17, HWDecodeListener hWDecodeListener) {
        Message obtain;
        HandlerThread handlerThread = this.movieProcessThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("movieTouchThread");
            this.movieProcessThread = baseHandlerThread;
            baseHandlerThread.start();
            this.movieProcessHandler = new Handler(this.movieProcessThread.getLooper()) { // from class: com.tencent.mobileqq.shortvideo.filter.QQMovieFilter.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    SLog.i(QQMovieFilter.TAG, "handle movie filter msg, what = " + message.what);
                    int i3 = message.what;
                    if (i3 == 1) {
                        QQMovieFilter.this.stopPlay();
                        if (QQMovieFilter.this.mDecodePlayer != null) {
                            QQMovieFilter.this.mDecodePlayer.setFilePath("", "");
                            return;
                        }
                        return;
                    }
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4 && QQMovieFilter.this.mDecodePlayer != null) {
                                QQMovieFilter.this.mDecodePlayer.stopMusic();
                                return;
                            }
                            return;
                        }
                        if (QQMovieFilter.this.mDecodePlayer != null) {
                            QQMovieFilter.this.mDecodePlayer.resumeMusic();
                            return;
                        }
                        return;
                    }
                    if (QQMovieFilter.this.mDecodePlayer != null && QQMovieFilter.this.mDecodePlayer.getCurrentState() == 1) {
                        SLog.i(QQMovieFilter.TAG, "DecodePlayer is preparing");
                        return;
                    }
                    Object[] objArr = (Object[]) message.obj;
                    QQMovieFilter.this.videoFilePath = (String) objArr[0];
                    String str3 = (String) objArr[1];
                    boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                    QQMovieFilter.this.xOffset = ((Float) objArr[3]).floatValue();
                    QQMovieFilter.this.yOffset = ((Float) objArr[4]).floatValue();
                    HWDecodeListener hWDecodeListener2 = (HWDecodeListener) objArr[5];
                    if (QQMovieFilter.this.mDecodePlayer == null) {
                        QQMovieFilter.this.mDecodePlayer = new DecodePlayer();
                    }
                    if (QQMovieFilter.this.onFrameAvailableListener != null) {
                        QQMovieFilter.this.onFrameAvailableListener.disable();
                    }
                    if (!FileUtil.fileExistsAndNotEmpty(QQMovieFilter.this.videoFilePath)) {
                        QQMovieFilter.this.stopPlay();
                        QQMovieFilter.this.mDecodePlayer.setFilePath("", "");
                        return;
                    }
                    QQMovieFilter.this.mDecodePlayer.setFilePath(QQMovieFilter.this.videoFilePath, str3);
                    QQMovieFilter.this.mDecodePlayer.setRepeat(booleanValue);
                    QQMovieFilter.this.mDecodePlayer.setDecodeListener(hWDecodeListener2);
                    QQMovieFilter qQMovieFilter = QQMovieFilter.this;
                    qQMovieFilter.onFrameAvailableListener = new MovieOnFrameAvailableListener(qQMovieFilter);
                    QQMovieFilter.this.mDecodePlayer.startPlay(QQMovieFilter.this.textureId, QQMovieFilter.this.onFrameAvailableListener);
                    QQMovieFilter.this.surfaceTexture = null;
                    QQMovieFilter.this.mDecodePlayer.setSpeedType(0);
                    if (QQMovieFilter.this.mOESMovieFilter != null) {
                        QQMovieFilter.this.mOESMovieFilter.adjustVideo(VideoUtil.getHeightWidthRatioOfVideo(QQMovieFilter.this.videoFilePath), QQMovieFilter.this.xOffset, QQMovieFilter.this.yOffset);
                    }
                }
            };
        }
        MovieOnFrameAvailableListener movieOnFrameAvailableListener = this.onFrameAvailableListener;
        if (movieOnFrameAvailableListener != null) {
            movieOnFrameAvailableListener.disable();
        }
        this.surfaceTexture = null;
        if (FileUtil.fileExistsAndNotEmpty(str)) {
            obtain = Message.obtain(this.movieProcessHandler, 2, new Object[]{str, str2, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), hWDecodeListener});
        } else {
            obtain = Message.obtain(this.movieProcessHandler, 1);
        }
        this.movieProcessHandler.removeMessages(2);
        this.movieProcessHandler.removeMessages(1);
        this.movieProcessHandler.sendMessage(obtain);
        this.lastSendMessage = obtain.what;
        SLog.i(TAG, "send movie filter msg, what = " + this.lastSendMessage);
    }
}
