package com.tencent.ark;

import android.graphics.RectF;
import com.tencent.ark.ark;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkViewModel extends ArkViewModelBase {
    protected static final String TAG = "ArkApp.ArkViewModel";
    protected IArkEGLContextManager mContextManager;
    protected ArkTextureViewImpl mHardwareView;
    protected boolean mIsSurfaceInvalid;
    public boolean needRefresh;

    public ArkViewModel(ark.ApplicationCallback applicationCallback) {
        this(applicationCallback, true);
    }

    public static EGLContextHolder getOffscreenContext() {
        if (!ArkViewModelBase.ENV.isHardwareAcceleration()) {
            return null;
        }
        return EGLContextHolder.getApplicationContext();
    }

    @Override // com.tencent.ark.ArkViewModelBase, com.tencent.ark.ark.ContainerCallback
    public void Update(float f16, float f17, float f18, float f19) {
        super.Update(f16, f17, f18, f19);
        this.mIsSurfaceInvalid = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void applicationCreate(ark.Application application) {
        if (!ArkViewModelBase.ENV.isHardwareAcceleration()) {
            Logger.logI(TAG, String.format("applicationCreate.app.no.hardware.rendering.this: %h", this));
            super.applicationCreate(application);
        } else {
            if (application == null) {
                Logger.logE(TAG, String.format("applicationCreate.app.is.null.this: %h", this));
                return;
            }
            EGLContextHolder createContext = this.mContextManager.createContext(this.mAppInfo.name);
            if (createContext == null) {
                Logger.logE(TAG, String.format("applicationCreate.createContext.fail.this: %h", this));
            }
            EGLContextHolder.setApplicationContext(createContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void applicationRelease(ark.Application application) {
        if (!ArkViewModelBase.ENV.isHardwareAcceleration()) {
            super.applicationRelease(application);
            return;
        }
        Logger.logE(TAG, String.format("applicationRelease.releaseContext.this: %h", this));
        if (this.mContextManager.releaseContext(this.mAppInfo.name)) {
            EGLContextHolder.setApplicationContext(null);
        }
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void createDrawTarget(ArkViewImplement arkViewImplement) {
        Logger.logD(TAG, String.format("createDrawTarget.this.%h.app.%s.container.%h", this, this.mAppInfo.name, this.mContainer));
        if (!this.mIsGpuRendering) {
            super.createDrawTarget(arkViewImplement);
            return;
        }
        this.mTimeRecord.beginOfCreateDrawTarget = System.currentTimeMillis();
        ArkTextureViewImpl arkTextureViewImpl = this.mHardwareView;
        if (arkTextureViewImpl != null && !this.mRectContainer.isEmpty()) {
            ark.Container container = this.mContainer;
            if (container != null) {
                if (!container.CreateHardwareBitmap(this.mRectContainer.width(), this.mRectContainer.height())) {
                    Logger.logI(TAG, String.format("createDrawTarget.this.%h.app.%s.container.%h", this, this.mAppInfo.name, this.mContainer));
                }
                this.mContainer.SetContextHolder(arkTextureViewImpl.getContextHolder());
            }
            invalidateRect();
            this.mTimeRecord.endOfCreateDrawTarget = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void destroyDrawTarget() {
        if (!this.mIsGpuRendering) {
            super.destroyDrawTarget();
            return;
        }
        Logger.logD(TAG, String.format("destroyDrawTarget.this.%h.app.%s.container.%h", this, this.mAppInfo.name, this.mContainer));
        ark.Container container = this.mContainer;
        if (container != null) {
            container.SetContextHolder(null);
            this.mContainer.DestroyHardwareBitmap();
        }
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void detachView() {
        super.detachView();
        this.mHardwareView = null;
    }

    @Override // com.tencent.ark.ArkViewModelBase, com.tencent.ark.ArkVsync.ArkFrameCallback
    public void doFrame() {
        boolean z16;
        if (!this.mIsGpuRendering) {
            super.doFrame();
            return;
        }
        ArkEnvironmentManager arkEnvironmentManager = ArkViewModelBase.ENV;
        if (arkEnvironmentManager.mIsDebug && arkEnvironmentManager.mShowVsyncLog) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.mSyncRectLock && this.mAttached) {
            beginDraw();
            if (!this.mRectInvalidF.isEmpty()) {
                ark.Container container = this.mContainer;
                RectF rectF = this.mRectInvalidF;
                if (container.Paint(rectF.left, rectF.top, rectF.right, rectF.bottom)) {
                    if (z16) {
                        Logger.logI(TAG, String.format("doFrame.paint.succ.%h.(%.1f, %.1f, %.1f, %.1f)", this, Float.valueOf(this.mRectContainerF.left), Float.valueOf(this.mRectContainerF.top), Float.valueOf(this.mRectContainerF.right), Float.valueOf(this.mRectContainerF.bottom)));
                    }
                    this.mRectInvalidF.setEmpty();
                }
            }
            if (this.mIsSurfaceInvalid && this.mContainer.InvalidSurface()) {
                this.mIsSurfaceInvalid = false;
                if (z16) {
                    Logger.logI(TAG, String.format("doFrame.invalid.succ.%h", this));
                }
                endDraw();
                didFirstPaint();
                return;
            }
            return;
        }
        if (z16) {
            Logger.logE(TAG, String.format("doFrame.fail.1.%h", this));
        }
    }

    public EGLContextHolder getContext() {
        return this.mContextManager.getContext(this.mAppInfo.name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public boolean initArkContainer(ArkViewImplement arkViewImplement) {
        if (arkViewImplement == null || arkViewImplement.getView() == null) {
            return false;
        }
        if (this.mIsGpuRendering) {
            if (!(arkViewImplement.getView() instanceof ArkTextureViewImpl)) {
                return false;
            }
            this.mHardwareView = (ArkTextureViewImpl) arkViewImplement.getView();
        }
        return super.initArkContainer(arkViewImplement);
    }

    @Override // com.tencent.ark.ArkViewModelBase
    protected void initLibrary() {
        ark.MediaSetStub(ArkPlayer.sFactory);
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void invalidateRect() {
        super.invalidateRect();
        this.mRectInvalidF.set(this.mRectContainerF);
        this.mIsSurfaceInvalid = true;
    }

    public boolean isGpuRenderingEnabled() {
        return this.mIsGpuRendering;
    }

    public ArkViewModel(ark.ApplicationCallback applicationCallback, boolean z16) {
        super(applicationCallback);
        boolean z17 = false;
        this.mIsSurfaceInvalid = false;
        this.mContextManager = null;
        this.needRefresh = false;
        if (z16 && ArkViewModelBase.ENV.isHardwareAcceleration()) {
            z17 = true;
        }
        this.mIsGpuRendering = z17;
        this.mContextManager = ArkEGLContextManager.getManager(ArkViewModelBase.ENV.isSingleThreadMode() ? 1 : 2);
    }
}
