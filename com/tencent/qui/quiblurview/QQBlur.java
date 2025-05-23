package com.tencent.qui.quiblurview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.enrique.stackblur.StackBlurManager;
import com.google.android.renderscript.Toolkit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes25.dex */
public class QQBlur {
    static IPatchRedirector $redirector_;
    private static HandlerThread U;
    public static int V;
    private static Field W;
    private float A;
    private a B;
    private long C;
    private long D;
    private long E;
    private String F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private List<View> O;
    private volatile boolean P;
    private long Q;
    private int R;
    private int S;
    private final boolean T;

    /* renamed from: a, reason: collision with root package name */
    private Context f363555a;

    /* renamed from: b, reason: collision with root package name */
    private View f363556b;

    /* renamed from: c, reason: collision with root package name */
    private volatile View f363557c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Bitmap f363558d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f363559e;

    /* renamed from: f, reason: collision with root package name */
    private Canvas f363560f;

    /* renamed from: g, reason: collision with root package name */
    private float f363561g;

    /* renamed from: h, reason: collision with root package name */
    private int f363562h;

    /* renamed from: i, reason: collision with root package name */
    private float f363563i;

    /* renamed from: j, reason: collision with root package name */
    private float f363564j;

    /* renamed from: k, reason: collision with root package name */
    private float f363565k;

    /* renamed from: l, reason: collision with root package name */
    private float f363566l;

    /* renamed from: m, reason: collision with root package name */
    private long f363567m;

    /* renamed from: n, reason: collision with root package name */
    private long f363568n;

    /* renamed from: o, reason: collision with root package name */
    private long f363569o;

    /* renamed from: p, reason: collision with root package name */
    private long f363570p;

    /* renamed from: q, reason: collision with root package name */
    private Handler f363571q;

    /* renamed from: r, reason: collision with root package name */
    private c f363572r;

    /* renamed from: s, reason: collision with root package name */
    private QQBlurBitmapCache f363573s;

    /* renamed from: t, reason: collision with root package name */
    private List<c> f363574t;

    /* renamed from: u, reason: collision with root package name */
    private List<Object> f363575u;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f363576v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f363577w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f363578x;

    /* renamed from: y, reason: collision with root package name */
    private RectF f363579y;

    /* renamed from: z, reason: collision with root package name */
    private float f363580z;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        boolean a();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface c {
        void a(Bundle bundle);

        void b(Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface d {
        void a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
            return;
        }
        V = 0;
        HandlerThread b16 = ud0.h.b("QQBlur", -8);
        U = b16;
        b16.start();
    }

    public QQBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f363561g = 8.0f;
        this.f363562h = 6;
        this.f363563i = 1.0f;
        this.f363564j = 1.0f;
        this.f363565k = 1.0f;
        this.f363566l = 1.0f;
        this.f363573s = new QQBlurBitmapCache(2);
        this.f363574t = new CopyOnWriteArrayList();
        this.f363575u = new ArrayList();
        this.f363576v = true;
        this.f363577w = new ColorDrawable(Color.parseColor("#DAFAFAFC"));
        this.f363579y = new RectF();
        this.G = 0;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = new ArrayList();
        this.P = false;
        this.R = 2;
        this.S = 0;
        this.T = ud0.b.a().getApplicationInfo().targetSdkVersion < 31;
    }

    private boolean A() {
        if (!this.f363575u.isEmpty() && this.J) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i3, int i16) {
        if (ud0.d.h()) {
            ud0.d.a("QQBlur", ud0.d.f438810d, "onPolicyChange() called with: from = [" + i3 + "], to = [" + i16 + "]");
        }
        V();
    }

