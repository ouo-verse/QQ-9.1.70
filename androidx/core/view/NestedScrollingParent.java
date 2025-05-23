package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f16, float f17, boolean z16);

    boolean onNestedPreFling(@NonNull View view, float f16, float f17);

    void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3);

    void onStopNestedScroll(@NonNull View view);
}
