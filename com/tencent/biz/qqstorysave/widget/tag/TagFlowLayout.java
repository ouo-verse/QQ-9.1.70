package com.tencent.biz.qqstorysave.widget.tag;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.widget.TraceUtils;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TagFlowLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected BaseAdapter f94555d;

    /* renamed from: e, reason: collision with root package name */
    private DataSetObserver f94556e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
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

    protected void a() {
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < this.f94555d.getCount() && i3 < childCount) {
            int itemViewType = this.f94555d.getItemViewType(i3);
            View childAt = getChildAt(i3);
            if (itemViewType == ((Integer) childAt.getTag(R.id.gzq)).intValue() && itemViewType == 0) {
                this.f94555d.getView(i3, childAt, this);
            } else {
                addView(this.f94555d.getView(i3, null, this), i3, new ViewGroup.MarginLayoutParams(-2, -2));
                removeView(childAt);
            }
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.a("attach", "attach");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c.a("detach", "detach");
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
        BaseAdapter baseAdapter2 = this.f94555d;
        if (baseAdapter2 != null && (dataSetObserver = this.f94556e) != null) {
            baseAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        removeAllViews();
        this.f94555d = baseAdapter;
        if (baseAdapter != null) {
            a aVar = new a();
            this.f94556e = aVar;
            this.f94555d.registerDataSetObserver(aVar);
            this.f94555d.notifyDataSetChanged();
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
