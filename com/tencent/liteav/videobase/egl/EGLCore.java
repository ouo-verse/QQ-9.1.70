package com.tencent.liteav.videobase.egl;

import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.l;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class EGLCore {
    private static final long DESTROY_EGL_CORE_DELAY_TIME_MS = 100;
    private static final int MAX_EGL_CORE_COUNT = 50;
    private static final String TAG = "EGLCore";
    private e<?> mEglHelper;
    private boolean mIsOffScreen = false;
    private Object mSharedContext;
    private static final l sSequenceTaskRunner = new l();
    private static final AtomicInteger sEGLCoreCount = new AtomicInteger();

    public static EGLCore create(Object obj) {
        EGLCore eGLCore = new EGLCore();
        try {
            eGLCore.initialize(obj, null, 128, 128);
            eGLCore.makeCurrent();
            return eGLCore;
        } catch (d e16) {
            LiteavLog.e(TAG, "create EGLCore failed.", e16);
            return null;
        }
    }

    public static void destroy(EGLCore eGLCore) {
        if (eGLCore == null) {
            return;
        }
        if (eGLCore.mIsOffScreen) {
            destroyAsync(eGLCore);
        } else {
            destroySync(eGLCore);
        }
    }

    public static void destroyAsync(EGLCore eGLCore) {
        if (eGLCore == null) {
            return;
        }
        eGLCore.unmakeCurrent();
        sSequenceTaskRunner.a(c.a(eGLCore), 100L);
    }

    public static void destroySync(EGLCore eGLCore) {
        if (eGLCore == null) {
            return;
        }
        try {
            eGLCore.unmakeCurrent();
            eGLCore.uninitialize();
            LiteavLog.i(TAG, "EGLCore destroy sync success. ".concat(String.valueOf(eGLCore)));
        } catch (d e16) {
            LiteavLog.e(TAG, "EGLCore destroy sync failed.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$destroyAsync$0(EGLCore eGLCore) {
        try {
            eGLCore.unmakeCurrent();
            eGLCore.uninitialize();
            LiteavLog.i(TAG, "EGLCore destroy async success. ".concat(String.valueOf(eGLCore)));
        } catch (d e16) {
            LiteavLog.e(TAG, "EGLCore destroy async failed.", e16);
        }
    }

    private void uninitialize() throws d {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.c();
            this.mEglHelper = null;
        }
        this.mSharedContext = null;
        sEGLCoreCount.decrementAndGet();
    }

    public Object getEglContext() {
        e<?> eVar = this.mEglHelper;
        if (eVar == null) {
            return null;
        }
        return eVar.f();
    }

    public Object getSharedContext() {
        return this.mSharedContext;
    }

    public Size getSurfaceSize() {
        e<?> eVar = this.mEglHelper;
        if (eVar == null) {
            return new Size(0, 0);
        }
        return eVar.e();
    }

    public void initialize(Object obj, Surface surface, int i3, int i16) throws d {
        boolean z16;
        if (surface == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsOffScreen = z16;
        if (obj == null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                this.mEglHelper = b.a((EGLContext) null, surface, i3, i16);
            } else {
                this.mEglHelper = a.a((javax.microedition.khronos.egl.EGLContext) null, surface, i3, i16);
            }
        } else if (obj instanceof javax.microedition.khronos.egl.EGLContext) {
            this.mEglHelper = a.a((javax.microedition.khronos.egl.EGLContext) obj, surface, i3, i16);
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (obj instanceof EGLContext)) {
            this.mEglHelper = b.a((EGLContext) obj, surface, i3, i16);
        } else {
            throw new d(0, "sharedContext isn't EGLContext");
        }
        this.mSharedContext = obj;
        LiteavLog.i(TAG, "EGLCore created in thread " + Thread.currentThread().getId() + ", sharedContext: " + obj + ", Surface: " + surface + ", width: " + i3 + ", height: " + i16 + ", eglCoreCount: " + sEGLCoreCount.incrementAndGet());
    }

    public void makeCurrent() throws d {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void setPresentationTime(long j3) {
        e<?> eVar = this.mEglHelper;
        if (eVar != null && (eVar instanceof b)) {
            b bVar = (b) eVar;
            EGLExt.eglPresentationTimeANDROID(bVar.f119326a, bVar.f119327b, j3);
        }
    }

    public void swapBuffers() throws d {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void unmakeCurrent() {
        e<?> eVar = this.mEglHelper;
        if (eVar != null) {
            eVar.d();
        }
    }
}
