package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.tencent.ark.ArkTextureView;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkTextureViewImpl extends TextureView implements TextureView.SurfaceTextureListener, ArkTextureView.ArkTextureViewInterface {
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    protected static String TAG = "ArkApp.ArkTextureViewImpl";
    private Object mLock;
    private SurfaceTexture mSurface;
    private volatile boolean mSurfaceAvailable;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private ViewContext mViewContext;
    public ArkViewImplement mViewImpl;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ViewContext {
        EGLContextHolder contextHolder;
        SurfaceTexture surfaceTexture;
        ArkViewModel viewModel;

        ViewContext() {
        }
    }

    public ArkTextureViewImpl(Context context, ArkViewImplement arkViewImplement) {
        super(context);
        this.mSurfaceAvailable = false;
        this.mLock = new Object();
        this.mViewImpl = arkViewImplement;
        setSurfaceTextureListener(this);
        setOpaque(false);
        if (isAvailable() && ENV.mIsDebug) {
            Logger.logD(TAG, String.format("surface.available.this.%h", this));
        }
    }

    private static void releaseContext(final ViewContext viewContext) {
        ArkViewModel arkViewModel;
        if (viewContext == null || (arkViewModel = viewContext.viewModel) == null) {
            return;
        }
        Logger.logD(TAG, String.format("releaseContext.begin.model.%h.context.%h.queue.%s", arkViewModel, viewContext.contextHolder, arkViewModel.getQueueKey()));
        ArkDispatchQueue.asyncRun(viewContext.viewModel.getQueueKey(), new Runnable() { // from class: com.tencent.ark.ArkTextureViewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                String str = ArkTextureViewImpl.TAG;
                ViewContext viewContext2 = ViewContext.this;
                ArkViewModel arkViewModel2 = viewContext2.viewModel;
                Logger.logI(str, String.format("releaseContext.run.model.%h.context.%h.queue.%s", arkViewModel2, viewContext2.contextHolder, arkViewModel2.getQueueKey()));
                ViewContext.this.viewModel.destroyDrawTarget();
                EGLContextHolder eGLContextHolder = ViewContext.this.contextHolder;
                if (eGLContextHolder != null) {
                    eGLContextHolder.release();
                    ViewContext.this.contextHolder = null;
                }
            }
        });
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void checkSurfaceAvailable() {
        if (this.mSurfaceAvailable) {
            return;
        }
        if (isAvailable()) {
            Logger.logE(TAG, String.format("checkSurfaceAvailable.become.available.this.%h", this));
            onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
        } else {
            Logger.logE(TAG, String.format("checkSurfaceAvailable.not.available.this.%h", this));
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void createContext() {
        createContext(this.mSurface, this.mSurfaceWidth, this.mSurfaceHeight);
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public Bitmap getBitmapBuffer() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EGLContextHolder getContextHolder() {
        EGLContextHolder eGLContextHolder;
        synchronized (this) {
            ViewContext viewContext = this.mViewContext;
            if (viewContext != null && (eGLContextHolder = viewContext.contextHolder) != null) {
                return eGLContextHolder;
            }
            Logger.logE(TAG, String.format("getContextHolder.context.is.null.this.%h", this));
            return null;
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public boolean onInvalidate(Rect rect) {
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        Rect rect = this.mViewImpl.mRectView;
        if (!rect.isEmpty()) {
            setMeasuredDimension(rect.width(), rect.height());
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        Logger.logI(TAG, String.format("onSurfaceTextureAvailable.this.%h.surface.%h.size.(%d, %d)", this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16)));
        if (this.mSurface == surfaceTexture && this.mSurfaceWidth == i3 && this.mSurfaceHeight == i16) {
            Logger.logI(TAG, String.format("onSurfaceTextureAvailable.already.called.this.%h.surface.%h.size.(%d, %d)", this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16)));
        } else {
            onSurfaceTextureSizeChanged(surfaceTexture, i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Logger.logI(TAG, String.format("onSurfaceTextureDestroyed.this.%h.viewContext.%h.surface.%h", this, this.mViewContext, surfaceTexture));
        releaseContext();
        synchronized (this.mLock) {
            this.mSurfaceAvailable = false;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        Logger.logI(TAG, String.format("onSurfaceTextureSizeChanged.this.%h.surface.%h.width.%d.height.%d.viewContext.%h", this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16), this.mViewContext));
        synchronized (this.mLock) {
            this.mSurfaceAvailable = true;
        }
        this.mSurface = surfaceTexture;
        this.mSurfaceWidth = i3;
        this.mSurfaceHeight = i16;
        createContext(surfaceTexture, i3, i16);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (ENV.mShowVsyncLog) {
            Logger.logD(TAG, String.format("onSurfaceTextureUpdated.this.%h", this));
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public Bitmap recreateBitmapBuffer(Rect rect) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[Catch: all -> 0x00a5, TryCatch #0 {, blocks: (B:8:0x0026, B:12:0x0051, B:13:0x0063, B:17:0x0067, B:18:0x0070, B:19:0x0074, B:22:0x002f, B:24:0x0033), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void createContext(final SurfaceTexture surfaceTexture, final int i3, final int i16) {
        byte b16;
        if (surfaceTexture != null && i3 != 0 && i16 != 0) {
            Logger.logD(TAG, String.format("createContext.this.%h.viewContext.%h", this, this.mViewContext));
            final ArkViewModel viewModel = this.mViewImpl.getViewModel();
            synchronized (this) {
                ViewContext viewContext = this.mViewContext;
                ViewContext viewContext2 = null;
                byte b17 = 0;
                if (viewContext != null) {
                    if (viewContext.viewModel == viewModel) {
                        b16 = false;
                        if (viewModel != null) {
                            Logger.logI(TAG, String.format("createContext.current.view.model.is.null.this.%h.surface.%h", this, surfaceTexture));
                            return;
                        }
                        if (b16 != false) {
                            ViewContext viewContext3 = new ViewContext();
                            this.mViewContext = viewContext3;
                            viewContext3.viewModel = viewModel;
                        }
                        final ViewContext viewContext4 = this.mViewContext;
                        viewContext4.surfaceTexture = surfaceTexture;
                        Logger.logI(TAG, String.format("createContext.1.this.%h.size.(%d, %d).model.%h.surface.%h", this, Integer.valueOf(i3), Integer.valueOf(i16), viewModel, surfaceTexture));
                        viewModel.SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkTextureViewImpl.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Logger.logD(ArkTextureViewImpl.TAG, String.format("createContext.2.this.%h.size.(%d, %d)", ArkTextureViewImpl.this, Integer.valueOf(i3), Integer.valueOf(i16)));
                                viewModel.mTimeRecord.beginOfCreateContext = System.currentTimeMillis();
                                ViewContext viewContext5 = viewContext4;
                                if (viewContext5.surfaceTexture == null) {
                                    Logger.logE(ArkTextureViewImpl.TAG, String.format("createContext.surface.null: %h", ArkTextureViewImpl.this));
                                    return;
                                }
                                EGLContextHolder eGLContextHolder = viewContext5.contextHolder;
                                if (eGLContextHolder != null && eGLContextHolder.mSurfaceTexture == surfaceTexture) {
                                    Logger.logI(ArkTextureViewImpl.TAG, String.format("createContext.sizeChanged: %h", ArkTextureViewImpl.this));
                                    viewContext4.contextHolder.sizeChanged(i3, i16);
                                } else {
                                    if (eGLContextHolder != null) {
                                        Logger.logD(ArkTextureViewImpl.TAG, String.format("createContext.surface.rebind: %h, model:%h, context:%h", ArkTextureViewImpl.this, viewContext5.viewModel, eGLContextHolder));
                                        viewContext4.contextHolder.release();
                                        viewContext4.contextHolder = null;
                                    }
                                    EGLContextHolder context = viewModel.getContext();
                                    if (context != null) {
                                        synchronized (ArkTextureViewImpl.this.mLock) {
                                            if (!ArkTextureViewImpl.this.mSurfaceAvailable) {
                                                Logger.logE(ArkTextureViewImpl.TAG, String.format("createContext.Surface is unavailable", new Object[0]));
                                                return;
                                            } else {
                                                viewContext4.contextHolder = new EGLContextHolder();
                                                ViewContext viewContext6 = viewContext4;
                                                viewContext6.contextHolder.create(context.mContext, viewContext6.surfaceTexture, i3, i16);
                                            }
                                        }
                                    } else {
                                        Logger.logE(ArkTextureViewImpl.TAG, String.format("createContext.offscreenContext.null: %h, model:%h", ArkTextureViewImpl.this, viewContext4.viewModel));
                                        return;
                                    }
                                }
                                viewModel.mTimeRecord.endOfCreateContext = System.currentTimeMillis();
                                viewModel.createDrawTarget(null);
                            }
                        });
                        return;
                    }
                    this.mViewContext = null;
                    Logger.logE(TAG, String.format("createContext.model.changed.this.%h.viewContext.%h.model.%h.new.model.%h.", this, null, viewContext2.viewModel, viewModel));
                }
                b16 = true;
                if (viewModel != null) {
                }
            }
        } else {
            Logger.logE(TAG, String.format("createContext.surface.not.ready.this.%h", this));
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void releaseContext() {
        String str = TAG;
        Object[] objArr = new Object[3];
        objArr[0] = this;
        ViewContext viewContext = this.mViewContext;
        objArr[1] = viewContext;
        objArr[2] = viewContext != null ? viewContext.viewModel : null;
        Logger.logD(str, String.format("releaseContext.this.%h.viewContext.%h.model.%h", objArr));
        synchronized (this) {
            ViewContext viewContext2 = this.mViewContext;
            this.mViewContext = null;
            releaseContext(viewContext2);
        }
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void destroyBitmapBuffer() {
    }

    @Override // com.tencent.ark.ArkTextureView.ArkTextureViewInterface
    public void initArkView(ArkViewModel arkViewModel) {
    }
}
