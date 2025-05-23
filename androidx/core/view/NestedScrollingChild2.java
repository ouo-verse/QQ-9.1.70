package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i3, int i16, @Nullable int[] iArr, @Nullable int[] iArr2, int i17);

    boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19);

    boolean hasNestedScrollingParent(int i3);

    boolean startNestedScroll(int i3, int i16);

    void stopNestedScroll(int i3);
}
