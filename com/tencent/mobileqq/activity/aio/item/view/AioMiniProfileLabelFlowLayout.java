package com.tencent.mobileqq.activity.aio.item.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.widget.FlowLayout;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes33.dex */
public class AioMiniProfileLabelFlowLayout extends FlowLayout {
    public AioMiniProfileLabelFlowLayout(Context context) {
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

    @Override // com.tencent.mobileqq.troop.widget.FlowLayout, com.tencent.biz.qqstorysave.widget.tag.TagFlowLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int width = getWidth();
        int childCount = getChildCount();
        int i19 = 1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        for (int i29 = 0; i29 < childCount; i29++) {
            View childAt = getChildAt(i29);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int dip2px = i19 == 1 ? width - ViewUtils.dip2px(90.0f) : width;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i36 = marginLayoutParams.leftMargin;
                if (i26 + i36 + measuredWidth + marginLayoutParams.rightMargin > dip2px) {
                    i27 += i28;
                    i19++;
                    i26 = 0;
                }
                int i37 = marginLayoutParams.topMargin;
                i28 = i37 + measuredHeight + marginLayoutParams.bottomMargin;
                int i38 = i36 + i26;
                int i39 = i37 + i27;
                childAt.layout(i38, i39, i38 + measuredWidth, measuredHeight + i39);
                i26 += marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstorysave.widget.tag.TagFlowLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 1;
        while (true) {
            if (i26 >= childCount) {
                i17 = size;
                i18 = size2;
                break;
            }
            View childAt = getChildAt(i26);
            if (childAt.getVisibility() == 8) {
                i17 = size;
                i18 = size2;
            } else {
                measureChild(childAt, i3, i16);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i38 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i18 = size2;
                int i39 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                if (i37 == 1) {
                    i19 = size - ViewUtils.dip2px(90.0f);
                    i17 = size;
                } else {
                    i19 = size;
                    i17 = i19;
                }
                int i46 = i27 + i38;
                if (i46 > i19) {
                    i37++;
                    if (i37 > 2) {
                        i36 = Math.max(i27, i38);
                        i29 += i28;
                        break;
                    } else {
                        i36 = Math.max(i27, i38);
                        i29 += i39;
                    }
                } else {
                    i39 = Math.max(i28, i39);
                    i38 = i46;
                }
                if (i26 == childCount - 1) {
                    i29 += i39;
                    i36 = Math.max(i38, i36);
                }
                i28 = i39;
                i27 = i38;
            }
            i26++;
            size2 = i18;
            size = i17;
        }
        if (mode == 1073741824) {
            i36 = i17;
        }
        setMeasuredDimension(i36, mode2 == 1073741824 ? i18 : i29);
    }

    public AioMiniProfileLabelFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AioMiniProfileLabelFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
