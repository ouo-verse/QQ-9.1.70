package android.support.v4.view;

import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
class ViewCompatMarshmallow {
    ViewCompatMarshmallow() {
    }

    public static int getScrollIndicators(View view) {
        return view.getScrollIndicators();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view, int i3) {
        view.offsetLeftAndRight(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view, int i3) {
        view.offsetTopAndBottom(i3);
    }

    public static void setScrollIndicators(View view, int i3) {
        view.setScrollIndicators(i3);
    }

    public static void setScrollIndicators(View view, int i3, int i16) {
        view.setScrollIndicators(i3, i16);
    }
}
