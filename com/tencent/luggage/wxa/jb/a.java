package com.tencent.luggage.wxa.jb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import androidx.core.internal.view.SupportMenu;
import com.tencent.filter.GLSLRender;
import com.tencent.luggage.wxa.eb.d;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.tencwebrtc.EglBase;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6333a f130928a;

    /* renamed from: b, reason: collision with root package name */
    public static int f130929b;

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f130930c;

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f130931d;

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f130932e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f130933f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f130934g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f130935h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f130936i;

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f130937j;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.jb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6333a {
        public C6333a() {
        }

        public /* synthetic */ C6333a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(int i3) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        }

        public final int c() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9729);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            a("genTexture");
            return iArr[0];
        }

        public final int d() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, 10241, 9729);
            GLES20.glTexParameteri(36197, 10240, 9729);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glBindTexture(36197, 0);
            a("glGenTextures");
            return iArr[0];
        }

        public final void a(Context context) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                ConfigurationInfo deviceConfigurationInfo = activityManager != null ? activityManager.getDeviceConfigurationInfo() : null;
                if (deviceConfigurationInfo != null) {
                    int i3 = (deviceConfigurationInfo.reqGlEsVersion & SupportMenu.CATEGORY_MASK) >> 16;
                    f0 e16 = f0.e("mmkv_gl_key");
                    int a16 = e16.a("support_egl_context_client_version", 3);
                    w.d("MicroMsg.GLEnvironmentUtil", "egl support version " + deviceConfigurationInfo.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + deviceConfigurationInfo.reqGlEsVersion + "   major:" + i3 + "  curVersion:" + a16);
                    int i16 = 2;
                    if (a16 >= 3 && i3 == 2) {
                        w.d("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
                        com.tencent.luggage.wxa.xm.b.INSTANCE.a(985L, 11L, 1L);
                    }
                    if (!e16.a("has_reported_egl_version", false)) {
                        w.d("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
                        com.tencent.luggage.wxa.xm.b.INSTANCE.a(985L, 12L, 1L);
                        e16.b("has_reported_egl_version", true);
                    }
                    if (i3 >= 3) {
                        i3 = 3;
                    }
                    if (i3 > 2) {
                        i16 = i3;
                    }
                    e16.b("support_egl_context_client_version", i16);
                }
                if (deviceConfigurationInfo == null) {
                    w.b("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
                }
                if (com.tencent.luggage.wxa.im.a.b().a("clicfg_gles_version_enable", true)) {
                    return;
                }
                f0.e("mmkv_gl_key").b("support_egl_context_client_version", 3);
            } catch (Exception e17) {
                w.a("MicroMsg.GLEnvironmentUtil", e17, "", new Object[0]);
            }
        }

        public final int b(String vertexShaderSource, String fragmentShaderSource) {
            Intrinsics.checkNotNullParameter(vertexShaderSource, "vertexShaderSource");
            Intrinsics.checkNotNullParameter(fragmentShaderSource, "fragmentShaderSource");
            int[] iArr = new int[1];
            int a16 = a(vertexShaderSource, 35633);
            if (a16 == 0) {
                w.b("MicroMsg.GLEnvironmentUtil", "load vertex shader failed");
                return 0;
            }
            int a17 = a(fragmentShaderSource, 35632);
            if (a17 == 0) {
                w.b("MicroMsg.GLEnvironmentUtil", "load fragment shader failed");
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(glCreateProgram, a16);
            GLES20.glAttachShader(glCreateProgram, a17);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] <= 0) {
                w.b("MicroMsg.GLEnvironmentUtil", "link program failed");
                return 0;
            }
            GLES20.glDeleteShader(a16);
            GLES20.glDeleteShader(a17);
            return glCreateProgram;
        }

        public final int b() {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            int i3 = iArr[0];
            if (i3 != 0) {
                return i3;
            }
            w.b("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
            return 0;
        }

        public final void a(int i3) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
        }

        public final int a(String shaderSource, int i3) {
            Intrinsics.checkNotNullParameter(shaderSource, "shaderSource");
            int[] iArr = new int[1];
            int glCreateShader = GLES20.glCreateShader(i3);
            GLES20.glShaderSource(glCreateShader, shaderSource);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            w.b("MicroMsg.GLEnvironmentUtil", "loadShader error, infoLog: " + GLES20.glGetShaderInfoLog(glCreateShader));
            return 0;
        }

        public final void a() {
            GLES20.glClear(16640);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glBindFramebuffer(36160, 0);
        }

        public final void a(com.tencent.luggage.wxa.eb.a aVar, d dVar, int i3, int i16) {
            if (aVar == null) {
                w.b("MicroMsg.GLEnvironmentUtil", "fbo is null !");
                return;
            }
            if (dVar == null) {
                w.b("MicroMsg.GLEnvironmentUtil", "texture is null");
                return;
            }
            GLES20.glBindFramebuffer(36160, aVar.d());
            if (i3 > 0 && i16 > 0) {
                d.a(dVar, i3, i16, 0, null, 0, 0, 60, null);
            }
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, dVar.e(), 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        }

        public static /* synthetic */ b a(C6333a c6333a, Surface surface, SurfaceTexture surfaceTexture, int i3, int i16, EGLContext eGLContext, int i17, Object obj) {
            if ((i17 & 2) != 0) {
                surfaceTexture = null;
            }
            SurfaceTexture surfaceTexture2 = surfaceTexture;
            int i18 = (i17 & 4) != 0 ? 0 : i3;
            int i19 = (i17 & 8) != 0 ? 0 : i16;
            if ((i17 & 16) != 0) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            return c6333a.a(surface, surfaceTexture2, i18, i19, eGLContext);
        }

        public final b a(Surface surface, SurfaceTexture surfaceTexture, int i3, int i16, EGLContext eGLContext) {
            EGLConfig[] eGLConfigArr;
            int i17;
            EGLDisplay eGLDisplay;
            int i18;
            int[] iArr;
            EGLSurface eglCreatePbufferSurface;
            String str;
            w.d("MicroMsg.GLEnvironmentUtil", "eglSetupBySurface, surface:" + surface + ", surfaceTexture:" + surfaceTexture + ", width:" + i3 + ", height:" + i16);
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr2 = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr2, 0, iArr2, 1)) {
                    EGLConfig[] eGLConfigArr2 = new EGLConfig[1];
                    int[] iArr3 = new int[1];
                    if (surface != null || surfaceTexture != null) {
                        eGLConfigArr = eGLConfigArr2;
                        i17 = 2;
                        eGLDisplay = eglGetDisplay;
                        EGL14.eglChooseConfig(eGLDisplay, a.f130933f, 0, eGLConfigArr, 0, 1, iArr3, 0);
                    } else {
                        eGLConfigArr = eGLConfigArr2;
                        i17 = 2;
                        eGLDisplay = eglGetDisplay;
                        EGL14.eglChooseConfig(eglGetDisplay, a.f130933f, 0, eGLConfigArr2, 0, 1, iArr3, 0);
                    }
                    a(this, "eglCreateContext RGB888+recordable ES2", (String) null, i17, (Object) null);
                    int a16 = f0.e("mmkv_gl_key").a("support_egl_context_client_version", 3);
                    int[] iArr4 = new int[3];
                    iArr4[0] = 12440;
                    iArr4[1] = a16;
                    iArr4[i17] = 12344;
                    EGLDisplay mEGLDisplay = eGLDisplay;
                    EGLContext mEGLContext = EGL14.eglCreateContext(mEGLDisplay, eGLConfigArr[0], eGLContext, iArr4, 0);
                    a(this, "eglCreateContext", (String) null, i17, (Object) null);
                    w.d("MicroMsg.GLEnvironmentUtil", "create eglContext: " + mEGLContext.getNativeHandle() + ", stack:" + w0.b());
                    if (Intrinsics.areEqual(mEGLContext, EGL14.EGL_NO_CONTEXT)) {
                        w.b("MicroMsg.GLEnvironmentUtil", "create " + a16 + " EGL context failed");
                        if (a16 == 3) {
                            w.d("MicroMsg.GLEnvironmentUtil", "retry create EGL 2.0 context");
                            iArr4[1] = i17;
                            mEGLContext = EGL14.eglCreateContext(mEGLDisplay, eGLConfigArr[0], eGLContext, iArr4, 0);
                            a(this, "eglCreateContext fallback", (String) null, i17, (Object) null);
                            w.d("MicroMsg.GLEnvironmentUtil", "create eglContext: " + mEGLContext.getNativeHandle() + ", stack:" + w0.b());
                        }
                    }
                    if (!Intrinsics.areEqual(mEGLContext, EGL14.EGL_NO_CONTEXT)) {
                        com.tencent.luggage.wxa.xm.b.INSTANCE.a(985L, 189L, 1L);
                    }
                    if (i3 <= 0 || i16 <= 0) {
                        i18 = 0;
                        iArr = new int[]{12344};
                    } else {
                        iArr = new int[5];
                        i18 = 0;
                        iArr[0] = 12375;
                        iArr[1] = i3;
                        iArr[i17] = 12374;
                        iArr[3] = i16;
                        iArr[4] = 12344;
                    }
                    if (surface != null) {
                        eglCreatePbufferSurface = EGL14.eglCreateWindowSurface(mEGLDisplay, eGLConfigArr[i18], surface, iArr, i18);
                    } else if (surfaceTexture != null) {
                        eglCreatePbufferSurface = EGL14.eglCreateWindowSurface(mEGLDisplay, eGLConfigArr[i18], surfaceTexture, iArr, i18);
                    } else {
                        eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(mEGLDisplay, eGLConfigArr[i18], iArr, i18);
                    }
                    if (surface != null) {
                        str = null;
                        a(this, "eglCreateWindowSurface", (String) null, i17, (Object) null);
                    } else {
                        str = null;
                        a(this, "eglCreatePbufferSurface", (String) null, i17, (Object) null);
                    }
                    if (eglCreatePbufferSurface != null) {
                        EGL14.eglMakeCurrent(mEGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, mEGLContext);
                        a(this, "eglMakeCurrent", str, i17, str);
                    }
                    Intrinsics.checkNotNullExpressionValue(mEGLDisplay, "mEGLDisplay");
                    Intrinsics.checkNotNullExpressionValue(mEGLContext, "mEGLContext");
                    return new b(mEGLDisplay, eglCreatePbufferSurface, mEGLContext);
                }
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }

        public static /* synthetic */ boolean a(C6333a c6333a, String str, String str2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str2 = "MicroMsg.GLEnvironmentUtil";
            }
            return c6333a.a(str, str2);
        }

        public final boolean a(String msg2, String tag) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(tag, "tag");
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                return false;
            }
            w.f(tag, msg2 + ": EGL error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
            return true;
        }

        public final void a(String str) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                w.f("MicroMsg.GLEnvironmentUtil", str + ": GL error: 0x" + Integer.toHexString(glGetError), new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public EGLDisplay f130938a;

        /* renamed from: b, reason: collision with root package name */
        public EGLSurface f130939b;

        /* renamed from: c, reason: collision with root package name */
        public EGLContext f130940c;

        public b(EGLDisplay disPlay, EGLSurface eGLSurface, EGLContext eglContext) {
            Intrinsics.checkNotNullParameter(disPlay, "disPlay");
            Intrinsics.checkNotNullParameter(eglContext, "eglContext");
            this.f130938a = disPlay;
            this.f130939b = eGLSurface;
            this.f130940c = eglContext;
        }

        public final EGLDisplay a() {
            return this.f130938a;
        }

        public final EGLContext b() {
            return this.f130940c;
        }

        public final EGLSurface c() {
            return this.f130939b;
        }

        public final void a(EGLContext eGLContext) {
            Intrinsics.checkNotNullParameter(eGLContext, "<set-?>");
            this.f130940c = eGLContext;
        }

        public final void a(EGLSurface eGLSurface) {
            this.f130939b = eGLSurface;
        }
    }

    static {
        C6333a c6333a = new C6333a(null);
        f130928a = c6333a;
        f130929b = -1;
        f130930c = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f130931d = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f130932e = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f130933f = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};
        f130934g = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12338, 1, 12337, 4, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};
        f130935h = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
        f130936i = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        f130937j = new int[]{12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344};
        Context c16 = z.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
        c6333a.a(c16);
    }
}
