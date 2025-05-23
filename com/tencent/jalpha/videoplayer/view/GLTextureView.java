package com.tencent.jalpha.videoplayer.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.tencent.ark.EGLContextHolder;
import com.tencent.jalpha.common.Logger;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes7.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GLTextureView";
    private static int sGLESVersion;
    private static final GLThreadManager sGLThreadManager;
    private Runnable mCheckAlphaTask;
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private GLSurfaceView.Renderer mRenderer;
    int mSurfaceHeight;
    private boolean mSurfaceTextureAvailable;
    int mSurfaceWidth;
    private final WeakReference<GLTextureView> mThisWeakRef;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private abstract class BaseConfigChooser implements EGLConfigChooser {
        static IPatchRedirector $redirector_;
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GLTextureView.this, (Object) iArr);
            } else {
                this.mConfigSpec = filterConfigSpec(iArr);
            }
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GLTextureView.this.mEGLContextClientVersion != 2 && GLTextureView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i3 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = 12352;
            if (GLTextureView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // com.tencent.jalpha.videoplayer.view.GLTextureView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EGLConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) egl10, (Object) eGLDisplay);
            }
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                int i3 = iArr[0];
                if (i3 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i3];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i3, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class ComponentSizeChooser extends BaseConfigChooser {
        static IPatchRedirector $redirector_;
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;

        public ComponentSizeChooser(int i3, int i16, int i17, int i18, int i19, int i26) {
            super(new int[]{12324, i3, 12323, i16, 12322, i17, 12321, i18, 12325, i19, 12326, i26, 12344});
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GLTextureView.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
                return;
            }
            this.mValue = new int[1];
            this.mRedSize = i3;
            this.mGreenSize = i16;
            this.mBlueSize = i17;
            this.mAlphaSize = i18;
            this.mDepthSize = i19;
            this.mStencilSize = i26;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, int i16) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, this.mValue)) {
                return this.mValue[0];
            }
            return i16;
        }

        @Override // com.tencent.jalpha.videoplayer.view.GLTextureView.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EGLConfig) iPatchRedirector.redirect((short) 2, this, egl10, eGLDisplay, eGLConfigArr);
            }
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class DefaultContextFactory implements EGLContextFactory {
        static IPatchRedirector $redirector_;
        private int EGL_CONTEXT_CLIENT_VERSION;

        /* synthetic */ DefaultContextFactory(GLTextureView gLTextureView, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gLTextureView, (Object) anonymousClass1);
        }

        @Override // com.tencent.jalpha.videoplayer.view.GLTextureView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EGLContext) iPatchRedirector.redirect((short) 2, this, egl10, eGLDisplay, eGLConfig);
            }
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.tencent.jalpha.videoplayer.view.GLTextureView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, egl10, eGLDisplay, eGLContext);
                return;
            }
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
        }

        DefaultContextFactory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.EGL_CONTEXT_CLIENT_VERSION = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GLTextureView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        static IPatchRedirector $redirector_;

        /* synthetic */ DefaultWindowSurfaceFactory(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }

        @Override // com.tencent.jalpha.videoplayer.view.GLTextureView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EGLSurface) iPatchRedirector.redirect((short) 2, this, egl10, eGLDisplay, eGLConfig, obj);
            }
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e16) {
                Log.e(GLTextureView.TAG, "eglCreateWindowSurface", e16);
                return null;
            }
        }

        @Override // com.tencent.jalpha.videoplayer.view.GLTextureView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, egl10, eGLDisplay, eGLSurface);
            } else {
                egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            }
        }

        DefaultWindowSurfaceFactory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class EglHelper {
        static IPatchRedirector $redirector_;
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLTextureView> mGLTextureViewWeakRef;

        public EglHelper(WeakReference<GLTextureView> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            } else {
                this.mGLTextureViewWeakRef = weakReference;
            }
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.mGLTextureViewWeakRef.get();
                if (gLTextureView != null) {
                    gLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public static String formatEglError(String str, int i3) {
            return str + " failed: " + getErrorString(i3);
        }

        public static String getErrorString(int i3) {
            switch (i3) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case 12298:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return getHex(i3);
            }
        }

        private static String getHex(int i3) {
            return RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i3);
        }

        public static void logEglErrorAsWarning(String str, String str2, int i3) {
            Log.w(str, formatEglError(str2, i3));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        GL createGL() {
            LogWriter logWriter;
            GL gl5 = this.mEglContext.getGL();
            GLTextureView gLTextureView = this.mGLTextureViewWeakRef.get();
            if (gLTextureView != null) {
                if (gLTextureView.mGLWrapper != null) {
                    gl5 = gLTextureView.mGLWrapper.wrap(gl5);
                }
                if ((gLTextureView.mDebugFlags & 3) != 0) {
                    int i3 = 1;
                    if ((gLTextureView.mDebugFlags & 1) == 0) {
                        i3 = 0;
                    }
                    if ((gLTextureView.mDebugFlags & 2) != 0) {
                        logWriter = new LogWriter();
                    } else {
                        logWriter = null;
                    }
                    return GLDebugHelper.wrap(gl5, i3, logWriter);
                }
                return gl5;
            }
            return gl5;
        }

        public boolean createSurface() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.mEgl != null) {
                if (this.mEglDisplay != null) {
                    if (this.mEglConfig != null) {
                        destroySurfaceImp();
                        GLTextureView gLTextureView = this.mGLTextureViewWeakRef.get();
                        if (gLTextureView != null) {
                            this.mEglSurface = gLTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLTextureView.getSurfaceTexture());
                        } else {
                            this.mEglSurface = null;
                        }
                        EGLSurface eGLSurface = this.mEglSurface;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                                return false;
                            }
                            return true;
                        }
                        if (this.mEgl.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void destroySurface() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                destroySurfaceImp();
            }
        }

        public void finish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            if (this.mEglContext != null) {
                GLTextureView gLTextureView = this.mGLTextureViewWeakRef.get();
                if (gLTextureView != null) {
                    gLTextureView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        public void start() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.mGLTextureViewWeakRef.get();
                    if (gLTextureView == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = gLTextureView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = gLTextureView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int swap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return 12288;
        }

        public static void throwEglException(String str, int i3) {
            throw new RuntimeException(formatEglError(str, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class GLThread extends BaseThread {
        static IPatchRedirector $redirector_;
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue;
        private boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GLTextureView> mGLTextureViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight;
        private boolean mLogPrinted;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode;
        private boolean mRequestPaused;
        private boolean mRequestRender;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int mWidth;

        GLThread(WeakReference<GLTextureView> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
                return;
            }
            this.mLogPrinted = false;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mRenderMode = 1;
            this.mRequestRender = true;
            this.mEventQueue = new ArrayList<>();
            this.mSizeChanged = true;
            this.mGLTextureViewWeakRef = weakReference;
        }

        private void guardedRun() throws InterruptedException {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            this.mEglHelper = new EglHelper(this.mGLTextureViewWeakRef);
            boolean z28 = false;
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            boolean z29 = false;
            boolean z36 = false;
            boolean z37 = false;
            boolean z38 = false;
            boolean z39 = false;
            int i3 = 0;
            int i16 = 0;
            boolean z46 = false;
            boolean z47 = false;
            boolean z48 = false;
            GL10 gl10 = null;
            while (true) {
                Runnable runnable = null;
                boolean z49 = z29;
                while (true) {
                    try {
                        boolean z55 = z49;
                        synchronized (GLTextureView.sGLThreadManager) {
                            while (!this.mShouldExit) {
                                try {
                                    try {
                                        if (!this.mEventQueue.isEmpty()) {
                                            try {
                                                runnable = this.mEventQueue.remove(z28 ? 1 : 0);
                                                z18 = z55;
                                                z19 = z28 ? 1 : 0;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                z28 = true;
                                                try {
                                                    throw th;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    z16 = z28;
                                                }
                                            }
                                        } else {
                                            boolean z56 = this.mPaused;
                                            boolean z57 = this.mRequestPaused;
                                            if (z56 != z57) {
                                                this.mPaused = z57;
                                                GLTextureView.sGLThreadManager.notifyAll();
                                            } else {
                                                z57 = z28 ? 1 : 0;
                                            }
                                            if (this.mShouldReleaseEglContext) {
                                                stopEglSurfaceLocked();
                                                stopEglContextLocked();
                                                this.mShouldReleaseEglContext = z28;
                                                z48 = true;
                                            }
                                            if (z55) {
                                                stopEglSurfaceLocked();
                                                stopEglContextLocked();
                                                z55 = z28 ? 1 : 0;
                                            }
                                            if (z57 && this.mHaveEglSurface) {
                                                stopEglSurfaceLocked();
                                            }
                                            if (z57 && this.mHaveEglContext) {
                                                GLTextureView gLTextureView = this.mGLTextureViewWeakRef.get();
                                                if (gLTextureView == null) {
                                                    z27 = z28 ? 1 : 0;
                                                } else {
                                                    z27 = gLTextureView.mPreserveEGLContextOnPause;
                                                }
                                                if (!z27 || GLTextureView.sGLThreadManager.shouldReleaseEGLContextWhenPausing()) {
                                                    stopEglContextLocked();
                                                }
                                            }
                                            if (z57 && GLTextureView.sGLThreadManager.shouldTerminateEGLWhenPausing()) {
                                                this.mEglHelper.finish();
                                            }
                                            if (this.mHasSurface || this.mWaitingForSurface) {
                                                z26 = z55;
                                            } else {
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append("noticed surfaceView surface lost tid=");
                                                z26 = z55;
                                                sb5.append(getId());
                                                Logger.d(GLTextureView.TAG, sb5.toString());
                                                if (this.mHaveEglSurface) {
                                                    stopEglSurfaceLocked();
                                                }
                                                this.mWaitingForSurface = true;
                                                this.mSurfaceIsBad = false;
                                                GLTextureView.sGLThreadManager.notifyAll();
                                            }
                                            if (this.mHasSurface && this.mWaitingForSurface) {
                                                this.mWaitingForSurface = false;
                                                GLTextureView.sGLThreadManager.notifyAll();
                                            }
                                            if (z47) {
                                                this.mRenderComplete = true;
                                                GLTextureView.sGLThreadManager.notifyAll();
                                                z46 = false;
                                                z47 = false;
                                            }
                                            if (readyToDraw()) {
                                                if (!this.mHaveEglContext) {
                                                    if (z48) {
                                                        z48 = false;
                                                    } else if (GLTextureView.sGLThreadManager.tryAcquireEglContextLocked(this)) {
                                                        try {
                                                            this.mEglHelper.start();
                                                            this.mHaveEglContext = true;
                                                            GLTextureView.sGLThreadManager.notifyAll();
                                                            z36 = true;
                                                        } catch (RuntimeException e16) {
                                                            GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
                                                            throw e16;
                                                        }
                                                    }
                                                }
                                                if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                                    this.mHaveEglSurface = true;
                                                    z37 = true;
                                                    z38 = true;
                                                    z39 = true;
                                                }
                                                if (this.mHaveEglSurface) {
                                                    if (this.mSizeChanged) {
                                                        int i17 = this.mWidth;
                                                        int i18 = this.mHeight;
                                                        z19 = false;
                                                        this.mSizeChanged = false;
                                                        i3 = i17;
                                                        i16 = i18;
                                                        z37 = true;
                                                        z39 = true;
                                                        z46 = true;
                                                    } else {
                                                        z19 = false;
                                                    }
                                                    this.mRequestRender = z19;
                                                    GLTextureView.sGLThreadManager.notifyAll();
                                                    z18 = z26;
                                                }
                                            }
                                            z17 = true;
                                            try {
                                                LockMethodProxy.wait(GLTextureView.sGLThreadManager);
                                                z28 = false;
                                                z55 = z26;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                z28 = z17;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        z17 = true;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                }
                            }
                            synchronized (GLTextureView.sGLThreadManager) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                            }
                            return;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        z16 = true;
                    }
                    if (runnable != null) {
                        break;
                    }
                    if (z37) {
                        if (!this.mEglHelper.createSurface()) {
                            synchronized (GLTextureView.sGLThreadManager) {
                                this.mFinishedCreatingEglSurface = true;
                                this.mSurfaceIsBad = true;
                                GLTextureView.sGLThreadManager.notifyAll();
                            }
                            z28 = z19;
                            z49 = z18;
                        } else {
                            synchronized (GLTextureView.sGLThreadManager) {
                                this.mFinishedCreatingEglSurface = true;
                                GLTextureView.sGLThreadManager.notifyAll();
                            }
                            z37 = z19;
                        }
                        th = th10;
                        z16 = true;
                        if (z16) {
                            synchronized (GLTextureView.sGLThreadManager) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                            }
                        }
                        throw th;
                    }
                    if (z38) {
                        gl10 = (GL10) this.mEglHelper.createGL();
                        GLTextureView.sGLThreadManager.checkGLDriver(gl10);
                        z38 = z19;
                    }
                    if (z36) {
                        GLTextureView gLTextureView2 = this.mGLTextureViewWeakRef.get();
                        if (gLTextureView2 != null && gLTextureView2.mRenderer != null) {
                            gLTextureView2.mRenderer.onSurfaceCreated(gl10, this.mEglHelper.mEglConfig);
                        }
                        z36 = z19;
                    }
                    if (z39) {
                        GLTextureView gLTextureView3 = this.mGLTextureViewWeakRef.get();
                        if (gLTextureView3 != null && gLTextureView3.mRenderer != null) {
                            gLTextureView3.mRenderer.onSurfaceChanged(gl10, i3, i16);
                        }
                        z39 = z19;
                    }
                    GLTextureView gLTextureView4 = this.mGLTextureViewWeakRef.get();
                    if (gLTextureView4 != null && gLTextureView4.mRenderer != null) {
                        gLTextureView4.mRenderer.onDrawFrame(gl10);
                    }
                    int swap = this.mEglHelper.swap();
                    if (swap == 12288) {
                        z16 = true;
                        z18 = z18;
                    } else if (swap != 12302) {
                        EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", swap);
                        synchronized (GLTextureView.sGLThreadManager) {
                            z16 = true;
                            try {
                                this.mSurfaceIsBad = true;
                                GLTextureView.sGLThreadManager.notifyAll();
                            } catch (Throwable th11) {
                                try {
                                    throw th11;
                                } catch (Throwable th12) {
                                    th = th12;
                                }
                            }
                        }
                        z18 = z18;
                    } else {
                        z16 = true;
                        z18 = true;
                    }
                    if (z46) {
                        z47 = z16;
                    }
                    z28 = z19;
                    z49 = z18;
                }
                runnable.run();
                z28 = z19;
                z29 = z18;
            }
        }

        private boolean readyToDraw() {
            if (!this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1)) {
                return true;
            }
            return false;
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.mHaveEglContext && this.mHaveEglSurface && readyToDraw()) {
                return true;
            }
            return false;
        }

        public int getRenderMode() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    i3 = this.mRenderMode;
                }
                return i3;
            }
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }

        public void onPause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRequestPaused = true;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused) {
                        try {
                            LockMethodProxy.wait(GLTextureView.sGLThreadManager);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        public void onResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRequestPaused = false;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                        try {
                            LockMethodProxy.wait(GLTextureView.sGLThreadManager);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public void onWindowResize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mWidth = i3;
                    this.mHeight = i16;
                    this.mSizeChanged = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        try {
                            LockMethodProxy.wait(GLTextureView.sGLThreadManager);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        public void queueEvent(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) runnable);
            } else {
                if (runnable != null) {
                    synchronized (GLTextureView.sGLThreadManager) {
                        this.mEventQueue.add(runnable);
                        GLTextureView.sGLThreadManager.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }

        public void requestExitAndWait() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mShouldExit = true;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mExited) {
                        try {
                            LockMethodProxy.wait(GLTextureView.sGLThreadManager);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 12, (Object) this);
        }

        public void requestReleaseEglContextLocked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this);
            } else {
                this.mShouldReleaseEglContext = true;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public void requestRender() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRequestRender = true;
                    GLTextureView.sGLThreadManager.notifyAll();
                }
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th5) {
                GLTextureView.sGLThreadManager.threadExiting(this);
                throw th5;
            }
            GLTextureView.sGLThreadManager.threadExiting(this);
        }

        public void setRenderMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            if (i3 >= 0 && i3 <= 1) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mRenderMode = i3;
                    GLTextureView.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void surfaceCreated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mHasSurface = true;
                    this.mFinishedCreatingEglSurface = false;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                        try {
                            LockMethodProxy.wait(GLTextureView.sGLThreadManager);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this);
        }

        public void surfaceDestroyed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mHasSurface = false;
                    GLTextureView.sGLThreadManager.notifyAll();
                    while (!this.mWaitingForSurface && !this.mExited) {
                        if (!this.mLogPrinted) {
                            this.mLogPrinted = true;
                            Logger.d(GLTextureView.TAG, "mWaitingForSurface " + this.mWaitingForSurface + " mExited " + this.mExited);
                        }
                        try {
                            LockMethodProxy.wait(GLTextureView.sGLThreadManager);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class GLThreadManager {
        static IPatchRedirector $redirector_ = null;
        private static String TAG = null;
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9984);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
            } else {
                TAG = "GLThreadManager";
            }
        }

        /* synthetic */ GLThreadManager(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) anonymousClass1);
        }

        private void checkGLESVersion() {
            if (!this.mGLESVersionCheckComplete) {
                int i3 = GLTextureView.sGLESVersion;
                this.mGLESVersion = i3;
                if (i3 >= 131072) {
                    this.mMultipleGLESContextsAllowed = true;
                }
                this.mGLESVersionCheckComplete = true;
            }
        }

        public synchronized void checkGLDriver(GL10 gl10) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) gl10);
                return;
            }
            if (!this.mGLESDriverCheckComplete) {
                checkGLESVersion();
                String glGetString = gl10.glGetString(7937);
                boolean z17 = false;
                if (this.mGLESVersion < 131072) {
                    if (!glGetString.startsWith(kMSM7K_RENDERER_PREFIX)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.mMultipleGLESContextsAllowed = z16;
                    notifyAll();
                }
                if (!this.mMultipleGLESContextsAllowed) {
                    z17 = true;
                }
                this.mLimitedGLESContexts = z17;
                this.mGLESDriverCheckComplete = true;
            }
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) gLThread);
                return;
            }
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.mLimitedGLESContexts;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public synchronized void threadExiting(GLThread gLThread) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                gLThread.mExited = true;
                if (this.mEglOwner == gLThread) {
                    this.mEglOwner = null;
                }
                notifyAll();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gLThread);
        }

        public boolean tryAcquireEglContextLocked(GLThread gLThread) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) gLThread)).booleanValue();
            }
            GLThread gLThread2 = this.mEglOwner;
            if (gLThread2 != gLThread && gLThread2 != null) {
                checkGLESVersion();
                if (this.mMultipleGLESContextsAllowed) {
                    return true;
                }
                GLThread gLThread3 = this.mEglOwner;
                if (gLThread3 != null) {
                    gLThread3.requestReleaseEglContextLocked();
                    return false;
                }
                return false;
            }
            this.mEglOwner = gLThread;
            notifyAll();
            return true;
        }

        GLThreadManager() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface GLWrapper {
        GL wrap(GL gl5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class LogWriter extends Writer {
        static IPatchRedirector $redirector_;
        private StringBuilder mBuilder;

        LogWriter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mBuilder = new StringBuilder();
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GLTextureView.TAG, this.mBuilder.toString());
                StringBuilder sb5 = this.mBuilder;
                sb5.delete(0, sb5.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                flushBuilder();
            }
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                flushBuilder();
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            for (int i17 = 0; i17 < i16; i17++) {
                char c16 = cArr[i3 + i17];
                if (c16 == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class SimpleEGLConfigChooser extends ComponentSizeChooser {
        static IPatchRedirector $redirector_;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SimpleEGLConfigChooser(boolean z16) {
            super(8, 8, 8, 0, r6, 0);
            int i3;
            if (z16) {
                i3 = 16;
            } else {
                i3 = 0;
            }
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GLTextureView.this, Boolean.valueOf(z16));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            sGLThreadManager = new GLThreadManager(null);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mCheckAlphaTask = new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.GLTextureView.1
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
                GLTextureView.this.mGLThread.onWindowResize(GLTextureView.this.getWidth(), GLTextureView.this.getHeight());
                Logger.d(GLTextureView.TAG, "TextureView mCheckAlphaTask,alpha:" + GLTextureView.this.getViewAlpha());
                if (GLTextureView.this.getViewAlpha() != 1.0f) {
                    GLTextureView.this.setViewAlpha(1.0f);
                }
            }
        };
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    @SuppressLint({"UseValueOf"})
    public static Integer getInt(Context context, String str, int i3) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(i3));
        } catch (IllegalArgumentException e16) {
            throw e16;
        } catch (Exception unused) {
            return Integer.valueOf(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    public float getViewAlpha() {
        return getAlpha();
    }

    private void init() {
        sGLESVersion = getInt(getContext(), "ro.opengles.version", 0).intValue();
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.jalpha.videoplayer.view.GLTextureView.2
            static IPatchRedirector $redirector_;

            {
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    public void setViewAlpha(float f16) {
        setAlpha(f16);
        Logger.d(TAG, "TextureView setAlpha,alpha:" + f16);
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

    public int getDebugFlags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mGLThread.getRenderMode();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                i3 = gLThread.getRenderMode();
            } else {
                i3 = 1;
            }
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (i3 != 1) {
                gLThread2.setRenderMode(i3);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.mGLThread.onPause();
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.mGLThread.onResume();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mSurfaceTextureAvailable = true;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        Log.d(TAG, "onSurfaceTextureAvailable");
        long currentTimeMillis = System.currentTimeMillis();
        surfaceCreated(surfaceTexture);
        postDelayed(this.mCheckAlphaTask, 250L);
        Logger.d(TAG, " TextureView onSurfaceTextureAvailable surfaceCreated use:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        this.mSurfaceTextureAvailable = false;
        Log.d(TAG, "onSurfaceTextureDestroyed");
        surfaceDestroyed(surfaceTexture);
        Logger.d(TAG, " TextureView onSurfaceTextureDestroyed");
        setViewAlpha(0.0f);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Log.d(TAG, "onSurfaceTextureSizeChanged");
        surfaceChanged(surfaceTexture, 0, i3, i16);
        Logger.d(TAG, " TextureView onSurfaceTextureSizeChanged surfaceChanged use:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) surfaceTexture);
        }
    }

    public void queueEvent(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) runnable);
        } else {
            this.mGLThread.queueEvent(runnable);
        }
    }

    public void requestRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
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

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) eGLConfigChooser);
        } else {
            checkRenderThreadState();
            this.mEGLConfigChooser = eGLConfigChooser;
        }
    }

    public void setEGLContextClientVersion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            checkRenderThreadState();
            this.mEGLContextClientVersion = i3;
        }
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) eGLContextFactory);
        } else {
            checkRenderThreadState();
            this.mEGLContextFactory = eGLContextFactory;
        }
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) eGLWindowSurfaceFactory);
        } else {
            checkRenderThreadState();
            this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
        }
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gLWrapper);
        } else {
            this.mGLWrapper = gLWrapper;
        }
    }

    public void setPreserveEGLContextOnPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mPreserveEGLContextOnPause = z16;
        }
    }

    public void setRenderMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mGLThread.setRenderMode(i3);
        }
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) renderer);
            return;
        }
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        AnonymousClass1 anonymousClass1 = null;
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory(this, anonymousClass1);
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory(anonymousClass1);
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mSurfaceWidth != i16 || this.mSurfaceHeight != i17) {
            this.mSurfaceWidth = i16;
            this.mSurfaceHeight = i17;
            this.mGLThread.onWindowResize(i16, i17);
            Logger.d(TAG, " surfaceChanged, onWindowResize");
        }
        removeCallbacks(this.mCheckAlphaTask);
        if (this.mSurfaceTextureAvailable && getViewAlpha() != 1.0f) {
            setViewAlpha(1.0f);
        }
        Logger.d(TAG, " surfaceChanged, w:" + i16 + ",h:" + i17 + " use:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) surfaceTexture);
        } else {
            this.mGLThread.surfaceCreated();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) surfaceTexture);
        } else {
            this.mGLThread.surfaceDestroyed();
        }
    }

    public void setEGLConfigChooser(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            setEGLConfigChooser(new SimpleEGLConfigChooser(z16));
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
    }

    public void setEGLConfigChooser(int i3, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            setEGLConfigChooser(new ComponentSizeChooser(i3, i16, i17, i18, i19, i26));
        } else {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mCheckAlphaTask = new Runnable() { // from class: com.tencent.jalpha.videoplayer.view.GLTextureView.1
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
                GLTextureView.this.mGLThread.onWindowResize(GLTextureView.this.getWidth(), GLTextureView.this.getHeight());
                Logger.d(GLTextureView.TAG, "TextureView mCheckAlphaTask,alpha:" + GLTextureView.this.getViewAlpha());
                if (GLTextureView.this.getViewAlpha() != 1.0f) {
                    GLTextureView.this.setViewAlpha(1.0f);
                }
            }
        };
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }
}
