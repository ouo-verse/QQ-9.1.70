package com.tencent.mobileqq.shortvideo.pkvideo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.lang.ref.WeakReference;

/* loaded from: classes18.dex */
public class PKFilter extends QQBaseFilter {
    public static String TAG = "PKFilter";
    public static final String TAG_ENCODE = TAG + "_encode";
    private boolean havePrepared;
    private boolean isDebug;
    private boolean isPKdecoderNeedWaitStart;
    private boolean isRepeat;
    private String mAudioPath;
    private DecodePlayer mDecodePlayer;
    private long mFilterDecodeTimeStamp;
    private int mHeight;
    private boolean mIsEncode;
    private boolean mIsSurfaceCreated;
    private int mLastOutputTexture;
    private float[] mMvpMatrix;
    private long mOrigVideoDurationMS;
    private String mPKCoverPath;
    private int mPKCoverTextureID;
    private PKDecodeListener mPKDecodeListener;
    private String mPKTitleBmgPath;
    private int mPKTitleTextureID;
    private long mPKVideoDecodeTimeStamp;
    private long mPkVideoDurationMs;
    private RenderBuffer mRenderFBO;
    private int mRivalTextureID;
    private SurfaceTexture mSurfaceTexture;
    private TextureRender mTextureRender;
    private String mVideoPath;
    private int mWidth;
    private OnFrameAvailableListener onFrameAvailableListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class OnFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener {
        private WeakReference<PKFilter> mFilter;
        private boolean mIsEnabled = true;

        public OnFrameAvailableListener(PKFilter pKFilter) {
            this.mFilter = new WeakReference<>(pKFilter);
        }

        public void disable() {
            this.mIsEnabled = false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            PKFilter pKFilter;
            if (this.mIsEnabled && (pKFilter = this.mFilter.get()) != null) {
                pKFilter.setSurfaceTexture(surfaceTexture);
            }
        }
    }

