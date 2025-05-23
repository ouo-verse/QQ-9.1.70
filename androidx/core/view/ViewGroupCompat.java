package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(@NonNull ViewGroup viewGroup, int i3) {
        viewGroup.setLayoutMode(i3);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z16) {
        viewGroup.setMotionEventSplittingEnabled(z16);
    }

    public static void setTransitionGroup(@NonNull ViewGroup viewGroup, boolean z16) {
        viewGroup.setTransitionGroup(z16);
    }
}
