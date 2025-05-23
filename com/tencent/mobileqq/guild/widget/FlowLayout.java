package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.TraceUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class FlowLayout extends TagFlowLayout {

    /* renamed from: f, reason: collision with root package name */
    protected int f235806f;

    /* renamed from: h, reason: collision with root package name */
    protected int f235807h;

    public FlowLayout(Context context) {
        super(context);
        this.f235806f = 10;
        this.f235807h = 7;
    }

    @Override // com.tencent.mobileqq.guild.widget.TagFlowLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        TraceUtils.traceBegin("FlowLayout.onLayout");
        int width = getWidth();
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = getChildAt(i28);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (i19 == 0) {
                    int i29 = i19 + marginLayoutParams.leftMargin;
                    int i36 = marginLayoutParams.topMargin + i26;
                    childAt.layout(i29, i36, i29 + measuredWidth, i36 + measuredHeight);
                    i19 = ViewUtils.dpToPx(this.f235806f) + marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
                    i27 = marginLayoutParams.bottomMargin + measuredHeight + marginLayoutParams.topMargin;
                } else {
                    if (marginLayoutParams.leftMargin + i19 + measuredWidth + marginLayoutParams.rightMargin > width) {
                        i26 += i27 + ViewUtils.dpToPx(this.f235807h);
                        i27 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                        i19 = 0;
                    } else {
                        i27 = Math.max(i27, marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin);
                    }
                    int i37 = marginLayoutParams.leftMargin + i19;
                    int i38 = marginLayoutParams.topMargin + i26;
                    childAt.layout(i37, i38, i37 + measuredWidth, measuredHeight + i38);
                    i19 += ViewUtils.dpToPx(this.f235806f) + marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
                }
            }
        }
        TraceUtils.traceEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.TagFlowLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        TraceUtils.traceBegin("TagFlowLayout.onMeasure");
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i16);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                if (i17 != 0) {
                    if (ViewUtils.dpToPx(this.f235806f) + i17 + measuredWidth > size) {
                        int max = Math.max(i17, i18);
                        i19 += i26 + ViewUtils.dpToPx(this.f235807h);
                        i18 = max;
                    } else {
                        i17 += measuredWidth + ViewUtils.dpToPx(this.f235806f);
                        i26 = Math.max(i26, measuredHeight);
                    }
                }
                i26 = measuredHeight;
                i17 = measuredWidth;
            }
        }
        setMeasuredDimension(Math.max(i17, i18), i19 + i26);
        TraceUtils.traceEnd();
    }

    public void setHorizontalSpacing(int i3) {
        this.f235806f = i3;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f235806f = 10;
        this.f235807h = 7;
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f235806f = 10;
        this.f235807h = 7;
    }
}
