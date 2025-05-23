package com.tencent.mm.ui.widget.picker;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class OptionPicker extends NumberPicker {

    /* renamed from: a, reason: collision with root package name */
    public String[] f153623a;

    /* renamed from: b, reason: collision with root package name */
    public int f153624b;

    /* renamed from: c, reason: collision with root package name */
    public int f153625c;

    /* renamed from: d, reason: collision with root package name */
    public int f153626d;

    /* renamed from: e, reason: collision with root package name */
    public Context f153627e;

    public OptionPicker(Context context) {
        super(context);
        this.f153627e = context;
        a();
    }

    public final void a() {
        this.f153624b = o.a(this.f153627e, 120);
        this.f153626d = o.a(this.f153627e, 20);
        NumberPickerUtil.reflectSetDividerDrawable(this, getResources().getDrawable(R.drawable.k6l));
        setDescendantFocusability(393216);
        NumberPickerUtil.setNumberPickerTextColor(this, this.f153627e.getResources().getColor(R.color.c7u));
    }

    public final int currentIndex() {
        return getValue();
    }

    public final String currentValue() {
        String[] strArr = this.f153623a;
        if (strArr != null && strArr.length > 0) {
            return strArr[getValue()];
        }
        return "";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.NumberPicker, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE || View.MeasureSpec.getMode(i3) == 1073741824) {
            this.f153625c = View.MeasureSpec.getSize(i3);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), i16);
        int measuredWidth = getMeasuredWidth();
        int i18 = this.f153624b;
        if (measuredWidth <= i18 && ((i17 = this.f153625c) <= 0 || i18 <= i17)) {
            setMeasuredDimension(i18, getMeasuredHeight());
            return;
        }
        int measuredWidth2 = getMeasuredWidth() + (this.f153626d * 2);
        int i19 = this.f153625c;
        if (i19 > 0 && i19 <= measuredWidth2) {
            measuredWidth2 = i19;
        }
        setMeasuredDimension(measuredWidth2, getMeasuredHeight());
    }

    @Override // android.widget.NumberPicker
    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        super.setDisplayedValues(strArr);
    }

    public final void setExtraPadding(int i3) {
        this.f153626d = Math.max(i3, 0);
    }

    public final void setMaxWidth(int i3) {
        this.f153625c = i3;
    }

    public final void setMinWidth(int i3) {
        this.f153624b = i3;
    }

    public void setOptionsArray(String[] strArr) {
        if (strArr == null) {
            return;
        }
        this.f153623a = strArr;
        setDisplayedValues(null);
        setMinValue(0);
        setMaxValue(Math.max(strArr.length - 1, 0));
        setWrapSelectorWheel(false);
        if (strArr.length <= 0) {
            strArr = null;
        }
        super.setDisplayedValues(strArr);
    }

    public OptionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153627e = context;
        a();
    }

    public OptionPicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153627e = context;
        a();
    }

    @TargetApi(21)
    public OptionPicker(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f153627e = context;
        a();
    }
}
