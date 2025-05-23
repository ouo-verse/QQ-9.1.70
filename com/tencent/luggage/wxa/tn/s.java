package com.tencent.luggage.wxa.tn;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cooperation.qzone.report.lp.LpReportInfoConfig;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static int f141704a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f141705b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f141706c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f141707d = -1;

    public static final int a(Context context, boolean z16) {
        if (!f141705b) {
            int i3 = f141704a;
            return (i3 <= 0 || !z16) ? b(context) : i3;
        }
        return d(context);
    }

    public static final int b(Context context) {
        if (!f141705b) {
            if (!a(context)) {
                return z.e().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
            }
            int i3 = z.e().getInt("com.tencent.mm.compatible.util.keybord.height", a(context, 230));
            f141704a = i3;
            return i3;
        }
        return d(context);
    }

    public static final int c(Context context) {
        if (!f141705b) {
            int i3 = f141706c;
            if (i3 > 0) {
                return i3;
            }
            if (!a(context)) {
                return 1140;
            }
            int a16 = a(context, LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT);
            f141706c = a16;
            return a16;
        }
        return d(context);
    }

    public static final int d(Context context) {
        int i3 = f141707d;
        if (i3 > 0) {
            return i3;
        }
        if (!a(context)) {
            return f141707d * 3;
        }
        int a16 = a(context, 230);
        f141707d = a16;
        return a16;
    }

    public static int e(Context context) {
        int[] f16 = f(context);
        if (f16[0] < f16[1]) {
            return 1;
        }
        return 2;
    }

    public static int[] f(Context context) {
        if (context == null) {
            context = z.c();
        }
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public static final int g(Context context) {
        return b(context, -1);
    }

    public static boolean h(Context context) {
        if (e(context) == 1) {
            return true;
        }
        return false;
    }

    public static final boolean a(Context context) {
        if (context == null) {
            context = z.c();
        }
        return context != null;
    }

    public static final int a(Context context, int i3) {
        return com.tencent.luggage.wxa.kn.a.a(context, i3);
    }

    public static final int b(Context context, int i3) {
        int d16 = d(context);
        if (!h(context)) {
            int i16 = (int) (d16 / 1.5d);
            int i17 = f(context)[0] / 2;
            return i16 > i17 ? i17 : i16;
        }
        if (i3 <= 0) {
            i3 = a(context, true);
        }
        int c16 = c(context);
        return i3 > c16 ? c16 : i3 < d16 ? d16 : i3;
    }
}
