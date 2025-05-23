package com.tencent.mobileqq.apollo.view.opengl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes11.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, h {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "[ApolloGL][GLTextureView]";
    private static final GLThreadManager sGLThreadManager;
    private int mDebugFlags;
    private boolean mDestroyOnAsync;
    private boolean mDetached;
    protected boolean mDisableCreateRenderThread;
    private e mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private f mEGLContextFactory;
    private g mEGLWindowSurfaceFactory;
    private FinishDrawing mFinishDrawing;
    private Runnable mForceSetAlphaTask;
    private GLThread mGLThread;
    private i mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private k mRenderer;
    int mSurfaceHeight;
    int mSurfaceWidth;
    private final WeakReference<h> mThisWeakRef;
    private Handler mUIHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class FinishDrawing implements Runnable {
        static IPatchRedirector $redirector_;

        FinishDrawing() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) GLTextureView.this);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (GLTextureView.this.mGLThread.ableToDraw()) {
                GLTextureView.this.checkSetAlpha();
            } else {
                GLTextureView.this.mGLThread.g(this);
            }
        }

        /* synthetic */ FinishDrawing(GLTextureView gLTextureView, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gLTextureView, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GLTextureView.this);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
            } else {
                GLTextureView gLTextureView = GLTextureView.this;
                gLTextureView.surfaceChanged(gLTextureView.getSurfaceTexture(), 0, i17 - i3, i18 - i16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            sGLThreadManager = new GLThreadManager();
        }
    }

    public GLTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mThisWeakRef = new WeakReference<>(this);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mForceSetAlphaTask = new Runnable() { // from class: com.tencent.mobileqq.apollo.view.opengl.GLTextureView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GLTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (GLTextureView.this.getViewAlpha() != 1.0f) {
                    GLTextureView.this.setViewAlpha(1.0f);
                }
                QLog.d(GLTextureView.TAG, 1, "TextureView mCheckSurfaceChangeTask, ableToDraw:" + GLTextureView.this.mGLThread.ableToDraw() + ",alpha:" + GLTextureView.this.getViewAlpha());
            }
        };
        this.mFinishDrawing = new FinishDrawing(this, null);
        init();
    }

    public static void checkGLVersion(Context context) {
        GLThreadManager.c(context);
    }

    private void checkRenderThreadState() {
        if (this.mGLThread == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSetAlpha() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mUIHandler.post(this.mForceSetAlphaTask);
        } else {
            this.mForceSetAlphaTask.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    public float getViewAlpha() {
        return getAlpha();
    }

    private void init() {
        GLThreadManager.e(getContext());
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(new a());
        setViewAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    public void setViewAlpha(float f16) {
        setAlpha(f16);
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public int getDebugFlags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mDebugFlags;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public e getEGLConfigChooser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mEGLConfigChooser;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public f getEGLContextFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mEGLContextFactory;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public g getEGLWindowSurfaceFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (g) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mEGLWindowSurfaceFactory;
    }

    public long getGLThreadId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
        }
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            return gLThread.getId();
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public i getGLWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (i) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mGLWrapper;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public Object getNativeWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return getSurfaceTexture();
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public boolean getPreserveEGLContextOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mGLThread.getRenderMode();
    }

    public String getRenderThreadName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "GLTexture_";
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public k getRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (k) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mRenderer;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        QLog.d(TAG, 1, "onAttachedToWindow reattach =" + this.mDetached + ", mDisableCreateRenderThread: " + this.mDisableCreateRenderThread);
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                i3 = gLThread.getRenderMode();
            } else {
                i3 = 1;
            }
            if (!this.mDisableCreateRenderThread) {
                GLThread gLThread2 = new GLThread(sGLThreadManager, this.mThisWeakRef);
                this.mGLThread = gLThread2;
                gLThread2.f(this.mDestroyOnAsync);
                this.mGLThread.setName(getRenderThreadName() + "_" + this.mGLThread.getId());
                this.mGLThread.h(false);
                if (i3 != 1) {
                    this.mGLThread.setRenderMode(i3);
                }
                this.mGLThread.start();
            } else {
                QLog.e(TAG, 1, "onAttachedToWindow mDisableCreateRenderThread true");
            }
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        QLog.d(TAG, 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            this.mGLThread.onPause();
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            this.mGLThread.onResume();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mGLThread.g(this.mFinishDrawing);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        QLog.d(TAG, 1, "onSurfaceTextureAvailable");
        long currentTimeMillis = System.currentTimeMillis();
        surfaceCreated(surfaceTexture);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, 2, " TextureView onSurfaceTextureAvailable surfaceCreated cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        surfaceChanged(surfaceTexture, 0, i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, 2, " TextureView onSurfaceTextureAvailable surfaceChanged cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        QLog.d(TAG, 1, "onSurfaceTextureDestroyed");
        surfaceDestroyed(surfaceTexture);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "TextureView onSurfaceTextureDestroyed");
        }
        setViewAlpha(0.0f);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        surfaceChanged(surfaceTexture, 0, i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "TextureView onSurfaceTextureSizeChanged surfaceChanged cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) surfaceTexture);
        }
    }

    public void queueEvent(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) runnable);
        } else {
            this.mGLThread.queueEvent(runnable);
        }
    }

    public void requestRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mGLThread.requestRender();
        }
    }

    public void setDebugFlags(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mDebugFlags = i3;
        }
    }

    public void setDestroyOnAsync(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.mDestroyOnAsync = z16;
        }
    }

    public void setEGLConfigChooser(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) eVar);
        } else {
            checkRenderThreadState();
            this.mEGLConfigChooser = eVar;
        }
    }

    public void setEGLContextClientVersion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            checkRenderThreadState();
            this.mEGLContextClientVersion = i3;
        }
    }

    public void setEGLContextFactory(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) fVar);
        } else {
            checkRenderThreadState();
            this.mEGLContextFactory = fVar;
        }
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) gVar);
        } else {
            checkRenderThreadState();
            this.mEGLWindowSurfaceFactory = gVar;
        }
    }

    public void setGLWrapper(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
        } else {
            this.mGLWrapper = iVar;
        }
    }

    public void setPreserveEGLContextOnPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mPreserveEGLContextOnPause = z16;
        }
    }

    public void setRenderMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.mGLThread.setRenderMode(i3);
        }
    }

    public void setRenderer(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) kVar);
            return;
        }
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new l(this.mEGLContextClientVersion, true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new c(this.mEGLContextClientVersion);
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new d();
        }
        this.mRenderer = kVar;
        GLThread gLThread = new GLThread(sGLThreadManager, this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.f(this.mDestroyOnAsync);
        this.mGLThread.setName(getRenderThreadName() + "_" + this.mGLThread.getId());
        this.mGLThread.h(false);
        this.mGLThread.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.mSurfaceWidth != i16 || this.mSurfaceHeight != i17) {
            this.mSurfaceWidth = i16;
            this.mSurfaceHeight = i17;
            this.mGLThread.g(this.mFinishDrawing);
            this.mGLThread.onWindowResize(i16, i17);
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) surfaceTexture);
        } else {
            this.mGLThread.surfaceCreated();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) surfaceTexture);
        } else {
            this.mGLThread.surfaceDestroyed();
        }
    }

    public void setEGLConfigChooser(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            setEGLConfigChooser(new l(this.mEGLContextClientVersion, z16));
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    public void setEGLConfigChooser(int i3, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            setEGLConfigChooser(new b(this.mEGLContextClientVersion, i3, i16, i17, i18, i19, i26));
        } else {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mThisWeakRef = new WeakReference<>(this);
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mForceSetAlphaTask = new Runnable() { // from class: com.tencent.mobileqq.apollo.view.opengl.GLTextureView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GLTextureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (GLTextureView.this.getViewAlpha() != 1.0f) {
                    GLTextureView.this.setViewAlpha(1.0f);
                }
                QLog.d(GLTextureView.TAG, 1, "TextureView mCheckSurfaceChangeTask, ableToDraw:" + GLTextureView.this.mGLThread.ableToDraw() + ",alpha:" + GLTextureView.this.getViewAlpha());
            }
        };
        this.mFinishDrawing = new FinishDrawing(this, null);
        init();
    }
}
