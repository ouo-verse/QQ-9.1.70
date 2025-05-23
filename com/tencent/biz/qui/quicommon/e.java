package com.tencent.biz.qui.quicommon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f95161a;

    /* renamed from: b, reason: collision with root package name */
    public static float f95162b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f95163a;

        a(int i3) {
            this.f95163a = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), e.c(this.f95163a));
        }
    }

    static {
        DisplayMetrics displayMetrics = ud0.b.a().getResources().getDisplayMetrics();
        f95162b = displayMetrics.density;
        f95161a = displayMetrics.densityDpi;
    }

    public static int a(float f16) {
        return (int) ((f16 * f95162b) + 0.5f);
    }

    public static int b(@NonNull Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(float f16) {
        return Math.round(f16 * f95162b);
    }

    public static int d(@NonNull Context context, float f16) {
        return Math.round(f16 * context.getResources().getDisplayMetrics().density);
    }

    public static int e(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int f() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) ud0.b.a().getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception e16) {
            ud0.d.b("ViewUtils", ud0.d.f438809c, e16);
            return -1;
        }
    }

    public static int g() {
        if (ud0.b.a().getResources().getConfiguration().orientation == 2) {
            return ud0.b.a().getResources().getDisplayMetrics().widthPixels;
        }
        return ud0.b.a().getResources().getDisplayMetrics().heightPixels;
    }

    public static int h() {
        return ud0.b.a().getResources().getDisplayMetrics().heightPixels;
    }

    public static int i() {
        if (ud0.b.a().getResources().getConfiguration().orientation == 2) {
            return ud0.b.a().getResources().getDisplayMetrics().heightPixels;
        }
        return ud0.b.a().getResources().getDisplayMetrics().widthPixels;
    }

    public static int j() {
        if (ud0.b.a().getResources().getConfiguration().orientation == 2) {
            return f();
        }
        return ud0.b.a().getResources().getDisplayMetrics().widthPixels;
    }

    public static int k() {
        return Math.min(i(), g());
    }

    public static int l(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean m() {
        if (ud0.b.a().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static boolean n() {
        boolean z16;
        Display defaultDisplay = ((WindowManager) ud0.b.a().getSystemService("window")).getDefaultDisplay();
        if (ud0.b.a().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        int rotation = defaultDisplay.getRotation();
        if (!z16) {
            return false;
        }
        if (rotation == 0 || rotation == 1) {
            return true;
        }
        return false;
    }

    public static void o(View view, int i3) {
        if (view == null) {
            return;
        }
        view.setClipToOutline(true);
        view.setOutlineProvider(new a(i3));
    }
}
