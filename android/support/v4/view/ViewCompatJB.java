package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewCompatJB {
    ViewCompatJB() {
    }

    public static Object getAccessibilityNodeProvider(View view) {
        return view.getAccessibilityNodeProvider();
    }

    public static boolean getFitsSystemWindows(View view) {
        return view.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(View view) {
        return view.getImportantForAccessibility();
    }

    public static int getMinimumHeight(View view) {
        return view.getMinimumHeight();
    }

    public static int getMinimumWidth(View view) {
        return view.getMinimumWidth();
    }

    public static ViewParent getParentForAccessibility(View view) {
        return view.getParentForAccessibility();
    }

    public static boolean hasOverlappingRendering(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean hasTransientState(View view) {
        return view.hasTransientState();
    }

    public static boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
        return view.performAccessibilityAction(i3, bundle);
    }

    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j3) {
        view.postOnAnimationDelayed(runnable, j3);
    }

    public static void requestApplyInsets(View view) {
        view.requestFitSystemWindows();
    }

    public static void setHasTransientState(View view, boolean z16) {
        view.setHasTransientState(z16);
    }

    public static void setImportantForAccessibility(View view, int i3) {
        view.setImportantForAccessibility(i3);
    }

    public static void postInvalidateOnAnimation(View view, int i3, int i16, int i17, int i18) {
        view.postInvalidate(i3, i16, i17, i18);
    }
}
