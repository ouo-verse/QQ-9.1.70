package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.zf.c;

/* loaded from: classes9.dex */
public class AppBrandOptionsPickerV2 extends a implements c {
    public String[] R0;
    public int S0;

    @Keep
    public AppBrandOptionsPickerV2(Context context) {
        super(context);
        setDividerHeight(com.tencent.luggage.wxa.kn.a.a(context, 2));
        setDividerColor(Color.parseColor("#1AAD19"));
        setItemPaddingVertical(com.tencent.luggage.wxa.kn.a.a(context, 8));
        setNormalTextColor(Color.parseColor("#A5A5A5"));
        setSelectedTextColor(-16777216);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
        h();
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.picker.a, android.view.View
    public final void onMeasure(int i3, int i16) {
        int i17 = this.S0;
        if (i17 > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final String currentValue() {
        String[] strArr = this.R0;
        if (strArr != null && strArr.length > 0) {
            return strArr[getValue()];
        }
        return "";
    }

    public final void setForceWidth(int i3) {
        this.S0 = i3;
    }

    public final void setOptionsArray(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            setEnabled(true);
            setVisibility(0);
            this.R0 = strArr;
            a(strArr);
            return;
        }
        setEnabled(false);
        setVisibility(4);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public final View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
    }
}
