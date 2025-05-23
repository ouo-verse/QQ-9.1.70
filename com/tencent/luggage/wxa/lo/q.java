package com.tencent.luggage.wxa.lo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q {
    public static int a(Context context) {
        int height;
        if (context == null) {
            n.e("WeUIToolHelper", "[getActionBarHeight] context is null!", new Object[0]);
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.bfi);
        if (context instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) context;
            if (appCompatActivity.getSupportActionBar() != null) {
                height = appCompatActivity.getSupportActionBar().getHeight();
            }
            height = 0;
        } else {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.getActionBar() != null) {
                    height = activity.getActionBar().getHeight();
                }
            }
            height = 0;
        }
        if (height <= 0) {
            height = dimensionPixelSize;
        }
        n.c("WeUIToolHelper", "[getActionBarHeight] real:%s defaultVal:%s", Integer.valueOf(height), Integer.valueOf(dimensionPixelSize));
        return height;
    }

    public static Point b(Context context) {
        Rect rect;
        WindowMetrics currentWindowMetrics;
        Point point = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                rect = currentWindowMetrics.getBounds();
            } catch (RuntimeException e16) {
                n.a("WeUIToolHelper", e16, "getDisplayRealSize RuntimeException", new Object[0]);
                rect = null;
            }
            if (rect != null) {
                point.x = rect.width();
                point.y = rect.height();
            } else {
                defaultDisplay.getRealSize(point);
            }
        } else {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    public static int c(Context context) {
        int i3 = 0;
        if (!d(context)) {
            return 0;
        }
        int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            i3 = Resources.getSystem().getDimensionPixelSize(identifier);
        }
        int e16 = e(context);
        if (e16 != 0 && e16 < i3) {
            return e16;
        }
        return i3;
    }

    public static boolean d(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getWindow() != null && (activity.getWindow().getAttributes().flags & 512) == 512) {
                return false;
            }
        }
        if (e(context) <= 0) {
            return false;
        }
        return true;
    }

    public static int e(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point b16 = b(context);
        int max = Math.max(point.y, point.x);
        if (h(context)) {
            max = point.y;
        }
        int max2 = Math.max(b16.y, b16.x);
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            max = Math.max(rect.bottom, rect.right);
            if (h(context)) {
                max = rect.bottom;
            }
        }
        return max2 - max;
    }

    public static int f(Context context) {
        return a(context, o.a(context, 25));
    }

    public static boolean g(Context context) {
        if (!(context instanceof Activity) || (((Activity) context).getWindow().getAttributes().flags & 1024) != 1024) {
            return true;
        }
        return false;
    }

    public static boolean h(Context context) {
        if (context.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public static int a(Context context, int i3) {
        int dimensionPixelSize;
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            dimensionPixelSize = context.getResources().getDimensionPixelSize(r.a(cls.getField("status_bar_height").get(b.f133704a.b(cls)).toString(), 0));
        } catch (Exception e16) {
            n.e("WeUIToolHelper", "getStatusBarHeightFromSysR by R$dimen fail: " + e16.getMessage(), new Object[0]);
            try {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
            } catch (Exception e17) {
                n.e("WeUIToolHelper", "getStatusBarHeightFromSysR by identifier fail: " + e17.getMessage(), new Object[0]);
            }
        }
        i3 = dimensionPixelSize;
        n.c("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", Integer.valueOf(i3));
        return i3;
    }
}
