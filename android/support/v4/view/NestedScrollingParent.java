package android.support.v4.view;

import android.view.View;

/* loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(View view, float f16, float f17, boolean z16);

    boolean onNestedPreFling(View view, float f16, float f17);

    void onNestedPreScroll(View view, int i3, int i16, int[] iArr);

    void onNestedScroll(View view, int i3, int i16, int i17, int i18);

    void onNestedScrollAccepted(View view, View view2, int i3);

    boolean onStartNestedScroll(View view, View view2, int i3);

    void onStopNestedScroll(View view);
}
