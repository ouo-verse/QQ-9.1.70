package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewCompatLollipop {
    ViewCompatLollipop() {
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets unwrap;
        WindowInsets dispatchApplyWindowInsets;
        if ((windowInsetsCompat instanceof WindowInsetsCompatApi21) && (dispatchApplyWindowInsets = view.dispatchApplyWindowInsets((unwrap = ((WindowInsetsCompatApi21) windowInsetsCompat).unwrap()))) != unwrap) {
            return new WindowInsetsCompatApi21(dispatchApplyWindowInsets);
        }
        return windowInsetsCompat;
    }

    public static boolean dispatchNestedFling(View view, float f16, float f17, boolean z16) {
        return view.dispatchNestedFling(f16, f17, z16);
    }

    public static boolean dispatchNestedPreFling(View view, float f16, float f17) {
        return view.dispatchNestedPreFling(f16, f17);
    }

    public static boolean dispatchNestedPreScroll(View view, int i3, int i16, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i3, i16, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(View view, int i3, int i16, int i17, int i18, int[] iArr) {
        return view.dispatchNestedScroll(i3, i16, i17, i18, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ColorStateList getBackgroundTintList(View view) {
        return view.getBackgroundTintList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return view.getBackgroundTintMode();
    }

    public static float getElevation(View view) {
        return view.getElevation();
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    public static float getZ(View view) {
        return view.getZ();
    }

    public static boolean hasNestedScrollingParent(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean isImportantForAccessibility(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets unwrap;
        WindowInsets onApplyWindowInsets;
        if ((windowInsetsCompat instanceof WindowInsetsCompatApi21) && (onApplyWindowInsets = view.onApplyWindowInsets((unwrap = ((WindowInsetsCompatApi21) windowInsetsCompat).unwrap()))) != unwrap) {
            return new WindowInsetsCompatApi21(onApplyWindowInsets);
        }
        return windowInsetsCompat;
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void setElevation(View view, float f16) {
        view.setElevation(f16);
    }

    public static void setNestedScrollingEnabled(View view, boolean z16) {
        view.setNestedScrollingEnabled(z16);
    }

    public static void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewCompatLollipop.1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return ((WindowInsetsCompatApi21) OnApplyWindowInsetsListener.this.onApplyWindowInsets(view2, new WindowInsetsCompatApi21(windowInsets))).unwrap();
                }
            });
        }
    }

    public static void setTransitionName(View view, String str) {
        view.setTransitionName(str);
    }

    public static void setTranslationZ(View view, float f16) {
        view.setTranslationZ(f16);
    }

    public static boolean startNestedScroll(View view, int i3) {
        return view.startNestedScroll(i3);
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }
}
