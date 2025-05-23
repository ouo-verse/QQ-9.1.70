package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    private LinearLayoutManager mLayoutManager;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    private boolean arePagesLaidOutContiguously() {
        boolean z16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i3;
        int bottom;
        int i16;
        int childCount = this.mLayoutManager.getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (this.mLayoutManager.getOrientation() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, childCount, 2);
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = this.mLayoutManager.getChildAt(i17);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = ZERO_MARGIN_LAYOUT_PARAMS;
                }
                int[] iArr2 = iArr[i17];
                if (z16) {
                    top = childAt.getLeft();
                    i3 = marginLayoutParams.leftMargin;
                } else {
                    top = childAt.getTop();
                    i3 = marginLayoutParams.topMargin;
                }
                iArr2[0] = top - i3;
                int[] iArr3 = iArr[i17];
                if (z16) {
                    bottom = childAt.getRight();
                    i16 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i16 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i16;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.widget.AnimateLayoutChangeDetector.1
            @Override // java.util.Comparator
            public int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i18 = 1; i18 < childCount; i18++) {
            if (iArr[i18 - 1][1] != iArr[i18][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i19 = iArr4[1];
        int i26 = iArr4[0];
        int i27 = i19 - i26;
        if (i26 <= 0 && iArr[childCount - 1][1] >= i27) {
            return true;
        }
        return false;
    }

    private boolean hasRunningChangingLayoutTransition() {
        int childCount = this.mLayoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i3))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean mayHaveInterferingAnimations() {
        if ((!arePagesLaidOutContiguously() || this.mLayoutManager.getChildCount() <= 1) && hasRunningChangingLayoutTransition()) {
            return true;
        }
        return false;
    }

    private static boolean hasRunningChangingLayoutTransition(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (hasRunningChangingLayoutTransition(viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }
}
