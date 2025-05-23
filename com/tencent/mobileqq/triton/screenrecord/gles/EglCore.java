package com.tencent.mobileqq.triton.screenrecord.gles;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u001d\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00030\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/gles/EglCore;", "", "sharedContext", "Landroid/opengl/EGLContext;", WadlProxyConsts.FLAGS, "", "(Landroid/opengl/EGLContext;I)V", "mEGLConfig", "Landroid/opengl/EGLConfig;", "mEGLContext", "kotlin.jvm.PlatformType", "mEGLDisplay", "Landroid/opengl/EGLDisplay;", "mGlVersion", "checkEglError", "", "msg", "", "createWindowSurface", "Landroid/opengl/EGLSurface;", "surface", "getConfig", "version", "makeCurrent", "eglSurface", "makeNothingCurrent", "", "querySurface", "what", "release", "releaseSurface", "setPresentationTime", "nsecs", "", "swapBuffers", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = "EglCore";
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;

    @JvmOverloads
    public EglCore() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    private final void checkEglError(String msg2) {
        Ref.IntRef intRef = new Ref.IntRef();
        int eglGetError = EGL14.eglGetError();
        intRef.element = eglGetError;
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(msg2 + ": EGL error: 0x" + Integer.toHexString(intRef.element));
    }

    private final EGLConfig getConfig(int flags, int version) {
        int i3;
        if (version >= 3) {
            i3 = 68;
        } else {
            i3 = 4;
        }
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i3, 12344, 0, 12344};
        if ((flags & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.mEGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            Logger.w$default(TAG, "unable to find RGB8888 / " + version + " EGLConfig", null, 4, null);
            return null;
        }
        return eGLConfigArr[0];
    }

    @NotNull
    public final EGLSurface createWindowSurface(@NotNull Object surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        if (!(surface instanceof Surface) && !(surface instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + surface);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public final void makeCurrent(@Nullable EGLSurface eglSurface) {
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            Logger.d$default(TAG, "NOTE: makeCurrent w/o display", null, 4, null);
        }
        if (EGL14.eglMakeCurrent(this.mEGLDisplay, eglSurface, eglSurface, this.mEGLContext)) {
        } else {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final boolean makeNothingCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        return EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
    }

    public final int querySurface(@Nullable EGLSurface eglSurface, int what) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, eglSurface, what, iArr, 0);
        return iArr[0];
    }

    public final void release() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public final void releaseSurface(@Nullable EGLSurface eglSurface) {
        EGL14.eglDestroySurface(this.mEGLDisplay, eglSurface);
    }

    public final void setPresentationTime(@Nullable EGLSurface eglSurface, long nsecs) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eglSurface, nsecs);
    }

    public final boolean swapBuffers(@Nullable EGLSurface eglSurface) {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, eglSurface);
    }

    @JvmOverloads
    public EglCore(@Nullable EGLContext eGLContext) {
        this(eGLContext, 0, 2, null);
    }

    @JvmOverloads
    public EglCore(@Nullable EGLContext eGLContext, int i3) {
        EGLConfig config;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLDisplay = eGLDisplay;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mGlVersion = -1;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEGLDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i3 & 2) != 0 && (config = getConfig(i3, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.mEGLConfig = config;
                            this.mEGLContext = eglCreateContext;
                            this.mGlVersion = 3;
                        }
                    }
                    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig config2 = getConfig(i3, 2);
                        if (config2 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.mEGLDisplay, config2, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            checkEglError("eglCreateContext");
                            this.mEGLConfig = config2;
                            this.mEGLContext = eglCreateContext2;
                            this.mGlVersion = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    Logger.d$default(TAG, "EGLContext created, client version " + iArr2[0], null, 4, null);
                    checkEglError("eglQueryContext");
                    return;
                }
                this.mEGLDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    public /* synthetic */ EglCore(EGLContext eGLContext, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : eGLContext, (i16 & 2) != 0 ? 0 : i3);
    }
}
