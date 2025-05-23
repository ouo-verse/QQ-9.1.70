package com.tencent.luggage.wxa.xj;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xj.l;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class l implements com.tencent.mm.plugin.appbrand.platform.window.activity.a {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f145127a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f145128b = this;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f145129c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f145130d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f145131e;

    /* renamed from: f, reason: collision with root package name */
    public final WindowInsets[] f145132f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.xj.b f145133g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f145134a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f145135b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.lo.k f145136c;

        public a(int i3, View view, com.tencent.luggage.wxa.lo.k kVar) {
            this.f145134a = i3;
            this.f145135b = view;
            this.f145136c = kVar;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            synchronized (l.this.f145128b) {
                l.this.f145132f[this.f145134a] = this.f145135b.getRootWindowInsets();
                l.this.f145131e = l.b(windowInsets);
            }
            this.f145136c.b(this);
            return windowInsets;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.lo.k f145138a;

        public b(com.tencent.luggage.wxa.lo.k kVar) {
            this.f145138a = kVar;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            WindowInsets rootWindowInsets;
            boolean z16;
            try {
                try {
                    View decorView = l.this.f145127a.getWindow().getDecorView();
                    int rotation = com.tencent.luggage.wxa.xj.a.a(l.this.f145127a).getRotation();
                    synchronized (l.this.f145128b) {
                        WindowInsets[] windowInsetsArr = l.this.f145132f;
                        rootWindowInsets = decorView.getRootWindowInsets();
                        windowInsetsArr[rotation] = rootWindowInsets;
                        z16 = l.this.f145131e = l.b(windowInsets);
                    }
                    w.d("Luggage.WXA.WindowAndroidActivityCutoutHandlerApi28", "resetCache-onApplyWindowInsets, notch:%b, windowInsets:%s", Boolean.valueOf(z16), rootWindowInsets);
                } catch (Exception e16) {
                    w.a("Luggage.WXA.WindowAndroidActivityCutoutHandlerApi28", e16, "resetCache-onApplyWindowInsets", new Object[0]);
                }
                return windowInsets;
            } finally {
                this.f145138a.b(this);
            }
        }
    }

    public l(Activity activity) {
        Handler handler;
        View decorView;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = Handler.createAsync(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        this.f145129c = handler;
        boolean z16 = false;
        this.f145131e = false;
        this.f145132f = new WindowInsets[4];
        this.f145127a = activity;
        this.f145130d = new Configuration(activity.getResources().getConfiguration());
        if (activity.getWindow() == null) {
            decorView = null;
        } else {
            decorView = activity.getWindow().getDecorView();
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(a());
        objArr[1] = activity.getLocalClassName();
        if (decorView != null && decorView.isAttachedToWindow()) {
            z16 = true;
        }
        objArr[2] = Boolean.valueOf(z16);
        w.d("Luggage.WXA.WindowAndroidActivityCutoutHandlerApi28", "<init> hasCutOut[%b] activity[%s], isDecorViewAttached[%b]", objArr);
        if (decorView != null && !decorView.isAttachedToWindow()) {
            decorView.post(new Runnable() { // from class: t41.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.a();
                }
            });
        }
    }

    public final void d() {
        boolean b16 = c0.b();
        synchronized (this.f145128b) {
            for (int i3 = 0; i3 <= 3; i3++) {
                this.f145132f[i3] = null;
            }
        }
        if (!b16) {
            return;
        }
        try {
            com.tencent.luggage.wxa.lo.k b17 = com.tencent.luggage.wxa.lo.k.b(this.f145127a);
            b17.a(new b(b17));
            this.f145127a.getWindow().getDecorView().requestApplyInsets();
        } catch (Exception e16) {
            w.a("Luggage.WXA.WindowAndroidActivityCutoutHandlerApi28", e16, "resetCache", new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r0 = r0.getDisplayCutout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        r0 = r0.getBoundingRects();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        List boundingRects;
        return (windowInsets == null || displayCutout == null || boundingRects == null || boundingRects.size() <= 0) ? false : true;
    }

    public final View c() {
        Window window = this.f145127a.getWindow();
        if (window == null) {
            return null;
        }
        return window.getDecorView();
    }

    public WindowInsets a(int i3) {
        WindowInsets windowInsets;
        synchronized (this.f145128b) {
            windowInsets = this.f145132f[i3];
        }
        return windowInsets;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.a
    public int b() {
        return com.tencent.luggage.wxa.h6.l.f126905a.a(this.f145127a);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.a
    public boolean a() {
        final View decorView = this.f145127a.getWindow().getDecorView();
        final int rotation = com.tencent.luggage.wxa.xj.a.a(this.f145127a).getRotation();
        WindowInsets a16 = a(rotation);
        if (a16 != null) {
            boolean b16 = b(a16);
            this.f145131e = b16;
            return b16;
        }
        if (decorView.isAttachedToWindow()) {
            if (c0.b()) {
                WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                synchronized (this.f145128b) {
                    this.f145132f[rotation] = rootWindowInsets;
                    this.f145131e = b(rootWindowInsets);
                }
            } else {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final WindowInsets[] windowInsetsArr = {null};
                this.f145129c.postAtFrontOfQueue(new Runnable() { // from class: t41.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.this.a(windowInsetsArr, decorView, rotation, countDownLatch);
                    }
                });
                try {
                    countDownLatch.await(500L, TimeUnit.MILLISECONDS);
                } catch (Exception e16) {
                    w.b("Luggage.WXA.WindowAndroidActivityCutoutHandlerApi28", "hasCutout await main thread failed, %s", e16);
                }
            }
        } else {
            com.tencent.luggage.wxa.lo.k b17 = com.tencent.luggage.wxa.lo.k.b(this.f145127a);
            b17.a(new a(rotation, decorView, b17));
        }
        return this.f145131e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WindowInsets[] windowInsetsArr, View view, int i3, CountDownLatch countDownLatch) {
        windowInsetsArr[0] = view.getRootWindowInsets();
        synchronized (this.f145128b) {
            this.f145132f[i3] = windowInsetsArr[0];
            this.f145131e = b(windowInsetsArr[0]);
        }
        countDownLatch.countDown();
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.a
    public void a(Configuration configuration) {
        if (n.a(this.f145130d, configuration)) {
            com.tencent.luggage.wxa.xj.b bVar = this.f145133g;
            if (bVar != null) {
                bVar.a();
            } else {
                this.f145133g = new com.tencent.luggage.wxa.xj.b(new Function0() { // from class: t41.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return l.this.c();
                    }
                }, new Runnable() { // from class: t41.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.this.d();
                    }
                });
            }
            this.f145133g.d();
        }
        this.f145130d = new Configuration(configuration);
    }
}