    public PKFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(183, qQFilterRenderManager);
        this.isDebug = false;
        this.mPKCoverTextureID = -1;
        this.mRivalTextureID = -1;
        this.mPKTitleTextureID = -1;
        this.mMvpMatrix = new float[16];
        this.mLastOutputTexture = -1;
        this.havePrepared = false;
        this.mPkVideoDurationMs = -1L;
        this.mOrigVideoDurationMS = -1L;
    }

    private void assertFailed(String str) {
        doAssert(true, str);
    }

    private void doAssert(boolean z16, String str) {
        if (!z16) {
            return;
        }
        if (!this.isDebug) {
            SLog.e(TAG, str);
            return;
        }
        throw new RuntimeException(str);
    }

    private int drawPKFrame(int i3, int i16, int i17) {
        this.mRenderFBO.bind();
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            assertFailed("fbo is not ready plz fix it error:" + glCheckFramebufferStatus);
            return this.mLastOutputTexture;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (i17 >= 0) {
            Matrix.setIdentityM(this.mMvpMatrix, 0);
            Matrix.translateM(this.mMvpMatrix, 0, 0.0f, 0.5f, 0.0f);
            Matrix.scaleM(this.mMvpMatrix, 0, 1.0f, 0.25f, 1.0f);
            this.mTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i17, null, this.mMvpMatrix);
        }
        if (i16 >= 0) {
            Matrix.setIdentityM(this.mMvpMatrix, 0);
            Matrix.translateM(this.mMvpMatrix, 0, 0.5f, -0.24f, 0.0f);
            Matrix.scaleM(this.mMvpMatrix, 0, 0.5f, 0.5f, 1.0f);
            if (this.mSurfaceTexture == null) {
                this.mTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i16, null, this.mMvpMatrix);
            } else {
                this.mTextureRender.drawTexture(36197, i16, null, this.mMvpMatrix);
            }
        }
        if (i3 >= 0) {
            Matrix.setIdentityM(this.mMvpMatrix, 0);
            Matrix.translateM(this.mMvpMatrix, 0, -0.5f, -0.24f, 0.0f);
            Matrix.scaleM(this.mMvpMatrix, 0, 0.5f, 0.5f, 1.0f);
            this.mTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, this.mMvpMatrix);
        }
        this.mRenderFBO.unbind();
        int texId = this.mRenderFBO.getTexId();
        this.mOutputTextureID = texId;
        return texId;
    }

    public void config(String str, String str2, String str3, long j3, boolean z16) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            assertFailed("config the pk video file path and cover both null!!");
            return;
        }
        SLog.e(TAG, "config pk video path = " + str + ", cover= " + str2 + ",mOrigVideoDurationMS = " + j3 + ",isEncode=" + z16);
        this.mIsEncode = z16;
        this.mVideoPath = str;
        this.mPKCoverPath = str2;
        this.mPKTitleBmgPath = str3;
        this.mOrigVideoDurationMS = j3;
        this.mPKDecodeListener = new PKDecodeListener();
        DecodePlayer decodePlayer = this.mDecodePlayer;
        if (decodePlayer != null) {
            decodePlayer.stopPlay();
        }
        if (FileUtil.fileExistsAndNotEmpty(str)) {
            DecodePlayer decodePlayer2 = new DecodePlayer();
            this.mDecodePlayer = decodePlayer2;
            decodePlayer2.setRepeat(false);
            if (z16) {
                this.mDecodePlayer.setNOSleep(true);
                this.mDecodePlayer.setSyncDecode(true);
            }
            this.mDecodePlayer.setFilePath(this.mVideoPath, null);
            this.mDecodePlayer.setDecodeListener(this.mPKDecodeListener);
            this.mDecodePlayer.setSpeedType(0);
        }
    }

    public void enableDebug(boolean z16) {
        this.isDebug = z16;
    }

    public String getPKCoverPath() {
        return this.mPKCoverPath;
    }

    public HWVideoDecoder getPKDecoder() {
        DecodePlayer decodePlayer = this.mDecodePlayer;
        if (decodePlayer == null) {
            return null;
        }
        return decodePlayer.getDecoder();
    }

    public String getPKTitleBmgPath() {
        return this.mPKTitleBmgPath;
    }

    public String getPKVideoPath() {
        return this.mVideoPath;
    }

    public long getPkVideoDurationMs() {
        return this.mPkVideoDurationMs;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return this.mIsSurfaceCreated;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mFilterDecodeTimeStamp = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
        int i3 = this.mPKCoverTextureID;
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            i3 = this.mRivalTextureID;
        } else {
            SLog.e(TAG, "mSurfaceTexture is null!!!");
        }
        super.onDrawFrame();
        int drawPKFrame = drawPKFrame(this.mInputTextureID, i3, this.mPKTitleTextureID);
        if (drawPKFrame < 0) {
            SLog.e(TAG, "out is fushu!!!");
            drawPKFrame = this.mInputTextureID;
        }
        this.mLastOutputTexture = drawPKFrame;
        this.mOutputTextureID = drawPKFrame;
        long currentTimeMillis2 = System.currentTimeMillis();
        SLog.e(TAG, "PKFilter draw frame cost=" + (currentTimeMillis2 - currentTimeMillis));
    }

    public void onFilterDecodeRepeat() {
        SLog.e(TAG, "filter decoder onDecodeRepeat");
        this.mFilterDecodeTimeStamp = 0L;
        DecodePlayer decodePlayer = this.mDecodePlayer;
        if (decodePlayer != null) {
            decodePlayer.startPlay(this.mRivalTextureID, this.onFrameAvailableListener);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        super.onSurfaceCreate();
        SLog.d(TAG, "init");
        if (!this.havePrepared) {
            prepare();
        }
        if (this.mTextureRender == null) {
            this.mTextureRender = new TextureRender();
        }
        this.mWidth = getQQFilterRenderManager().getFilterWidth();
        int filterHeight = getQQFilterRenderManager().getFilterHeight();
        this.mHeight = filterHeight;
        int i3 = this.mWidth;
        if (i3 > 720) {
            this.mHeight = (filterHeight * 720) / i3;
            this.mWidth = 720;
        }
        if (this.mWidth == 0 || this.mHeight == 0) {
            assertFailed("error:: get filter width=" + this.mWidth + " and mHeight=" + this.mHeight);
            this.mWidth = 720;
            this.mHeight = 1280;
        }
        if (this.mRenderFBO == null) {
            this.mRenderFBO = new RenderBuffer(this.mWidth, this.mHeight, 33984);
        }
        if (this.mPKCoverTextureID < 0 && FileUtil.fileExistsAndNotEmpty(this.mPKCoverPath)) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(this.mPKCoverPath);
                this.mPKCoverTextureID = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, decodeFile);
                decodeFile.recycle();
            } catch (OutOfMemoryError e16) {
                SLog.e(TAG, "create the pk cover texture out of memory:" + e16);
            }
            if (this.mPKCoverTextureID < 0) {
                SLog.e(TAG, "create the pk cover texture failed");
            }
        }
        if (this.mPKTitleTextureID < 0 && FileUtil.fileExistsAndNotEmpty(this.mPKTitleBmgPath)) {
            try {
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.mPKTitleBmgPath);
                this.mPKTitleTextureID = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, decodeFile2);
                decodeFile2.recycle();
            } catch (OutOfMemoryError e17) {
                SLog.e(TAG, "create the pk title texture out of memory:" + e17);
            }
            if (this.mPKTitleTextureID < 0) {
                SLog.e(TAG, "create the pk title texture failed");
            }
        }
        this.mIsSurfaceCreated = true;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        SLog.d(TAG, "onSurfaceDestroy");
        this.isPKdecoderNeedWaitStart = false;
        DecodePlayer decodePlayer = this.mDecodePlayer;
        if (decodePlayer != null) {
            decodePlayer.stopPlay();
        }
        this.havePrepared = false;
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        this.mRenderFBO = null;
        TextureRender textureRender = this.mTextureRender;
        if (textureRender != null) {
            textureRender.release();
        }
        this.mTextureRender = null;
        this.mSurfaceTexture = null;
        this.mIsSurfaceCreated = false;
        this.mPKCoverTextureID = -1;
        this.mPKTitleTextureID = -1;
    }

    public void prepare() {
        OnFrameAvailableListener onFrameAvailableListener = this.onFrameAvailableListener;
        if (onFrameAvailableListener != null) {
            onFrameAvailableListener.disable();
        }
        this.onFrameAvailableListener = new OnFrameAvailableListener(this);
        this.mSurfaceTexture = null;
        int i3 = this.mRivalTextureID;
        if (i3 > 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        }
        if (!FileUtil.fileExistsAndNotEmpty(this.mVideoPath)) {
            if (!FileUtil.fileExistsAndNotEmpty(this.mPKCoverPath)) {
                assertFailed("failed to prepare the filter when video path and cover is both no exists!");
                return;
            }
            SLog.e(TAG, "prepare pk video file is not ready , cover= " + this.mPKCoverPath);
            this.mRivalTextureID = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, BitmapFactory.decodeFile(this.mPKCoverPath));
            this.havePrepared = true;
            return;
        }
        int createTexture = GlUtil.createTexture(36197);
        this.mRivalTextureID = createTexture;
        this.isPKdecoderNeedWaitStart = true;
        this.mDecodePlayer.startPlay(createTexture, this.onFrameAvailableListener);
        this.havePrepared = true;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = surfaceTexture;
    }

    /* loaded from: classes18.dex */
    private class PKDecodeListener implements HWDecodeListener {
        PKDecodeListener() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeFrame(long j3, long j16) throws InterruptedException {
            SLog.d(PKFilter.TAG, "PK decoder onDecodeFrame=" + (j3 / 1000000));
            PKFilter.this.mPKVideoDecodeTimeStamp = j3;
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeRepeat() {
            PKFilter.this.mPKVideoDecodeTimeStamp = 0L;
            SLog.e(PKFilter.TAG, "pk decoder onDecodeRepeat");
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeCancel() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeFinish() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeStart() {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeSeekTo(long j3) {
        }

        @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
        public void onDecodeError(int i3, Throwable th5) {
        }
    }

    public void onFilterPlayStart() {
    }

    private void syncDecoderStartTime(long j3) {
    }
}
