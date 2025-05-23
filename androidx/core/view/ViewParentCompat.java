package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i3) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i3);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f16, float f17, boolean z16) {
        try {
            return viewParent.onNestedFling(view, f16, f17, z16);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e16);
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f16, float f17) {
        try {
            return viewParent.onNestedPreFling(view, f16, f17);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e16);
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i16, int[] iArr) {
        onNestedPreScroll(viewParent, view, i3, i16, iArr, 0);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18) {
        onNestedScroll(viewParent, view, i3, i16, i17, i18, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3) {
        onNestedScrollAccepted(viewParent, view, view2, i3, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3) {
        return onStartNestedScroll(viewParent, view, view2, i3, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i16, int[] iArr, int i17) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i3, i16, iArr, i17);
            return;
        }
        if (i17 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i3, i16, iArr);
            } catch (AbstractMethodError e16) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e16);
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3, int i16) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i3, i16);
            return;
        }
        if (i16 == 0) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i3);
            } catch (AbstractMethodError e16) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e16);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3, int i16) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i3, i16);
        }
        if (i16 != 0) {
            return false;
        }
        try {
            return viewParent.onStartNestedScroll(view, view2, i3);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e16);
            return false;
        }
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i3);
            return;
        }
        if (i3 == 0) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e16) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e16);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18, int i19) {
        onNestedScroll(viewParent, view, i3, i16, i17, i18, i19, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18, int i19, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i3, i16, i17, i18, i19, iArr);
            return;
        }
        iArr[0] = iArr[0] + i17;
        iArr[1] = iArr[1] + i18;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i3, i16, i17, i18, i19);
            return;
        }
        if (i19 == 0) {
            try {
                viewParent.onNestedScroll(view, i3, i16, i17, i18);
            } catch (AbstractMethodError e16) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e16);
            }
        }
    }
}
