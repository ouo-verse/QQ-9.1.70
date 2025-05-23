package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    /* compiled from: P */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    private static class Impl16 {
        Impl16() {
        }

        static void setDecorFitsSystemWindows(@NonNull Window window, boolean z16) {
            int i3;
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z16) {
                i3 = systemUiVisibility & (-1793);
            } else {
                i3 = systemUiVisibility | 1792;
            }
            decorView.setSystemUiVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Impl30 {
        Impl30() {
        }

        static WindowInsetsControllerCompat getInsetsController(@NonNull Window window) {
            WindowInsetsController insetsController;
            insetsController = window.getInsetsController();
            if (insetsController != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(insetsController);
            }
            return null;
        }

        static void setDecorFitsSystemWindows(@NonNull Window window, boolean z16) {
            window.setDecorFitsSystemWindows(z16);
        }
    }

    WindowCompat() {
    }

    @Nullable
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window window, @NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInsetsController(window);
        }
        return new WindowInsetsControllerCompat(window, view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window window, @IdRes int i3) {
        View requireViewById;
        if (Build.VERSION.SDK_INT >= 28) {
            requireViewById = window.requireViewById(i3);
            return (T) requireViewById;
        }
        T t16 = (T) window.findViewById(i3);
        if (t16 != null) {
            return t16;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(@NonNull Window window, boolean z16) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setDecorFitsSystemWindows(window, z16);
        } else {
            Impl16.setDecorFitsSystemWindows(window, z16);
        }
    }
}
