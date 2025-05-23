package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.widget.FlowLayout;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendLabelFlowLayout extends FlowLayout {
    public ExtendFriendLabelFlowLayout(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.qqstorysave.widget.tag.TagFlowLayout
    protected void a() {
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < this.f94555d.getCount() && i3 < childCount) {
            this.f94555d.getView(i3, getChildAt(i3), this);
            i3++;
        }
        if (childCount > this.f94555d.getCount()) {
            removeViews(i3, childCount - this.f94555d.getCount());
        }
        if (childCount < this.f94555d.getCount()) {
            while (i3 < this.f94555d.getCount()) {
                addView(this.f94555d.getView(i3, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
                i3++;
            }
        }
    }

    public ExtendFriendLabelFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExtendFriendLabelFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstorysave.widget.tag.TagFlowLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 1;
        int i29 = 0;
        while (true) {
            if (i18 >= childCount) {
                i17 = size2;
                break;
            }
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() == 8) {
                i17 = size2;
            } else {
                measureChild(childAt, i3, i16);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i17 = size2;
                int i36 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int i37 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i38 = i29 + i36;
                if (i38 > size) {
                    i28++;
                    if (i28 > 2) {
                        i27 = Math.max(i29, i36);
                        i26 += i19;
                        break;
                    } else {
                        i27 = Math.max(i29, i36);
                        i26 += i37;
                    }
                } else {
                    i37 = Math.max(i19, i37);
                    i36 = i38;
                }
                if (i18 == childCount - 1) {
                    i26 += i37;
                    i19 = i37;
                    i27 = Math.max(i36, i27);
                } else {
                    i19 = i37;
                }
                i29 = i36;
            }
            i18++;
            size2 = i17;
        }
        if (mode != 1073741824) {
            size = i27;
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i17 : i26);
    }
}
