package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.tencent.ark.EGLContextHolder;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes2.dex */
public final class DummySurface extends Surface {
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final int SECURE_MODE_NONE = 0;
    private static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
    private static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DummySurfaceThread extends BaseHandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 3;
        private static final int MSG_UPDATE_TEXTURE = 2;
        private EGLContext context;
        private EGLDisplay display;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private EGLSurface pbuffer;
        private DummySurface surface;
        private SurfaceTexture surfaceTexture;
        private final int[] textureIdHolder;

        public DummySurfaceThread() {
            super("dummySurface");
            this.textureIdHolder = new int[1];
        }

        private void initInternal(int i3) {
            boolean z16;
            boolean z17;
            int[] iArr;
            boolean z18;
            int[] iArr2;
            boolean z19;
            EGLSurface eGLSurface;
            boolean z26 = false;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.display = eglGetDisplay;
            if (eglGetDisplay != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkState(z16, "eglGetDisplay failed");
            int[] iArr3 = new int[2];
            Assertions.checkState(EGL14.eglInitialize(this.display, iArr3, 0, iArr3, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr4 = new int[1];
            if (EGL14.eglChooseConfig(this.display, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            Assertions.checkState(z17, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (i3 == 0) {
                iArr = new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            } else {
                iArr = new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
            }
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.display, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
            this.context = eglCreateContext;
            if (eglCreateContext != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            Assertions.checkState(z18, "eglCreateContext failed");
            if (i3 == 1) {
                eGLSurface = EGL14.EGL_NO_SURFACE;
            } else {
                if (i3 == 2) {
                    iArr2 = new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 1, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 1, DummySurface.EGL_PROTECTED_CONTENT_EXT, 1, 12344};
                } else {
                    iArr2 = new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 1, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 1, 12344};
                }
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.display, eGLConfig, iArr2, 0);
                this.pbuffer = eglCreatePbufferSurface;
                if (eglCreatePbufferSurface != null) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                Assertions.checkState(z19, "eglCreatePbufferSurface failed");
                eGLSurface = this.pbuffer;
            }
            Assertions.checkState(EGL14.eglMakeCurrent(this.display, eGLSurface, eGLSurface, this.context), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.textureIdHolder, 0);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureIdHolder[0]);
            this.surfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            SurfaceTexture surfaceTexture2 = this.surfaceTexture;
            if (i3 != 0) {
                z26 = true;
            }
            this.surface = new DummySurface(this, surfaceTexture2, z26);
        }

        private void releaseInternal() {
            try {
                SurfaceTexture surfaceTexture = this.surfaceTexture;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures(1, this.textureIdHolder, 0);
                }
            } finally {
                EGLSurface eGLSurface = this.pbuffer;
                if (eGLSurface != null) {
                    EGL14.eglDestroySurface(this.display, eGLSurface);
                }
                EGLContext eGLContext = this.context;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.display, eGLContext);
                }
                this.pbuffer = null;
                this.context = null;
                this.display = null;
                this.surface = null;
                this.surfaceTexture = null;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            try {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return true;
                        }
                        try {
                            releaseInternal();
                        } finally {
                            try {
                                return true;
                            } finally {
                            }
                        }
                        return true;
                    }
                    this.surfaceTexture.updateTexImage();
                    return true;
                }
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e16) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e16);
                    this.initError = e16;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e17) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e17);
                    this.initException = e17;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th5) {
                synchronized (this) {
                    notify();
                    throw th5;
                }
            }
        }

        public DummySurface init(int i3) {
            boolean z16;
            start();
            this.handler = new Handler(getLooper(), this);
            synchronized (this) {
                z16 = false;
                this.handler.obtainMessage(1, i3, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        LockMethodProxy.wait(this);
                    } catch (InterruptedException unused) {
                        z16 = true;
                    }
                }
            }
            if (z16) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException == null) {
                Error error = this.initError;
                if (error == null) {
                    return this.surface;
                }
                throw error;
            }
            throw runtimeException;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.handler.sendEmptyMessage(2);
        }

        public void release() {
            this.handler.sendEmptyMessage(3);
        }
    }

    private static void assertApiLevel17OrHigher() {
        if (Util.SDK_INT >= 17) {
        } else {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    private static int getSecureModeV24(Context context) {
        String eglQueryString;
        int i3 = Util.SDK_INT;
        if (i3 < 26 && (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return 0;
        }
        if ((i3 < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return 0;
        }
        if (eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT)) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z16;
        int secureModeV24;
        synchronized (DummySurface.class) {
            z16 = true;
            if (!secureModeInitialized) {
                if (Util.SDK_INT < 24) {
                    secureModeV24 = 0;
                } else {
                    secureModeV24 = getSecureModeV24(context);
                }
                secureMode = secureModeV24;
                secureModeInitialized = true;
            }
            if (secureMode == 0) {
                z16 = false;
            }
        }
        return z16;
    }

    public static DummySurface newInstanceV17(Context context, boolean z16) {
        boolean z17;
        assertApiLevel17OrHigher();
        int i3 = 0;
        if (z16 && !isSecureSupported(context)) {
            z17 = false;
        } else {
            z17 = true;
        }
        Assertions.checkState(z17);
        DummySurfaceThread dummySurfaceThread = new DummySurfaceThread();
        if (z16) {
            i3 = secureMode;
        }
        return dummySurfaceThread.init(i3);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z16) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z16;
    }
}
