package com.tencent.luggage.wxa.kj;

import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class w0 implements com.tencent.luggage.wxa.mj.e, com.tencent.luggage.wxa.mj.c {

    /* renamed from: a, reason: collision with root package name */
    public final v f132520a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.p4.e f132521b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f132522c = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    public String[] f132523d = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f132524e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f132525f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f132526g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f132527h = false;

    /* renamed from: i, reason: collision with root package name */
    public Configuration f132528i;

    /* renamed from: j, reason: collision with root package name */
    public f f132529j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnLayoutChangeListener {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kj.w0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6396a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View.OnLayoutChangeListener f132531a;

            public RunnableC6396a(View.OnLayoutChangeListener onLayoutChangeListener) {
                this.f132531a = onLayoutChangeListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                w0.this.f132520a.q0().removeOnLayoutChangeListener(this.f132531a);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (TextUtils.isEmpty(w0.this.f132520a.A0())) {
                return;
            }
            if (w0.this.f132525f) {
                try {
                    w0.this.f132520a.q0().removeOnLayoutChangeListener(this);
                } catch (ConcurrentModificationException unused) {
                    w0.this.f132520a.c(new RunnableC6396a(this));
                }
            } else {
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", w0.this.f132520a.getAppId(), w0.this.f132520a.A0(), Boolean.valueOf(w0.this.f132526g));
                if (!w0.this.f132526g) {
                    w0.this.c();
                } else {
                    w0.this.f132527h = true;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132533a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f132534b;

        public b(String str, Map map) {
            this.f132533a = str;
            this.f132534b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            w0.this.a(this.f132533a, this.f132534b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.a f132536a;

        public c(e.a aVar) {
            this.f132536a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w0.this.a(this.f132536a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f132538a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.a f132539b;

        public d(e.a aVar) {
            this.f132539b = aVar;
        }

        @Override // com.tencent.luggage.wxa.wj.e.a
        public void a(e.b bVar, boolean z16) {
            boolean andSet = this.f132538a.getAndSet(true);
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b], hasFiredCallback[%b]", w0.this.e(), w0.this.g(), bVar, Boolean.valueOf(z16), Boolean.valueOf(andSet));
            if (andSet) {
                return;
            }
            e.a aVar = this.f132539b;
            if (aVar != null) {
                aVar.a(bVar, z16);
            }
            w0.this.a(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends com.tencent.luggage.wxa.wj.b {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.wj.b
        public void j() {
            w0.this.f132520a.h0().b(this);
            if (!w0.this.f132525f && w0.this.f132524e) {
                w0.this.a((e.a) null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f132542a;

        /* renamed from: b, reason: collision with root package name */
        public ViewTreeObserver.OnGlobalLayoutListener f132543b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w0.this.a(false);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: a, reason: collision with root package name */
            public int f132546a;

            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (f.this.f132542a == null) {
                    f.this.c();
                    return;
                }
                int i3 = this.f132546a + 1;
                this.f132546a = i3;
                if (i3 == 2) {
                    f.this.c();
                    f.this.f132542a.run();
                }
            }
        }

        public f() {
            this.f132542a = new a();
        }

        public final void c() {
            View contentView = w0.this.f132520a.getContentView();
            if (contentView != null) {
                contentView.removeCallbacks(this.f132542a);
                if (this.f132543b != null) {
                    contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f132543b);
                }
            }
        }

        public void a() {
            c();
            this.f132543b = null;
            this.f132542a = null;
        }

        public void b() {
            w0.this.a(true);
            c();
            View contentView = w0.this.f132520a.getContentView();
            Objects.requireNonNull(contentView);
            contentView.postDelayed(this.f132542a, 100L);
            ViewTreeObserver viewTreeObserver = contentView.getViewTreeObserver();
            b bVar = new b();
            this.f132543b = bVar;
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
        }

        public /* synthetic */ f(w0 w0Var, a aVar) {
            this();
        }
    }

    public w0(v vVar) {
        this.f132520a = vVar;
        this.f132521b = new com.tencent.luggage.wxa.p4.e(vVar);
        vVar.q0().addOnLayoutChangeListener(new a());
    }

    @Override // com.tencent.luggage.wxa.mj.e
    public String getRequestedOrientation() {
        boolean z16;
        if (this.f132523d == null) {
            synchronized (this.f132522c) {
                if (this.f132523d == null) {
                    b(this.f132520a.s0());
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "getRequestedOrientation and setInitialOrientation for %s, %s, stack:%s", e(), g(), Log.getStackTraceString(new Throwable()));
        }
        return this.f132523d[0];
    }

    public final boolean h() {
        if (this.f132520a.D().shouldInLargeScreenCompatMode()) {
            return false;
        }
        com.tencent.luggage.wxa.h6.l lVar = com.tencent.luggage.wxa.h6.l.f126905a;
        if (lVar.d() && com.tencent.luggage.wxa.uk.b0.c(this.f132520a.getContext())) {
            return true;
        }
        if (!com.tencent.luggage.wxa.p003do.c.a() || !com.tencent.luggage.wxa.uk.b0.c(this.f132520a.getContext()) || lVar.d()) {
            return false;
        }
        return true;
    }

    public final boolean i() {
        try {
            return this.f132520a.getRuntime().E().H;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final boolean j() {
        if (!com.tencent.luggage.wxa.uk.b0.c(this.f132520a.getContext())) {
            return false;
        }
        return i();
    }

    public final boolean k() {
        if (e.b.b(f().a()) && ((com.tencent.luggage.wxa.j4.a) this.f132520a.a(com.tencent.luggage.wxa.j4.a.class)).f130780a) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onBackground() {
        this.f132524e = false;
        this.f132521b.i();
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2;
        if (this.f132524e && !this.f132525f && (configuration2 = this.f132528i) != null && configuration2.orientation != configuration.orientation) {
            this.f132528i = new Configuration(configuration);
            if (this.f132529j == null) {
                this.f132529j = new f(this, null);
            }
            this.f132529j.b();
        }
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onDestroy() {
        this.f132524e = false;
        this.f132525f = true;
        f fVar = this.f132529j;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onForeground() {
        if (this.f132528i == null) {
            n b06 = this.f132520a.b0();
            Objects.requireNonNull(b06);
            this.f132528i = new Configuration(b06.getResources().getConfiguration());
        }
        this.f132524e = true;
        if (this.f132520a.h0() != null && this.f132520a.h0().b()) {
            this.f132520a.h0().a(new e());
        } else {
            a((e.a) null);
        }
        this.f132521b.j();
    }

    public final void c() {
        com.tencent.luggage.wxa.ic.l y06 = this.f132520a.y0();
        if (y06 == null || this.f132525f) {
            return;
        }
        this.f132521b.a(y06);
    }

    public final boolean d() {
        if (!com.tencent.luggage.wxa.uk.b0.b(this.f132520a.getContext())) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "folderFixedOrientationDeviceCompatible not large screen");
            return false;
        }
        boolean b16 = com.tencent.luggage.wxa.h6.l.f126905a.b();
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "folderFixedOrientationDeviceCompatible ret=" + b16);
        return b16;
    }

    public final String e() {
        return this.f132520a.getAppId();
    }

    public final com.tencent.luggage.wxa.wj.e f() {
        return this.f132520a.D().getOrientationHandler();
    }

    public final String g() {
        return this.f132520a.A0();
    }

    public final void a(boolean z16) {
        this.f132526g = z16;
        if (z16 || !this.f132527h) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", this.f132520a.getAppId(), this.f132520a.A0(), Boolean.valueOf(this.f132525f));
        c();
        this.f132527h = false;
    }

    public final void b(String str) {
        this.f132521b.a(false);
        synchronized (this.f132522c) {
            this.f132523d = new String[]{str};
        }
    }

    public final boolean b() {
        com.tencent.luggage.wxa.wj.e orientationHandler = this.f132520a.D() == null ? null : this.f132520a.D().getOrientationHandler();
        if (orientationHandler == null || (orientationHandler instanceof com.tencent.luggage.wxa.yj.a)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", this.f132520a.getAppId(), this.f132520a.A0());
            return false;
        }
        e.b a16 = orientationHandler.a();
        e.b a17 = e.b.a(getRequestedOrientation());
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", e(), g(), a16, a17);
        if (e.b.UNSPECIFIED == a17) {
            return false;
        }
        if ((this.f132520a.D() instanceof WindowAndroidActivityImpl) && (j() || h() || k())) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], fixed orientation device", e(), g());
            return false;
        }
        if (d()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] return false for folder orientaion fixed", e(), g());
            return false;
        }
        if (i() && k()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] unlock landscape for wmpf & auto", e(), g());
            return false;
        }
        if (a17 == null) {
            a17 = e.b.PORTRAIT;
        }
        return !a16.a(a17);
    }

    @Override // com.tencent.luggage.wxa.mj.e
    public boolean a() {
        boolean b16 = b();
        this.f132521b.a(b16);
        return b16;
    }

    @Override // com.tencent.luggage.wxa.mj.e
    public void a(String str) {
        synchronized (this.f132522c) {
            String[] strArr = this.f132523d;
            if (strArr == null) {
                this.f132523d = new String[]{str};
            } else {
                strArr[0] = str;
            }
        }
        a((e.a) null);
    }

    public void a(String str, Map map) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f132520a.a(new b(str, map));
        } else {
            this.f132521b.a(map);
            a(str);
        }
    }

    public void a(e.a aVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f132520a.a(new c(aVar));
            return;
        }
        if (this.f132525f) {
            com.tencent.luggage.wxa.tn.w.h("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", e(), this.f132520a.A0());
            return;
        }
        a(true);
        d dVar = new d(aVar);
        boolean z16 = this.f132520a.D() instanceof WindowAndroidActivityImpl;
        if (e.b.b(f().a()) && z16) {
            if (!h() && !j()) {
                if (k()) {
                    dVar.a(null, false);
                    com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], wmpfFixedOrientationDeviceCompatible, callback first then try request orientation", e(), g());
                }
            } else {
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", e(), g());
                dVar.a(null, false);
                return;
            }
        }
        if (this.f132520a.getRuntime().C0()) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
            dVar.a(null, false);
            return;
        }
        com.tencent.luggage.wxa.tn.w.f("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", e(), g(), getRequestedOrientation());
        String b16 = com.tencent.luggage.wxa.tn.w0.b(getRequestedOrientation(), "portrait");
        b16.hashCode();
        char c16 = '\uffff';
        switch (b16.hashCode()) {
            case -2022952606:
                if (b16.equals("landscapeLeft")) {
                    c16 = 0;
                    break;
                }
                break;
            case 3005871:
                if (b16.equals("auto")) {
                    c16 = 1;
                    break;
                }
                break;
            case 729267099:
                if (b16.equals("portrait")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1430647483:
                if (b16.equals("landscape")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                f().a(e.b.LANDSCAPE_LEFT, dVar);
                return;
            case 1:
                f().a(e.b.UNSPECIFIED, dVar);
                return;
            case 2:
                f().a(e.b.PORTRAIT, dVar);
                return;
            case 3:
                f().a(e.b.LANDSCAPE_SENSOR, dVar);
                return;
            default:
                String format = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", this.f132520a.getAppId(), this.f132520a.A0(), getRequestedOrientation());
                if (!this.f132520a.b()) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", format);
                    dVar.a(null, false);
                    return;
                }
                throw new IllegalArgumentException(format);
        }
    }
}
