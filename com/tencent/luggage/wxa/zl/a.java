package com.tencent.luggage.wxa.zl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends c {
    public static final int G = 2131363139;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zl.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class ViewOnClickListenerC6990a implements View.OnClickListener {
        public ViewOnClickListenerC6990a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.d();
        }
    }

    public a(Context context) {
        super(context);
        super.setId(G);
        setBackgroundResource(R.color.ajr);
        setOnClickListener(new ViewOnClickListenerC6990a());
    }

    public static a c(View view) {
        return (a) view.getRootView().findViewById(G);
    }

    @Override // com.tencent.luggage.wxa.zl.c
    public void d() {
        super.d();
    }

    @Override // com.tencent.luggage.wxa.zl.c
    public void j() {
        super.j();
    }

    @Override // com.tencent.luggage.wxa.zl.c, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        if (!isShown()) {
            super.onMeasure(i3, i16);
            return;
        }
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            i17 = ((ViewGroup) getParent()).getMeasuredHeight();
        } else {
            i17 = 0;
        }
        if (i17 > 0) {
            a(i3, View.MeasureSpec.makeMeasureSpec(i17, 1073741824));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @Override // com.tencent.luggage.wxa.zl.c
    public void setHeader(String str) {
        super.setHeader(str);
    }

    @Override // android.view.View
    public void setId(int i3) {
    }
}
