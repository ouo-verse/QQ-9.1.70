package com.tencent.luggage.wxa.lb;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.mmsight.model.MMSightCameraFrameDataCallback;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends GLSurfaceView implements c {

    /* renamed from: f, reason: collision with root package name */
    public static final b f133228f = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public Function1 f133229a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.mb.a f133230b;

    /* renamed from: c, reason: collision with root package name */
    public int f133231c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f133232d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f133233e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6428a implements GLSurfaceView.Renderer {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lb.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6429a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f133235a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GL10 f133236b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f133237c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f133238d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6429a(a aVar, GL10 gl10, int i3, int i16) {
                super(0);
                this.f133235a = aVar;
                this.f133236b = gl10;
                this.f133237c = i3;
                this.f133238d = i16;
            }

            public final void a() {
                boolean z16;
                SurfaceTexture surfaceTexture;
                com.tencent.luggage.wxa.eb.d f16;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("previewController initRender  ");
                if (this.f133235a.f133229a == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                w.f("MicroMsg.CameraPreviewGLSurfaceView", sb5.toString(), new Object[0]);
                com.tencent.luggage.wxa.mb.a aVar = this.f133235a.f133230b;
                if (aVar != null) {
                    aVar.a(this.f133236b, this.f133237c, this.f133238d);
                }
                com.tencent.luggage.wxa.mb.a aVar2 = this.f133235a.f133230b;
                if (aVar2 != null && (f16 = aVar2.f()) != null) {
                    f16.a(this.f133237c, this.f133238d);
                }
                this.f133235a.f133232d = true;
                if (this.f133235a.f133229a != null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("callback.invoke  ");
                    com.tencent.luggage.wxa.mb.a aVar3 = this.f133235a.f133230b;
                    SurfaceTexture surfaceTexture2 = null;
                    if (aVar3 != null) {
                        surfaceTexture = aVar3.d();
                    } else {
                        surfaceTexture = null;
                    }
                    sb6.append(surfaceTexture);
                    w.f("MicroMsg.CameraPreviewGLSurfaceView", sb6.toString(), new Object[0]);
                    Function1 function1 = this.f133235a.f133229a;
                    if (function1 != null) {
                        com.tencent.luggage.wxa.mb.a aVar4 = this.f133235a.f133230b;
                        if (aVar4 != null) {
                            surfaceTexture2 = aVar4.d();
                        }
                        function1.invoke(surfaceTexture2);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public C6428a() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            com.tencent.luggage.wxa.mb.a aVar;
            if (!a.this.f133233e && (aVar = a.this.f133230b) != null) {
                aVar.a(gl10);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
            w.f("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + i3 + " height:" + i16, new Object[0]);
            com.tencent.luggage.wxa.mb.a aVar = a.this.f133230b;
            if (aVar != null) {
                aVar.a(true, a.this.f133231c, (Function0) new C6429a(a.this, gl10, i3, i16));
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            w.f("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
            com.tencent.luggage.wxa.mb.a aVar = a.this.f133230b;
            if (aVar != null) {
                aVar.a(gl10, eGLConfig);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getHolder().addCallback(this);
        try {
            try {
                try {
                    getHolder().setType(2);
                } catch (Exception unused) {
                    getHolder().setType(1);
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            getHolder().setType(0);
        }
        setEGLContextFactory(new com.tencent.luggage.wxa.gb.b());
        setEGLContextClientVersion(f0.e("mmkv_gl_key").a("support_egl_context_client_version", 3));
        setEGLConfigChooser(new com.tencent.luggage.wxa.gb.a(5, 6, 5, 0, 0, 0));
        setPreserveEGLContextOnPause(false);
        setRenderer(new C6428a());
        setRenderMode(0);
        w.f("MicroMsg.CameraPreviewGLSurfaceView", "init create CameraPreviewGLSurfaceView", new Object[0]);
    }

    @Nullable
    public EGLContext getEGLContext() {
        com.tencent.luggage.wxa.mb.a aVar = this.f133230b;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    @Nullable
    public MMSightCameraFrameDataCallback getFrameDataCallback() {
        com.tencent.luggage.wxa.mb.a aVar = this.f133230b;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    @Nullable
    public com.tencent.luggage.wxa.eb.d getPreviewTexture() {
        com.tencent.luggage.wxa.mb.a aVar = this.f133230b;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    public void setOnDrawListener(@Nullable Function1<? super com.tencent.luggage.wxa.eb.d, Unit> function1) {
        w.f("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
        com.tencent.luggage.wxa.mb.a aVar = this.f133230b;
        if (aVar != null) {
            aVar.a(function1);
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        w.d("MicroMsg.CameraPreviewGLSurfaceView", "surfaceChanged:" + holder.getSurface() + ", format:" + i3 + ", w:" + i16 + ", h:" + i17);
        super.surfaceChanged(holder, i3, i16, i17);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        w.d("MicroMsg.CameraPreviewGLSurfaceView", "surfaceCreated: " + holder.getSurface());
        super.surfaceCreated(holder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        w.d("MicroMsg.CameraPreviewGLSurfaceView", "surfaceDestroyed: " + holder.getSurface());
        com.tencent.luggage.wxa.mb.a aVar = this.f133230b;
        if (aVar != null) {
            com.tencent.luggage.wxa.mb.a.a(aVar, false, true, 1, null);
        }
        this.f133232d = false;
        super.surfaceDestroyed(holder);
    }
}
