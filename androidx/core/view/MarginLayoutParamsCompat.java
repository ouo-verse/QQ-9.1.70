package androidx.core.view;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int layoutDirection = marginLayoutParams.getLayoutDirection();
        if (layoutDirection != 0 && layoutDirection != 1) {
            return 0;
        }
        return layoutDirection;
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.resolveLayoutDirection(i3);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setLayoutDirection(i3);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginEnd(i3);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginStart(i3);
    }
}
