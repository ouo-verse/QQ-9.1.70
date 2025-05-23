package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    private void forceUniformWidth(int i3, int i16) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i17 = 0; i17 < i3; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                    int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i16, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i18;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i3, int i16, int i17, int i18) {
        view.layout(i3, i16, i17 + i3, i18 + i16);
    }

    private boolean tryOnMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int makeMeasureSpec;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                int id5 = childAt.getId();
                if (id5 == R.id.f99605q9) {
                    view = childAt;
                } else if (id5 == R.id.tiq) {
                    view2 = childAt;
                } else {
                    if ((id5 != R.id.b9q && id5 != R.id.uco) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i3, 0);
            paddingTop += view.getMeasuredHeight();
            i17 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i17 = 0;
        }
        if (view2 != null) {
            view2.measure(i3, 0);
            i18 = resolveMinimumHeight(view2);
            i19 = view2.getMeasuredHeight() - i18;
            paddingTop += i18;
            i17 = View.combineMeasuredStates(i17, view2.getMeasuredState());
        } else {
            i18 = 0;
            i19 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                makeMeasureSpec = 0;
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i3, makeMeasureSpec);
            i26 = view3.getMeasuredHeight();
            paddingTop += i26;
            i17 = View.combineMeasuredStates(i17, view3.getMeasuredState());
        } else {
            i26 = 0;
        }
        int i28 = size - paddingTop;
        if (view2 != null) {
            int i29 = paddingTop - i18;
            int min = Math.min(i28, i19);
            if (min > 0) {
                i28 -= min;
                i18 += min;
            }
            view2.measure(i3, View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
            paddingTop = i29 + view2.getMeasuredHeight();
            i17 = View.combineMeasuredStates(i17, view2.getMeasuredState());
        }
        if (view3 != null && i28 > 0) {
            view3.measure(i3, View.MeasureSpec.makeMeasureSpec(i26 + i28, mode));
            paddingTop = (paddingTop - i26) + view3.getMeasuredHeight();
            i17 = View.combineMeasuredStates(i17, view3.getMeasuredState());
        }
        int i36 = 0;
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt2 = getChildAt(i37);
            if (childAt2.getVisibility() != 8) {
                i36 = Math.max(i36, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i36 + getPaddingLeft() + getPaddingRight(), i3, i17), View.resolveSizeAndState(paddingTop, i16, 0));
        if (mode2 != 1073741824) {
            forceUniformWidth(childCount, i16);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int paddingTop;
        int intrinsicHeight;
        int i19;
        int i26;
        int i27;
        int paddingLeft = getPaddingLeft();
        int i28 = i17 - i3;
        int paddingRight = i28 - getPaddingRight();
        int paddingRight2 = (i28 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i29 = gravity & 112;
        int i36 = gravity & 8388615;
        if (i29 != 16) {
            if (i29 != 80) {
                paddingTop = getPaddingTop();
            } else {
                paddingTop = ((getPaddingTop() + i18) - i16) - measuredHeight;
            }
        } else {
            paddingTop = getPaddingTop() + (((i18 - i16) - measuredHeight) / 2);
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            intrinsicHeight = 0;
        } else {
            intrinsicHeight = dividerDrawable.getIntrinsicHeight();
        }
        for (int i37 = 0; i37 < childCount; i37++) {
            View childAt = getChildAt(i37);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i38 = layoutParams.gravity;
                if (i38 < 0) {
                    i38 = i36;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i38, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 5) {
                        i27 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                        if (hasDividerBeforeChildAt(i37)) {
                            paddingTop += intrinsicHeight;
                        }
                        int i39 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        setChildFrame(childAt, i27, i39, measuredWidth, measuredHeight2);
                        paddingTop = i39 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    } else {
                        i19 = paddingRight - measuredWidth;
                        i26 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                } else {
                    i19 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i26 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                i27 = i19 - i26;
                if (hasDividerBeforeChildAt(i37)) {
                }
                int i392 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                setChildFrame(childAt, i27, i392, measuredWidth, measuredHeight2);
                paddingTop = i392 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i3, int i16) {
        if (!tryOnMeasure(i3, i16)) {
            super.onMeasure(i3, i16);
        }
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
