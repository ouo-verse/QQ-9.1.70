package com.tencent.mm.plugin.appbrand.platform.window.activity;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.lo.f;
import com.tencent.luggage.wxa.lo.k;
import com.tencent.luggage.wxa.ok.g;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.b0;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.wj.d;
import com.tencent.luggage.wxa.wj.h;
import com.tencent.luggage.wxa.xj.d;
import com.tencent.luggage.wxa.xj.n;
import com.tencent.mm.plugin.appbrand.platform.window.activity.a;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WindowAndroidActivityImpl implements com.tencent.luggage.wxa.wj.c {

    /* renamed from: b, reason: collision with root package name */
    public a f152254b;

    /* renamed from: c, reason: collision with root package name */
    public d f152255c;

    /* renamed from: d, reason: collision with root package name */
    public WindowInsets f152256d;

    /* renamed from: e, reason: collision with root package name */
    public DisplayMetrics f152257e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.xj.b f152258f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f152260h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f152261i;

    /* renamed from: a, reason: collision with root package name */
    public Context f152253a = new MutableContextWrapper(z.c());

    /* renamed from: g, reason: collision with root package name */
    public final ActivityLifecycleMonitor f152259g = new ActivityLifecycleMonitor(this);

    /* renamed from: j, reason: collision with root package name */
    public final Rect[] f152262j = new Rect[4];

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class ActivityLifecycleMonitor implements LifecycleObserver {

        /* renamed from: a, reason: collision with root package name */
        public final WindowAndroidActivityImpl f152263a;

        /* renamed from: b, reason: collision with root package name */
        public Activity f152264b;

        public ActivityLifecycleMonitor(WindowAndroidActivityImpl windowAndroidActivityImpl) {
            this.f152263a = windowAndroidActivityImpl;
        }

        public void a(Context context) {
            Activity activity = this.f152264b;
            if (activity != null) {
                ((AppCompatActivity) activity).getLifecycle().removeObserver(this);
            }
            Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
            this.f152264b = a16;
            if (a16 != null) {
                ((AppCompatActivity) a16).getLifecycle().addObserver(this);
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void onPause() {
            this.f152263a.f152261i = true;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            this.f152263a.f152260h = false;
            this.f152263a.f152261i = false;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            this.f152263a.f152260h = false;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop() {
            this.f152263a.f152260h = true;
            this.f152263a.f152261i = true;
        }
    }

    public void b(Configuration configuration) {
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public Context cloneContext() {
        return this.f152253a;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public com.tencent.luggage.wxa.wj.d createFullscreenHandler(d.a aVar) {
        return new com.tencent.luggage.wxa.xj.c(this, aVar);
    }

    @Override // com.tencent.luggage.wxa.wj.f
    public boolean forceLightMode() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public final Context getContext() {
        return this.f152253a;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public /* synthetic */ void getLocationInWindow(View view, int[] iArr) {
        o41.a.a(this, view, iArr);
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public c.b getNavigationBar() {
        int b16 = f.b(getContext());
        if (b16 <= 0) {
            return null;
        }
        c.b bVar = new c.b();
        bVar.f144266a = b16;
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public Rect getSafeAreaInsets() {
        boolean z16;
        Rect rect;
        boolean z17;
        boolean z18;
        boolean z19;
        long a16 = w0.a();
        int i3 = -1;
        try {
            Activity j3 = j();
            if (j3 == null) {
                w.b("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
                long a17 = w0.a() - a16;
                Object[] objArr = new Object[3];
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                objArr[0] = Boolean.valueOf(z19);
                objArr[1] = -1;
                objArr[2] = Long.valueOf(a17);
                w.d("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, rotation:%d cost:%dms", objArr);
                return null;
            }
            if (j3.getWindow() == null) {
                w.b("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
                long a18 = w0.a() - a16;
                Object[] objArr2 = new Object[3];
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                objArr2[0] = Boolean.valueOf(z18);
                objArr2[1] = -1;
                objArr2[2] = Long.valueOf(a18);
                w.d("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, rotation:%d cost:%dms", objArr2);
                return null;
            }
            i3 = com.tencent.luggage.wxa.xj.a.a(j3).getRotation();
            synchronized (this.f152262j) {
                rect = this.f152262j[i3];
                if (rect == null) {
                    rect = a(j3, i3);
                    this.f152262j[i3] = rect;
                }
            }
            long a19 = w0.a() - a16;
            Object[] objArr3 = new Object[3];
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z17 = true;
            } else {
                z17 = false;
            }
            objArr3[0] = Boolean.valueOf(z17);
            objArr3[1] = Integer.valueOf(i3);
            objArr3[2] = Long.valueOf(a19);
            w.d("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, rotation:%d cost:%dms", objArr3);
            return rect;
        } catch (Throwable th5) {
            long a26 = w0.a() - a16;
            Object[] objArr4 = new Object[3];
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr4[0] = Boolean.valueOf(z16);
            objArr4[1] = Integer.valueOf(i3);
            objArr4[2] = Long.valueOf(a26);
            w.d("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets forMainThread:%b, rotation:%d cost:%dms", objArr4);
            throw th5;
        }
    }

    @Override // com.tencent.luggage.wxa.wj.f
    public float getScale() {
        return 1.0f;
    }

    @Override // com.tencent.luggage.wxa.wj.f
    public c.C6887c getStatusBar() {
        int b16;
        int i3;
        WindowInsets p16 = p();
        if (p16 != null) {
            b16 = p16.getStableInsetTop();
        } else {
            b16 = l.f126905a.b(getContext());
        }
        c.C6887c c6887c = new c.C6887c();
        c6887c.f144267a = b16;
        if (j() != null) {
            if (g.h(j())) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            c6887c.f144268b = i3;
        }
        return c6887c;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public DisplayMetrics getVDisplayMetrics() {
        DisplayMetrics k3 = k();
        this.f152257e = k3;
        return k3;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public ViewGroup.LayoutParams getWindowLayoutParams(com.tencent.luggage.wxa.ic.g gVar) {
        com.tencent.luggage.wxa.il.g K = gVar.K();
        if ((K instanceof com.tencent.luggage.wxa.il.c) && !gVar.y0()) {
            return ((com.tencent.luggage.wxa.il.c) K).getWxaLayoutParams();
        }
        return gVar.K().getLayoutParams();
    }

    public boolean i() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public boolean isInMultiWindowMode() {
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        Activity j3 = j();
        if (e.f141559a || e.f141565g) {
            Objects.requireNonNull(j3);
        }
        if (j3 != null) {
            isInMultiWindowMode = j3.isInMultiWindowMode();
            if (!isInMultiWindowMode) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.wj.f
    public final boolean isLargeScreenWindow() {
        return b0.c(getContext());
    }

    public final Activity j() {
        return com.tencent.luggage.wxa.bo.a.a(this.f152253a);
    }

    public final DisplayMetrics k() {
        Display defaultDisplay;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        int navigationBars;
        Insets insets;
        int i3;
        WindowInsetsCompat rootWindowInsets;
        if (j() != null) {
            defaultDisplay = com.tencent.luggage.wxa.xj.a.a(j());
        } else {
            defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (j() != null && (rootWindowInsets = ViewCompat.getRootWindowInsets(j().getWindow().getDecorView())) != null) {
            defaultDisplay.getRealMetrics(displayMetrics);
            displayMetrics.heightPixels -= rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        } else if (Build.VERSION.SDK_INT >= 30) {
            defaultDisplay.getRealMetrics(displayMetrics);
            currentWindowMetrics = l().getCurrentWindowMetrics();
            windowInsets = currentWindowMetrics.getWindowInsets();
            navigationBars = WindowInsets.Type.navigationBars();
            insets = windowInsets.getInsets(navigationBars);
            i3 = insets.bottom;
            displayMetrics.heightPixels -= i3;
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public final WindowManager l() {
        return (WindowManager) ContextCompat.getSystemService(this.f152253a, WindowManager.class);
    }

    public final View m() {
        Window window;
        Activity j3 = j();
        if (j3 == null || (window = j3.getWindow()) == null) {
            return null;
        }
        return window.getDecorView();
    }

    @Override // com.tencent.luggage.wxa.wj.c
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.xj.d getOrientationHandler() {
        com.tencent.luggage.wxa.xj.d dVar = this.f152255c;
        if (dVar == null || ((dVar instanceof com.tencent.luggage.wxa.xj.e) && ((com.tencent.luggage.wxa.xj.e) dVar).b() != j())) {
            com.tencent.luggage.wxa.xj.d dVar2 = this.f152255c;
            if (dVar2 != null) {
                dVar2.release();
            }
            this.f152255c = new com.tencent.luggage.wxa.xj.e(this);
        }
        return this.f152255c;
    }

    public final WindowInsets p() {
        Activity j3 = j();
        if (j3 != null) {
            WindowInsets a16 = k.a(j3);
            this.f152256d = a16;
            return a16;
        }
        WindowInsets windowInsets = this.f152256d;
        if (windowInsets != null) {
            return windowInsets;
        }
        return null;
    }

    public boolean q() {
        if (j() != null && this.f152261i) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (j() != null && this.f152260h) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public boolean runInStandaloneTask() {
        return false;
    }

    public final void s() {
        boolean b16 = c0.b();
        synchronized (this.f152262j) {
            for (int i3 = 0; i3 <= 3; i3++) {
                try {
                    this.f152262j[i3] = null;
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (b16) {
                getSafeAreaInsets();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public void setWindowBackgroundColor(int i3, com.tencent.luggage.wxa.ic.g gVar) {
        boolean z16;
        ColorDrawable colorDrawable;
        if (i3 != 0 && (i3 >> 24) == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Activity j3 = j();
        if (j3 == null) {
            return;
        }
        Window window = j3.getWindow();
        if (z16) {
            colorDrawable = new ColorDrawable(0);
        } else {
            colorDrawable = new ColorDrawable(i3);
        }
        window.setBackgroundDrawable(colorDrawable);
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public void setWindowDescription(c.a aVar) {
        if (j() != null && aVar != null) {
            try {
                j().setTaskDescription(n.a(aVar));
            } catch (Exception e16) {
                w.b("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", e16);
                try {
                    j().setTaskDescription(n.a(new c.a(aVar.c(), aVar.a(), -16777216)));
                } catch (Exception e17) {
                    w.b("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try2 e=%s", e17);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public void setWindowLayoutParams(h hVar, com.tencent.luggage.wxa.ic.g gVar) {
        com.tencent.luggage.wxa.il.g K = gVar.K();
        if ((K instanceof com.tencent.luggage.wxa.il.c) && !gVar.y0()) {
            ((com.tencent.luggage.wxa.il.c) K).setWxaLayoutParams(hVar);
            return;
        }
        gVar.K().setLayoutParams(hVar);
        gVar.K().setScaleX(hVar.a());
        gVar.K().setScaleY(hVar.a());
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public boolean shouldInLargeScreenCompatMode() {
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(com.tencent.luggage.wxa.wj.c cVar) {
        if (cVar == null) {
            return -1;
        }
        if (this == cVar) {
            return 0;
        }
        return ((cVar instanceof WindowAndroidActivityImpl) && j() == ((WindowAndroidActivityImpl) cVar).j()) ? 0 : -1;
    }

    public static WindowAndroidActivityImpl b(com.tencent.luggage.wxa.wj.c cVar) {
        if (cVar != null && (cVar instanceof WindowAndroidActivityImpl)) {
            return (WindowAndroidActivityImpl) cVar;
        }
        return null;
    }

    public final void a(Context context) {
        if (this.f152253a == context) {
            return;
        }
        if (i()) {
            w.d("Luggage.WXA.WindowAndroidActivityImpl", "resetContext, this:%s, new:%s, old:%s, stack:%s", getClass().getName(), context, this.f152253a, Log.getStackTraceString(new Throwable()));
        }
        this.f152253a = context;
        this.f152254b = a.C7063a.a(j());
        getOrientationHandler();
        p();
        this.f152257e = null;
        this.f152261i = false;
        this.f152260h = false;
        this.f152259g.a(context);
    }

    public final DisplayMetrics a(int i3, int i16) {
        DisplayMetrics displayMetrics = this.f152257e;
        if (displayMetrics == null) {
            displayMetrics = k();
            this.f152257e = displayMetrics;
        }
        Objects.requireNonNull(displayMetrics);
        if (i3 > 0 && i16 > 0) {
            displayMetrics.widthPixels = i3;
            displayMetrics.heightPixels = i16;
        }
        return displayMetrics;
    }

    public final void a(Configuration configuration) {
        if (n.a(getContext().getResources().getConfiguration(), configuration)) {
            com.tencent.luggage.wxa.xj.b bVar = this.f152258f;
            if (bVar != null) {
                bVar.a();
            } else {
                this.f152258f = new com.tencent.luggage.wxa.xj.b(new Function0() { // from class: com.tencent.mm.plugin.appbrand.platform.window.activity.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WindowAndroidActivityImpl.this.m();
                    }
                }, new Runnable() { // from class: com.tencent.mm.plugin.appbrand.platform.window.activity.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindowAndroidActivityImpl.this.s();
                    }
                });
            }
            this.f152258f.d();
        }
        getContext().getResources().getConfiguration().updateFrom(configuration);
        getOrientationHandler().onConfigurationChanged(configuration);
        this.f152254b.a(configuration);
        b(configuration);
    }

    @Override // com.tencent.luggage.wxa.wj.c
    public void setSoftOrientation(String str) {
    }

    public final Rect a(Activity activity, int i3) {
        int i16;
        int i17;
        WindowInsets a16;
        DisplayCutout displayCutout;
        int safeInsetLeft;
        int safeInsetTop;
        int safeInsetRight;
        int safeInsetBottom;
        if (ViewCompat.isLaidOut(activity.getWindow().getDecorView())) {
            View decorView = activity.getWindow().getDecorView();
            i16 = decorView.getWidth();
            i17 = decorView.getHeight();
        } else {
            i16 = getVDisplayMetrics().widthPixels;
            i17 = getVDisplayMetrics().heightPixels;
        }
        if (!this.f152254b.a()) {
            return new Rect(0, 0, i16, i17);
        }
        if (Build.VERSION.SDK_INT >= 28 && (a16 = ((com.tencent.luggage.wxa.xj.l) this.f152254b).a(i3)) != null) {
            displayCutout = a16.getDisplayCutout();
            if (displayCutout != null) {
                safeInsetLeft = displayCutout.getSafeInsetLeft();
                safeInsetTop = displayCutout.getSafeInsetTop();
                safeInsetRight = displayCutout.getSafeInsetRight();
                safeInsetBottom = displayCutout.getSafeInsetBottom();
                return new Rect(safeInsetLeft, safeInsetTop, i16 - safeInsetRight, i17 - safeInsetBottom);
            }
            w.b("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
        }
        int b16 = this.f152254b.b();
        if (i3 == 0) {
            return new Rect(0, b16, i16, i17);
        }
        if (i3 == 1) {
            return new Rect(b16, 0, i16, i17);
        }
        if (i3 == 2) {
            return new Rect(0, 0, i16, i17 - b16);
        }
        if (i3 != 3) {
            return new Rect(0, 0, i16, i17);
        }
        return new Rect(0, 0, i16 - b16, i17);
    }
}
