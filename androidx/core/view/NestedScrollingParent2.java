package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17);

    void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16);

    void onStopNestedScroll(@NonNull View view, int i3);
}
