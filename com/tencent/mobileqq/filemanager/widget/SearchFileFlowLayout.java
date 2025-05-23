package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SearchFileFlowLayout extends ViewGroup {
    private List<View> C;

    /* renamed from: d, reason: collision with root package name */
    private int f209481d;

    /* renamed from: e, reason: collision with root package name */
    private int f209482e;

    /* renamed from: f, reason: collision with root package name */
    private List<List<View>> f209483f;

    /* renamed from: h, reason: collision with root package name */
    private List<Integer> f209484h;

    /* renamed from: i, reason: collision with root package name */
    private List<Integer> f209485i;

    /* renamed from: m, reason: collision with root package name */
    private List<Integer> f209486m;

    public SearchFileFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f209483f = new ArrayList();
        this.f209484h = new ArrayList();
        this.f209485i = new ArrayList();
        this.f209486m = new ArrayList();
        this.C = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SearchFileFlowLayout);
        this.f209481d = obtainStyledAttributes.getInt(R.styleable.SearchFileFlowLayout_AlignMode, 0);
        int integer = obtainStyledAttributes.getInteger(R.styleable.SearchFileFlowLayout_max_num_one_line, -1);
        this.f209482e = integer;
        if (integer <= 0) {
            this.f209482e = -1;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x017d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int intValue;
        int i19;
        int i26;
        this.f209483f.clear();
        this.f209484h.clear();
        this.f209485i.clear();
        this.C.clear();
        this.f209486m.clear();
        int width = getWidth();
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        for (int i36 = 0; i36 < childCount; i36++) {
            View childAt = getChildAt(i36);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredWidth + i28 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight() || (i29 > (i26 = this.f209482e) && i26 != -1)) {
                this.f209484h.add(Integer.valueOf(i27));
                this.f209485i.add(Integer.valueOf(i28));
                this.f209483f.add(this.C);
                i27 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                this.C = new ArrayList();
                i28 = 0;
                i29 = 0;
            }
            i29++;
            i28 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i27 = Math.max(i27, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            this.C.add(childAt);
        }
        this.f209484h.add(Integer.valueOf(i27));
        this.f209485i.add(Integer.valueOf(i28));
        this.f209483f.add(this.C);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f209483f.size();
        QLog.d("FlowLayout", 2, "\u4e00\u5171\u6709 " + size + " \u884c");
        int i37 = 0;
        for (int i38 = 0; i38 < size; i38++) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) getChildAt(i37).getLayoutParams();
            View childAt2 = getChildAt((this.f209483f.get(i38).size() + i37) - 1);
            i37 += this.f209483f.get(i38).size();
            this.f209486m.add(Integer.valueOf((((getMeasuredWidth() - this.f209485i.get(i38).intValue()) + marginLayoutParams2.leftMargin) + ((ViewGroup.MarginLayoutParams) childAt2.getLayoutParams()).rightMargin) / 2));
        }
        for (int i39 = 0; i39 < size; i39++) {
            this.C = this.f209483f.get(i39);
            int intValue2 = this.f209484h.get(i39).intValue();
            int i46 = this.f209481d;
            if (i46 == 2) {
                intValue = this.f209486m.get(i39).intValue() * 2;
            } else {
                if (i46 == 1) {
                    intValue = this.f209486m.get(i39).intValue();
                }
                for (i19 = 0; i19 < this.C.size(); i19++) {
                    View view = this.C.get(i19);
                    if (view.getVisibility() != 8) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i47 = marginLayoutParams3.leftMargin + paddingLeft;
                        int i48 = marginLayoutParams3.topMargin + paddingTop;
                        view.layout(i47, i48, view.getMeasuredWidth() + i47, view.getMeasuredHeight() + i48);
                        paddingLeft += view.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin;
                    }
                }
                paddingLeft = getPaddingLeft();
                paddingTop += intValue2;
            }
            paddingLeft += intValue;
            while (i19 < this.C.size()) {
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e A[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int paddingRight;
        int paddingTop;
        int i17;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i16);
        int childCount = getChildCount();
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (i18 < childCount) {
            View childAt = getChildAt(i18);
            measureChild(childAt, i3, i16);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i36 = size2;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i37 = i19 + measuredWidth;
            if (i37 <= (size - getPaddingLeft()) - getPaddingRight()) {
                int i38 = this.f209482e;
                i17 = size;
                if (i27 < i38 || i38 == -1) {
                    i27++;
                    i29 = Math.max(i29, measuredHeight);
                    i19 = i37;
                    if (i18 != childCount - 1) {
                        i28 += i29;
                        i26 = Math.max(i19, i26);
                    }
                    i18++;
                    size2 = i36;
                    size = i17;
                }
            } else {
                i17 = size;
            }
            i26 = Math.max(i26, i19);
            i28 += i29;
            i29 = measuredHeight;
            i19 = measuredWidth;
            if (i18 != childCount - 1) {
            }
            i18++;
            size2 = i36;
            size = i17;
        }
        int i39 = size;
        int i46 = size2;
        if (mode == 1073741824) {
            paddingRight = i39;
        } else {
            paddingRight = getPaddingRight() + i26 + getPaddingLeft();
        }
        if (mode2 == 1073741824) {
            paddingTop = i46;
        } else {
            paddingTop = i28 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public void setAlignMode(int i3) {
        if (i3 < 0 || i3 > 2) {
            this.f209481d = 0;
        }
        this.f209481d = i3;
        invalidate();
    }

    public void setMaxNumInLine(int i3) {
        this.f209482e = i3;
        invalidate();
    }

    public void setMaxNumInLineAndAlignMode(int i3, int i16) {
        if (i3 < 0 || i3 > 2) {
            this.f209481d = 0;
        }
        this.f209481d = i3;
        this.f209482e = i16;
    }

    public SearchFileFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchFileFlowLayout(Context context) {
        this(context, null);
    }
}
