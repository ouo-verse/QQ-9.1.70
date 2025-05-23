package com.tencent.luggage.wxa.ok;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g extends com.tencent.luggage.wxa.lo.f {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f136601a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f136602b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Window f136603c;

        public a(boolean z16, boolean z17, Window window) {
            this.f136601a = z16;
            this.f136602b = z17;
            this.f136603c = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            w.a("MicroMsg.AppBrandUIUtil", "configFullScreen(fullscreen:%b, consumeCutout:%b), onSystemUiVisibilityChange(%d)", Boolean.valueOf(this.f136601a), Boolean.valueOf(this.f136602b), Integer.valueOf(i3));
            if ((i3 & 4) == 0) {
                this.f136603c.getDecorView().setSystemUiVisibility(g.g(this.f136603c, true));
            }
        }
    }

    public static boolean a(Activity activity) {
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT >= 24 && activity != null) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                return true;
            }
        }
        return false;
    }

    public static void b(Context context, boolean z16) {
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
        if (a16 != null && a16.getWindow() != null) {
            e(a16.getWindow(), z16);
        } else {
            w.h("MicroMsg.AppBrandUIUtil", "configNavigationBar with context(%s), get NULL activity", context);
        }
    }

    public static void d(Window window, boolean z16) {
        a(window, z16, false);
    }

    public static void e(Window window, boolean z16) {
        if (z16) {
            if (com.tencent.luggage.wxa.aa.a.a(19)) {
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 2);
                return;
            } else {
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 2 | 4096);
                return;
            }
        }
        if (com.tencent.luggage.wxa.aa.a.a(19)) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-3));
        } else {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-3) & (-4097));
        }
    }

    public static void f(Window window, boolean z16) {
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(window.getDecorView());
        if (windowInsetsController == null) {
            return;
        }
        if (z16) {
            windowInsetsController.setSystemBarsBehavior(2);
            windowInsetsController.hide(WindowInsetsCompat.Type.statusBars());
        } else {
            windowInsetsController.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    public static int g(Window window, boolean z16) {
        int i3;
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z16) {
            i3 = systemUiVisibility | 1024 | 256 | 512 | 2 | 4 | 4096;
        } else {
            i3 = systemUiVisibility & (-1025) & (-257) & (-513) & (-3) & (-5) & (-4097);
        }
        w.d("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", Integer.valueOf(i3));
        return i3;
    }

    public static boolean h(Context context) {
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
        if (a16 == null) {
            return false;
        }
        try {
            if ((a16.getWindow().getAttributes().flags & 1024) != 1024) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i(Context context) {
        if (!(context instanceof Activity) || context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    public static void c(Context context, boolean z16) {
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
        if (a16 != null && a16.getWindow() != null) {
            f(a16.getWindow(), z16);
        } else {
            w.h("MicroMsg.AppBrandUIUtil", "configStatusBar with context(%s), get NULL activity", context);
        }
    }

    public static boolean a(View view) {
        Activity a16;
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT < 24 || view == null || (a16 = com.tencent.luggage.wxa.bo.a.a(view.getContext())) == null) {
            return false;
        }
        isInMultiWindowMode = a16.isInMultiWindowMode();
        return isInMultiWindowMode;
    }

    public static void a(Context context, boolean z16) {
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
        if (a16 != null && a16.getWindow() != null) {
            d(a16.getWindow(), z16);
        } else {
            w.h("MicroMsg.AppBrandUIUtil", "configFullScreen with context(%s), get NULL activity", context);
        }
    }

    public static void a(Window window, boolean z16, boolean z17) {
        if (z16) {
            window.getDecorView().setSystemUiVisibility(g(window, true));
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new a(z16, z17, window));
            window.addFlags(1024);
            if (!z17 || Build.VERSION.SDK_INT < 28) {
                return;
            }
            window.getAttributes().layoutInDisplayCutoutMode = 1;
            window.setAttributes(window.getAttributes());
            return;
        }
        window.getDecorView().setSystemUiVisibility(g(window, false));
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        try {
            window.clearFlags(1024);
        } catch (Exception e16) {
            w.a("MicroMsg.AppBrandUIUtil", e16, "[CAUGHT CRASH]", new Object[0]);
        }
    }
}
