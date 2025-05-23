package com.tencent.luggage.wxa.ok;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static void a(View view, AppBrandCircleProgressView appBrandCircleProgressView, TextView textView) {
        ViewGroup.LayoutParams layoutParams = appBrandCircleProgressView.getLayoutParams();
        layoutParams.width = com.tencent.luggage.wxa.kn.a.d(z.c(), R.dimen.f158084bj0);
        layoutParams.height = com.tencent.luggage.wxa.kn.a.d(z.c(), R.dimen.f158084bj0);
        appBrandCircleProgressView.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        layoutParams2.width = com.tencent.luggage.wxa.kn.a.d(z.c(), R.dimen.bir);
        layoutParams2.height = com.tencent.luggage.wxa.kn.a.d(z.c(), R.dimen.bir);
        view.requestLayout();
        textView.setTextSize(0, com.tencent.luggage.wxa.kn.a.d(z.c(), R.dimen.bck));
    }
}
