package com.tencent.luggage.wxa.lb;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.luggage.wxa.jb.a;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.mmsight.model.MMSightCameraFrameDataCallback;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.lb.c {

    /* renamed from: l, reason: collision with root package name */
    public static final a f133239l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public a.b f133240a;

    /* renamed from: b, reason: collision with root package name */
    public Surface f133241b;

    /* renamed from: c, reason: collision with root package name */
    public int f133242c;

    /* renamed from: d, reason: collision with root package name */
    public int f133243d;

    /* renamed from: e, reason: collision with root package name */
    public HandlerThread f133244e;

    /* renamed from: f, reason: collision with root package name */
    public b0 f133245f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.fb.a f133246g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.mb.a f133247h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f133248i;

    /* renamed from: j, reason: collision with root package name */
    public Function1 f133249j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f133250k = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lb.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6430b extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133252b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f133253c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Surface f133254d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6430b(int i3, int i16, Surface surface) {
            super(0);
            this.f133252b = i3;
            this.f133253c = i16;
            this.f133254d = surface;
        }

        public final void a() {
            b.this.f133242c = this.f133252b;
            b.this.f133243d = this.f133253c;
            b.this.f133241b = this.f133254d;
            b bVar = b.this;
            bVar.f133240a = a.C6333a.a(com.tencent.luggage.wxa.jb.a.f130928a, bVar.f133241b, null, 0, 0, null, 30, null);
            com.tencent.luggage.wxa.fb.a d16 = b.this.d();
            SurfaceTexture surfaceTexture = null;
            if (d16 != null) {
                d16.onSurfaceCreated(null, null);
            }
            com.tencent.luggage.wxa.fb.a d17 = b.this.d();
            if (d17 != null) {
                d17.a(this.f133252b, this.f133253c);
            }
            com.tencent.luggage.wxa.fb.a d18 = b.this.d();
            if (d18 != null) {
                d18.a(true);
            }
            b.this.f133248i = true;
            w.d("MicroMsg.CameraPreviewGLTextureRender", "previewCallback?.invoke");
            Function1 function1 = b.this.f133249j;
            if (function1 != null) {
                com.tencent.luggage.wxa.mb.a aVar = b.this.f133247h;
                if (aVar != null) {
                    surfaceTexture = aVar.d();
                }
                function1.invoke(surfaceTexture);
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
        public c() {
            super(0);
        }

        public final void a() {
            com.tencent.luggage.wxa.fb.a d16 = b.this.d();
            if (d16 != null) {
                com.tencent.luggage.wxa.fb.a.a(d16, false, 1, null);
            }
            b.this.a((com.tencent.luggage.wxa.fb.a) null);
            a.b bVar = b.this.f133240a;
            if (bVar != null) {
                b bVar2 = b.this;
                EGL14.eglDestroyContext(bVar.a(), bVar.b());
                EGL14.eglDestroySurface(bVar.a(), bVar.c());
                bVar.a(EGL14.EGL_NO_SURFACE);
                EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
                Intrinsics.checkNotNullExpressionValue(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
                bVar.a(EGL_NO_CONTEXT);
                bVar2.f();
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
    public static final class d extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133257b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f133258c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i3, int i16) {
            super(0);
            this.f133257b = i3;
            this.f133258c = i16;
        }

        public final void a() {
            b.this.f133242c = this.f133257b;
            b.this.f133243d = this.f133258c;
            com.tencent.luggage.wxa.fb.a d16 = b.this.d();
            if (d16 != null) {
                d16.a(b.this.f133242c, b.this.f133243d);
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
    public static final class e extends Lambda implements Function0 {
        public e() {
            super(0);
        }

        public final void a() {
            com.tencent.luggage.wxa.fb.a d16 = b.this.d();
            if (d16 != null) {
                com.tencent.luggage.wxa.fb.a.a(d16, false, 1, null);
            }
            b.this.a((com.tencent.luggage.wxa.fb.a) null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {
        public f() {
            super(0);
        }

        public final void a() {
            SurfaceTexture d16;
            com.tencent.luggage.wxa.mb.a aVar = b.this.f133247h;
            if (aVar != null && (d16 = aVar.d()) != null) {
                d16.updateTexImage();
            }
            com.tencent.luggage.wxa.fb.a d17 = b.this.d();
            if (d17 != null) {
                d17.onDrawFrame(null);
            }
            a.b bVar = b.this.f133240a;
            if (bVar != null) {
                EGLExt.eglPresentationTimeANDROID(bVar.a(), bVar.c(), System.nanoTime());
                EGL14.eglSwapBuffers(bVar.a(), bVar.c());
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
    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f133261a;

        public g(Function0 function0) {
            this.f133261a = function0;
        }

        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.f133261a.invoke();
        }
    }

    public b() {
        e();
    }

    public void b(Surface surface) {
    }

    public void h() {
        w.f("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview", new Object[0]);
        this.f133249j = null;
    }

    @Override // com.tencent.luggage.wxa.lb.d
    public void requestRender() {
        a(new f());
    }

    public com.tencent.luggage.wxa.eb.d c() {
        com.tencent.luggage.wxa.fb.a aVar = this.f133246g;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public final com.tencent.luggage.wxa.fb.a d() {
        return this.f133246g;
    }

    public final void e() {
        HandlerThread d16 = com.tencent.luggage.wxa.cq.d.d("CameraPreviewTextureView_renderThread", -2);
        d16.start();
        this.f133245f = new b0(d16.getLooper());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f133250k);
        this.f133250k.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((Function0) it.next());
        }
        this.f133244e = d16;
    }

    public final void f() {
        HandlerThread handlerThread = this.f133244e;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.f133244e = null;
        this.f133245f = null;
    }

    public void g() {
        a(new e());
    }

    public void b(Surface surface, int i3, int i16) {
        w.d("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceSizeChanged, surface:" + surface + ", width:" + i3 + ", height:" + i16);
        a(new d(i3, i16));
    }

    public final void a(com.tencent.luggage.wxa.fb.a aVar) {
        this.f133246g = aVar;
    }

    public void b(Function1 function1) {
        w.f("MicroMsg.CameraPreviewGLTextureRender", "tryCameraPreview canPreview:" + this.f133248i, new Object[0]);
        if (!this.f133248i) {
            this.f133249j = function1;
        } else if (function1 != null) {
            com.tencent.luggage.wxa.mb.a aVar = this.f133247h;
            function1.invoke(aVar != null ? aVar.d() : null);
        }
    }

    public void a(com.tencent.luggage.wxa.kb.a cameraConfig) {
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        w.d("MicroMsg.CameraPreviewGLTextureRender", "updateCameraConfig: " + cameraConfig);
        com.tencent.luggage.wxa.mb.a aVar = this.f133247h;
        if (aVar != null) {
            aVar.b(cameraConfig);
        }
    }

    public boolean a(Surface surface) {
        w.f("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceDestroyed", new Object[0]);
        this.f133248i = false;
        a(new c());
        return false;
    }

    public MMSightCameraFrameDataCallback b() {
        com.tencent.luggage.wxa.mb.a aVar = this.f133247h;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public void a(Surface surface, int i3, int i16) {
        w.d("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceAvailable, surface:" + surface + ", width:" + i3 + ", height:" + i16 + ", handler: " + this.f133245f);
        if (this.f133245f == null) {
            e();
        }
        if (surface != null) {
            a(new C6430b(i3, i16, surface));
        }
    }

    public EGLContext a() {
        a.b bVar = this.f133240a;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public void a(Function1 function1) {
        com.tencent.luggage.wxa.mb.a aVar = this.f133247h;
        if (aVar != null) {
            aVar.a(function1);
        }
    }

    public void a(com.tencent.luggage.wxa.fb.a renderer, boolean z16) {
        com.tencent.luggage.wxa.mb.a cVar;
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        w.d("MicroMsg.CameraPreviewGLTextureRender", "setRenderer:" + renderer.hashCode() + "  cpuCrop:" + z16);
        com.tencent.luggage.wxa.mb.a aVar = this.f133247h;
        if (aVar != null) {
            com.tencent.luggage.wxa.mb.a.a(aVar, false, false, 3, null);
        }
        if (z16) {
            cVar = new com.tencent.luggage.wxa.mb.b(this);
        } else {
            cVar = new com.tencent.luggage.wxa.mb.c(this);
        }
        this.f133247h = cVar;
        cVar.a(renderer);
        this.f133246g = renderer;
    }

    @Override // com.tencent.luggage.wxa.lb.d
    public void a(Function0 r16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        b0 b0Var = this.f133245f;
        if (b0Var != null) {
            b0Var.a((Runnable) new g(r16));
        } else {
            this.f133250k.add(r16);
        }
    }
}
