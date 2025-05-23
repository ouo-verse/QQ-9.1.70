package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.zf.c;
import com.tencent.luggage.wxa.zl.e;
import com.tencent.mm.ui.widget.picker.NumberPickerUtil;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class AppBrandOptionsPicker extends NumberPicker implements c {

    /* renamed from: a, reason: collision with root package name */
    public String[] f152440a;

    /* renamed from: b, reason: collision with root package name */
    public int f152441b;

    /* renamed from: c, reason: collision with root package name */
    public int f152442c;

    /* renamed from: d, reason: collision with root package name */
    public int f152443d;

    @Keep
    public AppBrandOptionsPicker(Context context) {
        super(new ContextThemeWrapper(context, R.style.ajv));
        NumberPickerUtil.reflectSetDividerDrawable(this, getResources().getDrawable(R.drawable.ja_));
        NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this);
        NumberPickerUtil.removePendingSetSelectionCommand(this);
        e.a(this);
        this.f152441b = com.tencent.luggage.wxa.kn.a.a(context, 100);
        this.f152443d = com.tencent.luggage.wxa.kn.a.a(context, 20);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String currentValue() {
        String[] strArr = this.f152440a;
        if (strArr != null && strArr.length > 0) {
            return strArr[getValue()];
        }
        return "";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NumberPickerUtil.fixDefaultValueDisplaying(this);
    }

    @Override // android.widget.NumberPicker, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE || View.MeasureSpec.getMode(i3) == 1073741824) {
            this.f152442c = View.MeasureSpec.getSize(i3);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), i16);
        int measuredWidth = getMeasuredWidth();
        int i18 = this.f152441b;
        if (measuredWidth <= i18 && ((i17 = this.f152442c) <= 0 || i18 <= i17)) {
            setMeasuredDimension(i18, getMeasuredHeight());
            return;
        }
        int measuredWidth2 = getMeasuredWidth() + (this.f152443d * 2);
        int i19 = this.f152442c;
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
        this.f152443d = Math.max(i3, 0);
    }

    public final void setMaxWidth(int i3) {
        this.f152442c = i3;
    }

    public final void setMinWidth(int i3) {
        this.f152441b = i3;
    }

    public void setOptionsArray(String[] strArr) {
        if (strArr == null) {
            return;
        }
        this.f152440a = strArr;
        setDisplayedValues(null);
        setMinValue(0);
        setMaxValue(Math.max(strArr.length - 1, 0));
        if (strArr.length <= 0) {
            strArr = null;
        }
        super.setDisplayedValues(strArr);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
    }
}
