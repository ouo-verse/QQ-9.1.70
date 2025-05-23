package android.support.v4.view;

/* compiled from: P */
/* loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f16, float f17, boolean z16);

    boolean dispatchNestedPreFling(float f16, float f17);

    boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2);

    boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z16);

    boolean startNestedScroll(int i3);

    void stopNestedScroll();
}
