package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class e {
    public static void a(@NonNull Window window, boolean z16, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2) {
        boolean z17;
        boolean z18 = false;
        if (num != null && num.intValue() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (num2 == null || num2.intValue() == 0) {
            z18 = true;
        }
        if (z17 || z18) {
            int b16 = z0.a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z17) {
                num = Integer.valueOf(b16);
            }
            if (z18) {
                num2 = Integer.valueOf(b16);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z16);
        int c16 = c(window.getContext(), z16);
        int b17 = b(window.getContext(), z16);
        window.setStatusBarColor(c16);
        window.setNavigationBarColor(b17);
        boolean d16 = d(c16, z0.a.f(num.intValue()));
        boolean d17 = d(b17, z0.a.f(num2.intValue()));
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        if (insetsController != null) {
            insetsController.setAppearanceLightStatusBars(d16);
            insetsController.setAppearanceLightNavigationBars(d17);
        }
    }

    @TargetApi(21)
    private static int b(Context context, boolean z16) {
        if (z16 && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(z0.a.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z16) {
            return 0;
        }
        return z0.a.b(context, R.attr.navigationBarColor, -16777216);
    }

    @TargetApi(21)
    private static int c(Context context, boolean z16) {
        if (z16) {
            return 0;
        }
        return z0.a.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i3, boolean z16) {
        if (!z0.a.f(i3) && (i3 != 0 || !z16)) {
            return false;
        }
        return true;
    }
}
