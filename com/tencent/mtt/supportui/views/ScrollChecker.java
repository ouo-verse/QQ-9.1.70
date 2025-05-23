package com.tencent.mtt.supportui.views;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ScrollChecker {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface IScrollCheck {
        boolean horizontalCanScroll(int i3);

        boolean verticalCanScroll(int i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canScroll(View view, boolean z16, boolean z17, int i3, int i16, int i17) {
        int i18;
        int i19;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = (int) (view.getScrollX() + view.getTranslationX() + 0.5f);
            int scrollY = (int) (view.getScrollY() + view.getTranslationX() + 0.5f);
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt.getVisibility() == 0 && (i18 = i16 + scrollX) >= childAt.getLeft() && i18 < childAt.getRight() && (i19 = i17 + scrollY) >= childAt.getTop() && i19 < childAt.getBottom() && canScroll(childAt, true, z17, i3, i18 - childAt.getLeft(), i19 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!(view instanceof IScrollCheck)) {
            return false;
        }
        IScrollCheck iScrollCheck = (IScrollCheck) view;
        if (z16) {
            int i26 = -i3;
            if (z17) {
                if (iScrollCheck.verticalCanScroll(i26)) {
                    return true;
                }
            } else if (iScrollCheck.horizontalCanScroll(i26)) {
                return true;
            }
        }
        return false;
    }
}
