package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityEventCompatKitKat {
    AccessibilityEventCompatKitKat() {
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i3) {
        accessibilityEvent.setContentChangeTypes(i3);
    }
}
