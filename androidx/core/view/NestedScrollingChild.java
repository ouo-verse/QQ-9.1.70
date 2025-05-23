package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f16, float f17, boolean z16);

    boolean dispatchNestedPreFling(float f16, float f17);

    boolean dispatchNestedPreScroll(int i3, int i16, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z16);

    boolean startNestedScroll(int i3);

    void stopNestedScroll();
}
