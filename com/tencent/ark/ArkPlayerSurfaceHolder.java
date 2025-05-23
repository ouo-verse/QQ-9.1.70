package com.tencent.ark;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.ark.ark;

/* loaded from: classes3.dex */
public class ArkPlayerSurfaceHolder implements SurfaceTexture.OnFrameAvailableListener {
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    public static final String TAG = "ArkApp.ArkPlayerSurfaceHolder";
    protected EGLContextHolder mOffscreenContext;
    protected String mQueueKey;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureID = 0;
    public long mFrameCallback = 0;
    public long mFrameUserdata = 0;
    public int mFrameWidth = 0;
    public int mFrameHeight = 0;

    public void DoDispathTask(Runnable runnable) {
        if (this.mQueueKey == ArkDispatchQueue.getCurrentQueueKey()) {
            runnable.run();
        } else {
            ArkDispatchQueue.asyncRun(this.mQueueKey, runnable);
        }
    }

    public void SetFrameCallback(long j3, long j16) {
        this.mFrameCallback = j3;
        this.mFrameUserdata = j16;
    }

    public void SetFrameSize(int i3, int i16) {
        this.mFrameWidth = i3;
        this.mFrameHeight = i16;
    }

    public void deinitialize() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        EGLContextHolder eGLContextHolder = this.mOffscreenContext;
        if (eGLContextHolder != null && this.mTextureID != 0) {
            eGLContextHolder.makeCurrent();
            GLES20.glDeleteTextures(1, new int[]{this.mTextureID}, 0);
        }
        this.mTextureID = 0;
    }

    public Surface getSurface() {
        Surface surface = this.mSurface;
        if (surface != null) {
            return surface;
        }
        if (this.mSurfaceTexture == null) {
            return null;
        }
        Surface surface2 = new Surface(this.mSurfaceTexture);
        this.mSurface = surface2;
        return surface2;
    }

    public boolean initialize() {
        if (this.mSurfaceTexture != null) {
            return true;
        }
        this.mQueueKey = ArkDispatchQueue.getCurrentQueueKey();
        if (this.mOffscreenContext == null) {
            this.mOffscreenContext = ArkViewModel.getOffscreenContext();
        }
        EGLContextHolder eGLContextHolder = this.mOffscreenContext;
        if (eGLContextHolder != null && eGLContextHolder.makeCurrent()) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            if (i3 == 0) {
                Logger.logE(TAG, "initialize.glGenTextures.fail!!");
                return false;
            }
            this.mTextureID = i3;
            GLES20.glBindTexture(36197, i3);
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            return true;
        }
        Logger.logE(TAG, "initialize.makeCurrent.fail!!");
        return false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.mSurfaceTexture != null && this.mOffscreenContext != null && this.mFrameCallback != 0) {
            DoDispathTask(new Runnable() { // from class: com.tencent.ark.ArkPlayerSurfaceHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    EGLContextHolder eGLContextHolder;
                    ArkPlayerSurfaceHolder arkPlayerSurfaceHolder = ArkPlayerSurfaceHolder.this;
                    if (arkPlayerSurfaceHolder.mSurfaceTexture != null && (eGLContextHolder = arkPlayerSurfaceHolder.mOffscreenContext) != null && arkPlayerSurfaceHolder.mFrameCallback != 0 && eGLContextHolder.makeCurrent()) {
                        ArkPlayerSurfaceHolder.this.mSurfaceTexture.updateTexImage();
                        ark.PlayerStub.FrameInfo frameInfo = new ark.PlayerStub.FrameInfo();
                        ArkPlayerSurfaceHolder arkPlayerSurfaceHolder2 = ArkPlayerSurfaceHolder.this;
                        frameInfo.width = arkPlayerSurfaceHolder2.mFrameWidth;
                        frameInfo.height = arkPlayerSurfaceHolder2.mFrameHeight;
                        frameInfo.texture = arkPlayerSurfaceHolder2.mTextureID;
                        ark.PlayerUpdateFrame(arkPlayerSurfaceHolder2.mFrameCallback, arkPlayerSurfaceHolder2.mFrameUserdata, frameInfo);
                    }
                }
            });
        }
    }
}
