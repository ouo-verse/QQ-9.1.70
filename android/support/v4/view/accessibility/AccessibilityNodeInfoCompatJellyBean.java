package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatJellyBean {
    AccessibilityNodeInfoCompatJellyBean() {
    }

    public static void addChild(Object obj, View view, int i3) {
        ((AccessibilityNodeInfo) obj).addChild(view, i3);
    }

    public static Object findFocus(Object obj, int i3) {
        return ((AccessibilityNodeInfo) obj).findFocus(i3);
    }

    public static Object focusSearch(Object obj, int i3) {
        return ((AccessibilityNodeInfo) obj).focusSearch(i3);
    }

    public static int getMovementGranularities(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMovementGranularities();
    }

    public static boolean isAccessibilityFocused(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    public static boolean isVisibleToUser(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public static Object obtain(View view, int i3) {
        return AccessibilityNodeInfo.obtain(view, i3);
    }

    public static boolean performAction(Object obj, int i3, Bundle bundle) {
        return ((AccessibilityNodeInfo) obj).performAction(i3, bundle);
    }

    public static void setAccesibilityFocused(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z16);
    }

    public static void setMovementGranularities(Object obj, int i3) {
        ((AccessibilityNodeInfo) obj).setMovementGranularities(i3);
    }

    public static void setParent(Object obj, View view, int i3) {
        ((AccessibilityNodeInfo) obj).setParent(view, i3);
    }

    public static void setSource(Object obj, View view, int i3) {
        ((AccessibilityNodeInfo) obj).setSource(view, i3);
    }

    public static void setVisibleToUser(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z16);
    }
}
