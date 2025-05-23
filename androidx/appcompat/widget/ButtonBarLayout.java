package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private int mMinimumHeight;

    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastWidthSize = -1;
        this.mMinimumHeight = 0;
        int[] iArr = R.styleable.ButtonBarLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.mAllowStacking = obtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
    }

    private int getNextVisibleChildIndex(int i3) {
        int childCount = getChildCount();
        while (i3 < childCount) {
            if (getChildAt(i3).getVisibility() == 0) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private boolean isStacked() {
        if (getOrientation() == 1) {
            return true;
        }
        return false;
    }

    private void setStacked(boolean z16) {
        int i3;
        int i16;
        setOrientation(z16 ? 1 : 0);
        if (z16) {
            i3 = 5;
        } else {
            i3 = 80;
        }
        setGravity(i3);
        View findViewById = findViewById(com.tencent.mobileqq.R.id.f87124ti);
        if (findViewById != null) {
            if (z16) {
                i16 = 8;
            } else {
                i16 = 4;
            }
            findViewById.setVisibility(i16);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.mMinimumHeight, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        boolean z16;
        boolean z17;
        int size = View.MeasureSpec.getSize(i3);
        int i18 = 0;
        if (this.mAllowStacking) {
            if (size > this.mLastWidthSize && isStacked()) {
                setStacked(false);
            }
            this.mLastWidthSize = size;
        }
        if (!isStacked() && View.MeasureSpec.getMode(i3) == 1073741824) {
            i17 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z16 = true;
        } else {
            i17 = i3;
            z16 = false;
        }
        super.onMeasure(i17, i16);
        if (this.mAllowStacking && !isStacked()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                setStacked(true);
                z16 = true;
            }
        }
        if (z16) {
            super.onMeasure(i3, i16);
        }
        int nextVisibleChildIndex = getNextVisibleChildIndex(0);
        if (nextVisibleChildIndex >= 0) {
            View childAt = getChildAt(nextVisibleChildIndex);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (isStacked()) {
                int nextVisibleChildIndex2 = getNextVisibleChildIndex(nextVisibleChildIndex + 1);
                if (nextVisibleChildIndex2 >= 0) {
                    paddingTop += getChildAt(nextVisibleChildIndex2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i18 = paddingTop;
            } else {
                i18 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight(this) != i18) {
            setMinimumHeight(i18);
        }
    }

    public void setAllowStacking(boolean z16) {
        if (this.mAllowStacking != z16) {
            this.mAllowStacking = z16;
            if (!z16 && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
