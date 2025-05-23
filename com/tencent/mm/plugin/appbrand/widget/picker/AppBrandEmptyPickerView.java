package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.zf.c;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class AppBrandEmptyPickerView extends View implements c {
    @Keep
    public AppBrandEmptyPickerView(Context context) {
        super(context);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public Object currentValue() {
        return null;
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(R.dimen.f159277cy0), 1073741824));
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
