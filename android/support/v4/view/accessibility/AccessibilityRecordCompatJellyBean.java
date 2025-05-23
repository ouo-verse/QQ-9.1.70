package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void setSource(Object obj, View view, int i3) {
        ((AccessibilityRecord) obj).setSource(view, i3);
    }
}
