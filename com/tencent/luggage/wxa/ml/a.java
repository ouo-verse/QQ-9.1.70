package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends FrameLayout {
    public a(Context context, View view) {
        super(context);
        addView(view);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        if ((getParent() instanceof View) && ((View) getParent()).getMeasuredHeight() > 0) {
            Context context = getContext();
            if (com.tencent.luggage.wxa.tn.s.h(getContext())) {
                i17 = 173;
            } else {
                i17 = 24;
            }
            i16 = View.MeasureSpec.makeMeasureSpec(((View) getParent()).getMeasuredHeight() - com.tencent.luggage.wxa.kn.a.a(context, i17), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
    }
}
