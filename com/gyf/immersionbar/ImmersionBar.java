package com.gyf.immersionbar;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cooperation.qzone.util.WnsNetworkConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes2.dex */
public final class ImmersionBar implements ImmersionCallback {
    private ViewGroup C;
    private ImmersionBar D;
    private boolean E;
    private boolean F;
    private boolean G;
    private b H;
    private com.gyf.immersionbar.a I;
    private int J;
    private int K;
    private int L;
    private f M;
    private final Map<String, b> N;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f35994d;

    /* renamed from: e, reason: collision with root package name */
    private Fragment f35995e;

    /* renamed from: f, reason: collision with root package name */
    private android.app.Fragment f35996f;

    /* renamed from: h, reason: collision with root package name */
    private Dialog f35997h;

    /* renamed from: i, reason: collision with root package name */
    private Window f35998i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f35999m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36004a;

        static {
            int[] iArr = new int[BarHide.values().length];
            f36004a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36004a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36004a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36004a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmersionBar(Activity activity) {
        this.E = false;
        this.F = false;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.N = new HashMap();
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.f35994d = activity;
        K(activity.getWindow());
    }

    private static o A() {
        return o.f();
    }

    @TargetApi(14)
    public static int B(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r4.C.getWindowInsetsController();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F() {
        WindowInsetsController windowInsetsController;
        int statusBars;
        int navigationBars;
        int statusBars2;
        int navigationBars2;
        int statusBars3;
        int navigationBars3;
        if (Build.VERSION.SDK_INT >= 30 && windowInsetsController != null) {
            int i3 = a.f36004a[this.H.F.ordinal()];
            if (i3 == 1) {
                statusBars = WindowInsets.Type.statusBars();
                windowInsetsController.hide(statusBars);
                navigationBars = WindowInsets.Type.navigationBars();
                windowInsetsController.hide(navigationBars);
            } else if (i3 == 2) {
                statusBars2 = WindowInsets.Type.statusBars();
                windowInsetsController.hide(statusBars2);
            } else if (i3 == 3) {
                navigationBars2 = WindowInsets.Type.navigationBars();
                windowInsetsController.hide(navigationBars2);
            } else if (i3 == 4) {
                statusBars3 = WindowInsets.Type.statusBars();
                windowInsetsController.show(statusBars3);
                navigationBars3 = WindowInsets.Type.navigationBars();
                windowInsetsController.show(navigationBars3);
            }
            windowInsetsController.setSystemBarsBehavior(2);
        }
    }

    private int G(int i3) {
        if (Build.VERSION.SDK_INT >= 30) {
            return i3;
        }
        int i16 = a.f36004a[this.H.F.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        i3 |= 0;
                    }
                } else {
                    i3 |= 514;
                }
            } else {
                i3 |= 1028;
            }
        } else {
            i3 |= WnsNetworkConst.WRITE_FAIL;
        }
        return i3 | 4096;
    }

    @RequiresApi(api = 21)
    private int I(int i3) {
        if (!this.Q) {
            this.H.f36023f = this.f35998i.getNavigationBarColor();
        }
        int i16 = i3 | 1024;
        b bVar = this.H;
        if (bVar.D && bVar.f36022e0) {
            i16 |= 512;
        }
        this.f35998i.clearFlags(67108864);
        if (this.I.l()) {
            this.f35998i.clearFlags(134217728);
        }
        this.f35998i.addFlags(Integer.MIN_VALUE);
        b bVar2 = this.H;
        if (bVar2.M) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f35998i.setStatusBarContrastEnforced(false);
            }
            Window window = this.f35998i;
            b bVar3 = this.H;
            window.setStatusBarColor(ColorUtils.blendARGB(bVar3.f36019d, bVar3.N, bVar3.f36026h));
        } else {
            this.f35998i.setStatusBarColor(ColorUtils.blendARGB(bVar2.f36019d, 0, bVar2.f36026h));
        }
        b bVar4 = this.H;
        if (bVar4.f36022e0) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f35998i.setNavigationBarContrastEnforced(false);
            }
            Window window2 = this.f35998i;
            b bVar5 = this.H;
            window2.setNavigationBarColor(ColorUtils.blendARGB(bVar5.f36021e, bVar5.P, bVar5.f36030m));
        } else {
            this.f35998i.setNavigationBarColor(bVar4.f36023f);
        }
        return i16;
    }

    private void J() {
        this.f35998i.addFlags(67108864);
        g0();
        if (this.I.l() || OSUtils.isEMUI3_x()) {
            b bVar = this.H;
            if (bVar.f36022e0 && bVar.f36024f0) {
                this.f35998i.addFlags(134217728);
            } else {
                this.f35998i.clearFlags(134217728);
            }
            if (this.J == 0) {
                this.J = this.I.d();
            }
            if (this.K == 0) {
                this.K = this.I.g();
            }
            f0();
        }
    }

    private void K(Window window) {
        this.f35998i = window;
        this.H = new b();
        ViewGroup viewGroup = (ViewGroup) this.f35998i.getDecorView();
        this.f35999m = viewGroup;
        this.C = (ViewGroup) viewGroup.findViewById(R.id.content);
    }

    public static boolean N() {
        if (!OSUtils.isMIUI6Later() && Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return true;
    }

    public static boolean O() {
        if (!OSUtils.isMIUI6Later()) {
            OSUtils.isFlymeOS4Later();
            return true;
        }
        return true;
    }

    private void T() {
        q();
        if (!this.E && OSUtils.isEMUI3_x()) {
            p();
        }
    }

    private void V() {
        if (Build.VERSION.SDK_INT >= 30) {
            b0();
            X();
        }
    }

    private int W(int i3) {
        if (Build.VERSION.SDK_INT >= 26 && this.H.H) {
            return i3 | 16;
        }
        return i3;
    }

    @RequiresApi(api = 30)
    private void X() {
        WindowInsetsController windowInsetsController;
        windowInsetsController = this.C.getWindowInsetsController();
        if (this.H.H) {
            windowInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            windowInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    private void Y(int i3, int i16, int i17, int i18) {
        ViewGroup viewGroup = this.C;
        if (viewGroup != null) {
            viewGroup.setPadding(i3, i16, i17, i18);
        }
        this.T = i3;
        this.U = i16;
        this.V = i17;
        this.W = i18;
    }

    private void Z() {
        if (OSUtils.isMIUI6Later()) {
            SpecialBarFontUtils.setMIUIBarDark(this.f35998i, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.H.G);
            b bVar = this.H;
            if (bVar.f36022e0) {
                SpecialBarFontUtils.setMIUIBarDark(this.f35998i, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", bVar.H);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            b bVar2 = this.H;
            int i3 = bVar2.Z;
            if (i3 != 0) {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.f35994d, i3);
            } else {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.f35994d, bVar2.G);
            }
        }
    }

    private int a0(int i3) {
        if (this.H.G) {
            return i3 | 8192;
        }
        return i3;
    }

    @RequiresApi(api = 30)
    private void b0() {
        WindowInsetsController windowInsetsController;
        windowInsetsController = this.C.getWindowInsetsController();
        if (!this.H.G) {
            windowInsetsController.setSystemBarsAppearance(0, 8);
            return;
        }
        if (this.f35998i != null) {
            j0(8192);
        }
        windowInsetsController.setSystemBarsAppearance(8, 8);
    }

    public static void c0(Activity activity, int i3, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(com.tencent.mobileqq.R.id.f165791xl3);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i3) {
                    view.setTag(com.tencent.mobileqq.R.id.f165791xl3, Integer.valueOf(i3));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, 0);
                    }
                    layoutParams.height = i3;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public static void d0(Activity activity, final int i3, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        for (final View view : viewArr) {
            if (view != null) {
                final Integer num = (Integer) view.getTag(com.tencent.mobileqq.R.id.f165791xl3);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i3) {
                    view.setTag(com.tencent.mobileqq.R.id.f165791xl3, Integer.valueOf(i3));
                    final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    }
                    int i16 = layoutParams.height;
                    if (i16 != -2 && i16 != -1) {
                        layoutParams.height = i16 + (i3 - num.intValue());
                        view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i3) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                    } else {
                        view.post(new Runnable() { // from class: com.gyf.immersionbar.ImmersionBar.1
                            @Override // java.lang.Runnable
                            public void run() {
                                layoutParams.height = (view.getHeight() + i3) - num.intValue();
                                View view2 = view;
                                view2.setPadding(view2.getPaddingLeft(), (view.getPaddingTop() + i3) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                                view.setLayoutParams(layoutParams);
                            }
                        });
                    }
                }
            }
        }
    }

    private void e() {
        boolean z16;
        b bVar = this.H;
        int blendARGB = ColorUtils.blendARGB(bVar.f36019d, bVar.N, bVar.f36026h);
        b bVar2 = this.H;
        boolean z17 = true;
        if (bVar2.I && blendARGB != 0) {
            if (blendARGB > -4539718) {
                z16 = true;
            } else {
                z16 = false;
            }
            h0(z16, bVar2.K);
        }
        b bVar3 = this.H;
        int blendARGB2 = ColorUtils.blendARGB(bVar3.f36021e, bVar3.P, bVar3.f36030m);
        b bVar4 = this.H;
        if (bVar4.J && blendARGB2 != 0) {
            if (blendARGB2 <= -4539718) {
                z17 = false;
            }
            P(z17, bVar4.L);
        }
    }

    public static void e0(Activity activity, int i3, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(com.tencent.mobileqq.R.id.f165791xl3);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i3) {
                    view.setTag(com.tencent.mobileqq.R.id.f165791xl3, Integer.valueOf(i3));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i3) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private void f() {
        if (this.f35994d != null) {
            f fVar = this.M;
            if (fVar != null) {
                fVar.a();
                this.M = null;
            }
            e.b().d(this);
            k.a().c(this.H.f36029i0);
        }
    }

    private void f0() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f35999m;
        int i3 = d.f36032b;
        View findViewById = viewGroup.findViewById(i3);
        if (findViewById == null) {
            findViewById = new View(this.f35994d);
            findViewById.setId(i3);
            this.f35999m.addView(findViewById);
        }
        if (this.I.m()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.I.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.I.g(), -1);
            layoutParams.gravity = 8388613;
        }
        findViewById.setLayoutParams(layoutParams);
        b bVar = this.H;
        findViewById.setBackgroundColor(ColorUtils.blendARGB(bVar.f36021e, bVar.P, bVar.f36030m));
        b bVar2 = this.H;
        if (bVar2.f36022e0 && bVar2.f36024f0 && !bVar2.E) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public static boolean g(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (((childAt instanceof DrawerLayout) && g(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void g0() {
        ViewGroup viewGroup = this.f35999m;
        int i3 = d.f36031a;
        View findViewById = viewGroup.findViewById(i3);
        if (findViewById == null) {
            findViewById = new View(this.f35994d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.I.j());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(i3);
            this.f35999m.addView(findViewById);
        }
        b bVar = this.H;
        if (bVar.M) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(bVar.f36019d, bVar.N, bVar.f36026h));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(bVar.f36019d, 0, bVar.f36026h));
        }
    }

    private void h() {
        if (this.D == null) {
            this.D = m0(this.f35994d);
        }
        ImmersionBar immersionBar = this.D;
        if (immersionBar != null && !immersionBar.Q) {
            immersionBar.H();
        }
    }

    private void i() {
        if (!this.E) {
            if (this.H.f36018c0) {
                if (this.M == null) {
                    this.M = new f(this);
                }
                this.M.c(this.H.f36020d0);
                return;
            } else {
                f fVar = this.M;
                if (fVar != null) {
                    fVar.b();
                    return;
                }
                return;
            }
        }
        ImmersionBar immersionBar = this.D;
        if (immersionBar != null) {
            if (immersionBar.H.f36018c0) {
                if (immersionBar.M == null) {
                    immersionBar.M = new f(immersionBar);
                }
                ImmersionBar immersionBar2 = this.D;
                immersionBar2.M.c(immersionBar2.H.f36020d0);
                return;
            }
            f fVar2 = immersionBar.M;
            if (fVar2 != null) {
                fVar2.b();
            }
        }
    }

    private void i0() {
        if (this.H.Q.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.H.Q.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer valueOf = Integer.valueOf(this.H.f36019d);
                Integer valueOf2 = Integer.valueOf(this.H.N);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.H.R - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.H.f36026h));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.H.R));
                    }
                }
            }
        }
    }

    private void j() {
        int i3;
        if (this.H.Y) {
            i3 = this.I.j();
        } else {
            i3 = 0;
        }
        int i16 = this.P;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    c0(this.f35994d, i3, this.H.X);
                    return;
                }
                return;
            }
            e0(this.f35994d, i3, this.H.W);
            return;
        }
        d0(this.f35994d, i3, this.H.W);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 28 && !this.Q) {
            try {
                WindowManager.LayoutParams attributes = this.f35998i.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                this.f35998i.setAttributes(attributes);
            } catch (Exception unused) {
            }
        }
    }

    private void k0() {
        com.gyf.immersionbar.a aVar = new com.gyf.immersionbar.a(this.f35994d);
        this.I = aVar;
        if (!this.Q || this.R) {
            this.L = aVar.a();
        }
    }

    private void l0() {
        e();
        if (!this.Q || this.E) {
            k0();
        }
        ImmersionBar immersionBar = this.D;
        if (immersionBar != null) {
            if (this.E) {
                immersionBar.H = this.H;
            }
            if (this.G && immersionBar.S) {
                immersionBar.H.f36018c0 = false;
            }
        }
    }

    private void m() {
        if (!OSUtils.isEMUI3_x()) {
            n();
        } else {
            o();
        }
        j();
    }

    public static ImmersionBar m0(@NonNull Activity activity) {
        return A().b(activity, false);
    }

    private void n() {
        int i3;
        if (g(this.f35999m.findViewById(R.id.content))) {
            Y(0, 0, 0, 0);
            return;
        }
        if (this.H.V && this.P == 4) {
            i3 = this.I.j();
        } else {
            i3 = 0;
        }
        if (this.H.f36017b0) {
            i3 = this.I.j() + this.L;
        }
        Y(0, i3, 0, 0);
    }

    public static ImmersionBar n0(@NonNull Fragment fragment) {
        return A().c(fragment, false);
    }

    private void o() {
        if (this.H.f36017b0) {
            this.R = true;
            this.C.post(this);
        } else {
            this.R = false;
            T();
        }
    }

    private void p() {
        View findViewById = this.f35999m.findViewById(d.f36032b);
        b bVar = this.H;
        if (bVar.f36022e0 && bVar.f36024f0) {
            if (findViewById != null) {
                e.b().a(this);
                e.b().c(this.f35994d.getApplication());
                return;
            }
            return;
        }
        e.b().d(this);
        findViewById.setVisibility(8);
    }

    private void q() {
        int i3;
        int i16;
        int i17;
        if (g(this.f35999m.findViewById(R.id.content))) {
            Y(0, 0, 0, 0);
            return;
        }
        if (this.H.V && this.P == 4) {
            i3 = this.I.j();
        } else {
            i3 = 0;
        }
        if (this.H.f36017b0) {
            i3 = this.I.j() + this.L;
        }
        if (this.I.l()) {
            b bVar = this.H;
            if (bVar.f36022e0 && bVar.f36024f0) {
                if (!bVar.D) {
                    if (this.I.m()) {
                        i17 = this.I.d();
                        i16 = 0;
                    } else {
                        i16 = this.I.g();
                        i17 = 0;
                    }
                } else {
                    i16 = 0;
                    i17 = 0;
                }
                if (this.H.E) {
                    if (this.I.m()) {
                        i17 = 0;
                    } else {
                        i16 = 0;
                    }
                } else if (!this.I.m()) {
                    i16 = this.I.g();
                }
                Y(0, i3, i16, i17);
            }
        }
        i16 = 0;
        i17 = 0;
        Y(0, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment C() {
        return this.f35995e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Window D() {
        return this.f35998i;
    }

    public ImmersionBar E(BarHide barHide) {
        boolean z16;
        this.H.F = barHide;
        if (OSUtils.isEMUI3_x()) {
            b bVar = this.H;
            BarHide barHide2 = bVar.F;
            if (barHide2 != BarHide.FLAG_HIDE_NAVIGATION_BAR && barHide2 != BarHide.FLAG_HIDE_BAR) {
                z16 = false;
            } else {
                z16 = true;
            }
            bVar.E = z16;
        }
        return this;
    }

    public void H() {
        if (this.H.f36027h0) {
            l0();
            U();
            m();
            i();
            i0();
            this.Q = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M() {
        return this.F;
    }

    public ImmersionBar P(boolean z16, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.H.H = z16;
        if (z16 && !N()) {
            this.H.f36030m = f16;
        } else {
            b bVar = this.H;
            bVar.f36030m = bVar.C;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(Configuration configuration) {
        k0();
        if (!OSUtils.isEMUI3_x()) {
            m();
        } else if (this.Q && !this.E && this.H.f36024f0) {
            H();
        } else {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        ImmersionBar immersionBar;
        f();
        if (this.G && (immersionBar = this.D) != null) {
            b bVar = immersionBar.H;
            bVar.f36018c0 = immersionBar.S;
            if (bVar.F != BarHide.FLAG_SHOW_BAR) {
                immersionBar.U();
            }
        }
        this.Q = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        k0();
        if (!this.E && this.Q && this.H != null) {
            if (OSUtils.isEMUI3_x() && this.H.f36025g0) {
                H();
            } else if (this.H.F != BarHide.FLAG_SHOW_BAR) {
                U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        int i3 = 256;
        if (!OSUtils.isEMUI3_x()) {
            k();
            i3 = W(a0(I(256)));
            V();
        } else {
            J();
        }
        this.f35999m.setSystemUiVisibility(G(i3));
        Z();
        F();
        if (this.H.f36029i0 != null) {
            k.a().b(this.f35994d.getApplication());
        }
    }

    @Override // com.gyf.immersionbar.m
    public void a(boolean z16, NavigationBarType navigationBarType) {
        View findViewById = this.f35999m.findViewById(d.f36032b);
        if (findViewById != null) {
            this.I = new com.gyf.immersionbar.a(this.f35994d);
            int paddingBottom = this.C.getPaddingBottom();
            int paddingRight = this.C.getPaddingRight();
            if (!z16) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                if (!g(this.f35999m.findViewById(R.id.content))) {
                    if (this.J == 0) {
                        this.J = this.I.d();
                    }
                    if (this.K == 0) {
                        this.K = this.I.g();
                    }
                    if (!this.H.E) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.I.m()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.J;
                            layoutParams.height = paddingBottom;
                            if (this.H.D) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = 8388613;
                            int i3 = this.K;
                            layoutParams.width = i3;
                            if (this.H.D) {
                                i3 = 0;
                            }
                            paddingRight = i3;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    Y(0, this.C.getPaddingTop(), paddingRight, paddingBottom);
                }
            }
            paddingBottom = 0;
            paddingRight = 0;
            Y(0, this.C.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public ImmersionBar h0(boolean z16, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.H.G = z16;
        if (z16 && !O()) {
            this.H.f36026h = f16;
        } else {
            b bVar = this.H;
            bVar.Z = bVar.f36016a0;
            bVar.f36026h = bVar.f36028i;
        }
        return this;
    }

    protected void j0(int i3) {
        View decorView = this.f35998i.getDecorView();
        decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        f fVar;
        ImmersionBar immersionBar = this.D;
        if (immersionBar != null && (fVar = immersionBar.M) != null) {
            fVar.b();
            this.D.M.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.L;
    }

    @Override // java.lang.Runnable
    public void run() {
        T();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity s() {
        return this.f35994d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.gyf.immersionbar.a t() {
        if (this.I == null) {
            this.I = new com.gyf.immersionbar.a(this.f35994d);
        }
        return this.I;
    }

    public b u() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.app.Fragment v() {
        return this.f35996f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w() {
        return this.W;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmersionBar(Fragment fragment) {
        this.E = false;
        this.F = false;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.N = new HashMap();
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.E = true;
        FragmentActivity activity = fragment.getActivity();
        this.f35994d = activity;
        this.f35995e = fragment;
        h();
        K(activity.getWindow());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmersionBar(android.app.Fragment fragment) {
        this.E = false;
        this.F = false;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.N = new HashMap();
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.E = true;
        Activity activity = fragment.getActivity();
        this.f35994d = activity;
        this.f35996f = fragment;
        h();
        K(activity.getWindow());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmersionBar(DialogFragment dialogFragment) {
        this.E = false;
        this.F = false;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.N = new HashMap();
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.G = true;
        this.F = true;
        this.f35994d = dialogFragment.getActivity();
        this.f35995e = dialogFragment;
        this.f35997h = dialogFragment.getDialog();
        h();
        K(this.f35997h.getWindow());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmersionBar(android.app.DialogFragment dialogFragment) {
        this.E = false;
        this.F = false;
        this.G = false;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = null;
        this.N = new HashMap();
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.G = true;
        this.F = true;
        this.f35994d = dialogFragment.getActivity();
        this.f35996f = dialogFragment;
        this.f35997h = dialogFragment.getDialog();
        h();
        K(this.f35997h.getWindow());
    }
}
