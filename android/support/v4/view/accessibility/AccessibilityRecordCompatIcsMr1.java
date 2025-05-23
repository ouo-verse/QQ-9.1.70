package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityRecordCompatIcsMr1 {
    AccessibilityRecordCompatIcsMr1() {
    }

    public static int getMaxScrollX(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollX();
    }

    public static int getMaxScrollY(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollY();
    }

    public static void setMaxScrollX(Object obj, int i3) {
        ((AccessibilityRecord) obj).setMaxScrollX(i3);
    }

    public static void setMaxScrollY(Object obj, int i3) {
        ((AccessibilityRecord) obj).setMaxScrollY(i3);
    }
}
