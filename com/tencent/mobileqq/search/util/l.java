package com.tencent.mobileqq.search.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a\u0012\u0010\f\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Landroidx/constraintlayout/widget/ConstraintLayout;", "", "columnCount", "spacing", "spacingForSingleRow", "paddingForSingleRow", "", "placeholderForSingleRow", "", "e", "Landroid/view/View;", "expendSize", "b", "d", "(I)I", "dp", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l {
    public static final void b(@NotNull final View view, final int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.search.util.k
            @Override // java.lang.Runnable
            public final void run() {
                l.c(view, i3, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View this_expendTouchArea, int i3, View parentView) {
        Intrinsics.checkNotNullParameter(this_expendTouchArea, "$this_expendTouchArea");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        this_expendTouchArea.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expendTouchArea));
    }

    public static final int d(int i3) {
        return Utils.n(i3, BaseApplication.getContext().getResources());
    }

    public static final void e(@NotNull ConstraintLayout constraintLayout, int i3, int i16, int i17, int i18, boolean z16) {
        ConstraintLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(constraintLayout, "<this>");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        int childCount = constraintLayout.getChildCount();
        int i19 = 0;
        if (!z16 && childCount < i3) {
            View view = null;
            while (i19 < childCount) {
                View childAt = constraintLayout.getChildAt(i19);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
                    layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.horizontalWeight = 1.0f;
                }
                if (view == null) {
                    constraintSet.connect(childAt.getId(), 6, 0, 6, i18);
                } else {
                    constraintSet.connect(childAt.getId(), 6, view.getId(), 7, i17);
                }
                if (i19 < childCount - 1) {
                    constraintSet.connect(childAt.getId(), 7, constraintLayout.getChildAt(i19 + 1).getId(), 6, i17);
                } else {
                    constraintSet.connect(childAt.getId(), 7, 0, 7, i18);
                }
                i19++;
                view = childAt;
            }
        } else {
            int ceil = (int) Math.ceil(childCount / i3);
            int max = Math.max(childCount, ceil * i3);
            while (constraintLayout.getChildCount() < max) {
                View view2 = new View(constraintLayout.getContext());
                view2.setId(ViewCompat.generateViewId());
                view2.setLayoutParams(new ConstraintLayout.LayoutParams(0, 0));
                view2.setBackgroundColor(0);
                constraintLayout.addView(view2);
            }
            for (int i26 = 0; i26 < max; i26++) {
                View childAt2 = constraintLayout.getChildAt(i26);
                int i27 = i26 % i3;
                int i28 = i26 / i3;
                if (i27 == 0) {
                    constraintSet.connect(childAt2.getId(), 6, 0, 6);
                } else {
                    constraintSet.connect(childAt2.getId(), 6, constraintLayout.getChildAt(i26 - 1).getId(), 7, i16);
                }
                if (i28 == 0) {
                    constraintSet.connect(childAt2.getId(), 3, 0, 3);
                } else {
                    constraintSet.connect(childAt2.getId(), 3, constraintLayout.getChildAt((i28 - 1) * i3).getId(), 4, i16);
                }
                if (i27 < i3 - 1) {
                    constraintSet.connect(childAt2.getId(), 7, constraintLayout.getChildAt(i26 + 1).getId(), 6, 0);
                } else {
                    constraintSet.connect(childAt2.getId(), 7, 0, 7, 0);
                }
                if (i28 == ceil - 1) {
                    constraintSet.connect(childAt2.getId(), 4, 0, 4);
                }
            }
        }
        constraintSet.applyTo(constraintLayout);
    }

    public static /* synthetic */ void f(ConstraintLayout constraintLayout, int i3, int i16, int i17, int i18, boolean z16, int i19, Object obj) {
        int i26;
        int i27;
        if ((i19 & 4) != 0) {
            i26 = 0;
        } else {
            i26 = i17;
        }
        if ((i19 & 8) != 0) {
            i27 = 0;
        } else {
            i27 = i18;
        }
        if ((i19 & 16) != 0) {
            z16 = true;
        }
        e(constraintLayout, i3, i16, i26, i27, z16);
    }
}
