package com.tencent.luggage.wxa.gb;

import android.opengl.GLSurfaceView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.maxvideo.MaxVideoConst;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements GLSurfaceView.EGLConfigChooser {

    /* renamed from: k, reason: collision with root package name */
    public static final C6239a f126664k = new C6239a(null);

    /* renamed from: l, reason: collision with root package name */
    public static final String f126665l = "GLConfigChooser";

    /* renamed from: a, reason: collision with root package name */
    public int f126666a;

    /* renamed from: b, reason: collision with root package name */
    public int f126667b;

    /* renamed from: c, reason: collision with root package name */
    public int f126668c;

    /* renamed from: d, reason: collision with root package name */
    public int f126669d;

    /* renamed from: e, reason: collision with root package name */
    public int f126670e;

    /* renamed from: f, reason: collision with root package name */
    public int f126671f;

    /* renamed from: g, reason: collision with root package name */
    public final String f126672g = "MicroMsg.RenderConfigChooser";

    /* renamed from: h, reason: collision with root package name */
    public final int f126673h = 4;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f126674i = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};

    /* renamed from: j, reason: collision with root package name */
    public final int[] f126675j = new int[1];

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.gb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6239a {
        public C6239a() {
        }

        public /* synthetic */ C6239a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.f126666a = i3;
        this.f126667b = i16;
        this.f126668c = i17;
        this.f126669d = i18;
        this.f126670e = i19;
        this.f126671f = i26;
    }

    public final EGLConfig a(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
        Intrinsics.checkNotNullParameter(egl, "egl");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(configs, "configs");
        for (EGLConfig eGLConfig : configs) {
            Intrinsics.checkNotNull(eGLConfig);
            int a16 = a(egl, display, eGLConfig, 12325, 0);
            int a17 = a(egl, display, eGLConfig, 12326, 0);
            if (a16 >= this.f126670e && a17 >= this.f126671f) {
                int a18 = a(egl, display, eGLConfig, 12324, 0);
                int a19 = a(egl, display, eGLConfig, 12323, 0);
                int a26 = a(egl, display, eGLConfig, 12322, 0);
                int a27 = a(egl, display, eGLConfig, 12321, 0);
                if (a18 == this.f126666a && a19 == this.f126667b && a26 == this.f126668c && a27 == this.f126669d) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    public final void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        int length = eGLConfigArr.length;
        String str = this.f126672g;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d configurations", Arrays.copyOf(new Object[]{Integer.valueOf(length)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        w.d(str, format);
        for (int i3 = 0; i3 < length; i3++) {
            String str2 = this.f126672g;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("Configuration %d:\n", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            w.d(str2, format2);
            EGLConfig eGLConfig = eGLConfigArr[i3];
            Intrinsics.checkNotNull(eGLConfig);
            a(egl10, eGLDisplay, eGLConfig);
        }
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
        Intrinsics.checkNotNullParameter(egl, "egl");
        Intrinsics.checkNotNullParameter(display, "display");
        int[] iArr = new int[1];
        egl.eglChooseConfig(display, this.f126674i, null, 0, iArr);
        int i3 = iArr[0];
        if (i3 > 0) {
            EGLConfig[] eGLConfigArr = new EGLConfig[i3];
            egl.eglChooseConfig(display, this.f126674i, eGLConfigArr, i3, iArr);
            b(egl, display, eGLConfigArr);
            return a(egl, display, eGLConfigArr);
        }
        throw new IllegalArgumentException("No configs match configSpec");
    }

    public final int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, int i16) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, this.f126675j) ? this.f126675j[0] : i16;
    }

    public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, MaxVideoConst.RESULT_LOCAL, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
        String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
        int[] iArr2 = new int[1];
        for (int i3 = 0; i3 < 33; i3++) {
            int i16 = iArr[i3];
            String str = strArr[i3];
            egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i16, iArr2);
        }
    }
}
