package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes13.dex */
public class CommentEllipsizeLayout extends LinearLayout {
    public CommentEllipsizeLayout(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        TextView textView;
        boolean z17;
        LinearLayout.LayoutParams layoutParams;
        if (getOrientation() == 0 && View.MeasureSpec.getMode(i3) == 1073741824) {
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i3);
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
            if (textView2 != null && i19 != 0) {
                z16 = false;
            }
            if (!(z18 | z16) && i19 > size) {
                int measuredWidth = textView2.getMeasuredWidth() - (i19 - size);
                if (measuredWidth >= 0) {
                    i17 = measuredWidth;
                }
                textView2.setMaxWidth(i17);
            }
        }
        super.onMeasure(i3, i16);
    }

    public CommentEllipsizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
