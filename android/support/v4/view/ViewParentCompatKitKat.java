package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
class ViewParentCompatKitKat {
    ViewParentCompatKitKat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i3) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i3);
    }
}
