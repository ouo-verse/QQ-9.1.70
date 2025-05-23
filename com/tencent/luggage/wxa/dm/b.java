package com.tencent.luggage.wxa.dm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends RelativeLayout {
    public b(Context context) {
        super(context);
        a();
    }

    public final void a() {
        int a16;
        int a17;
        int a18;
        Context context = getContext();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setId(R.id.sst);
        boolean h16 = com.tencent.luggage.wxa.kn.a.h(getContext());
        w.a("MicroMsg.AppBrandPageTabBar", "init, useLargerText: " + h16);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(R.id.ssv);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        linearLayout.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.ssu);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (h16) {
            a16 = com.tencent.luggage.wxa.kn.a.a(getContext(), 34);
        } else {
            a16 = com.tencent.luggage.wxa.kn.a.a(getContext(), 28);
        }
        imageView.setLayoutParams(new ViewGroup.LayoutParams(a16, a16));
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(R.id.ssy);
        textView.setTextSize(0, com.tencent.luggage.wxa.kn.a.c(context, R.dimen.bpe) * com.tencent.luggage.wxa.kn.a.d(getContext()));
        textView.setPadding(com.tencent.luggage.wxa.kn.a.c(context, R.dimen.bgc), 0, com.tencent.luggage.wxa.kn.a.c(context, R.dimen.bgc), 0);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.addView(textView);
        addView(linearLayout);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.sss);
        textView2.setTextSize(0, com.tencent.luggage.wxa.kn.a.c(context, R.dimen.bpc) * com.tencent.luggage.wxa.kn.a.d(getContext()));
        textView2.setBackground(com.tencent.luggage.wxa.kn.a.e(context, R.drawable.j_z));
        textView2.setTextAppearance(context, R.style.f173787aj1);
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(6, R.id.ssv);
        layoutParams3.addRule(17, R.id.ssv);
        if (h16) {
            a17 = com.tencent.luggage.wxa.kn.a.a(getContext(), -12);
        } else {
            a17 = com.tencent.luggage.wxa.kn.a.a(getContext(), -8);
        }
        layoutParams3.setMarginStart(a17);
        textView2.setLayoutParams(layoutParams3);
        addView(textView2);
        View imageView2 = new ImageView(context);
        imageView2.setId(R.id.ssx);
        imageView2.setBackground(com.tencent.luggage.wxa.kn.a.e(context, R.drawable.m0h));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.tencent.luggage.wxa.kn.a.c(context, R.dimen.bh9), com.tencent.luggage.wxa.kn.a.c(context, R.dimen.bh9));
        layoutParams4.addRule(6, R.id.ssv);
        layoutParams4.addRule(19, R.id.ssv);
        if (h16) {
            a18 = com.tencent.luggage.wxa.kn.a.a(getContext(), -1);
        } else {
            a18 = com.tencent.luggage.wxa.kn.a.a(getContext(), -3);
        }
        layoutParams4.setMarginEnd(a18);
        layoutParams4.topMargin = com.tencent.luggage.wxa.kn.a.a(context, 1);
        imageView2.setLayoutParams(layoutParams4);
        addView(imageView2);
        View view = new View(context);
        view.setId(R.id.ssw);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, com.tencent.luggage.wxa.kn.a.c(context, R.dimen.bgc));
        layoutParams5.addRule(18, R.id.ssv);
        layoutParams5.addRule(19, R.id.ssv);
        layoutParams5.addRule(12, -1);
        view.setLayoutParams(layoutParams5);
        addView(view);
    }
}
