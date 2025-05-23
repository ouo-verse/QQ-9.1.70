package com.tencent.biz.qqstory.qqonly;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class QQStoryGamePKFilter extends QQBaseFilter {
    public static final int MOVIE_FILTER_MESSAGE_START = 2;
    public static final int MOVIE_FILTER_MESSAGE_STOP = 1;
    public static final String TAG = "QQStoryGamePKFilter";
    private Handler gameDecodeHandler;
    private HandlerThread gameDecodeThread;
    private DecodePlayer mDecodePlayer;
    private boolean mIsSurfaceCreated;
    private float[] mMvpMatrix;
    private RenderBuffer mRenderFBO;
    private float[] mRevertMatrix;
    private int mRivalTextureID;
    private SurfaceTexture mSurfaceTexture;
    private TextureRender mTextureRender;
    private String mVideoPath;
    private OnFrameAvailableListener onFrameAvailableListener;

    /* loaded from: classes5.dex */
    private static class OnFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener {
        private WeakReference<QQStoryGamePKFilter> mFilter;
        private boolean mIsEnabled = true;

        public OnFrameAvailableListener(QQStoryGamePKFilter qQStoryGamePKFilter) {
            this.mFilter = new WeakReference<>(qQStoryGamePKFilter);
        }

        public void disable() {
            this.mIsEnabled = false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            QQStoryGamePKFilter qQStoryGamePKFilter;
            if (this.mIsEnabled && (qQStoryGamePKFilter = this.mFilter.get()) != null) {
                qQStoryGamePKFilter.setSurfaceTexture(surfaceTexture);
            }
        }
    }

    public QQStoryGamePKFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(183, qQFilterRenderManager);
        this.mRivalTextureID = -1;
        this.mMvpMatrix = new float[16];
        this.mRevertMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        initTexture();
    }

    private void initTexture() {
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        TextureRender textureRender = this.mTextureRender;
        if (textureRender != null) {
            textureRender.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.mDecodePlayer.getCurrentState() == 3) {
            this.mSurfaceTexture = surfaceTexture;
        }
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
        return this.mIsSurfaceCreated;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        DecodePlayer decodePlayer;
        Log.v("wyx", "onDrawFrame: decodePlayer state=" + this.mDecodePlayer.getCurrentState() + ", rivalTextureId=" + this.mRivalTextureID + ", inputTextureId=" + this.mInputTextureID);
        DecodePlayer decodePlayer2 = this.mDecodePlayer;
        if (decodePlayer2 != null && decodePlayer2.getCurrentState() == 3 && this.mSurfaceTexture != null && !this.mIsSurfaceCreated) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0 && SdkContext.getInstance().getLogger().isEnable()) {
                SdkContext.getInstance().getLogger().e(TAG, "previousUnknownError: glError 0x" + Integer.toHexString(glGetError));
            }
            if (this.mTextureRender == null) {
                this.mTextureRender = new TextureRender();
            }
            this.mIsSurfaceCreated = true;
        }
        if (this.mIsSurfaceCreated && (decodePlayer = this.mDecodePlayer) != null && decodePlayer.getCurrentState() == 3 && this.mSurfaceTexture != null) {
            if (this.mRenderFBO == null) {
                this.mRenderFBO = new RenderBuffer(720, 1280, 33984);
            }
            try {
                this.mRenderFBO.bind();
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
                this.mSurfaceTexture.updateTexImage();
                Matrix.setIdentityM(this.mMvpMatrix, 0);
                Matrix.translateM(this.mMvpMatrix, 0, 0.5f, 0.0f, 0.0f);
                Matrix.scaleM(this.mMvpMatrix, 0, 0.5f, 0.5f, 1.0f);
                this.mTextureRender.drawTexture(36197, this.mRivalTextureID, null, this.mMvpMatrix);
                Matrix.setIdentityM(this.mMvpMatrix, 0);
                Matrix.translateM(this.mMvpMatrix, 0, -0.5f, 0.0f, 0.0f);
                Matrix.scaleM(this.mMvpMatrix, 0, 0.5f, 0.5f, 1.0f);
                this.mTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, this.mInputTextureID, null, this.mMvpMatrix);
                this.mRenderFBO.unbind();
                this.mOutputTextureID = this.mRenderFBO.getTexId();
                return;
            } catch (Throwable unused) {
                this.mOutputTextureID = this.mInputTextureID;
                return;
            }
        }
        this.mOutputTextureID = this.mInputTextureID;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        TextureRender textureRender = this.mTextureRender;
        if (textureRender != null) {
            textureRender.release();
        }
        if (this.gameDecodeHandler != null) {
            this.gameDecodeHandler = null;
        }
        HandlerThread handlerThread = this.gameDecodeThread;
        if (handlerThread != null) {
            if (handlerThread.isAlive()) {
                this.gameDecodeThread.quit();
            }
            this.gameDecodeThread = null;
        }
        stopPlay();
        this.mIsSurfaceCreated = false;
    }

    public void startPlay(String str, String str2, boolean z16, float f16, float f17, HWDecodeListener hWDecodeListener) {
        Message obtain;
        HandlerThread handlerThread = this.gameDecodeThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("GameDecodeThread");
            this.gameDecodeThread = baseHandlerThread;
            baseHandlerThread.start();
            this.gameDecodeHandler = new Handler(this.gameDecodeThread.getLooper()) { // from class: com.tencent.biz.qqstory.qqonly.QQStoryGamePKFilter.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    SLog.i(QQStoryGamePKFilter.TAG, "handle game filter msg, what = " + message.what);
                    int i3 = message.what;
                    if (i3 == 1) {
                        QQStoryGamePKFilter.this.stopPlay();
                        if (QQStoryGamePKFilter.this.mDecodePlayer != null) {
                            QQStoryGamePKFilter.this.mDecodePlayer.setFilePath("", "");
                            return;
                        }
                        return;
                    }
                    if (i3 == 2) {
                        if (QQStoryGamePKFilter.this.mDecodePlayer != null && QQStoryGamePKFilter.this.mDecodePlayer.getCurrentState() == 1) {
                            SLog.i(QQStoryGamePKFilter.TAG, "DecodePlayer is preparing");
                            return;
                        }
                        Object[] objArr = (Object[]) message.obj;
                        QQStoryGamePKFilter.this.mVideoPath = (String) objArr[0];
                        String str3 = (String) objArr[1];
                        boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                        HWDecodeListener hWDecodeListener2 = (HWDecodeListener) objArr[5];
                        if (QQStoryGamePKFilter.this.mDecodePlayer == null) {
                            QQStoryGamePKFilter.this.mDecodePlayer = new DecodePlayer();
                            QQStoryGamePKFilter.this.mRivalTextureID = GlUtil.createTexture(36197);
                            Log.v("wyx", "onSurfaceCreate. rivalTextureId=" + QQStoryGamePKFilter.this.mRivalTextureID);
                        }
                        if (QQStoryGamePKFilter.this.onFrameAvailableListener != null) {
                            QQStoryGamePKFilter.this.onFrameAvailableListener.disable();
                        }
                        if (!FileUtil.fileExistsAndNotEmpty(QQStoryGamePKFilter.this.mVideoPath)) {
                            QQStoryGamePKFilter.this.stopPlay();
                            QQStoryGamePKFilter.this.mDecodePlayer.setFilePath("", "");
                            return;
                        }
                        QQStoryGamePKFilter.this.mDecodePlayer.setFilePath(QQStoryGamePKFilter.this.mVideoPath, str3);
                        QQStoryGamePKFilter.this.mDecodePlayer.setRepeat(booleanValue);
                        QQStoryGamePKFilter.this.mDecodePlayer.setDecodeListener(hWDecodeListener2);
                        QQStoryGamePKFilter qQStoryGamePKFilter = QQStoryGamePKFilter.this;
                        qQStoryGamePKFilter.onFrameAvailableListener = new OnFrameAvailableListener(qQStoryGamePKFilter);
                        QQStoryGamePKFilter.this.mDecodePlayer.startPlay(QQStoryGamePKFilter.this.mRivalTextureID, QQStoryGamePKFilter.this.onFrameAvailableListener);
                        QQStoryGamePKFilter.this.mSurfaceTexture = null;
                        QQStoryGamePKFilter.this.mDecodePlayer.setSpeedType(0);
                    }
                }
            };
        }
        OnFrameAvailableListener onFrameAvailableListener = this.onFrameAvailableListener;
        if (onFrameAvailableListener != null) {
            onFrameAvailableListener.disable();
        }
        this.mSurfaceTexture = null;
        if (FileUtil.fileExistsAndNotEmpty(str)) {
            obtain = Message.obtain(this.gameDecodeHandler, 2, new Object[]{str, str2, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17), hWDecodeListener});
        } else {
            obtain = Message.obtain(this.gameDecodeHandler, 1);
        }
        this.gameDecodeHandler.removeMessages(2);
        this.gameDecodeHandler.removeMessages(1);
        this.gameDecodeHandler.sendMessage(obtain);
    }
}
