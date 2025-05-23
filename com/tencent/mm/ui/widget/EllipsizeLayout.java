package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class EllipsizeLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f152690a;

    public EllipsizeLayout(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i3, int i16) {
        boolean z16;
        int measuredWidth;
        TextView textView;
        boolean z17;
        LinearLayout.LayoutParams layoutParams;
        if (getOrientation() == 0 && View.MeasureSpec.getMode(i3) == 1073741824) {
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i3) - (getPaddingLeft() + getPaddingRight());
            int i17 = 0;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
            TextView textView2 = null;
            boolean z18 = false;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                z16 = true;
                if (i18 >= childCount || z18) {
                    break;
                }
                View childAt = getChildAt(i18);
                if (childAt != null && childAt.getVisibility() != 8) {
                    if (childAt instanceof TextView) {
                        TextView textView3 = (TextView) childAt;
                        if (textView3.getEllipsize() != null) {
                            if (textView2 == null) {
                                textView3.setMaxWidth(Integer.MAX_VALUE);
                                if (this.f152690a) {
                                    ((LinearLayout.LayoutParams) textView3.getLayoutParams()).leftMargin = 0;
                                }
                                z17 = z18;
                                textView = textView3;
                            } else {
                                textView = textView2;
                                z17 = true;
                            }
                            measureChildWithMargins(childAt, makeMeasureSpec, 0, i16, 0);
                            layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                            if (layoutParams == null) {
                                if (layoutParams.weight <= 0.0f) {
                                    z16 = false;
                                }
                                z18 = z17 | z16;
                                i19 += childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                            } else {
                                z18 = true;
                            }
                            textView2 = textView;
                        }
                    }
                    textView = textView2;
                    z17 = z18;
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i16, 0);
                    layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    if (layoutParams == null) {
                    }
                    textView2 = textView;
                }
                i18++;
            }
            if (textView2 != null) {
                if (i19 != 0) {
                    z16 = false;
                }
                boolean z19 = z18 | z16;
                int measuredWidth2 = textView2.getMeasuredWidth() - (i19 - size);
                if (!z19 && i19 > size) {
                    if (measuredWidth2 >= 0) {
                        i17 = measuredWidth2;
                    }
                    textView2.setMaxWidth(i17);
                    measuredWidth2 = i17;
                }
                if (this.f152690a && textView2.getMeasuredWidth() > 0) {
                    if (i19 > size) {
                        measuredWidth = i19 - textView2.getMeasuredWidth();
                    } else {
                        measuredWidth = (size - textView2.getMeasuredWidth()) / 2;
                    }
                    ((LinearLayout.LayoutParams) textView2.getLayoutParams()).leftMargin = measuredWidth;
                    textView2.setMaxWidth(measuredWidth2 - measuredWidth);
                }
            }
        }
        super.onMeasure(i3, i16);
    }

    public EllipsizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152690a = context.obtainStyledAttributes(attributeSet, R.styleable.EllipsizeLayout).getBoolean(R.styleable.EllipsizeLayout_center_ellipsize_textview, false);
    }
}
