package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityRecordCompatIcs {
    AccessibilityRecordCompatIcs() {
    }

    public static int getAddedCount(Object obj) {
        return ((AccessibilityRecord) obj).getAddedCount();
    }

    public static CharSequence getBeforeText(Object obj) {
        return ((AccessibilityRecord) obj).getBeforeText();
    }

    public static CharSequence getClassName(Object obj) {
        return ((AccessibilityRecord) obj).getClassName();
    }

    public static CharSequence getContentDescription(Object obj) {
        return ((AccessibilityRecord) obj).getContentDescription();
    }

    public static int getCurrentItemIndex(Object obj) {
        return ((AccessibilityRecord) obj).getCurrentItemIndex();
    }

    public static int getFromIndex(Object obj) {
        return ((AccessibilityRecord) obj).getFromIndex();
    }

    public static int getItemCount(Object obj) {
        return ((AccessibilityRecord) obj).getItemCount();
    }

    public static Parcelable getParcelableData(Object obj) {
        return ((AccessibilityRecord) obj).getParcelableData();
    }

    public static int getRemovedCount(Object obj) {
        return ((AccessibilityRecord) obj).getRemovedCount();
    }

    public static int getScrollX(Object obj) {
        return ((AccessibilityRecord) obj).getScrollX();
    }

    public static int getScrollY(Object obj) {
        return ((AccessibilityRecord) obj).getScrollY();
    }

    public static Object getSource(Object obj) {
        return ((AccessibilityRecord) obj).getSource();
    }

    public static List<CharSequence> getText(Object obj) {
        return ((AccessibilityRecord) obj).getText();
    }

    public static int getToIndex(Object obj) {
        return ((AccessibilityRecord) obj).getToIndex();
    }

    public static int getWindowId(Object obj) {
        return ((AccessibilityRecord) obj).getWindowId();
    }

    public static boolean isChecked(Object obj) {
        return ((AccessibilityRecord) obj).isChecked();
    }

    public static boolean isEnabled(Object obj) {
        return ((AccessibilityRecord) obj).isEnabled();
    }

    public static boolean isFullScreen(Object obj) {
        return ((AccessibilityRecord) obj).isFullScreen();
    }

    public static boolean isPassword(Object obj) {
        return ((AccessibilityRecord) obj).isPassword();
    }

    public static boolean isScrollable(Object obj) {
        return ((AccessibilityRecord) obj).isScrollable();
    }

    public static Object obtain() {
        return AccessibilityRecord.obtain();
    }

    public static void recycle(Object obj) {
        ((AccessibilityRecord) obj).recycle();
    }

    public static void setAddedCount(Object obj, int i3) {
        ((AccessibilityRecord) obj).setAddedCount(i3);
    }

    public static void setBeforeText(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setBeforeText(charSequence);
    }

    public static void setChecked(Object obj, boolean z16) {
        ((AccessibilityRecord) obj).setChecked(z16);
    }

    public static void setClassName(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setClassName(charSequence);
    }

    public static void setContentDescription(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setContentDescription(charSequence);
    }

    public static void setCurrentItemIndex(Object obj, int i3) {
        ((AccessibilityRecord) obj).setCurrentItemIndex(i3);
    }

    public static void setEnabled(Object obj, boolean z16) {
        ((AccessibilityRecord) obj).setEnabled(z16);
    }

    public static void setFromIndex(Object obj, int i3) {
        ((AccessibilityRecord) obj).setFromIndex(i3);
    }

    public static void setFullScreen(Object obj, boolean z16) {
        ((AccessibilityRecord) obj).setFullScreen(z16);
    }

    public static void setItemCount(Object obj, int i3) {
        ((AccessibilityRecord) obj).setItemCount(i3);
    }

    public static void setParcelableData(Object obj, Parcelable parcelable) {
        ((AccessibilityRecord) obj).setParcelableData(parcelable);
    }

    public static void setPassword(Object obj, boolean z16) {
        ((AccessibilityRecord) obj).setPassword(z16);
    }

    public static void setRemovedCount(Object obj, int i3) {
        ((AccessibilityRecord) obj).setRemovedCount(i3);
    }

    public static void setScrollX(Object obj, int i3) {
        ((AccessibilityRecord) obj).setScrollX(i3);
    }

    public static void setScrollY(Object obj, int i3) {
        ((AccessibilityRecord) obj).setScrollY(i3);
    }

    public static void setScrollable(Object obj, boolean z16) {
        ((AccessibilityRecord) obj).setScrollable(z16);
    }

    public static void setSource(Object obj, View view) {
        ((AccessibilityRecord) obj).setSource(view);
    }

    public static void setToIndex(Object obj, int i3) {
        ((AccessibilityRecord) obj).setToIndex(i3);
    }

    public static Object obtain(Object obj) {
        return AccessibilityRecord.obtain((AccessibilityRecord) obj);
    }
}
