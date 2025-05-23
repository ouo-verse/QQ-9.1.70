package com.tencent.mm.plugin.appbrand.widget.input;

import android.R;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.lo.k;
import com.tencent.luggage.wxa.ol.b1;
import com.tencent.luggage.wxa.tn.w;

/* loaded from: classes9.dex */
public class KeyboardHeightProvider {

    /* renamed from: a, reason: collision with root package name */
    public b1 f152372a;

    /* renamed from: b, reason: collision with root package name */
    public View f152373b;

    /* renamed from: e, reason: collision with root package name */
    public View f152376e;

    /* renamed from: f, reason: collision with root package name */
    public Activity f152377f;

    /* renamed from: g, reason: collision with root package name */
    public LifecycleObserver f152378g;

    /* renamed from: h, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f152379h;

    /* renamed from: i, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f152380i;

    /* renamed from: l, reason: collision with root package name */
    public int f152383l;

    /* renamed from: m, reason: collision with root package name */
    public int f152384m;

    /* renamed from: n, reason: collision with root package name */
    public int f152385n;

    /* renamed from: o, reason: collision with root package name */
    public int f152386o;

    /* renamed from: c, reason: collision with root package name */
    public Rect f152374c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public Rect f152375d = new Rect();

    /* renamed from: j, reason: collision with root package name */
    public boolean f152381j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f152382k = true;

