package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatIcs {
    AccessibilityNodeInfoCompatIcs() {
    }

    public static void addAction(Object obj, int i3) {
        ((AccessibilityNodeInfo) obj).addAction(i3);
    }

    public static void addChild(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public static List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
        return ((AccessibilityNodeInfo) obj).findAccessibilityNodeInfosByText(str);
    }

    public static int getActions(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void getBoundsInParent(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void getBoundsInScreen(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static Object getChild(Object obj, int i3) {
        return ((AccessibilityNodeInfo) obj).getChild(i3);
    }

    public static int getChildCount(Object obj) {
        return ((AccessibilityNodeInfo) obj).getChildCount();
    }

    public static CharSequence getClassName(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence getContentDescription(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence getPackageName(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static Object getParent(Object obj) {
        return ((AccessibilityNodeInfo) obj).getParent();
    }

    public static CharSequence getText(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static int getWindowId(Object obj) {
        return ((AccessibilityNodeInfo) obj).getWindowId();
    }

    public static boolean isCheckable(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean isChecked(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean isClickable(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean isEnabled(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean isFocusable(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean isFocused(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean isLongClickable(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean isPassword(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean isScrollable(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean isSelected(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static Object obtain() {
        return AccessibilityNodeInfo.obtain();
    }

    public static boolean performAction(Object obj, int i3) {
        return ((AccessibilityNodeInfo) obj).performAction(i3);
    }

    public static void recycle(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }

    public static void setBoundsInParent(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void setBoundsInScreen(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void setCheckable(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setCheckable(z16);
    }

    public static void setChecked(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setChecked(z16);
    }

    public static void setClassName(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void setClickable(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setClickable(z16);
    }

    public static void setContentDescription(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void setEnabled(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setEnabled(z16);
    }

    public static void setFocusable(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setFocusable(z16);
    }

    public static void setFocused(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setFocused(z16);
    }

    public static void setLongClickable(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z16);
    }

    public static void setPackageName(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void setParent(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void setPassword(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setPassword(z16);
    }

    public static void setScrollable(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setScrollable(z16);
    }

    public static void setSelected(Object obj, boolean z16) {
        ((AccessibilityNodeInfo) obj).setSelected(z16);
    }

    public static void setSource(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void setText(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setText(charSequence);
    }

    public static Object obtain(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public static Object obtain(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }
}
