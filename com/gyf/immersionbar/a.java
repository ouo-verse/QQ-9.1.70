package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import com.gyf.immersionbar.g;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f36009a;

    /* renamed from: b, reason: collision with root package name */
    private final int f36010b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f36011c;

    /* renamed from: d, reason: collision with root package name */
    private final int f36012d;

    /* renamed from: e, reason: collision with root package name */
    private final int f36013e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f36014f;

    /* renamed from: g, reason: collision with root package name */
    private final float f36015g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Activity activity) {
        boolean z16;
        if (activity.getResources().getConfiguration().orientation == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f36014f = z16;
        this.f36015g = i(activity);
        this.f36009a = c(activity, "status_bar_height");
        this.f36010b = b(activity);
        int e16 = e(activity);
        this.f36012d = e16;
        this.f36013e = h(activity);
        this.f36011c = e16 > 0;
    }

    @TargetApi(14)
    private int b(Activity activity) {
        int i3;
        View findViewById = activity.getWindow().findViewById(R.id.f163915s93);
        if (findViewById != null) {
            i3 = findViewById.getMeasuredHeight();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
        }
        return i3;
    }

    static int c(Context context, String str) {
        float f16;
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize && (Build.VERSION.SDK_INT < 29 || str.equals("status_bar_height"))) {
                    return dimensionPixelSize2;
                }
                float f17 = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                if (f17 >= 0.0f) {
                    f16 = f17 + 0.5f;
                } else {
                    f16 = f17 - 0.5f;
                }
                return (int) f16;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    @TargetApi(14)
    private int e(Context context) {
        if (k((Activity) context)) {
            return f(context);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(@NonNull Context context) {
        String str;
        if (context.getResources().getConfiguration().orientation == 1) {
            str = "navigation_bar_height";
        } else {
            str = "navigation_bar_height_landscape";
        }
        return c(context, str);
    }

    @TargetApi(14)
    private int h(Context context) {
        if (k((Activity) context)) {
            return c(context, "navigation_bar_width");
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    private float i(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f16 = displayMetrics.widthPixels;
        float f17 = displayMetrics.density;
        return Math.min(f16 / f17, displayMetrics.heightPixels / f17);
    }

    @TargetApi(14)
    private boolean k(Activity activity) {
        g.a a16 = g.a(activity);
        if (!a16.f36044b && a16.f36043a) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        int i16 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i17 = displayMetrics2.heightPixels;
        if (i16 - displayMetrics2.widthPixels <= 0 && i3 - i17 <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f36010b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f36012d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f36013e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f36009a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f36011c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        if (this.f36015g < 600.0f && !this.f36014f) {
            return false;
        }
        return true;
    }
}
