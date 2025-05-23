package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
class ViewParentCompatLollipop {
    private static final String TAG = "ViewParentCompat";

    ViewParentCompatLollipop() {
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
        try {
            viewParent.onNestedPreScroll(view, i3, i16, iArr);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e16);
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18) {
        try {
            viewParent.onNestedScroll(view, i3, i16, i17, i18);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e16);
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, i3);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e16);
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3) {
        try {
            return viewParent.onStartNestedScroll(view, view2, i3);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e16);
            return false;
        }
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        try {
            viewParent.onStopNestedScroll(view);
        } catch (AbstractMethodError e16) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e16);
        }
    }
}
