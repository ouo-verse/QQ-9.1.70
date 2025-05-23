package com.tencent.luggage.wxa.d4;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.z3.c;
import com.tencent.luggage.wxa.z3.d;
import com.tencent.luggage.wxa.z3.e;
import com.tencent.luggage.wxa.z3.g;
import com.tencent.luggage.wxa.z3.h;
import com.tencent.luggage.wxa.z3.i;
import com.tencent.luggage.wxa.z3.j;
import com.tencent.luggage.wxa.z3.k;
import com.tencent.luggage.wxa.z3.l;
import com.tencent.luggage.wxa.z3.p;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends FrameLayout implements Camera.PreviewCallback, Camera.AutoFocusCallback, TextureView.SurfaceTextureListener {

    /* renamed from: i, reason: collision with root package name */
    public static int f124062i = 80;

    /* renamed from: j, reason: collision with root package name */
    public static int f124063j = 1000;

    /* renamed from: a, reason: collision with root package name */
    public TextureView f124064a;

    /* renamed from: b, reason: collision with root package name */
    public p f124065b;

    /* renamed from: c, reason: collision with root package name */
    public SurfaceTexture f124066c;

    /* renamed from: d, reason: collision with root package name */
    public int f124067d;

    /* renamed from: e, reason: collision with root package name */
    public long f124068e;

    /* renamed from: f, reason: collision with root package name */
    public long f124069f;

    /* renamed from: g, reason: collision with root package name */
    public f f124070g;

    /* renamed from: h, reason: collision with root package name */
    public e f124071h;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.d4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6128a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.a f124072a;

        public C6128a(e.a aVar) {
            this.f124072a = aVar;
        }

        @Override // com.tencent.luggage.wxa.z3.e.a
        public void a() {
            if (a.this.f124065b.isOpen() && a.this.f124065b.e()) {
                a aVar = a.this;
                if (aVar.f124066c != null) {
                    aVar.f124064a.setTransform(aVar.a(aVar.f124065b.d(), new Point(a.this.f124064a.getWidth(), a.this.f124064a.getHeight())));
                    e.a aVar2 = this.f124072a;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.z3.e.a
        public void a() {
            a.this.b(0L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f124075a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f124076b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.d4.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6129a implements e.a {
            public C6129a() {
            }

            @Override // com.tencent.luggage.wxa.z3.e.a
            public void a() {
                a.this.b(0L);
            }
        }

        public c(int i3, int i16) {
            this.f124075a = i3;
            this.f124076b = i16;
        }

        @Override // com.tencent.luggage.wxa.z3.c.a
        public void a() {
            a.this.f124065b.a(new Point(this.f124075a, this.f124076b));
            a.this.a(new C6129a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements d.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.d4.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6130a implements e.a {
            public C6130a() {
            }

            @Override // com.tencent.luggage.wxa.z3.e.a
            public void a() {
                a.this.b(0L);
            }
        }

        public d() {
        }

        @Override // com.tencent.luggage.wxa.z3.d.a
        public void a() {
            a.this.f124065b.a(new Point(a.this.f124064a.getWidth(), a.this.f124064a.getHeight()));
            a.this.a(new C6130a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a.this.f124069f = System.currentTimeMillis();
            if (a.this.f124065b.e()) {
                if (!"auto".equals(a.this.f124065b.c())) {
                    a.this.f124065b.a("auto");
                }
                a aVar = a.this;
                aVar.f124065b.a((Camera.AutoFocusCallback) aVar);
                com.tencent.luggage.wxa.yp.b.c("ScanView", "do auto focus");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a.this.f124068e = System.currentTimeMillis();
            com.tencent.luggage.wxa.yp.b.c("ScanView", "take one shot");
            if (a.this.f124065b.e()) {
                a aVar = a.this;
                aVar.f124065b.a((Camera.PreviewCallback) aVar);
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f124070g = new f(Looper.myLooper());
        this.f124071h = new e(Looper.myLooper());
    }

    public abstract void b();

    public void c() {
        TextureView textureView = new TextureView(getContext());
        this.f124064a = textureView;
        textureView.setSurfaceTextureListener(this);
        addView(this.f124064a, new FrameLayout.LayoutParams(-1, -1));
        b();
        this.f124067d = getResources().getConfiguration().orientation;
        a((c.a) null);
    }

    public void d() {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "onCreate");
        c();
    }

    public void e() {
        com.tencent.luggage.wxa.yp.b.c("ScanView", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.f124064a.setSurfaceTextureListener(null);
    }

    public void f() {
        com.tencent.luggage.wxa.yp.b.c("ScanView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    public void g() {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "onResume");
    }

    public void h() {
        com.tencent.luggage.wxa.yp.b.c("ScanView", DKHippyEvent.EVENT_STOP);
    }

    public void i() {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "try stop preview");
        if (this.f124065b.isOpen()) {
            l.a().a(new k(this.f124065b));
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.luggage.wxa.yp.b.c("ScanView", "onConfigurationChanged %d,%d", Integer.valueOf(configuration.orientation), Integer.valueOf(this.f124067d));
        int i3 = configuration.orientation;
        if (i3 != this.f124067d && this.f124065b != null) {
            this.f124067d = i3;
            a(new d());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
        a();
    }

    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        this.f124068e = 0L;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "surface available, %d %d", Integer.valueOf(i3), Integer.valueOf(i16));
        this.f124066c = surfaceTexture;
        if (this.f124065b.isOpen()) {
            this.f124065b.a(new Point(i3, i16));
            a(new b());
        } else {
            a(new c(i3, i16));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "surface destroyed");
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "surface size changed, %d %d", Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public void b(long j3) {
        long currentTimeMillis = System.currentTimeMillis() - this.f124068e;
        long j16 = f124062i;
        if (currentTimeMillis > j16) {
            this.f124070g.removeMessages(0);
            this.f124070g.sendEmptyMessageDelayed(0, j3);
        } else {
            this.f124070g.removeMessages(0);
            this.f124070g.sendEmptyMessageDelayed(0, j3 + (j16 - currentTimeMillis));
        }
    }

    public void a(c.a aVar) {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "try open camera");
        if (!this.f124065b.isOpen()) {
            com.tencent.luggage.wxa.yp.b.c("ScanView", "camera is not open");
            l.a().a(new h(this.f124065b, ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation()), aVar);
        } else {
            com.tencent.luggage.wxa.yp.b.c("ScanView", "camera is already open!");
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a() {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "try close camera");
        if (this.f124065b.isOpen()) {
            l.a().a(new g(this.f124065b));
        }
    }

    public void a(d.a aVar) {
        int rotation = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation();
        com.tencent.luggage.wxa.yp.b.c("ScanView", "try reopen camera " + rotation);
        l.a().a(new i(this.f124065b, rotation), aVar);
    }

    public final Matrix a(Point point, Point point2) {
        float f16;
        float f17;
        com.tencent.luggage.wxa.yp.b.c("ScanView", "from " + point + " to " + point2);
        Matrix matrix = new Matrix();
        this.f124064a.getTransform(matrix);
        matrix.reset();
        com.tencent.luggage.wxa.yp.b.c("ScanView", "before matrix " + matrix);
        if (point.equals(point2)) {
            return matrix;
        }
        int a16 = this.f124065b.a();
        Point b16 = this.f124065b.b();
        int i3 = b16.x;
        int i16 = point2.x;
        int i17 = (i3 - i16) / 2;
        int i18 = b16.y;
        int i19 = point2.y;
        int i26 = (i18 - i19) / 2;
        if (a16 % 180 != 0) {
            f16 = (i16 * 1.0f) / point.y;
            i26 = (i3 - i19) / 2;
            i17 = (i18 - i16) / 2;
            f17 = (i19 * 1.0f) / point.x;
        } else {
            f16 = (i16 * 1.0f) / point.x;
            f17 = (i19 * 1.0f) / point.y;
        }
        float max = Math.max(f16, f17);
        com.tencent.luggage.wxa.yp.b.c("ScanView", "scaleX %f, scaleY %f, scale %f, dx %d, dy %d", Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(max), Integer.valueOf(i17), Integer.valueOf(i26));
        matrix.preScale(1.0f / f16, 1.0f / f17);
        matrix.postScale(max, max);
        matrix.postTranslate(-i17, -i26);
        com.tencent.luggage.wxa.yp.b.c("ScanView", "after matrix " + matrix);
        return matrix;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void a(e.a aVar) {
        com.tencent.luggage.wxa.yp.b.c("ScanView", "try start preview");
        if (!this.f124065b.isOpen() || this.f124065b.e() || this.f124066c == null) {
            return;
        }
        l.a().a(new j(this.f124065b, this.f124066c), new C6128a(aVar));
    }

    public void a(long j3) {
        long currentTimeMillis = System.currentTimeMillis() - this.f124069f;
        long j16 = f124063j;
        if (currentTimeMillis > j16) {
            this.f124071h.removeMessages(0);
            this.f124071h.sendEmptyMessageDelayed(0, j3);
        } else {
            this.f124071h.removeMessages(0);
            this.f124071h.sendEmptyMessageDelayed(0, j3 + (j16 - currentTimeMillis));
        }
    }
}
