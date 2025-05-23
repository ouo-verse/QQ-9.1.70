package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class TagFlowLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected BaseAdapter f236159d;

    /* renamed from: e, reason: collision with root package name */
    private DataSetObserver f236160e;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            TagFlowLayout.this.a();
        }
    }

    public TagFlowLayout(Context context) {
        super(context);
    }

    public void a() {
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < this.f236159d.getCount() && i3 < childCount) {
            this.f236159d.getView(i3, getChildAt(i3), this);
            i3++;
        }
        if (childCount > this.f236159d.getCount()) {
            removeViews(i3, childCount - this.f236159d.getCount());
        }
        if (childCount < this.f236159d.getCount()) {
            while (i3 < this.f236159d.getCount()) {
                addView(this.f236159d.getView(i3, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
                i3++;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("TagFlowLayout", 2, "attach");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("TagFlowLayout", 2, "detach");
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        TraceUtils.traceBegin("TagFlowLayout.onLayout");
        int width = getWidth();
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i28 = marginLayoutParams.leftMargin;
                if (i19 + i28 + measuredWidth + marginLayoutParams.rightMargin > width) {
                    i26 += marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    i19 = 0;
                }
                int i29 = i28 + i19;
                int i36 = marginLayoutParams.topMargin + i26;
                childAt.layout(i29, i36, i29 + measuredWidth, measuredHeight + i36);
                i19 += marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin;
            }
        }
        TraceUtils.traceEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        TraceUtils.traceBegin("TagFlowLayout.onMeasure");
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() == 8) {
                i18 = size2;
            } else {
                measureChild(childAt, i3, i16);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i18 = size2;
                int i36 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int i37 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i38 = i27 + i36;
                if (i38 > size) {
                    i26 = Math.max(i27, i36);
                    i29 += i37;
                } else {
                    i37 = Math.max(i28, i37);
                    i36 = i38;
                }
                if (i19 == childCount - 1) {
                    i29 += i37;
                    i26 = Math.max(i36, i26);
                }
                i27 = i36;
                i28 = i37;
            }
            i19++;
            size2 = i18;
        }
        int i39 = size2;
        if (mode != 1073741824) {
            size = i26;
        }
        if (mode2 == 1073741824) {
            i17 = i39;
        } else {
            i17 = i29;
        }
        setMeasuredDimension(size, i17);
        TraceUtils.traceEnd();
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        DataSetObserver dataSetObserver;
        BaseAdapter baseAdapter2 = this.f236159d;
        if (baseAdapter2 != null && (dataSetObserver = this.f236160e) != null) {
            baseAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        removeAllViews();
        this.f236159d = baseAdapter;
        if (baseAdapter != null) {
            a aVar = new a();
            this.f236160e = aVar;
            this.f236159d.registerDataSetObserver(aVar);
            this.f236159d.notifyDataSetChanged();
        }
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return (RelativeLayout.LayoutParams) new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
