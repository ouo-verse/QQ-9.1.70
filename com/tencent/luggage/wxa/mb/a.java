package com.tencent.luggage.wxa.mb;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.WindowManager;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.luggage.wxa.lb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.plugin.mmsight.model.MMSightCameraFrameDataCallback;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public d f134221a;

    /* renamed from: b, reason: collision with root package name */
    public final String f134222b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.fb.a f134223c;

    /* renamed from: d, reason: collision with root package name */
    public EGLContext f134224d;

    /* renamed from: e, reason: collision with root package name */
    public EGLSurface f134225e;

    /* renamed from: f, reason: collision with root package name */
    public Function1 f134226f;

    /* renamed from: g, reason: collision with root package name */
    public Function1 f134227g;

    /* renamed from: h, reason: collision with root package name */
    public IntBuffer f134228h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f134229i;

    /* renamed from: j, reason: collision with root package name */
    public Function1 f134230j;

    /* renamed from: k, reason: collision with root package name */
    public int f134231k;

    /* renamed from: l, reason: collision with root package name */
    public int f134232l;

    /* renamed from: m, reason: collision with root package name */
    public final int f134233m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f134234n;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6467a extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f134236b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f134237c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f134238d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6467a(Function0 function0, boolean z16, int i3) {
            super(0);
            this.f134236b = function0;
            this.f134237c = z16;
            this.f134238d = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
        
            if (r0.a() == true) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            boolean z16;
            com.tencent.luggage.wxa.fb.a c16 = a.this.c();
            if (c16 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                Function0 function0 = this.f134236b;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            w.f(a.this.e(), "initRender, generateExternalTexture: " + this.f134237c, new Object[0]);
            com.tencent.luggage.wxa.fb.a c17 = a.this.c();
            if (c17 != null) {
                c17.a(this.f134237c);
            }
            com.tencent.luggage.wxa.fb.a c18 = a.this.c();
            if (c18 != null) {
                c18.c(this.f134238d);
            }
            a.this.f134224d = EGL14.eglGetCurrentContext();
            Function0 function02 = this.f134236b;
            if (function02 != null) {
                function02.invoke();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f134240b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f134241c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z16, boolean z17) {
            super(0);
            this.f134240b = z16;
            this.f134241c = z17;
        }

        public final void a() {
            w.f(a.this.e(), "release", new Object[0]);
            com.tencent.luggage.wxa.fb.a c16 = a.this.c();
            if (c16 != null) {
                com.tencent.luggage.wxa.fb.a.a(c16, false, 1, null);
            }
            a.this.f134224d = null;
            if (this.f134240b && this.f134241c) {
                Object obj = a.this.f134234n;
                a aVar = a.this;
                synchronized (obj) {
                    try {
                        aVar.f134234n.notifyAll();
                    } catch (Exception e16) {
                        w.a(aVar.e(), e16, "notify release error", new Object[0]);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fb.a f134243b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.fb.a aVar) {
            super(0);
            this.f134243b = aVar;
        }

        public final void a() {
            Function1 function1 = a.this.f134227g;
            if (function1 != null) {
                function1.invoke(this.f134243b.g());
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public a(d view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f134221a = view;
        this.f134222b = "MicroMsg.AbsPreviewController";
        this.f134233m = 360;
        this.f134234n = new Object();
    }

    public MMSightCameraFrameDataCallback b() {
        return null;
    }

    public final com.tencent.luggage.wxa.fb.a c() {
        return this.f134223c;
    }

    public final SurfaceTexture d() {
        com.tencent.luggage.wxa.fb.a aVar = this.f134223c;
        if (aVar != null) {
            return aVar.l();
        }
        return null;
    }

    public final String e() {
        return this.f134222b;
    }

    public final com.tencent.luggage.wxa.eb.d f() {
        com.tencent.luggage.wxa.fb.a aVar = this.f134223c;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public final d g() {
        return this.f134221a;
    }

    public void a(Function1 function1) {
        this.f134227g = function1;
    }

    public void b(com.tencent.luggage.wxa.kb.a cameraConfig) {
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        w.f(this.f134222b, "updateCameraConfig: " + cameraConfig, new Object[0]);
        Point a16 = cameraConfig.a();
        com.tencent.luggage.wxa.fb.a aVar = this.f134223c;
        if (aVar != null) {
            aVar.b(a16.x, a16.y);
        }
        com.tencent.luggage.wxa.fb.a aVar2 = this.f134223c;
        if (aVar2 != null) {
            aVar2.b(a(cameraConfig));
        }
        com.tencent.luggage.wxa.fb.a aVar3 = this.f134223c;
        if (aVar3 != null) {
            aVar3.b(cameraConfig.d());
        }
    }

    public void a(com.tencent.luggage.wxa.fb.a renderer) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.f134223c = renderer;
        if (renderer == null) {
            return;
        }
        renderer.a(new c(renderer));
    }

    public final void a(GL10 gl10) {
        com.tencent.luggage.wxa.fb.a aVar = this.f134223c;
        if (aVar != null) {
            aVar.onDrawFrame(gl10);
        }
        if (this.f134229i) {
            this.f134229i = false;
            IntBuffer allocate = IntBuffer.allocate(this.f134232l * this.f134231k);
            this.f134228h = allocate;
            Intrinsics.checkNotNull(allocate);
            allocate.position(0);
            GLES20.glReadPixels(0, 0, this.f134231k, this.f134232l, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f134228h);
            Bitmap createBitmap = Bitmap.createBitmap(this.f134231k, this.f134232l, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(drawWidth, \u2026 Bitmap.Config.ARGB_8888)");
            IntBuffer intBuffer = this.f134228h;
            Intrinsics.checkNotNull(intBuffer);
            createBitmap.copyPixelsFromBuffer(intBuffer);
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            matrix.preRotate(180.0f);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, this.f134231k, this.f134232l, matrix, false);
            Intrinsics.checkNotNullExpressionValue(createBitmap2, "createBitmap(tmpBmp, 0, \u2026ght, matrixMirror, false)");
            createBitmap.recycle();
            Function1 function1 = this.f134230j;
            if (function1 != null) {
                function1.invoke(createBitmap2);
            }
        }
    }

    public final void a(GL10 gl10, int i3, int i16) {
        this.f134231k = i3;
        this.f134232l = i16;
        com.tencent.luggage.wxa.fb.a aVar = this.f134223c;
        if (aVar != null) {
            aVar.onSurfaceChanged(gl10, i3, i16);
        }
    }

    public final void a(GL10 gl10, EGLConfig eGLConfig) {
        this.f134224d = EGL14.eglGetCurrentContext();
        EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12377);
        this.f134225e = eglGetCurrentSurface;
        Function1 function1 = this.f134226f;
        if (function1 != null) {
            Intrinsics.checkNotNull(eglGetCurrentSurface);
            function1.invoke(eglGetCurrentSurface);
        }
        this.f134226f = null;
        com.tencent.luggage.wxa.fb.a aVar = this.f134223c;
        if (aVar != null) {
            aVar.onSurfaceCreated(gl10, eGLConfig);
        }
    }

    public final void a(boolean z16, int i3, Function0 function0) {
        this.f134221a.a(new C6467a(function0, z16, i3));
    }

    public final EGLContext a() {
        return this.f134224d;
    }

    public static /* synthetic */ void a(a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: release");
        }
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        aVar.a(z16, z17);
    }

    public final void a(boolean z16, boolean z17) {
        w.d(this.f134222b, "release, needPostRenderThread:" + z16 + ", block:" + z17);
        b bVar = new b(z16, z17);
        if (z16) {
            long a16 = w0.a();
            w.d(this.f134222b, "start post release");
            this.f134221a.a(bVar);
            if (z17) {
                synchronized (this.f134234n) {
                    try {
                        this.f134234n.wait(100L);
                    } catch (Exception e16) {
                        w.a(this.f134222b, e16, "wait release error", new Object[0]);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                w.d(this.f134222b, "wait release finished cost:" + w0.e(a16) + "ms");
                return;
            }
            return;
        }
        bVar.invoke();
    }

    public final int a(com.tencent.luggage.wxa.kb.a aVar) {
        int rotation;
        if (aVar.c() != -1) {
            rotation = aVar.c();
        } else {
            Object systemService = z.c().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
        }
        int b16 = aVar.b() - (rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90);
        int i3 = this.f134233m;
        return (b16 + i3) % i3;
    }
}
