package com.tencent.mobileqq.utils.kapalaiadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public class KapalaiRadioGroupBase extends RadioGroup {
    public KapalaiRadioGroupBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        a();
    }

    public KapalaiRadioGroupBase(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }
}
