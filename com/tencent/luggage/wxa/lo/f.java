package com.tencent.luggage.wxa.lo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsControllerCompat;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static int a(int i3, int i16, float f16) {
        float f17 = 1.0f - f16;
        return ((((int) (((i3 & 255) * f16) + ((i16 & 255) * f17))) & 255) << 0) | ((((int) ((((i3 >> 24) & 255) * f16) + (((i16 >> 24) & 255) * f17))) & 255) << 24) | ((((int) ((((i3 >> 16) & 255) * f16) + (((i16 >> 16) & 255) * f17))) & 255) << 16) | ((((int) ((((i3 >> 8) & 255) * f16) + (((i16 >> 8) & 255) * f17))) & 255) << 8);
    }

    public static int b(Context context, int i3) {
        return com.tencent.luggage.wxa.aa.k.a(context, i3);
    }

    public static boolean c(Context context) {
        if (d(context) > 0) {
            return true;
        }
        return false;
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            w.b("Luggage.LuggageUIHelper", "getRealBottomHeight, get NULL windowManager");
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point a16 = a(context);
        int max = Math.max(point.y, point.x);
        int max2 = Math.max(a16.y, a16.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom - rect.top, rect.right - rect.left);
        }
        return max2 - max;
    }

    public static int e(Context context) {
        return b(context, 25);
    }

    public static int f(Context context) {
        int b16 = b(context, -1);
        if (b16 > 0) {
            return a(context, b16);
        }
        if (context instanceof Activity) {
            Rect rect = new Rect();
            Activity activity = (Activity) context;
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = activity.getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            activity.getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height - rect.height() >= 0 && iArr[1] > 200) {
                return height - rect.height();
            }
            return rect.top;
        }
        return com.tencent.luggage.wxa.kn.a.a(context, 20);
    }

    public static void g(Context context) {
        if (context instanceof Activity) {
            b(((Activity) context).getWindow());
        }
    }

    public static int a(Context context, int i3) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i16 = rect.top;
        if (i16 <= i3) {
            return i3;
        }
        w.h("Luggage.LuggageUIHelper", "[fixStatusBarHeight] top:%s statusHeight:%s", Integer.valueOf(i16), Integer.valueOf(i3));
        return 0;
    }

    public static void b(Window window) {
        if (window == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public static boolean b(Window window, boolean z16) {
        if (window == null || window.getDecorView() == null || !a()) {
            return false;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z16 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        return true;
    }

    public static void a(Window window) {
        if (window == null) {
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(0);
        if (i3 >= 28) {
            window.setNavigationBarDividerColor(0);
        }
    }

    public static int b(Context context) {
        int identifier;
        if (!c(context) || (identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return Resources.getSystem().getDimensionPixelSize(identifier);
    }

    public static void a(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        try {
            if (activity.getWindow() == null) {
                return;
            }
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setStatusBarColor(i3);
        } catch (Throwable th5) {
            w.a("Luggage.LuggageUIHelper", th5, "", new Object[0]);
        }
    }

    public static boolean a() {
        return !com.tencent.luggage.wxa.p003do.d.b();
    }

    public static void a(Window window, boolean z16) {
        if (window == null || window.getDecorView() == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z16 ? systemUiVisibility | 16 : systemUiVisibility & (-17));
    }

    public static Point a(Context context) {
        Point point = new Point();
        if (context == null) {
            return point;
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static void a(Context context, Window window) {
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(!((context.getResources().getConfiguration().uiMode & 48) == 32));
        window.clearFlags(Integer.MIN_VALUE);
    }
}