    private void Q(StackBlurManager stackBlurManager) {
        this.f363571q.post(new Runnable(stackBlurManager) { // from class: com.tencent.qui.quiblurview.QQBlur.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            private int f363581d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ StackBlurManager f363582e;

            {
                this.f363582e = stackBlurManager;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQBlur.this, (Object) stackBlurManager);
                } else {
                    this.f363581d = -1;
                }
            }

            private void e() {
                int i3;
                if (QQBlur.this.f363576v) {
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int i16 = this.f363581d;
                if (i16 != -1 && i16 != (i3 = QQBlur.V)) {
                    QQBlur.this.L(i16, i3);
                }
                int i17 = QQBlur.V;
                this.f363581d = i17;
                Bitmap v3 = QQBlur.this.v(i17, this.f363582e);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                QQBlur.h(QQBlur.this);
                QQBlur.i(QQBlur.this, elapsedRealtime2 - elapsedRealtime);
                if (v3 != null) {
                    View view = QQBlur.this.f363557c;
                    if (!QQBlur.this.H) {
                        QQBlur.this.f363558d = v3;
                        if (view != null && QQBlur.this.f363578x) {
                            view.postInvalidate();
                        }
                    } else if (view == null || !QQBlur.this.f363578x) {
                        QQBlur.this.f363558d = v3;
                    } else if (!v3.sameAs(QQBlur.this.f363558d)) {
                        if (view instanceof QQBlurView) {
                            ((QQBlurView) view).n();
                        }
                        QQBlur.this.f363558d = v3;
                        view.postInvalidate();
                    } else if (view instanceof QQBlurView) {
                        ((QQBlurView) view).setPreDrawLimitTime();
                    }
                    QQBlur qQBlur = QQBlur.this;
                    qQBlur.f363565k = qQBlur.f363563i * QQBlur.this.f363561g;
                    QQBlur qQBlur2 = QQBlur.this;
                    qQBlur2.f363566l = qQBlur2.f363564j * QQBlur.this.f363561g;
                    return;
                }
                ud0.d.b(QQBlur.this.D(), ud0.d.f438811e, "run: outBitmap is null. OOM ?");
                if (QQBlur.this.f363557c != null) {
                    QQBlur.this.f363557c.postInvalidate();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    e();
                }
            }
        });
    }

    private void R() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f363556b != null && this.f363557c != null) {
            int width = this.f363557c.getWidth();
            int height = this.f363557c.getHeight();
            if (width > 0 && height > 0) {
                if (S(width, height)) {
                    return;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.f363567m++;
                this.f363568n += elapsedRealtime2 - elapsedRealtime;
                return;
            }
            ud0.d.b(D(), ud0.d.f438811e, "prepareBlurBitmap: viewWidth = " + width + " viewHeight = " + height);
            return;
        }
        ud0.d.b(D(), ud0.d.f438811e, "prepareBlurBitmap: mBgView = " + this.f363556b + " mBlurView = " + this.f363557c);
    }

    private boolean S(int i3, int i16) {
        Bitmap bitmap;
        float f16 = i3;
        int w3 = w(f16, this.f363561g);
        float f17 = i16;
        int w16 = w(f17, this.f363561g);
        int X = X(w3);
        int X2 = X(w16);
        if (X > this.f363557c.getResources().getDisplayMetrics().widthPixels) {
            ud0.d.b(D(), ud0.d.f438811e, "prepareBlurBitmapCore: roundScaledWidth = " + X + ", viewWidth = " + i3 + ", scaleFactor = " + this.f363561g);
            return true;
        }
        if (X2 > this.f363557c.getResources().getDisplayMetrics().heightPixels) {
            ud0.d.b(D(), ud0.d.f438811e, "prepareBlurBitmapCore: roundScaledHeight = " + X2 + ", viewHeight = " + i16 + ", scaleFactor = " + this.f363561g);
            return true;
        }
        float f18 = X2;
        this.f363564j = w16 / f18;
        float f19 = w3;
        float f26 = X;
        this.f363563i = f19 / f26;
        float f27 = (f26 * 1.0f) / f16;
        float f28 = (f18 * 1.0f) / f17;
        try {
            if (this.L) {
                bitmap = this.f363573s.a(X, X2);
            } else {
                bitmap = Bitmap.createBitmap(X, X2, Bitmap.Config.ARGB_8888);
            }
        } catch (Throwable th5) {
            ud0.d.b(D(), ud0.d.f438811e, "prepareBlurBitmapCore: ", th5);
            bitmap = null;
        }
        if (bitmap == null) {
            return true;
        }
        this.C = bitmap.getWidth();
        this.D = bitmap.getHeight();
        this.E = bitmap.getAllocationByteCount();
        bitmap.eraseColor(this.G);
        this.f363560f.setBitmap(bitmap);
        this.f363557c.getLocationInWindow(new int[2]);
        this.f363556b.getLocationInWindow(new int[2]);
        float f29 = (-(r2[0] - r11[0])) * f27;
        this.f363560f.save();
        this.f363560f.translate(f29 - (this.f363556b.getScrollX() * f27), ((-(r2[1] - r11[1])) * f28) - (this.f363556b.getScrollY() * f28));
        this.f363560f.scale(f27, f28);
        StackBlurManager stackBlurManager = new StackBlurManager(bitmap);
        stackBlurManager.setDbg(false);
        stackBlurManager.setExecutorThreads(stackBlurManager.getExecutorThreads());
        Bundle bundle = new Bundle();
        c cVar = this.f363572r;
        if (cVar != null) {
            cVar.b(bundle);
        }
        for (c cVar2 : this.f363574t) {
            if (cVar2 != null) {
                cVar2.b(bundle);
            }
        }
        this.N = true;
        if (Build.VERSION.SDK_INT > 27 && this.f363557c.getContext().getApplicationInfo().targetSdkVersion > 27) {
            x();
        } else {
            Rect clipBounds = this.f363560f.getClipBounds();
            clipBounds.inset(-bitmap.getWidth(), -bitmap.getHeight());
            if (this.f363560f.clipRect(clipBounds, Region.Op.REPLACE)) {
                x();
            } else {
                ud0.d.b(D(), ud0.d.f438811e, "prepareBlurBitmapCore: canvas clip rect empty. Cannot draw!!!");
            }
        }
        this.f363560f.restore();
        W();
        this.N = false;
        c cVar3 = this.f363572r;
        if (cVar3 != null) {
            cVar3.a(bundle);
        }
        for (c cVar4 : this.f363574t) {
            if (cVar4 != null) {
                cVar4.a(bundle);
            }
        }
        Q(stackBlurManager);
        return false;
    }

    private void V() {
        this.f363567m = 0L;
        this.f363568n = 0L;
        this.f363569o = 0L;
        this.f363570p = 0L;
    }

    private void W() {
        if (A()) {
            return;
        }
        this.P = true;
        for (View view : this.O) {
            if (view != null) {
                g0(view, 0);
            }
        }
        this.O.clear();
        this.P = false;
    }

    public static int X(int i3) {
        int i16 = i3 % 16;
        if (i16 == 0) {
            return i3;
        }
        return (i3 - i16) + 16;
    }

    private void Y(View view, List<View> list) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        list.add(view);
        g0(view, 4);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                Y(viewGroup.getChildAt(i3), list);
            }
        }
    }

    private void g0(View view, int i3) {
        if (!this.T) {
            return;
        }
        SystemClock.uptimeMillis();
        try {
            if (W == null) {
                W = com.tencent.biz.qui.quicommon.d.c("android.view.View", "mViewFlags");
            }
            W.setInt(view, (i3 & 12) | (W.getInt(view) & (-13)));
        } catch (Exception unused) {
        }
        SystemClock.uptimeMillis();
        if (this.Q >= JsonGrayBusiId.UI_RESERVE_100000_110000) {
            this.Q = 0L;
        }
        long j3 = this.Q + 1;
        this.Q = j3;
        long j16 = j3 % 2000;
    }

    static /* synthetic */ long h(QQBlur qQBlur) {
        long j3 = qQBlur.f363569o;
        qQBlur.f363569o = 1 + j3;
        return j3;
    }

    static /* synthetic */ long i(QQBlur qQBlur, long j3) {
        long j16 = qQBlur.f363570p + j3;
        qQBlur.f363570p = j16;
        return j16;
    }

    private void s() {
        if (this.f363555a == null || this.f363556b == null || this.f363557c == null) {
            ud0.d.k("QQBlur", ud0.d.f438811e, "[checkArgs] arguments is invalid, mContext" + this.f363555a + ", mBgView=" + this.f363556b + ", mBlurView=" + this.f363557c + ", stack=" + ud0.d.f(new RuntimeException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044 A[ADDED_TO_REGION] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap v(int i3, StackBlurManager stackBlurManager) {
        Bitmap a16;
        boolean z16;
        boolean z17;
        try {
            if (this.K) {
                try {
                    a16 = Toolkit.f34531b.a(stackBlurManager.getImage(), this.f363562h);
                    z16 = true;
                } catch (Throwable th5) {
                    ud0.d.b(D(), ud0.d.f438811e, th5);
                }
                if (!z16 && this.I) {
                    try {
                        a16 = stackBlurManager.processNatively(this.f363562h);
                        z17 = true;
                    } catch (Throwable th6) {
                        ud0.d.b(D(), ud0.d.f438811e, th6);
                    }
                    if (z16 && !z17) {
                        return stackBlurManager.process(this.f363562h);
                    }
                    return a16;
                }
                z17 = false;
                if (z16) {
                }
                return a16;
            }
            a16 = null;
            z16 = false;
            if (!z16) {
                a16 = stackBlurManager.processNatively(this.f363562h);
                z17 = true;
                if (z16) {
                }
                return a16;
            }
            z17 = false;
            if (z16) {
            }
            return a16;
        } catch (Throwable unused) {
            ud0.d.b(D(), ud0.d.f438811e, "run: process blur OOM ?");
            return null;
        }
    }

    private static int w(float f16, float f17) {
        return (int) Math.ceil(f16 / f17);
    }

    private void x() {
        if (!A()) {
            this.f363556b.draw(this.f363560f);
            return;
        }
        try {
            for (Object obj : this.f363575u) {
                if (obj instanceof View) {
                    ((View) obj).draw(this.f363560f);
                } else if (obj instanceof Drawable) {
                    z((Drawable) obj);
                }
            }
        } catch (Throwable th5) {
            ud0.d.b(D(), ud0.d.f438811e, th5);
        }
    }

    private void z(Drawable drawable) {
        try {
            Rect bounds = drawable.getBounds();
            if (bounds != null && bounds.height() > 0 && bounds.width() > 0) {
                drawable.draw(this.f363560f);
            }
        } catch (Throwable th5) {
            ud0.d.b(D(), ud0.d.f438811e, th5);
        }
    }

    public Drawable B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Drawable) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f363577w;
    }

    public float C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.f363561g;
    }

    public String D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        if (TextUtils.isEmpty(this.F)) {
            return "QQBlur";
        }
        return "QQBlur." + this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        return this.f363578x;
    }

    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.N;
    }

    public boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f363576v;
    }

    public QQBlur H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QQBlur) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f363578x && ud0.a.b()) {
            throw new IllegalStateException("duplicate create called!");
        }
        this.f363555a = this.f363557c.getContext();
        this.f363560f = new Canvas();
        this.f363571q = new Handler(U.getLooper());
        this.f363578x = true;
        this.H = ud0.g.b("qq_blur_view_improve", true);
        this.I = ud0.g.b("qq_blur_view_native", true);
        this.J = ud0.g.b("qq_blur_view_bg_direct", true);
        this.K = ud0.g.b("qq_blur_view_rs_toolkit", true);
        this.L = ud0.g.b("qq_blur_bitmap_cache", false);
        ud0.d.a(D(), ud0.d.f438811e, "onCreate called nativeBlur Feature Enable: " + this.I + ", mIsFeatureSwitchEnable: " + this.H + ", directBgView Enable: " + this.J + ", RSToolkit Enable: " + this.K + ", bitmap cache Enable: " + this.L);
        s();
        return this;
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        ud0.d.a(D(), ud0.d.f438811e, "onDestroy() called");
        if (this.f363578x) {
            this.f363578x = false;
            this.f363571q.removeCallbacksAndMessages(null);
            this.f363571q = null;
            this.f363556b = null;
            this.f363557c = null;
            this.f363560f.setBitmap(null);
            this.f363560f = null;
            this.f363559e = null;
            this.f363572r = null;
            this.f363555a = null;
            this.f363575u.clear();
            this.O.clear();
        }
        this.f363573s.b();
    }

    public void J(View view, Canvas canvas, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, canvas, dVar);
            return;
        }
        Bitmap bitmap = this.f363558d;
        if (bitmap != null) {
            canvas.save();
            if (this.S == 1) {
                canvas.scale(this.f363565k, this.f363566l);
            } else {
                canvas.scale((view.getWidth() * 1.0f) / bitmap.getWidth(), (view.getHeight() * 1.0f) / bitmap.getHeight());
            }
            if (this.f363559e == null) {
                this.f363559e = new Paint(1);
            }
            Paint paint = this.f363559e;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.f363579y.set(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawRoundRect(this.f363579y, this.f363580z, this.A, this.f363559e);
            Drawable drawable = this.f363577w;
            if (drawable != null) {
                drawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                this.f363577w.draw(canvas);
            }
            canvas.restore();
            return;
        }
        if (ud0.d.h()) {
            ud0.d.b(D(), ud0.d.f438811e, "onDrawBlur: blured bitmap is null " + Integer.toHexString(System.identityHashCode(view)));
        }
        if (dVar != null) {
            dVar.a();
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.f363576v = true;
            V();
        }
    }

    public boolean M() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        a aVar = this.B;
        if (aVar != null) {
            z16 = aVar.a();
        } else {
            View view = this.f363556b;
            if (view != null) {
                z16 = view.isDirty();
            } else {
                z16 = false;
            }
        }
        View view2 = this.f363557c;
        if (!this.f363576v && z16 && view2 != null && view2.isShown()) {
            R();
            if (!this.H) {
                view2.invalidate();
                return true;
            }
            return true;
        }
        return true;
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (ud0.d.i()) {
            ud0.d.a(D(), ud0.d.f438811e, "onResume");
        }
        this.f363576v = false;
    }

    public void O(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            this.M = z16;
        }
    }

    public void P(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) drawable);
        } else {
            this.f363577w = drawable;
        }
    }

    public void T(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.f363562h = i3;
        }
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (A() || this.P) {
            return;
        }
        this.O.clear();
        View view = this.f363556b;
        if (view != null) {
            Y(view.getRootView(), this.O);
        }
    }

    public void Z(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
        } else {
            this.f363561g = f16;
        }
    }

    public void a0(List<?> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        this.f363575u.clear();
        if (list != null) {
            for (Object obj : list) {
                if ((obj instanceof View) || (obj instanceof Drawable)) {
                    this.f363575u.add(obj);
                }
            }
        }
    }

    public void b0(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bVar);
        }
    }

    public void c0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            this.F = str;
        }
    }

    public void d0(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) aVar);
        } else {
            this.B = aVar;
        }
    }

    public void e0(ColorDrawable colorDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) colorDrawable);
        } else {
            this.f363558d = com.tencent.qui.quiblurview.a.a(colorDrawable);
        }
    }

    public void f0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else {
            this.S = i3;
        }
    }

    public QQBlur p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQBlur) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }
        this.f363556b = view;
        return this;
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            V = i3;
        }
    }

    public QQBlur r(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQBlur) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        }
        this.f363557c = view;
        return this;
    }

    public boolean t(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) canvas)).booleanValue();
        }
        if (canvas == this.f363560f) {
            return true;
        }
        return false;
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public QQBlur y(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (QQBlur) iPatchRedirector.redirect((short) 11, (Object) this, (Object) cVar);
        }
        this.f363572r = cVar;
        return this;
    }
}
