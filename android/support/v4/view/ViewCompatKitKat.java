package android.support.v4.view;

import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewCompatKitKat {
    ViewCompatKitKat() {
    }

    public static int getAccessibilityLiveRegion(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    public static void setAccessibilityLiveRegion(View view, int i3) {
        view.setAccessibilityLiveRegion(i3);
    }
}