    /* loaded from: classes9.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (KeyboardHeightProvider.this.f152373b != null) {
                KeyboardHeightProvider.this.c();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (KeyboardHeightProvider.this.f152373b != null) {
                int i3 = KeyboardHeightProvider.this.f152375d.bottom;
                KeyboardHeightProvider.this.f152376e.getWindowVisibleDisplayFrame(KeyboardHeightProvider.this.f152375d);
                if (KeyboardHeightProvider.this.f152375d.bottom != i3) {
                    w.d("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", Integer.valueOf(i3), KeyboardHeightProvider.this.f152375d.toShortString());
                    KeyboardHeightProvider.this.c();
                }
            }
        }
    }

    public KeyboardHeightProvider(Activity activity) {
        this.f152377f = activity;
        d();
        this.f152376e = activity.findViewById(R.id.content);
        this.f152379h = new a();
        this.f152380i = new b();
        int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.f152385n = Resources.getSystem().getDimensionPixelSize(identifier);
        }
        this.f152386o = com.tencent.luggage.wxa.kn.a.a(activity, 96);
    }

    public final void e() {
        WindowInsets a16 = k.a(this.f152377f);
        if (a16 != null) {
            this.f152385n = a16.getStableInsetBottom();
        }
    }

    public void f() {
        d();
        if (this.f152376e != null) {
            w.d("MicroMsg.KeyboardHeightProvider", "start: %s, %s", Boolean.valueOf(this.f152381j), this.f152376e.getWindowToken());
            if (!this.f152381j && this.f152376e.getWindowToken() != null && !this.f152377f.isFinishing()) {
                this.f152381j = true;
                LinearLayout linearLayout = new LinearLayout(this.f152377f);
                this.f152373b = linearLayout;
                linearLayout.setBackgroundColor(0);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
                layoutParams.width = 0;
                layoutParams.height = -1;
                layoutParams.gravity = 8388659;
                layoutParams.softInputMode = 16;
                layoutParams.setTitle("KeyboardWindow@" + hashCode());
                try {
                    this.f152377f.getWindowManager().addView(this.f152373b, layoutParams);
                } catch (Exception e16) {
                    w.a("MicroMsg.KeyboardHeightProvider", e16, "", new Object[0]);
                    this.f152381j = false;
                    this.f152373b = null;
                }
                if (this.f152381j) {
                    this.f152373b.getViewTreeObserver().addOnGlobalLayoutListener(this.f152379h);
                    this.f152376e.getViewTreeObserver().addOnGlobalLayoutListener(this.f152380i);
                }
                this.f152383l = 0;
                this.f152384m = 0;
                if ((this.f152377f.getWindow().getAttributes().softInputMode & 240) != 48) {
                    w.f("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
                    this.f152382k = false;
                } else {
                    this.f152382k = true;
                }
            }
        }
    }

    public void g() {
        if (this.f152378g != null) {
            ComponentCallbacks2 componentCallbacks2 = this.f152377f;
            if (componentCallbacks2 instanceof LifecycleOwner) {
                ((LifecycleOwner) componentCallbacks2).getLifecycle().removeObserver(this.f152378g);
            }
        }
    }

    public void a(b1 b1Var) {
        this.f152372a = b1Var;
    }

    public void b() {
        View view;
        w.d("MicroMsg.KeyboardHeightProvider", "close: ");
        this.f152376e.getViewTreeObserver().removeOnGlobalLayoutListener(this.f152380i);
        if (this.f152381j && (view = this.f152373b) != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f152379h);
            try {
                this.f152377f.getWindowManager().removeView(this.f152373b);
            } catch (Exception e16) {
                w.a("MicroMsg.KeyboardHeightProvider", e16, "", new Object[0]);
            }
            this.f152373b = null;
        }
        this.f152381j = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r0 = r9.f152376e.getRootWindowInsets().getDisplayCutout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r0 = r0.getSafeInsetBottom();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        int i3;
        boolean z16;
        DisplayCutout displayCutout;
        int safeInsetBottom;
        e();
        this.f152373b.getWindowVisibleDisplayFrame(this.f152374c);
        this.f152376e.getWindowVisibleDisplayFrame(this.f152375d);
        int i16 = this.f152374c.bottom;
        if (i16 > this.f152383l) {
            this.f152383l = i16;
        }
        int i17 = this.f152375d.bottom;
        if (i17 > this.f152384m) {
            this.f152384m = i17;
        }
        int i18 = this.f152384m;
        int i19 = this.f152383l;
        int i26 = i18 - i19;
        if (this.f152382k) {
            i3 = i17 - i16;
            if (com.tencent.luggage.wxa.aa.a.c(28) && this.f152376e.getRootWindowInsets() != null && displayCutout != null && safeInsetBottom == i3) {
                w.d("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: has cutout bottom, %s", Integer.valueOf(safeInsetBottom));
                i3 -= safeInsetBottom;
            }
            int i27 = this.f152385n;
            if (i3 == i27 && i27 != 0) {
                w.d("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: navigationHeight %d, %d, %d", Integer.valueOf(this.f152383l), Integer.valueOf(this.f152384m), Integer.valueOf(this.f152385n));
                i3 -= this.f152385n;
            }
            if (i3 == i26 && i26 > 0 && i26 < this.f152386o) {
                w.d("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: max bottom diff %d, %d, %d", Integer.valueOf(this.f152383l), Integer.valueOf(this.f152384m), Integer.valueOf(i26));
                i3 -= i26;
            }
            if (i3 == 0 && this.f152384m - this.f152375d.bottom > this.f152386o) {
                w.f("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: adjust nothing not work!");
                i3 = this.f152384m - this.f152375d.bottom;
            } else {
                z16 = false;
                w.d("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: %s, %s", this.f152374c.toShortString(), this.f152375d.toShortString());
                a(i3, z16);
            }
        } else {
            i3 = i19 - i16;
        }
        z16 = true;
        w.d("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: %s, %s", this.f152374c.toShortString(), this.f152375d.toShortString());
        a(i3, z16);
    }

    public final void d() {
        if ((this.f152377f.getWindow().getAttributes().softInputMode & 240) != 48) {
            w.f("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
            this.f152382k = false;
        } else {
            this.f152382k = true;
        }
    }

    public final void a(int i3, boolean z16) {
        b1 b1Var = this.f152372a;
        if (b1Var != null) {
            b1Var.a(i3, z16);
        }
    }

    public void a() {
        ComponentCallbacks2 componentCallbacks2 = this.f152377f;
        if (componentCallbacks2 instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) componentCallbacks2).getLifecycle();
            LifecycleObserver lifecycleObserver = new LifecycleObserver() { // from class: com.tencent.mm.plugin.appbrand.widget.input.KeyboardHeightProvider.3
                @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                public void onPaused() {
                    KeyboardHeightProvider.this.b();
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                public void onResumed() {
                    KeyboardHeightProvider.this.f();
                }
            };
            this.f152378g = lifecycleObserver;
            lifecycle.addObserver(lifecycleObserver);
        }
    }
}
